/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */

import com.alibaba.fastjson.JSON;
import com.cashloan.cl.model.pay.lianlian.util.PaySecurity;
import com.cashloan.cl.model.pay.lianlian.util.SignUtil;
import com.rongdu.cashloan.core.common.context.Global;

import java.util.Map;

/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PaymentModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private String api_version;
/*     */   private String dt_order;
/*     */   private String money_order;
/*     */   private String card_no;
/*     */   private String acct_name;
/*     */   private String bank_name;
/*     */   private String info_order;
/*     */   private String flag_card;
/*     */   private String memo;
/*     */   private String prcptcd;
/*     */   private String bank_code;
/*     */   private String city_code;
/*     */   private String brabank_name;
/*     */   private String pay_load;
/*     */   private String oid_paybill;
/*     */   private String confirm_code;
/*     */   private String result_pay;
/*     */   private String settle_date;
/*     */   
/*     */   public PaymentModel() {}
/*     */   
/*     */   public PaymentModel(String orderNo)
/*     */   {
/* 117 */     setOrderNo(orderNo);
/* 118 */     setNo_order(orderNo);
/* 119 */     setService("payment");
/* 120 */     setApi_version("1.0");
/* 121 */     setFlag_card("0");
/* 122 */     setSubUrl("https://instantpay.lianlianpay.com/paymentapi/payment.htm");
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/* 127 */     return new String[] { "oid_partner", "platform", "api_version", "sign", 
/* 128 */       "sign_type", "no_order", "dt_order", "money_order", "card_no", 
/* 129 */       "acct_name", "bank_name", "info_order", "flag_card", 
/* 130 */       "notify_url", "memo", "prcptcd", "bank_code", "city_code", 
/* 131 */       "brabank_name" };
/*     */   }
/*     */   
/*     */   public String[] reqParamNames()
/*     */   {
/* 136 */     return new String[] { "oid_partner", "pay_load" };
/*     */   }
/*     */   
/*     */   public String[] respParamNames()
/*     */   {
/* 141 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign", 
/* 142 */       "oid_partner", "no_order", "oid_paybill", "confirm_code" };
/*     */   }
/*     */   
/*     */   public String[] respVerifyParamNames()
/*     */   {
/* 147 */     return new String[] { "oid_partner", "sign_type", "sign", "no_order", 
/* 148 */       "dt_order", "money_order", "oid_paybill", "info_order", 
/* 149 */       "result_pay", "settle_date" };
/*     */   }
/*     */   
/*     */   public void sign()
/*     */   {
/* 154 */     Map<String, Object> map = paramToMap(signParamNames());
/* 155 */     setSign(SignUtil.genRSASign(JSON.toJSONString(map)));
/*     */     
/* 157 */     Map<String, Object> pubMap = paramToMap(signParamNames());
/* 158 */     String encryptStr = PaySecurity.encrypt(JSON.toJSONString(pubMap),
/* 159 */       Global.getValue("lianlian_public_key"));
/* 160 */     setPay_load(encryptStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApi_version()
/*     */   {
/* 169 */     return this.api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApi_version(String api_version)
/*     */   {
/* 178 */     this.api_version = api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDt_order()
/*     */   {
/* 187 */     return this.dt_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDt_order(String dt_order)
/*     */   {
/* 196 */     this.dt_order = dt_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMoney_order()
/*     */   {
/* 205 */     return this.money_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMoney_order(String money_order)
/*     */   {
/* 214 */     this.money_order = money_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCard_no()
/*     */   {
/* 223 */     return this.card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCard_no(String card_no)
/*     */   {
/* 232 */     this.card_no = card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAcct_name()
/*     */   {
/* 241 */     return this.acct_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAcct_name(String acct_name)
/*     */   {
/* 250 */     this.acct_name = acct_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBank_name()
/*     */   {
/* 259 */     return this.bank_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBank_name(String bank_name)
/*     */   {
/* 268 */     this.bank_name = bank_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInfo_order()
/*     */   {
/* 277 */     return this.info_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInfo_order(String info_order)
/*     */   {
/* 286 */     this.info_order = info_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFlag_card()
/*     */   {
/* 295 */     return this.flag_card;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFlag_card(String flag_card)
/*     */   {
/* 304 */     this.flag_card = flag_card;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMemo()
/*     */   {
/* 313 */     return this.memo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMemo(String memo)
/*     */   {
/* 322 */     this.memo = memo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPrcptcd()
/*     */   {
/* 331 */     return this.prcptcd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPrcptcd(String prcptcd)
/*     */   {
/* 340 */     this.prcptcd = prcptcd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBank_code()
/*     */   {
/* 349 */     return this.bank_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBank_code(String bank_code)
/*     */   {
/* 358 */     this.bank_code = bank_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCity_code()
/*     */   {
/* 367 */     return this.city_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCity_code(String city_code)
/*     */   {
/* 376 */     this.city_code = city_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBrabank_name()
/*     */   {
/* 385 */     return this.brabank_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBrabank_name(String brabank_name)
/*     */   {
/* 394 */     this.brabank_name = brabank_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPay_load()
/*     */   {
/* 403 */     return this.pay_load;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPay_load(String pay_load)
/*     */   {
/* 412 */     this.pay_load = pay_load;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOid_paybill()
/*     */   {
/* 421 */     return this.oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOid_paybill(String oid_paybill)
/*     */   {
/* 430 */     this.oid_paybill = oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getConfirm_code()
/*     */   {
/* 439 */     return this.confirm_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setConfirm_code(String confirm_code)
/*     */   {
/* 448 */     this.confirm_code = confirm_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResult_pay()
/*     */   {
/* 457 */     return this.result_pay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResult_pay(String result_pay)
/*     */   {
/* 466 */     this.result_pay = result_pay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSettle_date()
/*     */   {
/* 475 */     return this.settle_date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSettle_date(String settle_date)
/*     */   {
/* 484 */     this.settle_date = settle_date;
/*     */   }
/*     */ }
