/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.BorrowProgress;
/*     */ import com.cashloan.cl.domain.UrgeRepayOrder;
/*     */ import com.cashloan.cl.domain.UrgeRepayOrderLog;
/*     */ import com.cashloan.cl.mapper.BorrowProgressMapper;
/*     */ import com.cashloan.cl.mapper.ClBorrowMapper;
/*     */ import com.cashloan.cl.mapper.UrgeRepayOrderLogMapper;
/*     */ import com.cashloan.cl.mapper.UrgeRepayOrderMapper;
/*     */ import com.cashloan.cl.service.UrgeRepayOrderLogService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.model.BorrowModel;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("urgeRepayOrderLogService")
/*     */ public class UrgeRepayOrderLogServiceImpl
/*     */   extends BaseServiceImpl<UrgeRepayOrderLog, Long>
/*     */   implements UrgeRepayOrderLogService
/*     */ {
/*     */   @Resource
/*     */   private UrgeRepayOrderMapper urgeRepayOrderMapper;
/*     */   @Resource
/*     */   private UrgeRepayOrderLogMapper urgeRepayOrderLogMapper;
/*     */   @Resource
/*     */   private ClBorrowMapper clBorrowMapper;
/*     */   @Resource
/*     */   private BorrowProgressMapper borrowProgressMapper;
/*     */   
/*     */   public BaseMapper<UrgeRepayOrderLog, Long> getMapper()
/*     */   {
/*  57 */     return this.urgeRepayOrderLogMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<UrgeRepayOrderLog> list(Map<String, Object> params, int current, int pageSize)
/*     */   {
/*  63 */     PageHelper.startPage(current, pageSize);
/*  64 */     List<UrgeRepayOrderLog> list = this.urgeRepayOrderLogMapper
/*  65 */       .listSelective(params);
/*  66 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<UrgeRepayOrderLog> getLogByParam(Map<String, Object> params)
/*     */   {
/*  72 */     return this.urgeRepayOrderLogMapper.listSelective(params);
/*     */   }
/*     */   
/*     */   public int saveOrderInfo(UrgeRepayOrderLog orderLog, UrgeRepayOrder order)
/*     */   {
/*  77 */     orderLog.setDueId(order.getId());
/*  78 */     orderLog.setBorrowId(order.getBorrowId());
/*  79 */     orderLog.setUserId(order.getUserId());
/*     */     
/*  81 */     int i = this.urgeRepayOrderLogMapper.save(orderLog);
/*     */     
/*  83 */     Map<String, Object> map = new HashMap();
/*  84 */     map.put("id", order.getId());
/*  85 */     map.put("state", orderLog.getState());
/*  86 */     map.put("count", Long.valueOf(order.getCount().longValue() + 1L));
/*  87 */     map.put("successTime", DateUtil.getNow());
/*  88 */     this.urgeRepayOrderMapper.updateSelective(map);
/*  89 */     if (order.getState().equals("50"))
/*     */     {
/*  91 */       Borrow b = (Borrow)this.clBorrowMapper.findByPrimary(order.getBorrowId());
/*  92 */       Map<String, Object> stateMap = new HashMap();
/*  93 */       stateMap.put("id", order.getBorrowId());
/*  94 */       stateMap.put("state", "90");
/*  95 */       this.clBorrowMapper.updateSelective(stateMap);
/*     */       
/*  97 */       BorrowProgress bp = new BorrowProgress();
/*  98 */       bp.setBorrowId(b.getId());
/*  99 */       bp.setUserId(b.getUserId());
/* 100 */       bp.setRemark(BorrowModel.convertBorrowRemark("90"));
/* 101 */       bp.setState("90");
/* 102 */       bp.setCreateTime(new Date());
/* 103 */       this.borrowProgressMapper.save(bp);
/*     */     }
/* 105 */     return i;
/*     */   }
/*     */ }
