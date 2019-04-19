/*     */ package com.rongdu.cashloan.rule.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.rule.domain.RuleEngine;
import com.rongdu.cashloan.rule.domain.RuleEngineConfig;
import com.rongdu.cashloan.rule.domain.RuleEngineInfo;
import com.rongdu.cashloan.rule.mapper.RuleEngineConfigMapper;
import com.rongdu.cashloan.rule.mapper.RuleEngineInfoMapper;
import com.rongdu.cashloan.rule.mapper.RuleEngineMapper;
import com.rongdu.cashloan.rule.service.RuleEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.*;

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
/*     */ @Service("ruleEngineService")
/*     */ public class RuleEngineServiceImpl
/*     */   extends BaseServiceImpl<RuleEngine, Long>
/*     */   implements RuleEngineService
/*     */ {
/*  46 */   private static final Logger logger = LoggerFactory.getLogger(RuleEngineServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private RuleEngineConfigMapper ruleEngineConfigMapper;
/*     */   @Resource
/*     */   private RuleEngineMapper ruleEngineMapper;
/*     */   @Resource
/*     */   private RuleEngineInfoMapper ruleEngineInfoMapper;
/*     */   
/*     */   public BaseMapper<RuleEngine, Long> getMapper()
/*     */   {
/*  57 */     return this.ruleEngineMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Page<RuleEngine> findListByPage(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  65 */     PageHelper.startPage(currentPage, pageSize);
/*  66 */     List<RuleEngine> list = this.ruleEngineMapper.listByPage(params);
/*  67 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public int saveOrUpate(Map<String, Object> map)
/*     */   {
/*     */     int resCode;
/*  76 */     if (StringUtil.isNotBlank(map.get("id"))) {
/*  77 */       resCode = this.ruleEngineMapper.updateSelective(map);
/*     */     } else {
/*  79 */       RuleEngine engine = new RuleEngine();
/*  80 */       engine.setAddTime(new Date());
/*  81 */       engine.setAddIp(String.valueOf(map.get("addIp")));
/*  82 */       engine.setName(String.valueOf(map.get("name")));
/*  83 */       engine.setState(String.valueOf(map.get("state")));
/*  84 */       engine.setConfigCount((Integer)map.get("configCount"));
/*  85 */       resCode = this.ruleEngineMapper.save(engine);
/*     */     }
/*  87 */     return resCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public RuleEngine findById(Long id)
/*     */   {
/*  95 */     return (RuleEngine)this.ruleEngineMapper.findByPrimary(id);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int updateByRule(Map<String, Object> map)
/*     */   {
/* 103 */     Map<String, Object> paramMap = new HashMap();
/* 104 */     paramMap.put("ruleEnginId", map.get("id"));
/* 105 */     paramMap.put("state", map.get("state"));
/* 106 */     this.ruleEngineConfigMapper.updateByRuleEnginId(paramMap);
/*     */     
/* 108 */     return this.ruleEngineMapper.updateSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RuleEngine> selectList(Map<String, Object> params)
/*     */   {
/* 116 */     return this.ruleEngineMapper.listSelective(params);
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> findAllRule(Map<String, Object> params)
/*     */   {
/* 121 */     List<Map<String, Object>> list = new ArrayList();
/* 122 */     List<RuleEngine> allRule = this.ruleEngineMapper.listSelective(params);
/* 123 */     for (RuleEngine rule : allRule) {
/* 124 */       Map<String, Object> search = new HashMap();
/* 125 */       search.put("ruleEnginId", rule.getId());
/* 126 */       List<RuleEngineConfig> configs = this.ruleEngineConfigMapper.listSelective(search);
/* 127 */       List<RuleEngineInfo> reulst = this.ruleEngineInfoMapper.listSelective(search);
/* 128 */       Map<String, Object> map = new HashMap();
/* 129 */       map.put("rule", rule);
/* 130 */       map.put("configList", configs);
/* 131 */       map.put("infoList", reulst);
/*     */       
/* 133 */       list.add(map);
/*     */     }
/* 135 */     return list;
/*     */   }
/*     */ }
