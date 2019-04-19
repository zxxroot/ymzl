/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*    */ import com.rongdu.cashloan.core.domain.User;
/*    */ import com.rongdu.cashloan.core.mapper.UserMapper;
/*    */ import com.rongdu.cashloan.rc.domain.ContactCount;
/*    */ import com.rongdu.cashloan.rc.mapper.ContactCountMapper;
/*    */ import com.rongdu.cashloan.rc.mapper.RcUserContactsCountMapper;
/*    */ import com.rongdu.cashloan.rc.service.ContactCountService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ 
/*    */ @Service("contactCountService")
/*    */ public class ContactCountServiceImpl
/*    */   extends BaseServiceImpl<ContactCount, Long>
/*    */   implements ContactCountService
/*    */ {
/* 42 */   private static final Logger logger = LoggerFactory.getLogger(ContactCountServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private ContactCountMapper contactCountMapper;
/*    */   @Resource
/*    */   private UserMapper userMapper;
/*    */   @Resource
/*    */   private RcUserContactsCountMapper rcUserContactsCountMapper;
/*    */   
/*    */   public BaseMapper<ContactCount, Long> getMapper()
/*    */   {
/* 53 */     return this.contactCountMapper;
/*    */   }
/*    */   
/*    */   public int countContacts(Long userId) {
/* 57 */     Map<String, Object> params = new HashMap();
/* 58 */     params.put("userId", userId);
/* 59 */     params.put("tableName", ShardTableUtil.generateTableNameById("cl_user_contacts", userId.longValue(), 30000L));
/* 60 */     ContactCount cc = new ContactCount();
/* 61 */     cc.setUserId(userId);
/* 62 */     cc.setCount(this.rcUserContactsCountMapper.count(params));
/* 63 */     cc.setCountOne(this.rcUserContactsCountMapper.countSucceed(params));
/* 64 */     cc.setCountTwo(this.rcUserContactsCountMapper.countFail(params));
/* 65 */     cc.setCountThree(this.rcUserContactsCountMapper.countNinety(params));
/* 66 */     cc.setCountFour(this.rcUserContactsCountMapper.countThirty(params));
/* 67 */     cc.setCountFive(this.rcUserContactsCountMapper.countWithinThirty(params));
/* 68 */     cc.setCreateTime(DateUtil.getNow());
/* 69 */     return this.contactCountMapper.save(cc);
/*    */   }
/*    */   
/*    */   public int save()
/*    */   {
/* 74 */     int msg = 0;
/* 75 */     Map<String, Object> paramMap = new HashMap();
/* 76 */     List<User> list = this.userMapper.listSelective(paramMap);
/* 77 */     ContactCount cc = new ContactCount();
/*    */     
/* 79 */     for (User user : list) {
/* 80 */       Map<String, Object> params = new HashMap();
/* 81 */       params.put("userId", user.getId());
/* 82 */       params.put("tableName", ShardTableUtil.generateTableNameById("cl_user_contacts", user.getId().longValue(), 30000L));
/* 83 */       cc.setUserId(user.getId());
/* 84 */       cc.setCount(this.rcUserContactsCountMapper.count(params));
/* 85 */       cc.setCountOne(this.rcUserContactsCountMapper.countSucceed(params));
/* 86 */       cc.setCountTwo(this.rcUserContactsCountMapper.countFail(params));
/* 87 */       cc.setCountThree(this.rcUserContactsCountMapper.countNinety(params));
/* 88 */       cc.setCountFour(this.rcUserContactsCountMapper.countThirty(params));
/* 89 */       cc.setCountFive(this.rcUserContactsCountMapper.countWithinThirty(params));
/* 90 */       cc.setCreateTime(DateUtil.getNow());
/* 91 */       msg = this.contactCountMapper.save(cc);
/*    */     }
/* 93 */     return msg;
/*    */   }
/*    */ }
