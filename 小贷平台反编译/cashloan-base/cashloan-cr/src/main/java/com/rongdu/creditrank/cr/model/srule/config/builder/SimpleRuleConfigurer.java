/*    */ package com.rongdu.creditrank.cr.model.srule.config.builder;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.RuleBasic;
/*    */ import com.rongdu.creditrank.cr.model.srule.utils.RulePolicy;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleRuleConfigurer<H, O extends Rule, B extends AbstractRuleBuilder<H, O>>
/*    */   extends RuleConfigurerAdapter<H, O, B>
/*    */ {
/*    */   public RuleConfigurer<H> rulePolicy(RulePolicy rulePolicy)
/*    */   {
/* 18 */     RuleBasic ruleBasic = (RuleBasic)threadLocalRules.get();
/* 19 */     ruleBasic.setRulePolicy(rulePolicy);
/* 20 */     return this;
/*    */   }
/*    */   
/*    */   public RuleConfigurer<H> preLoad(Map<H, Integer> map)
/*    */   {
/* 25 */     RuleBasic<H> ruleBasic = (RuleBasic)threadLocalRules.get();
/* 26 */     ruleBasic.setPreLoad(map);
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public RuleConfigurer<H> name(String name)
/*    */   {
/* 32 */     RuleBasic<H> ruleBasic = (RuleBasic)threadLocalRules.get();
/* 33 */     ruleBasic.setName(name);
/* 34 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\model\srule\config\builder\SimpleRuleConfigurer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */