/*     */ package com.rongdu.cashloan.rc.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rc.domain.SceneBusiness;
/*     */ import com.rongdu.cashloan.rc.model.ManageSceneBusinessModel;
/*     */ import com.rongdu.cashloan.rc.service.SceneBusinessService;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class SceneBusinessController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private SceneBusinessService sceneBusinessService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/credit/sceneBusiness/page.htm"})
/*     */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  52 */     Map<String, Object> params = JSONObject.parseObject(search);
/*  53 */     Page<ManageSceneBusinessModel> page = this.sceneBusinessService.page(params, currentPage, pageSize);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/sceneBusiness/save.htm"})
/*     */   public void save(SceneBusiness sceneBusiness)
/*     */   {
/*  71 */     Map<String, Object> result = new HashMap();
/*     */     
/*     */ 
/*  74 */     boolean flag = this.sceneBusinessService.validExist(sceneBusiness.getScene(), sceneBusiness.getBusinessId(), sceneBusiness.getType());
/*  75 */     if (flag) {
/*  76 */       result.put("code", Integer.valueOf(200));
/*  77 */       result.put("msg", "场景接口关联关系已经存在");
/*  78 */       ServletUtils.writeToResponse(this.response, result);
/*  79 */       return;
/*     */     }
/*  81 */     flag = this.sceneBusinessService.save(sceneBusiness);
/*     */     
/*     */ 
/*  84 */     if (flag) {
/*  85 */       result.put("code", Integer.valueOf(200));
/*  86 */       result.put("msg", "操作成功");
/*     */     } else {
/*  88 */       result.put("code", Integer.valueOf(400));
/*  89 */       result.put("msg", "操作失败");
/*     */     }
/*  91 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/sceneBusiness/update.htm"})
/*     */   public void update(SceneBusiness sceneBusiness)
/*     */   {
/* 103 */     boolean flag = this.sceneBusinessService.update(sceneBusiness);
/*     */     
/* 105 */     Map<String, Object> result = new HashMap();
/* 106 */     if (flag)
/*     */     {
/* 108 */       result.put("code", Integer.valueOf(200));
/* 109 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/* 112 */       result.put("code", Integer.valueOf(400));
/* 113 */       result.put("msg", "操作失败");
/*     */     }
/* 115 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/credit/sceneBusiness/enable.htm"})
/*     */   public void enable(@RequestParam("id") Long id)
/*     */   {
/* 130 */     boolean flag = this.sceneBusinessService.enable(id);
/* 131 */     Map<String, Object> result = new HashMap();
/* 132 */     if (flag)
/*     */     {
/* 134 */       result.put("code", Integer.valueOf(200));
/* 135 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/* 138 */       result.put("code", Integer.valueOf(400));
/* 139 */       result.put("msg", "操作失败");
/*     */     }
/* 141 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/sceneBusiness/disable.htm"})
/*     */   public void disable(@RequestParam("id") Long id)
/*     */   {
/* 153 */     boolean flag = this.sceneBusinessService.disable(id);
/*     */     
/* 155 */     Map<String, Object> result = new HashMap();
/* 156 */     if (flag)
/*     */     {
/* 158 */       result.put("code", Integer.valueOf(200));
/* 159 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/* 162 */       result.put("code", Integer.valueOf(400));
/* 163 */       result.put("msg", "操作失败");
/*     */     }
/* 165 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
