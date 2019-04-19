/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.BorrowRepay;
/*     */ import java.util.Date;
/*     */ import tool.util.BigDecimalUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManageBRepayModel
/*     */   extends BorrowRepay
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private String orderNo;
/*     */   private Double borrowAmount;
/*     */   private Double repayAmount;
/*     */   private Double repayTotal;
/*     */   private Date borrowTime;
/*     */   private String channelName;
/*     */   
/*     */   public String getChannelName()
/*     */   {
/*  53 */     return this.channelName;
/*     */   }
/*     */   
/*     */   public void setChannelName(String channelName) {
/*  57 */     this.channelName = channelName;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/*  61 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/*  65 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/*  69 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  73 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getOrderNo() {
/*  77 */     return this.orderNo;
/*     */   }
/*     */   
/*     */   public void setOrderNo(String orderNo) {
/*  81 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */   public Double getBorrowAmount() {
/*  85 */     return this.borrowAmount;
/*     */   }
/*     */   
/*     */   public void setBorrowAmount(Double borrowAmount) {
/*  89 */     this.borrowAmount = borrowAmount;
/*     */   }
/*     */   
/*     */   public Double getRepayAmount() {
/*  93 */     return this.repayAmount;
/*     */   }
/*     */   
/*     */   public void setRepayAmount(Double repayAmount) {
/*  97 */     this.repayAmount = repayAmount;
/*     */   }
/*     */   
/*     */   public Double getRepayTotal() {
/* 101 */     this.repayTotal = Double.valueOf(BigDecimalUtil.add(new double[] { getRepayAmount().doubleValue(), getPenaltyAmout().doubleValue() }));
/* 102 */     return this.repayTotal;
/*     */   }
/*     */   
/*     */   public void setRepayTotal(Double repayTotal) {
/* 106 */     this.repayTotal = repayTotal;
/*     */   }
/*     */   
/*     */   public Date getBorrowTime() {
/* 110 */     return this.borrowTime;
/*     */   }
/*     */   
/*     */   public void setBorrowTime(Date borrowTime) {
/* 114 */     this.borrowTime = borrowTime;
/*     */   }
/*     */ }
