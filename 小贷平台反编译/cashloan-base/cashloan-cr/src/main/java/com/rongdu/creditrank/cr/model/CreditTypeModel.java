/*    */ package com.rongdu.creditrank.cr.model;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.domain.CreditType;
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
/*    */ public class CreditTypeModel
/*    */   extends CreditType
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String cardName;
/*    */   private String rankName;
/*    */   private String borrowTypeName;
/*    */   
/*    */   public String getCardName()
/*    */   {
/* 39 */     return this.cardName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setCardName(String cardName)
/*    */   {
/* 47 */     this.cardName = cardName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getRankName()
/*    */   {
/* 55 */     return this.rankName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setRankName(String rankName)
/*    */   {
/* 63 */     this.rankName = rankName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getBorrowTypeName()
/*    */   {
/* 71 */     return this.borrowTypeName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setBorrowTypeName(String borrowTypeName)
/*    */   {
/* 79 */     this.borrowTypeName = borrowTypeName;
/*    */   }
/*    */ }
