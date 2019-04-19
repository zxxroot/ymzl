/*     */ package com.cashloan.cl.domain;
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
/*     */ public class YoudunLoanIndustry
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String loanPlatformCount;
/*     */   private String name;
/*     */   private String actualLoanPlatformCount;
/*     */   private String repaymentTimesCount;
/*     */   private String repaymentPlatformCount;
/*     */   
/*     */   public String getName()
/*     */   {
/*  42 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  46 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getActualLoanPlatformCount()
/*     */   {
/*  55 */     return this.actualLoanPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setActualLoanPlatformCount(String actualLoanPlatformCount)
/*     */   {
/*  64 */     this.actualLoanPlatformCount = actualLoanPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanPlatformCount()
/*     */   {
/*  74 */     return this.loanPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanPlatformCount(String loanPlatformCount)
/*     */   {
/*  83 */     this.loanPlatformCount = loanPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepaymentTimesCount()
/*     */   {
/*  92 */     return this.repaymentTimesCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepaymentTimesCount(String repaymentTimesCount)
/*     */   {
/* 101 */     this.repaymentTimesCount = repaymentTimesCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepaymentPlatformCount()
/*     */   {
/* 110 */     return this.repaymentPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepaymentPlatformCount(String repaymentPlatformCount)
/*     */   {
/* 119 */     this.repaymentPlatformCount = repaymentPlatformCount;
/*     */   }
/*     */ }
