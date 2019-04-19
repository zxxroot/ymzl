/*     */ package com.rongdu.cashloan.rule.domain;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class RuleEngineInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long ruleEnginId;
/*     */   private Integer minIntegral;
/*     */   private Integer maxIntegral;
/*     */   private String result;
/*     */   private String reqExt;
/*     */   private String formula;
/*     */   private Integer integral;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  64 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  73 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getRuleEnginId()
/*     */   {
/*  82 */     return this.ruleEnginId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRuleEnginId(Long ruleEnginId)
/*     */   {
/*  91 */     this.ruleEnginId = ruleEnginId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getMinIntegral()
/*     */   {
/* 100 */     return this.minIntegral;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMinIntegral(Integer minIntegral)
/*     */   {
/* 109 */     this.minIntegral = minIntegral;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getMaxIntegral()
/*     */   {
/* 118 */     return this.maxIntegral;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMaxIntegral(Integer maxIntegral)
/*     */   {
/* 127 */     this.maxIntegral = maxIntegral;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResult()
/*     */   {
/* 136 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResult(String result)
/*     */   {
/* 145 */     this.result = result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReqExt()
/*     */   {
/* 154 */     return this.reqExt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReqExt(String reqExt)
/*     */   {
/* 163 */     this.reqExt = reqExt;
/*     */   }
/*     */   
/*     */   public String getFormula() {
/* 167 */     return this.formula;
/*     */   }
/*     */   
/*     */   public void setFormula(String formula) {
/* 171 */     this.formula = formula;
/*     */   }
/*     */   
/*     */   public Integer getIntegral() {
/* 175 */     return this.integral;
/*     */   }
/*     */   
/*     */   public void setIntegral(Integer integral) {
/* 179 */     this.integral = integral;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\domain\RuleEngineInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */