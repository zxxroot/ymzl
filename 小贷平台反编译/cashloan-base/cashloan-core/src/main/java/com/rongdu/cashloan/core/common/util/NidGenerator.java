/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.UUID;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NidGenerator
/*    */ {
/* 15 */   public static final Logger logger = LoggerFactory.getLogger(NidGenerator.class);
/* 16 */   protected final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*    */   
/*    */   private static int getHashCode() {
/* 19 */     int hashCode = UUID.randomUUID().toString().hashCode();
/* 20 */     if (hashCode < 0) {
/* 21 */       hashCode = -hashCode;
/*    */     }
/* 23 */     return hashCode;
/*    */   }
/*    */   
/*    */   public static String getOrderNo() {
/* 27 */     int hashCode = getHashCode();
/* 28 */     return String.format("%011d", new Object[] { Integer.valueOf(hashCode) });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getCardNid()
/*    */   {
/* 36 */     int hashCode = getHashCode();
/* 37 */     return "CC" + String.format("%011d", new Object[] { Integer.valueOf(hashCode) });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getItemNid()
/*    */   {
/* 45 */     int hashCode = getHashCode();
/* 46 */     return "CI" + String.format("%011d", new Object[] { Integer.valueOf(hashCode) });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getFactorNid()
/*    */   {
/* 54 */     int hashCode = getHashCode();
/* 55 */     return "CF" + String.format("%011d", new Object[] { Integer.valueOf(hashCode) });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getParamNid()
/*    */   {
/* 63 */     int hashCode = getHashCode();
/* 64 */     return "CFP" + String.format("%010d", new Object[] { Integer.valueOf(hashCode) });
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 68 */     logger.info(getCardNid());
/* 69 */     logger.info(getItemNid());
/* 70 */     logger.info(getFactorNid());
/* 71 */     logger.info(getParamNid());
/* 72 */     logger.info(getOrderNo());
/*    */   }
/*    */ }
