/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperatorTdBills
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Long reqLogId;
/*     */   private String orderNo;
/*     */   private String billCycle;
/*     */   private String billFee;
/*     */   private String billDiscount;
/*     */   private String billTotal;
/*     */   private String breachAmount;
/*     */   private String paidAmount;
/*     */   private String unpaidAmount;
/*     */   private String billRecord;
/*     */   private String usageDetail;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  89 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  98 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 107 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 116 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBillCycle()
/*     */   {
/* 125 */     return this.billCycle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBillCycle(String billCycle)
/*     */   {
/* 134 */     this.billCycle = billCycle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBillFee()
/*     */   {
/* 143 */     return this.billFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBillFee(String billFee)
/*     */   {
/* 152 */     this.billFee = billFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBillDiscount()
/*     */   {
/* 161 */     return this.billDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBillDiscount(String billDiscount)
/*     */   {
/* 170 */     this.billDiscount = billDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBillTotal()
/*     */   {
/* 179 */     return this.billTotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBillTotal(String billTotal)
/*     */   {
/* 188 */     this.billTotal = billTotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBreachAmount()
/*     */   {
/* 197 */     return this.breachAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBreachAmount(String breachAmount)
/*     */   {
/* 206 */     this.breachAmount = breachAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPaidAmount()
/*     */   {
/* 215 */     return this.paidAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPaidAmount(String paidAmount)
/*     */   {
/* 224 */     this.paidAmount = paidAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUnpaidAmount()
/*     */   {
/* 233 */     return this.unpaidAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUnpaidAmount(String unpaidAmount)
/*     */   {
/* 242 */     this.unpaidAmount = unpaidAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBillRecord()
/*     */   {
/* 251 */     return this.billRecord;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBillRecord(String billRecord)
/*     */   {
/* 260 */     this.billRecord = billRecord;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUsageDetail()
/*     */   {
/* 269 */     return this.usageDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUsageDetail(String usageDetail)
/*     */   {
/* 278 */     this.usageDetail = usageDetail;
/*     */   }
/*     */   
/*     */   public Long getReqLogId() {
/* 282 */     return this.reqLogId;
/*     */   }
/*     */   
/*     */   public void setReqLogId(Long reqLogId) {
/* 286 */     this.reqLogId = reqLogId;
/*     */   }
/*     */   
/*     */   public String getOrderNo() {
/* 290 */     return this.orderNo;
/*     */   }
/*     */   
/*     */   public void setOrderNo(String orderNo) {
/* 294 */     this.orderNo = orderNo;
/*     */   }
/*     */ }
