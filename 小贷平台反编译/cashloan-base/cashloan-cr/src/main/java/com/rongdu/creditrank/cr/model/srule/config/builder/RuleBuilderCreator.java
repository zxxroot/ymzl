/*     */ package com.rongdu.creditrank.cr.model.srule.config.builder;
/*     */ 
/*     */ import com.rongdu.creditrank.cr.model.srule.config.condition.Condition;
import com.rongdu.creditrank.cr.model.srule.config.rule.AbstractRule;
import com.rongdu.creditrank.cr.model.srule.config.rule.RuleBasic;
import com.rongdu.creditrank.cr.model.srule.exception.RuleValueException;
import com.rongdu.creditrank.cr.model.srule.utils.ConditionOpt;
import com.rongdu.creditrank.cr.model.srule.utils.RulePolicy;

import java.util.HashSet;
import java.util.Set;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RuleBuilderCreator
/*     */ {
/*  23 */   private static final RuleBuilder<String> stringRuleBuilder = new StringRuleBuilder();
/*     */   
/*     */ 
/*  26 */   private static final RuleBuilder<Double> numRuleBuilder = new NumRuleBuilder();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RuleBuilder<String> stringRuleBuilder()
/*     */   {
/*  35 */     return stringRuleBuilder;
/*     */   }
/*     */   
/*     */   public static RuleBuilder<Double> numRuleBuilder()
/*     */   {
/*  40 */     return numRuleBuilder;
/*     */   }
/*     */   
/*     */   private static final class StringRuleBuilder
/*     */     extends SimpleRuleBuilder<String, RuleBuilderCreator.StringRule>
/*     */   {
/*     */     protected RuleBasic<String> concrete()
/*     */     {
/*  48 */       return new RuleBuilderCreator.StringRule();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static final class NumRuleBuilder
/*     */     extends SimpleRuleBuilder<Double, RuleBuilderCreator.NumRule>
/*     */   {
/*     */     protected RuleBasic<Double> concrete()
/*     */     {
/*  58 */       return new RuleBuilderCreator.NumRule();
/*     */     }
/*     */   }
/*     */   
/*     */   static final class StringRule
/*     */     extends AbstractRule<String>
/*     */   {
/*     */     public boolean beginMatch()
/*     */       throws RuleValueException
/*     */     {
/*  68 */       Set<Boolean> matchSet = new HashSet();
/*  69 */       for (Condition<String> condition : this.conditions) {
/*  70 */         ConditionOpt opt = condition.getOpt();
/*  71 */         String value = (String)condition.getValue();
/*     */         
/*  73 */         if (this.matchTo == null) {
/*  74 */           throw new RuleValueException("can not found mathTo value!");
/*     */         }
/*  76 */         if (opt == ConditionOpt.INCLUDE) {
/*  77 */           matchSet.add(Boolean.valueOf(value.contains((CharSequence)this.matchTo)));
/*     */ 
/*     */ 
/*     */         }
/*  81 */         else if (opt == ConditionOpt.NOT_INCLUDE) {
/*  82 */           matchSet.add(Boolean.valueOf(!value.contains((CharSequence)this.matchTo)));
/*     */         }
/*     */         else
/*     */         {
/*  86 */           if ((this.preLoad == null) || (this.preLoad.size() == 0)) {
/*  87 */             throw new RuleValueException("StringRule must have preLoad! ");
/*     */           }
/*     */           
/*  90 */           if ((this.preLoad != null) && (!this.preLoad.containsKey(value))) {
/*  91 */             throw new RuleValueException("value : " + value + " is not in the preLoad! ");
/*     */           }
/*     */           
/*  94 */           Integer valueSortId = (Integer)this.preLoad.get(value);
/*     */           
/*  96 */           Integer matchSortId = (Integer)this.preLoad.get(this.matchTo);
/*  97 */           if (matchSortId == null) {
/*  98 */             throw new RuleValueException("matchTo value : " + (String)this.matchTo + " is not found! ");
/*     */           }
/*     */           
/* 101 */           switch (opt) {
/*     */           case BIGGER: 
/* 103 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() > valueSortId.intValue()));
/* 104 */             break;
/*     */           case BIGGER_EQUAL: 
/* 106 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() >= valueSortId.intValue()));
/* 107 */             break;
/*     */           case EQUAL: 
/* 109 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() < valueSortId.intValue()));
/* 110 */             break;
/*     */           case INCLUDE: 
/* 112 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() <= valueSortId.intValue()));
/* 113 */             break;
/*     */           case NOT_EQUAL: 
/* 115 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() == valueSortId.intValue()));
/* 116 */             break;
/*     */           case NOT_INCLUDE: 
/* 118 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() != valueSortId.intValue()));
/* 119 */             break;
/*     */           default: 
/* 121 */             throw new RuleValueException("opt : " + opt + " is not accepted! "); }
/*     */         }
/*     */       }
/* 124 */       boolean isMatch = false;
/* 125 */       if (this.policy == RulePolicy.MATCHALL) {
/* 126 */         if (!matchSet.contains(Boolean.valueOf(false))) {
/* 127 */           isMatch = true;
/*     */         }
/* 129 */       } else if ((this.policy == RulePolicy.MATCHONE) && 
/* 130 */         (matchSet.contains(Boolean.valueOf(true)))) {
/* 131 */         isMatch = true;
/*     */       }
/*     */       
/* 134 */       return isMatch;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static final class NumRule
/*     */     extends AbstractRule<Double>
/*     */   {
/*     */     public boolean beginMatch()
/*     */       throws RuleValueException
/*     */     {
/* 147 */       Set<Boolean> matchSet = new HashSet();
/* 148 */       for (Condition<Double> condition : this.conditions) {
/* 149 */         ConditionOpt opt = condition.getOpt();
/* 150 */         Double value = (Double)condition.getValue();
/*     */         
/* 152 */         if (this.matchTo == null) {
/* 153 */           throw new RuleValueException("can not found mathTo value!");
/*     */         }
/*     */         
/* 156 */         switch (opt) {
/*     */         case BIGGER: 
/* 158 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) == 1));
/* 159 */           break;
/*     */         case BIGGER_EQUAL: 
/* 161 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) != -1));
/* 162 */           break;
/*     */         case EQUAL: 
/* 164 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) == -1));
/* 165 */           break;
/*     */         case INCLUDE: 
/* 167 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) != 1));
/* 168 */           break;
/*     */         case NOT_EQUAL: 
/* 170 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) == 0));
/* 171 */           break;
/*     */         case NOT_INCLUDE: 
/* 173 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) != 0));
/* 174 */           break;
/*     */         default: 
/* 176 */           throw new RuleValueException("opt : " + opt + " is not accepted! ");
/*     */         }
/*     */         
/*     */       }
/* 180 */       boolean isMatch = false;
/* 181 */       if (this.policy == RulePolicy.MATCHALL) {
/* 182 */         if (!matchSet.contains(Boolean.valueOf(false))) {
/* 183 */           isMatch = true;
/*     */         }
/* 185 */       } else if ((this.policy == RulePolicy.MATCHONE) && 
/* 186 */         (matchSet.contains(Boolean.valueOf(true)))) {
/* 187 */         isMatch = true;
/*     */       }
/*     */       
/* 190 */       return isMatch;
/*     */     }
/*     */   }
/*     */ }
