/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.BorrowRiskData;
/*    */ import com.cashloan.cl.mapper.BorrowRiskDataMapper;
/*    */ import com.cashloan.cl.service.BorrowRiskDataService;
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
/*    */ @Service("borrowRiskDataService")
/*    */ public class BorrowRiskDataServiceImpl
/*    */   extends BaseServiceImpl<BorrowRiskData, Long>
/*    */   implements BorrowRiskDataService
/*    */ {
/* 33 */   private static final Logger logger = LoggerFactory.getLogger(BorrowRiskDataServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private BorrowRiskDataMapper borrowRiskDataMapper;
/*    */   
/*    */   public BaseMapper<BorrowRiskData, Long> getMapper()
/*    */   {
/* 40 */     return this.borrowRiskDataMapper;
/*    */   }
/*    */   
/*    */   public List<BorrowRiskData> listSelective(Map<String, Object> params)
/*    */   {
/* 45 */     return this.borrowRiskDataMapper.listSelective(params);
/*    */   }
/*    */ }


/*impl\BorrowRiskDataServiceImpl.class

 */