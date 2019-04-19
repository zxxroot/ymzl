/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.net.URLDecoder;
/*     */ import java.net.URLEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Base64
/*     */ {
/*  12 */   private static final char[] chars64 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 
/*  13 */     'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
/*  14 */     'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', 
/*  15 */     '5', '6', '7', '8', '9', '+', '/' };
/*     */   
/*     */ 
/*  18 */   private static final int[] ints64 = new int[''];
/*     */   
/*  20 */   static { for (int i = 0; i < 64; i++) {
/*  21 */       ints64[chars64[i]] = i;
/*     */     }
/*     */   }
/*     */   
/*     */   public static String encodeStr(String newStr)
/*     */   {
/*  27 */     if ((newStr == null) || (newStr.length() == 0))
/*  28 */       return null;
/*  29 */     String encoded = encode(newStr.getBytes());
/*  30 */     if ((encoded == null) || (encoded.length() == 0)) {
/*  31 */       return null;
/*     */     }
/*  33 */     return URLEncoder.encode(encoded);
/*     */   }
/*     */   
/*     */ 
/*     */   public static String decodeStr(String newStr)
/*     */   {
/*  39 */     if ((newStr == null) || (newStr.length() == 0))
/*  40 */       return null;
/*  41 */     String urlDecode = URLDecoder.decode(newStr);
/*     */     
/*  43 */     byte[] decode = decode(urlDecode);
/*  44 */     if ((decode == null) || (decode.length == 0)) {
/*  45 */       return null;
/*     */     }
/*  47 */     return new String(decode);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String encode(byte[] unencoded)
/*     */   {
/*  55 */     if ((unencoded == null) || (unencoded.length == 0)) {
/*  56 */       return null;
/*     */     }
/*  58 */     ByteArrayOutputStream out = new ByteArrayOutputStream((int)(unencoded.length * 1.37D));
/*  59 */     int byteCount = 0;
/*  60 */     int carryOver = 0;
/*     */     
/*  62 */     for (int i = 0; i < unencoded.length; i++) {
/*  63 */       int bc = byteCount % 3;
/*  64 */       byte b = unencoded[i];
/*     */       
/*     */ 
/*     */ 
/*  68 */       if (bc == 0) {
/*  69 */         int lookup = b >> 2 & 0x3F;
/*  70 */         carryOver = b & 0x3;
/*  71 */         out.write(chars64[lookup]);
/*  72 */       } else if (bc == 1)
/*     */       {
/*     */ 
/*  75 */         int lookup = carryOver << 4 | b >> 4 & 0xF;
/*  76 */         carryOver = b & 0xF;
/*  77 */         out.write(chars64[lookup]);
/*  78 */       } else if (bc == 2)
/*     */       {
/*     */ 
/*  81 */         int lookup = carryOver << 2 | b >> 6 & 0x3;
/*  82 */         out.write(chars64[lookup]);
/*     */         
/*  84 */         lookup = b & 0x3F;
/*  85 */         out.write(chars64[lookup]);
/*  86 */         carryOver = 0;
/*     */       }
/*  88 */       byteCount++;
/*     */     }
/*     */     
/*  91 */     if (byteCount % 3 == 1) {
/*  92 */       int lookup = carryOver << 4 & 0xF0;
/*  93 */       out.write(chars64[lookup]);
/*  94 */       out.write(61);
/*  95 */       out.write(61);
/*  96 */     } else if (byteCount % 3 == 2) {
/*  97 */       int lookup = carryOver << 2 & 0x3C;
/*  98 */       out.write(chars64[lookup]);
/*  99 */       out.write(61);
/*     */     }
/* 101 */     return out.toString();
/*     */   }
/*     */   
/*     */   public static final byte[] decode(String encoded)
/*     */   {
/* 106 */     if ((encoded == null) || (encoded.length() == 0)) {
/* 107 */       return null;
/*     */     }
/* 109 */     byte[] bytes = encoded.getBytes();
/*     */     
/* 111 */     ByteArrayOutputStream out = new ByteArrayOutputStream((int)(bytes.length * 0.67D));
/* 112 */     int byteCount = 0;
/* 113 */     int carryOver = 0;
/*     */     
/* 115 */     for (int i = 0; i < bytes.length; i++) {
/* 116 */       int ch = bytes[i];
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */       if (ch == 61) {
/*     */         break;
/*     */       }
/*     */       
/* 127 */       int newbits = ints64[ch];
/*     */       
/* 129 */       int bc = byteCount % 4;
/* 130 */       if (bc == 0)
/*     */       {
/* 132 */         carryOver = newbits & 0x3F;
/* 133 */       } else if (bc == 1)
/*     */       {
/* 135 */         int data = (carryOver << 2) + (newbits >> 4 & 0x3);
/* 136 */         out.write(data);
/* 137 */         carryOver = newbits & 0xF;
/* 138 */       } else if (bc == 2)
/*     */       {
/*     */ 
/* 141 */         int data = (carryOver << 4) + (newbits >> 2 & 0xF);
/* 142 */         out.write(data);
/* 143 */         carryOver = newbits & 0x3;
/* 144 */       } else if (bc == 3)
/*     */       {
/* 146 */         int data = (carryOver << 6) + (newbits & 0x3F);
/* 147 */         out.write(data);
/* 148 */         carryOver = 0;
/*     */       }
/* 150 */       byteCount++;
/*     */     }
/*     */     
/* 153 */     return out.toByteArray();
/*     */   }
/*     */ }
