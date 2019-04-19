/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.rc.domain.StatisticsBusiness;
/*    */ import com.rongdu.cashloan.rc.mapper.StatisticsBusinessMapper;
/*    */ import com.rongdu.cashloan.rc.service.StatisticsBusinessService;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
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
/*    */ @Service("statisticsBusinessService")
/*    */ public class StatisticsBusinessServiceImpl
/*    */   extends BaseServiceImpl<StatisticsBusiness, Long>
/*    */   implements StatisticsBusinessService
/*    */ {
/*    */   @Resource
/*    */   private StatisticsBusinessMapper statisticsBusinessMapper;
/*    */   
/*    */   public BaseMapper<StatisticsBusiness, Long> getMapper()
/*    */   {
/* 38 */     return this.statisticsBusinessMapper;
/*    */   }
/*    */   
/*    */   public Page<StatisticsBusiness> page(Map<String, Object> params, int currentPage, int pageSize)
/*    */   {
/* 43 */     PageHelper.startPage(currentPage, pageSize);
/* 44 */     Page<StatisticsBusiness> page = (Page)this.statisticsBusinessMapper.listSelective(params);
/* 45 */     return page;
/*    */   }
/*    */   
/*    */   public List<StatisticsBusiness> listSelective(Map<String, Object> params)
/*    */   {
/* 50 */     return this.statisticsBusinessMapper.listSelective(params);
/*    */   }
/*    */ }
