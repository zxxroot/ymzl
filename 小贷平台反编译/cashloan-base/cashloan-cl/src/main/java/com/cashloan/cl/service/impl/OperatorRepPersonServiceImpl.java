/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorRepPerson;
/*    */ import com.cashloan.cl.mapper.OperatorRepPersonMapper;
/*    */ import com.cashloan.cl.service.OperatorRepPersonService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
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
/*    */ @Service("operatorRepPersonService")
/*    */ public class OperatorRepPersonServiceImpl
/*    */   extends BaseServiceImpl<OperatorRepPerson, Long>
/*    */   implements OperatorRepPersonService
/*    */ {
/* 32 */   private static final Logger logger = LoggerFactory.getLogger(OperatorRepPersonServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OperatorRepPersonMapper operatorRepPersonMapper;
/*    */   
/*    */   public BaseMapper<OperatorRepPerson, Long> getMapper()
/*    */   {
/* 39 */     return this.operatorRepPersonMapper;
/*    */   }
/*    */   
/*    */   public OperatorRepPerson findSelective(Map<String, Object> paramsMap)
/*    */   {
/* 44 */     return (OperatorRepPerson)this.operatorRepPersonMapper.findSelective(paramsMap);
/*    */   }
/*    */ }
