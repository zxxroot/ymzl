/*    */ package com.rongdu.creditrank.cr.model.srule.config.core;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;

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
/*    */ 
/*    */ public class RulesExecutor
/*    */ {
/*    */   public static RulesLogic newNoneRelationRulesLogic()
/*    */   {
/* 22 */     return new NoneRelationRulesLogic();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class NoneRelationRulesLogic
/*    */     extends AbstractRulesLogic
/*    */   {
/*    */     public boolean doLogic(List<Rule> list)
/*    */     {
/* 31 */       this.ruleList = list;
/*    */       
/* 33 */       for (Rule rule : list) {
/* 34 */         boolean matchResult = rule.beginMatch();
/* 35 */         this.resultMap.put(Long.valueOf(rule.getId()), Boolean.valueOf(matchResult));
/*    */       }
/* 37 */       return true;
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
/* 48 */       return false;
/*    */     }
/*    */   }
/*    */ }
