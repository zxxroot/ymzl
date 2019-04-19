/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */

import com.cashloan.cl.domain.OperatorBasic;
import com.cashloan.cl.mapper.OperatorBasicMapper;
import com.cashloan.cl.service.OperatorBasicService;
import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
/*    */ @Service("operatorBasicService")
/*    */ public class OperatorBasicServiceImpl
/*    */   extends BaseServiceImpl<OperatorBasic, Long>
/*    */   implements OperatorBasicService
/*    */ {
/*    */   @Resource
/*    */   private OperatorBasicMapper operatorBasicMapper;
/*    */   
/*    */   public BaseMapper<OperatorBasic, Long> getMapper()
/*    */   {
/* 39 */     return this.operatorBasicMapper;
/*    */   }
/*    */   
/*    */   public void saveRecords(List<OperatorBasic> basics) throws BussinessException
/*    */   {
/* 44 */     for (OperatorBasic basic : basics) {
/* 45 */       this.operatorBasicMapper.save(basic);
/*    */     }
/*    */   }
/*    */   
/*    */   public void countOperatorVoice(Long userId)
/*    */     throws BussinessException
/*    */   {}
/*    */   
/*    */   public void countOperatorBorrow(Long userId)
/*    */     throws BussinessException
/*    */   {}
/*    */ }
