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
/*     */ public class ManageProfitModel
/*     */ {
/*     */   private long id;
/*     */   private long userId;
/*     */   private long inviteId;
/*     */   private String userName;
/*     */   private String inviteName;
/*     */   private Date addTime;
/*     */   private String level;
/*     */   private String rate;
/*     */   
/*     */   public long getId()
/*     */   {
/*  40 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(long id)
/*     */   {
/*  48 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getUserId()
/*     */   {
/*  56 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(long userId)
/*     */   {
/*  64 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getInviteId()
/*     */   {
/*  72 */     return this.inviteId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInviteId(long inviteId)
/*     */   {
/*  80 */     this.inviteId = inviteId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserName()
/*     */   {
/*  88 */     return this.userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserName(String userName)
/*     */   {
/*  96 */     this.userName = userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInviteName()
/*     */   {
/* 104 */     return this.inviteName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInviteName(String inviteName)
/*     */   {
/* 112 */     this.inviteName = inviteName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 120 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 128 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLevel()
/*     */   {
/* 136 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLevel(String level)
/*     */   {
/* 144 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRate()
/*     */   {
/* 152 */     return this.rate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRate(String rate)
/*     */   {
/* 160 */     this.rate = rate;
/*     */   }
/*     */ }
