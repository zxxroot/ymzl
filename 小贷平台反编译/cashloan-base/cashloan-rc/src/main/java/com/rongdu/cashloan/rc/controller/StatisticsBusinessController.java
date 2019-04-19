/*     */ package com.rongdu.cashloan.rc.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rc.domain.StatisticsBusiness;
/*     */ import com.rongdu.cashloan.rc.service.StatisticsBusinessService;
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
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class StatisticsBusinessController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private StatisticsBusinessService statisticsBusinessService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/rc/business/page.htm"})
/*     */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  52 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  53 */     Page<StatisticsBusiness> page = this.statisticsBusinessService.page(params, currentPage, pageSize);
/*  54 */     Map<String, Object> result = new HashMap();
/*  55 */     result.put("data", page);
/*  56 */     result.put("page", new RdPage(page));
/*  57 */     result.put("code", Integer.valueOf(200));
/*  58 */     result.put("msg", "获取成功");
/*  59 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/databusiness/listByDataId.htm"})
/*     */   public void listByDataId(@RequestParam("statisticsId") Long statisticsId)
/*     */   {
/*  68 */     Map<String, Object> paramMap = new HashMap();
/*  69 */     paramMap.put("statisticsId", statisticsId);
/*  70 */     List<StatisticsBusiness> list = this.statisticsBusinessService.listSelective(paramMap);
/*     */     
/*  72 */     Map<String, Object> result = new HashMap();
/*  73 */     result.put("data", list);
/*  74 */     result.put("code", Integer.valueOf(200));
/*  75 */     result.put("msg", "获取成功");
/*  76 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/business/save.htm"})
/*     */   public void save(StatisticsBusiness statisticsBusiness)
/*     */   {
/*  86 */     Map<String, Object> result = new HashMap();
/*     */     
/*     */ 
/*  89 */     boolean flag = false;
/*  90 */     int i = 0;
/*  91 */     if (flag) {
/*  92 */       flag = false;
/*  93 */       result.put("code", Integer.valueOf(200));
/*  94 */       result.put("msg", "接口简称重复");
/*  95 */       ServletUtils.writeToResponse(this.response, result);
/*  96 */       return;
/*     */     }
/*  98 */     flag = true;
/*  99 */     statisticsBusiness.setState("10");
/* 100 */     statisticsBusiness.setAddTime(new Date());
/* 101 */     i = this.statisticsBusinessService.insert(statisticsBusiness);
/*     */     
/*     */ 
/* 104 */     if (i > 0) {
/* 105 */       result.put("code", Integer.valueOf(200));
/* 106 */       result.put("msg", "操作成功");
/*     */     } else {
/* 108 */       result.put("code", Integer.valueOf(400));
/* 109 */       result.put("msg", "操作失败");
/*     */     }
/* 111 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/business/update.htm"})
/*     */   public void update(StatisticsBusiness statisticsBusiness)
/*     */   {
/* 123 */     int i = this.statisticsBusinessService.updateById(statisticsBusiness);
/*     */     
/* 125 */     Map<String, Object> result = new HashMap();
/* 126 */     if (i > 0) {
/* 127 */       result.put("code", Integer.valueOf(200));
/* 128 */       result.put("msg", "操作成功");
/*     */     } else {
/* 130 */       result.put("code", Integer.valueOf(400));
/* 131 */       result.put("msg", "操作失败");
/*     */     }
/* 133 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/business/enable.htm"})
/*     */   public void enable(@RequestParam("id") Long id)
/*     */   {
/* 144 */     StatisticsBusiness statisticsBusiness = (StatisticsBusiness)this.statisticsBusinessService.getById(id);
/* 145 */     statisticsBusiness.setState("10");
/* 146 */     int i = this.statisticsBusinessService.updateById(statisticsBusiness);
/*     */     
/* 148 */     Map<String, Object> result = new HashMap();
/* 149 */     if (i > 0) {
/* 150 */       result.put("code", Integer.valueOf(200));
/* 151 */       result.put("msg", "操作成功");
/*     */     } else {
/* 153 */       result.put("code", Integer.valueOf(400));
/* 154 */       result.put("msg", "操作失败");
/*     */     }
/* 156 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rc/business/disable.htm"})
/*     */   public void disable(@RequestParam("id") Long id)
/*     */   {
/* 168 */     StatisticsBusiness statisticsBusiness = (StatisticsBusiness)this.statisticsBusinessService.getById(id);
/* 169 */     statisticsBusiness.setState("20");
/* 170 */     int i = this.statisticsBusinessService.updateById(statisticsBusiness);
/*     */     
/* 172 */     Map<String, Object> result = new HashMap();
/* 173 */     if (i > 0) {
/* 174 */       result.put("code", Integer.valueOf(200));
/* 175 */       result.put("msg", "操作成功");
/*     */     } else {
/* 177 */       result.put("code", Integer.valueOf(400));
/* 178 */       result.put("msg", "操作失败");
/*     */     }
/* 180 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
