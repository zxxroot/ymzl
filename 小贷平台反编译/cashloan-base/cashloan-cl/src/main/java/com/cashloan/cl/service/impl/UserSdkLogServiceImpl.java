/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.cashloan.cl.domain.UserSdkLog;
/*    */ import com.cashloan.cl.mapper.UserSdkLogMapper;
/*    */ import com.cashloan.cl.service.UserSdkLogService;
/*    */ import com.rongdu.cashloan.core.common.context.Global;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
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
/*    */ @Service("userSdkLogService")
/*    */ public class UserSdkLogServiceImpl
/*    */   extends BaseServiceImpl<UserSdkLog, Long>
/*    */   implements UserSdkLogService
/*    */ {
/* 35 */   private static final Logger logger = LoggerFactory.getLogger(UserSdkLogServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private UserSdkLogMapper userSdkLogMapper;
/*    */   
/*    */   public BaseMapper<UserSdkLog, Long> getMapper()
/*    */   {
/* 42 */     return this.userSdkLogMapper;
/*    */   }
/*    */   
/*    */   public Map<String, Object> countDayTime(Map<String, Object> searchMap)
/*    */   {
/* 47 */     String sdk = Global.getValue("sdk_time");
/* 48 */     int faceTimes = JSONObject.parseObject(sdk).getIntValue("faceTime");
/* 49 */     int ocrTimes = JSONObject.parseObject(sdk).getIntValue("ocrTime");
/* 50 */     searchMap.put("timeType", "10");
/* 51 */     int faceTime = this.userSdkLogMapper.countDayTime(searchMap);
/* 52 */     searchMap.put("timeType", "20");
/* 53 */     int ocrTime = this.userSdkLogMapper.countDayTime(searchMap);
/* 54 */     Map<String, Object> times = new HashMap();
/* 55 */     times.put("faceTime", Integer.valueOf(faceTimes - faceTime < 0 ? 0 : faceTimes - faceTime));
/* 56 */     times.put("ocrTime", Integer.valueOf(ocrTimes - ocrTime < 0 ? 0 : ocrTimes - ocrTime));
/* 57 */     return times;
/*    */   }
/*    */   
/*    */   public int save(UserSdkLog usl)
/*    */   {
/* 62 */     return this.userSdkLogMapper.save(usl);
/*    */   }
/*    */ }
