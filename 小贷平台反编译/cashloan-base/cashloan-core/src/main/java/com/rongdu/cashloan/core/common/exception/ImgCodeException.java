/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ImgCodeException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */ 
/*    */   protected static final int IMGCODE_EXCEPTION__CODE = 400;
/*    */   
/*    */ 
/*    */   protected int code;
/*    */   
/*    */ 
/*    */ 
/*    */   public ImgCodeException(int code, String businessMessage)
/*    */   {
/* 21 */     this(businessMessage);
/*    */   }
/*    */   
/*    */   public ImgCodeException(String businessMessage, Throwable cause, int code) {
/* 25 */     this(businessMessage, cause);
/*    */   }
/*    */   
/*    */   public ImgCodeException(String businessMessage, Throwable cause) {
/* 29 */     super(businessMessage, cause);
/* 30 */     this.code = 400;
/*    */   }
/*    */   
/*    */   public ImgCodeException(String message) {
/* 34 */     super(message);
/* 35 */     this.code = 400;
/*    */   }
/*    */   
/*    */   public ImgCodeException(Throwable t)
/*    */   {
/* 40 */     this(t.getMessage(), t);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\ImgCodeException.class

 */