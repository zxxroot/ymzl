/*    */ package com.cashloan.cl.model.tongdun.http;
/*    */ 
/*    */ import org.springframework.http.HttpHeaders;

import java.lang.reflect.Type;
import java.util.Map;

/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class HttpRestRequest<T extends HttpRestResponse>
/*    */ {
/*    */   public static final String GET = "GET";
/*    */   public static final String POST = "POST";
/*    */   public static final String DELETE = "DELETE";
/*    */   public static final String PUT = "PUT";
/*    */   public static final String HEAD = "HEAD";
/*    */   public static final String PATCH = "PATCH";
/*    */   private Map<String, Object> paramMap;
/*    */   protected String requestBody;
/*    */   private Class<T> clazz;
/*    */   
/*    */   public HttpRestRequest()
/*    */   {
/* 37 */     Type type = getClass().getGenericSuperclass();
/* 38 */     this.clazz = ((Class)((java.lang.reflect.ParameterizedType)type).getActualTypeArguments()[0]);
/*    */   }
/*    */   
/*    */   public String getRequestBody()
/*    */   {
/* 43 */     return this.requestBody;
/*    */   }
/*    */   
/*    */   public Map<String, Object> getParamMap() {
/* 47 */     return this.paramMap;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setParamMap(Map<String, Object> map)
/*    */   {
/* 56 */     this.paramMap = map;
/* 57 */     this.requestBody = ((String)this.paramMap.get("body"));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract String getUrlParam();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract String getHttpMethod();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract Object getBody()
/*    */     throws Exception;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract String getServerHost();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Class<T> getResponseClass()
/*    */   {
/* 98 */     return this.clazz;
/*    */   }
/*    */   
/*    */   public abstract HttpHeaders getHeaderMap();
/*    */   
/*    */   public abstract void check()
/*    */     throws HttpRestException;
/*    */ }
