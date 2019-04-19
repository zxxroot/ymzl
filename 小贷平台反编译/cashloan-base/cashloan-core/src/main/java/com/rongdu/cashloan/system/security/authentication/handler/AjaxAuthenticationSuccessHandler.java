/*    */ package com.rongdu.cashloan.system.security.authentication.handler;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonEncoding;
/*    */ import com.fasterxml.jackson.core.JsonFactory;
/*    */ import com.fasterxml.jackson.core.JsonGenerator;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.http.converter.HttpMessageNotWritableException;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AjaxAuthenticationSuccessHandler
/*    */   implements AuthenticationSuccessHandler
/*    */ {
/*    */   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
/*    */     throws IOException, ServletException
/*    */   {
/* 29 */     ObjectMapper objectMapper = new ObjectMapper();
/* 30 */     response.setHeader("Content-Type", "application/json;charset=UTF-8");
/* 31 */     JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), 
/* 32 */       JsonEncoding.UTF8);
/*    */     try
/*    */     {
/* 35 */       Map<String, Object> context = new HashMap();
/* 36 */       context.put("code", Integer.valueOf(200));
/* 37 */       objectMapper.writeValue(jsonGenerator, context);
/*    */     } catch (Exception ex) {
/* 39 */       throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\authentication\handler\AjaxAuthenticationSuccessHandler.class

 */