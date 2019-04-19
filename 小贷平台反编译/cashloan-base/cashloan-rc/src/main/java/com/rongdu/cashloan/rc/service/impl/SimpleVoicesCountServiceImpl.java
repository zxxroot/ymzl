/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*    */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*    */ import com.rongdu.cashloan.rc.domain.SimpleVoicesCount;
/*    */ import com.rongdu.cashloan.rc.mapper.SimpleVoicesCountMapper;
/*    */ import com.rongdu.cashloan.rc.service.SimpleVoicesCountService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("simpleVoicesCountService")
/*    */ public class SimpleVoicesCountServiceImpl
/*    */   extends BaseServiceImpl<SimpleVoicesCount, Long>
/*    */   implements SimpleVoicesCountService
/*    */ {
/* 40 */   private static final Logger logger = LoggerFactory.getLogger(SimpleVoicesCountServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private SimpleVoicesCountMapper simpleVoicesCountMapper;
/*    */   @Resource
/*    */   private UserBaseInfoService userBaseInfoService;
/*    */   
/*    */   public BaseMapper<SimpleVoicesCount, Long> getMapper()
/*    */   {
/* 49 */     return this.simpleVoicesCountMapper;
/*    */   }
/*    */   
/*    */   public int countOne(long userId)
/*    */   {
/* 54 */     String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId, 30000L);
/* 55 */     int count = this.simpleVoicesCountMapper.countOne(tableName, userId);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 63 */     SimpleVoicesCount simpleVoicesCount = new SimpleVoicesCount();
/* 64 */     simpleVoicesCount.setUserId(Long.valueOf(userId));
/* 65 */     simpleVoicesCount.setCountOne(Integer.valueOf(count));
/* 66 */     simpleVoicesCount.setCreateTime(DateUtil.getNow());
/*    */     
/* 68 */     return this.simpleVoicesCountMapper.save(simpleVoicesCount);
/*    */   }
/*    */   
/*    */   public SimpleVoicesCount findByUserId(long userId)
/*    */   {
/* 73 */     return this.simpleVoicesCountMapper.findByUserId(userId);
/*    */   }
/*    */ }
