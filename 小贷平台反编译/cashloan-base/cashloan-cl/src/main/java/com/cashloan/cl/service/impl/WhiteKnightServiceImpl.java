/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.domain.BaiqishiAntiLog;
import com.cashloan.cl.domain.WhiteKnight;
import com.cashloan.cl.mapper.*;
import com.cashloan.cl.service.WhiteKnightService;
import com.cashloan.cl.utils.AppHelper;
import com.cashloan.cl.utils.WhiteKnightInvoker;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import com.rongdu.cashloan.rc.service.TppBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class WhiteKnightServiceImpl
/*     */   extends BaseServiceImpl<WhiteKnight, Long>
/*     */   implements WhiteKnightService
/*     */ {
/*  67 */   private static final Logger logger = LoggerFactory.getLogger(WhiteKnightServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private DhbReqLogMapper dhbReqLogMapper;
/*     */   
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   
/*     */   @Resource
/*     */   private DhbBindingMapper dhbBindingMapper;
/*     */   
/*     */   @Resource
/*     */   private DhbHistoryOrgMapper dhbHistoryOrgMapper;
/*     */   
/*     */   @Resource
/*     */   private DhbHistorySearchMapper dhbHistorySearchMapper;
/*     */   
/*     */   @Resource
/*     */   private DhbRiskBlacklistMapper dhbRiskBlacklistMapper;
/*     */   
/*     */   @Resource
/*     */   private DhbUserBasicMapper dhbUserBasicMapper;
/*     */   
/*     */   @Resource
/*     */   private DhbRiskSocialNetworkMapper dhbRiskSocialNetworkMapper;
/*     */   
/*     */   @Resource
/*     */   private TppBusinessService tppBusinessService;
/*     */   @Resource
/*     */   private BaiqishiAntiLogMapper baiqishiAntiLogMapper;
/*     */   
/*     */   public int queryWhiteKnight(Borrow borrow, TppBusiness business)
/*     */   {
/* 100 */     logger.info("借款id:" + borrow.getId() + "开始进行白骑士反欺诈。。。");
/* 101 */     UserBaseInfo userBaseinfo = this.userBaseInfoMapper.findByUserId(borrow.getUserId());
/* 102 */     BaiqishiAntiLog log = new BaiqishiAntiLog();
/* 103 */     String orderNo = OrderNoUtil.getSerialNumber();
/* 104 */     log.setUserId(userBaseinfo.getUserId());
/* 105 */     log.setPhone(userBaseinfo.getPhone());
/* 106 */     log.setOrderNo(orderNo);
/* 107 */     log.setCreateTime(new Date());
/*     */     try
/*     */     {
/* 110 */       this.baiqishiAntiLogMapper.deleteByUserId(borrow.getUserId());
/*     */       
/* 112 */       String res = invoke("loan", userBaseinfo.getPhone());
/* 113 */       if ((res != null) && (!"".equals(res))) {
/* 114 */         Map<String, Object> resultMap = JSONObject.parseObject(res);
/* 115 */         String code = String.valueOf(resultMap.get("resultCode"));
/* 116 */         log.setRespCode(code);
/*     */         
/* 118 */         if ("BQS000".equals(code)) {
/* 119 */           if ("Accept".equals(String.valueOf(resultMap.get("finalDecision")))) {
/* 120 */             log.setFinalDecision(Integer.valueOf(0));
/* 121 */           } else if ("Reject".equals(String.valueOf(resultMap.get("finalDecision")))) {
/* 122 */             log.setFinalDecision(Integer.valueOf(1));
/*     */           } else {
/* 124 */             log.setFinalDecision(Integer.valueOf(2));
/*     */           }
/* 126 */           log.setScore(Integer.valueOf(String.valueOf(resultMap.get("finalScore") == null ? Integer.valueOf(0) : resultMap.get("finalScore"))));
/* 127 */           log.setRespParams(res);
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 131 */       logger.info("反欺诈返回的异常为：" + e.getMessage() + ",用户手机号为：" + userBaseinfo.getPhone());
/*     */     }
/* 133 */     return this.baiqishiAntiLogMapper.save(log);
/*     */   }
/*     */   
/*     */   public BaseMapper<WhiteKnight, Long> getMapper()
/*     */   {
/* 138 */     return null;
/*     */   }
/*     */   
/*     */   public String invoke(String type, String phone)
/*     */   {
/* 143 */     Map<String, Object> param = Maps.newHashMap();
/* 144 */     param.put("phone", phone);
/* 145 */     UserBaseInfo user = (UserBaseInfo)this.userBaseInfoMapper.findSelective(param);
/*     */     
/* 147 */     String res = null;
/* 148 */     TppBusiness business = this.tppBusinessService.findByNid("WhiteKnight", Long.valueOf(8L));
/* 149 */     if ((Optional.fromNullable(business).isPresent()) && (business.getState().equals("10"))) {
/* 150 */       String extend = business.getExtend();
/* 151 */       WhiteKnight bean = (WhiteKnight) AppHelper.json2Object(extend, WhiteKnight.class);
/*     */       
/* 153 */       bean.setApiUrl(business.getUrl());
/*     */       
/* 155 */       Map<String, Object> params = Maps.newHashMap();
/*     */       
/* 157 */       params.put("verifyKey", bean.getVerifyKey());
/* 158 */       params.put("partnerId", bean.getPartnerId());
/*     */       
/* 160 */       params.put("appId", bean.getAppId());
/*     */       
/* 162 */       if (user != null) {
/* 163 */         if ((user.getIdNo() != null) && (!"".equals(user.getIdNo()))) {
/* 164 */           params.put("certNo", user.getIdNo());
/*     */         }
/* 166 */         if ((user.getRealName() != null) && (!"".equals(user.getRealName()))) {
/* 167 */           params.put("name", user.getRealName());
/*     */         }
/*     */       }
/* 170 */       params.put("mobile", phone);
/* 171 */       params.put("eventType", type);
/*     */       try {
/* 173 */         res = WhiteKnightInvoker.getIntance().invoke(params, bean.getApiUrl());
/*     */         
/* 175 */         logger.info("调用白骑士" + type + "事件返回结果： res={}", res);
/*     */       } catch (IOException e) {
/* 177 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 180 */     return res;
/*     */   }
/*     */   
/*     */   public String change(String name)
/*     */   {
/* 185 */     StringBuffer sb = new StringBuffer();
/* 186 */     sb.append(name);
/* 187 */     int count = sb.indexOf("_");
/* 188 */     while (count != 0) {
/* 189 */       int num = sb.indexOf("_", count);
/* 190 */       count = num + 1;
/* 191 */       if (num != -1) {
/* 192 */         char ss = sb.charAt(count);
/* 193 */         char ia = ss;
/* 194 */         boolean flag = StringUtil.isAllLowerCase(String.valueOf(ss));
/* 195 */         if (flag) {
/* 196 */           ia = (char)(ss - ' ');
/*     */         }
/* 198 */         sb.replace(count, count + 1, String.valueOf(ia));
/*     */       }
/*     */     }
/* 201 */     String data = sb.toString().replaceAll("_", "");
/* 202 */     return data.toString();
/*     */   }
/*     */ }
