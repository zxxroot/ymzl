/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BorrowRepayLog
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long repayId;
/*     */   private Long borrowId;
/*     */   private Long userId;
/*     */   private Double amount;
/*     */   private Date repayTime;
/*     */   private Double penaltyAmout;
/*     */   private String penaltyDay;
/*     */   private String repayWay;
/*     */   private String repayAccount;
/*     */   private String refundDeduction;
/*     */   private Date payTime;
/*     */   private Date createTime;
/*     */   private String serialNumber;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  96 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 105 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getRepayId()
/*     */   {
/* 114 */     return this.repayId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayId(Long repayId)
/*     */   {
/* 124 */     this.repayId = repayId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getBorrowId()
/*     */   {
/* 133 */     return this.borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowId(Long borrowId)
/*     */   {
/* 143 */     this.borrowId = borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 152 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 162 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getAmount()
/*     */   {
/* 171 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmount(Double amount)
/*     */   {
/* 181 */     this.amount = amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getRepayTime()
/*     */   {
/* 190 */     return this.repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayTime(Date repayTime)
/*     */   {
/* 200 */     this.repayTime = repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getPenaltyAmout()
/*     */   {
/* 209 */     return this.penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPenaltyAmout(Double penaltyAmout)
/*     */   {
/* 219 */     this.penaltyAmout = penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPenaltyDay()
/*     */   {
/* 227 */     return this.penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPenaltyDay(String penaltyDay)
/*     */   {
/* 235 */     this.penaltyDay = penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayWay()
/*     */   {
/* 243 */     return this.repayWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayWay(String repayWay)
/*     */   {
/* 251 */     this.repayWay = repayWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayAccount()
/*     */   {
/* 259 */     return this.repayAccount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayAccount(String repayAccount)
/*     */   {
/* 267 */     this.repayAccount = repayAccount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRefundDeduction()
/*     */   {
/* 275 */     return this.refundDeduction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRefundDeduction(String refundDeduction)
/*     */   {
/* 283 */     this.refundDeduction = refundDeduction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getPayTime()
/*     */   {
/* 291 */     return this.payTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayTime(Date payTime)
/*     */   {
/* 299 */     this.payTime = payTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 307 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 315 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 319 */     return this.serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String serialNumber) {
/* 323 */     this.serialNumber = serialNumber;
/*     */   }
/*     */ }
