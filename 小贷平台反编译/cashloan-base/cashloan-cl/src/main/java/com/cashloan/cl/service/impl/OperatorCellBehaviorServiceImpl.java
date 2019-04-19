/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorCellBehavior;
/*    */ import com.cashloan.cl.mapper.OperatorCellBehaviorMapper;
/*    */ import com.cashloan.cl.service.OperatorCellBehaviorService;
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
/*    */ @Service("operatorCellBehaviorService")
/*    */ public class OperatorCellBehaviorServiceImpl
/*    */   extends BaseServiceImpl<OperatorCellBehavior, Long>
/*    */   implements OperatorCellBehaviorService
/*    */ {
/* 35 */   private static final Logger logger = LoggerFactory.getLogger(OperatorCellBehaviorServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorCellBehaviorMapper operatorCellBehaviorMapper;
/*    */   
/*    */   public BaseMapper<OperatorCellBehavior, Long> getMapper()
/*    */   {
/* 42 */     return this.operatorCellBehaviorMapper;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<OperatorCellBehavior> listSelective(Map<String, Object> paramsMap)
/*    */   {
/* 48 */     long userId = ((Long)paramsMap.get("userId")).longValue();
/* 49 */     String tableBehavior = ShardTableUtil.generateTableNameById("cl_operator_cell_behavior", userId, 30000L);
/* 50 */     int countBehavior = this.operatorCellBehaviorMapper.countTable(tableBehavior);
/* 51 */     if (countBehavior == 0) {
/* 52 */       this.operatorCellBehaviorMapper.createTable(tableBehavior);
/*    */     }
/* 54 */     return this.operatorCellBehaviorMapper.listShardSelective(tableBehavior, paramsMap);
/*    */   }
/*    */ }
