/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.OperatorTdCallInfo;
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
/*    */ public class OperatorTdCallInfoModel
/*    */   extends OperatorTdCallInfo
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String callRecord;
/*    */   
/*    */   public String getCallRecord()
/*    */   {
/* 24 */     return this.callRecord;
/*    */   }
/*    */   
/* 27 */   public void setCallRecord(String callRecord) { this.callRecord = callRecord; }
/*    */ }
