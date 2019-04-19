/*     */ package com.rongdu.cashloan.rc.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.rc.domain.SceneBusiness;
/*     */ import com.rongdu.cashloan.rc.mapper.SceneBusinessMapper;
/*     */ import com.rongdu.cashloan.rc.model.ManageSceneBusinessModel;
/*     */ import com.rongdu.cashloan.rc.service.SceneBusinessService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.DateUtil;
/*     */ import tool.util.StringUtil;
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
/*     */ @Service("sceneBusinessService")
/*     */ public class SceneBusinessServiceImpl
/*     */   extends BaseServiceImpl<SceneBusiness, Long>
/*     */   implements SceneBusinessService
/*     */ {
/*     */   @Resource
/*     */   private SceneBusinessMapper sceneBusinessMapper;
/*     */   
/*     */   public BaseMapper<SceneBusiness, Long> getMapper()
/*     */   {
/*  43 */     return this.sceneBusinessMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageSceneBusinessModel> page(Map<String, Object> paramMap, int current, int pageSize)
/*     */   {
/*  49 */     PageHelper.startPage(current, pageSize);
/*  50 */     Page<ManageSceneBusinessModel> page = (Page)this.sceneBusinessMapper.list(paramMap);
/*  51 */     return page;
/*     */   }
/*     */   
/*     */   public boolean save(SceneBusiness sceneBusiness)
/*     */   {
/*  56 */     sceneBusiness.setState("10");
/*  57 */     sceneBusiness.setAddTime(DateUtil.getNow());
/*     */     
/*  59 */     int result = this.sceneBusinessMapper.save(sceneBusiness);
/*  60 */     if (result > 0L) {
/*  61 */       return true;
/*     */     }
/*  63 */     return false;
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
/*     */ 
/*     */ 
/*     */   public boolean update(SceneBusiness sceneBusiness)
/*     */   {
/*  79 */     int result = this.sceneBusinessMapper.update(sceneBusiness);
/*  80 */     if (result > 0L) {
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public boolean enable(Long id)
/*     */   {
/*  88 */     Map<String, Object> paramMap = new HashMap();
/*  89 */     paramMap.put("id", id);
/*  90 */     paramMap.put("state", "10");
/*  91 */     int result = this.sceneBusinessMapper.updateSelective(paramMap);
/*  92 */     if (result > 0L) {
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public boolean disable(Long id)
/*     */   {
/* 100 */     Map<String, Object> paramMap = new HashMap();
/* 101 */     paramMap.put("id", id);
/* 102 */     paramMap.put("state", "20");
/* 103 */     int result = this.sceneBusinessMapper.updateSelective(paramMap);
/* 104 */     if (result > 0L) {
/* 105 */       return true;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   public boolean validExist(String scene, Long businessId, String type)
/*     */   {
/* 112 */     if ((StringUtil.isNotBlank(scene)) && (StringUtil.isNotBlank(type)) && (businessId != null) && (businessId.longValue() > 0L)) {
/* 113 */       Map<String, Object> params = new HashMap();
/* 114 */       params.put("scene", scene);
/* 115 */       params.put("businessId", businessId);
/* 116 */       params.put("type", type);
/* 117 */       List<SceneBusiness> business = this.sceneBusinessMapper.listSelective(params);
/* 118 */       if (business.size() > 0) {
/* 119 */         return true;
/*     */       }
/*     */     } else {
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     return false;
/*     */   }
/*     */ }
