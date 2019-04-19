/*    */ package com.cashloan.cl.model.zmxy.creditScore;
/*    */ 
/*    */

import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;
import com.antgroup.zmxy.openplatform.api.ZhimaApiException;
import com.antgroup.zmxy.openplatform.api.request.ZhimaCreditScoreGetRequest;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditScoreGetResponse;
import com.cashloan.cl.model.zmxy.base.BaseQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
/*    */ public class ZmScoreQuery
/*    */   extends BaseQuery
/*    */ {
/* 21 */   public static final Logger logger = LoggerFactory.getLogger(ZmScoreQuery.class);
/*    */   
/* 23 */   public ZmScoreQuery(String privateKey, String zhimaPublicKey, String appId) { super(privateKey, zhimaPublicKey, appId); }
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
/*    */   public ZmScoreResp queryScore(String openId, String transactionId)
/*    */   {
/* 42 */     ZhimaCreditScoreGetRequest req = new ZhimaCreditScoreGetRequest();
/* 43 */     req.setProductCode("w1010100100000000001");
/* 44 */     req.setOpenId(openId);
/* 45 */     req.setTransactionId(transactionId);
/* 46 */     DefaultZhimaClient client = new DefaultZhimaClient("https://zmopenapi.zmxy.com.cn/openapi.do", getAppId(), getPrivateKey(), getZhimaPublicKey());
/* 47 */     ZmScoreResp zmScoreResp = null;
/*    */     try {
/* 49 */       ZhimaCreditScoreGetResponse response = (ZhimaCreditScoreGetResponse)client.execute(req);
/* 51 */       zmScoreResp = new ZmScoreResp(response);
/*    */     } catch (ZhimaApiException e) {
/* 53 */       logger.error(e.getMessage(), e);
/*    */     }
/* 55 */     return zmScoreResp;
/*    */   }
/*    */ }
