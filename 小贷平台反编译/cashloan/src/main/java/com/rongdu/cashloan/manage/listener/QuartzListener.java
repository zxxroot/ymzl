/*    */ package com.rongdu.cashloan.manage.listener;
/*    */ 
/*    */ import com.rongdu.cashloan.manage.domain.QuartzInfo;
/*    */ import com.rongdu.cashloan.manage.model.QuartzManager;
/*    */ import com.rongdu.cashloan.manage.service.QuartzInfoService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.servlet.ServletContextEvent;
/*    */ import javax.servlet.ServletContextListener;
/*    */ import javax.servlet.http.HttpSessionAttributeListener;
/*    */ import javax.servlet.http.HttpSessionBindingEvent;
/*    */ import org.apache.log4j.Logger;
/*    */ import tool.util.BeanUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QuartzListener
/*    */   implements ServletContextListener, HttpSessionAttributeListener
/*    */ {
/* 23 */   private static Logger logger = Logger.getLogger(QuartzListener.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void attributeAdded(HttpSessionBindingEvent event) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void attributeRemoved(HttpSessionBindingEvent event) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void attributeReplaced(HttpSessionBindingEvent event) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void contextInitialized(ServletContextEvent sce)
/*    */   {
/* 45 */     logger.info("【启动所有任务】开始...");
/*    */     try {
/* 47 */       QuartzInfoService quartzInfoService = (QuartzInfoService)BeanUtil.getBean("quartzInfoService");
/*    */       
/*    */ 
/* 50 */       Map<String, Object> paramMap = new HashMap();
/* 51 */       paramMap.put("state", "10");
/* 52 */       List<QuartzInfo> list = quartzInfoService.list(paramMap);
/*    */       
/*    */ 
/* 55 */       for (QuartzInfo quartzInfo : list) {
/* 56 */         String clName = quartzInfo.getClassName();
/* 57 */         Object cl = Class.forName(clName).newInstance();
/* 58 */         QuartzManager.addJob(quartzInfo.getCode(), cl.getClass(), quartzInfo.getCycle());
/*    */       }
/*    */       
/*    */ 
/* 62 */       QuartzManager.startJobs();
/*    */     }
/*    */     catch (Exception e) {
/* 65 */       logger.error("启动定时任务异常--->" + e.getMessage(), e);
/*    */     }
/* 67 */     logger.info("【启动所有任务】结束...");
/*    */   }
/*    */   
/*    */   public void contextDestroyed(ServletContextEvent sce) {}
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\listener\QuartzListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */