/*     */ package com.rongdu.cashloan.core.common.util.json.fastjson;
/*     */ 
/*     */ import com.alibaba.fastjson.serializer.JSONSerializer;
/*     */ import com.alibaba.fastjson.serializer.PropertyFilter;
/*     */ import com.alibaba.fastjson.serializer.SerializeWriter;
/*     */ import com.rongdu.cashloan.core.common.util.json.AbstractJsonSerializer;
/*     */ import java.util.List;
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
/*     */ public class JsonSerializer
/*     */   extends AbstractJsonSerializer
/*     */ {
/*     */   private JSONSerializer json;
/*  27 */   private boolean hasObject = false;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String DEFAULT_NAME = "data";
/*     */   
/*     */ 
/*     */ 
/*     */   public JsonSerializer(String name)
/*     */   {
/*  37 */     this.json = new JSONSerializer();
/*  38 */     if (name != null) {
/*  39 */       writeHead();
/*     */     }
/*     */   }
/*     */   
/*     */   public JsonSerializer(boolean needErrorInfo, String name) {
/*  44 */     this.json = new JSONSerializer();
/*  45 */     setNeedErrorInfo(needErrorInfo);
/*  46 */     if (name != null) {
/*  47 */       writeHead();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void writeHead()
/*     */   {
/*  55 */     this.json.getWriter().append('{');
/*     */   }
/*     */   
/*     */   public void addObject(Object object, String name, String[] properties, Boolean isFilter)
/*     */   {
/*  60 */     SerializeWriter writer = this.json.getWriter();
/*     */     
/*  62 */     if (this.hasObject) {
/*  63 */       writer.append(',');
/*     */     }
/*     */     else {
/*  66 */       this.hasObject = true;
/*     */     }
/*     */     
/*  69 */     this.json.getPropertyFilters().clear();
/*     */     
/*     */ 
/*  72 */     if ((properties != null) && (properties.length > 0)) {
/*  73 */       arrayToFilters(this.json, properties, isFilter);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */     if ((name != null) && (!"".equals(name)) && (name.length() > 0)) {
/*  82 */       this.json.write(name);
/*  83 */       writer.append(':');
/*     */     }
/*  85 */     this.json.write(object);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addObject(Object object, String name)
/*     */   {
/*  91 */     addObject(object, name, null, Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */ 
/*     */   public void addObjectWithExclude(Object object, String name, String[] properties)
/*     */   {
/*  97 */     addObject(object, name, properties, Boolean.valueOf(true));
/*     */   }
/*     */   
/*     */   public void addObjectWithInclude(Object object, String name, String[] properties)
/*     */   {
/* 102 */     addObject(object, name, properties, Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 108 */     return this.json.toString();
/*     */   }
/*     */   
/*     */   public String toString(String name) {
/* 112 */     writeTail(name);
/* 113 */     return this.json.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void writeTail(String name)
/*     */   {
/* 120 */     SerializeWriter writer = this.json.getWriter();
/*     */     
/* 122 */     if (isNeedErrorInfo()) {
/* 123 */       if (this.hasObject) {
/* 124 */         writer.append(',');
/*     */       }
/* 126 */       this.json.write("errorNo");
/* 127 */       writer.append(":");
/* 128 */       this.json.write(getErrorNo());
/* 129 */       writer.append(',');
/* 130 */       this.json.write("errorInfo");
/* 131 */       writer.append(":");
/* 132 */       this.json.write(getErrorInfo());
/*     */     }
/* 134 */     if (name != null) {
/* 135 */       writer.append('}');
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void arrayToFilters(JSONSerializer jsonSerializer, String[] properties, Boolean isFilter)
/*     */   {
/* 147 */     List<PropertyFilter> filterList = jsonSerializer.getPropertyFilters();
/* 148 */     String[] arrayOfString; int j; int i; if ((isFilter != null) && (!isFilter.booleanValue()))
/*     */     {
/* 150 */       j = (arrayOfString = properties).length; for (i = 0; i < j; i++) { final String property = arrayOfString[i];
/* 151 */         PropertyFilter filter = new PropertyFilter() {
/*     */           public boolean apply(Object source, String name, Object value) {
/* 153 */             if (property.equals(name)) {
/* 154 */               return true;
/*     */             }
/* 156 */             return false;
/*     */           }
/* 158 */         };
/* 159 */         filterList.add(filter);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 164 */       j = (arrayOfString = properties).length; for (i = 0; i < j; i++) { final String property = arrayOfString[i];
/* 165 */         PropertyFilter filter = new PropertyFilter() {
/*     */           public boolean apply(Object source, String name, Object value) {
/* 167 */             if (property.equals(name)) {
/* 168 */               return false;
/*     */             }
/* 170 */             return true;
/*     */           }
/* 172 */         };
/* 173 */         filterList.add(filter);
/*     */       }
/*     */     }
/*     */   }
/*     */ }
