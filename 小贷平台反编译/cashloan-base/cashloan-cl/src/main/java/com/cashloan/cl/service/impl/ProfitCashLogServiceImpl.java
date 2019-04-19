/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.domain.ProfitCashLog;
/*    */ import com.cashloan.cl.mapper.ProfitCashLogMapper;
/*    */ import com.cashloan.cl.model.ManageProfitLogModel;
/*    */ import com.cashloan.cl.service.ProfitCashLogService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.domain.User;
/*    */ import com.rongdu.cashloan.core.mapper.UserMapper;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ import tool.util.StringUtil;
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
/*    */ @Service("profitCashLogService")
/*    */ public class ProfitCashLogServiceImpl
/*    */   extends BaseServiceImpl<ProfitCashLog, Long>
/*    */   implements ProfitCashLogService
/*    */ {
/* 42 */   private static final Logger logger = LoggerFactory.getLogger(ProfitCashLogServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private ProfitCashLogMapper profitCashLogMapper;
/*    */   
/*    */   @Resource
/*    */   private UserMapper userMapper;
/*    */   
/*    */ 
/*    */   public BaseMapper<ProfitCashLog, Long> getMapper()
/*    */   {
/* 53 */     return this.profitCashLogMapper;
/*    */   }
/*    */   
/*    */ 
/*    */   public Page<ProfitCashLog> page(Map<String, Object> searchMap, int current, int pageSize)
/*    */   {
/* 59 */     PageHelper.startPage(current, pageSize);
/* 60 */     List<ProfitCashLog> list = this.profitCashLogMapper.listSelective(searchMap);
/* 61 */     return (Page)list;
/*    */   }
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
/*    */   public Page<ManageProfitLogModel> findLog(String phone, String userName, int current, int pageSize)
/*    */   {
/* 78 */     Map<String, Object> map = new HashMap();
/* 79 */     User user = this.userMapper.findByLoginName(phone);
/* 80 */     map.put("userId", user.getId());
/* 81 */     userName = userName == null ? "" : userName.trim();
/* 82 */     if (StringUtil.isNotBlank(userName)) {
/* 83 */       map.put("userName", userName.trim() + "%");
/*    */     }
/* 85 */     PageHelper.startPage(current, pageSize);
/* 86 */     List<ManageProfitLogModel> list = this.profitCashLogMapper.findLog(map);
/* 87 */     return (Page)list;
/*    */   }
/*    */   
/*    */   public Page<ManageProfitLogModel> findLog(String userName, int current, int pageSize)
/*    */   {
/* 92 */     PageHelper.startPage(current, pageSize);
/* 93 */     Map<String, Object> map = new HashMap();
/* 94 */     if (StringUtil.isNotBlank(userName)) {
/* 95 */       map.put("agentName", "%" + userName + "%");
/*    */     }
/* 97 */     List<ManageProfitLogModel> list = this.profitCashLogMapper.findSysLog(map);
/* 98 */     return (Page)list;
/*    */   }
/*    */ }
