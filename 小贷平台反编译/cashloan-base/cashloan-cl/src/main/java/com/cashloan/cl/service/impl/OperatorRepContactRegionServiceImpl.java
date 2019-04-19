/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorRepContactRegion;
/*    */ import com.cashloan.cl.mapper.OperatorRepContactRegionMapper;
/*    */ import com.cashloan.cl.service.OperatorRepContactRegionService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
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
/*    */ @Service("operatorRepContactRegionService")
/*    */ public class OperatorRepContactRegionServiceImpl
/*    */   extends BaseServiceImpl<OperatorRepContactRegion, Long>
/*    */   implements OperatorRepContactRegionService
/*    */ {
/* 34 */   private static final Logger logger = LoggerFactory.getLogger(OperatorRepContactRegionServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorRepContactRegionMapper operatorRepContactRegionMapper;
/*    */   
/*    */   public BaseMapper<OperatorRepContactRegion, Long> getMapper()
/*    */   {
/* 41 */     return this.operatorRepContactRegionMapper;
/*    */   }
/*    */   
/*    */   public List<OperatorRepContactRegion> listSelective(Map<String, Object> paramsMap)
/*    */   {
/* 46 */     long userId = ((Long)paramsMap.get("userId")).longValue();
/* 47 */     String tableContactRegion = ShardTableUtil.generateTableNameById("cl_operator_rep_contact_region", userId, 30000L);
/* 48 */     int countTableContactRegion = this.operatorRepContactRegionMapper.countTable(tableContactRegion);
/* 49 */     if (countTableContactRegion == 0) {
/* 50 */       this.operatorRepContactRegionMapper.createTable(tableContactRegion);
/*    */     }
/* 52 */     return this.operatorRepContactRegionMapper.listShardSelective(tableContactRegion, paramsMap);
/*    */   }
/*    */ }
