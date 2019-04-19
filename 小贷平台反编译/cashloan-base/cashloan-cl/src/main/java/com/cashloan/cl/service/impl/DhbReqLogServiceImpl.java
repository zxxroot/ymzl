/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.cashloan.cl.domain.DhbBinding;
/*     */ import com.cashloan.cl.domain.DhbHistoryOrg;
/*     */ import com.cashloan.cl.domain.DhbHistorySearch;
/*     */ import com.cashloan.cl.domain.DhbReqLog;
/*     */ import com.cashloan.cl.domain.DhbRiskBlacklist;
/*     */ import com.cashloan.cl.domain.DhbRiskSocialNetwork;
/*     */ import com.cashloan.cl.domain.DhbUserBasic;
/*     */ import com.cashloan.cl.mapper.DhbBindingMapper;
/*     */ import com.cashloan.cl.mapper.DhbHistoryOrgMapper;
/*     */ import com.cashloan.cl.mapper.DhbHistorySearchMapper;
/*     */ import com.cashloan.cl.mapper.DhbReqLogMapper;
/*     */ import com.cashloan.cl.mapper.DhbRiskBlacklistMapper;
/*     */ import com.cashloan.cl.mapper.DhbRiskSocialNetworkMapper;
/*     */ import com.cashloan.cl.mapper.DhbUserBasicMapper;
/*     */ import com.cashloan.cl.service.DhbReqLogService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.HttpsUtil;
/*     */ import com.rongdu.cashloan.core.common.util.OrderNoUtil;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.StringUtil;
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
/*     */ @Service("dhbReqLogService")
/*     */ public class DhbReqLogServiceImpl
/*     */   extends BaseServiceImpl<DhbReqLog, Long>
/*     */   implements DhbReqLogService
/*     */ {
/*  56 */   private static final Logger logger = LoggerFactory.getLogger(DhbReqLogServiceImpl.class);
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
/*     */   public BaseMapper<DhbReqLog, Long> getMapper()
/*     */   {
/*  84 */     return this.dhbReqLogMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int queryDhbSauron(Borrow borrow, TppBusiness business)
/*     */   {
/*  95 */     logger.info("借款id:" + borrow.getId() + "开始进行贷后邦反欺诈。。。");
/*  96 */     int i = 0;
/*  97 */     String accessToken = "";
/*     */     
/*  99 */     UserBaseInfo userBaseinfo = this.userBaseInfoMapper.findByUserId(borrow.getUserId());
/* 100 */     String orderNo = OrderNoUtil.getSerialNumber();
/* 101 */     DhbReqLog log = new DhbReqLog();
/* 102 */     log.setBorrowId(borrow.getId());
/* 103 */     log.setCreateTime(new Date());
/* 104 */     log.setOrderNo(orderNo);
/* 105 */     log.setUserId(borrow.getUserId());
/*     */     
/* 107 */     String companyAccount = Global.getValue("sauron_dhb_partner_code");
/*     */     
/* 109 */     String signature = Global.getValue("sauron_dhb_sign");
/*     */     
/* 111 */     String url = Global.getValue("sauron_dhb_partner_url") + "/" + companyAccount + "/access_token?signature=" + signature;
/* 112 */     String result = null;
/*     */     try {
/* 114 */       result = HttpsUtil.getClient(url);
/*     */     } catch (Exception e) {
/* 116 */       logger.error(e.getMessage(), e);
/*     */     }
/* 118 */     if ((result != null) && (!result.equals(""))) {
/* 119 */       Map<String, Object> resultMap = JSONObject.parseObject(result);
/* 120 */       String code = String.valueOf(resultMap.get("code"));
/* 121 */       if (code.equals("0"))
/*     */       {
/* 123 */         if (resultMap.get("data") != null) {
/* 124 */           Map<String, Object> resMap = JSONObject.parseObject(resultMap.get("data"));
/* 125 */           accessToken = String.valueOf(resMap.get("access_token"));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 130 */     url = 
/* 131 */       Global.getValue("sauron_dhb_data_url") + "?name=" + userBaseinfo.getRealName() + "&idCard=" + userBaseinfo.getIdNo() + "&phone=" + userBaseinfo.getPhone() + "&companyAccount=" + companyAccount + "&accessToken=" + accessToken;
/*     */     try {
/* 133 */       result = HttpsUtil.getClient(url);
/*     */     } catch (Exception e) {
/* 135 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */     
/* 138 */     if ((result != null) && (!result.equals(""))) {
/* 139 */       Map<String, Object> resultMap = JSONObject.parseObject(result);
/* 140 */       String code = String.valueOf(resultMap.get("code"));
/* 141 */       log.setRespCode(code);
/* 142 */       log.setRespParams(String.valueOf(resultMap.get("message")));
/* 143 */       log.setRespTime(new Date());
/* 144 */       log.setRespOrderNo("");
/* 145 */       if (code.equals("17153"))
/*     */       {
/* 147 */         i = saveSauronRes(String.valueOf(resultMap.get("data")), borrow.getUserId().longValue(), orderNo);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 152 */     i = this.dhbReqLogMapper.save(log);
/* 153 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int saveSauronRes(String res, long userId, String orderNo)
/*     */   {
/* 166 */     logger.info("保存贷后邦-反欺诈数据。。。");
/* 167 */     int i = 0;
/* 168 */     if (StringUtil.isNotBlank(res)) {
/* 169 */       res = change(res);
/*     */       
/* 171 */       List<DhbUserBasic> basicList = JSONObject.parseArray("[" + JSONObject.parseObject(res).get("userBasic") + "]", DhbUserBasic.class);
/* 172 */       if ((basicList != null) && (!basicList.isEmpty()))
/*     */       {
/* 174 */         this.dhbUserBasicMapper.deleteByUserId(Long.valueOf(userId));
/* 175 */         DhbUserBasic basic = (DhbUserBasic)basicList.get(0);
/* 176 */         basic.setOrderNo(orderNo);
/* 177 */         basic.setUserId(Long.valueOf(userId));
/* 178 */         i = this.dhbUserBasicMapper.save(basic);
/*     */       }
/* 180 */       List<DhbHistoryOrg> orgList = JSONObject.parseArray("[" + JSONObject.parseObject(res).get("historyOrg") + "]", DhbHistoryOrg.class);
/* 181 */       if ((orgList != null) && (!orgList.isEmpty()))
/*     */       {
/* 183 */         this.dhbHistoryOrgMapper.deleteByUserId(userId);
/* 184 */         DhbHistoryOrg org = (DhbHistoryOrg)orgList.get(0);
/* 185 */         org.setOrderNo(orderNo);
/* 186 */         org.setUserId(Long.valueOf(userId));
/* 187 */         i = this.dhbHistoryOrgMapper.save(org);
/*     */       }
/* 189 */       List<DhbHistorySearch> searchList = JSONObject.parseArray("[" + JSONObject.parseObject(res).get("historySearch") + "]", DhbHistorySearch.class);
/* 190 */       if ((searchList != null) && (!searchList.isEmpty()))
/*     */       {
/* 192 */         this.dhbHistorySearchMapper.deleteByUserId(userId);
/* 193 */         DhbHistorySearch search = (DhbHistorySearch)searchList.get(0);
/* 194 */         search.setOrderNo(orderNo);
/* 195 */         search.setUserId(Long.valueOf(userId));
/* 196 */         i = this.dhbHistorySearchMapper.save(search);
/*     */       }
/* 198 */       List<DhbRiskBlacklist> blackList = JSONObject.parseArray("[" + JSONObject.parseObject(res).get("riskBlacklist") + "]", DhbRiskBlacklist.class);
/* 199 */       if ((blackList != null) && (!blackList.isEmpty()))
/*     */       {
/* 201 */         this.dhbRiskBlacklistMapper.deleteByUserId(userId);
/* 202 */         DhbRiskBlacklist black = (DhbRiskBlacklist)blackList.get(0);
/* 203 */         black.setOrderNo(orderNo);
/* 204 */         black.setUserId(Long.valueOf(userId));
/* 205 */         i = this.dhbRiskBlacklistMapper.save(black);
/*     */       }
/* 207 */       List<DhbRiskSocialNetwork> riskList = JSONObject.parseArray("[" + JSONObject.parseObject(res).get("riskSocialNetwork") + "]", DhbRiskSocialNetwork.class);
/* 208 */       if ((riskList != null) && (!riskList.isEmpty()))
/*     */       {
/* 210 */         this.dhbRiskSocialNetworkMapper.deleteByUserId(userId);
/* 211 */         DhbRiskSocialNetwork risk = (DhbRiskSocialNetwork)riskList.get(0);
/* 212 */         risk.setOrderNo(orderNo);
/* 213 */         risk.setUserId(Long.valueOf(userId));
/* 214 */         i = this.dhbRiskSocialNetworkMapper.save(risk);
/*     */       }
/*     */       
/* 217 */       this.dhbBindingMapper.deleteByUserId(userId);
/*     */       
/* 219 */       int searchOrgsCntCard = 0;
/*     */       
/* 221 */       int idcardValidate = 1;
/* 222 */       DhbBinding bind = new DhbBinding();
/* 223 */       Map<String, Object> resultMap = JSONObject.parseObject(res);
/* 224 */       String bindIds = String.valueOf(resultMap.get("bindingIdcards"));
/* 225 */       if (StringUtil.isNotBlank(bindIds)) {
/* 226 */         bind.setBindingIdcardsDetail(bindIds);
/* 227 */         List idsList = JSONObject.parseArray(bindIds, Object.class);
/* 228 */         if ((idsList != null) && (!idsList.isEmpty())) {
/* 229 */           for (int j = 0; j < idsList.size(); j++) {
/* 230 */             searchOrgsCntCard += ((Integer)JSONObject.parseObject(idsList.get(j).toString()).get("searchOrgsCnt")).intValue();
/* 231 */             if (((Integer)JSONObject.parseObject(idsList.get(j).toString()).get("idcardValidate")).intValue() == 0) {
/* 232 */               idcardValidate = 0;
/*     */             }
/*     */           }
/* 235 */           bind.setBindingIdcardsSize(Integer.valueOf(idsList.size()));
/*     */         } else {
/* 237 */           bind.setBindingIdcardsSize(Integer.valueOf(0));
/*     */         }
/* 239 */         bind.setBindingIdcardsTotalCnt(Integer.valueOf(searchOrgsCntCard));
/* 240 */         bind.setBindingIdcardValidate(Integer.valueOf(idcardValidate));
/*     */       }
/*     */       
/* 243 */       int searchOrgsCntPhone = 0;
/*     */       
/* 245 */       String bindPhones = String.valueOf(resultMap.get("bindingPhones"));
/* 246 */       if (StringUtil.isNotBlank(bindPhones)) {
/* 247 */         bind.setBindingPhonesDetail(bindPhones);
/* 248 */         List phonesList = JSONObject.parseArray(bindPhones, Object.class);
/* 249 */         if ((phonesList != null) && (!phonesList.isEmpty())) {
/* 250 */           for (int j = 0; j < phonesList.size(); j++) {
/* 251 */             searchOrgsCntPhone += ((Integer)JSONObject.parseObject(phonesList.get(j).toString()).get("searchOrgsCnt")).intValue();
/*     */           }
/* 253 */           bind.setBindingPhonesSize(Integer.valueOf(phonesList.size()));
/*     */         } else {
/* 255 */           bind.setBindingPhonesSize(Integer.valueOf(0));
/*     */         }
/* 257 */         bind.setBindingPhonesTotalCnt(Integer.valueOf(searchOrgsCntPhone));
/*     */       }
/* 259 */       bind.setOrderNo(orderNo);
/* 260 */       bind.setUserId(Long.valueOf(userId));
/* 261 */       i = this.dhbBindingMapper.save(bind);
/*     */     }
/*     */     
/*     */ 
/* 265 */     return i;
/*     */   }
/*     */   
/*     */   public String change(String name)
/*     */   {
/* 270 */     StringBuffer sb = new StringBuffer();
/* 271 */     sb.append(name);
/* 272 */     int count = sb.indexOf("_");
/* 273 */     while (count != 0) {
/* 274 */       int num = sb.indexOf("_", count);
/* 275 */       count = num + 1;
/* 276 */       if (num != -1) {
/* 277 */         char ss = sb.charAt(count);
/* 278 */         char ia = ss;
/* 279 */         boolean flag = StringUtil.isAllLowerCase(String.valueOf(ss));
/* 280 */         if (flag) {
/* 281 */           ia = (char)(ss - ' ');
/*     */         }
/* 283 */         sb.replace(count, count + 1, ia);
/*     */       }
/*     */     }
/* 286 */     String data = sb.toString().replaceAll("_", "");
/* 287 */     return data.toString();
/*     */   }
/*     */ }
