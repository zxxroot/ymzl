/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import tool.util.BigDecimalUtil;
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
/*     */ public class RepayAnalisisModel
/*     */ {
/*     */   private String date;
/*     */   private String repayCount;
/*     */   private String overdueCount;
/*     */   private String repayAmt;
/*     */   private String penaltyRepayAmt;
/*     */   private String apr;
/*     */   private String amountApr;
/*     */   
/*     */   public String getDate()
/*     */   {
/*  57 */     return this.date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDate(String date)
/*     */   {
/*  65 */     this.date = date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayCount()
/*     */   {
/*  73 */     return this.repayCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayCount(String repayCount)
/*     */   {
/*  81 */     this.repayCount = repayCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOverdueCount()
/*     */   {
/*  89 */     return this.overdueCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOverdueCount(String overdueCount)
/*     */   {
/*  97 */     this.overdueCount = overdueCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayAmt()
/*     */   {
/* 105 */     return this.repayAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayAmt(String repayAmt)
/*     */   {
/* 113 */     this.repayAmt = repayAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApr()
/*     */   {
/* 122 */     String repayCount = getRepayCount();
/* 123 */     String overdueCount = getOverdueCount();
/* 124 */     if ((StringUtil.isNotBlank(repayCount)) && (StringUtil.isNotBlank(overdueCount)) && (Double.valueOf(repayCount).doubleValue() > 0.0D)) {
/* 125 */       Double repay = Double.valueOf(repayCount);
/* 126 */       Double overdue = Double.valueOf(overdueCount);
/* 127 */       Double aprValue = Double.valueOf(overdue.doubleValue() / repay.doubleValue());
/* 128 */       this.apr = StringUtil.isNull(Double.valueOf(BigDecimalUtil.decimal(aprValue.doubleValue() * 100.0D, 2)));
/*     */     } else {
/* 130 */       this.apr = "0.00";
/*     */     }
/* 132 */     return this.apr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApr(String apr)
/*     */   {
/* 140 */     this.apr = apr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPenaltyRepayAmt()
/*     */   {
/* 147 */     return this.penaltyRepayAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPenaltyRepayAmt(String penaltyRepayAmt)
/*     */   {
/* 154 */     this.penaltyRepayAmt = penaltyRepayAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAmountApr()
/*     */   {
/* 161 */     String repayAmt = getRepayAmt();
/* 162 */     String penaltyRepayAmt = getPenaltyRepayAmt();
/* 163 */     if ((StringUtil.isNotBlank(repayAmt)) && (StringUtil.isNotBlank(penaltyRepayAmt)) && (Double.valueOf(repayAmt).doubleValue() > 0.0D)) {
/* 164 */       this.amountApr = StringUtil.isNull(Double.valueOf(BigDecimalUtil.decimal(Double.valueOf(penaltyRepayAmt).doubleValue() / Double.valueOf(repayAmt).doubleValue() * 100.0D, 2)));
/*     */     } else {
/* 166 */       this.amountApr = "0.00";
/*     */     }
/* 168 */     return this.amountApr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAmountApr(String amountApr)
/*     */   {
/* 175 */     this.amountApr = amountApr;
/*     */   }
/*     */ }
