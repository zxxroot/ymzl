/*     */ package com.rongdu.cashloan.rule.controller;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rule.domain.RuleEngine;
/*     */ import com.rongdu.cashloan.rule.domain.RuleEngineConfig;
/*     */ import com.rongdu.cashloan.rule.domain.RuleEngineInfo;
/*     */ import com.rongdu.cashloan.rule.service.RuleEngineConfigService;
/*     */ import com.rongdu.cashloan.rule.service.RuleEngineInfoService;
/*     */ import com.rongdu.cashloan.rule.service.RuleEngineService;
/*     */ import com.rongdu.cashloan.rule.service.RuleInfoService;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
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
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class RuleEngineConfigController
/*     */   extends BaseController
/*     */ {
/*  46 */   private static final Logger logger = LoggerFactory.getLogger(RuleEngineConfigController.class);
/*     */   
/*     */   @Resource
/*     */   private RuleEngineConfigService ruleEngineConfigService;
/*     */   
/*     */   @Resource
/*     */   private RuleEngineService ruleEngineService;
/*     */   @Resource
/*     */   private RuleInfoService ruleInfoService;
/*     */   @Resource
/*     */   private RuleEngineInfoService ruleEngineInfoService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/rule/findTable.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:findTable", name="查询规则引擎表信息")
/*     */   public void findByTable()
/*     */   {
/*  62 */     Map<String, Object> map = new HashMap();
/*  63 */     map.put("state", "10");
/*  64 */     List<Map<String, Object>> data = this.ruleEngineConfigService.findAllInfo(map);
/*  65 */     Map<String, Object> result = new HashMap();
/*  66 */     result.put("data", data);
/*  67 */     result.put("code", Integer.valueOf(200));
/*  68 */     result.put("msg", "成功");
/*  69 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/getRuleConfig.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:getRuleConfig", name="查询规则详细信息")
/*     */   public void getConfig(@RequestParam("id") Long id)
/*     */   {
/*  78 */     RuleEngine rule = this.ruleEngineService.findById(id);
/*     */     
/*  80 */     Map<String, Object> search = new HashMap();
/*  81 */     search.put("ruleEnginId", id);
/*  82 */     List<RuleEngineConfig> configs = this.ruleEngineConfigService.findByMap(search);
/*  83 */     List<RuleEngineInfo> reulst = this.ruleEngineInfoService.findByMap(search);
/*  84 */     Map<String, Object> map = new HashMap();
/*  85 */     map.put("rule", rule);
/*  86 */     map.put("configList", configs);
/*  87 */     map.put("infoList", reulst);
/*  88 */     Map<String, Object> result = new HashMap();
/*  89 */     result.put("data", map);
/*  90 */     result.put("code", Integer.valueOf(200));
/*  91 */     result.put("msg", "成功");
/*  92 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/rule/saveRuleConfig.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:saveRuleConfig", name="编辑规则设置信息")
/*     */   public void saveRuleConfig(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("type") String type, @RequestParam(value="id", required=false) Long id, @RequestParam("configList") String configList, @RequestParam(value="infoList", required=false) String infoList)
/*     */   {
/* 107 */     List list = (List)JsonUtil.parse(configList, List.class);
/* 108 */     Map<String, Object> rule = new HashMap();
/* 109 */     if (StringUtil.isNotBlank(id)) {
/* 110 */       rule.put("id", id);
/*     */     }
/* 112 */     rule.put("name", name);
/* 113 */     rule.put("type", type);
/*     */     
/* 115 */     int resCode = this.ruleEngineConfigService.saveOrUpate(rule, list, infoList, request);
/* 116 */     Map<String, Object> result = new HashMap();
/* 117 */     if (resCode > 0) {
/* 118 */       result.put("code", Integer.valueOf(200));
/* 119 */       result.put("msg", "成功");
/*     */     } else {
/* 121 */       result.put("code", Integer.valueOf(400));
/* 122 */       result.put("msg", "失败");
/*     */     }
/* 124 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\controller\RuleEngineConfigController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */