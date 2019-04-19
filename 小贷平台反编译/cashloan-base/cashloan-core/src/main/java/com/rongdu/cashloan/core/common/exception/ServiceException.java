/*    */ package com.rongdu.cashloan.core.common.exception;
/*    */ 
/*    */ public class ServiceException
/*    */   extends ErongBaseException
/*    */ {
/*    */   private static final long serialVersionUID = 2517215637491201756L;
/*    */   protected static final int SERVICE_EXCEPTION__CODE = 400;
/*    */   protected static final String SERVICE_EXCEPTION__MSG = "ServiceFailed";
/*    */   
/*    */   public ServiceException(String businessMessage, int code)
/*    */   {
/* 12 */     this(businessMessage);
/*    */   }
/*    */   
/*    */   public ServiceException(String businessMessage, Throwable cause, int code) {
/* 16 */     this(businessMessage, cause);
/*    */   }
/*    */   
/*    */   public ServiceException(String businessMessage, Throwable cause) {
/* 20 */     super(businessMessage, cause);
/* 21 */     this.code = 400;
/*    */   }
/*    */   
/*    */   public ServiceException(String message) {
/* 25 */     super(message);
/* 26 */     this.code = 400;
/*    */   }
/*    */   
/*    */   public ServiceException(Throwable t)
/*    */   {
/* 31 */     this(t.getMessage(), t);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\exception\ServiceException.class

 */