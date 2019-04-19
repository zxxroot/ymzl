/*    */ package com.cashloan.cl.utils;
/*    */ 
/*    */ import java.nio.charset.Charset;
/*    */ import java.security.MessageDigest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MD5Utils
/*    */ {
/* 13 */   private static char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*    */   
/*    */   public static final String MD5Encrpytion(String source) {
/*    */     try {
/* 17 */       byte[] strTemp = source.getBytes(Charset.forName("UTF-8"));
/* 18 */       MessageDigest mdTemp = MessageDigest.getInstance("MD5");
/* 19 */       mdTemp.update(strTemp);
/* 20 */       byte[] md = mdTemp.digest();
/* 21 */       int j = md.length;
/* 22 */       char[] str = new char[j * 2];
/* 23 */       int k = 0;
/* 24 */       for (int i = 0; i < j; i++) {
/* 25 */         byte byte0 = md[i];
/* 26 */         str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
/* 27 */         str[(k++)] = hexDigits[(byte0 & 0xF)];
/*    */       }
/* 29 */       for (int m = 0; m < str.length; m++) {
/* 30 */         if ((str[m] >= 'a') && (str[m] <= 'z')) {
/* 31 */           str[m] = ((char)(str[m] - ' '));
/*    */         }
/*    */       }
/* 34 */       return new String(str);
/*    */     }
/*    */     catch (Exception localException) {}
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public static final String MD5Encrpytion(byte[] source) {
/*    */     try {
/* 42 */       MessageDigest mdTemp = MessageDigest.getInstance("MD5");
/* 43 */       mdTemp.update(source);
/* 44 */       byte[] md = mdTemp.digest();
/* 45 */       int j = md.length;
/* 46 */       char[] str = new char[j * 2];
/* 47 */       int k = 0;
/* 48 */       for (int i = 0; i < j; i++) {
/* 49 */         byte byte0 = md[i];
/* 50 */         str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
/* 51 */         str[(k++)] = hexDigits[(byte0 & 0xF)];
/*    */       }
/* 53 */       for (int m = 0; m < str.length; m++) {
/* 54 */         if ((str[m] >= 'a') && (str[m] <= 'z')) {
/* 55 */           str[m] = ((char)(str[m] - ' '));
/*    */         }
/*    */       }
/* 58 */       return new String(str);
/*    */     }
/*    */     catch (Exception localException) {}
/* 61 */     return null;
/*    */   }
/*    */ }
