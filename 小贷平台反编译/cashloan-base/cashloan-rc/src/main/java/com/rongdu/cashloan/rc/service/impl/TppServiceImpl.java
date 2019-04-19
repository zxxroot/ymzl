/*     */ package com.rongdu.cashloan.rc.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.rc.domain.Tpp;
/*     */ import com.rongdu.cashloan.rc.mapper.TppMapper;
/*     */ import com.rongdu.cashloan.rc.model.ManageTppModel;
/*     */ import com.rongdu.cashloan.rc.model.TppModel;
/*     */ import com.rongdu.cashloan.rc.service.TppService;
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
/*     */ @Service("tppService")
/*     */ public class TppServiceImpl
/*     */   extends BaseServiceImpl<Tpp, Long>
/*     */   implements TppService
/*     */ {
/*     */   @Resource
/*     */   private TppMapper tppMapper;
/*     */   
/*     */   public BaseMapper<Tpp, Long> getMapper()
/*     */   {
/*  42 */     return this.tppMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageTppModel> page(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  48 */     PageHelper.startPage(currentPage, pageSize);
/*  49 */     Page<ManageTppModel> page = (Page)this.tppMapper.list(params);
/*  50 */     return page;
/*     */   }
/*     */   
/*     */   public List<TppModel> listAll()
/*     */   {
/*  55 */     return this.tppMapper.listAll();
/*     */   }
/*     */   
/*     */   public List<TppModel> listAllWithBusiness()
/*     */   {
/*  60 */     return this.tppMapper.listAllWithBusiness();
/*     */   }
/*     */   
/*     */   public boolean save(Tpp tpp)
/*     */   {
/*  65 */     tpp.setState("10");
/*  66 */     tpp.setAddTime(DateUtil.getNow());
/*     */     
/*  68 */     int result = this.tppMapper.save(tpp);
/*  69 */     if (result > 0L) {
/*  70 */       return true;
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public boolean update(Tpp tpp)
/*     */   {
/*  77 */     Map<String, Object> paramMap = new HashMap();
/*  78 */     paramMap.put("id", tpp.getId());
/*  79 */     paramMap.put("name", tpp.getName());
/*  80 */     paramMap.put("signType", tpp.getSignType());
/*  81 */     paramMap.put("key", tpp.getKey());
/*  82 */     paramMap.put("extend", tpp.getExtend());
/*  83 */     paramMap.put("merNo", tpp.getMerNo());
/*  84 */     paramMap.put("nid", tpp.getNid());
/*  85 */     int result = this.tppMapper.updateSelective(paramMap);
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
/*  97 */     int result = this.tppMapper.updateSelective(paramMap);
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
/* 109 */     int result = this.tppMapper.updateSelective(paramMap);
/* 110 */     if (result > 0L) {
/* 111 */       return true;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */ }
