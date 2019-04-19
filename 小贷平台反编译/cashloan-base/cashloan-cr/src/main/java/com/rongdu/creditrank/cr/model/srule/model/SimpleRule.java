/*     */ package com.rongdu.creditrank.cr.model.srule.model;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleRule
/*     */ {
/*     */   public static final String NUMERIC = "int";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String TEXT = "string";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String COMPAR_PASS = "Y";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String COMPAR_FAIL = "N";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long ruleId;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String name;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String formula;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String value;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String range;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String resultType;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String comparResult;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SimpleRule() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SimpleRule(Long ruleId, String name, String formula, String value, String range, String type, String resultType)
/*     */   {
/*  91 */     this.ruleId = ruleId;
/*  92 */     this.name = name;
/*  93 */     this.formula = formula;
/*  94 */     this.value = value;
/*  95 */     this.range = range;
/*  96 */     this.type = type;
/*  97 */     this.resultType = resultType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getRuleId()
/*     */   {
/* 106 */     return this.ruleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRuleId(Long ruleId)
/*     */   {
/* 114 */     this.ruleId = ruleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 122 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 130 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFormula()
/*     */   {
/* 138 */     return this.formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFormula(String formula)
/*     */   {
/* 146 */     this.formula = formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getValue()
/*     */   {
/* 154 */     return this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setValue(String value)
/*     */   {
/* 162 */     this.value = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRange()
/*     */   {
/* 170 */     return this.range;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRange(String range)
/*     */   {
/* 178 */     this.range = range;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/* 186 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 194 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResultType()
/*     */   {
/* 203 */     return this.resultType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResultType(String resultType)
/*     */   {
/* 211 */     this.resultType = resultType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getComparResult()
/*     */   {
/* 219 */     return this.comparResult;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setComparResult(String comparResult)
/*     */   {
/* 227 */     this.comparResult = comparResult;
/*     */   }
/*     */ }
