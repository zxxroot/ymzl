/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.ChannelThirdLog;
/*    */ import com.cashloan.cl.mapper.ChannelThirdLogMapper;
/*    */ import com.cashloan.cl.service.ChannelThirdLogService;
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
/*    */ @Service("channelThirdLogService")
/*    */ public class ChannelThirdLogServiceImpl
/*    */   extends BaseServiceImpl<ChannelThirdLog, Long>
/*    */   implements ChannelThirdLogService
/*    */ {
/* 30 */   private static final Logger logger = LoggerFactory.getLogger(ChannelThirdLogServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private ChannelThirdLogMapper channelThirdLogMapper;
/*    */   
/*    */   public BaseMapper<ChannelThirdLog, Long> getMapper()
/*    */   {
/* 37 */     return this.channelThirdLogMapper;
/*    */   }
/*    */ }
