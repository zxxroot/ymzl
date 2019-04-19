/*     */ package com.rongdu.cashloan.core.common.util.crypto.impl;
/*     */ 
/*     */

import com.rongdu.cashloan.core.common.util.Base32;
import com.rongdu.cashloan.core.common.util.crypto.Crypto;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;

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
/*     */ 
/*     */ 
/*     */ public abstract class AbstractCryptoImpl
/*     */   implements Crypto
/*     */ {
/*  22 */   public static final Logger logger = LoggerFactory.getLogger(AbstractCryptoImpl.class);
/*     */   
/*  24 */   private static final Crypto.Encoding DefaultEncoding = Crypto.Encoding.Base32;
/*     */   
/*     */   private static final String DefaultCharset = "UTF-8";
/*     */   private static final String Base64StringCharset = "ISO-8859-1";
/*     */   
/*     */   private class CryptoCipher
/*     */   {
/*     */     private Cipher encryptCipher;
/*     */     private Cipher decryptCipher;
/*     */     
/*     */     private CryptoCipher()
/*     */     {
/*  36 */       this.encryptCipher = AbstractCryptoImpl.this.getEncryptCipher();
/*  37 */       this.decryptCipher = AbstractCryptoImpl.this.getDecryptCipher();
/*     */     }
/*     */     
/*     */     public byte[] encrypt(byte[] bs) {
/*     */       try {
/*  42 */         return this.encryptCipher.doFinal(bs);
/*     */       } catch (IllegalBlockSizeException e) {
/*  44 */         AbstractCryptoImpl.logger.error(e.getMessage(), e);
/*     */       } catch (BadPaddingException e) {
/*  46 */         AbstractCryptoImpl.logger.error(e.getMessage(), e);
/*     */       }
/*  48 */       return bs;
/*     */     }
/*     */     
/*     */     public byte[] dectypt(byte[] bs) {
/*     */       try {
/*  53 */         return this.decryptCipher.doFinal(bs);
/*     */       } catch (IllegalBlockSizeException e) {
/*  55 */         AbstractCryptoImpl.logger.error(e.getMessage(), e);
/*     */       } catch (BadPaddingException e) {
/*  57 */         AbstractCryptoImpl.logger.error(e.getMessage(), e);
/*     */       }
/*  59 */       return bs;
/*     */     }
/*     */   }
/*     */   
/*  63 */   private ThreadLocal<CryptoCipher> local = new ThreadLocal();
/*     */   
/*     */   protected CryptoCipher getLocalCipher() {
/*  66 */     CryptoCipher cc = (CryptoCipher)this.local.get();
/*  67 */     if (cc == null) {
/*  68 */       cc = new CryptoCipher();
/*  69 */       this.local.set(cc);
/*     */     }
/*  71 */     return cc;
/*     */   }
/*     */   
/*     */ 
/*     */   protected abstract Cipher getEncryptCipher();
/*     */   
/*     */ 
/*     */   protected abstract Cipher getDecryptCipher();
/*     */   
/*     */ 
/*     */   public String dectypt(String s)
/*     */   {
/*  83 */     return dectypt(s, DefaultEncoding, "UTF-8");
/*     */   }
/*     */   
/*     */   public String dectypt(String s, Crypto.Encoding en) {
/*  87 */     return dectypt(s, en, "UTF-8");
/*     */   }
/*     */   
/*     */   public String dectypt(String s, String charset) {
/*  91 */     return dectypt(s, DefaultEncoding, charset);
/*     */   }
/*     */   
/*     */   public String dectypt(String s, Crypto.Encoding en, String charset) {
/*  95 */     if (s == null) {
/*  96 */       throw new NullPointerException("dectypt string can't be null");
/*     */     }
/*  98 */     if (en == null) {
/*  99 */       throw new NullPointerException("dectypt Encoding can't be null");
/*     */     }
/* 101 */     if (charset == null) {
/* 102 */       throw new NullPointerException("dectypt charset can't be null");
/*     */     }
/*     */     try {
/* 105 */       byte[] bs = en == Crypto.Encoding.Base32 ? Base32.decode(s) : 
/* 106 */         Base64.decodeBase64(s.getBytes("ISO-8859-1"));
/* 107 */       bs = dectypt(bs);
/* 108 */       return new String(bs, charset);
/*     */     } catch (UnsupportedEncodingException e) {
/* 110 */       logger.error(e.getMessage(), e);
/*     */     }
/* 112 */     return charset;
/*     */   }
/*     */   
/*     */   public String encrypt(String s) {
/* 116 */     return encrypt(s, DefaultEncoding, "UTF-8");
/*     */   }
/*     */   
/*     */   public String encrypt(String s, Crypto.Encoding en) {
/* 120 */     return encrypt(s, en, "UTF-8");
/*     */   }
/*     */   
/*     */   public String encrypt(String s, String charset) {
/* 124 */     return encrypt(s, DefaultEncoding, charset);
/*     */   }
/*     */   
/*     */   public String encrypt(String s, Crypto.Encoding en, String charset) {
/* 128 */     if (s == null) {
/* 129 */       throw new NullPointerException("encrypt string can't be null");
/*     */     }
/* 131 */     if (en == null) {
/* 132 */       throw new NullPointerException("encrypt Encoding can't be null");
/*     */     }
/* 134 */     if (charset == null) {
/* 135 */       throw new NullPointerException("encrypt charset can't be null");
/*     */     }
/*     */     try {
/* 138 */       byte[] bs = s.getBytes(charset);
/* 139 */       bs = encrypt(bs);
/* 140 */       return en == Crypto.Encoding.Base32 ? Base32.encode(bs) : new String(
/* 141 */         Base64.encodeBase64(bs), "ISO-8859-1");
/*     */     } catch (UnsupportedEncodingException e) {
/* 143 */       logger.error(e.getMessage(), e);
/*     */     }
/* 145 */     return charset;
/*     */   }
/*     */   
/*     */   public byte[] dectypt(byte[] bytes) {
/* 149 */     if (bytes == null) {
/* 150 */       throw new NullPointerException("dectypt bytes can't be null");
/*     */     }
/* 152 */     return getLocalCipher().dectypt(bytes);
/*     */   }
/*     */   
/*     */   public byte[] encrypt(byte[] bytes) {
/* 156 */     if (bytes == null) {
/* 157 */       throw new NullPointerException("encrypt bytes can't be null");
/*     */     }
/* 159 */     return getLocalCipher().encrypt(bytes);
/*     */   }
/*     */ }


/* crypto\impl\AbstractCryptoImpl.class

 */