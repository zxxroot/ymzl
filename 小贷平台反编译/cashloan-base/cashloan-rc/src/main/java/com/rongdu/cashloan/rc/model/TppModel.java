/*    */ package com.rongdu.cashloan.rc.model;
/*    */ 
/*    */ import com.rongdu.cashloan.rc.domain.Tpp;
/*    */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*    */ import java.util.List;
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
/*    */ public class TppModel
/*    */   extends Tpp
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private List<TppBusiness> businessList;
/*    */   
/*    */   public List<TppBusiness> getBusinessList()
/*    */   {
/* 31 */     return this.businessList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setBusinessList(List<TppBusiness> businessList)
/*    */   {
/* 39 */     this.businessList = businessList;
/*    */   }
/*    */ }
