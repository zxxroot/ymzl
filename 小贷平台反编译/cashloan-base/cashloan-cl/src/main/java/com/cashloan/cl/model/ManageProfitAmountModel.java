/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.ProfitAmount;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ManageProfitAmountModel
/*    */   extends ProfitAmount
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String userName;
/*    */   private String realName;
/*    */   
/*    */   public String getUserName()
/*    */   {
/* 21 */     return this.userName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setUserName(String userName)
/*    */   {
/* 28 */     this.userName = userName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getRealName()
/*    */   {
/* 35 */     return this.realName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRealName(String realName)
/*    */   {
/* 42 */     this.realName = realName;
/*    */   }
/*    */ }
