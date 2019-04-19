/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.ProfitCashLog;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ManageCashLogModel
/*    */   extends ProfitCashLog
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String userName;
/*    */   
/*    */   public String getUserName()
/*    */   {
/* 18 */     return this.userName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setUserName(String userName)
/*    */   {
/* 25 */     this.userName = userName;
/*    */   }
/*    */ }
