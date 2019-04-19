/*    */ package com.rongdu.creditrank.cr.model.srule.model;
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
/*    */ public enum Formula
/*    */ {
/* 15 */   greater(
/* 16 */     ">", ">"), 
/* 17 */   less(
/* 18 */     "<", "<"), 
/* 19 */   equal(
/* 20 */     "=", "="), 
/* 21 */   not_equal(
/* 22 */     "!=", "!="), 
/* 23 */   greater_equal(
/* 24 */     ">=", ">="), 
/* 25 */   less_equal(
/* 26 */     "<=", "<="), 
/*    */   
/*    */ 
/* 29 */   greater_equal_and_less_equal(
/* 30 */     "<=and<=", "<=and<="), 
/* 31 */   greater_equal_and_less(
/* 32 */     "<=and<", "<=and<"), 
/* 33 */   greater_and_less_equal(
/* 34 */     "<and<=", "<and<="), 
/* 35 */   greater_and_less(
/* 36 */     "<and<", "<and<"), 
/*    */   
/*    */ 
/* 39 */   include(
/* 40 */     "include", "include"), 
/* 41 */   exclude(
/* 42 */     "exclude", "exclude");
/*    */   
/*    */ 
/*    */   private String name;
/*    */   
/*    */   private String index;
/*    */   
/*    */   private Formula(String name, String index)
/*    */   {
/* 51 */     this.name = name;
/* 52 */     this.index = index;
/*    */   }
/*    */   
/*    */   public static String getName(String index) { Formula[] arrayOfFormula;
/* 56 */     int j = (arrayOfFormula = values()).length; for (int i = 0; i < j; i++) { Formula c = arrayOfFormula[i];
/* 57 */       if (c.getIndex().equals(index)) {
/* 58 */         return c.name;
/*    */       }
/*    */     }
/* 61 */     return null;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 65 */     return this.name;
/*    */   }
/*    */   
/* 68 */   public void setName(String name) { this.name = name; }
/*    */   
/*    */   public String getIndex() {
/* 71 */     return this.index;
/*    */   }
/*    */   
/* 74 */   public void setIndex(String index) { this.index = index; }
/*    */ }
