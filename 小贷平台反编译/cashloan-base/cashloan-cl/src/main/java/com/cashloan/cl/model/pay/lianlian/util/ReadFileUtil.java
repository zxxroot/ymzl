/*     */ package com.cashloan.cl.model.pay.lianlian.util;
/*     */ 
/*     */ import com.jcraft.jsch.ChannelSftp;
import com.rongdu.cashloan.core.common.util.SftpUtil;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReadFileUtil
/*     */ {
/*  33 */   private static final Logger logger = Logger.getLogger(ReadFileUtil.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String FILE_SUFFIX_CSV = ".txt";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String CHARSET_UTF8 = "UTF-8";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final char SPACE_MARK = ',';
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<String> getFile(String fileName)
/*     */   {
/*  58 */     ChannelSftp sftp = SftpUtil.connect();
/*     */     
/*  60 */     InputStream in = SftpUtil.getFileStream(fileName, sftp);
/*     */     try {
/*  62 */       in.available();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  66 */       logger.error("读取文件为空", e);
/*     */     }
/*  68 */     return read(in);
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static List<String> read(String fileName)
{return null;}
/*     */   
/*     */   public static List<String> readZip(String zipFileName)
/*     */   {
/* 124 */     return readZip(zipFileName, ".txt");
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static List<String> readZip(String zipFileName, String fileSuffix)
/*     */   {return null;}
/*     */   
/*     */   public static List<String> read(InputStream is)
/*     */   {
/* 184 */     List<String> list = new ArrayList();
/*     */     try {
/* 186 */       InputStreamReader read = new InputStreamReader(is, "UTF-8");
/* 187 */       BufferedReader bufferedReader = new BufferedReader(read);
/* 188 */       String lineTxt = null;
/* 189 */       int i = 0;
/* 190 */       while ((lineTxt = bufferedReader.readLine()) != null) {
/* 191 */         if (i > 0) {
/* 192 */           list.add(lineTxt);
/*     */         }
/* 194 */         i++;
/*     */       }
/* 196 */       read.close();
/*     */     } catch (UnsupportedEncodingException e) {
/* 198 */       logger.error(e.getMessage(), e);
/*     */     } catch (IOException e) {
/* 200 */       logger.error(e.getMessage(), e);
/*     */     }
/* 202 */     return list;
/*     */   }
/*     */   
/*     */   public static List<String> readZip(InputStream inputStream)
/*     */   {
/* 207 */     List<String> list = new ArrayList();
/*     */     try {
/* 209 */       ZipInputStream zis = new ZipInputStream(inputStream);
/* 210 */       ZipEntry ze = null;
/* 211 */       while ((ze = zis.getNextEntry()) != null)
/*     */       {
/* 213 */         if (ze.isDirectory()) {
/* 214 */           zis.closeEntry();
/*     */         }
/*     */         else {
/* 217 */           BufferedReader reader = new BufferedReader(new InputStreamReader(zis));
/* 218 */           list.addAll(read(reader));
/* 219 */           zis.closeEntry();
/*     */         } }
/* 221 */       inputStream.close();
/* 222 */       zis.close();
/*     */     } catch (Exception e) {
/* 224 */       logger.error("读取数据异常：", e);
/*     */     }
/* 226 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<String> read(BufferedReader reader)
/*     */   {
/* 237 */     List<String> list = new ArrayList();
/*     */     try {
/* 239 */       String lineTxt = null;
/* 240 */       int i = 0;
/* 241 */       while ((lineTxt = reader.readLine()) != null) {
/* 242 */         if (i > 0) {
/* 243 */           list.add(lineTxt);
/*     */         }
/* 245 */         i++;
/*     */       }
/* 247 */       reader.close();
/*     */     } catch (UnsupportedEncodingException e) {
/* 249 */       logger.error(e.getMessage(), e);
/*     */     } catch (IOException e) {
/* 251 */       logger.error(e.getMessage(), e);
/*     */     }
/* 253 */     return list;
/*     */   }
/*     */ }
