/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.BorrowRepay;
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
/*    */ 
/*    */ 
/*    */ public class BorrowRepayModel
/*    */   extends BorrowRepay
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String STATE_REPAY_YES = "10";
/*    */   public static final String STATE_REPAY_NO = "20";
/*    */   private String phone;
/*    */   private String repayTimeStr;
/*    */   private String realRepayTime;
/*    */   private String realRepayAmount;
/*    */   
/*    */   public String getPhone()
/*    */   {
/* 46 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 50 */     this.phone = phone;
/*    */   }
/*    */   
/*    */   public String getRepayTimeStr() {
/* 54 */     return this.repayTimeStr;
/*    */   }
/*    */   
/*    */   public void setRepayTimeStr(String repayTimeStr) {
/* 58 */     this.repayTimeStr = repayTimeStr;
/*    */   }
/*    */   
/*    */   public String getRealRepayTime() {
/* 62 */     return this.realRepayTime;
/*    */   }
/*    */   
/*    */   public void setRealRepayTime(String realRepayTime) {
/* 66 */     this.realRepayTime = realRepayTime;
/*    */   }
/*    */   
/*    */   public String getRealRepayAmount() {
/* 70 */     return this.realRepayAmount;
/*    */   }
/*    */   
/*    */   public void setRealRepayAmount(String realRepayAmount) {
/* 74 */     this.realRepayAmount = realRepayAmount;
/*    */   }
/*    */ }
