/*    */ package com.rongdu.creditrank.cr.domain;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class Rank
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Long id;
/*    */   private String rankName;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 38 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId(Long id)
/*    */   {
/* 47 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getRankName()
/*    */   {
/* 55 */     return this.rankName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setRankName(String rankName)
/*    */   {
/* 63 */     this.rankName = rankName;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\domain\Rank.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */