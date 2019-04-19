/*    */ package com.rongdu.cashloan.core.common.util.crypto.impl;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.security.InvalidKeyException;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.NoSuchPaddingException;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlowfishCryptoImpl
/*    */   extends AbstractCryptoImpl
/*    */ {
/* 19 */   public static final Logger logger = LoggerFactory.getLogger(BlowfishCryptoImpl.class);
/*    */   
/*    */   private static final String algorithm = "Blowfish";
/*    */   
/*    */   private static final String transformation = "Blowfish/ECB/PKCS5Padding";
/*    */   
/* 25 */   private String key = "1Ay6qVwz5ic-=8egkfsdt9f12dalfdz0kHgYuy1X";
/*    */   
/*    */   public String getKey() {
/* 28 */     return this.key;
/*    */   }
/*    */   
/*    */   public void setKey(String key) {
/* 32 */     this.key = key;
/*    */   }
/*    */   
/* 35 */   private static BlowfishCryptoImpl defaultInstance = new BlowfishCryptoImpl();
/*    */   
/*    */   public static BlowfishCryptoImpl getDefault() {
/* 38 */     return defaultInstance;
/*    */   }
/*    */   
/*    */   protected Cipher getDecryptCipher()
/*    */   {
/* 43 */     Cipher cipher = null;
/*    */     try {
/* 45 */       SecretKeySpec secretKey = new SecretKeySpec(this.key.getBytes("UTF-8"), "Blowfish");
/* 46 */       cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
/* 47 */       cipher.init(2, secretKey);
/*    */     } catch (InvalidKeyException e) {
/* 49 */       logger.error(e.getMessage(), e);
/*    */     } catch (UnsupportedEncodingException e) {
/* 51 */       logger.error(e.getMessage(), e);
/*    */     } catch (NoSuchAlgorithmException e) {
/* 53 */       logger.error(e.getMessage(), e);
/*    */     } catch (NoSuchPaddingException e) {
/* 55 */       logger.error(e.getMessage(), e);
/*    */     }
/* 57 */     return cipher;
/*    */   }
/*    */   
/*    */   protected Cipher getEncryptCipher()
/*    */   {
/* 62 */     Cipher cipher = null;
/*    */     try {
/* 64 */       SecretKeySpec secretKey = new SecretKeySpec(this.key.getBytes("UTF-8"), "Blowfish");
/* 65 */       cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
/* 66 */       cipher.init(1, secretKey);
/*    */     } catch (InvalidKeyException e) {
/* 68 */       logger.error(e.getMessage(), e);
/*    */     } catch (UnsupportedEncodingException e) {
/* 70 */       logger.error(e.getMessage(), e);
/*    */     } catch (NoSuchAlgorithmException e) {
/* 72 */       logger.error(e.getMessage(), e);
/*    */     } catch (NoSuchPaddingException e) {
/* 74 */       logger.error(e.getMessage(), e);
/*    */     }
/* 76 */     return cipher;
/*    */   }
/*    */ }


/* crypto\impl\BlowfishCryptoImpl.class

 */