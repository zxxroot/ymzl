/*     */ package com.cashloan.cl.model.tongdun.http;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.ReflectionUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
/*     */ public class JsonFieldAutoPickGenerator
/*     */ {
/*  26 */   private static final Map<String, Field> fieldCache = new ConcurrentHashMap();
/*  27 */   private static Logger logger = Logger.getLogger(JsonFieldAutoPickGenerator.class);
/*     */   public static <T> T autoSetter(String jsonStr, Class<T> clazz)
/*     */   {
/*  40 */     T rsp = null;
/*  41 */     final JSONObject rootObject = JSONObject.parseObject(jsonStr);
/*     */     try {
/*  43 */       rsp = clazz.newInstance();
/*     */     } catch (InstantiationException|IllegalAccessException e1) {
/*  45 */       logger.error(e1);
/*     */     }
/*  47 */     T finalRsp = rsp;
/*  48 */     ReflectionUtils.doWithFields(clazz, new ReflectionUtils.FieldCallback()
/*     */     {
/*     */       private String autoPickFieldAnnoValue;
/*     */       
/*     */       private String fieldTypeName;
/*     */       private Class customClassType;
/*     */       
/*     */       public void doWith(Field field)
/*     */         throws IllegalArgumentException, IllegalAccessException
/*     */       {
/*  58 */         AutoPickField autoPickField = (AutoPickField)field.getAnnotation(AutoPickField.class);
/*  59 */         if (autoPickField != null) {
/*  60 */           field.setAccessible(true);
/*  61 */           this.autoPickFieldAnnoValue = autoPickField.value();
/*  62 */           this.fieldTypeName = field.getType().getSimpleName();
/*  63 */           this.customClassType = autoPickField.type();
/*  64 */           Object result = scanEachJsonNodeKey();
/*  65 */           field.set(JsonFieldAutoPickGenerator.class, result);
/*     */         }
/*     */       }
/*     */       
/*     */       private Object scanEachJsonNodeKey() {
/*  70 */         JsonParserContext context = new JsonParserContext();
/*  71 */         context.putRootJsonNode(rootObject);
/*  72 */         context.setCustomClassType(this.customClassType);
/*  73 */         Object obj = null;
/*     */         try {
/*  75 */           List<String> nodes = getKeyNameOnEachJsonNode();
/*  76 */           if (nodes.size() == 0) {
/*  77 */             obj = rootObject;
/*     */           } else {
/*  79 */             obj = context.getTargetValue(getKeyNameOnEachJsonNode(), this.fieldTypeName);
/*     */           }
/*     */         } catch (Exception e) {
/*  82 */           JsonFieldAutoPickGenerator.logger.error("异常,", e);
/*     */         }
/*  84 */         return obj;
/*     */       }
/*     */       
/*     */       private List<String> getKeyNameOnEachJsonNode()
/*     */       {
/*  89 */         return Arrays.asList(StringUtils.split(this.autoPickFieldAnnoValue, ">"));
/*     */       }
/*     */       
/*  92 */     });
/*  93 */     return rsp;
/*     */   }
/*     */   
/*     */   public static <T> T toGenerator(Map<String, Object> params, Class<T> clazz) throws HttpRestException
/*     */   {
/*  98 */     T rsp = null;
/*     */     try {
/* 100 */       rsp = clazz.newInstance();
/* 101 */       BeanInfo e = Introspector.getBeanInfo(clazz);
/* 102 */       PropertyDescriptor[] pds = e.getPropertyDescriptors();
/* 103 */       PropertyDescriptor[] arrayOfPropertyDescriptor1; int j = (arrayOfPropertyDescriptor1 = pds).length; for (int i = 0; i < j; i++) { PropertyDescriptor pd = arrayOfPropertyDescriptor1[i];
/* 104 */         Method method = pd.getWriteMethod();
/* 105 */         if (method != null)
/*     */         {
/* 107 */           Field field = getField(clazz, pd);
/* 108 */           AutoPickField autoPickField = (AutoPickField)field.getAnnotation(AutoPickField.class);
/* 109 */           if ((autoPickField != null) && (StringUtils.isNotBlank(autoPickField.value())))
/*     */           {
/*     */ 
/* 112 */             Object param = params.get(autoPickField.value());
/* 113 */             method.invoke(rsp, new Object[] { param });
/*     */           }
/*     */         }
/*     */       }
/* 117 */       return rsp;
/*     */     } catch (Exception e) {
/* 119 */       throw new HttpRestException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   private static Field getField(Class<?> clazz, PropertyDescriptor pd)
/*     */   {
/* 125 */     String key = clazz.getName() + "_" + pd.getName();
/* 126 */     Field field = (Field)fieldCache.get(key);
/* 127 */     if (field == null) {
/*     */       try {
/* 129 */         field = clazz.getDeclaredField(pd.getName());
/*     */       }
/*     */       catch (NoSuchFieldException e) {
/*     */         try {
/* 133 */           field = clazz.getSuperclass().getDeclaredField(pd.getName());
/*     */         } catch (NoSuchFieldException|SecurityException e1) {
/* 135 */           logger.error("异常,", e);
/*     */         }
/*     */       } catch (SecurityException e) {
/* 138 */         logger.error("异常,", e);
/*     */       }
/* 140 */       fieldCache.put(key, field);
/*     */     }
/* 142 */     return field;
/*     */   }
/*     */ }
