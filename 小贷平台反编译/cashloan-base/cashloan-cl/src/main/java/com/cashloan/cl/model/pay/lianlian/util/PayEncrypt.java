/*     */ package com.cashloan.cl.model.pay.lianlian.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.security.InvalidAlgorithmParameterException;
/*     */ import java.security.InvalidKeyException;
/*     */ import java.security.KeyFactory;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.PublicKey;
/*     */ import java.security.spec.InvalidKeySpecException;
/*     */ import java.security.spec.PKCS8EncodedKeySpec;
/*     */ import java.security.spec.X509EncodedKeySpec;
/*     */ import javax.crypto.BadPaddingException;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.IllegalBlockSizeException;
/*     */ import javax.crypto.Mac;
/*     */ import javax.crypto.NoSuchPaddingException;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.spec.IvParameterSpec;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import sun.misc.BASE64Decoder;
/*     */ import sun.misc.BASE64Encoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PayEncrypt
/*     */ {
/*  32 */   public static final Logger logger = LoggerFactory.getLogger(PayEncrypt.class);
/*     */   
/*     */ 
/*     */   public static String rsaEncrypt(String source, String public_key)
/*     */     throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
/*     */   {
/*  38 */     BASE64Decoder b64d = new BASE64Decoder();
/*  39 */     byte[] keyByte = b64d.decodeBuffer(public_key);
/*  40 */     X509EncodedKeySpec x509ek = new X509EncodedKeySpec(keyByte);
/*  41 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/*  42 */     PublicKey publicKey = keyFactory.generatePublic(x509ek);
/*     */     
/*  44 */     Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
/*  45 */     cipher.init(1, publicKey);
/*  46 */     byte[] sbt = source.getBytes("UTF-8");
/*  47 */     byte[] epByte = cipher.doFinal(sbt);
/*  48 */     BASE64Encoder encoder = new BASE64Encoder();
/*  49 */     String epStr = encoder.encode(epByte);
/*  50 */     return epStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static byte[] rsaDecrypt(String cryptograph, String private_key)
/*     */     throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
/*     */   {
/*  58 */     BASE64Decoder b64d = new BASE64Decoder();
/*  59 */     byte[] keyByte = b64d.decodeBuffer(private_key);
/*  60 */     PKCS8EncodedKeySpec s8ek = new PKCS8EncodedKeySpec(keyByte);
/*  61 */     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/*  62 */     PrivateKey privateKey = keyFactory.generatePrivate(s8ek);
/*     */     
/*  64 */     Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
/*  65 */     cipher.init(2, privateKey);
/*  66 */     BASE64Decoder decoder = new BASE64Decoder();
/*  67 */     byte[] b1 = decoder.decodeBuffer(cryptograph);
/*     */     
/*  69 */     byte[] b = cipher.doFinal(b1);
/*  70 */     return b;
/*     */   }
/*     */   
/*     */ 
/*     */   public static String aesEncrypt(byte[] msgbt, byte[] aesKey, byte[] nonce)
/*     */     throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
/*     */   {
/*  77 */     SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey, "AES");
/*  78 */     Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
/*     */     
/*  80 */     IvParameterSpec ips = createCtrIv(nonce);
/*     */     
/*  82 */     cipher.init(1, secretKeySpec, ips);
/*  83 */     byte[] epByte = cipher.doFinal(msgbt);
/*  84 */     BASE64Encoder encoder = new BASE64Encoder();
/*  85 */     String epStr = encoder.encode(epByte);
/*  86 */     return epStr;
/*     */   }
/*     */   
/*     */ 
/*     */   public static String aesDecrypt(String msgbt, byte[] aesKey, byte[] iv)
/*     */     throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, IllegalBlockSizeException, BadPaddingException
/*     */   {
/*  93 */     SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey, "AES");
/*  94 */     Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
/*  95 */     IvParameterSpec ips = createCtrIv(iv);
/*     */     
/*  97 */     cipher.init(2, secretKeySpec, ips);
/*  98 */     BASE64Decoder decoder = new BASE64Decoder();
/*  99 */     byte[] b1 = decoder.decodeBuffer(msgbt);
/*     */     
/* 101 */     byte[] b = cipher.doFinal(b1);
/* 102 */     return new String(b, "UTF-8");
/*     */   }
/*     */   
/*     */   private static IvParameterSpec createCtrIv(byte[] nonce) {
/* 106 */     byte[] counter = { 0, 0, 0, 0, 0, 0, 0, 1 };
/* 107 */     byte[] output = new byte[nonce.length + counter.length];
/* 108 */     for (int i = 0; i < nonce.length; i++) {
/* 109 */       output[i] = nonce[i];
/*     */     }
/* 111 */     for (int i = 0; i < counter.length; i++) {
/* 112 */       output[(i + nonce.length)] = counter[i];
/*     */     }
/* 114 */     return new IvParameterSpec(output);
/*     */   }
/*     */   
/*     */   public static byte[] encodeHmacSHA256(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException
/*     */   {
/* 119 */     SecretKey secretKey = new SecretKeySpec(key, "HmacSHA256");
/* 120 */     Mac mac = Mac.getInstance(secretKey.getAlgorithm());
/* 121 */     mac.init(secretKey);
/* 122 */     byte[] digest = mac.doFinal(data);
/* 123 */     return digest;
/*     */   }
/*     */   
/*     */   public static String lianlianpayDecrypt(String base64_ciphertext, String base64_encrypted_aes_key, String base64_nonce, String trader_pri_key)
/*     */   {
/*     */     try
/*     */     {
/* 130 */       byte[] aes_key = rsaDecrypt(base64_encrypted_aes_key, trader_pri_key);
/* 131 */       BASE64Decoder decoder = new BASE64Decoder();
/* 132 */       byte[] nonce = decoder.decodeBuffer(base64_nonce);
/* 133 */       return aesDecrypt(base64_ciphertext, aes_key, nonce);
/*     */     } catch (Exception e) {
/* 135 */       logger.error(e.getMessage(), e);
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */   
/*     */   public static String lianlianpayEncrypt(String req, String public_key, String hmack_key, String version, String aes_key, String nonce)
/*     */   {
/*     */     try {
/* 143 */       BASE64Encoder encoder = new BASE64Encoder();
/* 144 */       String B64hmack_key = rsaEncrypt(hmack_key, public_key);
/* 145 */       String B64aes_key = rsaEncrypt(aes_key, public_key);
/* 146 */       String B64nonce = encoder.encode(nonce.getBytes());
/* 147 */       String encry = aesEncrypt(req.getBytes("UTF-8"), aes_key.getBytes(), nonce.getBytes());
/* 148 */       String message = B64nonce + "$" + encry;
/* 149 */       byte[] sign = encodeHmacSHA256(message.getBytes(), hmack_key.getBytes());
/* 150 */       String B64sign = encoder.encode(sign);
/*     */       
/* 152 */       return version + "$" + B64hmack_key + "$" + B64aes_key + "$" + 
/* 153 */         B64nonce + "$" + encry + "$" + B64sign;
/*     */     } catch (Exception e) {
/* 155 */       logger.error(e.getMessage(), e);
/*     */     }
/* 157 */     return null;
/*     */   }
/*     */ }
