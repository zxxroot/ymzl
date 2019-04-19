/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.UserMessages;
/*     */ import com.cashloan.cl.mapper.UserMessagesMapper;
/*     */ import com.cashloan.cl.service.UserMessagesService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*     */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*     */ import java.util.Date;
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
/*     */ @Service("clUserMessagesService")
/*     */ public class UserMessagesServiceImpl
/*     */   extends BaseServiceImpl<UserMessages, Long>
/*     */   implements UserMessagesService
/*     */ {
/*  39 */   private static final Logger logger = LoggerFactory.getLogger(UserMessagesServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UserMessagesMapper clUserMessagesMapper;
/*     */   
/*     */   public BaseMapper<UserMessages, Long> getMapper()
/*     */   {
/*  46 */     return this.clUserMessagesMapper;
/*     */   }
/*     */   
/*     */   public boolean deleteAndSave(List<Map<String, Object>> infos, String userId)
/*     */   {
/*  51 */     int msg = 0;
/*  52 */     String name = null;
/*  53 */     String phone = null;
/*  54 */     boolean flag = false;
/*     */     
/*  56 */     long userid = Long.parseLong(userId);
/*     */     
/*     */ 
/*  59 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_messages", userid, 30000L);
/*  60 */     int countTable = this.clUserMessagesMapper.countTable(tableName);
/*  61 */     if (countTable == 0) {
/*  62 */       this.clUserMessagesMapper.createTable(tableName);
/*     */     }
/*     */     
/*  65 */     this.clUserMessagesMapper.deleteShardByUserId(tableName, userid);
/*  66 */     for (Map<String, Object> map : infos) {
/*  67 */       name = StringUtil.isNull(map.get("name")).replaceAll("(null)", "").replace("()", "");
/*  68 */       phone = StringUtil.isNull(map.get("phone")).replaceAll("-", "").replaceAll(" ", "");
/*  69 */       if ((StringUtil.isNotBlank(name)) && (name.length() <= 20) && (StringUtil.isNotBlank(phone)) && (phone.length() <= 20)) {
/*  70 */         UserMessages clUserMessages = new UserMessages();
/*  71 */         clUserMessages.setName(map.get("name"));
/*  72 */         clUserMessages.setPhone(map.get("phone"));
/*  73 */         clUserMessages.setTime(new Date(Long.parseLong(map.get("time"))));
/*  74 */         clUserMessages.setType(map.get("type"));
/*  75 */         clUserMessages.setUserId(Long.valueOf(Long.parseLong(userId)));
/*  76 */         this.clUserMessagesMapper.saveShard(tableName, clUserMessages);
/*  77 */         msg++;
/*     */       } else {
/*  79 */         logger.error("保存用户userId：" + userId + "短信记录失败，name： " + name + "， phone：" + phone);
/*     */       }
/*     */     }
/*  82 */     if (msg > 0) {
/*  83 */       flag = true;
/*     */     }
/*  85 */     return flag;
/*     */   }
/*     */   
/*     */   public Page<UserMessages> listMessages(long userId, int current, int pageSize)
/*     */   {
/*  90 */     PageHelper.startPage(current, pageSize);
/*  91 */     Map<String, Object> searchMap = new HashMap();
/*  92 */     searchMap.put("userId", Long.valueOf(userId));
/*  93 */     List<UserMessages> list = this.clUserMessagesMapper.listSelective(searchMap);
/*  94 */     for (UserMessages clUserMessages : list) {
/*  95 */       if ("10".equals(clUserMessages.getType())) {
/*  96 */         clUserMessages.setType("发送");
/*     */       } else {
/*  98 */         clUserMessages.setType("接收");
/*     */       }
/*     */     }
/* 101 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Page<UserMessages> findShardPage(long userId, int current, int pageSize)
/*     */   {
/* 108 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_messages", userId, 30000L);
/* 109 */     int countTable = this.clUserMessagesMapper.countTable(tableName);
/* 110 */     if (countTable == 0) {
/* 111 */       this.clUserMessagesMapper.createTable(tableName);
/*     */     }
/* 113 */     PageHelper.startPage(current, pageSize);
/* 114 */     Map<String, Object> params = new HashMap();
/* 115 */     params.put("userId", Long.valueOf(userId));
/* 116 */     List<UserMessages> list = this.clUserMessagesMapper.listShardSelective(tableName, params);
/* 117 */     return (Page)list;
/*     */   }
/*     */ }


/*impl\UserMessagesServiceImpl.class

 */