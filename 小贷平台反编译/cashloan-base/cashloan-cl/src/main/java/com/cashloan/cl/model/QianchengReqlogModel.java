/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.QianchengReqlog;
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
/*    */ public class QianchengReqlogModel
/*    */   extends QianchengReqlog
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Double amount;
/*    */   private String realName;
/*    */   private String phone;
/*    */   private String stateStr;
/*    */   public static final String STATE_SUBMIT = "10";
/*    */   public static final String STATE_PASS = "20";
/*    */   public static final String STATE_REFUSED = "30";
/*    */   
/*    */   public String getStateStr()
/*    */   {
/* 42 */     if ("10".equals(getState())) {
/* 43 */       setStateStr("提交申请");
/* 44 */     } else if ("20".equals(getState())) {
/* 45 */       setStateStr("审核通过");
/* 46 */     } else if ("30".equals(getState())) {
/* 47 */       setStateStr("审核不通过");
/*    */     } else {
/* 49 */       setStateStr("--");
/*    */     }
/* 51 */     return this.stateStr;
/*    */   }
/*    */   
/*    */   public void setStateStr(String stateStr) {
/* 55 */     this.stateStr = stateStr;
/*    */   }
/*    */   
/*    */   public Double getAmount() {
/* 59 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Double amount) {
/* 63 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public String getRealName() {
/* 67 */     return this.realName;
/*    */   }
/*    */   
/*    */   public void setRealName(String realName) {
/* 71 */     this.realName = realName;
/*    */   }
/*    */   
/*    */   public String getPhone() {
/* 75 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 79 */     this.phone = phone;
/*    */   }
/*    */ }
