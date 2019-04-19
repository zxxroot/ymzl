/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */

import com.cashloan.cl.service.OperatorReqLogService;
import com.cashloan.cl.domain.OperatorReqLog;
import com.cashloan.cl.mapper.OperatorReqLogMapper;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.NumberUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*    */ @Service("operatorReqLogService")
/*    */ public class OperatorReqLogServiceImpl
/*    */   extends BaseServiceImpl<OperatorReqLog, Long>
/*    */   implements OperatorReqLogService
/*    */ {
/* 40 */   public static final Logger logger = LoggerFactory.getLogger(OperatorReqLogServiceImpl.class);
/*    */   @Resource
/*    */   private OperatorReqLogMapper operatorReqLogMapper;
/*    */   
/*    */   public BaseMapper<OperatorReqLog, Long> getMapper()
/*    */   {
/* 46 */     return this.operatorReqLogMapper;
/*    */   }
/*    */   
/*    */   public OperatorReqLog findSelective(Map<String, Object> paramMap)
/*    */   {
/* 51 */     return (OperatorReqLog)this.operatorReqLogMapper.findSelective(paramMap);
/*    */   }
/*    */   
/*    */   public String findOrderByUserId(Long userId)
/*    */   {
/* 56 */     return this.operatorReqLogMapper.findOrderByUserId(userId);
/*    */   }
/*    */   
/*    */   public boolean checkUserOperator(long userId)
/*    */   {
/* 61 */     boolean result = true;
/* 62 */     String daysMostTimes = Global.getValue("operatorCredit_day_most_times");
/* 63 */     if (StringUtil.isNotBlank(daysMostTimes)) {
/* 64 */       int times = NumberUtil.getInt(daysMostTimes);
/* 65 */       Map<String, Object> paramMap = new HashMap();
/* 66 */       paramMap.put("userId", Long.valueOf(userId));
/* 67 */       List<OperatorReqLog> logs = this.operatorReqLogMapper.listByUserId(paramMap);
/* 68 */       if ((!logs.isEmpty()) && (logs.size() >= times)) {
/* 69 */         logger.error("用户" + userId + "今天请求认证次数超过" + times + ",请明日再来认证");
/* 70 */         result = false;
/*    */       }
/*    */     }
/*    */     
/* 74 */     return result;
/*    */   }
/*    */   
/*    */   public OperatorReqLog findLastRecord(Map<String, Object> paramMap)
/*    */   {
/* 79 */     return this.operatorReqLogMapper.findLastRecord(paramMap);
/*    */   }
/*    */ }
