/*    */ package com.rongdu.cashloan.rule.model;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.domain.BorrowRuleResult;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ManageRuleResultModel
/*    */   extends BorrowRuleResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int total;
/*    */   private int pass;
/*    */   private int noPass;
/*    */   private int review;
/*    */   private List infoList;
/*    */   
/*    */   public int getTotal()
/*    */   {
/* 25 */     return this.total;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setTotal(int total)
/*    */   {
/* 32 */     this.total = total;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getPass()
/*    */   {
/* 39 */     return this.pass;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setPass(int pass)
/*    */   {
/* 46 */     this.pass = pass;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getNoPass()
/*    */   {
/* 53 */     return this.noPass;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setNoPass(int noPass)
/*    */   {
/* 60 */     this.noPass = noPass;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getReview()
/*    */   {
/* 67 */     return this.review;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setReview(int review)
/*    */   {
/* 74 */     this.review = review;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List getInfoList()
/*    */   {
/* 81 */     return this.infoList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setInfoList(List infoList)
/*    */   {
/* 88 */     this.infoList = infoList;
/*    */   }
/*    */ }
