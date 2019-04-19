/*     */ package com.rongdu.cashloan.rc.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rc.domain.Tpp;
/*     */ import com.rongdu.cashloan.rc.model.ManageTppModel;
/*     */ import com.rongdu.cashloan.rc.model.TppModel;
/*     */ import com.rongdu.cashloan.rc.service.TppService;
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
/*     */ public class TppController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private TppService tppService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/credit/tpp/page.htm"})
/*     */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  53 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  54 */     Page<ManageTppModel> page = this.tppService.page(params, currentPage, pageSize);
/*  55 */     Map<String, Object> result = new HashMap();
/*  56 */     result.put("data", page);
/*  57 */     result.put("page", new RdPage(page));
/*  58 */     result.put("code", Integer.valueOf(200));
/*  59 */     result.put("msg", "获取成功");
/*  60 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tpp/listAll.htm"})
/*     */   public void listAll()
/*     */   {
/*  68 */     Map<String, Object> result = new HashMap();
/*  69 */     List<TppModel> list = this.tppService.listAllWithBusiness();
/*     */     
/*  71 */     result.put("data", list);
/*  72 */     result.put("code", Integer.valueOf(200));
/*  73 */     result.put("msg", "获取成功");
/*  74 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tpp/save.htm"})
/*     */   public void save(Tpp tpp)
/*     */   {
/*  84 */     boolean flag = this.tppService.save(tpp);
/*     */     
/*  86 */     Map<String, Object> result = new HashMap();
/*  87 */     if (flag) {
/*  88 */       result.put("code", Integer.valueOf(200));
/*  89 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/*  92 */       result.put("code", Integer.valueOf(400));
/*  93 */       result.put("msg", "操作失败");
/*     */     }
/*  95 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tpp/update.htm"})
/*     */   public void update(Tpp tpp)
/*     */   {
/* 108 */     boolean flag = this.tppService.update(tpp);
/*     */     
/* 110 */     Map<String, Object> result = new HashMap();
/* 111 */     if (flag)
/*     */     {
/* 113 */       result.put("code", Integer.valueOf(200));
/* 114 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/* 117 */       result.put("code", Integer.valueOf(400));
/* 118 */       result.put("msg", "操作失败");
/*     */     }
/* 120 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tpp/enalbe.htm"})
/*     */   public void enalbe(@RequestParam("id") Long id)
/*     */   {
/* 132 */     boolean flag = this.tppService.enable(id);
/* 133 */     Map<String, Object> result = new HashMap();
/* 134 */     if (flag)
/*     */     {
/* 136 */       result.put("code", Integer.valueOf(200));
/* 137 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/* 140 */       result.put("code", Integer.valueOf(400));
/* 141 */       result.put("msg", "操作失败");
/*     */     }
/* 143 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tpp/disable.htm"})
/*     */   public void disable(@RequestParam("id") Long id)
/*     */   {
/* 155 */     boolean flag = this.tppService.disable(id);
/*     */     
/* 157 */     Map<String, Object> result = new HashMap();
/* 158 */     if (flag)
/*     */     {
/* 160 */       result.put("code", Integer.valueOf(200));
/* 161 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/* 164 */       result.put("code", Integer.valueOf(400));
/* 165 */       result.put("msg", "操作失败");
/*     */     }
/* 167 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
