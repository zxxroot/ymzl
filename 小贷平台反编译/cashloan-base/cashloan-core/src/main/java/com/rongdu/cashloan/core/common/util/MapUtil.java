/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.IntrospectionException;
/*     */ import java.beans.Introspector;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import tool.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapUtil
/*     */ {
/*  29 */   public static final Logger logger = LoggerFactory.getLogger(MapUtil.class);
/*     */   
/*     */   public static List collectProperty(List<Map<String, Object>> list, String property) {
/*  32 */     return collectProperty(list, property, true);
/*     */   }
/*     */   
/*     */   public static List collectProperty(List<Map<String, Object>> list, String property, boolean acceptNull) {
/*  36 */     List rlist = new ArrayList();
/*  37 */     for (Map rec : list) {
/*  38 */       Object o = rec.get(property);
/*  39 */       if ((o != null) || (acceptNull))
/*  40 */         rlist.add(o);
/*     */     }
/*  42 */     return rlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Object convertMap(Class type, Map map)
/*     */   {
/*     */     try
/*     */     {
/*  56 */       BeanInfo beanInfo = Introspector.getBeanInfo(type);
/*  57 */       Object obj = type.newInstance();
/*     */       
/*     */ 
/*  60 */       PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
/*  61 */       for (int i = 0; i < propertyDescriptors.length; i++) {
/*  62 */         PropertyDescriptor descriptor = propertyDescriptors[i];
/*  63 */         String propertyName = descriptor.getName();
/*     */         
/*  65 */         if (map.containsKey(propertyName))
/*     */         {
/*  67 */           Object value = map.get(propertyName);
/*     */           
/*  69 */           Object[] args = new Object[1];
/*  70 */           args[0] = value;
/*     */           
/*  72 */           descriptor.getWriteMethod().invoke(obj, args);
/*     */         }
/*     */       }
/*  75 */       return obj;
/*     */     } catch (IntrospectionException e) {
/*  77 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */     catch (InstantiationException e) {
/*  80 */       logger.error(e.getMessage(), e);
/*     */     } catch (IllegalAccessException e) {
/*  82 */       logger.error(e.getMessage(), e);
/*     */     } catch (IllegalArgumentException e) {
/*  84 */       logger.error(e.getMessage(), e);
/*     */     } catch (InvocationTargetException e) {
/*  86 */       logger.error(e.getMessage(), e);
/*     */     }
/*  88 */     return null;
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
/*     */   public static Map convertBean(Object bean)
/*     */     throws IntrospectionException, IllegalAccessException, InvocationTargetException
/*     */   {
/* 103 */     Class type = bean.getClass();
/* 104 */     Map returnMap = new HashMap();
/* 105 */     BeanInfo beanInfo = Introspector.getBeanInfo(type);
/*     */     
/* 107 */     PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
/* 108 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/* 109 */       PropertyDescriptor descriptor = propertyDescriptors[i];
/* 110 */       String propertyName = descriptor.getName();
/* 111 */       if (!"class".equals(propertyName)) {
/* 112 */         Method readMethod = descriptor.getReadMethod();
/* 113 */         Object result = readMethod.invoke(bean, new Object[0]);
/* 114 */         if (result != null) {
/* 115 */           returnMap.put(propertyName, result);
/*     */         } else {
/* 117 */           returnMap.put(propertyName, "");
/*     */         }
/*     */       }
/*     */     }
/* 121 */     return returnMap;
/*     */   }
/*     */   
/*     */   public static Map array2Map(Object[][] values) {
/* 125 */     LinkedHashMap rec = new LinkedHashMap();
/* 126 */     Object[][] arr = values;
/* 127 */     int len = values.length;
/*     */     
/* 129 */     for (int i = 0; i < len; i++) {
/* 130 */       Object[] o = arr[i];
/* 131 */       Object value = o[1];
/* 132 */       if ((value instanceof Object[][])) {
/* 133 */         value = array2Map((Object[][])value);
/* 134 */       } else if ((value instanceof List)) {
/* 135 */         ArrayList children = new ArrayList();
/* 136 */         Iterator i$1 = ((List)value).iterator();
/*     */         
/* 138 */         while (i$1.hasNext()) {
/* 139 */           Object item = i$1.next();
/* 140 */           if ((item instanceof Object[][])) {
/* 141 */             children.add(array2Map((Object[][])item));
/* 142 */           } else if ((item instanceof Map)) {
/* 143 */             children.add((Map)item);
/*     */           } else {
/* 145 */             children.add(item);
/*     */           }
/*     */         }
/*     */         
/* 149 */         value = children;
/*     */       }
/*     */       
/* 152 */       rec.put(o[0], value);
/*     */     }
/*     */     
/* 155 */     return rec;
/*     */   }
/*     */   
/*     */   public static Map<String, Object> replaceNullValue2EmptyStr(Map<String, Object> rec) {
/* 159 */     Iterator i$ = rec.keySet().iterator();
/*     */     
/* 161 */     while (i$.hasNext()) {
/* 162 */       String key = (String)i$.next();
/* 163 */       if (rec.get(key) == null) {
/* 164 */         rec.put(key, "");
/*     */       }
/*     */     }
/*     */     
/* 168 */     return rec;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<String, Object> removeEmptyStr(Map<String, Object> rec)
/*     */   {
/* 177 */     Iterator i$ = rec.keySet().iterator();
/*     */     
/* 179 */     while (i$.hasNext()) {
/* 180 */       String key = (String)i$.next();
/* 181 */       Object value = rec.get(key);
/* 182 */       if (StringUtil.isBlank(value)) {
/* 183 */         i$.remove();
/*     */       }
/*     */     }
/*     */     
/* 187 */     return rec;
/*     */   }
/*     */   
/*     */   public static <T> List<T> toList(Collection<T> collection) {
/* 191 */     ArrayList rlist = new ArrayList();
/* 192 */     Iterator it = collection.iterator();
/*     */     
/* 194 */     while (it.hasNext()) {
/* 195 */       Object t = it.next();
/* 196 */       rlist.add(t);
/*     */     }
/*     */     
/* 199 */     return rlist;
/*     */   }
/*     */   
/*     */   public static Map<String, Object> simpleSort(Map params) {
/* 203 */     List<String> list = toList(params.keySet());
/* 204 */     Collections.sort(list);
/* 205 */     Map<String, Object> result = new LinkedHashMap();
/* 206 */     for (String name : list) {
/* 207 */       result.put(name, params.get(name));
/*     */     }
/* 209 */     return result;
/*     */   }
/*     */ }
