/*    */ package com.rongdu.cashloan.system.model;
/*    */ 
/*    */ import com.rongdu.cashloan.system.domain.SysMenu;
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
/*    */ public class MenuModel
/*    */   extends SysMenu
/*    */ {
/*    */   private static final long serialVersionUID = -616526029044963364L;
/*    */   private Long roleId;
/*    */   
/*    */   public Long getRoleId()
/*    */   {
/* 24 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public void setRoleId(Long roleId) {
/* 28 */     this.roleId = roleId;
/*    */   }
/*    */ }
