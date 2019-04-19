/*     */ package com.rongdu.creditrank.cr.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.creditrank.cr.domain.Info;
/*     */ import com.rongdu.creditrank.cr.model.InfoModel;
/*     */ import com.rongdu.creditrank.cr.model.RuleInfoDetail;
/*     */ import com.rongdu.creditrank.cr.service.InfoService;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class InfoController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private InfoService infoService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cr/info/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void page(@RequestParam(value="search", required=false) String secreditrankh, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  62 */     Map<String, Object> secreditrankhMap = (Map)JsonUtil.parse(secreditrankh, Map.class);
/*  63 */     Page<InfoModel> page = this.infoService.page(secreditrankhMap, current, pageSize);
/*  64 */     for (InfoModel infoModel : page) {
/*  65 */       JSONArray arr = JSONArray.parseArray(infoModel.getDetail());
/*  66 */       infoModel.setChildren(arr);
/*     */     }
/*  68 */     Map<String, Object> result = new HashMap();
/*  69 */     result.put("data", page);
/*  70 */     result.put("page", new RdPage(page));
/*  71 */     result.put("code", Integer.valueOf(200));
/*  72 */     result.put("msg", "查询成功");
/*  73 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/cr/info/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(@RequestParam("tbNid") String tbNid, @RequestParam("tbName") String tbName, @RequestParam("detail") String detail)
/*     */     throws Exception
/*     */   {
/*  88 */     Map<String, Object> result = new HashMap();
/*  89 */     Info info = new Info();
/*  90 */     info = this.infoService.findByTbNid(tbNid);
/*  91 */     if (StringUtil.isBlank(info)) {
/*  92 */       int msg = this.infoService.save(tbNid, tbName, detail);
/*  93 */       if (msg < 0) {
/*  94 */         result.put("code", Integer.valueOf(400));
/*  95 */         result.put("msg", "新增失败");
/*     */       } else {
/*  97 */         result.put("code", Integer.valueOf(200));
/*  98 */         result.put("msg", "新增成功");
/*     */       }
/*     */     } else {
/* 101 */       result.put("code", Integer.valueOf(400));
/* 102 */       result.put("msg", "记录已存在");
/*     */     }
/* 104 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/cr/info/update.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void update(@RequestParam("id") long id, @RequestParam("tbNid") String tbNid, @RequestParam("tbName") String tbName, @RequestParam("detail") String detail)
/*     */     throws Exception
/*     */   {
/* 121 */     Map<String, Object> result = new HashMap();
/* 122 */     Map<String, Object> updateMap = new HashMap();
/* 123 */     updateMap.put("id", Long.valueOf(id));
/* 124 */     updateMap.put("tbNid", tbNid);
/* 125 */     updateMap.put("tbName", tbName);
/* 126 */     updateMap.put("detail", detail);
/* 127 */     int msg = this.infoService.updateSelective(updateMap);
/* 128 */     if (msg > 0) {
/* 129 */       result.put("code", Integer.valueOf(200));
/* 130 */       result.put("msg", "修改成功");
/*     */     } else {
/* 132 */       result.put("code", Integer.valueOf(400));
/* 133 */       result.put("msg", "修改失败");
/*     */     }
/*     */     
/* 136 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/cr/info/updateState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateState(@RequestParam("id") long id, @RequestParam("state") String state)
/*     */     throws Exception
/*     */   {
/* 151 */     Map<String, Object> result = new HashMap();
/* 152 */     Map<String, Object> updateMap = new HashMap();
/* 153 */     updateMap.put("id", Long.valueOf(id));
/* 154 */     updateMap.put("state", state);
/* 155 */     int msg = this.infoService.updateSelective(updateMap);
/* 156 */     if (msg > 0) {
/* 157 */       result.put("code", Integer.valueOf(200));
/* 158 */       result.put("msg", "修改成功");
/*     */     } else {
/* 160 */       result.put("code", Integer.valueOf(400));
/* 161 */       result.put("msg", "修改失败");
/*     */     }
/*     */     
/* 164 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/cr/info/infoPage.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void infoPage(@RequestParam(value="secreditrankh", required=false) String secreditrankh, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 180 */     Map<String, Object> secreditrankhMap = (Map)JsonUtil.parse(secreditrankh, Map.class);
/* 181 */     Page<InfoModel> page = this.infoService.page(secreditrankhMap, current, pageSize);
/* 182 */     Map<String, Object> result = new HashMap();
/* 183 */     result.put("data", page);
/* 184 */     result.put("page", new RdPage(page));
/* 185 */     result.put("code", Integer.valueOf(200));
/* 186 */     result.put("msg", "查询成功");
/* 187 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/info/findAllDataTable.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void findAllDataTable()
/*     */   {
/* 197 */     List<Map<String, Object>> data = new ArrayList();
/* 198 */     List<Map<String, Object>> list = this.infoService.findTable();
/* 199 */     Map<String, Object> map = new HashMap();
/* 200 */     List<Map<String, Object>> columnList = this.infoService.findColumnByName(map);
/* 201 */     if (list != null) {
/* 202 */       List<Info> infolist = this.infoService.listSelective(map);
/* 203 */       for (int i = 0; i < list.size(); i++) {
/* 204 */         Map<String, Object> result = (Map)list.get(i);
/*     */         
/* 206 */         result.put("checked", Boolean.valueOf(checkTable(infolist, (String)result.get("tableName"))));
/* 207 */         List<Map<String, Object>> children = new ArrayList();
/* 208 */         if (columnList != null) {
/* 209 */           for (int j = 0; j < columnList.size(); j++) {
/* 210 */             Map<String, Object> childrenmap = new HashMap();
/* 211 */             Map<String, Object> column = (Map)columnList.get(j);
/* 212 */             if (column.get("tableName").equals(result.get("tableName"))) {
/* 213 */               childrenmap.put("columnName", column.get("columnName"));
/* 214 */               String columnComment = (String)column.get("columnComment");
/*     */               
/* 216 */               if ((StringUtil.isNotBlank(columnComment)) && 
/* 217 */                 (columnComment.length() > 1)) {
/* 218 */                 int colu = columnComment.indexOf(" ");
/* 219 */                 if (colu != -1) {
/* 220 */                   columnComment = columnComment.substring(0, colu);
/*     */                 }
/* 222 */                 else if (columnComment.length() > 10) {
/* 223 */                   columnComment = columnComment.substring(0, 11);
/*     */                 }
/*     */               }
/*     */               
/*     */ 
/* 228 */               childrenmap.put("columnComment", columnComment);
/* 229 */               if ("bigint;int;decimal;integer;tinyint;double;decimal;float;bit;smallint;mediumint;".contains((String)column.get("data_type"))) {
/* 230 */                 childrenmap.put("type", "int");
/*     */               } else {
/* 232 */                 childrenmap.put("type", "string");
/*     */               }
/*     */               
/* 235 */               childrenmap.put("checked", Boolean.valueOf(checkColumn(infolist, (String)column.get("tableName"), (String)column.get("columnName"))));
/* 236 */               children.add(childrenmap);
/*     */             }
/*     */           }
/*     */         }
/* 240 */         result.put("children", children);
/* 241 */         data.add(result);
/*     */       }
/*     */     }
/* 244 */     Map<String, Object> result = new HashMap();
/* 245 */     result.put("data", data);
/* 246 */     result.put("code", Integer.valueOf(200));
/* 247 */     result.put("msg", "查询成功");
/* 248 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */   public boolean checkTable(List<Info> list, String table) {
/* 252 */     for (Info info : list) {
/* 253 */       if (info.getTbNid().equals(table)) {
/* 254 */         return true;
/*     */       }
/*     */     }
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   public boolean checkColumn(List<Info> list, String table, String column) {
/* 261 */     for (Info info : list) {
/* 262 */       if (info.getTbNid().equals(table)) {
/* 263 */         List<RuleInfoDetail> rules = JSONArray.parseArray(info.getDetail(), RuleInfoDetail.class);
/* 264 */         for (RuleInfoDetail d : rules) {
/* 265 */           if (d.getNid().equals(column)) {
/* 266 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 271 */     return false;
/*     */   }
/*     */ }
