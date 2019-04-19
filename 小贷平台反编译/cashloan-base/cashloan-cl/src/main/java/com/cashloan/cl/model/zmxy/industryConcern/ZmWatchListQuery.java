/*    */ package com.cashloan.cl.model.zmxy.industryConcern;
/*    */ 
/*    */

import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;
import com.antgroup.zmxy.openplatform.api.ZhimaApiException;
import com.antgroup.zmxy.openplatform.api.request.ZhimaCreditWatchlistiiGetRequest;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditWatchlistiiGetResponse;
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
/*    */ public class ZmWatchListQuery
/*    */   extends BaseQuery
/*    */ {
/* 20 */   public static final Logger logger = LoggerFactory.getLogger(ZmWatchListQuery.class);
/*    */   
/* 22 */   public ZmWatchListQuery(String privateKey, String zhimaPublicKey, String appId) { super(privateKey, zhimaPublicKey, appId); }
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
/*    */   public ZmWatchListResp queryWatchList(String openId, String transactionId)
/*    */   {
/* 35 */     ZhimaCreditWatchlistiiGetRequest creditWatchlistGetRequest = new ZhimaCreditWatchlistiiGetRequest();
/* 36 */     creditWatchlistGetRequest.setPlatform("zmop");
/* 37 */     creditWatchlistGetRequest.setChannel("apppc");
/* 38 */     creditWatchlistGetRequest.setTransactionId(transactionId);
/* 39 */     creditWatchlistGetRequest.setProductCode("w1010100100000000022");
/* 40 */     creditWatchlistGetRequest.setOpenId(openId);
/* 41 */     DefaultZhimaClient client = new DefaultZhimaClient("https://zmopenapi.zmxy.com.cn/openapi.do", getAppId(), "UTF-8", getPrivateKey(), getZhimaPublicKey());
/* 42 */     ZmWatchListResp zmWatchListResp = null;
/*    */     try {
/* 44 */       ZhimaCreditWatchlistiiGetResponse response = (ZhimaCreditWatchlistiiGetResponse)client.execute(creditWatchlistGetRequest);
/* 46 */       zmWatchListResp = new ZmWatchListResp(response);
/*    */     } catch (ZhimaApiException e) {
/* 48 */       logger.error(e.getMessage(), e);
/*    */     }
/* 50 */     return zmWatchListResp;
/*    */   }
/*    */ }
