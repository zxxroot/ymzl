/*     */ package com.cashloan.cl.model.pay.lianlian.util;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.base64.Base64Util;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.security.InvalidKeyException;
/*     */ import java.security.KeyFactory;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.PublicKey;
/*     */ import java.security.Signature;
/*     */ import java.security.SignatureException;
/*     */ import java.security.spec.InvalidKeySpecException;
/*     */ import java.security.spec.PKCS8EncodedKeySpec;
/*     */ import java.security.spec.X509EncodedKeySpec;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SignUtil
/*     */ {
/*  29 */   private static Logger logger = Logger.getLogger(SignUtil.class);
/*     */   private static SignUtil instance;
/*     */   
/*     */   public static SignUtil getInstance()
/*     */   {
/*  34 */     if (instance == null)
/*  35 */       return new SignUtil();
/*  36 */     return instance;
/*     */   }
/*     */   
/*     */   public static String sign(String priKey, String signStr)
/*     */   {
/*  41 */     byte[] signed = null;
/*     */     try
/*     */     {
/*  44 */       PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Util.base64DecodeToArray(priKey));
/*     */       
/*  46 */       KeyFactory keyf = KeyFactory.getInstance("RSA");
/*  47 */       PrivateKey myprikey = keyf.generatePrivate(priPKCS8);
/*     */       
/*  49 */       Signature signet = Signature.getInstance("MD5withRSA");
/*  50 */       signet.initSign(myprikey);
/*  51 */       signet.update(signStr.getBytes("UTF-8"));
/*  52 */       signed = signet.sign();
/*     */     }
/*     */     catch (InvalidKeyException|NoSuchAlgorithmException|InvalidKeySpecException|SignatureException|UnsupportedEncodingException e)
/*     */     {
/*  56 */       logger.error("签名失败," + e.getMessage(), e);
/*     */     }
/*     */     
/*     */ 
/*  60 */     return new String(
/*  61 */       Base64.encodeBase64(signed));
/*     */   }
/*     */   
/*     */   public static boolean checksign(String pubKeyStr, String oidStr, String signedStr)
/*     */   {
/*     */     try {
/*  67 */       X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(
/*  68 */         Base64Util.base64DecodeToArray(pubKeyStr));
/*  69 */       KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/*  70 */       PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);
/*  71 */       byte[] signed = Base64Util.base64DecodeToArray(signedStr);
/*  72 */       Signature signetcheck = Signature.getInstance("MD5withRSA");
/*  73 */       signetcheck.initVerify(pubKey);
/*  74 */       signetcheck.update(oidStr.getBytes("UTF-8"));
/*  75 */       return signetcheck.verify(signed);
/*     */     }
/*     */     catch (InvalidKeyException|NoSuchAlgorithmException|InvalidKeySpecException|SignatureException|UnsupportedEncodingException e)
/*     */     {
/*  79 */       logger.error("签名失败," + e.getMessage(), e);
/*     */     }
/*     */     
/*  82 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String genRSASign(String jsonStr)
/*     */   {
/*  89 */     String sign_src = genSignData(jsonStr);
/*     */     
/*  91 */     JSONObject reqObj = JSON.parseObject(jsonStr);
/*  92 */     logger.debug("商户[" + reqObj.getString("oid_partner") + "]待签名原串：" + sign_src);
/*     */     
/*  94 */     return sign(Global.getValue("lianlian_private_key"), sign_src);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String genSignData(String jsonStr)
/*     */   {
/* 104 */     JSONObject jsonObject = JSON.parseObject(jsonStr);
/* 105 */     StringBuilder content = new StringBuilder();
/*     */     
/*     */ 
/* 108 */     List<String> keys = new ArrayList(jsonObject.keySet());
/* 109 */     Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
/* 110 */     for (int i = 0; i < keys.size(); i++) {
/* 111 */       String key = (String)keys.get(i);
/*     */       
/* 113 */       if (!"sign".equals(key))
/*     */       {
/*     */ 
/* 116 */         String value = jsonObject.getString(key);
/*     */         
/* 118 */         if (!StringUtils.isEmpty(value))
/*     */         {
/*     */ 
/* 121 */           content.append((i == 0 ? "" : "&") + key + "=" + value); }
/*     */       }
/*     */     }
/* 124 */     String signSrc = content.toString();
/* 125 */     if (signSrc.startsWith("&")) {
/* 126 */       signSrc = signSrc.replaceFirst("&", "");
/*     */     }
/* 128 */     return signSrc;
/*     */   }
/*     */ }
