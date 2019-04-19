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
/*     */ public class DhbBinding
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private Long userId;
/*     */   private Integer bindingIdcardsSize;
/*     */   private String bindingIdcardsDetail;
/*     */   private Integer bindingPhonesSize;
/*     */   private String bindingPhonesDetail;
/*     */   private Integer bindingPhonesTotalCnt;
/*     */   private Integer bindingIdcardsTotalCnt;
/*     */   private Integer bindingIdcardValidate;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  75 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  84 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/*  93 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 102 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 111 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 120 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getBindingIdcardsSize()
/*     */   {
/* 129 */     return this.bindingIdcardsSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBindingIdcardsSize(Integer bindingIdcardsSize)
/*     */   {
/* 138 */     this.bindingIdcardsSize = bindingIdcardsSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBindingIdcardsDetail()
/*     */   {
/* 147 */     return this.bindingIdcardsDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBindingIdcardsDetail(String bindingIdcardsDetail)
/*     */   {
/* 156 */     this.bindingIdcardsDetail = bindingIdcardsDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getBindingPhonesSize()
/*     */   {
/* 165 */     return this.bindingPhonesSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBindingPhonesSize(Integer bindingPhonesSize)
/*     */   {
/* 174 */     this.bindingPhonesSize = bindingPhonesSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBindingPhonesDetail()
/*     */   {
/* 183 */     return this.bindingPhonesDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBindingPhonesDetail(String bindingPhonesDetail)
/*     */   {
/* 192 */     this.bindingPhonesDetail = bindingPhonesDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getBindingPhonesTotalCnt()
/*     */   {
/* 201 */     return this.bindingPhonesTotalCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBindingPhonesTotalCnt(Integer bindingPhonesTotalCnt)
/*     */   {
/* 210 */     this.bindingPhonesTotalCnt = bindingPhonesTotalCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getBindingIdcardsTotalCnt()
/*     */   {
/* 219 */     return this.bindingIdcardsTotalCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBindingIdcardsTotalCnt(Integer bindingIdcardsTotalCnt)
/*     */   {
/* 228 */     this.bindingIdcardsTotalCnt = bindingIdcardsTotalCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getBindingIdcardValidate()
/*     */   {
/* 237 */     return this.bindingIdcardValidate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBindingIdcardValidate(Integer bindingIdcardValidate)
/*     */   {
/* 246 */     this.bindingIdcardValidate = bindingIdcardValidate;
/*     */   }
/*     */ }
