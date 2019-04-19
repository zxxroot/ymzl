/*    */ package com.rongdu.cashloan.rule.model.srule.config.builder;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.model.srule.config.rule.Rule;
/*    */ import com.rongdu.cashloan.rule.model.srule.config.rule.RuleBasic;
/*    */ import com.rongdu.cashloan.rule.model.srule.utils.RulePolicy;
/*    */ import java.util.Map;
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
/* 17 */     RuleBasic ruleBasic = (RuleBasic)threadLocalRules.get();
/* 18 */     ruleBasic.setRulePolicy(rulePolicy);
/* 19 */     return this;
/*    */   }
/*    */   
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
