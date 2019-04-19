/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
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
/*     */ public class OperatorVoicesTotal
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long netsTime;
/*     */   private Long userId;
/*     */   private BigDecimal payAmtJan;
/*     */   private BigDecimal payAmtFeb;
/*     */   private BigDecimal payAmtMar;
/*     */   private BigDecimal payAmtApr;
/*     */   private BigDecimal payAmtMay;
/*     */   private BigDecimal payAmtJune;
/*     */   private BigDecimal payAmtTreeAvg;
/*     */   private BigDecimal payAmtFiveAvg;
/*     */   private Long voicesCount;
/*     */   private Long smsCount;
/*     */   private Long voicesContactsPhone;
/*     */   private BigDecimal voicesContactsScale;
/*     */   private Long voicesContactsName;
/*     */   private Date createTime;
/*     */   
/*     */   public void init()
/*     */   {
/* 107 */     this.payAmtJan = BigDecimal.ZERO;
/* 108 */     this.payAmtFeb = BigDecimal.ZERO;
/* 109 */     this.payAmtMar = BigDecimal.ZERO;
/* 110 */     this.payAmtApr = BigDecimal.ZERO;
/* 111 */     this.payAmtMay = BigDecimal.ZERO;
/* 112 */     this.payAmtJune = BigDecimal.ZERO;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 122 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 131 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getNetsTime()
/*     */   {
/* 140 */     return this.netsTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNetsTime(Long netsTime)
/*     */   {
/* 149 */     this.netsTime = netsTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 158 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 167 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getPayAmtJan()
/*     */   {
/* 176 */     return this.payAmtJan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayAmtJan(BigDecimal payAmtJan)
/*     */   {
/* 185 */     this.payAmtJan = payAmtJan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getPayAmtFeb()
/*     */   {
/* 194 */     return this.payAmtFeb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayAmtFeb(BigDecimal payAmtFeb)
/*     */   {
/* 203 */     this.payAmtFeb = payAmtFeb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getPayAmtMar()
/*     */   {
/* 212 */     return this.payAmtMar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayAmtMar(BigDecimal payAmtMar)
/*     */   {
/* 221 */     this.payAmtMar = payAmtMar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getPayAmtApr()
/*     */   {
/* 230 */     return this.payAmtApr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayAmtApr(BigDecimal payAmtApr)
/*     */   {
/* 239 */     this.payAmtApr = payAmtApr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getPayAmtMay()
/*     */   {
/* 248 */     return this.payAmtMay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayAmtMay(BigDecimal payAmtMay)
/*     */   {
/* 257 */     this.payAmtMay = payAmtMay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getPayAmtJune()
/*     */   {
/* 266 */     return this.payAmtJune;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayAmtJune(BigDecimal payAmtJune)
/*     */   {
/* 275 */     this.payAmtJune = payAmtJune;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getPayAmtTreeAvg()
/*     */   {
/* 284 */     return this.payAmtTreeAvg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayAmtTreeAvg(BigDecimal payAmtTreeAvg)
/*     */   {
/* 293 */     this.payAmtTreeAvg = payAmtTreeAvg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getPayAmtFiveAvg()
/*     */   {
/* 302 */     return this.payAmtFiveAvg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayAmtFiveAvg(BigDecimal payAmtFiveAvg)
/*     */   {
/* 311 */     this.payAmtFiveAvg = payAmtFiveAvg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getVoicesCount()
/*     */   {
/* 320 */     return this.voicesCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoicesCount(Long voicesCount)
/*     */   {
/* 329 */     this.voicesCount = voicesCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getSmsCount()
/*     */   {
/* 338 */     return this.smsCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSmsCount(Long smsCount)
/*     */   {
/* 347 */     this.smsCount = smsCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getVoicesContactsPhone()
/*     */   {
/* 356 */     return this.voicesContactsPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoicesContactsPhone(Long voicesContactsPhone)
/*     */   {
/* 365 */     this.voicesContactsPhone = voicesContactsPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getVoicesContactsScale()
/*     */   {
/* 374 */     return this.voicesContactsScale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoicesContactsScale(BigDecimal voicesContactsScale)
/*     */   {
/* 383 */     this.voicesContactsScale = voicesContactsScale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getVoicesContactsName()
/*     */   {
/* 392 */     return this.voicesContactsName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoicesContactsName(Long voicesContactsName)
/*     */   {
/* 401 */     this.voicesContactsName = voicesContactsName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 410 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 419 */     this.createTime = createTime;
/*     */   }
/*     */ }
