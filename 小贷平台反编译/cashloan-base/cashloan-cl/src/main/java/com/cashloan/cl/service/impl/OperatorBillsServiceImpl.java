/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorBills;
/*    */ import com.cashloan.cl.mapper.OperatorBillsMapper;
/*    */ import com.cashloan.cl.model.OperatorBillsModel;
/*    */ import com.cashloan.cl.service.OperatorBillsService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
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
/*    */ @Service("operatorBillsService")
/*    */ @Transactional(rollbackFor={Exception.class})
/*    */ public class OperatorBillsServiceImpl
/*    */   extends BaseServiceImpl<OperatorBills, Long>
/*    */   implements OperatorBillsService
/*    */ {
/*    */   @Resource
/*    */   private OperatorBillsMapper operatorBillsMapper;
/*    */   
/*    */   public BaseMapper<OperatorBills, Long> getMapper()
/*    */   {
/* 40 */     return this.operatorBillsMapper;
/*    */   }
/*    */   
/*    */   public void saveRecords(List<OperatorBillsModel> bills) throws Exception
/*    */   {
/* 45 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 46 */     for (OperatorBillsModel tempBill : bills) {
/* 47 */       OperatorBills bill = tempBill;
/* 48 */       bill.setBillMonthDateStart(sdf.parse(tempBill.getBillMonthDate().substring(0, 10) + " 00:00:00"));
/* 49 */       bill.setBillMonthDateEnd(sdf.parse(tempBill.getBillMonthDate().substring(11, 21) + " 23:59:59"));
/* 50 */       this.operatorBillsMapper.save(bill);
/*    */     }
/*    */   }
/*    */ }
