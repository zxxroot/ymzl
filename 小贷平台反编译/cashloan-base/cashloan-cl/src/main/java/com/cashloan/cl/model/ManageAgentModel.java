/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.UserInvite;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ManageAgentModel
/*    */   extends UserInvite
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String level;
/*    */   private String count;
/*    */   private double borrowAmout;
/*    */   private double penaltyAmout;
/*    */   private double repayAmount;
/*    */   private double agentAmount;
/*    */   
/*    */   public String getLevel()
/*    */   {
/* 23 */     return this.level;
/*    */   }
/*    */   
/*    */   public void setLevel(String level) {
/* 27 */     this.level = level;
/*    */   }
/*    */   
/*    */   public String getCount() {
/* 31 */     return this.count;
/*    */   }
/*    */   
/*    */   public void setCount(String count) {
/* 35 */     this.count = count;
/*    */   }
/*    */   
/*    */   public double getBorrowAmout() {
/* 39 */     return this.borrowAmout;
/*    */   }
/*    */   
/*    */   public void setBorrowAmout(double borrowAmout) {
/* 43 */     this.borrowAmout = borrowAmout;
/*    */   }
/*    */   
/*    */   public double getPenaltyAmout() {
/* 47 */     return this.penaltyAmout;
/*    */   }
/*    */   
/*    */   public void setPenaltyAmout(double penaltyAmout) {
/* 51 */     this.penaltyAmout = penaltyAmout;
/*    */   }
/*    */   
/*    */   public double getRepayAmount() {
/* 55 */     return this.repayAmount;
/*    */   }
/*    */   
/*    */   public void setRepayAmount(double repayAmount) {
/* 59 */     this.repayAmount = repayAmount;
/*    */   }
/*    */   
/*    */   public double getAgentAmount() {
/* 63 */     return this.agentAmount;
/*    */   }
/*    */   
/*    */   public void setAgentAmount(double agentAmount) {
/* 67 */     this.agentAmount = agentAmount;
/*    */   }
/*    */ }
