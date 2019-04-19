/*     */ package com.cashloan.cl.model.pay.fuiou.newprotocol;
/*     */ 
/*     */

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
/*     */ public class BindModel
/*     */   extends com.rongdu.cashloan.cl.model.pay.fuiou.newprotocol.FuiouProtocolPayModel
/*     */ {
/*     */   private String msgCode;
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
/*     */   public String getMsgCode() {
/* 105 */     return this.msgCode;
/*     */   }
/*     */   
/*     */   public void setMsgCode(String msgCode) {
/* 109 */     this.msgCode = msgCode;
/*     */   }
/*     */   
/*     */   public String getUrl()
/*     */   {
/* 114 */     return Global.getValue("fuiou_proto_bindcard");
/*     */   }
/*     */   
/*     */   public void fillParams(Map<String, Object> map)
/*     */   {
/* 119 */     map.put("VERSION", getVersion());
/* 120 */     map.put("MCHNTCD", getMchntCd());
/* 121 */     map.put("USERID", getUserId());
/* 122 */     map.put("TRADEDATE", getTradeDate());
/* 123 */     map.put("MCHNTSSN", getMchntssn());
/* 124 */     map.put("ACCOUNT", getAccount());
/* 125 */     map.put("CARDNO", getCardNo());
/* 126 */     map.put("IDCARD", getIdCard());
/* 127 */     map.put("IDTYPE", getIdType());
/* 128 */     map.put("MOBILENO", getMobileNo());
/* 129 */     map.put("MSGCODE", getMsgCode());
/* 130 */     map.put("SIGN", getSign());
/*     */   }
/*     */   
/*     */   public String getSign()
/*     */   {
/* 135 */     String[] signItems = { getVersion(), getMchntssn(), getMchntCd(), getUserId(), getAccount(), 
/* 136 */       getCardNo(), getIdType(), getIdCard(), getMobileNo(), getMsgCode(), getMchntKey() };
/* 137 */     setSignItems(signItems);
/* 138 */     return super.getSign();
/*     */   }
/*     */ }
