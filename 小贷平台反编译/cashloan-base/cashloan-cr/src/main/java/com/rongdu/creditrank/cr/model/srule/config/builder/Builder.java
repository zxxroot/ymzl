/*    */ package com.rongdu.creditrank.cr.model.srule.config.builder;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.RuleBasic;
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
/*    */ public abstract interface Builder
/*    */ {
/* 17 */   public static final ThreadLocal<RuleBasic> threadLocalRules = new ThreadLocal();
/*    */   
/*    */   public abstract Rule build()
/*    */     throws Exception;
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\model\srule\config\builder\Builder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */