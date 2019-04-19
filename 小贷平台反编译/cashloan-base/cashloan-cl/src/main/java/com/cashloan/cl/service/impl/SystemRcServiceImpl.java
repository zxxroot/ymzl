/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.mapper.SystemRcMapper;
/*    */ import com.cashloan.cl.model.DayPassApr;
/*    */ import com.cashloan.cl.model.SystemDayData;
/*    */ import com.cashloan.cl.service.SystemRcService;
/*    */ import java.text.NumberFormat;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ @Service("systemRcService")
/*    */ public class SystemRcServiceImpl
/*    */   implements SystemRcService
/*    */ {
/*    */   @Resource
/*    */   private SystemRcMapper systemRcMapper;
/*    */   
/*    */   public Page<SystemDayData> findDayData(Map<String, Object> params, Integer current, Integer pageSize)
/*    */   {
/* 38 */     PageHelper.startPage(current.intValue(), pageSize.intValue());
/* 39 */     Page<SystemDayData> page = (Page)this.systemRcMapper.dayData(params);
/* 40 */     return page;
/*    */   }
/*    */   
/*    */   public Page<DayPassApr> findDayApr(Map<String, Object> params, Integer current, Integer pageSize)
/*    */   {
/* 45 */     PageHelper.startPage(current.intValue(), pageSize.intValue());
/* 46 */     List<DayPassApr> list = (Page)this.systemRcMapper.dayApr(params);
/* 47 */     NumberFormat nf = NumberFormat.getInstance();
/* 48 */     for (DayPassApr dayPassApr : list) {
/* 49 */       dayPassApr.setBorrowPassApr(nf.format(Double.parseDouble(dayPassApr.getBorrowPassApr())));
/* 50 */       dayPassApr.setBorrowApr(nf.format(Double.parseDouble(dayPassApr.getBorrowApr())));
/*    */     }
/* 52 */     return (Page)list;
/*    */   }
/*    */ }
