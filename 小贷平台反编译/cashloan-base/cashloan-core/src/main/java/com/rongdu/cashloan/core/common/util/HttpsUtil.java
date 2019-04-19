/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
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
/*     */ public class HttpsUtil
/*     */ {
/*  59 */   private static final Logger logger = Logger.getLogger(HttpsUtil.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String HTTPS_PROTOCOL_SCHEME = "https";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int DEFAULT_PORT_NUMBER_FOR_HTTPS = 443;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final String CHARSET = "UTF-8";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final int TIMEOUT = 60000;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String postClient(String postUrl, Map<String, String> requestParams)
/*     */   {
/*  89 */     return postClient(postUrl, requestParams, "UTF-8", 60000);
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
/*     */   public static String postClient(String postUrl, Map<String, String> requestParams, int timeout)
/*     */   {
/* 102 */     return postClient(postUrl, requestParams, "UTF-8", timeout);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String postClient(String postUrl, Map<String, String> requestParams, String charset, int timeout)
/*     */   {
/* 121 */     HttpClient httpClient = new DefaultHttpClient();
/*     */     try
/*     */     {
/* 124 */       SSLContext ctx = SSLContext.getInstance("TLS");
/* 125 */       ctx.init(null, new TrustManager[] { new HttpsX509TrustManager() },
/* 126 */         null);
/* 127 */       SSLSocketFactory sslSocketFactory = new SSLSocketFactory(ctx);
/*     */       
/* 129 */       httpClient
/* 130 */         .getConnectionManager()
/* 131 */         .getSchemeRegistry()
/* 132 */         .register(
/* 133 */         new Scheme(
/* 134 */         "https", 
/* 135 */         sslSocketFactory, 
/* 136 */         443));
/*     */       
/* 138 */       HttpPost httpPost = new HttpPost(postUrl);
/*     */       
/* 140 */       RequestConfig.Builder builder = RequestConfig.custom();
/* 141 */       builder.setSocketTimeout(timeout);
/* 142 */       builder.setConnectTimeout(timeout);
/* 143 */       RequestConfig config = builder.build();
/* 144 */       httpPost.setConfig(config);
/*     */       
/* 146 */       List<NameValuePair> formParams = convert2NameValuePair(requestParams);
/* 147 */       if (!formParams.isEmpty()) {
/* 148 */         httpPost.setEntity(new UrlEncodedFormEntity(formParams, charset));
/*     */       }
/*     */       
/* 151 */       HttpResponse response = httpClient.execute(httpPost);
/* 152 */       HttpEntity entity = response.getEntity();
/* 153 */       String responseContent = "";
/* 154 */       if (entity != null) {
/* 155 */         responseContent = EntityUtils.toString(entity, charset);
/* 156 */         entity.consumeContent();
/*     */       }
/* 158 */       logger.info("HtppsUtil发送请求状态码为：" + response.getStatusLine().getStatusCode() + "通知参数:" + responseContent);
/* 159 */       if (response.getStatusLine().getStatusCode() == 200) {
/* 160 */         if (StringUtil.isBlank(responseContent))
/*     */         {
/* 162 */           return "3000";
/*     */         }
/*     */         
/* 165 */         return responseContent;
/*     */       }
/*     */       
/* 168 */       return "3001";
/*     */     }
/*     */     catch (NoSuchAlgorithmException noSuex) {
/* 171 */       logger.info("请求发送失败，NoSuchAlgorithmException原因：", noSuex);
/*     */       
/* 173 */       return "3003";
/*     */     } catch (KeyManagementException keyMaEx) {
/* 175 */       logger.info("请求发送失败，KeyManagementException原因：秘钥异常", keyMaEx);
/*     */       
/* 177 */       return "3003";
/*     */     } catch (UnsupportedEncodingException unsuEx) {
/* 179 */       logger.info("请求发送失败，UnsupportedEncodingException原因：", unsuEx);
/*     */       
/* 181 */       return "3003";
/*     */     } catch (ClientProtocolException clPrEx) {
/* 183 */       logger.info("请求发送失败，ClientProtocolException原因：", clPrEx);
/*     */       
/* 185 */       return "3003";
/*     */     } catch (SocketTimeoutException e) {
/* 187 */       logger.info("请求发送失败，SocketTimeoutException原因：", e);
/*     */       
/* 189 */       return "3002";
/*     */     } catch (IOException ioEx) {
/* 191 */       logger.info("请求发送失败，ClientProtocolException原因：", ioEx);
/*     */       
/* 193 */       return "3003";
/*     */     } finally {
/* 195 */       httpClient.getConnectionManager().shutdown();
/*     */     }
/*     */   }
/*     */   
/*     */   private static List<NameValuePair> convert2NameValuePair(Map<String, String> requestParams) {
/* 200 */     if ((requestParams == null) || (requestParams.isEmpty())) {
/* 201 */       return null;
/*     */     }
/*     */     
/* 204 */     List<NameValuePair> formParams = new ArrayList();
/* 205 */     for (Map.Entry<String, String> entry : requestParams.entrySet()) {
/* 206 */       formParams.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
/*     */     }
/* 208 */     return formParams;
/*     */   }
/*     */   
/*     */   private static class HttpsX509TrustManager
/*     */     implements X509TrustManager
/*     */   {
/*     */     public void checkClientTrusted(X509Certificate[] chain, String authType)
/*     */       throws CertificateException
/*     */     {}
/*     */     
/*     */     public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
/*     */     {}
/*     */     
/*     */     public X509Certificate[] getAcceptedIssuers()
/*     */     {
/* 223 */       return new X509Certificate[0];
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getClient(String postUrl)
/*     */   {
/* 233 */     return getClient(postUrl, "UTF-8", 60000);
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
/*     */   public static String getClient(String postUrl, String charset, int timeout)
/*     */   {
/* 246 */     HttpClient httpClient = new DefaultHttpClient();
/*     */     try
/*     */     {
/* 249 */       SSLContext ctx = SSLContext.getInstance("TLS");
/* 250 */       ctx.init(null, new TrustManager[] { new HttpsX509TrustManager() },
/* 251 */         null);
/* 252 */       SSLSocketFactory sslSocketFactory = new SSLSocketFactory(ctx);
/*     */       
/* 254 */       httpClient
/* 255 */         .getConnectionManager()
/* 256 */         .getSchemeRegistry()
/* 257 */         .register(
/* 258 */         new Scheme(
/* 259 */         "https", 
/* 260 */         sslSocketFactory, 
/* 261 */         443));
/*     */       
/* 263 */       HttpGet httpGet = new HttpGet(postUrl);
/*     */       
/* 265 */       HttpResponse response = httpClient.execute(httpGet);
/* 266 */       HttpEntity entity = response.getEntity();
/*     */       
/* 268 */       String responseContent = "";
/* 269 */       if (entity != null) {
/* 270 */         responseContent = EntityUtils.toString(entity, charset);
/* 271 */         entity.consumeContent();
/*     */       }
/*     */       
/* 274 */       return responseContent;
/*     */     } catch (NoSuchAlgorithmException noSuex) {
/* 276 */       logger.info("请求发送失败，NoSuchAlgorithmException原因：", noSuex);
/*     */       
/* 278 */       return "3003";
/*     */     } catch (KeyManagementException keyMaEx) {
/* 280 */       logger.info("请求发送失败，KeyManagementException原因：", keyMaEx);
/*     */       
/* 282 */       return "3003";
/*     */     } catch (UnsupportedEncodingException unsuEx) {
/* 284 */       logger.info("请求发送失败，UnsupportedEncodingException原因：", unsuEx);
/*     */       
/* 286 */       return "3003";
/*     */     } catch (ClientProtocolException clPrEx) {
/* 288 */       logger.info("请求发送失败，ClientProtocolException原因：", clPrEx);
/*     */       
/* 290 */       return "3003";
/*     */     } catch (IOException ioEx) {
/* 292 */       logger.info("请求发送失败，ClientProtocolException原因：", ioEx);
/*     */       
/* 294 */       return "3003";
/*     */     } finally {
/* 296 */       httpClient.getConnectionManager().shutdown();
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
/*     */   public static String postStrClient(String postUrl, String jonStr)
/*     */   {
/* 309 */     return postStrClient(postUrl, jonStr, "UTF-8", 60000);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String postStrClient(String postUrl, String jonStr, int timeout)
/*     */   {
/* 321 */     return postStrClient(postUrl, jonStr, "UTF-8", timeout);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String postStrClient(String postUrl, String jonStr, String charset, int timeout)
/*     */   {
/* 342 */     HttpClient httpClient = new DefaultHttpClient();
/*     */     try {
/* 344 */       SSLContext ctx = SSLContext.getInstance("TLS");
/* 345 */       ctx.init(null, new TrustManager[] { new HttpsX509TrustManager() },
/* 346 */         null);
/* 347 */       SSLSocketFactory sslSocketFactory = new SSLSocketFactory(ctx);
/* 348 */       sslSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
/* 349 */       httpClient
/* 350 */         .getConnectionManager()
/* 351 */         .getSchemeRegistry()
/* 352 */         .register(
/* 353 */         new Scheme("https", 
/* 354 */         sslSocketFactory, 
/* 355 */         443));
/*     */       
/*     */ 
/* 358 */       HttpPost httpPost = new HttpPost(postUrl);
/*     */       
/* 360 */       RequestConfig.Builder builder = RequestConfig.custom();
/* 361 */       builder.setSocketTimeout(timeout);
/* 362 */       builder.setConnectTimeout(timeout);
/* 363 */       RequestConfig config = builder.build();
/* 364 */       httpPost.setConfig(config);
/* 365 */       httpPost.setHeader("User-Agent", "httpcomponents");
/* 366 */       httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
/* 367 */       StringEntity stringEntiry = new StringEntity(jonStr, "utf-8");
/* 368 */       httpPost.setEntity(stringEntiry);
/*     */       
/*     */ 
/* 371 */       HttpResponse response = httpClient.execute(httpPost);
/* 372 */       HttpEntity entity = response.getEntity();
/* 373 */       String responseContent = "";
/* 374 */       if (entity != null) {
/* 375 */         responseContent = EntityUtils.toString(entity, charset);
/* 376 */         entity.consumeContent();
/*     */       }
/* 378 */       logger.info("HtppsUtil发送请求状态码为：" + 
/* 379 */         response.getStatusLine().getStatusCode() + "通知参数:" + 
/* 380 */         responseContent);
/* 381 */       if (response.getStatusLine().getStatusCode() == 200) {
/* 382 */         if (StringUtil.isBlank(responseContent))
/*     */         {
/* 384 */           return "3000";
/*     */         }
/*     */         
/* 387 */         return responseContent;
/*     */       }
/*     */       
/* 390 */       return "3001";
/*     */     }
/*     */     catch (NoSuchAlgorithmException noSuex) {
/* 393 */       logger.info("请求发送失败，NoSuchAlgorithmException原因：", noSuex);
/*     */       
/* 395 */       return "3003";
/*     */     } catch (KeyManagementException keyMaEx) {
/* 397 */       logger.info("请求发送失败，KeyManagementException原因：秘钥异常", keyMaEx);
/*     */       
/* 399 */       return "3003";
/*     */     } catch (UnsupportedEncodingException unsuEx) {
/* 401 */       logger.info("请求发送失败，UnsupportedEncodingException原因：", unsuEx);
/*     */       
/* 403 */       return "3003";
/*     */     } catch (ClientProtocolException clPrEx) {
/* 405 */       logger.info("请求发送失败，ClientProtocolException原因：", clPrEx);
/*     */       
/* 407 */       return "3003";
/*     */     } catch (SocketTimeoutException e) {
/* 409 */       logger.info("请求发送失败，SocketTimeoutException原因：", e);
/*     */       
/* 411 */       return "3002";
/*     */     } catch (IOException ioEx) {
/* 413 */       logger.info("请求发送失败，ClientProtocolException原因：", ioEx);
/*     */       
/* 415 */       return "3003";
/*     */     } finally {
/* 417 */       httpClient.getConnectionManager().shutdown();
/*     */     }
/*     */   }
/*     */ }
