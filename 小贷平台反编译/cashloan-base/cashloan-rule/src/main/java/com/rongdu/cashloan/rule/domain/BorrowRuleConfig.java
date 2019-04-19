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
/*     */ public class BorrowRuleConfig
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long borrowRuleId;
/*     */   private Long ruleId;
/*     */   private Integer ruleSort;
/*     */   private Long configId;
/*     */   private Integer configSort;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  57 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  66 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getBorrowRuleId()
/*     */   {
/*  75 */     return this.borrowRuleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowRuleId(Long borrowRuleId)
/*     */   {
/*  84 */     this.borrowRuleId = borrowRuleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getRuleId()
/*     */   {
/*  93 */     return this.ruleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRuleId(Long ruleId)
/*     */   {
/* 102 */     this.ruleId = ruleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getRuleSort()
/*     */   {
/* 111 */     return this.ruleSort;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRuleSort(Integer ruleSort)
/*     */   {
/* 120 */     this.ruleSort = ruleSort;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getConfigId()
/*     */   {
/* 129 */     return this.configId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setConfigId(Long configId)
/*     */   {
/* 138 */     this.configId = configId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getConfigSort()
/*     */   {
/* 147 */     return this.configSort;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setConfigSort(Integer configSort)
/*     */   {
/* 156 */     this.configSort = configSort;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\domain\BorrowRuleConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */