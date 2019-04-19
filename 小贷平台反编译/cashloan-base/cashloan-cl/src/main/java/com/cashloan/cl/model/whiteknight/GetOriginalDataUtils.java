/*     */ package com.cashloan.cl.model.whiteknight;
/*     */ 
/*     */ import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ public class GetOriginalDataUtils
/*     */ {
/*     */   /* Error */
/*     */   public static String sendPost(boolean isSsl, String param, String url)
/*     */     throws Exception
{return null;}
/*     */   
/*     */   private static void trustAllHttpsCertificates()
/*     */     throws Exception
/*     */   {
/*  80 */     TrustManager[] trustAllCerts = new TrustManager[1];
/*  81 */     TrustManager tm = new miTM();
/*  82 */     trustAllCerts[0] = tm;
/*  83 */     SSLContext sc = SSLContext.getInstance("SSL");
/*  84 */     sc.init(null, trustAllCerts, null);
/*  85 */     HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
/*     */   }
/*     */   
/*     */   public static void ignoreSsl() throws Exception
/*     */   {
/*  90 */     HostnameVerifier hv = new HostnameVerifier() {
/*     */       public boolean verify(String urlHostName, SSLSession session) {
/*  92 */         return true;
/*     */       }
/*  94 */     };
/*  95 */     trustAllHttpsCertificates();
/*  96 */     HttpsURLConnection.setDefaultHostnameVerifier(hv);
/*     */   }
/*     */   
/*     */   static class miTM implements TrustManager, X509TrustManager
/*     */   {
/*     */     public X509Certificate[] getAcceptedIssuers()
/*     */     {
/* 103 */       return null;
/*     */     }
/*     */     
/*     */     public boolean isServerTrusted(X509Certificate[] certs) {
/* 107 */       return true;
/*     */     }
/*     */     
/*     */     public boolean isClientTrusted(X509Certificate[] certs) {
/* 111 */       return true;
/*     */     }
/*     */     
/*     */     public void checkServerTrusted(X509Certificate[] certs, String authType)
/*     */       throws CertificateException
/*     */     {}
/*     */     
/*     */     public void checkClientTrusted(X509Certificate[] certs, String authType)
/*     */       throws CertificateException
/*     */     {}
/*     */   }
/*     */ }
