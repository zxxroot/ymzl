/*    */ package com.cashloan.cl.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WhiteKnight
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 4718027409699547582L;
/*    */   private String verifyKey;
/*    */   private String partnerId;
/*    */   private String appId;
/*    */   private String apiUrl;
/*    */   
/*    */   public String getVerifyKey()
/*    */   {
/* 29 */     return this.verifyKey;
/*    */   }
/*    */   
/*    */   public void setVerifyKey(String verifyKey) {
/* 33 */     this.verifyKey = verifyKey;
/*    */   }
/*    */   
/*    */   public String getPartnerId() {
/* 37 */     return this.partnerId;
/*    */   }
/*    */   
/*    */   public void setPartnerId(String partnerId) {
/* 41 */     this.partnerId = partnerId;
/*    */   }
/*    */   
/*    */   public String getApiUrl() {
/* 45 */     return this.apiUrl;
/*    */   }
/*    */   
/*    */   public void setApiUrl(String apiUrl) {
/* 49 */     this.apiUrl = apiUrl;
/*    */   }
/*    */   
/*    */   public String getAppId() {
/* 53 */     return this.appId;
/*    */   }
/*    */   
/*    */   public void setAppId(String appId) {
/* 57 */     this.appId = appId;
/*    */   }
/*    */ }
