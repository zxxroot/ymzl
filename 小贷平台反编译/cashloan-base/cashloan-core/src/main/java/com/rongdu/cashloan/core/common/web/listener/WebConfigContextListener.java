/*    */ package com.rongdu.cashloan.core.common.web.listener;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.CacheUtil;
/*    */ import javax.servlet.ServletContextEvent;
/*    */ import javax.servlet.ServletContextListener;
/*    */ import javax.servlet.http.HttpSessionAttributeListener;
/*    */ import javax.servlet.http.HttpSessionBindingEvent;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class WebConfigContextListener
/*    */   implements ServletContextListener, HttpSessionAttributeListener
/*    */ {
/* 25 */   private static Logger logger = Logger.getLogger(WebConfigContextListener.class);
/*    */   
/*    */ 
/*    */ 
/*    */   public void contextDestroyed(ServletContextEvent event) {}
/*    */   
/*    */ 
/*    */   public void contextInitialized(ServletContextEvent event)
/*    */   {
/* 34 */     logger.info("启动加载...");
/*    */     
/*    */ 
/* 37 */     CacheUtil.initSysConfig();
/*    */   }
/*    */   
/*    */   public void attributeAdded(HttpSessionBindingEvent event) {}
/*    */   
/*    */   public void attributeRemoved(HttpSessionBindingEvent event) {}
/*    */   
/*    */   public void attributeReplaced(HttpSessionBindingEvent event) {}
/*    */ }
