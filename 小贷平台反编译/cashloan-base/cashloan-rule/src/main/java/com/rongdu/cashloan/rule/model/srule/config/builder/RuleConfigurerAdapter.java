/*    */ package com.rongdu.cashloan.rule.model.srule.config.builder;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.model.srule.config.rule.Rule;
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
/* 17 */     if (this.ruleBuilder == null) {
/* 18 */       throw new IllegalStateException("ruleBuilder cannot be null");
/*    */     }
/* 20 */     return this.ruleBuilder;
/*    */   }
/*    */   
/*    */   public void setBuilder(B builder) {
/* 24 */     this.ruleBuilder = builder;
/*    */   }
/*    */   
/*    */   public Rule build()
/*    */     throws Exception
/*    */   {
/* 30 */     return this.ruleBuilder.build();
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\model\srule\config\builder\RuleConfigurerAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */