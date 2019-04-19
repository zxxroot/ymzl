/*     */ package com.cashloan.cl.model.pay.lianlian;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueryAuthSignModel
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
/*     */   private String card_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String offset;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String count;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String agreement_list;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public QueryAuthSignModel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public QueryAuthSignModel(String orderNo)
/*     */   {
/*  60 */     setService("queryAuthSign");
/*  61 */     setOrderNo(orderNo);
/*  62 */     setPay_type("D");
/*  63 */     setOffset("0");
/*  64 */     setSubUrl("https://queryapi.lianlianpay.com/bankcardbindlist.htm");
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/*  69 */     return new String[] { "oid_partner", "user_id", "platform", "pay_type", 
/*  70 */       "sign_type", "sign", "no_agree", "card_no", "offset" };
/*     */   }
/*     */   
/*     */ 
/*     */   public String[] reqParamNames()
/*     */   {
/*  76 */     return new String[] { "oid_partner", "user_id", "platform", "pay_type", 
/*  77 */       "sign_type", "sign", "no_agree", "card_no", "offset" };
/*     */   }
/*     */   
/*     */   public String[] respParamNames()
/*     */   {
/*  82 */     return new String[] { "ret_code", "ret_msg", "user_id", "count", 
/*  83 */       "agreement_list", "sign_type", "sign" };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUser_id()
/*     */   {
/*  91 */     return this.user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUser_id(String user_id)
/*     */   {
/*  99 */     this.user_id = user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPay_type()
/*     */   {
/* 107 */     return this.pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPay_type(String pay_type)
/*     */   {
/* 115 */     this.pay_type = pay_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNo_agree()
/*     */   {
/* 123 */     return this.no_agree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNo_agree(String no_agree)
/*     */   {
/* 131 */     this.no_agree = no_agree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCard_no()
/*     */   {
/* 139 */     return this.card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCard_no(String card_no)
/*     */   {
/* 147 */     this.card_no = card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOffset()
/*     */   {
/* 155 */     return this.offset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOffset(String offset)
/*     */   {
/* 163 */     this.offset = offset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCount()
/*     */   {
/* 171 */     return this.count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCount(String count)
/*     */   {
/* 179 */     this.count = count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAgreement_list()
/*     */   {
/* 187 */     return this.agreement_list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAgreement_list(String agreement_list)
/*     */   {
/* 195 */     this.agreement_list = agreement_list;
/*     */   }
/*     */ }
