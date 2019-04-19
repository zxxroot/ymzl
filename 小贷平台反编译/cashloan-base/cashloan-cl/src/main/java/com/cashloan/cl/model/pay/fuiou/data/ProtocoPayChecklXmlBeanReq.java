/*     */ package com.cashloan.cl.model.pay.fuiou.data;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import org.nuxeo.common.xmap.annotation.XNode;
/*     */ 
/*     */ @org.nuxeo.common.xmap.annotation.XObject("ORDER")
/*     */ public class ProtocoPayChecklXmlBeanReq
/*     */ {
/*     */   @XNode("VERSION")
/*     */   private String version;
/*     */   @XNode("MCHNTSSN")
/*     */   private String mchntSsn;
/*     */   @XNode("MCHNTCD")
/*     */   private String mchntCd;
/*     */   @XNode("USERID")
/*     */   private String userId;
/*     */   @XNode("IDCARD")
/*     */   private String idCard;
/*     */   @XNode("IDTYPE")
/*     */   private String idType;
/*     */   @XNode("ACCOUNT")
/*     */   private String account;
/*     */   @XNode("CARDNO")
/*     */   private String cardNo;
/*     */   @XNode("MOBILENO")
/*     */   private String mobileNo;
/*     */   @XNode("MSGCODE")
/*     */   private String msgCode;
/*     */   @XNode("PROTOCOLNO")
/*     */   private String protocolNo;
/*     */   @XNode("SIGN")
/*     */   private String sign;
/*     */   @XNode("TRADEDATE")
/*     */   private String tradeDate;
/*     */   @XNode("TYPE")
/*     */   private String type;
/*     */   @XNode("MCHNTORDERID")
/*     */   private String mchntOrderId;
/*     */   @XNode("AMT")
/*     */   private String amt;
/*     */   @XNode("BACKURL")
/*     */   private String backUrl;
/*     */   @XNode("USERIP")
/*     */   private String userIp;
/*     */   @XNode("SIGNTP")
/*     */   private String signTp;
/*     */   @XNode("REM1")
/*  48 */   private String REM1 = "";
/*     */   @XNode("REM2")
/*  50 */   private String REM2 = "";
/*     */   @XNode("REM3")
/*  52 */   private String REM3 = "";
/*     */   private String key;
/*     */   
/*     */   public String getTradeDate()
/*     */   {
/*  57 */     return this.tradeDate;
/*     */   }
/*     */   
/*  60 */   public void setTradeDate(String tradeDate) { this.tradeDate = tradeDate; }
/*     */   
/*     */   public String getMchntSsn() {
/*  63 */     return this.mchntSsn;
/*     */   }
/*     */   
/*  66 */   public void setMchntSsn(String mchntSsn) { this.mchntSsn = mchntSsn; }
/*     */   
/*     */   public String getIdCard() {
/*  69 */     return this.idCard;
/*     */   }
/*     */   
/*  72 */   public void setIdCard(String idCard) { this.idCard = idCard; }
/*     */   
/*     */   public String getIdType() {
/*  75 */     return this.idType;
/*     */   }
/*     */   
/*  78 */   public void setIdType(String idType) { this.idType = idType; }
/*     */   
/*     */   public String getAccount() {
/*  81 */     return this.account;
/*     */   }
/*     */   
/*  84 */   public void setAccount(String account) { this.account = account; }
/*     */   
/*     */   public String getREM1() {
/*  87 */     return this.REM1;
/*     */   }
/*     */   
/*  90 */   public void setREM1(String rEM1) { this.REM1 = rEM1; }
/*     */   
/*     */   public String getREM2() {
/*  93 */     return this.REM2;
/*     */   }
/*     */   
/*  96 */   public void setREM2(String rEM2) { this.REM2 = rEM2; }
/*     */   
/*     */   public String getREM3() {
/*  99 */     return this.REM3;
/*     */   }
/*     */   
/* 102 */   public void setREM3(String rEM3) { this.REM3 = rEM3; }
/*     */   
/*     */   public String getCardNo() {
/* 105 */     return this.cardNo;
/*     */   }
/*     */   
/* 108 */   public void setCardNo(String cardNo) { this.cardNo = cardNo; }
/*     */   
/*     */   public String getMobileNo() {
/* 111 */     return this.mobileNo;
/*     */   }
/*     */   
/* 114 */   public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
/*     */   
/*     */   public String getVersion() {
/* 117 */     return this.version;
/*     */   }
/*     */   
/* 120 */   public void setVersion(String version) { this.version = version; }
/*     */   
/*     */   public String getMchntCd() {
/* 123 */     return this.mchntCd;
/*     */   }
/*     */   
/* 126 */   public void setMchntCd(String mchntCd) { this.mchntCd = mchntCd; }
/*     */   
/*     */   public String getUserId() {
/* 129 */     return this.userId;
/*     */   }
/*     */   
/* 132 */   public void setUserId(String userId) { this.userId = userId; }
/*     */   
/*     */   public String getProtocolNo() {
/* 135 */     return this.protocolNo;
/*     */   }
/*     */   
/* 138 */   public void setProtocolNo(String protocolNo) { this.protocolNo = protocolNo; }
/*     */   
/*     */   public String getSign() {
/* 141 */     return this.sign;
/*     */   }
/*     */   
/* 144 */   public void setSign(String sign) { this.sign = sign; }
/*     */   
/*     */   public String getMsgCode() {
/* 147 */     return this.msgCode;
/*     */   }
/*     */   
/* 150 */   public void setMsgCode(String msgCode) { this.msgCode = msgCode; }
/*     */   
/*     */   public String getType()
/*     */   {
/* 154 */     return this.type;
/*     */   }
/*     */   
/* 157 */   public void setType(String type) { this.type = type; }
/*     */   
/*     */   public String getMchntOrderId() {
/* 160 */     return this.mchntOrderId;
/*     */   }
/*     */   
/* 163 */   public void setMchntOrderId(String mchntOrderId) { this.mchntOrderId = mchntOrderId; }
/*     */   
/*     */   public String getAmt() {
/* 166 */     return this.amt;
/*     */   }
/*     */   
/* 169 */   public void setAmt(String amt) { this.amt = amt; }
/*     */   
/*     */   public String getBackUrl() {
/* 172 */     return this.backUrl;
/*     */   }
/*     */   
/* 175 */   public void setBackUrl(String backUrl) { this.backUrl = backUrl; }
/*     */   
/*     */   public String getUserIp() {
/* 178 */     return this.userIp;
/*     */   }
/*     */   
/* 181 */   public void setUserIp(String userIp) { this.userIp = userIp; }
/*     */   
/*     */ 
/*     */   public String getKey()
/*     */   {
/* 186 */     return this.key;
/*     */   }
/*     */   
/* 189 */   public void setKey(String key) { this.key = key; }
/*     */   
/*     */ 
/*     */   public String getSignTp()
/*     */   {
/* 194 */     return this.signTp;
/*     */   }
/*     */   
/* 197 */   public void setSignTp(String signTp) { this.signTp = signTp; }
/*     */   
/*     */   public String proUnBindSignStr(String key)
/*     */   {
/* 201 */     StringBuilder sb = new StringBuilder();
/* 202 */     sb.append(this.version);
/* 203 */     sb.append("|");
/* 204 */     sb.append(this.mchntCd);
/* 205 */     sb.append("|");
/* 206 */     sb.append(this.userId);
/* 207 */     sb.append("|");
/* 208 */     sb.append(this.protocolNo);
/* 209 */     sb.append("|");
/* 210 */     sb.append(key);
/* 211 */     System.out.println("CardPro proUnBindSignStr:" + sb.toString());
/* 212 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String sendMsgSignStr(String key, boolean isMsg) {
/* 216 */     StringBuilder sb = new StringBuilder();
/* 217 */     sb.append(this.version);
/* 218 */     sb.append("|");
/* 219 */     sb.append(this.mchntSsn);
/* 220 */     sb.append("|");
/* 221 */     sb.append(this.mchntCd);
/* 222 */     sb.append("|");
/* 223 */     sb.append(this.userId);
/* 224 */     sb.append("|");
/* 225 */     sb.append(this.account);
/* 226 */     sb.append("|");
/* 227 */     sb.append(this.cardNo);
/* 228 */     sb.append("|");
/* 229 */     sb.append(this.idType);
/* 230 */     sb.append("|");
/* 231 */     sb.append(this.idCard);
/* 232 */     sb.append("|");
/* 233 */     sb.append(this.mobileNo);
/* 234 */     sb.append("|");
/* 235 */     if (isMsg) {
/* 236 */       sb.append(this.msgCode);
/* 237 */       sb.append("|");
/*     */     }
/* 239 */     sb.append(key);
/* 240 */     System.out.println("CardPro sendMsgSignStr:" + sb.toString());
/* 241 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String proBindSignStr(String key)
/*     */   {
/* 246 */     StringBuilder sb = new StringBuilder();
/* 247 */     sb.append(this.version);
/* 248 */     sb.append("|");
/* 249 */     sb.append(this.mchntSsn);
/* 250 */     sb.append("|");
/* 251 */     sb.append(this.mchntCd);
/* 252 */     sb.append("|");
/* 253 */     sb.append(this.userId);
/* 254 */     sb.append("|");
/* 255 */     sb.append(this.account);
/* 256 */     sb.append("|");
/* 257 */     sb.append(this.cardNo);
/* 258 */     sb.append("|");
/* 259 */     sb.append(this.idType);
/* 260 */     sb.append("|");
/* 261 */     sb.append(this.idCard);
/* 262 */     sb.append("|");
/* 263 */     sb.append(this.mobileNo);
/* 264 */     sb.append("|");
/* 265 */     sb.append(this.msgCode);
/* 266 */     sb.append("|");
/* 267 */     sb.append(key);
/* 268 */     sb.append("|");
/* 269 */     sb.append(this.tradeDate);
/* 270 */     System.out.println("CardPro proBindSignStr:" + sb.toString());
/* 271 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String querySignStr(String key) {
/* 275 */     StringBuilder sb = new StringBuilder();
/* 276 */     sb.append(this.version);
/* 277 */     sb.append("|");
/* 278 */     sb.append(this.mchntCd);
/* 279 */     sb.append("|");
/* 280 */     sb.append(this.userId);
/* 281 */     sb.append("|");
/* 282 */     sb.append(key);
/* 283 */     System.out.println("CardPro querySignStr:" + sb.toString());
/* 284 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String newProPaySignStr(String key) {
/* 288 */     StringBuilder sb = new StringBuilder();
/* 289 */     sb.append(this.type);
/* 290 */     sb.append("|");
/* 291 */     sb.append(this.version);
/* 292 */     sb.append("|");
/* 293 */     sb.append(this.mchntCd);
/* 294 */     sb.append("|");
/* 295 */     sb.append(this.mchntOrderId);
/* 296 */     sb.append("|");
/* 297 */     sb.append(this.userId);
/* 298 */     sb.append("|");
/* 299 */     sb.append(this.protocolNo);
/* 300 */     sb.append("|");
/* 301 */     sb.append(this.amt);
/* 302 */     sb.append("|");
/* 303 */     sb.append(this.backUrl);
/* 304 */     sb.append("|");
/* 305 */     sb.append(this.userIp);
/* 306 */     sb.append("|");
/* 307 */     sb.append(key);
/* 308 */     System.out.println("newProPay sign:" + sb.toString());
/* 309 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String newProPayResutlQuerySignStr(String key) {
/* 313 */     StringBuilder sb = new StringBuilder();
/* 314 */     sb.append(this.version);
/* 315 */     sb.append("|");
/* 316 */     sb.append(this.mchntCd);
/* 317 */     sb.append("|");
/* 318 */     sb.append(this.mchntOrderId);
/* 319 */     sb.append("|");
/* 320 */     sb.append(key);
/* 321 */     System.out.println("proPayResult sign:" + sb.toString());
/* 322 */     return sb.toString();
/*     */   }
/*     */ }
