/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou.utils;
/*     */ 
/*     */

import com.alibaba.fastjson.JSON;
import com.cashloan.cl.domain.PayReqLog;
import com.cashloan.cl.model.pay.fuiou.FuiouPaymentModel;
import com.cashloan.cl.service.PayReqLogService;
import com.fuiou.mpay.encrypt.RSAUtils;
import com.fuiou.util.MD5;
import com.rongdu.cashloan.cl.model.pay.fuiou.*;
import com.rongdu.cashloan.core.common.context.Global;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tool.util.BeanUtil;
import tool.util.DateUtil;
import tool.util.IPUtil;
import tool.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FuiouHelper
/*     */ {
/*  45 */   public static final Logger logger = LoggerFactory.getLogger(FuiouHelper.class);
/*     */   private static final String ENCODEING = "UTF-8";
/*     */   
/*     */   public String doSubmit(FuiouPaymentModel model)
/*     */     throws ClientProtocolException, IOException
/*     */   {
/*  51 */     saveReqLog(model);
/*     */     
/*  53 */     String pay_switch = Global.getValue("fuiou_switch");
/*  54 */     String resp = null;
/*  55 */     String jsonStr = null;
/*  56 */     if ((StringUtil.isNotBlank(pay_switch)) && ("1".equals(pay_switch))) {
/*  57 */       logger.debug("请求地址：" + model.getUrl());
/*  58 */       CloseableHttpClient httpclient = HttpClientBuilder.create().build();
/*  59 */       HttpPost httppost = new HttpPost(model.getUrl());
/*  60 */       if (model.getParams() != null) {
/*  61 */         httppost.setEntity(new UrlEncodedFormEntity(model.getParams(), "UTF-8"));
/*     */       }
/*  63 */       CloseableHttpResponse response = httpclient.execute(httppost);
/*  64 */       HttpEntity entity = response.getEntity();
/*  65 */       jsonStr = EntityUtils.toString(entity, "utf-8");
/*  66 */       logger.info(jsonStr);
/*     */     } else {
/*  68 */       logger.debug("关闭富友支付,模拟返回结果");
/*  69 */       resp = "{\"ret_code\":\"0000\",\"ret_msg\":\"模拟交易成功\"}";
/*     */     }
/*     */     
/*  72 */     modifyReqLog(model, resp);
/*  73 */     return jsonStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void signPayment(FuiouSignModel model)
/*     */   {
/*  83 */     model.signature();
/*  84 */     model.setService("signPayment");
/*     */     
/*  86 */     saveReqLog(model);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String qrytrans(QrytransModel model)
/*     */   {
/*     */     try
/*     */     {
/*  97 */       model.signature();
/*  98 */       model.setService("qrytrans");
/*  99 */       return doSubmit(model);
/*     */     } catch (ClientProtocolException e) {
/* 101 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 103 */       e.printStackTrace();
/*     */     }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String payforreq(PayforreqModel model)
/*     */   {
/*     */     try
/*     */     {
/* 116 */       model.signature();
/* 117 */       model.setService("payforreq");
/* 118 */       return doSubmit(model);
/*     */     } catch (ClientProtocolException e) {
/* 120 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 122 */       e.printStackTrace();
/*     */     }
/* 124 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String incomeforreq(IncomeforreqModel model)
/*     */   {
/*     */     try
/*     */     {
/* 135 */       model.signature();
/* 136 */       model.setService("incomeforreq");
/* 137 */       return doSubmit(model);
/*     */     } catch (ClientProtocolException e) {
/* 139 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 141 */       e.printStackTrace();
/*     */     }
/* 143 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String protocelAutoPay(FuiouProtocolAutoPayModel model)
/*     */   {
/*     */     try
/*     */     {
/* 154 */       model.signature();
/* 155 */       model.setService("protocolAutoPay");
/* 156 */       return doSubmit(model);
/*     */     } catch (ClientProtocolException e) {
/* 158 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 160 */       e.printStackTrace();
/*     */     }
/* 162 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void saveReqLog(FuiouPaymentModel model)
/*     */   {
/* 171 */     PayReqLogService payReqLogService = (PayReqLogService)BeanUtil.getBean("payReqLogService");
/* 172 */     PayReqLog payReqLog = new PayReqLog();
/* 173 */     payReqLog.setOrderNo(model.getOrderNo());
/* 174 */     payReqLog.setService(model.getService());
/* 175 */     payReqLog.setCreateTime(DateUtil.getNow());
/* 176 */     payReqLog.setParams(JSON.toJSONString(model));
/* 177 */     if ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes() != null) {
/* 178 */       HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
/* 179 */         .getRequest();
/* 180 */       String ip = IPUtil.getRemortIP(request);
/* 181 */       payReqLog.setIp(ip);
/*     */     }
/* 183 */     payReqLogService.save(payReqLog);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void modifyReqLog(FuiouPaymentModel model, String resp)
/*     */   {
/* 193 */     PayReqLogService payReqLogService = (PayReqLogService)BeanUtil.getBean("payReqLogService");
/* 194 */     PayReqLog reqLog = payReqLogService.findByOrderNo(model.getOrderNo());
/* 195 */     if (reqLog == null) {
/* 196 */       return;
/*     */     }
/* 198 */     reqLog.setReturnParams(resp);
/* 199 */     reqLog.setReturnTime(DateUtil.getNow());
/* 200 */     payReqLogService.updateById(reqLog);
/*     */   }
/*     */   
/*     */   public static String getSign(String signStr, String signtp, String key) throws Exception {
/* 204 */     String sign = "";
/* 205 */     if ("md5".equalsIgnoreCase(signtp)) {
/* 206 */       sign = MD5.MD5Encode(signStr);
/*     */     } else {
/* 208 */       sign = RSAUtils.sign(signStr.getBytes("utf-8"), key);
/*     */     }
/* 210 */     return sign;
/*     */   }
/*     */ }