/*    */ package com.rongdu.cashloan.rule.model.srule.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ConditionOpt
/*    */ {
/* 10 */   BIGGER(">"), 
/* 11 */   BIGGER_EQUAL(">="), 
/* 12 */   SMALL("<"), 
/* 13 */   SMALL_EQUAL("<="), 
/* 14 */   EQUAL("="), 
/* 15 */   NOT_EQUAL("!="), 
/* 16 */   INCLUDE("include"), 
/* 17 */   NOT_INCLUDE("exclude");
/*    */   
/*    */   private String value;
/*    */   
/*    */   private ConditionOpt(String opt)
/*    */   {
/* 23 */     this.value = opt;
/*    */   }
/*    */   
/*    */   public String getValue()
/*    */   {
/* 28 */     return this.value;
/*    */   }
/*    */   
/*    */   public static ConditionOpt getOpt(String opt)
/*    */   {
/* 33 */     if (opt != null) {
/* 34 */       ConditionOpt[] values = values();
/* 35 */       ConditionOpt[] arrayOfConditionOpt1; int j = (arrayOfConditionOpt1 = values).length; for (int i = 0; i < j; i++) { ConditionOpt each = arrayOfConditionOpt1[i];
/* 36 */         if (each.value.equals(opt)) {
/* 37 */           return each;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 42 */     return null;
/*    */   }
/*    */ }
