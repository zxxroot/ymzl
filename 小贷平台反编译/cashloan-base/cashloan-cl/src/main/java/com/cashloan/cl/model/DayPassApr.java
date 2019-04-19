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
/*     */ public class DayPassApr
/*     */ {
/*     */   private String date;
/*     */   private String borrowUserCount;
/*     */   private String loanUserCount;
/*     */   private String borrowPassApr;
/*     */   private String brrowCount;
/*     */   private String loanCount;
/*     */   private String borrowApr;
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
/*     */   public String getBorrowUserCount()
/*     */   {
/*  73 */     return this.borrowUserCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowUserCount(String borrowUserCount)
/*     */   {
/*  81 */     this.borrowUserCount = borrowUserCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanUserCount()
/*     */   {
/*  89 */     return this.loanUserCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanUserCount(String loanUserCount)
/*     */   {
/*  97 */     this.loanUserCount = loanUserCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBorrowPassApr()
/*     */   {
/* 105 */     this.borrowPassApr = NumberUtil.format2Str(Double.valueOf(this.borrowPassApr).doubleValue());
/* 106 */     return this.borrowPassApr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowPassApr(String borrowPassApr)
/*     */   {
/* 114 */     this.borrowPassApr = borrowPassApr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBrrowCount()
/*     */   {
/* 122 */     return this.brrowCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBrrowCount(String brrowCount)
/*     */   {
/* 130 */     this.brrowCount = brrowCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanCount()
/*     */   {
/* 138 */     return this.loanCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanCount(String loanCount)
/*     */   {
/* 146 */     this.loanCount = loanCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBorrowApr()
/*     */   {
/* 154 */     this.borrowApr = NumberUtil.format2Str(Double.valueOf(this.borrowApr).doubleValue());
/* 155 */     return this.borrowApr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowApr(String borrowApr)
/*     */   {
/* 163 */     this.borrowApr = borrowApr;
/*     */   }
/*     */ }
