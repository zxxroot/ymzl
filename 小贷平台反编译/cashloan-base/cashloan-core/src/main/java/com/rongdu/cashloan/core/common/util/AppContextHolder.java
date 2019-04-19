/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.BeansException;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ import org.springframework.context.ApplicationContextAware;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AppContextHolder
/*    */   implements ApplicationContextAware
/*    */ {
/* 14 */   private static final Logger LOGGER = LoggerFactory.getLogger(AppContextHolder.class);
/*    */   public static final String DEFAULT_SESSION_FACTORY = "mySessionFactory";
/*    */   private static ApplicationContext appContext;
/* 17 */   private static boolean devMode = false;
/*    */   
/*    */   public void setApplicationContext(ApplicationContext ctx) throws BeansException
/*    */   {
/* 21 */     appContext = ctx;
/*    */   }
/*    */   
/*    */   public static ApplicationContext get() {
/* 25 */     return appContext;
/*    */   }
/*    */   
/*    */   public static Object getBean(String beanName) {
/* 29 */     return appContext.getBean(beanName);
/*    */   }
/*    */   
/*    */   public static boolean containsBean(String beanName) {
/* 33 */     return appContext.containsBean(beanName);
/*    */   }
/*    */   
/*    */   public static <T> T getBean(String beanName, Class<T> type) {
/* 37 */     return (T)appContext.getBean(beanName, type);
/*    */   }
/*    */   
/*    */   public static boolean isReady() {
/* 41 */     return appContext != null;
/*    */   }
/*    */   
/*    */   public static boolean isDevMode() {
/* 45 */     return devMode;
/*    */   }
/*    */   
/*    */   public void setDevMode(boolean devMode) {
/* 49 */     devMode = devMode;
/* 50 */     LOGGER.info("Debug[devMode] is -------------------{}-------------------", devMode ? "ON" : "OFF");
/*    */   }
/*    */ }

