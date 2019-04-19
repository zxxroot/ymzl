/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.UserInvite;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InviteBorrowModel
/*    */   extends UserInvite
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private double borrowAmout;
/*    */   private double penaltyAmout;
/*    */   private double repayAmount;
/*    */   private double agentAmount;
/*    */   
/*    */   public double getBorrowAmout()
/*    */   {
/* 21 */     return this.borrowAmout;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setBorrowAmout(double borrowAmout)
/*    */   {
/* 28 */     this.borrowAmout = borrowAmout;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public double getPenaltyAmout()
/*    */   {
/* 35 */     return this.penaltyAmout;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setPenaltyAmout(double penaltyAmout)
/*    */   {
/* 42 */     this.penaltyAmout = penaltyAmout;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public double getRepayAmount()
/*    */   {
/* 49 */     return this.repayAmount;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRepayAmount(double repayAmount)
/*    */   {
/* 56 */     this.repayAmount = repayAmount;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public double getAgentAmount()
/*    */   {
/* 63 */     return this.agentAmount;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setAgentAmount(double agentAmount)
/*    */   {
/* 70 */     this.agentAmount = agentAmount;
/*    */   }
/*    */ }
