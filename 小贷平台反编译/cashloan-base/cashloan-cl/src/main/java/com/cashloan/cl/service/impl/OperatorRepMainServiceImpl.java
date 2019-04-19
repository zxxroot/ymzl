/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorRepMain;
/*    */ import com.cashloan.cl.mapper.OperatorRepMainMapper;
/*    */ import com.cashloan.cl.service.OperatorRepMainService;
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
/*    */ @Service("operatorRepMainService")
/*    */ public class OperatorRepMainServiceImpl
/*    */   extends BaseServiceImpl<OperatorRepMain, Long>
/*    */   implements OperatorRepMainService
/*    */ {
/* 34 */   private static final Logger logger = LoggerFactory.getLogger(OperatorRepMainServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorRepMainMapper operatorRepMainMapper;
/*    */   
/*    */   public BaseMapper<OperatorRepMain, Long> getMapper()
/*    */   {
/* 41 */     return this.operatorRepMainMapper;
/*    */   }
/*    */   
/*    */   public List<OperatorRepMain> listSelective(Map<String, Object> paramsMap)
/*    */   {
/* 46 */     long userId = ((Long)paramsMap.get("userId")).longValue();
/* 47 */     String tableMainService = ShardTableUtil.generateTableNameById("cl_operator_rep_main_service", userId, 30000L);
/* 48 */     int countTableMain = this.operatorRepMainMapper.countTable(tableMainService);
/* 49 */     if (countTableMain == 0) {
/* 50 */       this.operatorRepMainMapper.createTable(tableMainService);
/*    */     }
/* 52 */     return this.operatorRepMainMapper.listShardSelective(tableMainService, paramsMap);
/*    */   }
/*    */ }
