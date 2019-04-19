/*    */ package com.rongdu.cashloan.system.security.authentication.handler;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.security.core.AuthenticationException;
/*    */ import org.springframework.security.web.DefaultRedirectStrategy;
/*    */ import org.springframework.security.web.RedirectStrategy;
/*    */ import org.springframework.security.web.authentication.AuthenticationFailureHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AccessAuthenticationFailureHandler
/*    */   implements AuthenticationFailureHandler
/*    */ {
/* 25 */   private static final Logger logger = LoggerFactory.getLogger(AccessAuthenticationFailureHandler.class);
/*    */   private String defaultFailureUrl;
/* 27 */   private boolean forwardToDestination = false;
/* 28 */   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
/*    */   
/*    */ 
/*    */   public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
/*    */     throws IOException, ServletException
/*    */   {
/* 34 */     Map<String, Object> context = new HashMap();
/*    */     
/* 36 */     context.put("code", Integer.valueOf(400));
/* 37 */     context.put("msg", "登录失败");
/* 38 */     ServletUtils.writeToResponse(response, context);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\authentication\handler\AccessAuthenticationFailureHandler.class

 */