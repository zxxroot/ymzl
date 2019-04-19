/*    */ package com.rongdu.cashloan.core.common.web.filter;
/*    */ 
/*    */ import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

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
/*    */ public class RemoteAddressFilter
/*    */   implements Filter
/*    */ {
/*    */   private static final String FORWARD_PARAMTER_NAME = "forwardParameter";
/* 25 */   private String forwardParameter = "X-Forwarded-For";
/*    */   
/*    */   public void init(FilterConfig fc) throws ServletException {
/* 28 */     String get = fc.getInitParameter("forwardParameter");
/* 29 */     if (get != null) {
/* 30 */       this.forwardParameter = get.trim();
/*    */     }
/*    */   }
/*    */   
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
/*    */     throws IOException, ServletException
/*    */   {
/* 37 */     if (!(request instanceof HttpServletRequest)) {
/* 38 */       fc.doFilter(request, response);
/* 39 */       return;
/*    */     }
/*    */     
/*    */ 
/* 43 */     if ((request instanceof RemoteIpRequestWrapper)) {
/* 44 */       fc.doFilter(request, response);
/* 45 */       return;
/*    */     }
/*    */     
/* 48 */     HttpServletRequest hsr = (HttpServletRequest)request;
/* 49 */     String forward = hsr.getHeader(this.forwardParameter);
/* 50 */     if (forward == null) {
/* 51 */       fc.doFilter(request, response);
/* 52 */       return;
/*    */     }
/* 54 */     fc.doFilter(new RemoteIpRequestWrapper(hsr, forward), response);
/*    */   }
/*    */   
/*    */   public void destroy() {}
/*    */   
/*    */   private static class RemoteIpRequestWrapper extends HttpServletRequestWrapper {
/*    */     private String remoteIp;
/*    */     
/* 62 */     public RemoteIpRequestWrapper(HttpServletRequest request, String ip) {
    super(request);
/* 63 */       this.remoteIp = ip;
/*    */     }
/*    */     
/*    */     public String getRemoteAddr()
/*    */     {
/* 68 */       return this.remoteIp;
/*    */     }
/*    */   }
/*    */ }
