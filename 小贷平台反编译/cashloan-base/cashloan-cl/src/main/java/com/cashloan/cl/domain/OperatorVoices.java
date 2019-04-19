/*     */ package com.cashloan.cl.domain;
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
/*     */ public class OperatorVoices
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Date gmtModified;
/*     */   private String phoneNum;
/*     */   private String voicePlace;
/*     */   private Date gmtCreate;
/*     */   private Long voiceDuration;
/*     */   private Date month;
/*     */   private String voiceType;
/*     */   private String voiceToNumber;
/*     */   private Date voiceDate;
/*     */   private String voiceStatus;
/*     */   private String bizNo;
/*     */   private Date createTime;
/*     */   private Long voicesCount;
/*     */   private String contactsName;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 107 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 116 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 124 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 132 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getGmtModified()
/*     */   {
/* 141 */     return this.gmtModified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGmtModified(Date gmtModified)
/*     */   {
/* 150 */     this.gmtModified = gmtModified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneNum()
/*     */   {
/* 159 */     return this.phoneNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneNum(String phoneNum)
/*     */   {
/* 168 */     this.phoneNum = phoneNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getVoicePlace()
/*     */   {
/* 177 */     return this.voicePlace;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoicePlace(String voicePlace)
/*     */   {
/* 186 */     this.voicePlace = voicePlace;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 195 */     return this.gmtCreate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 204 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getVoiceDuration()
/*     */   {
/* 213 */     return this.voiceDuration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceDuration(Long voiceDuration)
/*     */   {
/* 222 */     this.voiceDuration = voiceDuration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getMonth()
/*     */   {
/* 231 */     return this.month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMonth(Date month)
/*     */   {
/* 240 */     this.month = month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getVoiceType()
/*     */   {
/* 249 */     return this.voiceType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceType(String voiceType)
/*     */   {
/* 258 */     this.voiceType = voiceType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getVoiceToNumber()
/*     */   {
/* 267 */     return this.voiceToNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceToNumber(String voiceToNumber)
/*     */   {
/* 276 */     this.voiceToNumber = voiceToNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getVoiceDate()
/*     */   {
/* 285 */     return this.voiceDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceDate(Date voiceDate)
/*     */   {
/* 294 */     this.voiceDate = voiceDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getVoiceStatus()
/*     */   {
/* 303 */     return this.voiceStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceStatus(String voiceStatus)
/*     */   {
/* 312 */     this.voiceStatus = voiceStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBizNo()
/*     */   {
/* 321 */     return this.bizNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBizNo(String bizNo)
/*     */   {
/* 330 */     this.bizNo = bizNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 338 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 346 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getVoicesCount()
/*     */   {
/* 355 */     return this.voicesCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoicesCount(Long voicesCount)
/*     */   {
/* 365 */     this.voicesCount = voicesCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getContactsName()
/*     */   {
/* 374 */     return this.contactsName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContactsName(String contactsName)
/*     */   {
/* 384 */     this.contactsName = contactsName;
/*     */   }
/*     */ }
