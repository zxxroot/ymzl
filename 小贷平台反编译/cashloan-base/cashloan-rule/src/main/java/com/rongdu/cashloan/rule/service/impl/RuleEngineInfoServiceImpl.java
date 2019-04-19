/*    */ package com.rongdu.cashloan.rule.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.rule.domain.RuleEngineInfo;
/*    */ import com.rongdu.cashloan.rule.mapper.RuleEngineInfoMapper;
/*    */ import com.rongdu.cashloan.rule.service.RuleEngineInfoService;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ import tool.util.StringUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("ruleEngineInfoService")
/*    */ public class RuleEngineInfoServiceImpl
/*    */   extends BaseServiceImpl<RuleEngineInfo, Long>
/*    */   implements RuleEngineInfoService
/*    */ {
/* 40 */   private static final Logger logger = LoggerFactory.getLogger(RuleEngineInfoServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private RuleEngineInfoMapper ruleEngineInfoMapper;
/*    */   
/*    */   public BaseMapper<RuleEngineInfo, Long> getMapper()
/*    */   {
/* 47 */     return this.ruleEngineInfoMapper;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int saveIntegralInfo(Map<String, Object> map, List list)
/*    */   {
/* 57 */     int resCode = 0;
/* 58 */     if ((StringUtil.isNotBlank(map.get("id"))) && 
/* 59 */       (list != null) && (!list.isEmpty())) {
/* 60 */       for (int i = 0; i < list.size(); i++) {
/* 61 */         RuleEngineInfo info = new RuleEngineInfo();
/* 62 */         Map link = (LinkedHashMap)list.get(i);
/* 63 */         for (Iterator it = link.entrySet().iterator(); it.hasNext();) {
/* 64 */           Map.Entry<String, String> entry = (Map.Entry)it.next();
/* 65 */           if ("min".equals(entry.getKey())) {
/* 66 */             info.setMinIntegral(Integer.valueOf((String)entry.getValue()));
/*    */           }
/* 68 */           if (!"".equals(entry.getValue())) {
/* 69 */             if ("max".equals(entry.getKey())) {
/* 70 */               info.setMaxIntegral(Integer.valueOf((String)entry.getValue()));
/*    */             }
/* 72 */             if ("result".equals(entry.getKey())) {
/* 73 */               info.setResult((String)entry.getValue());
/*    */             }
/* 75 */             if ("id".equals(entry.getKey())) {
/* 76 */               info.setId(Long.valueOf(((String)entry.getValue()).trim()));
/*    */             }
/*    */           }
/*    */         }
/* 80 */         info.setRuleEnginId(Long.valueOf((String)map.get("id")));
/* 81 */         resCode = this.ruleEngineInfoMapper.insert(info);
/*    */       }
/*    */     }
/*    */     
/* 85 */     return resCode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<RuleEngineInfo> findByMap(Map<String, Object> search)
/*    */   {
/* 93 */     return this.ruleEngineInfoMapper.listSelective(search);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\impl\RuleEngineInfoServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */