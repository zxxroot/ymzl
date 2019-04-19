/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.alipay.api.AlipayClient;
/*     */ import com.alipay.api.DefaultAlipayClient;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
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
/*     */ public class BaseAliPayModel
/*     */ {
/*  23 */   private static final Logger logger = LoggerFactory.getLogger(BaseAliPayModel.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String app_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String service;
/*     */   
/*     */ 
/*     */ 
/*     */   private String public_key;
/*     */   
/*     */ 
/*     */ 
/*     */   private String private_key;
/*     */   
/*     */ 
/*     */ 
/*     */   private String subUrl;
/*     */   
/*     */ 
/*     */ 
/*     */   private String charset;
/*     */   
/*     */ 
/*     */ 
/*     */   private String format;
/*     */   
/*     */ 
/*     */ 
/*     */   private String sign_type;
/*     */   
/*     */ 
/*     */ 
/*     */   private String sign;
/*     */   
/*     */ 
/*     */ 
/*     */   private String timestamp;
/*     */   
/*     */ 
/*     */ 
/*     */   private String version;
/*     */   
/*     */ 
/*     */ 
/*     */   private String biz_content;
/*     */   
/*     */ 
/*     */ 
/*     */   private String notify_url;
/*     */   
/*     */ 
/*     */ 
/*     */   public String code;
/*     */   
/*     */ 
/*     */ 
/*     */   public String msg;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BaseAliPayModel()
/*     */   {
/*  92 */     setVersion("1.0");
/*  93 */     setFormat("json");
/*  94 */     setCharset("GBK");
/*  95 */     setSign_type("RSA2");
/*  96 */     setApp_id(Global.getValue("alipay_app_id"));
/*  97 */     setSubUrl(Global.getValue("alipay_app_apihost"));
/*  98 */     setPrivate_key(Global.getValue("alipay_private_key"));
/*  99 */     setPublic_key(Global.getValue("alipay_public_key"));
/*     */   }
/*     */   
/*     */   public String getFormat()
/*     */   {
/* 104 */     return this.format;
/*     */   }
/*     */   
/*     */   public void setFormat(String format) {
/* 108 */     this.format = format;
/*     */   }
/*     */   
/*     */   public String getApp_id() {
/* 112 */     return this.app_id;
/*     */   }
/*     */   
/*     */   public void setApp_id(String app_id) {
/* 116 */     this.app_id = app_id;
/*     */   }
/*     */   
/*     */   public String getService() {
/* 120 */     return this.service;
/*     */   }
/*     */   
/*     */   public void setService(String service) {
/* 124 */     this.service = service;
/*     */   }
/*     */   
/*     */   public String getSubUrl() {
/* 128 */     return this.subUrl;
/*     */   }
/*     */   
/*     */   public void setSubUrl(String subUrl) {
/* 132 */     this.subUrl = subUrl;
/*     */   }
/*     */   
/*     */   public String getCharset() {
/* 136 */     return this.charset;
/*     */   }
/*     */   
/*     */   public void setCharset(String charset) {
/* 140 */     this.charset = charset;
/*     */   }
/*     */   
/*     */   public String getSign_type() {
/* 144 */     return this.sign_type;
/*     */   }
/*     */   
/*     */   public void setSign_type(String sign_type) {
/* 148 */     this.sign_type = sign_type;
/*     */   }
/*     */   
/*     */   public String getSign() {
/* 152 */     return this.sign;
/*     */   }
/*     */   
/*     */   public void setSign(String sign) {
/* 156 */     this.sign = sign;
/*     */   }
/*     */   
/*     */   public String getTimestamp() {
/* 160 */     return this.timestamp;
/*     */   }
/*     */   
/*     */   public void setTimestamp(String timestamp) {
/* 164 */     this.timestamp = timestamp;
/*     */   }
/*     */   
/*     */   public String getVersion() {
/* 168 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(String version) {
/* 172 */     this.version = version;
/*     */   }
/*     */   
/*     */   public String getBiz_content() {
/* 176 */     return this.biz_content;
/*     */   }
/*     */   
/*     */   public void setBiz_content(String biz_content) {
/* 180 */     this.biz_content = biz_content;
/*     */   }
/*     */   
/*     */   public String getNotify_url() {
/* 184 */     return this.notify_url;
/*     */   }
/*     */   
/*     */   public void setNotify_url(String notify_url) {
/* 188 */     this.notify_url = notify_url;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 192 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 196 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getMsg() {
/* 200 */     return this.msg;
/*     */   }
/*     */   
/*     */   public void setMsg(String msg) {
/* 204 */     this.msg = msg;
/*     */   }
/*     */   
/*     */   public String getPublic_key() {
/* 208 */     return this.public_key;
/*     */   }
/*     */   
/*     */   public void setPublic_key(String public_key) {
/* 212 */     this.public_key = public_key;
/*     */   }
/*     */   
/*     */   public String getPrivate_key() {
/* 216 */     return this.private_key;
/*     */   }
/*     */   
/*     */   public void setPrivate_key(String private_key) {
/* 220 */     this.private_key = private_key;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AlipayClient defaultAlipayClient(BaseAliPayModel model)
/*     */   {
/* 230 */     AlipayClient alipayClient = new DefaultAlipayClient(model.getSubUrl(), model.getApp_id(), model.getPrivate_key(), model.getFormat(), model.getCharset(), model.getPublic_key(), model.getSign_type());
/* 231 */     return alipayClient;
/*     */   }
/*     */ }
