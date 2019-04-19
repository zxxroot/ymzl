/*    */ package com.cashloan.cl.model.zmxy.antiFraud;
/*    */ 
/*    */

import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;
import com.antgroup.zmxy.openplatform.api.ZhimaApiException;
import com.antgroup.zmxy.openplatform.api.request.ZhimaCreditIvsDetailGetRequest;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditIvsDetailGetResponse;
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
/*    */ 
/*    */ 
/*    */ public class ZmAntiFraudQuery
/*    */   extends BaseQuery
/*    */ {
/* 23 */   public static final Logger logger = LoggerFactory.getLogger(ZmAntiFraudQuery.class);
/*    */   
/*    */   public ZmAntiFraudQuery(String privateKey, String zhimaPublicKey, String appId) {
/* 26 */     super(privateKey, zhimaPublicKey, appId);
/*    */   }
/*    */   
/*    */ 
/*    */   public ZmAntiFraudResp QueryAntiFraud(AntiFraudParam antiFraudParam, String transactionId)
/*    */   {
/* 32 */     ZhimaCreditIvsDetailGetRequest req = new ZhimaCreditIvsDetailGetRequest();
/* 33 */     req.setChannel("apppc");
/* 34 */     req.setPlatform("zmop");
/* 35 */     req.setProductCode("w1010100000000000103");
/* 36 */     req.setTransactionId(transactionId);
/*    */     
/* 38 */     req.setCertNo(antiFraudParam.getCertNo());
/* 39 */     req.setCertType("100");
/* 40 */     req.setName(antiFraudParam.getName());
/* 41 */     req.setMobile(antiFraudParam.getMobile());
/* 42 */     req.setEmail(antiFraudParam.getEmail());
/* 43 */     req.setBankCard(antiFraudParam.getBankCard());
/* 44 */     req.setAddress(antiFraudParam.getAddress());
/* 45 */     req.setIp(antiFraudParam.getIp());
/* 46 */     req.setMac(antiFraudParam.getMac());
/* 47 */     req.setWifimac(antiFraudParam.getWifimac());
/* 48 */     req.setImei(antiFraudParam.getImei());
/* 49 */     req.setImsi(antiFraudParam.getImsi());
/*    */     
/* 51 */     DefaultZhimaClient client = new DefaultZhimaClient("https://zmopenapi.zmxy.com.cn/openapi.do", getAppId(), getPrivateKey(), getZhimaPublicKey());
/* 52 */     ZmAntiFraudResp zmAntiFraudResp = null;
/*    */     try {
/* 54 */       ZhimaCreditIvsDetailGetResponse response = (ZhimaCreditIvsDetailGetResponse)client.execute(req);
/* 55 */       zmAntiFraudResp = new ZmAntiFraudResp(response);
/*    */     } catch (ZhimaApiException e) {
/* 57 */       logger.error(e.getMessage(), e);
/*    */     }
/* 59 */     return zmAntiFraudResp;
/*    */   }
/*    */ }
