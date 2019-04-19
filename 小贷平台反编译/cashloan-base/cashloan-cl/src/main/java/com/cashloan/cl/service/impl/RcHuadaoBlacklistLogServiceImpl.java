/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.domain.RcHuadaoBlacklistLog;
import com.cashloan.cl.mapper.RcHuadaoBlacklistLogMapper;
import com.cashloan.cl.service.RcHuadaoBlacklistLogService;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.HuaDaoBlackUtil;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.service.UserBaseInfoService;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
/*     */ @Service("rcHuadaoBlacklistLogService")
/*     */ public class RcHuadaoBlacklistLogServiceImpl
/*     */   extends BaseServiceImpl<RcHuadaoBlacklistLog, Long>
/*     */   implements RcHuadaoBlacklistLogService
/*     */ {
/*  42 */   private static final Logger logger = LoggerFactory.getLogger(RcHuadaoBlacklistLogServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private RcHuadaoBlacklistLogMapper rcHuadaoBlacklistLogMapper;
/*     */   @Resource
/*     */   private UserBaseInfoService userBaseInfoService;
/*     */   
/*     */   public BaseMapper<RcHuadaoBlacklistLog, Long> getMapper()
/*     */   {
/*  51 */     return this.rcHuadaoBlacklistLogMapper;
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
/*     */   public int queryHuadaoBlackList(Long userId, TppBusiness business)
/*     */   {
/* 118 */     String APPID = Global.getValue("huadao_black_appId");
/* 119 */     String APPSECRET = Global.getValue("huadao_black_appId_pwd");
/* 120 */     String KEY = Global.getValue("hudao_balck_sdk_key");
/*     */     
/*     */ 
/* 123 */     UserBaseInfo baseInfo = this.userBaseInfoService.findByUserId(userId);
/*     */     
/* 125 */     String result = HuaDaoBlackUtil.getIsBlack(APPID, APPSECRET, KEY, baseInfo.getPhone());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 130 */     RcHuadaoBlacklistLog rcHuadaoBlacklistLog = new RcHuadaoBlacklistLog();
/* 131 */     rcHuadaoBlacklistLog.setCreateTime(new Date());
/* 132 */     rcHuadaoBlacklistLog.setUserId(userId);
/* 133 */     if ((result != null) && (!result.equals(""))) {
/* 134 */       Map<String, Object> resultMap = JSONObject.parseObject(result);
/* 135 */       String code = resultMap.get("CODE").toString();
/* 136 */       if (code.equals("200")) {
/* 137 */         rcHuadaoBlacklistLog.setOrderNo(OrderNoUtil.getSerialNumber());
/* 138 */         rcHuadaoBlacklistLog.setRespCode(code);
/* 139 */         rcHuadaoBlacklistLog.setRespParams(result);
/* 140 */         String black = resultMap.get("IS_BLACK").toString();
/* 141 */         if ("".equals(black)) {
/* 142 */           rcHuadaoBlacklistLog.setIsBlack("0");
/*     */         } else
/* 144 */           rcHuadaoBlacklistLog.setIsBlack("1");
/*     */       } else {
/* 146 */         rcHuadaoBlacklistLog.setRespCode(code);
/* 147 */         rcHuadaoBlacklistLog.setRespParams(resultMap.get("message").toString());
/*     */       }
/*     */     } else {
/* 150 */       rcHuadaoBlacklistLog.setRespParams("第三方请求返回空值，请求参数如下:---APPID:" + APPID + "---APPSECRET:" + APPSECRET + "---KEY" + KEY + "---userId:" + 
/* 151 */         userId + "---phone:" + baseInfo.getPhone());
/*     */     }
/* 153 */     return this.rcHuadaoBlacklistLogMapper.save(rcHuadaoBlacklistLog);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int queryHuadaoBlackList(String phone, TppBusiness business)
/*     */   {
/* 160 */     String APPID = Global.getValue("huadao_black_appId");
/* 161 */     String APPSECRET = Global.getValue("huadao_black_appId_pwd");
/* 162 */     String KEY = Global.getValue("hudao_balck_sdk_key");
/*     */     
/*     */ 
/* 165 */     String result = HuaDaoBlackUtil.getIsBlack(APPID, APPSECRET, KEY, phone);
/* 166 */     RcHuadaoBlacklistLog rcHuadaoBlacklistLog = new RcHuadaoBlacklistLog();
/* 167 */     rcHuadaoBlacklistLog.setCreateTime(new Date());
/* 168 */     rcHuadaoBlacklistLog.setUserId(null);
/* 169 */     rcHuadaoBlacklistLog.setPhone(phone);
/* 170 */     if ((result != null) && (!result.equals(""))) {
/* 171 */       Map<String, Object> resultMap = JSONObject.parseObject(result);
/* 172 */       String code = resultMap.get("CODE").toString();
/* 173 */       if (code.equals("200")) {
/* 174 */         rcHuadaoBlacklistLog.setOrderNo(OrderNoUtil.getSerialNumber());
/* 175 */         rcHuadaoBlacklistLog.setRespCode(code);
/* 176 */         rcHuadaoBlacklistLog.setRespParams(result);
/* 177 */         String black = resultMap.get("IS_BLACK").toString();
/* 178 */         if ("".equals(black)) {
/* 179 */           rcHuadaoBlacklistLog.setIsBlack("0");
/*     */         } else
/* 181 */           rcHuadaoBlacklistLog.setIsBlack("1");
/*     */       } else {
/* 183 */         rcHuadaoBlacklistLog.setRespCode(code);
/* 184 */         rcHuadaoBlacklistLog.setRespParams(resultMap.get("message").toString());
/*     */       }
/*     */     } else {
/* 187 */       rcHuadaoBlacklistLog.setRespParams("第三方请求返回空值，请求参数如下:---APPID:" + APPID + "---APPSECRET:" + APPSECRET + "---KEY" + KEY + "---phone:" + phone);
/*     */     }
/* 189 */     return this.rcHuadaoBlacklistLogMapper.save(rcHuadaoBlacklistLog);
/*     */   }
/*     */   
/*     */   public void deleteByUserId(Long userId)
/*     */   {
/* 194 */     this.rcHuadaoBlacklistLogMapper.deleteByUserId(userId);
/*     */   }
/*     */   
/*     */ 
/*     */   public void deleteByPhone(String phone)
/*     */   {
/* 200 */     this.rcHuadaoBlacklistLogMapper.deleteByPhone(phone);
/*     */   }
/*     */   
/*     */   public List<RcHuadaoBlacklistLog> listService(Map<String, Object> params)
/*     */   {
/* 205 */     return this.rcHuadaoBlacklistLogMapper.listSelective(params);
/*     */   }
/*     */   
/*     */   public boolean isBlack(Long userId)
/*     */   {
/* 210 */     Map<String, Object> params = new HashMap();
/* 211 */     params.put("userId", userId);
/* 212 */     params.put("isBlack", Integer.valueOf(1));
/* 213 */     if (this.rcHuadaoBlacklistLogMapper.listSelective(params).size() > 0) {
/* 214 */       return true;
/*     */     }
/* 216 */     return false;
/*     */   }
/*     */ }


/*impl\RcHuadaoBlacklistLogServiceImpl.class

 */