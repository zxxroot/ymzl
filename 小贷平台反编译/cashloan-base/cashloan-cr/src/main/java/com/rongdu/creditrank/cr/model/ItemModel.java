/*    */ package com.rongdu.creditrank.cr.model;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.domain.Item;
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
/*    */ public class ItemModel
/*    */   extends Item
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private List children;
/*    */   private String article;
/*    */   private String weight;
/*    */   
/*    */   public List getChildren()
/*    */   {
/* 42 */     return this.children;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setChildren(List children)
/*    */   {
/* 51 */     this.children = children;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getArticle()
/*    */   {
/* 59 */     return this.article;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setArticle(String article)
/*    */   {
/* 67 */     this.article = article;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getWeight()
/*    */   {
/* 75 */     return this.weight;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setWeight(String weight)
/*    */   {
/* 83 */     this.weight = weight;
/*    */   }
/*    */ }
