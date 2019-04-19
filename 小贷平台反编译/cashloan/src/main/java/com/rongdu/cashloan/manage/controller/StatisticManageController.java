/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.model.DayNeedAmountModel;
/*     */ import com.rongdu.cashloan.cl.model.ExpendDetailModel;
/*     */ import com.rongdu.cashloan.cl.model.IncomeAndExpendModel;
/*     */ import com.rongdu.cashloan.cl.model.IncomeDetailModel;
/*     */ import com.rongdu.cashloan.cl.service.StatisticManageService;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class StatisticManageController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private StatisticManageService statisticManageService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/statistic/dayNeedAmount.htm"})
/*     */   public void dayNeedAmount(HttpServletResponse response, @RequestParam("search") String search, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize)
/*     */     throws Exception
/*     */   {
/*  55 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  56 */     Page<DayNeedAmountModel> page = this.statisticManageService.dayNeedAmount(params, current, pageSize);
/*  57 */     Map<String, Object> result = new HashMap();
/*  58 */     result.put("data", page);
/*  59 */     result.put("page", new RdPage(page));
/*  60 */     result.put("code", Integer.valueOf(200));
/*  61 */     result.put("msg", "查询成功");
/*  62 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/statistic/incomeAndExpend.htm"})
/*     */   public void incomeAndExpend(HttpServletResponse response, @RequestParam("search") String search, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize)
/*     */     throws Exception
/*     */   {
/*  78 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  79 */     Page<IncomeAndExpendModel> page = this.statisticManageService.repayIncomeAndExpend(params, current, pageSize);
/*  80 */     Map<String, Object> result = new HashMap();
/*  81 */     result.put("data", page);
/*  82 */     result.put("page", new RdPage(page));
/*  83 */     result.put("code", Integer.valueOf(200));
/*  84 */     result.put("msg", "查询成功");
/*  85 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/statistic/incomeDetail.htm"})
/*     */   public void incomeDetail(HttpServletResponse response, @RequestParam("search") String search, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize)
/*     */     throws Exception
/*     */   {
/* 101 */     Map<String, Object> params = JSONObject.parseObject(search);
/* 102 */     Page<IncomeDetailModel> page = this.statisticManageService.incomeDetail(params, current, pageSize);
/* 103 */     Map<String, Object> result = new HashMap();
/* 104 */     Double incomeSum = this.statisticManageService.incomeSum(params);
/* 105 */     result.put("incomeSum", incomeSum);
/* 106 */     result.put("data", page);
/* 107 */     result.put("page", new RdPage(page));
/* 108 */     result.put("code", Integer.valueOf(200));
/* 109 */     result.put("msg", "查询成功");
/* 110 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/statistic/expendDetail.htm"})
/*     */   public void expendDetail(HttpServletResponse response, @RequestParam("search") String search, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize)
/*     */     throws Exception
/*     */   {
/* 126 */     Map<String, Object> params = JSONObject.parseObject(search);
/* 127 */     Page<ExpendDetailModel> page = this.statisticManageService.expendDetail(params, current, pageSize);
/* 128 */     Map<String, Object> result = new HashMap();
/* 129 */     Double expendSum = this.statisticManageService.expendSum(params);
/* 130 */     result.put("expendSum", expendSum);
/* 131 */     result.put("data", page);
/* 132 */     result.put("page", new RdPage(page));
/* 133 */     result.put("code", Integer.valueOf(200));
/* 134 */     result.put("msg", "查询成功");
/* 135 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\StatisticManageController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */