/*     */ package com.cashloan.cl.model;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManageBorrowExportModel
/*     */   extends Borrow
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private Date loanTime;
/*     */   private String penaltyDay;
/*     */   private double penaltyAmout;
/*     */   private Date repayTime;
/*     */   private double repayAmount;
/*     */   private String level;
/*     */   
/*     */   public String getRealName()
/*     */   {
/*  55 */     return this.realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRealName(String realName)
/*     */   {
/*  62 */     this.realName = realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPhone()
/*     */   {
/*  69 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/*  76 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getLoanTime()
/*     */   {
/*  83 */     return this.loanTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLoanTime(Date loanTime)
/*     */   {
/*  90 */     this.loanTime = loanTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPenaltyDay()
/*     */   {
/*  97 */     return this.penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPenaltyDay(String penaltyDay)
/*     */   {
/* 104 */     this.penaltyDay = penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getPenaltyAmout()
/*     */   {
/* 111 */     return this.penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPenaltyAmout(double penaltyAmout)
/*     */   {
/* 118 */     this.penaltyAmout = penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getRepayTime()
/*     */   {
/* 125 */     return this.repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRepayTime(Date repayTime)
/*     */   {
/* 132 */     this.repayTime = repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getRepayAmount()
/*     */   {
/* 139 */     return this.repayAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRepayAmount(double repayAmount)
/*     */   {
/* 146 */     this.repayAmount = repayAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getLevel()
/*     */   {
/* 153 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(String level)
/*     */   {
/* 160 */     this.level = level;
/*     */   }
/*     */ }
