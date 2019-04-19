/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.cashloan.cl.domain.YoudunDevicesList;
/*     */ import com.cashloan.cl.domain.YoudunGraphDetail;
/*     */ import com.cashloan.cl.domain.YoudunIdDetail;
/*     */ import com.cashloan.cl.domain.YoudunLoanDetail;
/*     */ import com.cashloan.cl.domain.YoudunLoanIndustry;
/*     */ import com.cashloan.cl.domain.YoudunScoreDetail;
/*     */ import com.cashloan.cl.domain.YoudunUserFeatures;
/*     */ import com.cashloan.cl.mapper.OperatorTdBillsMapper;
/*     */ import com.cashloan.cl.mapper.YoudunDevicesListMapper;
/*     */ import com.cashloan.cl.mapper.YoudunGraphDetailMapper;
/*     */ import com.cashloan.cl.mapper.YoudunIdDetailMapper;
/*     */ import com.cashloan.cl.mapper.YoudunLoanDetailMapper;
/*     */ import com.cashloan.cl.mapper.YoudunScoreDetailMapper;
/*     */ import com.cashloan.cl.mapper.YoudunUserFeaturesMapper;
/*     */ import com.cashloan.cl.service.YoudunUserFeaturesService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.OrderNoUtil;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.commons.httpclient.util.URIUtil;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.methods.HttpPost;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClientBuilder;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.StringUtil;
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
/*     */ @Service("youdunUserFeaturesService")
/*     */ public class YoudunUserFeaturesServiceImpl
/*     */   extends BaseServiceImpl<YoudunUserFeatures, Long>
/*     */   implements YoudunUserFeaturesService
/*     */ {
/*     */   @Resource
/*     */   private YoudunUserFeaturesMapper youdunUserFeaturesMapper;
/*     */   @Resource
/*     */   private OperatorTdBillsMapper operatorTdBillsMapper;
/*     */   @Resource
/*     */   private YoudunIdDetailMapper youdunIdDetailMapper;
/*     */   @Resource
/*     */   private YoudunGraphDetailMapper youdunGraphDetailMapper;
/*     */   @Resource
/*     */   private YoudunScoreDetailMapper youdunScoreDetailMapper;
/*     */   @Resource
/*     */   private YoudunDevicesListMapper youdunDevicesListMapper;
/*     */   @Resource
/*     */   private YoudunLoanDetailMapper youdunLoanDetailMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   
/*     */   public BaseMapper<YoudunUserFeatures, Long> getMapper()
/*     */   {
/* 122 */     return this.youdunUserFeaturesMapper;
/*     */   }
/*     */   
/* 125 */   private static String fformatStr = "/dsp-front/4.1/dsp-front/default/pubkey/%s/product_code/%s/out_order_id/%s/signature/%s";
/*     */   
/*     */   public Map<String, Object> udcredit(Long userId) throws Exception
/*     */   {
/* 129 */     Map<String, Object> map = new HashMap();
/*     */     
/* 131 */     List<YoudunIdDetail> youdunIdDetail = this.youdunIdDetailMapper.findByUserId(userId);
/* 132 */     if (youdunIdDetail.size() == 0)
/*     */     {
/* 134 */       String url = "https://api4.udcredit.com";
/* 135 */       String apikey = Global.getValue("ocr_udcredit_pubkey");
/* 136 */       String secretkey = Global.getValue("ocr_udcredit_secretkey");
/* 137 */       Map<String, String> body = new HashMap();
/* 138 */       map.put("userId", userId);
/* 139 */       UserBaseInfo userBaseInfo = (UserBaseInfo)this.userBaseInfoMapper.findSelective(map);
/* 140 */       if ((userBaseInfo == null) || (userBaseInfo.getIdNo() == null)) {
/* 141 */         map.put("msg", "用户不存在");
/* 142 */         return map;
/*     */       }
/* 144 */       body.put("id_no", userBaseInfo.getIdNo());
/* 145 */       StringBuffer bodySb = new StringBuffer("{");
/* 146 */       for (Map.Entry<String, String> entry : body.entrySet()) {
/* 147 */         bodySb.append("'").append((String)entry.getKey()).append("':'").append((String)entry.getValue()).append("',");
/*     */       }
/* 149 */       String bodyStr = bodySb.substring(0, bodySb.length() - 1) + "}";
/* 150 */       String signature = md5(bodyStr + "|" + secretkey);
/* 151 */       url = url + String.format(fformatStr, new Object[] { apikey, "Y1001005", System.currentTimeMillis() + " ", signature });
/* 152 */       System.out.println("requestUrl=>" + url);
/* 153 */       System.out.println("request parameter body=>" + body);
/* 154 */       HttpResponse r = makePostRequest(url, bodyStr);
/* 155 */       String res = EntityUtils.toString(r.getEntity());
/* 156 */       if (StringUtil.isNotBlank(res)) {
/* 157 */         res = change(res);
/*     */       }
/*     */       
/* 160 */       String orderNo = OrderNoUtil.getSerialNumber();
/* 161 */       String bodys = JsonUtil.toString(JSONObject.parseObject(res).get("body"));
/* 162 */       if ((bodys == null) || (bodys.equals("null"))) {
/* 163 */         map.put("msg", "用户无数据");
/* 164 */         return map;
/*     */       }
/*     */       
/* 167 */       saveYoudunDetail(bodys, orderNo, userId);
/*     */     }
/* 169 */     map.clear();
/* 170 */     map.put("youdunIdDetail", youdunIdDetail);
/* 171 */     List<YoudunUserFeatures> userFeatures = this.youdunUserFeaturesMapper.findByUserId(userId);
/* 172 */     map.put("userFeatures", userFeatures);
/* 173 */     List<YoudunGraphDetail> youdunGraphDetail = this.youdunGraphDetailMapper.findByUserId(userId);
/* 174 */     map.put("youdunGraphDetail", youdunGraphDetail);
/* 175 */     List<YoudunScoreDetail> youdunScoreDetail = this.youdunScoreDetailMapper.findByUserId(userId);
/* 176 */     map.put("youdunScoreDetail", youdunScoreDetail);
/* 177 */     List<YoudunDevicesList> youdunDevicesList = this.youdunDevicesListMapper.findByUserId(userId);
/* 178 */     map.put("youdunDevicesList", youdunDevicesList);
/* 179 */     List<YoudunLoanDetail> youdunLoanDetail = this.youdunLoanDetailMapper.findByUserId(userId);
/* 180 */     map.put("youdunLoanDetail", youdunLoanDetail);
/* 181 */     List<YoudunLoanIndustry> loanIndustry = JSONObject.parseArray(((YoudunLoanDetail)youdunLoanDetail.get(0)).getLoanIndustry(), YoudunLoanIndustry.class);
/* 182 */     map.put("loanIndustry", loanIndustry);
/*     */     
/* 184 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void saveYoudunDetail(String bodys, String orderNo, Long userId)
/*     */   {
/* 194 */     List<YoudunUserFeatures> youdunUserFeatures = JSONObject.parseArray(JSONObject.parseObject(bodys).get("userFeatures"), YoudunUserFeatures.class);
/* 195 */     for (YoudunUserFeatures features : youdunUserFeatures) {
/* 196 */       if (features != null) {
/* 197 */         features.setUserId(userId);
/* 198 */         features.setOrderNo(orderNo);
/* 199 */         this.youdunUserFeaturesMapper.save(features);
/*     */       }
/*     */     }
/*     */     
/* 203 */     List<YoudunIdDetail> youdunIdDetail = JSONObject.parseArray("[" + JSONObject.parseObject(bodys).get("idDetail") + "]", YoudunIdDetail.class);
/* 204 */     for (YoudunIdDetail Detail : youdunIdDetail) {
/* 205 */       if (Detail != null) {
/* 206 */         Detail.setUserId(userId);
/* 207 */         Detail.setOrderNo(orderNo);
/* 208 */         this.youdunIdDetailMapper.save(Detail);
/*     */       }
/*     */     }
/*     */     
/* 212 */     Object youdunGraphDetail = JSONObject.parseArray("[" + JSONObject.parseObject(bodys).get("graphDetail") + "]", YoudunGraphDetail.class);
/* 213 */     for (YoudunGraphDetail graphDetail : (List)youdunGraphDetail) {
/* 214 */       if (graphDetail != null) {
/* 215 */         graphDetail.setUserId(userId);
/* 216 */         graphDetail.setOrderNo(orderNo);
/* 217 */         this.youdunGraphDetailMapper.save(graphDetail);
/*     */       }
/*     */     }
/*     */     
/* 221 */     Object youdunScoreDetail = JSONObject.parseArray("[" + JSONObject.parseObject(bodys).get("scoreDetail") + "]", YoudunScoreDetail.class);
/* 222 */     for (YoudunScoreDetail scoreDetail : (List)youdunScoreDetail) {
/* 223 */       if (scoreDetail != null) {
/* 224 */         scoreDetail.setUserId(userId);
/* 225 */         scoreDetail.setOrderNo(orderNo);
/* 226 */         this.youdunScoreDetailMapper.save(scoreDetail);
/*     */       }
/*     */     }
/*     */     
/* 230 */     Object youdunDevicesList = JSONObject.parseArray(JSONObject.parseObject(bodys).get("devicesList"), YoudunDevicesList.class);
/* 231 */     for (YoudunDevicesList list : (List)youdunDevicesList) {
/* 232 */       if (list != null) {
/* 233 */         list.setUserId(userId);
/* 234 */         list.setOrderNo(orderNo);
/* 235 */         this.youdunDevicesListMapper.save(list);
/*     */       }
/*     */     }
/*     */     
/* 239 */     Object params = (Map)JSONObject.parseObject(JsonUtil.toString(JSONObject.parseObject(bodys).get("loanDetail")), Map.class);
/* 240 */     if (params != null) {
/* 241 */       YoudunLoanDetail loanDetail = new YoudunLoanDetail();
/* 242 */       loanDetail.setUserId(userId);
/* 243 */       loanDetail.setOrderNo(orderNo);
/* 244 */       loanDetail.setActualLoanPlatformCount1m(((Map)params).get("actualLoanPlatformCount\021m").toString());
/* 245 */       loanDetail.setActualLoanPlatformCount3m(((Map)params).get("actualLoanPlatformCount\023m").toString());
/* 246 */       loanDetail.setActualLoanPlatformCount6m(((Map)params).get("actualLoanPlatformCount\026m").toString());
/* 247 */       loanDetail.setActualLoanPlatformCount(((Map)params).get("actualLoanPlatformCount").toString());
/* 248 */       loanDetail.setLoanPlatformCount(((Map)params).get("loanPlatformCount").toString());
/* 249 */       loanDetail.setLoanPlatformCount1m(((Map)params).get("loanPlatformCount\021m").toString());
/* 250 */       loanDetail.setLoanPlatformCount3m(((Map)params).get("loanPlatformCount\023m").toString());
/* 251 */       loanDetail.setLoanPlatformCount6m(((Map)params).get("loanPlatformCount\026m").toString());
/* 252 */       loanDetail.setRepaymentTimesCount(((Map)params).get("repaymentTimesCount").toString());
/* 253 */       loanDetail.setRepaymentPlatformCount(((Map)params).get("repaymentPlatformCount").toString());
/* 254 */       loanDetail.setRepaymentPlatformCount1m(((Map)params).get("repaymentPlatformCount\021m").toString());
/* 255 */       loanDetail.setRepaymentPlatformCount3m(((Map)params).get("repaymentPlatformCount\023m").toString());
/* 256 */       loanDetail.setRepaymentPlatformCount6m(((Map)params).get("repaymentPlatformCount\026m").toString());
/* 257 */       loanDetail.setLoanIndustry(((Map)params).get("loanIndustry").toString());
/* 258 */       this.youdunLoanDetailMapper.save(loanDetail);
/*     */     }
/*     */   }
/*     */   
/*     */   public String change(String name)
/*     */   {
/* 264 */     StringBuffer sb = new StringBuffer();
/* 265 */     sb.append(name);
/* 266 */     int count = sb.indexOf("_");
/* 267 */     while (count != 0) {
/* 268 */       int num = sb.indexOf("_", count);
/* 269 */       count = num + 1;
/* 270 */       if (num != -1) {
/* 271 */         char ss = sb.charAt(count);
/* 272 */         char ia = (char)(ss - ' ');
/* 273 */         sb.replace(count, count + 1, ia);
/*     */       }
/*     */     }
/* 276 */     String data = sb.toString().replaceAll("_", "");
/* 277 */     return data.toString();
/*     */   }
/*     */   
/*     */   private static String md5(String data) throws NoSuchAlgorithmException {
/* 281 */     MessageDigest md = MessageDigest.getInstance("MD5");
/* 282 */     md.update(data.toString().getBytes());
/* 283 */     return bytesToHex(md.digest());
/*     */   }
/*     */   
/* 286 */   private static final CloseableHttpClient client = HttpClientBuilder.create().build();
/*     */   
/*     */   private static HttpResponse makePostRequest(String uri, String jsonData) throws ClientProtocolException, IOException
/*     */   {
/* 290 */     HttpPost httpPost = new HttpPost(URIUtil.encodeQuery(uri, "utf-8"));
/* 291 */     httpPost.setEntity(new StringEntity(jsonData, "UTF-8"));
/* 292 */     httpPost.setHeader("Accept", "application/json");
/* 293 */     httpPost.setHeader("Content-type", "application/json; charset=utf-8");
/* 294 */     return client.execute(httpPost);
/*     */   }
/*     */   
/*     */   private static String bytesToHex(byte[] ch) {
/* 298 */     StringBuffer ret = new StringBuffer("");
/* 299 */     for (int i = 0; i < ch.length; i++)
/* 300 */       ret.append(byteToHex(ch[i]));
/* 301 */     return ret.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   private static String byteToHex(byte ch)
/*     */   {
/* 307 */     String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
/* 308 */     return str[(ch >> 4 & 0xF)] + str[(ch & 0xF)];
/*     */   }
/*     */ }
