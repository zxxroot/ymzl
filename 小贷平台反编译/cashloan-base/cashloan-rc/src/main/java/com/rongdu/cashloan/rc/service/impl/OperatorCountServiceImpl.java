/*     */ package com.rongdu.cashloan.rc.service.impl;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import com.rongdu.cashloan.rc.domain.PhoneCallBaseCount;
/*     */ import com.rongdu.cashloan.rc.mapper.OperatorCountMapper;
/*     */ import com.rongdu.cashloan.rc.mapper.PhoneCallBaseCountMapper;
/*     */ import com.rongdu.cashloan.rc.mapper.PhoneCallBorrowCountMapper;
/*     */ import com.rongdu.cashloan.rc.model.OperatorCountModel;
/*     */ import com.rongdu.cashloan.rc.service.OperatorCountService;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
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
/*     */ @Service("operatorCountService")
/*     */ public class OperatorCountServiceImpl
/*     */   extends BaseServiceImpl<OperatorCountModel, String>
/*     */   implements OperatorCountService
/*     */ {
/*     */   @Resource
/*     */   private OperatorCountMapper operatorCountMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private PhoneCallBaseCountMapper phoneCallBaseCountMapper;
/*     */   @Resource
/*     */   private PhoneCallBorrowCountMapper phoneCallBorrowCountMapper;
/*     */   
/*     */   public BaseMapper<OperatorCountModel, String> getMapper()
/*     */   {
/*  51 */     return this.operatorCountMapper;
/*     */   }
/*     */   
/*     */   public int operatorCountVoice(Long userId)
/*     */   {
/*  56 */     int update = 0;
/*  57 */     UserBaseInfo baseInfo = this.userBaseInfoMapper.findByUserId(userId);
/*  58 */     OperatorCountModel result = null;
/*  59 */     Map<String, Object> params = new HashMap();
/*  60 */     params.put("phone", baseInfo.getPhone());
/*  61 */     params.put("tableName", ShardTableUtil.generateTableNameById("cl_operator_voices", userId.longValue(), 30000L));
/*  62 */     if ((baseInfo != null) && (baseInfo.getPhone() != null)) {
/*  63 */       result = this.operatorCountMapper.operatorVoicesInfo(params);
/*  64 */       result.setUserId(userId);
/*  65 */       result.setPhone(baseInfo.getPhone());
/*     */     }
/*     */     
/*  68 */     if (result != null) {
/*  69 */       Double monthAmt = this.operatorCountMapper.operatorMonthAmt(baseInfo.getPhone());
/*  70 */       result.setMonthAmt(monthAmt);
/*  71 */       Date joinDate = this.operatorCountMapper.operatorJoinDate(baseInfo.getPhone());
/*  72 */       if (joinDate != null) {
/*  73 */         Calendar cal1 = Calendar.getInstance();
/*  74 */         cal1.setTime(joinDate);
/*  75 */         Calendar cal2 = Calendar.getInstance();
/*  76 */         cal2.setTime(DateUtil.getNow());
/*  77 */         int month = (cal2.get(1) - cal1.get(1)) * 12 - cal1.get(2) + cal2.get(2);
/*  78 */         result.setJoinMonthCount(Integer.valueOf(month));
/*     */       } else {
/*  80 */         result.setJoinMonthCount(Integer.valueOf(0));
/*     */       }
/*     */       
/*  83 */       OperatorCountModel voicesPhone = this.operatorCountMapper.operatorVoicesPhone(params);
/*     */       
/*  85 */       if (voicesPhone != null) {
/*  86 */         result.setGe3Times60SNumCount90(voicesPhone.getGe3Times60SNumCount90());
/*  87 */         result.setGe5TimesNumCount90(voicesPhone.getGe5TimesNumCount90());
/*     */       }
/*     */       
/*  90 */       Integer times = this.operatorCountMapper.emerConcatTimes(params);
/*  91 */       result.setEmerConcatTimes6Month(times);
/*     */     }
/*  93 */     PhoneCallBaseCount baseCount = new PhoneCallBaseCount();
/*  94 */     if (result != null) {
/*  95 */       baseCount = new PhoneCallBaseCount(result);
/*  96 */       if ((result.getCountVoices90() != null) && (result.getLiveAddrVoice90N() != null) && (result.getCountVoices90().intValue() > 0) && (result.getLiveAddrVoice90N().intValue() > 0) && (result.getCountVoices90().intValue() == result.getLiveAddrVoice90N().intValue())) {
/*  97 */         baseCount.setAddressMatching("20");
/*     */       } else {
/*  99 */         baseCount.setAddressMatching("10");
/*     */       }
/* 101 */       if ((result.getMonthAmt() != null) && (result.getMonthAmt().doubleValue() > 0.0D)) {
/* 102 */         BigDecimal monthAmt = new BigDecimal(result.getMonthAmt().doubleValue()).setScale(0, 4);
/* 103 */         baseCount.setMonthSource(Integer.valueOf(monthAmt.intValue()));
/*     */       } else {
/* 105 */         baseCount.setMonthSource(Integer.valueOf(0));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 110 */     if (result != null) {
/* 111 */       result = this.operatorCountMapper.concatsBorrowInfo(params);
/*     */       
/*     */ 
/* 114 */       baseCount.setCountTwenty(result.getPre20NumBorrowY90());
/* 115 */       baseCount.setCountTwentyOne(result.getPre20NumBorrowN90());
/* 116 */       baseCount.setCountTwentyTwo(result.getPre20NumBorrowN90M3());
/* 117 */       baseCount.setCountTwentyThree(result.getPre20NumBorrowNMore30M1());
/* 118 */       baseCount.setCountTwentyFour(result.getPre20NumBorrowNLess30M1());
/* 119 */       update = this.phoneCallBaseCountMapper.save(baseCount);
/*     */     }
/*     */     
/* 122 */     return update;
/*     */   }
/*     */ }
