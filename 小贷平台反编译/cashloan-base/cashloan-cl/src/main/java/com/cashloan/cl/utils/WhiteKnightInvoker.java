/*     */ package com.cashloan.cl.utils;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Map;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.SSLException;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.client.HttpRequestRetryHandler;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.config.RequestConfig.Builder;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpPost;
/*     */ import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
/*     */ import org.apache.http.conn.ssl.SSLContextBuilder;
/*     */ import org.apache.http.conn.ssl.TrustStrategy;
/*     */ import org.apache.http.conn.ssl.X509HostnameVerifier;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClientBuilder;
/*     */ import org.apache.http.impl.client.HttpClients;
/*     */ import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WhiteKnightInvoker
/*     */ {
/*  41 */   private static final Log log = LogFactory.getLog(WhiteKnightInvoker.class);
/*     */   
/*     */ 
/*     */   private static PoolingHttpClientConnectionManager connMgr;
/*     */   
/*     */   private static RequestConfig requestConfig;
/*     */   
/*  48 */   private static volatile WhiteKnightInvoker w = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static WhiteKnightInvoker getIntance()
/*     */   {
/*  55 */     if (w == null) {
/*  56 */       synchronized (WhiteKnightInvoker.class) {
/*  57 */         if (w == null) {
/*  58 */           w = new WhiteKnightInvoker();
/*  59 */           connMgr = new PoolingHttpClientConnectionManager();
/*  60 */           connMgr.setMaxTotal(500);
/*  61 */           connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());
/*  62 */           RequestConfig.Builder configBuilder = RequestConfig.custom();
/*  63 */           configBuilder.setConnectTimeout(1000);
/*  64 */           configBuilder.setSocketTimeout(1000);
/*  65 */           configBuilder.setConnectionRequestTimeout(2000);
/*  66 */           configBuilder.setStaleConnectionCheckEnabled(true);
/*  67 */           requestConfig = configBuilder.build();
/*     */         }
/*     */       }
/*     */     }
/*  71 */     return w;
/*     */   }
/*     */   
/*  74 */   HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
/*     */     public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
/*  76 */       if (executionCount >= 3) {
/*  77 */         return false;
/*     */       }
/*  79 */       if ((exception instanceof InterruptedIOException)) {
/*  80 */         return true;
/*     */       }
/*  82 */       return false;
/*     */     }
/*     */   };
/*     */   
/*     */   public String invoke(Map<String, Object> params, String apiUrl) throws IOException
/*     */   {
/*  88 */     CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).setRetryHandler(this.httpRequestRetryHandler).build();
/*  89 */     HttpPost httpPost = new HttpPost(apiUrl);
/*  90 */     CloseableHttpResponse response = null;
/*     */     
/*     */     try
/*     */     {
/*  94 */       httpPost.setConfig(requestConfig);
/*  95 */       StringEntity se = new StringEntity(JSON.toJSONString(params), "UTF-8");
/*  96 */       httpPost.addHeader("Content-Type", "application/json");
/*  97 */       se.setContentType("text/json");
/*  98 */       httpPost.setEntity(se);
/*  99 */       response = httpClient.execute(httpPost);
/* 100 */       int statusCode = response.getStatusLine().getStatusCode();
/* 101 */       if (statusCode != 200) {
/* 102 */         log.warn("[BqsApiInvoker] invoke failed, response status: " + statusCode);
/* 103 */         return null;
/*     */       }
/* 105 */       HttpEntity entity = response.getEntity();
/* 106 */       if (entity == null) {
/* 107 */         log.warn("[BqsApiInvoker] invoke failed, response output is null!");
/* 108 */         return null;
/*     */       }
/* 110 */       String result = EntityUtils.toString(entity, "utf-8");
/* 111 */       return result;
/*     */     } catch (Exception e) {
/* 113 */       log.error("[BqsApiInvoker] invoke throw exception, details: ", e);
/*     */     } finally {
/* 115 */       if (response != null) {
/* 116 */         EntityUtils.consume(response.getEntity());
/*     */       }
/*     */     }
/* 119 */     return null;
/*     */   }
/*     */   
/*     */   private SSLConnectionSocketFactory createSSLConnSocketFactory() {
/* 123 */     SSLConnectionSocketFactory sslsf = null;
/*     */     try {
/* 125 */       SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
/*     */       {
/*     */         public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
/* 128 */           return true;
/*     */         }
/* 130 */       }).build();
/* 131 */       sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier()
/*     */       {
/*     */         public boolean verify(String arg0, SSLSession arg1)
/*     */         {
/* 135 */           return true;
/*     */         }
/*     */         
/*     */         public void verify(String host, SSLSocket ssl)
/*     */           throws IOException
/*     */         {}
/*     */         
/*     */         public void verify(String host, X509Certificate cert) throws SSLException
/*     */         {}
/*     */         
/*     */         public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException
/*     */         {}
/*     */       });
/*     */     }
/*     */     catch (GeneralSecurityException e)
/*     */     {
/* 151 */       log.error(e.getMessage(), e);
/*     */     }
/* 153 */     return sslsf;
/*     */   }
/*     */ }
