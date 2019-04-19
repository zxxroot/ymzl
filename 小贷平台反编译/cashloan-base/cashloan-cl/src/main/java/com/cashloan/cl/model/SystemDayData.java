/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import tool.util.NumberUtil;
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
/*     */ public class SystemDayData
/*     */ {
/*     */   private String date;
/*     */   private String userCount;
/*     */   private String borrowCount;
/*     */   private String loanCount;
/*     */   private String apr;
/*     */   private String overdueCount;
/*     */   private String badAmtCount;
/*     */   private String badAmt;
/*     */   private String loanAmt;
/*     */   private String repayAmt;
/*     */   private String servFeeAmt;
/*     */   private String overdueAmt;
/*     */   private String urgeRepayCount;
/*     */   private String overdueInterest;
/*     */   
/*     */   public String getDate()
/*     */   {
/*  93 */     return this.date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDate(String date)
/*     */   {
/* 101 */     this.date = date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserCount()
/*     */   {
/* 109 */     return this.userCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserCount(String userCount)
/*     */   {
/* 117 */     this.userCount = userCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBorrowCount()
/*     */   {
/* 125 */     return this.borrowCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowCount(String borrowCount)
/*     */   {
/* 133 */     this.borrowCount = borrowCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanCount()
/*     */   {
/* 141 */     return this.loanCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanCount(String loanCount)
/*     */   {
/* 149 */     this.loanCount = loanCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApr()
/*     */   {
/* 157 */     Double loan = Double.valueOf(getLoanCount());
/* 158 */     Double borrow = Double.valueOf(getBorrowCount());
/* 159 */     if ((loan.doubleValue() > 0.0D) && (borrow.doubleValue() > 0.0D)) {
/* 160 */       this.apr = NumberUtil.format2Str(loan.doubleValue() / borrow.doubleValue() * 100.0D);
/*     */     } else {
/* 162 */       this.apr = "0.00";
/*     */     }
/* 164 */     return this.apr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApr(String apr)
/*     */   {
/* 172 */     this.apr = apr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOverdueCount()
/*     */   {
/* 180 */     return this.overdueCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOverdueCount(String overdueCount)
/*     */   {
/* 188 */     this.overdueCount = overdueCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBadAmtCount()
/*     */   {
/* 196 */     return this.badAmtCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBadAmtCount(String badAmtCount)
/*     */   {
/* 204 */     this.badAmtCount = badAmtCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBadAmt()
/*     */   {
/* 212 */     return this.badAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBadAmt(String badAmt)
/*     */   {
/* 220 */     this.badAmt = badAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanAmt()
/*     */   {
/* 228 */     return this.loanAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanAmt(String loanAmt)
/*     */   {
/* 236 */     this.loanAmt = loanAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayAmt()
/*     */   {
/* 244 */     return this.repayAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayAmt(String repayAmt)
/*     */   {
/* 252 */     this.repayAmt = repayAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getServFeeAmt()
/*     */   {
/* 260 */     return this.servFeeAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setServFeeAmt(String servFeeAmt)
/*     */   {
/* 268 */     this.servFeeAmt = servFeeAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOverdueAmt()
/*     */   {
/* 276 */     return this.overdueAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOverdueAmt(String overdueAmt)
/*     */   {
/* 284 */     this.overdueAmt = overdueAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUrgeRepayCount()
/*     */   {
/* 292 */     return this.urgeRepayCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUrgeRepayCount(String urgeRepayCount)
/*     */   {
/* 300 */     this.urgeRepayCount = urgeRepayCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOverdueInterest()
/*     */   {
/* 308 */     return this.overdueInterest;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOverdueInterest(String overdueInterest)
/*     */   {
/* 316 */     this.overdueInterest = overdueInterest;
/*     */   }
/*     */ }
