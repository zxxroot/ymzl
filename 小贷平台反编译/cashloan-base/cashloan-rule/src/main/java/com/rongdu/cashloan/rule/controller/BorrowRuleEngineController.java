/*     */ package com.rongdu.cashloan.rule.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.util.JsonUtil;
import com.rongdu.cashloan.core.common.util.RdPage;
import com.rongdu.cashloan.core.common.util.ServletUtils;
import com.rongdu.cashloan.core.common.web.controller.BaseController;
import com.rongdu.cashloan.rule.domain.BorrowRuleConfig;
import com.rongdu.cashloan.rule.domain.BorrowRuleEngine;
import com.rongdu.cashloan.rule.domain.RuleEngine;
import com.rongdu.cashloan.rule.domain.RuleEngineConfig;
import com.rongdu.cashloan.rule.model.BorrowRuleConfigModel;
import com.rongdu.cashloan.rule.service.BorrowRuleConfigService;
import com.rongdu.cashloan.rule.service.BorrowRuleEngineService;
import com.rongdu.cashloan.rule.service.RuleEngineConfigService;
import com.rongdu.cashloan.rule.service.RuleEngineService;
import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
import com.rongdu.cashloan.system.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class BorrowRuleEngineController
/*     */   extends BaseController
/*     */ {
/*  55 */   private static final Logger logger = LoggerFactory.getLogger(BorrowRuleEngineController.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private BorrowRuleEngineService borrowRuleEngineService;
/*     */   
/*     */   @Resource
/*     */   private RuleEngineService ruleEngineService;
/*     */   
/*     */   @Resource
/*     */   private SysDictService sysDictService;
/*     */   
/*     */   @Resource
/*     */   private RuleEngineConfigService ruleEngineConfigService;
/*     */   
/*     */   @Resource
/*     */   private BorrowRuleConfigService borrowRuleConfigService;
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/borrowRuleEngine/page.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRuleEngine:page", name="查询借款规则列表")
/*     */   public void page(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  78 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  79 */     Page<BorrowRuleEngine> page = this.borrowRuleEngineService.page(params, currentPage, pageSize);
/*  80 */     Map<String, Object> result = new HashMap();
/*  81 */     result.put("data", page);
/*  82 */     result.put("page", new RdPage(page));
/*  83 */     result.put("code", Integer.valueOf(200));
/*  84 */     result.put("msg", "获取成功");
/*  85 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/borrowRuleEngine/findRuleList.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRuleEngine:findRuleList", name="借款规则设置列表")
/*     */   public void findRuleList()
/*     */     throws Exception
/*     */   {
/*  94 */     Map<String, Object> params = new HashMap();
/*  95 */     params.put("state", "10");
/*  96 */     List<RuleEngine> engineList = this.ruleEngineService.selectList(params);
/*  97 */     List<Map<String, Object>> list = new ArrayList();
/*  98 */     List<RuleEngineConfig> configs; for (RuleEngine rule : engineList) {
/*  99 */       Map<String, Object> search = new HashMap();
/* 100 */       search.put("ruleEnginId", rule.getId());
/* 101 */       configs = this.ruleEngineConfigService.findByMap(search);
/* 102 */       Map<String, Object> map = new HashMap();
/* 103 */       map.put("rule", rule);
/* 104 */       map.put("configList", configs);
/* 105 */       list.add(map);
/*     */     }
/*     */     
/* 108 */     List<Map<String, Object>> borrowList = new ArrayList();
/*     */     
/* 110 */     List<Map<String, Object>> dicList = this.sysDictService.getDictsCache("PRODUCT_TYPE");
/* 111 */     for (Map<String, Object> dic : dicList) {
/* 112 */       Map<String, Object> borrows = new HashMap();
/* 113 */       borrows.put("borrowType", dic.get("value"));
/* 114 */       borrows.put("borrowTypeName", dic.get("text"));
/* 115 */       borrowList.add(borrows);
/*     */     }
/*     */     
/* 118 */     List<Map<String, Object>> adaptedList = new ArrayList();
/* 119 */     Map<String, Object> adapted = new HashMap();
/* 120 */     adapted.put("adaptedId", "10");
/* 121 */     adapted.put("adaptedName", "贷前");
/* 122 */     adaptedList.add(adapted);
/* 123 */     adapted = new HashMap();
/* 124 */     adapted.put("adaptedId", "20");
/* 125 */     adapted.put("adaptedName", "贷后");
/* 126 */     adaptedList.add(adapted);
/* 127 */     adapted = new HashMap();
/* 128 */     adapted.put("adaptedId", "30");
/* 129 */     adapted.put("adaptedName", "实名");
/* 130 */     adaptedList.add(adapted);
/* 131 */     adapted = new HashMap();
/* 132 */     adapted.put("adaptedId", "40");
/* 133 */     adapted.put("adaptedName", "续贷");
/* 134 */     adaptedList.add(adapted);
/*     */     
/* 136 */     params = new HashMap();
/* 137 */     params.put("adaptedList", adaptedList);
/* 138 */     params.put("rules", list);
/* 139 */     params.put("borrows", borrowList);
/* 140 */     Map<String, Object> result = new HashMap();
/* 141 */     result.put("data", params);
/* 142 */     result.put("code", Integer.valueOf(200));
/* 143 */     result.put("msg", "获取成功");
/* 144 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/borrowRuleEngine/save.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRuleEngine:save", name="新增借款规则")
/*     */   public void save(BorrowRuleEngine bre)
/*     */   {
/* 156 */     bre.setAddTime(new Date());
/* 157 */     bre.setReqExt("");
/* 158 */     bre.setRuleCount(Integer.valueOf(0));
/* 159 */     int msg = this.borrowRuleEngineService.insert(bre);
/* 160 */     Map<String, Object> result = new HashMap();
/* 161 */     if (msg > 0) {
/* 162 */       result.put("code", Integer.valueOf(200));
/* 163 */       result.put("msg", "新增成功");
/*     */     } else {
/* 165 */       result.put("code", Integer.valueOf(400));
/* 166 */       result.put("msg", "新增失败");
/*     */     }
/* 168 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/borrowRuleEngine/detail.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRuleEngine:detail", name="查询借款配置详情")
/*     */   public void detail(@RequestParam("id") long id)
/*     */   {
/* 178 */     Map<String, Object> params = new HashMap();
/* 179 */     Map<String, Object> list = new HashMap();
/* 180 */     params.put("id", Long.valueOf(id));
/* 181 */     BorrowRuleEngine bre = (BorrowRuleEngine)this.borrowRuleEngineService.getById(Long.valueOf(id));
/* 182 */     params = new HashMap();
/* 183 */     params.put("borrowRuleId", Long.valueOf(id));
/* 184 */     List<BorrowRuleConfigModel> configs = this.borrowRuleConfigService.findConfig(params);
/* 185 */     list.put("borrowRuleConfig", configs);
/* 186 */     list.put("borrowRule", bre);
/* 187 */     Map<String, Object> result = new HashMap();
/* 188 */     result.put("data", list);
/* 189 */     result.put("code", Integer.valueOf(200));
/* 190 */     result.put("msg", "获取成功");
/* 191 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/borrowRuleEngine/updateRuleConfig.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRuleEngine:updateRuleConfig", name="编辑借款规则")
/*     */   public void update(BorrowRuleEngine brc, @RequestParam("ruleConfigList") String ruleConfigList)
/*     */     throws ServiceException
/*     */   {
/* 206 */     List list = (List)JsonUtil.parse(ruleConfigList, List.class);
/* 207 */     List<BorrowRuleConfig> configlist = new ArrayList();
/* 208 */     String value; if ((list != null) && (list.size() > 0)) {
/* 209 */       for (int i = 0; i < list.size(); i++) {
/* 210 */         Map link = (LinkedHashMap)list.get(i);
/* 211 */         value = JSON.toJSONString(link);
/* 212 */         BorrowRuleConfigModel allList = (BorrowRuleConfigModel)JsonUtil.parse(value, BorrowRuleConfigModel.class);
/* 213 */         if (allList == null) {
/*     */           break;
/*     */         }
/* 216 */         BorrowRuleConfig rule = allList.getRule();
/* 217 */         for (BorrowRuleConfig config : allList.getConfigList()) {
/* 218 */           BorrowRuleConfig brconfig = new BorrowRuleConfig();
/* 219 */           brconfig.setRuleId(rule.getRuleId());
/* 220 */           brconfig.setRuleSort(rule.getRuleSort());
/*     */           
/* 222 */           brconfig.setConfigId(config.getConfigId());
/* 223 */           brconfig.setConfigSort(config.getConfigSort());
/*     */           
/* 225 */           brconfig.setId(config.getId());
/* 226 */           configlist.add(brconfig);
/*     */         }
/*     */       }
/*     */     }
/* 230 */     if ((brc != null) && (brc.getBorrowType() != null) && 
/* 231 */       (brc.getBorrowType() != ""))
/*     */     {
/* 233 */       List<Map<String, Object>> dicList = this.sysDictService.getDictsCache("PRODUCT_TYPE");
/* 234 */       for (Map<String, Object> dic : dicList) {
/* 235 */         Map<String, Object> borrows = new HashMap();
/* 236 */         if (brc.getBorrowType().equals(String.valueOf(dic.get("value")))) {
/* 237 */           brc.setBorrowTypeName(String.valueOf(dic.get("text")));
/* 238 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 243 */     int msg = this.borrowRuleEngineService.update(brc, configlist);
/* 244 */     Map<String, Object> result = new HashMap();
/* 245 */     if (msg > 0) {
/* 246 */       result.put("code", Integer.valueOf(200));
/* 247 */       result.put("msg", "编辑成功");
/*     */     } else {
/* 249 */       result.put("code", Integer.valueOf(400));
/* 250 */       result.put("msg", "编辑失败");
/*     */     }
/* 252 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/borrowRuleEngine/delete.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRuleEngine:delete", name="删除借款规则")
/*     */   public void delete(@RequestParam("id") long id)
/*     */   {
/* 263 */     int msg = this.borrowRuleEngineService.deleteById(id);
/* 264 */     Map<String, Object> result = new HashMap();
/* 265 */     if (msg > 0) {
/* 266 */       result.put("code", Integer.valueOf(200));
/* 267 */       result.put("msg", "删除成功");
/*     */     } else {
/* 269 */       result.put("code", Integer.valueOf(400));
/* 270 */       result.put("msg", "删除失败");
/*     */     }
/* 272 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\controller\BorrowRuleEngineController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */