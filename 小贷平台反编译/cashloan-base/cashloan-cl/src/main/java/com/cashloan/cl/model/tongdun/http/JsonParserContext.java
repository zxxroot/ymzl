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
/*    */ public class JsonParserContext
/*    */   extends Observable
/*    */ {
/* 16 */   private List<JSONObject> preLevelJsonObjectList = new ArrayList();
/*    */   
/*    */   private List<String> keyNameOnEachJsonNode;
/*    */   
/*    */   private Class customClassType;
/*    */   
/*    */ 
/*    */   public List<JSONObject> getPreLevelJsonObjectList()
/*    */   {
/* 25 */     return this.preLevelJsonObjectList;
/*    */   }
/*    */   
/*    */   public void setPreLevelJsonObjectList(List<JSONObject> preLevelJsonObjectList) {
/* 29 */     this.preLevelJsonObjectList = preLevelJsonObjectList;
/*    */   }
/*    */   
/*    */   public void putRootJsonNode(JSONObject root) {
/* 33 */     this.preLevelJsonObjectList.add(root);
/*    */   }
/*    */   
/*    */   public void setCustomClassType(Class customClassType) {
/* 37 */     this.customClassType = customClassType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Object getTargetValue(List<String> keyNameOnEachJsonNode, String fieldTypeName)
/*    */     throws Exception
/*    */   {
/* 48 */     JsonNodeTypeParser arrayParser = new JsonArrayParser(this.customClassType);
/* 49 */     JsonNodeTypeParser objParser = new JsonObjectParser(fieldTypeName, this.customClassType);
/* 50 */     addObserver(objParser);
/* 51 */     this.keyNameOnEachJsonNode = keyNameOnEachJsonNode;
/* 52 */     Object resultValue = null;
/* 53 */     for (String jsonKey : keyNameOnEachJsonNode) {
/* 54 */       if (isTypeIsJsonArray(jsonKey)) {
/* 55 */         if (isOnTargetIndex(jsonKey)) {
/* 56 */           resultValue = arrayParser.onTargetNode(this.preLevelJsonObjectList, jsonKey);
/* 57 */           break;
/*    */         }
/* 59 */         arrayParser.onTargetPreviousNode(this.preLevelJsonObjectList, jsonKey);
/*    */       }
/*    */       else {
/* 62 */         if (isOnTargetIndex(jsonKey)) {
/* 63 */           resultValue = objParser.onTargetNode(this.preLevelJsonObjectList, jsonKey);
/* 64 */           break;
/*    */         }
/* 66 */         objParser.onTargetPreviousNode(this.preLevelJsonObjectList, jsonKey);
/*    */       }
/*    */     }
/*    */     
/* 70 */     return resultValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean isTypeIsJsonArray(String jsonKey)
/*    */   {
/* 80 */     if (jsonKey.endsWith("[]")) {
/* 81 */       setChanged();
/* 82 */       notifyObservers();
/* 83 */       return true;
/*    */     }
/* 85 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean isOnTargetIndex(String jsonKey)
/*    */   {
/* 96 */     if (this.keyNameOnEachJsonNode.lastIndexOf(jsonKey) == this.keyNameOnEachJsonNode.size() - 1) {
/* 97 */       return true;
/*    */     }
/* 99 */     return false;
/*    */   }
/*    */ }
