/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.cashloan.cl.domain.YoudunModelLog;
/*    */ import com.cashloan.cl.mapper.YoudunModelLogMapper;
/*    */ import com.cashloan.cl.service.YoudunModelService;
/*    */ import com.cashloan.cl.utils.OcrUdcreditUtils;
/*    */ import com.rongdu.cashloan.core.domain.Borrow;
/*    */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*    */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*    */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class YoudunModelServiceImpl
/*    */   implements YoudunModelService
/*    */ {
/* 27 */   private static final Logger logger = LoggerFactory.getLogger(YoudunModelServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private UserBaseInfoMapper userBaseInfoMapper;
/*    */   
/*    */   @Resource
/*    */   private YoudunModelLogMapper youdunModelLogMapper;
/*    */   
/*    */   public int queryYouDModel(Borrow borrow, TppBusiness business)
/*    */   {
/* 37 */     logger.info("借款id:" + borrow.getId() + "开始进行有盾建模分数查询接口。。。");
/* 38 */     int i = 0;
/* 39 */     UserBaseInfo baseInfo = this.userBaseInfoMapper.findByUserId(borrow.getUserId());
/*    */     
/* 41 */     Map<String, String> map = new HashMap();
/* 42 */     map.put("id_no", baseInfo.getIdNo());
/* 43 */     map.put("id_name", baseInfo.getRealName());
/* 44 */     map.put("mobile", baseInfo.getPhone());
/*    */     try {
/* 46 */       String result = OcrUdcreditUtils.apiCall(map, "M1001002");
/*    */       
/* 48 */       this.youdunModelLogMapper.deleteByUserId(baseInfo.getUserId());
/* 49 */       YoudunModelLog log = new YoudunModelLog();
/* 50 */       log.setUserId(borrow.getUserId());
/* 51 */       log.setCreateTime(new Date());
/* 52 */       log.setRespParams(JSONObject.toJSONString(map));
/* 53 */       if (!StringUtils.isBlank(result)) {
/* 54 */         Map<String, Object> resultMap = JSONObject.parseObject(result);
/* 55 */         Map<String, Object> resMap = JSONObject.parseObject(resultMap.get("header"));
/* 56 */         log.setRespCode(String.valueOf(resMap.get("ret_code")));
/* 57 */         if ("000000".equals(resMap.get("ret_code"))) {
/* 58 */           Map<String, Object> body = JSONObject.parseObject(resultMap.get("body"));
/* 59 */           log.setLoanIndustry(JSONObject.toJSONString(body.get("loan_industry")));
/* 60 */           log.setOrderNo(String.valueOf(body.get("ud_order_no")));
/* 61 */           log.setScore(Integer.valueOf(String.valueOf(body.get("score"))));
/* 62 */           log.setUserDetail(JSONObject.toJSONString(body.get("user_detail")));
/*    */         }
/*    */       }
/* 65 */       logger.info("res" + result);
/* 66 */       i = this.youdunModelLogMapper.save(log);
/*    */     } catch (Exception e) {
/* 68 */       logger.info("请求有盾建模分数查询接口异常：请求参数为：" + JSONObject.toJSONString(map));
/* 69 */       e.printStackTrace();
/*    */     }
/* 71 */     return i;
/*    */   }
/*    */ }
