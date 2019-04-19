/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import org.springframework.beans.BeanUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManageCreditReviewModel
/*     */   extends Borrow
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private String stateStr;
/*     */   private String sysName;
/*     */   private String channel;
/*     */   private int channelId;
/*     */   private Long sysUserId;
/*     */   private int giveStatus;
/*     */   
/*     */   public static ManageCreditReviewModel instance(Borrow borrow)
/*     */   {
/*  23 */     ManageCreditReviewModel borrowModel = new ManageCreditReviewModel();
/*  24 */     BeanUtils.copyProperties(borrow, borrowModel);
/*  25 */     return borrowModel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRealName()
/*     */   {
/*  69 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/*  73 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/*  77 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  81 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getStateStr() {
/*  85 */     if (getState() != null) {
/*  86 */       if ("22".equals(getState())) {
/*  87 */         this.stateStr = "待人工复审";
/*  88 */       } else if ("27".equals(getState())) {
/*  89 */         this.stateStr = "人工复审不通过";
/*     */       } else {
/*  91 */         this.stateStr = "人工复审通过";
/*     */       }
/*     */     }
/*  94 */     return this.stateStr;
/*     */   }
/*     */   
/*     */   public void setStateStr(String stateStr) {
/*  98 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */   public String getSysName() {
/* 102 */     return this.sysName;
/*     */   }
/*     */   
/*     */   public void setSysName(String sysName) {
/* 106 */     this.sysName = sysName;
/*     */   }
/*     */   
/*     */   public String getChannel() {
/* 110 */     return this.channel;
/*     */   }
/*     */   
/*     */   public void setChannel(String channel) {
/* 114 */     this.channel = channel;
/*     */   }
/*     */   
/*     */   public int getChannelId() {
/* 118 */     return this.channelId;
/*     */   }
/*     */   
/*     */   public void setChannelId(int channelId) {
/* 122 */     this.channelId = channelId;
/*     */   }
/*     */   
/*     */   public Long getSysUserId() {
/* 126 */     return this.sysUserId;
/*     */   }
/*     */   
/*     */   public void setSysUserId(Long sysUserId) {
/* 130 */     this.sysUserId = sysUserId;
/*     */   }
/*     */   
/*     */   public int getGiveStatus() {
/* 134 */     this.giveStatus = 1;
/* 135 */     if (getSysUserId() == null) {
/* 136 */       this.giveStatus = 0;
/*     */     }
/* 138 */     return this.giveStatus;
/*     */   }
/*     */   
/*     */   public void setGiveStatus(int giveStatus) {
/* 142 */     this.giveStatus = giveStatus;
/*     */   }
/*     */ }
