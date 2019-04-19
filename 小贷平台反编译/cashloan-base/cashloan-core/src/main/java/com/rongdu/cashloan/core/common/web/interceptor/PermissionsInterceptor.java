/*    */ package com.rongdu.cashloan.core.common.web.interceptor;
/*    */ 
/*    */ import com.rongdu.cashloan.system.service.SysMenuService;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContext;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class PermissionsInterceptor extends org.springframework.web.servlet.handler.HandlerInterceptorAdapter
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("sysMenuServiceImpl")
/*    */   private SysMenuService sysMenuService;
/*    */   
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
/*    */   {
/* 24 */     if (SecurityContextHolder.getContext().getAuthentication() == null) {
/* 25 */       return true;
/*    */     }
/*    */     
/* 28 */     UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/* 29 */     if ((user == null) || (user.getUsername() == null)) {
/* 30 */       response.setContentType("text/html;charset=utf-8");
/* 31 */       response.getWriter().print("您未登录，请登录后继续此操作!");
/* 32 */       return false;
/*    */     }
/* 34 */     String url = request.getServletPath();
/* 35 */     if ((url == null) || (url.length() <= 0)) {
/* 36 */       return true;
/*    */     }
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
/* 50 */     return true;
/*    */   }
/*    */ }
