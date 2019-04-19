/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RepaymentModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private String user_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String busi_partner;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String api_version;
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
/*     */   private String name_goods;
/*     */   
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
/*     */   private String money_order;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String valid_order;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String risk_item;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String schedule_repayment_date;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String repayment_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String pay_type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String no_agree;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String oid_paybill;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String settle_date;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String result_pay;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String bank_code;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String id_type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String id_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String acct_name;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String card_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String correlationID;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RepaymentModel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RepaymentModel(String orderNo)
/*     */   {
/* 136 */     setOrderNo(orderNo);
/* 137 */     setNo_order(orderNo);
/* 138 */     setService("repayment");
/* 139 */     setApi_version("1.0");
/* 140 */     setPay_type("D");
/* 141 */     setSubUrl("https://repaymentapi.lianlianpay.com/bankcardrepayment.htm");
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/* 146 */     return new String[] { "platform", "user_id", "oid_partner", 
/* 147 */       "sign_type", "sign", "busi_partner", "api_version", "no_order", 
/* 148 */       "dt_order", "name_goods", "info_order", "money_order", 
/* 149 */       "notify_url", "valid_order", "risk_item", 
/* 150 */       "schedule_repayment_date", "repayment_no", "pay_type", 
/* 151 */       "no_agree" };
/*     */   }
/*     */   
/*     */   public String[] reqParamNames()
/*     */   {
/* 156 */     return new String[] { "platform", "user_id", "oid_partner", 
/* 157 */       "sign_type", "sign", "busi_partner", "api_version", "no_order", 
/* 158 */       "dt_order", "name_goods", "info_order", "money_order", 
/* 159 */       "notify_url", "valid_order", "risk_item", 
/* 160 */       "schedule_repayment_date", "repayment_no", "pay_type", 
/* 161 */       "no_agree" };
/*     */   }
/*     */   
/*     */   public String[] respParamNames()
/*     */   {
/* 166 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign", 
/* 167 */       "correlationID", "oid_partner", "no_order", "dt_order", 
/* 168 */       "money_order", "oid_paybill", "settle_date", "info_order", 
/* 169 */       "repayment_no" };
/*     */   }
/*     */   
/*     */   public String[] respVerifyParamNames()
/*     */   {
/* 174 */     return new String[] { "oid_partner", "sign_type", "sign", "dt_order", 
/* 175 */       "no_order", "oid_paybill", "money_order", "result_pay", 
/* 176 */       "settle_date", "info_order", "pay_type", "bank_code", 
/* 177 */       "no_agree", "id_type", "id_no", "acct_name", "card_no" };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUser_id()
/*     */   {
/* 186 */     return this.user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUser_id(String user_id)
/*     */   {
/* 195 */     this.user_id = user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBusi_partner()
/*     */   {
/* 204 */     return this.busi_partner;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBusi_partner(String busi_partner)
/*     */   {
/* 213 */     this.busi_partner = busi_partner;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApi_version()
/*     */   {
/* 222 */     return this.api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApi_version(String api_version)
/*     */   {
/* 231 */     this.api_version = api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDt_order()
/*     */   {
/* 240 */     return this.dt_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDt_order(String dt_order)
/*     */   {
/* 249 */     this.dt_order = dt_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName_goods()
/*     */   {
/* 258 */     return this.name_goods;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName_goods(String name_goods)
/*     */   {
/* 267 */     this.name_goods = name_goods;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInfo_order()
/*     */   {
/* 276 */     return this.info_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInfo_order(String info_order)
/*     */   {
/* 285 */     this.info_order = info_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMoney_order()
/*     */   {
/* 294 */     return this.money_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMoney_order(String money_order)
/*     */   {
/* 303 */     this.money_order = money_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getValid_order()
/*     */   {
/* 312 */     return this.valid_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setValid_order(String valid_order)
/*     */   {
/* 321 */     this.valid_order = valid_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRisk_item()
/*     */   {
/* 330 */     return this.risk_item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRisk_item(String risk_item)
/*     */   {
/* 339 */     this.risk_item = risk_item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSchedule_repayment_date()
/*     */   {
/* 348 */     return this.schedule_repayment_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSchedule_repayment_date(String schedule_repayment_date)
/*     */   {
/* 357 */     this.schedule_repayment_date = schedule_repayment_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayment_no()
/*     */   {
/* 366 */     return this.repayment_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayment_no(String repayment_no)
/*     */   {
/* 375 */     this.repayment_no = repayment_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPay_type()
/*     */   {
/* 384 */     return this.pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPay_type(String pay_type)
/*     */   {
/* 393 */     this.pay_type = pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNo_agree()
/*     */   {
/* 402 */     return this.no_agree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNo_agree(String no_agree)
/*     */   {
/* 411 */     this.no_agree = no_agree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOid_paybill()
/*     */   {
/* 420 */     return this.oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOid_paybill(String oid_paybill)
/*     */   {
/* 429 */     this.oid_paybill = oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSettle_date()
/*     */   {
/* 438 */     return this.settle_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSettle_date(String settle_date)
/*     */   {
/* 447 */     this.settle_date = settle_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResult_pay()
/*     */   {
/* 456 */     return this.result_pay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResult_pay(String result_pay)
/*     */   {
/* 465 */     this.result_pay = result_pay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBank_code()
/*     */   {
/* 474 */     return this.bank_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBank_code(String bank_code)
/*     */   {
/* 483 */     this.bank_code = bank_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getId_type()
/*     */   {
/* 492 */     return this.id_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId_type(String id_type)
/*     */   {
/* 501 */     this.id_type = id_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getId_no()
/*     */   {
/* 510 */     return this.id_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId_no(String id_no)
/*     */   {
/* 519 */     this.id_no = id_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAcct_name()
/*     */   {
/* 528 */     return this.acct_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAcct_name(String acct_name)
/*     */   {
/* 537 */     this.acct_name = acct_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCard_no()
/*     */   {
/* 546 */     return this.card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCard_no(String card_no)
/*     */   {
/* 555 */     this.card_no = card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCorrelationID()
/*     */   {
/* 563 */     return this.correlationID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCorrelationID(String correlationID)
/*     */   {
/* 571 */     this.correlationID = correlationID;
/*     */   }
/*     */ }
