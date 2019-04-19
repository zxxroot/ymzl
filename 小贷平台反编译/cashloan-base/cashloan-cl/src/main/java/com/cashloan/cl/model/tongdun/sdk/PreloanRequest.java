/*    */ package com.cashloan.cl.model.tongdun.sdk;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.cashloan.cl.model.tongdun.http.HttpRestException;
/*    */ import com.cashloan.cl.model.tongdun.http.HttpRestRequest;
/*    */ import com.cashloan.cl.model.tongdun.util.EncryptUtil;
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.springframework.http.HttpHeaders;
/*    */ import org.springframework.http.MediaType;
/*    */ import org.springframework.util.MultiValueMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PreloanRequest
/*    */   extends HttpRestRequest<PreloanResponse>
/*    */ {
/*    */   private String urlParam;
/*    */   private String httpMethod;
/*    */   private String serverHost;
/*    */   
/*    */   public Object getBody()
/*    */     throws Exception
/*    */   {
/* 30 */     Map<String, Object> bodyMap = (Map)JSON.parse(getRequestBody());
/* 31 */     MultiValueMap<String, Object> encodeMap = EncryptUtil.postFormAndEncoder(bodyMap, false);
/* 32 */     return encodeMap;
/*    */   }
/*    */   
/*    */   public HttpHeaders getHeaderMap()
/*    */   {
/* 37 */     HttpHeaders headers = new HttpHeaders();
/* 38 */     headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
/* 39 */     headers.set("Accept-Charset", "utf-8");
/* 40 */     headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
/* 41 */     return headers;
/*    */   }
/*    */   
/*    */   public void check() throws HttpRestException
/*    */   {
/* 46 */     if (StringUtils.isBlank(this.requestBody)) {
/* 47 */       throw new HttpRestException("requestBody 参数不能为空！");
/*    */     }
/*    */   }
/*    */   
/*    */   public void setUrlParam(String urlParam)
/*    */   {
/* 53 */     this.urlParam = urlParam;
/*    */   }
/*    */   
/*    */   public void setHttpMethod(String httpMethod) {
/* 57 */     this.httpMethod = httpMethod;
/*    */   }
/*    */   
/*    */   public void setServerHost(String serverHost) {
/* 61 */     this.serverHost = serverHost;
/*    */   }
/*    */   
/*    */   public String getUrlParam()
/*    */   {
/* 66 */     return this.urlParam;
/*    */   }
/*    */   
/*    */   public String getHttpMethod()
/*    */   {
/* 71 */     return this.httpMethod;
/*    */   }
/*    */   
/*    */   public String getServerHost()
/*    */   {
/* 76 */     return this.serverHost;
/*    */   }
/*    */ }
