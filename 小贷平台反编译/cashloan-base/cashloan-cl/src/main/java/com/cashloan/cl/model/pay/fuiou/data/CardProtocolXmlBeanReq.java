/*     */ package com.cashloan.cl.model.pay.fuiou.data;
/*     */ 
/*     */ import org.nuxeo.common.xmap.annotation.XNode;

/*     */
/*     */ 
/*     */ @org.nuxeo.common.xmap.annotation.XObject("REQUEST")
/*     */ public class CardProtocolXmlBeanReq
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
/*     */   private String key;
/*     */   
/*     */   public String getTradeDate()
/*     */   {
/*  51 */     return this.tradeDate;
/*     */   }
/*     */   
/*  54 */   public void setTradeDate(String tradeDate) { this.tradeDate = tradeDate; }
/*     */   
/*     */   public String getMchntSsn() {
/*  57 */     return this.mchntSsn;
/*     */   }
/*     */   
/*  60 */   public void setMchntSsn(String mchntSsn) { this.mchntSsn = mchntSsn; }
/*     */   
/*     */   public String getIdCard() {
/*  63 */     return this.idCard;
/*     */   }
/*     */   
/*  66 */   public void setIdCard(String idCard) { this.idCard = idCard; }
/*     */   
/*     */   public String getIdType() {
/*  69 */     return this.idType;
/*     */   }
/*     */   
/*  72 */   public void setIdType(String idType) { this.idType = idType; }
/*     */   
/*     */   public String getAccount() {
/*  75 */     return this.account;
/*     */   }
/*     */   
/*  78 */   public void setAccount(String account) { this.account = account; }
/*     */   
/*     */   public String getCardNo() {
/*  81 */     return this.cardNo;
/*     */   }
/*     */   
/*  84 */   public void setCardNo(String cardNo) { this.cardNo = cardNo; }
/*     */   
/*     */   public String getMobileNo() {
/*  87 */     return this.mobileNo;
/*     */   }
/*     */   
/*  90 */   public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
/*     */   
/*     */   public String getVersion() {
/*  93 */     return this.version;
/*     */   }
/*     */   
/*  96 */   public void setVersion(String version) { this.version = version; }
/*     */   
/*     */   public String getMchntCd() {
/*  99 */     return this.mchntCd;
/*     */   }
/*     */   
/* 102 */   public void setMchntCd(String mchntCd) { this.mchntCd = mchntCd; }
/*     */   
/*     */   public String getUserId() {
/* 105 */     return this.userId;
/*     */   }
/*     */   
/* 108 */   public void setUserId(String userId) { this.userId = userId; }
/*     */   
/*     */   public String getProtocolNo() {
/* 111 */     return this.protocolNo;
/*     */   }
/*     */   
/* 114 */   public void setProtocolNo(String protocolNo) { this.protocolNo = protocolNo; }
/*     */   
/*     */   public String getSign() {
/* 117 */     return this.sign;
/*     */   }
/*     */   
/* 120 */   public void setSign(String sign) { this.sign = sign; }
/*     */   
/*     */   public String getMsgCode() {
/* 123 */     return this.msgCode;
/*     */   }
/*     */   
/* 126 */   public void setMsgCode(String msgCode) { this.msgCode = msgCode; }
/*     */   
/*     */   public String getType()
/*     */   {
/* 130 */     return this.type;
/*     */   }
/*     */   
/* 133 */   public void setType(String type) { this.type = type; }
/*     */   
/*     */   public String getMchntOrderId() {
/* 136 */     return this.mchntOrderId;
/*     */   }
/*     */   
/* 139 */   public void setMchntOrderId(String mchntOrderId) { this.mchntOrderId = mchntOrderId; }
/*     */   
/*     */   public String getAmt() {
/* 142 */     return this.amt;
/*     */   }
/*     */   
/* 145 */   public void setAmt(String amt) { this.amt = amt; }
/*     */   
/*     */   public String getBackUrl() {
/* 148 */     return this.backUrl;
/*     */   }
/*     */   
/* 151 */   public void setBackUrl(String backUrl) { this.backUrl = backUrl; }
/*     */   
/*     */   public String getUserIp() {
/* 154 */     return this.userIp;
/*     */   }
/*     */   
/* 157 */   public void setUserIp(String userIp) { this.userIp = userIp; }
/*     */   
/*     */ 
/*     */   public String getKey()
/*     */   {
/* 162 */     return this.key;
/*     */   }
/*     */   
/* 165 */   public void setKey(String key) { this.key = key; }
/*     */   
/*     */ 
/*     */   public String getSignTp()
/*     */   {
/* 170 */     return this.signTp;
/*     */   }
/*     */   
/* 173 */   public void setSignTp(String signTp) { this.signTp = signTp; }
/*     */   
/*     */   public String proUnBindSignStr(String key)
/*     */   {
/* 177 */     StringBuilder sb = new StringBuilder();
/* 178 */     sb.append(this.version);
/* 179 */     sb.append("|");
/* 180 */     sb.append(this.mchntCd);
/* 181 */     sb.append("|");
/* 182 */     sb.append(this.userId);
/* 183 */     sb.append("|");
/* 184 */     sb.append(this.protocolNo);
/* 185 */     sb.append("|");
/* 186 */     sb.append(key);
/* 187 */     System.out.println("CardPro proUnBindSignStr:" + sb.toString());
/* 188 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String sendMsgSignStr(String key, boolean isMsg) {
/* 192 */     StringBuilder sb = new StringBuilder();
/* 193 */     sb.append(this.version);
/* 194 */     sb.append("|");
/* 195 */     sb.append(this.mchntSsn);
/* 196 */     sb.append("|");
/* 197 */     sb.append(this.mchntCd);
/* 198 */     sb.append("|");
/* 199 */     sb.append(this.userId);
/* 200 */     sb.append("|");
/* 201 */     sb.append(this.account);
/* 202 */     sb.append("|");
/* 203 */     sb.append(this.cardNo);
/* 204 */     sb.append("|");
/* 205 */     sb.append(this.idType);
/* 206 */     sb.append("|");
/* 207 */     sb.append(this.idCard);
/* 208 */     sb.append("|");
/* 209 */     sb.append(this.mobileNo);
/* 210 */     sb.append("|");
/* 211 */     if (isMsg) {
/* 212 */       sb.append(this.msgCode);
/* 213 */       sb.append("|");
/*     */     }
/* 215 */     sb.append(key);
/* 216 */     System.out.println("CardPro sendMsgSignStr:" + sb.toString());
/* 217 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String proBindSignStr(String key)
/*     */   {
/* 222 */     StringBuilder sb = new StringBuilder();
/* 223 */     sb.append(this.version);
/* 224 */     sb.append("|");
/* 225 */     sb.append(this.mchntSsn);
/* 226 */     sb.append("|");
/* 227 */     sb.append(this.mchntCd);
/* 228 */     sb.append("|");
/* 229 */     sb.append(this.userId);
/* 230 */     sb.append("|");
/* 231 */     sb.append(this.account);
/* 232 */     sb.append("|");
/* 233 */     sb.append(this.cardNo);
/* 234 */     sb.append("|");
/* 235 */     sb.append(this.idType);
/* 236 */     sb.append("|");
/* 237 */     sb.append(this.idCard);
/* 238 */     sb.append("|");
/* 239 */     sb.append(this.mobileNo);
/* 240 */     sb.append("|");
/* 241 */     sb.append(this.msgCode);
/* 242 */     sb.append("|");
/* 243 */     sb.append(key);
/* 244 */     sb.append("|");
/* 245 */     sb.append(this.tradeDate);
/* 246 */     System.out.println("CardPro proBindSignStr:" + sb.toString());
/* 247 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String querySignStr(String key) {
/* 251 */     StringBuilder sb = new StringBuilder();
/* 252 */     sb.append(this.version);
/* 253 */     sb.append("|");
/* 254 */     sb.append(this.mchntCd);
/* 255 */     sb.append("|");
/* 256 */     sb.append(this.userId);
/* 257 */     sb.append("|");
/* 258 */     sb.append(key);
/* 259 */     System.out.println("CardPro querySignStr:" + sb.toString());
/* 260 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String newProPaySignStr(String key) {
/* 264 */     StringBuilder sb = new StringBuilder();
/* 265 */     sb.append(this.type);
/* 266 */     sb.append("|");
/* 267 */     sb.append(this.version);
/* 268 */     sb.append("|");
/* 269 */     sb.append(this.mchntCd);
/* 270 */     sb.append("|");
/* 271 */     sb.append(this.mchntOrderId);
/* 272 */     sb.append("|");
/* 273 */     sb.append(this.userId);
/* 274 */     sb.append("|");
/* 275 */     sb.append(this.protocolNo);
/* 276 */     sb.append("|");
/* 277 */     sb.append(this.amt);
/* 278 */     sb.append("|");
/* 279 */     sb.append(this.backUrl);
/* 280 */     sb.append("|");
/* 281 */     sb.append(this.userIp);
/* 282 */     sb.append("|");
/* 283 */     sb.append(key);
/* 284 */     System.out.println("newProPay sign:" + sb.toString());
/* 285 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String newProPayResutlQuerySignStr(String key) {
/* 289 */     StringBuilder sb = new StringBuilder();
/* 290 */     sb.append(this.version);
/* 291 */     sb.append("|");
/* 292 */     sb.append(this.mchntCd);
/* 293 */     sb.append("|");
/* 294 */     sb.append(this.mchntOrderId);
/* 295 */     sb.append("|");
/* 296 */     sb.append(key);
/* 297 */     System.out.println("proPayResult sign:" + sb.toString());
/* 298 */     return sb.toString();
/*     */   }
/*     */ }
