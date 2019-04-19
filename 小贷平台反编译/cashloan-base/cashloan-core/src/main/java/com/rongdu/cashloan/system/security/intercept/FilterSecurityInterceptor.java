/*    */ package com.rongdu.cashloan.system.security.intercept;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import org.springframework.security.access.SecurityMetadataSource;
/*    */ import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
/*    */ import org.springframework.security.web.FilterInvocation;
/*    */ import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FilterSecurityInterceptor
/*    */   extends AbstractSecurityInterceptor
/*    */   implements Filter
/*    */ {
/*    */   private FilterInvocationSecurityMetadataSource securityMetadataSource;
/*    */   
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*    */     throws IOException, ServletException
/*    */   {
/* 28 */     FilterInvocation fi = new FilterInvocation(request, response, chain);
/* 29 */     invoke(fi);
/*    */   }
/*    */   
/*    */   public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
/* 33 */     return this.securityMetadataSource;
/*    */   }
/*    */   
/*    */   public Class<? extends Object> getSecureObjectClass() {
/* 37 */     return FilterInvocation.class;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void invoke(FilterInvocation fi)
/*    */     throws IOException, ServletException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: invokespecial 49	org/springframework/security/access/intercept/AbstractSecurityInterceptor:beforeInvocation	(Ljava/lang/Object;)Lorg/springframework/security/access/intercept/InterceptorStatusToken;
/*    */     //   5: astore_2
/*    */     //   6: aload_1
/*    */     //   7: invokevirtual 53	org/springframework/security/web/FilterInvocation:getChain	()Ljavax/servlet/FilterChain;
/*    */     //   10: aload_1
/*    */     //   11: invokevirtual 57	org/springframework/security/web/FilterInvocation:getRequest	()Ljavax/servlet/http/HttpServletRequest;
/*    */     //   14: aload_1
/*    */     //   15: invokevirtual 61	org/springframework/security/web/FilterInvocation:getResponse	()Ljavax/servlet/http/HttpServletResponse;
/*    */     //   18: invokeinterface 65 3 0
/*    */     //   23: goto +13 -> 36
/*    */     //   26: astore_3
/*    */     //   27: aload_0
/*    */     //   28: aload_2
/*    */     //   29: aconst_null
/*    */     //   30: invokespecial 70	org/springframework/security/access/intercept/AbstractSecurityInterceptor:afterInvocation	(Lorg/springframework/security/access/intercept/InterceptorStatusToken;Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   33: pop
/*    */     //   34: aload_3
/*    */     //   35: athrow
/*    */     //   36: aload_0
/*    */     //   37: aload_2
/*    */     //   38: aconst_null
/*    */     //   39: invokespecial 70	org/springframework/security/access/intercept/AbstractSecurityInterceptor:afterInvocation	(Lorg/springframework/security/access/intercept/InterceptorStatusToken;Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   42: pop
/*    */     //   43: return
/*    */     // Line number table:
/*    */     //   Java source line #41	-> byte code offset #0
/*    */     //   Java source line #43	-> byte code offset #6
/*    */     //   Java source line #44	-> byte code offset #23
/*    */     //   Java source line #45	-> byte code offset #27
/*    */     //   Java source line #46	-> byte code offset #34
/*    */     //   Java source line #45	-> byte code offset #36
/*    */     //   Java source line #47	-> byte code offset #43
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	44	0	this	FilterSecurityInterceptor
/*    */     //   0	44	1	fi	FilterInvocation
/*    */     //   5	33	2	token	org.springframework.security.access.intercept.InterceptorStatusToken
/*    */     //   26	9	3	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   6	26	26	finally
/*    */   }
/*    */   
/*    */   public SecurityMetadataSource obtainSecurityMetadataSource()
/*    */   {
/* 50 */     return this.securityMetadataSource;
/*    */   }
/*    */   
/*    */   public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
/* 54 */     this.securityMetadataSource = newSource;
/*    */   }
/*    */   
/*    */   public void destroy() {}
/*    */   
/*    */   public void init(FilterConfig arg0)
/*    */     throws ServletException
/*    */   {}
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\security\intercept\FilterSecurityInterceptor.class

 */