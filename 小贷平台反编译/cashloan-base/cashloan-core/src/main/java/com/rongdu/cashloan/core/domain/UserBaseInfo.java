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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UserBaseInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String phone;
/*     */   private String email;
/*     */   private String realName;
/*     */   private Integer age;
/*     */   private String sex;
/*     */   private String national;
/*     */   private String idNo;
/*     */   private String idAddr;
/*     */   private String livingImg;
/*     */   private String ocrImg;
/*     */   private String frontImg;
/*     */   private String backImg;
/*     */   private String education;
/*     */   private String marryState;
/*     */   private String companyName;
/*     */   private String companyPhone;
/*     */   private String companyAddr;
/*     */   private String companyDetailAddr;
/*     */   private String companyCoordinate;
/*     */   private String salary;
/*     */   private String workingYears;
/*     */   private String workingImg;
/*     */   private String liveTime;
/*     */   private String liveAddr;
/*     */   private String liveDetailAddr;
/*     */   private String liveCoordinate;
/*     */   private String phoneServerPwd;
/*     */   private String registerAddr;
/*     */   private String registerCoordinate;
/*     */   private String state;
/*     */   private String blackReason;
/*     */   private Date updateTime;
/*     */   private Date createTime;
/*     */   private Long contactsRepeatName;
/*     */   private Long contactsRepeatPhone;
/*     */   private Long phoneVoiceCount;
/*     */   private Long contactsCount;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 221 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 230 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 239 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 249 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 258 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 268 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEmail()
/*     */   {
/* 277 */     return this.email;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEmail(String email)
/*     */   {
/* 287 */     this.email = email;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRealName()
/*     */   {
/* 296 */     return this.realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRealName(String realName)
/*     */   {
/* 306 */     this.realName = realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getAge()
/*     */   {
/* 315 */     return this.age;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAge(Integer age)
/*     */   {
/* 325 */     this.age = age;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSex()
/*     */   {
/* 334 */     return this.sex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSex(String sex)
/*     */   {
/* 344 */     this.sex = sex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNational()
/*     */   {
/* 353 */     return this.national;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNational(String national)
/*     */   {
/* 363 */     this.national = national;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdNo()
/*     */   {
/* 372 */     return this.idNo;
/*     */   }
/*     */   
/*     */ 
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
/*     */ 
/*     */   public String getIdAddr()
/*     */   {
/* 391 */     return this.idAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdAddr(String idAddr)
/*     */   {
/* 401 */     this.idAddr = idAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLivingImg()
/*     */   {
/* 410 */     return this.livingImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLivingImg(String livingImg)
/*     */   {
/* 420 */     this.livingImg = livingImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOcrImg()
/*     */   {
/* 429 */     return this.ocrImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOcrImg(String ocrImg)
/*     */   {
/* 439 */     this.ocrImg = ocrImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFrontImg()
/*     */   {
/* 448 */     return this.frontImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFrontImg(String frontImg)
/*     */   {
/* 458 */     this.frontImg = frontImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBackImg()
/*     */   {
/* 467 */     return this.backImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBackImg(String backImg)
/*     */   {
/* 477 */     this.backImg = backImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEducation()
/*     */   {
/* 486 */     return this.education;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEducation(String education)
/*     */   {
/* 496 */     this.education = education;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMarryState()
/*     */   {
/* 505 */     return this.marryState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMarryState(String marryState)
/*     */   {
/* 515 */     this.marryState = marryState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyName()
/*     */   {
/* 524 */     return this.companyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyName(String companyName)
/*     */   {
/* 534 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyPhone()
/*     */   {
/* 543 */     return this.companyPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyPhone(String companyPhone)
/*     */   {
/* 553 */     this.companyPhone = companyPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyAddr()
/*     */   {
/* 562 */     return this.companyAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyAddr(String companyAddr)
/*     */   {
/* 572 */     this.companyAddr = companyAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyDetailAddr()
/*     */   {
/* 581 */     return this.companyDetailAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyDetailAddr(String companyDetailAddr)
/*     */   {
/* 591 */     this.companyDetailAddr = companyDetailAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyCoordinate()
/*     */   {
/* 600 */     return this.companyCoordinate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyCoordinate(String companyCoordinate)
/*     */   {
/* 610 */     this.companyCoordinate = companyCoordinate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSalary()
/*     */   {
/* 619 */     return this.salary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSalary(String salary)
/*     */   {
/* 629 */     this.salary = salary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWorkingYears()
/*     */   {
/* 638 */     return this.workingYears;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWorkingYears(String workingYears)
/*     */   {
/* 648 */     this.workingYears = workingYears;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWorkingImg()
/*     */   {
/* 657 */     return this.workingImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWorkingImg(String workingImg)
/*     */   {
/* 667 */     this.workingImg = workingImg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLiveTime()
/*     */   {
/* 676 */     return this.liveTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLiveTime(String liveTime)
/*     */   {
/* 686 */     this.liveTime = liveTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLiveAddr()
/*     */   {
/* 695 */     return this.liveAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLiveAddr(String liveAddr)
/*     */   {
/* 705 */     this.liveAddr = liveAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLiveDetailAddr()
/*     */   {
/* 714 */     return this.liveDetailAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLiveDetailAddr(String liveDetailAddr)
/*     */   {
/* 724 */     this.liveDetailAddr = liveDetailAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLiveCoordinate()
/*     */   {
/* 733 */     return this.liveCoordinate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLiveCoordinate(String liveCoordinate)
/*     */   {
/* 743 */     this.liveCoordinate = liveCoordinate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneServerPwd()
/*     */   {
/* 752 */     return this.phoneServerPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneServerPwd(String phoneServerPwd)
/*     */   {
/* 762 */     this.phoneServerPwd = phoneServerPwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRegisterAddr()
/*     */   {
/* 771 */     return this.registerAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegisterAddr(String registerAddr)
/*     */   {
/* 781 */     this.registerAddr = registerAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRegisterCoordinate()
/*     */   {
/* 790 */     return this.registerCoordinate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegisterCoordinate(String registerCoordinate)
/*     */   {
/* 800 */     this.registerCoordinate = registerCoordinate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 809 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 819 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBlackReason()
/*     */   {
/* 828 */     return this.blackReason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBlackReason(String blackReason)
/*     */   {
/* 838 */     this.blackReason = blackReason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 847 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 856 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 865 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 874 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getContactsRepeatName()
/*     */   {
/* 883 */     return this.contactsRepeatName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContactsRepeatName(Long contactsRepeatName)
/*     */   {
/* 892 */     this.contactsRepeatName = contactsRepeatName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getContactsRepeatPhone()
/*     */   {
/* 901 */     return this.contactsRepeatPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContactsRepeatPhone(Long contactsRepeatPhone)
/*     */   {
/* 910 */     this.contactsRepeatPhone = contactsRepeatPhone;
/*     */   }
/*     */   
/*     */   public Long getPhoneVoiceCount() {
/* 914 */     return this.phoneVoiceCount;
/*     */   }
/*     */   
/*     */   public void setPhoneVoiceCount(Long phoneVoiceCount) {
/* 918 */     this.phoneVoiceCount = phoneVoiceCount;
/*     */   }
/*     */   
/*     */   public Long getContactsCount() {
/* 922 */     return this.contactsCount;
/*     */   }
/*     */   
/*     */   public void setContactsCount(Long contactsCount) {
/* 926 */     this.contactsCount = contactsCount;
/*     */   }
/*     */ }
