/*    */ package com.cashloan.cl.domain;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OperatorHLSmsRecord
/*    */   extends OperatorTdSmsRecord
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1087866694521442335L;
/*    */   private String startTime;
/*    */   private String otherCellPhone;
/*    */   private String initType;
/*    */   private String place;
/*    */   private String subtotal;
/*    */   
/*    */   public void setInitType(String initType)
/*    */   {
/* 50 */     super.setMsgBizName(initType);
/* 51 */     this.initType = initType;
/*    */   }
/*    */   
/*    */   public void setOtherCellPhone(String otherCellPhone) {
/* 55 */     super.setMsgOtherNum(otherCellPhone);
/* 56 */     this.otherCellPhone = otherCellPhone;
/*    */   }
/*    */   
/*    */   public void setPlace(String place) {
/* 60 */     super.setMsgAddress(place);
/* 61 */     this.place = place;
/*    */   }
/*    */   
/*    */   public void setStartTime(String startTime) {
/* 65 */     super.setMsgStartTime(startTime);
/* 66 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   public void setSubtotal(String subtotal) {
/* 70 */     super.setMsgFee(subtotal);
/* 71 */     this.subtotal = subtotal;
/*    */   }
/*    */   
/*    */   public String getInitType() {
/* 75 */     return this.initType;
/*    */   }
/*    */   
/*    */   public String getOtherCellPhone() {
/* 79 */     return this.otherCellPhone;
/*    */   }
/*    */   
/*    */   public String getPlace() {
/* 83 */     return this.place;
/*    */   }
/*    */   
/*    */   public String getStartTime() {
/* 87 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public String getSubtotal() {
/* 91 */     return this.subtotal;
/*    */   }
/*    */ }
