/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorVoicesTotal;
/*    */ import com.cashloan.cl.mapper.OperatorVoicesTotalMapper;
/*    */ import com.cashloan.cl.service.OperatorVoicesTotalService;
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
/*    */ @Service("operatorVoicesTotalService")
/*    */ public class OperatorVoicesTotalServiceImpl
/*    */   extends BaseServiceImpl<OperatorVoicesTotal, Long>
/*    */   implements OperatorVoicesTotalService
/*    */ {
/* 30 */   private static final Logger logger = LoggerFactory.getLogger(OperatorVoicesTotalServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorVoicesTotalMapper operatorVoicesTotalMapper;
/*    */   
/*    */   public BaseMapper<OperatorVoicesTotal, Long> getMapper()
/*    */   {
/* 37 */     return this.operatorVoicesTotalMapper;
/*    */   }
/*    */ }
