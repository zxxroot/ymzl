/*     */ package com.rongdu.cashloan.core.common.util;
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
/*     */ public final class Base32
/*     */ {
/*  14 */   private static final char[] base32Chars = { 'a', 'b', 'c', 'd', 'e', 'f', 
/*  15 */     'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
/*  16 */     't', 'u', 'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7' };
/*     */   
/*  18 */   private static final int[] base32Lookup = { 255, 255, 26, 27, 28, 
/*  19 */     29, 30, 31, 
/*  20 */     255, 255, 255, 255, 255, 255, 255, 255, 
/*     */     
/*     */ 
/*  23 */     255, 0, 1, 2, 3, 4, 5, 6, 
/*     */     
/*     */ 
/*  26 */     7, 8, 9, 10, 11, 12, 13, 14, 
/*     */     
/*     */ 
/*  29 */     15, 16, 17, 18, 19, 20, 21, 22, 
/*     */     
/*     */ 
/*  32 */     23, 24, 25, 255, 255, 255, 255, 255, 
/*     */     
/*     */ 
/*  35 */     255, 0, 1, 2, 3, 4, 5, 6, 
/*     */     
/*     */ 
/*  38 */     7, 8, 9, 10, 11, 12, 13, 14, 
/*     */     
/*     */ 
/*  41 */     15, 16, 17, 18, 19, 20, 21, 22, 
/*     */     
/*     */ 
/*  44 */     23, 24, 25, 255, 255, 255, 255, 255 };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  49 */   private static final int base32LookupLength = base32Lookup.length;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String encode(byte[] bytes)
/*     */   {
/*  60 */     if ((bytes == null) || (bytes.length == 0)) {
/*  61 */       return null;
/*     */     }
/*  63 */     int i = 0;
/*  64 */     int index = 0;
/*     */     
/*     */ 
/*     */ 
/*  68 */     StringBuilder base32 = new StringBuilder((bytes.length + 7) * 8 / 5);
/*     */     
/*  70 */     while (i < bytes.length) {
/*  71 */       int currByte = bytes[i] >= 0 ? bytes[i] : bytes[i] + 256;
/*     */       
/*     */       int digit;
/*  74 */       if (index > 3) { int nextByte;
/*  75 */         if (i + 1 < bytes.length) {
/*  76 */           nextByte = bytes[(i + 1)] >= 0 ? bytes[(i + 1)] : 
/*  77 */             bytes[(i + 1)] + 256;
/*     */         } else {
/*  79 */           nextByte = 0;
/*     */         }
/*     */         
/*  82 */        digit = currByte & 255 >> index;
/*  83 */         index = (index + 5) % 8;
/*  84 */         digit <<= index;
/*  85 */         digit |= nextByte >> 8 - index;
/*  86 */         i++;
/*     */       } else {
/*  88 */         digit = currByte >> 8 - (index + 5) & 0x1F;
/*  89 */         index = (index + 5) % 8;
/*  90 */         if (index == 0)
/*  91 */           i++;
/*     */       }
/*  93 */       base32.append(base32Chars[digit]);
/*     */     }
/*     */     
/*  96 */     return base32.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static byte[] decode(String base32)
/*     */   {
/* 106 */     if ((base32 == null) || (base32.length() == 0)) {
/* 107 */       return null;
/*     */     }
/* 109 */     int slength = base32.length();
/* 110 */     byte[] bytes = new byte[slength * 5 / 8];
/*     */     
/* 112 */     int i = 0;int index = 0; for (int offset = 0; i < slength; i++) {
/* 113 */       int lookup = base32.charAt(i) - '0';
/*     */       
/*     */ 
/* 116 */       if ((lookup >= 0) && (lookup < base32LookupLength))
/*     */       {
/*     */ 
/*     */ 
/* 120 */         int digit = base32Lookup[lookup];
/*     */         
/*     */ 
/* 123 */         if (digit != 255)
/*     */         {
/*     */ 
/*     */ 
/* 127 */           if (index <= 3) {
/* 128 */             index = (index + 5) % 8;
/* 129 */             if (index == 0) {
/* 130 */               int tmp101_99 = offset; byte[] tmp101_97 = bytes;tmp101_97[tmp101_99] = ((byte)(tmp101_97[tmp101_99] | digit));
/* 131 */               offset++;
/* 132 */               if (offset >= bytes.length)
/*     */                 break;
/*     */             } else {
/* 135 */               int tmp126_124 = offset; byte[] tmp126_122 = bytes;tmp126_122[tmp126_124] = ((byte)(tmp126_122[tmp126_124] | digit << 8 - index));
/*     */             }
/*     */           } else {
/* 138 */             index = (index + 5) % 8; int 
/* 139 */               tmp152_150 = offset; byte[] tmp152_148 = bytes;tmp152_148[tmp152_150] = ((byte)(tmp152_148[tmp152_150] | digit >>> index));
/* 140 */             offset++;
/*     */             
/* 142 */             if (offset >= bytes.length) {
/*     */               break;
/*     */             }
/* 145 */             int tmp179_177 = offset; byte[] tmp179_175 = bytes;tmp179_175[tmp179_177] = ((byte)(tmp179_175[tmp179_177] | digit << 8 - index));
/*     */           } }
/*     */       } }
/* 148 */     return bytes;
/*     */   }
/*     */ }
