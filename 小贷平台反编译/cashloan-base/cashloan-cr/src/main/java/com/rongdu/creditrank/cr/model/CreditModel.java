/*     */ package com.rongdu.creditrank.cr.model;
/*     */ 
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreditModel
/*     */   extends UserBaseInfo
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Double total;
/*     */   private Double unuse;
/*     */   private Double used;
/*     */   private String consumerNo;
/*     */   private String creditName;
/*     */   private String grade;
/*     */   private String stateStr;
/*     */   private String state;
/*     */   
/*     */   public String getStateStr()
/*     */   {
/*  34 */     return this.stateStr;
/*     */   }
/*     */   
/*     */   public void setStateStr(String stateStr) {
/*  38 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */   public String getState() {
/*  42 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/*  46 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String stateConvert(String state) {
/*  50 */     String stateStr = null;
/*  51 */     if ("10".equals(state)) {
/*  52 */       stateStr = "正常";
/*  53 */     } else if ("20".equals(state)) {
/*  54 */       stateStr = "黑名单";
/*     */     }
/*  56 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getUnuse()
/*     */   {
/*  64 */     return this.unuse;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUnuse(Double unuse)
/*     */   {
/*  72 */     this.unuse = unuse;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getSerialversionuid()
/*     */   {
/*  82 */     return 1L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getTotal()
/*     */   {
/*  90 */     return this.total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotal(Double total)
/*     */   {
/*  98 */     this.total = total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getUsed()
/*     */   {
/* 106 */     return this.used;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUsed(Double used)
/*     */   {
/* 114 */     this.used = used;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getGrade()
/*     */   {
/* 122 */     return this.grade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGrade(String grade)
/*     */   {
/* 130 */     this.grade = grade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditName()
/*     */   {
/* 139 */     return this.creditName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditName(String creditName)
/*     */   {
/* 147 */     this.creditName = creditName;
/*     */   }
/*     */   
/*     */   public String getConsumerNo() {
/* 151 */     return this.consumerNo;
/*     */   }
/*     */   
/*     */   public void setConsumerNo(String consumerNo) {
/* 155 */     this.consumerNo = consumerNo;
/*     */   }
/*     */ }
