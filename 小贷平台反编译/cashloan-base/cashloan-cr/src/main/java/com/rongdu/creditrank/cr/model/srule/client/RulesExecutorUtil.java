/*     */ package com.rongdu.creditrank.cr.model.srule.client;
/*     */ 
/*     */ import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
/*     */ import com.rongdu.creditrank.cr.model.srule.model.ScoreOrientedRule;
/*     */ import com.rongdu.creditrank.cr.model.srule.model.SimpleRule;
/*     */ import com.rongdu.creditrank.cr.model.srule.utils.GenerateRule;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
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
/*     */ public class RulesExecutorUtil
/*     */ {
/*     */   public static Map<String, List<SimpleRule>> builtResult(Map<String, List<SimpleRule>> maps)
/*     */   {
/*  33 */     Iterator<Map.Entry<String, List<SimpleRule>>> entries = maps.entrySet().iterator();
/*  34 */     Map<String, String> resultMap = new HashMap();
/*  35 */     while (entries.hasNext()) {
/*  36 */       Map.Entry<String, List<SimpleRule>> entry = (Map.Entry)entries.next();
/*  37 */       String key = (String)entry.getKey();
/*  38 */       List<SimpleRule> simpleList = (List)entry.getValue();
/*  39 */       for (int i = 0; i < simpleList.size(); i++) {
/*  40 */         SimpleRule simpleRule = (SimpleRule)simpleList.get(i);
/*  41 */         boolean result = false;
/*  42 */         if ("string".equals(simpleRule.getType())) {
/*  43 */           result = GenerateRule.genTextResult(simpleRule);
/*  44 */         } else if ("int".equals(simpleRule.getType())) {
/*  45 */           Rule rule = GenerateRule.genNumRule(simpleRule);
/*  46 */           result = rule.beginMatch();
/*     */         }
/*     */         
/*  49 */         if (result) {
/*  50 */           simpleRule.setComparResult("Y");
/*  51 */           resultMap.put(key, simpleRule.getResultType());
/*  52 */           if (!(simpleRule instanceof ScoreOrientedRule)) break;
/*  53 */           ScoreOrientedRule soRule = (ScoreOrientedRule)simpleRule;
/*  54 */           soRule.setResultScore(soRule.getScore());
/*     */           
/*  56 */           break;
/*     */         }
/*  58 */         simpleRule.setComparResult("N");
/*     */         
/*  60 */         simpleList.set(i, simpleRule);
/*     */       }
/*  62 */       maps.put(key, simpleList);
/*     */     }
/*  64 */     return maps;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SimpleRule singleRuleResult(SimpleRule simpleRule)
/*     */   {
/*  73 */     boolean result = false;
/*  74 */     if ("string".equals(simpleRule.getType()))
/*     */     {
/*  76 */       result = GenerateRule.genTextResult(simpleRule);
/*  77 */     } else if ("int".equals(simpleRule.getType()))
/*     */     {
/*  79 */       Rule rule = GenerateRule.genNumRule(simpleRule);
/*  80 */       result = rule.beginMatch();
/*     */     }
/*  82 */     if (result) {
/*  83 */       simpleRule.setComparResult("Y");
/*     */     } else {
/*  85 */       simpleRule.setComparResult("N");
/*     */     }
/*     */     
/*  88 */     return simpleRule;
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
/*     */   public static SimpleRule singleRuleResult(Long id, String name, String formula, String range, String value, String type, String resultType)
/*     */   {
/* 103 */     SimpleRule simpleRule = new SimpleRule(id, name, formula, value, range, type, resultType);
/* 104 */     return singleRuleResult(simpleRule);
/*     */   }
/*     */ }
