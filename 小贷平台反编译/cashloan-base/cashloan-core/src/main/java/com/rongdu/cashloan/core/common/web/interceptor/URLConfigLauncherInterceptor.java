/*    */ package com.rongdu.cashloan.core.common.web.interceptor;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.model.URLConfig;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class URLConfigLauncherInterceptor
/*    */   extends HandlerInterceptorAdapter
/*    */ {
/*    */   private Map<String, URLConfig> urlConfigs;
/*    */   
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/*    */     throws Exception
/*    */   {
/* 24 */     for (Map.Entry<String, URLConfig> entry : this.urlConfigs.entrySet()) {
/* 25 */       request.setAttribute((String)entry.getKey(), entry.getValue());
/*    */     }
/* 27 */     return super.preHandle(request, response, handler);
/*    */   }
/*    */   
/*    */   public Map<String, URLConfig> getUrlConfigs() {
/* 31 */     return this.urlConfigs;
/*    */   }
/*    */   
/*    */   public void setUrlConfigs(Map<String, URLConfig> urlConfigs) {
/* 35 */     this.urlConfigs = urlConfigs;
/*    */   }
/*    */ }
