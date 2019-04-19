/*    */ package com.rongdu.creditrank.cr.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.creditrank.cr.domain.CrResult;
/*    */ import com.rongdu.creditrank.cr.mapper.CrResultMapper;
/*    */ import com.rongdu.creditrank.cr.service.CrResultService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("crResultService")
/*    */ public class CrResultServiceImpl
/*    */   extends BaseServiceImpl<CrResult, Long>
/*    */   implements CrResultService
/*    */ {
/*    */   @Resource
/*    */   private CrResultMapper crResultMapper;
/*    */   
/*    */   public BaseMapper<CrResult, Long> getMapper()
/*    */   {
/* 38 */     return this.crResultMapper;
/*    */   }
/*    */   
/*    */   public Map<String, Object> findUserResult(Long userId)
/*    */   {
/* 43 */     return this.crResultMapper.findUserResult(userId);
/*    */   }
/*    */   
/*    */   public List<CrResult> findAllBorrowTypeResult(Long userId)
/*    */   {
/* 48 */     return this.crResultMapper.findAllBorrowTypeResult(userId);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\CrResultServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */