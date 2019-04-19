/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou.utils;
/*     */ 
/*     */ import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
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

/*     */ public class HttpPostUtil
/*     */ {
/*  43 */   private static final Logger LOGGER = Logger.getLogger(HttpPostUtil.class);
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String postForward(String url, Map<String, String> params)
/*     */     throws Exception
/*     */   {
/*  55 */     return postForward(url, params, "UTF-8", false);
/*     */   }
/*     */   
/*     */   public static String postForward(String url, Map<String, String> params, boolean isCode) throws Exception
/*     */   {
/*  60 */     return postForward(url, params, "UTF-8", isCode);
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
/*     */   public static String postForward(String url, Map<String, String> params, String charset, boolean isCode)
/*     */     throws Exception
/*     */   {
/*  75 */     LOGGER.info("http-post请求" + url + ":" + params);
/*  76 */     boolean https = isHttps(url);
/*  77 */     if (https)
/*     */     {
/*  79 */       Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
/*  80 */       Protocol.registerProtocol("https", myhttps);
/*     */     }
/*     */     
/*  83 */     HttpClient httpclient = new HttpClient();
/*  84 */     PostMethod xmlpost = new PostMethod(url);
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  89 */       httpclient.getHttpConnectionManager().getParams().setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler(0, false));
/*  90 */       httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
/*  91 */       httpclient.getParams().setParameter("http.protocol.content-charset", charset);
/*     */       
/*  93 */       NameValuePair[] nameValuePairs = new NameValuePair[params.size()];
/*  94 */       Iterator<String> keyIterator = params.keySet().iterator();
/*  95 */       int i = 0;
/*  96 */       while (keyIterator.hasNext())
/*     */       {
/*  98 */         Object key = keyIterator.next();
/*  99 */         String value = (String)params.get(key);
/* 100 */         if (isCode)
/* 101 */           value = URLEncoder.encode(value, charset);
/* 102 */         NameValuePair name = new NameValuePair((String)key, value);
/* 103 */         nameValuePairs[i] = name;
/* 104 */         i++;
/*     */       }
/*     */       
/* 107 */       xmlpost.setRequestBody(nameValuePairs);
/* 108 */       int status = httpclient.executeMethod(xmlpost);
/* 109 */       String response = xmlpost.getResponseBodyAsString();
/*     */       
/* 111 */       LOGGER.info("http-post请求返回" + status + ":" + response);
/* 112 */       return response;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 116 */       LOGGER.error("http-post请求异常", e);
/* 117 */       throw e;
/*     */     }
/*     */     finally
/*     */     {
/* 121 */       if (xmlpost != null)
/*     */       {
/* 123 */         xmlpost.releaseConnection();
/*     */       }
/* 125 */       if (httpclient != null)
/*     */       {
/* 127 */         httpclient.getHttpConnectionManager().closeIdleConnections(0L);
/*     */       }
/*     */       
/* 130 */       if (https)
/*     */       {
/* 132 */         Protocol.unregisterProtocol("https");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String postForward(String url, String params)
/*     */     throws Exception
/*     */   {
/* 147 */     return postForward(url, params, "UTF-8", false);
/*     */   }
/*     */   
/*     */   public static String postForward(String url, String params, boolean isCode) throws Exception
/*     */   {
/* 152 */     return postForward(url, params, "UTF-8", isCode);
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
/*     */   public static String postForward(String url, String params, String charset, boolean isCode)
/*     */     throws Exception
/*     */   {
/* 166 */     LOGGER.info("http-post请求" + url + ":" + params);
/* 167 */     boolean https = isHttps(url);
/* 168 */     if (https)
/*     */     {
/* 170 */       Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
/* 171 */       Protocol.registerProtocol("https", myhttps);
/*     */     }
/*     */     
/* 174 */     HttpClient httpclient = new HttpClient();
/* 175 */     PostMethod xmlpost = new PostMethod(url);
/* 176 */     if (isCode)
/* 177 */       params = URLEncoder.encode(params, charset);
/* 178 */     byte[] input = params.getBytes(charset);
/* 179 */     InputStream inputStream = new ByteArrayInputStream(input);
/*     */     
/*     */     try
/*     */     {
/* 183 */       httpclient.getHttpConnectionManager().getParams().setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler(0, false));
/* 184 */       httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
/* 185 */       httpclient.getParams().setParameter("http.protocol.content-charset", charset);
/* 186 */       xmlpost.setRequestEntity(new InputStreamRequestEntity(inputStream, params.length()));
/*     */       
/* 188 */       int status = httpclient.executeMethod(xmlpost);
/* 189 */       String response = xmlpost.getResponseBodyAsString();
/*     */       
/* 191 */       LOGGER.info("http-post请求返回" + status + ":" + response);
/* 192 */       return response;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       LOGGER.error("http-post请求异常", e);
/* 197 */       throw e;
/*     */     }
/*     */     finally
/*     */     {
/* 201 */       if (xmlpost != null)
/*     */       {
/* 203 */         xmlpost.releaseConnection();
/*     */       }
/* 205 */       if (httpclient != null)
/*     */       {
/* 207 */         httpclient.getHttpConnectionManager().closeIdleConnections(0L);
/*     */       }
/*     */       
/* 210 */       if (https)
/*     */       {
/* 212 */         Protocol.unregisterProtocol("https");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean isHttps(String url)
/*     */   {
/* 219 */     if (url.startsWith("https"))
/*     */     {
/* 221 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 225 */     return false;
/*     */   }
/*     */ }
