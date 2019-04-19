/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.cashloan.cl.domain.UserEmerContacts;
/*     */ import com.cashloan.cl.mapper.OperatorVoicesMapper;
/*     */ import com.cashloan.cl.mapper.UserContactsMapper;
/*     */ import com.cashloan.cl.mapper.UserEmerContactsMapper;
/*     */ import com.cashloan.cl.service.UserEmerContactsService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ @Service("userEmerContactsService")
/*     */ public class UserEmerContactsServiceImpl
/*     */   extends BaseServiceImpl<UserEmerContacts, Long>
/*     */   implements UserEmerContactsService
/*     */ {
/*  38 */   private static final Logger logger = LoggerFactory.getLogger(UserEmerContactsServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UserEmerContactsMapper userEmerContactsMapper;
/*     */   @Resource
/*     */   private UserContactsMapper userContactsMapper;
/*     */   @Resource
/*     */   private OperatorVoicesMapper operatorVoicesMapper;
/*     */   
/*     */   public BaseMapper<UserEmerContacts, Long> getMapper()
/*     */   {
/*  49 */     return this.userEmerContactsMapper;
/*     */   }
/*     */   
/*     */   public List<UserEmerContacts> getUserEmerContactsByUserId(Map<String, Object> paramMap)
/*     */   {
/*  54 */     return this.userEmerContactsMapper.listSelective(paramMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int updateUserContacts(Long userId)
/*     */   {
/*  63 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId.longValue(), 30000L);
/*  64 */     int countTable = this.userContactsMapper.countTable(tableName);
/*  65 */     if (countTable == 0) {
/*  66 */       this.userContactsMapper.createTable(tableName);
/*     */     }
/*     */     
/*  69 */     Map<String, Object> result = new HashMap();
/*  70 */     result.put("userId", userId);
/*     */     
/*  72 */     List<UserEmerContacts> list = getUserEmerContactsByUserId(result);
/*  73 */     if ((list != null) && (!list.isEmpty())) {
/*  74 */       for (UserEmerContacts bean : list) {
/*  75 */         result.put("phone", bean.getPhone());
/*  76 */         result.put("relation", bean.getRelation());
/*     */         
/*  78 */         this.userContactsMapper.updateVoicesCount(tableName, result);
/*     */       }
/*     */     }
/*  81 */     return list.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateVoiceMessage(String tableName, Map<String, Object> paramMap)
/*     */   {
/*  89 */     if ((tableName == null) || ("".equals(tableName))) {
/*  90 */       tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", Long.valueOf(paramMap.get("userId").toString()).longValue(), 30000L);
/*  91 */       int countTable = this.operatorVoicesMapper.countTable(tableName);
/*  92 */       if (countTable == 0) {
/*  93 */         this.operatorVoicesMapper.createTable(tableName);
/*     */       }
/*     */     }
/*     */     
/*  97 */     List<UserEmerContacts> infoModel = this.userEmerContactsMapper.listSelective(paramMap);
/*  98 */     if ((!infoModel.isEmpty()) && (infoModel != null))
/*     */     {
/* 100 */       for (UserEmerContacts userEmerContacts : infoModel) {
/* 101 */         paramMap.put("phone", userEmerContacts.getPhone());
/* 102 */         Map<String, Object> map = this.operatorVoicesMapper.operatorVoicesCount(tableName, paramMap);
/* 103 */         if (map != null)
/*     */         {
/* 105 */           Long voicesCount = Long.valueOf(String.valueOf(map.get("voices_count")));
/* 106 */           Long voicesHours = Long.valueOf(String.valueOf(map.get("voices_hours")));
/* 107 */           userEmerContacts.setVoicesCount(voicesCount);
/* 108 */           userEmerContacts.setVoicesHours(voicesHours);
/* 109 */           this.userEmerContactsMapper.update(userEmerContacts);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }
