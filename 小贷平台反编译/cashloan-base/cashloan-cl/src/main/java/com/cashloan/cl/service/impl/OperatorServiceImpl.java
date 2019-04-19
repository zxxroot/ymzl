/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.cashloan.cl.domain.OperatorBasic;
/*     */ import com.cashloan.cl.domain.OperatorVoices;
/*     */ import com.cashloan.cl.mapper.OperatorBasicMapper;
/*     */ import com.cashloan.cl.mapper.OperatorBillsMapper;
/*     */ import com.cashloan.cl.mapper.OperatorVoicesMapper;
/*     */ import com.cashloan.cl.mapper.UserAuthMapper;
/*     */ import com.cashloan.cl.model.OperatorBillsModel;
/*     */ import com.cashloan.cl.service.OperatorService;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import tool.util.StringUtil;
/*     */ import vo.GzipUtil;
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
/*     */ @Service("operatorService")
/*     */ @Transactional(rollbackFor={Exception.class})
/*     */ public class OperatorServiceImpl
/*     */   implements OperatorService
/*     */ {
/*  47 */   public static final Logger logger = LoggerFactory.getLogger(OperatorServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private OperatorBasicMapper operatorBasicMapper;
/*     */   
/*     */   @Resource
/*     */   private OperatorBillsMapper operatorBillsMapper;
/*     */   
/*     */   @Resource
/*     */   private OperatorVoicesMapper operatorVoicesMapper;
/*     */   
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private UserAuthMapper userAuthMapper;
/*     */   
/*     */   public void saveOperatorInfos(String res, String compressStatus, Long userId, Date createTime)
/*     */   {
/*  65 */     if (StringUtil.isNotBlank(res)) {
/*  66 */       if ("1".equals(compressStatus)) {
/*     */         try {
/*  68 */           res = GzipUtil.decompressWithBase64(res);
/*     */         } catch (IOException e) {
/*  70 */           logger.error(e.getMessage(), e);
/*     */         }
/*     */       }
/*     */       
/*  74 */       Map<String, Object> resJson = JSONObject.parseObject(res);
/*     */       
/*  76 */       UserBaseInfo baseInfo = null;
/*  77 */       if ((userId != null) && (userId.longValue() > 0L)) {
/*  78 */         Map<String, Object> params = new HashMap();
/*  79 */         params.put("userId", userId);
/*  80 */         baseInfo = (UserBaseInfo)this.userBaseInfoMapper.findSelective(params);
/*     */       }
/*  82 */       if (baseInfo == null) {
/*  83 */         logger.error("保存用户userId：" + userId + "运营商数据时未找到其userBaseInfo，处理失败");
/*  84 */         return;
/*     */       }
/*     */       
/*  87 */       OperatorBasic basic = null;
/*  88 */       String operator_basic = String.valueOf(resJson.get("shuli_operator_basic"));
/*  89 */       if (StringUtil.isNotBlank(operator_basic))
/*     */       {
/*  91 */         List<OperatorBasic> basicList = JSONObject.parseArray(modifyExtendPhoneAge(operator_basic), OperatorBasic.class);
/*  92 */         if ((basicList != null) && (!basicList.isEmpty())) {
/*  93 */           basic = (OperatorBasic)basicList.get(0);
/*     */         }
/*     */         
/*  96 */         if (basic == null) {
/*  97 */           logger.info("保存用户userId：" + userId + "运营商数据时operatorBasic对象为空");
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/* 105 */           if (basic.getExtendJoinDt() != null) {
/* 106 */             basic.setExtendPhoneAge(Integer.valueOf(DateUtil.daysBetween(basic.getExtendJoinDt(), DateUtil.getNow())));
/*     */           }
/* 108 */           basic.setUserId(userId);
/* 109 */           basic.setCreateTime(createTime);
/* 110 */           this.operatorBasicMapper.save(basic);
/*     */         }
/*     */       }
/*     */       
/* 114 */       String operator_bills = String.valueOf(resJson.get("shuli_operator_bill"));
/* 115 */       Date end; if (StringUtil.isNotBlank(operator_bills)) {
/* 116 */         List<OperatorBillsModel> billsList = JSONObject.parseArray(operator_bills, OperatorBillsModel.class);
/* 117 */         if ((billsList != null) && (billsList.size() > 0)) {
/* 118 */           for (OperatorBillsModel bill : billsList) {
/* 119 */             String billMonthDate = bill.getBillMonthDate().replace("/", "");
/* 120 */             if (billMonthDate.length() == 21) {
/* 121 */               Date start = DateUtil.valueOf(billMonthDate.substring(0, 10) + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
/* 122 */               Date end = DateUtil.valueOf(billMonthDate.substring(11, 21) + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
/* 123 */               bill.setBillMonthDateStart(start);
/* 124 */               bill.setBillMonthDateEnd(end);
/* 125 */             } else if (billMonthDate.length() == 10) {
/* 126 */               Date start = DateUtil.valueOf(billMonthDate.substring(0, 10) + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
/* 127 */               Date end = DateUtil.valueOf(billMonthDate.substring(0, 10) + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
/* 128 */               bill.setBillMonthDateStart(start);
/* 129 */               bill.setBillMonthDateEnd(end);
/* 130 */             } else if (billMonthDate.length() == 7) {
/* 131 */               Date start = DateUtil.valueOf(billMonthDate + "-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
/* 132 */               bill.setBillMonthDateStart(start);
/* 133 */               bill.setBillMonthDateEnd(start);
/*     */             } else {
/* 135 */               Date start = DateUtil.getNow();
/* 136 */               end = DateUtil.getNow();
/* 137 */               bill.setBillMonthDateStart(start);
/* 138 */               bill.setBillMonthDateEnd(end);
/*     */             }
/* 140 */             bill.setCreateTime(createTime);
/* 141 */             this.operatorBillsMapper.save(bill);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 146 */       String operator_voices = StringUtil.isNull(resJson.get("shuli_operator_voice"));
/* 147 */       if (StringUtil.isNotBlank(operator_voices)) {
/* 148 */         List<OperatorVoices> voicesList = JSONObject.parseArray(operator_voices, OperatorVoices.class);
/* 149 */         if (!voicesList.isEmpty())
/*     */         {
/* 151 */           String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId.longValue(), 30000L);
/* 152 */           int countTable = this.operatorVoicesMapper.countTable(tableName);
/* 153 */           if (countTable == 0) {
/* 154 */             this.operatorVoicesMapper.createTable(tableName);
/*     */           }
/*     */           
/* 157 */           for (OperatorVoices voice : voicesList) {
/* 158 */             voice.setUserId(userId);
/* 159 */             voice.setCreateTime(createTime);
/* 160 */             logger.debug("GmtCreate----" + voice.getGmtCreate());
/* 161 */             logger.debug("GmtModified----" + voice.getGmtModified());
/* 162 */             logger.debug("CreateTime()----" + voice.getCreateTime());
/* 163 */             this.operatorVoicesMapper.saveShard(tableName, voice);
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 168 */       logger.error("保存用户userId：" + userId + "运营商数据时，res为空，处理失败");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String modifyExtendPhoneAge(String operator_basic)
/*     */   {
/* 178 */     String afterStr = operator_basic;
/*     */     
/* 180 */     int beginIndex = afterStr.indexOf("extendPhoneAge");
/* 181 */     if (beginIndex == -1) {
/* 182 */       return operator_basic;
/*     */     }
/*     */     
/* 185 */     String subStr = afterStr.substring(beginIndex + 17);
/* 186 */     int endIndex = subStr.indexOf("\"");
/*     */     
/*     */ 
/*     */ 
/* 190 */     String extendPhoneAge = subStr.substring(0, endIndex);
/*     */     
/* 192 */     if (StringUtil.isEmpty(extendPhoneAge)) {
/* 193 */       StringBuffer stringBuffer = new StringBuffer(afterStr);
/* 194 */       return stringBuffer.insert(beginIndex + 17, 0).toString();
/*     */     }
/*     */     
/* 197 */     int monthIndex = extendPhoneAge.indexOf("个月");
/* 198 */     int yearIndex = extendPhoneAge.indexOf("年");
/* 199 */     Integer year = Integer.valueOf(0);
/* 200 */     Integer month = Integer.valueOf(0);
/* 201 */     if (yearIndex != -1) {
/* 202 */       year = Integer.valueOf(Integer.valueOf(extendPhoneAge.substring(0, yearIndex)).intValue() * 12);
/*     */     }
/* 204 */     if (monthIndex != -1) {
/* 205 */       month = Integer.valueOf(extendPhoneAge.substring(yearIndex + 1, monthIndex));
/*     */     }
/* 207 */     return afterStr.replace(extendPhoneAge, String.valueOf(year.intValue() + month.intValue()));
/*     */   }
/*     */ }


/*impl\OperatorServiceImpl.class

 */