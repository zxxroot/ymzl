/*     */ package com.cashloan.cl.model.pay.lianlian.util;
/*     */ 
/*     */

import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.model.pay.lianlian.*;
import com.cashloan.cl.domain.PayReqLog;
import com.cashloan.cl.service.PayReqLogService;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.util.HttpsUtil;
import com.rongdu.cashloan.core.common.util.ReflectUtil;
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
import java.io.UnsupportedEncodingException;
import java.util.Map;
/*     */ public class LianLianHelper
/*     */ {
/*  50 */   public static final Logger logger = LoggerFactory.getLogger(LianLianHelper.class);
/*     */   
/*     */   private BasePaymentModel doSubmit(BasePaymentModel model)
/*     */   {
/*  54 */     saveReqLog(model);
/*     */     
/*  56 */     Map<String, String> map = ReflectUtil.fieldValueToMap(model, model.reqParamNames());
/*     */     
/*  58 */     String jsonStr = JSONObject.toJSONString(map);
/*  59 */     String resp = null;
/*     */     try
/*     */     {
/*  62 */       String lianlianSwitch = Global.getValue("lianlian_switch");
/*     */       
/*  64 */       if ((StringUtil.isNotBlank(lianlianSwitch)) && ("1".equals(lianlianSwitch))) {
/*  65 */         logger.debug("请求地址：" + model.getSubUrl());
/*  66 */         resp = HttpsUtil.postStrClient(model.getSubUrl(), jsonStr);
/*     */       } else {
/*  68 */         logger.debug("关闭连连支付,模拟返回结果");
/*  69 */         resp = "{\"ret_code\":\"0000\",\"ret_msg\":\"模拟交易成功\"}";
/*     */       }
/*     */       
/*  72 */       model.response(resp);
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/*  75 */       logger.error(e.getMessage(), e);
/*     */     } catch (IOException e) {
/*  77 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */     
/*     */ 
/*  81 */     modifyReqLog(model, resp);
/*  82 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel payment(PaymentModel model)
/*     */   {
/*  92 */     model.sign();
/*  93 */     doSubmit(model);
/*  94 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
/*     */   public BasePaymentModel confirmPayment(BasePaymentModel model)
/*     */   {
/* 104 */     model.sign();
/* 106 */     return doSubmit(model);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel queryPayment(QueryPaymentModel model)
/*     */   {
/* 116 */     model.sign();
/* 117 */     doSubmit(model);
/* 118 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel authApply(AuthApplyModel model)
/*     */   {
/* 130 */     model.sign();
/* 131 */     doSubmit(model);
/* 132 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel queryAuthSign(QueryAuthSignModel model)
/*     */   {
/* 141 */     model.sign();
/* 142 */     doSubmit(model);
/* 143 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel cancelAuthSign(CancelAuthSignModel model)
/*     */   {
/* 152 */     model.sign();
/* 153 */     doSubmit(model);
/* 154 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel repaymentPlanChange(BasePaymentModel model)
/*     */   {
/* 165 */     model.sign();
/* 166 */     doSubmit(model);
/* 167 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel repayment(RepaymentModel model)
/*     */   {
/* 177 */     model.sign();
/* 178 */     doSubmit(model);
/* 179 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel queryRepayment(QueryRepaymentModel model)
/*     */   {
/* 189 */     model.sign();
/* 190 */     doSubmit(model);
/* 191 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void saveReqLog(BasePaymentModel model)
/*     */   {
/* 200 */     PayReqLogService payReqLogService = (PayReqLogService)BeanUtil.getBean("payReqLogService");
/* 201 */     PayReqLog payReqLog = new PayReqLog();
/* 202 */     payReqLog.setOrderNo(model.getOrderNo());
/* 203 */     payReqLog.setService(model.getService());
/* 204 */     payReqLog.setCreateTime(DateUtil.getNow());
/* 205 */     payReqLog.setParams(ReflectUtil.fieldValueToJson(model, model.signParamNames()));
/* 206 */     payReqLog.setReqDetailParams(ReflectUtil.fieldValueToJson(model, model.reqParamNames()));
/*     */     
/* 208 */     if ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes() != null) {
/* 209 */       HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
/* 210 */       String ip = IPUtil.getRemortIP(request);
/* 211 */       payReqLog.setIp(ip);
/*     */     }
/* 213 */     payReqLogService.save(payReqLog);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void modifyReqLog(BasePaymentModel model, String resp)
/*     */   {
/* 223 */     PayReqLogService payReqLogService = (PayReqLogService)BeanUtil.getBean("payReqLogService");
/* 224 */     PayReqLog reqLog = payReqLogService.findByOrderNo(model.getOrderNo());
/* 225 */     if (reqLog == null) {
/* 226 */       return;
/*     */     }
/* 228 */     reqLog.setReturnParams(resp);
/* 229 */     reqLog.setReturnTime(DateUtil.getNow());
/* 230 */     payReqLogService.updateById(reqLog);
/*     */   }
/*     */ }