/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.domain.BorrowRepayLog;
import com.cashloan.cl.mapper.BorrowRepayLogMapper;
import com.cashloan.cl.model.BorrowRepayLogModel;
import com.cashloan.cl.model.ManageBRepayLogModel;
import com.cashloan.cl.service.BorrowRepayLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

;

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
/*     */ @Service("borrowRepayLogService")
/*     */ public class BorrowRepayLogServiceImpl
/*     */   extends BaseServiceImpl<BorrowRepayLog, Long>
/*     */   implements BorrowRepayLogService
/*     */ {
/*  37 */   private static final Logger logger = LoggerFactory.getLogger(BorrowRepayLogServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private BorrowRepayLogMapper borrowRepayLogMapper;
/*     */   
/*     */ 
/*     */   public BaseMapper<BorrowRepayLog, Long> getMapper()
/*     */   {
/*  45 */     return this.borrowRepayLogMapper;
/*     */   }
/*     */   
/*     */   public int save(BorrowRepayLog brl)
/*     */   {
/*  50 */     return this.borrowRepayLogMapper.save(brl);
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<BorrowRepayLogModel> page(Map<String, Object> searchMap, int current, int pageSize)
/*     */   {
/*  56 */     PageHelper.startPage(current, pageSize);
/*  57 */     List<BorrowRepayLogModel> list = this.borrowRepayLogMapper.listSelModel(searchMap);
/*  58 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageBRepayLogModel> listModel(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  64 */     PageHelper.startPage(currentPage, pageSize);
/*  65 */     List<ManageBRepayLogModel> list = this.borrowRepayLogMapper.listModel(params);
/*  66 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public BorrowRepayLog findSelective(Map<String, Object> paramMap)
/*     */   {
/*  71 */     BorrowRepayLog borrowRepayLog = null;
/*     */     try {
/*  73 */       borrowRepayLog = (BorrowRepayLog)this.borrowRepayLogMapper.findSelective(paramMap);
/*     */     } catch (Exception e) {
/*  75 */       logger.error(e.getMessage(), e);
/*     */     }
/*  77 */     return borrowRepayLog;
/*     */   }
/*     */   
/*     */   public boolean updateSelective(Map<String, Object> paramMap)
/*     */   {
/*  82 */     int result = this.borrowRepayLogMapper.updateSelective(paramMap);
/*  83 */     if (result > 0L) {
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public boolean refundDeduction(Map<String, Object> paramMap)
/*     */   {
/*  91 */     int result = this.borrowRepayLogMapper.refundDeduction(paramMap);
/*  92 */     if (result > 0L) {
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public List listExport(Map<String, Object> searchParams)
/*     */   {
/* 101 */     List<ManageBRepayLogModel> list = this.borrowRepayLogMapper.listModel(searchParams);
/* 102 */     for (ManageBRepayLogModel m : list) { String str;
/* 103 */       switch ((str = m.getRepayWay()).hashCode()) {case 1567:  if (str.equals("10")) break; break; case 1598:  if (str.equals("20")) {} break; case 1629:  if (!str.equals("30"))
/*     */         {
/* 105 */           m.setRepayWay("代扣");
/* 108 */           m.setRepayWay("银行卡转账");
/*     */         }
/*     */         else {
/* 111 */           m.setRepayWay("支付宝转账");
/*     */         }
/*     */         break; }
/*     */     }
/* 115 */     return list;
/*     */   }
/*     */ }
