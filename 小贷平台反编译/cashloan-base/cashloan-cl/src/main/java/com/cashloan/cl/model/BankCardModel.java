/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.BankCard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BankCardModel
/*    */   extends BankCard
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String STATE_ENABLE = "10";
/*    */   public static final String STATE_DISABLE = "20";
/*    */   private String changeAble;
/*    */   
/*    */   public String getChangeAble()
/*    */   {
/* 23 */     return this.changeAble;
/*    */   }
/*    */   
/*    */   public void setChangeAble(String changeAble) {
/* 27 */     this.changeAble = changeAble;
/*    */   }
/*    */ }
