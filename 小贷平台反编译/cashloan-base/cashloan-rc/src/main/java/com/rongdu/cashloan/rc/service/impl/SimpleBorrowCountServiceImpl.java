/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.rc.domain.SimpleBorrowCount;
/*    */ import com.rongdu.cashloan.rc.mapper.SimpleBorrowCountMapper;
/*    */ import com.rongdu.cashloan.rc.service.SimpleBorrowCountService;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ import tool.util.DateUtil;
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
/*    */ @Service("simpleBorrowCountService")
/*    */ public class SimpleBorrowCountServiceImpl
/*    */   extends BaseServiceImpl<SimpleBorrowCount, Long>
/*    */   implements SimpleBorrowCountService
/*    */ {
/* 33 */   private static final Logger logger = LoggerFactory.getLogger(SimpleBorrowCountServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private SimpleBorrowCountMapper simpleBorrowCountMapper;
/*    */   
/*    */   public BaseMapper<SimpleBorrowCount, Long> getMapper()
/*    */   {
/* 40 */     return this.simpleBorrowCountMapper;
/*    */   }
/*    */   
/*    */   public int countOne(long userId)
/*    */   {
/* 45 */     int count = this.simpleBorrowCountMapper.countOne(userId);
/*    */     
/* 47 */     SimpleBorrowCount simpleBorrowCount = new SimpleBorrowCount();
/* 48 */     simpleBorrowCount.setUserId(Long.valueOf(userId));
/* 49 */     simpleBorrowCount.setCountOne(Integer.valueOf(count));
/* 50 */     simpleBorrowCount.setCreateTime(DateUtil.getNow());
/*    */     
/* 52 */     return this.simpleBorrowCountMapper.save(simpleBorrowCount);
/*    */   }
/*    */ }
