/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RepaymentPlanModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private String user_id;
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
/*     */   private String repayment_state;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String repayment_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String sms_param;
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
/*     */   public RepaymentPlanModel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RepaymentPlanModel(String orderNo)
/*     */   {
/*  52 */     setService("repaymentPlan");
/*  53 */     setOrderNo(orderNo);
/*  54 */     setSubUrl("https://repaymentapi.lianlianpay.com/repaymentplanchange.htm");
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/*  59 */     return new String[] { "oid_partner", "sign_type", "sign", "user_id", 
/*  60 */       "repayment_plan", "repayment_state", "repayment_no", 
/*  61 */       "sms_param" };
/*     */   }
/*     */   
/*     */   public String[] reqParamNames()
/*     */   {
/*  66 */     return new String[] { "oid_partner", "sign_type", "sign", "user_id", 
/*  67 */       "repayment_plan", "repayment_state", "repayment_no", 
/*  68 */       "sms_param" };
/*     */   }
/*     */   
/*     */ 
/*     */   public String[] respParamNames()
/*     */   {
/*  74 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign", "correlationID" };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUser_id()
/*     */   {
/*  83 */     return this.user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUser_id(String user_id)
/*     */   {
/*  92 */     this.user_id = user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayment_plan()
/*     */   {
/* 101 */     return this.repayment_plan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayment_plan(String repayment_plan)
/*     */   {
/* 110 */     this.repayment_plan = repayment_plan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayment_state()
/*     */   {
/* 119 */     return this.repayment_state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayment_state(String repayment_state)
/*     */   {
/* 128 */     this.repayment_state = repayment_state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepayment_no()
/*     */   {
/* 137 */     return this.repayment_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayment_no(String repayment_no)
/*     */   {
/* 146 */     this.repayment_no = repayment_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSms_param()
/*     */   {
/* 155 */     return this.sms_param;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSms_param(String sms_param)
/*     */   {
/* 164 */     this.sms_param = sms_param;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCorrelationID()
/*     */   {
/* 172 */     return this.correlationID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCorrelationID(String correlationID)
/*     */   {
/* 180 */     this.correlationID = correlationID;
/*     */   }
/*     */ }
