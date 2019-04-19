/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*    */ import com.rongdu.cashloan.rc.domain.SimpleContactCount;
/*    */ import com.rongdu.cashloan.rc.mapper.SimpleContactCountMapper;
/*    */ import com.rongdu.cashloan.rc.service.SimpleContactCountService;
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
/*    */ @Service("simpleContactCountService")
/*    */ public class SimpleContactCountServiceImpl
/*    */   extends BaseServiceImpl<SimpleContactCount, Long>
/*    */   implements SimpleContactCountService
/*    */ {
/* 34 */   private static final Logger logger = LoggerFactory.getLogger(SimpleContactCountServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private SimpleContactCountMapper simpleContactCountMapper;
/*    */   
/*    */   public BaseMapper<SimpleContactCount, Long> getMapper()
/*    */   {
/* 41 */     return this.simpleContactCountMapper;
/*    */   }
/*    */   
/*    */   public int countOne(long userId)
/*    */   {
/* 46 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId, 30000L);
/* 47 */     int count = this.simpleContactCountMapper.countOne(tableName, userId);
/*    */     
/* 49 */     SimpleContactCount simpleContactCount = new SimpleContactCount();
/* 50 */     simpleContactCount.setUserId(Long.valueOf(userId));
/* 51 */     simpleContactCount.setCountOne(Integer.valueOf(count));
/* 52 */     simpleContactCount.setCreateTime(DateUtil.getNow());
/*    */     
/* 54 */     return this.simpleContactCountMapper.save(simpleContactCount);
/*    */   }
/*    */ }
