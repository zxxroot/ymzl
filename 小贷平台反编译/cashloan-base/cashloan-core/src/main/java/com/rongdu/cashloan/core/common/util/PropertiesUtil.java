/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.text.MessageFormat;
/*    */ import java.util.Properties;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class PropertiesUtil
/*    */ {
/* 11 */   private static Logger log = Logger.getLogger(PropertiesUtil.class);
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
/* 23 */   private static Properties properties = new Properties();
/*    */   
/*    */   static {
/* 26 */     try { properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("sysConfig.properties"));
/*    */     } catch (IOException e) {
/* 28 */       e.printStackTrace();
/* 29 */       log.error("读取配置文件出错，请确认properties文件已经放在目录下。");
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getValue(String key)
/*    */   {
/* 40 */     String value = properties.getProperty(key);
/* 41 */     if (StringUtil.isBlank(value)) {
/* 42 */       log.info("没有获取指定key的值，请确认资源文件中是否存在【" + key + "】");
/*    */     }
/* 44 */     return value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getValue(String key, Object[] param)
/*    */   {
/* 55 */     String value = getValue(key);
/* 56 */     return MessageFormat.format(value, param);
/*    */   }
/*    */ }
