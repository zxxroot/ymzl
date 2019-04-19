/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateUtil
/*     */   extends tool.util.DateUtil
/*     */ {
/*     */   public static Date dateAddMins(Date date, int minCnt)
/*     */   {
/*  20 */     Date d = new Date(date.getTime());
/*  21 */     d.setMinutes(d.getMinutes() + minCnt);
/*  22 */     return d;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int minuteBetween(Date date1, Date date2)
/*     */   {
/*  32 */     DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  33 */     Calendar cal = Calendar.getInstance();
/*     */     try {
/*  35 */       Date d1 = sdf.parse(dateStr4(date1));
/*  36 */       Date d2 = sdf.parse(dateStr4(date2));
/*  37 */       cal.setTime(d1);
/*  38 */       long time1 = cal.getTimeInMillis();
/*  39 */       cal.setTime(d2);
/*  40 */       long time2 = cal.getTimeInMillis();
/*  41 */       return Integer.parseInt(String.valueOf((time2 - time1) / 60000L));
/*     */     } catch (ParseException e) {
/*  43 */       e.printStackTrace();
/*     */     }
/*  45 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Date getDayStartTime(Date date)
/*     */   {
/*  55 */     Calendar cal = Calendar.getInstance();
/*  56 */     cal.setTimeInMillis(date.getTime());
/*  57 */     cal.set(cal.get(1), cal.get(2), 
/*  58 */       cal.get(5), 0, 0, 0);
/*  59 */     return cal.getTime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Date getDayEndTime(Date date)
/*     */   {
/*  69 */     Calendar cal = Calendar.getInstance();
/*  70 */     cal.setTimeInMillis(date.getTime());
/*  71 */     cal.set(cal.get(1), cal.get(2), 
/*  72 */       cal.get(5), 23, 59, 59);
/*  73 */     return cal.getTime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Date parse(String date, String type)
/*     */   {
/*  83 */     SimpleDateFormat formatter = new SimpleDateFormat(type);
/*  84 */     ParsePosition pos = new ParsePosition(0);
/*  85 */     Date strtodate = formatter.parse(date, pos);
/*  86 */     return strtodate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Date> dateSplit(Date startDate, Date endDate)
/*     */     throws Exception
/*     */   {
/*  99 */     if (!startDate.before(endDate))
/* 100 */       throw new Exception("开始时间应该在结束时间之后");
/* 101 */     Long spi = Long.valueOf(endDate.getTime() - startDate.getTime());
/* 102 */     Long step = Long.valueOf(spi.longValue() / 86400000L);
/*     */     
/* 104 */     List<Date> dateList = new ArrayList();
/* 105 */     dateList.add(endDate);
/* 106 */     for (int i = 1; i <= step.longValue(); i++) {
/* 107 */       dateList.add(new Date(((Date)dateList.get(i - 1)).getTime() - 
/* 108 */         86400000L));
/*     */     }
/* 110 */     return dateList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<String> getMonthBetween(String minDate, String maxDate)
/*     */     throws ParseException
/*     */   {
/* 121 */     ArrayList<String> result = new ArrayList();
/* 122 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
/*     */     
/* 124 */     Calendar min = Calendar.getInstance();
/* 125 */     Calendar max = Calendar.getInstance();
/*     */     
/* 127 */     min.setTime(sdf.parse(minDate));
/* 128 */     min.set(min.get(1), min.get(2), 1);
/*     */     
/* 130 */     max.setTime(sdf.parse(maxDate));
/* 131 */     max.set(max.get(1), max.get(2), 2);
/*     */     
/* 133 */     Calendar curr = min;
/* 134 */     while (curr.before(max)) {
/* 135 */       result.add(sdf.format(curr.getTime()));
/* 136 */       curr.add(2, 1);
/*     */     }
/*     */     
/* 139 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Date getDateBefore(int day, Date date)
/*     */   {
/* 150 */     Calendar calendar = new GregorianCalendar();
/* 151 */     calendar.setTime(date);
/* 152 */     calendar.add(5, day);
/* 153 */     date = calendar.getTime();
/* 154 */     return date;
/*     */   }
/*     */   
/*     */   public static Date dateAddDays(Date date, int days)
/*     */   {
/* 159 */     Date d = new Date(date.getTime());
/* 160 */     d.setDate(d.getDate() + days);
/* 161 */     return d;
/*     */   }
/*     */ }


/* DateUtil.class

 */