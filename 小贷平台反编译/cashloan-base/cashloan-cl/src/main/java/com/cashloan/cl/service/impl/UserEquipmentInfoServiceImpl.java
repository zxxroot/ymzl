/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.cashloan.cl.domain.UserEquipmentInfo;
/*     */ import com.cashloan.cl.mapper.UserEquipmentInfoMapper;
/*     */ import com.cashloan.cl.service.UserEquipmentInfoService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.mapper.UserMapper;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.DateUtil;
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
/*     */ @Service("userEquipmentInfoService")
/*     */ public class UserEquipmentInfoServiceImpl
/*     */   extends BaseServiceImpl<UserEquipmentInfo, Long>
/*     */   implements UserEquipmentInfoService
/*     */ {
/*  36 */   private static final Logger logger = LoggerFactory.getLogger(UserEquipmentInfoServiceImpl.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private UserEquipmentInfoMapper userEquipmentInfoMapper;
/*     */   
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   
/*     */ 
/*     */   public BaseMapper<UserEquipmentInfo, Long> getMapper()
/*     */   {
/*  48 */     return this.userEquipmentInfoMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int saveOrUpdate(UserEquipmentInfo uei)
/*     */   {
/*  56 */     Map<String, Object> map = new HashMap();
/*  57 */     map.put("userId", uei.getUserId());
/*  58 */     UserEquipmentInfo uinfo = (UserEquipmentInfo)this.userEquipmentInfoMapper.findSelective(map);
/*  59 */     if (uinfo == null) {
/*  60 */       return this.userEquipmentInfoMapper.save(uei);
/*     */     }
/*  62 */     map.put("id", uinfo.getId());
/*  63 */     map.put("operatingSystem", uei.getOperatingSystem());
/*  64 */     map.put("systemVersions", uei.getSystemVersions());
/*  65 */     map.put("phoneType", uei.getPhoneType());
/*  66 */     map.put("phoneBrand", uei.getPhoneBrand());
/*  67 */     map.put("phoneMark", uei.getPhoneMark());
/*  68 */     map.put("versionName", uei.getVersionName());
/*  69 */     map.put("versionCode", uei.getVersionCode());
/*  70 */     map.put("mac", uei.getMac());
/*  71 */     return this.userEquipmentInfoMapper.updateSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public UserEquipmentInfo findSelective(long userId)
/*     */   {
/*  79 */     Map<String, Object> map = new HashMap();
/*  80 */     map.put("userId", Long.valueOf(userId));
/*  81 */     return (UserEquipmentInfo)this.userEquipmentInfoMapper.findSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void save(String loginName, String blackBox)
/*     */   {
/*  89 */     if (blackBox == null) {
/*  90 */       return;
/*     */     }
/*  92 */     Map<String, Object> map = new HashMap();
/*  93 */     map.put("loginName", loginName);
/*  94 */     User user = (User)this.userMapper.findSelective(map);
/*  95 */     map = new HashMap();
/*  96 */     map.put("userId", user.getId());
/*  97 */     UserEquipmentInfo uinfo = (UserEquipmentInfo)this.userEquipmentInfoMapper.findSelective(map);
/*  98 */     if (user != null) {
/*  99 */       Map<String, Object> paramMap = new HashMap();
/* 100 */       paramMap.put("id", user.getId());
/* 101 */       paramMap.put("loginTime", DateUtil.getNow());
/* 102 */       this.userMapper.updateSelective(paramMap);
/* 103 */       if (uinfo == null) {
/* 104 */         UserEquipmentInfo uei = new UserEquipmentInfo();
/* 105 */         uei.setUserId(user.getId());
/* 106 */         uei.setBlackBox(blackBox);
/* 107 */         this.userEquipmentInfoMapper.save(uei);
/*     */       } else {
/* 109 */         map.put("blackBox", blackBox);
/* 110 */         map.put("id", uinfo.getId());
/* 111 */         this.userEquipmentInfoMapper.updateSelective(map);
/*     */       }
/*     */     }
/*     */   }
/*     */ }
