/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.SmsTpl;
/*    */ import com.cashloan.cl.mapper.SmsTplMapper;
/*    */ import com.cashloan.cl.service.SmsTplService;
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
/*    */ @Service("clSmsTplService")
/*    */ public class SmsTplServiceImpl
/*    */   extends BaseServiceImpl<SmsTpl, Long>
/*    */   implements SmsTplService
/*    */ {
/* 29 */   private static final Logger logger = LoggerFactory.getLogger(SmsTplServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private SmsTplMapper clSmsTplMapper;
/*    */   
/*    */   public BaseMapper<SmsTpl, Long> getMapper()
/*    */   {
/* 36 */     return this.clSmsTplMapper;
/*    */   }
/*    */ }
