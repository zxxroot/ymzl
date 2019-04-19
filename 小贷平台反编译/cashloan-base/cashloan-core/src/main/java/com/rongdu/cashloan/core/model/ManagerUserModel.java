/*     */ package com.rongdu.cashloan.core.model;
/*     */ 
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
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
/*     */ public class ManagerUserModel
/*     */   extends UserBaseInfo
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String loginName;
/*     */   private String loginPwd;
/*     */   private Date loginpwdModifyTime;
/*     */   private Date registTime;
/*     */   private String registerClient;
/*     */   private String tradePwd;
/*     */   private Date tradepwdModifyTime;
/*     */   private String uuid;
/*     */   private String invitationCode;
/*     */   private Integer level;
/*     */   private String cardNo;
/*     */   private String bank;
/*     */   private String bankPhone;
/*     */   private String channelName;
/*     */   private String score;
/*     */   private String black;
/*     */   
/*     */   public String getBankPhone()
/*     */   {
/*  96 */     return this.bankPhone;
/*     */   }
/*     */   
/*     */   public void setBankPhone(String bankPhone) {
/* 100 */     this.bankPhone = bankPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoginName()
/*     */   {
/* 109 */     return this.loginName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginName(String loginName)
/*     */   {
/* 119 */     this.loginName = loginName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoginPwd()
/*     */   {
/* 128 */     return this.loginPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginPwd(String loginPwd)
/*     */   {
/* 138 */     this.loginPwd = loginPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getLoginpwdModifyTime()
/*     */   {
/* 147 */     return this.loginpwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginpwdModifyTime(Date loginpwdModifyTime)
/*     */   {
/* 157 */     this.loginpwdModifyTime = loginpwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getRegistTime()
/*     */   {
/* 166 */     return this.registTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegistTime(Date registTime)
/*     */   {
/* 176 */     this.registTime = registTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRegisterClient()
/*     */   {
/* 185 */     return this.registerClient;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegisterClient(String registerClient)
/*     */   {
/* 195 */     this.registerClient = registerClient;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTradePwd()
/*     */   {
/* 204 */     return this.tradePwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTradePwd(String tradePwd)
/*     */   {
/* 214 */     this.tradePwd = tradePwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getTradepwdModifyTime()
/*     */   {
/* 223 */     return this.tradepwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTradepwdModifyTime(Date tradepwdModifyTime)
/*     */   {
/* 233 */     this.tradepwdModifyTime = tradepwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUuid()
/*     */   {
/* 242 */     return this.uuid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUuid(String uuid)
/*     */   {
/* 252 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInvitationCode()
/*     */   {
/* 261 */     return this.invitationCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInvitationCode(String invitationCode)
/*     */   {
/* 271 */     this.invitationCode = invitationCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getLevel()
/*     */   {
/* 280 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLevel(Integer level)
/*     */   {
/* 290 */     this.level = level;
/*     */   }
/*     */   
/*     */   public String getCardNo() {
/* 294 */     return this.cardNo;
/*     */   }
/*     */   
/*     */   public void setCardNo(String cardNo) {
/* 298 */     this.cardNo = cardNo;
/*     */   }
/*     */   
/*     */   public String getBank() {
/* 302 */     return this.bank;
/*     */   }
/*     */   
/*     */   public void setBank(String bank) {
/* 306 */     this.bank = bank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getChannelName()
/*     */   {
/* 313 */     return this.channelName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChannelName(String channelName)
/*     */   {
/* 320 */     this.channelName = channelName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getScore()
/*     */   {
/* 327 */     return this.score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setScore(String score)
/*     */   {
/* 334 */     this.score = score;
/*     */   }
/*     */   
/*     */   public String getBlack() {
/* 338 */     return this.black;
/*     */   }
/*     */   
/*     */   public void setBlack(String black) {
/* 342 */     this.black = black;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\model\ManagerUserModel.class

 */