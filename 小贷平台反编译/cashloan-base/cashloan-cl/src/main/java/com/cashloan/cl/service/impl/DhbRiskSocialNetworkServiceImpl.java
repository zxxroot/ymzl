/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.DhbRiskSocialNetwork;
/*    */ import com.cashloan.cl.mapper.DhbRiskSocialNetworkMapper;
/*    */ import com.cashloan.cl.service.DhbRiskSocialNetworkService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
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
/*    */ @Service("dhbRiskSocialNetworkService")
/*    */ public class DhbRiskSocialNetworkServiceImpl
/*    */   extends BaseServiceImpl<DhbRiskSocialNetwork, Long>
/*    */   implements DhbRiskSocialNetworkService
/*    */ {
/*    */   @Resource
/*    */   private DhbRiskSocialNetworkMapper dhbRiskSocialNetworkMapper;
/*    */   
/*    */   public BaseMapper<DhbRiskSocialNetwork, Long> getMapper()
/*    */   {
/* 31 */     return this.dhbRiskSocialNetworkMapper;
/*    */   }
/*    */   
/*    */   public DhbRiskSocialNetwork findSelective(Map<String, Object> paramMap)
/*    */   {
/* 36 */     List<DhbRiskSocialNetwork> list = this.dhbRiskSocialNetworkMapper.listSelective(paramMap);
/* 37 */     if ((list == null) || (list.isEmpty())) {
/* 38 */       return new DhbRiskSocialNetwork();
/*    */     }
/* 40 */     return (DhbRiskSocialNetwork)list.get(0);
/*    */   }
/*    */ }


/*impl\DhbRiskSocialNetworkServiceImpl.class

 */