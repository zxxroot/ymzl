/*     */ package com.rongdu.cashloan.rc.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*     */ import com.rongdu.cashloan.rc.model.ManageTppBusinessModel;
/*     */ import com.rongdu.cashloan.rc.service.TppBusinessService;
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
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class TppBusinessController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private TppBusinessService tppBusinessService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/credit/tppBusiness/page.htm"})
/*     */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  53 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  54 */     Page<ManageTppBusinessModel> page = this.tppBusinessService.page(params, currentPage, 
/*  55 */       pageSize);
/*  56 */     Map<String, Object> result = new HashMap();
/*  57 */     result.put("data", page);
/*  58 */     result.put("page", new RdPage(page));
/*  59 */     result.put("code", Integer.valueOf(200));
/*  60 */     result.put("msg", "获取成功");
/*  61 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tppBusiness/listByTppId.htm"})
/*     */   public void listByTppId(@RequestParam("tppId") Long tppId)
/*     */   {
/*  71 */     Map<String, Object> paramMap = new HashMap();
/*  72 */     paramMap.put("tppId", tppId);
/*  73 */     List<TppBusiness> list = this.tppBusinessService.listSelective(paramMap);
/*     */     
/*  75 */     Map<String, Object> result = new HashMap();
/*  76 */     result.put("data", list);
/*  77 */     result.put("code", Integer.valueOf(200));
/*  78 */     result.put("msg", "获取成功");
/*  79 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tppBusiness/save.htm"})
/*     */   public void save(TppBusiness tppBusiness)
/*     */   {
/*  90 */     Map<String, Object> result = new HashMap();
/*     */     
/*     */ 
/*  93 */     boolean flag = this.tppBusinessService.tppBusinessExist(tppBusiness);
/*  94 */     if (flag)
/*     */     {
/*  96 */       result.put("code", Integer.valueOf(200));
/*  97 */       result.put("msg", "接口简称重复");
/*  98 */       ServletUtils.writeToResponse(this.response, result);
/*  99 */       return;
/*     */     }
/* 101 */     flag = this.tppBusinessService.save(tppBusiness);
/*     */     
/*     */ 
/* 104 */     if (flag) {
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
/*     */   @RequestMapping({"/modules/manage/credit/tppBusiness/update.htm"})
/*     */   public void update(TppBusiness tppBusiness)
/*     */   {
/* 123 */     boolean flag = this.tppBusinessService.update(tppBusiness);
/*     */     
/* 125 */     Map<String, Object> result = new HashMap();
/* 126 */     if (flag)
/*     */     {
/* 128 */       result.put("code", Integer.valueOf(200));
/* 129 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/* 132 */       result.put("code", Integer.valueOf(400));
/* 133 */       result.put("msg", "操作失败");
/*     */     }
/* 135 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tppBusiness/enable.htm"})
/*     */   public void enable(@RequestParam("id") Long id)
/*     */   {
/* 147 */     boolean flag = this.tppBusinessService.enable(id);
/*     */     
/* 149 */     Map<String, Object> result = new HashMap();
/* 150 */     if (flag) {
/* 151 */       result.put("code", Integer.valueOf(200));
/* 152 */       result.put("msg", "操作成功");
/*     */     } else {
/* 154 */       result.put("code", Integer.valueOf(400));
/* 155 */       result.put("msg", "操作失败");
/*     */     }
/* 157 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/tppBusiness/disable.htm"})
/*     */   public void disable(@RequestParam("id") Long id)
/*     */   {
/* 169 */     boolean flag = this.tppBusinessService.disable(id);
/*     */     
/* 171 */     Map<String, Object> result = new HashMap();
/* 172 */     if (flag) {
/* 173 */       result.put("code", Integer.valueOf(200));
/* 174 */       result.put("msg", "操作成功");
/*     */     } else {
/* 176 */       result.put("code", Integer.valueOf(400));
/* 177 */       result.put("msg", "操作失败");
/*     */     }
/* 179 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
