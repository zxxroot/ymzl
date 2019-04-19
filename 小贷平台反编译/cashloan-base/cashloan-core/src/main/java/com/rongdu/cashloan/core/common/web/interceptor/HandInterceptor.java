/*     */ package com.rongdu.cashloan.core.common.web.interceptor;
/*     */ 
/*     */

import com.rongdu.cashloan.system.service.SysMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;
import tool.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class HandInterceptor
/*     */   extends HandlerInterceptorAdapter
/*     */ {
/*  27 */   private static final Logger log = Logger.getLogger(HandInterceptor.class);
/*     */   
/*     */ 
/*     */   @Autowired
/*     */   @Qualifier("sysMenuServiceImpl")
/*     */   private SysMenuService sysMenuService;
/*     */   
/*     */   private HttpServletRequest request;
/*     */   
/*  36 */   private MethodNameResolver methodNameResolver = new InternalPathMethodNameResolver();
/*     */   
/*     */   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception
/*     */   {
/*  40 */     this.request = request;
/*  41 */     String methodName = this.methodNameResolver.getHandlerMethodName(request);
/*  42 */     saveOperatorLog(methodName);
/*  43 */     if (e != null) {
/*  44 */       log.error("Exception message   :", e);
/*  45 */       saveExceptionLog(methodName, e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void saveOperatorLog(String methodName) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void saveExceptionLog(String methodName, Exception e)
/*     */   {
/*  89 */     StringWriter sw = new StringWriter();
/*  90 */     e.printStackTrace(new PrintWriter(sw, true));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isOperatorLog(String path)
/*     */   {
/* 118 */     String[] urlArr = { "Add.htm", "Edit.htm", "Delete.htm" };
/* 119 */     for (int i = 0; i < urlArr.length; i++) {
/* 120 */       String url = urlArr[i];
/* 121 */       int size = path.lastIndexOf(url);
/* 122 */       if (size > 0) {
/* 123 */         return true;
/*     */       }
/*     */     }
/* 126 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String getAllParams(boolean safety)
/*     */   {
/* 135 */     StringBuilder ps = new StringBuilder();
/* 136 */     Enumeration<?> parameterNames = this.request.getParameterNames();
/* 137 */     while (parameterNames.hasMoreElements()) {
/* 138 */       String parameter = (String)parameterNames.nextElement();
/* 139 */       String value = this.request.getParameter(parameter);
/* 140 */       if ((StringUtil.isNotBlank(value)) && (
/* 141 */         (safety) || ((!parameter.contains("password")) && (!parameter.contains("pwd"))))) {
/* 142 */         ps.append(parameter + "=" + value);
/* 143 */         if (parameterNames.hasMoreElements()) {
/* 144 */           ps.append("&");
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 149 */     return ps.toString();
/*     */   }
/*     */ }
