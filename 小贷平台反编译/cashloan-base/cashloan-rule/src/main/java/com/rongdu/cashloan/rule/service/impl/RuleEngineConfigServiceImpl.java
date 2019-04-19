/*     */ package com.rongdu.cashloan.rule.service.impl;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.JsonUtil;
import com.rongdu.cashloan.core.common.util.ServletUtils;
import com.rongdu.cashloan.rule.domain.*;
import com.rongdu.cashloan.rule.mapper.*;
import com.rongdu.cashloan.rule.service.RuleEngineConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
/*     */ @Service("ruleEngineConfigService")
/*     */ public class RuleEngineConfigServiceImpl
/*     */   extends BaseServiceImpl<RuleEngineConfig, Long>
/*     */   implements RuleEngineConfigService
/*     */ {
/*  55 */   private static final Logger logger = LoggerFactory.getLogger(RuleEngineConfigServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private RuleEngineConfigMapper ruleEngineConfigMapper;
/*     */   
/*     */   @Resource
/*     */   private RuleEngineMapper ruleEngineMapper;
/*     */   
/*     */   @Resource
/*     */   private RuleInfoMapper ruleInfoMapper;
/*     */   
/*     */   @Resource
/*     */   private RuleEngineInfoMapper ruleEngineInfoMapper;
/*     */   
/*     */   @Resource
/*     */   private BorrowRuleConfigMapper borrowRuleConfigMapper;
/*     */   @Resource
/*     */   private BorrowRuleEngineMapper borrowRuleEngineMapper;
/*     */   
/*     */   public BaseMapper<RuleEngineConfig, Long> getMapper()
/*     */   {
/*  76 */     return this.ruleEngineConfigMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<RuleEngineConfig> findByMap(Map<String, Object> search)
/*     */   {
/*  84 */     return this.ruleEngineConfigMapper.listSelective(search);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Map<String, Object>> findTable()
/*     */   {
/*  92 */     List<Map<String, Object>> list = this.ruleEngineConfigMapper.findTable();
/*  93 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Map<String, Object>> findTableByName(Map<String, Object> paramMap)
/*     */   {
/*  99 */     List<Map<String, Object>> list = this.ruleEngineConfigMapper.findTableByName(paramMap);
/* 100 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Map<String, Object>> findColumnByName(Map<String, Object> map)
/*     */   {
/* 109 */     List<Map<String, Object>> list = this.ruleEngineConfigMapper.findColumnByName(map);
/* 110 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int updateSelective(Map<String, Object> map)
/*     */   {
/* 118 */     return this.ruleEngineConfigMapper.updateSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Map<String, Object>> findAllInfo(Map<String, Object> map)
/*     */   {
/* 124 */     List<RuleInfo> list = this.ruleInfoMapper.listSelective(map);
/* 125 */     List<Map<String, Object>> data = new ArrayList();
/* 126 */     if (list != null) {
/* 127 */       for (int i = 0; i < list.size(); i++) {
/* 128 */         RuleInfo rule = (RuleInfo)list.get(i);
/* 129 */         Map<String, Object> result = new HashMap();
/* 130 */         result.put("tableName", rule.getTbNid());
/* 131 */         result.put("tableComment", rule.getTbName());
/* 132 */         List<Map<String, Object>> children = new ArrayList();
/* 133 */         if (rule.getDetail() != null) {
/* 134 */           List childrenlist = (List)JsonUtil.parse(rule.getDetail(), 
/* 135 */             List.class);
/* 136 */           for (int j = 0; j < childrenlist.size(); j++) {
/* 137 */             Map<String, Object> childrenMap = new HashMap();
/* 138 */             Map link = (LinkedHashMap)childrenlist.get(j);
/* 139 */             Iterator it = link.entrySet().iterator();
/* 140 */             while (it.hasNext()) {
/* 141 */               Map.Entry<String, String> entry = 
/* 142 */                 (Map.Entry)it.next();
/* 143 */               if (!"".equals(entry.getValue())) {
/* 144 */                 if ("nid".equals(entry.getKey())) {
/* 145 */                   childrenMap.put("columnName", 
/* 146 */                     entry.getValue());
/*     */                 }
/* 148 */                 if ("name".equals(entry.getKey())) {
/* 149 */                   childrenMap.put("columnComment", 
/* 150 */                     entry.getValue());
/*     */                 }
/* 152 */                 if ("type".equals(entry.getKey())) {
/* 153 */                   childrenMap.put("type", entry.getValue());
/*     */                 }
/*     */               }
/*     */             }
/* 157 */             children.add(childrenMap);
/*     */           }
/*     */           
/* 160 */           result.put("children", children);
/* 161 */           data.add(result);
/*     */         }
/*     */       }
/*     */     }
/* 165 */     return data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int saveOrUpate(Map<String, Object> map, List list, String datalist, HttpServletRequest request)
/*     */   {
/* 174 */     RuleEngine rule = new RuleEngine();
/* 176 */     int resCode; if (StringUtil.isNotBlank(map.get("id")))
/*     */     {
/* 178 */       rule.setId(Long.valueOf(map.get("id").toString()));
/* 179 */       if (!"20".equals(String.valueOf(map.get("typeResultStatus")))) {
/* 180 */         map.put("typeResultStatus", "10");
/*     */       }
/* 182 */       map.put("configCount", Integer.valueOf(list != null ? list.size() : 0));
/* 183 */       resCode = this.ruleEngineMapper.updateSelective(map);
/*     */     }
/*     */     else
/*     */     {
/* 187 */       rule.setAddTime(new Date());
/* 188 */       rule.setAddIp(ServletUtils.getIpAddress(request));
/* 189 */       rule.setState("10");
/* 190 */       rule.setName(String.valueOf(map.get("name")));
/* 191 */       rule.setIntegral((Integer)map.get("integral"));
/* 192 */       rule.setType(String.valueOf(map.get("type")));
/* 193 */       rule.setTypeResultStatus(String.valueOf(map.get("typeResultStatus")));
/* 194 */       if (!"20".equals(rule.getTypeResultStatus())) {
/* 195 */         rule.setTypeResultStatus("10");
/*     */       }
/* 197 */       rule.setAddIp(ServletUtils.getIpAddress(request));
/* 198 */       rule.setConfigCount(Integer.valueOf(list != null ? list.size() : 0));
/* 199 */       resCode = this.ruleEngineMapper.insertId(rule);
/*     */     }
/*     */     
/*     */ 
/* 203 */     if ((datalist != null) && (!"[{}]".equals(datalist))) {
/* 204 */       List infolist = (List)JsonUtil.parse(datalist, List.class);
/* 205 */       resCode = saveIntegralInfo(rule.getId().longValue(), infolist);
/*     */     }
/*     */     
/* 208 */     if ((list != null) && (list.size() > 0)) {
/* 209 */       resCode = saveConfig(list, rule, request);
/*     */     }
/* 211 */     return resCode;
/*     */   }
/*     */   
/*     */   public int saveConfig(List list, RuleEngine rule, HttpServletRequest request)
/*     */   {
/* 216 */     int resCode = 0;
/* 217 */     if ((list != null) && (list.size() > 0))
/*     */     {
/* 219 */       Map<String, Object> paramMap = new HashMap();
/* 220 */       paramMap.put("ruleEnginId", rule.getId());
/* 221 */       List<RuleEngineConfig> oldconfigs = this.ruleEngineConfigMapper.listSelective(paramMap);
/* 222 */       String olds = ";";
/*     */       
/*     */ 
/* 225 */       paramMap = new HashMap();
/* 226 */       paramMap.put("ruleId", rule.getId());
/* 227 */       List<BorrowRuleConfig> borrowRuleConfig = this.borrowRuleConfigMapper.findBorrowRuleId(paramMap);
/* 228 */       boolean flag = false;
/* 229 */       if ((borrowRuleConfig != null) && (borrowRuleConfig.size() > 0)) {
/* 230 */         flag = true;
/*     */       }
/* 232 */       int add = 0;
/* 233 */       int plus = 0;
/* 234 */       RuleEngineConfig config; for (int i = 0; i < list.size(); i++) {
/* 235 */         config = new RuleEngineConfig();
/* 236 */         Map link = (LinkedHashMap)list.get(i);
/* 237 */         for (Iterator it = link.entrySet().iterator(); it.hasNext();) {
/* 238 */           Map.Entry<String, Object> entry = (Map.Entry)it.next();
/* 239 */           if (!"".equals(entry.getValue()))
/*     */           {
/* 241 */             if ("id".equals(entry.getKey())) {
/* 242 */               config.setId(Long.valueOf(String.valueOf(entry.getValue())));
/*     */             }
/* 244 */             if ("ctable".equals(entry.getKey())) {
/* 245 */               config.setCtable(StringUtil.isNull(entry.getValue()));
/*     */             }
/* 247 */             if ("ccolumn".equals(entry.getKey())) {
/* 248 */               config.setCcolumn(StringUtil.isNull(entry.getValue()));
/*     */             }
/* 250 */             if ("tableComment".equals(entry.getKey())) {
/* 251 */               config.setTableComment(StringUtil.isNull(entry.getValue()));
/*     */             }
/* 253 */             if ("columnComment".equals(entry.getKey())) {
/* 254 */               config.setColumnComment(StringUtil.isNull(entry.getValue()));
/*     */             }
/* 256 */             if ("formula".equals(entry.getKey())) {
/* 257 */               config.setFormula(StringUtil.isNull(entry.getValue()));
/*     */             }
/* 259 */             if ("cvalue".equals(entry.getKey())) {
/* 260 */               String cvalue = StringUtil.isNull(entry.getValue());
/* 261 */               config.setCvalue(cvalue.replaceAll("，", ","));
/*     */             }
/* 263 */             if ("type".equals(entry.getKey())) {
/* 264 */               config.setType(StringUtil.isNull(entry.getValue()));
/*     */             }
/* 266 */             if ("integral".equals(entry.getKey())) {
/* 267 */               config.setIntegral(Integer.valueOf(String.valueOf(entry.getValue())));
/*     */             }
/* 269 */             if ("result".equals(entry.getKey())) {
/* 270 */               config.setResult(StringUtil.isNull(entry.getValue()));
/*     */             }
/* 272 */             if ("resultType".equals(entry.getKey())) {
/* 273 */               config.setResultType(StringUtil.isNull(entry.getValue()));
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */         List<Map<String, Object>> infos;
/*     */         
/* 280 */         if ((config.getType() == "") || (config.getType() == null)) {
/* 281 */           Map<String, Object> info = new HashMap();
/* 282 */           infos = findAllInfo(info);
/* 283 */           if (infos != null) {
/* 284 */             for (int k = 0; k < infos.size(); k++) {
/* 285 */               Map<String, Object> table = (Map)infos.get(k);
/* 286 */               if (table.get("tableName").equals(config.getCtable())) {
/* 287 */                 config.setTableComment((String)table.get("tableComment"));
/* 288 */                 List<Map<String, Object>> children = (List)table.get("children");
/* 289 */                 if (children != null) {
/* 290 */                   for (Map<String, Object> child : children) {
/* 291 */                     if (child.get("columnName").equals(config.getCcolumn())) {
/* 292 */                       config.setColumnComment((String)child.get("columnComment"));
/* 293 */                       config.setType((String)child.get("type"));
/* 294 */                       break;
/*     */                     }
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 302 */         if ((config.getId() != null) && (config.getId().longValue() != 0L)) {
/* 303 */           olds = olds + config.getId() + ";";
/* 304 */           Map<String, Object> params = (Map)JsonUtil.parse(JsonUtil.toString(config), Map.class);
/* 305 */           resCode = this.ruleEngineConfigMapper.updateSelective(params);
/*     */         } else {
/* 307 */           config.setAddTime(new Date());
/* 308 */           config.setState("10");
/* 309 */           config.setAddIp(ServletUtils.getIpAddress(request));
/* 310 */           config.setRuleEnginId(rule.getId());
/* 311 */           resCode = this.ruleEngineConfigMapper.insert(config);
/* 312 */           add++;
/*     */           
/* 314 */           if (flag) {
/* 315 */             for (BorrowRuleConfig br : borrowRuleConfig) {
/* 316 */               BorrowRuleConfig bc = new BorrowRuleConfig();
/* 317 */               bc.setBorrowRuleId(br.getBorrowRuleId());
/* 318 */               bc.setRuleId(rule.getId());
/* 319 */               bc.setConfigId(config.getId());
/* 320 */               bc.setRuleSort(br.getRuleSort());
/* 321 */               bc.setConfigSort(Integer.valueOf(0));
/* 322 */               this.borrowRuleConfigMapper.save(bc);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 328 */       for (RuleEngineConfig c : oldconfigs) {
/* 329 */         if (!olds.contains(";" + String.valueOf(c.getId()) + ";")) {
/* 330 */           this.ruleEngineConfigMapper.deleteById(c.getId());
/*     */           
/* 332 */           paramMap = new HashMap();
/* 333 */           paramMap.put("ruleId", rule.getId());
/* 334 */           paramMap.put("configId", c.getId());
/* 335 */           this.borrowRuleConfigMapper.deleteByMap(paramMap);
/* 336 */           plus++;
/*     */         }
/*     */       }
/*     */       
/* 340 */       if (flag) {
/* 341 */         for (BorrowRuleConfig br : borrowRuleConfig) {
/* 342 */           int count = br.getConfigSort().intValue() + add - plus;
/* 343 */           if (count > 0) {
/* 344 */             paramMap = new HashMap();
/* 345 */             paramMap.put("id", br.getBorrowRuleId());
/* 346 */             paramMap.put("ruleCount", Integer.valueOf(count));
/* 347 */             this.borrowRuleEngineMapper.updateSelective(paramMap);
/*     */           } else {
/* 349 */             this.borrowRuleEngineMapper.deleteById(br.getBorrowRuleId().longValue());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 355 */       this.ruleEngineConfigMapper.deleteByRuleId(rule.getId());
/*     */       
/* 357 */       Map<String, Object> paramMap = new HashMap();
/* 358 */       paramMap.put("ruleId", rule.getId());
/* 359 */       this.borrowRuleConfigMapper.deleteByMap(paramMap);
/*     */     }
/* 361 */     return resCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int saveIntegralInfo(long fid, List list)
/*     */   {
/* 372 */     int resCode = 0;
/* 373 */     if (StringUtil.isNotBlank(Long.valueOf(fid))) {
/* 374 */       this.ruleEngineInfoMapper.deleteInfoByRuleId(fid);
/* 375 */       if ((list != null) && (list.size() > 0)) {
/* 376 */         for (int i = 0; i < list.size(); i++) {
/* 377 */           RuleEngineInfo info = new RuleEngineInfo();
/* 378 */           Map link = (LinkedHashMap)list.get(i);
/* 379 */           for (Iterator it = link.entrySet().iterator(); it.hasNext();) {
/* 380 */             Map.Entry<String, Object> entry = 
/* 381 */               (Map.Entry)it.next();
/* 382 */             if (!"".equals(entry.getValue())) {
/* 383 */               if (((String)entry.getKey()).equals("info_formula"))
/*     */               {
/* 385 */                 info.setFormula((String)entry.getValue());
/*     */               }
/* 387 */               if (((String)entry.getKey()).equals("info_integral")) {
/* 388 */                 info.setIntegral(
/* 389 */                   (Integer)entry.getValue());
/*     */               }
/* 391 */               if (((String)entry.getKey()).equals("info_result")) {
/* 392 */                 info.setResult((String)entry.getValue());
/*     */               }
/* 394 */               if (((String)entry.getKey()).equals("info_id")) {
/* 395 */                 info.setId(
/* 396 */                   (Long)entry.getValue());
/*     */               }
/*     */             }
/*     */           }
/* 400 */           info.setRuleEnginId(Long.valueOf(fid));
/* 401 */           resCode = this.ruleEngineInfoMapper.insert(info);
/*     */         }
/*     */       }
/*     */     }
/* 405 */     return resCode;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\impl\RuleEngineConfigServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */