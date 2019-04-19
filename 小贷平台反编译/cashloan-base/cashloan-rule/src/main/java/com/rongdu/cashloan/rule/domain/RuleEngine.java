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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RuleEngine
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String TYPE_RESULT_ENABLE = "20";
/*     */   public static final String TYPE_RESULT_DISABLE = "10";
/*     */   public static final String STATE_ENABLE = "10";
/*     */   public static final String STATE_DISABLE = "20";
/*     */   private Long id;
/*     */   private String name;
/*     */   private String state;
/*     */   private Integer configCount;
/*     */   private Integer integral;
/*     */   private String reqExt;
/*     */   private String addIp;
/*     */   @JSONField(format="yyyy-MM-dd HH:mm:ss")
/*     */   private Date addTime;
/*     */   private Integer sort;
/*     */   private String type;
/*     */   private String typeResultStatus;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  94 */     return this.id;
/*     */   }
/*     */   
/*     */   public String getTypeResultStatus() {
/*  98 */     return this.typeResultStatus;
/*     */   }
/*     */   
/*     */   public void setTypeResultStatus(String typeResultStatus) {
/* 102 */     this.typeResultStatus = typeResultStatus;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 106 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 110 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 119 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 128 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 138 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 147 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 157 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getConfigCount()
/*     */   {
/* 166 */     return this.configCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setConfigCount(Integer configCount)
/*     */   {
/* 176 */     this.configCount = configCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReqExt()
/*     */   {
/* 185 */     return this.reqExt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReqExt(String reqExt)
/*     */   {
/* 195 */     this.reqExt = reqExt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAddIp()
/*     */   {
/* 204 */     return this.addIp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddIp(String addIp)
/*     */   {
/* 214 */     this.addIp = addIp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 223 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 233 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */   public Integer getIntegral() {
/* 237 */     return this.integral;
/*     */   }
/*     */   
/*     */   public void setIntegral(Integer integral) {
/* 241 */     this.integral = integral;
/*     */   }
/*     */   
/*     */   public Integer getSort() {
/* 245 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 249 */     this.sort = sort;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\domain\RuleEngine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */