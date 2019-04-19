/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.google.common.base.Optional;
/*    */ import com.cashloan.cl.domain.TaoBao;
/*    */ import com.cashloan.cl.mapper.UserAuthMapper;
/*    */ import com.cashloan.cl.model.zmxy.creditScore.WhiteKnightZhiMaResponse;
/*    */ import com.cashloan.cl.service.TaoBaoService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*    */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.jfree.util.Log;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service("taobaoService")
/*    */ public class TaoBaoServiceImpl
/*    */   extends BaseServiceImpl<TaoBao, Long>
/*    */   implements TaoBaoService
/*    */ {
/* 26 */   private static final Logger logger = LoggerFactory.getLogger(TaoBaoServiceImpl.class);
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private UserAuthMapper userAuthMapper;
/*    */   
/*    */   @Resource
/*    */   private UserBaseInfoMapper userBaseinfoMapper;
/*    */   
/*    */ 
/*    */   public BaseMapper<TaoBao, Long> getMapper()
/*    */   {
/* 38 */     return null;
/*    */   }
/*    */   
/*    */   public void wkzmrCallBack(WhiteKnightZhiMaResponse whiteKnightZhiMaResponse)
/*    */   {
/* 43 */     String mobile = whiteKnightZhiMaResponse.getMobile();
/* 44 */     Map<String, Object> paramMap = new HashMap(1);
/* 45 */     paramMap.put("phone", mobile);
/* 46 */     Log.info("####################TaoBaoServiceImpl.whiteKnightAuthCallBack----taobao######################################" + mobile);
/* 47 */     UserBaseInfo userinfo = (UserBaseInfo)this.userBaseinfoMapper.findSelective(paramMap);
/* 48 */     Log.info("####################TaoBaoServiceImpl.whiteKnightAuthCallBack----taobao######################################" + userinfo);
/* 49 */     if (Optional.fromNullable(userinfo).isPresent()) {
/* 50 */       Long userId = userinfo.getUserId();
/*    */       
/* 52 */       paramMap.clear();
/* 53 */       paramMap.put("userId", userId);
/* 54 */       paramMap.put("taoBaoState", "30");
/* 55 */       int updateCount = this.userAuthMapper.updateByUserId(paramMap);
/* 56 */       if (updateCount != 1) {
/* 57 */         logger.error("用户" + userId + "淘宝认证信息更新出错");
/*    */       }
/* 59 */       paramMap.clear();
/* 60 */       paramMap.put("userId", userId);
/*    */     }
/*    */   }
/*    */ }
