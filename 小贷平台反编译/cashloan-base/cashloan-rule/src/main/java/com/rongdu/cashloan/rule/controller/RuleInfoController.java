/*     */ package com.rongdu.cashloan.rule.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rule.domain.RuleInfo;
/*     */ import com.rongdu.cashloan.rule.model.RuleInfoDetail;
/*     */ import com.rongdu.cashloan.rule.service.RuleEngineConfigService;
/*     */ import com.rongdu.cashloan.rule.service.RuleInfoService;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class RuleInfoController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private RuleInfoService ruleInfoService;
/*     */   @Resource
/*     */   private RuleEngineConfigService ruleEngineConfigService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/rule/ruleList.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:ruleList", name="查询借款规则列表")
/*     */   public void ruleList(@RequestParam(value="search", required=false) String search, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  65 */     Map<String, Object> params = (Map)JsonUtil.parse(search, Map.class);
/*  66 */     Page<RuleInfo> page = this.ruleInfoService.ruleList(params, currentPage, pageSize);
/*  67 */     Map<String, Object> result = new HashMap();
/*  68 */     result.put("data", page);
/*  69 */     result.put("page", new RdPage(page));
/*  70 */     result.put("code", Integer.valueOf(200));
/*  71 */     result.put("msg", "获取成功");
/*  72 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/addRuleInfo.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:addRuleInfo", name="添加规则配置信息")
/*     */   public void addRuleInfo(@RequestParam("detail") String details, @RequestParam("tbNid") String tbNid, @RequestParam("tbName") String tbName)
/*     */   {
/*  86 */     List<RuleInfoDetail> rules = JSONArray.parseArray(details, RuleInfoDetail.class);
/*  87 */     RuleInfoDetail detail = new RuleInfoDetail();
/*  88 */     Map<String, Object> result = new HashMap();
/*  89 */     if (detail.validData(rules)) {
/*  90 */       RuleInfo ruleInfo = new RuleInfo();
/*  91 */       ruleInfo.setTbName(tbName);
/*  92 */       ruleInfo.setTbNid(tbNid);
/*  93 */       ruleInfo.setDetail(details);
/*  94 */       ruleInfo.setAddTime(new Date());
/*  95 */       ruleInfo.setState("10");
/*  96 */       this.ruleInfoService.insert(ruleInfo);
/*  97 */       result.put("code", Integer.valueOf(200));
/*  98 */       result.put("msg", "添加成功");
/*     */     } else {
/* 100 */       result.put("code", Integer.valueOf(400));
/* 101 */       result.put("msg", "添加失败，参数错误");
/*     */     }
/*     */     
/* 104 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/getRuleInfo.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:getRuleInfo", name="查询规则配置信息")
/*     */   public void getRuleInfo(@RequestParam("id") Long id)
/*     */   {
/* 116 */     RuleInfo ruleInfo = (RuleInfo)this.ruleInfoService.getById(id);
/* 117 */     Map<String, Object> data = new HashMap();
/* 118 */     if (ruleInfo != null) {
/* 119 */       data.put("id", ruleInfo.getId());
/* 120 */       data.put("tbNid", ruleInfo.getTbNid());
/* 121 */       data.put("tbName", ruleInfo.getTbName());
/* 122 */       data.put("detail", ruleInfo.getDetail());
/* 123 */       if (StringUtil.isNotBlank(ruleInfo.getDetail())) {
/* 124 */         List<RuleInfoDetail> rules = JSONArray.parseArray(ruleInfo.getDetail(), RuleInfoDetail.class);
/* 125 */         if ((rules != null) && (!rules.isEmpty())) {
/* 126 */           data.put("detail", rules);
/*     */         }
/*     */       }
/*     */     }
/* 130 */     Map<String, Object> result = new HashMap();
/* 131 */     result.put("code", Integer.valueOf(200));
/* 132 */     result.put("msg", "查询成功");
/* 133 */     result.put("data", data);
/* 134 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/modifyRuleInfo.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:modifyRuleInfo", name="修改规则配置信息")
/*     */   public void modifyRuleInfo(@RequestParam("detail") String detail, @RequestParam("id") Long id)
/*     */   {
/* 147 */     RuleInfo ruleInfo = (RuleInfo)this.ruleInfoService.getById(id);
/* 148 */     ruleInfo.setDetail(detail);
/* 149 */     this.ruleInfoService.updateById(ruleInfo);
/* 150 */     Map<String, Object> result = new HashMap();
/* 151 */     result.put("code", Integer.valueOf(200));
/* 152 */     result.put("msg", "修改成功");
/* 153 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/findAllDataTable.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:findAllDataTable", name="查询数据中所有表和字段")
/*     */   public void findAllDataTable()
/*     */   {
/* 162 */     List<Map<String, Object>> data = new ArrayList();
/* 163 */     Map<String, Object> paramMap = new HashMap();
/* 164 */     if (StringUtil.isNotEmpty(Global.getValue("rule_tables"))) {
/* 165 */       List<String> tableNames = new ArrayList(Arrays.asList(Global.getValue("rule_tables").split(",")));
/* 166 */       paramMap.put("tableNames", tableNames);
/*     */     }
/* 168 */     List<Map<String, Object>> list = this.ruleEngineConfigService.findTableByName(paramMap);
/*     */     
/* 170 */     Map<String, Object> map = new HashMap();
/* 171 */     List<Map<String, Object>> columnList = this.ruleEngineConfigService.findColumnByName(map);
/* 172 */     if (list != null) {
/* 173 */       List<RuleInfo> infolist = this.ruleInfoService.findAll(map);
/* 174 */       for (int i = 0; i < list.size(); i++) {
/* 175 */         Map<String, Object> result = (Map)list.get(i);
/*     */         
/* 177 */         result.put("checked", Boolean.valueOf(this.ruleInfoService.checkTable(infolist, (String)result.get("tableName"))));
/* 178 */         List<Map<String, Object>> children = new ArrayList();
/* 179 */         if (columnList != null) {
/* 180 */           for (int j = 0; j < columnList.size(); j++) {
/* 181 */             Map<String, Object> childrenmap = new HashMap();
/* 182 */             Map<String, Object> column = (Map)columnList.get(j);
/* 183 */             if (column.get("tableName").equals(result.get("tableName"))) {
/* 184 */               childrenmap.put("columnName", column.get("columnName"));
/* 185 */               String columnComment = (String)column.get("columnComment");
/*     */               
/* 187 */               if ((StringUtil.isNotBlank(columnComment)) && 
/* 188 */                 (columnComment.length() > 1)) {
/* 189 */                 int colu = columnComment.indexOf(" ");
/* 190 */                 if (colu != -1) {
/* 191 */                   columnComment = columnComment.substring(0, colu);
/*     */                 }
/*     */               }
/*     */               
/* 195 */               childrenmap.put("columnComment", columnComment);
/* 196 */               if ("bigint;int;decimal;integer;tinyint;double;decimal;float;bit;smallint;mediumint;".contains((String)column.get("data_type"))) {
/* 197 */                 childrenmap.put("type", "int");
/*     */               } else {
/* 199 */                 childrenmap.put("type", "string");
/*     */               }
/*     */               
/* 202 */               childrenmap.put("checked", Boolean.valueOf(this.ruleInfoService.checkColumn(infolist, (String)column.get("tableName"), (String)column.get("columnName"))));
/* 203 */               children.add(childrenmap);
/*     */             }
/*     */           }
/*     */         }
/* 207 */         result.put("children", children);
/* 208 */         data.add(result);
/*     */       }
/*     */     }
/* 211 */     Map<String, Object> result = new HashMap();
/* 212 */     result.put("data", data);
/* 213 */     result.put("code", Integer.valueOf(200));
/* 214 */     result.put("msg", "查询成功");
/* 215 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/rule/modifyInfoState.htm"})
/*     */   @RequiresPermission(code="modules:manage:rule:modifyInfoState", name="编辑状态")
/*     */   public void DelInfoConfig(@RequestParam("id") Long id, @RequestParam("state") String state)
/*     */   {
/* 225 */     int r = this.ruleInfoService.modifyInfoState(id, state);
/* 226 */     Map<String, Object> result = new HashMap();
/* 227 */     if (r == 1) {
/* 228 */       result.put("code", Integer.valueOf(200));
/* 229 */       result.put("msg", "成功");
/*     */     } else {
/* 231 */       result.put("code", Integer.valueOf(400));
/* 232 */       result.put("msg", "失败");
/*     */     }
/* 234 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\controller\RuleInfoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */