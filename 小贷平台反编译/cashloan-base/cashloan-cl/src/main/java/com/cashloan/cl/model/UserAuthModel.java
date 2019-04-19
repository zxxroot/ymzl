/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.UserAuth;
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
/*    */ public class UserAuthModel
/*    */   extends UserAuth
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String STATE_NOT_CERTIFIED = "10";
/*    */   public static final String STATE_ERTIFICATION = "20";
/*    */   public static final String STATE_VERIFIED = "30";
/*    */   private String loginName;
/*    */   private String realName;
/*    */   private String phone;
/*    */   
/*    */   public String getLoginName()
/*    */   {
/* 40 */     return this.loginName;
/*    */   }
/*    */   
/* 43 */   public void setLoginName(String loginName) { this.loginName = loginName; }
/*    */   
/*    */   public String getRealName() {
/* 46 */     return this.realName;
/*    */   }
/*    */   
/* 49 */   public void setRealName(String realName) { this.realName = realName; }
/*    */   
/*    */   public String getPhone() {
/* 52 */     return this.phone;
/*    */   }
/*    */   
/* 55 */   public void setPhone(String phone) { this.phone = phone; }
/*    */ }
