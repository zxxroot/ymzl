/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou.utils;
/*     */ 
/*     */ import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
/*     */public class MySSLSocketFactory
/*     */   implements ProtocolSocketFactory
/*     */ {
/* 232 */   private SSLContext sslcontext = null;
/*     */   
/*     */   private SSLContext createSSLContext()
/*     */   {
/* 236 */     SSLContext sslcontext = null;
/*     */     try
/*     */     {
/* 239 */       sslcontext = SSLContext.getInstance("SSL");
/* 240 */       sslcontext.init(null, new TrustManager[] {
/* 241 */         new TrustAnyTrustManager() }, new SecureRandom());
/*     */     }
/*     */     catch (NoSuchAlgorithmException e)
/*     */     {
/* 245 */       e.printStackTrace();
/*     */     }
/*     */     catch (KeyManagementException e)
/*     */     {
/* 249 */       e.printStackTrace();
/*     */     }
/* 251 */     return sslcontext;
/*     */   }
/*     */   
/*     */   private SSLContext getSSLContext()
/*     */   {
/* 256 */     if (this.sslcontext == null)
/*     */     {
/* 258 */       this.sslcontext = createSSLContext();
/*     */     }
/* 260 */     return this.sslcontext;
/*     */   }
/*     */   
/*     */   public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
/*     */     throws IOException, UnknownHostException
/*     */   {
/* 266 */     return getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);
/*     */   }
/*     */   
/*     */   public Socket createSocket(String host, int port) throws IOException, UnknownHostException
/*     */   {
/* 271 */     return getSSLContext().getSocketFactory().createSocket(host, port);
/*     */   }
/*     */   
/*     */   public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort)
/*     */     throws IOException, UnknownHostException
/*     */   {
/* 277 */     return getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);
/*     */   }
/*     */   
/*     */   public Socket createSocket(String host, int port, InetAddress localAddress, int localPort, HttpConnectionParams params)
/*     */     throws IOException, UnknownHostException, ConnectTimeoutException
/*     */   {
/* 283 */     if (params == null)
/*     */     {
/* 285 */       throw new IllegalArgumentException("Parameters may not be null");
/*     */     }
/* 287 */     int timeout = params.getConnectionTimeout();
/* 288 */     SocketFactory socketfactory = getSSLContext().getSocketFactory();
/* 289 */     if (timeout == 0)
/*     */     {
/* 291 */       return socketfactory.createSocket(host, port, localAddress, localPort);
/*     */     }
/*     */     
/*     */ 
/* 295 */     Socket socket = socketfactory.createSocket();
/* 296 */     SocketAddress localaddr = new InetSocketAddress(localAddress, localPort);
/* 297 */     SocketAddress remoteaddr = new InetSocketAddress(host, port);
/* 298 */     socket.bind(localaddr);
/* 299 */     socket.connect(remoteaddr, timeout);
/* 300 */     return socket;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class TrustAnyTrustManager
/*     */     implements X509TrustManager
/*     */   {
/*     */     public void checkClientTrusted(X509Certificate[] chain, String authType)
/*     */       throws CertificateException
/*     */     {}
/*     */     
/*     */     public void checkServerTrusted(X509Certificate[] chain, String authType)
/*     */       throws CertificateException
/*     */     {}
/*     */     
/*     */     public X509Certificate[] getAcceptedIssuers()
/*     */     {
/* 317 */       return new X509Certificate[0];
/*     */     }
/*     */   }
/*     */ }
