/*     */ package com.rongdu.creditrank.cr.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.creditrank.cr.domain.Credit;
/*     */ import com.rongdu.creditrank.cr.domain.CreditLog;
/*     */ import com.rongdu.creditrank.cr.mapper.CreditLogMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.CreditMapper;
/*     */ import com.rongdu.creditrank.cr.model.CreditModel;
/*     */ import com.rongdu.creditrank.cr.service.CreditService;
/*     */ import java.util.Date;
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
/*     */ 
/*     */ @Service("creditService")
/*     */ public class CreditServiceImpl
/*     */   extends BaseServiceImpl<Credit, Long>
/*     */   implements CreditService
/*     */ {
/*  43 */   private static final Logger logger = LoggerFactory.getLogger(CreditServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private CreditMapper creditMapper;
/*     */   
/*     */   @Resource
/*     */   private CreditLogMapper creditLogMapper;
/*     */   
/*     */   public BaseMapper<Credit, Long> getMapper()
/*     */   {
/*  53 */     return this.creditMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<CreditModel> page(Map<String, Object> searchMap, int current, int pageSize)
/*     */   {
/*  59 */     PageHelper.startPage(current, pageSize);
/*  60 */     List<CreditModel> list = this.creditMapper.page(searchMap);
/*  61 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<CreditModel> listAll(Map<String, Object> searchMap, int current, int pageSize)
/*     */   {
/*  67 */     PageHelper.startPage(current, pageSize);
/*  68 */     List<CreditModel> list = this.creditMapper.listAll(searchMap);
/*  69 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public Credit findSelective(Map<String, Object> searchMap)
/*     */   {
/*  74 */     return (Credit)this.creditMapper.findSelective(searchMap);
/*     */   }
/*     */   
/*     */   public Credit findByPrimary(long id)
/*     */   {
/*  79 */     return (Credit)this.creditMapper.findByPrimary(Long.valueOf(id));
/*     */   }
/*     */   
/*     */   public int updateSelective(Map<String, Object> param)
/*     */   {
/*  84 */     return this.creditMapper.updateSelective(param);
/*     */   }
/*     */   
/*     */   public List<Credit> findByConsumerNo(String consumerNo)
/*     */   {
/*  89 */     Map<String, Object> result = new HashMap();
/*  90 */     result.put("consumerNo", consumerNo);
/*  91 */     List<Credit> list = this.creditMapper.listSelective(result);
/*  92 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public int updateSelective(long id, double unuse, SysUser sysUser, String remark)
/*     */   {
/*  98 */     Credit credit = (Credit)this.creditMapper.findByPrimary(Long.valueOf(id));
/*  99 */     Map<String, Object> param = new HashMap();
/* 100 */     double total = credit.getTotal().doubleValue();
/* 101 */     double result = unuse - credit.getUnuse().doubleValue();
/* 102 */     double later = credit.getTotal().doubleValue() + result;
/* 103 */     param.put("id", credit.getId());
/* 104 */     param.put("total", Double.valueOf(later));
/* 105 */     param.put("unuse", Double.valueOf(unuse));
/* 106 */     int msg = this.creditMapper.updateSelective(param);
/*     */     
/* 108 */     if (msg > 0) {
/* 109 */       if (unuse > credit.getUnuse().doubleValue()) {
/* 110 */         msg = saveLog(credit, sysUser, total, result, later, remark, "10");
/*     */       } else {
/* 112 */         msg = saveLog(credit, sysUser, total, result, later, remark, "20");
/*     */       }
/*     */     }
/*     */     
/* 116 */     return msg;
/*     */   }
/*     */   
/*     */   public int updateState(long id, String state, SysUser sysUser)
/*     */   {
/* 121 */     Map<String, Object> param = new HashMap();
/* 122 */     param.put("id", Long.valueOf(id));
/* 123 */     param.put("state", state);
/* 124 */     int msg = this.creditMapper.updateSelective(param);
/* 125 */     Credit credit = (Credit)this.creditMapper.findByPrimary(Long.valueOf(id));
/* 126 */     if (msg > 0) {
/* 127 */       if ("10".equals(state)) {
/* 128 */         msg = saveLog(credit, sysUser, 0.0D, credit.getUnuse().doubleValue(), credit.getUnuse().doubleValue(), "解冻", "40");
/*     */       } else {
/* 130 */         msg = saveLog(credit, sysUser, credit.getUnuse().doubleValue(), credit.getUnuse().doubleValue(), 0.0D, "冻结", "30");
/*     */       }
/*     */     }
/* 133 */     return msg;
/*     */   }
/*     */   
/*     */   public int saveLog(Credit credit, SysUser sysUser, double total, double result, double later, String remark, String type)
/*     */   {
/* 138 */     CreditLog log = new CreditLog();
/* 139 */     log.setModifyTime(new Date());
/* 140 */     log.setConsumerNo(credit.getConsumerNo());
/* 141 */     log.setCreditType(credit.getCreditType());
/*     */     
/* 143 */     log.setModifyUser("system");
/* 144 */     log.setPre(Double.valueOf(total));
/* 145 */     log.setNow(Double.valueOf(later));
/* 146 */     log.setModifyTotal(Double.valueOf(Math.abs(result)));
/* 147 */     log.setRemark(remark);
/* 148 */     log.setType(type);
/* 149 */     int msg = this.creditLogMapper.save(log);
/* 150 */     return msg;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\CreditServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */