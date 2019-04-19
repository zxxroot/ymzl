/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import com.alibaba.fastjson.annotation.JSONField;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperatorTdBasic
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Long reqLogId;
/*     */   private String orderNo;
/*     */   @JSONField(name="cell_phone")
/*     */   private String userMobile;
/*     */   @JSONField(name="datasource")
/*     */   private String channelSrc;
/*     */   private String accountBalance;
/*     */   private String currentFee;
/*     */   private String creditLevel;
/*     */   private String mobileStatus;
/*     */   @JSONField(name="reg_time")
/*     */   private String netTime;
/*     */   private Integer netAge;
/*     */   @JSONField(name="real_name")
/*     */   private String realInfo;
/*     */   private String creditPoint;
/*     */   private String creditEffectiveTime;
/*     */   private String creditScore;
/*     */   private String landLevel;
/*     */   private String roamState;
/*     */   private String balanceAvailable;
/*     */   private String balanceUnavailable;
/*     */   private String prepayAvailable;
/*     */   private String promAvailable;
/*     */   private String prepayUnavailable;
/*     */   private String promUnavailable;
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
/*     */   public Long getUserId()
/*     */   {
/* 167 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 176 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getChannelSrc()
/*     */   {
/* 185 */     return this.channelSrc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setChannelSrc(String channelSrc)
/*     */   {
/* 194 */     this.channelSrc = channelSrc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountBalance()
/*     */   {
/* 203 */     return this.accountBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountBalance(String accountBalance)
/*     */   {
/* 212 */     this.accountBalance = accountBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCurrentFee()
/*     */   {
/* 221 */     return this.currentFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCurrentFee(String currentFee)
/*     */   {
/* 230 */     this.currentFee = currentFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditLevel()
/*     */   {
/* 239 */     return this.creditLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditLevel(String creditLevel)
/*     */   {
/* 248 */     this.creditLevel = creditLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMobileStatus()
/*     */   {
/* 257 */     return this.mobileStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMobileStatus(String mobileStatus)
/*     */   {
/* 266 */     this.mobileStatus = mobileStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNetTime()
/*     */   {
/* 275 */     return this.netTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNetTime(String netTime)
/*     */   {
/* 284 */     this.netTime = netTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getNetAge()
/*     */   {
/* 293 */     return this.netAge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNetAge(Integer netAge)
/*     */   {
/* 302 */     this.netAge = netAge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRealInfo()
/*     */   {
/* 311 */     return this.realInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRealInfo(String realInfo)
/*     */   {
/* 320 */     this.realInfo = realInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditPoint()
/*     */   {
/* 329 */     return this.creditPoint;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditPoint(String creditPoint)
/*     */   {
/* 338 */     this.creditPoint = creditPoint;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditEffectiveTime()
/*     */   {
/* 347 */     return this.creditEffectiveTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditEffectiveTime(String creditEffectiveTime)
/*     */   {
/* 356 */     this.creditEffectiveTime = creditEffectiveTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditScore()
/*     */   {
/* 365 */     return this.creditScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditScore(String creditScore)
/*     */   {
/* 374 */     this.creditScore = creditScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLandLevel()
/*     */   {
/* 383 */     return this.landLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLandLevel(String landLevel)
/*     */   {
/* 392 */     this.landLevel = landLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRoamState()
/*     */   {
/* 401 */     return this.roamState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRoamState(String roamState)
/*     */   {
/* 410 */     this.roamState = roamState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBalanceAvailable()
/*     */   {
/* 419 */     return this.balanceAvailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBalanceAvailable(String balanceAvailable)
/*     */   {
/* 428 */     this.balanceAvailable = balanceAvailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBalanceUnavailable()
/*     */   {
/* 437 */     return this.balanceUnavailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBalanceUnavailable(String balanceUnavailable)
/*     */   {
/* 446 */     this.balanceUnavailable = balanceUnavailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPrepayAvailable()
/*     */   {
/* 455 */     return this.prepayAvailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPrepayAvailable(String prepayAvailable)
/*     */   {
/* 464 */     this.prepayAvailable = prepayAvailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPromAvailable()
/*     */   {
/* 473 */     return this.promAvailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPromAvailable(String promAvailable)
/*     */   {
/* 482 */     this.promAvailable = promAvailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPrepayUnavailable()
/*     */   {
/* 491 */     return this.prepayUnavailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPrepayUnavailable(String prepayUnavailable)
/*     */   {
/* 500 */     this.prepayUnavailable = prepayUnavailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPromUnavailable()
/*     */   {
/* 509 */     return this.promUnavailable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPromUnavailable(String promUnavailable)
/*     */   {
/* 518 */     this.promUnavailable = promUnavailable;
/*     */   }
/*     */   
/*     */   public Long getReqLogId() {
/* 522 */     return this.reqLogId;
/*     */   }
/*     */   
/*     */   public void setReqLogId(Long reqLogId) {
/* 526 */     this.reqLogId = reqLogId;
/*     */   }
/*     */   
/*     */   public String getOrderNo() {
/* 530 */     return this.orderNo;
/*     */   }
/*     */   
/*     */   public void setOrderNo(String orderNo) {
/* 534 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */   public String getUserMobile() {
/* 538 */     return this.userMobile;
/*     */   }
/*     */   
/*     */   public void setUserMobile(String userMobile) {
/* 542 */     this.userMobile = userMobile;
/*     */   }
/*     */ }
