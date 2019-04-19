/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.context.Global;
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
/*     */ public class UrgeRepayOrder
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String userName;
/*     */   private String borrowName;
/*     */   private String phone;
/*     */   private Long borrowId;
/*     */   private String orderNo;
/*     */   private Double amount;
/*     */   private String timeLimit;
/*     */   private Date borrowTime;
/*     */   private Date repayTime;
/*     */   private Long penaltyDay;
/*     */   private Double penaltyAmout;
/*     */   private String state;
/*     */   private Long count;
/*     */   private Date createTime;
/*     */   private Date successTime;
/*     */   private String level;
/*     */   public String idNo;
/*     */   public String liveDetailAddr;
/*     */   
/*     */   public String getIdNo()
/*     */   {
/* 123 */     return this.idNo;
/*     */   }
/*     */   
/*     */   public void setIdNo(String idNo) {
/* 127 */     this.idNo = idNo;
/*     */   }
/*     */   
/*     */   public String getLiveDetailAddr() {
/* 131 */     return this.liveDetailAddr;
/*     */   }
/*     */   
/*     */   public void setLiveDetailAddr(String liveDetailAddr) {
/* 135 */     this.liveDetailAddr = liveDetailAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 144 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 153 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 162 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 171 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserName()
/*     */   {
/* 180 */     return this.userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserName(String userName)
/*     */   {
/* 189 */     this.userName = userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 198 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 207 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getBorrowId()
/*     */   {
/* 216 */     return this.borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowId(Long borrowId)
/*     */   {
/* 225 */     this.borrowId = borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getAmount()
/*     */   {
/* 234 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmount(Double amount)
/*     */   {
/* 243 */     this.amount = amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTimeLimit()
/*     */   {
/* 252 */     return this.timeLimit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTimeLimit(String timeLimit)
/*     */   {
/* 261 */     this.timeLimit = timeLimit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getBorrowTime()
/*     */   {
/* 270 */     return this.borrowTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowTime(Date borrowTime)
/*     */   {
/* 279 */     this.borrowTime = borrowTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getRepayTime()
/*     */   {
/* 288 */     return this.repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayTime(Date repayTime)
/*     */   {
/* 297 */     this.repayTime = repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getPenaltyDay()
/*     */   {
/* 306 */     return this.penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPenaltyDay(Long penaltyDay)
/*     */   {
/* 315 */     this.penaltyDay = penaltyDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getPenaltyAmout()
/*     */   {
/* 324 */     return this.penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPenaltyAmout(Double penaltyAmout)
/*     */   {
/* 333 */     this.penaltyAmout = penaltyAmout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 342 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 351 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCount()
/*     */   {
/* 360 */     return this.count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCount(Long count)
/*     */   {
/* 369 */     this.count = count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 378 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 387 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String getBorrowName() {
/* 391 */     return this.borrowName;
/*     */   }
/*     */   
/*     */   public void setBorrowName(String borrowName) {
/* 395 */     this.borrowName = borrowName;
/*     */   }
/*     */   
/*     */   public String getLevel() {
/* 399 */     String penaltyDayLevel = Global.getValue("penalty_day_level");
/* 400 */     String[] penaltyDays = penaltyDayLevel.split(",");
/* 401 */     int penaltyDayOne = Integer.parseInt(penaltyDays[0]);
/* 402 */     int penaltyDayTwo = Integer.parseInt(penaltyDays[1]);
/* 403 */     if (this.penaltyDay != null) {
/* 404 */       if ((0L < this.penaltyDay.longValue()) && (this.penaltyDay.longValue() <= penaltyDayOne)) {
/* 405 */         this.level = "M1";
/* 406 */       } else if ((penaltyDayOne < this.penaltyDay.longValue()) && (this.penaltyDay.longValue() <= penaltyDayTwo)) {
/* 407 */         this.level = "M2";
/* 408 */       } else if (penaltyDayTwo < this.penaltyDay.longValue()) {
/* 409 */         this.level = "M3";
/*     */       }
/*     */     }
/* 412 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(String level) {
/* 416 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getSuccessTime()
/*     */   {
/* 423 */     return this.successTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSuccessTime(Date successTime)
/*     */   {
/* 430 */     this.successTime = successTime;
/*     */   }
/*     */   
/*     */   public String getOrderNo() {
/* 434 */     return this.orderNo;
/*     */   }
/*     */   
/*     */   public void setOrderNo(String orderNo) {
/* 438 */     this.orderNo = orderNo;
/*     */   }
/*     */ }
