/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.YoudunLoanDetail;
/*    */ import com.cashloan.cl.mapper.YoudunLoanDetailMapper;
/*    */ import com.cashloan.cl.service.YoudunLoanDetailService;
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
/*    */ @Service("youdunLoanDetailService")
/*    */ public class YoudunLoanDetailServiceImpl
/*    */   extends BaseServiceImpl<YoudunLoanDetail, Long>
/*    */   implements YoudunLoanDetailService
/*    */ {
/*    */   @Resource
/*    */   private YoudunLoanDetailMapper youdunLoanDetailMapper;
/*    */   
/*    */   public BaseMapper<YoudunLoanDetail, Long> getMapper()
/*    */   {
/* 33 */     return this.youdunLoanDetailMapper;
/*    */   }
/*    */ }
