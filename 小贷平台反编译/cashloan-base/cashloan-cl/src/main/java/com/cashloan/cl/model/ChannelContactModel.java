/*     */ package com.cashloan.cl.model;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChannelContactModel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -896818200134837655L;
/*     */   public static final int STATE_ENABLE = 10;
/*     */   public static final int STATE_DISABLE = 20;
/*     */   private Long id;
/*     */   private String contactId;
/*     */   private String contactName;
/*     */   private String userName;
/*     */   private String providerId;
/*     */   private String providerName;
/*     */   private Long userId;
/*     */   private Long channelStaffUserId;
/*     */   private String linker;
/*     */   private String phone;
/*     */   private Date createTime;
/*     */   private Date updateTime;
/*     */   private String state;
/*     */   private String updateUser;
/*     */   private Long role;
/*     */   private String channelContactState;
/*     */   private String channelProviderState;
/*     */   private String firstState;
/*     */   
/*     */   public Long getRole()
/*     */   {
/* 116 */     return this.role;
/*     */   }
/*     */   
/*     */   public void setRole(Long role) {
/* 120 */     this.role = role;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 124 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 128 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getUpdateUser() {
/* 132 */     return this.updateUser;
/*     */   }
/*     */   
/*     */   public void setUpdateUser(String updateUser) {
/* 136 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 140 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 144 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 148 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 152 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserName()
/*     */   {
/* 161 */     return this.userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserName(String userName)
/*     */   {
/* 170 */     this.userName = userName;
/*     */   }
/*     */   
/*     */   public String getContactName() {
/* 174 */     return this.contactName;
/*     */   }
/*     */   
/*     */   public void setContactName(String contactName) {
/* 178 */     this.contactName = contactName;
/*     */   }
/*     */   
/*     */   public String getProviderName() {
/* 182 */     return this.providerName;
/*     */   }
/*     */   
/*     */   public void setProviderName(String providerName) {
/* 186 */     this.providerName = providerName;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/* 190 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/* 194 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getLinker() {
/* 198 */     return this.linker;
/*     */   }
/*     */   
/*     */   public void setLinker(String linker) {
/* 202 */     this.linker = linker;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 206 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 210 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getContactId() {
/* 214 */     return this.contactId;
/*     */   }
/*     */   
/*     */   public void setContactId(String contactId) {
/* 218 */     this.contactId = contactId;
/*     */   }
/*     */   
/*     */   public String getProviderId() {
/* 222 */     return this.providerId;
/*     */   }
/*     */   
/*     */   public void setProviderId(String providerId) {
/* 226 */     this.providerId = providerId;
/*     */   }
/*     */   
/*     */   public Long getId() {
/* 230 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 234 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getChannelStaffUserId() {
/* 238 */     return this.channelStaffUserId;
/*     */   }
/*     */   
/*     */   public void setChannelStaffUserId(Long channelStaffUserId) {
/* 242 */     this.channelStaffUserId = channelStaffUserId;
/*     */   }
/*     */   
/*     */   public String getChannelContactState() {
/* 246 */     return this.channelContactState;
/*     */   }
/*     */   
/*     */   public void setChannelContactState(String channelContactState) {
/* 250 */     this.channelContactState = channelContactState;
/*     */   }
/*     */   
/*     */   public String getFirstState() {
/* 254 */     return this.firstState;
/*     */   }
/*     */   
/*     */   public void setFirstState(String firstState) {
/* 258 */     this.firstState = firstState;
/*     */   }
/*     */   
/*     */   public String getChannelProviderState() {
/* 262 */     return this.channelProviderState;
/*     */   }
/*     */   
/*     */   public void setChannelProviderState(String channelProviderState) {
/* 266 */     this.channelProviderState = channelProviderState;
/*     */   }
/*     */ }
