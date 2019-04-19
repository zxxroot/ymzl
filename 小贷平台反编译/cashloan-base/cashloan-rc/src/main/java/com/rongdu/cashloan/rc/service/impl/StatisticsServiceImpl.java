/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.rc.domain.Statistics;
/*    */ import com.rongdu.cashloan.rc.mapper.StatisticsMapper;
/*    */ import com.rongdu.cashloan.rc.service.StatisticsService;
/*    */ import java.util.HashMap;
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
/*    */ @Service("statisticsService")
/*    */ public class StatisticsServiceImpl
/*    */   extends BaseServiceImpl<Statistics, Long>
/*    */   implements StatisticsService
/*    */ {
/*    */   @Resource
/*    */   private StatisticsMapper statisticsMapper;
/*    */   
/*    */   public BaseMapper<Statistics, Long> getMapper()
/*    */   {
/* 38 */     return this.statisticsMapper;
/*    */   }
/*    */   
/*    */   public Page<Statistics> page(Map<String, Object> params, int currentPage, int pageSize)
/*    */   {
/* 43 */     PageHelper.startPage(currentPage, pageSize);
/* 44 */     Page<Statistics> page = (Page)this.statisticsMapper.listSelective(params);
/* 45 */     return page;
/*    */   }
/*    */   
/*    */   public List<Statistics> listAll()
/*    */   {
/* 50 */     Map<String, Object> params = new HashMap();
/* 51 */     params.put("state", "10");
/* 52 */     return this.statisticsMapper.listSelective(params);
/*    */   }
/*    */ }
