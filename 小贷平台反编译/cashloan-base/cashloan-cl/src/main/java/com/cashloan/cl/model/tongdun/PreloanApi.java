/*     */ package com.cashloan.cl.model.tongdun;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.cashloan.cl.model.tongdun.http.HttpRestClient;
/*     */ import com.cashloan.cl.model.tongdun.sdk.PreloanReportRequest;
/*     */ import com.cashloan.cl.model.tongdun.sdk.PreloanReportResponse;
/*     */ import com.cashloan.cl.model.tongdun.sdk.PreloanRequest;
/*     */ import com.cashloan.cl.model.tongdun.sdk.PreloanResponse;
/*     */ import com.cashloan.cl.service.impl.TongdunReqLogServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.base64.Base64Encoder;
/*     */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PreloanApi
/*     */ {
/*  33 */   private static final Logger logger = LoggerFactory.getLogger(TongdunReqLogServiceImpl.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String preloan(Map<String, Object> map, TppBusiness business, boolean testState, String mobileType)
/*     */   {
/*     */     try
/*     */     {
/*  43 */       PreloanRequest request = new PreloanRequest();
/*     */       
/*  45 */       JSONObject extend = JSONObject.parseObject(business.getExtend());
/*  46 */       request.setHttpMethod("POST");
/*  47 */       String partnerKey = extend.getString("partner_key");
/*  48 */       String partnerCode = extend.getString("partner_code");
/*  49 */       String appName = extend.getString("app_name");
/*  50 */       JSONObject names = JSONObject.parseObject(appName);
/*  51 */       if (mobileType.equals("1")) {
/*  52 */         appName = names.getString("ios");
/*  53 */       } else if (mobileType.equals("2")) {
/*  54 */         appName = names.getString("and");
/*     */       } else {
/*  56 */         appName = names.getString("web");
/*     */       }
/*  58 */       String urlParam = "partner_key=" + partnerKey + "&partner_code=" + partnerCode + "&app_name=" + appName;
/*     */       
/*  60 */       request.setUrlParam(urlParam);
/*  61 */       request.setServerHost(testState ? business.getTestUrl() : business.getUrl());
/*     */       
/*  63 */       request.setParamMap(map);
/*  64 */       PreloanResponse response = (PreloanResponse)HttpRestClient.create().executeThenGetJsonResponse(request);
/*  65 */       return response.postResponseToJsonStr();
/*     */     }
/*     */     catch (Exception e) {
/*  68 */       e.printStackTrace();
/*     */     }
/*  70 */     return "";
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
/*     */   public PreloanReportResponse preloanReport(Map<String, Object> map, TppBusiness business, boolean testState, String mobileType)
/*     */   {
/*  83 */     PreloanReportRequest request = new PreloanReportRequest();
/*     */     
/*  85 */     JSONObject extend = JSONObject.parseObject(business.getExtend());
/*  86 */     request.setHttpMethod("GET");
/*  87 */     request.setServerHost(testState ? business.getTestUrl() : business.getUrl());
/*  88 */     String partnerKey = extend.getString("partner_key");
/*  89 */     String partnerCode = extend.getString("partner_code");
/*  90 */     String appName = extend.getString("app_name");
/*  91 */     JSONObject names = JSONObject.parseObject(appName);
/*  92 */     if (mobileType.equals("1")) {
/*  93 */       appName = names.getString("ios");
/*  94 */     } else if (mobileType.equals("2")) {
/*  95 */       appName = names.getString("and");
/*     */     } else {
/*  97 */       appName = names.getString("web");
/*     */     }
/*  99 */     String urlParam = "partner_key=" + partnerKey + "&partner_code=" + partnerCode + "&app_name=" + appName;
/*     */     
/* 101 */     Map bodyMap = (Map)JSON.parseObject((String)map.get("body"), Map.class);
/* 102 */     String reportId = (String)bodyMap.get("report_id");
/* 103 */     urlParam = urlParam + "&report_id=" + reportId;
/* 104 */     request.setUrlParam(urlParam);
/*     */     
/* 106 */     request.setParamMap(map);
/* 107 */     PreloanReportResponse response = (PreloanReportResponse)HttpRestClient.create().executeThenGetJsonResponse(request);
/* 108 */     return response;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String operatorQuery(Map<String, Object> map)
/*     */   {
/* 116 */     PreloanRequest request = new PreloanRequest();
/* 117 */     String partnerKey = Global.getValue("tongdun_operator_partner_key");
/* 118 */     String partnerCode = Global.getValue("tongdun_operator_partner_code");
/* 119 */     String queryUrl = Global.getValue("tongdun_operator_query_url");
/* 120 */     String urlParam = "partner_key=" + partnerKey + "&partner_code=" + partnerCode;
/* 121 */     logger.info("==请求参数=" + queryUrl + "?" + urlParam);
/* 122 */     request.setHttpMethod("POST");
/* 123 */     request.setUrlParam(urlParam);
/* 124 */     request.setServerHost(queryUrl);
/* 125 */     Map<String, Object> body = new HashMap();
/* 126 */     body.put("body", JsonUtil.toString(map));
/* 127 */     request.setParamMap(body);
/* 128 */     PreloanResponse response = (PreloanResponse)HttpRestClient.create().executeThenGetJsonResponse(request);
/* 129 */     return response.postResponseToStr();
/*     */   }
/*     */   
/*     */ 
/*     */   public static String sign(Map<String, Object> signMap)
/*     */   {
/* 135 */     String original = genSignData(JSONObject.toJSONString(signMap));
/*     */     try
/*     */     {
/* 138 */       MessageDigest md5 = MessageDigest.getInstance("MD5");
/* 139 */       Base64Encoder base64 = new Base64Encoder();
/* 140 */       return base64.encode(md5.digest(original.toString().getBytes("utf-8")));
/*     */     }
/*     */     catch (Exception e) {
/* 143 */       e.printStackTrace();
/*     */     }
/* 145 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String genSignData(String jsonStr)
/*     */   {
/* 155 */     JSONObject jsonObject = JSON.parseObject(jsonStr);
/* 156 */     StringBuilder content = new StringBuilder();
/*     */     
/*     */ 
/* 159 */     List<String> keys = new ArrayList(jsonObject.keySet());
/* 160 */     Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
/* 161 */     for (int i = 0; i < keys.size(); i++) {
/* 162 */       String key = (String)keys.get(i);
/*     */       
/* 164 */       if (!"sign".equals(key))
/*     */       {
/*     */ 
/* 167 */         String value = jsonObject.getString(key);
/*     */         
/* 169 */         if (!StringUtils.isEmpty(value))
/*     */         {
/*     */ 
/* 172 */           content.append((i == 0 ? "" : "&") + key + "=" + value); }
/*     */       }
/*     */     }
/* 175 */     String signSrc = content.toString();
/* 176 */     if (signSrc.startsWith("&")) {
/* 177 */       signSrc = signSrc.replaceFirst("&", "");
/*     */     }
/* 179 */     return signSrc;
/*     */   }
/*     */ }
