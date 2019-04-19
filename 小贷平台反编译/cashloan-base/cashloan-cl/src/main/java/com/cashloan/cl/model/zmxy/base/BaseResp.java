/*    */ package com.cashloan.cl.model.zmxy.base;
/*    */ 
/*    */ import com.antgroup.zmxy.openplatform.api.ZhimaResponse;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BaseResp
/*    */   extends ZhimaResponse
/*    */ {
/*    */   private ZhimaResponse response;
/*    */   
/*    */   public BaseResp(ZhimaResponse response)
/*    */   {
/* 17 */     this.response = response;
/*    */   }
/*    */   
/*    */   public boolean isSuccess()
/*    */   {
/* 22 */     return this.response.isSuccess();
/*    */   }
/*    */   
/*    */   public String getErrorCode()
/*    */   {
/* 27 */     return this.response.getErrorCode();
/*    */   }
/*    */   
/*    */   public String getErrorMessage()
/*    */   {
/* 32 */     return this.response.getErrorMessage();
/*    */   }
/*    */   
/*    */   public String getBody()
/*    */   {
/* 37 */     return this.response.getBody();
/*    */   }
/*    */   
/*    */   public Map<String, String> getParams()
/*    */   {
/* 42 */     return this.response.getParams();
/*    */   }
/*    */ }
