/*    */ package com.rongdu.cashloan.system.security.authentication.handler;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonEncoding;
/*    */ import com.fasterxml.jackson.core.JsonFactory;
/*    */ import com.fasterxml.jackson.core.JsonGenerator;
/*    */ import com.fasterxml.jackson.core.JsonProcessingException;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.http.converter.HttpMessageNotWritableException;
/*    */ import org.springframework.security.core.AuthenticationException;
/*    */ import org.springframework.security.web.authentication.AuthenticationFailureHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AjaxAuthenticationFailureHandler
/*    */   implements AuthenticationFailureHandler
/*    */ {
/* 26 */   protected final Log logger = LogFactory.getLog(getClass());
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
/*    */     throws IOException, ServletException
/*    */   {
/* 34 */     ObjectMapper objectMapper = new ObjectMapper();
/* 35 */     response.setHeader("Content-Type", "application/json;charset=UTF-8");
/* 36 */     JsonGenerator jsonGenerator = objectMapper.getJsonFactory()
/* 37 */       .createJsonGenerator(response.getOutputStream(), 
/* 38 */       JsonEncoding.UTF8);
/*    */     try
/*    */     {
/* 41 */       Map<String, Object> context = new HashMap();
/* 42 */       context.put("code", Integer.valueOf(400));
/* 43 */       context.put("msg", "登录失败，用户名或者密码错误");
/* 44 */       objectMapper.writeValue(jsonGenerator, context);
/*    */     }
/*    */     catch (JsonProcessingException ex) {
/* 47 */       throw new HttpMessageNotWritableException("Could not write JSON: " + 
/* 48 */         ex.getMessage(), ex);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\authentication\handler\AjaxAuthenticationFailureHandler.class

 */