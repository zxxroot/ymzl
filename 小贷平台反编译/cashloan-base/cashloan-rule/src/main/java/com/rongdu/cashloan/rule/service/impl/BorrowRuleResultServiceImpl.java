/*    */ package com.rongdu.cashloan.rule.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.rule.domain.BorrowRuleResult;
/*    */ import com.rongdu.cashloan.rule.mapper.BorrowRuleResultMapper;
/*    */ import com.rongdu.cashloan.rule.service.BorrowRuleResultService;
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
/*    */ @Service("borrowRuleResultService")
/*    */ public class BorrowRuleResultServiceImpl
/*    */   extends BaseServiceImpl<BorrowRuleResult, Long>
/*    */   implements BorrowRuleResultService
/*    */ {
/* 36 */   private static final Logger logger = LoggerFactory.getLogger(BorrowRuleResultServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private BorrowRuleResultMapper borrowRuleResultMapper;
/*    */   
/*    */   public BaseMapper<BorrowRuleResult, Long> getMapper()
/*    */   {
/* 43 */     return this.borrowRuleResultMapper;
/*    */   }
/*    */   
/*    */   public Page<BorrowRuleResult> borrowRuleResult(Map<String, Object> params, int currentPage, int pageSize)
/*    */   {
/* 48 */     PageHelper.startPage(currentPage, pageSize);
/* 49 */     List<BorrowRuleResult> list = this.borrowRuleResultMapper.listSelective(params);
/* 50 */     return (Page)list;
/*    */   }
/*    */ }
