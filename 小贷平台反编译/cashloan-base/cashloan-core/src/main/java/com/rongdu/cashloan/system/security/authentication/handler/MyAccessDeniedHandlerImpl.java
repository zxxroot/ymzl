/*    */ package com.rongdu.cashloan.system.security.authentication.handler;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.security.access.AccessDeniedException;
/*    */ import org.springframework.security.web.access.AccessDeniedHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyAccessDeniedHandlerImpl
/*    */   implements AccessDeniedHandler
/*    */ {
/*    */   public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
/*    */     throws IOException, ServletException
/*    */   {
/* 24 */     Map<String, Object> context = new HashMap();
/* 25 */     context.put("code", Integer.valueOf(400));
/* 26 */     context.put("msg", "登录失败");
/* 27 */     ServletUtils.writeToResponse(response, context);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\authentication\handler\MyAccessDeniedHandlerImpl.class

 */