/*    */ package com.rongdu.creditrank.cr.model.srule.config.builder;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class RuleConfigurerAdapter<H, O extends Rule, B extends AbstractRuleBuilder<H, O>>
/*    */   implements RuleConfigurer<H>
/*    */ {
/*    */   private B ruleBuilder;
/*    */   
/*    */   protected final B getBuilder()
/*    */   {
/* 18 */     if (this.ruleBuilder == null) {
/* 19 */       throw new IllegalStateException("ruleBuilder cannot be null");
/*    */     }
/* 21 */     return this.ruleBuilder;
/*    */   }
/*    */   
/*    */   public void setBuilder(B builder) {
/* 25 */     this.ruleBuilder = builder;
/*    */   }
/*    */   
/*    */   public Rule build()
/*    */     throws Exception
/*    */   {
/* 31 */     return this.ruleBuilder.build();
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\model\srule\config\builder\RuleConfigurerAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */