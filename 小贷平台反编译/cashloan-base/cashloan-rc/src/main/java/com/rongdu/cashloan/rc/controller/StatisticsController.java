/*     */ package com.rongdu.cashloan.rc.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rc.domain.Statistics;
/*     */ import com.rongdu.cashloan.rc.service.StatisticsService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
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
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class StatisticsController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private StatisticsService statisticsService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/rc/statistics/page.htm"})
/*     */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  51 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  52 */     Page<Statistics> page = this.statisticsService.page(params, currentPage, pageSize);
/*  53 */     Map<String, Object> result = new HashMap();
/*  54 */     result.put("data", page);
/*  55 */     result.put("page", new RdPage(page));
/*  56 */     result.put("code", Integer.valueOf(200));
/*  57 */     result.put("msg", "获取成功");
/*  58 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/statistics/listAll.htm"})
/*     */   public void listAll()
/*     */   {
/*  66 */     List<Statistics> list = this.statisticsService.listAll();
/*     */     
/*  68 */     Map<String, Object> result = new HashMap();
/*  69 */     result.put("data", list);
/*  70 */     result.put("code", Integer.valueOf(200));
/*  71 */     result.put("msg", "获取成功");
/*  72 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/statistics/save.htm"})
/*     */   public void save(Statistics statistics)
/*     */   {
/*  81 */     statistics.setAddTime(new Date());
/*  82 */     statistics.setState("10");
/*  83 */     int flag = this.statisticsService.insert(statistics);
/*     */     
/*  85 */     Map<String, Object> result = new HashMap();
/*  86 */     if (flag > 0) {
/*  87 */       result.put("code", Integer.valueOf(200));
/*  88 */       result.put("msg", "操作成功");
/*     */     } else {
/*  90 */       result.put("code", Integer.valueOf(400));
/*  91 */       result.put("msg", "操作失败");
/*     */     }
/*  93 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/statistics/update.htm"})
/*     */   public void update(Statistics statistics)
/*     */   {
/* 103 */     int flag = this.statisticsService.updateById(statistics);
/*     */     
/* 105 */     Map<String, Object> result = new HashMap();
/* 106 */     if (flag > 0) {
/* 107 */       result.put("code", Integer.valueOf(200));
/* 108 */       result.put("msg", "操作成功");
/*     */     } else {
/* 110 */       result.put("code", Integer.valueOf(400));
/* 111 */       result.put("msg", "操作失败");
/*     */     }
/* 113 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/statistics/enalbe.htm"})
/*     */   public void enalbe(@RequestParam("id") Long id)
/*     */   {
/* 122 */     Statistics statistics = (Statistics)this.statisticsService.getById(id);
/* 123 */     statistics.setState("10");
/* 124 */     int flag = this.statisticsService.updateById(statistics);
/*     */     
/* 126 */     Map<String, Object> result = new HashMap();
/* 127 */     if (flag > 0) {
/* 128 */       result.put("code", Integer.valueOf(200));
/* 129 */       result.put("msg", "操作成功");
/*     */     } else {
/* 131 */       result.put("code", Integer.valueOf(400));
/* 132 */       result.put("msg", "操作失败");
/*     */     }
/* 134 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/statistics/disable.htm"})
/*     */   public void disable(@RequestParam("id") Long id)
/*     */   {
/* 143 */     Statistics statistics = (Statistics)this.statisticsService.getById(id);
/* 144 */     statistics.setState("20");
/* 145 */     int flag = this.statisticsService.updateById(statistics);
/*     */     
/* 147 */     Map<String, Object> result = new HashMap();
/* 148 */     if (flag > 0) {
/* 149 */       result.put("code", Integer.valueOf(200));
/* 150 */       result.put("msg", "操作成功");
/*     */     } else {
/* 152 */       result.put("code", Integer.valueOf(400));
/* 153 */       result.put("msg", "操作失败");
/*     */     }
/* 155 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
