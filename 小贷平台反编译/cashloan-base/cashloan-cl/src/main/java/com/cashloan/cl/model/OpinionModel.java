/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.Opinion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpinionModel
/*     */   extends Opinion
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String STATE_WAITE_CONFIRM = "10";
/*     */   public static final String STATE_CONFIRMED = "20";
/*     */   private String phone;
/*     */   private String userRealName;
/*     */   private String sysUserRealName;
/*     */   private String stateStr;
/*     */   
/*     */   public String getPhone()
/*     */   {
/*  53 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/*  61 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserRealName()
/*     */   {
/*  69 */     return this.userRealName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserRealName(String userRealName)
/*     */   {
/*  77 */     this.userRealName = userRealName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSysUserRealName()
/*     */   {
/*  85 */     return this.sysUserRealName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSysUserRealName(String sysUserRealName)
/*     */   {
/*  93 */     this.sysUserRealName = sysUserRealName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getStateStr()
/*     */   {
/* 101 */     String state = getState();
/* 102 */     if ("10".equals(state))
/* 103 */       return "待确认";
/* 104 */     if ("20".equals(state)) {
/* 105 */       return "已确认";
/*     */     }
/* 107 */     return this.stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStateStr(String stateStr)
/*     */   {
/* 115 */     this.stateStr = stateStr;
/*     */   }
/*     */ }
