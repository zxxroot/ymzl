/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.model.BorrowModel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClBorrowModel
/*     */   extends Borrow
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String cardNo;
/*     */   private String bank;
/*     */   private String stateStr;
/*     */   private double penaltyAmount;
/*     */   private int penaltyDay;
/*     */   private Date realTime;
/*     */   private Date repayTime;
/*     */   private double agentAmount;
/*     */   private double repayAmount;
/*     */   private String creditTimeStr;
/*     */   private String penalty;
/*     */   private String overdueAmount;
/*     */   
/*     */   public double getPenaltyAmount()
/*     */   {
/*  48 */     return this.penaltyAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPenaltyAmount(double penaltyAmount)
/*     */   {
/*  55 */     this.penaltyAmount = penaltyAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getAgentAmount()
/*     */   {
/*  62 */     return this.agentAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAgentAmount(double agentAmount)
/*     */   {
/*  69 */     this.agentAmount = agentAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPenaltyDay()
/*     */   {
/*  76 */     return this.penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPenaltyDay(int penaltyDay)
/*     */   {
/*  83 */     this.penaltyDay = penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getRealTime()
/*     */   {
/*  90 */     return this.realTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRealTime(Date realTime)
/*     */   {
/*  97 */     this.realTime = realTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCardNo()
/*     */   {
/* 104 */     return this.cardNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCardNo(String cardNo)
/*     */   {
/* 111 */     this.cardNo = cardNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBank()
/*     */   {
/* 118 */     return this.bank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBank(String bank)
/*     */   {
/* 125 */     this.bank = bank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getStateStr()
/*     */   {
/* 132 */     this.stateStr = BorrowModel.apiConvertBorrowState(getState());
/* 133 */     return this.stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStateStr(String stateStr)
/*     */   {
/* 140 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getRepayTime()
/*     */   {
/* 147 */     return this.repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRepayTime(Date repayTime)
/*     */   {
/* 154 */     this.repayTime = repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getRepayAmount()
/*     */   {
/* 161 */     return this.repayAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRepayAmount(double repayAmount)
/*     */   {
/* 168 */     this.repayAmount = repayAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCreditTimeStr()
/*     */   {
/* 175 */     return this.creditTimeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreditTimeStr(String creditTimeStr)
/*     */   {
/* 182 */     this.creditTimeStr = creditTimeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPenalty()
/*     */   {
/* 189 */     return this.penalty;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPenalty(String penalty)
/*     */   {
/* 196 */     this.penalty = penalty;
/*     */   }
/*     */   
/*     */   public String getOverdueAmount() {
/* 200 */     return this.overdueAmount;
/*     */   }
/*     */   
/*     */   public void setOverdueAmount(String overdueAmount) {
/* 204 */     this.overdueAmount = overdueAmount;
/*     */   }
/*     */ }
