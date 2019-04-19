/*    */ package com.rongdu.creditrank.cr.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.creditrank.cr.domain.CreditLog;
/*    */ import com.rongdu.creditrank.cr.mapper.CreditLogMapper;
/*    */ import com.rongdu.creditrank.cr.model.CreditLogModel;
/*    */ import com.rongdu.creditrank.cr.service.CreditLogService;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
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
/*    */ @Service("creditLogService")
/*    */ public class CreditLogServiceImpl
/*    */   extends BaseServiceImpl<CreditLog, Long>
/*    */   implements CreditLogService
/*    */ {
/* 38 */   private static final Logger logger = LoggerFactory.getLogger(CreditLogServiceImpl.class);
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private CreditLogMapper creditLogMapper;
/*    */   
/*    */ 
/*    */ 
/*    */   public BaseMapper<CreditLog, Long> getMapper()
/*    */   {
/* 48 */     return this.creditLogMapper;
/*    */   }
/*    */   
/*    */   public int save(CreditLog log)
/*    */   {
/* 53 */     return this.creditLogMapper.save(log);
/*    */   }
/*    */   
/*    */ 
/*    */   public Page<CreditLogModel> page(Map<String, Object> searchMap, int current, int pageSize)
/*    */   {
/* 59 */     PageHelper.startPage(current, pageSize);
/* 60 */     List<CreditLogModel> list = this.creditLogMapper.findLog(searchMap);
/* 61 */     return (Page)list;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\CreditLogServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */