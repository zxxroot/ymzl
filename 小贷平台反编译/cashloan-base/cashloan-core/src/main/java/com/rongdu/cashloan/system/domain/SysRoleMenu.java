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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SysRoleMenu
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Long id;
/*    */   private Long roleId;
/*    */   private Long menuId;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 36 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId(Long id)
/*    */   {
/* 44 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Long getRoleId()
/*    */   {
/* 52 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setRoleId(Long roleId)
/*    */   {
/* 60 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Long getMenuId()
/*    */   {
/* 68 */     return this.menuId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setMenuId(Long menuId)
/*    */   {
/* 76 */     this.menuId = menuId;
/*    */   }
/*    */ }
