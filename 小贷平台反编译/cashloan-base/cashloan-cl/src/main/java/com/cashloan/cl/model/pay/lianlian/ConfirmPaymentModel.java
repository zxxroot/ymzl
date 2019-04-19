/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */

import com.alibaba.fastjson.JSON;
import com.cashloan.cl.model.pay.lianlian.util.PaySecurity;
import com.cashloan.cl.model.pay.lianlian.util.SignUtil;
import com.rongdu.cashloan.core.common.context.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
/*     */ public class ConfirmPaymentModel
/*     */   extends BasePaymentModel
/*     */ {
/*  25 */   private static final Logger logger = LoggerFactory.getLogger(ConfirmPaymentModel.class);
/*     */   
/*     */ 
/*     */ 
/*     */   private String api_version;
/*     */   
/*     */ 
/*     */ 
/*     */   private String confirm_code;
/*     */   
/*     */ 
/*     */ 
/*     */   private String pay_load;
/*     */   
/*     */ 
/*     */ 
/*     */   private String oid_paybill;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ConfirmPaymentModel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ConfirmPaymentModel(String orderNo)
/*     */   {
/*  53 */     setOrderNo(orderNo);
/*  54 */     setService("confirmPayment");
/*  55 */     setApi_version("1.0");
/*  56 */     setSubUrl("https://instantpay.lianlianpay.com/paymentapi/confirmPayment.htm");
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/*  61 */     return new String[] { "oid_partner", "sign_type", "sign", "platform", 
/*  62 */       "api_version", "no_order", "confirm_code", "notify_url" };
/*     */   }
/*     */   
/*     */   public String[] reqParamNames()
/*     */   {
/*  67 */     return new String[] { "oid_partner", "pay_load" };
/*     */   }
/*     */   
/*     */   public String[] respParamNames()
/*     */   {
/*  72 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign", 
/*  73 */       "oid_partner", "no_order", "oid_paybill" };
/*     */   }
/*     */   
/*     */   public void sign()
/*     */   {
/*  78 */     Map<String, Object> map = paramToMap(signParamNames());
/*  79 */     setSign(SignUtil.genRSASign(JSON.toJSONString(map)));
/*     */     
/*  81 */     logger.info("使用连连银通公钥加密");
/*  82 */     Map<String, Object> pubMap = paramToMap(signParamNames());
/*  83 */     String encryptStr = PaySecurity.encrypt(JSON.toJSONString(pubMap), 
/*  84 */       Global.getValue("lianlian_public_key"));
/*     */     
/*  86 */     setPay_load(encryptStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApi_version()
/*     */   {
/*  95 */     return this.api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApi_version(String api_version)
/*     */   {
/* 104 */     this.api_version = api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getConfirm_code()
/*     */   {
/* 113 */     return this.confirm_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setConfirm_code(String confirm_code)
/*     */   {
/* 122 */     this.confirm_code = confirm_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPay_load()
/*     */   {
/* 131 */     return this.pay_load;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPay_load(String pay_load)
/*     */   {
/* 140 */     this.pay_load = pay_load;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOid_paybill()
/*     */   {
/* 149 */     return this.oid_paybill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOid_paybill(String oid_paybill)
/*     */   {
/* 158 */     this.oid_paybill = oid_paybill;
/*     */   }
/*     */ }
