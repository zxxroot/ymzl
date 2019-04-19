/*     */ package com.rongdu.cashloan.system.model;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.exception.OperatorException;
/*     */ import com.rongdu.cashloan.core.common.util.ValidateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.code.MD5;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import org.springframework.beans.BeanUtils;
/*     */ import tool.util.StringUtil;
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
/*     */ public class SysUserModel
/*     */   extends SysUser
/*     */ {
/*     */   private static final long serialVersionUID = -6789313850889066219L;
/*     */   private String oldPassword;
/*     */   private String confirmPassword;
/*     */   
/*     */   public static SysUserModel instance(SysUser sysUser)
/*     */   {
/*  38 */     SysUserModel userModel = new SysUserModel();
/*  39 */     BeanUtils.copyProperties(sysUser, userModel);
/*  40 */     return userModel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SysUser prototype()
/*     */   {
/*  49 */     SysUser user = new SysUser();
/*  50 */     BeanUtils.copyProperties(this, user);
/*  51 */     return user;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int validLoginModel()
/*     */   {
/*  60 */     if (StringUtil.isBlank(getUserName())) {
/*  61 */       throw new OperatorException("用户名不能为空！", 1);
/*     */     }
/*  63 */     if (StringUtil.isBlank(getPassword())) {
/*  64 */       throw new OperatorException("密码不能为空！", 1);
/*     */     }
/*  66 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String validModifyPwdModel(SysUser user)
/*     */   {
/*  77 */     if (getOldPassword() == null)
/*  78 */       throw new OperatorException("请输入您的原密码！", 1);
/*  79 */     if (!MD5.encode(getOldPassword()).equals(user.getPassword()))
/*  80 */       throw new OperatorException("原密码错误！", 1);
/*  81 */     if (getPassword().equals(getOldPassword()))
/*  82 */       throw new OperatorException("新密码不能和原密码相同！", 1);
/*  83 */     if (!getPassword().equals(getConfirmPassword())) {
/*  84 */       throw new OperatorException("新密码和确认密码不相同！", 1);
/*     */     }
/*  86 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int validRegModel()
/*     */   {
/*  95 */     if (!ValidateUtil.isUser_name(getUserName())) {
/*  96 */       throw new OperatorException("用户名格式错误！", 1);
/*     */     }
/*  98 */     if (StringUtil.isBlank(getPassword())) {
/*  99 */       throw new OperatorException("密码不能为空！", 1);
/*     */     }
/* 101 */     if (StringUtil.isBlank(getConfirmPassword())) {
/* 102 */       throw new OperatorException("确认密码不能为空！");
/*     */     }
/* 104 */     if (!getPassword().equals(getConfirmPassword())) {
/* 105 */       throw new OperatorException("两次输入的密码不一致！");
/*     */     }
/* 107 */     return -1;
/*     */   }
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
/*     */   public int validOfficeModel()
/*     */   {
/* 121 */     return -1;
/*     */   }
/*     */   
/*     */   public String getOldPassword() {
/* 125 */     return this.oldPassword;
/*     */   }
/*     */   
/*     */   public void setOldPassword(String oldPassword) {
/* 129 */     this.oldPassword = oldPassword;
/*     */   }
/*     */   
/*     */   public String getConfirmPassword() {
/* 133 */     return this.confirmPassword;
/*     */   }
/*     */   
/*     */   public void setConfirmPassword(String confirmPassword) {
/* 137 */     this.confirmPassword = confirmPassword;
/*     */   }
/*     */ }
