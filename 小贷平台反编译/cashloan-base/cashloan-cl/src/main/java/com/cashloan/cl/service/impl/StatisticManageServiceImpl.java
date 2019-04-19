/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.mapper.StatisticManageMapper;
/*    */ import com.cashloan.cl.model.DayNeedAmountModel;
/*    */ import com.cashloan.cl.model.ExpendDetailModel;
/*    */ import com.cashloan.cl.model.IncomeAndExpendModel;
/*    */ import com.cashloan.cl.model.IncomeDetailModel;
/*    */ import com.cashloan.cl.service.StatisticManageService;
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
/*    */ @Service("statisticManageService")
/*    */ public class StatisticManageServiceImpl
/*    */   implements StatisticManageService
/*    */ {
/*    */   @Resource
/*    */   private StatisticManageMapper statisticManageMapper;
/*    */   
/*    */   public Page<IncomeAndExpendModel> repayIncomeAndExpend(Map<String, Object> params, Integer current, Integer pageSize)
/*    */   {
/* 36 */     PageHelper.startPage(current.intValue(), pageSize.intValue());
/* 37 */     Page<IncomeAndExpendModel> page = (Page)this.statisticManageMapper.repayIncomeAndExpend(params);
/* 38 */     return page;
/*    */   }
/*    */   
/*    */   public Page<DayNeedAmountModel> dayNeedAmount(Map<String, Object> params, Integer current, Integer pageSize)
/*    */   {
/* 43 */     PageHelper.startPage(current.intValue(), pageSize.intValue());
/* 44 */     Page<DayNeedAmountModel> page = (Page)this.statisticManageMapper.dayNeedAmount(params);
/* 45 */     return page;
/*    */   }
/*    */   
/*    */   public Page<IncomeDetailModel> incomeDetail(Map<String, Object> params, Integer current, Integer pageSize)
/*    */   {
/* 50 */     PageHelper.startPage(current.intValue(), pageSize.intValue());
/* 51 */     Page<IncomeDetailModel> page = (Page)this.statisticManageMapper.incomeDetail(params);
/* 52 */     return page;
/*    */   }
/*    */   
/*    */   public Page<ExpendDetailModel> expendDetail(Map<String, Object> params, Integer current, Integer pageSize)
/*    */   {
/* 57 */     PageHelper.startPage(current.intValue(), pageSize.intValue());
/* 58 */     Page<ExpendDetailModel> page = (Page)this.statisticManageMapper.expendDetail(params);
/* 59 */     return page;
/*    */   }
/*    */   
/*    */   public Double incomeSum(Map<String, Object> params)
/*    */   {
/* 64 */     return this.statisticManageMapper.incomeSum(params);
/*    */   }
/*    */   
/*    */   public Double expendSum(Map<String, Object> params)
/*    */   {
/* 69 */     return this.statisticManageMapper.expendSum(params);
/*    */   }
/*    */ }


/*impl\StatisticManageServiceImpl.class

 */