/*    */ package com.rongdu.creditrank.cr.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.creditrank.cr.domain.RankDetail;
/*    */ import com.rongdu.creditrank.cr.mapper.RankDetailMapper;
/*    */ import com.rongdu.creditrank.cr.service.RankDetailService;
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
/*    */ @Service("rankDetailService")
/*    */ public class RankDetailServiceImpl
/*    */   extends BaseServiceImpl<RankDetail, Long>
/*    */   implements RankDetailService
/*    */ {
/* 37 */   private static final Logger logger = LoggerFactory.getLogger(RankDetailServiceImpl.class);
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private RankDetailMapper rankDetailMapper;
/*    */   
/*    */ 
/*    */ 
/*    */   public BaseMapper<RankDetail, Long> getMapper()
/*    */   {
/* 47 */     return this.rankDetailMapper;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int save(RankDetail rankDetail)
/*    */   {
/* 55 */     return this.rankDetailMapper.save(rankDetail);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int updateSelective(Map<String, Object> rankDetailMap)
/*    */   {
/* 63 */     return this.rankDetailMapper.updateSelective(rankDetailMap);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Page<RankDetail> page(Map<String, Object> searchMap, int current, int pageSize)
/*    */   {
/* 72 */     PageHelper.startPage(current, pageSize);
/* 73 */     List<RankDetail> list = this.rankDetailMapper.listSelective(searchMap);
/* 74 */     return (Page)list;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\RankDetailServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */