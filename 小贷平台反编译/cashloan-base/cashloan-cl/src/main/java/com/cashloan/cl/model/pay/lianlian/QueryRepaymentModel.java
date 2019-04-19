/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.cashloan.cl.model.pay.lianlian.util.SignUtil;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueryRepaymentModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private String dt_order;
/*     */   private String query_version;
/*     */   private String result_pay;
/*     */   private String oid_paybill;
/*     */   private String money_order;
/*     */   private String settle_date;
/*     */   private String info_order;
/*     */   private String pay_type;
/*     */   private String bank_code;
/*     */   private String bank_name;
/*     */   private String memo;
/*     */   private String card_no;
/*     */   
/*     */   public QueryRepaymentModel() {}
/*     */   
/*     */   public QueryRepaymentModel(String orderNo)
/*     */   {
/*  92 */     setOrderNo(orderNo);
/*  93 */     setQuery_version("1.0");
/*  94 */     setSubUrl("https://queryapi.lianlianpay.com/orderquery.htm");
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/*  99 */     return new String[] { "oid_partner", "sign_type", "sign", "no_order", 
/* 100 */       "dt_order", "oid_paybill", "query_version" };
/*     */   }
/*     */   
/*     */   public String[] reqParamNames()
/*     */   {
/* 105 */     return new String[] { "oid_partner", "sign_type", "sign", "no_order", 
/* 106 */       "dt_order", "oid_paybill", "query_version" };
/*     */   }
/*     */   
/*     */   public String[] verifySignParamNames() {
/* 110 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign", 
/* 111 */       "result_pay", "oid_partner", "dt_order", "no_order", 
/* 112 */       "oid_paybill", "money_order", "settle_date", "info_order", 
/* 113 */       "pay_type", "bank_code", "memo" };
/*     */   }
/*     */   
/*     */   public String[] respParamNames()
/*     */   {
/* 118 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign", 
/* 119 */       "result_pay", "oid_partner", "dt_order", "no_order", 
/* 120 */       "oid_paybill", "money_order", "settle_date", "info_order", 
/* 121 */       "pay_type", "bank_code", "bank_name", "memo", "card_no" };
/*     */   }
/*     */   
/*     */   public boolean verfiySign(BasePaymentModel model)
/*     */   {
/* 126 */     Map<String, Object> map = paramToMap(verifySignParamNames());
/* 127 */     String verifyJsonStr = SignUtil.genSignData(JSON.toJSONString(map));
/* 128 */     return SignUtil.checksign(Global.getValue("lianlian_public_key"), verifyJsonStr, 
/* 129 */       model.getSign());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDt_order()
/*     */   {
/* 138 */     return this.dt_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDt_order(String dt_order)
/*     */   {
/* 147 */     this.dt_order = dt_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getQuery_version()
/*     */   {
/* 156 */     return this.query_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setQuery_version(String query_version)
/*     */   {
/* 165 */     this.query_version = query_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResult_pay()
/*     */   {
/* 174 */     return this.result_pay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResult_pay(String result_pay)
/*     */   {
/* 183 */     this.result_pay = result_pay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOid_paybill()
/*     */   {
/* 192 */     return this.oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOid_paybill(String oid_paybill)
/*     */   {
/* 201 */     this.oid_paybill = oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMoney_order()
/*     */   {
/* 210 */     return this.money_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMoney_order(String money_order)
/*     */   {
/* 219 */     this.money_order = money_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSettle_date()
/*     */   {
/* 228 */     return this.settle_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSettle_date(String settle_date)
/*     */   {
/* 237 */     this.settle_date = settle_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInfo_order()
/*     */   {
/* 246 */     return this.info_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInfo_order(String info_order)
/*     */   {
/* 255 */     this.info_order = info_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPay_type()
/*     */   {
/* 264 */     return this.pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPay_type(String pay_type)
/*     */   {
/* 273 */     this.pay_type = pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBank_code()
/*     */   {
/* 282 */     return this.bank_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBank_code(String bank_code)
/*     */   {
/* 291 */     this.bank_code = bank_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBank_name()
/*     */   {
/* 300 */     return this.bank_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBank_name(String bank_name)
/*     */   {
/* 309 */     this.bank_name = bank_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMemo()
/*     */   {
/* 318 */     return this.memo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMemo(String memo)
/*     */   {
/* 327 */     this.memo = memo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCard_no()
/*     */   {
/* 336 */     return this.card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCard_no(String card_no)
/*     */   {
/* 345 */     this.card_no = card_no;
/*     */   }
/*     */ }
