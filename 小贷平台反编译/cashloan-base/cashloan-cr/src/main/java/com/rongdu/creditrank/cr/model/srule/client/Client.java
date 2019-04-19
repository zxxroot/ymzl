/*    */ package com.rongdu.creditrank.cr.model.srule.client;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.model.srule.config.builder.RuleBuilder;
import com.rongdu.creditrank.cr.model.srule.config.builder.RuleBuilderCreator;
import com.rongdu.creditrank.cr.model.srule.config.condition.ConditionItem;
import com.rongdu.creditrank.cr.model.srule.config.core.RulesExecutor;
import com.rongdu.creditrank.cr.model.srule.config.core.RulesLogic;
import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
import com.rongdu.creditrank.cr.model.srule.utils.RulePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*    */ public class Client
/*    */ {
/* 24 */   public static final Logger logger = LoggerFactory.getLogger(Client.class);
/*    */   
/*    */   public static void main(String[] args) throws Exception
/*    */   {
/* 28 */     Map<String, Integer> load = new HashMap();
/* 29 */     load.put("博士", Integer.valueOf(3));
/* 30 */     load.put("硕士", Integer.valueOf(2));
/* 31 */     load.put("学士", Integer.valueOf(1));
/*    */     
/*    */ 
/* 34 */     RuleBuilder<String> ruleBuilder = RuleBuilderCreator.stringRuleBuilder();
/*    */     
/*    */ 
/* 37 */     ConditionItem stringItem = ruleBuilder.newConditionItems();
/* 38 */     stringItem.add(">=", "学士");
/* 39 */     stringItem.add("<=", "博士");
/*    */     
/*    */ 
/*    */ 
/* 43 */     Rule rule = ruleBuilder.newRule(1L, "education", stringItem).preLoad(load).rulePolicy(RulePolicy.MATCHALL).build();
/* 44 */     rule.matchTo("硕士");
/* 49 */     RuleBuilder<Double> numRuleBuilder = RuleBuilderCreator.numRuleBuilder();
/*    */     
/*    */ 
/* 52 */     ConditionItem numItems = numRuleBuilder.newConditionItems();
/* 53 */     numItems.add(">=", Integer.valueOf(20));
/* 54 */     numItems.add(">=", Integer.valueOf(30));
/*    */     
/* 56 */     Rule rule2 = numRuleBuilder.newRule(2L, "age", numItems).rulePolicy(RulePolicy.MATCHALL).build();
/* 57 */     rule2.matchTo(Integer.valueOf(25));

/*    */ 
/*    */ 
/* 63 */     ConditionItem includeItem = ruleBuilder.newConditionItems();
/* 64 */     includeItem.add("include", "学士，博士，硕士");
/* 65 */     Rule rule3 = ruleBuilder.newRule(3L, "education", includeItem).rulePolicy(RulePolicy.MATCHALL).build();
/* 66 */     rule3.matchTo("学士");
/*    */     
/* 69 */     List<Rule> list = new ArrayList();
/* 70 */     list.add(rule);
/* 71 */     list.add(rule2);
/* 72 */     list.add(rule3);
/*    */     
/*    */ 
/* 75 */     RulesLogic rulesLogic = RulesExecutor.newNoneRelationRulesLogic();
/*    */     
/* 77 */     rulesLogic.doLogic(list);
/*    */     
/*    */ 
/* 80 */     Map<Long, Boolean> resultMap = rulesLogic.rulesResult();
/*    */   }
/*    */ }
