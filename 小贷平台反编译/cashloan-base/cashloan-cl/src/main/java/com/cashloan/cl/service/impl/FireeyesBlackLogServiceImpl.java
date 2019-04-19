/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.cashloan.cl.domain.FireeyesBlackLog;
/*     */ import com.cashloan.cl.mapper.FireeyesBlackLogMapper;
/*     */ import com.cashloan.cl.service.FireeyesBlackLogService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*     */ import credit.CreditRequest;
/*     */ import credit.Header;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ @Service("fireeyesBlackLogService")
/*     */ public class FireeyesBlackLogServiceImpl
/*     */   extends BaseServiceImpl<FireeyesBlackLog, Long>
/*     */   implements FireeyesBlackLogService
/*     */ {
/*  42 */   private static final Logger logger = LoggerFactory.getLogger(FireeyesBlackLogServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private FireeyesBlackLogMapper fireeyesBlackLogMapper;
/*     */   @Resource
/*     */   private UserBaseInfoService userBaseInfoService;
/*     */   
/*     */   public BaseMapper<FireeyesBlackLog, Long> getMapper()
/*     */   {
/*  51 */     return this.fireeyesBlackLogMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int queryFireeyesBlack(Borrow borrow, TppBusiness business)
/*     */   {
/*  60 */     int status = 0;
/*     */     try {
/*  62 */       Map<String, Object> businessMap = (Map)JSONObject.parseObject(business.getExtend(), Map.class);
/*     */       
/*  64 */       String APIHOST = business.getUrl();
/*  65 */       String APIKEY = businessMap.get("apiKey");
/*  66 */       String SECRETKEY = businessMap.get("secretKey");
/*  67 */       String channelNo = businessMap.get("channelNo");
/*  68 */       String interfaceName = businessMap.get("interfaceName");
/*     */       
/*  70 */       long timestamp = new Date().getTime();
/*  71 */       Header header = new Header(APIKEY, channelNo, interfaceName, timestamp);
/*     */       
/*  73 */       CreditRequest creditRequest = new CreditRequest(APIHOST, header);
/*  74 */       UserBaseInfo baseInfo = this.userBaseInfoService.findByUserId(borrow.getUserId());
/*  75 */       Map<String, Object> payload = new HashMap();
/*  76 */       payload.put("mobile", baseInfo.getPhone());
/*  77 */       payload.put("name", baseInfo.getRealName());
/*  78 */       payload.put("idCard", baseInfo.getIdNo());
/*  79 */       creditRequest.setPayload(payload);
/*  80 */       creditRequest.signByKey(SECRETKEY);
/*     */       
/*  82 */       FireeyesBlackLog blackLog = new FireeyesBlackLog();
/*  83 */       blackLog.setCreateTime(DateUtil.getNow());
/*  84 */       blackLog.setPhone(baseInfo.getPhone());
/*  85 */       blackLog.setUserId(borrow.getUserId());
/*  86 */       blackLog.setUserCard(baseInfo.getIdNo());
/*  87 */       blackLog.setUserName(baseInfo.getRealName());
/*  88 */       String result = creditRequest.request();
/*  89 */       logger.info("火眼黑名单返回数据：" + result);
/*  90 */       if ((result != null) && (!result.equals(""))) {
/*  91 */         Map<String, Object> resultMap = JSONObject.parseObject(result);
/*  92 */         String code = resultMap.get("code");
/*  93 */         if (code.equals("200")) {
/*  94 */           blackLog.setOrderNo(resultMap.get("orderNo"));
/*  95 */           blackLog.setRespCode(code);
/*     */           
/*  97 */           if (resultMap.get("res") != null) {
/*  98 */             Map<String, Object> resMap = JSONObject.parseObject(resultMap.get("res"));
/*  99 */             blackLog.setIsBlack(resMap.get("status"));
/* 100 */             blackLog.setRespParams(resMap.get("blackArray"));
/*     */           }
/*     */         } else {
/* 103 */           blackLog.setRespCode(code);
/* 104 */           blackLog.setRespParams(resultMap.get("message"));
/*     */         }
/*     */       }
/* 107 */       status = this.fireeyesBlackLogMapper.save(blackLog);
/*     */     }
/*     */     catch (Exception e) {
/* 110 */       e.printStackTrace();
/*     */     }
/*     */     
/* 113 */     return status;
/*     */   }
/*     */ }
