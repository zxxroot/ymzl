/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou.newprotocol;
/*     */ 
/*     */

import com.cashloan.cl.model.pay.fuiou.newprotocol.BindModel;
import com.cashloan.cl.model.pay.fuiou.newprotocol.SmsModel;
import com.cashloan.cl.model.pay.fuiou.newprotocol.UnbindModel;
import com.cashloan.cl.model.pay.fuiou.utils.XmlMapUtils;
import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.util.MD5;
import com.rongdu.cashloan.core.common.context.Global;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
/*     */ 
/*     */ 
/*     */ public abstract class FuiouProtocolPayModel
/*     */ {
/*  35 */   private static Logger logger = LoggerFactory.getLogger(FuiouProtocolPayModel.class.getName());
/*     */   
/*     */ 
/*     */ 
/*  39 */   private static String version = "1.0";
/*     */   
/*     */ 
/*     */ 
/*  43 */   private static String mchntCd = Global.getValue("fuiou_mchnt");
/*     */   
/*     */ 
/*     */ 
/*  47 */   private static String mchntKey = Global.getValue("fuiou_xieyizhifu_seckey");
/*     */   
/*     */ 
/*     */ 
/*  51 */   private String userId = "3";
/*     */   
/*     */ 
/*     */ 
/*  55 */   private String protocolNo = "ML7IEM1000166687462OFB";
/*     */   
/*     */ 
/*     */ 
/*     */   private String sign;
/*     */   
/*     */ 
/*     */   private String url;
/*     */   
/*     */ 
/*     */   private List<NameValuePair> params;
/*     */   
/*     */ 
/*     */   private String[] signItems;
/*     */   
/*     */ 
/*     */   private static final String ENCODEING = "UTF-8";
/*     */   
/*     */ 
/*     */ 
/*     */   public String getVersion()
/*     */   {
/*  77 */     return version;
/*     */   }
/*     */   
/*  80 */   protected void setVersion(String version) { version = version; }
/*     */   
/*     */   public String getMchntCd() {
/*  83 */     return mchntCd;
/*     */   }
/*     */   
/*  86 */   protected void setMchntCd(String mchntCd) { mchntCd = mchntCd; }
/*     */   
/*     */   public String getUserId() {
/*  89 */     return this.userId;
/*     */   }
/*     */   
/*  92 */   public void setUserId(String userId) { this.userId = userId; }
/*     */   
/*     */   public String getProtocolNo() {
/*  95 */     return this.protocolNo;
/*     */   }
/*     */   
/*  98 */   public void setProtocolNo(String protocolNo) { this.protocolNo = protocolNo; }
/*     */   
/*     */   public String getSign() {
/* 101 */     return this.sign;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void setSignItems(String[] signItems)
/*     */   {
/* 107 */     StringBuffer sb = new StringBuffer();
/* 108 */     String[] arrayOfString; int j = (arrayOfString = signItems).length; for (int i = 0; i < j; i++) { String item = arrayOfString[i];
/* 109 */       sb.append(item).append("|");
/*     */     }
/* 111 */     sb.deleteCharAt(sb.length() - 1);
/* 112 */     this.sign = sb.toString();
/* 113 */     logger.info(this.sign);
/*     */     try {
/* 115 */       this.sign = encryptSign(this.sign);
/*     */     } catch (Exception e) {
/* 117 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/* 121 */   public String getMchntKey() { return mchntKey; }
/*     */   
/*     */ 
/* 124 */   public void setMchntKey(String mchntKey) { mchntKey = mchntKey; }
/*     */   
/*     */   public abstract String getUrl();
/*     */   
/* 128 */   public List<NameValuePair> getParams(final boolean isNeedMchntCd) { final FuiouProtocolPayModel obj = this;
/* 129 */     List<NameValuePair> params = new ArrayList();
/* 130 */     if (isNeedMchntCd) {
/* 131 */       params.add(new NameValuePair()
/*     */       {
/*     */         public String getValue() {
/* 134 */           return FuiouProtocolPayModel.mchntCd;
/*     */         }
/*     */         
/*     */         public String getName()
/*     */         {
/* 139 */           return "MCHNTCD";
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 146 */     params.add(new NameValuePair()
/*     */     {
/*     */       public String getValue() {
/* 149 */         String APIFMS = null;
/* 150 */         Map<String, Object> map = new HashMap();
/* 151 */         FuiouProtocolPayModel.this.fillParams(map);
/*     */         try
/*     */         {
/* 154 */           Document doc = null;
/* 155 */           if (map.containsKey("ORDER")) {
/* 156 */             map.remove("ORDER");
/* 157 */             doc = XmlMapUtils.map2xml(map, "ORDER");
/* 158 */           } else if (map.containsKey("FM")) {
/* 159 */             map.remove("FM");
/* 160 */             doc = XmlMapUtils.map2xml(map, "FM");
/*     */           } else {
/* 162 */             doc = XmlMapUtils.map2xml(map, "REQUEST");
/*     */           }
/* 164 */           APIFMS = XmlMapUtils.formatXml(doc);
/* 165 */           FuiouProtocolPayModel.logger.info(APIFMS);
/* 166 */           if (isNeedMchntCd) {
/* 167 */             APIFMS = DESCoderFUIOU.desEncrypt(APIFMS, DESCoderFUIOU.getKeyLength8(obj.getMchntKey()));
/*     */           }
/*     */         } catch (Exception e) {
/* 170 */           e.printStackTrace();
/*     */         }
/* 172 */         return APIFMS;
/*     */       }
/*     */       
/*     */       public String getName()
/*     */       {
/* 177 */         if (isNeedMchntCd) {
/* 178 */           return "APIFMS";
/*     */         }
/* 180 */         return "FM";
/*     */       }
/*     */       
/*     */ 
/* 184 */     });
/* 185 */     return params;
/*     */   }
/*     */   
/* 188 */   public void setParams(List<NameValuePair> params) { this.params = params; }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void fillParams(Map<String, Object> paramMap);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<String, Object> submit()
/*     */   {
/* 200 */     Map<String, Object> map = null;
/* 201 */     logger.debug("请求地址：" + getUrl());
/* 202 */     CloseableHttpClient httpclient = HttpClientBuilder.create().build();
/* 203 */     HttpPost httppost = new HttpPost(getUrl());
/*     */     try {
/* 205 */       boolean need = ((this instanceof SmsModel)) || ((this instanceof BindModel)) ||
/* 206 */         ((this instanceof UnbindModel)) || ((this instanceof RePayModel));
/* 207 */       List<NameValuePair> params = getParams(need);
/* 208 */       if (params != null) {
/* 209 */         httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
/*     */       }
/* 211 */       CloseableHttpResponse response = httpclient.execute(httppost);
/* 212 */       HttpEntity entity = response.getEntity();
/* 213 */       String jsonStr = EntityUtils.toString(entity, "utf-8");
/* 214 */       if (need) {
/* 215 */         jsonStr = DESCoderFUIOU.desDecrypt(jsonStr, DESCoderFUIOU.getKeyLength8(getMchntKey()));
/*     */       }
/* 217 */       logger.info(jsonStr);
/* 218 */       map = XmlMapUtils.xml2map(jsonStr, false);
/*     */     } catch (Exception e) {
/* 220 */       e.printStackTrace();
/*     */     }
/*     */     
/* 223 */     return map;
/*     */   }
/*     */   
/*     */   public static String encryptSign(String signStr) throws Exception {
/* 227 */     return MD5.MD5Encode(signStr);
/*     */   }
/*     */ }
