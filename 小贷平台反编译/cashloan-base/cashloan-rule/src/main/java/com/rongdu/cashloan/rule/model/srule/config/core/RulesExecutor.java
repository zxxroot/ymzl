/*    */ package com.rongdu.cashloan.rule.model.srule.config.core;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.model.srule.config.rule.Rule;

import java.util.List;

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
/*    */ public class RulesExecutor
/*    */ {
/*    */   public static RulesLogic newNoneRelationRulesLogic()
/*    */   {
/* 21 */     return new NoneRelationRulesLogic();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class NoneRelationRulesLogic
/*    */     extends AbstractRulesLogic
/*    */   {
/*    */     public boolean doLogic(List<Rule> list)
/*    */     {
/* 30 */       this.ruleList = list;
/*    */       
/* 32 */       for (Rule rule : list) {
/* 33 */         boolean matchResult = rule.beginMatch();
/* 34 */         this.resultMap.put(Long.valueOf(rule.getId()), Boolean.valueOf(matchResult));
/*    */       }
/* 36 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private static class ComplexRelationRulesLogic
/*    */     extends AbstractRulesLogic
/*    */   {
/*    */     public boolean doLogic(List<Rule> list)
/*    */     {
/* 47 */       return false;
/*    */     }
/*    */   }
/*    */ }
