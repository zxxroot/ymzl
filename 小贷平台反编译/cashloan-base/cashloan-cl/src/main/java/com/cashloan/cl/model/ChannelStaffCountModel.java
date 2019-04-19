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
/*     */ public class ChannelStaffCountModel
/*     */ {
/*     */   private Long userId;
/*     */   private String name;
/*     */   private String userName;
/*     */   private String jobNumber;
/*     */   private String status;
/*     */   private Date createTime;
/*     */   private String nidName;
/*     */   private int channelCount;
/*     */   private int channelAddCount;
/*     */   private String memberState;
/*     */   
/*     */   public int getChannelCount()
/*     */   {
/*  60 */     return this.channelCount;
/*     */   }
/*     */   
/*  63 */   public void setChannelCount(int channelCount) { this.channelCount = channelCount; }
/*     */   
/*     */   public int getChannelAddCount() {
/*  66 */     return this.channelAddCount;
/*     */   }
/*     */   
/*  69 */   public void setChannelAddCount(int channelAddCount) { this.channelAddCount = channelAddCount; }
/*     */   
/*     */   public String getNidName() {
/*  72 */     return this.nidName;
/*     */   }
/*     */   
/*  75 */   public void setNidName(String nidName) { this.nidName = nidName; }
/*     */   
/*     */   public Long getUserId() {
/*  78 */     return this.userId;
/*     */   }
/*     */   
/*  81 */   public void setUserId(Long userId) { this.userId = userId; }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMemberState()
/*     */   {
/*  87 */     return this.memberState;
/*     */   }
/*     */   
/*  90 */   public void setMemberState(String memberState) { this.memberState = memberState; }
/*     */   
/*     */   public String getName() {
/*  93 */     return this.name;
/*     */   }
/*     */   
/*  96 */   public void setName(String name) { this.name = name; }
/*     */   
/*     */   public String getUserName() {
/*  99 */     return this.userName;
/*     */   }
/*     */   
/* 102 */   public void setUserName(String userName) { this.userName = userName; }
/*     */   
/*     */   public String getJobNumber() {
/* 105 */     return this.jobNumber;
/*     */   }
/*     */   
/* 108 */   public void setJobNumber(String jobNumber) { this.jobNumber = jobNumber; }
/*     */   
/*     */   public String getStatus() {
/* 111 */     return this.status;
/*     */   }
/*     */   
/* 114 */   public void setStatus(String status) { this.status = status; }
/*     */   
/*     */   public Date getCreateTime() {
/* 117 */     return this.createTime;
/*     */   }
/*     */   
/* 120 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*     */ }
