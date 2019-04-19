/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.UserCardCreditLog;
/*    */ import com.cashloan.cl.mapper.UserCardCreditLogMapper;
/*    */ import com.cashloan.cl.service.UserCardCreditLogService;
/*    */ import com.rongdu.cashloan.core.common.context.Global;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ import tool.util.NumberUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("userCardCreditLogService")
/*    */ public class UserCardCreditLogServiceImpl
/*    */   extends BaseServiceImpl<UserCardCreditLog, Long>
/*    */   implements UserCardCreditLogService
/*    */ {
/* 38 */   private static final Logger logger = LoggerFactory.getLogger(UserCardCreditLogServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private UserCardCreditLogMapper userCardCreditLogMapper;
/*    */   
/*    */   public BaseMapper<UserCardCreditLog, Long> getMapper()
/*    */   {
/* 45 */     return this.userCardCreditLogMapper;
/*    */   }
/*    */   
/*    */   public boolean isCanCredit(Long userId)
/*    */   {
/* 50 */     boolean result = true;
/* 51 */     String daysMostTimes = Global.getValue("idCardCredit_day_most_times");
/* 52 */     if (StringUtil.isNotBlank(daysMostTimes)) {
/* 53 */       int times = NumberUtil.getInt(daysMostTimes);
/* 54 */       Map<String, Object> paramMap = new HashMap();
/* 55 */       paramMap.put("userId", userId);
/* 56 */       int count = this.userCardCreditLogMapper.countByUserId(paramMap);
/* 57 */       if (count >= times) {
/* 58 */         logger.error("用户" + userId + "今天请求人脸识别次数超过" + times + ",请明日再来认证");
/* 59 */         result = false;
/*    */       }
/*    */     }
/* 62 */     return result;
/*    */   }
/*    */ }
