/*    */ package com.rongdu.cashloan.core.common.util.json.fastjson;
/*    */ 
/*    */ import com.alibaba.fastjson.serializer.JSONSerializer;
/*    */ import com.alibaba.fastjson.serializer.PropertyFilter;
/*    */ import com.rongdu.cashloan.core.common.util.json.ObjToJsonSerializer;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ObjToJsonSerializerImpl
/*    */   implements ObjToJsonSerializer
/*    */ {
/*    */   public String objectToJsonString(Object object, String[] properties, Boolean isFilter)
/*    */   {
/* 18 */     JSONSerializer json = new JSONSerializer();
/*    */     
/* 20 */     if ((properties != null) && (properties.length > 0)) {
/* 21 */       arrayToFilters(json, properties, isFilter);
/*    */     }
/* 23 */     json.write(object);
/* 24 */     return json.toString();
/*    */   }
/*    */   
/*    */   public String objectToJsonString(Object object) {
/* 28 */     JSONSerializer json = new JSONSerializer();
/* 29 */     json.write(object);
/* 30 */     return json.toString();
/*    */   }
/*    */   
/*    */   public String objectToJsonStringWithInclude(Object object, String[] properties)
/*    */   {
/* 35 */     return objectToJsonString(object, properties, Boolean.valueOf(false));
/*    */   }
/*    */   
/*    */ 
/*    */   public String objectToJsonStringWithExclude(Object object, String[] properties)
/*    */   {
/* 41 */     return objectToJsonString(object, properties, Boolean.valueOf(true));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void arrayToFilters(JSONSerializer jsonSerializer, String[] properties, Boolean isFilter)
/*    */   {
/* 52 */     List<PropertyFilter> filterList = jsonSerializer.getPropertyFilters();
/* 53 */     String[] arrayOfString; int j; int i; if ((isFilter != null) && (!isFilter.booleanValue()))
/*    */     {
/* 55 */       j = (arrayOfString = properties).length; for (i = 0; i < j; i++) { final String property = arrayOfString[i];
/* 56 */         PropertyFilter filter = new PropertyFilter() {
/*    */           public boolean apply(Object source, String name, Object value) {
/* 58 */             if (property.equals(name)) {
/* 59 */               return true;
/*    */             }
/* 61 */             return false;
/*    */           }
/* 63 */         };
/* 64 */         filterList.add(filter);
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 69 */       j = (arrayOfString = properties).length; for (i = 0; i < j; i++) { final String property = arrayOfString[i];
/* 70 */         PropertyFilter filter = new PropertyFilter() {
/*    */           public boolean apply(Object source, String name, Object value) {
/* 72 */             if (property.equals(name)) {
/* 73 */               return false;
/*    */             }
/* 75 */             return true;
/*    */           }
/* 77 */         };
/* 78 */         filterList.add(filter);
/*    */       }
/*    */     }
/*    */   }
/*    */ }
