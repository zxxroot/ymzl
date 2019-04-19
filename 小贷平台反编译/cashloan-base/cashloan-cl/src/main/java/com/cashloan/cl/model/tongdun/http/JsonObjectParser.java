/*    */ package com.cashloan.cl.model.tongdun.http;
/*    */ 
/*    */

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonObjectParser
/*    */   implements JsonNodeTypeParser
/*    */ {
/*    */   private String fieldTypeName;
/*    */   private boolean isListResult;
/*    */   private Class customClazz;
/*    */   
/*    */   public JsonObjectParser(String fieldTypeName, Class customClazz)
/*    */   {
/* 23 */     this.fieldTypeName = fieldTypeName;
/* 24 */     this.customClazz = customClazz;
/*    */   }
/*    */   
/*    */   public Object onTargetNode(List<JSONObject> list, String jsonKey)
/*    */     throws Exception
/*    */   {
/* 30 */     if (!this.isListResult) {
/* 31 */       if (this.customClazz != Object.class) {
/* 32 */         return JSONObject.toJavaObject(((JSONObject)list.get(0)).getJSONObject(jsonKey), this.customClazz);
/*    */       }
/* 34 */       return matchType((JSONObject)list.get(0), this.fieldTypeName, jsonKey);
/*    */     }
/* 36 */     List<Object> resultList = new ArrayList();
/* 37 */     for (JSONObject preLevelJsonObject : list) {
/* 38 */       if (this.customClazz != Object.class) {
/* 39 */         resultList.add(JSONObject.toJavaObject(preLevelJsonObject.getJSONObject(jsonKey), this.customClazz));
/*    */       } else {
/* 41 */         resultList.add(matchType(preLevelJsonObject, this.fieldTypeName, jsonKey));
/*    */       }
/*    */     }
/* 44 */     return resultList;
/*    */   }
/*    */   
/*    */   public void onTargetPreviousNode(List<JSONObject> list, String jsonKey)
/*    */     throws Exception
/*    */   {
/* 50 */     List<JSONObject> currentLevelJsonObjectList = new ArrayList();
/* 51 */     for (JSONObject preLevelJsonObject : list) {
/* 52 */       JSONObject currentJsonObject = preLevelJsonObject.getJSONObject(jsonKey);
/* 53 */       currentLevelJsonObjectList.add(currentJsonObject);
/*    */     }
/*    */     
/* 56 */     list.clear();
/*    */     
/* 58 */     for (JSONObject object : currentLevelJsonObjectList) {
/* 59 */       list.add(object);
/*    */     }
/*    */   }
/*    */   
/*    */   private Object matchType(JSONObject json, String fieldType, String key) {
/* 64 */     Object value = null;
/* 65 */     String str; switch ((str = fieldType).hashCode()) {case -1808118735:  if (str.equals("String")) {} break; case -672261858:  if (str.equals("Integer")) break; break; case 2374300:  if (str.equals("Long")) {} break; case 2052876273:  if (!str.equals("Double")) {

/* 67 */         value = json.getInteger(key);
/*    */
/* 70 */         value = json.getLong(key);
/*    */
/*    */       } else {
/* 73 */         value = json.getDouble(key);
/*    */
/* 76 */         value = json.getString(key); }
/* 77 */       break; }
/*    */     label144:
/* 79 */     value = json.get(key);
/*    */     
/*    */     label151:
/* 82 */     return value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void update(Observable o, Object arg)
/*    */   {
/* 93 */     this.isListResult = true;
/*    */   }
/*    */ }
