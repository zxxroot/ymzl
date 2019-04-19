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
/*     */ public class ChannelProvider
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String providerId;
/*     */   private String name;
/*     */   private Long grade;
/*     */   private Long settlement;
/*     */   private String cardNumber;
/*     */   private String bankAddress;
/*     */   private String bankOfAccounts;
/*     */   private Date createTime;
/*     */   private Date updateTime;
/*     */   private int state;
/*     */   private String updateUser;
/*     */   
/*     */   public int getState()
/*     */   {
/*  82 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(int state) {
/*  86 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getUpdateUser() {
/*  90 */     return this.updateUser;
/*     */   }
/*     */   
/*     */   public void setUpdateUser(String updateUser) {
/*  94 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/*  98 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 102 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 106 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 110 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String getBankAddress() {
/* 114 */     return this.bankAddress;
/*     */   }
/*     */   
/*     */   public void setBankAddress(String bankAddress) {
/* 118 */     this.bankAddress = bankAddress;
/*     */   }
/*     */   
/*     */   public String getBankOfAccounts() {
/* 122 */     return this.bankOfAccounts;
/*     */   }
/*     */   
/*     */   public void setBankOfAccounts(String bankOfAccounts) {
/* 126 */     this.bankOfAccounts = bankOfAccounts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 135 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 144 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 153 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 162 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getGrade()
/*     */   {
/* 171 */     return this.grade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGrade(Long grade)
/*     */   {
/* 180 */     this.grade = grade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getSettlement()
/*     */   {
/* 189 */     return this.settlement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSettlement(Long settlement)
/*     */   {
/* 198 */     this.settlement = settlement;
/*     */   }
/*     */   
/*     */   public String getProviderId() {
/* 202 */     return this.providerId;
/*     */   }
/*     */   
/*     */   public void setProviderId(String providerId) {
/* 206 */     this.providerId = providerId;
/*     */   }
/*     */   
/*     */   public String getCardNumber() {
/* 210 */     return this.cardNumber;
/*     */   }
/*     */   
/*     */   public void setCardNumber(String cardNumber) {
/* 214 */     this.cardNumber = cardNumber;
/*     */   }
/*     */ }
