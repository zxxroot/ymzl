/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.cashloan.cl.domain.UserAuth;
/*     */ import com.cashloan.cl.domain.UserCardCreditLog;
/*     */ import com.cashloan.cl.model.UploadFileRes;
/*     */ import com.cashloan.cl.monitor.BusinessExceptionMonitor;
/*     */ import com.cashloan.cl.service.UdcreditService;
/*     */ import com.cashloan.cl.service.UserAuthService;
/*     */ import com.cashloan.cl.service.UserCardCreditLogService;
/*     */ import com.cashloan.cl.utils.EhcacheUtil;
/*     */ import com.cashloan.cl.utils.OcrUdcreditUtils;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class UdcreditServiceImpl
/*     */   implements UdcreditService
/*     */ {
/*  60 */   private static final Logger logger = LoggerFactory.getLogger(UdcreditServiceImpl.class);
/*     */   
/*     */ 
/*     */ 
/*     */   @Autowired
/*     */   private UserBaseInfoService userBaseInfoService;
/*     */   
/*     */ 
/*     */ 
/*     */   @Autowired
/*     */   private UserCardCreditLogService userCardCreditLogService;
/*     */   
/*     */ 
/*     */ 
/*     */   @Autowired
/*     */   private UserAuthService userAuthService;
/*     */   
/*     */ 
/*     */   @Autowired
/*     */   private CloanUserService cloanUserService;
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<String, Object> udcredit(MultipartFile livingImg, MultipartFile frontImg, MultipartFile backImg, MultipartFile ocrImg, String realName, String idNo, String userId)
/*     */     throws Exception
/*     */   {
/*  86 */     String apikey = Global.getValue("ocr_udcredit_pubkey");
/*  87 */     String secretkey = Global.getValue("ocr_udcredit_secretkey");
/*  88 */     Long uId = Long.valueOf(Long.parseLong(userId));
/*  89 */     Map<String, Object> ubiMap = new HashMap();
/*  90 */     ubiMap.put("userId", userId);
/*  91 */     UserBaseInfo ubi = this.userBaseInfoService.findSelective(ubiMap);
/*  92 */     User user = (User)this.cloanUserService.getById(uId);
/*  93 */     UserAuth ua = this.userAuthService.findSelective(uId.longValue());
/*  94 */     Map<String, Object> resultMap = new HashMap();
/*  95 */     if ((ubi != null) && (ua.getIdState().equals("10"))) {
/*  96 */       ubiMap.clear();
/*  97 */       ubiMap.put("userId", userId);
/*  98 */       ubi = this.userBaseInfoService.findSelective(ubiMap);
/*  99 */       if ((user == null) || (ubi == null)) {
/* 100 */         resultMap.put("code", Integer.valueOf(400));
/* 101 */         resultMap.put("msg", "用户信息不存在!");
/* 102 */       } else if (!this.userCardCreditLogService.isCanCredit(uId)) {
/* 103 */         resultMap.put("code", Integer.valueOf(400));
/* 104 */         resultMap.put("msg", "今日请求认证次数已超过限制,请明日再尝试");
/*     */       } else {
/* 106 */         List<UploadFileRes> list = new LinkedList();
/* 107 */         OcrUdcreditUtils.saveMultipartFile(list, livingImg, ubi.getPhone());
/* 108 */         OcrUdcreditUtils.saveMultipartFile(list, frontImg, ubi.getPhone());
/* 109 */         OcrUdcreditUtils.saveMultipartFile(list, backImg, ubi.getPhone());
/*     */         
/* 111 */         String livingPath = Global.getValue("server_host") + "/readFile.htm?path=" + ((UploadFileRes)list.get(0)).getResPath();
/* 112 */         File livingImgfile = OcrUdcreditUtils.getRemoteFile(livingPath);
/*     */         
/* 114 */         Map<String, String> map = new HashMap();
/* 115 */         map.put("id_no", idNo);
/* 116 */         String result = OcrUdcreditUtils.apiCall(map, null);
/*     */         
/*     */ 
/* 119 */         if (livingImgfile.exists()) {
/* 120 */           livingImgfile.delete();
/*     */         }
/* 122 */         String res = (String)EhcacheUtil.getItem(idNo);
/* 123 */         JSONObject resultJson = JSONObject.parseObject(res);
/* 124 */         boolean env = "dev".equals(Global.getValue("app_environment"));
/* 125 */         if ((!env) && (resultJson == null)) {
/* 126 */           Map<String, Object> returnMap = new HashMap();
/* 127 */           returnMap.put("idState", "10");
/* 128 */           returnMap.put("userId", userId);
/* 129 */           returnMap.put("realNameState", "10");
/* 130 */           this.userAuthService.updateByUserId(returnMap);
/* 131 */           resultMap.put("code", Integer.valueOf(400));
/* 132 */           resultMap.put("msg", "认证失败，实名认证信息不一致!");
/* 133 */           return resultMap;
/*     */         }
/* 135 */         String code = env ? "1" : resultJson.getString("verify_status");
/* 136 */         boolean legal = thanVerify(realName, idNo, userId, ubi, resultMap, code);
/* 137 */         if (!legal) {
/* 138 */           Map<String, Object> resMap = new HashMap();
/* 139 */           resMap.put("idState", "10");
/* 140 */           resMap.put("userId", userId);
/* 141 */           resMap.put("realNameState", "10");
/* 142 */           this.userAuthService.updateByUserId(resMap);
/* 143 */           return resultMap;
/*     */         }
/*     */         
/* 146 */         Map<String, Object> reqMap = new HashMap();
/* 147 */         reqMap.put("idNo", idNo);
/* 148 */         reqMap.put("realName", realName);
/* 149 */         reqMap.put("apikey", apikey);
/* 150 */         reqMap.put("secretkey", secretkey);
/* 151 */         reqMap.put("livingImgfile", livingImgfile);
/*     */         
/* 153 */         UserCardCreditLog log = new UserCardCreditLog();
/* 154 */         log.setCreateTime(DateUtil.getNow());
/* 155 */         log.setUserId(ubi.getUserId());
/* 156 */         log.setReqParams(JSONObject.toJSONString(reqMap));
/* 157 */         log.setReturnParams(result);
/* 158 */         log.setResult(String.valueOf(code));
/*     */         
/* 160 */         if ((env) || (StringUtil.isNotBlank(resultJson))) {
/* 161 */           String similarity = 
/* 162 */             StringUtils.isBlank(resultJson.getString("similarity")) ? "0" : env ? "1" : 
/* 163 */             resultJson.getString("similarity");
/* 164 */           if (Double.parseDouble(similarity) >= Global.getDouble("idCard_credit_pass_rate")) {
/* 165 */             Map<String, Object> returnMap = new HashMap();
/* 166 */             returnMap.put("idState", "30");
/* 167 */             returnMap.put("userId", userId);
/* 168 */             this.userAuthService.updateByUserId(returnMap);
/*     */             
/* 170 */             log.setConfidence(String.valueOf(Double.parseDouble(similarity) / 100.0D));
/*     */             
/* 172 */             livingPath = ((UploadFileRes)list.get(0)).getResPath();
/* 173 */             String frontPath = ((UploadFileRes)list.get(1)).getResPath();
/* 174 */             String backPath = ((UploadFileRes)list.get(2)).getResPath();
/* 175 */             ubi.setLivingImg(livingPath);
/* 176 */             ubi.setFrontImg(frontPath);
/* 177 */             ubi.setBackImg(backPath);
/* 178 */             ubi.setRealName(realName);
/* 179 */             ubi.setIdNo(idNo);
/* 180 */             ubi.setAge(StringUtil.getAge(idNo));
/* 181 */             ubi.setSex(StringUtil.getSex(idNo));
/* 182 */             ubi.setIdAddr(!env ? resultJson.getString("address") : "");
/* 183 */             this.userBaseInfoService.updateById(ubi);
/* 184 */             resultMap.put("code", Integer.valueOf(200));
/* 185 */             resultMap.put("msg", "相似度达到指定标准,识别成功!");
/* 186 */             EhcacheUtil.removeItem(idNo);
/*     */             
/* 188 */             Map<String, Object> reMap = new HashMap();
/* 189 */             reMap.put("realNameState", "30");
/* 190 */             reMap.put("userId", userId);
/* 191 */             this.userAuthService.updateByUserId(reMap);
/*     */           } else {
/* 193 */             resultMap.put("code", Integer.valueOf(400));
/* 194 */             resultMap.put("msg", "人证相似度不足,请重新识别!");
/*     */           }
/*     */         } else {
/* 197 */           BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_6, userId, resultJson.getString("message"));
/* 198 */           resultMap.put("code", Integer.valueOf(400));
/* 199 */           resultMap.put("msg", "人证识别异常,请重新尝试!");
/*     */         }
/* 201 */         this.userCardCreditLogService.insert(log);
/* 202 */         logger.info("用户ID为" + userId + "的用户人证识别对比结果" + result);
/*     */       }
/*     */     } else {
/* 205 */       resultMap.put("code", Integer.valueOf(400));
/* 206 */       resultMap.put("msg", "操作失败");
/*     */     }
/* 208 */     return resultMap;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean thanVerify(String realName, String idNo, String userId, UserBaseInfo ubi, Map<String, Object> resultMap, String code)
/*     */   {
/* 214 */     String realname = ubi.getRealName();
/* 215 */     String idno = ubi.getIdNo();
/* 216 */     if ((StringUtils.isBlank(realname)) || (StringUtils.isBlank(idno))) {
/* 217 */       resultMap.put("code", Integer.valueOf(400));
/* 218 */       resultMap.put("msg", "认证失败，请完善实名认证信息!");
/* 219 */       return Boolean.FALSE.booleanValue();
/*     */     }
/* 221 */     if ((!StringUtils.equals(realName, realname)) || (!StringUtils.equals(idNo, idno)) || (StringUtils.isBlank(code)) || (!StringUtils.equals(code, "1"))) {
/* 222 */       resultMap.put("code", Integer.valueOf(400));
/* 223 */       resultMap.put("msg", "认证失败，实名认证信息不一致!");
/* 224 */       return Boolean.FALSE.booleanValue();
/*     */     }
/* 226 */     return Boolean.TRUE.booleanValue();
/*     */   }
/*     */ }

/*impl\UdcreditServiceImpl.class

 */