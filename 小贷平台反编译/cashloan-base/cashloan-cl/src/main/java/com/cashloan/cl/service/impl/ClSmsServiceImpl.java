/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.domain.*;
import com.cashloan.cl.mapper.*;
import com.cashloan.cl.model.BorrowRepayModel;
import com.cashloan.cl.monitor.BusinessExceptionMonitor;
import com.cashloan.cl.service.ClSmsService;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.DateUtil;
import com.rongdu.cashloan.core.common.util.StringUtil;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.User;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.core.mapper.UserMapper;
import credit.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import smscredit.SmsCreditRequest;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
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
/*     */ @Service("clSmsService")
/*     */ public class ClSmsServiceImpl
/*     */   extends BaseServiceImpl<Sms, Long>
/*     */   implements ClSmsService
/*     */ {
/*  57 */   public static final Logger logger = LoggerFactory.getLogger(ClSmsServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private SmsMapper smsMapper;
/*     */   @Resource
/*     */   private SmsTplMapper smsTplMapper;
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   @Resource
/*     */   private BorrowRepayMapper borrowRepayMapper;
/*     */   @Resource
/*     */   private ClBorrowMapper clBorrowMapper;
/*     */   @Resource
/*     */   private UrgeRepayOrderMapper urgeRepayOrderMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private BankCardMapper bankCardMapper;
/*     */   
/*     */   public BaseMapper<Sms, Long> getMapper()
/*     */   {
/*  78 */     return this.smsMapper;
/*     */   }
/*     */   
/*     */   public long findTimeDifference(String phone, String type)
/*     */   {
/*  83 */     int countdown = Global.getInt("sms_countdown");
/*  84 */     Map<String, Object> data = new HashMap();
/*  85 */     data.put("phone", phone);
/*  86 */     data.put("smsType", type);
/*  87 */     Sms sms = this.smsMapper.findTimeMsg(data);
/*  88 */     long times = 0L;
/*  89 */     if (sms != null) {
/*  90 */       Date d1 = sms.getSendTime();
/*  91 */       Date d2 = DateUtil.getNow();
/*  92 */       long diff = d2.getTime() - d1.getTime();
/*  93 */       if (diff < countdown * 1000) {
/*  94 */         times = countdown - diff / 1000L;
/*     */       } else {
/*  96 */         times = 0L;
/*     */       }
/*     */     }
/*  99 */     return times;
/*     */   }
/*     */   
/*     */   public int countDayTime(String phone, String type)
/*     */   {
/* 104 */     String mostTimes = Global.getValue("sms_day_most_times");
/* 105 */     int mostTime = JSONObject.parseObject(mostTimes).getIntValue(type);
/*     */     
/* 107 */     Map<String, Object> data = new HashMap();
/* 108 */     data.put("phone", phone);
/* 109 */     data.put("smsType", type);
/* 110 */     int times = this.smsMapper.countDayTime(data);
/*     */     
/* 112 */     return mostTime - times;
/*     */   }
/*     */   
/*     */   public long sendSms(String phone, String type)
/*     */   {
/* 117 */     Map<String, Object> search = new HashMap();
/* 118 */     search.put("type", type);
/* 119 */     search.put("state", "10");
/* 120 */     SmsTpl tpl = (SmsTpl)this.smsTplMapper.findSelective(search);
/* 121 */     if (tpl != null) {
/* 122 */       Map<String, Object> payload = new HashMap();
/* 123 */       int vcode = (int)(Math.random() * 9000.0D) + 1000;
/* 124 */       payload.put("mobile", phone);
/* 125 */       payload.put("message", change(type) + vcode);
/* 126 */       String result = sendCode(payload, tpl.getNumber());
/* 127 */       logger.debug("发送短信，phone：" + phone + "， type：" + type + "，同步响应结果：" + result);
/* 128 */       return result(result, phone, type, vcode);
/*     */     }
/* 130 */     logger.error("发送短信，phone：" + phone + "， type：" + type + "，没有获取到smsTpl");
/* 131 */     return 0L;
/*     */   }
/*     */   
/*     */   public int smsBatch(String id)
/*     */   {
/* 136 */     final long[] ids = StringUtil.toLongs(id.split(","));
/* 137 */     new Thread() {
/*     */       public void run() {
/* 139 */         Map<String, Object> search = new HashMap();
/* 140 */         search.put("type", "overdue");
/* 141 */         search.put("state", "10");
/* 142 */         String smsNo = ((SmsTpl)ClSmsServiceImpl.this.smsTplMapper.findSelective(search)).getNumber();
/* 143 */         if (smsNo != null) {
/* 144 */           ClSmsServiceImpl.logger.info("开始批量发送逾期短信。。");
/* 145 */           for (int i = 0; i < ids.length; i++) {
/* 146 */             UrgeRepayOrder uro = (UrgeRepayOrder)ClSmsServiceImpl.this.urgeRepayOrderMapper.findByPrimary(Long.valueOf(ids[i]));
/* 147 */             Map<String, Object> map = new HashMap();
/* 148 */             map.put("platform", uro.getBorrowTime());
/* 149 */             map.put("loan", uro.getAmount());
/* 150 */             map.put("time", uro.getRepayTime());
/* 151 */             map.put("overdueDay", uro.getPenaltyDay());
/* 152 */             map.put("amercement", uro.getPenaltyAmout());
/* 153 */             map.put("phone", uro.getPhone().subSequence(7, 11));
/*     */             
/* 155 */             Map<String, Object> payload = new HashMap();
/* 156 */             payload.put("mobile", uro.getPhone());
/* 157 */             payload.put("message", ClSmsServiceImpl.this.changeMessage("overdue", map));
/* 158 */             String result = ClSmsServiceImpl.this.sendCode(payload, smsNo);
/* 159 */             ClSmsServiceImpl.logger.info("短信发送结果" + result);
/* 160 */             ClSmsServiceImpl.this.result(result, uro.getPhone(), "overdue", 0);
/*     */           }
/*     */           
/*     */         }
/*     */         else {}
/*     */       }
/* 166 */     }.start();
/* 167 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */   public int verifySms(String phone, String type, String code)
/*     */   {
/* 173 */     if (("dev".equals(Global.getValue("app_environment"))) && ("0000".equals(code))) {
/* 174 */       return 1;
/*     */     }
/*     */     
/* 177 */     if ((StringUtil.isBlank(phone)) || (StringUtil.isBlank(type)) || (StringUtil.isBlank(code))) {
/* 178 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 182 */     if (!StringUtil.isPhone(phone)) {
/* 183 */       return 0;
/*     */     }
/*     */     
/* 186 */     Map<String, Object> data = new HashMap();
/* 187 */     data.put("phone", phone);
/* 188 */     data.put("smsType", type);
/* 189 */     Sms sms = this.smsMapper.findTimeMsg(data);
/* 190 */     if (sms != null) {
/* 191 */       String mostTimes = Global.getValue("sms_day_most_times");
/* 192 */       int mostTime = JSONObject.parseObject(mostTimes).getIntValue("verifyTime");
/*     */       
/* 194 */       data = new HashMap();
/* 195 */       data.put("verifyTime", Integer.valueOf(sms.getVerifyTime() + 1));
/* 196 */       data.put("id", sms.getId());
/* 197 */       this.smsMapper.updateSelective(data);
/*     */       
/* 199 */       if ((StringUtil.equals("20", sms.getState())) || (sms.getVerifyTime() > mostTime)) {
/* 200 */         return 0;
/*     */       }
/*     */       
/* 203 */       long timeLimit = Long.parseLong(Global.getValue("sms_time_limit"));
/*     */       
/* 205 */       Date d1 = sms.getSendTime();
/* 206 */       Date d2 = DateUtil.getNow();
/* 207 */       long diff = d2.getTime() - d1.getTime();
/* 208 */       if (diff > timeLimit * 60L * 1000L) {
/* 209 */         return -1;
/*     */       }
/* 211 */       if (sms.getCode().equals(code)) {
/* 212 */         Map<String, Object> map = new HashMap();
/* 213 */         map.put("id", sms.getId());
/* 214 */         map.put("state", "20");
/* 215 */         this.smsMapper.updateSelective(map);
/* 216 */         return 1;
/*     */       }
/*     */     }
/* 219 */     return 0;
/*     */   }
/*     */   
/*     */   protected String changeMessage(String smsType, Map<String, Object> map) {
/* 223 */     String message = "";
/* 224 */     if ("overdue".equals(smsType)) {
/* 225 */       message = ret(smsType);
/* 226 */       message = message
/* 227 */         .replace(
/* 228 */         "{$platform}", 
/* 229 */         DateUtil.dateStr(DateUtil.valueOf(
/* 230 */         DateUtil.dateStr(DateUtil.valueOf(map.get("platform").toString()), "yyyy-MM-dd")), "M月dd日"))
/* 231 */         .replace("{$loan}", StringUtil.isNull(map.get("loan")))
/* 232 */         .replace(
/* 233 */         "{$time}", 
/* 234 */         DateUtil.dateStr(DateUtil.valueOf(
/* 235 */         DateUtil.dateStr(DateUtil.valueOf(map.get("time").toString()), "yyyy-MM-dd")), "M月dd日"))
/* 236 */         .replace("{$overdueDay}", 
/* 237 */         StringUtil.isNull(map.get("overdueDay")))
/* 238 */         .replace("{$amercement}", 
/* 239 */         StringUtil.isNull(map.get("amercement")));
/*     */     }
/* 241 */     if ("loanInform".equals(smsType)) {
/* 242 */       message = ret(smsType);
/* 243 */       message = message.replace("{$time}", 
/* 244 */         DateUtil.dateStr(DateUtil.valueOf(
/* 245 */         DateUtil.dateStr(DateUtil.valueOf(map.get("time").toString()), "yyyy-MM-dd")), "M月dd日"));
/*     */     }
/* 247 */     if ("repayInform".equals(smsType)) {
/* 248 */       message = ret(smsType);
/* 249 */       message = message.replace("{$time}", 
/* 250 */         DateUtil.dateStr(DateUtil.valueOf(
/* 251 */         DateUtil.dateStr(DateUtil.valueOf(map.get("time").toString()), "yyyy-MM-dd")), "M月dd日"))
/* 252 */         .replace("{$loan}", StringUtil.isNull(map.get("loan")));
/*     */     }
/* 254 */     if ("repayBefore".equals(smsType)) {
/* 255 */       message = ret(smsType);
/* 256 */       message = message
/* 257 */         .replace("{$loan}", StringUtil.isNull(map.get("loan")))
/* 258 */         .replace(
/* 259 */         "{$time}", 
/* 260 */         DateUtil.dateStr(DateUtil.valueOf(
/* 261 */         DateUtil.dateStr(DateUtil.valueOf(map.get("time").toString()), "yyyy-MM-dd")), "M月dd日"))
/* 262 */         .replace("{$name}", StringUtil.isNull(map.get("name")))
/* 263 */         .replace("{$cardNo}", StringUtil.isNull(map.get("cardNo")))
/* 264 */         .replace("{$bankCardNo}", StringUtil.isNull(map.get("bankCardNo")));
/*     */     }
/* 266 */     if ("registerSuccess".equals(smsType)) {
/* 267 */       message = ret(smsType);
/* 268 */       message = message
/* 269 */         .replace("{$pwd}", StringUtil.isNull(map.get("pwd")));
/*     */     }
/* 271 */     return message;
/*     */   }
/*     */   
/*     */   public String change(String code) {
/* 275 */     String message = null;
/* 276 */     if ("register".equals(code)) {
/* 277 */       message = ret("register");
/* 278 */     } else if ("findReg".equals(code)) {
/* 279 */       message = ret("findReg");
/* 280 */     } else if ("bindCard".equals(code)) {
/* 281 */       message = ret("bindCard");
/* 282 */     } else if ("findPay".equals(code)) {
/* 283 */       message = ret("findPay");
/* 284 */     } else if ("overdue".equals(code)) {
/* 285 */       message = ret("overdue");
/* 286 */     } else if ("loanInform".equals(code)) {
/* 287 */       message = ret("loanInform");
/* 288 */     } else if ("repayInform".equals(code)) {
/* 289 */       message = ret("repayInform");
/* 290 */     } else if ("repayBefore".equals(code)) {
/* 291 */       message = ret("repayBefore");
/*     */     }
/* 293 */     return message;
/*     */   }
/*     */   
/*     */   public String ret(String type) {
/* 297 */     Map<String, Object> search = new HashMap();
/* 298 */     search.put("type", type);
/* 299 */     SmsTpl tpl = (SmsTpl)this.smsTplMapper.findSelective(search);
/* 300 */     return tpl.getTpl();
/*     */   }
/*     */   
/*     */   private int result(String result, String phone, String type, int vcode) {
/* 304 */     String sms_passageway = Global.getValue("sms_passageway");
/* 305 */     if (StringUtil.isBlank(sms_passageway)) {
/* 306 */       sms_passageway = "10";
/*     */     }
/*     */     
/* 309 */     int msg = 0;
/*     */     
/* 311 */     if ("10".equals(sms_passageway)) {
/* 312 */       JSONObject resultJson = JSONObject.parseObject(result);
/*     */       
/*     */ 
/* 315 */       if (StringUtil.isNotBlank(resultJson)) {
/* 316 */         Integer code = resultJson.getInteger("code");
/* 317 */         logger.info("发送短信，phone：" + phone + "， type：" + type + "，保存sms时code：" + code);
/* 318 */         Date now = DateUtil.getNow();
/* 319 */         Sms sms = new Sms();
/* 320 */         sms.setPhone(phone);
/* 321 */         sms.setSendTime(now);
/* 322 */         sms.setRespTime(now);
/* 323 */         sms.setSmsType(type);
/* 324 */         sms.setVerifyTime(0);
/*     */         
/* 326 */         if (code.intValue() == 200) {
/* 327 */           JSONObject resJson = JSONObject.parseObject(StringUtil.isNull(resultJson.get("res")));
/* 328 */           JSONObject tempJson = JSONObject.parseObject(StringUtil.isNull(resultJson.get("tempParame")));
/* 329 */           String orderNo = StringUtil.isNull(resultJson.get("orderNo"));
/* 330 */           Integer tempCode = tempJson.getInteger("code");
/*     */           
/* 332 */           sms.setContent(resJson.getString("result"));
/* 333 */           sms.setResp("短信已发送");
/* 334 */           sms.setCode(StringUtil.isNull(tempCode));
/* 335 */           sms.setOrderNo(orderNo);
/* 336 */           sms.setState("10");
/* 337 */           msg = this.smsMapper.save(sms);
/*     */         } else {
/* 339 */           String message = resultJson.getString("message");
/* 340 */           sms.setContent(message);
/* 341 */           sms.setResp("短信发送失败");
/* 342 */           sms.setCode("");
/* 343 */           sms.setOrderNo("");
/* 344 */           sms.setState("20");
/* 345 */           this.smsMapper.save(sms);
/*     */           
/* 347 */           BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_3, phone, message);
/*     */         }
/*     */       }
/*     */     }
/* 351 */     if ("20".equals(sms_passageway)) {
/* 352 */       Date now = DateUtil.getNow();
/* 353 */       Sms sms = new Sms();
/*     */       
/* 355 */       if (result.contains("\n")) {
/* 356 */         String[] results = result.split("\n");
/* 357 */         String[] temp = results[0].split(",");
/* 358 */         sms.setPhone(phone);
/* 359 */         sms.setSendTime(now);
/* 360 */         sms.setContent(result);
/* 361 */         SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmss");
/*     */         try {
/* 363 */           now = s.parse(temp[0]);
/*     */         } catch (Exception e) {
/* 365 */           logger.error(e.getMessage(), e);
/*     */         }
/* 367 */         sms.setRespTime(now);
/* 368 */         sms.setResp("短信已发送");
/* 369 */         sms.setSmsType(type);
/* 370 */         sms.setCode(String.valueOf(vcode));
/* 371 */         sms.setOrderNo(StringUtil.isNull(results[1]));
/* 372 */         sms.setState("10");
/* 373 */         sms.setVerifyTime(0);
/* 374 */         msg = this.smsMapper.save(sms);
/*     */       }
/*     */       else
/*     */       {
/* 378 */         sms.setPhone(phone);
/* 379 */         sms.setSendTime(now);
/* 380 */         sms.setContent(result);
/* 381 */         sms.setRespTime(now);
/* 382 */         sms.setResp("短信发送失败");
/* 383 */         sms.setSmsType(type);
/* 384 */         sms.setCode("");
/* 385 */         sms.setOrderNo("");
/* 386 */         sms.setState("20");
/* 387 */         sms.setVerifyTime(0);
/* 388 */         this.smsMapper.save(sms);
/*     */         
/* 390 */         BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_3, phone, result);
/*     */       }
/*     */     }
/* 393 */     return msg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private String sendCode(Map<String, Object> payload, String smsNo)
/*     */   {
/* 400 */     String sms_passageway = Global.getValue("sms_passageway");
/* 401 */     if (StringUtil.isBlank(sms_passageway)) {
/* 402 */       sms_passageway = "10";
/*     */     }
/*     */     
/* 405 */     if ("10".equals(sms_passageway)) {
/* 406 */       return dsSendSms(payload, smsNo);
/*     */     }
/* 408 */     if ("20".equals(sms_passageway)) {
/* 409 */       String cl_sms_value = Global.getValue("cl_sms_value");
/*     */       
/* 411 */       Map<String, Object> smsMap = (Map)JSONObject.parseObject(cl_sms_value, Map.class);
/* 412 */       payload.putAll(smsMap);
/* 413 */       if ((payload.containsKey("url")) && (payload.containsKey("un")) && 
/* 414 */         (payload.containsKey("pw")) && 
/* 415 */         (payload.containsKey("mobile")) && 
/* 416 */         (payload.containsKey("message")) && 
/* 417 */         (payload.containsKey("rd")) && (payload.containsKey("ex"))) {
/* 418 */         return clSendSms(payload);
/*     */       }
/*     */     }
/* 421 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String clSendSms(Map<String, Object> payload)
/*     */   {
/* 434 */     HttpClient client = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
/* 435 */     GetMethod method = new GetMethod();
/* 436 */     String returnStr = "";
/*     */     try {
/* 438 */       URI base = new URI((String)payload.get("url"), false);
/* 439 */       method.setURI(new URI(base, "send", false));
/* 440 */       method.setQueryString(new NameValuePair[] {
/* 441 */         new NameValuePair("un", (String)payload.get("un")), 
/* 442 */         new NameValuePair("pw", (String)payload.get("pw")), 
/* 443 */         new NameValuePair("phone", (String)payload.get("mobile")), 
/* 444 */         new NameValuePair("rd", (String)payload.get("rd")), 
/* 445 */         new NameValuePair("msg", (String)payload.get("message")), 
/* 446 */         new NameValuePair("ex", (String)payload.get("ex")) });
/*     */       
/* 448 */       int result = client.executeMethod(method);
/* 449 */       if (result == 200) {
/* 450 */         InputStream in = method.getResponseBodyAsStream();
/* 451 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 452 */         byte[] buffer = new byte['Ѐ'];
/* 453 */         int len = 0;
/* 454 */         while ((len = in.read(buffer)) != -1) {
/* 455 */           baos.write(buffer, 0, len);
/*     */         }
/* 457 */         returnStr = URLDecoder.decode(baos.toString(), "UTF-8");
/*     */       } else {
/* 459 */         throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
/*     */       }
/* 461 */     } catch (Exception e) { e = e;
/* 462 */       logger.error(e.getMessage(), e);
/*     */       
/* 464 */       method.releaseConnection();
/*     */     }
///*     */     finally
///*     */     {
///* 464 */         method.releaseConnection();
///* 465 */       throw ((Throwable)localObject);
///*     */     }
/* 464 */     method.releaseConnection();
/*     */     label392:
/* 466 */     return returnStr;
/*     */   }
/*     */   
/*     */   private String dsSendSms(Map<String, Object> payload, String smsNo)
/*     */   {
/* 471 */     String APIKEY = Global.getValue("apikey");
/* 472 */     String SECRETKEY = Global.getValue("secretkey");
/* 473 */     String APIHOST = Global.getValue("sms_apihost");
/* 474 */     String channelNo = Global.getValue("sms_channelNo");
/* 475 */     String interfaceName = Global.getValue("sms_interfaceName");
/*     */     
/* 477 */     long timestamp = new Date().getTime();
/* 478 */     Header header = new Header(APIKEY, channelNo, interfaceName, timestamp);
/* 479 */     SmsCreditRequest creditRequest = new SmsCreditRequest(APIHOST, header, smsNo);
/*     */     
/* 481 */     creditRequest.setPayload(payload);
/* 482 */     creditRequest.signByKey(SECRETKEY);
/* 483 */     String result = null;
/*     */     try {
/* 485 */       result = creditRequest.request();
/*     */     } catch (Exception e) {
/* 487 */       logger.error(e.getMessage(), e);
/*     */     }
/* 489 */     return result;
/*     */   }
/*     */   
/*     */   public int findUser(String phone)
/*     */   {
/* 494 */     Map<String, Object> paramMap = new HashMap();
/* 495 */     paramMap.put("loginName", phone);
/* 496 */     User user = (User)this.userMapper.findSelective(paramMap);
/* 497 */     if (StringUtil.isNotBlank(user)) {
/* 498 */       return 1;
/*     */     }
/* 500 */     return 0;
/*     */   }
/*     */   
/*     */   public int loanInform(long userId, long borrowId)
/*     */   {
/* 505 */     Map<String, Object> search = new HashMap();
/* 506 */     User user = (User)this.userMapper.findByPrimary(Long.valueOf(userId));
/* 507 */     search.put("borrowId", Long.valueOf(borrowId));
/* 508 */     Borrow br = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowId));
/* 509 */     if ((user != null) && (br != null)) {
/* 510 */       search.put("type", "loanInform");
/* 511 */       search.put("state", "10");
/* 512 */       SmsTpl tpl = (SmsTpl)this.smsTplMapper.findSelective(search);
/* 513 */       if (tpl != null) {
/* 514 */         search = new HashMap();
/* 515 */         search.put("time", DateUtil.dateStr(br.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
/* 516 */         Map<String, Object> payload = new HashMap();
/* 517 */         payload.put("mobile", user.getLoginName());
/* 518 */         payload.put("message", changeMessage("loanInform", search));
/* 519 */         String result = sendCode(payload, tpl.getNumber());
/* 520 */         logger.info("短信发送结果" + result);
/* 521 */         return result(result, user.getLoginName(), "loanInform", 0);
/*     */       }
/*     */     }
/* 524 */     return 0;
/*     */   }
/*     */   
/*     */   public int repayInform(long userId, long borrowId)
/*     */   {
/* 529 */     Map<String, Object> search = new HashMap();
/* 530 */     User user = (User)this.userMapper.findByPrimary(Long.valueOf(userId));
/* 531 */     search.put("borrowId", Long.valueOf(borrowId));
/* 532 */     Borrow br = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowId));
/* 533 */     if ((user != null) && (br != null)) {
/* 534 */       search.put("type", "repayInform");
/* 535 */       search.put("state", "10");
/* 536 */       SmsTpl tpl = (SmsTpl)this.smsTplMapper.findSelective(search);
/* 537 */       if (tpl != null) {
/* 538 */         search = new HashMap();
/* 539 */         search.put("time", DateUtil.dateStr(br.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
/* 540 */         search.put("loan", br.getAmount());
/* 541 */         Map<String, Object> payload = new HashMap();
/* 542 */         payload.put("mobile", user.getLoginName());
/* 543 */         payload.put("message", changeMessage("repayInform", search));
/* 544 */         String result = sendCode(payload, tpl.getNumber());
/* 545 */         logger.info("短信发送结果" + result);
/* 546 */         return result(result, user.getLoginName(), "repayInform", 0);
/*     */       }
/*     */     }
/* 549 */     return 0;
/*     */   }
/*     */   
/*     */   public int overdue(long borrowId)
/*     */   {
/* 554 */     Map<String, Object> search = new HashMap();
/* 555 */     search.put("type", "overdue");
/* 556 */     search.put("state", "10");
/* 557 */     String smsNo = ((SmsTpl)this.smsTplMapper.findSelective(search)).getNumber();
/* 558 */     if (smsNo != null) {
/* 559 */       BorrowRepayModel brm = this.borrowRepayMapper.findOverdue(borrowId);
/* 560 */       Map<String, Object> map = new HashMap();
/* 561 */       map.put("phone", brm.getPhone());
/* 562 */       map.put("platform", brm.getCreateTime());
/* 563 */       map.put("loan", brm.getAmount());
/* 564 */       map.put("time", brm.getRepayTime());
/* 565 */       map.put("overdueDay", brm.getPenaltyDay());
/* 566 */       map.put("amercement", brm.getPenaltyAmout());
/* 567 */       Map<String, Object> payload = new HashMap();
/* 568 */       payload.put("mobile", brm.getPhone());
/* 569 */       payload.put("message", changeMessage("overdue", map));
/* 570 */       String result = sendCode(payload, smsNo);
/* 571 */       logger.info("短信发送结果" + result);
/* 572 */       result(result, brm.getPhone(), "overdue", 0);
/*     */     } else {
/* 574 */       return 0;
/*     */     }
/* 576 */     return 1;
/*     */   }
/*     */   
/*     */   public int repayBefore(long userId, long borrowId)
/*     */   {
/* 581 */     Map<String, Object> search = new HashMap();
/* 582 */     search.put("borrowId", Long.valueOf(borrowId));
/* 583 */     BorrowRepay repay = (BorrowRepay)this.borrowRepayMapper.findSelective(search);
/* 584 */     UserBaseInfo baseInfo = this.userBaseInfoMapper.findByUserId(Long.valueOf(userId));
/* 585 */     search.clear();
/* 586 */     search.put("userId", Long.valueOf(userId));
/* 587 */     BankCard bankCard = (BankCard)this.bankCardMapper.findSelective(search);
/* 588 */     if ((baseInfo != null) && (repay != null) && (bankCard != null)) {
/* 589 */       search.clear();
/* 590 */       search.put("type", "repayBefore");
/* 591 */       search.put("state", "10");
/* 592 */       SmsTpl tpl = (SmsTpl)this.smsTplMapper.findSelective(search);
/* 593 */       if (tpl != null) {
/* 594 */         search = new HashMap();
/* 595 */         search.put("time", DateUtil.dateStr(repay.getRepayTime(), "yyyy-MM-dd HH:mm:ss"));
/* 596 */         search.put("cardNo", baseInfo.getPhone().substring(7, 11));
/* 597 */         search.put("name", baseInfo.getRealName());
/* 598 */         search.put("loan", repay.getAmount());
/* 599 */         int len = bankCard.getCardNo().length();
/* 600 */         search.put("bankCardNo", bankCard.getCardNo().substring(len - 4, len));
/* 601 */         Map<String, Object> payload = new HashMap();
/* 602 */         payload.put("mobile", baseInfo.getPhone());
/* 603 */         payload.put("message", changeMessage("repayBefore", search));
/* 604 */         String result = sendCode(payload, tpl.getNumber());
/* 605 */         logger.info("短信发送结果" + result);
/* 606 */         return result(result, baseInfo.getPhone(), "repayBefore", 0);
/*     */       }
/*     */     }
/* 609 */     return 0;
/*     */   }
/*     */   
/*     */   public int registerSuccess(String phone, String pwd)
/*     */   {
/* 614 */     Map<String, Object> search = new HashMap();
/* 615 */     search.put("type", "registerSuccess");
/* 616 */     search.put("state", "10");
/* 617 */     String smsNo = ((SmsTpl)this.smsTplMapper.findSelective(search)).getNumber();
/* 618 */     if (smsNo != null) {
/* 619 */       Map<String, Object> map = new HashMap();
/* 620 */       search.put("pwd", pwd);
/* 621 */       Map<String, Object> payload = new HashMap();
/* 622 */       payload.put("mobile", phone);
/* 623 */       payload.put("message", changeMessage("registerSuccess", search));
/* 624 */       String result = sendCode(payload, smsNo);
/* 625 */       logger.info("短信发送结果" + result);
/* 626 */       return result(result, phone, "registerSuccess", 0);
/*     */     }
/* 628 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<String, Integer> sendBatchSms(List<String> phones, String tpl)
/*     */   {
/* 634 */     Map<String, Integer> res = new HashMap();
/* 635 */     res.put("total", Integer.valueOf(phones.size()));
/* 636 */     res.put("success", Integer.valueOf(0));
/*     */     
/* 638 */     for (String phone : phones) {
/* 639 */       Map<String, Object> payload = new HashMap();
/* 640 */       payload.put("mobile", phone);
/* 641 */       payload.put("message", tpl);
/* 642 */       String result = sendCode(payload, "0");
/* 643 */       int msg = result(result, phone, "registerSuccess", 0);
/* 644 */       res.put("success", Integer.valueOf(((Integer)res.get("success")).intValue() + msg));
/*     */     }
/*     */     
/* 647 */     return res;
/*     */   }
/*     */ }