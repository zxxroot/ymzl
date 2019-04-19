/*     */ package com.rongdu.cashloan.rule.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BorrowRuleEngine
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String ADAPTED_BEFORE = "10";
/*     */   public static final String ADAPTED_AFTER = "20";
/*     */   public static final String REAL_AUTH = "30";
/*     */   public static final String RISK_BORROW = "40";
/*     */   public static final String SH_REG = "50";
/*     */   private Long id;
/*     */   private String borrowTypeName;
/*     */   private String borrowType;
/*     */   private Integer ruleCount;
/*     */   private String adaptedId;
/*     */   private String adaptedName;
/*     */   private Date addTime;
/*     */   private String reqExt;
/*     */   
/*     */   public String getAdaptedNameById(String adaptedId)
/*     */   {
/*  30 */     String adaptedName = "";
/*  31 */     if ((adaptedId != null) && (adaptedId != "")) {
/*  32 */       if (adaptedId.equals("10")) {
/*  33 */         adaptedName = "贷前";
/*  34 */       } else if (adaptedId.equals("20")) {
/*  35 */         adaptedName = "贷后";
/*  36 */       } else if (adaptedId.equals("30")) {
/*  37 */         adaptedName = "实名";
/*  38 */       } else if (adaptedId.equals("40")) {
/*  39 */         adaptedName = "续贷";
/*  40 */       } else if (adaptedId.equals("50")) {
/*  41 */         adaptedName = "注册";
/*     */       }
/*     */     }
/*  44 */     return adaptedName;
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
/*     */   public Long getId()
/*     */   {
/*  93 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 102 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBorrowTypeName()
/*     */   {
/* 111 */     return this.borrowTypeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowTypeName(String borrowTypeName)
/*     */   {
/* 121 */     this.borrowTypeName = borrowTypeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBorrowType()
/*     */   {
/* 130 */     return this.borrowType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowType(String borrowType)
/*     */   {
/* 140 */     this.borrowType = borrowType;
/*     */   }
/*     */   
/*     */   public Integer getRuleCount() {
/* 144 */     return this.ruleCount;
/*     */   }
/*     */   
/*     */   public void setRuleCount(Integer ruleCount) {
/* 148 */     this.ruleCount = ruleCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 157 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 167 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReqExt()
/*     */   {
/* 176 */     return this.reqExt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReqExt(String reqExt)
/*     */   {
/* 186 */     this.reqExt = reqExt;
/*     */   }
/*     */   
/*     */   public String getAdaptedId() {
/* 190 */     return this.adaptedId;
/*     */   }
/*     */   
/*     */   public void setAdaptedId(String adaptedId) {
/* 194 */     this.adaptedId = adaptedId;
/*     */   }
/*     */   
/*     */   public String getAdaptedName() {
/* 198 */     return this.adaptedName;
/*     */   }
/*     */   
/*     */   public void setAdaptedName(String adaptedName) {
/* 202 */     this.adaptedName = adaptedName;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\domain\BorrowRuleEngine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */