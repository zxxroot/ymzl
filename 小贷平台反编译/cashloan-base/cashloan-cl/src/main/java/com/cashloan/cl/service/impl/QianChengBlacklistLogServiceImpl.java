/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.service.QianChengBlacklistLogService;
import com.cashloan.cl.domain.QianChengBlacklistLog;
import com.cashloan.cl.mapper.QianChengBlacklistLogMapper;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import com.rongdu.cashloan.core.common.util.QianChengUtil;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.service.UserBaseInfoService;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("qianChengBlacklistLogService")
/*    */ public class QianChengBlacklistLogServiceImpl
/*    */   extends BaseServiceImpl<QianChengBlacklistLog, Long>
/*    */   implements QianChengBlacklistLogService
/*    */ {
/*    */   @Resource
/*    */   private QianChengBlacklistLogMapper qianChengBlacklistLogMapper;
/*    */   @Resource
/*    */   private UserBaseInfoService userBaseInfoService;
/*    */   
/*    */   public int qianchengBlackRequest(Long userId, TppBusiness business)
/*    */   {
/* 48 */     UserBaseInfo baseInfo = this.userBaseInfoService.findByUserId(userId);
/* 49 */     QianChengBlacklistLog qianChengBlacklistLog = new QianChengBlacklistLog();
/* 50 */     qianChengBlacklistLog.setUserId(userId);
/* 51 */     qianChengBlacklistLog.setCreateTime(new Date());
/*    */     
/* 53 */     String result = QianChengUtil.getBalck(baseInfo.getRealName(), baseInfo.getIdNo(), baseInfo.getPhone());
/* 54 */     if ((result != null) && (!result.equals(""))) {
/* 55 */       Map<String, Object> resultMap = JSONObject.parseObject(result);
/* 56 */       String code = resultMap.get("code").toString();
/* 57 */       if (code.equals("0")) {
/* 58 */         qianChengBlacklistLog.setOrderNo(OrderNoUtil.getSerialNumber());
/* 59 */         qianChengBlacklistLog.setRespCode(code);
/* 60 */         qianChengBlacklistLog.setRespParams(result);
/* 61 */         JSONArray array = JSONObject.parseObject(result).getJSONArray("data");
/* 62 */         boolean isBlack = ((Boolean)array.getJSONObject(0).get("is_in")).booleanValue();
/* 63 */         if (isBlack) {
/* 64 */           qianChengBlacklistLog.setIsBlack("1");
/*    */         } else
/* 66 */           qianChengBlacklistLog.setIsBlack("0");
/*    */       } else {
/* 68 */         qianChengBlacklistLog.setRespCode(code);
/* 69 */         qianChengBlacklistLog.setRespParams(String.valueOf(resultMap.get("msg")));
/*    */       }
/*    */     } else {
/* 72 */       qianChengBlacklistLog.setRespParams("第三方请求返回空值，请求参数如下:---username:" + baseInfo.getRealName() + "---id_card:" + baseInfo.getIdNo() + "---mobile" + baseInfo.getPhone() + "---userId:" + 
/* 73 */         userId);
/*    */     }
/* 75 */     return this.qianChengBlacklistLogMapper.save(qianChengBlacklistLog);
/*    */   }
/*    */   
/*    */   public BaseMapper<QianChengBlacklistLog, Long> getMapper()
/*    */   {
/* 80 */     return this.qianChengBlacklistLogMapper;
/*    */   }
/*    */   
/*    */   public void deleteByUserId(Long userId) {
/* 84 */     this.qianChengBlacklistLogMapper.deleteByUserId(userId);
/*    */   }
/*    */   
/*    */   public boolean isBlack(Long userId)
/*    */   {
/* 89 */     Map<String, Object> params = new HashMap();
/* 90 */     params.put("userId", userId);
/* 91 */     params.put("isBlack", Integer.valueOf(1));
/* 92 */     if (this.qianChengBlacklistLogMapper.listSelective(params).size() > 0) {
/* 93 */       return true;
/*    */     }
/* 95 */     return false;
/*    */   }
/*    */ }
