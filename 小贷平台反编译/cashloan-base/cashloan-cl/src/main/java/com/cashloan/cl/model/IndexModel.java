/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.rongdu.cashloan.core.domain.Borrow;
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
/*    */ public class IndexModel
/*    */   extends Borrow
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String cardNo;
/*    */   private Date creditTime;
/*    */   private Date loanTime;
/*    */   
/*    */   public String getCardNo()
/*    */   {
/* 26 */     return this.cardNo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setCardNo(String cardNo)
/*    */   {
/* 33 */     this.cardNo = cardNo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Date getCreditTime()
/*    */   {
/* 40 */     return this.creditTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setCreditTime(Date creditTime)
/*    */   {
/* 47 */     this.creditTime = creditTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Date getLoanTime()
/*    */   {
/* 54 */     return this.loanTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setLoanTime(Date loanTime)
/*    */   {
/* 61 */     this.loanTime = loanTime;
/*    */   }
/*    */ }
