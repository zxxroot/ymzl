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
/*     */ public class OperatorBasic
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Date gmtModified;
/*     */   private Double basicExpenditure;
/*     */   private Date gmtCreate;
/*     */   private Date extendJoinDt;
/*     */   private Integer basicAllBonus;
/*     */   private String extendCertifedStatus;
/*     */   private Double basicBalance;
/*     */   private String basicPhoneNum;
/*     */   private String extendBelongto;
/*     */   private String extendContactAddr;
/*     */   private Integer extendPhoneAge;
/*     */   private String bizNo;
/*     */   private String basicUserName;
/*     */   private Date createTime;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 105 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 112 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 120 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 128 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getGmtModified()
/*     */   {
/* 135 */     return this.gmtModified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGmtModified(Date gmtModified)
/*     */   {
/* 142 */     this.gmtModified = gmtModified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Double getBasicExpenditure()
/*     */   {
/* 149 */     return this.basicExpenditure;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBasicExpenditure(Double basicExpenditure)
/*     */   {
/* 156 */     this.basicExpenditure = basicExpenditure;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 163 */     return this.gmtCreate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 170 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getExtendJoinDt()
/*     */   {
/* 177 */     return this.extendJoinDt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExtendJoinDt(Date extendJoinDt)
/*     */   {
/* 184 */     this.extendJoinDt = extendJoinDt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getBasicAllBonus()
/*     */   {
/* 191 */     return this.basicAllBonus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBasicAllBonus(Integer basicAllBonus)
/*     */   {
/* 198 */     this.basicAllBonus = basicAllBonus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getExtendCertifedStatus()
/*     */   {
/* 205 */     return this.extendCertifedStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExtendCertifedStatus(String extendCertifedStatus)
/*     */   {
/* 212 */     this.extendCertifedStatus = extendCertifedStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Double getBasicBalance()
/*     */   {
/* 219 */     return this.basicBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBasicBalance(Double basicBalance)
/*     */   {
/* 226 */     this.basicBalance = basicBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBasicPhoneNum()
/*     */   {
/* 233 */     return this.basicPhoneNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBasicPhoneNum(String basicPhoneNum)
/*     */   {
/* 240 */     this.basicPhoneNum = basicPhoneNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getExtendBelongto()
/*     */   {
/* 247 */     return this.extendBelongto;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExtendBelongto(String extendBelongto)
/*     */   {
/* 254 */     this.extendBelongto = extendBelongto;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getExtendContactAddr()
/*     */   {
/* 261 */     return this.extendContactAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExtendContactAddr(String extendContactAddr)
/*     */   {
/* 268 */     this.extendContactAddr = extendContactAddr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getExtendPhoneAge()
/*     */   {
/* 275 */     return this.extendPhoneAge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExtendPhoneAge(Integer extendPhoneAge)
/*     */   {
/* 282 */     this.extendPhoneAge = extendPhoneAge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBizNo()
/*     */   {
/* 289 */     return this.bizNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBizNo(String bizNo)
/*     */   {
/* 296 */     this.bizNo = bizNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBasicUserName()
/*     */   {
/* 303 */     return this.basicUserName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBasicUserName(String basicUserName)
/*     */   {
/* 310 */     this.basicUserName = basicUserName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 317 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 324 */     this.createTime = createTime;
/*     */   }
/*     */ }
