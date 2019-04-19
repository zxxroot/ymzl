/*     */ package com.rongdu.cashloan.rule.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.rule.domain.RuleInfo;
/*     */ import com.rongdu.cashloan.rule.mapper.RuleInfoMapper;
/*     */ import com.rongdu.cashloan.rule.model.RuleInfoDetail;
/*     */ import com.rongdu.cashloan.rule.service.RuleInfoService;
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
/*     */ @Service("ruleInfoService")
/*     */ public class RuleInfoServiceImpl
/*     */   extends BaseServiceImpl<RuleInfo, Long>
/*     */   implements RuleInfoService
/*     */ {
/*  39 */   private static final Logger logger = LoggerFactory.getLogger(RuleInfoServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private RuleInfoMapper ruleInfoMapper;
/*     */   
/*     */   public BaseMapper<RuleInfo, Long> getMapper()
/*     */   {
/*  46 */     return this.ruleInfoMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RuleInfo> findAll(Map<String, Object> map)
/*     */   {
/*  54 */     return this.ruleInfoMapper.listSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Page<RuleInfo> ruleList(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  62 */     PageHelper.startPage(currentPage, pageSize);
/*  63 */     List<RuleInfo> list = this.ruleInfoMapper.listSelective(params);
/*  64 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean checkTable(List<RuleInfo> list, String table)
/*     */   {
/*  72 */     for (RuleInfo info : list) {
/*  73 */       if (info.getTbNid().equals(table)) {
/*  74 */         return true;
/*     */       }
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean checkColumn(List<RuleInfo> list, String table, String column)
/*     */   {
/*  85 */     for (RuleInfo info : list) {
/*  86 */       if (info.getTbNid().equals(table)) {
/*  87 */         List<RuleInfoDetail> rules = JSONArray.parseArray(info.getDetail(), RuleInfoDetail.class);
/*  88 */         for (RuleInfoDetail d : rules) {
/*  89 */           if (d.getNid().equals(column)) {
/*  90 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int modifyInfoState(Long id, String state)
/*     */   {
/* 103 */     Map<String, Object> paramMap = new HashMap();
/* 104 */     paramMap.put("id", id);
/* 105 */     paramMap.put("state", state);
/* 106 */     return this.ruleInfoMapper.updateSelective(paramMap);
/*     */   }
/*     */ }
