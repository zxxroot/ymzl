/*     */ package com.cashloan.cl.model.zmxy.creditScore;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WhiteKnightZhiMaResult
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String resultCode;
/*     */   private String resultDesc;
/*     */   private ZmDetail data;
/*     */   
/*     */   public String getResultCode()
/*     */   {
/*  22 */     return this.resultCode;
/*     */   }
/*     */   
/*     */   public void setResultCode(String resultCode) {
/*  26 */     this.resultCode = resultCode;
/*     */   }
/*     */   
/*     */   public String getResultDesc() {
/*  30 */     return this.resultDesc;
/*     */   }
/*     */   
/*     */   public void setResultDesc(String resultDesc) {
/*  34 */     this.resultDesc = resultDesc;
/*     */   }
/*     */   
/*     */   public ZmDetail getData() {
/*  38 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setData(ZmDetail data) {
/*  42 */     this.data = data;
/*     */   }
/*     */   
/*     */   public static class ZmDetail
/*     */   {
/*     */     private WhiteKnightZhiMaResult.ZmDetailInfo zmDetailInfo;
/*     */     
/*     */     public WhiteKnightZhiMaResult.ZmDetailInfo getZmDetailInfo()
/*     */     {
/*  51 */       return this.zmDetailInfo;
/*     */     }
/*     */     
/*     */     public void setZmDetailInfo(WhiteKnightZhiMaResult.ZmDetailInfo zmDetailInfo) {
/*  55 */       this.zmDetailInfo = zmDetailInfo;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static class ZmDetailInfo
/*     */   {
/*     */     private String zmScore;
/*     */     
/*     */     private String realCheckName;
/*     */     
/*     */     private String realCheckCertNo;
/*     */     
/*     */     private String loginType;
/*     */     
/*     */     private String userName;
/*     */     
/*     */     private String memberName;
/*     */     
/*     */     private String jiebeiAmount;
/*     */     
/*     */     private String huabeiTotalAmount;
/*     */     
/*     */     private String huabeiAvailAmount;
/*     */     
/*     */     private Boolean equalToPetitioner;
/*     */     
/*     */     private Long storeTime;
/*     */     
/*     */     public String getZmScore()
/*     */     {
/*  86 */       return this.zmScore;
/*     */     }
/*     */     
/*     */     public void setZmScore(String zmScore) {
/*  90 */       this.zmScore = zmScore;
/*     */     }
/*     */     
/*     */     public String getRealCheckName() {
/*  94 */       return this.realCheckName;
/*     */     }
/*     */     
/*     */     public void setRealCheckName(String realCheckName) {
/*  98 */       this.realCheckName = realCheckName;
/*     */     }
/*     */     
/*     */     public String getRealCheckCertNo() {
/* 102 */       return this.realCheckCertNo;
/*     */     }
/*     */     
/*     */     public void setRealCheckCertNo(String realCheckCertNo) {
/* 106 */       this.realCheckCertNo = realCheckCertNo;
/*     */     }
/*     */     
/*     */     public String getLoginType() {
/* 110 */       return this.loginType;
/*     */     }
/*     */     
/*     */     public void setLoginType(String loginType) {
/* 114 */       this.loginType = loginType;
/*     */     }
/*     */     
/*     */     public String getUserName() {
/* 118 */       return this.userName;
/*     */     }
/*     */     
/*     */     public void setUserName(String userName) {
/* 122 */       this.userName = userName;
/*     */     }
/*     */     
/*     */     public String getMemberName() {
/* 126 */       return this.memberName;
/*     */     }
/*     */     
/*     */     public void setMemberName(String memberName) {
/* 130 */       this.memberName = memberName;
/*     */     }
/*     */     
/*     */     public String getJiebeiAmount() {
/* 134 */       return this.jiebeiAmount;
/*     */     }
/*     */     
/*     */     public void setJiebeiAmount(String jiebeiAmount) {
/* 138 */       this.jiebeiAmount = jiebeiAmount;
/*     */     }
/*     */     
/*     */     public String getHuabeiTotalAmount() {
/* 142 */       return this.huabeiTotalAmount;
/*     */     }
/*     */     
/*     */     public void setHuabeiTotalAmount(String huabeiTotalAmount) {
/* 146 */       this.huabeiTotalAmount = huabeiTotalAmount;
/*     */     }
/*     */     
/*     */     public String getHuabeiAvailAmount() {
/* 150 */       return this.huabeiAvailAmount;
/*     */     }
/*     */     
/*     */     public void setHuabeiAvailAmount(String huabeiAvailAmount) {
/* 154 */       this.huabeiAvailAmount = huabeiAvailAmount;
/*     */     }
/*     */     
/*     */     public Boolean getEqualToPetitioner() {
/* 158 */       return this.equalToPetitioner;
/*     */     }
/*     */     
/*     */     public void setEqualToPetitioner(Boolean equalToPetitioner) {
/* 162 */       this.equalToPetitioner = equalToPetitioner;
/*     */     }
/*     */     
/*     */     public Long getStoreTime() {
/* 166 */       return this.storeTime;
/*     */     }
/*     */     
/*     */     public void setStoreTime(Long storeTime) {
/* 170 */       this.storeTime = storeTime;
/*     */     }
/*     */   }
/*     */ }
