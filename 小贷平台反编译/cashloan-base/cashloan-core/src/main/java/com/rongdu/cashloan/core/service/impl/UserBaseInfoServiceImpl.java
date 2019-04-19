/*     */ package com.rongdu.cashloan.core.service.impl;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import com.rongdu.cashloan.core.model.ManagerUserModel;
/*     */ import com.rongdu.cashloan.core.model.UserWorkInfoModel;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
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
/*     */ @Service("userBaseInfoService")
/*     */ public class UserBaseInfoServiceImpl
/*     */   extends BaseServiceImpl<UserBaseInfo, Long>
/*     */   implements UserBaseInfoService
/*     */ {
/*  37 */   private static final Logger logger = LoggerFactory.getLogger(UserBaseInfoServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   
/*     */   public BaseMapper<UserBaseInfo, Long> getMapper()
/*     */   {
/*  44 */     return this.userBaseInfoMapper;
/*     */   }
/*     */   
/*     */   public UserBaseInfo findByUserId(Long userId)
/*     */   {
/*  49 */     Map<String, Object> paramMap = new HashMap();
/*  50 */     paramMap.put("userId", userId);
/*  51 */     UserBaseInfo baseInfo = null;
/*     */     try {
/*  53 */       baseInfo = (UserBaseInfo)this.userBaseInfoMapper.findSelective(paramMap);
/*     */     } catch (Exception e) {
/*  55 */       logger.error("查询用户基本信息异常", e);
/*     */     }
/*     */     
/*  58 */     return baseInfo;
/*     */   }
/*     */   
/*     */   public UserBaseInfo findSelective(Map<String, Object> paramMap)
/*     */   {
/*  63 */     return (UserBaseInfo)this.userBaseInfoMapper.findSelective(paramMap);
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> getDictsCache(String type)
/*     */   {
/*  68 */     return this.userBaseInfoMapper.getDictsCache(type);
/*     */   }
/*     */   
/*     */   public ManagerUserModel getBaseModelByUserId(Long userId)
/*     */   {
/*  73 */     return this.userBaseInfoMapper.getBaseModelByUserId(userId);
/*     */   }
/*     */   
/*     */   public int updateState(long id, String state)
/*     */   {
/*  78 */     int i = 0;
/*  79 */     Map<String, Object> paramMap = new HashMap();
/*  80 */     paramMap.put("userId", Long.valueOf(id));
/*  81 */     UserBaseInfo base = (UserBaseInfo)this.userBaseInfoMapper.findSelective(paramMap);
/*  82 */     if (base != null) {
/*  83 */       Map<String, Object> map = new HashMap();
/*  84 */       map.put("id", base.getId());
/*  85 */       map.put("state", state);
/*  86 */       i = this.userBaseInfoMapper.updateSelective(map);
/*     */     }
/*  88 */     return i;
/*     */   }
/*     */   
/*     */   public boolean updateSelective(Map<String, Object> paramMap)
/*     */   {
/*  93 */     int result = this.userBaseInfoMapper.updateSelective(paramMap);
/*  94 */     if (result > 0L) {
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public UserWorkInfoModel getWorkInfo(Long userId)
/*     */   {
/* 102 */     return this.userBaseInfoMapper.findWorkInfo(userId);
/*     */   }
/*     */   
/*     */   public List<UserBaseInfo> listSelective(Map<String, Object> paramMap)
/*     */   {
/* 107 */     return this.userBaseInfoMapper.listSelective(paramMap);
/*     */   }
/*     */   
/*     */   public List<String> getUnRepayPhone()
/*     */   {
/* 112 */     return this.userBaseInfoMapper.getUnRepayPhone();
/*     */   }
/*     */ }
