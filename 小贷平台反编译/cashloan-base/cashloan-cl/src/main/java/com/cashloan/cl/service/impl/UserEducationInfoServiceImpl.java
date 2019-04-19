/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.UserEducationInfo;
/*     */ import com.cashloan.cl.mapper.UserEducationInfoMapper;
/*     */ import com.cashloan.cl.model.UserEducationInfoModel;
/*     */ import com.cashloan.cl.service.UserEducationInfoService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
/*     */ import com.rongdu.cashloan.core.mapper.UserMapper;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.StringUtil;
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
/*     */ @Service("userEducationService")
/*     */ public class UserEducationInfoServiceImpl
/*     */   extends BaseServiceImpl<UserEducationInfo, Long>
/*     */   implements UserEducationInfoService
/*     */ {
/*  41 */   private static final Logger logger = LoggerFactory.getLogger(UserEducationInfoServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UserEducationInfoMapper userEducationInfoMapper;
/*     */   
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   
/*     */   public BaseMapper<UserEducationInfo, Long> getMapper()
/*     */   {
/*  54 */     return this.userEducationInfoMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int save(UserEducationInfo ue)
/*     */   {
/*  62 */     int msg = 0;
/*  63 */     Map<String, Object> map = new HashMap();
/*  64 */     map.put("userId", ue.getUserId());
/*  65 */     UserBaseInfo ubi = (UserBaseInfo)this.userBaseInfoMapper.findSelective(map);
/*  66 */     if (StringUtil.isNotBlank(ubi.getEducation())) {
/*  67 */       if (ubi.getEducation().equals(ue.getEducationBackground())) {
/*  68 */         ue.setState("10");
/*     */       } else {
/*  70 */         ue.setState("20");
/*     */       }
/*  72 */       UserEducationInfo uei = (UserEducationInfo)this.userEducationInfoMapper.findSelective(map);
/*  73 */       if (uei == null) {
/*  74 */         msg = this.userEducationInfoMapper.save(ue);
/*     */       } else {
/*  76 */         ue.setId(uei.getId());
/*  77 */         msg = this.userEducationInfoMapper.update(ue);
/*     */       }
/*     */     }
/*  80 */     return msg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int update(UserEducationInfo uei)
/*     */   {
/*  88 */     int msg = 0;
/*  89 */     Map<String, Object> map = new HashMap();
/*  90 */     map.put("userId", uei.getUserId());
/*  91 */     UserBaseInfo ubi = (UserBaseInfo)this.userBaseInfoMapper.findSelective(map);
/*  92 */     if ((ubi != null) && (ubi.getEducation().equals(uei.getEducationBackground()))) {
/*  93 */       uei.setState("10");
/*  94 */       UserEducationInfo ue = (UserEducationInfo)this.userEducationInfoMapper.findSelective(map);
/*  95 */       if (ue != null) {
/*  96 */         msg = this.userEducationInfoMapper.update(ue);
/*     */       }
/*     */     }
/*  99 */     return msg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Page<UserEducationInfoModel> list(Map<String, Object> searchMap, int current, int pageSize)
/*     */   {
/* 108 */     PageHelper.startPage(current, pageSize);
/* 109 */     List<UserEducationInfoModel> list = this.userEducationInfoMapper.page(searchMap);
/* 110 */     for (UserEducationInfoModel model : list) {
/* 111 */       if ("10".equals(model.getState())) {
/* 112 */         model.setStateStr("匹配");
/* 113 */       } else if ("20".equals(model.getState())) {
/* 114 */         model.setStateStr("不匹配");
/*     */       }
/*     */     }
/* 117 */     return (Page)list;
/*     */   }
/*     */ }
