/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.domain.PhoneCollectionLog;
/*    */ import com.cashloan.cl.mapper.PhoneCollectionLogMapper;
/*    */ import com.cashloan.cl.model.PhoneCollectionLogModel;
/*    */ import com.cashloan.cl.service.PhoneCollectionLogService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ @Service("phoneCollectionLogService")
/*    */ public class PhoneCollectionLogServiceImpl
/*    */   extends BaseServiceImpl<PhoneCollectionLog, Long>
/*    */   implements PhoneCollectionLogService
/*    */ {
/* 36 */   private static final Logger logger = LoggerFactory.getLogger(PhoneCollectionLogServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private PhoneCollectionLogMapper phoneCollectionLogMapper;
/*    */   
/*    */   public BaseMapper<PhoneCollectionLog, Long> getMapper()
/*    */   {
/* 43 */     return this.phoneCollectionLogMapper;
/*    */   }
/*    */   
/*    */   public Page<PhoneCollectionLogModel> list(Map<String, Object> params, int current, int pageSize)
/*    */   {
/* 48 */     PageHelper.startPage(current, pageSize);
/* 49 */     List<PhoneCollectionLogModel> list = this.phoneCollectionLogMapper.listJoin(params);
/* 50 */     return (Page)list;
/*    */   }
/*    */ }
