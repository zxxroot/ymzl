/*    */ package com.rongdu.creditrank.cr.model;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.domain.Info;
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
/*    */ public class InfoModel
/*    */   extends Info
/*    */ {
/*    */   private List children;
/*    */   
/*    */   public List getChildren()
/*    */   {
/* 28 */     return this.children;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setChildren(List children)
/*    */   {
/* 37 */     this.children = children;
/*    */   }
/*    */ }
