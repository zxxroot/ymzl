/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang3.time.DateFormatUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateUtils
/*     */   extends org.apache.commons.lang3.time.DateUtils
/*     */ {
/*  15 */   private static String[] parsePatterns = {
/*  16 */     "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
/*  17 */     "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", 
/*  18 */     "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM" };
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getDate()
/*     */   {
/*  24 */     return getDate("yyyy-MM-dd");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getDate(String pattern)
/*     */   {
/*  31 */     return DateFormatUtils.format(new Date(), pattern);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String formatDate(Date date, Object... pattern)
/*     */   {
/*  38 */     String formatDate = null;
/*  39 */     if ((pattern != null) && (pattern.length > 0)) {
/*  40 */       formatDate = DateFormatUtils.format(date, pattern[0].toString());
/*     */     } else {
/*  42 */       formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
/*     */     }
/*  44 */     return formatDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String formatDateTime(Date date)
/*     */   {
/*  51 */     return formatDate(date, new Object[] { "yyyy-MM-dd HH:mm:ss" });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getTime()
/*     */   {
/*  58 */     return formatDate(new Date(), new Object[] { "HH:mm:ss" });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getDateTime()
/*     */   {
/*  65 */     return formatDate(new Date(), new Object[] { "yyyy-MM-dd HH:mm:ss" });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getYear()
/*     */   {
/*  72 */     return formatDate(new Date(), new Object[] { "yyyy" });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getMonth()
/*     */   {
/*  79 */     return formatDate(new Date(), new Object[] { "MM" });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getDay()
/*     */   {
/*  86 */     return formatDate(new Date(), new Object[] { "dd" });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getWeek()
/*     */   {
/*  93 */     return formatDate(new Date(), new Object[] { "E" });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Date parseDate(Object str)
/*     */   {
/* 103 */     if (str == null) {
/* 104 */       return null;
/*     */     }
/*     */     try {
/* 107 */       return parseDate(str.toString(), parsePatterns);
/*     */     } catch (ParseException e) {}
/* 109 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long pastDays(Date date)
/*     */   {
/* 119 */     long t = new Date().getTime() - date.getTime();
/* 120 */     return t / 86400000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long pastHour(Date date)
/*     */   {
/* 129 */     long t = new Date().getTime() - date.getTime();
/* 130 */     return t / 3600000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long pastMinutes(Date date)
/*     */   {
/* 139 */     long t = new Date().getTime() - date.getTime();
/* 140 */     return t / 60000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String formatDateTime(long timeMillis)
/*     */   {
/* 149 */     long day = timeMillis / 86400000L;
/* 150 */     long hour = timeMillis / 3600000L - day * 24L;
/* 151 */     long min = timeMillis / 60000L - day * 24L * 60L - hour * 60L;
/* 152 */     long s = timeMillis / 1000L - day * 24L * 60L * 60L - hour * 60L * 60L - min * 60L;
/* 153 */     long sss = timeMillis - day * 24L * 60L * 60L * 1000L - hour * 60L * 60L * 1000L - min * 60L * 1000L - s * 1000L;
/* 154 */     return (day > 0L ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static double getDistanceOfTwoDate(Date before, Date after)
/*     */   {
/* 165 */     long beforeTime = before.getTime();
/* 166 */     long afterTime = after.getTime();
/* 167 */     return (afterTime - beforeTime) / 86400000L;
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */     throws ParseException
/*     */   {}
/*     */ }
