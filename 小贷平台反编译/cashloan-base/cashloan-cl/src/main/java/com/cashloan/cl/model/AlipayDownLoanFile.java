/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AlipayDownLoanFile
/*     */ {
/*  26 */   private static final Logger logger = Logger.getLogger(AlipayDownLoanFile.class);
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
/*     */   public static List<AlipayModel> parseAlipayByUrl(String urlStr)
/*     */     throws IOException
/*     */   {
/*  41 */     return null;
/*     */   }
/*     */   
/*     */   public static Map<String, Object> getUrlParams(String param)
/*     */   {
/* 104 */     Map<String, Object> map = new HashMap(0);
/* 105 */     if (StringUtils.isEmpty(param)) {
/* 106 */       return map;
/*     */     }
/* 108 */     String[] params = param.split("&");
/* 109 */     for (int i = 0; i < params.length; i++) {
/* 110 */       String[] p = params[i].split("=");
/* 111 */       if (p.length == 2) {
/* 112 */         map.put(p[0], p[1]);
/*     */       }
/*     */     }
/* 115 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static byte[] readInputStream(InputStream inputStream)
/*     */     throws IOException
/*     */   {
/* 125 */     byte[] buffer = new byte['Ѐ'];
/*     */     
/* 127 */     ByteArrayOutputStream bos = new ByteArrayOutputStream();
/* 128 */     int len; while ((len = inputStream.read(buffer)) != -1) {
/* 129 */       bos.write(buffer, 0, len);
/*     */     }
/* 131 */     bos.close();
/* 132 */     return bos.toByteArray();
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static String unzip(String zipFilePath, String unzipFilePath, boolean includeZipFileName)
{return null;}
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 235 */       String filePath = "D:/现金贷/cashloan/framework-manage/src/main/webapp/alipay/20881021698578250156_20170406.csv.zip";
/*     */       
/* 237 */       String savePath = "D:/现金贷/cashloan/framework-manage/src/main/webapp/alipay/file";
/* 238 */       unzip(filePath, savePath, false);
/*     */     } catch (Exception e) {
/* 240 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ }
