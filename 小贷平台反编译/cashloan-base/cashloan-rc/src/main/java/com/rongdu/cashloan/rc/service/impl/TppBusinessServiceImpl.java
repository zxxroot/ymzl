/*     */ package com.rongdu.cashloan.rc.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*     */ import com.rongdu.cashloan.rc.mapper.TppBusinessMapper;
/*     */ import com.rongdu.cashloan.rc.model.ManageTppBusinessModel;
/*     */ import com.rongdu.cashloan.rc.model.TppBusinessModel;
/*     */ import com.rongdu.cashloan.rc.service.TppBusinessService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.DateUtil;
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
/*     */ @Service("tppBusinessService")
/*     */ public class TppBusinessServiceImpl
/*     */   extends BaseServiceImpl<TppBusiness, Long>
/*     */   implements TppBusinessService
/*     */ {
/*     */   @Resource
/*     */   private TppBusinessMapper tppBusinessMapper;
/*     */   
/*     */   public BaseMapper<TppBusiness, Long> getMapper()
/*     */   {
/*  43 */     return this.tppBusinessMapper;
/*     */   }
/*     */   
/*     */   public List<TppBusinessModel> listAll()
/*     */   {
/*  48 */     return this.tppBusinessMapper.listAll();
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageTppBusinessModel> page(Map<String, Object> paramMap, int current, int pageSize)
/*     */   {
/*  54 */     PageHelper.startPage(current, pageSize);
/*  55 */     Page<ManageTppBusinessModel> page = (Page)this.tppBusinessMapper.list(paramMap);
/*  56 */     return page;
/*     */   }
/*     */   
/*     */   public List<TppBusiness> listSelective(Map<String, Object> paramMap)
/*     */   {
/*  61 */     return this.tppBusinessMapper.listSelective(paramMap);
/*     */   }
/*     */   
/*     */   public boolean save(TppBusiness tppBusiness)
/*     */   {
/*  66 */     tppBusiness.setState("10");
/*  67 */     tppBusiness.setAddTime(DateUtil.getNow());
/*     */     
/*  69 */     int result = this.tppBusinessMapper.save(tppBusiness);
/*  70 */     if (result > 0L) {
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public boolean update(TppBusiness tppBusiness)
/*     */   {
/*  78 */     Map<String, Object> paramMap = new HashMap();
/*  79 */     paramMap.put("id", tppBusiness.getId());
/*  80 */     paramMap.put("nid", tppBusiness.getNid());
/*  81 */     paramMap.put("name", tppBusiness.getName());
/*  82 */     paramMap.put("url", tppBusiness.getUrl());
/*  83 */     paramMap.put("testUrl", tppBusiness.getTestUrl());
/*  84 */     paramMap.put("extend", tppBusiness.getExtend());
/*  85 */     int result = this.tppBusinessMapper.updateSelective(paramMap);
/*  86 */     if (result > 0L) {
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public boolean enable(Long id)
/*     */   {
/*  94 */     Map<String, Object> paramMap = new HashMap();
/*  95 */     paramMap.put("id", id);
/*  96 */     paramMap.put("state", "10");
/*  97 */     int result = this.tppBusinessMapper.updateSelective(paramMap);
/*  98 */     if (result > 0L) {
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public boolean disable(Long id)
/*     */   {
/* 106 */     Map<String, Object> paramMap = new HashMap();
/* 107 */     paramMap.put("id", id);
/* 108 */     paramMap.put("state", "20");
/* 109 */     int result = this.tppBusinessMapper.updateSelective(paramMap);
/* 110 */     if (result > 0L) {
/* 111 */       return true;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */   
/*     */   public boolean tppBusinessExist(TppBusiness business)
/*     */   {
/* 118 */     TppBusiness rtTppBusi = this.tppBusinessMapper.findByNid(business.getNid(), business.getTppId());
/* 119 */     if (rtTppBusi != null) {
/* 120 */       return true;
/*     */     }
/* 122 */     return false;
/*     */   }
/*     */   
/*     */   public TppBusiness findByNid(String nid, Long tppId)
/*     */   {
/* 127 */     return this.tppBusinessMapper.findByNid(nid, tppId);
/*     */   }
/*     */ }
