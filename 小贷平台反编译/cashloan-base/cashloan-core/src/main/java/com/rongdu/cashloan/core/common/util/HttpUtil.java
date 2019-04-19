/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.*;
import java.util.*;

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
/*     */ public class HttpUtil
/*     */ {
/*  44 */   private static final Logger logger = Logger.getLogger(HttpUtil.class);
/*     */   
/*     */ 
/*     */   private static final String CHARSET = "UTF-8";
/*     */   
/*     */ 
/*     */   private static final int TIMEOUT = 60000;
/*     */   
/*     */ 
/*     */   private static Scanner scanner;
/*     */   
/*     */ 
/*     */ 
/*     */   public static String doGet(String url)
/*     */   {
/*  59 */     return send(url, null, false, "utf8");
/*     */   }
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<BasicNameValuePair> wrapParam(Map<String, String> params)
/*     */   {
/*  74 */     List<BasicNameValuePair> data = new ArrayList();
/*  75 */     for (Map.Entry<String, String> entry : params.entrySet()) {
/*  76 */       String key = (String)entry.getKey();
/*  77 */       String value = (String)entry.getValue();
/*  78 */       data.add(new BasicNameValuePair(key, value));
/*     */     }
/*  80 */     return data;
/*     */   }

/*     */   public static String initResult(int code, String msg)
/*     */   {
/* 143 */     Map<String, Object> data = new HashMap();
/* 144 */     data.put("code", Integer.valueOf(code));
/* 145 */     data.put("msg", msg);
/* 146 */     return JSONObject.toJSONString(data);
/*     */   }
/*     */   
/*     */   public static String doPost(String url, Map<String, String> params)
/*     */   {
/* 151 */     return send(url, params, true, "UTF-8");
/*     */   }
/*     */   
/*     */   public static String send(String url, Map<String, String> params, boolean post, String readEncode) {
/* 155 */     InputStream input = null;
/*     */     try {
/* 157 */       URL realUrl = new URL(url);
/* 158 */       URLConnection connection = realUrl.openConnection();
/* 159 */       connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
/* 160 */       connection.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
/* 161 */       connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
/* 162 */       connection.setRequestProperty("Connection", "keep-alive");
/* 163 */       connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36 SE 2.X MetaSr 1.0");
/*     */       
/*     */ 
/*     */ 
/* 167 */       if (post) {
/* 168 */         connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
/* 169 */         connection.setDoInput(true);
/* 170 */         connection.setDoOutput(true);
/* 171 */         ((HttpURLConnection)connection).setRequestMethod("POST");
/*     */         
/* 173 */         if ((params != null) && (!params.isEmpty())) {
/* 174 */           StringBuilder sb = new StringBuilder();
/* 175 */           for (Map.Entry<String, String> entry : params.entrySet()) {
/* 176 */             String key = (String)entry.getKey();
/* 177 */             String value = (String)entry.getValue();
/* 178 */             sb.append(key + "=" + URLEncoder.encode(value, "UTF-8") + "&");
/*     */           }
/* 180 */           sb.deleteCharAt(sb.length() - 1);
/* 181 */           OutputStream out = connection.getOutputStream();
/* 182 */           out.write(sb.toString().getBytes("UTF-8"));
/*     */         }
/*     */       }
/*     */       
/* 186 */       input = connection.getInputStream();
/* 187 */       scanner = new Scanner(input, readEncode);
/* 188 */       scanner.useDelimiter("$");
/* 189 */       return scanner.next();
/*     */     } catch (Exception e) {
/* 191 */       logger.error(e.getMessage(), e);
/*     */     } finally {
/* 193 */       if (input != null) {
/*     */         try {
/* 195 */           input.close();
/*     */         } catch (IOException e) {
/* 197 */           logger.error(e.getMessage(), e);
/*     */         }
/*     */       }
/*     */     }
/* 201 */     return null;
/*     */   }

/*     */   public static JSONObject postClient(String urlString, String jsonObject)
/*     */   {
/* 256 */     JSONObject returnJson = null;
/*     */     try
/*     */     {
/* 259 */       URL url = new URL(urlString);
/* 260 */       HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/* 261 */       connection.setRequestMethod("POST");
/* 262 */       connection.setDoOutput(true);
/* 263 */       connection.setDoInput(true);
/* 264 */       connection.setUseCaches(false);
/* 265 */       connection.setInstanceFollowRedirects(true);
/* 266 */       connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
/* 267 */       connection.connect();
/* 268 */       DataOutputStream out = new DataOutputStream(
/* 269 */         connection.getOutputStream());
/* 270 */       out.write(jsonObject.toString().getBytes("UTF-8"));
/* 271 */       out.flush();
/* 272 */       out.close();
/*     */       
/* 274 */       BufferedReader reader = new BufferedReader(new InputStreamReader(
/* 275 */         connection.getInputStream(), "utf-8"));
/*     */       
/* 277 */       StringBuffer sb = new StringBuffer("");
/* 278 */       String lines; while ((lines = reader.readLine()) != null) {
/* 279 */         sb.append(lines);
/*     */       }
/* 281 */       System.out.println("sb:" + sb);
/* 282 */       returnJson = JSONObject.parseObject(sb.toString());
/* 283 */       reader.close();
/*     */       
/* 285 */       connection.disconnect();
/*     */     } catch (MalformedURLException e) {
/* 287 */       logger.error(e.getMessage());
/*     */     } catch (UnsupportedEncodingException e) {
/* 289 */       logger.error(e.getMessage());
/*     */     } catch (IOException e) {
/* 291 */       logger.error(e.getMessage());
/*     */     }
/* 293 */     return returnJson;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> T postClient4Obj(String urlString, String jsonObject, Class<T> c)
/*     */   {
/* 304 */     T t = null;
/*     */     try
/*     */     {
/* 307 */       URL url = new URL(urlString);
/* 308 */       HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/* 309 */       connection.setRequestMethod("POST");
/* 310 */       connection.setDoOutput(true);
/* 311 */       connection.setDoInput(true);
/* 312 */       connection.setUseCaches(false);
/* 313 */       connection.setInstanceFollowRedirects(true);
/* 314 */       connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
/* 315 */       connection.connect();
/* 316 */       DataOutputStream out = new DataOutputStream(connection.getOutputStream());
/* 317 */       out.write(jsonObject.toString().getBytes("UTF-8"));
/* 318 */       out.flush();
/* 319 */       out.close();
/*     */       
/* 321 */       BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
/*     */       
/* 323 */       StringBuffer sb = new StringBuffer("");
/* 324 */       String lines; while ((lines = reader.readLine()) != null) {
/* 325 */         sb.append(lines);
/*     */       }
/* 327 */       System.out.println("sb:" + sb);
/* 328 */       t = JSONObject.parseObject(sb.toString(), c);
/* 329 */       reader.close();
/*     */       
/* 331 */       connection.disconnect();
/*     */     } catch (MalformedURLException e) {
/* 333 */       logger.error(e.getMessage());
/*     */     } catch (UnsupportedEncodingException e) {
/* 335 */       logger.error(e.getMessage());
/*     */     } catch (IOException e) {
/* 337 */       logger.error(e.getMessage());
/*     */     }
/* 339 */     return t;
/*     */   }
/*     */ }
