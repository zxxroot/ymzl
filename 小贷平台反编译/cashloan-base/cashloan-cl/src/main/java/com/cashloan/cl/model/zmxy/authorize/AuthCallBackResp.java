/*    */ package com.cashloan.cl.model.zmxy.authorize;
/*    */ 
/*    */ 
/*    */ public class AuthCallBackResp
/*    */ {
/*    */   private boolean success;
/*    */   
/*    */   private String openId;
/*    */   
/*    */   private String key;
/*    */   
/*    */   private String errorCode;
/*    */   
/*    */   private String errorMessage;
/*    */   
/*    */ 
/*    */   public String getErrorCode()
/*    */   {
/* 19 */     return this.errorCode;
/*    */   }
/*    */   
/*    */   public String getErrorMessage() {
/* 23 */     return this.errorMessage;
/*    */   }
/*    */   
/*    */   public String getOpenId() {
/* 27 */     return this.openId;
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 31 */     return this.key;
/*    */   }
/*    */   
/*    */   public boolean isSuccess() {
/* 35 */     return this.success;
/*    */   }
/*    */   
/*    */   public void setSuccess(boolean success) {
/* 39 */     this.success = success;
/*    */   }
/*    */   
/*    */   public void setOpenId(String openId) {
/* 43 */     this.openId = openId;
/*    */   }
/*    */   
/*    */   public void setKey(String key) {
/* 47 */     this.key = key;
/*    */   }
/*    */   
/*    */   public void setErrorCode(String errorCode) {
/* 51 */     this.errorCode = errorCode;
/*    */   }
/*    */   
/*    */   public void setErrorMessage(String errorMessage) {
/* 55 */     this.errorMessage = errorMessage;
/*    */   }
/*    */ }
