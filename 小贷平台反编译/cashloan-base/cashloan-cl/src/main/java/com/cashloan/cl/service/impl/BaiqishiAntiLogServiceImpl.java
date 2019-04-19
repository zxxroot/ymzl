/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.BaiqishiAntiLog;
/*    */ import com.cashloan.cl.mapper.BaiqishiAntiLogMapper;
/*    */ import com.cashloan.cl.service.BaiqishiAntiLogService;
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
/*    */ @Service("baiqishiAntiLogService")
/*    */ public class BaiqishiAntiLogServiceImpl
/*    */   extends BaseServiceImpl<BaiqishiAntiLog, Long>
/*    */   implements BaiqishiAntiLogService
/*    */ {
/* 30 */   private static final Logger logger = LoggerFactory.getLogger(BaiqishiAntiLogServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private BaiqishiAntiLogMapper baiqishiAntiLogMapper;
/*    */   
/*    */   public BaseMapper<BaiqishiAntiLog, Long> getMapper()
/*    */   {
/* 37 */     return this.baiqishiAntiLogMapper;
/*    */   }
/*    */ }
