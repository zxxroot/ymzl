/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.UUID;
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
/*    */ public class OrderNoUtil
/*    */ {
/*    */   private static final String COMMON_DATE = "yyyyMMdd";
/*    */   
/*    */   public static String getSerialNumber()
/*    */   {
/* 29 */     int hashCode = UUID.randomUUID().toString().hashCode();
/* 30 */     if (hashCode < 0) {
/* 31 */       hashCode = -hashCode;
/*    */     }
/* 33 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 34 */     return sdf.format(new Date()).substring(2, 8) + String.format("%010d", new Object[] { Integer.valueOf(hashCode) });
/*    */   }
/*    */ }
