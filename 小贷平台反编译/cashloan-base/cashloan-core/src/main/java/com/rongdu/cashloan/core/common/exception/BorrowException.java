/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BorrowException
/*    */   extends BaseRuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = -7400559552805824955L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public BorrowException() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public BorrowException(String message)
/*    */   {
/* 20 */     super(message);
/*    */   }
/*    */   
/*    */   public BorrowException(String message, String url) {
/* 24 */     super(message, url);
/*    */   }
/*    */   
/*    */   public BorrowException(String message, int type) {
/* 28 */     super(message, type);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\BorrowException.class

 */