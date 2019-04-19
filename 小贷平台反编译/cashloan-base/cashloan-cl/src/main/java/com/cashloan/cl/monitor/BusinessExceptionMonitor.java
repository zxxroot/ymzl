/*    */ package com.cashloan.cl.monitor;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.DateUtil;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BusinessExceptionMonitor
/*    */ {
/* 14 */   private static Logger logger = Logger.getLogger(BusinessExceptionMonitor.class);
/*    */   
/* 16 */   private static Map<String, Integer> exception = new HashMap();
/*    */   
/*    */ 
/* 19 */   public static String TYPE_1 = "Zmxy-CreditScoreQuery";
/*    */   
/*    */ 
/* 22 */   public static String TYPE_2 = "Zmxy-BlackQuery";
/*    */   
/*    */ 
/* 25 */   public static String TYPE_3 = "Dsdata-Sms";
/*    */   
/*    */ 
/* 28 */   public static String TYPE_4 = "Dsdata-QcRisk";
/*    */   
/*    */ 
/* 31 */   public static String TYPE_5 = "Dsdata-ShangShu";
/*    */   
/*    */ 
/* 34 */   public static String TYPE_6 = "Dsdata-face++";
/*    */   
/*    */ 
/* 37 */   public static String TYPE_7 = "Dsdata-XiaoShi";
/*    */   
/*    */ 
/* 40 */   public static String TYPE_8 = "Dsdata-ShangTang";
/*    */   
/*    */ 
/* 43 */   public static String TYPE_9 = "LianLianPay";
/*    */   
/*    */ 
/* 46 */   public static String TYPE_10 = "TongdunApply";
/*    */   
/*    */ 
/* 49 */   public static String TYPE_11 = "WhiteKnight";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void add(String type, Object keyInfo, String msg)
/*    */   {
/* 58 */     String date = DateUtil.dateStr2(DateUtil.getNow());
/* 59 */     String key = date + "_" + type;
/* 60 */     Integer count = (Integer)exception.get(key);
/* 61 */     count = Integer.valueOf(count == null ? 0 : count.intValue());
/* 62 */     int newCount = count.intValue() + 1;
/* 63 */     exception.put(key, Integer.valueOf(newCount));
/* 64 */     logger.warn(type + "：" + " 关键信息, " + keyInfo + ", 提示信息：" + msg + ", 今日异常次数：" + newCount);
/*    */   }
/*    */ }
