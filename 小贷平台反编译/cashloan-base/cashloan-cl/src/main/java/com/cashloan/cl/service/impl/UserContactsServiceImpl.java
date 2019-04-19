/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.UserContacts;
/*     */ import com.cashloan.cl.mapper.OperatorVoicesMapper;
/*     */ import com.cashloan.cl.mapper.UserContactsMapper;
/*     */ import com.cashloan.cl.mapper.UserEmerContactsMapper;
/*     */ import com.cashloan.cl.service.OperatorVoicesService;
/*     */ import com.cashloan.cl.service.UserContactsService;
/*     */ import com.cashloan.cl.service.UserEmerContactsService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*     */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ @Service("clUserContactsService")
/*     */ public class UserContactsServiceImpl
/*     */   extends BaseServiceImpl<UserContacts, Long>
/*     */   implements UserContactsService
/*     */ {
/*  48 */   private static final Logger logger = LoggerFactory.getLogger(UserContactsServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UserContactsMapper userContactsMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private UserEmerContactsMapper userEmerContactsMapper;
/*     */   @Resource
/*     */   private OperatorVoicesMapper operatorVoicesMapper;
/*     */   @Resource
/*     */   private OperatorVoicesService operatorVoicesService;
/*     */   @Resource
/*     */   private UserEmerContactsService userEmerContactsService;
/*     */   
/*     */   public BaseMapper<UserContacts, Long> getMapper()
/*     */   {
/*  65 */     return this.userContactsMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<UserContacts> listContacts(long userId, int current, int pageSize)
/*     */   {
/*  71 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId, 30000L);
/*  72 */     int countTable = this.userContactsMapper.countTable(tableName);
/*  73 */     if (countTable == 0) {
/*  74 */       this.userContactsMapper.createTable(tableName);
/*     */     }
/*     */     
/*  77 */     PageHelper.startPage(current, pageSize);
/*  78 */     Map<String, Object> params = new HashMap();
/*  79 */     params.put("userId", Long.valueOf(userId));
/*  80 */     List<UserContacts> list = this.userContactsMapper.listShardSelective(tableName, params);
/*  81 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public boolean deleteAndSave(List<Map<String, Object>> infos, String userId)
/*     */   {
/*  86 */     int msg = 0;
/*  87 */     String name = null;
/*  88 */     String phone = null;
/*  89 */     boolean flag = false;
/*     */     
/*  91 */     long userid = Long.parseLong(userId);
/*     */     
/*  93 */     UserBaseInfo info = this.userBaseInfoMapper.findByUserId(Long.valueOf(userid));
/*     */     
/*     */ 
/*  96 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_contacts", userid, 30000L);
/*  97 */     int countTable = this.userContactsMapper.countTable(tableName);
/*  98 */     if (countTable == 0) {
/*  99 */       this.userContactsMapper.createTable(tableName);
/*     */     }
/*     */     
/*     */ 
/* 103 */     String tableOperaName = ShardTableUtil.generateTableNameById("cl_operator_voices", userid, 30000L);
/* 104 */     int countOperaTable = this.operatorVoicesMapper.countTable(tableOperaName);
/* 105 */     if (countOperaTable == 0) {
/* 106 */       this.operatorVoicesMapper.createTable(tableOperaName);
/*     */     }
/*     */     
/* 109 */     for (Map<String, Object> map : infos) {
/* 110 */       logger.debug("保存用户userId：" + userId + "通讯录，name：" + StringUtil.isNull(map.get("name")) + "，phone：" + StringUtil.isNull(map.get("phone")));
/* 111 */       name = StringUtil.isNull(map.get("name")).replaceAll("(null)", "").replace("()", "");
/* 112 */       phone = StringUtil.isNull(map.get("phone")).replaceAll("-", "").replaceAll(" ", "");
/* 113 */       logger.debug("保存用户userId：" + userId + "通讯录，name___：" + name + "，phone___：" + phone);
/* 114 */       if ((StringUtil.isNotBlank(name)) && (name.length() <= 20) && (StringUtil.isNotBlank(phone)) && (phone.length() <= 20)) {
/*     */         try {
/* 116 */           UserContacts userContacts = new UserContacts();
/* 117 */           userContacts.setUserId(Long.valueOf(userid));
/* 118 */           userContacts.setName(replaceEmoji(name));
/* 119 */           userContacts.setPhone(phone);
/*     */           
/* 121 */           if (phone.equals(info.getPhone())) {
/* 122 */             userContacts.setRelation("本人");
/*     */           }
/*     */           
/* 125 */           HashMap<String, Object> paramMap = new HashMap();
/* 126 */           paramMap.put("userId", Long.valueOf(userid));
/*     */           
/*     */ 
/* 129 */           Map<String, Object> list = this.operatorVoicesMapper.operatorVoicesCount(tableOperaName, paramMap);
/* 130 */           if (list != null) {
/* 131 */             Long voicesCount = Long.valueOf(Long.parseLong(String.valueOf(list.get("voices_count"))));
/* 132 */             userContacts.setVoicesCount(voicesCount);
/*     */           }
/* 134 */           msg = this.userContactsMapper.saveShard(tableName, userContacts);
/*     */         } catch (Exception e) {
/* 136 */           logger.error("保存用户userId：" + userId + "通讯录异常， name： " + name + "， phone：" + phone);
/*     */         }
/*     */       } else {
/* 139 */         logger.error("保存用户userId：" + userId + "通讯录失败，name： " + name + "， phone：" + phone);
/*     */       }
/*     */     }
/* 142 */     updateMessage(userId, info, tableName, tableOperaName);
/* 143 */     if (msg > 0) {
/* 144 */       flag = true;
/*     */     }
/* 146 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateMessage(String userId, UserBaseInfo info, String tableName, String tableOperaName)
/*     */   {
/* 158 */     HashMap<String, Object> result = new HashMap();
/* 159 */     result.put("userId", userId);
/*     */     
/* 161 */     this.userEmerContactsService.updateUserContacts(Long.valueOf(userId));
/*     */     
/* 163 */     Map<String, Object> nameCount = this.userContactsMapper.findRepeatCount(tableName, userId, "name");
/* 164 */     Map<String, Object> phoneCount = this.userContactsMapper.findRepeatCount(tableName, userId, "phone");
/* 165 */     info.setContactsRepeatName(Long.valueOf(String.valueOf(nameCount.get("count"))));
/* 166 */     info.setContactsRepeatPhone(Long.valueOf(String.valueOf(phoneCount.get("count"))));
/* 167 */     this.userBaseInfoMapper.update(info);
/*     */     
/*     */ 
/* 170 */     this.operatorVoicesService.updateVoiceMessage(tableOperaName, tableName, result);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<UserContacts> listContacts(long userId, String phone)
/*     */   {
/* 176 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId, 30000L);
/* 177 */     int countTable = this.userContactsMapper.countTable(tableName);
/* 178 */     if (countTable == 0) {
/* 179 */       this.userContactsMapper.createTable(tableName);
/*     */     }
/* 181 */     Map<String, Object> params = new HashMap();
/* 182 */     params.put("userId", Long.valueOf(userId));
/* 183 */     params.put("phone", phone);
/* 184 */     List<UserContacts> list = this.userContactsMapper.listShardSelective(tableName, params);
/* 185 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<UserContacts> listContacts(long userId)
/*     */   {
/* 191 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_contacts", userId, 30000L);
/* 192 */     int countTable = this.userContactsMapper.countTable(tableName);
/* 193 */     if (countTable == 0) {
/* 194 */       this.userContactsMapper.createTable(tableName);
/*     */     }
/* 196 */     Map<String, Object> params = new HashMap();
/* 197 */     params.put("userId", Long.valueOf(userId));
/* 198 */     List<UserContacts> list = this.userContactsMapper.listShardSelective(tableName, params);
/* 199 */     return list;
/*     */   }
/*     */   
/*     */   public int update(UserContacts bean)
/*     */   {
/* 204 */     return this.userContactsMapper.update(bean);
/*     */   }
/*     */   
/*     */ 
/*     */   public void deleteShardByUserId(Long userId)
/*     */   {
/* 210 */     String tableName = ShardTableUtil.generateTableNameById("cl_user_contacts", Long.valueOf(userId.longValue()).longValue(), 30000L);
/* 211 */     int countTable = this.userContactsMapper.countTable(tableName);
/* 212 */     if (countTable == 0) {
/* 213 */       this.userContactsMapper.createTable(tableName);
/*     */     }
/* 215 */     this.userContactsMapper.deleteShardByUserId(tableName, userId.longValue());
/*     */   }
/*     */   
/*     */   public String replaceEmoji(String str) {
/* 219 */     if (StringUtil.isEmpty(str)) {
/* 220 */       return "";
/*     */     }
/* 222 */     String patternString = "[^a-zA-Z0-9\\u4E00-\\u9FA5]";
/* 223 */     Pattern pattern = Pattern.compile(patternString);
/* 224 */     Matcher matcher = pattern.matcher(str);
/* 225 */     return matcher.replaceAll("");
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 229 */     UserContactsServiceImpl user = new UserContactsServiceImpl();
/* 230 */     System.out.println(user.replaceEmoji("车车🚗🚗🚗🚗🚗勇"));
/*     */   }
/*     */ }
