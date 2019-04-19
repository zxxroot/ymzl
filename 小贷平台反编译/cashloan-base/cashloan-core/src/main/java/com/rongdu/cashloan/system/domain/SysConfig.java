/*     */ package com.rongdu.cashloan.system.domain;
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
/*     */ public class SysConfig
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String code;
/*     */   private String name;
/*     */   private String value;
/*     */   private Integer type;
/*     */   private Integer status;
/*     */   private Long creator;
/*     */   private String remark;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  40 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  44 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  48 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  52 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getValue() {
/*  56 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(String value) {
/*  60 */     this.value = value;
/*     */   }
/*     */   
/*     */   public Integer getType() {
/*  64 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Integer type) {
/*  68 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/*  72 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  76 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  80 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  84 */     this.code = code;
/*     */   }
/*     */   
/*     */   public Long getCreator() {
/*  88 */     return this.creator;
/*     */   }
/*     */   
/*     */   public void setCreator(Long creator) {
/*  92 */     this.creator = creator;
/*     */   }
/*     */   
/*     */   public String getRemark() {
/*  96 */     return this.remark;
/*     */   }
/*     */   
/*     */   public void setRemark(String remark) {
/* 100 */     this.remark = remark;
/*     */   }
/*     */ }
