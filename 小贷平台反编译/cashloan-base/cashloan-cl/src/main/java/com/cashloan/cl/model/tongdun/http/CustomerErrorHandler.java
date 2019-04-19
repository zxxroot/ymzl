/*    */ package com.cashloan.cl.model.tongdun.http;
/*    */ 
/*    */ import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

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
/*    */ public class CustomerErrorHandler
/*    */   extends DefaultResponseErrorHandler
/*    */ {
/* 21 */   private static final Logger logger = Logger.getLogger(CustomerErrorHandler.class);
/*    */   
/*    */   public void handleError(ClientHttpResponse response)
/*    */     throws IOException
/*    */   {
/* 26 */     HttpStatus statusCode = response.getStatusCode();
/* 27 */     if ((statusCode.is4xxClientError()) || (statusCode.is5xxServerError()))
/*    */     {
/* 29 */       HttpClientErrorException exception = new HttpClientErrorException(statusCode, response.getStatusText(), 
/* 30 */         response.getHeaders(), getResponseBody(response), getCharset(response));
/* 31 */       exception.getResponseBodyAsString();
/*    */     }
/*    */   }
/*    */   
/*    */
protected byte[] getResponseBody(ClientHttpResponse response) {
/*    */     try {
/* 37 */       InputStream responseBody = response.getBody();
/* 38 */       if (responseBody != null) {
/* 39 */         return FileCopyUtils.copyToByteArray(responseBody);
/*    */       }
/*    */     } catch (IOException ex) {
/* 42 */       logger.error(ex);
/*    */     }
/* 44 */     return new byte[0];
/*    */   }
/*    */   
/*    */   protected Charset getCharset(ClientHttpResponse response) {
/* 48 */     HttpHeaders headers = response.getHeaders();
/* 49 */     MediaType contentType = headers.getContentType();
/* 50 */     return contentType != null ? contentType.getCharset() : null;
/*    */   }
/*    */ }
