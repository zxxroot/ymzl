/*    */ package com.cashloan.cl.model.zmxy.antiFraud;
/*    */ 
/*    */

import com.antgroup.zmxy.openplatform.api.domain.IvsDetail;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditIvsDetailGetResponse;
import com.cashloan.cl.model.zmxy.base.BaseResp;

import java.util.List;

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
/*    */ 
/*    */ 
/*    */ public class ZmAntiFraudResp
/*    */   extends BaseResp
/*    */ {
/*    */   private Long ivsScore;
/*    */   private List<IvsDetail> ivsDetails;
/*    */   private String bizNo;
/*    */   
/*    */   public Long getIvsScore()
/*    */   {
/* 31 */     return this.ivsScore;
/*    */   }
/*    */   
/*    */   public List<IvsDetail> getIvsDetails() {
/* 35 */     return this.ivsDetails;
/*    */   }
/*    */   
/*    */   public String getBizNo()
/*    */   {
/* 40 */     return this.bizNo;
/*    */   }
/*    */   
/*    */   public ZmAntiFraudResp(ZhimaCreditIvsDetailGetResponse response)
/*    */   {
/* 45 */     super(response);
/* 46 */     this.bizNo = response.getBizNo();
/* 47 */     this.ivsScore = response.getIvsScore();
/* 48 */     this.ivsDetails = response.getIvsDetail();
/*    */   }
/*    */ }
