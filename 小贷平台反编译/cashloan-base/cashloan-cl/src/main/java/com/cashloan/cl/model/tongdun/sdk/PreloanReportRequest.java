/*    */ package com.cashloan.cl.model.tongdun.sdk;
/*    */ 
/*    */ import com.cashloan.cl.model.tongdun.http.HttpRestException;
/*    */ import com.cashloan.cl.model.tongdun.http.HttpRestRequest;
/*    */ import java.util.Arrays;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.springframework.http.HttpHeaders;
/*    */ import org.springframework.http.MediaType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PreloanReportRequest
/*    */   extends HttpRestRequest<PreloanReportResponse>
/*    */ {
/*    */   private String urlParam;
/*    */   private String httpMethod;
/*    */   private String serverHost;
/*    */   
/*    */   public Object getBody()
/*    */     throws Exception
/*    */   {
/* 44 */     return null;
/*    */   }
/*    */   
/*    */   public HttpHeaders getHeaderMap()
/*    */   {
/* 49 */     HttpHeaders headers = new HttpHeaders();
/* 50 */     headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
/* 51 */     headers.set("Accept-Charset", "utf-8");
/* 52 */     headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
/* 53 */     return headers;
/*    */   }
/*    */   
/*    */   public void check() throws HttpRestException
/*    */   {
/* 58 */     if (StringUtils.isBlank(this.requestBody)) {
/* 59 */       throw new HttpRestException("requestBody 参数不能为空！");
/*    */     }
/*    */   }
/*    */   
/*    */   public String getUrlParam() {
/* 64 */     return this.urlParam;
/*    */   }
/*    */   
/*    */   public void setUrlParam(String urlParam) {
/* 68 */     this.urlParam = urlParam;
/*    */   }
/*    */   
/*    */   public String getHttpMethod() {
/* 72 */     return this.httpMethod;
/*    */   }
/*    */   
/*    */   public void setHttpMethod(String httpMethod) {
/* 76 */     this.httpMethod = httpMethod;
/*    */   }
/*    */   
/*    */   public String getServerHost() {
/* 80 */     return this.serverHost;
/*    */   }
/*    */   
/*    */   public void setServerHost(String serverHost) {
/* 84 */     this.serverHost = serverHost;
/*    */   }
/*    */ }
