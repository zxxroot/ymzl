/*    */ package com.cashloan.cl.model.tongdun.http;
/*    */ 
/*    */ 
/*    */ public class HttpRestException
/*    */   extends RuntimeException
/*    */ {
/*    */   private String errCode;
/*    */   
/*    */   private String errMsg;
/*    */   
/*    */   public HttpRestException(String errCode, String errMsg)
/*    */   {
/* 13 */     super(errCode + ":" + errMsg);
/* 14 */     this.errCode = errCode;
/* 15 */     this.errMsg = errMsg;
/*    */   }
/*    */   
/*    */   public HttpRestException() {}
/*    */   
/*    */   public String getErrCode()
/*    */   {
/* 22 */     return this.errCode;
/*    */   }
/*    */   
/*    */   public void setErrCode(String errCode) {
/* 26 */     this.errCode = errCode;
/*    */   }
/*    */   
/*    */   public String getErrMsg() {
/* 30 */     return this.errMsg;
/*    */   }
/*    */   
/*    */   public void setErrMsg(String errMsg) {
/* 34 */     this.errMsg = errMsg;
/*    */   }
/*    */   
/*    */   public HttpRestException(Throwable cause) {
/* 38 */     super(cause);
/*    */   }
/*    */   
/*    */   public HttpRestException(String message, Throwable cause) {
/* 42 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public HttpRestException(String message)
/*    */   {
/* 47 */     super(message);
/*    */   }
/*    */ }
