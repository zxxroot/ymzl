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
/*     */ public class OperatorRepMain
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String companyName;
/*     */   private String companyType;
/*     */   private Integer totalServiceCnt;
/*     */   private String serviceDetails;
/*     */   private Integer interactCnt;
/*     */   private String interactMth;
/*     */   private Date createTime;
/*     */   private String janCnt;
/*     */   private String febCnt;
/*     */   private String marCnt;
/*     */   private String aprCnt;
/*     */   private String mayCnt;
/*     */   private String juneCnt;
/*     */   private String julyCnt;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  83 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  92 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 101 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 111 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyName()
/*     */   {
/* 120 */     return this.companyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyName(String companyName)
/*     */   {
/* 130 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCompanyType()
/*     */   {
/* 139 */     return this.companyType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCompanyType(String companyType)
/*     */   {
/* 149 */     this.companyType = companyType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getTotalServiceCnt()
/*     */   {
/* 158 */     return this.totalServiceCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalServiceCnt(Integer totalServiceCnt)
/*     */   {
/* 168 */     this.totalServiceCnt = totalServiceCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getServiceDetails()
/*     */   {
/* 177 */     return this.serviceDetails;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setServiceDetails(String serviceDetails)
/*     */   {
/* 187 */     this.serviceDetails = serviceDetails;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getInteractCnt()
/*     */   {
/* 196 */     return this.interactCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInteractCnt(Integer interactCnt)
/*     */   {
/* 206 */     this.interactCnt = interactCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInteractMth()
/*     */   {
/* 215 */     return this.interactMth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInteractMth(String interactMth)
/*     */   {
/* 225 */     this.interactMth = interactMth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 234 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 244 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String getJanCnt() {
/* 248 */     return this.janCnt;
/*     */   }
/*     */   
/*     */   public void setJanCnt(String janCnt) {
/* 252 */     this.janCnt = janCnt;
/*     */   }
/*     */   
/*     */   public String getFebCnt() {
/* 256 */     return this.febCnt;
/*     */   }
/*     */   
/*     */   public void setFebCnt(String febCnt) {
/* 260 */     this.febCnt = febCnt;
/*     */   }
/*     */   
/*     */   public String getMarCnt() {
/* 264 */     return this.marCnt;
/*     */   }
/*     */   
/*     */   public void setMarCnt(String marCnt) {
/* 268 */     this.marCnt = marCnt;
/*     */   }
/*     */   
/*     */   public String getAprCnt() {
/* 272 */     return this.aprCnt;
/*     */   }
/*     */   
/*     */   public void setAprCnt(String aprCnt) {
/* 276 */     this.aprCnt = aprCnt;
/*     */   }
/*     */   
/*     */   public String getMayCnt() {
/* 280 */     return this.mayCnt;
/*     */   }
/*     */   
/*     */   public void setMayCnt(String mayCnt) {
/* 284 */     this.mayCnt = mayCnt;
/*     */   }
/*     */   
/*     */   public String getJuneCnt() {
/* 288 */     return this.juneCnt;
/*     */   }
/*     */   
/*     */   public void setJuneCnt(String juneCnt) {
/* 292 */     this.juneCnt = juneCnt;
/*     */   }
/*     */   
/*     */   public String getJulyCnt() {
/* 296 */     return this.julyCnt;
/*     */   }
/*     */   
/*     */   public void setJulyCnt(String julyCnt) {
/* 300 */     this.julyCnt = julyCnt;
/*     */   }
/*     */ }
