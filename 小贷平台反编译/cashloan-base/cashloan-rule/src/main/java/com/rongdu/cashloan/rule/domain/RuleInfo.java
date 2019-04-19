/*     */ package com.rongdu.cashloan.rule.domain;
/*     */ 
/*     */ import com.alibaba.fastjson.annotation.JSONField;
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
/*     */ public class RuleInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String tbNid;
/*     */   private String tbName;
/*     */   private String detail;
/*     */   private String state;
/*     */   private String reqExt;
/*     */   @JSONField(format="yyyy-MM-dd HH:mm:ss")
/*     */   private Date addTime;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  65 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  74 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTbNid()
/*     */   {
/*  83 */     return this.tbNid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTbNid(String tbNid)
/*     */   {
/*  92 */     this.tbNid = tbNid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTbName()
/*     */   {
/* 101 */     return this.tbName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTbName(String tbName)
/*     */   {
/* 110 */     this.tbName = tbName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDetail()
/*     */   {
/* 119 */     return this.detail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDetail(String detail)
/*     */   {
/* 128 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 132 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 136 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getReqExt() {
/* 140 */     return this.reqExt;
/*     */   }
/*     */   
/*     */   public void setReqExt(String reqExt) {
/* 144 */     this.reqExt = reqExt;
/*     */   }
/*     */   
/*     */   public Date getAddTime() {
/* 148 */     return this.addTime;
/*     */   }
/*     */   
/*     */   public void setAddTime(Date addTime) {
/* 152 */     this.addTime = addTime;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\domain\RuleInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */