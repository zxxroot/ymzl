/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.ProfitAgent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ManageAgentListModel
/*    */   extends ProfitAgent
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String userName;
/*    */   
/*    */   public String getUserName()
/*    */   {
/* 16 */     return this.userName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setUserName(String userName)
/*    */   {
/* 23 */     this.userName = userName;
/*    */   }
/*    */ }
