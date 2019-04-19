/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.YoudunGraphDetail;
/*    */ import com.cashloan.cl.mapper.YoudunGraphDetailMapper;
/*    */ import com.cashloan.cl.service.YoudunGraphDetailService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import javax.annotation.Resource;
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
/*    */ @Service("youdunGraphDetailService")
/*    */ public class YoudunGraphDetailServiceImpl
/*    */   extends BaseServiceImpl<YoudunGraphDetail, Long>
/*    */   implements YoudunGraphDetailService
/*    */ {
/*    */   @Resource
/*    */   private YoudunGraphDetailMapper youdunGraphDetailMapper;
/*    */   
/*    */   public BaseMapper<YoudunGraphDetail, Long> getMapper()
/*    */   {
/* 34 */     return this.youdunGraphDetailMapper;
/*    */   }
/*    */ }
