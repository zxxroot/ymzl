/*    */ package com.rongdu.cashloan.core.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.domain.UserOtherInfo;
/*    */ import com.rongdu.cashloan.core.mapper.UserOtherInfoMapper;
/*    */ import com.rongdu.cashloan.core.service.UserOtherInfoService;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ import tool.util.DateUtil;
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
/*    */ @Service("userOtherInfoService")
/*    */ public class UserOtherInfoServiceImpl
/*    */   extends BaseServiceImpl<UserOtherInfo, Long>
/*    */   implements UserOtherInfoService
/*    */ {
/* 36 */   private static final Logger logger = LoggerFactory.getLogger(UserOtherInfoServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private UserOtherInfoMapper userOtherInfoMapper;
/*    */   
/*    */   public UserOtherInfo getInfoByUserId(Long userId)
/*    */   {
/* 43 */     Map<String, Object> paramMap = new HashMap();
/* 44 */     paramMap.put("userId", userId);
/* 45 */     UserOtherInfo otherInfo = null;
/*    */     try {
/* 47 */       otherInfo = (UserOtherInfo)this.userOtherInfoMapper.findSelective(paramMap);
/*    */     } catch (Exception e) {
/* 49 */       logger.error("查询用户userId：" + userId + "其他信息异常", e);
/*    */     }
/* 51 */     return otherInfo;
/*    */   }
/*    */   
/*    */   public boolean save(UserOtherInfo otherInfo)
/*    */   {
/* 56 */     otherInfo.setCreateTime(DateUtil.getNow());
/* 57 */     int result = this.userOtherInfoMapper.save(otherInfo);
/* 58 */     if (result > 0L) {
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public boolean update(UserOtherInfo otherInfo)
/*    */   {
/* 66 */     int result = this.userOtherInfoMapper.update(otherInfo);
/* 67 */     if (result > 0L) {
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public boolean updateSelective(Map<String, Object> paramMap)
/*    */   {
/* 75 */     int result = this.userOtherInfoMapper.updateSelective(paramMap);
/* 76 */     if (result > 0L) {
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public BaseMapper<UserOtherInfo, Long> getMapper()
/*    */   {
/* 85 */     return this.userOtherInfoMapper;
/*    */   }
/*    */ }
