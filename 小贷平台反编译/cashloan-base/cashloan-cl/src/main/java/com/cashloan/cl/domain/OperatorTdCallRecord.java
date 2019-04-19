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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperatorTdCallRecord
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long infoId;
/*     */   private String callStartTime;
/*     */   private String callAddress;
/*     */   private String callTypeName;
/*     */   private String callOtherNumber;
/*     */   private String callTime;
/*     */   private String callLandType;
/*     */   private String callRoamCost;
/*     */   private String callLongDistance;
/*     */   private String callDiscount;
/*     */   private String callCost;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  86 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  95 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getInfoId()
/*     */   {
/* 104 */     return this.infoId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInfoId(Long infoId)
/*     */   {
/* 113 */     this.infoId = infoId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallStartTime()
/*     */   {
/* 122 */     return this.callStartTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallStartTime(String callStartTime)
/*     */   {
/* 131 */     this.callStartTime = callStartTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallAddress()
/*     */   {
/* 140 */     return this.callAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallAddress(String callAddress)
/*     */   {
/* 149 */     this.callAddress = callAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallTypeName()
/*     */   {
/* 158 */     return this.callTypeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallTypeName(String callTypeName)
/*     */   {
/* 167 */     this.callTypeName = callTypeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallOtherNumber()
/*     */   {
/* 176 */     return this.callOtherNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallOtherNumber(String callOtherNumber)
/*     */   {
/* 185 */     this.callOtherNumber = callOtherNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallTime()
/*     */   {
/* 194 */     return this.callTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallTime(String callTime)
/*     */   {
/* 203 */     this.callTime = callTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallLandType()
/*     */   {
/* 212 */     return this.callLandType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallLandType(String callLandType)
/*     */   {
/* 221 */     this.callLandType = callLandType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallRoamCost()
/*     */   {
/* 230 */     return this.callRoamCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallRoamCost(String callRoamCost)
/*     */   {
/* 239 */     this.callRoamCost = callRoamCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallLongDistance()
/*     */   {
/* 248 */     return this.callLongDistance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallLongDistance(String callLongDistance)
/*     */   {
/* 257 */     this.callLongDistance = callLongDistance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallDiscount()
/*     */   {
/* 266 */     return this.callDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallDiscount(String callDiscount)
/*     */   {
/* 275 */     this.callDiscount = callDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCallCost()
/*     */   {
/* 284 */     return this.callCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallCost(String callCost)
/*     */   {
/* 293 */     this.callCost = callCost;
/*     */   }
/*     */ }
