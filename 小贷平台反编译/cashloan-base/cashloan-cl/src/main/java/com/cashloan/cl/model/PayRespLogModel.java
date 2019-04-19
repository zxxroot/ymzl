/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.PayRespLog;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PayRespLogModel
/*    */   extends PayRespLog
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final int RESP_LOG_TYPE_RETURN = 1;
/*    */   public static final int RESP_LOG_TYPE_NOTIFY = 2;
/*    */   
/*    */   public PayRespLogModel(String orderNo, Integer type, String params)
/*    */   {
/* 20 */     super(orderNo, type, params);
/*    */   }
/*    */ }
