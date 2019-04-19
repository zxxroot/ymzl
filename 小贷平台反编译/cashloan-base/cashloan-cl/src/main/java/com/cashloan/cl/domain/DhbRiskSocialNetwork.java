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
/*     */ public class DhbRiskSocialNetwork
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private Long userId;
/*     */   private Integer snScore;
/*     */   private Integer snOrder1ContactsCnt;
/*     */   private Integer snOrder1BlacklistContactsCnt;
/*     */   private Integer snOrder2BlacklistContactsCnt;
/*     */   private Integer snOrder2BlacklistRoutersCnt;
/*     */   private Double snOrder2BlacklistRoutersPct;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  80 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/*  89 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/*  98 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 107 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 116 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSnScore()
/*     */   {
/* 125 */     return this.snScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSnScore(Integer snScore)
/*     */   {
/* 134 */     this.snScore = snScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSnOrder1ContactsCnt()
/*     */   {
/* 143 */     return this.snOrder1ContactsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSnOrder1ContactsCnt(Integer snOrder1ContactsCnt)
/*     */   {
/* 152 */     this.snOrder1ContactsCnt = snOrder1ContactsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSnOrder1BlacklistContactsCnt()
/*     */   {
/* 161 */     return this.snOrder1BlacklistContactsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSnOrder1BlacklistContactsCnt(Integer snOrder1BlacklistContactsCnt)
/*     */   {
/* 170 */     this.snOrder1BlacklistContactsCnt = snOrder1BlacklistContactsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSnOrder2BlacklistContactsCnt()
/*     */   {
/* 179 */     return this.snOrder2BlacklistContactsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSnOrder2BlacklistContactsCnt(Integer snOrder2BlacklistContactsCnt)
/*     */   {
/* 188 */     this.snOrder2BlacklistContactsCnt = snOrder2BlacklistContactsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSnOrder2BlacklistRoutersCnt()
/*     */   {
/* 197 */     return this.snOrder2BlacklistRoutersCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSnOrder2BlacklistRoutersCnt(Integer snOrder2BlacklistRoutersCnt)
/*     */   {
/* 206 */     this.snOrder2BlacklistRoutersCnt = snOrder2BlacklistRoutersCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getSnOrder2BlacklistRoutersPct()
/*     */   {
/* 215 */     return this.snOrder2BlacklistRoutersPct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSnOrder2BlacklistRoutersPct(Double snOrder2BlacklistRoutersPct)
/*     */   {
/* 224 */     this.snOrder2BlacklistRoutersPct = snOrder2BlacklistRoutersPct;
/*     */   }
/*     */ }