/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */
/*    */

import com.cashloan.cl.domain.BorrowRepayLog;
import tool.util.DateUtil;
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
/*    */ public class BorrowRepayLogModel
/*    */   extends BorrowRepayLog
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String REPAY_WAY_CHARGE = "10";
/*    */   public static final String REPAY_WAY_TRANSFER = "20";
/*    */   public static final String REPAY_WAY_ALIPAY_TRANSFER = "30";
/*    */   public static final String REPAY_WAY_AUTH = "40";
/*    */   private String repayTimeStr;
/*    */   
/*    */   public String getRepayTimeStr()
/*    */   {
/* 35 */     this.repayTimeStr = DateUtil.dateStr(getRepayTime(), "yyyy-MM-dd HH:mm");
/* 36 */     return this.repayTimeStr;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setRepayTimeStr(String repayTimeStr)
/*    */   {
/* 45 */     this.repayTimeStr = repayTimeStr;
/*    */   }
/*    */ }
