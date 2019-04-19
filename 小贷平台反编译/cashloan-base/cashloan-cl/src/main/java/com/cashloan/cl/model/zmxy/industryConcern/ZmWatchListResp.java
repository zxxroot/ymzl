/*    */ package com.cashloan.cl.model.zmxy.industryConcern;
/*    */ 
/*    */ import com.antgroup.zmxy.openplatform.api.domain.ZmWatchListDetail;
/*    */ import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditWatchlistiiGetResponse;
/*    */ import com.cashloan.cl.model.zmxy.base.BaseResp;
/*    */ import com.cashloan.cl.model.zmxy.base.ZmConstant;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class ZmWatchListResp
/*    */   extends BaseResp
/*    */ {
/*    */   private boolean isMatched;
/*    */   private String bizNo;
/*    */   private List<RiskDetail> riskDetails;
/*    */   
/*    */   public boolean isMatched()
/*    */   {
/* 33 */     return this.isMatched;
/*    */   }
/*    */   
/*    */   public String getBizNo() {
/* 37 */     return this.bizNo;
/*    */   }
/*    */   
/*    */   public List<RiskDetail> getRiskDetails() {
/* 41 */     return this.riskDetails;
/*    */   }
/*    */   
/*    */   public ZmWatchListResp(ZhimaCreditWatchlistiiGetResponse response)
/*    */   {
/* 46 */     super(response);
/* 47 */     this.isMatched = (response.getIsMatched() == null ? false : response.getIsMatched().booleanValue());
/* 48 */     this.bizNo = response.getBizNo();
/* 49 */     handelDetailList(response.getDetails());
/*    */   }
/*    */   
/*    */   private void handelDetailList(List<ZmWatchListDetail> details)
/*    */   {
/* 54 */     if ((details != null) && (details.size() > 0)) {
/* 55 */       this.riskDetails = new ArrayList(details.size());
/* 56 */       for (ZmWatchListDetail detail : details) {
/* 57 */         RiskDetail riskDetail = new RiskDetail();
/* 58 */         riskDetail.setBizCode(detail.getBizCode());
/* 59 */         riskDetail.setCode(detail.getCode());
/* 60 */         riskDetail.setSettlement(detail.getSettlement().booleanValue());
/* 61 */         riskDetail.setStatus(detail.getStatus());
/* 62 */         riskDetail.setType(detail.getType());
/* 63 */         riskDetail.setBizMsg(ZmConstant.getRiskMessage(detail.getBizCode()));
/* 64 */         riskDetail.setCodeMsg(ZmConstant.getRiskMessage(detail.getCode()));
/* 65 */         riskDetail.setTypeMsg(ZmConstant.getRiskMessage(detail.getType()));
/* 66 */         riskDetail.setExtendInfos(detail.getExtendInfo());
/* 67 */         this.riskDetails.add(riskDetail);
/*    */       }
/*    */     }
/*    */   }
/*    */ }
