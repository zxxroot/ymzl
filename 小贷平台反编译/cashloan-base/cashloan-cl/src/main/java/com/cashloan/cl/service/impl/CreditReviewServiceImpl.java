/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.mapper.ClBorrowMapper;
/*    */ import com.cashloan.cl.model.CreditReviewTotalModel;
/*    */ import com.cashloan.cl.service.CreditReviewService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
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
/*    */ @Service("creditReviewService")
/*    */ public class CreditReviewServiceImpl
/*    */   implements CreditReviewService
/*    */ {
/*    */   @Autowired
/*    */   private ClBorrowMapper clBorrowMapper;
/*    */   
/*    */   public Page<CreditReviewTotalModel> memberCount(Map<String, Object> params, int current, int pageSize)
/*    */   {
/* 32 */     params = params == null ? new HashMap() : params;
/* 33 */     params.put("roleNid", "riskControlPersonnel");
/* 34 */     PageHelper.startPage(current, pageSize);
/* 35 */     List<CreditReviewTotalModel> modelList = this.clBorrowMapper.listSysUserByRole(params);
/* 36 */     return (Page)modelList;
/*    */   }
/*    */ }


/*impl\CreditReviewServiceImpl.class

 */