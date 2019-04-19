/*    */ package com.cashloan.cl.model.zmxy.base;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BaseQuery
/*    */ {
/*    */   protected static final String gatewayUrl = "https://zmopenapi.zmxy.com.cn/openapi.do";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private final String privateKey;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private final String zhimaPublicKey;
/*    */   
/*    */ 
/*    */ 
/*    */   private final String appId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public BaseQuery(String privateKey, String zhimaPublicKey, String appId)
/*    */   {
/* 30 */     this.privateKey = privateKey;
/* 31 */     this.zhimaPublicKey = zhimaPublicKey;
/* 32 */     this.appId = appId;
/*    */   }
/*    */   
/*    */   public BaseQuery(String privateKey) {
/* 36 */     this(privateKey, null, null);
/*    */   }
/*    */   
/*    */   public String getPrivateKey() {
/* 40 */     return this.privateKey;
/*    */   }
/*    */   
/*    */   public String getZhimaPublicKey() {
/* 44 */     return this.zhimaPublicKey;
/*    */   }
/*    */   
/*    */   public String getAppId() {
/* 48 */     return this.appId;
/*    */   }
/*    */ }
