/*     */ package com.rongdu.cashloan.system.security.authentication.handler;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.shiro.SecurityUtils;
/*     */ import org.apache.shiro.subject.Subject;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.context.SecurityContext;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.security.core.session.SessionInformation;
/*     */ import org.springframework.security.core.session.SessionRegistry;
/*     */ import org.springframework.security.web.DefaultRedirectStrategy;
/*     */ import org.springframework.security.web.RedirectStrategy;
/*     */ import org.springframework.security.web.authentication.logout.LogoutHandler;
/*     */ import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
/*     */ import org.springframework.security.web.util.UrlUtils;
/*     */ import org.springframework.util.Assert;
/*     */ import org.springframework.web.filter.GenericFilterBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyConcurrentSessionFilter
/*     */   extends GenericFilterBean
/*     */ {
/*     */   private SessionRegistry sessionRegistry;
/*     */   private String expiredUrl;
/*  36 */   private LogoutHandler[] handlers = { new SecurityContextLogoutHandler() };
/*  37 */   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
/*     */   
/*     */ 
/*     */ 
/*     */   public void afterPropertiesSet()
/*     */   {
/*  43 */     Assert.notNull(this.sessionRegistry, "SessionRegistry required");
/*  44 */     Assert.isTrue((this.expiredUrl == null) || (UrlUtils.isValidRedirectUrl(this.expiredUrl)), 
/*  45 */       this.expiredUrl + " isn't a valid redirect URL");
/*     */   }
/*     */   
/*     */ 
/*     */   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
/*     */     throws IOException, ServletException
/*     */   {
/*  52 */     HttpServletRequest request = (HttpServletRequest)req;
/*  53 */     HttpServletResponse response = (HttpServletResponse)res;
/*     */     
/*  55 */     HttpSession session = request.getSession(false);
/*  56 */     if (session != null) {
/*  57 */       if ("/j_spring_security_logout".equals(request.getRequestURI())) {
/*  58 */         session.removeAttribute("SysUser");
/*  59 */         session.removeAttribute("roleId");
/*  60 */         session.removeAttribute("SPRING_SECURITY_CONTEXT");
/*  61 */         session.invalidate();
/*  62 */         SecurityUtils.getSubject().logout();
/*     */       }
/*  64 */       SessionInformation info = this.sessionRegistry.getSessionInformation(session.getId());
/*     */       
/*  66 */       if (info != null) {
/*  67 */         if (info.isExpired()) {
/*  68 */           doLogout(request, response);
/*     */           
/*     */ 
/*  71 */           String targetUrl = determineExpiredUrl(request, info);
/*  72 */           response.setHeader("Location", request.getContextPath() + targetUrl);
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
/*  89 */           Map<String, Object> error = new HashMap();
/*  90 */           error.put("success", Boolean.valueOf(false));
/*  91 */           error.put("errCode", "0x0001");
/*  92 */           error.put("message", "与服务dadads的会话已经超时");
/*  93 */           error.put("data", "");
/*  94 */           response.setHeader("Location", request.getContextPath() + targetUrl);
/*  95 */           response.setCharacterEncoding("UTF-8");
/*  96 */           response.addHeader("__timeout", "true");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 104 */           ServletUtils.writeToResponse(response, error);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 109 */           info.refreshLastRequest();
/*     */         }
/*     */       }
/*     */     } else {
/* 113 */       response.addHeader("sessionstatus", "timeout");
/*     */       
/* 115 */       Map<String, Object> error = new HashMap();
/* 116 */       error.put("code", "800");
/*     */       
/* 118 */       error.put("msg", "与服务器的会话已经超时");
/* 119 */       error.put("data", "");
/* 120 */       response.setCharacterEncoding("UTF-8");
/* 121 */       response.addHeader("__timeout", "true");
/* 122 */       ServletUtils.writeToResponse(response, error);
/*     */       
/* 124 */       return;
/*     */     }
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
/* 148 */     chain.doFilter(request, response);
/*     */   }
/*     */   
/*     */   protected String determineExpiredUrl(HttpServletRequest request, SessionInformation info)
/*     */   {
/* 153 */     return this.expiredUrl;
/*     */   }
/*     */   
/*     */   private void doLogout(HttpServletRequest request, HttpServletResponse response) {
/* 157 */     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
/*     */     
/* 159 */     for (int i = 0; i < this.handlers.length; i++) {
/* 160 */       this.handlers[i].logout(request, response, auth);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setExpiredUrl(String expiredUrl) {
/* 165 */     this.expiredUrl = expiredUrl;
/*     */   }
/*     */   
/*     */   public void setSessionRegistry(SessionRegistry sessionRegistry) {
/* 169 */     this.sessionRegistry = sessionRegistry;
/*     */   }
/*     */   
/*     */   public void setLogoutHandlers(LogoutHandler[] handlers) {
/* 173 */     Assert.notNull(handlers);
/* 174 */     this.handlers = handlers;
/*     */   }
/*     */   
/*     */   public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
/* 178 */     this.redirectStrategy = redirectStrategy;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\authentication\handler\MyConcurrentSessionFilter.class

 */