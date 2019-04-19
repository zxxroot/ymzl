/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */
/*     */

import com.cashloan.cl.domain.BorrowRepayLog;
import tool.util.BigDecimalUtil;
import tool.util.StringUtil;

import java.util.Date;

/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManageBRepayLogModel
/*     */   extends BorrowRepayLog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String state;
/*     */   private String orderNo;
/*     */   private Double borrowAmount;
/*     */   private Double fee;
/*     */   private Double repayAmount;
/*     */   private Double repayLogAmount;
/*     */   private Date repayPlanTime;
/*     */   private Double repayPenalty;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private Double repayTotal;
/*     */   private Double repayYesTotal;
/*     */   private String channelName;
/*     */   
/*     */   public String getChannelName()
/*     */   {
/*  71 */     return this.channelName;
/*     */   }
/*     */   
/*     */   public void setChannelName(String channelName) {
/*  75 */     this.channelName = channelName;
/*     */   }
/*     */   
/*     */   public Double getRepayYesTotal() {
/*  79 */     this.repayYesTotal = Double.valueOf(BigDecimalUtil.add(new double[] {
/*  80 */       StringUtil.isNotBlank(getRepayLogAmount()) ? getRepayLogAmount().doubleValue() : 0.0D, 
/*  81 */       StringUtil.isNotBlank(getPenaltyAmout()) ? getPenaltyAmout().doubleValue() : 0.0D }));
/*  82 */     return this.repayYesTotal;
/*     */   }
/*     */   
/*     */   public void setRepayYesTotal(Double repayYesTotal) {
/*  86 */     this.repayYesTotal = repayYesTotal;
/*     */   }
/*     */   
/*     */   public Double getRepayTotal() {
/*  90 */     this.repayTotal = Double.valueOf(BigDecimalUtil.add(new double[] {
/*  91 */       StringUtil.isNotBlank(getRepayAmount()) ? getRepayAmount().doubleValue() : 0.0D, 
/*  92 */       StringUtil.isNotBlank(getRepayPenalty()) ? getRepayPenalty().doubleValue() : 0.0D }));
/*  93 */     return this.repayTotal;
/*     */   }
/*     */   
/*     */   public void setRepayTotal(Double repayTotal) {
/*  97 */     this.repayTotal = repayTotal;
/*     */   }
/*     */   
/* 100 */   public Double getRepayPenalty() { return this.repayPenalty; }
/*     */   
/*     */   public void setRepayPenalty(Double repayPenalty)
/*     */   {
/* 104 */     this.repayPenalty = repayPenalty;
/*     */   }
/*     */   
/*     */   public Date getRepayPlanTime() {
/* 108 */     return this.repayPlanTime;
/*     */   }
/*     */   
/*     */   public void setRepayPlanTime(Date repayPlanTime) {
/* 112 */     this.repayPlanTime = repayPlanTime;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 116 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 120 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getOrderNo() {
/* 124 */     return this.orderNo;
/*     */   }
/*     */   
/*     */   public void setOrderNo(String orderNo) {
/* 128 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */   public Double getBorrowAmount() {
/* 132 */     return this.borrowAmount;
/*     */   }
/*     */   
/*     */   public void setBorrowAmount(Double borrowAmount) {
/* 136 */     this.borrowAmount = borrowAmount;
/*     */   }
/*     */   
/*     */   public Double getRepayAmount() {
/* 140 */     return this.repayAmount;
/*     */   }
/*     */   
/*     */   public void setRepayAmount(Double repayAmount) {
/* 144 */     this.repayAmount = repayAmount;
/*     */   }
/*     */   
/*     */   public Double getRepayLogAmount() {
/* 148 */     return this.repayLogAmount;
/*     */   }
/*     */   
/*     */   public void setRepayLogAmount(Double repayLogAmount) {
/* 152 */     this.repayLogAmount = repayLogAmount;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/* 156 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/* 160 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 164 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 168 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public Double getFee() {
/* 172 */     return this.fee;
/*     */   }
/*     */   
/*     */   public void setFee(Double fee) {
/* 176 */     this.fee = fee;
/*     */   }
/*     */ }
