/*     */ package com.rongdu.cashloan.core.domain;
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
/*     */ public class Borrow
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String orderNo;
/*     */   private Double amount;
/*     */   private Double realAmount;
/*     */   private Double fee;
/*     */   private Date createTime;
/*     */   private String timeLimit;
/*     */   private String state;
/*     */   private Long cardId;
/*     */   private Double serviceFee;
/*     */   private Double infoAuthFee;
/*     */   private Double channelFee;
/*     */   private Double accountFee;
/*     */   private Double interest;
/*     */   private String client;
/*     */   private String address;
/*     */   private String coordinate;
/*     */   private String remark;
/*     */   private String ip;
/*     */   private String signServiceId;
/*     */   private Long sysUserId;
/*     */   private Date auditTime;
/*     */   private int borrowType;
/*     */   
/*     */   public Borrow() {}
/*     */   
/*     */   public Borrow(Long userId, Double amount, String timeLimit, Long cardId, String client, String address, String coordinate, String ip)
/*     */   {
/* 148 */     this.userId = userId;
/* 149 */     this.amount = amount;
/* 150 */     this.timeLimit = timeLimit;
/* 151 */     this.cardId = cardId;
/* 152 */     this.client = client;
/* 153 */     this.address = address;
/* 154 */     this.coordinate = coordinate;
/* 155 */     this.ip = ip;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 164 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 173 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 182 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 192 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 201 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 211 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getAmount()
/*     */   {
/* 220 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmount(Double amount)
/*     */   {
/* 230 */     this.amount = amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRealAmount()
/*     */   {
/* 239 */     return this.realAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRealAmount(Double realAmount)
/*     */   {
/* 249 */     this.realAmount = realAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getFee()
/*     */   {
/* 258 */     return this.fee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFee(Double fee)
/*     */   {
/* 268 */     this.fee = fee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 277 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 287 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTimeLimit()
/*     */   {
/* 296 */     return this.timeLimit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTimeLimit(String timeLimit)
/*     */   {
/* 306 */     this.timeLimit = timeLimit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 315 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 325 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCardId()
/*     */   {
/* 334 */     return this.cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardId(Long cardId)
/*     */   {
/* 344 */     this.cardId = cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getServiceFee()
/*     */   {
/* 353 */     return this.serviceFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setServiceFee(Double serviceFee)
/*     */   {
/* 363 */     this.serviceFee = serviceFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getInfoAuthFee()
/*     */   {
/* 372 */     return this.infoAuthFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInfoAuthFee(Double infoAuthFee)
/*     */   {
/* 382 */     this.infoAuthFee = infoAuthFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getChannelFee()
/*     */   {
/* 391 */     return this.channelFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setChannelFee(Double channelFee)
/*     */   {
/* 401 */     this.channelFee = channelFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getAccountFee()
/*     */   {
/* 410 */     return this.accountFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountFee(Double accountFee)
/*     */   {
/* 420 */     this.accountFee = accountFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getInterest()
/*     */   {
/* 429 */     return this.interest;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInterest(Double interest)
/*     */   {
/* 439 */     this.interest = interest;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getClient()
/*     */   {
/* 448 */     return this.client;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setClient(String client)
/*     */   {
/* 458 */     this.client = client;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddress()
/*     */   {
/* 465 */     return this.address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 473 */     this.address = address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCoordinate()
/*     */   {
/* 480 */     return this.coordinate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCoordinate(String coordinate)
/*     */   {
/* 488 */     this.coordinate = coordinate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 495 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 503 */     this.remark = remark;
/*     */   }
/*     */   
/*     */   public String getIp() {
/* 507 */     return this.ip;
/*     */   }
/*     */   
/*     */   public void setIp(String ip) {
/* 511 */     this.ip = ip;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSignServiceId()
/*     */   {
/* 518 */     return this.signServiceId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSignServiceId(String signServiceId)
/*     */   {
/* 526 */     this.signServiceId = signServiceId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getSysUserId()
/*     */   {
/* 535 */     return this.sysUserId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSysUserId(Long sysUserId)
/*     */   {
/* 544 */     this.sysUserId = sysUserId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAuditTime()
/*     */   {
/* 553 */     return this.auditTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAuditTime(Date auditTime)
/*     */   {
/* 562 */     this.auditTime = auditTime;
/*     */   }
/*     */   
/*     */   public int getBorrowType() {
/* 566 */     return this.borrowType;
/*     */   }
/*     */   
/*     */   public void setBorrowType(int borrowType) {
/* 570 */     this.borrowType = borrowType;
/*     */   }
/*     */ }
