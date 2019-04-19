/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorTdSmsInfo;
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
/*    */ public class OperatorTdSmsInfoModel
/*    */   extends OperatorTdSmsInfo
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String smsRecord;
/*    */   
/*    */   public String getSmsRecord()
/*    */   {
/* 25 */     return this.smsRecord;
/*    */   }
/*    */   
/*    */   public void setSmsRecord(String smsRecord) {
/* 29 */     this.smsRecord = smsRecord;
/*    */   }
/*    */ }
