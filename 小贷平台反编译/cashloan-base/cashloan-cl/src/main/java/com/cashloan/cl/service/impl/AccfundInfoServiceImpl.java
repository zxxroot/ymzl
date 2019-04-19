/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.domain.AccfundInfo;
import com.cashloan.cl.domain.AccfundLog;
import com.cashloan.cl.mapper.AccfundInfoMapper;
import com.cashloan.cl.mapper.AccfundLogMapper;
import com.cashloan.cl.mapper.UserAuthMapper;
import com.cashloan.cl.service.AccfundInfoService;
import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.StringUtil;

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
/*     */ 
/*     */ @Service("accfundInfoService")
/*     */ public class AccfundInfoServiceImpl
/*     */   extends BaseServiceImpl<AccfundInfo, Long>
/*     */   implements AccfundInfoService
/*     */ {
/*  43 */   private static final Logger logger = LoggerFactory.getLogger(AccfundInfoServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private AccfundInfoMapper accfundInfoMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private AccfundLogMapper accfundLogMapper;
/*     */   @Resource
/*     */   private UserAuthMapper userAuthMapper;
/*     */   
/*     */   public BaseMapper<AccfundInfo, Long> getMapper()
/*     */   {
/*  56 */     return this.accfundInfoMapper;
/*     */   }
/*     */   
/*     */   public void saveAccfundInfos(String res, Long userId, Date createTime)
/*     */   {
/*  61 */     if (StringUtil.isNotBlank(res)) {
/*  62 */       Map<String, Object> resJson = JSONObject.parseObject(res);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  70 */       AccfundInfo accfundInfo = null;
/*  71 */       String basic_info = String.valueOf(resJson.get("basic_info_house_accumulation_fund_type_id"));
/*  72 */       if (StringUtil.isNotBlank(basic_info)) {
/*  73 */         List<AccfundInfo> infoList = JSONObject.parseArray(basic_info, AccfundInfo.class);
/*  74 */         if ((infoList != null) && (!infoList.isEmpty())) {
/*  75 */           accfundInfo = (AccfundInfo)infoList.get(0);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  80 */       if (accfundInfo != null) {
/*  81 */         accfundInfo.setUserId(userId);
/*  82 */         accfundInfo.setCreateTime(createTime);
/*  83 */         insert(accfundInfo);
/*  84 */         String detailInfos = String.valueOf(resJson.get("detail_info_house_accumulation_fund_type_id"));
/*  85 */         if (StringUtil.isNotBlank(detailInfos)) {
/*  86 */           List<AccfundLog> accfundLogs = JSONObject.parseArray(detailInfos, AccfundLog.class);
/*  87 */           if ((accfundLogs != null) && (accfundLogs.size() > 0)) {
/*  88 */             for (AccfundLog accfundLog : accfundLogs) {
/*  89 */               accfundLog.setUserId(userId);
/*  90 */               accfundLog.setCreateTime(createTime);
/*  91 */               this.accfundLogMapper.save(accfundLog);
/*     */             }
/*     */           }
/*     */         }
/*  95 */         Map<String, Object> userAuth = new HashMap();
/*  96 */         userAuth.put("userId", userId);
/*  97 */         userAuth.put("accFundState", "30");
/*  98 */         this.userAuthMapper.updateByUserId(userAuth);
/*  99 */         logger.info("公积金异步回调，userId:" + userId + "，成功将userAuth.accFundState的状态改为20");
/*     */       } else {
/* 101 */         throw new BussinessException("回调数据与用户数据不匹配,回调数据" + res);
/*     */       }
/*     */     } else {
/* 104 */       logger.equals("用户【" + userId + "】公积金认证异步回调信息没有返回res，处理失败");
/*     */     }
/*     */   }
/*     */ }
