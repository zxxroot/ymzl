/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.OperatorCellBehavior;
/*     */ import com.cashloan.cl.domain.OperatorHLBasic;
/*     */ import com.cashloan.cl.domain.OperatorHLCallRecord;
/*     */ import com.cashloan.cl.domain.OperatorHLSmsRecord;
/*     */ import com.cashloan.cl.domain.OperatorRepApplicationCheck;
/*     */ import com.cashloan.cl.domain.OperatorRepBehaviorCheck;
/*     */ import com.cashloan.cl.domain.OperatorRepContactRegion;
/*     */ import com.cashloan.cl.domain.OperatorRepMain;
/*     */ import com.cashloan.cl.domain.OperatorRepPerson;
/*     */ import com.cashloan.cl.domain.OperatorRepTripInfo;
/*     */ import com.cashloan.cl.domain.OperatorReqLog;
/*     */ import com.cashloan.cl.domain.OperatorTdBasic;
/*     */ import com.cashloan.cl.domain.OperatorTdBills;
/*     */ import com.cashloan.cl.domain.OperatorTdCallInfo;
/*     */ import com.cashloan.cl.domain.OperatorTdCallRecord;
/*     */ import com.cashloan.cl.domain.OperatorTdSmsRecord;
/*     */ import com.cashloan.cl.domain.OperatorTdTransactions;
/*     */ import com.cashloan.cl.domain.OperatorTransactions;
/*     */ import com.cashloan.cl.domain.OperatorVoices;
/*     */ import com.cashloan.cl.domain.OperatorVoicesContact;
/*     */ import com.cashloan.cl.domain.OperatorVoicesTotal;
/*     */ import com.cashloan.cl.domain.UserContacts;
/*     */ import com.cashloan.cl.domain.UserMessages;
/*     */ import com.cashloan.cl.mapper.OperatorCellBehaviorMapper;
/*     */ import com.cashloan.cl.mapper.OperatorRepApplicationCheckMapper;
/*     */ import com.cashloan.cl.mapper.OperatorRepBehaviorCheckMapper;
/*     */ import com.cashloan.cl.mapper.OperatorRepContactRegionMapper;
/*     */ import com.cashloan.cl.mapper.OperatorRepMainMapper;
/*     */ import com.cashloan.cl.mapper.OperatorRepPersonMapper;
/*     */ import com.cashloan.cl.mapper.OperatorRepTripInfoMapper;
/*     */ import com.cashloan.cl.mapper.OperatorTdBasicMapper;
/*     */ import com.cashloan.cl.mapper.OperatorTdBillsMapper;
/*     */ import com.cashloan.cl.mapper.OperatorTdCallInfoMapper;
/*     */ import com.cashloan.cl.mapper.OperatorTdCallRecordMapper;
/*     */ import com.cashloan.cl.mapper.OperatorTdSmsInfoMapper;
/*     */ import com.cashloan.cl.mapper.OperatorTdSmsRecordMapper;
/*     */ import com.cashloan.cl.mapper.OperatorTdTransactionsMapper;
/*     */ import com.cashloan.cl.mapper.OperatorVoicesContactMapper;
/*     */ import com.cashloan.cl.mapper.OperatorVoicesMapper;
/*     */ import com.cashloan.cl.mapper.OperatorVoicesTotalMapper;
/*     */ import com.cashloan.cl.mapper.UserAuthMapper;
/*     */ import com.cashloan.cl.mapper.UserContactsMapper;
/*     */ import com.cashloan.cl.mapper.UserEmerContactsMapper;
/*     */ import com.cashloan.cl.mapper.UserMessagesMapper;
/*     */ import com.cashloan.cl.model.OperatorTdCallInfoModel;
/*     */ import com.cashloan.cl.model.OperatorTdSmsInfoModel;
/*     */ import com.cashloan.cl.service.OperatorTdBasicService;
/*     */ import com.cashloan.cl.service.OperatorVoicesService;
/*     */ import com.cashloan.cl.service.UserContactsService;
/*     */ import com.cashloan.cl.service.UserEmerContactsService;
/*     */ import com.rongdu.cashloan.core.common.exception.BussinessException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.*;
/*     */
/*     */
/*     */
/*     */
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ @Service("operatorTdBasicService")
/*     */ public class OperatorTdBasicServiceImpl
/*     */   extends BaseServiceImpl<OperatorTdBasic, Long>
/*     */   implements OperatorTdBasicService
/*     */ {
/*  97 */   private static final Logger logger = LoggerFactory.getLogger(OperatorTdBasicServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private OperatorTdBasicMapper operatorTdBasicMapper;
/*     */   @Resource
/*     */   private OperatorTdBillsMapper operatorTdBillsMapper;
/*     */   @Resource
/*     */   private OperatorTdCallInfoMapper operatorTdCallInfoMapper;
/*     */   @Resource
/*     */   private OperatorTdCallRecordMapper operatorTdCallRecordMapper;
/*     */   @Resource
/*     */   private OperatorTdSmsInfoMapper operatorTdSmsInfoMapper;
/*     */   @Resource
/*     */   private OperatorTdSmsRecordMapper operatorTdSmsRecordMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private UserAuthMapper userAuthMapper;
/*     */   @Resource
/*     */   private OperatorVoicesMapper operatorVoicesMapper;
/*     */   @Resource
/*     */   private UserMessagesMapper userMessagesMapper;
/*     */   @Resource
/*     */   private UserEmerContactsMapper userEmerContactsMapper;
/*     */   @Resource
/*     */   private UserContactsMapper userContactsMapper;
/*     */   @Resource
/*     */   private OperatorTdTransactionsMapper operatorTdTransactionsMapper;
/*     */   @Resource
/*     */   private OperatorCellBehaviorMapper operatorCellBehaviorMapper;
/*     */   @Resource
/*     */   OperatorVoicesContactMapper operatorVoicesContactMapper;
/*     */   @Resource
/*     */   UserEmerContactsService userEmerContactsService;
/*     */   @Resource
/*     */   OperatorVoicesService operatorVoicesService;
/*     */   @Resource
/*     */   OperatorVoicesTotalMapper operatorVoicesTotalMapper;
/*     */   @Resource
/*     */   UserContactsService userContactsService;
/*     */   @Resource
/*     */   OperatorRepApplicationCheckMapper operatorRepApplicationCheckMapper;
/*     */   @Resource
/*     */   OperatorRepBehaviorCheckMapper operatorRepBehaviorCheckMapper;
/*     */   @Resource
/*     */   OperatorRepContactRegionMapper operatorRepContactRegionMapper;
/*     */   @Resource
/*     */   OperatorRepMainMapper operatorRepMainMapper;
/*     */   @Resource
/*     */   OperatorRepPersonMapper operatorRepPersonMapper;
/*     */   @Resource
/*     */   OperatorRepTripInfoMapper operatorRepTripInfoMapper;
/*     */   
/*     */   public BaseMapper<OperatorTdBasic, Long> getMapper()
/*     */   {
/* 152 */     return this.operatorTdBasicMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveTdOperatorInfos(Map<String, Object> resultData, Long userId, OperatorReqLog log)
/*     */   {
/* 159 */     logger.info("===开始解析运营商数据====");
/* 160 */     Map<String, Object> map = new HashMap();
/* 161 */     if (tool.util.StringUtil.isNotBlank(resultData)) {
/* 162 */       UserBaseInfo userBaseInfo = null;
/* 163 */       if ((userId != null) && (userId.longValue() > 0L)) {
/* 164 */         Map<String, Object> params = new HashMap();
/* 165 */         params.put("userId", userId);
/* 166 */         userBaseInfo = (UserBaseInfo)this.userBaseInfoMapper.findSelective(params);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 177 */       Map<String, Object> dataMap = (Map)resultData.get("data");
/* 178 */       if ((userBaseInfo != null) && (tool.util.StringUtil.isNotBlank(userBaseInfo.getPhone())) && (dataMap != null) && 
/* 179 */         (tool.util.StringUtil.isNotBlank(dataMap.get("user_mobile"))) && (userBaseInfo.getPhone().equals(dataMap.get("user_mobile")))) {
/* 180 */         Map<String, Object> taskMap = (Map)dataMap.get("task_data");
/* 181 */         if ((taskMap != null) && (tool.util.StringUtil.isNotBlank(taskMap)))
/*     */         {
/* 183 */           OperatorTdBasic basic = null;
/* 184 */           String operator_basic = JsonUtil.toString(taskMap.get("account_info"));
/* 185 */           Date date; int age; if (tool.util.StringUtil.isNotBlank(operator_basic)) {
/* 186 */             Map<String, Object> params = (Map)JsonUtil.parse(operator_basic, Map.class);
/*     */             
/* 188 */             if ((params.containsKey("net_age")) && (!tool.util.StringUtil.isNumber(String.valueOf(params.get("net_age"))))) {
/* 189 */               params.remove("net_age");
/* 190 */               params.put("net_age", Integer.valueOf(0));
/*     */             }
/* 192 */             List<OperatorTdBasic> basicList = JSONObject.parseArray(change("[" + JsonUtil.toString(params) + "]"), 
/* 193 */               OperatorTdBasic.class);
/* 194 */             if ((basicList != null) && (!basicList.isEmpty())) {
/* 195 */               basic = (OperatorTdBasic)basicList.get(0);
/* 196 */               String netTime = basic.getNetTime();
/*     */               
/* 198 */               if (com.rongdu.cashloan.core.common.util.StringUtil.isValidDate(netTime)) {
/* 199 */                 date = tool.util.DateUtil.getNow();
/* 200 */                 age = 0;
/* 201 */                 age = tool.util.DateUtil.daysBetween(tool.util.DateUtil.valueOf(netTime), date);
/* 202 */                 basic.setNetAge(Integer.valueOf(age));
/* 203 */               } else if (tool.util.StringUtil.isNotBlank(basic.getNetAge())) {
/* 204 */                 basic.setNetAge(Integer.valueOf(basic.getNetAge().intValue() * 30));
/*     */               } else {
/* 206 */                 basic.setNetAge(Integer.valueOf(0));
/*     */               }
/*     */             }
/*     */           }
/* 210 */           basic.setChannelSrc(String.valueOf(dataMap.get("channel_src")));
/* 211 */           basic.setUserId(userId);
/* 212 */           basic.setUserMobile(String.valueOf(dataMap.get("user_mobile")));
/* 213 */           basic.setReqLogId(log.getId());
/* 214 */           basic.setOrderNo(log.getOrderNo());
/* 215 */           this.operatorTdBasicMapper.save(basic);
/*     */           
/*     */ 
/* 218 */           String operator_bills = JsonUtil.toString(taskMap.get("bill_info"));
/* 219 */           if (tool.util.StringUtil.isNotBlank(operator_bills)) {
/* 220 */             List<OperatorTdBills> billsList = JSONObject.parseArray(change(operator_bills), OperatorTdBills.class);
/* 221 */             if ((billsList != null) && (!billsList.isEmpty())) {
/* 222 */               for (OperatorTdBills bills : billsList) {
/* 223 */                 bills.setUserId(userId);
/* 224 */                 bills.setReqLogId(log.getId());
/* 225 */                 bills.setOrderNo(log.getOrderNo());
/* 226 */                 bills.setBillRecord("");
/* 227 */                 bills.setUsageDetail("");
/* 228 */                 this.operatorTdBillsMapper.save(bills);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 234 */           String operator_call_info = JsonUtil.toString(taskMap.get("call_info"));
/* 235 */           String record; if (tool.util.StringUtil.isNotBlank(operator_call_info)) {
/* 236 */             List<OperatorTdCallInfoModel> billsList = JSONObject.parseArray(change(operator_call_info), 
/* 237 */               OperatorTdCallInfoModel.class);
/* 238 */             if ((billsList != null) && (!billsList.isEmpty())) {
/* 239 */                for (age=0; age<billsList.size(); age++) {
/* 239 */                 OperatorTdCallInfoModel callInfo = billsList.get(age);
/* 240 */                 callInfo.setUserId(userId);
/* 241 */                 callInfo.setReqLogId(log.getId());
/* 242 */                 callInfo.setOrderNo(log.getOrderNo());
/* 243 */                 this.operatorTdCallInfoMapper.save(callInfo);
/* 244 */                 record = callInfo.getCallRecord();
                            List<OperatorTdCallRecord> records = new ArrayList<>();
/* 245 */                 if ((record == null) || (record.isEmpty()))
/* 246 */ {
                                records = JSONObject.parseArray(change(record), OperatorTdCallRecord.class);
                            }
/* 247 */                 if ((records == null) || (records.isEmpty())) {
                                OperatorTdCallRecord r = records.get(0);
                                r.setInfoId(callInfo.getId());
                                this.operatorTdCallRecordMapper.save(r);
                            }
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 259 */           String operator_sms_info = JsonUtil.toString(taskMap.get("sms_info"));
/* 260 */           if (tool.util.StringUtil.isNotBlank(operator_call_info)) {
/* 261 */             List<OperatorTdSmsInfoModel> smsList = JSONObject.parseArray(change(operator_sms_info), 
/* 262 */               OperatorTdSmsInfoModel.class);
/* 263 */             if ((smsList != null) && (!smsList.isEmpty())) { Iterator localIterator2;
///* 264 */               label1071: for (record = smsList.iterator(); record.hasNext();
/*     */                   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
///* 273 */                   localIterator2.hasNext())
/*     */               {
/* 264 */                 OperatorTdSmsInfoModel smsInfo = (OperatorTdSmsInfoModel)record.next();
/* 265 */                 smsInfo.setUserId(userId);
/* 266 */                 smsInfo.setReqLogId(log.getId());
/* 267 */                 smsInfo.setOrderNo(log.getOrderNo());
/* 268 */                 this.operatorTdSmsInfoMapper.save(smsInfo);
/* 269 */                 String record = smsInfo.getSmsRecord();
/* 270 */                 if ((record == null) || (record.isEmpty())) break label1071;
/* 271 */                 List<OperatorTdSmsRecord> records = JSONObject.parseArray(change(record), OperatorTdSmsRecord.class);
/* 272 */                 if ((records == null) || (records.isEmpty())) break label1071;
/* 273 */                 localIterator2 = records.iterator(); continue;OperatorTdSmsRecord r = (OperatorTdSmsRecord)localIterator2.next();
/* 274 */                 r.setInfoId(smsInfo.getId());
/* 275 */                 this.operatorTdSmsRecordMapper.save(r);
/*     */               }
/*     */               
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 283 */           logger.error("用户【" + userId + "】没有运营商关键信息task_data，处理失败");
/*     */         }
/*     */       }
/*     */       else {
/* 287 */         throw new BussinessException("用户【" + userId + "】运营商认证回调数据与用户数据不匹配");
/*     */       }
/*     */     }
/*     */     else {
/* 291 */       logger.error("用户【" + userId + "】运营商认证异步回调信息没有返回res，处理失败");
/*     */     }
/* 293 */     logger.info("===结束解析运营商数据====");
/*     */   }
/*     */   
/*     */   public String change(String name)
/*     */   {
/* 298 */     StringBuffer sb = new StringBuffer();
/* 299 */     sb.append(name);
/* 300 */     int count = sb.indexOf("_");
/* 301 */     while (count != 0) {
/* 302 */       int num = sb.indexOf("_", count);
/* 303 */       count = num + 1;
/* 304 */       if (num != -1) {
/* 305 */         char ss = sb.charAt(count);
/* 306 */         char ia = (char)(ss - ' ');
/* 307 */         sb.replace(count, count + 1, ia);
/*     */       }
/*     */     }
/* 310 */     String data = sb.toString().replaceAll("_", "");
/* 311 */     return data.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public OperatorTdCallInfo findOperatorTdCallInfos(Map<String, Object> params)
/*     */   {
/* 317 */     OperatorTdCallInfo info = new OperatorTdCallInfo();
/* 318 */     List<OperatorTdCallInfo> list = this.operatorTdCallInfoMapper.listSelective(params);
/* 319 */     if ((tool.util.StringUtil.isNotBlank(list)) && (list.size() > 0)) {
/* 320 */       info = (OperatorTdCallInfo)list.get(0);
/*     */     }
/* 322 */     return info;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<OperatorVoices> findPageOperatorTdCallRecord(Map<String, Object> params, int current, int pageSize)
/*     */   {
/* 328 */     PageHelper.startPage(current, pageSize);
/* 329 */     List<OperatorVoices> list = this.operatorTdCallRecordMapper.listOperatorVoicesModel(params);
/* 330 */     return (Page)list;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public void saveHLOperatorInfos(Map<String, Object> dataMap, Long userId, OperatorReqLog log)
/*     */   {
/* 346 */     logger.info("===开始解析运营商数据====");
/* 347 */     if (tool.util.StringUtil.isNotBlank(dataMap)) {
/* 348 */       UserBaseInfo userBaseInfo = null;
/* 349 */       if ((userId != null) && (userId.longValue() > 0L)) {
/* 350 */         Map<String, Object> params = new HashMap();
/* 351 */         params.put("userId", userId);
/* 352 */         userBaseInfo = (UserBaseInfo)this.userBaseInfoMapper.findSelective(params);
/*     */       }
/* 354 */       if ((userBaseInfo != null) && (tool.util.StringUtil.isNotBlank(userBaseInfo.getPhone())) && (dataMap != null) && 
/* 355 */         (tool.util.StringUtil.isNotBlank(dataMap.get("cell_phone_number"))) && 
/* 356 */         (userBaseInfo.getPhone().equals(dataMap.get("cell_phone_number")))) {
/* 357 */         List<Map<String, Object>> list = (List)dataMap.get("push_data");
/* 358 */         Map<String, Object> taskMap = (Map)list.get(0);
/* 359 */         if ((taskMap != null) && (tool.util.StringUtil.isNotBlank(taskMap)))
/*     */         {
/* 361 */           OperatorHLBasic basic = null;
/* 362 */           String operator_basic = JsonUtil.toString(taskMap.get("basic"));
/* 363 */           if (tool.util.StringUtil.isNotBlank(operator_basic)) {
/* 364 */             Map<String, Object> params = (Map)JSONObject.parseObject(operator_basic, Map.class);
/* 365 */             String regTime = (String)params.get("reg_time");
/* 366 */             if ((params.containsKey("reg_time")) && (!com.rongdu.cashloan.core.common.util.StringUtil.isValidDate(String.valueOf(regTime)))) {
/* 367 */               params.remove("reg_time");
/* 368 */               params.put("reg_time", Integer.valueOf(0));
/*     */             }
/* 370 */             List<OperatorHLBasic> basicList = JSONObject.parseArray(change("[" + JsonUtil.toString(params) + "]"), 
/* 371 */               OperatorHLBasic.class);
/* 372 */             if ((basicList != null) && (!basicList.isEmpty())) {
/* 373 */               basic = (OperatorHLBasic)basicList.get(0);
/* 374 */               String netTime = basic.getNetTime();
/* 375 */               if ((StringUtils.isNotBlank(netTime)) && (com.rongdu.cashloan.core.common.util.StringUtil.isValidDate(netTime))) {
/* 376 */                 Date date = tool.util.DateUtil.getNow();
/* 377 */                 int age = 0;
/* 378 */                 age = tool.util.DateUtil.daysBetween(tool.util.DateUtil.valueOf(netTime), date);
/* 379 */                 basic.setNetAge(Integer.valueOf(age));
/* 380 */               } else if (tool.util.StringUtil.isNotBlank(basic.getNetAge())) {
/* 381 */                 basic.setNetAge(Integer.valueOf(basic.getNetAge().intValue() * 30));
/*     */               } else {
/* 383 */                 basic.setNetAge(Integer.valueOf(0));
/*     */               }
/*     */             }
/*     */           }
/* 387 */           basic.setUserId(userId);
/* 388 */           basic.setReqLogId(log.getId());
/* 389 */           basic.setOrderNo(log.getOrderNo());
/* 390 */           this.operatorTdBasicMapper.save(basic);
/*     */           
/*     */ 
/* 393 */           String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId.longValue(), 30000L);
/* 394 */           int countTable = this.operatorVoicesMapper.countTable(tableName);
/* 395 */           if (countTable == 0) {
/* 396 */             this.operatorVoicesMapper.createTable(tableName);
/*     */           }
/* 398 */           String tableContactsName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId.longValue(), 30000L);
/* 399 */           int countContactsTable = this.userContactsMapper.countTable(tableContactsName);
/* 400 */           if (countContactsTable == 0) {
/* 401 */             this.userContactsMapper.createTable(tableContactsName);
/*     */           }
/*     */           
/*     */ 
/* 405 */           String operator_call_info = JsonUtil.toString(taskMap.get("calls"));
/* 406 */           if (tool.util.StringUtil.isNotBlank(operator_call_info)) {
/* 407 */             OperatorTdCallInfoModel callInfo = new OperatorTdCallInfoModel();
/* 408 */             callInfo.setUserId(userId);
/* 409 */             callInfo.setReqLogId(log.getId());
/* 410 */             callInfo.setOrderNo(log.getOrderNo());
/* 411 */             callInfo.setCallRecord(operator_call_info);
/* 412 */             this.operatorTdCallInfoMapper.save(callInfo);
/* 413 */             String record = callInfo.getCallRecord();
/* 414 */             if ((record != null) && (!record.isEmpty())) {
/* 415 */               List<OperatorHLCallRecord> voicesList = JSONObject.parseArray(change(record), OperatorHLCallRecord.class);
/* 416 */               if (!voicesList.isEmpty()) {
/* 417 */                 for (OperatorVoices voice : voicesList) {
/* 418 */                   voice.setUserId(userId);
/* 419 */                   voice.setCreateTime(new Date());
/* 420 */                   voice.setPhoneNum(userBaseInfo.getPhone());
/* 421 */                   logger.debug("CreateTime()----" + voice.getCreateTime());
/* 422 */                   this.operatorVoicesMapper.saveShard(tableName, voice);
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 429 */           String operator_sms_info = JsonUtil.toString(taskMap.get("smses"));
/* 430 */           Object tableNameMessage; if (tool.util.StringUtil.isNotBlank(operator_sms_info)) {
/* 431 */             OperatorTdSmsInfoModel smsInfo = new OperatorTdSmsInfoModel();
/* 432 */             smsInfo.setUserId(userId);
/* 433 */             smsInfo.setReqLogId(log.getId());
/* 434 */             smsInfo.setOrderNo(log.getOrderNo());
/* 435 */             smsInfo.setSmsRecord(operator_sms_info);
/* 436 */             this.operatorTdSmsInfoMapper.save(smsInfo);
/* 437 */             String record = smsInfo.getSmsRecord();
/* 438 */             if ((record != null) && (!record.isEmpty())) {
/* 439 */               List<OperatorHLSmsRecord> records = JSONObject.parseArray(change(record), OperatorHLSmsRecord.class);
/* 440 */               if ((records != null) && (!records.isEmpty()))
/*     */               {
/* 442 */                 tableNameMessage = ShardTableUtil.generateTableNameById("cl_user_messages", userId.longValue(), 30000L);
/* 443 */                 int countMessageTable = this.userMessagesMapper.countTable((String)tableNameMessage);
/* 444 */                 if (countMessageTable == 0) {
/* 445 */                   this.userMessagesMapper.createTable((String)tableNameMessage);
/*     */                 }
/*     */                 
/*     */ 
/* 449 */                 for (OperatorHLSmsRecord r : records) {
/* 450 */                   UserMessages clUserMessages = new UserMessages();
/* 451 */                   clUserMessages.setName(r.getOtherCellPhone());
/* 452 */                   clUserMessages.setPhone(r.getOtherCellPhone());
/* 453 */                   clUserMessages.setTime(com.rongdu.cashloan.core.common.util.DateUtil.parse(r.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
/* 454 */                   clUserMessages.setType(String.valueOf((StringUtils.isNotBlank(r.getInitType())) && (r.getInitType().equals("接收")) ? 20 : 10));
/* 455 */                   clUserMessages.setUserId(userId);
/* 456 */                   this.userMessagesMapper.saveShard((String)tableNameMessage, clUserMessages);
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 463 */           String operator_transactions = JsonUtil.toString(taskMap.get("transactions"));
/* 464 */           if (tool.util.StringUtil.isNotBlank(operator_transactions)) {
/* 465 */             List<OperatorTransactions> records = JSONObject.parseArray(change(operator_transactions), OperatorTransactions.class);
/*     */             
/* 467 */             if ((records != null) && (!records.isEmpty())) {
/* 468 */               for (tableNameMessage = records.iterator(); ((Iterator)tableNameMessage).hasNext();) { OperatorTransactions r = (OperatorTransactions)((Iterator)tableNameMessage).next();
/* 469 */                 r.setCreateTime(new Date());
/* 470 */                 r.setUserId(userId);
/* 471 */                 r.setBillCycleTime(com.rongdu.cashloan.core.common.util.DateUtil.parse(r.getBillCycle(), "yyyy-MM-dd HH:mm:ss"));
/* 472 */                 r.setObtainTime(com.rongdu.cashloan.core.common.util.DateUtil.parse(r.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
/* 473 */                 this.operatorTdTransactionsMapper.save(r);
/*     */               }
/*     */             }
/*     */           }
/* 477 */           updateMessage(userBaseInfo.getUserId(), tableName, tableContactsName);
/*     */         } else {
/* 479 */           logger.error("用户【" + userId + "】没有运营商关键信息task_data，处理失败");
/*     */         }
/*     */       }
/*     */       else {
/* 483 */         throw new BussinessException("用户【" + userId + "】运营商认证回调数据与用户数据不匹配");
/*     */       }
/*     */     } else {
/* 486 */       logger.error("用户【" + userId + "】运营商认证异步回调信息没有返回res，处理失败");
/*     */     }
/* 488 */     logger.info("===结束解析运营商数据====");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateMessage(Long userId, String tableName, String tableContactsName)
/*     */   {
/* 499 */     HashMap<String, Object> paramMap = new HashMap();
/* 500 */     paramMap.put("userId", userId);
/*     */     
/* 502 */     this.userEmerContactsService.updateVoiceMessage(tableName, paramMap);
/*     */     
/* 504 */     this.operatorVoicesService.updateVoiceMessage(tableName, tableContactsName, paramMap);
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveOperatorReportInfos(Map<String, Object> dataMap, Long userId, OperatorReqLog log)
/*     */   {
/* 510 */     logger.info("===开始解析运营商报告数据====");
/* 511 */     if (tool.util.StringUtil.isNotBlank(dataMap)) {
/* 512 */       UserBaseInfo userBaseInfo = null;
/* 513 */       if ((userId != null) && (userId.longValue() > 0L)) {
/* 514 */         Map<String, Object> params = new HashMap();
/* 515 */         params.put("userId", userId);
/* 516 */         userBaseInfo = (UserBaseInfo)this.userBaseInfoMapper.findSelective(params);
/*     */       }
/* 518 */       if ((userBaseInfo != null) && (tool.util.StringUtil.isNotBlank(userBaseInfo.getPhone())) && (dataMap != null) && 
/* 519 */         (tool.util.StringUtil.isNotBlank(dataMap.get("cell_phone_number"))) && 
/* 520 */         (userBaseInfo.getPhone().equals(dataMap.get("cell_phone_number")))) {
/* 521 */         Map<String, Object> taskMap = JSONObject.parseObject(dataMap.get("push_data").toString());
/* 522 */         if ((taskMap != null) && (tool.util.StringUtil.isNotBlank(taskMap)))
/*     */         {
/* 524 */           JSONArray array = JSONObject.parseArray(taskMap.get("cell_behavior").toString());
/* 525 */           List<OperatorCellBehavior> records; if (array != null)
/*     */           {
/* 527 */             String tableBehavior = ShardTableUtil.generateTableNameById("cl_operator_cell_behavior", userId.longValue(), 30000L);
/* 528 */             int countBehavior = this.operatorCellBehaviorMapper.countTable(tableBehavior);
/* 529 */             if (countBehavior == 0) {
/* 530 */               this.operatorCellBehaviorMapper.createTable(tableBehavior);
/*     */             }
/*     */             
/* 533 */             String behavior = array.getJSONObject(0).get("behavior").toString();
/* 534 */             if (tool.util.StringUtil.isNotBlank(behavior)) {
/* 535 */               records = JSONObject.parseArray(change(behavior), OperatorCellBehavior.class);
/* 536 */               if ((records != null) && (!records.isEmpty())) {
/* 537 */                 for (OperatorCellBehavior r : records) {
/* 538 */                   r.setCreateTime(new Date());
/* 539 */                   r.setUserId(userId);
/* 540 */                   this.operatorCellBehaviorMapper.saveShard(tableBehavior, r);
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 547 */           String person = JsonUtil.toString(taskMap.get("person"));
/* 548 */           if (tool.util.StringUtil.isNotBlank(person)) {
/* 549 */             List<OperatorRepPerson> records = JSONObject.parseArray("[" + person + "]", OperatorRepPerson.class);
/*     */             
/* 551 */             if ((records != null) && (!records.isEmpty())) {
/* 552 */               for (OperatorRepPerson r : records) {
/* 553 */                 r.setCreateTime(new Date());
/* 554 */                 r.setUserId(userId);
/* 555 */                 this.operatorRepPersonMapper.save(r);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 560 */           String tableApplication = ShardTableUtil.generateTableNameById("cl_operator_rep_application_check", userId.longValue(), 30000L);
/* 561 */           int countApplication = this.operatorRepApplicationCheckMapper.countTable(tableApplication);
/* 562 */           if (countApplication == 0) {
/* 563 */             this.operatorRepApplicationCheckMapper.createTable(tableApplication);
/*     */           }
/*     */           
/* 566 */           String applicationCheck = JsonUtil.toString(taskMap.get("application_check"));
/* 567 */           if (tool.util.StringUtil.isNotBlank(applicationCheck)) {
/* 568 */             List<OperatorRepApplicationCheck> records = JSONObject.parseArray(change(applicationCheck), OperatorRepApplicationCheck.class);
/* 569 */             if ((records != null) && (!records.isEmpty())) {
/* 570 */               for (OperatorRepApplicationCheck r : records) {
/* 571 */                 r.setCreateTime(new Date());
/* 572 */                 r.setUserId(userId);
/* 573 */                 this.operatorRepApplicationCheckMapper.saveShard(tableApplication, r);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 578 */           String tableBehaviorCheck = ShardTableUtil.generateTableNameById("cl_operator_rep_behavior_check", userId.longValue(), 30000L);
/* 579 */           int countTableBehaviorCheck = this.operatorRepBehaviorCheckMapper.countTable(tableBehaviorCheck);
/* 580 */           if (countTableBehaviorCheck == 0) {
/* 581 */             this.operatorRepBehaviorCheckMapper.createTable(tableBehaviorCheck);
/*     */           }
/*     */           
/* 584 */           String behaviorCheck = JsonUtil.toString(taskMap.get("behavior_check"));
/* 585 */           if (tool.util.StringUtil.isNotBlank(behaviorCheck)) {
/* 586 */             List<OperatorRepBehaviorCheck> records = JSONObject.parseArray(change(behaviorCheck), OperatorRepBehaviorCheck.class);
/* 587 */             if ((records != null) && (!records.isEmpty())) {
/* 588 */               for (OperatorRepBehaviorCheck r : records) {
/* 589 */                 r.setCreateTime(new Date());
/* 590 */                 r.setUserId(userId);
/* 591 */                 this.operatorRepBehaviorCheckMapper.saveShard(tableBehaviorCheck, r);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 596 */           String tableContactRegion = ShardTableUtil.generateTableNameById("cl_operator_rep_contact_region", userId.longValue(), 30000L);
/* 597 */           int countTableContactRegion = this.operatorRepContactRegionMapper.countTable(tableContactRegion);
/* 598 */           if (countTableContactRegion == 0) {
/* 599 */             this.operatorRepContactRegionMapper.createTable(tableContactRegion);
/*     */           }
/*     */           
/* 602 */           String contactRegion = JsonUtil.toString(taskMap.get("contact_region"));
/* 603 */           if (tool.util.StringUtil.isNotBlank(contactRegion)) {
/* 604 */             List<OperatorRepContactRegion> records = JSONObject.parseArray(change(contactRegion), OperatorRepContactRegion.class);
/* 605 */             if ((records != null) && (!records.isEmpty())) {
/* 606 */               for (OperatorRepContactRegion r : records) {
/* 607 */                 r.setCreateTime(new Date());
/* 608 */                 r.setUserId(userId);
/* 609 */                 this.operatorRepContactRegionMapper.saveShard(tableContactRegion, r);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 614 */           String tableTripInfo = ShardTableUtil.generateTableNameById("cl_operator_rep_trip_info", userId.longValue(), 30000L);
/* 615 */           int countTableTripInfo = this.operatorRepTripInfoMapper.countTable(tableTripInfo);
/* 616 */           if (countTableTripInfo == 0) {
/* 617 */             this.operatorRepTripInfoMapper.createTable(tableTripInfo);
/*     */           }
/*     */           
/* 620 */           String tripInfo = JsonUtil.toString(taskMap.get("trip_info"));
/* 621 */           if (tool.util.StringUtil.isNotBlank(tripInfo)) {
/* 622 */             List<OperatorRepTripInfo> records = JSONObject.parseArray(change(tripInfo), OperatorRepTripInfo.class);
/* 623 */             if ((records != null) && (!records.isEmpty())) {
/* 624 */               for (OperatorRepTripInfo r : records) {
/* 625 */                 r.setUserId(userId);
/* 626 */                 r.setCreateTime(new Date());
/* 627 */                 this.operatorRepTripInfoMapper.saveShard(tableTripInfo, r);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 632 */           String tableMainService = ShardTableUtil.generateTableNameById("cl_operator_rep_main_service", userId.longValue(), 30000L);
/* 633 */           int countTableMain = this.operatorRepMainMapper.countTable(tableMainService);
/* 634 */           if (countTableMain == 0) {
/* 635 */             this.operatorRepMainMapper.createTable(tableMainService);
/*     */           }
/*     */           
/* 638 */           String mainService = JsonUtil.toString(taskMap.get("main_service"));
/* 639 */           if (tool.util.StringUtil.isNotBlank(mainService)) {
/* 640 */             List<OperatorRepMain> records = JSONObject.parseArray(change(mainService), OperatorRepMain.class);
/* 641 */             if ((records != null) && (!records.isEmpty())) {
/* 642 */               for (OperatorRepMain r : records) {
/* 643 */                 r.setUserId(userId);
/* 644 */                 r.setCreateTime(new Date());
/* 645 */                 this.operatorRepMainMapper.saveShard(tableMainService, r);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 650 */           String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId.longValue(), 30000L);
/* 651 */           int countTable = this.operatorVoicesMapper.countTable(tableName);
/* 652 */           if (countTable == 0) {
/* 653 */             this.operatorVoicesMapper.createTable(tableName);
/*     */           }
/* 655 */           String tableContactsName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId.longValue(), 30000L);
/* 656 */           int countContactsTable = this.userContactsMapper.countTable(tableContactsName);
/* 657 */           if (countContactsTable == 0) {
/* 658 */             this.userContactsMapper.createTable(tableContactsName);
/*     */           }
/* 660 */           String tableMessageName = ShardTableUtil.generateTableNameById("cl_user_messages", userId.longValue(), 30000L);
/* 661 */           int countMessageTable = this.userMessagesMapper.countTable(tableMessageName);
/* 662 */           if (countMessageTable == 0) {
/* 663 */             this.userMessagesMapper.createTable(tableMessageName);
/*     */           }
/* 665 */           String tableVoiceContactName = ShardTableUtil.generateTableNameById("cl_operator_voices_contact", userId.longValue(), 30000L);
/* 666 */           int countVoiceContactTable = this.operatorVoicesContactMapper.countTable(tableVoiceContactName);
/* 667 */           if (countVoiceContactTable == 0) {
/* 668 */             this.operatorVoicesContactMapper.createTable(tableVoiceContactName);
/*     */           }
/* 670 */           Map<String, Object> paramMap = new HashMap();
/* 671 */           paramMap.put("userId", userBaseInfo.getUserId());
/*     */           
/*     */ 
/* 674 */           String contact_list = taskMap.get("contact_list").toString();
/* 675 */           if (tool.util.StringUtil.isNotBlank(contact_list)) {
/* 676 */             List<OperatorVoicesContact> records = JSONObject.parseArray(change(contact_list), OperatorVoicesContact.class);
/* 677 */             if ((records != null) && (!records.isEmpty())) {
/* 678 */               for (OperatorVoicesContact r : records) {
/* 679 */                 paramMap.put("phone", r.getPhoneNum());
/*     */                 
/* 681 */                 List<UserContacts> listContacts = this.userContactsMapper.listShardSelective(tableContactsName, paramMap);
/* 682 */                 if ((listContacts != null) && (!listContacts.isEmpty())) {
/* 683 */                   r.setUserContactsName(((UserContacts)listContacts.get(0)).getName());
/*     */                 }
/*     */                 
/* 686 */                 paramMap.put("voiceToNumber", r.getPhoneNum());
/* 687 */                 paramMap.put("orderBy", "voice_date desc");
/* 688 */                 List<OperatorVoices> list = this.operatorVoicesMapper.listShardSelective(tableName, paramMap);
/* 689 */                 if ((list != null) && (!list.isEmpty())) {
/* 690 */                   r.setLastCallTime(((OperatorVoices)list.get(0)).getVoiceDate());
/*     */                 }
/* 692 */                 r.setUserId(userId);
/* 693 */                 r.setCreateTime(new Date());
/* 694 */                 this.operatorVoicesContactMapper.saveShard(tableVoiceContactName, r);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 699 */           paramMap.clear();
/* 700 */           paramMap.put("userId", userBaseInfo.getUserId());
/*     */           
/* 702 */           List<OperatorTdTransactions> list = this.operatorTdTransactionsMapper.listSelective(paramMap);
/* 703 */           OperatorVoicesTotal bean = new OperatorVoicesTotal();
/* 704 */           bean.init();
/* 705 */           bean.setUserId(userId);
/* 706 */           bean.setNetsTime(Long.valueOf(list.size()));
/* 707 */           if ((list != null) && (!list.isEmpty())) {
/* 708 */             for (int i = 0; i < list.size(); i++) {
/* 709 */               BigDecimal amount = ((OperatorTdTransactions)list.get(i)).getTotalAmt();
/* 710 */               logger.info("=========amount:" + amount + "==========");
/* 711 */               amount = amount == null ? BigDecimal.ZERO : amount;
/* 712 */               switch (i)
/*     */               {
/*     */               case 0: 
/* 715 */                 bean.setPayAmtJan(amount);
/* 716 */                 break;
/*     */               case 1: 
/* 718 */                 bean.setPayAmtFeb(bean.getPayAmtJan().add(amount));
/* 719 */                 break;
/*     */               case 2: 
/* 721 */                 bean.setPayAmtMar(bean.getPayAmtFeb().add(amount));
/* 722 */                 break;
/*     */               case 3: 
/* 724 */                 bean.setPayAmtApr(bean.getPayAmtMar().add(amount));
/* 725 */                 break;
/*     */               case 4: 
/* 727 */                 bean.setPayAmtMay(bean.getPayAmtApr().add(amount));
/* 728 */                 break;
/*     */               case 5: 
/* 730 */                 bean.setPayAmtJune(bean.getPayAmtMay().add(amount));
/*     */               }
/*     */               
/*     */             }
/* 734 */             BigDecimal payAmtTreeTotal = bean.getPayAmtMar();
/* 735 */             BigDecimal payAmtFive = bean.getPayAmtMay();
/* 736 */             bean.setPayAmtTreeAvg(payAmtTreeTotal.divide(new BigDecimal(3), 2, 6));
/* 737 */             bean.setPayAmtFiveAvg(payAmtFive.divide(new BigDecimal(5), 2, 6));
/*     */           }
/*     */           
/*     */ 
/* 741 */           Object listVoices = this.operatorVoicesMapper.listShardSelective(tableName, paramMap);
/* 742 */           bean.setVoicesCount(Long.valueOf(((List)listVoices).size()));
/*     */           
/* 744 */           List<UserMessages> listSms = this.userMessagesMapper.listShardSelective(tableMessageName, paramMap);
/* 745 */           bean.setSmsCount(Long.valueOf(listSms.size()));
/* 746 */           paramMap.put("totalName", "totalName");
/* 747 */           List<OperatorVoices> listVoicesName = this.operatorVoicesMapper.listShardSelective(tableName, paramMap);
/* 748 */           bean.setVoicesContactsPhone(Long.valueOf(listVoicesName.size()));
/* 749 */           if (((List)listVoices).size() == 0) {
/* 750 */             bean.setVoicesContactsScale(BigDecimal.ZERO);
/*     */           } else {
/* 752 */             bean.setVoicesContactsScale(new BigDecimal(listVoicesName.size()).divide(new BigDecimal(bean.getVoicesCount().longValue()), 2, 6));
/*     */           }
/* 754 */           List<Map<String, String>> listContactsName = this.operatorVoicesMapper.listDistinctService(tableName, "contacts_name", paramMap);
/* 755 */           bean.setVoicesContactsName(Long.valueOf(listContactsName.size()));
/* 756 */           bean.setCreateTime(new Date());
/* 757 */           this.operatorVoicesTotalMapper.save(bean);
/*     */           
/* 759 */           userBaseInfo.setPhoneVoiceCount(Long.valueOf(((List)listVoices).size()));
/* 760 */           this.userBaseInfoMapper.update(userBaseInfo);
/*     */           
/* 762 */           Map<String, Object> temp = new HashMap();
/* 763 */           temp.put("userId", userId);
/* 764 */           temp.put("phoneState", "30");
/* 765 */           this.userAuthMapper.updatePhoneState(temp);
/*     */         } else {
/* 767 */           logger.error("用户【" + userId + "】没有运营商关键信息task_data，处理失败");
/*     */         }
/*     */       } else {
/* 770 */         throw new BussinessException("用户【" + userId + "】运营商认证回调数据与用户数据不匹配");
/*     */       }
/*     */     } else {
/* 773 */       logger.error("用户【" + userId + "】运营商认证异步回调信息没有返回res，处理失败");
/*     */     }
/* 775 */     logger.info("===结束解析运营商报告数据====");
/*     */   }
/*     */   
/*     */   public void deleteOperatorData(Long userId)
/*     */   {
/* 780 */     logger.info("===开始删除运营商原始报告数据====");
/*     */     
/* 782 */     String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId.longValue(), 30000L);
/* 783 */     int countTable = this.operatorVoicesMapper.countTable(tableName);
/* 784 */     if (countTable == 0) {
/* 785 */       this.operatorVoicesMapper.createTable(tableName);
/*     */     }
/* 787 */     String tableNameMessage = ShardTableUtil.generateTableNameById("cl_user_messages", userId.longValue(), 30000L);
/* 788 */     int countMessageTable = this.userMessagesMapper.countTable(tableNameMessage);
/* 789 */     if (countMessageTable == 0) {
/* 790 */       this.userMessagesMapper.createTable(tableNameMessage);
/*     */     }
/* 792 */     this.operatorTdBasicMapper.deleteByUserId(userId);
/* 793 */     this.operatorVoicesMapper.deleteShardByUserId(tableName, userId);
/* 794 */     this.operatorTdCallInfoMapper.deleteByUserId(userId);
/* 795 */     this.operatorTdSmsInfoMapper.deleteByUserId(userId);
/* 796 */     this.userMessagesMapper.deleteShardByUserId(tableNameMessage, userId.longValue());
/* 797 */     this.operatorTdTransactionsMapper.deleteByUserId(userId);
/* 798 */     logger.info("===结束删除运营商报告数据====");
/*     */   }
/*     */   
/*     */   public void deleteOperatorReportData(Long userId)
/*     */   {
/* 803 */     logger.info("===开始删除运营商原始报告数据====");
/*     */     
/* 805 */     String tableBehavior = ShardTableUtil.generateTableNameById("cl_operator_cell_behavior", userId.longValue(), 30000L);
/* 806 */     int countBehavior = this.operatorCellBehaviorMapper.countTable(tableBehavior);
/* 807 */     if (countBehavior == 0) {
/* 808 */       this.operatorCellBehaviorMapper.createTable(tableBehavior);
/*     */     }
/*     */     
/* 811 */     String tableApplication = ShardTableUtil.generateTableNameById("cl_operator_rep_application_check", userId.longValue(), 30000L);
/* 812 */     int countApplication = this.operatorRepApplicationCheckMapper.countTable(tableApplication);
/* 813 */     if (countApplication == 0) {
/* 814 */       this.operatorRepApplicationCheckMapper.createTable(tableApplication);
/*     */     }
/*     */     
/* 817 */     String tableBehaviorCheck = ShardTableUtil.generateTableNameById("cl_operator_rep_behavior_check", userId.longValue(), 30000L);
/* 818 */     int countTableBehaviorCheck = this.operatorRepBehaviorCheckMapper.countTable(tableBehaviorCheck);
/* 819 */     if (countTableBehaviorCheck == 0) {
/* 820 */       this.operatorRepBehaviorCheckMapper.createTable(tableBehaviorCheck);
/*     */     }
/*     */     
/* 823 */     String tableContactRegion = ShardTableUtil.generateTableNameById("cl_operator_rep_contact_region", userId.longValue(), 30000L);
/* 824 */     int countTableContactRegion = this.operatorRepContactRegionMapper.countTable(tableContactRegion);
/* 825 */     if (countTableContactRegion == 0) {
/* 826 */       this.operatorRepContactRegionMapper.createTable(tableContactRegion);
/*     */     }
/*     */     
/* 829 */     String tableTripInfo = ShardTableUtil.generateTableNameById("cl_operator_rep_trip_info", userId.longValue(), 30000L);
/* 830 */     int countTableTripInfo = this.operatorRepTripInfoMapper.countTable(tableTripInfo);
/* 831 */     if (countTableTripInfo == 0) {
/* 832 */       this.operatorRepTripInfoMapper.createTable(tableTripInfo);
/*     */     }
/*     */     
/* 835 */     String tableMainService = ShardTableUtil.generateTableNameById("cl_operator_rep_main_service", userId.longValue(), 30000L);
/* 836 */     int countTableMain = this.operatorRepMainMapper.countTable(tableMainService);
/* 837 */     if (countTableMain == 0) {
/* 838 */       this.operatorRepMainMapper.createTable(tableMainService);
/*     */     }
/*     */     
/* 841 */     String tableVoiceContactName = ShardTableUtil.generateTableNameById("cl_operator_voices_contact", userId.longValue(), 30000L);
/* 842 */     int countVoiceContactTable = this.operatorVoicesContactMapper.countTable(tableVoiceContactName);
/* 843 */     if (countVoiceContactTable == 0) {
/* 844 */       this.operatorVoicesContactMapper.createTable(tableVoiceContactName);
/*     */     }
/*     */     
/* 847 */     this.operatorCellBehaviorMapper.deleteShardByUserId(tableBehavior, userId);
/*     */     
/* 849 */     this.operatorRepPersonMapper.deleteShardByUserId(userId);
/*     */     
/* 851 */     this.operatorRepApplicationCheckMapper.deleteShardByUserId(tableApplication, userId);
/*     */     
/* 853 */     this.operatorRepBehaviorCheckMapper.deleteShardByUserId(tableBehaviorCheck, userId);
/*     */     
/* 855 */     this.operatorRepContactRegionMapper.deleteShardByUserId(tableContactRegion, userId);
/*     */     
/* 857 */     this.operatorRepTripInfoMapper.deleteShardByUserId(tableTripInfo, userId);
/*     */     
/* 859 */     this.operatorRepMainMapper.deleteShardByUserId(tableMainService, userId);
/*     */     
/* 861 */     this.operatorVoicesContactMapper.deleteShardByUserId(tableVoiceContactName, userId);
/*     */     
/* 863 */     this.operatorVoicesTotalMapper.deleteByUserId(userId);
/* 864 */     logger.info("===结束删除运营商报告数据====");
/*     */   }
/*     */   
/*     */   public void saveWkOperatorInfos(Map<String, Object> dataMap, Long userId)
/*     */   {
/* 869 */     logger.info("===开始解析运营商数据====");
/* 870 */     if (tool.util.StringUtil.isNotBlank(dataMap)) {
/* 871 */       UserBaseInfo userBaseInfo = null;
/* 872 */       if ((userId != null) && (userId.longValue() > 0L)) {
/* 873 */         Map<String, Object> params = new HashMap();
/* 874 */         params.put("userId", userId);
/* 875 */         userBaseInfo = (UserBaseInfo)this.userBaseInfoMapper.findSelective(params);
/*     */       }
/* 877 */       Object object = dataMap.get("data");
/* 878 */       if ((userBaseInfo != null) && (tool.util.StringUtil.isNotBlank(userBaseInfo.getPhone())) && (dataMap != null) && (tool.util.StringUtil.isNotBlank(object))) {
/* 879 */         Map<String, String> data = (Map)JSONObject.parseObject(JsonUtil.toString(object), Map.class);
/* 880 */         Map<String, String> mnoDetail = (Map)JSONObject.parseObject(JsonUtil.toString(data.get("mnoDetail")), Map.class);
/* 881 */         Map<String, String> basicData = (Map)JSONObject.parseObject(JsonUtil.toString(mnoDetail.get("mnoPersonalInfo")), Map.class);
/*     */         
/*     */ 
/* 884 */         if (tool.util.StringUtil.equals(userBaseInfo.getPhone(), (CharSequence)basicData.get("mobile"))) {
/* 885 */           List<Map<String, Object>> mnoCallRecords = (List)JSONObject.parseObject(JsonUtil.toString(mnoDetail.get("mnoCallRecords")), List.class);
/* 886 */           List<Map<String, Object>> mnoSmsRecords = (List)JSONObject.parseObject(JsonUtil.toString(mnoDetail.get("mnoSmsRecords")), List.class);
/*     */           
/* 888 */           String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId.longValue(), 30000L);
/* 889 */           int countTable = this.operatorVoicesMapper.countTable(tableName);
/* 890 */           if (countTable == 0) {
/* 891 */             this.operatorVoicesMapper.createTable(tableName);
/*     */           }
/* 893 */           String tableContactsName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId.longValue(), 30000L);
/* 894 */           int countContactsTable = this.userContactsMapper.countTable(tableContactsName);
/* 895 */           if (countContactsTable == 0) {
/* 896 */             this.userContactsMapper.createTable(tableContactsName);
/*     */           }
/*     */           
/* 899 */           for (int i = 0; i < mnoCallRecords.size(); i++) {
/* 900 */             OperatorVoices voice = new OperatorVoices();
/* 901 */             voice.setVoiceType((String)((Map)mnoCallRecords.get(i)).get("callType"));
/* 902 */             voice.setGmtCreate(new Date(Long.parseLong((String)((Map)mnoCallRecords.get(i)).get("beginTime"))));
/* 903 */             voice.setVoiceDuration(Long.valueOf(Long.parseLong((String)((Map)mnoCallRecords.get(i)).get("callDuration"))));
/* 904 */             voice.setVoiceToNumber((String)((Map)mnoCallRecords.get(i)).get("otherNum"));
/* 905 */             voice.setVoicePlace((String)((Map)mnoCallRecords.get(i)).get("stdHomeArea"));
/* 906 */             voice.setUserId(userId);
/* 907 */             voice.setCreateTime(new Date());
/* 908 */             voice.setPhoneNum(userBaseInfo.getPhone());
/* 909 */             this.operatorVoicesMapper.saveShard(tableName, voice);
/*     */           }
/*     */           
/* 912 */           String tableNameMessage = ShardTableUtil.generateTableNameById("cl_user_messages", userId.longValue(), 30000L);
/* 913 */           int countMessageTable = this.userMessagesMapper.countTable(tableNameMessage);
/* 914 */           if (countMessageTable == 0) {
/* 915 */             this.userMessagesMapper.createTable(tableNameMessage);
/*     */           }
/*     */           
/* 918 */           for (int i = 0; i < mnoSmsRecords.size(); i++) {
/* 919 */             UserMessages clUserMessages = new UserMessages();
/* 920 */             clUserMessages.setName((String)((Map)mnoSmsRecords.get(i)).get("otherNum"));
/* 921 */             clUserMessages.setPhone((String)((Map)mnoSmsRecords.get(i)).get("otherNum"));
/* 922 */             clUserMessages.setTime(new Date(Long.parseLong((String)((Map)mnoCallRecords.get(i)).get("beginTime"))));
/* 923 */             clUserMessages.setType(String.valueOf((StringUtils.isNotBlank((String)((Map)mnoSmsRecords.get(i)).get("smsType"))) && 
/* 924 */               (((String)((Map)mnoSmsRecords.get(i)).get("smsType")).equals("接收")) ? 20 : 10));
/* 925 */             clUserMessages.setUserId(userId);
/* 926 */             this.userMessagesMapper.saveShard(tableNameMessage, clUserMessages);
/*     */           }
/*     */           
/* 929 */           Map<String, Object> temp = new HashMap();
/* 930 */           temp.put("userId", userId);
/* 931 */           temp.put("phoneState", "30");
/* 932 */           this.userAuthMapper.updatePhoneState(temp);
/* 933 */           updateMessage(userBaseInfo.getUserId(), tableName, tableContactsName);
/*     */         }
/*     */       } else {
/* 936 */         throw new BussinessException("用户【" + userId + "】运营商认证回调数据与用户数据不匹配");
/*     */       }
/*     */     } else {
/* 939 */       logger.error("用户【" + userId + "】运营商认证异步回调信息没有返回res，处理失败");
/*     */     }
/* 941 */     logger.info("===结束解析运营商数据====");
/*     */   }
/*     */ }


/*impl\OperatorTdBasicServiceImpl.class

 */