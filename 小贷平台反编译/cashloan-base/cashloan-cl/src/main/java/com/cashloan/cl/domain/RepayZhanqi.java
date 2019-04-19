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
/*     */ public class RepayZhanqi
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long borrowId;
/*     */   private Long userId;
/*     */   private int zhanqiType;
/*     */   private BigDecimal zhanqiFee;
/*     */   private int zhanqiState;
/*     */   private Date createTime;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  59 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  63 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getBorrowId() {
/*  67 */     return this.borrowId;
/*     */   }
/*     */   
/*     */   public void setBorrowId(Long borrowId) {
/*  71 */     this.borrowId = borrowId;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/*  75 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/*  79 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public int getZhanqiType() {
/*  83 */     return this.zhanqiType;
/*     */   }
/*     */   
/*     */   public void setZhanqiType(int zhanqiType) {
/*  87 */     this.zhanqiType = zhanqiType;
/*     */   }
/*     */   
/*     */   public BigDecimal getZhanqiFee() {
/*  91 */     return this.zhanqiFee;
/*     */   }
/*     */   
/*     */   public void setZhanqiFee(BigDecimal zhanqiFee) {
/*  95 */     this.zhanqiFee = zhanqiFee;
/*     */   }
/*     */   
/*     */   public int getZhanqiState() {
/*  99 */     return this.zhanqiState;
/*     */   }
/*     */   
/*     */   public void setZhanqiState(int zhanqiState) {
/* 103 */     this.zhanqiState = zhanqiState;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 107 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 111 */     this.createTime = createTime;
/*     */   }
/*     */ }
