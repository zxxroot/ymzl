/*    */ package com.rongdu.cashloan.rule.model.srule.config.core;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.model.srule.config.rule.Rule;
/*    */ import com.rongdu.cashloan.rule.model.srule.exception.RuleNotFoundException;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractRulesLogic
/*    */   implements RulesLogic
/*    */ {
/*    */   protected List<Rule> ruleList;
/* 18 */   protected Map<Long, Boolean> resultMap = new HashMap();
/*    */   
/*    */   public Map<Long, Boolean> rulesResult() throws RuleNotFoundException
/*    */   {
/* 22 */     if ((this.ruleList == null) || (this.ruleList.size() == 0)) {
/* 23 */       throw new RuleNotFoundException("can not found rules to be matched! ");
/*    */     }
/* 25 */     return this.resultMap;
/*    */   }
/*    */ }
