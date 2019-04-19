/*    */ package com.cashloan.cl.model.hulu;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import credit.DsCreditRequest;
/*    */ import credit.Header;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.entity.ContentType;
/*    */ import org.apache.http.entity.StringEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HuLuMobileColletRequest
/*    */   extends DsCreditRequest
/*    */ {
/*    */   private String token;
/*    */   private String password;
/*    */   private String captcha;
/*    */   
/*    */   public HuLuMobileColletRequest(String host, Header header, String token, String password, String captcha)
/*    */   {
/* 24 */     super(host, header);
/* 25 */     this.token = token;
/* 26 */     this.password = password;
/* 27 */     this.captcha = captcha;
/*    */   }
/*    */   
/*    */   protected HttpEntity handle()
/*    */     throws Exception
/*    */   {
/* 33 */     Map paramMap = new HashMap();
/* 34 */     paramMap.put("token", this.token);
/* 35 */     if (StringUtils.isNotBlank(this.password)) {
/* 36 */       paramMap.put("password", this.password);
/*    */     }
/* 38 */     if (StringUtils.isNotBlank(this.captcha)) {
/* 39 */       paramMap.put("captcha", this.captcha);
/*    */     }
/* 41 */     String body = JSON.toJSONString(paramMap);
/* 42 */     ContentType jsonType = ContentType.create("application/json", "utf-8");
/* 43 */     return new StringEntity(body, jsonType);
/*    */   }
/*    */ }
