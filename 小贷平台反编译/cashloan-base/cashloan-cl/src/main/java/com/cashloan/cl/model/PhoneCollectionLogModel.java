/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import com.cashloan.cl.domain.PhoneCollectionLog;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PhoneCollectionLogModel
/*    */   extends PhoneCollectionLog
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String sysName;
/*    */   
/*    */   public String getSysName()
/*    */   {
/* 17 */     return this.sysName;
/*    */   }
/*    */   
/*    */   public void setSysName(String sysName) {
/* 21 */     this.sysName = sysName;
/*    */   }
/*    */ }
