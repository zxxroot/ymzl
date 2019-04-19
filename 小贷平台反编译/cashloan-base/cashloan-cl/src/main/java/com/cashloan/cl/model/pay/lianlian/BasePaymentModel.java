/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.model.pay.lianlian.util.SignUtil;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.util.ReflectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tool.util.StringUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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
/*     */ public class BasePaymentModel
/*     */ {
/*  33 */   private static final Logger logger = LoggerFactory.getLogger(BasePaymentModel.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private double amount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String service;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String orderNo;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String oid_partner;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String no_order;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String sign_type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String sign;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String platform;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String notify_url;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String ret_code;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String ret_msg;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String subUrl;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String[] signParamNames()
/*     */   {
/* 101 */     return new String[0];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String[] reqParamNames()
/*     */   {
/* 108 */     return new String[0];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String[] respParamNames()
/*     */   {
/* 116 */     return new String[0];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String[] respVerifyParamNames()
/*     */   {
/* 124 */     return new String[0];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BasePaymentModel()
/*     */   {
/* 133 */     setOid_partner(Global.getValue("lianlian_business_no"));
/* 134 */     setSign_type("RSA");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void sign()
/*     */   {
/* 144 */     Map<String, Object> map = paramToMap(signParamNames());
/* 145 */     setSign(SignUtil.genRSASign(JSON.toJSONString(map)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean checkReturn()
/*     */   {
/* 154 */     if ((StringUtil.isNotBlank(getRet_code())) && ("0000".equals(getRet_code()))) {
/* 155 */       return true;
/*     */     }
/* 157 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean verfiySign(BasePaymentModel model)
/*     */   {
/* 166 */     Map<String, Object> map = paramToMap(respParamNames());
/* 167 */     String verifyJsonStr = SignUtil.genSignData(JSON.toJSONString(map));
/* 168 */     logger.debug("验签明文：" + verifyJsonStr);
/* 169 */     return SignUtil.checksign(Global.getValue("lianlian_public_key"), verifyJsonStr, 
/* 170 */       model.getSign());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean checkSign(BasePaymentModel model)
/*     */   {
/* 179 */     Map<String, Object> map = paramToMap(respVerifyParamNames());
/* 180 */     String verifyJsonStr = SignUtil.genSignData(JSON.toJSONString(map));
/* 181 */     logger.debug("验签明文：" + verifyJsonStr);
/* 182 */     return SignUtil.checksign(Global.getValue("lianlian_public_key"), verifyJsonStr, 
/* 183 */       model.getSign());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void response(String respMsg)
/*     */     throws UnsupportedEncodingException, IOException
/*     */   {
/* 196 */     JSONObject resultArray = JSON.parseObject(respMsg);
/* 197 */     StringBuilder verifyStr = new StringBuilder(50);
/* 198 */     Map<String, Field> fs = ReflectUtil.getClassField(getClass());
/* 199 */     String[] arrayOfString; int j = (arrayOfString = respParamNames()).length; for (int i = 0; i < j; i++) { String name = arrayOfString[i];
/* 200 */       String value = resultArray.getString(name);
/* 201 */       verifyStr.append(name + " : " + value + ",");
/* 202 */       if (!StringUtil.isBlank(value))
/*     */       {
/*     */ 
/* 205 */         Field f = (Field)fs.get(StringUtil.firstCharLowerCase(name));
/* 206 */         ReflectUtil.invokeSetMethod(f.getDeclaringClass(), this, f.getName(), f.getType(), value);
/*     */       } }
/* 208 */     logger.info("响应参数： " + verifyStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<String, Object> paramToMap(String[] params)
/*     */   {
/* 218 */     Map<String, Object> map = new HashMap();
/* 219 */     String[] arrayOfString; int j = (arrayOfString = params).length; for (int i = 0; i < j; i++) { String name = arrayOfString[i];
/* 220 */       Object result = ReflectUtil.invokeGetMethod(getClass(), this, name);
/* 221 */       if (result != null)
/*     */       {
/*     */ 
/* 224 */         map.put(name, result); }
/*     */     }
/* 226 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getAmount()
/*     */   {
/* 235 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmount(double amount)
/*     */   {
/* 244 */     this.amount = amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getService()
/*     */   {
/* 253 */     return this.service;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setService(String service)
/*     */   {
/* 262 */     this.service = service;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 271 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 280 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOid_partner()
/*     */   {
/* 289 */     return this.oid_partner;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOid_partner(String oid_partner)
/*     */   {
/* 298 */     this.oid_partner = oid_partner;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNo_order()
/*     */   {
/* 307 */     return this.no_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNo_order(String no_order)
/*     */   {
/* 316 */     this.no_order = no_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSign_type()
/*     */   {
/* 325 */     return this.sign_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSign_type(String sign_type)
/*     */   {
/* 334 */     this.sign_type = sign_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSign()
/*     */   {
/* 343 */     return this.sign;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSign(String sign)
/*     */   {
/* 352 */     this.sign = sign;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPlatform()
/*     */   {
/* 361 */     return this.platform;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPlatform(String platform)
/*     */   {
/* 370 */     this.platform = platform;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNotify_url()
/*     */   {
/* 379 */     return this.notify_url;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNotify_url(String notify_url)
/*     */   {
/* 388 */     this.notify_url = notify_url;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRet_code()
/*     */   {
/* 397 */     return this.ret_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRet_code(String ret_code)
/*     */   {
/* 406 */     this.ret_code = ret_code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRet_msg()
/*     */   {
/* 415 */     return this.ret_msg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRet_msg(String ret_msg)
/*     */   {
/* 424 */     this.ret_msg = ret_msg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSubUrl()
/*     */   {
/* 433 */     return this.subUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSubUrl(String subUrl)
/*     */   {
/* 442 */     this.subUrl = subUrl;
/*     */   }
/*     */ }
