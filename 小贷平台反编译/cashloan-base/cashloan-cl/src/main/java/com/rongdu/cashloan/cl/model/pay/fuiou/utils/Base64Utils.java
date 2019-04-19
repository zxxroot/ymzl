/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou.utils;
/*     */ 
/*     */ import it.sauronsoftware.base64.Base64;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ public class Base64Utils
/*     */ {
/*     */   private static final int CACHE_SIZE = 1024;
/*     */   
/*     */   public static byte[] decode(String base64)
/*     */     throws Exception
/*     */   {
/*  40 */     return Base64.decode(base64.getBytes());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String encode(byte[] bytes)
/*     */     throws Exception
/*     */   {
/*  53 */     return new String(Base64.encode(bytes));
/*     */   }
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
/*     */   public static String encodeFile(String filePath)
/*     */     throws Exception
/*     */   {
/*  69 */     byte[] bytes = fileToByte(filePath);
/*  70 */     return encode(bytes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void decodeToFile(String filePath, String base64)
/*     */     throws Exception
/*     */   {
/*  83 */     byte[] bytes = decode(base64);
/*  84 */     byteArrayToFile(bytes, filePath);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static byte[] fileToByte(String filePath)
/*     */     throws Exception
/*     */   {
/*  97 */     byte[] data = new byte[0];
/*  98 */     File file = new File(filePath);
/*  99 */     if (file.exists()) {
/* 100 */       FileInputStream in = new FileInputStream(file);
/* 101 */       ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
/* 102 */       byte[] cache = new byte['Ѐ'];
/* 103 */       int nRead = 0;
/* 104 */       while ((nRead = in.read(cache)) != -1) {
/* 105 */         out.write(cache, 0, nRead);
/* 106 */         out.flush();
/*     */       }
/* 108 */       out.close();
/* 109 */       in.close();
/* 110 */       data = out.toByteArray();
/*     */     }
/* 112 */     return data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void byteArrayToFile(byte[] bytes, String filePath)
/*     */     throws Exception
/*     */   {
/* 124 */     InputStream in = new ByteArrayInputStream(bytes);
/* 125 */     File destFile = new File(filePath);
/* 126 */     if (!destFile.getParentFile().exists()) {
/* 127 */       destFile.getParentFile().mkdirs();
/*     */     }
/* 129 */     destFile.createNewFile();
/* 130 */     OutputStream out = new FileOutputStream(destFile);
/* 131 */     byte[] cache = new byte['Ѐ'];
/* 132 */     int nRead = 0;
/* 133 */     while ((nRead = in.read(cache)) != -1) {
/* 134 */       out.write(cache, 0, nRead);
/* 135 */       out.flush();
/*     */     }
/* 137 */     out.close();
/* 138 */     in.close();
/*     */   }
/*     */ }

