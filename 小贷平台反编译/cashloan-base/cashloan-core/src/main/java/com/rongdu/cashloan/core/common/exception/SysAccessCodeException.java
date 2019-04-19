/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SysAccessCodeException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */ 
/*    */   protected static final int SERVICE_EXCEPTION__CODE = 400;
/*    */   
/*    */ 
/*    */   protected int code;
/*    */   
/*    */ 
/*    */ 
/*    */   public SysAccessCodeException(int code, String businessMessage)
/*    */   {
/* 21 */     this(businessMessage);
/*    */   }
/*    */   
/*    */   public SysAccessCodeException(String businessMessage, Throwable cause, int code) {
/* 25 */     this(businessMessage, cause);
/*    */   }
/*    */   
/*    */   public SysAccessCodeException(String businessMessage, Throwable cause) {
/* 29 */     super(businessMessage, cause);
/* 30 */     this.code = 400;
/*    */   }
/*    */   
/*    */   public SysAccessCodeException(String message) {
/* 34 */     super(message);
/* 35 */     this.code = 400;
/*    */   }
/*    */   
/*    */   public SysAccessCodeException(Throwable t)
/*    */   {
/* 40 */     this(t.getMessage(), t);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\SysAccessCodeException.class

 */