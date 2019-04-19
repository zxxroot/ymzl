/*    */ package com.cashloan.cl.model.tongdun.http;
/*    */ 
/*    */

import org.springframework.http.ResponseEntity;

/*    */
/*    */ 
/*    */ public class ResponseDataToJsonParser<T extends HttpRestResponse>
/*    */   implements HttpResponseParser<T>
/*    */ {
/*    */   private Class<T> clazz;
/*    */   
/*    */   public ResponseDataToJsonParser(Class<T> clazz)
/*    */   {
/* 13 */     this.clazz = clazz;
/*    */   }
/*    */   
/*    */   public T handle(ResponseEntity<String> responseBody) throws HttpRestException
/*    */   {
/* 18 */     T response = null;
/* 19 */     int status = responseBody.getStatusCode().value();
/* 20 */     String body = (String)responseBody.getBody();
/*    */     try
/*    */     {
/* 23 */       response = JsonFieldAutoPickGenerator.autoSetter(body, this.clazz);
/* 24 */       response.setBody(body);
/* 25 */       response.setCode(Integer.valueOf(status));
/* 26 */       response.setMessage("");
/*    */     } catch (Exception e) {
/* 28 */       throw new HttpRestException(e.getMessage(), e);
/*    */     }
/* 30 */     return response;
/*    */   }
/*    */ }
