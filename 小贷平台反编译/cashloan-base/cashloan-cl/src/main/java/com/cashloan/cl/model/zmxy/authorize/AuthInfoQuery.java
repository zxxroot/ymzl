/*     */ package com.cashloan.cl.model.zmxy.authorize;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;
import com.antgroup.zmxy.openplatform.api.ZhimaApiException;
import com.antgroup.zmxy.openplatform.api.request.ZhimaAuthInfoAuthorizeRequest;
import com.antgroup.zmxy.openplatform.api.request.ZhimaAuthInfoAuthqueryRequest;
import com.antgroup.zmxy.openplatform.api.response.ZhimaAuthInfoAuthqueryResponse;
import com.cashloan.cl.model.zmxy.base.BaseQuery;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;

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
/*     */ 
/*     */ 
/*     */ public class AuthInfoQuery
/*     */   extends BaseQuery
/*     */ {
/*  27 */   public static final Logger logger = LoggerFactory.getLogger(AuthInfoQuery.class);
/*     */   
/*     */   public AuthInfoQuery(String privateKey, String zhimaPublicKey, String appId) {
/*  30 */     super(privateKey, zhimaPublicKey, appId);
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
/*     */   public AuthOpenIdResp queryOpenId(String certNo, String name)
/*     */     throws ServiceException
/*     */   {
/*  44 */     String certType = "IDENTITY_CARD";
/*  45 */     JSONObject paramJson = new JSONObject(true);
/*  46 */     paramJson.put("certNo", certNo);
/*  47 */     paramJson.put("name", name);
/*  48 */     paramJson.put("certType", "IDENTITY_CARD");
/*  49 */     ZhimaAuthInfoAuthqueryRequest req = new ZhimaAuthInfoAuthqueryRequest();
/*  50 */     req.setIdentityType("2");
/*  51 */     req.setIdentityParam(paramJson.toJSONString());
/*  52 */     DefaultZhimaClient client = new DefaultZhimaClient("https://zmopenapi.zmxy.com.cn/openapi.do", getAppId(), getPrivateKey(), getZhimaPublicKey());
/*  53 */     AuthOpenIdResp resp = null;
/*     */     try {
/*  55 */       ZhimaAuthInfoAuthqueryResponse response = (ZhimaAuthInfoAuthqueryResponse)client.execute(req);
/*  56 */       if (!StringUtil.isBlank(response.getErrorMessage())) {
/*  57 */         throw new ServiceException(response.getErrorMessage());
/*     */       }
/*  60 */       resp = new AuthOpenIdResp(response);
/*     */     } catch (Exception e) {
/*  62 */       throw new ServiceException(e.getMessage(), e);
/*     */     }
/*  64 */     return resp;
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
/*     */   public String getAuthorizeUrl(String certNo, String name, String key)
/*     */   {
/*  77 */     String certType = "IDENTITY_CARD";
/*  78 */     String AuthCode = "M_APPPC_CERT";
/*  79 */     ZhimaAuthInfoAuthorizeRequest req = new ZhimaAuthInfoAuthorizeRequest();
/*  80 */     req.setIdentityType("2");
/*  81 */     req.setChannel("apppc");
/*  82 */     JSONObject bizParamsJson = new JSONObject(true);
/*  83 */     bizParamsJson.put("auth_code", "M_APPPC_CERT");
/*  84 */     bizParamsJson.put("state", key);
/*  85 */     req.setBizParams(bizParamsJson.toJSONString());
/*  86 */     JSONObject paramJson = new JSONObject(true);
/*  87 */     paramJson.put("certNo", certNo);
/*  88 */     paramJson.put("name", name);
/*  89 */     paramJson.put("certType", "IDENTITY_CARD");
/*  90 */     req.setIdentityParam(paramJson.toJSONString());
/*  91 */     DefaultZhimaClient client = new DefaultZhimaClient("https://zmopenapi.zmxy.com.cn/openapi.do", getAppId(), getPrivateKey(), getZhimaPublicKey());
/*  92 */     String url = null;
/*     */     try {
/*  94 */       url = client.generatePageRedirectInvokeUrl(req);
/*  95 */       logger.info(url);
/*     */     } catch (ZhimaApiException e) {
/*  97 */       logger.error(e.getMessage(), e);
/*     */     }
/*  99 */     return url;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneAuthorizeUrl(String certNo, String name, String key)
/*     */   {
/* 110 */     String certType = "IDENTITY_CARD";
/* 111 */     String AuthCode = "M_H5";
/* 112 */     ZhimaAuthInfoAuthorizeRequest req = new ZhimaAuthInfoAuthorizeRequest();
/* 113 */     req.setIdentityType("2");
/* 114 */     req.setChannel("app");
/* 115 */     req.setPlatform("zmop");
/* 116 */     JSONObject bizParamsJson = new JSONObject(true);
/* 117 */     bizParamsJson.put("auth_code", "M_H5");
/* 118 */     bizParamsJson.put("channelType", "app");
/* 119 */     bizParamsJson.put("state", key);
/* 120 */     req.setBizParams(bizParamsJson.toJSONString());
/* 121 */     JSONObject paramJson = new JSONObject(true);
/* 122 */     paramJson.put("certNo", certNo);
/* 123 */     paramJson.put("name", name);
/* 124 */     paramJson.put("certType", "IDENTITY_CARD");
/* 125 */     req.setIdentityParam(paramJson.toJSONString());
/* 126 */     DefaultZhimaClient client = new DefaultZhimaClient("https://zmopenapi.zmxy.com.cn/openapi.do", getAppId(), getPrivateKey(), getZhimaPublicKey());
/* 127 */     String url = null;
/*     */     try {
/* 129 */       url = client.generatePageRedirectInvokeUrl(req);
/* 130 */       logger.debug(url);
/*     */     } catch (ZhimaApiException e) {
/* 132 */       logger.error(e.getMessage(), e);
/*     */     }
/* 134 */     return url;
/*     */   }
/*     */   
/* 137 */   public String sign(String params, String sign) throws Exception { String params_ = "";
/* 138 */     String sign_ = "";
/* 139 */     if (params.indexOf("%") != -1) {
/* 140 */       params_ = URLDecoder.decode(params, "UTF-8");
/*     */     }
/*     */     
/* 143 */     if (sign.indexOf("%") != -1) {
/* 144 */       sign_ = URLDecoder.decode(sign, "UTF-8");
/*     */     }
/*     */     
/* 147 */     DefaultZhimaClient client = new DefaultZhimaClient("https://zmopenapi.zmxy.com.cn/openapi.do", getAppId(), getPrivateKey(), 
/* 148 */       getZhimaPublicKey());
/* 149 */     String result = null;
/*     */     try {
/* 151 */       result = client.decryptAndVerifySign(params_, sign_);
/* 152 */       logger.info(result);
/*     */     }
/*     */     catch (ZhimaApiException e) {
/* 155 */       logger.error(e.getMessage(), e);
/*     */     }
/* 157 */     return result;
/*     */   }
/*     */ }
