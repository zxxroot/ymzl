/*    */ package com.rongdu.creditrank.cr.model;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.domain.CrResultDetail;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrResultDetailModel
/*    */   extends CrResultDetail
/*    */ {
/*    */   public List<CrResultItemDetail> itemList;
/*    */   
/*    */   public List<CrResultItemDetail> getItemList()
/*    */   {
/* 19 */     return this.itemList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setItemList(List<CrResultItemDetail> itemList)
/*    */   {
/* 27 */     this.itemList = itemList;
/*    */   }
/*    */ }
