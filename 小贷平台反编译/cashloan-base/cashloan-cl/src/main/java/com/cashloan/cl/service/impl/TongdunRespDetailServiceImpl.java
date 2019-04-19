/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.TongdunRespDetail;
/*    */ import com.cashloan.cl.mapper.TongdunRespDetailMapper;
/*    */ import com.cashloan.cl.service.TongdunRespDetailService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("tongdunRespDetailService")
/*    */ public class TongdunRespDetailServiceImpl
/*    */   extends BaseServiceImpl<TongdunRespDetail, Long>
/*    */   implements TongdunRespDetailService
/*    */ {
/* 20 */   private static final Logger logger = LoggerFactory.getLogger(TongdunRespDetailServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private TongdunRespDetailMapper tongdunRespDetailMapper;
/*    */   
/*    */   public BaseMapper<TongdunRespDetail, Long> getMapper()
/*    */   {
/* 27 */     return this.tongdunRespDetailMapper;
/*    */   }
/*    */ }
