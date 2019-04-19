/*    */ package com.rongdu.cashloan.system.security.datesource;
/*    */ 
/*    */ import com.rongdu.cashloan.system.security.userdetails.UserFunction;
/*    */ import com.rongdu.cashloan.system.security.userdetails.UserRole;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import org.springframework.security.access.ConfigAttribute;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContext;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.security.web.FilterInvocation;
/*    */ import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/*    */ import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/*    */ import org.springframework.security.web.util.matcher.RequestMatcher;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SecurityContextMetadataSource
/*    */   implements FilterInvocationSecurityMetadataSource
/*    */ {
/*    */   public Collection<ConfigAttribute> getAttributes(Object obj)
/*    */     throws IllegalArgumentException
/*    */   {
/* 27 */     String url = ((FilterInvocation)obj).getRequestUrl();
/* 28 */     RequestMatcher urlMatcher = new AntPathRequestMatcher(url);
/* 29 */     Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/* 30 */     if ((principal instanceof UserRole)) {
/* 31 */       UserRole userRole = (UserRole)principal;
/* 32 */       Map<String, UserFunction> resouceMap = userRole.getFunctionMap();
/* 33 */       if ((resouceMap != null) && (!resouceMap.isEmpty())) {
/* 34 */         for (Map.Entry<String, UserFunction> res : resouceMap.entrySet()) {
/* 35 */           if (urlMatcher.matches(((FilterInvocation)obj).getHttpRequest())) {
/* 36 */             return ((UserFunction)res.getValue()).getRoles();
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 41 */     return null;
/*    */   }
/*    */   
/*    */   public boolean supports(Class<?> clazz) {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public Collection<ConfigAttribute> getAllConfigAttributes() {
/* 49 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\datesource\SecurityContextMetadataSource.class

 */