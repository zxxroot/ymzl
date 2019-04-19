/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
import com.rongdu.cashloan.core.common.exception.BaseRuntimeException;
import org.apache.log4j.Logger;

import java.lang.reflect.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReflectUtil
/*     */ {
/*  31 */   private static final Logger logger = Logger.getLogger(ReflectUtil.class);
/*     */   
/*  33 */   public static List<?> PRIMITIVE_TYPES = Arrays.asList(new Class[] {
/*  34 */     Character.TYPE, Short.TYPE, Byte.TYPE, Integer.TYPE, Long.TYPE, 
/*  35 */     Float.TYPE, Double.TYPE, Boolean.TYPE, Short.class, Byte.class, 
/*  36 */     Integer.class, Long.class, Float.class, Double.class, 
/*  37 */     Boolean.class, String.class, Date.class });
/*     */   
/*     */   public static boolean isPrimitive(Class<?> type) {
/*  40 */     return PRIMITIVE_TYPES.contains(type);
/*     */   }
/*     */   
/*     */   public static Object invokeGetMethod(Class<?> claszz, Object o, String name) {
/*  44 */     Object ret = null;
/*     */     try {
/*  46 */       Method method = claszz.getMethod("get" + 
/*  47 */         StringUtil.firstCharUpperCase(name), new Class[0]);
/*  48 */       ret = method.invoke(o, new Object[0]);
/*     */     }
/*     */     catch (NoSuchMethodException|SecurityException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e)
/*     */     {
/*  52 */       logger.error("claszz:" + claszz + ",name:" + name, e);
/*     */     }
/*  54 */     return ret;
/*     */   }
/*     */   
/*     */   public static Object invokeSetMethod(Class<?> claszz, Object o, String name, Class<?>[] argTypes, Object[] args)
/*     */   {
/*  59 */     Object ret = null;
/*     */     try
/*     */     {
/*  62 */       if (!checkModifiers(claszz, name)) {
/*  63 */         Method method = claszz.getMethod(
/*  64 */           "set" + StringUtil.firstCharUpperCase(name), argTypes);
/*  65 */         ret = method.invoke(o, args);
/*     */       }
/*     */     }
/*     */     catch (NoSuchMethodException|SecurityException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e)
/*     */     {
/*  70 */       logger.error("claszz:" + claszz + ",name:" + name + ",argType:" + 
/*  71 */         argTypes + ",args:" + args, e);
/*     */     }
/*  73 */     return ret;
/*     */   }
/*     */   
/*     */   public static Object invokeSetMethod(Class<?> claszz, Object o, String name, Class<?> argType, Object args)
/*     */   {
/*  78 */     Object ret = null;
/*     */     try
/*     */     {
/*  81 */       if (!checkModifiers(claszz, name)) {
/*  82 */         Method method = claszz.getMethod(
/*  83 */           "set" + StringUtil.firstCharUpperCase(name), 
/*  84 */           new Class[] { argType });
/*  85 */         ret = method.invoke(o, new Object[] { args });
/*     */       }
/*     */     }
/*     */     catch (NoSuchMethodException|SecurityException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e)
/*     */     {
/*  90 */       logger.error("claszz:" + claszz + ",name:" + name + ",argType:" + 
/*  91 */         argType + ",args:" + args);
/*     */     }
/*  93 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkModifiers(Class<?> claszz, String name)
/*     */   {
/*     */     try
/*     */     {
/* 105 */       Field field = claszz.getField(name);
/* 106 */       if (isConstant(field.getModifiers())) {
/* 107 */         return true;
/*     */       }
/*     */     } catch (NoSuchFieldException e) {
/* 110 */       logger.error(e);
/* 111 */       return false;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isConstant(int modifiers)
/*     */   {
/* 124 */     if ((Modifier.isStatic(modifiers)) && (Modifier.isFinal(modifiers))) {
/* 125 */       return true;
/*     */     }
/* 127 */     return false;
/*     */   }
/*     */   
/*     */   public static Class<?> getSuperClassGenricType(Class clazz, int index)
/*     */   {
/* 132 */     Type genType = clazz.getGenericSuperclass();
/*     */     
/* 134 */     if (!(genType instanceof ParameterizedType)) {
/* 135 */       return Object.class;
/*     */     }
/*     */     
/* 138 */     Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
/* 139 */     if ((index >= params.length) || (index < 0)) {
/* 140 */       throw new BaseRuntimeException("你输入的索引" + (
/* 141 */         index < 0 ? "不能小于0" : "超出了参数的总数"));
/*     */     }
/* 143 */     if (!(params[index] instanceof Class)) {
/* 144 */       return Object.class;
/*     */     }
/* 146 */     return (Class)params[index];
/*     */   }
/*     */   
/*     */   public static Class getSuperClassGenricType(Class clazz)
/*     */   {
/* 151 */     return getSuperClassGenricType(clazz, 0);
/*     */   }
/*     */   
/*     */   public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes)
/*     */   {
/* 156 */     Method method = null;
/* 157 */     Class<?> clazz = object.getClass();
/* 158 */     while (clazz != Object.class) {
/*     */       try {
/* 160 */         method = clazz.getDeclaredMethod(methodName, parameterTypes);
/*     */       }
/*     */       catch (Exception localException) {}
/*     */       
/*     */ 
/*     */ 
/* 166 */       if (method != null)
/*     */         break;
/* 168 */       clazz = clazz.getSuperclass();
/*     */     }
/* 170 */     return method;
/*     */   }
/*     */   
/*     */   public static Map<String, Field> getClassField(Class<?> clazz) {
/* 174 */     Field[] declaredFields = clazz.getDeclaredFields();
/* 175 */     Map<String, Field> fieldMap = new HashMap();
/* 176 */     Map<String, Field> superFieldMap = new HashMap();
/* 177 */     Field[] arrayOfField1; int j = (arrayOfField1 = declaredFields).length; for (int i = 0; i < j; i++) { Field field = arrayOfField1[i];
/* 178 */       fieldMap.put(field.getName(), field);
/*     */     }
/* 180 */     if (clazz.getSuperclass() != null) {
/* 181 */       superFieldMap = getClassField(clazz.getSuperclass());
/*     */     }
/* 183 */     fieldMap.putAll(superFieldMap);
/* 184 */     return fieldMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String fieldValueToJson(Object object)
/*     */   {
/* 195 */     Class<?> clazz = object.getClass();
/* 196 */     Field[] fss = new Field[0];
/* 197 */     for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
/*     */       try {
/* 199 */         Field[] fs = clazz.getDeclaredFields();
/* 200 */         fss = (Field[])ArrayUtil.concat(fss, fs);
/*     */       }
/*     */       catch (Exception localException) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 208 */     Map<String, Object> map = new HashMap();
/* 209 */     Field[] arrayOfField1; int j = (arrayOfField1 = fss).length; for (int i = 0; i < j; i++) { Field f = arrayOfField1[i];
/*     */       
/* 211 */       if ((String.class.equals(f.getType())) && 
/* 212 */         (!isConstant(f.getModifiers()))) {
/* 213 */         String fieldName = f.getName();
/* 214 */         Object o = invokeGetMethod(f.getDeclaringClass(), 
/* 215 */           object, fieldName);
/* 216 */         String value = StringUtil.isNull(o);
/* 217 */         if (value != "")
/*     */         {
/*     */ 
/* 220 */           map.put(fieldName, value); }
/*     */       }
/*     */     }
/* 223 */     String str = JSONObject.toJSONString(map);
/* 224 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<String, Object> fieldValueToMap(Object object)
/*     */   {
/* 235 */     Class<?> clazz = object.getClass();
/* 236 */     Field[] fss = new Field[0];
/* 237 */     for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
/*     */       try {
/* 239 */         Field[] fs = clazz.getDeclaredFields();
/* 240 */         fss = (Field[])ArrayUtil.concat(fss, fs);
/*     */       }
/*     */       catch (Exception localException) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 248 */     Map<String, Object> map = new HashMap();
/* 249 */     Field[] arrayOfField1; int j = (arrayOfField1 = fss).length; for (int i = 0; i < j; i++) { Field f = arrayOfField1[i];
/*     */       
/* 251 */       if ((String.class.equals(f.getType())) && 
/* 252 */         (!isConstant(f.getModifiers()))) {
/* 253 */         String fieldName = f.getName();
/* 254 */         Object o = invokeGetMethod(f.getDeclaringClass(), 
/* 255 */           object, fieldName);
/* 256 */         String value = StringUtil.isNull(o);
/* 257 */         if (value != "")
/*     */         {
/*     */ 
/* 260 */           map.put(fieldName, value); }
/*     */       }
/*     */     }
/* 263 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String fieldValueToString(Object object)
/*     */   {
/* 274 */     Class<?> clazz = object.getClass();
/* 275 */     Field[] fss = new Field[0];
/* 276 */     for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
/*     */       try {
/* 278 */         Field[] fs = clazz.getDeclaredFields();
/* 279 */         fss = (Field[])ArrayUtil.concat(fss, fs);
/*     */       }
/*     */       catch (Exception localException) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 286 */     StringBuilder sb = new StringBuilder(50);
/* 287 */     Field[] arrayOfField1; int j = (arrayOfField1 = fss).length; for (int i = 0; i < j; i++) { Field f = arrayOfField1[i];
/*     */       
/* 289 */       if ((String.class.equals(f.getType())) && 
/* 290 */         (!isConstant(f.getModifiers()))) {
/* 291 */         String fieldName = f.getName();
/* 292 */         Object o = invokeGetMethod(f.getDeclaringClass(), 
/* 293 */           object, fieldName);
/* 294 */         String value = StringUtil.isNull(o);
/* 295 */         if (value != "")
/*     */         {
/*     */ 
/* 298 */           sb.append(fieldName + "=" + value + "&"); }
/*     */       }
/*     */     }
/* 301 */     logger.debug("请求TPP参数：" + sb.toString());
/* 302 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String fieldValueToString(Object object, String[] paramNames)
/*     */   {
/* 314 */     if ((object == null) || (paramNames == null) || (paramNames.length <= 0)) {
/* 315 */       return "";
/*     */     }
/* 317 */     StringBuilder sb = new StringBuilder();
/* 318 */     StringBuilder detail = new StringBuilder();
/* 319 */     String[] arrayOfString; int j = (arrayOfString = paramNames).length; for (int i = 0; i < j; i++) { String name = arrayOfString[i];
/* 320 */       Object o = invokeGetMethod(object.getClass(), object, 
/* 321 */         name);
/* 322 */       String value = StringUtil.isNull(o);
/* 323 */       sb.append(value);
/* 324 */       detail.append(name + "=" + value + "&");
/*     */     }
/* 326 */     logger.debug("参数拼接明细：" + detail.toString());
/* 327 */     logger.debug("参数拼接结果：" + sb.toString());
/* 328 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String fieldValueToString(Map<String, String> data, String[] paramNames)
/*     */   {
/* 333 */     if ((data.isEmpty()) || (paramNames == null) || (paramNames.length <= 0)) {
/* 334 */       return "";
/*     */     }
/* 336 */     StringBuilder sb = new StringBuilder();
/* 337 */     StringBuilder detail = new StringBuilder();
/* 338 */     String[] arrayOfString; int j = (arrayOfString = paramNames).length; for (int i = 0; i < j; i++) { String name = arrayOfString[i];
/* 339 */       String value = (String)data.get(name);
/* 340 */       value = StringUtil.isNull(value);
/* 341 */       sb.append(value);
/* 342 */       detail.append(name + "=" + value + "&");
/*     */     }
/* 344 */     logger.debug("参数拼接明细：" + detail.toString());
/* 345 */     logger.debug("参数拼接结果：" + sb.toString());
/* 346 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String fieldValueToJson(Object object, String[] paramNames)
/*     */   {
/* 357 */     Map<String, String> map = fieldValueToMap(object, paramNames);
/* 358 */     String str = JSONObject.toJSONString(map);
/* 359 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<String, String> fieldValueToMap(Object object, String[] paramNames)
/*     */   {
/* 371 */     return fieldValueToMap(object, paramNames, true);
/*     */   }
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
/*     */   public static Map<String, String> fieldValueToMap(Object object, String[] paramNames, boolean is_trim)
/*     */   {
/* 385 */     Map<String, String> map = new HashMap();
/* 386 */     String[] arrayOfString; int j = (arrayOfString = paramNames).length; for (int i = 0; i < j; i++) { String name = arrayOfString[i];
/* 387 */       Object o = invokeGetMethod(object.getClass(), object, 
/* 388 */         name);
/* 389 */       String value = StringUtil.isNull(o);
/*     */       
/* 391 */       if ((!is_trim) || (!"".equals(value)))
/*     */       {
/*     */ 
/* 394 */         map.put(name, value); }
/*     */     }
/* 396 */     logger.debug("数组反射结果：" + map.toString());
/* 397 */     return map;
/*     */   }
/*     */ }
