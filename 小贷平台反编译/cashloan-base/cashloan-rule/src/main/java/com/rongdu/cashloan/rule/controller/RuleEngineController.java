/*     */ package com.rongdu.cashloan.rule.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rule.domain.BorrowRuleConfig;
/*     */ import com.rongdu.cashloan.rule.domain.RuleEngine;
/*     */ import com.rongdu.cashloan.rule.service.BorrowRuleConfigService;
/*     */ import com.rongdu.cashloan.rule.service.BorrowRuleEngineService;
/*     */ import com.rongdu.cashloan.rule.service.RuleEngineConfigService;
/*     */ import com.rongdu.cashloan.rule.service.RuleEngineService;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class RuleEngineController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private RuleEngineService ruleEngineService;
/*     */   @Resource
/*     */   private BorrowRuleConfigService borrowRuleConfigService;
/*     */   @Resource
/*     */   private BorrowRuleEngineService borrowRuleEngineService;
/*     */   @Resource
/*     */   private RuleEngineConfigService ruleEngineConfigService;
/*  57 */   private static final Logger logger = LoggerFactory.getLogger(RuleEngineController.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:list", name="查询规则记录")
/*     */   public void list(@RequestParam(value="search", required=false) String search, @RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  68 */     Map<String, Object> params = (Map)JsonUtil.parse(search, Map.class);
/*  69 */     Page<RuleEngine> page = this.ruleEngineService.findListByPage(params, currentPage, pageSize);
/*  70 */     Map<String, Object> result = new HashMap();
/*  71 */     result.put("data", page);
/*  72 */     result.put("page", new RdPage(page));
/*  73 */     result.put("code", Integer.valueOf(200));
/*  74 */     result.put("msg", "获取成功");
/*  75 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/modifyState.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:modifyState", name="修改规则状态")
/*     */   public void modifyState(@RequestParam("state") String state, @RequestParam("id") Long id)
/*     */   {
/*  85 */     int resCode = 0;
/*  86 */     if ((StringUtil.isNotBlank(id)) && (StringUtil.isNotBlank(state))) {
/*  87 */       Map<String, Object> map = new HashMap();
/*  88 */       map.put("id", id);
/*  89 */       map.put("state", state);
/*  90 */       resCode = this.ruleEngineService.updateByRule(map);
/*  91 */       if (state.equals("20"))
/*     */       {
/*  93 */         Map<String, Object> paramMap = new HashMap();
/*  94 */         paramMap.put("ruleId", id);
/*  95 */         List<BorrowRuleConfig> borrowRuleConfig = this.borrowRuleConfigService.findBorrowRuleId(paramMap);
/*  96 */         RuleEngine rule = this.ruleEngineService.findById(id);
/*  97 */         for (BorrowRuleConfig br : borrowRuleConfig) {
/*  98 */           int count = br.getConfigSort().intValue() - rule.getConfigCount().intValue();
/*  99 */           if (count > 0) {
/* 100 */             paramMap = new HashMap();
/* 101 */             paramMap.put("id", br.getBorrowRuleId());
/* 102 */             paramMap.put("ruleCount", Integer.valueOf(count));
/* 103 */             this.borrowRuleEngineService.updateSelective(paramMap);
/*     */           } else {
/* 105 */             this.borrowRuleEngineService.deleteById(br.getBorrowRuleId().longValue());
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 111 */         map = new HashMap();
/* 112 */         map.put("ruleId", id);
/* 113 */         this.borrowRuleConfigService.deleteByMap(map);
/*     */       }
/*     */     }
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
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/allList.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:allList", name="查询所有规则及其配置信息")
/*     */   public void list(@RequestParam(value="search", required=false) String search)
/*     */   {
/* 133 */     Map<String, Object> params = (Map)JsonUtil.parse(search, Map.class);
/* 134 */     List<Map<String, Object>> list = this.ruleEngineService.findAllRule(params);
/* 135 */     Map<String, Object> result = new HashMap();
/* 136 */     result.put("data", list);
/* 137 */     result.put("code", Integer.valueOf(200));
/* 138 */     result.put("msg", "获取成功");
/* 139 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\controller\RuleEngineController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */