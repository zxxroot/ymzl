/*     */ package com.rongdu.cashloan.system.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SysRole
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String name;
/*     */   private Date addTime;
/*     */   private String addUser;
/*     */   private Date updateTime;
/*     */   private String updateUser;
/*     */   private String remark;
/*     */   private Byte isDelete;
/*     */   private String nid;
/*     */   private List<SysRoleMenu> roleMenus;
/*     */   private List<SysUserRole> operatorRoles;
/*     */   
/*     */   public SysRole() {}
/*     */   
/*     */   public SysRole(Long id)
/*     */   {
/*  69 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  78 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  87 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/*  96 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 105 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 114 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 123 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAddUser()
/*     */   {
/* 132 */     return this.addUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddUser(String addUser)
/*     */   {
/* 141 */     this.addUser = addUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 150 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 159 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUpdateUser()
/*     */   {
/* 168 */     return this.updateUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateUser(String updateUser)
/*     */   {
/* 177 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 186 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 195 */     this.remark = remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Byte getIsDelete()
/*     */   {
/* 204 */     return this.isDelete;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsDelete(Byte isDelete)
/*     */   {
/* 213 */     this.isDelete = isDelete;
/*     */   }
/*     */   
/*     */   public List<SysRoleMenu> getRoleMenus() {
/* 217 */     return this.roleMenus;
/*     */   }
/*     */   
/*     */   public void setRoleMenus(List<SysRoleMenu> roleMenus) {
/* 221 */     this.roleMenus = roleMenus;
/*     */   }
/*     */   
/*     */   public List<SysUserRole> getOperatorRoles() {
/* 225 */     return this.operatorRoles;
/*     */   }
/*     */   
/*     */   public void setOperatorRoles(List<SysUserRole> operatorRoles) {
/* 229 */     this.operatorRoles = operatorRoles;
/*     */   }
/*     */   
/*     */   public String getNid() {
/* 233 */     return this.nid;
/*     */   }
/*     */   
/*     */   public void setNid(String nid) {
/* 237 */     this.nid = nid;
/*     */   }
/*     */ }
