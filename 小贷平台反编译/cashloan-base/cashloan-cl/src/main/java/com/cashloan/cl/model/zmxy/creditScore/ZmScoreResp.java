/*    */ package com.cashloan.cl.model.zmxy.creditScore;
/*    */ 
/*    */ import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditScoreGetResponse;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZmScoreResp
/*    */   extends BaseResp
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String AUTHENTICATION_FAIL = "ZMCREDIT.authentication_fail";
/*    */   private String bizNo;
/*    */   private String zmScore;
/*    */   
/*    */   public String getBizNo()
/*    */   {
/* 30 */     return this.bizNo;
/*    */   }
/*    */   
/*    */   public String getZmScore() {
/* 34 */     return this.zmScore;
/*    */   }
/*    */   
/*    */   public ZmScoreResp(ZhimaCreditScoreGetResponse response) {
/* 38 */     super(response);
/* 39 */     this.bizNo = response.getBizNo();
/* 40 */     this.zmScore = response.getZmScore();
/*    */   }
/*    */ }
