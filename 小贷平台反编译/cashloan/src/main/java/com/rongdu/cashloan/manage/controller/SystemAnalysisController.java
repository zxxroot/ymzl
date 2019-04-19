/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.model.OverdueAnalisisModel;
/*     */ import com.rongdu.cashloan.cl.model.RepayAnalisisModel;
/*     */ import com.rongdu.cashloan.cl.service.SystemAnalysisService;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
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
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class SystemAnalysisController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private SystemAnalysisService systemAnalysisService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/sysanalysis/dayRepay.htm"})
/*     */   public void dayRepay(HttpServletResponse response, @RequestParam("search") String search)
/*     */     throws Exception
/*     */   {
/*  53 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  54 */     List<RepayAnalisisModel> list = this.systemAnalysisService.dayRepayAnalisis(params);
/*  55 */     Map<String, Object> result = new HashMap();
/*  56 */     result.put("data", list);
/*  57 */     result.put("code", Integer.valueOf(200));
/*  58 */     result.put("msg", "查询成功");
/*  59 */     ServletUtils.writeToResponse(response, result);
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
/*     */   @RequestMapping({"/modules/manage/sysanalysis/monthRepay.htm"})
/*     */   public void monthRepay(HttpServletResponse response, @RequestParam("search") String search)
/*     */     throws Exception
/*     */   {
/*  74 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  75 */     List<RepayAnalisisModel> list = this.systemAnalysisService.monthRepayAnalisis(params);
/*  76 */     Map<String, Object> result = new HashMap();
/*  77 */     result.put("data", list);
/*  78 */     result.put("code", Integer.valueOf(200));
/*  79 */     result.put("msg", "查询成功");
/*  80 */     ServletUtils.writeToResponse(response, result);
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
/*     */   @RequestMapping({"/modules/manage/sysanalysis/overdue.htm"})
/*     */   public void overdue(HttpServletResponse response, @RequestParam("search") String search, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize)
/*     */     throws Exception
/*     */   {
/*  96 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  97 */     Page<OverdueAnalisisModel> page = this.systemAnalysisService.overdueAnalisis(params, current, pageSize);
/*  98 */     Map<String, Object> result = new HashMap();
/*  99 */     result.put("data", page);
/* 100 */     result.put("page", new RdPage(page));
/* 101 */     result.put("code", Integer.valueOf(200));
/* 102 */     result.put("msg", "查询成功");
/* 103 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SystemAnalysisController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */