/*     */ package com.rongdu.cashloan.manage.interceptor;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.DateUtils;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.shiro.SecurityUtils;
/*     */ import org.apache.shiro.session.Session;
/*     */ import org.apache.shiro.subject.Subject;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.core.NamedThreadLocal;
/*     */ import org.springframework.web.servlet.HandlerInterceptor;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConLogInterceptor
/*     */   implements HandlerInterceptor
/*     */ {
/*  27 */   private static final Logger logger = LoggerFactory.getLogger(ConLogInterceptor.class);
/*  28 */   private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal("ThreadLocal StartTime");
/*     */   
/*     */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
/*     */   {
/*  32 */     Session session = SecurityUtils.getSubject().getSession();
/*  33 */     if ((SecurityUtils.getSubject() == null) || (session == null)) {
/*  34 */       return true;
/*     */     }
/*  36 */     response.addHeader("Access-Control-Allow-Origin", "*");
/*     */     
/*  38 */     if (!request.getRequestURI().contains("channel")) {
/*  39 */       SysUser sysUser = (SysUser)session.getAttribute("SysUser");
/*  40 */       if (sysUser == null) {
/*  41 */         System.out.print("##");
/*  42 */         Map<String, Object> result = new HashMap();
/*  43 */         result.put("code", Integer.valueOf(800));
/*  44 */         result.put("msg", "您未登录或登录已过期，请登录后再操作");
/*  45 */         ServletUtils.writeToResponse(response, result);
/*  46 */         return false;
/*     */       }
/*  48 */       if (sysUser.getStatus().equals(Byte.valueOf((byte)1))) {
/*  49 */         Map<String, Object> result = new HashMap();
/*  50 */         result.put("code", Integer.valueOf(800));
/*  51 */         result.put("msg", "您的账户已被锁定，请联系管理员解锁");
/*  52 */         ServletUtils.writeToResponse(response, result);
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       if (logger.isDebugEnabled()) {
/*  57 */         String ip = getRemoteHost(request);
/*  58 */         long beginTime = System.currentTimeMillis();
/*  59 */         startTimeThreadLocal.set(Long.valueOf(beginTime));
/*  60 */         logger.debug("{}正在访问URI: {}", ip, request.getRequestURI());
/*     */       }
/*     */     }
/*     */     
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
/*     */   {
/*  69 */     if (modelAndView != null) {
/*  70 */       logger.debug("ViewName: " + modelAndView.getViewName());
/*     */     }
/*     */   }
/*     */   
/*     */   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
/*     */     throws Exception
/*     */   {
/*  77 */     if (logger.isDebugEnabled()) {
/*  78 */       long beginTime = ((Long)startTimeThreadLocal.get()).longValue();
/*  79 */       long endTime = System.currentTimeMillis();
/*  80 */       String ip = getRemoteHost(request);
/*  81 */       logger.debug(
/*  82 */         "{}响应结束：  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  剩余内存: {}m  最大可用内存: {}m", new Object[] {
/*  83 */         ip, 
/*  84 */         DateUtils.formatDateTime(endTime - beginTime), 
/*  85 */         request.getRequestURI(), 
/*  86 */         Long.valueOf(Runtime.getRuntime().maxMemory() / 1024L / 1024L), 
/*  87 */         Long.valueOf(Runtime.getRuntime().totalMemory() / 1024L / 1024L), 
/*  88 */         Long.valueOf(Runtime.getRuntime().freeMemory() / 1024L / 1024L), 
/*  89 */         Long.valueOf((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024L / 1024L) });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private String getRemoteHost(HttpServletRequest request)
/*     */   {
/*  96 */     String ip = request.getHeader("x-forwarded-for");
/*  97 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/*  98 */       ip = request.getHeader("Proxy-Client-IP");
/*     */     }
/* 100 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 101 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*     */     }
/* 103 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 104 */       ip = request.getRemoteAddr();
/*     */     }
/* 106 */     return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\interceptor\ConLogInterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */