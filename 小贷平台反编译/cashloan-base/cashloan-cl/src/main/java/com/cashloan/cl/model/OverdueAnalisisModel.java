/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import tool.util.NumberUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OverdueAnalisisModel
/*     */ {
/*     */   private String date;
/*     */   private String overdueCount;
/*     */   private String overdueAmt;
/*     */   private String penaltyAmout;
/*     */   private String urgeRepayBorrow;
/*     */   private String urgeRepayCount;
/*     */   private String urgeRepaySuccess;
/*     */   private String badCount;
/*     */   private String apr;
/*     */   
/*     */   public String getDate()
/*     */   {
/*  68 */     return this.date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDate(String date)
/*     */   {
/*  76 */     this.date = date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOverdueCount()
/*     */   {
/*  84 */     return this.overdueCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOverdueCount(String overdueCount)
/*     */   {
/*  92 */     this.overdueCount = overdueCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOverdueAmt()
/*     */   {
/* 100 */     return this.overdueAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOverdueAmt(String overdueAmt)
/*     */   {
/* 108 */     this.overdueAmt = overdueAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPenaltyAmout()
/*     */   {
/* 116 */     return this.penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPenaltyAmout(String penaltyAmout)
/*     */   {
/* 124 */     this.penaltyAmout = penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUrgeRepayBorrow()
/*     */   {
/* 132 */     return this.urgeRepayBorrow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUrgeRepayBorrow(String urgeRepayBorrow)
/*     */   {
/* 140 */     this.urgeRepayBorrow = urgeRepayBorrow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUrgeRepayCount()
/*     */   {
/* 148 */     return this.urgeRepayCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUrgeRepayCount(String urgeRepayCount)
/*     */   {
/* 156 */     this.urgeRepayCount = urgeRepayCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUrgeRepaySuccess()
/*     */   {
/* 164 */     return this.urgeRepaySuccess;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUrgeRepaySuccess(String urgeRepaySuccess)
/*     */   {
/* 172 */     this.urgeRepaySuccess = urgeRepaySuccess;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBadCount()
/*     */   {
/* 180 */     return this.badCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBadCount(String badCount)
/*     */   {
/* 188 */     this.badCount = badCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApr()
/*     */   {
/* 196 */     String urgeRepayCount = getUrgeRepayCount();
/* 197 */     String urgeRepaySuccess = getUrgeRepaySuccess();
/* 198 */     if ((StringUtil.isNotBlank(urgeRepayCount)) && (StringUtil.isNotBlank(urgeRepaySuccess))) {
/* 199 */       Double count = Double.valueOf(urgeRepayCount);
/* 200 */       Double success = Double.valueOf(urgeRepaySuccess);
/* 201 */       if ((count.doubleValue() > 0.0D) && (success.doubleValue() > 0.0D)) {
/* 202 */         Double aprValue = Double.valueOf(success.doubleValue() / count.doubleValue());
/* 203 */         this.apr = NumberUtil.format2Str(aprValue.doubleValue() * 100.0D);
/*     */       } else {
/* 205 */         this.apr = "0.00";
/*     */       }
/*     */     }
/* 208 */     return this.apr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApr(String apr)
/*     */   {
/* 216 */     this.apr = apr;
/*     */   }
/*     */ }
