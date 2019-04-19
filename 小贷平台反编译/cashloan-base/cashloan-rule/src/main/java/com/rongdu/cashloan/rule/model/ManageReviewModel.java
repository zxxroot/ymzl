/*    */ package com.rongdu.cashloan.rule.model;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.domain.BorrowRuleResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ManageReviewModel
/*    */   extends BorrowRuleResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String ruleName;
/*    */   
/*    */   public String getRuleName()
/*    */   {
/* 15 */     return this.ruleName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRuleName(String ruleName)
/*    */   {
/* 22 */     this.ruleName = ruleName;
/*    */   }
/*    */ }
