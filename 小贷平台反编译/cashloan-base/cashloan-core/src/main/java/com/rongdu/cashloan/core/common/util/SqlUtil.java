/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SqlUtil
/*     */ {
/*     */   public static String buildSaveOrUpdatesMap(String tableName, List<Map<String, Object>> list)
/*     */   {
/*  18 */     StringBuilder sql = new StringBuilder(buildInsertSqlMap(tableName, list));
/*  19 */     sql.append("on duplicate key update ");
/*  20 */     for (Object name : ((Map)list.get(0)).keySet()) {
/*  21 */       sql.append("`" + name + "`=values(`" + name + "`),");
/*     */     }
/*  23 */     sql.deleteCharAt(sql.length() - 1);
/*  24 */     return sql.toString();
/*     */   }
/*     */   
/*     */   public static String buildInsertSqlMap(String tableName, List<Map<String, Object>> list)
/*     */   {
/*  29 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  30 */     StringBuilder sb = new StringBuilder("insert into `" + tableName + "`(");
/*     */     
/*  32 */     Set<String> keys = ((Map)list.get(0)).keySet();
/*  33 */     for (String key : keys) {
/*  34 */       sb.append("`" + key + "`,");
/*     */     }
/*  36 */     sb.deleteCharAt(sb.length() - 1);
/*  37 */     sb.append(")values");
/*     */     
/*  39 */     for (Map<String, Object> rec : list) {
/*  40 */       sb.append("(");
/*  41 */       for (String key : keys) {
/*  42 */         Object value = rec.get(key);
/*  43 */         if ((value != null) && (!(value instanceof Number)) && (!(value instanceof Boolean))) {
/*  44 */           if ((value instanceof Date)) {
/*  45 */             value = sdf.format(value);
/*     */           } else {
/*  47 */             value = value.toString().replaceAll("['\\\\]", "\\\\$0");
/*     */           }
/*  49 */           value = "'" + value + "'";
/*     */         }
/*  51 */         sb.append(value + ",");
/*     */       }
/*  53 */       sb.deleteCharAt(sb.length() - 1);
/*  54 */       sb.append("),");
/*     */     }
/*  56 */     sb.deleteCharAt(sb.length() - 1);
/*  57 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String buildUpdateSql(String tableName, Object[][] params) {
/*  61 */     return buildUpdateSql(tableName, MapUtil.array2Map(params));
/*     */   }
/*     */   
/*     */   public static String buildUpdateSql(String tableName, Map<String, Object> rec) {
/*  65 */     return buildUpdateSql(tableName, rec, "id");
/*     */   }
/*     */   
/*     */   public static String buildUpdateSql(String tableName, Map<String, Object> rec, String idProperty) {
/*  69 */     StringBuilder sb = new StringBuilder("update `" + tableName + "` set ");
/*  70 */     Object keyValue = rec.remove(idProperty);
/*  71 */     rec.remove("id");
/*  72 */     if (rec.isEmpty()) {
/*  73 */       return null;
/*     */     }
/*  75 */     Iterator i$ = rec.keySet().iterator();
/*     */     
/*  77 */     while (i$.hasNext()) {
/*  78 */       String key = (String)i$.next();
/*  79 */       sb.append("`" + key + "`=" + formatValue(rec.get(key)));
/*  80 */       sb.append(",");
/*     */     }
/*     */     
/*  83 */     sb.deleteCharAt(sb.length() - 1);
/*  84 */     if ((keyValue instanceof String)) {
/*  85 */       keyValue = "'" + keyValue + "'";
/*     */     }
/*     */     
/*  88 */     sb.append(" where " + idProperty + "=" + keyValue);
/*  89 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private static Object formatValue(Object value)
/*     */   {
/*  94 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  95 */     if ((value != null) && (!(value instanceof Number)) && (!(value instanceof Boolean))) { String value1;
/*  97 */       if ((value instanceof Date)) {
/*  98 */         value1 = sdf.format(value);
/*     */       } else {
/* 100 */         value1 = value.toString().replaceAll("['\\\\]", "\\\\$0");
/*     */       }
/*     */       
/* 103 */       value = "'" + value1 + "'";
/*     */     }
/*     */     
/* 106 */     return value;
/*     */   }
/*     */   
/*     */   public static String buildInsertSqlMap(String tableName, Object[][] params)
/*     */   {
/* 111 */     return buildInsertSqlMap(tableName, MapUtil.array2Map(params));
/*     */   }
/*     */   
/*     */   public static String buildInsertSqlMap(String tableName, Map<String, Object> rec) {
/* 115 */     ArrayList list = new ArrayList();
/* 116 */     list.add(rec);
/* 117 */     return buildInsertSqlMap(tableName, list);
/*     */   }
/*     */ }
