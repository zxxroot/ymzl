/*     */ package com.rongdu.cashloan.system.domain;
/*     */ 
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
/*     */ public class SysPerm
/*     */ {
/*     */   private Long id;
/*     */   private String code;
/*     */   private String name;
/*     */   private Integer permLevel;
/*     */   private String remark;
/*     */   private Date addTime;
/*     */   private String addUser;
/*     */   private Long menuId;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  66 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  70 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  74 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  78 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  82 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  86 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Integer getPermLevel() {
/*  90 */     return this.permLevel;
/*     */   }
/*     */   
/*     */   public void setPermLevel(Integer permLevel) {
/*  94 */     this.permLevel = permLevel;
/*     */   }
/*     */   
/*     */   public String getRemark() {
/*  98 */     return this.remark;
/*     */   }
/*     */   
/*     */   public void setRemark(String remark) {
/* 102 */     this.remark = remark;
/*     */   }
/*     */   
/*     */   public Date getAddTime() {
/* 106 */     return this.addTime;
/*     */   }
/*     */   
/*     */   public void setAddTime(Date addTime) {
/* 110 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */   public String getAddUser() {
/* 114 */     return this.addUser;
/*     */   }
/*     */   
/*     */   public void setAddUser(String addUser) {
/* 118 */     this.addUser = addUser;
/*     */   }
/*     */   
/*     */   public Long getMenuId() {
/* 122 */     return this.menuId;
/*     */   }
/*     */   
/*     */   public void setMenuId(Long menuId) {
/* 126 */     this.menuId = menuId;
/*     */   }
/*     */ }
