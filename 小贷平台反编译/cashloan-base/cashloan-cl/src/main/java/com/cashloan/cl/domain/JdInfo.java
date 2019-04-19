/*     */ package com.cashloan.cl.domain;
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
/*     */ public class JdInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String bind;
/*     */   private Date bindTime;
/*     */   private Long userId;
/*     */   private String loginName;
/*     */   private String nickName;
/*     */   private String receiveAddresses;
/*     */   
/*     */   public JdInfo() {}
/*     */   
/*     */   public JdInfo(String bind, Date bindTime, Long userId, String loginName, String nickName, String receiveAddresses)
/*     */   {
/*  60 */     this.bind = bind;
/*  61 */     this.bindTime = bindTime;
/*  62 */     this.userId = userId;
/*  63 */     this.loginName = loginName;
/*  64 */     this.nickName = nickName;
/*  65 */     this.receiveAddresses = receiveAddresses;
/*     */   }
/*     */   
/*  68 */   public Long getId() { return this.id; }
/*     */   
/*     */   public void setId(Long id) {
/*  71 */     this.id = id;
/*     */   }
/*     */   
/*  74 */   public String getBind() { return this.bind; }
/*     */   
/*     */   public void setBind(String bind) {
/*  77 */     this.bind = bind;
/*     */   }
/*     */   
/*  80 */   public Date getBindTime() { return this.bindTime; }
/*     */   
/*     */   public void setBindTime(Date bindTime) {
/*  83 */     this.bindTime = bindTime;
/*     */   }
/*     */   
/*  86 */   public Long getUserId() { return this.userId; }
/*     */   
/*     */   public void setUserId(Long userId) {
/*  89 */     this.userId = userId;
/*     */   }
/*     */   
/*  92 */   public String getLoginName() { return this.loginName; }
/*     */   
/*     */   public void setLoginName(String loginName) {
/*  95 */     this.loginName = loginName;
/*     */   }
/*     */   
/*  98 */   public String getNickName() { return this.nickName; }
/*     */   
/*     */   public void setNickName(String nickName) {
/* 101 */     this.nickName = nickName;
/*     */   }
/*     */   
/* 104 */   public String getReceiveAddresses() { return this.receiveAddresses; }
/*     */   
/*     */   public void setReceiveAddresses(String receiveAddresses) {
/* 107 */     this.receiveAddresses = receiveAddresses;
/*     */   }
/*     */ }
