/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.domain.PayReqLog;
/*    */ import com.cashloan.cl.mapper.PayReqLogMapper;
/*    */ import com.cashloan.cl.model.ManagePayReqLogModel;
/*    */ import com.cashloan.cl.service.PayReqLogService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.util.HashMap;
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
/*    */ @Service("payReqLogService")
/*    */ public class PayReqLogServiceImpl
/*    */   extends BaseServiceImpl<PayReqLog, Long>
/*    */   implements PayReqLogService
/*    */ {
/*    */   @Resource
/*    */   private PayReqLogMapper payReqLogMapper;
/*    */   
/*    */   public boolean save(PayReqLog log)
/*    */   {
/* 42 */     log.setCreateTime(DateUtil.getNow());
/* 43 */     int result = this.payReqLogMapper.save(log);
/* 44 */     if (result > 0L) {
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public PayReqLog findByOrderNo(String orderNo)
/*    */   {
/* 52 */     Map<String, Object> paramMap = new HashMap();
/* 53 */     paramMap.put("orderNo", orderNo);
/* 54 */     return (PayReqLog)this.payReqLogMapper.findSelective(paramMap);
/*    */   }
/*    */   
/*    */   public Page<ManagePayReqLogModel> page(int current, int pageSize, Map<String, Object> searchMap)
/*    */   {
/* 59 */     PageHelper.startPage(current, pageSize);
/* 60 */     Page<ManagePayReqLogModel> page = (Page)this.payReqLogMapper.page(searchMap);
/* 61 */     return page;
/*    */   }
/*    */   
/*    */   public ManagePayReqLogModel findDetail(Long id)
/*    */   {
/* 66 */     return this.payReqLogMapper.findDetail(id);
/*    */   }
/*    */   
/*    */   public BaseMapper<PayReqLog, Long> getMapper()
/*    */   {
/* 71 */     return this.payReqLogMapper;
/*    */   }
/*    */ }
