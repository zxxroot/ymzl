/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorBills;
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
/*    */ public class OperatorBillsModel
/*    */   extends OperatorBills
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String billMonthDate;
/*    */   
/*    */   public String getBillMonthDate()
/*    */   {
/* 29 */     return this.billMonthDate;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setBillMonthDate(String billMonthDate)
/*    */   {
/* 37 */     this.billMonthDate = billMonthDate;
/*    */   }
/*    */ }
