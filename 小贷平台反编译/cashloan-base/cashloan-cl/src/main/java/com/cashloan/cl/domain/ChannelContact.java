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
/*     */ public class ChannelContact
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String contactId;
/*     */   private String name;
/*     */   private Long userId;
/*     */   private String userName;
/*     */   private Long role;
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
/*  96 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(int state) {
/* 100 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getUpdateUser() {
/* 104 */     return this.updateUser;
/*     */   }
/*     */   
/*     */   public void setUpdateUser(String updateUser) {
/* 108 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 112 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 116 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 120 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 124 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String getBankAddress() {
/* 128 */     return this.bankAddress;
/*     */   }
/*     */   
/*     */   public void setBankAddress(String bankAddress) {
/* 132 */     this.bankAddress = bankAddress;
/*     */   }
/*     */   
/*     */   public String getBankOfAccounts() {
/* 136 */     return this.bankOfAccounts;
/*     */   }
/*     */   
/*     */   public void setBankOfAccounts(String bankOfAccounts) {
/* 140 */     this.bankOfAccounts = bankOfAccounts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 149 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 158 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 167 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 176 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserName()
/*     */   {
/* 185 */     return this.userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserName(String userName)
/*     */   {
/* 194 */     this.userName = userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getRole()
/*     */   {
/* 203 */     return this.role;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRole(Long role)
/*     */   {
/* 212 */     this.role = role;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getGrade()
/*     */   {
/* 221 */     return this.grade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGrade(Long grade)
/*     */   {
/* 230 */     this.grade = grade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getSettlement()
/*     */   {
/* 239 */     return this.settlement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSettlement(Long settlement)
/*     */   {
/* 248 */     this.settlement = settlement;
/*     */   }
/*     */   
/*     */   public String getContactId() {
/* 252 */     return this.contactId;
/*     */   }
/*     */   
/*     */   public void setContactId(String contactId) {
/* 256 */     this.contactId = contactId;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/* 260 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/* 264 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getCardNumber() {
/* 268 */     return this.cardNumber;
/*     */   }
/*     */   
/*     */   public void setCardNumber(String cardNumber) {
/* 272 */     this.cardNumber = cardNumber;
/*     */   }
/*     */ }