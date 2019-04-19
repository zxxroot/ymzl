/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tool.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.zip.GZIPOutputStream;
/*     */ public class ServletUtils
/*     */ {
/*  28 */   private static final Logger logger = LoggerFactory.getLogger(ServletUtils.class);
/*     */   
/*     */   public static final long ONE_DAY_SECONDS = 86400L;
/*     */   
/*     */   public static final long ONE_WEEK_SECONDS = 604800L;
/*     */   
/*     */   public static final long ONE_MONTH_SECONDS = 2592000L;
/*     */   
/*     */   public static final long ONE_YEAR_SECONDS = 31536000L;
/*     */   
/*     */   private static final String CONTENT_TYPE = "content-type";
/*     */   public static final String EXCEL_TYPE = "application/vnd.ms-excel";
/*     */   public static final String HTML_TYPE = "text/html";
/*     */   public static final String JS_TYPE = "text/javascript";
/*     */   public static final String CSS_TYPE = "text/css";
/*     */   public static final String JSON_TYPE = "application/json";
/*     */   public static final String XML_TYPE = "text/xml";
/*     */   public static final String TEXT_TYPE = "text/plain";
/*     */   public static final String CODE_UTF8 = "UTF-8";
/*     */   
/*     */   public static void setContentType(HttpServletResponse response, String contentType, String encoding)
/*     */   {
/*  50 */     setContentType(response, contentType);
/*  51 */     response.setCharacterEncoding(encoding);
/*     */   }
/*     */   
/*     */   public static void setContentType(HttpServletResponse response, String contentType)
/*     */   {
/*  56 */     response.setContentType(contentType);
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static void outputFile(HttpServletResponse response, org.springframework.core.io.Resource[] rs, boolean gzip)
/*     */     throws IOException
/*     */   {

/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static void outputFile(HttpServletResponse response, org.springframework.core.io.Resource r, boolean gzip)
/*     */     throws IOException
{}
/*     */   
/*     */   public static OutputStream buildGzipOutputStream(HttpServletResponse response)
/*     */     throws IOException
/*     */   {
/* 146 */     response.setHeader("Content-Encoding", "gzip");
/* 147 */     response.setHeader("Vary", "Accept-Encoding");
/* 148 */     return new GZIPOutputStream(response.getOutputStream());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isAcceptGzip(HttpServletRequest request)
/*     */   {
/* 158 */     String acceptEncoding = request.getHeader("Accept-Encoding");
/* 159 */     return StringUtil.contains(acceptEncoding, "gzip");
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
/*     */   public static boolean checkAndSetExpiresHeaders(HttpServletRequest request, HttpServletResponse response, long lastModi)
/*     */   {
/* 172 */     String etag = "W/\"" + lastModi + "\"";
/* 173 */     if ((!checkIfModifiedSince(request, response, lastModi)) || 
/* 174 */       (!checkIfNoneMatchEtag(request, response, etag))) {
/* 175 */       return false;
/*     */     }
/* 177 */     setLastModifiedHeader(response, lastModi);
/* 178 */     setEtag(response, etag);
/* 179 */     if (AppContextHolder.isDevMode()) {
/* 180 */       setNoCacheHeader(response);
/*     */     } else {
/* 182 */       setExpiresHeader(response, 86400L);
/*     */     }
/* 184 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setNoCacheHeader(HttpServletResponse response)
/*     */   {
/* 193 */     response.setDateHeader("Expires", 1L);
/* 194 */     response.addHeader("Pragma", "no-cache");
/* 195 */     response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setExpiresHeader(HttpServletResponse response, long expiresSeconds)
/*     */   {
/* 206 */     response.setDateHeader("Expires", System.currentTimeMillis() + 
/* 207 */       expiresSeconds * 1000L);
/* 208 */     response.setHeader("Cache-Control", "private, max-age=" + 
/* 209 */       expiresSeconds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setLastModifiedHeader(HttpServletResponse response, long lastModifiedDate)
/*     */   {
/* 220 */     response.setDateHeader("Last-Modified", lastModifiedDate);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setEtag(HttpServletResponse response, String etag)
/*     */   {
/* 230 */     response.setHeader("ETag", etag);
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
/*     */   public static boolean checkIfModifiedSince(HttpServletRequest request, HttpServletResponse response, long lastModified)
/*     */   {
/* 243 */     long ifModifiedSince = request.getDateHeader("If-Modified-Since");
/* 244 */     if ((ifModifiedSince != -1L) && (lastModified < ifModifiedSince + 1000L)) {
/* 245 */       response.setStatus(304);
/* 246 */       return false;
/*     */     }
/* 248 */     return true;
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
/*     */   public static boolean checkIfNoneMatchEtag(HttpServletRequest request, HttpServletResponse response, String etag)
/*     */   {
/* 261 */     String headerValue = request.getHeader("If-None-Match");
/* 262 */     if (headerValue != null) {
/* 263 */       boolean conditionSatisfied = false;
/* 264 */       if (!"*".equals(headerValue)) {
/* 265 */         StringTokenizer commaTokenizer = new StringTokenizer(
/* 266 */           headerValue, ",");
/*     */         do {
/* 268 */           String currentToken = commaTokenizer.nextToken();
/* 269 */           if (currentToken.trim().equals(etag)) {
/* 270 */             conditionSatisfied = true;
/*     */           }
/* 267 */           if (conditionSatisfied) break; } while (commaTokenizer.hasMoreTokens());
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 274 */         conditionSatisfied = true;
/*     */       }
/* 276 */       if (conditionSatisfied) {
/* 277 */         response.setStatus(304);
/* 278 */         response.setHeader("ETag", etag);
/* 279 */         return false;
/*     */       }
/*     */     }
/* 282 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setFileDownloadHeader(HttpServletResponse response, String fileName)
/*     */   {
/*     */     try
/*     */     {
/* 294 */       String encodedfileName = new String(fileName.getBytes(), 
/* 295 */         "ISO8859-1");
/* 296 */       response.setHeader("Content-Disposition", "attachment; filename=\"" + 
/* 297 */         encodedfileName + "\"");
/*     */     } catch (UnsupportedEncodingException e) {
/* 299 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getIpAddress(HttpServletRequest request) {
/* 304 */     String ip = request.getHeader("x-forwarded-for");
/* 305 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 306 */       ip = request.getHeader("Proxy-Client-IP");
/*     */     }
/* 308 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 309 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*     */     }
/* 311 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 312 */       ip = request.getRemoteAddr();
/*     */     }
/* 314 */     return ip;
/*     */   }
/*     */   
/*     */   public static void writeToResponse(HttpServletResponse response, Map<String, Object> res) {
/* 318 */     response.addHeader("content-type", "text/javascript");
/* 319 */     response.setContentType("application/json");
/* 320 */     response.setCharacterEncoding("UTF-8");
/* 321 */     OutputStreamWriter out = null;
/*     */     try {
/* 323 */       out = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
/*     */     } catch (UnsupportedEncodingException e) {
/* 325 */       logger.error(e.getMessage(), e);
/*     */     } catch (IOException e) {
/* 327 */       logger.error(e.getMessage(), e);
/*     */     }
/* 329 */     JsonUtil.write(out, res);
/*     */   }
/*     */   
/*     */   public static void writeToResponseWithOnlyYMDDate(HttpServletResponse response, Map<? extends Object, Object> res) {
/* 333 */     response.addHeader("content-type", "text/javascript");
/* 334 */     response.setContentType("application/json");
/* 335 */     response.setCharacterEncoding("UTF-8");
/* 336 */     OutputStreamWriter out = null;
/*     */     try {
/* 338 */       out = new OutputStreamWriter(
/* 339 */         response.getOutputStream(), "UTF-8");
/*     */     } catch (UnsupportedEncodingException e) {
/* 341 */       logger.error(e.getMessage(), e);
/*     */     } catch (IOException e) {
/* 343 */       logger.error(e.getMessage(), e);
/*     */     }
/* 345 */     JsonUtil.writeWithOnlyYMDDate(out, res);
/*     */   }
/*     */   
/*     */   public static void writeToResponselist(HttpServletResponse response, List<? extends Object> res) throws IOException
/*     */   {
/* 350 */     response.addHeader("content-type", "text/javascript");
/* 351 */     OutputStreamWriter out = new OutputStreamWriter(
/* 352 */       response.getOutputStream(), "UTF-8");
/* 353 */     JsonUtil.write(out, res);
/*     */   }
/*     */   
/*     */   public static void writeToResponselist2(HttpServletResponse response, List<Object> res) throws IOException
/*     */   {
/* 358 */     response.addHeader("content-type", "text/javascript");
/* 359 */     OutputStreamWriter out = new OutputStreamWriter(
/* 360 */       response.getOutputStream(), "UTF-8");
/* 361 */     JsonUtil.write(out, res);
/*     */   }
/*     */   
/*     */   public static void writeToResponse(HttpServletResponse response, Object object) throws IOException
/*     */   {
/* 366 */     response.addHeader("content-type", "text/javascript");
/* 367 */     response.setContentType("application/json");
/* 368 */     response.setCharacterEncoding("UTF-8");
/*     */     
/* 370 */     OutputStreamWriter out = new OutputStreamWriter(
/* 371 */       response.getOutputStream(), "UTF-8");
/*     */     
/* 373 */     JsonUtil.write(out, object);
/*     */   }
/*     */ }
