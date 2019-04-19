/*    */ package com.rongdu.cashloan.system.security.authentication.handler;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
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
/*    */ public class RdAuthenticationEntryPoint
/*    */   extends LoginUrlAuthenticationEntryPoint
/*    */ {
/* 24 */   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
/*    */   
/* 26 */   private static final Log logger = LogFactory.getLog(RdAuthenticationEntryPoint.class);

    public RdAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    /*    */
/*    */ 
/*    */   public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
/*    */     throws IOException, ServletException
/*    */   {
/* 32 */     HttpServletRequest httpRequest = request;
/* 33 */     HttpServletResponse httpResponse = response;
/*    */     
/* 35 */     String url = request.getRequestURI();
/* 36 */     logger.info("commence------------");
/* 37 */     if (logger.isDebugEnabled()) {
/* 38 */       logger.debug("url:" + url);
/*    */     }
/*    */     
/* 41 */     if (logger.isDebugEnabled()) {
/* 42 */       logger.debug("ajax request or post");
/*    */     }
/*    */     
/* 45 */     if (request.getHeader("x-requested-with") != null)
/*    */     {
/* 47 */       if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
/* 48 */         response.addHeader("sessionstatus", "timeout");
/*    */         
/* 50 */         Map<String, Object> error = new HashMap();
/* 51 */         error.put("code", "800");
/*    */         
/* 53 */         error.put("msg", "与服务器的会话已经超时");
/* 54 */         error.put("data", "");
/* 55 */         response.setCharacterEncoding("UTF-8");
/* 56 */         response.addHeader("__timeout", "true");
/* 57 */         ServletUtils.writeToResponse(response, error);
/* 58 */         logger.info("------- test=====================");
/* 59 */         return;
/*    */       } }
/* 61 */     super.commence(httpRequest, httpResponse, authException);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\authentication\handler\RdAuthenticationEntryPoint.class

 */