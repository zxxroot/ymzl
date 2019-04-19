/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.rc.domain.PhoneCallBaseCount;
/*    */ import com.rongdu.cashloan.rc.mapper.PhoneCallBaseCountMapper;
/*    */ import com.rongdu.cashloan.rc.service.PhoneCallBaseCountService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("phoneCallBaseCountService")
/*    */ public class PhoneCallBaseCountServiceImpl
/*    */   extends BaseServiceImpl<PhoneCallBaseCount, Long>
/*    */   implements PhoneCallBaseCountService
/*    */ {
/*    */   @Resource
/*    */   private PhoneCallBaseCountMapper phoneCallBaseCountMapper;
/*    */   
/*    */   public BaseMapper<PhoneCallBaseCount, Long> getMapper()
/*    */   {
/* 33 */     return this.phoneCallBaseCountMapper;
/*    */   }
/*    */ }
