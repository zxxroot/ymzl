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
/*     */ public class OperatorTdSmsInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Long reqLogId;
/*     */   private String orderNo;
/*     */   private String totalMsgCost;
/*     */   private String totalMsgCount;
/*     */   private String msgCycle;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  58 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  67 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/*  76 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/*  85 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalMsgCost()
/*     */   {
/*  94 */     return this.totalMsgCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalMsgCost(String totalMsgCost)
/*     */   {
/* 103 */     this.totalMsgCost = totalMsgCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalMsgCount()
/*     */   {
/* 112 */     return this.totalMsgCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalMsgCount(String totalMsgCount)
/*     */   {
/* 121 */     this.totalMsgCount = totalMsgCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgCycle()
/*     */   {
/* 130 */     return this.msgCycle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgCycle(String msgCycle)
/*     */   {
/* 139 */     this.msgCycle = msgCycle;
/*     */   }
/*     */   
/*     */   public Long getReqLogId() {
/* 143 */     return this.reqLogId;
/*     */   }
/*     */   
/*     */   public void setReqLogId(Long reqLogId) {
/* 147 */     this.reqLogId = reqLogId;
/*     */   }
/*     */   
/*     */   public String getOrderNo() {
/* 151 */     return this.orderNo;
/*     */   }
/*     */   
/*     */   public void setOrderNo(String orderNo) {
/* 155 */     this.orderNo = orderNo;
/*     */   }
/*     */ }
