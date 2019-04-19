/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AuthApplyModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private String user_id;
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
/*     */   private String repayment_plan;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String repayment_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String sms_param;
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
/*     */   private String token;
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
/*     */   public AuthApplyModel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AuthApplyModel(String orderNo)
/*     */   {
/*  71 */     setService("authApply");
/*  72 */     setOrderNo(orderNo);
/*  73 */     setApi_version("1.0");
/*  74 */     setPay_type("D");
/*  75 */     setSubUrl("https://repaymentapi.lianlianpay.com/agreenoauthapply.htm");
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/*  80 */     return new String[] { "platform", "user_id", "oid_partner", 
/*  81 */       "sign_type", "sign", "api_version", "repayment_plan", 
/*  82 */       "repayment_no", "sms_param", "pay_type", "no_agree" };
/*     */   }
/*     */   
/*     */   public String[] reqParamNames()
/*     */   {
/*  87 */     return new String[] { "platform", "user_id", "oid_partner", 
/*  88 */       "sign_type", "sign", "api_version", "repayment_plan", 
/*  89 */       "repayment_no", "sms_param", "pay_type", "no_agree" };
/*     */   }
/*     */   
/*     */   public String[] respParamNames()
/*     */   {
/*  94 */     return new String[] { "ret_code", "ret_msg", "token", "sign_type", 
/*  95 */       "sign", "correlationID", "oid_partner", "repayment_no" };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUser_id()
/*     */   {
/* 105 */     return this.user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUser_id(String user_id)
/*     */   {
/* 114 */     this.user_id = user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApi_version()
/*     */   {
/* 123 */     return this.api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApi_version(String api_version)
/*     */   {
/* 132 */     this.api_version = api_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayment_plan()
/*     */   {
/* 141 */     return this.repayment_plan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayment_plan(String repayment_plan)
/*     */   {
/* 150 */     this.repayment_plan = repayment_plan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayment_no()
/*     */   {
/* 159 */     return this.repayment_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayment_no(String repayment_no)
/*     */   {
/* 168 */     this.repayment_no = repayment_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSms_param()
/*     */   {
/* 177 */     return this.sms_param;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSms_param(String sms_param)
/*     */   {
/* 186 */     this.sms_param = sms_param;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPay_type()
/*     */   {
/* 195 */     return this.pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPay_type(String pay_type)
/*     */   {
/* 204 */     this.pay_type = pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNo_agree()
/*     */   {
/* 213 */     return this.no_agree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNo_agree(String no_agree)
/*     */   {
/* 222 */     this.no_agree = no_agree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getToken()
/*     */   {
/* 231 */     return this.token;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setToken(String token)
/*     */   {
/* 240 */     this.token = token;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCorrelationID()
/*     */   {
/* 248 */     return this.correlationID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCorrelationID(String correlationID)
/*     */   {
/* 256 */     this.correlationID = correlationID;
/*     */   }
/*     */ }
