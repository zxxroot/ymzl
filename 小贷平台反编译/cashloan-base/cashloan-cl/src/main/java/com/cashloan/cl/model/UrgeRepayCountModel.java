/*     */ package com.cashloan.cl.model;
/*     */ 
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
/*     */ public class UrgeRepayCountModel
/*     */ {
/*     */   private Long userId;
/*     */   private String name;
/*     */   private String userName;
/*     */   private String jobNumber;
/*     */   private String status;
/*     */   private int count;
/*     */   private int waitCount;
/*     */   private int successCount;
/*     */   private int yesterdayCount;
/*     */   private int orderCount;
/*     */   private int failCount;
/*     */   private double backRate;
/*     */   private Date createTime;
/*     */   private int promisCount;
/*     */   private int allOrderCount;
/*     */   private int allFailCount;
/*     */   private double allBackRate;
/*     */   private int allSuccessCount;
/*     */   private String memberState;
/*     */   
/*     */   public Long getUserId()
/*     */   {
/* 101 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 108 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMemberState()
/*     */   {
/* 117 */     return this.memberState;
/*     */   }
/*     */   
/* 120 */   public void setMemberState(String memberState) { this.memberState = memberState; }
/*     */   
/*     */   public int getPromisCount() {
/* 123 */     return this.promisCount;
/*     */   }
/*     */   
/* 126 */   public void setPromisCount(int promisCount) { this.promisCount = promisCount; }
/*     */   
/*     */   public String getName() {
/* 129 */     return this.name;
/*     */   }
/*     */   
/* 132 */   public void setName(String name) { this.name = name; }
/*     */   
/*     */   public String getUserName() {
/* 135 */     return this.userName;
/*     */   }
/*     */   
/* 138 */   public void setUserName(String userName) { this.userName = userName; }
/*     */   
/*     */   public String getJobNumber() {
/* 141 */     return this.jobNumber;
/*     */   }
/*     */   
/* 144 */   public void setJobNumber(String jobNumber) { this.jobNumber = jobNumber; }
/*     */   
/*     */   public String getStatus() {
/* 147 */     return this.status;
/*     */   }
/*     */   
/* 150 */   public void setStatus(String status) { this.status = status; }
/*     */   
/*     */   public int getCount() {
/* 153 */     return this.count;
/*     */   }
/*     */   
/* 156 */   public void setCount(int count) { this.count = count; }
/*     */   
/*     */   public int getWaitCount() {
/* 159 */     return this.waitCount;
/*     */   }
/*     */   
/* 162 */   public void setWaitCount(int waitCount) { this.waitCount = waitCount; }
/*     */   
/*     */   public int getSuccessCount() {
/* 165 */     return this.successCount;
/*     */   }
/*     */   
/* 168 */   public void setSuccessCount(int successCount) { this.successCount = successCount; }
/*     */   
/*     */   public int getYesterdayCount() {
/* 171 */     return this.yesterdayCount;
/*     */   }
/*     */   
/* 174 */   public void setYesterdayCount(int yesterdayCount) { this.yesterdayCount = yesterdayCount; }
/*     */   
/*     */   public int getOrderCount() {
/* 177 */     return this.orderCount;
/*     */   }
/*     */   
/* 180 */   public void setOrderCount(int orderCount) { this.orderCount = orderCount; }
/*     */   
/*     */   public int getFailCount() {
/* 183 */     return this.failCount;
/*     */   }
/*     */   
/* 186 */   public void setFailCount(int failCount) { this.failCount = failCount; }
/*     */   
/*     */   public double getBackRate() {
/* 189 */     return this.backRate;
/*     */   }
/*     */   
/* 192 */   public void setBackRate(double backRate) { this.backRate = backRate; }
/*     */   
/*     */   public Date getCreateTime() {
/* 195 */     return this.createTime;
/*     */   }
/*     */   
/* 198 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*     */   
/*     */   public int getAllOrderCount() {
/* 201 */     return this.allOrderCount;
/*     */   }
/*     */   
/* 204 */   public void setAllOrderCount(int allOrderCount) { this.allOrderCount = allOrderCount; }
/*     */   
/*     */   public int getAllFailCount() {
/* 207 */     return this.allFailCount;
/*     */   }
/*     */   
/* 210 */   public void setAllFailCount(int allFailCount) { this.allFailCount = allFailCount; }
/*     */   
/*     */   public double getAllBackRate() {
/* 213 */     return this.allBackRate;
/*     */   }
/*     */   
/* 216 */   public void setAllBackRate(double allBackRate) { this.allBackRate = allBackRate; }
/*     */   
/*     */   public int getAllSuccessCount() {
/* 219 */     return this.allSuccessCount;
/*     */   }
/*     */   
/* 222 */   public void setAllSuccessCount(int allSuccessCount) { this.allSuccessCount = allSuccessCount; }
/*     */ }
