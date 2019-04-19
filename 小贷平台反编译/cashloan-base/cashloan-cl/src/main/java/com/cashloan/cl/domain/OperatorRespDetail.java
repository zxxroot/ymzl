/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import tool.util.DateUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperatorRespDetail
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long reqLogId;
/*     */   private String orderNo;
/*     */   private String notifyParams;
/*     */   private Date notifyTime;
/*     */   
/*     */   public OperatorRespDetail() {}
/*     */   
/*     */   public OperatorRespDetail(long reqLogId, String orderNo, String notifyParams)
/*     */   {
/*  53 */     this.reqLogId = Long.valueOf(reqLogId);
/*  54 */     this.orderNo = orderNo;
/*  55 */     this.notifyParams = notifyParams;
/*  56 */     this.notifyTime = DateUtil.getNow();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  66 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  75 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getReqLogId()
/*     */   {
/*  84 */     return this.reqLogId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReqLogId(Long reqLogId)
/*     */   {
/*  93 */     this.reqLogId = reqLogId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 102 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 111 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNotifyParams()
/*     */   {
/* 120 */     return this.notifyParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNotifyParams(String notifyParams)
/*     */   {
/* 129 */     this.notifyParams = notifyParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getNotifyTime()
/*     */   {
/* 138 */     return this.notifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNotifyTime(Date notifyTime)
/*     */   {
/* 147 */     this.notifyTime = notifyTime;
/*     */   }
/*     */ }
