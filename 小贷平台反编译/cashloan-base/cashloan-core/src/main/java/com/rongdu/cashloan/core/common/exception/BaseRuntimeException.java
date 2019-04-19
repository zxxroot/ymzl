/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ public class BaseRuntimeException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 538922474277376456L;
/*    */   public static final int TYPE_JSON = 1;
/*    */   private String url;
/*  9 */   protected int type = 500;
/*    */   
/*    */   public BaseRuntimeException(String msg, Throwable cause) {
/* 12 */     super(msg, cause);
/*    */   }
/*    */   
/*    */ 
/*    */   public BaseRuntimeException() {}
/*    */   
/*    */   public BaseRuntimeException(String message)
/*    */   {
/* 20 */     super(message);
/*    */   }
/*    */   
/*    */   public BaseRuntimeException(String message, String url) {
/* 24 */     super(message);
/* 25 */     this.url = url;
/*    */   }
/*    */   
/*    */   public BaseRuntimeException(String message, int type) {
/* 29 */     super(message);
/* 30 */     this.type = type;
/*    */   }
/*    */   
/*    */   public int getType() {
/* 34 */     return this.type;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 38 */     return this.url;
/*    */   }
/*    */   
/*    */   public void setUrl(String url) {
/* 42 */     this.url = url;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\BaseRuntimeException.class

 */