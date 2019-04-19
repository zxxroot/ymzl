/*     */ package com.cashloan.cl.model.pay.fuiou.newprotocol;
/*     */ 
/*     */

import com.rongdu.cashloan.cl.model.pay.fuiou.newprotocol.FuiouProtocolPayModel;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import com.rongdu.cashloan.core.common.util.StringUtil;

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
/*     */ public class SmsModel
/*     */   extends FuiouProtocolPayModel
/*     */ {
/*  17 */   private String tradeDate = StringUtil.getDate();
/*     */   
/*     */ 
/*     */ 
/*     */   private String mchntssn;
/*     */   
/*     */ 
/*     */ 
/*     */   private String account;
/*     */   
/*     */ 
/*     */ 
/*     */   private String cardNo;
/*     */   
/*     */ 
/*     */ 
/*  33 */   private String idType = "0";
/*     */   
/*     */ 
/*     */ 
/*     */   private String idCard;
/*     */   
/*     */ 
/*     */   private String mobileNo;
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTradeDate()
/*     */   {
/*  46 */     return this.tradeDate;
/*     */   }
/*     */   
/*     */   protected void setTradeDate(String tradeDate) {
/*  50 */     this.tradeDate = tradeDate;
/*     */   }
/*     */   
/*     */   public String getMchntssn() {
/*  54 */     if (this.mchntssn == null) {
/*  55 */       this.mchntssn = OrderNoUtil.getSerialNumber();
/*     */     }
/*  57 */     return this.mchntssn;
/*     */   }
/*     */   
/*     */   public void setMchntssn(String mchntssn) {
/*  61 */     this.mchntssn = mchntssn;
/*     */   }
/*     */   
/*     */   public String getAccount() {
/*  65 */     return this.account;
/*     */   }
/*     */   
/*     */   public void setAccount(String account) {
/*  69 */     this.account = account;
/*     */   }
/*     */   
/*     */   public String getCardNo() {
/*  73 */     return this.cardNo;
/*     */   }
/*     */   
/*     */   public void setCardNo(String cardNo) {
/*  77 */     this.cardNo = cardNo;
/*     */   }
/*     */   
/*     */   protected String getIdType() {
/*  81 */     return this.idType;
/*     */   }
/*     */   
/*     */   public void setIdType(String idType) {
/*  85 */     this.idType = idType;
/*     */   }
/*     */   
/*     */   public String getIdCard() {
/*  89 */     return this.idCard;
/*     */   }
/*     */   
/*     */   public void setIdCard(String idCard) {
/*  93 */     this.idCard = idCard;
/*     */   }
/*     */   
/*     */   public String getMobileNo() {
/*  97 */     return this.mobileNo;
/*     */   }
/*     */   
/*     */   public void setMobileNo(String mobileNo) {
/* 101 */     this.mobileNo = mobileNo;
/*     */   }
/*     */   
/*     */   public String getUrl()
/*     */   {
/* 106 */     return Global.getValue("fuiou_bindcard_msg_url");
/*     */   }
/*     */   
/*     */   public void fillParams(Map<String, Object> map)
/*     */   {
/* 111 */     map.put("VERSION", getVersion());
/* 112 */     map.put("MCHNTCD", getMchntCd());
/* 113 */     map.put("USERID", getUserId());
/* 114 */     map.put("TRADEDATE", getTradeDate());
/* 115 */     map.put("MCHNTSSN", getMchntssn());
/* 116 */     map.put("ACCOUNT", getAccount());
/* 117 */     map.put("CARDNO", getCardNo());
/* 118 */     map.put("IDTYPE", getIdType());
/* 119 */     map.put("IDCARD", getIdCard());
/* 120 */     map.put("MOBILENO", getMobileNo());
/* 121 */     map.put("CVN", "");
/* 122 */     map.put("SIGN", getSign());
/*     */   }
/*     */   
/*     */   public String getSign()
/*     */   {
/* 127 */     String[] signItems = { getVersion(), getMchntssn(), getMchntCd(), getUserId(), getAccount(), 
/* 128 */       getCardNo(), getIdType(), getIdCard(), getMobileNo(), getMchntKey() };
/* 129 */     setSignItems(signItems);
/* 130 */     return super.getSign();
/*     */   }
/*     */ }
