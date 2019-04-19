/*     */ package com.rongdu.cashloan.rule.model.srule.config.builder;
/*     */ 
/*     */ import com.rongdu.cashloan.rule.model.srule.config.condition.Condition;
import com.rongdu.cashloan.rule.model.srule.config.rule.AbstractRule;
import com.rongdu.cashloan.rule.model.srule.config.rule.RuleBasic;
import com.rongdu.cashloan.rule.model.srule.exception.RuleValueException;
import com.rongdu.cashloan.rule.model.srule.utils.ConditionOpt;
import com.rongdu.cashloan.rule.model.srule.utils.RulePolicy;

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
/*     */ 
/*     */ public class RuleBuilderCreator
/*     */ {
/*  24 */   private static final RuleBuilder<String> stringRuleBuilder = new StringRuleBuilder();
/*     */   
/*     */ 
/*  27 */   private static final RuleBuilder<Double> numRuleBuilder = new NumRuleBuilder();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RuleBuilder<String> stringRuleBuilder()
/*     */   {
/*  36 */     return stringRuleBuilder;
/*     */   }
/*     */   
/*     */   public static RuleBuilder<Double> numRuleBuilder()
/*     */   {
/*  41 */     return numRuleBuilder;
/*     */   }
/*     */   
/*     */   private static final class StringRuleBuilder
/*     */     extends SimpleRuleBuilder<String, RuleBuilderCreator.StringRule>
/*     */   {
/*     */     protected RuleBasic<String> concrete()
/*     */     {
/*  49 */       return new RuleBuilderCreator.StringRule();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static final class NumRuleBuilder
/*     */     extends SimpleRuleBuilder<Double, RuleBuilderCreator.NumRule>
/*     */   {
/*     */     protected RuleBasic<Double> concrete()
/*     */     {
/*  59 */       return new RuleBuilderCreator.NumRule();
/*     */     }
/*     */   }
/*     */   
/*     */   static final class StringRule
/*     */     extends AbstractRule<String>
/*     */   {
/*     */     public boolean beginMatch()
/*     */       throws RuleValueException
/*     */     {
/*  69 */       Set<Boolean> matchSet = new HashSet();
/*  70 */       for (Condition<String> condition : this.conditions) {
/*  71 */         ConditionOpt opt = condition.getOpt();
/*  72 */         String value = (String)condition.getValue();
/*     */         
/*  74 */         if (this.matchTo == null) {
/*  75 */           throw new RuleValueException("can not found mathTo value!");
/*     */         }
/*  77 */         if (opt == ConditionOpt.INCLUDE) {
/*  78 */           matchSet.add(Boolean.valueOf(value.contains((CharSequence)this.matchTo)));
/*     */ 
/*     */ 
/*     */         }
/*  82 */         else if (opt == ConditionOpt.NOT_INCLUDE) {
/*  83 */           matchSet.add(Boolean.valueOf(!value.contains((CharSequence)this.matchTo)));
/*     */         }
/*     */         else
/*     */         {
/*  87 */           if ((this.preLoad == null) || (this.preLoad.size() == 0)) {
/*  88 */             throw new RuleValueException("StringRule must have preLoad! ");
/*     */           }
/*     */           
/*  91 */           if ((this.preLoad != null) && (!this.preLoad.containsKey(value))) {
/*  92 */             throw new RuleValueException("value : " + value + " is not in the preLoad! ");
/*     */           }
/*     */           
/*  95 */           Integer valueSortId = (Integer)this.preLoad.get(value);
/*     */           
/*  97 */           Integer matchSortId = (Integer)this.preLoad.get(this.matchTo);
/*  98 */           if (matchSortId == null) {
/*  99 */             throw new RuleValueException("matchTo value : " + (String)this.matchTo + " is not found! ");
/*     */           }
/*     */           
/* 102 */           switch (opt) {
/*     */           case BIGGER: 
/* 104 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() > valueSortId.intValue()));
/* 105 */             break;
/*     */           case BIGGER_EQUAL: 
/* 107 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() >= valueSortId.intValue()));
/* 108 */             break;
/*     */           case EQUAL: 
/* 110 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() < valueSortId.intValue()));
/* 111 */             break;
/*     */           case INCLUDE: 
/* 113 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() <= valueSortId.intValue()));
/* 114 */             break;
/*     */           case NOT_EQUAL: 
/* 116 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() == valueSortId.intValue()));
/* 117 */             break;
/*     */           case NOT_INCLUDE: 
/* 119 */             matchSet.add(Boolean.valueOf(matchSortId.intValue() != valueSortId.intValue()));
/* 120 */             break;
/*     */           default: 
/* 122 */             throw new RuleValueException("opt : " + opt + " is not accepted! "); }
/*     */         }
/*     */       }
/* 125 */       boolean isMatch = false;
/* 126 */       if (this.policy == RulePolicy.MATCHALL) {
/* 127 */         if (!matchSet.contains(Boolean.valueOf(false))) {
/* 128 */           isMatch = true;
/*     */         }
/* 130 */       } else if ((this.policy == RulePolicy.MATCHONE) && 
/* 131 */         (matchSet.contains(Boolean.valueOf(true)))) {
/* 132 */         isMatch = true;
/*     */       }
/*     */       
/* 135 */       return isMatch;
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
/* 148 */       Set<Boolean> matchSet = new HashSet();
/* 149 */       for (Condition<Double> condition : this.conditions) {
/* 150 */         ConditionOpt opt = condition.getOpt();
/* 151 */         Double value = (Double)condition.getValue();
/*     */         
/* 153 */         if (this.matchTo == null) {
/* 154 */           throw new RuleValueException("can not found mathTo value!");
/*     */         }
/*     */         
/* 157 */         switch (opt) {
/*     */         case BIGGER: 
/* 159 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) == 1));
/* 160 */           break;
/*     */         case BIGGER_EQUAL: 
/* 162 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) != -1));
/* 163 */           break;
/*     */         case EQUAL: 
/* 165 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) == -1));
/* 166 */           break;
/*     */         case INCLUDE: 
/* 168 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) != 1));
/* 169 */           break;
/*     */         case NOT_EQUAL: 
/* 171 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) == 0));
/* 172 */           break;
/*     */         case NOT_INCLUDE: 
/* 174 */           matchSet.add(Boolean.valueOf(((Double)this.matchTo).compareTo(value) != 0));
/* 175 */           break;
/*     */         default: 
/* 177 */           throw new RuleValueException("opt : " + opt + " is not accepted! ");
/*     */         }
/*     */         
/*     */       }
/* 181 */       boolean isMatch = false;
/* 182 */       if (this.policy == RulePolicy.MATCHALL) {
/* 183 */         if (!matchSet.contains(Boolean.valueOf(false))) {
/* 184 */           isMatch = true;
/*     */         }
/* 186 */       } else if ((this.policy == RulePolicy.MATCHONE) && 
/* 187 */         (matchSet.contains(Boolean.valueOf(true)))) {
/* 188 */         isMatch = true;
/*     */       }
/*     */       
/* 191 */       return isMatch;
/*     */     }
/*     */   }
/*     */ }
