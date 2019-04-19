/*    */ package com.cashloan.cl.model.tongdun.http;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class HttpRestResponse
/*    */ {
/*    */   private Integer code;
/*    */   
/*    */ 
/*    */   private String message;
/*    */   
/*    */ 
/*    */   private String body;
/*    */   
/*    */   private HttpRestRequest<?> httpRestRequest;
/*    */   
/*    */ 
/*    */   public Integer getCode()
/*    */   {
/* 20 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(Integer code) {
/* 24 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 28 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 32 */     this.message = message;
/*    */   }
/*    */   
/*    */   public String getBody() {
/* 36 */     return this.body;
/*    */   }
/*    */   
/*    */   public void setBody(String body) {
/* 40 */     this.body = body;
/*    */   }
/*    */   
/*    */   public HttpRestRequest<?> getHttpRestRequest() {
/* 44 */     return this.httpRestRequest;
/*    */   }
/*    */   
/*    */   public void setHttpRestRequest(HttpRestRequest<?> httpRestRequest) {
/* 48 */     this.httpRestRequest = httpRestRequest;
/*    */   }
/*    */   
/*    */   public abstract String postResponseToJsonStr();
/*    */ }
