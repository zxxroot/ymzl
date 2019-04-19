/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.PayCheck;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PayCheckModel
/*    */   extends PayCheck
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String STATE_PAY_SUCCESS = "0";
/*    */   public static final String STATE_REFUND = "5";
/*    */   public static final String TYPE_AMOUNT_MISMATCH = "10";
/*    */   public static final String TYPE_UNILATERAL_OUR = "20";
/*    */   public static final String TYPE_UNILATERAL_PAYMENT = "30";
/*    */   public static final String PROCESS_WAY_NOT_DEAL = "10";
/*    */   public static final String PROCESS_WAY_MAKEUP = "20";
/*    */   public static final String PROCESS_WAY_REFUND = "30";
/*    */   public static final String PROCESS_WAY_DEDUCTION = "40";
/*    */   public static final String PROCESS_RESULT_PENDING_TREATMENT = "10";
/*    */   public static final String PROCESS_RESULT_ALREADY_DEAL = "20";
/*    */   
/*    */   public PayCheckModel(String orderNo, double orderAmount, double realPayAmount, String type, String processResult)
/*    */   {
/* 49 */     super(orderNo, orderAmount, realPayAmount, type, processResult);
/*    */   }
/*    */ }
