/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.rc.domain.PhoneCallBorrowCount;
/*    */ import com.rongdu.cashloan.rc.mapper.PhoneCallBorrowCountMapper;
/*    */ import com.rongdu.cashloan.rc.service.PhoneCallBorrowCountService;
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
/*    */ @Service("phoneCallBorrowCountService")
/*    */ public class PhoneCallBorrowCountServiceImpl
/*    */   extends BaseServiceImpl<PhoneCallBorrowCount, Long>
/*    */   implements PhoneCallBorrowCountService
/*    */ {
/*    */   @Resource
/*    */   private PhoneCallBorrowCountMapper phoneCallBorrowCountMapper;
/*    */   
/*    */   public BaseMapper<PhoneCallBorrowCount, Long> getMapper()
/*    */   {
/* 33 */     return this.phoneCallBorrowCountMapper;
/*    */   }
/*    */ }
