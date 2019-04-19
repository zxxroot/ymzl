/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.mapper.ClBorrowMapper;
import com.cashloan.cl.mapper.ProfitLogMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.cashloan.cl.domain.ProfitAgent;
import com.cashloan.cl.domain.ProfitLog;
import com.cashloan.cl.domain.UserInvite;
import com.cashloan.cl.mapper.ProfitAgentMapper;
import com.cashloan.cl.mapper.ProfitAmountMapper;
import com.cashloan.cl.mapper.UserInviteMapper;
import com.cashloan.cl.model.ManageCashLogModel;
import com.cashloan.cl.model.ProfitLogModel;
import com.cashloan.cl.service.ProfitLogService;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.User;
import com.rongdu.cashloan.core.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*     */ @Service("profitLogService")
/*     */ public class ProfitLogServiceImpl
/*     */   extends BaseServiceImpl<ProfitLog, Long>
/*     */   implements ProfitLogService
/*     */ {
/*  53 */   private static final Logger logger = LoggerFactory.getLogger(ProfitLogServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private ProfitLogMapper profitLogMapper;
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   @Resource
/*     */   private ClBorrowMapper clBorrowMapper;
/*     */   @Resource
/*     */   private UserInviteMapper userInviteMapper;
/*     */   @Resource
/*     */   private ProfitAgentMapper profitAgentMapper;
/*     */   @Resource
/*     */   private ProfitAmountMapper profitAmountMapper;
/*     */   
/*     */   public BaseMapper<ProfitLog, Long> getMapper()
/*     */   {
/*  70 */     return this.profitLogMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ProfitLogModel> page(Map<String, Object> searchMap, int current, int pageSize)
/*     */   {
/*  76 */     PageHelper.startPage(current, pageSize);
/*  77 */     List<ProfitLogModel> list = this.profitLogMapper.listInfo(searchMap);
/*  78 */     for (ProfitLogModel profitLogModel : list) {
/*  79 */       profitLogModel.setMsg("借款" + profitLogModel.getMoney() + "元,综合费用" + profitLogModel.getFee() + "元");
/*     */     }
/*  81 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageCashLogModel> findCashLog(String phone, String userName, int current, int pageSize)
/*     */   {
/*  87 */     User user = this.userMapper.findByLoginName(phone);
/*  88 */     PageHelper.startPage(current, pageSize);
/*  89 */     Map<String, Object> map = new HashMap();
/*  90 */     map.put("id", user.getId());
/*  91 */     if (StringUtil.isNotBlank(userName)) {
/*  92 */       map.put("userName", "%" + userName + "%");
/*     */     }
/*  94 */     List<ManageCashLogModel> list = this.profitLogMapper.findCashLog(map);
/*  95 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageCashLogModel> findCashLog(String userName, int current, int pageSize)
/*     */   {
/* 101 */     PageHelper.startPage(current, pageSize);
/* 102 */     Map<String, Object> map = new HashMap();
/* 103 */     if (StringUtil.isNotBlank(userName)) {
/* 104 */       map.put("userName", "%" + userName + "%");
/*     */     }
/* 106 */     List<ManageCashLogModel> list = this.profitLogMapper.findSysCashLog(map);
/* 107 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int save(long borrowId, Date date)
/*     */   {
/* 115 */     Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowId));
/* 116 */     if (StringUtil.isBlank(borrow)) {
/* 117 */       throw new BussinessException("此借款不存在");
/*     */     }
/*     */     
/*     */ 
/* 121 */     User user = (User)this.userMapper.findByPrimary(borrow.getUserId());
/* 122 */     if (StringUtil.isBlank(user)) {
/* 123 */       throw new BussinessException("此用户不存在");
/*     */     }
/*     */     
/*     */ 
/* 127 */     Map<String, Object> inviteMap = new HashMap();
/* 128 */     inviteMap.put("inviteId", user.getId());
/* 129 */     UserInvite invite = (UserInvite)this.userInviteMapper.findSelective(inviteMap);
/*     */     
/*     */ 
/*     */ 
/* 133 */     Map<String, Object> profitAgentMap = new HashMap();
/* 134 */     profitAgentMap.put("userId", invite.getUserId());
/* 135 */     ProfitAgent agent = (ProfitAgent)this.profitAgentMapper.findSelective(profitAgentMap);
/*     */     
/* 137 */     Map<String, Object> params = new HashMap();
/*     */     int msg;
/* 139 */     if (StringUtil.isNotBlank(agent)) {
/* 140 */       Double amount = Double.valueOf(borrow.getFee().doubleValue() * agent.getRate().doubleValue());
/* 141 */       params.put("userId", agent.getUserId());
/* 142 */       params.put("amount", amount);
/* 143 */       this.profitAmountMapper.addNocashedAmount(params);
/* 144 */       msg = saveLog(date, agent.getUserId(), amount.doubleValue(), borrow.getId(), agent.getRate(), user.getId());
/*     */       
/* 146 */       if ((agent.getLevel().intValue() == 2) && 
/* 147 */         (agent.getLeaderId() != null) && (agent.getLeaderId().longValue() != 0L)) {
/* 148 */         Map<String, Object> profitAgentLevel = new HashMap();
/* 149 */         profitAgentLevel.put("userId", agent.getLeaderId());
/* 150 */         ProfitAgent agentLeader = (ProfitAgent)this.profitAgentMapper.findSelective(profitAgentLevel);
/* 151 */         if (StringUtil.isNotBlank(agentLeader)) {
/* 152 */           amount = Double.valueOf(borrow.getFee().doubleValue() * (agentLeader.getRate().doubleValue() - agent.getRate().doubleValue()));
/* 153 */           params.clear();
/* 154 */           params.put("userId", agentLeader.getUserId());
/* 155 */           params.put("amount", amount);
/* 156 */           this.profitAmountMapper.addNocashedAmount(params);
/* 157 */           msg = saveLog(date, agentLeader.getUserId(), amount.doubleValue(), borrow.getId(), agentLeader.getRate(), user.getId());
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 162 */       Double rate = Double.valueOf(Double.parseDouble(Global.getValue("levelThree")));
/* 163 */       Double amount = Double.valueOf(borrow.getFee().doubleValue() * rate.doubleValue() / 100.0D);
/* 164 */       params.clear();
/* 165 */       params.put("userId", invite.getUserId());
/* 166 */       params.put("amount", amount);
/* 167 */       this.profitAmountMapper.addNocashedAmount(params);
/* 168 */       msg = saveLog(date, invite.getUserId(), amount.doubleValue(), borrow.getId(), rate, user.getId());
/*     */     }
/* 170 */     return msg;
/*     */   }
/*     */   
/*     */ 
/*     */   private int saveLog(Date date, Long agentId, double d, Long borrowId, Double rate, Long userId)
/*     */   {
/* 176 */     ProfitLog log = new ProfitLog();
/* 177 */     log.setAddTime(date);
/* 178 */     log.setAgentId(agentId);
/* 179 */     log.setAmount(Double.valueOf(d));
/* 180 */     log.setBorrowId(borrowId);
/* 181 */     log.setRate(rate);
/* 182 */     log.setUserId(userId);
/* 183 */     return this.profitLogMapper.save(log);
/*     */   }
/*     */ }
