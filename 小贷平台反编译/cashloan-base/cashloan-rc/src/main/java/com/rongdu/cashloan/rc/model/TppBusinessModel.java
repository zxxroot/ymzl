/*    */ package com.rongdu.cashloan.rc.model;
/*    */ 
/*    */ import com.rongdu.cashloan.rc.domain.TppBusiness;
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
/*    */ 
/*    */ 
/*    */ public class TppBusinessModel
/*    */   extends TppBusiness
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String BUS_NID_QCRISK = "QcRisk";
/*    */   public static final String BUS_NID_TONGDUN = "TongdunApply";
/*    */   private String tppNid;
/*    */   
/*    */   public String getTppNid()
/*    */   {
/* 34 */     return this.tppNid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setTppNid(String tppNid)
/*    */   {
/* 43 */     this.tppNid = tppNid;
/*    */   }
/*    */ }
