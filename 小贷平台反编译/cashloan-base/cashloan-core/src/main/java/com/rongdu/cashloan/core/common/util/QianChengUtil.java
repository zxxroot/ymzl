/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.rongdu.cashloan.core.common.context.Global;
/*    */ import java.io.PrintStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ public class QianChengUtil
/*    */ {
/* 15 */   private static final Logger logger = LoggerFactory.getLogger(QianChengUtil.class);
/*    */   
/* 17 */   public static final String QC_TOKEN_URL = Global.getValue("qiancheng_token_partner_url");
/*    */   
/* 19 */   public static final String QC_BLACK_URL = Global.getValue("qiancheng_black_data_url");
/*    */   
/* 21 */   public static final String username = Global.getValue("qiancheng_username");
/*    */   
/* 23 */   public static final String password = Global.getValue("qiancheng_password");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getAccessToken()
/*    */   {
/* 32 */     String result = null;
/*    */     try {
/* 34 */       Map<String, String> params = new HashMap();
/* 35 */       params.put("username", username);
/* 36 */       params.put("password", password);
/* 37 */       result = HttpsUtil.postClient(QC_TOKEN_URL, params);
/* 38 */       Map<String, Object> resultMap = JSONObject.parseObject(result);
/* 39 */       result = JSONObject.parseObject(resultMap.get("data").toString()).getString("token");
/*    */     } catch (Exception e) {
/* 41 */       logger.error(e.getMessage(), e);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */   
/*    */   public static String getBalck(String name, String idCard, String mobile) {
/* 47 */     String res = null;
/*    */     try {
/* 49 */       Map<String, String> params = new HashMap();
/* 50 */       params.put("token", getAccessToken());
/* 51 */       params.put("name", name);
/* 52 */       params.put("id_card", idCard);
/* 53 */       params.put("mobile", mobile);
/* 54 */       res = HttpsUtil.postClient(QC_BLACK_URL, params);
/*    */     } catch (Exception e) {
/* 56 */       logger.error(e.getMessage(), e);
/*    */     }
/* 58 */     return res;
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 62 */     String res = getBalck("赵怡萍", "41142319940517002X", "18300674029");
/* 63 */     JSONArray array = JSONObject.parseObject(res).getJSONArray("data");
/* 64 */     boolean token = ((Boolean)array.getJSONObject(0).get("is_in")).booleanValue();
/* 65 */     System.out.println(token);
/*    */   }
/*    */ }
