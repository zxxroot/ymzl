/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.UserEducationInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserEducationInfoModel
/*    */   extends UserEducationInfo
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String phone;
/*    */   private String stateStr;
/*    */   
/*    */   public String getPhone()
/*    */   {
/* 20 */     return this.phone;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setPhone(String phone)
/*    */   {
/* 27 */     this.phone = phone;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getStateStr()
/*    */   {
/* 34 */     return this.stateStr;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setStateStr(String stateStr)
/*    */   {
/* 41 */     this.stateStr = stateStr;
/*    */   }
/*    */ }
