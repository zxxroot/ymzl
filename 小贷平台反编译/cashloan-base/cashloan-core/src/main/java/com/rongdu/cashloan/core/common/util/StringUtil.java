/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.context.Global;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StringUtil
/*     */   extends tool.util.StringUtil
/*     */ {
/*  29 */   private static int[] power = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isPhone(String str)
/*     */   {
/*  44 */     String phone = isNull(str);
/*  45 */     if (phone.length() != 11) {
/*  46 */       return false;
/*     */     }
/*  48 */     Pattern regex = Pattern.compile("^\\d{11}$");
/*  49 */     Matcher matcher = regex.matcher(phone);
/*  50 */     boolean isMatched = matcher.matches();
/*  51 */     if (!isMatched) {
/*  52 */       return false;
/*     */     }
/*  54 */     String segment = phone.substring(0, 3);
/*  55 */     String segments = Global.getValue("phone_number_segment");
/*  56 */     if (segments.contains(segment)) {
/*  57 */       return true;
/*     */     }
/*  59 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMail(String str)
/*     */   {
/*  68 */     String mail = isNull(str);
/*  69 */     Pattern regex = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
/*  70 */     Matcher matcher = regex.matcher(mail);
/*  71 */     boolean isMatched = matcher.matches();
/*  72 */     return isMatched;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCard(String str)
/*     */   {
/*  82 */     String cardId = isNull(str);
/*     */     
/*  84 */     Pattern isIDCard1 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
/*     */     
/*  86 */     Pattern isIDCard2 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
/*  87 */     Matcher matcher1 = isIDCard1.matcher(cardId);
/*  88 */     Matcher matcher2 = isIDCard2.matcher(cardId);
/*  89 */     boolean isMatched = (matcher1.matches()) || (matcher2.matches());
/*  90 */     return isMatched;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getSex(String cardId)
/*     */   {
/*     */     int sexNum;
/*     */ 
/* 104 */     if (cardId.length() == 15) {
/* 105 */       sexNum = cardId.charAt(cardId.length() - 1);
/*     */     } else {
/* 107 */       sexNum = cardId.charAt(cardId.length() - 2);
/*     */     }
/*     */     
/* 110 */     if (sexNum % 2 == 1) {
/* 111 */       return "男";
/*     */     }
/* 113 */     return "女";
/*     */   }
/*     */   
/*     */   public static String toString(String separate, int... objs)
/*     */   {
/* 118 */     StringBuilder sb = new StringBuilder();
/* 119 */     for (int i = 0; i < objs.length; i++) {
/* 120 */       if (i > 0)
/* 121 */         sb.append(separate);
/* 122 */       sb.append(objs[i]);
/*     */     }
/* 124 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String toStringArray(Object... list)
/*     */   {
/* 129 */     StringBuilder sb = new StringBuilder();
/* 130 */     int index = 0;
/*     */     
/* 132 */     Object[] arrayOfObject = list;int j = list.length; for (int i = 0; i < j; i++) { Object o = arrayOfObject[i];
/* 133 */       if (index > 0) sb.append(",");
/* 134 */       sb.append(o.toString());
/* 135 */       index++;
/*     */     }
/* 137 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String toString(Collection list)
/*     */   {
/* 142 */     return toString(list, ",");
/*     */   }
/*     */   
/*     */   public static String toString(Collection list, String delim)
/*     */   {
/* 147 */     StringBuilder sb = new StringBuilder();
/* 148 */     int index = 0;
/*     */     
/* 150 */     for (Object o : list) {
/* 151 */       if (index > 0) sb.append(delim);
/* 152 */       sb.append(o.toString());
/* 153 */       index++;
/*     */     }
/* 155 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String getRelativePath(File file, File parentFile) {
/* 159 */     return file.getAbsolutePath().replaceFirst("^\\Q" + parentFile.getAbsolutePath() + "\\E", "").replace("\\", "/");
/*     */   }
/*     */   
/*     */   public static String getFileUri(HttpServletRequest request, File file)
/*     */   {
/* 164 */     String pre = request.getRealPath("/");
/* 165 */     String fullpath = file.getAbsolutePath();
/* 166 */     return fullpath.replace(pre.replaceFirst("[\\\\/]$", ""), "").replace("\\", "/");
/*     */   }
/*     */   
/*     */   public static String getRepairedFileUri(String fullpath) {
/* 170 */     return fullpath.replaceFirst("[\\\\/]$", "").replace("\\", "/").replace("//", "/");
/*     */   }
/*     */   
/*     */ 
/*     */   public static String fmtMicrometer(String str)
/*     */   {
/*     */     DecimalFormat df;
/*     */     
/* 180 */     if (str.indexOf(".") > -1) {
/* 181 */       if (str.length() - str.indexOf(".") - 1 == 0) {
/* 182 */         df = new DecimalFormat("###,##0."); } else {
/* 183 */         if (str.length() - str.indexOf(".") - 1 == 1) {
/* 184 */           df = new DecimalFormat("###,##0.0");
/*     */         } else
/* 186 */           df = new DecimalFormat("###,##0.00");
/*     */       }
/*     */     } else {
/* 189 */       df = new DecimalFormat("###,##0");
/*     */     }
/* 191 */     double number = Double.parseDouble(str);
/* 192 */     return df.format(number);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Integer getAge(String idNo)
/*     */     throws ParseException
/*     */   {
/* 203 */     if ((idNo != null) && (idNo.length() == 15)) {
/* 204 */       idNo = convertIdcarBy15bit(idNo);
/*     */     }
/* 206 */     if ((idNo != null) && (idNo.length() == 18)) {
/* 207 */       String dates = idNo.substring(6, 14);
/* 208 */       int year = DateUtil.daysBetween(DateUtil.valueOf(dates, "yyyyMMdd"), DateUtil.getNow()) / 365;
/* 209 */       return Integer.valueOf(year);
/*     */     }
/* 211 */     return Integer.valueOf(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String convertIdcarBy15bit(String idcard)
/*     */     throws ParseException
/*     */   {
/* 223 */     if (idcard.length() != 15) {
/* 224 */       return null;
/*     */     }
/*     */     String idcard17;
/* 227 */     if (isDigital(idcard))
/*     */     {
/* 229 */       String birthday = idcard.substring(6, 12);
/* 230 */       Date birthdate = new SimpleDateFormat("yyMMdd").parse(birthday);
/* 231 */       Calendar cday = Calendar.getInstance();
/* 232 */       cday.setTime(birthdate);
/* 233 */       String year = String.valueOf(cday.get(1));
/*     */       
/* 235 */       idcard17 = idcard.substring(0, 6) + year + idcard.substring(8);
/*     */       
/* 237 */       char[] c = idcard17.toCharArray();
/*     */       
/*     */ 
/* 240 */       if (c != null)
/*     */       {
/*     */ 
/*     */ 
/* 244 */         int[] bit = converCharToInt(c);
/* 245 */         int sum17 = getPowerSum(bit);
/*     */         
/*     */ 
/* 248 */         String checkCode = getCheckCodeBySum(sum17);
/*     */         
/* 250 */         if (checkCode == null) {
/* 251 */           return null;
/*     */         }
/* 255 */         idcard17 = idcard17 + checkCode;
/*     */       }
/*     */     } else {
/* 258 */       return null; }
/* 260 */     return idcard17;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getCheckCodeBySum(int sum17)
/*     */   {
/* 270 */     String checkCode = null;
/* 271 */     switch (sum17 % 11) {
/*     */     case 10: 
/* 273 */       checkCode = "2";
/* 274 */       break;
/*     */     case 9: 
/* 276 */       checkCode = "3";
/* 277 */       break;
/*     */     case 8: 
/* 279 */       checkCode = "4";
/* 280 */       break;
/*     */     case 7: 
/* 282 */       checkCode = "5";
/* 283 */       break;
/*     */     case 6: 
/* 285 */       checkCode = "6";
/* 286 */       break;
/*     */     case 5: 
/* 288 */       checkCode = "7";
/* 289 */       break;
/*     */     case 4: 
/* 291 */       checkCode = "8";
/* 292 */       break;
/*     */     case 3: 
/* 294 */       checkCode = "9";
/* 295 */       break;
/*     */     case 2: 
/* 297 */       checkCode = "x";
/* 298 */       break;
/*     */     case 1: 
/* 300 */       checkCode = "0";
/* 301 */       break;
/*     */     case 0: 
/* 303 */       checkCode = "1";
/*     */     }
/*     */     
/* 306 */     return checkCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getPowerSum(int[] bit)
/*     */   {
/* 317 */     int sum = 0;
/*     */     
/* 319 */     if (power.length != bit.length) {
/* 320 */       return sum;
/*     */     }
/*     */     
/* 323 */     for (int i = 0; i < bit.length; i++) {
/* 324 */       for (int j = 0; j < power.length; j++) {
/* 325 */         if (i == j) {
/* 326 */           sum += bit[i] * power[j];
/*     */         }
/*     */       }
/*     */     }
/* 330 */     return sum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isDigital(String str)
/*     */   {
/* 339 */     return (str == null) || ("".equals(str)) ? false : str.matches("^[0-9]*$");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int[] converCharToInt(char[] c)
/*     */     throws NumberFormatException
/*     */   {
/* 349 */     int[] a = new int[c.length];
/* 350 */     int k = 0;
/* 351 */     char[] arrayOfChar = c;int j = c.length; for (int i = 0; i < j; i++) { char temp = arrayOfChar[i];
/* 352 */       a[(k++)] = Integer.parseInt(String.valueOf(temp));
/*     */     }
/* 354 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<String, Object> convertStringToMap(String s)
/*     */   {
/* 362 */     Map<String, Object> m = new HashMap();
/* 363 */     String[] couple = s.split("&");
/* 364 */     for (int i = 0; i < couple.length; i++) {
/* 365 */       String[] single = couple[i].split("=");
/* 366 */       if (single.length < 2) {
/* 367 */         m.put(single[0], "");
/*     */       }
/*     */       else
/* 370 */         m.put(single[0], single[1]);
/*     */     }
/* 372 */     return m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int compareVersion(String version1, String version2)
/*     */     throws Exception
/*     */   {
/* 382 */     if ((version1 == null) || (version2 == null)) {
/* 383 */       throw new Exception("compareVersion error:illegal params.");
/*     */     }
/* 385 */     String[] versionArray1 = version1.split("\\.");
/* 386 */     String[] versionArray2 = version2.split("\\.");
/* 387 */     int idx = 0;
/* 388 */     int minLength = Math.min(versionArray1.length, versionArray2.length);
/* 389 */     int diff = 0;
/* 390 */     while ((idx < minLength) && 
/* 391 */       ((diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0) && 
/* 392 */       ((diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0)) {
/* 393 */       idx++;
/*     */     }
/*     */     
/* 396 */     diff = diff != 0 ? diff : versionArray1.length - versionArray2.length;
/* 397 */     return diff;
/*     */   }
/*     */   
/* 400 */   static int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean isValidDate(String date)
/*     */   {
/*     */     try
/*     */     {
/* 408 */       int year = 0;
/* 409 */       int month = 0;
/* 410 */       int day = 0;
/* 411 */       if (date.length() > 5) {
/* 412 */         year = Integer.parseInt(date.substring(0, 4));
/* 413 */         if (year <= 0) return false;
/*     */       } else {
/* 415 */         return false;
/*     */       }
/* 417 */       if (date.length() > 8) {
/* 418 */         month = Integer.parseInt(date.substring(5, 7));
/* 419 */         if ((month <= 0) || (month > 12))
/* 420 */           return false;
/*     */       } else {
/* 422 */         return false;
/*     */       }
/* 424 */       if (date.length() > 11) {
/* 425 */         day = Integer.parseInt(date.substring(8, 10));
/* 426 */         if ((day <= 0) || (day > DAYS[month]))
/* 427 */           return false;
/*     */       } else {
/* 429 */         return false;
/*     */       }
/* 431 */       if ((month == 2) && (day == 29) && (!isGregorianLeapYear(year))) {
/* 432 */         return false;
/*     */       }
/* 434 */       if (date.length() > 20) {
/* 435 */         int hour = Integer.parseInt(date.substring(11, 13));
/* 436 */         if ((hour < 0) || (hour > 23))
/* 437 */           return false;
/* 438 */         int minute = Integer.parseInt(date.substring(14, 16));
/* 439 */         if ((minute < 0) || (minute > 59))
/* 440 */           return false;
/* 441 */         int second = Integer.parseInt(date.substring(17, 19));
/* 442 */         if ((second < 0) || (second > 59))
/* 443 */           return false;
/*     */       }
/*     */     } catch (Exception e) {
/* 446 */       e.printStackTrace();
/* 447 */       return false;
/*     */     }
/* 449 */     return true;
/*     */   }
/*     */   
/* 452 */   public static final boolean isGregorianLeapYear(int year) { return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)); }
/*     */   
/*     */   public static String getDate()
/*     */   {
/* 456 */     SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
/* 457 */     Date date = new Date();
/* 458 */     String date1 = sf.format(date);
/* 459 */     return date1;
/*     */   }
/*     */   
/*     */   public static String getDate(int i) {
/* 463 */     SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
/* 464 */     Calendar calendar = Calendar.getInstance();
/* 465 */     calendar.setTime(new Date());
/* 466 */     if (i == 1) {
/* 467 */       String str = sf.format(calendar.getTime());
/* 468 */       return str;
/*     */     }
/* 470 */     calendar.add(6, -1);
/* 471 */     String str = sf.format(calendar.getTime());
/* 472 */     return str;
/*     */   }
/*     */ }


/* StringUtil.class

 */