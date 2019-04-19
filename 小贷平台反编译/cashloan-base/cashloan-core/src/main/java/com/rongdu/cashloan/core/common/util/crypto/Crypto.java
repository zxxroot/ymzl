/*   */ package com.rongdu.cashloan.core.common.util.crypto;
/*   */ 
/*   */ public abstract interface Crypto {
/*   */   public abstract String encrypt(String paramString);
/*   */   
/*   */   public abstract String encrypt(String paramString, Encoding paramEncoding);
/*   */   
/*   */   public static enum Encoding {
/* 9 */     Base64,  Base32;
/*   */   }
/*   */   
/*   */   public abstract String encrypt(String paramString1, String paramString2);
/*   */   
/*   */   public abstract String encrypt(String paramString1, Encoding paramEncoding, String paramString2);
/*   */   
/*   */   public abstract String dectypt(String paramString);
/*   */   
/*   */   public abstract String dectypt(String paramString, Encoding paramEncoding);
/*   */   
/*   */   public abstract String dectypt(String paramString1, String paramString2);
/*   */   
/*   */   public abstract String dectypt(String paramString1, Encoding paramEncoding, String paramString2);
/*   */   
/*   */   public abstract byte[] encrypt(byte[] paramArrayOfByte);
/*   */   
/*   */   public abstract byte[] dectypt(byte[] paramArrayOfByte);
/*   */ }


/* crypto\Crypto.class

 */