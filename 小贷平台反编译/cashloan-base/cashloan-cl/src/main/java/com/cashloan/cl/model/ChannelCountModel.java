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
/*     */ public class ChannelCountModel
/*     */ {
/*     */   private Date time;
/*     */   private String code;
/*     */   private String name;
/*     */   private String registerCount;
/*     */   private String borrowMember;
/*     */   private String borrowCount;
/*     */   private String borrowAmout;
/*     */   private String badRate;
/*     */   private String payCount;
/*     */   private String payAccount;
/*     */   
/*     */   public Date getTime()
/*     */   {
/*  56 */     return this.time;
/*     */   }
/*     */   
/*  59 */   public void setTime(Date time) { this.time = time; }
/*     */   
/*     */   public String getCode() {
/*  62 */     return this.code;
/*     */   }
/*     */   
/*  65 */   public void setCode(String code) { this.code = code; }
/*     */   
/*     */   public String getName() {
/*  68 */     return this.name;
/*     */   }
/*     */   
/*  71 */   public void setName(String name) { this.name = name; }
/*     */   
/*     */   public String getRegisterCount() {
/*  74 */     return this.registerCount;
/*     */   }
/*     */   
/*  77 */   public void setRegisterCount(String registerCount) { this.registerCount = registerCount; }
/*     */   
/*     */   public String getBorrowMember() {
/*  80 */     return this.borrowMember;
/*     */   }
/*     */   
/*  83 */   public void setBorrowMember(String borrowMember) { this.borrowMember = borrowMember; }
/*     */   
/*     */   public String getBorrowCount() {
/*  86 */     return this.borrowCount;
/*     */   }
/*     */   
/*  89 */   public void setBorrowCount(String borrowCount) { this.borrowCount = borrowCount; }
/*     */   
/*     */   public String getBorrowAmout() {
/*  92 */     return this.borrowAmout;
/*     */   }
/*     */   
/*  95 */   public void setBorrowAmout(String borrowAmout) { this.borrowAmout = borrowAmout; }
/*     */   
/*     */   public String getBadRate() {
/*  98 */     return this.badRate;
/*     */   }
/*     */   
/* 101 */   public void setBadRate(String badRate) { this.badRate = badRate; }
/*     */   
/*     */   public String getPayCount() {
/* 104 */     return this.payCount;
/*     */   }
/*     */   
/* 107 */   public void setPayCount(String payCount) { this.payCount = payCount; }
/*     */   
/*     */   public String getPayAccount() {
/* 110 */     return this.payAccount;
/*     */   }
/*     */   
/* 113 */   public void setPayAccount(String payAccount) { this.payAccount = payAccount; }
/*     */ }
