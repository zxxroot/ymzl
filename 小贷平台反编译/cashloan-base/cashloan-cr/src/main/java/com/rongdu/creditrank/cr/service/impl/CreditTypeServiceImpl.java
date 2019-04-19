/*    */ package com.rongdu.creditrank.cr.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.creditrank.cr.domain.CreditType;
/*    */ import com.rongdu.creditrank.cr.mapper.CreditTypeMapper;
/*    */ import com.rongdu.creditrank.cr.model.CreditRatingModel;
/*    */ import com.rongdu.creditrank.cr.model.CreditTypeModel;
/*    */ import com.rongdu.creditrank.cr.service.CreditTypeService;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ @Service("creditTypeService")
/*    */ public class CreditTypeServiceImpl
/*    */   extends BaseServiceImpl<CreditType, Long>
/*    */   implements CreditTypeService
/*    */ {
/*    */   @Resource
/*    */   private CreditTypeMapper creditTypeMapper;
/*    */   
/*    */   public BaseMapper<CreditType, Long> getMapper()
/*    */   {
/* 42 */     return this.creditTypeMapper;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<CreditTypeModel> findAllCreditType()
/*    */   {
/* 48 */     List<CreditType> list = this.creditTypeMapper.listSelective(null);
/* 49 */     List<CreditTypeModel> rtList = new ArrayList();
/* 50 */     if ((list != null) && (!list.isEmpty())) {
/* 51 */       for (int i = 0; i < list.size(); i++) {
/* 52 */         CreditTypeModel info = this.creditTypeMapper.findCreditTypeInfo((CreditType)list.get(i));
/* 53 */         rtList.add(info);
/*    */       }
/*    */     }
/* 56 */     return rtList;
/*    */   }
/*    */   
/*    */   public CreditTypeModel findCreditTypeInfo(CreditType creditType)
/*    */   {
/* 61 */     if ((creditType != null) && (creditType.getId() != null)) {
/* 62 */       return this.creditTypeMapper.findCreditTypeInfo(creditType);
/*    */     }
/* 64 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Map<Long, String>> findUnUsedBorrowType()
/*    */   {
/* 71 */     return this.creditTypeMapper.findUnUsedBorrowType();
/*    */   }
/*    */   
/*    */   public List<CreditRatingModel> findEditBorrowType(Long typeId)
/*    */   {
/* 76 */     return this.creditTypeMapper.findEditBorrowType(typeId);
/*    */   }
/*    */   
/*    */   public List<CreditType> findCreditType(Map<String, Object> params)
/*    */   {
/* 81 */     return this.creditTypeMapper.listSelective(params);
/*    */   }
/*    */ }
