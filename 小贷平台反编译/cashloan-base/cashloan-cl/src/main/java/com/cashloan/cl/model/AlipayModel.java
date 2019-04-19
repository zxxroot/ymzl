/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import java.util.Date;
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
/*    */ public class AlipayModel
/*    */ {
/*    */   private String account;
/*    */   private String amount;
/*    */   private String remark;
/*    */   private Date repayTime;
/*    */   private String serialNumber;
/*    */   
/*    */   public String getAccount()
/*    */   {
/* 39 */     return this.account;
/*    */   }
/*    */   
/* 42 */   public void setAccount(String account) { this.account = account; }
/*    */   
/*    */   public String getAmount() {
/* 45 */     return this.amount;
/*    */   }
/*    */   
/* 48 */   public void setAmount(String amount) { this.amount = amount; }
/*    */   
/*    */   public Date getRepayTime() {
/* 51 */     return this.repayTime;
/*    */   }
/*    */   
/* 54 */   public void setRepayTime(Date repayTime) { this.repayTime = repayTime; }
/*    */   
/*    */   public String getSerialNumber() {
/* 57 */     return this.serialNumber;
/*    */   }
/*    */   
/* 60 */   public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
/*    */   
/*    */   public String getRemark() {
/* 63 */     return this.remark;
/*    */   }
/*    */   
/* 66 */   public void setRemark(String remark) { this.remark = remark; }
/*    */ }
