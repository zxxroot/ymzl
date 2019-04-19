/*     */ package com.rongdu.cashloan.core.domain;
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
/*     */ public class User
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String uuid;
/*     */   private String loginName;
/*     */   private String loginPwd;
/*     */   private Date loginpwdModifyTime;
/*     */   private String tradePwd;
/*     */   private Date tradepwdModifyTime;
/*     */   private Date registTime;
/*     */   private String registerClient;
/*     */   private String invitationCode;
/*     */   private Long channelId;
/*     */   private Date loginTime;
/*     */   private Integer level;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  91 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  99 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUuid()
/*     */   {
/* 107 */     return this.uuid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUuid(String uuid)
/*     */   {
/* 115 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoginName()
/*     */   {
/* 123 */     return this.loginName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginName(String loginName)
/*     */   {
/* 131 */     this.loginName = loginName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoginPwd()
/*     */   {
/* 139 */     return this.loginPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginPwd(String loginPwd)
/*     */   {
/* 147 */     this.loginPwd = loginPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getLoginpwdModifyTime()
/*     */   {
/* 155 */     return this.loginpwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginpwdModifyTime(Date loginpwdModifyTime)
/*     */   {
/* 163 */     this.loginpwdModifyTime = loginpwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTradePwd()
/*     */   {
/* 171 */     return this.tradePwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTradePwd(String tradePwd)
/*     */   {
/* 179 */     this.tradePwd = tradePwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getTradepwdModifyTime()
/*     */   {
/* 187 */     return this.tradepwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTradepwdModifyTime(Date tradepwdModifyTime)
/*     */   {
/* 195 */     this.tradepwdModifyTime = tradepwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getRegistTime()
/*     */   {
/* 203 */     return this.registTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegistTime(Date registTime)
/*     */   {
/* 211 */     this.registTime = registTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRegisterClient()
/*     */   {
/* 219 */     return this.registerClient;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegisterClient(String registerClient)
/*     */   {
/* 227 */     this.registerClient = registerClient;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInvitationCode()
/*     */   {
/* 235 */     return this.invitationCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInvitationCode(String invitationCode)
/*     */   {
/* 243 */     this.invitationCode = invitationCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getChannelId()
/*     */   {
/* 251 */     return this.channelId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setChannelId(Long channelId)
/*     */   {
/* 259 */     this.channelId = channelId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getLevel()
/*     */   {
/* 267 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLevel(Integer level)
/*     */   {
/* 275 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getLoginTime()
/*     */   {
/* 282 */     return this.loginTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLoginTime(Date loginTime)
/*     */   {
/* 289 */     this.loginTime = loginTime;
/*     */   }
/*     */ }
