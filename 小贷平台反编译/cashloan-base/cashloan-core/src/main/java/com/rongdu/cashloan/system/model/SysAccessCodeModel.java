/*    */ package com.rongdu.cashloan.system.model;
/*    */ 
/*    */ import com.rongdu.cashloan.system.domain.SysAccessCode;
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
/*    */ public class SysAccessCodeModel
/*    */   extends SysAccessCode
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String userName;
/*    */   private String name;
/*    */   private String stateStr;
/*    */   public static final String STATE_ENABLE = "10";
/*    */   public static final String STATE_DISABLE = "20";
/*    */   
/*    */   public String getStateStr()
/*    */   {
/* 35 */     if ("10".equals(getState())) {
/* 36 */       setStateStr("启用");
/* 37 */     } else if ("20".equals(getState())) {
/* 38 */       setStateStr("禁用");
/*    */     } else {
/* 40 */       setStateStr("--");
/*    */     }
/* 42 */     return this.stateStr;
/*    */   }
/*    */   
/*    */   public void setStateStr(String stateStr) {
/* 46 */     this.stateStr = stateStr;
/*    */   }
/*    */   
/*    */   public String getUserName() {
/* 50 */     return this.userName;
/*    */   }
/*    */   
/*    */   public void setUserName(String userName) {
/* 54 */     this.userName = userName;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 58 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 62 */     this.name = name;
/*    */   }
/*    */ }
