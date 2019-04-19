/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import java.util.Random;

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
/*     */ public class RC4
/*     */ {
/*     */   public static void main(String[] args)
/*     */   {
/*  23 */     for (int i = 0; i < 10000; i++) {
/*  24 */       System.out.println(toSerialCode(i));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   private static final char[] r = { 'q', 'w', 'e', '8', 's', '2', 'd', 'z', 'x', '9', 'c', '7', 'p', '5', 'i', 'k', '3', 'm', 'j', 'u', 'f', 'r', '4', 'v', 'y', 'l', 't', 'n', '6', 'b', 'g', 'h' };
/*     */   
/*     */ 
/*     */   private static final char b = 'a';
/*     */   
/*     */ 
/*  37 */   private static final int binLen = r.length;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final int s = 6;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String toSerialCode()
/*     */   {
/*  49 */     String aa = String.valueOf(System.currentTimeMillis());
/*  50 */     long a1 = Long.valueOf(aa.substring(3, aa.length())).longValue();
/*  51 */     return toSerialCode(a1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String toSerialCode(String code)
/*     */   {
/*  62 */     return toSerialCode(Math.abs(code.hashCode()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String toSerialCode(long id)
/*     */   {
/*  70 */     char[] buf = new char[32];
/*  71 */     int charPos = 32;
/*     */     
/*  73 */     while (id / binLen > 0L) {
/*  74 */       int ind = (int)(id % binLen);
/*  75 */       buf[(--charPos)] = r[ind];
/*  76 */       id /= binLen;
/*     */     }
/*  78 */     buf[(--charPos)] = r[((int)(id % binLen))];
/*  79 */     String str = new String(buf, charPos, 32 - charPos);
/*     */     
/*  81 */     if (str.length() < 6) {
/*  82 */       StringBuilder sb = new StringBuilder();
/*  83 */       sb.append('a');
/*  84 */       Random rnd = new Random();
/*  85 */       for (int i = 1; i < 6 - str.length(); i++) {
/*  86 */         sb.append(r[rnd.nextInt(binLen)]);
/*     */       }
/*  88 */       str = str + sb.toString();
/*     */     }
/*  90 */     return str;
/*     */   }
/*     */   
/*     */   public static long codeToId(String code) {
/*  94 */     char[] chs = code.toCharArray();
/*  95 */     long res = 0L;
/*  96 */     for (int i = 0; i < chs.length; i++) {
/*  97 */       int ind = 0;
/*  98 */       for (int j = 0; j < binLen; j++) {
/*  99 */         if (chs[i] == r[j]) {
/* 100 */           ind = j;
/* 101 */           break;
/*     */         }
/*     */       }
/* 104 */       if (chs[i] == 'a') {
/*     */         break;
/*     */       }
/* 107 */       if (i > 0) {
/* 108 */         res = res * binLen + ind;
/*     */       } else {
/* 110 */         res = ind;
/*     */       }
/*     */     }
/*     */     
/* 114 */     return res;
/*     */   }
/*     */ }