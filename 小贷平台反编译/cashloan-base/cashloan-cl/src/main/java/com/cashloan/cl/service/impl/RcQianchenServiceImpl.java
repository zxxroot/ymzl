/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.cashloan.cl.domain.QianchengReqlog;
/*     */ import com.cashloan.cl.domain.RcZhimaAntiFraud;
/*     */ import com.cashloan.cl.domain.RcZhimaIndustry;
/*     */ import com.cashloan.cl.domain.UserContacts;
/*     */ import com.cashloan.cl.domain.UserEmerContacts;
/*     */ import com.cashloan.cl.mapper.BorrowProgressMapper;
/*     */ import com.cashloan.cl.mapper.ClBorrowMapper;
/*     */ import com.cashloan.cl.mapper.OperatorReqLogMapper;
/*     */ import com.cashloan.cl.mapper.QianchengReqlogMapper;
/*     */ import com.cashloan.cl.mapper.RcZhimaAntiFraudMapper;
/*     */ import com.cashloan.cl.mapper.RcZhimaIndustryMapper;
/*     */ import com.cashloan.cl.mapper.UserContactsMapper;
/*     */ import com.cashloan.cl.mapper.UserEmerContactsMapper;
/*     */ import com.cashloan.cl.service.RcQianchenService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.exception.BussinessException;
/*     */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import com.rongdu.cashloan.core.mapper.UserMapper;
/*     */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*     */ import credit.Header;
/*     */ import credit.QianchengRiskRequest;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.DateUtil;
/*     */ import tool.util.StringUtil;
/*     */ import vo.qiancheng.BasicInfo;
/*     */ import vo.qiancheng.OrderDetail;
/*     */ import vo.qiancheng.RiskData;
/*     */ import vo.qiancheng.UserContact;
/*     */ import vo.qiancheng.UserMobileContacts;
/*     */ import vo.qiancheng.UserProofMateria;
/*     */ import vo.qiancheng.ZmData;
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
/*     */ @Service("rcQianchenService")
/*     */ public class RcQianchenServiceImpl
/*     */   implements RcQianchenService
/*     */ {
/*  63 */   public static final Logger logger = LoggerFactory.getLogger(RcQianchenServiceImpl.class);
/*     */   @Resource
/*     */   private UserEmerContactsMapper userEmerContactsMapper;
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private UserContactsMapper userContactsMapper;
/*     */   @Resource
/*     */   private OperatorReqLogMapper operatorReqLogMapper;
/*     */   @Resource
/*     */   private QianchengReqlogMapper qianchengReqlogMapper;
/*     */   @Resource
/*     */   private BorrowProgressMapper borrowProgressMapper;
/*     */   @Resource
/*     */   private ClBorrowMapper clBorrowMapper;
/*     */   @Resource
/*     */   private RcZhimaIndustryMapper rcZhimaIndustryMapper;
/*     */   @Resource
/*     */   private RcZhimaAntiFraudMapper rcZhimaAntiFraudMapper;
/*     */   
/*     */   public String qianchenRiskRequest(Long userId, Borrow borrow, String operatorNo, String reqOrderNo, TppBusiness tpp)
/*     */     throws BussinessException
/*     */   {
/*  88 */     UserBaseInfo userBaseinfo = this.userBaseInfoMapper.findUserImags(userId);
/*     */     
/*  90 */     RiskData riskData = new RiskData();
/*     */     
/*  92 */     Date nowDate = DateUtil.getNow();
/*  93 */     String nowDateStr = DateUtil.dateStr(nowDate, "yyyy-MM-dd HH:mm:ss");
/*  94 */     OrderDetail orderDetail = new OrderDetail();
/*  95 */     orderDetail.setAmount(Integer.valueOf((int)(borrow.getAmount().doubleValue() * 100.0D)));
/*  96 */     orderDetail.setLoan_term(Integer.valueOf(borrow.getTimeLimit()));
/*  97 */     orderDetail.setOrder_time(nowDateStr);
/*  98 */     orderDetail.setOrder_id(Long.valueOf(reqOrderNo));
/*  99 */     riskData.setOrder_detail(orderDetail);
/*     */     
/*     */ 
/* 102 */     BasicInfo basicInfo = new BasicInfo();
/*     */     
/*     */ 
/* 105 */     List<UserContact> ucList = new ArrayList();
/* 106 */     Map<String, Object> params = new HashMap();
/* 107 */     params.put("userId", userId);
/* 108 */     List<UserEmerContacts> EmerContacts = this.userEmerContactsMapper.listSelective(params);
/*     */     
/* 110 */     for (UserEmerContacts info : EmerContacts) {
/* 111 */       UserContact userContact = new UserContact();
/* 112 */       userContact.setName(info.getName());
/* 113 */       userContact.setMobile(info.getPhone());
/* 114 */       if ("父亲".equals(info.getRelation())) {
/* 115 */         userContact.setRelation(Integer.valueOf(0));
/* 116 */       } else if ("母亲".equals(info.getRelation())) {
/* 117 */         userContact.setRelation(Integer.valueOf(1));
/* 118 */       } else if ("配偶".equals(info.getRelation())) {
/* 119 */         userContact.setRelation(Integer.valueOf(2));
/* 120 */       } else if ("朋友".equals(info.getRelation())) {
/* 121 */         userContact.setRelation(Integer.valueOf(3));
/*     */       } else {
/* 123 */         userContact.setRelation(Integer.valueOf(4));
/*     */       }
/* 125 */       ucList.add(userContact);
/*     */     }
/*     */     
/* 128 */     basicInfo.setUser_contact(ucList);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 135 */     riskData.setBasic_info(basicInfo);
/*     */     
/*     */ 
/* 138 */     List<UserProofMateria> user_proof_materia = new ArrayList();
/* 139 */     String picPath = Global.getValue("server_host") + "/readFile.htm?path=";
/*     */     
/*     */ 
/* 142 */     if (StringUtil.isNotBlank(userBaseinfo.getLivingImg())) {
/* 143 */       UserProofMateria upm = new UserProofMateria();
/* 144 */       upm.setUrl(picPath + userBaseinfo.getLivingImg());
/* 145 */       upm.setType(Integer.valueOf(0));
/* 146 */       user_proof_materia.add(upm);
/*     */     }
/*     */     
/*     */ 
/* 150 */     if (StringUtil.isNotBlank(userBaseinfo.getFrontImg())) {
/* 151 */       UserProofMateria upm = new UserProofMateria();
/* 152 */       upm.setUrl(picPath + userBaseinfo.getFrontImg());
/* 153 */       upm.setType(Integer.valueOf(1));
/* 154 */       user_proof_materia.add(upm);
/*     */     }
/*     */     
/*     */ 
/* 158 */     if (StringUtil.isNotBlank(userBaseinfo.getBackImg())) {
/* 159 */       UserProofMateria upm = new UserProofMateria();
/* 160 */       upm.setUrl(picPath + userBaseinfo.getBackImg());
/* 161 */       upm.setType(Integer.valueOf(2));
/* 162 */       user_proof_materia.add(upm);
/*     */     }
/*     */     
/*     */ 
/* 166 */     riskData.setUser_proof_materia(user_proof_materia);
/*     */     
/*     */ 
/* 169 */     List<UserMobileContacts> user_mobile_contacts = new ArrayList();
/* 170 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId.longValue(), 30000L);
/* 171 */     int countTable = this.userContactsMapper.countTable(tableName);
/* 172 */     if (countTable == 0) {
/* 173 */       this.userContactsMapper.createTable(tableName);
/*     */     }
/*     */     
/* 176 */     params = new HashMap();
/* 177 */     params.put("userId", userId);
/* 178 */     List<UserContacts> userContacts = this.userContactsMapper.listShardSelective(tableName, params);
/*     */     
/* 180 */     for (UserContacts contact : userContacts) {
/* 181 */       UserMobileContacts umc = new UserMobileContacts();
/* 182 */       umc.setMobile(contact.getPhone());
/* 183 */       umc.setName(contact.getName());
/* 184 */       user_mobile_contacts.add(umc);
/*     */     }
/* 186 */     riskData.setUser_mobile_contacts(user_mobile_contacts);
/*     */     
/*     */ 
/* 189 */     ZmData zmData = new ZmData();
/*     */     
/* 191 */     Object industryList = this.rcZhimaIndustryMapper.findByuserId(userId);
/* 192 */     List<RcZhimaAntiFraud> antiFraudList = this.rcZhimaAntiFraudMapper.findByuserId(userId);
/* 193 */     if ((antiFraudList.size() > 0) && (StringUtil.isNotBlank(((RcZhimaAntiFraud)antiFraudList.get(0)).getIvsScore())) && (!"null".equals(((RcZhimaAntiFraud)antiFraudList.get(0)).getIvsScore()))) {
/* 194 */       zmData.setZm_score(Integer.valueOf(Integer.parseInt(((RcZhimaAntiFraud)antiFraudList.get(0)).getIvsScore())));
/*     */     } else {
/* 196 */       zmData.setZm_score(Integer.valueOf(0));
/*     */     }
/* 198 */     if ((industryList != null) && (!((List)industryList).isEmpty())) {
/* 199 */       RcZhimaIndustry industry = (RcZhimaIndustry)((List)industryList).get(0);
/* 200 */       zmData.setWatch_info(industry.getDetails());
/*     */     }
/* 202 */     riskData.setZm_data(zmData);
/*     */     
/*     */ 
/* 205 */     long timestamp = new Date().getTime();
/* 206 */     JSONObject apiParamJson = JSONObject.parseObject(tpp.getExtend());
/* 207 */     String APIKEY = apiParamJson.getString("apikey");
/* 208 */     String SECRETKEY = apiParamJson.getString("secretkey");
/* 209 */     Header header = new Header(APIKEY, timestamp);
/* 210 */     String url = tpp.getUrl();
/*     */     
/* 212 */     QianchengReqlog reqLog = new QianchengReqlog(reqOrderNo, borrow.getId(), userId, "10", nowDate);
/* 213 */     int logResult = this.qianchengReqlogMapper.save(reqLog);
/* 214 */     if (logResult == 1) {
/* 215 */       logger.debug("保存浅橙请求记录成功，borrowId:" + borrow.getId());
/*     */     } else {
/* 217 */       logger.debug("保存浅橙请求记录失败，borrowId:" + borrow.getId());
/*     */     }
/*     */     
/* 220 */     String result = "";
/* 221 */     logger.debug("浅橙请求记录，reqLog.getId():" + reqLog.getId());
/* 222 */     if (reqLog.getId().longValue() > 0L) {
/* 223 */       QianchengRiskRequest qianchengRiskRequest = new QianchengRiskRequest(url, header);
/* 224 */       qianchengRiskRequest.setName(userBaseinfo.getRealName());
/* 225 */       qianchengRiskRequest.setMobile(userBaseinfo.getPhone());
/* 226 */       qianchengRiskRequest.setIdCard(userBaseinfo.getIdNo());
/* 227 */       qianchengRiskRequest.setTelecomOrderNo(operatorNo);
/* 228 */       qianchengRiskRequest.setData(riskData);
/*     */       
/* 230 */       qianchengRiskRequest.signByKey(SECRETKEY);
/*     */       
/* 232 */       logger.debug("请求浅橙参数" + JSONObject.toJSONString(qianchengRiskRequest));
/*     */       try {
/* 234 */         reqLog.setReqParams(JSONObject.toJSONString(qianchengRiskRequest));
/* 235 */         this.qianchengReqlogMapper.update(reqLog);
/* 236 */         result = qianchengRiskRequest.request();
/* 237 */         logger.info("qianchenRiskRequest中qiancheng返回结果" + result);
/*     */       } catch (Exception e) {
/* 239 */         logger.error(e.getMessage(), e);
/*     */       }
/* 241 */       logger.debug("浅橙同步响应返回结果：" + result);
/*     */     }
/* 243 */     return result;
/*     */   }
/*     */ }
