/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorTdTransactions;
/*    */ import com.cashloan.cl.mapper.OperatorTdTransactionsMapper;
/*    */ import com.cashloan.cl.service.OperatorTdTransactionsService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
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
/*    */ @Service("operatorTdTransactionsService")
/*    */ public class OperatorTdTransactionsServiceImpl
/*    */   extends BaseServiceImpl<OperatorTdTransactions, Long>
/*    */   implements OperatorTdTransactionsService
/*    */ {
/* 30 */   private static final Logger logger = LoggerFactory.getLogger(OperatorTdTransactionsServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorTdTransactionsMapper operatorTdTransactionsMapper;
/*    */   
/*    */   public BaseMapper<OperatorTdTransactions, Long> getMapper()
/*    */   {
/* 37 */     return this.operatorTdTransactionsMapper;
/*    */   }
/*    */ }
