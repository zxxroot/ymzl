/*    */ package com.rongdu.cashloan.core.common.web.filter;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.model.TimeProfiler;
/*    */ import java.io.IOException;
/*    */ import java.util.Enumeration;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletRequest;
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
/*    */ public class PerformanceMonitorFilter
/*    */   implements Filter
/*    */ {
/* 26 */   private int threshold = 100;
/*    */   
/*    */   public void init(FilterConfig config) throws ServletException {
/* 29 */     String s = config.getInitParameter("threshold");
/*    */     
/* 31 */     if (s == null) {
/* 32 */       return;
/*    */     }
/* 34 */     this.threshold = Integer.valueOf(s).intValue();
/*    */   }
/*    */   
/*    */   public void destroy() {}
/*    */   
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*    */     throws IOException, ServletException
/*    */   {
/* 42 */     if (TimeProfiler.isProfileEnable()) {
/* 43 */       doFilterWithProfile(request, response, chain);
/*    */     } else {
/* 45 */       chain.doFilter(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   private void doFilterWithProfile(ServletRequest request, ServletResponse response, FilterChain chain)
/*    */     throws IOException, ServletException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: checkcast 74	javax/servlet/http/HttpServletRequest
/*    */     //   4: astore 4
/*    */     //   6: aload 4
/*    */     //   8: ldc 76
/*    */     //   10: invokeinterface 78 2 0
/*    */     //   15: aload_0
/*    */     //   16: aload 4
/*    */     //   18: invokespecial 82	com/rongdu/cashloan/core/common/web/filter/PerformanceMonitorFilter:getProfilerId	(Ljavax/servlet/http/HttpServletRequest;)Ljava/lang/String;
/*    */     //   21: astore 5
/*    */     //   23: aload 5
/*    */     //   25: aload_0
/*    */     //   26: getfield 14	com/rongdu/cashloan/core/common/web/filter/PerformanceMonitorFilter:threshold	I
/*    */     //   29: invokestatic 86	com/rongdu/cashloan/core/common/model/TimeProfiler:start	(Ljava/lang/String;I)Lcom/rongdu/cashloan/core/common/model/TimeProfiler;
/*    */     //   32: astore 6
/*    */     //   34: aload_3
/*    */     //   35: aload_1
/*    */     //   36: aload_2
/*    */     //   37: invokeinterface 63 3 0
/*    */     //   42: goto +19 -> 61
/*    */     //   45: astore 7
/*    */     //   47: aload 6
/*    */     //   49: aload_0
/*    */     //   50: aload 4
/*    */     //   52: invokespecial 90	com/rongdu/cashloan/core/common/web/filter/PerformanceMonitorFilter:getProfilerName	(Ljavax/servlet/http/HttpServletRequest;)Ljava/lang/String;
/*    */     //   55: invokevirtual 93	com/rongdu/cashloan/core/common/model/TimeProfiler:release	(Ljava/lang/String;)V
/*    */     //   58: aload 7
/*    */     //   60: athrow
/*    */     //   61: aload 6
/*    */     //   63: aload_0
/*    */     //   64: aload 4
/*    */     //   66: invokespecial 90	com/rongdu/cashloan/core/common/web/filter/PerformanceMonitorFilter:getProfilerName	(Ljavax/servlet/http/HttpServletRequest;)Ljava/lang/String;
/*    */     //   69: invokevirtual 93	com/rongdu/cashloan/core/common/model/TimeProfiler:release	(Ljava/lang/String;)V
/*    */     //   72: return
/*    */     // Line number table:
/*    */     //   Java source line #52	-> byte code offset #0
/*    */     //   Java source line #53	-> byte code offset #6
/*    */     //   Java source line #54	-> byte code offset #15
/*    */     //   Java source line #55	-> byte code offset #23
/*    */     //   Java source line #57	-> byte code offset #34
/*    */     //   Java source line #58	-> byte code offset #42
/*    */     //   Java source line #59	-> byte code offset #47
/*    */     //   Java source line #60	-> byte code offset #58
/*    */     //   Java source line #59	-> byte code offset #61
/*    */     //   Java source line #61	-> byte code offset #72
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	73	0	this	PerformanceMonitorFilter
/*    */     //   0	73	1	request	ServletRequest
/*    */     //   0	73	2	response	ServletResponse
/*    */     //   0	73	3	chain	FilterChain
/*    */     //   4	61	4	hs	HttpServletRequest
/*    */     //   21	3	5	profilerId	String
/*    */     //   32	30	6	profiler	TimeProfiler
/*    */     //   45	14	7	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   34	45	45	finally
/*    */   }
/*    */   
/*    */   private String getProfilerId(HttpServletRequest hs)
/*    */   {
/* 64 */     StringBuffer id = hs.getRequestURL();
/* 65 */     return id.toString();
/*    */   }
/*    */   
/*    */   private String getProfilerName(HttpServletRequest hs)
/*    */   {
/* 70 */     StringBuffer id = hs.getRequestURL();
/* 71 */     id.append(' ');
/* 72 */     Enumeration enumer = hs.getParameterNames();
/* 73 */     while (enumer.hasMoreElements()) {
/* 74 */       String name = enumer.nextElement().toString();
/* 75 */       String value = hs.getParameter(name);
/* 76 */       id.append('[').append(name).append('=').append(value).append("] ");
/*    */     }
/* 78 */     return id.toString();
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\web\filter\PerformanceMonitorFilter.class

 */