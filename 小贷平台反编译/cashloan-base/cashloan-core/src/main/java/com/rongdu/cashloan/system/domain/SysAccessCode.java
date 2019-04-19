/*     */ package com.rongdu.cashloan.system.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import tool.util.DateUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SysAccessCode
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String TWO_HOUR = "01";
/*     */   public static final String HALF_DAY = "02";
/*     */   public static final String ONE_DAY = "03";
/*     */   public static final String TWO_DAY = "04";
/*     */   public static final String SEVEN_DAY = "05";
/*     */   public static final String ONE_MOUNTH = "06";
/*     */   public static final String THREE_MOUNTH = "07";
/*     */   public static final String SIX_MOUNTH = "08";
/*     */   private Long id;
/*     */   private Long sysUserId;
/*     */   private String code;
/*     */   private String state;
/*     */   private Date createTime;
/*     */   private Date exceedTime;
/*     */   
/*     */   public SysAccessCode() {}
/*     */   
/*     */   public SysAccessCode(long sysUserId, String code, String state, Date exceedTime)
/*     */   {
/*  99 */     this.sysUserId = Long.valueOf(sysUserId);
/* 100 */     this.code = code;
/* 101 */     this.state = state;
/* 102 */     this.createTime = DateUtil.getNow();
/* 103 */     this.exceedTime = exceedTime;
/*     */   }
/*     */   
/*     */   public Long getId() {
/* 107 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 111 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getSysUserId() {
/* 115 */     return this.sysUserId;
/*     */   }
/*     */   
/*     */   public void setSysUserId(Long sysUserId) {
/* 119 */     this.sysUserId = sysUserId;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 123 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 127 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 131 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 135 */     this.state = state;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 139 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 143 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getExceedTime() {
/* 147 */     return this.exceedTime;
/*     */   }
/*     */   
/*     */   public void setExceedTime(Date exceedTime) {
/* 151 */     this.exceedTime = exceedTime;
/*     */   }
/*     */ }
