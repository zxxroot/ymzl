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
/*     */ public class YoudunGraphDetail
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String orderNo;
/*     */   private String mobileCount;
/*     */   private String linkUserCount;
/*     */   private String otherLinkDeviceCount;
/*     */   private String linkUserDetail;
/*     */   private String userHaveBankcardCount;
/*     */   private String otherLinkDeviceDetail;
/*     */   private String partnerUserCount;
/*     */   private String bankcardCount;
/*     */   private String linkDeviceDetail;
/*     */   private String linkDeviceCount;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  91 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 100 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 109 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 118 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 127 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 136 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMobileCount()
/*     */   {
/* 145 */     return this.mobileCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMobileCount(String mobileCount)
/*     */   {
/* 154 */     this.mobileCount = mobileCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLinkUserCount()
/*     */   {
/* 163 */     return this.linkUserCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLinkUserCount(String linkUserCount)
/*     */   {
/* 172 */     this.linkUserCount = linkUserCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOtherLinkDeviceCount()
/*     */   {
/* 181 */     return this.otherLinkDeviceCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOtherLinkDeviceCount(String otherLinkDeviceCount)
/*     */   {
/* 190 */     this.otherLinkDeviceCount = otherLinkDeviceCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLinkUserDetail()
/*     */   {
/* 199 */     return this.linkUserDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLinkUserDetail(String linkUserDetail)
/*     */   {
/* 208 */     this.linkUserDetail = linkUserDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserHaveBankcardCount()
/*     */   {
/* 217 */     return this.userHaveBankcardCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserHaveBankcardCount(String userHaveBankcardCount)
/*     */   {
/* 226 */     this.userHaveBankcardCount = userHaveBankcardCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOtherLinkDeviceDetail()
/*     */   {
/* 235 */     return this.otherLinkDeviceDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOtherLinkDeviceDetail(String otherLinkDeviceDetail)
/*     */   {
/* 244 */     this.otherLinkDeviceDetail = otherLinkDeviceDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPartnerUserCount()
/*     */   {
/* 253 */     return this.partnerUserCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPartnerUserCount(String partnerUserCount)
/*     */   {
/* 262 */     this.partnerUserCount = partnerUserCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBankcardCount()
/*     */   {
/* 271 */     return this.bankcardCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBankcardCount(String bankcardCount)
/*     */   {
/* 280 */     this.bankcardCount = bankcardCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLinkDeviceDetail()
/*     */   {
/* 289 */     return this.linkDeviceDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLinkDeviceDetail(String linkDeviceDetail)
/*     */   {
/* 298 */     this.linkDeviceDetail = linkDeviceDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLinkDeviceCount()
/*     */   {
/* 307 */     return this.linkDeviceCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLinkDeviceCount(String linkDeviceCount)
/*     */   {
/* 316 */     this.linkDeviceCount = linkDeviceCount;
/*     */   }
/*     */ }
