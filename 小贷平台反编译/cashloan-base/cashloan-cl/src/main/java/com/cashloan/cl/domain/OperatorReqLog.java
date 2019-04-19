/*     */ package com.cashloan.cl.domain;
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
/*     */ public class OperatorReqLog
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String BUSINESS_TYPE_SS = "10";
/*     */   public static final String BUSINESS_TYPE_AC = "20";
/*     */   public static final String BUSINESS_TYPE_TD = "30";
/*     */   public static final String BUSINESS_TYPE_SS2 = "40";
/*     */   public static final String BUSINESS_TYPE_GOURD = "50";
/*     */   public static final String BUSINESS_TYPE_WHITE = "60";
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String orderNo;
/*     */   private String respOrderNo;
/*     */   private String respCode;
/*     */   private String respParams;
/*     */   private Date createTime;
/*     */   private Date respTime;
/*     */   private String businessType;
/*     */   
/*     */   public OperatorReqLog() {}
/*     */   
/*     */   public OperatorReqLog(long userId, String orderNo, String respCode)
/*     */   {
/*  88 */     this.userId = Long.valueOf(userId);
/*  89 */     this.orderNo = orderNo;
/*  90 */     this.respCode = respCode;
/*  91 */     this.createTime = DateUtil.getNow();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  99 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 107 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 115 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 123 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 131 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 139 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRespCode()
/*     */   {
/* 147 */     return this.respCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRespCode(String respCode)
/*     */   {
/* 155 */     this.respCode = respCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 163 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 171 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getRespTime()
/*     */   {
/* 179 */     return this.respTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRespTime(Date respTime)
/*     */   {
/* 187 */     this.respTime = respTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRespParams()
/*     */   {
/* 195 */     return this.respParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRespParams(String respParams)
/*     */   {
/* 203 */     this.respParams = respParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRespOrderNo()
/*     */   {
/* 211 */     return this.respOrderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRespOrderNo(String respOrderNo)
/*     */   {
/* 219 */     this.respOrderNo = respOrderNo;
/*     */   }
/*     */   
/*     */   public String getBusinessType() {
/* 223 */     return this.businessType;
/*     */   }
/*     */   
/*     */   public void setBusinessType(String businessType) {
/* 227 */     this.businessType = businessType;
/*     */   }
/*     */ }