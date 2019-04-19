/*    */ package com.rongdu.cashloan.system.domain;
/*    */ 
/*    */ import java.util.Date;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SysRolePerm
/*    */ {
/*    */   private Long id;
/*    */   private Integer roleId;
/*    */   private Integer permId;
/*    */   private Date addTime;
/*    */   private String addUser;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 42 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 46 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Integer getRoleId() {
/* 50 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public void setRoleId(Integer roleId) {
/* 54 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   public Integer getPermId() {
/* 58 */     return this.permId;
/*    */   }
/*    */   
/*    */   public void setPermId(Integer permId) {
/* 62 */     this.permId = permId;
/*    */   }
/*    */   
/*    */   public Date getAddTime() {
/* 66 */     return this.addTime;
/*    */   }
/*    */   
/*    */   public void setAddTime(Date addTime) {
/* 70 */     this.addTime = addTime;
/*    */   }
/*    */   
/*    */   public String getAddUser() {
/* 74 */     return this.addUser;
/*    */   }
/*    */   
/*    */   public void setAddUser(String addUser) {
/* 78 */     this.addUser = addUser;
/*    */   }
/*    */ }
