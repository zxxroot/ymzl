/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.domain.PayRespLog;
/*    */ import com.cashloan.cl.mapper.PayRespLogMapper;
/*    */ import com.cashloan.cl.model.ManagePayRespLogModel;
/*    */ import com.cashloan.cl.service.PayRespLogService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
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
/*    */ @Service("payRespLogService")
/*    */ public class PayRespLogServiceImpl
/*    */   extends BaseServiceImpl<PayRespLog, Long>
/*    */   implements PayRespLogService
/*    */ {
/*    */   @Resource
/*    */   private PayRespLogMapper payRespLogMapper;
/*    */   
/*    */   public boolean save(PayRespLog log)
/*    */   {
/* 42 */     log.setCreateTime(DateUtil.getNow());
/* 43 */     int result = this.payRespLogMapper.save(log);
/* 44 */     if (result > 0L) {
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Page<ManagePayRespLogModel> page(int current, int pageSize, Map<String, Object> searchMap)
/*    */   {
/* 54 */     PageHelper.startPage(current, pageSize);
/* 55 */     Page<ManagePayRespLogModel> page = (Page)this.payRespLogMapper.page(searchMap);
/* 56 */     return page;
/*    */   }
/*    */   
/*    */   public ManagePayRespLogModel findDetail(Long id)
/*    */   {
/* 61 */     return this.payRespLogMapper.findDetail(id);
/*    */   }
/*    */   
/*    */   public BaseMapper<PayRespLog, Long> getMapper()
/*    */   {
/* 66 */     return this.payRespLogMapper;
/*    */   }
/*    */ }
