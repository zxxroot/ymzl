/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.google.common.base.Optional;
/*     */ import com.cashloan.cl.domain.Zhima;
/*     */ import com.cashloan.cl.mapper.BankCardMapper;
/*     */ import com.cashloan.cl.mapper.RcZhimaAntiFraudMapper;
/*     */ import com.cashloan.cl.mapper.RcZhimaIndustryMapper;
/*     */ import com.cashloan.cl.mapper.UserAuthMapper;
/*     */ import com.cashloan.cl.mapper.ZhimaMapper;
/*     */ import com.cashloan.cl.model.zmxy.authorize.AuthCallBack;
/*     */ import com.cashloan.cl.model.zmxy.authorize.AuthCallBackResp;
/*     */ import com.cashloan.cl.model.zmxy.base.ZmQueryCreator;
/*     */ import com.cashloan.cl.model.zmxy.creditScore.WhiteKnightZhiMaResponse;
/*     */ import com.cashloan.cl.model.zmxy.creditScore.WhiteKnightZhiMaResult;
/*     */ import com.cashloan.cl.model.zmxy.creditScore.WhiteKnightZhiMaResult.ZmDetail;
/*     */ import com.cashloan.cl.model.zmxy.creditScore.WhiteKnightZhiMaResult.ZmDetailInfo;
/*     */ import com.cashloan.cl.model.zmxy.creditScore.ZmScoreQuery;
/*     */ import com.cashloan.cl.model.zmxy.creditScore.ZmScoreResp;
/*     */ import com.cashloan.cl.monitor.BusinessExceptionMonitor;
/*     */ import com.cashloan.cl.service.ZhimaService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.HttpUtil;
/*     */ import com.rongdu.cashloan.core.common.util.OrderNoUtil;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import tool.util.DateUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("zhimaService")
/*     */ public class ZhimaServiceImpl
/*     */   extends BaseServiceImpl<Zhima, Long>
/*     */   implements ZhimaService
/*     */ {
/*  49 */   private static final Logger logger = LoggerFactory.getLogger(ZhimaServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private ZhimaMapper zhimaMapper;
/*     */   
/*     */   @Resource
/*     */   private UserAuthMapper userAuthMapper;
/*     */   
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseinfoMapper;
/*     */   
/*     */   @Resource
/*     */   private BankCardMapper bankCardMapper;
/*     */   
/*     */   @Resource
/*     */   private RcZhimaAntiFraudMapper rcZhimaAntiFraudMapper;
/*     */   
/*     */   @Resource
/*     */   private RcZhimaIndustryMapper rcZhimaIndustryMapper;
/*     */   
/*     */   public BaseMapper<Zhima, Long> getMapper()
/*     */   {
/*  71 */     return this.zhimaMapper;
/*     */   }
/*     */   
/*     */   public Zhima getZhima(Map<String, Object> paramMap)
/*     */   {
/*  76 */     return (Zhima)this.zhimaMapper.findSelective(paramMap);
/*     */   }
/*     */   
/*     */   @Transactional(rollbackFor={Exception.class})
/*     */   public Map<String, Object> authCallBack(String params, User user) throws Exception
/*     */   {
/*  82 */     Map<String, Object> result = new HashMap();
/*  83 */     ZmQueryCreator zmQueryCreator = new ZmQueryCreator();
/*  84 */     ZmScoreQuery zmScoreQuery = (ZmScoreQuery)zmQueryCreator.create(ZmScoreQuery.class);
/*  85 */     AuthCallBack authCallBack = (AuthCallBack)zmQueryCreator.create(AuthCallBack.class);
/*  86 */     AuthCallBackResp authCallBackResp = authCallBack.decryptedParam(params);
/*  87 */     if (authCallBackResp.isSuccess()) {
/*  88 */       Long userId = Long.valueOf(authCallBackResp.getKey());
/*     */       
/*  90 */       Map<String, Object> paramMap = new HashMap();
/*  91 */       paramMap.put("userId", userId);
/*  92 */       paramMap.put("zhimaState", "30");
/*  93 */       int updateCount = this.userAuthMapper.updateByUserId(paramMap);
/*  94 */       if (updateCount != 1) {
/*  95 */         logger.error("用户" + userId + "认证信息更新出错");
/*  96 */         result.put("code", Integer.valueOf(400));
/*  97 */         result.put("msg", "认证信息更新出错");
/*  98 */         return result;
/*     */       }
/* 100 */       String zmScore = "0";
/* 101 */       paramMap.clear();
/* 102 */       paramMap.put("userId", userId);
/*     */       
/* 104 */       if (this.zhimaMapper.findSelective(paramMap) == null) {
/* 105 */         Zhima zhima = new Zhima();
/* 106 */         zhima.setBind("20");
/* 107 */         zhima.setBindTime(new Date(System.currentTimeMillis()));
/* 108 */         zhima.setUserId(userId);
/* 109 */         zhima.setScore(Double.valueOf(0.0D));
/* 110 */         zhima.setOpenId(authCallBackResp.getOpenId());
/* 111 */         int count = this.zhimaMapper.save(zhima);
/* 112 */         if (count != 1) {
/* 113 */           logger.error("用户" + userId + "芝麻信用信息保存出错");
/* 114 */           result.put("code", Integer.valueOf(400));
/* 115 */           result.put("msg", "芝麻信用信息保存出错");
/* 116 */           return result;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 124 */       String time = Long.toString(Calendar.getInstance().getTimeInMillis());
/* 125 */       String transactionId = DateUtil.dateStr(DateUtil.getNow(), "yyyyMMddHHmmssSSS") + time;
/* 126 */       ZmScoreResp zmScoreResp = zmScoreQuery.queryScore(authCallBackResp.getOpenId(), transactionId);
/* 127 */       if (zmScoreResp.isSuccess()) {
/* 128 */         paramMap.clear();
/* 129 */         paramMap.put("userId", userId);
/*     */         
/* 131 */         Zhima zhima = (Zhima)this.zhimaMapper.findSelective(paramMap);
/* 132 */         zhima.setBindTime(new Date(System.currentTimeMillis()));
/* 133 */         zhima.setScore(Double.valueOf(zmScoreResp.getZmScore()));
/* 134 */         if (this.zhimaMapper.update(zhima) != 1) {
/* 135 */           logger.error("用户" + userId + "芝麻信用信息更新出错");
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 140 */         zmScore = zmScoreResp.getZmScore();
/*     */       } else {
/* 142 */         logger.error("用户" + userId + "获取积分出错:" + zmScoreResp.getErrorMessage());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 147 */       result.put("zmScore", zmScore);
/* 148 */       result.put("code", Integer.valueOf(200));
/* 149 */       result.put("msg", "授权成功");
/*     */     } else {
/* 151 */       result.put("code", Integer.valueOf(400));
/* 152 */       result.put("msg", authCallBackResp.getErrorMessage());
/* 153 */       logger.error("获取芝麻信息出错" + authCallBackResp.getErrorMessage());
/*     */     }
/* 155 */     return result;
/*     */   }
/*     */   
/*     */   public int updateZhimaScore(Long userId) {
/* 159 */     int update = 0;
/* 160 */     Map<String, Object> searchMap = new HashMap();
/* 161 */     searchMap.put("userId", userId);
/* 162 */     Zhima zm = (Zhima)this.zhimaMapper.findSelective(searchMap);
/* 163 */     if (zm != null) {
/* 164 */       String value = Global.getValue("zhima_model_switch");
/* 165 */       if ((StringUtils.isNotBlank(value)) && (StringUtils.equalsIgnoreCase(value, "1"))) {
/* 166 */         Map<String, Object> paramMap = new HashMap(1);
/* 167 */         paramMap.put("userId", userId);
/* 168 */         UserBaseInfo userinfo = (UserBaseInfo)this.userBaseinfoMapper.findSelective(paramMap);
/* 169 */         WhiteKnightZhiMaResponse whiteKnightZhiMaResponse = new WhiteKnightZhiMaResponse();
/* 170 */         whiteKnightZhiMaResponse.setCertNo(userinfo.getIdNo());
/* 171 */         whiteKnightZhiMaResponse.setMobile(userinfo.getPhone());
/* 172 */         whiteKnightZhiMaResponse.setName(userinfo.getRealName());
/* 173 */         return saveZmScore(whiteKnightZhiMaResponse, paramMap, userinfo);
/*     */       }
/*     */       
/* 176 */       String time = Long.toString(Calendar.getInstance().getTimeInMillis());
/* 177 */       String transactionId = DateUtil.dateStr(DateUtil.getNow(), "yyyyMMddHHmmssSSS") + time;
/* 178 */       ZmQueryCreator zmQueryCreator = new ZmQueryCreator();
/* 179 */       ZmScoreQuery zmScoreQuery = (ZmScoreQuery)zmQueryCreator.create(ZmScoreQuery.class);
/* 180 */       logger.info("征信数据查询 - 芝麻分，用户：" + userId + "，openId：" + zm.getOpenId());
/* 181 */       ZmScoreResp zmScoreResp = zmScoreQuery.queryScore(zm.getOpenId(), transactionId);
/*     */       
/* 183 */       if ((zmScoreResp != null) && (zmScoreResp.isSuccess())) {
/* 184 */         Map<String, Object> paramMap = new HashMap();
/* 185 */         paramMap.put("score", Double.valueOf(zmScoreResp.getZmScore()));
/* 186 */         paramMap.put("bindTime", new Date(System.currentTimeMillis()));
/* 187 */         paramMap.put("id", zm.getId());
/* 188 */         update = this.zhimaMapper.updateSelective(paramMap);
/* 189 */         logger.info("征信数据获取-查询芝麻分userId:" + userId + "，更新数据条数:" + update);
/* 190 */       } else if ((zmScoreResp != null) && ("ZMCREDIT.authentication_fail".equals(zmScoreResp.getErrorCode())))
/*     */       {
/* 192 */         String message = zmScoreResp.getErrorMessage();
/* 193 */         BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_1, userId, message);
/*     */         
/* 195 */         logger.info("征信数据获取-查询芝麻分userId:" + userId + "，获取积分出错:" + message);
/*     */         
/* 197 */         Map<String, Object> userAuthMap = new HashMap();
/* 198 */         userAuthMap.put("userId", userId);
/* 199 */         userAuthMap.put("zhimaState", "10");
/* 200 */         this.userAuthMapper.updateByUserId(userAuthMap);
/*     */         
/* 202 */         Map<String, Object> paramMap = new HashMap();
/* 203 */         paramMap.put("score", Integer.valueOf(350));
/* 204 */         paramMap.put("bindTime", new Date(System.currentTimeMillis()));
/* 205 */         paramMap.put("id", zm.getId());
/* 206 */         update = this.zhimaMapper.updateSelective(paramMap);
/*     */       } else {
/* 208 */         String message = zmScoreResp.getErrorMessage();
/* 209 */         BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_1, userId, message);
/*     */         
/* 211 */         logger.info("征信数据获取-查询芝麻分userId:" + userId + "，获取积分出错:" + message);
/* 212 */         Map<String, Object> paramMap = new HashMap();
/* 213 */         paramMap.put("bindTime", new Date(System.currentTimeMillis()));
/* 214 */         paramMap.put("id", zm.getId());
/* 215 */         update = this.zhimaMapper.updateSelective(paramMap);
/*     */       }
/*     */     }
/*     */     
/* 219 */     return update;
/*     */   }
/*     */   
/*     */   @Transactional(rollbackFor={Exception.class})
/*     */   public void wkzmrCallBack(WhiteKnightZhiMaResponse whiteKnightZhiMaResponse)
/*     */   {
/* 225 */     if (!Optional.fromNullable(whiteKnightZhiMaResponse).isPresent())
/* 226 */       return;
/* 227 */     String mobile = whiteKnightZhiMaResponse.getMobile();
/* 228 */     Map<String, Object> paramMap = new HashMap(1);
/* 229 */     paramMap.put("phone", mobile);
/* 230 */     UserBaseInfo userinfo = (UserBaseInfo)this.userBaseinfoMapper.findSelective(paramMap);
/* 231 */     saveZmScore(whiteKnightZhiMaResponse, paramMap, userinfo);
/*     */   }
/*     */   
/*     */   private int saveZmScore(WhiteKnightZhiMaResponse whiteKnightZhiMaResponse, Map<String, Object> paramMap, UserBaseInfo userinfo)
/*     */   {
/* 236 */     if (Optional.fromNullable(userinfo).isPresent()) {
/* 237 */       String url = Global.getValue("credit_zm_addr");
/* 238 */       String partnerId = Global.getValue("white_knight_merno");
/* 239 */       String verifyKey = Global.getValue("white_knight_verifyKey");
/* 240 */       String certNo = whiteKnightZhiMaResponse.getCertNo();
/* 241 */       String name = whiteKnightZhiMaResponse.getName();
/*     */       
/* 243 */       Map<String, Object> data = new HashMap();
/* 244 */       data.put("partnerId", partnerId);
/* 245 */       data.put("verifyKey", verifyKey);
/* 246 */       data.put("certNo", certNo);
/* 247 */       data.put("mobile", whiteKnightZhiMaResponse.getMobile());
/* 248 */       data.put("name", name);
/* 249 */       WhiteKnightZhiMaResult wkzm = (WhiteKnightZhiMaResult)HttpUtil.postClient4Obj(url, JSON.toJSONString(data), WhiteKnightZhiMaResult.class);
/* 250 */       if (Optional.fromNullable(wkzm).isPresent()) {
/* 251 */         String msgCode = wkzm.getResultCode();
/* 252 */         if ((StringUtils.isNotBlank(msgCode)) && (StringUtils.equalsIgnoreCase("CCOM1000", msgCode))) {
/* 253 */           Long userId = userinfo.getUserId();
/*     */           
/* 255 */           paramMap.clear();
/* 256 */           paramMap.put("userId", userId);
/* 257 */           paramMap.put("zhimaState", "30");
/* 258 */           int updateCount = this.userAuthMapper.updateByUserId(paramMap);
/* 259 */           if (updateCount != 1) {
/* 260 */             logger.error("用户" + userId + "芝麻信用认证信息更新出错");
/* 261 */             return updateCount;
/*     */           }
/* 263 */           paramMap.clear();
/* 264 */           paramMap.put("userId", userId);
/*     */           
/* 266 */           Zhima zm = (Zhima)this.zhimaMapper.findSelective(paramMap);
/* 267 */           if (zm == null) {
/* 268 */             Zhima zhima = new Zhima();
/* 269 */             zhima.setBind("20");
/* 270 */             zhima.setBindTime(new Date(System.currentTimeMillis()));
/* 271 */             zhima.setUserId(userId);
/* 272 */             zhima.setScore(new Double(wkzm.getData().getZmDetailInfo().getZmScore()));
/* 273 */             zhima.setOpenId(OrderNoUtil.getSerialNumber());
/* 274 */             int count = this.zhimaMapper.save(zhima);
/* 275 */             if (count != 1) {
/* 276 */               logger.error("用户" + userId + "芝麻信用信息保存出错");
/* 277 */               return count;
/*     */             }
/*     */           } else {
/* 280 */             Map<String, Object> parm = new HashMap();
/* 281 */             parm.put("score", new Double(wkzm.getData().getZmDetailInfo().getZmScore()));
/* 282 */             parm.put("bindTime", new Date(System.currentTimeMillis()));
/* 283 */             parm.put("id", zm.getId());
/* 284 */             return this.zhimaMapper.updateSelective(parm);
/*     */           }
/*     */         } else {
/* 287 */           logger.error("白骑士芝麻授信失败：" + JSON.toJSONString(wkzm));
/*     */         }
/*     */       }
/*     */     }
/* 291 */     return 0;
/*     */   }
/*     */   
/*     */   public Zhima findByUserId(Long userId)
/*     */   {
/* 296 */     Map<String, Object> paramMap = new HashMap();
/* 297 */     paramMap.put("userId", userId);
/* 298 */     return (Zhima)this.zhimaMapper.findSelective(paramMap);
/*     */   }
/*     */ }


/*impl\ZhimaServiceImpl.class

 */