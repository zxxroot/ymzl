/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ManageBorrowModel extends com.rongdu.cashloan.core.domain.Borrow
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private String stateStr;
/*     */   private Double repayAmount;
/*     */   private String repayTime;
/*     */   private Double penaltyAmout;
/*     */   private String penaltyDay;
/*     */   private long borrowId;
/*     */   private Date loanTime;
/*     */   private String level;
/*     */   private Double repayTotal;
/*     */   private Double repayYesTotal;
/*     */   private String sysName;
/*     */   private String borrowFee;
/*     */   
/*     */   public static ManageBorrowModel instance(com.rongdu.cashloan.core.domain.Borrow borrow)
/*     */   {
/*  25 */     ManageBorrowModel borrowModel = new ManageBorrowModel();
/*  26 */     org.springframework.beans.BeanUtils.copyProperties(borrow, borrowModel);
/*  27 */     return borrowModel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRepayTotal()
/*     */   {
/* 101 */     return this.repayTotal;
/*     */   }
/*     */   
/*     */   public void setRepayTotal(Double repayTotal) {
/* 105 */     this.repayTotal = repayTotal;
/*     */   }
/*     */   
/*     */   public Double getRepayYesTotal() {
/* 109 */     return this.repayYesTotal;
/*     */   }
/*     */   
/*     */   public void setRepayYesTotal(Double repayYesTotal) {
/* 113 */     this.repayYesTotal = repayYesTotal;
/*     */   }
/*     */   
/*     */   public Date getLoanTime() {
/* 117 */     return this.loanTime;
/*     */   }
/*     */   
/*     */   public void setLoanTime(Date loanTime) {
/* 121 */     this.loanTime = loanTime;
/*     */   }
/*     */   
/*     */   public Double getRepayAmount() {
/* 125 */     return this.repayAmount;
/*     */   }
/*     */   
/*     */   public void setRepayAmount(Double repayAmount) {
/* 129 */     this.repayAmount = repayAmount;
/*     */   }
/*     */   
/*     */   public String getRepayTime() {
/* 133 */     return this.repayTime;
/*     */   }
/*     */   
/*     */   public void setRepayTime(String repayTime) {
/* 137 */     this.repayTime = repayTime;
/*     */   }
/*     */   
/*     */   public Double getPenaltyAmout() {
/* 141 */     return this.penaltyAmout;
/*     */   }
/*     */   
/*     */   public void setPenaltyAmout(Double penaltyAmout) {
/* 145 */     this.penaltyAmout = penaltyAmout;
/*     */   }
/*     */   
/*     */   public String getPenaltyDay() {
/* 149 */     return this.penaltyDay;
/*     */   }
/*     */   
/*     */   public void setPenaltyDay(String penaltyDay) {
/* 153 */     this.penaltyDay = penaltyDay;
/*     */   }
/*     */   
/*     */   public String getStateStr() {
/* 157 */     this.stateStr = com.rongdu.cashloan.core.model.BorrowModel.manageConvertBorrowState(getState());
/* 158 */     return this.stateStr;
/*     */   }
/*     */   
/*     */   public void setStateStr(String stateStr) {
/* 162 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/* 166 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/* 170 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 174 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 178 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getBorrowId()
/*     */   {
/* 186 */     return this.borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowId(long borrowId)
/*     */   {
/* 194 */     this.borrowId = borrowId;
/*     */   }
/*     */   
/*     */   public String getLevel() {
/* 198 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(String level) {
/* 202 */     this.level = level;
/*     */   }
/*     */   
/*     */   public String getSysName() {
/* 206 */     return this.sysName;
/*     */   }
/*     */   
/*     */   public void setSysName(String sysName) {
/* 210 */     this.sysName = sysName;
/*     */   }
/*     */   
/*     */   public String getBorrowFee() {
/* 214 */     return this.borrowFee;
/*     */   }
/*     */   
/*     */   public void setBorrowFee(String borrowFee) {
/* 218 */     this.borrowFee = borrowFee;
/*     */   }
/*     */ }

