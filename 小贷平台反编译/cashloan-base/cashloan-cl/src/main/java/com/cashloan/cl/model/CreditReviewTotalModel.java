/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreditReviewTotalModel
/*     */ {
/*     */   private Long userId;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String name;
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
/*     */   private String jobNumber;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String status;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String memberState;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String waitCreditCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String creditCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String creditSucCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String creditRefCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String rate;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/*  70 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/*  74 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  78 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  82 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/*  86 */     return this.userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String userName) {
/*  90 */     this.userName = userName;
/*     */   }
/*     */   
/*     */   public String getJobNumber() {
/*  94 */     return this.jobNumber;
/*     */   }
/*     */   
/*     */   public void setJobNumber(String jobNumber) {
/*  98 */     this.jobNumber = jobNumber;
/*     */   }
/*     */   
/*     */   public String getStatus() {
/* 102 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 106 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getWaitCreditCount() {
/* 110 */     return this.waitCreditCount;
/*     */   }
/*     */   
/*     */   public void setWaitCreditCount(String waitCreditCount) {
/* 114 */     this.waitCreditCount = waitCreditCount;
/*     */   }
/*     */   
/*     */   public String getCreditCount() {
/* 118 */     return this.creditCount;
/*     */   }
/*     */   
/*     */   public void setCreditCount(String creditCount) {
/* 122 */     this.creditCount = creditCount;
/*     */   }
/*     */   
/*     */   public String getCreditSucCount() {
/* 126 */     return this.creditSucCount;
/*     */   }
/*     */   
/*     */   public void setCreditSucCount(String creditSucCount) {
/* 130 */     this.creditSucCount = creditSucCount;
/*     */   }
/*     */   
/*     */   public String getCreditRefCount() {
/* 134 */     return this.creditRefCount;
/*     */   }
/*     */   
/*     */   public void setCreditRefCount(String creditRefCount) {
/* 138 */     this.creditRefCount = creditRefCount;
/*     */   }
/*     */   
/*     */   public String getMemberState() {
/* 142 */     return this.memberState;
/*     */   }
/*     */   
/*     */   public void setMemberState(String memberState) {
/* 146 */     this.memberState = memberState;
/*     */   }
/*     */   
/*     */   public String getRate() {
/* 150 */     return this.rate;
/*     */   }
/*     */   
/*     */   public void setRate(String rate) {
/* 154 */     this.rate = rate;
/*     */   }
/*     */ }
