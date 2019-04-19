/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OperatorException
/*    */   extends BaseRuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = -7400559552805824955L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public OperatorException() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public OperatorException(String message)
/*    */   {
/* 20 */     super(message);
/*    */   }
/*    */   
/*    */   public OperatorException(String message, int type) {
/* 24 */     super(message, type);
/*    */   }
/*    */   
/*    */   public OperatorException(String msg, RuntimeException ex) {
/* 28 */     super(msg, ex);
/*    */   }
/*    */   
/*    */   public OperatorException(String message, String url) {
/* 32 */     super(message, url);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\OperatorException.class

 */