/*    */ package com.rongdu.cashloan.rule.model.srule.config.builder;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.model.srule.config.condition.AbstractCondition;
/*    */ import com.rongdu.cashloan.rule.model.srule.config.condition.Condition;
/*    */ import com.rongdu.cashloan.rule.model.srule.config.condition.ConditionItem;
/*    */ import com.rongdu.cashloan.rule.model.srule.config.rule.Rule;
/*    */ import com.rongdu.cashloan.rule.model.srule.config.rule.RuleBasic;
/*    */ import com.rongdu.cashloan.rule.model.srule.exception.RuleValueException;
/*    */ import com.rongdu.cashloan.rule.model.srule.utils.ConditionOpt;
/*    */ import java.lang.reflect.Type;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public abstract class SimpleRuleBuilder<H, T extends Rule>
/*    */   extends AbstractRuleBuilder<H, T>
/*    */ {
/*    */   private Class<H> oClazz;
/*    */   private RuleConfigurerAdapter<H, T, SimpleRuleBuilder<H, T>> ruleConfigurer;
/*    */   
/*    */   public SimpleRuleBuilder()
/*    */   {
/* 31 */     Type type = getClass().getGenericSuperclass();
/* 32 */     this.oClazz = ((Class)((java.lang.reflect.ParameterizedType)type).getActualTypeArguments()[0]);
/* 33 */     this.ruleConfigurer = new SimpleRuleConfigurer();
/* 34 */     this.ruleConfigurer.setBuilder(this);
/*    */   }
/*    */   
/*    */ 
/*    */   protected T doBuild()
/*    */     throws Exception
/*    */   {
/* 41 */     RuleBasic ruleBasic = (RuleBasic)threadLocalRules.get();
/* 42 */     return (T) ruleBasic;
/*    */   }
/*    */   
/*    */ 
/*    */   public ConditionItem newConditionItems()
/*    */   {
/* 48 */     return new ConditionItem();
/*    */   }
/*    */   
/*    */   public RuleConfigurer<H> newRule(long id, String column, ConditionItem conditionItem)
/*    */     throws IllegalAccessException, InstantiationException
/*    */   {
/* 54 */     RuleBasic<H> ruleBasic = concrete();
/* 55 */     ruleBasic.setColumn(column);
/* 56 */     ruleBasic.setId(id);
/* 57 */     ruleBasic.setConditions(itemTolist(conditionItem));
/* 58 */     ruleBasic.setValueType(this.oClazz);
/* 59 */     threadLocalRules.set(ruleBasic);
/* 60 */     return this.ruleConfigurer;
/*    */   }
/*    */   
/*    */   private List<Condition<H>> itemTolist(ConditionItem conditionItem)
/*    */     throws RuleValueException
/*    */   {
/* 66 */     List<Condition<H>> conditions = new ArrayList();
/* 67 */     while (conditionItem.hasNext()) {
/* 68 */       Object[] objs = conditionItem.next();
/* 69 */       AbstractCondition<H> condition = new AbstractCondition();
/* 70 */       condition.opt(ConditionOpt.getOpt((String)objs[0]));
/* 71 */       if (((objs[1] instanceof Long)) || ((objs[1] instanceof Integer)) || ((objs[1] instanceof Float))) {
/* 72 */         objs[1] = Double.valueOf(objs[1].toString());
/*    */       }
/* 74 */       if (objs[1].getClass() != this.oClazz) {
/* 75 */         throw new RuleValueException("item value :" + objs[1] + ",is not match to the type of " + this.oClazz.getName());
/*    */       }
/* 77 */       condition.value((H) objs[1]);
/* 78 */       conditions.add(condition);
/*    */     }
/* 80 */     return conditions;
/*    */   }
/*    */ }
