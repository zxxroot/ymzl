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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SysUser
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String name;
/*     */   private String userName;
/*     */   private String password;
/*     */   private String jobNumber;
/*     */   private String officeId;
/*     */   private String companyId;
/*     */   private String email;
/*     */   private String phone;
/*     */   private String mobile;
/*     */   private Byte status;
/*     */   private String loginIp;
/*     */   private Date loginTime;
/*     */   private Date addTime;
/*     */   private String addUser;
/*     */   private Date updateTime;
/*     */   private String updateUser;
/*     */   private String remark;
/*     */   private Byte position;
/*     */   private String officeOver;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 102 */     return this.id;
/*     */   }
/*     */   
/* 105 */   public void setId(Long id) { this.id = id; }
/*     */   
/*     */   public String getName() {
/* 108 */     return this.name;
/*     */   }
/*     */   
/* 111 */   public void setName(String name) { this.name = name; }
/*     */   
/*     */   public String getUserName() {
/* 114 */     return this.userName;
/*     */   }
/*     */   
/* 117 */   public void setUserName(String userName) { this.userName = userName; }
/*     */   
/*     */   public String getPassword() {
/* 120 */     return this.password;
/*     */   }
/*     */   
/* 123 */   public void setPassword(String password) { this.password = password; }
/*     */   
/*     */   public String getJobNumber() {
/* 126 */     return this.jobNumber;
/*     */   }
/*     */   
/* 129 */   public void setJobNumber(String jobNumber) { this.jobNumber = jobNumber; }
/*     */   
/*     */   public String getOfficeId() {
/* 132 */     return this.officeId;
/*     */   }
/*     */   
/* 135 */   public void setOfficeId(String officeId) { this.officeId = officeId; }
/*     */   
/*     */   public String getCompanyId() {
/* 138 */     return this.companyId;
/*     */   }
/*     */   
/* 141 */   public void setCompanyId(String companyId) { this.companyId = companyId; }
/*     */   
/*     */   public String getEmail() {
/* 144 */     return this.email;
/*     */   }
/*     */   
/* 147 */   public void setEmail(String email) { this.email = email; }
/*     */   
/*     */   public String getPhone() {
/* 150 */     return this.phone;
/*     */   }
/*     */   
/* 153 */   public void setPhone(String phone) { this.phone = phone; }
/*     */   
/*     */   public String getMobile() {
/* 156 */     return this.mobile;
/*     */   }
/*     */   
/* 159 */   public void setMobile(String mobile) { this.mobile = mobile; }
/*     */   
/*     */   public Byte getStatus() {
/* 162 */     return this.status;
/*     */   }
/*     */   
/* 165 */   public void setStatus(Byte status) { this.status = status; }
/*     */   
/*     */   public String getLoginIp() {
/* 168 */     return this.loginIp;
/*     */   }
/*     */   
/* 171 */   public void setLoginIp(String loginIp) { this.loginIp = loginIp; }
/*     */   
/*     */   public Date getLoginTime() {
/* 174 */     return this.loginTime;
/*     */   }
/*     */   
/* 177 */   public void setLoginTime(Date loginTime) { this.loginTime = loginTime; }
/*     */   
/*     */   public Date getAddTime() {
/* 180 */     return this.addTime;
/*     */   }
/*     */   
/* 183 */   public void setAddTime(Date addTime) { this.addTime = addTime; }
/*     */   
/*     */   public String getAddUser() {
/* 186 */     return this.addUser;
/*     */   }
/*     */   
/* 189 */   public void setAddUser(String addUser) { this.addUser = addUser; }
/*     */   
/*     */   public Date getUpdateTime() {
/* 192 */     return this.updateTime;
/*     */   }
/*     */   
/* 195 */   public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
/*     */   
/*     */   public String getUpdateUser() {
/* 198 */     return this.updateUser;
/*     */   }
/*     */   
/* 201 */   public void setUpdateUser(String updateUser) { this.updateUser = updateUser; }
/*     */   
/*     */   public String getRemark() {
/* 204 */     return this.remark;
/*     */   }
/*     */   
/* 207 */   public void setRemark(String remark) { this.remark = remark; }
/*     */   
/*     */   public Byte getPosition() {
/* 210 */     return this.position;
/*     */   }
/*     */   
/* 213 */   public void setPosition(Byte position) { this.position = position; }
/*     */   
/*     */   public String getOfficeOver() {
/* 216 */     return this.officeOver;
/*     */   }
/*     */   
/* 219 */   public void setOfficeOver(String officeOver) { this.officeOver = officeOver; }
/*     */ }
