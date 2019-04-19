/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CancelAuthSignModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private String user_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String pay_type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String no_agree;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CancelAuthSignModel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CancelAuthSignModel(String orderNo)
/*     */   {
/*  39 */     setService("cancelAuthSign");
/*  40 */     setOrderNo(orderNo);
/*  41 */     setPay_type("D");
/*  42 */     setSubUrl("https://yintong.com.cn/traderapi/bankcardunbind.htm");
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/*  47 */     return new String[] { "oid_partner", "user_id", "platform", "pay_type", 
/*  48 */       "sign_type", "sign", "no_agree" };
/*     */   }
/*     */   
/*     */ 
/*     */   public String[] reqParamNames()
/*     */   {
/*  54 */     return new String[] { "oid_partner", "user_id", "platform", "pay_type", 
/*  55 */       "sign_type", "sign", "no_agree" };
/*     */   }
/*     */   
/*     */   public String[] respParamNames()
/*     */   {
/*  60 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign" };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUser_id()
/*     */   {
/*  68 */     return this.user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUser_id(String user_id)
/*     */   {
/*  76 */     this.user_id = user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPay_type()
/*     */   {
/*  84 */     return this.pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPay_type(String pay_type)
/*     */   {
/*  92 */     this.pay_type = pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNo_agree()
/*     */   {
/* 100 */     return this.no_agree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNo_agree(String no_agree)
/*     */   {
/* 108 */     this.no_agree = no_agree;
/*     */   }
/*     */ }
