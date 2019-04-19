/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParamValideException
/*    */   extends ErongBaseException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */ 
/*    */ 
/*    */   public ParamValideException() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public ParamValideException(int code, String msg)
/*    */   {
/* 18 */     super(code, msg);
/*    */   }
/*    */   
/*    */   public ParamValideException(int code)
/*    */   {
/* 23 */     super(code);
/*    */   }
/*    */   
/*    */   public ParamValideException(String message, Throwable cause, int code)
/*    */   {
/* 28 */     super(message, cause, code);
/*    */   }
/*    */   
/*    */   public ParamValideException(String message, Throwable cause)
/*    */   {
/* 33 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public ParamValideException(String message)
/*    */   {
/* 38 */     super(message);
/*    */   }
/*    */   
/*    */   public ParamValideException(Throwable cause)
/*    */   {
/* 43 */     super(cause);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\ParamValideException.class

 */