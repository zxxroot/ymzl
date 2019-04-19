/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ 
/*    */ public class PersistentDataException
/*    */   extends ErongBaseException
/*    */ {
/*    */   private static final long serialVersionUID = -4715158650768072340L;
/*    */   
/*    */   public PersistentDataException() {}
/*    */   
/*    */   public PersistentDataException(int code, String msg)
/*    */   {
/* 13 */     super(code, msg);
/*    */   }
/*    */   
/*    */   public PersistentDataException(int code) {
/* 17 */     super(code);
/*    */   }
/*    */   
/*    */   public PersistentDataException(String message, Throwable cause, int code) {
/* 21 */     super(message, cause, code);
/*    */   }
/*    */   
/*    */   public PersistentDataException(String message, Throwable cause) {
/* 25 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public PersistentDataException(String message) {
/* 29 */     super(message);
/*    */   }
/*    */   
/*    */   public PersistentDataException(Throwable cause) {
/* 33 */     super(cause);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\PersistentDataException.class

 */