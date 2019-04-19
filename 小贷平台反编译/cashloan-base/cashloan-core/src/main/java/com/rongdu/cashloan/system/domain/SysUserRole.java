/*    */ package com.rongdu.cashloan.system.domain;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class SysUserRole
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Long id;
/*    */   private Long roleId;
/*    */   private Long userId;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 30 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 34 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Long getRoleId() {
/* 38 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public void setRoleId(Long roleId) {
/* 42 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 46 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 50 */     this.userId = userId;
/*    */   }
/*    */ }
