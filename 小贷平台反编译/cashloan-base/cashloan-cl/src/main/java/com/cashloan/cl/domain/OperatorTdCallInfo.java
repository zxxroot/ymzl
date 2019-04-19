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
/*     */ public class OperatorTdCallInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Long reqLogId;
/*     */   private String orderNo;
/*     */   private String totalCallTime;
/*     */   private String totalCallCount;
/*     */   private String totalFee;
/*     */   private String callCycle;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  63 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  72 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/*  81 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/*  90 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalCallTime()
/*     */   {
/*  99 */     return this.totalCallTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalCallTime(String totalCallTime)
/*     */   {
/* 108 */     this.totalCallTime = totalCallTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalCallCount()
/*     */   {
/* 117 */     return this.totalCallCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalCallCount(String totalCallCount)
/*     */   {
/* 126 */     this.totalCallCount = totalCallCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalFee()
/*     */   {
/* 135 */     return this.totalFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalFee(String totalFee)
/*     */   {
/* 144 */     this.totalFee = totalFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallCycle()
/*     */   {
/* 153 */     return this.callCycle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallCycle(String callCycle)
/*     */   {
/* 162 */     this.callCycle = callCycle;
/*     */   }
/*     */   
/*     */   public Long getReqLogId() {
/* 166 */     return this.reqLogId;
/*     */   }
/*     */   
/*     */   public void setReqLogId(Long reqLogId) {
/* 170 */     this.reqLogId = reqLogId;
/*     */   }
/*     */   
/*     */   public String getOrderNo() {
/* 174 */     return this.orderNo;
/*     */   }
/*     */   
/*     */   public void setOrderNo(String orderNo) {
/* 178 */     this.orderNo = orderNo;
/*     */   }
/*     */ }
