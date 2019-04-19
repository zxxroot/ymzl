/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tool.util.StringUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileTypeUtil
/*     */ {
/*  33 */   private static final Logger LOG = LoggerFactory.getLogger(FileTypeUtil.class);
/*     */   
/*  35 */   public static final Map<String, String> FILE_TYPE_MAP = new HashMap();
/*     */   
/*     */   public static final String FILE_TYPE_GIF = "gif";
/*     */   
/*     */   public static final String FILE_TYPE_JPEG = "jpeg";
/*     */   
/*     */   public static final String FILE_TYPE_PNG = "png";
/*     */   
/*     */   public static final String FILE_TYPE_JPG = "jpg";
/*     */   
/*     */   public static final String FILE_TYPE_PDF = "pdf";
/*     */   public static final String FILE_TYPE_XLS = "xls";
/*     */   public static final String FILE_TYPE_XLSX = "xlsx";
/*     */   public static final String FILE_TYPE_DOC = "doc";
/*     */   public static final String FILE_TYPE_DOCX = "docx";
/*     */   
/*     */   static
/*     */   {
/*  53 */     getAllFileType();
/*     */   }
/*     */   
/*     */   private static void getAllFileType()
/*     */   {
/*  58 */     FILE_TYPE_MAP.put("jpg", "FFD8FF");
/*  59 */     FILE_TYPE_MAP.put("jpeg", "FFD8FF");
/*  60 */     FILE_TYPE_MAP.put("png", "89504E47");
/*  61 */     FILE_TYPE_MAP.put("gif", "47494638");
/*  62 */     FILE_TYPE_MAP.put("tif", "49492A00");
/*  63 */     FILE_TYPE_MAP.put("bmp", "424D");
/*  64 */     FILE_TYPE_MAP.put("dwg", "41433130");
/*  65 */     FILE_TYPE_MAP.put("html", "68746D6C3E");
/*  66 */     FILE_TYPE_MAP.put("rtf", "7B5C727466");
/*  67 */     FILE_TYPE_MAP.put("xml", "3C3F786D6C");
/*  68 */     FILE_TYPE_MAP.put("rar", "52617221");
/*  69 */     FILE_TYPE_MAP.put("psd", "38425053");
/*  70 */     FILE_TYPE_MAP.put("eml", "44656C69766572792D646174653A");
/*  71 */     FILE_TYPE_MAP.put("dbx", "CFAD12FEC5FD746F");
/*  72 */     FILE_TYPE_MAP.put("pst", "2142444E");
/*  73 */     FILE_TYPE_MAP.put("xlsx", "504B0304");
/*  74 */     FILE_TYPE_MAP.put("xls", "D0CF11E0");
/*  75 */     FILE_TYPE_MAP.put("doc", "D0CF11E0");
/*  76 */     FILE_TYPE_MAP.put("pdf", "255044462D312E");
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static final String getFileType(File file)
{return null;}
/*     */   
/*     */   public static final String getFileTypeByStream(byte[] b)
/*     */   {
/* 112 */     String filetypeHex = String.valueOf(getFileHexString(b));
/* 113 */     Iterator<Map.Entry<String, String>> entryiterator = FILE_TYPE_MAP.entrySet().iterator();
/* 114 */     while (entryiterator.hasNext()) {
/* 115 */       Map.Entry<String, String> entry = (Map.Entry)entryiterator.next();
/* 116 */       String fileTypeHexValue = (String)entry.getValue();
/* 117 */       if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {
/* 118 */         return (String)entry.getKey();
/*     */       }
/*     */     }
/* 121 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkFileType(File file)
/*     */   {
/* 130 */     String fileType = getFileType(file);
/* 131 */     if (StringUtil.isBlank(fileType)) {
/* 132 */       return false;
/*     */     }
/* 134 */     return isImage(file, fileType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isImage(File file, String fileType)
/*     */   {
/* 145 */     if ((("jpeg".equals(fileType)) || ("jpg".equals(fileType)) || ("png".equals(fileType)) || ("gif".equals(fileType))) && 
/* 146 */       (fileIsImage(file).booleanValue())) {
/* 147 */       return true;
/*     */     }
/*     */     
/* 150 */     return false;
/*     */   }
/*     */   
/*     */   public static Boolean fileIsImage(File file)
/*     */   {
/* 155 */     InputStream is = null;
/* 156 */     BufferedReader reader = null;
/* 157 */     FileReader fr = null;
/*     */     try {
/* 159 */       fr = new FileReader(file);
/*     */       
/* 161 */       is = new FileInputStream(file);
/*     */       
/* 163 */       BufferedImage image = ImageIO.read(is);
/* 164 */       if (image != null) {
/* 165 */         reader = new BufferedReader(fr);
/* 166 */         String exits = null;
/* 167 */         Boolean localBoolean; while ((exits = reader.readLine()) != null) {
/* 168 */           exits = shiftD(exits);
/* 169 */           if ((exits.indexOf("eval") > -1) || (exits.indexOf("<?php") > -1)) {
/* 170 */             return Boolean.valueOf(false);
/*     */           }
/*     */         }
/* 173 */         return Boolean.valueOf(true);
/*     */       }
/*     */     } catch (Exception e) {
/* 176 */       LOG.error("fileIsImage方法异常", e);
/*     */     } finally {
/*     */       try {
/* 179 */         if (is != null) {
/* 180 */           is.close();
/*     */         }
/* 182 */         if (reader != null) {
/* 183 */           reader.close();
/*     */         }
/* 185 */         if (fr != null) {
/* 186 */           fr.close();
/*     */         }
/*     */       } catch (IOException e) {
/* 189 */         LOG.error("fileIsImage IO关闭异常", e);
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/* 179 */       if (is != null) {
/* 180 */         is.close();
/*     */       }
/* 182 */       if (reader != null) {
/* 183 */         reader.close();
/*     */       }
/* 185 */       if (fr != null) {
/* 186 */         fr.close();
/*     */       }
/*     */     } catch (IOException e) {
/* 189 */       LOG.error("fileIsImage IO关闭异常", e);
/*     */     }
/*     */     
/* 192 */     return Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public static String shiftD(String str) {
/* 196 */     int size = str.length();
/* 197 */     char[] chs = str.toCharArray();
/* 198 */     for (int i = 0; i < size; i++) {
/* 199 */       if ((chs[i] <= 'Z') && (chs[i] >= 'A')) {
/* 200 */         chs[i] = ((char)(chs[i] + ' '));
/*     */       }
/*     */     }
/* 203 */     return new String(chs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isPdf(String fileType)
/*     */   {
/* 212 */     if ("pdf".equals(fileType)) {
/* 213 */       return true;
/*     */     }
/* 215 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isExcel(String fileType)
/*     */   {
/* 225 */     if (("xlsx".equals(fileType)) || ("xls".equals(fileType))) {
/* 226 */       return true;
/*     */     }
/* 228 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isWord(String fileType)
/*     */   {
/* 238 */     if (("doc".equals(fileType)) || ("docx".equals(fileType))) {
/* 239 */       return true;
/*     */     }
/* 241 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getFileTypeStr(String fileType)
/*     */   {
/* 252 */     Iterator<Map.Entry<String, String>> entryiterator = FILE_TYPE_MAP.entrySet().iterator();
/* 253 */     while (entryiterator.hasNext()) {
/* 254 */       Map.Entry<String, String> entry = (Map.Entry)entryiterator.next();
/* 255 */       String fileTypeHexValue = (String)entry.getValue();
/* 256 */       if (fileType.equalsIgnoreCase(fileTypeHexValue)) {
/* 257 */         return (String)entry.getKey();
/*     */       }
/*     */     }
/* 260 */     return "";
/*     */   }
/*     */   
/*     */   public static final String getFileHexString(byte[] b)
/*     */   {
/* 265 */     StringBuilder stringBuilder = new StringBuilder();
/* 266 */     if ((b == null) || (b.length <= 0))
/*     */     {
/* 268 */       return null;
/*     */     }
/* 270 */     for (int i = 0; i < b.length; i++)
/*     */     {
/* 272 */       int v = b[i] & 0xFF;
/* 273 */       String hv = Integer.toHexString(v);
/* 274 */       if (hv.length() < 2)
/*     */       {
/* 276 */         stringBuilder.append(0);
/*     */       }
/* 278 */       stringBuilder.append(hv);
/*     */     }
/* 280 */     return stringBuilder.toString();
/*     */   }
/*     */ }
