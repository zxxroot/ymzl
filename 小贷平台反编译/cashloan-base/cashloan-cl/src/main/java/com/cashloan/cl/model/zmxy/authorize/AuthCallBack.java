/*    */ package com.cashloan.cl.model.zmxy.authorize;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.antgroup.zmxy.openplatform.api.internal.util.RSACoderUtil;
/*    */ import com.cashloan.cl.model.zmxy.base.BaseQuery;
/*    */ import java.net.URLDecoder;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AuthCallBack
/*    */   extends BaseQuery
/*    */ {
/* 19 */   public static final Logger logger = LoggerFactory.getLogger(AuthCallBack.class);
/*    */   
/*    */   private String openId;
/*    */   
/*    */   private String key;
/*    */   private String errorCode;
/*    */   private String errorMessage;
/*    */   
/*    */   public AuthCallBack(String privateKey, String zhimaPublicKey, String appId)
/*    */   {
/* 29 */     super(privateKey);
/*    */   }
/*    */   
/*    */   public String getErrorCode() {
/* 33 */     return this.errorCode;
/*    */   }
/*    */   
/*    */   public String getErrorMessage() {
/* 37 */     return this.errorMessage;
/*    */   }
/*    */   
/*    */   public String getOpenId() {
/* 41 */     return this.openId;
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 45 */     return this.key;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public AuthCallBackResp decryptedParam(String param)
/*    */   {
/* 55 */     AuthCallBackResp authCallBackResp = new AuthCallBackResp();
/*    */     try {
/* 57 */       String decryptedParam = RSACoderUtil.decrypt(param, getPrivateKey(), "UTF-8");
/* 58 */       decryptedParam = URLDecoder.decode(decryptedParam, "UTF-8");
/* 59 */       logger.info(decryptedParam);
/* 60 */       String[] keyValues = decryptedParam.split("&");
/* 61 */       JSONObject paramJson = new JSONObject(true);
/* 62 */       String[] arrayOfString1; int j = (arrayOfString1 = keyValues).length; for (int i = 0; i < j; i++) { String keyValue = arrayOfString1[i];
/* 63 */         String[] each = keyValue.split("=");
/* 64 */         paramJson.put(each[0], each[1]);
/*    */       }
/* 66 */       authCallBackResp.setSuccess(paramJson.getBooleanValue("success"));
/* 67 */       authCallBackResp.setOpenId(paramJson.getString("open_id"));
/* 68 */       authCallBackResp.setKey(paramJson.getString("state"));
/* 69 */       authCallBackResp.setErrorCode(paramJson.getString("error_code"));
/* 70 */       authCallBackResp.setErrorMessage(paramJson.getString("error_message"));
/*    */     } catch (Exception e) {
/* 72 */       logger.error(e.getMessage(), e);
/*    */     }
/* 74 */     return authCallBackResp;
/*    */   }
/*    */ }
