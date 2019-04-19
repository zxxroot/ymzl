/*    */ package com.cashloan.cl.model.pay.lianlian.util;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ public class PaySecurity
/*    */ {
/*    */   public static String encrypt(String plaintext, String public_key) {
/*  8 */     String hmack_key = genLetterDigitRandom(32);
/*  9 */     String version = "lianpay1_0_1";
/* 10 */     String aes_key = genLetterDigitRandom(32);
/* 11 */     String nonce = genLetterDigitRandom(8);
/* 12 */     return PayEncrypt.lianlianpayEncrypt(plaintext, public_key, 
/* 13 */       hmack_key, version, aes_key, nonce);
/*    */   }
/*    */   
/*    */   public static String decrypt(String ciphertext, String private_key)
/*    */   {
/* 18 */     if (isNull(ciphertext)) {
/* 19 */       return "";
/*    */     }
/* 21 */     String[] ciphertextArry = ciphertext.split("\\$");
/* 22 */     String base64_encrypted_aes_key = ciphertextArry.length > 2 ? ciphertextArry[2] : 
/* 23 */       "";
/* 24 */     String base64_nonce = ciphertextArry.length > 3 ? ciphertextArry[3] : "";
/* 25 */     String base64_ciphertext = ciphertextArry.length > 4 ? ciphertextArry[4] : "";
/* 26 */     return PayEncrypt.lianlianpayDecrypt(base64_ciphertext, base64_encrypted_aes_key, base64_nonce, private_key);
/*    */   }
/*    */   
/*    */   public static String genLetterDigitRandom(int size) {
/* 30 */     StringBuilder allLetterDigit = new StringBuilder(
/* 31 */       "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
/* 32 */     Random random = new Random();
/*    */     
/* 34 */     StringBuilder randomSb = new StringBuilder("");
/* 35 */     for (int i = 0; i < size; i++) {
/* 36 */       randomSb.append(allLetterDigit.charAt(random.nextInt(allLetterDigit.length())));
/*    */     }
/* 38 */     return randomSb.toString();
/*    */   }
/*    */   
/*    */   public static boolean isNull(String str) {
/* 42 */     if ((str == null) || (str.equalsIgnoreCase("NULL")) || (str.equals(""))) {
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */ }
