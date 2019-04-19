/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ public class ErongBaseException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 2762206975774689502L;
/*  7 */   protected int code = 500;
/*    */   
/*    */   public ErongBaseException(int code) {
/* 10 */     this.code = code;
/*    */   }
/*    */   
/*    */ 
/*    */   public ErongBaseException() {}
/*    */   
/*    */   public ErongBaseException(String message)
/*    */   {
/* 18 */     super(message);
/*    */   }
/*    */   
/*    */   public ErongBaseException(int code, String msg) {
/* 22 */     super(msg);
/* 23 */     this.code = code;
/*    */   }
/*    */   
/*    */   public ErongBaseException(Throwable cause) {
/* 27 */     super(cause);
/*    */   }
/*    */   
/*    */   public ErongBaseException(String message, Throwable cause) {
/* 31 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public ErongBaseException(String message, Throwable cause, int code) {
/* 35 */     super(message, cause);
/* 36 */     this.code = code;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 40 */     return this.code;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\ErongBaseException.class

 */