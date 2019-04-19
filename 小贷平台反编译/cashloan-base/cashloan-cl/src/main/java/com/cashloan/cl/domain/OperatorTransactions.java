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
/*    */ public class OperatorTransactions
/*    */   extends OperatorTdTransactions
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String updateTime;
/*    */   private String billCycle;
/*    */   
/*    */   public String getUpdateTime()
/*    */   {
/* 23 */     return this.updateTime;
/*    */   }
/*    */   
/*    */   public void setUpdateTime(String updateTime) {
/* 27 */     this.updateTime = updateTime;
/*    */   }
/*    */   
/*    */   public String getBillCycle() {
/* 31 */     return this.billCycle;
/*    */   }
/*    */   
/*    */   public void setBillCycle(String billCycle) {
/* 35 */     this.billCycle = billCycle;
/*    */   }
/*    */ }
