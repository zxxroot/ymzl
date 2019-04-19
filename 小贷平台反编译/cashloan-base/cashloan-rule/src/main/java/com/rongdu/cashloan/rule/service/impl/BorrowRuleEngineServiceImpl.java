/*     */ package com.rongdu.cashloan.rule.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.rule.domain.BorrowRuleConfig;
/*     */ import com.rongdu.cashloan.rule.domain.BorrowRuleEngine;
/*     */ import com.rongdu.cashloan.rule.mapper.BorrowRuleConfigMapper;
/*     */ import com.rongdu.cashloan.rule.mapper.BorrowRuleEngineMapper;
/*     */ import com.rongdu.cashloan.rule.service.BorrowRuleEngineService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ @Service("borrowRuleEngineService")
/*     */ public class BorrowRuleEngineServiceImpl
/*     */   extends BaseServiceImpl<BorrowRuleEngine, Long>
/*     */   implements BorrowRuleEngineService
/*     */ {
/*  50 */   private static final Logger logger = LoggerFactory.getLogger(BorrowRuleEngineServiceImpl.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private BorrowRuleEngineMapper borrowRuleEngineMapper;
/*     */   
/*     */   @Resource
/*     */   private BorrowRuleConfigMapper borrowRuleConfigMapper;
/*     */   
/*     */ 
/*     */   public BaseMapper<BorrowRuleEngine, Long> getMapper()
/*     */   {
/*  62 */     return this.borrowRuleEngineMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Page<BorrowRuleEngine> page(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  71 */     PageHelper.startPage(currentPage, pageSize);
/*  72 */     List<BorrowRuleEngine> list = this.borrowRuleEngineMapper.listSelective(params);
/*  73 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public int insert(BorrowRuleEngine bre)
/*     */   {
/*  78 */     return this.borrowRuleEngineMapper.save(bre);
/*     */   }
/*     */   
/*     */   public int updateSelective(Map<String, Object> params)
/*     */   {
/*  83 */     return this.borrowRuleEngineMapper.updateSelective(params);
/*     */   }
/*     */   
/*     */   public int deleteById(long id)
/*     */   {
/*  88 */     int i = this.borrowRuleEngineMapper.deleteById(id);
/*  89 */     Map<String, Object> params = new HashMap();
/*  90 */     params.put("borrowRuleId", Long.valueOf(id));
/*  91 */     i = this.borrowRuleConfigMapper.deleteByBorrowRuleId(params);
/*  92 */     return i;
/*     */   }
/*     */   
/*     */   public int update(BorrowRuleEngine bre)
/*     */   {
/*  97 */     Map<String, Object> params = new HashMap();
/*  98 */     params.put("id", bre.getId());
/*  99 */     params.put("adaptedId", bre.getAdaptedId());
/* 100 */     params.put("adaptedName", bre.getAdaptedName());
/* 101 */     params.put("borrowType", bre.getBorrowType());
/* 102 */     params.put("borrowTypeName", bre.getBorrowTypeName());
/* 103 */     return this.borrowRuleEngineMapper.updateSelective(params);
/*     */   }
/*     */   
/*     */   public int update(BorrowRuleEngine brc, List<BorrowRuleConfig> configlist)
/*     */   {
/* 108 */     brc.setAdaptedName(brc.getAdaptedNameById(brc.getAdaptedId()));
/* 109 */     int m = 0;
/* 110 */     brc.setRuleCount(Integer.valueOf(configlist != null ? configlist.size() : 0));
/* 111 */     if (brc.getId() != null) {
/* 112 */       Map<String, Object> params = new HashMap();
/* 113 */       params = changeObject(brc);
/* 114 */       m = this.borrowRuleEngineMapper.updateSelective(params);
/*     */     } else {
/* 116 */       brc.setAddTime(new Date());
/* 117 */       brc.setReqExt("");
/* 118 */       m = this.borrowRuleEngineMapper.save(brc);
/*     */     }
/* 120 */     if (configlist != null) {
/* 121 */       String ids = ";";
/* 122 */       Map<String, Object> params = new HashMap();
/* 123 */       params.put("borrowRuleId", brc.getId());
/* 124 */       List<BorrowRuleConfig> oldList = this.borrowRuleConfigMapper.listSelective(params);
/*     */       
/* 126 */       for (BorrowRuleConfig c : configlist) {
/* 127 */         if ((c.getId() != null) && (c.getId().longValue() != 0L)) {
/* 128 */           ids = ids + c.getId() + ";";
/* 129 */           params = new HashMap();
/* 130 */           params = changeObject(c);
/* 131 */           m = this.borrowRuleConfigMapper.updateSelective(params);
/*     */         } else {
/* 133 */           c.setBorrowRuleId(brc.getId());
/* 134 */           m = this.borrowRuleConfigMapper.save(c);
/*     */         }
/*     */       }
/*     */       
/* 138 */       if ((oldList != null) && (oldList.size() > 0)) {
/* 139 */         for (BorrowRuleConfig c : oldList) {
/* 140 */           if (!ids.contains(";" + String.valueOf(new StringBuilder().append(c.getId()).append(";").toString())))
/*     */           {
/* 142 */             this.borrowRuleConfigMapper.deleteById(c.getId());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 148 */       Map<String, Object> params = new HashMap();
/* 149 */       params.put("borrowRuleId", brc.getId());
/* 150 */       this.borrowRuleConfigMapper.deleteByBorrowRuleId(params);
/*     */     }
/* 152 */     return m;
/*     */   }
/*     */   
/*     */   public Map<String, Object> changeObject(Object c) {
/* 156 */     String str = JSONObject.toJSONString(c);
/* 157 */     Map<String, Object> params = (Map)JsonUtil.parse(str, Map.class);
/* 158 */     return params;
/*     */   }
/*     */ }
