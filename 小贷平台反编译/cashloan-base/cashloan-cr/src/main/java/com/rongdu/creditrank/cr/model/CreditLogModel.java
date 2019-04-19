/*     */ package com.rongdu.creditrank.cr.model;
/*     */ 
/*     */ import com.rongdu.creditrank.cr.domain.CreditLog;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreditLogModel
/*     */   extends CreditLog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String type;
/*     */   private String stateStr;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private String idNo;
/*     */   private String unuse;
/*     */   private String creditName;
/*     */   
/*     */   public String convert(String type)
/*     */   {
/*  54 */     String stateStr = null;
/*  55 */     if ("10".equals(type)) {
/*  56 */       stateStr = "增加";
/*  57 */     } else if ("20".equals(type)) {
/*  58 */       stateStr = "减少";
/*  59 */     } else if ("30".equals(type)) {
/*  60 */       stateStr = "冻结";
/*  61 */     } else if ("40".equals(type)) {
/*  62 */       stateStr = "解冻";
/*     */     }
/*  64 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/*  72 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/*  81 */     this.type = convert(type);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRealName()
/*     */   {
/*  89 */     return this.realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRealName(String realName)
/*     */   {
/*  97 */     this.realName = realName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 105 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 113 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdNo()
/*     */   {
/* 121 */     return this.idNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdNo(String idNo)
/*     */   {
/* 129 */     this.idNo = idNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUnuse()
/*     */   {
/* 137 */     return this.unuse;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUnuse(String unuse)
/*     */   {
/* 145 */     this.unuse = unuse;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditName()
/*     */   {
/* 153 */     return this.creditName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditName(String creditName)
/*     */   {
/* 161 */     this.creditName = creditName;
/*     */   }
/*     */ }
