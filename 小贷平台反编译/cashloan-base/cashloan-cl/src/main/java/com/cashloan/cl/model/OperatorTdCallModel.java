/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorTdCallRecord;
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
/*    */ public class OperatorTdCallModel
/*    */   extends OperatorTdCallRecord
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String userMobile;
/*    */   
/*    */   public String getUserMobile()
/*    */   {
/* 24 */     return this.userMobile;
/*    */   }
/*    */   
/*    */   public void setUserMobile(String userMobile) {
/* 28 */     this.userMobile = userMobile;
/*    */   }
/*    */ }
