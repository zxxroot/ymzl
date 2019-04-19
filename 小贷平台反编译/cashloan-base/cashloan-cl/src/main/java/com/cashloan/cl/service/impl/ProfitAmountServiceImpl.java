/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.ProfitAmount;
/*     */ import com.cashloan.cl.domain.ProfitCashLog;
/*     */ import com.cashloan.cl.mapper.ProfitAmountMapper;
/*     */ import com.cashloan.cl.mapper.ProfitCashLogMapper;
/*     */ import com.cashloan.cl.model.ManageProfitAmountModel;
/*     */ import com.cashloan.cl.service.ProfitAmountService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.mapper.UserMapper;
/*     */ import java.util.Date;
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
/*     */ 
/*     */ @Service("profitAmountService")
/*     */ public class ProfitAmountServiceImpl
/*     */   extends BaseServiceImpl<ProfitAmount, Long>
/*     */   implements ProfitAmountService
/*     */ {
/*  46 */   private static final Logger logger = LoggerFactory.getLogger(ProfitAmountServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private ProfitAmountMapper profitAmountMapper;
/*     */   @Resource
/*     */   private ProfitCashLogMapper profitCashLogMapper;
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   
/*     */   public BaseMapper<ProfitAmount, Long> getMapper()
/*     */   {
/*  57 */     return this.profitAmountMapper;
/*     */   }
/*     */   
/*     */   public int cash(long userId, double money)
/*     */   {
/*  62 */     int msg = 0;
/*  63 */     Map<String, Object> map = new HashMap();
/*  64 */     map.put("userId", Long.valueOf(userId));
/*  65 */     ProfitAmount pa = (ProfitAmount)this.profitAmountMapper.findSelective(map);
/*  66 */     if (StringUtil.isNotBlank(pa)) {
/*  67 */       map.put("noCashed", Double.valueOf(pa.getNoCashed().doubleValue() - money));
/*  68 */       map.put("cashed", Double.valueOf(pa.getCashed().doubleValue() + money));
/*  69 */       map.put("id", pa.getId());
/*  70 */       msg = this.profitAmountMapper.updateSelective(map);
/*     */     }
/*  72 */     if (msg > 0) {
/*  73 */       ProfitCashLog pcl = new ProfitCashLog();
/*  74 */       pcl.setUserId(Long.valueOf(userId));
/*  75 */       pcl.setAmount(Double.valueOf(money));
/*  76 */       pcl.setAddTime(new Date());
/*  77 */       msg = this.profitCashLogMapper.save(pcl);
/*     */     }
/*  79 */     return msg;
/*     */   }
/*     */   
/*     */   public ProfitAmount find(long userId)
/*     */   {
/*  84 */     Map<String, Object> map = new HashMap();
/*  85 */     map.put("userId", Long.valueOf(userId));
/*  86 */     return (ProfitAmount)this.profitAmountMapper.findSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageProfitAmountModel> findAmount(String phone, String userName, int current, int pageSize)
/*     */   {
/*  92 */     User user = this.userMapper.findByLoginName(phone);
/*  93 */     PageHelper.startPage(current, pageSize);
/*  94 */     Map<String, Object> map = new HashMap();
/*  95 */     map.put("id", user.getId());
/*  96 */     if (StringUtil.isNotBlank(userName)) {
/*  97 */       map.put("userName", "%" + userName + "%");
/*     */     }
/*  99 */     List<ManageProfitAmountModel> list = this.profitAmountMapper.findAmount(map);
/* 100 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageProfitAmountModel> findSysAmount(String userName, int current, int pageSize)
/*     */   {
/* 106 */     PageHelper.startPage(current, pageSize);
/* 107 */     Map<String, Object> map = new HashMap();
/* 108 */     if (StringUtil.isNotBlank(userName)) {
/* 109 */       map.put("userName", "%" + userName + "%");
/*     */     }
/* 111 */     List<ManageProfitAmountModel> list = this.profitAmountMapper.findSysAmount(map);
/* 112 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public List<ProfitAmount> listNoCash()
/*     */   {
/* 117 */     return this.profitAmountMapper.listNoCash();
/*     */   }
/*     */ }
