/*     */ package com.rongdu.cashloan.system.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
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
/*     */ public class SysMenu
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String text;
/*     */   private int parentId;
/*     */   private String href;
/*     */   private String iconCls;
/*     */   private int sort;
/*     */   private Date addTime;
/*     */   private String addUser;
/*     */   private Date updateTime;
/*     */   private String updateUser;
/*     */   private String remark;
/*     */   private byte isDelete;
/*     */   private byte isMenu;
/*     */   private String scriptid;
/*     */   private Boolean leaf;
/*     */   private byte level;
/*     */   private String controllerName;
/*     */   
/*     */   public byte getLevel()
/*     */   {
/*  95 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(byte level) {
/*  99 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SysMenu() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SysMenu(Long id)
/*     */   {
/* 111 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 120 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 129 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getText()
/*     */   {
/* 135 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(String text) {
/* 139 */     this.text = text;
/*     */   }
/*     */   
/*     */   public int getParentId()
/*     */   {
/* 144 */     return this.parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(int parentId) {
/* 148 */     this.parentId = parentId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getHref()
/*     */   {
/* 155 */     return this.href;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHref(String href)
/*     */   {
/* 162 */     this.href = href;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getIconCls()
/*     */   {
/* 169 */     return this.iconCls;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIconCls(String iconCls)
/*     */   {
/* 176 */     this.iconCls = iconCls;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSort()
/*     */   {
/* 185 */     return this.sort;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSort(int sort)
/*     */   {
/* 194 */     this.sort = sort;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 203 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 212 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAddUser()
/*     */   {
/* 221 */     return this.addUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddUser(String addUser)
/*     */   {
/* 230 */     this.addUser = addUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 239 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 248 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUpdateUser()
/*     */   {
/* 257 */     return this.updateUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateUser(String updateUser)
/*     */   {
/* 266 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 275 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 284 */     this.remark = remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public byte getIsDelete()
/*     */   {
/* 293 */     return this.isDelete;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsDelete(byte isDelete)
/*     */   {
/* 302 */     this.isDelete = isDelete;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public byte getIsMenu()
/*     */   {
/* 310 */     return this.isMenu;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsMenu(byte isMenu)
/*     */   {
/* 318 */     this.isMenu = isMenu;
/*     */   }
/*     */   
/*     */   public String getScriptid() {
/* 322 */     return this.scriptid;
/*     */   }
/*     */   
/*     */   public void setScriptid(String scriptid) {
/* 326 */     this.scriptid = scriptid;
/*     */   }
/*     */   
/*     */   public boolean isLeaf() {
/* 330 */     return this.leaf.booleanValue();
/*     */   }
/*     */   
/*     */   public void setLeaf(boolean leaf) {
/* 334 */     this.leaf = Boolean.valueOf(leaf);
/*     */   }
/*     */   
/*     */   public String getControllerName() {
/* 338 */     return this.controllerName;
/*     */   }
/*     */   
/*     */   public void setControllerName(String controllerName) {
/* 342 */     this.controllerName = controllerName;
/*     */   }
/*     */ }
