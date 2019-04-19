/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.DhbHistoryOrg;
/*    */ import com.cashloan.cl.mapper.DhbHistoryOrgMapper;
/*    */ import com.cashloan.cl.service.DhbHistoryOrgService;
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
/*    */ 
/*    */ @Service("dhbHistoryOrgService")
/*    */ public class DhbHistoryOrgServiceImpl
/*    */   extends BaseServiceImpl<DhbHistoryOrg, Long>
/*    */   implements DhbHistoryOrgService
/*    */ {
/* 34 */   private static final Logger logger = LoggerFactory.getLogger(DhbHistoryOrgServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private DhbHistoryOrgMapper dhbHistoryOrgMapper;
/*    */   
/*    */   public BaseMapper<DhbHistoryOrg, Long> getMapper()
/*    */   {
/* 41 */     return this.dhbHistoryOrgMapper;
/*    */   }
/*    */   
/*    */   public DhbHistoryOrg findSelective(Map<String, Object> map)
/*    */   {
/* 46 */     List<DhbHistoryOrg> list = this.dhbHistoryOrgMapper.listSelective(map);
/* 47 */     if ((list == null) || (list.isEmpty())) {
/* 48 */       return new DhbHistoryOrg();
/*    */     }
/* 50 */     return (DhbHistoryOrg)list.get(0);
/*    */   }
/*    */ }
