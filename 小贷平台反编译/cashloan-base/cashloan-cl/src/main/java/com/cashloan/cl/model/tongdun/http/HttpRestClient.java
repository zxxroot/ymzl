/*    */ package com.cashloan.cl.model.tongdun.http;
/*    */ 
/*    */ import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

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
/*    */ public class HttpRestClient
/*    */ {
/* 20 */   private static final Logger logger = Logger.getLogger(HttpRestClient.class);
/*    */   
/* 22 */   private static HttpRestClient instance = new HttpRestClient();
/*    */   
/*    */   private static SimpleClientHttpRequestFactory requestFactory;
/*    */   
/*    */   private HttpRestClient()
/*    */   {
/* 28 */     requestFactory = new SimpleClientHttpRequestFactory();
/* 29 */     requestFactory.setConnectTimeout(5000);
/* 30 */     requestFactory.setReadTimeout(30000);
/*    */   }
/*    */   
/*    */   public static HttpRestClient create() {
/* 34 */     return instance;
/*    */   }
/*    */   
/* 37 */   public <T extends HttpRestResponse> T executeThenGetJsonResponse(HttpRestRequest<T> request) {
    return _execute(request, (HttpResponseParser<T>) new ResponseDataToJsonParser(request.getResponseClass())); }
/*    */   
/*    */ 
/*    */   private <T extends HttpRestResponse> T _execute(HttpRestRequest<T> request, HttpResponseParser<T> parser)
/*    */   {
/* 42 */     RestTemplate restTemplate = new RestTemplate(requestFactory);
/* 43 */     restTemplate.setErrorHandler(new CustomerErrorHandler());
/*    */     
/* 45 */     T response = null;
/*    */     try
/*    */     {
/* 48 */       String httpMethod = request.getHttpMethod();
/* 49 */       Object body = request.getBody();
/* 50 */       String host = request.getServerHost();
/* 51 */       String urlParam = request.getUrlParam();
/* 52 */       if ((urlParam != null) && (!urlParam.isEmpty())) {
/* 53 */         host = host + "?" + urlParam;
/*    */       }
/* 55 */       HttpHeaders header = request.getHeaderMap();
/* 56 */       URI u = new URI(host);
/* 57 */       HttpEntity<?> httpEntity = new HttpEntity(body, header);
/* 58 */       ResponseEntity<String> result = null;
/* 59 */       String str1; switch ((str1 = httpMethod).hashCode()) {case 70454:  if (str1.equals("GET")) {} break; case 79599:  if (str1.equals("PUT")) {} break; case 2461856:  if (str1.equals("POST")) break; break; case 2012838315:  if (!str1.equals("DELETE")) {
/* 61 */           restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
/* 62 */           result = restTemplate.exchange(u, HttpMethod.POST, httpEntity, String.class);
/*    */           
/* 65 */           result = restTemplate.exchange(u, HttpMethod.GET, httpEntity, String.class);
/*    */           
/* 68 */           result = restTemplate.exchange(u, HttpMethod.PUT, httpEntity, String.class);
/*    */         }
/*    */         else {
/* 71 */           result = restTemplate.exchange(u, HttpMethod.DELETE, httpEntity, String.class); }
/*    */         break; }
/*    */       label310:
/* 74 */       if (result != null) {
/* 75 */         response = parser.handle(result);
/* 76 */         response.setHttpRestRequest(request);
/*    */       }
/*    */     } catch (HttpRestException e) {
/*    */       try {
/* 80 */         response = (T) request.getResponseClass().newInstance();
/* 81 */         response.setCode(Integer.valueOf(400));
/* 82 */         response.setMessage(e.getErrMsg());
/*    */       } catch (Exception e1) {
/* 84 */         logger.error(e1);
/*    */       }
/*    */     } catch (Exception e) {
/*    */       try {
/* 88 */         response.setCode(Integer.valueOf(200));
/* 89 */         response.setMessage("请求失败");
/*    */       } catch (Exception e1) {
/* 91 */         logger.error(e1);
/*    */       }
/*    */     }
/* 94 */     return response;
/*    */   }
/*    */ }
