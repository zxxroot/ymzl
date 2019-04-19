/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorRepApplicationCheck;
/*    */ import com.cashloan.cl.mapper.OperatorRepApplicationCheckMapper;
/*    */ import com.cashloan.cl.service.OperatorRepApplicationCheckService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
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
/*    */ @Service("operatorRepApplicationCheckService")
/*    */ public class OperatorRepApplicationCheckServiceImpl
/*    */   extends BaseServiceImpl<OperatorRepApplicationCheck, Long>
/*    */   implements OperatorRepApplicationCheckService
/*    */ {
/* 35 */   private static final Logger logger = LoggerFactory.getLogger(OperatorRepApplicationCheckServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorRepApplicationCheckMapper operatorRepApplicationCheckMapper;
/*    */   
/*    */   public BaseMapper<OperatorRepApplicationCheck, Long> getMapper()
/*    */   {
/* 42 */     return this.operatorRepApplicationCheckMapper;
/*    */   }
/*    */   
/*    */   public List<OperatorRepApplicationCheck> listSelective(Map<String, Object> paramsMap)
/*    */   {
/* 47 */     long userId = ((Long)paramsMap.get("userId")).longValue();
/* 48 */     String tableApplication = ShardTableUtil.generateTableNameById("cl_operator_rep_application_check", userId, 30000L);
/* 49 */     int countApplication = this.operatorRepApplicationCheckMapper.countTable(tableApplication);
/* 50 */     if (countApplication == 0) {
/* 51 */       this.operatorRepApplicationCheckMapper.createTable(tableApplication);
/*    */     }
/* 53 */     return this.operatorRepApplicationCheckMapper.listShardSelective(tableApplication, paramsMap);
/*    */   }
/*    */ }
