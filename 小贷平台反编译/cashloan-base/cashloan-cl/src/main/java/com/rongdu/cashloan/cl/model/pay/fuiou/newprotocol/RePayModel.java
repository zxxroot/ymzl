/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou.newprotocol;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.OrderNoUtil;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RePayModel
/*     */   extends FuiouProtocolPayModel
/*     */ {
/*     */   private String userIp;
/*  15 */   private String type = "03";
/*  16 */   private String mchntOrderId = OrderNoUtil.getSerialNumber();
/*     */   private String userId;
/*     */   private Long amt;
/*     */   private String protocolNo;
/*  20 */   private String needSendMsg = "0";
/*  21 */   private String backUrl = "http://www.baiduc.om";
/*     */   private String rem1;
/*     */   private String rem2;
/*     */   private String rem3;
/*  25 */   private String signTp = "MD5";
/*     */   
/*     */ 
/*     */   public String getUserIp()
/*     */   {
/*  30 */     return this.userIp;
/*     */   }
/*     */   
/*     */   public void setUserIp(String userIp) {
/*  34 */     this.userIp = userIp;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  38 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  42 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getMchntOrderId() {
/*  46 */     return this.mchntOrderId;
/*     */   }
/*     */   
/*     */   public void setMchntOrderId(String mchntOrderId) {
/*  50 */     this.mchntOrderId = mchntOrderId;
/*     */   }
/*     */   
/*     */   public String getUserId() {
/*  54 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(String userId) {
/*  58 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public Long getAmt() {
/*  62 */     return this.amt;
/*     */   }
/*     */   
/*     */   public void setAmt(Long amt) {
/*  66 */     this.amt = amt;
/*     */   }
/*     */   
/*     */   public String getProtocolNo() {
/*  70 */     return this.protocolNo;
/*     */   }
/*     */   
/*     */   public void setProtocolNo(String protocolNo) {
/*  74 */     this.protocolNo = protocolNo;
/*     */   }
/*     */   
/*     */   public String getNeedSendMsg() {
/*  78 */     return this.needSendMsg;
/*     */   }
/*     */   
/*     */   public void setNeedSendMsg(String needSendMsg) {
/*  82 */     this.needSendMsg = needSendMsg;
/*     */   }
/*     */   
/*     */   public String getBackUrl() {
/*  86 */     return this.backUrl;
/*     */   }
/*     */   
/*     */   public void setBackUrl(String backUrl) {
/*  90 */     this.backUrl = backUrl;
/*     */   }
/*     */   
/*     */   public String getRem1() {
/*  94 */     return this.rem1;
/*     */   }
/*     */   
/*     */   public void setRem1(String rem1) {
/*  98 */     this.rem1 = rem1;
/*     */   }
/*     */   
/*     */   public String getRem2() {
/* 102 */     return this.rem2;
/*     */   }
/*     */   
/*     */   public void setRem2(String rem2) {
/* 106 */     this.rem2 = rem2;
/*     */   }
/*     */   
/*     */   public String getRem3() {
/* 110 */     return this.rem3;
/*     */   }
/*     */   
/*     */   public void setRem3(String rem3) {
/* 114 */     this.rem3 = rem3;
/*     */   }
/*     */   
/*     */   public String getSignTp() {
/* 118 */     return this.signTp;
/*     */   }
/*     */   
/*     */   public void setSignTp(String signTp) {
/* 122 */     this.signTp = signTp;
/*     */   }
/*     */   
/*     */   public String getUrl()
/*     */   {
/* 127 */     return Global.getValue("fuiou_xieyizhifu_autopay");
/*     */   }
/*     */   
/*     */   public void fillParams(Map<String, Object> map)
/*     */   {
/* 132 */     map.put("VERSION", getVersion());
/* 133 */     map.put("USERIP", getUserIp());
/* 134 */     map.put("MCHNTCD", getMchntCd());
/* 135 */     map.put("TYPE", getType());
/* 136 */     map.put("MCHNTORDERID", getMchntOrderId());
/* 137 */     map.put("USERID", getUserId());
/* 138 */     map.put("AMT", getAmt());
/* 139 */     map.put("PROTOCOLNO", getProtocolNo());
/* 140 */     map.put("NEEDSENDMSG", getNeedSendMsg());
/* 141 */     map.put("BACKURL", getBackUrl());
/* 142 */     map.put("REM1", getRem1());
/* 143 */     map.put("REM2", getRem2());
/* 144 */     map.put("REM3", getRem3());
/* 145 */     map.put("SIGNTP", getSignTp());
/* 146 */     map.put("SIGN", getSign());
/*     */   }
/*     */   
/*     */   public String getSign()
/*     */   {
/* 151 */     String[] signItems = { getType(), getVersion(), getMchntCd(), getMchntOrderId(), getUserId(), 
/* 152 */       getProtocolNo(), String.valueOf(getAmt()), getBackUrl(), getUserIp(), getMchntKey() };
/* 153 */     setSignItems(signItems);
/* 154 */     return super.getSign();
/*     */   }
/*     */ }
