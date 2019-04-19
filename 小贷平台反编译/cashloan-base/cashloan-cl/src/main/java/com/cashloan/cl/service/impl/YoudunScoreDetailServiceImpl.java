/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.YoudunScoreDetail;
/*    */ import com.cashloan.cl.mapper.YoudunScoreDetailMapper;
/*    */ import com.cashloan.cl.service.YoudunScoreDetailService;
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
/*    */ @Service("youdunScoreDetailService")
/*    */ public class YoudunScoreDetailServiceImpl
/*    */   extends BaseServiceImpl<YoudunScoreDetail, Long>
/*    */   implements YoudunScoreDetailService
/*    */ {
/*    */   @Resource
/*    */   private YoudunScoreDetailMapper youdunScoreDetailMapper;
/*    */   
/*    */   public BaseMapper<YoudunScoreDetail, Long> getMapper()
/*    */   {
/* 33 */     return this.youdunScoreDetailMapper;
/*    */   }
/*    */ }
