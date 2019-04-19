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
/*     */ public class CheckBoxTree
/*     */ {
/*  24 */   private static final Logger logger = Logger.getLogger(CheckBoxTree.class);
/*     */   
/*     */   static class TreeObject {
/*     */     public Object value;
/*     */     public Object key;
/*     */     public Object parent;
/*     */     public String label;
/*  31 */     public Boolean leaf = Boolean.valueOf(true);
/*  32 */     public Boolean expanded = Boolean.valueOf(true);
/*  33 */     public Boolean checked = Boolean.valueOf(false);
/*  34 */     public List<TreeObject> children = null;
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
/*     */ 
/*     */   public static List TreeList(List list, String primaryKey, String textKey, String parentKey, String ids)
/*     */   {
/*  49 */     Map<String, TreeObject> mapping = new TreeMap();
/*  50 */     for (Object object : list) {
/*  51 */       TreeObject treeObject = new TreeObject();
/*  52 */       treeObject.value = getObjectKeyValue(object, primaryKey);
/*  53 */       treeObject.key = getObjectKeyValue(object, primaryKey);
/*  54 */       treeObject.parent = getObjectKeyValue(object, parentKey);
/*  55 */       treeObject.label = String.valueOf(getObjectKeyValue(object, textKey));
/*  56 */       mapping.put(String.valueOf(treeObject.value), treeObject); }
/*     */     TreeObject parentObject;
/*  58 */     for (TreeObject treeObject : mapping.values()) {
/*  59 */       parentObject = (TreeObject)mapping.get(treeObject.parent);
/*  60 */       if (parentObject != null) {
/*  61 */         parentObject.leaf = Boolean.valueOf(false);
/*  62 */         if (parentObject.children == null)
/*  63 */           parentObject.children = new ArrayList();
/*  64 */         parentObject.children.add(treeObject);
/*     */       }
/*     */     }
/*  67 */     List treeList = new ArrayList();
/*  68 */     for (TreeObject treeObject : mapping.values()) {
/*  69 */       TreeObject parentObject1 = (TreeObject)mapping.get(treeObject.parent);
/*  70 */       if (parentObject1 == null)
/*  71 */         treeList.add(parentObject1);
/*     */     }
/*  73 */     return treeList;
/*     */   }
/*     */   
/*     */   public static String TreeJson(List list, String primaryKey, String textKey, String parentKey)
/*     */   {
/*  78 */     return JSONObject.toJSONString(Tree.TreeList(list, primaryKey, textKey, parentKey)).toString();
/*     */   }
/*     */   
/*     */   private static Object getObjectKeyValue(Object object, String key)
/*     */   {
/*  83 */     if ((object instanceof Map)) {
/*  84 */       return ((Map)object).get(key);
/*     */     }
/*  86 */     Field[] fields = object.getClass().getDeclaredFields();
/*  87 */     Field[] arrayOfField1; int j = (arrayOfField1 = fields).length; for (int i = 0; i < j; i++) { Field field = arrayOfField1[i];
/*     */       
/*  89 */       if (field.getName().equals(key)) {
/*  90 */         Object value = null;
/*     */         try {
/*  92 */           value = field.get(object);
/*     */         } catch (Exception e) {
/*  94 */           logger.info(e);
/*     */         }
/*  96 */         if (value != null)
/*  97 */           return value;
/*     */       }
/*     */     }
/* 100 */     String getMethodName = "get" + ForMat(key);
/* 101 */     Method method = null;
/*     */     try {
/* 103 */       method = object.getClass().getMethod(getMethodName, new Class[0]);
/*     */     } catch (Exception e) {
/* 105 */       logger.info(e);
/*     */     }
/* 107 */     if (method != null)
/*     */     {
/* 109 */       Object value = null;
/*     */       try {
/* 111 */         value = method.invoke(object, new Object[0]);
/*     */       } catch (Exception e) {
/* 113 */         logger.info(e);
/*     */       }
/* 115 */       return value;
/*     */     }
/*     */     
/* 118 */     return null;
/*     */   }
/*     */   
/*     */   private static String ForMat(String string) {
/* 122 */     if ((string == null) || ("".equals(string)))
/* 123 */       return string;
/* 124 */     return string.substring(0, 1).toUpperCase() + string.substring(1);
/*     */   }
/*     */ }
