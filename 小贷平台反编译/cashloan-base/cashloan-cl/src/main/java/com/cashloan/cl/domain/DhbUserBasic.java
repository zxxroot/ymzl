/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DhbUserBasic
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private Long userId;
/*     */   private Integer age;
/*     */   private String gender;
/*     */   private String birthday;
/*     */   private Integer idcardValidate;
/*     */   private String idcardProvince;
/*     */   private String idcardCity;
/*     */   private String idcardRegion;
/*     */   private String phoneOperator;
/*     */   private String phoneProvince;
/*     */   private String phoneCity;
/*     */   private Integer recordIdcardDays;
/*     */   private Integer recordPhoneDays;
/*     */   private String lastAppearIdcard;
/*     */   private String lastAppearPhone;
/*     */   private Integer usedIdcardsCnt;
/*     */   private Integer usedPhonesCnt;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 121 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 130 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 139 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 148 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 157 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 166 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getAge()
/*     */   {
/* 175 */     return this.age;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAge(Integer age)
/*     */   {
/* 184 */     this.age = age;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getGender()
/*     */   {
/* 193 */     return this.gender;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGender(String gender)
/*     */   {
/* 202 */     this.gender = gender;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBirthday()
/*     */   {
/* 211 */     return this.birthday;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBirthday(String birthday)
/*     */   {
/* 220 */     this.birthday = birthday;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getIdcardValidate()
/*     */   {
/* 229 */     return this.idcardValidate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdcardValidate(Integer idcardValidate)
/*     */   {
/* 238 */     this.idcardValidate = idcardValidate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdcardProvince()
/*     */   {
/* 247 */     return this.idcardProvince;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdcardProvince(String idcardProvince)
/*     */   {
/* 256 */     this.idcardProvince = idcardProvince;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdcardCity()
/*     */   {
/* 265 */     return this.idcardCity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdcardCity(String idcardCity)
/*     */   {
/* 274 */     this.idcardCity = idcardCity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdcardRegion()
/*     */   {
/* 283 */     return this.idcardRegion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdcardRegion(String idcardRegion)
/*     */   {
/* 292 */     this.idcardRegion = idcardRegion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneOperator()
/*     */   {
/* 301 */     return this.phoneOperator;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneOperator(String phoneOperator)
/*     */   {
/* 310 */     this.phoneOperator = phoneOperator;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneProvince()
/*     */   {
/* 319 */     return this.phoneProvince;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneProvince(String phoneProvince)
/*     */   {
/* 328 */     this.phoneProvince = phoneProvince;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneCity()
/*     */   {
/* 337 */     return this.phoneCity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneCity(String phoneCity)
/*     */   {
/* 346 */     this.phoneCity = phoneCity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getRecordIdcardDays()
/*     */   {
/* 355 */     return this.recordIdcardDays;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRecordIdcardDays(Integer recordIdcardDays)
/*     */   {
/* 364 */     this.recordIdcardDays = recordIdcardDays;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getRecordPhoneDays()
/*     */   {
/* 373 */     return this.recordPhoneDays;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRecordPhoneDays(Integer recordPhoneDays)
/*     */   {
/* 382 */     this.recordPhoneDays = recordPhoneDays;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLastAppearIdcard()
/*     */   {
/* 391 */     return this.lastAppearIdcard;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLastAppearIdcard(String lastAppearIdcard)
/*     */   {
/* 400 */     this.lastAppearIdcard = lastAppearIdcard;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLastAppearPhone()
/*     */   {
/* 409 */     return this.lastAppearPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLastAppearPhone(String lastAppearPhone)
/*     */   {
/* 418 */     this.lastAppearPhone = lastAppearPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getUsedIdcardsCnt()
/*     */   {
/* 427 */     return this.usedIdcardsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUsedIdcardsCnt(Integer usedIdcardsCnt)
/*     */   {
/* 436 */     this.usedIdcardsCnt = usedIdcardsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getUsedPhonesCnt()
/*     */   {
/* 445 */     return this.usedPhonesCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUsedPhonesCnt(Integer usedPhonesCnt)
/*     */   {
/* 454 */     this.usedPhonesCnt = usedPhonesCnt;
/*     */   }
/*     */ }
