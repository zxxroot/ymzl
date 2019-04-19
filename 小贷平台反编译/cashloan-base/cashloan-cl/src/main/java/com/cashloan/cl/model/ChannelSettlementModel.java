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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChannelSettlementModel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String providerId;
/*     */   private String providerName;
/*     */   private String providerSettlement;
/*     */   private String providerSettlementStr;
/*     */   private String contactId;
/*     */   private String contactName;
/*     */   private String contactSettlement;
/*     */   private String contactSettlementStr;
/*     */   private String firstName;
/*     */   private String twoName;
/*     */   private String state;
/*     */   private String stateStr;
/*     */   private Date createTime;
/*     */   private int channelStage;
/*     */   private Date updateTime;
/*     */   private String settlementSign;
/*     */   private String settlementSignStr;
/*     */   private String updateUser;
/*     */   private Long firstId;
/*     */   private Long twoId;
/*     */   private Long settlementId;
/*     */   private String settlementState;
/*     */   private String settlementStateStr;
/*     */   private Date settlementUpdateTime;
/*     */   
/*     */   public String getCode()
/*     */   {
/* 160 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/* 169 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 178 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 187 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 196 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 205 */     this.state = state;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 209 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 213 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public int getChannelStage() {
/* 217 */     return this.channelStage;
/*     */   }
/*     */   
/*     */   public void setChannelStage(int channelStage) {
/* 221 */     this.channelStage = channelStage;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 225 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 229 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String getUpdateUser()
/*     */   {
/* 234 */     return this.updateUser;
/*     */   }
/*     */   
/*     */   public void setUpdateUser(String updateUser) {
/* 238 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */   public String getProviderId() {
/* 242 */     return this.providerId;
/*     */   }
/*     */   
/*     */   public void setProviderId(String providerId) {
/* 246 */     this.providerId = providerId;
/*     */   }
/*     */   
/*     */   public String getProviderName() {
/* 250 */     return this.providerName;
/*     */   }
/*     */   
/*     */   public void setProviderName(String providerName) {
/* 254 */     this.providerName = providerName;
/*     */   }
/*     */   
/*     */   public String getProviderSettlement()
/*     */   {
/* 259 */     return this.providerSettlement;
/*     */   }
/*     */   
/*     */   public void setProviderSettlement(String providerSettlement) {
/* 263 */     this.providerSettlement = providerSettlement;
/*     */   }
/*     */   
/*     */   public String getSettlementSign() {
/* 267 */     return this.settlementSign;
/*     */   }
/*     */   
/*     */   public void setSettlementSign(String settlementSign) {
/* 271 */     this.settlementSign = settlementSign;
/*     */   }
/*     */   
/*     */   public String getContactId() {
/* 275 */     return this.contactId;
/*     */   }
/*     */   
/*     */   public void setContactId(String contactId) {
/* 279 */     this.contactId = contactId;
/*     */   }
/*     */   
/*     */   public String getContactName() {
/* 283 */     return this.contactName;
/*     */   }
/*     */   
/*     */   public void setContactName(String contactName) {
/* 287 */     this.contactName = contactName;
/*     */   }
/*     */   
/*     */   public String getContactSettlement() {
/* 291 */     return this.contactSettlement;
/*     */   }
/*     */   
/*     */   public void setContactSettlement(String contactSettlement) {
/* 295 */     this.contactSettlement = contactSettlement;
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/* 299 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String firstName) {
/* 303 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */   public String getTwoName() {
/* 307 */     return this.twoName;
/*     */   }
/*     */   
/*     */   public void setTwoName(String twoName) {
/* 311 */     this.twoName = twoName;
/*     */   }
/*     */   
/*     */   public Long getFirstId() {
/* 315 */     return this.firstId;
/*     */   }
/*     */   
/*     */   public void setFirstId(Long firstId) {
/* 319 */     this.firstId = firstId;
/*     */   }
/*     */   
/*     */   public Long getTwoId() {
/* 323 */     return this.twoId;
/*     */   }
/*     */   
/*     */   public void setTwoId(Long twoId) {
/* 327 */     this.twoId = twoId;
/*     */   }
/*     */   
/*     */   public Long getId() {
/* 331 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 335 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getSettlementId() {
/* 339 */     return this.settlementId;
/*     */   }
/*     */   
/*     */   public void setSettlementId(Long settlementId) {
/* 343 */     this.settlementId = settlementId;
/*     */   }
/*     */   
/*     */   public String getSettlementState() {
/* 347 */     return this.settlementState;
/*     */   }
/*     */   
/*     */   public void setSettlementState(String settlementState) {
/* 351 */     this.settlementState = settlementState;
/*     */   }
/*     */   
/*     */   public Date getSettlementUpdateTime() {
/* 355 */     return this.settlementUpdateTime;
/*     */   }
/*     */   
/*     */   public void setSettlementUpdateTime(Date settlementUpdateTime) {
/* 359 */     this.settlementUpdateTime = settlementUpdateTime;
/*     */   }
/*     */   
/*     */   public String getProviderSettlementStr() {
/* 363 */     this.providerSettlementStr = settlementConvet(getProviderSettlement());
/* 364 */     return this.providerSettlementStr;
/*     */   }
/*     */   
/*     */   private String settlementConvet(String string) {
/* 368 */     String providerSettlementStr = null;
/* 369 */     if ("10".equals(string)) {
/* 370 */       providerSettlementStr = "支付宝";
/* 371 */     } else if ("20".equals(string)) {
/* 372 */       providerSettlementStr = "银行卡";
/*     */     } else {
/* 374 */       providerSettlementStr = " - ";
/*     */     }
/* 376 */     return providerSettlementStr;
/*     */   }
/*     */   
/*     */   public void setProviderSettlementStr(String providerSettlementStr) {
/* 380 */     this.providerSettlementStr = providerSettlementStr;
/*     */   }
/*     */   
/*     */   public String getContactSettlementStr() {
/* 384 */     this.contactSettlementStr = settlementConvet(getContactSettlement());
/* 385 */     return this.contactSettlementStr;
/*     */   }
/*     */   
/*     */   public void setContactSettlementStr(String contactSettlementStr) {
/* 389 */     this.contactSettlementStr = contactSettlementStr;
/*     */   }
/*     */   
/*     */   public String getStateStr() {
/* 393 */     this.stateStr = stateConvet(getState());
/* 394 */     return this.stateStr;
/*     */   }
/*     */   
/*     */   private String stateConvet(String state) {
/* 398 */     String stateStr = null;
/* 399 */     if ("10".equals(state)) {
/* 400 */       stateStr = "启用";
/* 401 */     } else if ("20".equals(state)) {
/* 402 */       stateStr = "禁用";
/*     */     } else {
/* 404 */       stateStr = " - ";
/*     */     }
/* 406 */     return stateStr;
/*     */   }
/*     */   
/*     */   public void setStateStr(String stateStr) {
/* 410 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */   public String getSettlementSignStr() {
/* 414 */     this.settlementSignStr = settlementSignConvet(getSettlementSign());
/* 415 */     return this.settlementSignStr;
/*     */   }
/*     */   
/*     */   private String settlementSignConvet(String settlementSign) {
/* 419 */     String settlementSignStr = null;
/* 420 */     if ("10".equals(settlementSign)) {
/* 421 */       settlementSignStr = "公";
/* 422 */     } else if ("20".equals(settlementSign)) {
/* 423 */       settlementSignStr = "私";
/*     */     } else {
/* 425 */       settlementSignStr = " - ";
/*     */     }
/* 427 */     return settlementSignStr;
/*     */   }
/*     */   
/*     */   public void setSettlementSignStr(String settlementSignStr) {
/* 431 */     this.settlementSignStr = settlementSignStr;
/*     */   }
/*     */   
/*     */   public String getSettlementStateStr() {
/* 435 */     this.settlementStateStr = settlementStateConvet(getSettlementState());
/* 436 */     return this.settlementStateStr;
/*     */   }
/*     */   
/*     */   private String settlementStateConvet(String settlementState) {
/* 440 */     String settlementStateStr = null;
/* 441 */     if ("10".equals(settlementState)) {
/* 442 */       settlementStateStr = "未结算";
/* 443 */     } else if ("20".equals(settlementState)) {
/* 444 */       settlementStateStr = "已结算";
/*     */     } else {
/* 446 */       settlementStateStr = " - ";
/*     */     }
/* 448 */     return settlementStateStr;
/*     */   }
/*     */   
/*     */   public void setSettlementStateStr(String settlementStateStr) {
/* 452 */     this.settlementStateStr = settlementStateStr;
/*     */   }
/*     */ }
