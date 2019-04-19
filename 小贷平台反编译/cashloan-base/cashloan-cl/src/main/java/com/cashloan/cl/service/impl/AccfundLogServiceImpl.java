/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */
/*    */

import com.cashloan.cl.domain.AccfundLog;
import com.cashloan.cl.mapper.AccfundLogMapper;
import com.cashloan.cl.service.AccfundLogService;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
/*    */ @Service("accfundLogService")
/*    */ public class AccfundLogServiceImpl
/*    */   extends BaseServiceImpl<AccfundLog, Long>
/*    */   implements AccfundLogService
/*    */ {
/* 31 */   private static final Logger logger = LoggerFactory.getLogger(AccfundLogServiceImpl.class);
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private AccfundLogMapper accfundLogMapper;
/*    */   
/*    */ 
/*    */ 
/*    */   public BaseMapper<AccfundLog, Long> getMapper()
/*    */   {
/* 41 */     return this.accfundLogMapper;
/*    */   }
/*    */ }


/*impl\AccfundLogServiceImpl.class

 */