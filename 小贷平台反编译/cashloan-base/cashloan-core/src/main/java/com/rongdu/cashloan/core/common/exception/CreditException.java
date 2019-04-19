/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CreditException
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
/*    */   public CreditException() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CreditException(String message)
/*    */   {
/* 27 */     super(message);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public CreditException(String code, String message)
/*    */   {
/* 37 */     super(message);
/* 38 */     this.code = code;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 46 */     return this.code;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setCode(String code)
/*    */   {
/* 54 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\CreditException.class

 */