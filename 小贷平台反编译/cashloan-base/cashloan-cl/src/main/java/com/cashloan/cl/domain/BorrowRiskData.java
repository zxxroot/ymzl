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
/*     */ public class BorrowRiskData
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Long repayId;
/*     */   private Long expireDay;
/*     */   private Long urgeCount;
/*     */   private Date updateTime;
/*     */   private Date createTime;
/*     */   private Long loanCount;
/*     */   private Long loanSuCount;
/*     */   private Long loanFailCount;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  77 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  86 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/*  95 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 104 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getRepayId()
/*     */   {
/* 113 */     return this.repayId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayId(Long repayId)
/*     */   {
/* 122 */     this.repayId = repayId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUrgeCount()
/*     */   {
/* 131 */     return this.urgeCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getExpireDay()
/*     */   {
/* 140 */     return this.expireDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setExpireDay(Long expireDay)
/*     */   {
/* 149 */     this.expireDay = expireDay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUrgeCount(Long urgeCount)
/*     */   {
/* 158 */     this.urgeCount = urgeCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 167 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 176 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 185 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 194 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Long getLoanCount() {
/* 198 */     return this.loanCount;
/*     */   }
/*     */   
/*     */   public void setLoanCount(Long loanCount) {
/* 202 */     this.loanCount = loanCount;
/*     */   }
/*     */   
/*     */   public Long getLoanSuCount() {
/* 206 */     return this.loanSuCount;
/*     */   }
/*     */   
/*     */   public void setLoanSuCount(Long loanSuCount) {
/* 210 */     this.loanSuCount = loanSuCount;
/*     */   }
/*     */   
/*     */   public Long getLoanFailCount() {
/* 214 */     return this.loanFailCount;
/*     */   }
/*     */   
/*     */   public void setLoanFailCount(Long loanFailCount) {
/* 218 */     this.loanFailCount = loanFailCount;
/*     */   }
/*     */ }
