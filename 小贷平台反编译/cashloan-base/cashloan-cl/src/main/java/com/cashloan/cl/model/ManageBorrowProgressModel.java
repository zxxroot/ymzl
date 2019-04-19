/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.BorrowProgress;
/*    */ import com.rongdu.cashloan.core.model.BorrowModel;
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
/*    */ public class ManageBorrowProgressModel
/*    */   extends BorrowProgress
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String realName;
/*    */   private String phone;
/*    */   private String orderNo;
/*    */   private Double amount;
/*    */   private String stateStr;
/*    */   
/*    */   public String getStateStr()
/*    */   {
/* 38 */     this.stateStr = BorrowModel.manageConvertBorrowState(getState());
/* 39 */     return this.stateStr;
/*    */   }
/*    */   
/*    */   public void setStateStr(String stateStr)
/*    */   {
/* 44 */     this.stateStr = stateStr;
/*    */   }
/*    */   
/*    */   public String getRealName() {
/* 48 */     return this.realName;
/*    */   }
/*    */   
/*    */   public void setRealName(String realName) {
/* 52 */     this.realName = realName;
/*    */   }
/*    */   
/*    */   public String getPhone() {
/* 56 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 60 */     this.phone = phone;
/*    */   }
/*    */   
/*    */   public String getOrderNo() {
/* 64 */     return this.orderNo;
/*    */   }
/*    */   
/*    */   public void setOrderNo(String orderNo) {
/* 68 */     this.orderNo = orderNo;
/*    */   }
/*    */   
/*    */   public Double getAmount() {
/* 72 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Double amount) {
/* 76 */     this.amount = amount;
/*    */   }
/*    */ }
