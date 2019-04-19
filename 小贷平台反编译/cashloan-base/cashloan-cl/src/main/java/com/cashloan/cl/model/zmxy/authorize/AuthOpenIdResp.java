/*    */ package com.cashloan.cl.model.zmxy.authorize;
/*    */ 
/*    */ import com.antgroup.zmxy.openplatform.api.response.ZhimaAuthInfoAuthqueryResponse;
/*    */ import com.cashloan.cl.model.zmxy.base.BaseResp;
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
/*    */ 
/*    */ 
/*    */ public class AuthOpenIdResp
/*    */   extends BaseResp
/*    */ {
/*    */   private boolean authorized;
/*    */   private String openId;
/*    */   
/*    */   public AuthOpenIdResp(ZhimaAuthInfoAuthqueryResponse response)
/*    */   {
/* 25 */     super(response);
/* 26 */     this.authorized = response.getAuthorized().booleanValue();
/* 27 */     this.openId = response.getOpenId();
/*    */   }
/*    */   
/*    */   public boolean isAuthorized() {
/* 31 */     return this.authorized;
/*    */   }
/*    */   
/*    */   public String getOpenId() {
/* 35 */     return this.openId;
/*    */   }
/*    */ }
