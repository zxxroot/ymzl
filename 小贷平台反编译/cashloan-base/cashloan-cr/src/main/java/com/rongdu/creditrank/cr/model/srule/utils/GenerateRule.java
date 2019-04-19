/*     */ package com.rongdu.creditrank.cr.model.srule.utils;
/*     */ 
/*     */ import com.rongdu.creditrank.cr.model.srule.config.builder.RuleBuilder;
/*     */ import com.rongdu.creditrank.cr.model.srule.config.builder.RuleBuilderCreator;
/*     */ import com.rongdu.creditrank.cr.model.srule.config.builder.RuleConfigurer;
/*     */ import com.rongdu.creditrank.cr.model.srule.config.condition.ConditionItem;
/*     */ import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
/*     */ import com.rongdu.creditrank.cr.model.srule.model.Formula;
/*     */ import com.rongdu.creditrank.cr.model.srule.model.SimpleRule;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class GenerateRule
/*     */ {
/*  26 */   private static final Logger logger = Logger.getLogger(GenerateRule.class);
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
/*     */   public static boolean genTextResult(String rule, String scop, String value)
/*     */   {
/*  41 */     return comparText(rule, scop, value);
/*     */   }
/*     */   
/*     */   public static boolean comparText(String formula, String scop, String value) {
/*  45 */     boolean result = false;
/*  46 */     if (Formula.include.getName().equals(formula)) {
/*  47 */       result = StringUtil.contains(scop, value);
/*  48 */     } else if (Formula.exclude.getName().equals(formula)) {
/*  49 */       result = !StringUtil.contains(scop, value);
/*  50 */     } else if (Formula.equal.getName().equals(formula)) {
/*  51 */       result = StringUtil.equals(scop, value);
/*  52 */     } else if (Formula.not_equal.getName().equals(formula)) {
/*  53 */       result = !StringUtil.equals(scop, value);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */     return result;
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
/*     */ 
/*     */   public static Rule genNumRule(Long id, String colName, String rule, String scop, Double value)
/*     */   {
/*  80 */     RuleBuilder<Double> builder = RuleBuilderCreator.numRuleBuilder();
/*  81 */     ConditionItem items = builder.newConditionItems();
/*  82 */     items.add(rule, Double.valueOf(scop));
/*  83 */     Rule rtRule = null;
/*     */     try {
/*  85 */       rtRule = builder.newRule(id.longValue(), colName, items).rulePolicy(RulePolicy.MATCHALL).build();
/*  86 */       rtRule.matchTo(value);
/*     */     } catch (IllegalAccessException e) {
/*  88 */       logger.error(e);
/*     */     } catch (InstantiationException e) {
/*  90 */       logger.error(e);
/*     */     } catch (Exception e) {
/*  92 */       logger.error(e);
/*     */     }
/*     */     
/*  95 */     return rtRule;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean genTextResult(SimpleRule rule)
/*     */   {
/* 106 */     return comparText(rule.getFormula(), rule.getRange(), rule.getValue());
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
/*     */ 
/*     */ 
/*     */   public static Rule genNumRule(SimpleRule rule)
/*     */   {
/* 123 */     RuleBuilder<Double> builder = RuleBuilderCreator.numRuleBuilder();
/* 124 */     ConditionItem items = buildNumItems(builder, rule.getFormula(), rule.getRange());
/* 125 */     Rule rtRule = null;
/*     */     try {
/* 127 */       rtRule = builder.newRule(rule.getRuleId().longValue(), rule.getName(), items).rulePolicy(RulePolicy.MATCHALL).build();
/* 128 */       rtRule.matchTo(Double.valueOf(rule.getValue()));
/*     */     } catch (IllegalAccessException e) {
/* 130 */       logger.error(e);
/*     */     } catch (InstantiationException e) {
/* 132 */       logger.error(e);
/*     */     } catch (Exception e) {
/* 134 */       logger.error(e);
/*     */     }
/*     */     
/* 137 */     return rtRule;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ConditionItem buildNumItems(RuleBuilder<Double> builder, String formula, String range)
/*     */   {
/* 148 */     ConditionItem items = builder.newConditionItems();
/* 149 */     if (Formula.greater.getName().equals(formula)) {
/* 150 */       items.add(Formula.greater.getName(), Double.valueOf(range));
/* 151 */     } else if (Formula.less.getName().equals(formula)) {
/* 152 */       items.add(Formula.less.getName(), Double.valueOf(range));
/* 153 */     } else if (Formula.equal.getName().equals(formula)) {
/* 154 */       items.add(Formula.equal.getName(), Double.valueOf(range));
/* 155 */     } else if (Formula.not_equal.getName().equals(formula)) {
/* 156 */       items.add(Formula.not_equal.getName(), Double.valueOf(range));
/* 157 */     } else if (Formula.greater_equal.getName().equals(formula)) {
/* 158 */       items.add(Formula.greater_equal.getName(), Double.valueOf(range));
/* 159 */     } else if (Formula.less_equal.getName().equals(formula)) {
/* 160 */       items.add(Formula.less_equal.getName(), Double.valueOf(range));
/* 161 */     } else if (Formula.greater_equal_and_less_equal.getName().equals(formula)) {
/* 162 */       String[] ranges = range.trim().split(",");
/* 163 */       items.add(Formula.greater_equal.getName(), Double.valueOf(ranges[0]));
/* 164 */       items.add(Formula.less_equal.getName(), Double.valueOf(ranges[1]));
/* 165 */     } else if (Formula.greater_equal_and_less.getName().equals(formula)) {
/* 166 */       String[] ranges = range.trim().split(",");
/* 167 */       items.add(Formula.greater_equal.getName(), Double.valueOf(ranges[0]));
/* 168 */       items.add(Formula.less.getName(), Double.valueOf(ranges[1]));
/* 169 */     } else if (Formula.greater_and_less_equal.getName().equals(formula)) {
/* 170 */       String[] ranges = range.trim().split(",");
/* 171 */       items.add(Formula.greater.getName(), Double.valueOf(ranges[0]));
/* 172 */       items.add(Formula.less_equal.getName(), Double.valueOf(ranges[1]));
/* 173 */     } else if (Formula.greater_and_less.getName().equals(formula)) {
/* 174 */       String[] ranges = range.trim().split(",");
/* 175 */       items.add(Formula.greater.getName(), Double.valueOf(ranges[0]));
/* 176 */       items.add(Formula.less.getName(), Double.valueOf(ranges[1]));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 181 */     return items;
/*     */   }
/*     */ }
