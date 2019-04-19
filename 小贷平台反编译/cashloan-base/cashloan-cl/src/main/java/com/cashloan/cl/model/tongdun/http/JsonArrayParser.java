/*    */ package com.cashloan.cl.model.tongdun.http;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Observable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonArrayParser
/*    */   implements JsonNodeTypeParser
/*    */ {
/*    */   private Class customClazz;
/*    */   
/*    */   public JsonArrayParser(Class customClazz)
/*    */   {
/* 21 */     this.customClazz = customClazz;
/*    */   }
/*    */   
/*    */   public Object onTargetNode(List<JSONObject> list, String jsonKey)
/*    */     throws Exception
/*    */   {
/* 27 */     List<Object> resultList = new ArrayList();
/*    */     try { Iterator localIterator2;
/* 29 */       for (Iterator localIterator1 = list.iterator(); localIterator1.hasNext(); 
/*    */           
/* 31 */           localIterator2.hasNext())
/*    */       {
/* 29 */         JSONObject jsonObject = (JSONObject)localIterator1.next();
/* 30 */         JSONArray array = jsonObject.getJSONArray(org.apache.commons.lang3.StringUtils.split(jsonKey, "[]")[0]);
/* 31 */         localIterator2 = array.iterator();
Object anArray = localIterator2.next();
/* 32 */         if (((anArray instanceof JSONObject)) && (this.customClazz != Object.class)) {
/* 33 */           anArray = JSONObject.toJavaObject((JSON)anArray, this.customClazz);
/*    */         }
/* 35 */         resultList.add(anArray);
/*    */       }
/*    */     }
/*    */     catch (Exception e) {
/* 39 */       throw e;
/*    */     }
/* 41 */     return resultList;
/*    */   }
/*    */   
/*    */   public void onTargetPreviousNode(List<JSONObject> list, String jsonKey) throws Exception
/*    */   {
/* 46 */     List<JSONArray> currentLevelJsonArrayList = new ArrayList();
/* 47 */     for (JSONObject preLevelJsonObject : list) {
/* 48 */       JSONArray array = preLevelJsonObject.getJSONArray(org.apache.commons.lang3.StringUtils.split(jsonKey, "[]")[0]);
/* 49 */       currentLevelJsonArrayList.add(array);
/*    */     }
/*    */     
/* 52 */     list.clear();
/*    */     /*JSONArray array;
*//* 54 *//*     int j; for (??? = currentLevelJsonArrayList.iterator(); ???.hasNext();
*//* 55 *//*         j < array.size())
*//*    *//*     {
*//* 54 *//*       array = (JSONArray)???.next();
*//* 55 *//*       j = 0;
*//* 56 *//*       list.add(array.getJSONObject(j));j++;
*//*    *//*     }*/
/*    */   }
/*    */   
/*    */   public void update(Observable o, Object arg) {}
/*    */ }
