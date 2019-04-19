/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.RepayZhanqi;
/*    */ import com.cashloan.cl.mapper.RepayZhanqiMapper;
/*    */ import com.cashloan.cl.service.RepayZhanqiService;
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
/*    */ @Service("repayZhanqiService")
/*    */ public class RepayZhanqiServiceImpl
/*    */   extends BaseServiceImpl<RepayZhanqi, Long>
/*    */   implements RepayZhanqiService
/*    */ {
/* 46 */   private static final Logger logger = LoggerFactory.getLogger(RepayZhanqiServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private RepayZhanqiMapper repayZhanqiMapper;
/*    */   
/*    */ 
/*    */   public BaseMapper<RepayZhanqi, Long> getMapper()
/*    */   {
/* 54 */     return this.repayZhanqiMapper;
/*    */   }
/*    */ }


/*impl\RepayZhanqiServiceImpl.class

 */