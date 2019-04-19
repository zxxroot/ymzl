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
/*     */ public class UrgeRepayOrderLog
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long dueId;
/*     */   private Long borrowId;
/*     */   private Long userId;
/*     */   private Date createTime;
/*     */   private String state;
/*     */   private String remark;
/*     */   private Date promiseTime;
/*     */   private String way;
/*     */   private String flag;
/*     */   
/*     */   public Date getPromiseTime()
/*     */   {
/*  69 */     return this.promiseTime;
/*     */   }
/*     */   
/*     */   public void setPromiseTime(Date promiseTime) {
/*  73 */     this.promiseTime = promiseTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  82 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  91 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getDueId()
/*     */   {
/* 100 */     return this.dueId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDueId(Long dueId)
/*     */   {
/* 110 */     this.dueId = dueId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getBorrowId()
/*     */   {
/* 119 */     return this.borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowId(Long borrowId)
/*     */   {
/* 129 */     this.borrowId = borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 138 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 148 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 157 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 167 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 176 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 186 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 195 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 205 */     this.remark = remark;
/*     */   }
/*     */   
/*     */   public String getWay() {
/* 209 */     return this.way;
/*     */   }
/*     */   
/*     */   public void setWay(String way) {
/* 213 */     this.way = way;
/*     */   }
/*     */   
/*     */   public String getFlag() {
/* 217 */     return this.flag;
/*     */   }
/*     */   
/*     */   public void setFlag(String flag) {
/* 221 */     this.flag = flag;
/*     */   }
/*     */ }
