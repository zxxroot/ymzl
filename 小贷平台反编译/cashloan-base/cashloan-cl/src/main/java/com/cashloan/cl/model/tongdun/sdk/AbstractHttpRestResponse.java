/*     */ package com.cashloan.cl.model.tongdun.sdk;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.cashloan.cl.model.tongdun.http.AutoPickField;
/*     */ import com.cashloan.cl.model.tongdun.http.HttpRestRequest;
/*     */ import com.cashloan.cl.model.tongdun.http.HttpRestResponse;
/*     */ import java.util.Map;
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
/*     */ public class AbstractHttpRestResponse
/*     */   extends HttpRestResponse
/*     */ {
/*     */   @AutoPickField("success")
/*     */   private Boolean success;
/*     */   @AutoPickField("reason_desc")
/*     */   private String retMsg;
/*     */   @AutoPickField("reason_code")
/*     */   private String retCode;
/*     */   @AutoPickField
/*     */   private JSONObject data;
/*     */   @AutoPickField("code")
/*     */   private String code;
/*     */   @AutoPickField("message")
/*     */   private String message;
/*     */   
/*     */   public Boolean getSuccess()
/*     */   {
/*  40 */     return this.success;
/*     */   }
/*     */   
/*     */   public String getRetMsg() {
/*  44 */     return this.retMsg;
/*     */   }
/*     */   
/*     */   public JSONObject getData() {
/*  48 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setSuccess(Boolean success) {
/*  52 */     this.success = success;
/*     */   }
/*     */   
/*     */   public void setRetMsg(String retMsg) {
/*  56 */     this.retMsg = retMsg;
/*     */   }
/*     */   
/*     */   public void setData(JSONObject data) {
/*  60 */     this.data = data;
/*     */   }
/*     */   
/*     */   public String getRetCode() {
/*  64 */     return this.retCode;
/*     */   }
/*     */   
/*     */   public void setRetCode(String retCode) {
/*  68 */     this.retCode = retCode;
/*     */   }
/*     */   
/*     */ 
/*     */   public String postResponseToJsonStr()
/*     */   {
/*  74 */     JSONObject retJson = new JSONObject(true);
/*  75 */     if (this.success.booleanValue()) {
/*  76 */       retJson.put("code", Integer.valueOf(200));
/*  77 */       retJson.put("data", getData());
/*  78 */       retJson.put("message", "调用成功！");
/*     */     } else {
/*  80 */       retJson.put("code", this.retCode);
/*  81 */       retJson.put("message", getRetMsg());
/*     */     }
/*  83 */     return JSON.toJSONString(retJson);
/*     */   }
/*     */   
/*  86 */   public String postResponseToStr() { JSONObject retJson = new JSONObject(true);
/*  87 */     if (this.code.equals("0")) {
/*  88 */       retJson.put("code", Integer.valueOf(200));
/*  89 */       retJson.put("data", getData());
/*  90 */       retJson.put("message", "调用成功！");
/*     */     } else {
/*  92 */       retJson.put("code", this.code);
/*  93 */       retJson.put("message", getMessage());
/*     */     }
/*  95 */     return JSON.toJSONString(retJson);
/*     */   }
/*     */   
/*     */ 
/*     */   public Map handleReqJson()
/*     */   {
/* 101 */     HttpRestRequest restRequest = getHttpRestRequest();
/* 102 */     Map req = (Map)JSONObject.parseObject(restRequest.getRequestBody(), Map.class);
/* 103 */     return req;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public JSONObject handleResJson()
/*     */     throws Exception
/*     */   {
/* 113 */     return getData();
/*     */   }
/*     */ }
