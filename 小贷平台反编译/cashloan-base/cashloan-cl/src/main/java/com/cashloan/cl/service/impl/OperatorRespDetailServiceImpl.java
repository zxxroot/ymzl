/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorRespDetail;
/*    */ import com.cashloan.cl.mapper.OperatorRespDetailMapper;
/*    */ import com.cashloan.cl.service.OperatorRespDetailService;
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
/*    */ 
/*    */ @Service("operatorRespDetailService")
/*    */ public class OperatorRespDetailServiceImpl
/*    */   extends BaseServiceImpl<OperatorRespDetail, Long>
/*    */   implements OperatorRespDetailService
/*    */ {
/* 31 */   private static final Logger logger = LoggerFactory.getLogger(OperatorRespDetailServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorRespDetailMapper operatorRespDetailMapper;
/*    */   
/*    */ 
/*    */   public BaseMapper<OperatorRespDetail, Long> getMapper()
/*    */   {
/* 39 */     return this.operatorRespDetailMapper;
/*    */   }
/*    */ }
