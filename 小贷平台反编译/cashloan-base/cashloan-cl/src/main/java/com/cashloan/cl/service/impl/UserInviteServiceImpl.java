/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.ProfitAgent;
/*     */ import com.cashloan.cl.domain.UserInvite;
/*     */ import com.cashloan.cl.mapper.ProfitAgentMapper;
/*     */ import com.cashloan.cl.mapper.ProfitCashLogMapper;
/*     */ import com.cashloan.cl.mapper.UserInviteMapper;
/*     */ import com.cashloan.cl.model.InviteBorrowModel;
/*     */ import com.cashloan.cl.model.ManageAgentModel;
/*     */ import com.cashloan.cl.model.ManageProfitModel;
/*     */ import com.cashloan.cl.service.UserInviteService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.domain.User;
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
/*     */ 
/*     */ 
/*     */ @Service("userInviteService")
/*     */ public class UserInviteServiceImpl
/*     */   extends BaseServiceImpl<UserInvite, Long>
/*     */   implements UserInviteService
/*     */ {
/*  49 */   private static final Logger logger = LoggerFactory.getLogger(UserInviteServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UserInviteMapper userInviteMapper;
/*     */   
/*     */   @Resource
/*     */   private ProfitAgentMapper profitAgentMapper;
/*     */   @Resource
/*     */   private ProfitCashLogMapper profitCashLogMapper;
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   
/*     */   public BaseMapper<UserInvite, Long> getMapper()
/*     */   {
/*  63 */     return this.userInviteMapper;
/*     */   }
/*     */   
/*     */   public Map<String, Object> findPhone(long userId)
/*     */   {
/*  68 */     boolean isPhone = true;
/*  69 */     String phone = Global.getValue("phone");
/*  70 */     Map<String, Object> phoneMap = new HashMap();
/*  71 */     phoneMap.put("phone", phone);
/*  72 */     Map<String, Object> inviteMap = new HashMap();
/*  73 */     inviteMap.put("inviteId", Long.valueOf(userId));
/*  74 */     UserInvite ui = (UserInvite)this.userInviteMapper.findSelective(inviteMap);
/*  75 */     Map<String, Object> profitMap = new HashMap();
/*     */     
/*  77 */     if (StringUtil.isNotBlank(ui)) {
/*  78 */       profitMap.put("userId", ui.getUserId());
/*  79 */       ProfitAgent pa = (ProfitAgent)this.profitAgentMapper.findSelective(profitMap);
/*  80 */       if ((StringUtil.isNotBlank(pa)) && (pa.getLevel().intValue() != 3)) {
/*  81 */         phoneMap.put("phone", ui.getUserName());
/*     */       }
/*     */     }
/*  84 */     profitMap.put("userId", Long.valueOf(userId));
/*  85 */     ProfitAgent pa = (ProfitAgent)this.profitAgentMapper.findSelective(profitMap);
/*  86 */     if ((StringUtil.isNotBlank(pa)) && (pa.getLevel().intValue() == 1)) {
/*  87 */       isPhone = false;
/*     */     }
/*  89 */     phoneMap.put("isPhone", Boolean.valueOf(isPhone));
/*  90 */     return phoneMap;
/*     */   }
/*     */   
/*     */   public Page<ManageProfitModel> findAgent(String phone, String userName, int current, int pageSize) throws ServiceException
/*     */   {
/*  95 */     Map<String, Object> map = new HashMap();
/*  96 */     User user = this.userMapper.findByLoginName(phone);
/*  97 */     map.put("id", user.getId());
/*  98 */     map.put("userId", user.getId());
/*  99 */     if (StringUtil.isNotBlank(userName)) {
/* 100 */       map.put("userName", "%" + userName + "%");
/*     */     }
/* 102 */     PageHelper.startPage(current, pageSize);
/* 103 */     List<ManageProfitModel> list = this.userInviteMapper.findAgent(map);
/* 104 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageAgentModel> findSysAgent(String userName, int current, int pageSize)
/*     */   {
/* 110 */     PageHelper.startPage(current, pageSize);
/* 111 */     Map<String, Object> map = new HashMap();
/* 112 */     if (StringUtil.isNotBlank(userName)) {
/* 113 */       map.put("userName", "%" + userName + "%");
/*     */     }
/* 115 */     List<ManageAgentModel> list = this.userInviteMapper.findSysAgent(map);
/* 116 */     for (ManageAgentModel manageAgentModel : list) {
/* 117 */       if ("1".equals(manageAgentModel.getLevel())) {
/* 118 */         manageAgentModel.setCount(this.userInviteMapper.count(manageAgentModel.getUserId()));
/*     */       } else {
/* 120 */         manageAgentModel.setCount("0");
/*     */       }
/*     */     }
/* 123 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public Page<InviteBorrowModel> listInviteBorrow(long userId, int current, int pageSize)
/*     */   {
/* 128 */     PageHelper.startPage(current, pageSize);
/* 129 */     Map<String, Object> map = new HashMap();
/* 130 */     map.put("userId", Long.valueOf(userId));
/* 131 */     List<InviteBorrowModel> list = this.userInviteMapper.listInviteBorrow(map);
/* 132 */     return (Page)list;
/*     */   }
/*     */ }


/*impl\UserInviteServiceImpl.class

 */