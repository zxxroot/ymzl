/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AuthSignModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private String user_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String id_type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String id_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String acct_name;
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
/*     */   private String risk_item;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String result_sign;
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
/*     */   public AuthSignModel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AuthSignModel(String orderNo)
/*     */   {
/*  64 */     setOrderNo(orderNo);
/*     */   }
/*     */   
/*     */   public String[] signParamNames()
/*     */   {
/*  69 */     return new String[] { "user_id", "platform", "oid_partner", 
/*  70 */       "sign_type", "sign", "id_type", "id_no", "acct_name", 
/*  71 */       "card_no", "risk_item" };
/*     */   }
/*     */   
/*     */   public String[] reqParamNames()
/*     */   {
/*  76 */     return new String[] { "user_id", "platform", "oid_partner", 
/*  77 */       "sign_type", "sign", "id_type", "id_no", "acct_name", 
/*  78 */       "card_no", "risk_item" };
/*     */   }
/*     */   
/*     */ 
/*     */   public String[] respParamNames()
/*     */   {
/*  84 */     return new String[] { "ret_code", "ret_msg", "sign_type", "sign", 
/*  85 */       "result_sign", "oid_partner", "user_id", "no_agree" };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUser_id()
/*     */   {
/*  93 */     return this.user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUser_id(String user_id)
/*     */   {
/* 101 */     this.user_id = user_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getId_type()
/*     */   {
/* 109 */     return this.id_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId_type(String id_type)
/*     */   {
/* 117 */     this.id_type = id_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getId_no()
/*     */   {
/* 125 */     return this.id_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId_no(String id_no)
/*     */   {
/* 133 */     this.id_no = id_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAcct_name()
/*     */   {
/* 141 */     return this.acct_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAcct_name(String acct_name)
/*     */   {
/* 149 */     this.acct_name = acct_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCard_no()
/*     */   {
/* 157 */     return this.card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCard_no(String card_no)
/*     */   {
/* 165 */     this.card_no = card_no;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRisk_item()
/*     */   {
/* 173 */     return this.risk_item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRisk_item(String risk_item)
/*     */   {
/* 181 */     this.risk_item = risk_item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResult_sign()
/*     */   {
/* 189 */     return this.result_sign;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResult_sign(String result_sign)
/*     */   {
/* 197 */     this.result_sign = result_sign;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNo_agree()
/*     */   {
/* 205 */     return this.no_agree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNo_agree(String no_agree)
/*     */   {
/* 213 */     this.no_agree = no_agree;
/*     */   }
/*     */ }
