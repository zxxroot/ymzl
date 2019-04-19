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
/*     */ public class ChannelSettlement
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long channelId;
/*     */   private Integer state;
/*     */   private String updateUser;
/*     */   private String createTime;
/*     */   private String updateTime;
/*     */   private String paymentTransaction;
/*     */   private Integer settlement;
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
/*     */   public Long getChannelId()
/*     */   {
/*  84 */     return this.channelId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setChannelId(Long channelId)
/*     */   {
/*  93 */     this.channelId = channelId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getState()
/*     */   {
/* 102 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(Integer state)
/*     */   {
/* 111 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUpdateUser()
/*     */   {
/* 120 */     return this.updateUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateUser(String updateUser)
/*     */   {
/* 129 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */   public String getUpdateTime() {
/* 133 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(String updateTime) {
/* 137 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String getPaymentTransaction() {
/* 141 */     return this.paymentTransaction;
/*     */   }
/*     */   
/*     */   public void setPaymentTransaction(String paymentTransaction) {
/* 145 */     this.paymentTransaction = paymentTransaction;
/*     */   }
/*     */   
/*     */   public String getCreateTime() {
/* 149 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(String createTime) {
/* 153 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Integer getSettlement() {
/* 157 */     return this.settlement;
/*     */   }
/*     */   
/*     */   public void setSettlement(Integer settlement) {
/* 161 */     this.settlement = settlement;
/*     */   }
/*     */ }
