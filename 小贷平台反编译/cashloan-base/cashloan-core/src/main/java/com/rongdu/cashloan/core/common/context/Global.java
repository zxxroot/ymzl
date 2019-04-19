/*    */ package com.rongdu.cashloan.core.common.context;
/*    */ 
/*    */ import java.util.Map;
/*    */ import tool.util.NumberUtil;
/*    */ import tool.util.StringUtil;
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
/*    */ public class Global
/*    */ {
/*    */   public static Map<String, Object> configMap;
/*    */   public static Map<String, Object> msg_template_Map;
/*    */   
/*    */   public static int getInt(String key)
/*    */   {
/* 26 */     return NumberUtil.getInt(StringUtil.isNull(configMap.get(key)));
/*    */   }
/*    */   
/*    */   public static double getDouble(String key) {
/* 30 */     return NumberUtil.getDouble(StringUtil.isNull(configMap.get(key)));
/*    */   }
/*    */   
/*    */   public static String getValue(String key) {
/* 34 */     return StringUtil.isNull(configMap.get(key));
/*    */   }
/*    */   
/*    */   public static Object getObject(String key) {
/* 38 */     return configMap.get(key);
/*    */   }
/*    */   
/*    */   public static String getMsgTempLate(String key) {
/* 42 */     return StringUtil.isNull(msg_template_Map.get(key));
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\context\Global.class

 */