/*     */ package com.rongdu.cashloan.core.model;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CloanUserModel
/*     */ {
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String loginName;
/*     */   private String loginPwd;
/*     */   private Date loginpwdModifyTime;
/*     */   private Date registTime;
/*     */   private String registerClient;
/*     */   private long channelId;
/*     */   private String channelName;
/*     */   private String tradePwd;
/*     */   private Date tradepwdModifyTime;
/*     */   private String uuid;
/*     */   private String invitationCode;
/*     */   private String realName;
/*     */   private String idNo;
/*     */   private String idAddr;
/*     */   private String companyName;
/*     */   private String companyAddr;
/*     */   private String sex;
/*     */   private String liveAddr;
/*     */   private String liveTime;
/*     */   private String marryState;
/*     */   private String phone;
/*     */   private String phoneServerPwd;
/*     */   private String national;
/*     */   private String education;
/*     */   private String workingYears;
/*     */   private String salary;
/*     */   private String state;
/*     */   private String brTimes;
/*     */   private String createTime;
/*     */   private String updateTime;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 166 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 174 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 182 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 190 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoginName()
/*     */   {
/* 198 */     return this.loginName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginName(String loginName)
/*     */   {
/* 206 */     this.loginName = loginName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoginPwd()
/*     */   {
/* 214 */     return this.loginPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginPwd(String loginPwd)
/*     */   {
/* 222 */     this.loginPwd = loginPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getLoginpwdModifyTime()
/*     */   {
/* 230 */     return this.loginpwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoginpwdModifyTime(Date loginpwdModifyTime)
/*     */   {
/* 238 */     this.loginpwdModifyTime = loginpwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getRegistTime()
/*     */   {
/* 246 */     return this.registTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegistTime(Date registTime)
/*     */   {
/* 254 */     this.registTime = registTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRegisterClient()
/*     */   {
/* 262 */     return this.registerClient;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegisterClient(String registerClient)
/*     */   {
/* 270 */     this.registerClient = registerClient;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getChannelName()
/*     */   {
/* 278 */     return this.channelName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setChannelName(String channelName)
/*     */   {
/* 286 */     this.channelName = channelName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTradePwd()
/*     */   {
/* 294 */     return this.tradePwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTradePwd(String tradePwd)
/*     */   {
/* 302 */     this.tradePwd = tradePwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getTradepwdModifyTime()
/*     */   {
/* 310 */     return this.tradepwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTradepwdModifyTime(Date tradepwdModifyTime)
/*     */   {
/* 318 */     this.tradepwdModifyTime = tradepwdModifyTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUuid()
/*     */   {
/* 326 */     return this.uuid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUuid(String uuid)
/*     */   {
/* 334 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInvitationCode()
/*     */   {
/* 342 */     return this.invitationCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInvitationCode(String invitationCode)
/*     */   {
/* 350 */     this.invitationCode = invitationCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRealName()
/*     */   {
/* 358 */     return this.realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRealName(String realName)
/*     */   {
/* 366 */     this.realName = realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdNo()
/*     */   {
/* 374 */     return this.idNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdNo(String idNo)
/*     */   {
/* 382 */     this.idNo = idNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdAddr()
/*     */   {
/* 390 */     return this.idAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdAddr(String idAddr)
/*     */   {
/* 398 */     this.idAddr = idAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyName()
/*     */   {
/* 406 */     return this.companyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyName(String companyName)
/*     */   {
/* 414 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyAddr()
/*     */   {
/* 422 */     return this.companyAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyAddr(String companyAddr)
/*     */   {
/* 430 */     this.companyAddr = companyAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSex()
/*     */   {
/* 438 */     return this.sex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSex(String sex)
/*     */   {
/* 446 */     this.sex = sex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLiveAddr()
/*     */   {
/* 454 */     return this.liveAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLiveAddr(String liveAddr)
/*     */   {
/* 462 */     this.liveAddr = liveAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLiveTime()
/*     */   {
/* 470 */     return this.liveTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLiveTime(String liveTime)
/*     */   {
/* 478 */     this.liveTime = liveTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMarryState()
/*     */   {
/* 486 */     return this.marryState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMarryState(String marryState)
/*     */   {
/* 494 */     this.marryState = marryState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 502 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 510 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneServerPwd()
/*     */   {
/* 518 */     return this.phoneServerPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneServerPwd(String phoneServerPwd)
/*     */   {
/* 526 */     this.phoneServerPwd = phoneServerPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNational()
/*     */   {
/* 534 */     return this.national;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNational(String national)
/*     */   {
/* 542 */     this.national = national;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEducation()
/*     */   {
/* 550 */     return this.education;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEducation(String education)
/*     */   {
/* 558 */     this.education = education;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWorkingYears()
/*     */   {
/* 566 */     return this.workingYears;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWorkingYears(String workingYears)
/*     */   {
/* 574 */     this.workingYears = workingYears;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSalary()
/*     */   {
/* 582 */     return this.salary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSalary(String salary)
/*     */   {
/* 590 */     this.salary = salary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 598 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 606 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreateTime()
/*     */   {
/* 614 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(String createTime)
/*     */   {
/* 622 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUpdateTime()
/*     */   {
/* 630 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(String updateTime)
/*     */   {
/* 638 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getChannelId()
/*     */   {
/* 645 */     return this.channelId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChannelId(long channelId)
/*     */   {
/* 652 */     this.channelId = channelId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBrTimes()
/*     */   {
/* 660 */     return this.brTimes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBrTimes(String brTimes)
/*     */   {
/* 668 */     this.brTimes = brTimes;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\model\CloanUserModel.class

 */