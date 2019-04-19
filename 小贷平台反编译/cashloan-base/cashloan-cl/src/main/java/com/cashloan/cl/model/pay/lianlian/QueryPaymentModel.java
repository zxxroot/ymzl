/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueryPaymentModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private String api_version;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String oid_paybill;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String dt_order;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String money_order;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String result_pay;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String settle_date;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String info_order;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public QueryPaymentModel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public QueryPaymentModel(String orderNo)
/*     */   {
/*  59 */     setService("queryPayment");
/*  60 */     setOrderNo(orderNo);
/*  61 */     setApi_version("1.0");
/*  62 */     setSubUrl("https://instantpay.lianlianpay.com/paymentapi/queryPayment.htm");
/*     */   }
/*     */   
/*     */ 
/*     */   public String[] signParamNames()
/*     */   {
/*  68 */     return new String[] { "oid_partner", "platform", "api_version", 
/*  69 */       "no_order", "oid_paybill", "sign_type", "sign" };
/*     */   }
/*     */   
/*     */   public String[] reqParamNames()
/*     */   {
/*  74 */     return new String[] { "oid_partner", "platform", "api_version", 
/*  75 */       "no_order", "oid_paybill", "sign_type", "sign" };
/*     */   }
/*     */   
/*     */   public String[] respParamNames()
/*     */   {
/*  80 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign", 
/*  81 */       "oid_partner", "no_order", "dt_order", "money_order", 
/*  82 */       "oid_paybill", "result_pay", "settle_date", "info_order" };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApi_version()
/*     */   {
/*  91 */     return this.api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApi_version(String api_version)
/*     */   {
/* 100 */     this.api_version = api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOid_paybill()
/*     */   {
/* 109 */     return this.oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOid_paybill(String oid_paybill)
/*     */   {
/* 118 */     this.oid_paybill = oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDt_order()
/*     */   {
/* 127 */     return this.dt_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDt_order(String dt_order)
/*     */   {
/* 136 */     this.dt_order = dt_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMoney_order()
/*     */   {
/* 145 */     return this.money_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMoney_order(String money_order)
/*     */   {
/* 154 */     this.money_order = money_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResult_pay()
/*     */   {
/* 163 */     return this.result_pay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResult_pay(String result_pay)
/*     */   {
/* 172 */     this.result_pay = result_pay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSettle_date()
/*     */   {
/* 181 */     return this.settle_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSettle_date(String settle_date)
/*     */   {
/* 190 */     this.settle_date = settle_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInfo_order()
/*     */   {
/* 199 */     return this.info_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInfo_order(String info_order)
/*     */   {
/* 208 */     this.info_order = info_order;
/*     */   }
/*     */ }
