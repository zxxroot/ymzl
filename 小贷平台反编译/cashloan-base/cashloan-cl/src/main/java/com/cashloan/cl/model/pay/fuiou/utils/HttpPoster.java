/*     */ package com.cashloan.cl.model.pay.fuiou.utils;
/*     */ 
/*     */

import com.alibaba.fastjson.JSON;
import com.rongdu.cashloan.cl.model.pay.fuiou.utils.MySSLSocketFactory;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
/*     */ public class HttpPoster
/*     */ {
/*     */   private String url;
/*     */   private String charset;
/*     */   
/*     */   public HttpPoster() {}
/*     */   
/*     */   public void setUrl(String url)
/*     */   {
/*  41 */     this.url = url;
/*     */   }
/*     */   
/*     */   public void setCharset(String charset) {
/*  45 */     this.charset = charset;
/*     */   }
/*     */   
/*     */   public HttpPoster(String url, String charset)
/*     */   {
/*  50 */     this.url = url;
/*  51 */     this.charset = charset;
/*     */   }
/*     */   
/*     */   public HttpPoster(String url)
/*     */   {
/*  56 */     this.url = url;
/*  57 */     this.charset = "UTF-8";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int post(Map<String, String> parameters, String url, String charset)
/*     */     throws Exception
/*     */   {
/*  69 */     HttpPoster post = new HttpPoster(url, charset);
/*  70 */     return post.post(parameters);
/*     */   }
/*     */   
/*     */   public static String getResponseString(Map<String, String> parameters, String url, String charset) throws Exception {
/*  74 */     HttpPoster post = new HttpPoster(url, charset);
/*  75 */     return post.postStr(parameters);
/*     */   }
/*     */   
/*     */   public static int post(Map<String, String> parameters, String url) throws Exception {
/*  79 */     HttpPoster post = new HttpPoster(url, "UTF-8");
/*  80 */     return post.post(parameters);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int post(final Map<String, String> parameters)
/*     */   {
/*  90 */     post(new PostMethodCallback()
/*     */     {
/*     */       public void doInPostMethod(PostMethod postMethod)
/*     */       {
/*  94 */         System.out.println("发送URL==" + HttpPoster.this.url);
/*  95 */         System.out.println("发送参数==" + parameters);
/*  96 */         NameValuePair[] nameValuePairs = new NameValuePair[parameters.size()];
/*  97 */         Set<Map.Entry<String, String>> set = parameters.entrySet();
/*  98 */         int i = 0;
/*     */         
/* 100 */         for (Map.Entry<String, String> entry : set) {
/* 101 */           NameValuePair pair = new NameValuePair((String)entry.getKey(), (String)entry.getValue());
/* 102 */           nameValuePairs[i] = pair;
/* 103 */           i++;
/*     */         }
/*     */         
/* 106 */         postMethod.setRequestBody(nameValuePairs);
/*     */       }
/*     */     });
    return 0;
/*     */   }
/*     */   
/*     */   public static String postJson(Map<String, String> parameters, String url, String charset)
/*     */   {
/* 113 */     HttpPoster post = new HttpPoster(url, charset);
/* 114 */     return post.postStrNew(parameters);
/*     */   }
/*     */   
/*     */   public String postStrNew(final Map<String, String> parameters) {
/* 118 */     postStr(new PostMethodCallback()
/*     */     {
/*     */ 
/*     */       public void doInPostMethod(PostMethod postMethod)
/*     */       {
/* 123 */         RequestEntity re = null;
/*     */         try {
/* 125 */           re = new StringRequestEntity(JSON.toJSONString(parameters), "application/json", "UTF-8");
/*     */         } catch (Exception e) {
/* 127 */           e.printStackTrace();
/*     */         }
/* 129 */         postMethod.setRequestEntity(re);
/*     */       }
/*     */     });return "";

/*     */   }
/*     */   
/*     */   public String postStr(final Map<String, String> parameters) {
/* 135 */     System.out.println("发送url==" + this.url);
/* 136 */     postStr(new PostMethodCallback()
/*     */     {
/*     */       public void doInPostMethod(PostMethod postMethod)
/*     */       {
/* 140 */         System.out.println("发送参数==" + parameters);
/* 141 */         NameValuePair[] nameValuePairs = new NameValuePair[parameters.size()];
/* 142 */         Set<Map.Entry<String, String>> set = parameters.entrySet();
/* 143 */         int i = 0;
/*     */         
/* 145 */         for (Map.Entry<String, String> entry : set) {
/* 146 */           NameValuePair pair = new NameValuePair((String)entry.getKey(), (String)entry.getValue());
/* 147 */           nameValuePairs[i] = pair;
/* 148 */           i++;
/*     */         }
/*     */         
/* 151 */         postMethod.setRequestBody(nameValuePairs);
/*     */       }
/*     */     });
return "";
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
/*     */   public int post(final String body)
/*     */     throws Exception
/*     */   {
/* 167 */     post(new PostMethodCallback()
/*     */     {
/*     */       public void doInPostMethod(PostMethod postMethod)
/*     */       {
/*     */         try
/*     */         {
/* 173 */           InputStream instream = new ByteArrayInputStream(body.getBytes(HttpPoster.this.charset));
/* 174 */           postMethod.setRequestEntity(new InputStreamRequestEntity(instream, body.getBytes(HttpPoster.this.charset).length));
/*     */         } catch (UnsupportedEncodingException e) {
/* 176 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     });
    return 0;
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
/*     */   private int post(PostMethodCallback callback)
/*     */   {
/* 193 */     HttpClient httpclient = null;
/* 194 */     PostMethod xmlpost = null;
/*     */     try
/*     */     {
/* 197 */       if (this.url.indexOf("https://") != -1)
/*     */       {
/*     */ 
/* 200 */         Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
/* 201 */         Protocol.registerProtocol("https", myhttps);
/*     */       }
/* 203 */       httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
/* 204 */       httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
/* 205 */       httpclient.getHttpConnectionManager().getParams().setSoTimeout(10000);
/* 206 */       xmlpost = new PostMethod(this.url);
/* 207 */       httpclient.getParams().setParameter("http.protocol.content-charset", this.charset);
/* 208 */       httpclient.getParams().setContentCharset(this.charset);
/*     */       
/*     */ 
/* 211 */       callback.doInPostMethod(xmlpost);
/*     */       
/* 213 */       int responseStatCode = httpclient.executeMethod(xmlpost);
/*     */       
/* 215 */       InputStream ips = xmlpost.getResponseBodyAsStream();
/* 216 */       List<Byte> byteList = new ArrayList();
/* 217 */       int is = 0;
/* 218 */       while ((is = ips.read()) != -1)
/* 219 */         byteList.add(Byte.valueOf((byte)is));
/* 220 */       byte[] allb = new byte[byteList.size()];
/* 221 */       for (int j = 0; j < byteList.size(); j++)
/* 222 */         allb[j] = ((Byte)byteList.get(j)).byteValue();
/* 223 */       String responseString = new String(allb, this.charset);
/* 224 */       System.out.println("HTTP返回码=" + responseStatCode);
/* 225 */       System.out.println("应答数据=" + responseString);
/* 226 */       if (this.url.indexOf("https://") != -1)
/* 227 */         Protocol.unregisterProtocol("https");
/* 228 */       return responseStatCode;
/*     */     } catch (IOException e) {
/* 230 */       e.printStackTrace();
/* 231 */       System.out.println("报文发送到[" + this.url + "]失败:" + e.getMessage());
/* 232 */       throw new IllegalArgumentException("通信异常");
/*     */     } finally {
/* 234 */       if (xmlpost != null) {
/* 235 */         xmlpost.releaseConnection();
/*     */       }
/* 237 */       if (httpclient != null) {
/* 238 */         httpclient.getHttpConnectionManager().closeIdleConnections(0L);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private String postStr(PostMethodCallback callback) {
/* 244 */     HttpClient httpclient = null;
/* 245 */     PostMethod xmlpost = null;
/*     */     try
/*     */     {
/* 248 */       if (this.url.indexOf("https://") != -1)
/*     */       {
/*     */ 
/* 251 */         Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
/* 252 */         Protocol.registerProtocol("https", myhttps);
/*     */       }
/* 254 */       httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
/* 255 */       httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
/* 256 */       httpclient.getHttpConnectionManager().getParams().setSoTimeout(10000);
/* 257 */       xmlpost = new PostMethod(this.url);
/* 258 */       httpclient.getParams().setParameter("http.protocol.content-charset", this.charset);
/* 259 */       httpclient.getParams().setContentCharset(this.charset);
/*     */       
/*     */ 
/* 262 */       callback.doInPostMethod(xmlpost);
/*     */       
/* 264 */       int responseStatCode = httpclient.executeMethod(xmlpost);
/*     */       
/* 266 */       InputStream ips = xmlpost.getResponseBodyAsStream();
/* 267 */       List<Byte> byteList = new ArrayList();
/* 268 */       int is = 0;
/* 269 */       while ((is = ips.read()) != -1)
/* 270 */         byteList.add(Byte.valueOf((byte)is));
/* 271 */       byte[] allb = new byte[byteList.size()];
/* 272 */       for (int j = 0; j < byteList.size(); j++)
/* 273 */         allb[j] = ((Byte)byteList.get(j)).byteValue();
/* 274 */       String responseString = new String(allb, this.charset);
/* 275 */       System.out.println("HTTP返回码=" + responseStatCode);
/* 276 */       System.out.println("应答数据=" + responseString);
/* 277 */       if (this.url.indexOf("https://") != -1)
/* 278 */         Protocol.unregisterProtocol("https");
/* 279 */       return responseString;
/*     */     } catch (IOException e) {
/* 281 */       e.printStackTrace();
/* 282 */       throw new IllegalArgumentException("通信异常");
/*     */     } finally {
/* 284 */       if (xmlpost != null) {
/* 285 */         xmlpost.releaseConnection();
/*     */       }
/* 287 */       if (httpclient != null) {
/* 288 */         httpclient.getHttpConnectionManager().closeIdleConnections(0L);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface PostMethodCallback
/*     */   {
/*     */     public abstract void doInPostMethod(PostMethod paramPostMethod);
/*     */   }
/*     */ }
