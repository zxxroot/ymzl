/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorRepTripInfo;
/*    */ import com.cashloan.cl.mapper.OperatorRepTripInfoMapper;
/*    */ import com.cashloan.cl.service.OperatorRepTripInfoService;
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
/*    */ 
/*    */ @Service("operatorRepTripInfoService")
/*    */ public class OperatorRepTripInfoServiceImpl
/*    */   extends BaseServiceImpl<OperatorRepTripInfo, Long>
/*    */   implements OperatorRepTripInfoService
/*    */ {
/* 35 */   private static final Logger logger = LoggerFactory.getLogger(OperatorRepTripInfoServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorRepTripInfoMapper operatorRepTripInfoMapper;
/*    */   
/*    */   public BaseMapper<OperatorRepTripInfo, Long> getMapper()
/*    */   {
/* 42 */     return this.operatorRepTripInfoMapper;
/*    */   }
/*    */   
/*    */   public List<OperatorRepTripInfo> listSelective(Map<String, Object> paramMap)
/*    */   {
/* 47 */     long userId = ((Long)paramMap.get("userId")).longValue();
/* 48 */     String tableTripInfo = ShardTableUtil.generateTableNameById("cl_operator_rep_trip_info", userId, 30000L);
/* 49 */     int countTableTripInfo = this.operatorRepTripInfoMapper.countTable(tableTripInfo);
/* 50 */     if (countTableTripInfo == 0) {
/* 51 */       this.operatorRepTripInfoMapper.createTable(tableTripInfo);
/*    */     }
/* 53 */     return this.operatorRepTripInfoMapper.listShardSelective(tableTripInfo, paramMap);
/*    */   }
/*    */ }
