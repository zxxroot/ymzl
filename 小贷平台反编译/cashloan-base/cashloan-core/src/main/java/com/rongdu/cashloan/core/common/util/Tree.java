/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
/*     */ public class Tree
/*     */ {
/*  24 */   private static final Logger logger = Logger.getLogger(Tree.class);
/*     */   
/*     */   static class TreeObject
/*     */   {
/*     */     public Object value;
/*     */     public Object parent;
/*     */     public String label;
/*  31 */     public Boolean leaf = Boolean.valueOf(true);
/*  32 */     public Boolean expanded = Boolean.valueOf(true);
/*  33 */     public List<TreeObject> children = null;
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
/*     */   public static List<TreeObject> TreeList(List<?> list, String primaryKey, String textKey, String parentKey)
/*     */   {
/*  47 */     Map<String, TreeObject> mapping = new TreeMap();
/*  48 */     for (Object object : list) {
/*  49 */       TreeObject treeObject = new TreeObject();
/*  50 */       treeObject.value = getObjectKeyValue(object, primaryKey).toString();
/*  51 */       treeObject.parent = getObjectKeyValue(object, parentKey).toString();
/*  52 */       treeObject.label = (String) getObjectKeyValue(object, textKey);
/*  53 */       mapping.put((String) treeObject.value, treeObject); }
/*     */     TreeObject parentObject;
/*  55 */     for (TreeObject treeObject : mapping.values()) {
/*  56 */       parentObject = (TreeObject)mapping.get(treeObject.parent);
/*  57 */       if (parentObject != null) {
/*  58 */         parentObject.leaf = Boolean.valueOf(false);
/*  59 */         if (parentObject.children == null) {
/*  60 */           parentObject.children = new ArrayList();
/*     */         }
/*  62 */         parentObject.children.add(treeObject);
/*     */       }
/*     */     }
/*  65 */     List<TreeObject> treeList = new ArrayList();
/*  66 */     for (TreeObject treeObject : mapping.values()) {
/*  67 */       TreeObject parentObject1 = (TreeObject)mapping.get(treeObject.parent);
/*  68 */       if (parentObject1 == null) {
/*  69 */         treeList.add(parentObject1);
/*     */       }
/*     */     }
/*     */     
/*  73 */     return treeList;
/*     */   }
/*     */   
/*     */   public static String TreeJson(List list, String primaryKey, String textKey, String parentKey)
/*     */   {
/*  78 */     return JSONObject.toJSONString(TreeList(list, primaryKey, textKey, parentKey)).toString();
/*     */   }
/*     */   
/*     */   public static Object getObjectKeyValue(Object object, String key)
/*     */   {
/*  83 */     if ((object instanceof Map)) {
/*  84 */       return ((Map)object).get(key);
/*     */     }
/*  86 */     Field[] fields = object.getClass().getDeclaredFields();
/*  87 */     Field[] arrayOfField1; int j = (arrayOfField1 = fields).length; for (int i = 0; i < j; i++) { Field field = arrayOfField1[i];
/*     */       
/*  89 */       field.setAccessible(true);
/*  90 */       if (field.getName().equals(key)) {
/*  91 */         Object value = null;
/*     */         try {
/*  93 */           value = field.get(object);
/*     */         } catch (Exception e) {
/*  95 */           logger.error(e);
/*     */         }
/*  97 */         if (value != null)
/*  98 */           return value;
/*     */       }
/*     */     }
/* 101 */     String getMethodName = "get" + ForMat(key);
/* 102 */     Method method = null;
/*     */     try {
/* 104 */       method = object.getClass().getMethod(getMethodName, new Class[0]);
/*     */     } catch (Exception e) {
/* 106 */       logger.error(e);
/*     */     }
/* 108 */     if (method != null)
/*     */     {
/* 110 */       Object value = null;
/*     */       try {
/* 112 */         value = method.invoke(object, new Object[0]);
/*     */       } catch (Exception e) {
/* 114 */         logger.error(e);
/*     */       }
/* 116 */       return value;
/*     */     }
/*     */     
/* 119 */     return null;
/*     */   }
/*     */   
/*     */   private static String ForMat(String string) {
/* 123 */     if ((string == null) || ("".equals(string)))
/* 124 */       return string;
/* 125 */     return string.substring(0, 1).toUpperCase() + string.substring(1);
/*     */   }
/*     */ }
