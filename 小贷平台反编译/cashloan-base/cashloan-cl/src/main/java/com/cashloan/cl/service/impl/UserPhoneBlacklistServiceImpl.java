/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.UserPhoneBlacklist;
/*    */ import com.cashloan.cl.mapper.UserPhoneBlacklistMapper;
/*    */ import com.cashloan.cl.service.UserPhoneBlacklistService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import javax.annotation.Resource;
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
/*    */ @Service("userPhoneBlacklistService")
/*    */ public class UserPhoneBlacklistServiceImpl
/*    */   extends BaseServiceImpl<UserPhoneBlacklist, Long>
/*    */   implements UserPhoneBlacklistService
/*    */ {
/*    */   @Resource
/*    */   private UserPhoneBlacklistMapper userPhoneBlacklistMapper;
/*    */   
/*    */   public BaseMapper<UserPhoneBlacklist, Long> getMapper()
/*    */   {
/* 33 */     return this.userPhoneBlacklistMapper;
/*    */   }
/*    */   
/*    */   public UserPhoneBlacklist getByPhone(String phone)
/*    */   {
/* 38 */     return this.userPhoneBlacklistMapper.getByPhone(phone);
/*    */   }
/*    */ }


/*impl\UserPhoneBlacklistServiceImpl.class

 */