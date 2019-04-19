/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.domain.OperatorVoicesContact;
/*    */ import com.cashloan.cl.mapper.OperatorVoicesContactMapper;
/*    */ import com.cashloan.cl.service.OperatorVoicesContactService;
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
/*    */ @Service("operatorVoicesContactService")
/*    */ public class OperatorVoicesContactServiceImpl
/*    */   extends BaseServiceImpl<OperatorVoicesContact, Long>
/*    */   implements OperatorVoicesContactService
/*    */ {
/* 36 */   private static final Logger logger = LoggerFactory.getLogger(OperatorVoicesContactServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorVoicesContactMapper operatorVoicesContactMapper;
/*    */   
/*    */   public BaseMapper<OperatorVoicesContact, Long> getMapper()
/*    */   {
/* 43 */     return this.operatorVoicesContactMapper;
/*    */   }
/*    */   
/*    */ 
/*    */   public Page<OperatorVoicesContact> findShardPage(Map<String, Object> params, int current, int pageSize)
/*    */   {
/* 49 */     long userId = ((Long)params.get("userId")).longValue();
/*    */     
/* 51 */     String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices_contact", userId, 30000L);
/* 52 */     int countTable = this.operatorVoicesContactMapper.countTable(tableName);
/* 53 */     if (countTable == 0) {
/* 54 */       this.operatorVoicesContactMapper.createTable(tableName);
/*    */     }
/* 56 */     params.put("orderBy", "last_call_time DESC");
/* 57 */     PageHelper.startPage(current, pageSize);
/* 58 */     List<OperatorVoicesContact> list = this.operatorVoicesContactMapper.listShardSelective(tableName, params);
/* 59 */     return (Page)list;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<OperatorVoicesContact> listSelective(Map<String, Object> paramsMap)
/*    */   {
/* 65 */     long userId = ((Long)paramsMap.get("userId")).longValue();
/*    */     
/* 67 */     String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices_contact", userId, 30000L);
/* 68 */     int countTable = this.operatorVoicesContactMapper.countTable(tableName);
/* 69 */     if (countTable == 0) {
/* 70 */       this.operatorVoicesContactMapper.createTable(tableName);
/*    */     }
/* 72 */     return this.operatorVoicesContactMapper.listShardSelective(tableName, paramsMap);
/*    */   }
/*    */ }


/*impl\OperatorVoicesContactServiceImpl.class

 */