/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.DhbHistorySearch;
/*    */ import com.cashloan.cl.mapper.DhbHistorySearchMapper;
/*    */ import com.cashloan.cl.service.DhbHistorySearchService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
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
/*    */ @Service("dhbHistorySearchService")
/*    */ public class DhbHistorySearchServiceImpl
/*    */   extends BaseServiceImpl<DhbHistorySearch, Long>
/*    */   implements DhbHistorySearchService
/*    */ {
/* 33 */   private static final Logger logger = LoggerFactory.getLogger(DhbHistorySearchServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private DhbHistorySearchMapper dhbHistorySearchMapper;
/*    */   
/*    */   public BaseMapper<DhbHistorySearch, Long> getMapper()
/*    */   {
/* 40 */     return this.dhbHistorySearchMapper;
/*    */   }
/*    */   
/*    */   public DhbHistorySearch findSelective(Map<String, Object> paramMap)
/*    */   {
/* 45 */     List<DhbHistorySearch> list = this.dhbHistorySearchMapper.listSelective(paramMap);
/* 46 */     if ((list == null) || (list.isEmpty())) {
/* 47 */       return new DhbHistorySearch();
/*    */     }
/* 49 */     return (DhbHistorySearch)list.get(0);
/*    */   }
/*    */ }
