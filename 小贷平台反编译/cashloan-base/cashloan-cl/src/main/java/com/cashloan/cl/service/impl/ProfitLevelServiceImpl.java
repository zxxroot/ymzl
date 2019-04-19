/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.ProfitLevel;
/*    */ import com.cashloan.cl.mapper.ProfitLevelMapper;
/*    */ import com.cashloan.cl.service.ProfitLevelService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.util.HashMap;
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
/*    */ @Service("profitLevelService")
/*    */ public class ProfitLevelServiceImpl
/*    */   extends BaseServiceImpl<ProfitLevel, Long>
/*    */   implements ProfitLevelService
/*    */ {
/* 35 */   private static final Logger logger = LoggerFactory.getLogger(ProfitLevelServiceImpl.class);
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private ProfitLevelMapper profitLevelMapper;
/*    */   
/*    */ 
/*    */ 
/*    */   public BaseMapper<ProfitLevel, Long> getMapper()
/*    */   {
/* 45 */     return this.profitLevelMapper;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<ProfitLevel> find()
/*    */   {
/* 53 */     return this.profitLevelMapper.listAll();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int update(long id, double rate)
/*    */   {
/* 61 */     Map<String, Object> map = new HashMap();
/* 62 */     map.put("id", Long.valueOf(id));
/* 63 */     map.put("rate", Double.valueOf(rate));
/* 64 */     return this.profitLevelMapper.updateSelective(map);
/*    */   }
/*    */ }
