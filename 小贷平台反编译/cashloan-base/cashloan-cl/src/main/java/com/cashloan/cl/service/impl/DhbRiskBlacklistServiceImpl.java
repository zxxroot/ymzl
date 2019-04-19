/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.DhbRiskBlacklist;
/*    */ import com.cashloan.cl.mapper.DhbRiskBlacklistMapper;
/*    */ import com.cashloan.cl.service.DhbRiskBlacklistService;
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
/*    */ @Service("dhbRiskBlacklistService")
/*    */ public class DhbRiskBlacklistServiceImpl
/*    */   extends BaseServiceImpl<DhbRiskBlacklist, Long>
/*    */   implements DhbRiskBlacklistService
/*    */ {
/* 33 */   private static final Logger logger = LoggerFactory.getLogger(DhbRiskBlacklistServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private DhbRiskBlacklistMapper dhbRiskBlacklistMapper;
/*    */   
/*    */   public BaseMapper<DhbRiskBlacklist, Long> getMapper()
/*    */   {
/* 40 */     return this.dhbRiskBlacklistMapper;
/*    */   }
/*    */   
/*    */   public DhbRiskBlacklist findSelective(Map<String, Object> paramMap)
/*    */   {
/* 45 */     List<DhbRiskBlacklist> list = this.dhbRiskBlacklistMapper.listSelective(paramMap);
/* 46 */     if ((list == null) || (list.isEmpty())) {
/* 47 */       return new DhbRiskBlacklist();
/*    */     }
/* 49 */     return (DhbRiskBlacklist)list.get(0);
/*    */   }
/*    */ }


/*impl\DhbRiskBlacklistServiceImpl.class

 */