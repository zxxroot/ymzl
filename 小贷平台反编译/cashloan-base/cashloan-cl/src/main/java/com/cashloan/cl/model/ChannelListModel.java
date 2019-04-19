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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChannelListModel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String providerId;
/*     */   private String providerName;
/*     */   private String providerSettlement;
/*     */   private String contactId;
/*     */   private String contactName;
/*     */   private String contactSettlement;
/*     */   private String firstName;
/*     */   private String twoName;
/*     */   private String state;
/*     */   private Date createTime;
/*     */   private String channelStage;
/*     */   private Date updateTime;
/*     */   private String settlementSign;
/*     */   private String updateUser;
/*     */   private Long firstId;
/*     */   private Long twoId;
/*     */   private int channelGrade;
/*     */   private String channelContactState;
/*     */   private String channelProviderState;
/*     */   private String firstState;
/*     */   private String twoState;
/*     */   private String providerSettlementStr;
/*     */   private String contactSettlementStr;
/*     */   private String channelStageStr;
/*     */   private String settlementSignStr;
/*     */   private String stateStr;
/*     */   private String inviteURL;
/*     */   private String loginURL;
/*     */   private int divLevel;
/*     */   private String parentCode;
/*     */   private String parentPath;
/*     */   private Long userNum;
/*     */   private String cuserid;
/*     */   
/*     */   public String getInviteURL()
/*     */   {
/* 192 */     return this.inviteURL;
/*     */   }
/*     */   
/*     */   public void setInviteURL(String inviteURL) {
/* 196 */     this.inviteURL = inviteURL;
/*     */   }
/*     */   
/*     */   public String getLoginURL() {
/* 200 */     return this.loginURL;
/*     */   }
/*     */   
/*     */   public void setLoginURL(String loginURL) {
/* 204 */     this.loginURL = loginURL;
/*     */   }
/*     */   
/*     */   public int getDivLevel() {
/* 208 */     return this.divLevel;
/*     */   }
/*     */   
/*     */   public void setDivLevel(int divLevel) {
/* 212 */     this.divLevel = divLevel;
/*     */   }
/*     */   
/*     */   public String getParentCode() {
/* 216 */     return this.parentCode;
/*     */   }
/*     */   
/*     */   public void setParentCode(String parentCode) {
/* 220 */     this.parentCode = parentCode;
/*     */   }
/*     */   
/*     */   public String getParentPath() {
/* 224 */     return this.parentPath;
/*     */   }
/*     */   
/*     */   public void setParentPath(String parentPath) {
/* 228 */     this.parentPath = parentPath;
/*     */   }
/*     */   
/*     */   public Long getUserNum() {
/* 232 */     return this.userNum;
/*     */   }
/*     */   
/*     */   public void setUserNum(Long userNum) {
/* 236 */     this.userNum = userNum;
/*     */   }
/*     */   
/*     */   public String getCuserid() {
/* 240 */     return this.cuserid;
/*     */   }
/*     */   
/*     */   public void setCuserid(String cuserid) {
/* 244 */     this.cuserid = cuserid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCode()
/*     */   {
/* 253 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/* 262 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 271 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 280 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 289 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 298 */     this.state = state;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 302 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 306 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime()
/*     */   {
/* 311 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 315 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public String getUpdateUser() {
/* 319 */     return this.updateUser;
/*     */   }
/*     */   
/*     */   public void setUpdateUser(String updateUser) {
/* 323 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */   public String getProviderId() {
/* 327 */     if ((this.channelProviderState != null) && (this.channelProviderState.equals("20"))) {
/* 328 */       return null;
/*     */     }
/* 330 */     return this.providerId;
/*     */   }
/*     */   
/*     */   public void setProviderId(String providerId) {
/* 334 */     this.providerId = providerId;
/*     */   }
/*     */   
/*     */   public String getProviderName() {
/* 338 */     if ((this.channelProviderState != null) && (this.channelProviderState.equals("20"))) {
/* 339 */       return null;
/*     */     }
/* 341 */     return this.providerName;
/*     */   }
/*     */   
/*     */   public void setProviderName(String providerName) {
/* 345 */     this.providerName = providerName;
/*     */   }
/*     */   
/*     */   public String getProviderSettlement()
/*     */   {
/* 350 */     if ((this.channelProviderState != null) && (this.channelProviderState.equals("20"))) {
/* 351 */       return null;
/*     */     }
/* 353 */     return this.providerSettlement;
/*     */   }
/*     */   
/*     */   public void setProviderSettlement(String providerSettlement) {
/* 357 */     this.providerSettlement = providerSettlement;
/*     */   }
/*     */   
/*     */   public String getContactId() {
/* 361 */     if ((this.channelContactState != null) && (this.channelContactState.equals("20"))) {
/* 362 */       return null;
/*     */     }
/* 364 */     return this.contactId;
/*     */   }
/*     */   
/*     */   public void setContactId(String contactId) {
/* 368 */     this.contactId = contactId;
/*     */   }
/*     */   
/*     */   public String getContactName() {
/* 372 */     if ((this.channelContactState != null) && (this.channelContactState.equals("20"))) {
/* 373 */       return null;
/*     */     }
/* 375 */     return this.contactName;
/*     */   }
/*     */   
/*     */   public void setContactName(String contactName) {
/* 379 */     this.contactName = contactName;
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/* 383 */     if ((this.firstState != null) && (this.firstState.equals("1"))) {
/* 384 */       return null;
/*     */     }
/* 386 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String firstName) {
/* 390 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */   public String getTwoName() {
/* 394 */     if ((this.twoState != null) && (this.twoState.equals("1"))) {
/* 395 */       return null;
/*     */     }
/* 397 */     return this.twoName;
/*     */   }
/*     */   
/*     */   public void setTwoName(String twoName) {
/* 401 */     this.twoName = twoName;
/*     */   }
/*     */   
/*     */   public Long getFirstId() {
/* 405 */     return this.firstId;
/*     */   }
/*     */   
/*     */   public void setFirstId(Long firstId) {
/* 409 */     this.firstId = firstId;
/*     */   }
/*     */   
/*     */   public Long getTwoId() {
/* 413 */     return this.twoId;
/*     */   }
/*     */   
/*     */   public void setTwoId(Long twoId) {
/* 417 */     this.twoId = twoId;
/*     */   }
/*     */   
/*     */   public Long getId() {
/* 421 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 425 */     this.id = id;
/*     */   }
/*     */   
/*     */   public int getChannelGrade() {
/* 429 */     return this.channelGrade;
/*     */   }
/*     */   
/*     */   public void setChannelGrade(int channelGrade) {
/* 433 */     this.channelGrade = channelGrade;
/*     */   }
/*     */   
/*     */   public String getChannelContactState() {
/* 437 */     return this.channelContactState;
/*     */   }
/*     */   
/*     */   public void setChannelContactState(String channelContactState) {
/* 441 */     this.channelContactState = channelContactState;
/*     */   }
/*     */   
/*     */   public String getChannelProviderState() {
/* 445 */     return this.channelProviderState;
/*     */   }
/*     */   
/*     */   public void setChannelProviderState(String channelProviderState) {
/* 449 */     this.channelProviderState = channelProviderState;
/*     */   }
/*     */   
/*     */   public String getFirstState() {
/* 453 */     return this.firstState;
/*     */   }
/*     */   
/*     */   public void setFirstState(String firstState) {
/* 457 */     this.firstState = firstState;
/*     */   }
/*     */   
/*     */   public String getTwoState() {
/* 461 */     return this.twoState;
/*     */   }
/*     */   
/*     */   public void setTwoState(String twoState) {
/* 465 */     this.twoState = twoState;
/*     */   }
/*     */   
/*     */   public String getProviderSettlementStr() {
/* 469 */     this.providerSettlementStr = settlementConvet(getProviderSettlement());
/* 470 */     return this.providerSettlementStr;
/*     */   }
/*     */   
/*     */   private String settlementConvet(String string) {
/* 474 */     String providerSettlementStr = null;
/* 475 */     if ("10".equals(string)) {
/* 476 */       providerSettlementStr = "支付宝";
/* 477 */     } else if ("20".equals(string)) {
/* 478 */       providerSettlementStr = "银行卡";
/*     */     } else {
/* 480 */       providerSettlementStr = " - ";
/*     */     }
/* 482 */     return providerSettlementStr;
/*     */   }
/*     */   
/*     */   public void setProviderSettlementStr(String providerSettlementStr) {
/* 486 */     this.providerSettlementStr = providerSettlementStr;
/*     */   }
/*     */   
/*     */   public String getContactSettlementStr() {
/* 490 */     if ((this.channelContactState != null) && (this.channelContactState.equals("20"))) {
/* 491 */       return null;
/*     */     }
/* 493 */     this.contactSettlementStr = settlementConvet(getContactSettlement());
/* 494 */     return this.contactSettlementStr;
/*     */   }
/*     */   
/*     */   public void setContactSettlementStr(String contactSettlementStr) {
/* 498 */     this.contactSettlementStr = contactSettlementStr;
/*     */   }
/*     */   
/*     */   public String getStateStr() {
/* 502 */     this.stateStr = stateConvet(getState());
/* 503 */     return this.stateStr;
/*     */   }
/*     */   
/*     */   private String stateConvet(String state) {
/* 507 */     String stateStr = null;
/* 508 */     if ("10".equals(state)) {
/* 509 */       stateStr = "启用";
/* 510 */     } else if ("20".equals(state)) {
/* 511 */       stateStr = "禁用";
/*     */     } else {
/* 513 */       stateStr = " - ";
/*     */     }
/* 515 */     return stateStr;
/*     */   }
/*     */   
/*     */   public void setStateStr(String stateStr) {
/* 519 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */   public String getSettlementSignStr() {
/* 523 */     this.settlementSignStr = settlementSignConvet(getSettlementSign());
/* 524 */     return this.settlementSignStr;
/*     */   }
/*     */   
/*     */   private String settlementSignConvet(String settlementSign) {
/* 528 */     String settlementSignStr = null;
/* 529 */     if ("10".equals(settlementSign)) {
/* 530 */       settlementSignStr = "公";
/* 531 */     } else if ("20".equals(settlementSign)) {
/* 532 */       settlementSignStr = "私";
/*     */     } else {
/* 534 */       settlementSignStr = " - ";
/*     */     }
/* 536 */     return settlementSignStr;
/*     */   }
/*     */   
/*     */   public void setSettlementSignStr(String settlementSignStr) {
/* 540 */     this.settlementSignStr = settlementSignStr;
/*     */   }
/*     */   
/*     */   public String getSettlementSign() {
/* 544 */     return this.settlementSign;
/*     */   }
/*     */   
/*     */   public void setSettlementSign(String settlementSign) {
/* 548 */     this.settlementSign = settlementSign;
/*     */   }
/*     */   
/*     */   public String getContactSettlement() {
/* 552 */     return this.contactSettlement;
/*     */   }
/*     */   
/*     */   public void setContactSettlement(String contactSettlement) {
/* 556 */     this.contactSettlement = contactSettlement;
/*     */   }
/*     */   
/*     */   public String getChannelStageStr() {
/* 560 */     this.channelStageStr = channelStageStrConvet(getChannelStage());
/* 561 */     return this.channelStageStr;
/*     */   }
/*     */   
/*     */   private String channelStageStrConvet(String channelStage) {
/* 565 */     String channelStageStr = null;
/* 566 */     if ("10".equals(channelStage)) {
/* 567 */       channelStageStr = "实验期";
/* 568 */     } else if ("20".equals(channelStage)) {
/* 569 */       channelStageStr = "观察期";
/* 570 */     } else if ("20".equals(channelStage)) {
/* 571 */       channelStageStr = "深度合作";
/*     */     } else {
/* 573 */       channelStageStr = " - ";
/*     */     }
/* 575 */     return channelStageStr;
/*     */   }
/*     */   
/*     */   public void setChannelStageStr(String channelStageStr) {
/* 579 */     this.channelStageStr = channelStageStr;
/*     */   }
/*     */   
/*     */   public String getChannelStage() {
/* 583 */     return this.channelStage;
/*     */   }
/*     */   
/*     */   public void setChannelStage(String channelStage) {
/* 587 */     this.channelStage = channelStage;
/*     */   }
/*     */ }
