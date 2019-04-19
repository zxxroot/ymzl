/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.model.BorrowModel;
/*     */ import org.springframework.beans.BeanUtils;
/*     */ 
/*     */ public class ChannelBorrowModel extends Borrow
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private String stateStr;
/*     */   private Double repayAmount;
/*     */   private String repayTime;
/*     */   private String channelCode;
/*     */   
/*     */   public static ChannelBorrowModel instance(Borrow borrow)
/*     */   {
/*  19 */     ChannelBorrowModel borrowModel = new ChannelBorrowModel();
/*  20 */     BeanUtils.copyProperties(borrow, borrowModel);
/*  21 */     return borrowModel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String channelName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String providerId;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String providerName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String contactId;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String contactName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String linker;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int borrowType;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String userName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRepayAmount()
/*     */   {
/*  96 */     return this.repayAmount;
/*     */   }
/*     */   
/*     */   public void setRepayAmount(Double repayAmount) {
/* 100 */     this.repayAmount = repayAmount;
/*     */   }
/*     */   
/*     */   public String getRepayTime() {
/* 104 */     return this.repayTime;
/*     */   }
/*     */   
/*     */   public void setRepayTime(String repayTime) {
/* 108 */     this.repayTime = repayTime;
/*     */   }
/*     */   
/*     */   public String getStateStr() {
/* 112 */     this.stateStr = BorrowModel.manageConvertBorrowState(getState());
/* 113 */     return this.stateStr;
/*     */   }
/*     */   
/*     */   public void setStateStr(String stateStr) {
/* 117 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/* 121 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/* 125 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 129 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 133 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getChannelCode() {
/* 137 */     return this.channelCode;
/*     */   }
/*     */   
/*     */   public void setChannelCode(String channelCode) {
/* 141 */     this.channelCode = channelCode;
/*     */   }
/*     */   
/*     */   public String getChannelName() {
/* 145 */     return this.channelName;
/*     */   }
/*     */   
/*     */   public void setChannelName(String channelName) {
/* 149 */     this.channelName = channelName;
/*     */   }
/*     */   
/*     */   public String getProviderId() {
/* 153 */     return this.providerId;
/*     */   }
/*     */   
/*     */   public void setProviderId(String providerId) {
/* 157 */     this.providerId = providerId;
/*     */   }
/*     */   
/*     */   public String getProviderName() {
/* 161 */     return this.providerName;
/*     */   }
/*     */   
/*     */   public void setProviderName(String providerName) {
/* 165 */     this.providerName = providerName;
/*     */   }
/*     */   
/*     */   public String getContactId() {
/* 169 */     return this.contactId;
/*     */   }
/*     */   
/*     */   public void setContactId(String contactId) {
/* 173 */     this.contactId = contactId;
/*     */   }
/*     */   
/*     */   public String getContactName() {
/* 177 */     return this.contactName;
/*     */   }
/*     */   
/*     */   public void setContactName(String contactName) {
/* 181 */     this.contactName = contactName;
/*     */   }
/*     */   
/*     */   public String getLinker() {
/* 185 */     return this.linker;
/*     */   }
/*     */   
/*     */   public void setLinker(String linker) {
/* 189 */     this.linker = linker;
/*     */   }
/*     */   
/*     */   public int getBorrowType() {
/* 193 */     return this.borrowType;
/*     */   }
/*     */   
/*     */   public void setBorrowType(int borrowType) {
/* 197 */     this.borrowType = borrowType;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/* 201 */     return this.userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String userName) {
/* 205 */     this.userName = userName;
/*     */   }
/*     */ }
