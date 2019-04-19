/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleMessageException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String code;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SimpleMessageException() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SimpleMessageException(String message)
/*    */   {
/* 28 */     super(message);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SimpleMessageException(String code, String message)
/*    */   {
/* 38 */     super(message);
/* 39 */     this.code = code;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 47 */     return this.code;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setCode(String code)
/*    */   {
/* 55 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\SimpleMessageException.class

 */