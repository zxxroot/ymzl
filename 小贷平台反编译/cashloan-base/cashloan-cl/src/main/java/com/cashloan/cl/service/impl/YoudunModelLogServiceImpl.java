/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.YoudunModelLog;
/*    */ import com.cashloan.cl.mapper.YoudunModelLogMapper;
/*    */ import com.cashloan.cl.service.YoudunModelLogService;
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
/*    */ @Service("youdunModelLogService")
/*    */ public class YoudunModelLogServiceImpl
/*    */   extends BaseServiceImpl<YoudunModelLog, Long>
/*    */   implements YoudunModelLogService
/*    */ {
/* 30 */   private static final Logger logger = LoggerFactory.getLogger(YoudunModelLogServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private YoudunModelLogMapper youdunModelLogMapper;
/*    */   
/*    */   public BaseMapper<YoudunModelLog, Long> getMapper()
/*    */   {
/* 37 */     return this.youdunModelLogMapper;
/*    */   }
/*    */ }


/*impl\YoudunModelLogServiceImpl.class

 */