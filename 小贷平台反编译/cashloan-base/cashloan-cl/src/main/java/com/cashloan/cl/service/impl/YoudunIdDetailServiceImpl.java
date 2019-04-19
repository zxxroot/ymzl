/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.YoudunIdDetail;
/*    */ import com.cashloan.cl.mapper.YoudunIdDetailMapper;
/*    */ import com.cashloan.cl.service.YoudunIdDetailService;
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
/*    */ @Service("youdunIdDetailService")
/*    */ public class YoudunIdDetailServiceImpl
/*    */   extends BaseServiceImpl<YoudunIdDetail, Long>
/*    */   implements YoudunIdDetailService
/*    */ {
/*    */   @Resource
/*    */   private YoudunIdDetailMapper youdunIdDetailMapper;
/*    */   
/*    */   public BaseMapper<YoudunIdDetail, Long> getMapper()
/*    */   {
/* 34 */     return this.youdunIdDetailMapper;
/*    */   }
/*    */ }
