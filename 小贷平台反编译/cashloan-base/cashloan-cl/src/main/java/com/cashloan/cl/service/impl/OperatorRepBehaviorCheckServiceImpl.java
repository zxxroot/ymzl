/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorRepBehaviorCheck;
/*    */ import com.cashloan.cl.mapper.OperatorRepBehaviorCheckMapper;
/*    */ import com.cashloan.cl.service.OperatorRepBehaviorCheckService;
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
/*    */ @Service("operatorRepBehaviorCheckService")
/*    */ public class OperatorRepBehaviorCheckServiceImpl
/*    */   extends BaseServiceImpl<OperatorRepBehaviorCheck, Long>
/*    */   implements OperatorRepBehaviorCheckService
/*    */ {
/* 34 */   private static final Logger logger = LoggerFactory.getLogger(OperatorRepBehaviorCheckServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorRepBehaviorCheckMapper operatorRepBehaviorCheckMapper;
/*    */   
/*    */   public BaseMapper<OperatorRepBehaviorCheck, Long> getMapper()
/*    */   {
/* 41 */     return this.operatorRepBehaviorCheckMapper;
/*    */   }
/*    */   
/*    */   public List<OperatorRepBehaviorCheck> listSelective(Map<String, Object> paramMap)
/*    */   {
/* 46 */     long userId = ((Long)paramMap.get("userId")).longValue();
/* 47 */     String tableBehaviorCheck = ShardTableUtil.generateTableNameById("cl_operator_rep_behavior_check", userId, 30000L);
/* 48 */     int countTableBehaviorCheck = this.operatorRepBehaviorCheckMapper.countTable(tableBehaviorCheck);
/* 49 */     if (countTableBehaviorCheck == 0) {
/* 50 */       this.operatorRepBehaviorCheckMapper.createTable(tableBehaviorCheck);
/*    */     }
/* 52 */     return this.operatorRepBehaviorCheckMapper.listShardSelective(tableBehaviorCheck, paramMap);
/*    */   }
/*    */ }


/*impl\OperatorRepBehaviorCheckServiceImpl.class

 */