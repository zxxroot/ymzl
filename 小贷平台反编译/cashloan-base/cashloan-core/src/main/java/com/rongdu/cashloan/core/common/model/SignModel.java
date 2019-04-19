/*     */ package com.rongdu.cashloan.core.common.model;
/*     */ 
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SignModel
/*     */ {
/*  17 */   private static final Logger logger = Logger.getLogger(SignModel.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String realName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String userName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String idNo;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String phone;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String email;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String cardId;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String pwd;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String payPwd;
/*     */   
/*     */ 
/*     */ 
/*     */   private String signInfo;
/*     */   
/*     */ 
/*     */ 
/*     */   private String[] requestParamNames;
/*     */   
/*     */ 
/*     */ 
/*     */   private String[] responseParamNames;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSignInfo()
/*     */   {
/*  76 */     return this.signInfo;
/*     */   }
/*     */   
/*     */   public void setSignInfo(String signInfo) {
/*  80 */     this.signInfo = signInfo;
/*     */   }
/*     */   
/*     */   public String[] getRequestParamNames() {
/*  84 */     return this.requestParamNames;
/*     */   }
/*     */   
/*     */   public void setRequestParamNames(String[] requestParamNames) {
/*  88 */     this.requestParamNames = requestParamNames;
/*     */   }
/*     */   
/*     */   public String[] getResponseParamNames() {
/*  92 */     return this.responseParamNames;
/*     */   }
/*     */   
/*     */   public void setResponseParamNames(String[] responseParamNames) {
/*  96 */     this.responseParamNames = responseParamNames;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/* 100 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/* 104 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/* 108 */     return this.userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String userName) {
/* 112 */     this.userName = userName;
/*     */   }
/*     */   
/*     */   public String getIdNo() {
/* 116 */     return this.idNo;
/*     */   }
/*     */   
/*     */   public void setIdNo(String idNo) {
/* 120 */     this.idNo = idNo;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 124 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 128 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 132 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 136 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getCardId() {
/* 140 */     return this.cardId;
/*     */   }
/*     */   
/*     */   public void setCardId(String cardId) {
/* 144 */     this.cardId = cardId;
/*     */   }
/*     */   
/*     */   public String getPwd() {
/* 148 */     return this.pwd;
/*     */   }
/*     */   
/*     */   public void setPwd(String pwd) {
/* 152 */     this.pwd = pwd;
/*     */   }
/*     */   
/*     */   public String getPayPwd() {
/* 156 */     return this.payPwd;
/*     */   }
/*     */   
/*     */   public void setPayPwd(String payPwd) {
/* 160 */     this.payPwd = payPwd;
/*     */   }
/*     */   
/*     */   public static Logger getLogger() {
/* 164 */     return logger;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\model\SignModel.class

 */