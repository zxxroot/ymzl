/*    */ package com.rongdu.cashloan.core.common.util.crypto.impl;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.security.InvalidAlgorithmParameterException;
/*    */ import java.security.InvalidKeyException;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.NoSuchPaddingException;
/*    */ import javax.crypto.spec.IvParameterSpec;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AESCryptoImpl
/*    */   extends AbstractCryptoImpl
/*    */ {
/* 23 */   public static final Logger logger = LoggerFactory.getLogger(AESCryptoImpl.class);
/*    */   
/*    */   private static final String algorithm = "AES";
/*    */   
/*    */   private static final String transformation = "AES/CBC/PKCS5Padding";
/*    */   
/* 29 */   private String key = "5A82fh-e390V.qw8";
/*    */   
/* 31 */   private String ivParameter = "0102030405060708";
/*    */   
/*    */   public void setKey(String key) {
/* 34 */     this.key = key;
/*    */   }
/*    */   
/*    */   public void setIvParameter(String ivParameter) {
/* 38 */     this.ivParameter = ivParameter;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 45 */   private static AESCryptoImpl defaultInstance = new AESCryptoImpl();
/*    */   
/*    */   public static AESCryptoImpl getDefault() {
/* 48 */     return defaultInstance;
/*    */   }
/*    */   
/*    */   protected Cipher getDecryptCipher()
/*    */   {
/* 53 */     Cipher cipher = null;
/*    */     try {
/* 55 */       SecretKeySpec secretKey = new SecretKeySpec(this.key.getBytes("UTF-8"), "AES");
/* 56 */       cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
/* 57 */       IvParameterSpec iv = new IvParameterSpec(this.ivParameter.getBytes());
/* 58 */       cipher.init(2, secretKey, iv);
/*    */     } catch (InvalidKeyException e) {
/* 60 */       logger.error(e.getMessage(), e);
/*    */     } catch (UnsupportedEncodingException e) {
/* 62 */       logger.error(e.getMessage(), e);
/*    */     } catch (NoSuchAlgorithmException e) {
/* 64 */       logger.error(e.getMessage(), e);
/*    */     } catch (NoSuchPaddingException e) {
/* 66 */       logger.error(e.getMessage(), e);
/*    */     } catch (InvalidAlgorithmParameterException e) {
/* 68 */       logger.error(e.getMessage(), e);
/*    */     }
/* 70 */     return cipher;
/*    */   }
/*    */   
/*    */   protected Cipher getEncryptCipher()
/*    */   {
/* 75 */     Cipher cipher = null;
/*    */     try {
/* 77 */       SecretKeySpec secretKey = new SecretKeySpec(this.key.getBytes("UTF-8"), "AES");
/* 78 */       cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
/* 79 */       IvParameterSpec iv = new IvParameterSpec(this.ivParameter.getBytes());
/* 80 */       cipher.init(1, secretKey, iv);
/*    */     } catch (InvalidKeyException e) {
/* 82 */       logger.error(e.getMessage(), e);
/*    */     } catch (UnsupportedEncodingException e) {
/* 84 */       logger.error(e.getMessage(), e);
/*    */     } catch (NoSuchAlgorithmException e) {
/* 86 */       logger.error(e.getMessage(), e);
/*    */     } catch (NoSuchPaddingException e) {
/* 88 */       logger.error(e.getMessage(), e);
/*    */     } catch (InvalidAlgorithmParameterException e) {
/* 90 */       logger.error(e.getMessage(), e);
/*    */     }
/* 92 */     return cipher;
/*    */   }
/*    */ }


/* crypto\impl\AESCryptoImpl.class

 */