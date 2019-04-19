/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RepayModel
/*     */ {
/*     */   private long id;
/*     */   private long borrowId;
/*     */   private Date repayTime;
/*     */   private String repayTimeStr;
/*     */   private double amount;
/*     */   private double realAmount;
/*     */   private double fee;
/*     */   private double penaltyAmout;
/*     */   private String penaltyDay;
/*     */   private String msg;
/*     */   private String isPunish;
/*     */   private String state;
/*     */   
/*     */   public Date getRepayTime()
/*     */   {
/*  33 */     return this.repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setRepayTime(Date repayTime)
/*     */   {
/*  39 */     this.repayTime = repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public double getAmount()
/*     */   {
/*  45 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setAmount(double amount)
/*     */   {
/*  51 */     this.amount = amount;
/*     */   }
/*     */   
/*     */ 
/*     */   public double getRealAmount()
/*     */   {
/*  57 */     return this.realAmount;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setRealAmount(double realAmount)
/*     */   {
/*  63 */     this.realAmount = realAmount;
/*     */   }
/*     */   
/*     */ 
/*     */   public double getFee()
/*     */   {
/*  69 */     return this.fee;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setFee(double fee)
/*     */   {
/*  75 */     this.fee = fee;
/*     */   }
/*     */   
/*     */ 
/*     */   public double getPenaltyAmout()
/*     */   {
/*  81 */     return this.penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setPenaltyAmout(double penaltyAmout)
/*     */   {
/*  87 */     this.penaltyAmout = penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getMsg()
/*     */   {
/*  93 */     return this.msg;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setMsg(String msg)
/*     */   {
/*  99 */     this.msg = msg;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getRepayTimeStr()
/*     */   {
/* 105 */     return this.repayTimeStr;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setRepayTimeStr(String repayTimeStr)
/*     */   {
/* 111 */     this.repayTimeStr = repayTimeStr;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getIsPunish()
/*     */   {
/* 117 */     return this.isPunish;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setIsPunish(String isPunish)
/*     */   {
/* 123 */     this.isPunish = isPunish;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getPenaltyDay()
/*     */   {
/* 129 */     return this.penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setPenaltyDay(String penaltyDay)
/*     */   {
/* 135 */     this.penaltyDay = penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getId()
/*     */   {
/* 141 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setId(long id)
/*     */   {
/* 147 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getBorrowId()
/*     */   {
/* 153 */     return this.borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setBorrowId(long borrowId)
/*     */   {
/* 159 */     this.borrowId = borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getState()
/*     */   {
/* 165 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 171 */     this.state = state;
/*     */   }
/*     */ }
