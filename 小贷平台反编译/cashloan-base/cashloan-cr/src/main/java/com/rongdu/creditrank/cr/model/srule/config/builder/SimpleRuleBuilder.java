/*    */ package com.rongdu.creditrank.cr.model.srule.config.builder;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.model.srule.config.condition.AbstractCondition;
/*    */ import com.rongdu.creditrank.cr.model.srule.config.condition.Condition;
/*    */ import com.rongdu.creditrank.cr.model.srule.config.condition.ConditionItem;
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.RuleBasic;
/*    */ import com.rongdu.creditrank.cr.model.srule.exception.RuleValueException;
/*    */ import com.rongdu.creditrank.cr.model.srule.utils.ConditionOpt;
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
/*    */   protected T doBuild()
/*    */     throws Exception
/*    */   {
/* 40 */     RuleBasic ruleBasic = (RuleBasic)threadLocalRules.get();
/* 41 */     return (T) ruleBasic;
/*    */   }
/*    */   
/*    */ 
/*    */   public ConditionItem newConditionItems()
/*    */   {
/* 47 */     return new ConditionItem();
/*    */   }
/*    */   
/*    */   public RuleConfigurer<H> newRule(long id, String column, ConditionItem conditionItem)
/*    */     throws IllegalAccessException, InstantiationException
/*    */   {
/* 53 */     RuleBasic<H> ruleBasic = concrete();
/* 54 */     ruleBasic.setColumn(column);
/* 55 */     ruleBasic.setId(id);
/* 56 */     ruleBasic.setConditions(itemTolist(conditionItem));
/* 57 */     ruleBasic.setValueType(this.oClazz);
/* 58 */     threadLocalRules.set(ruleBasic);
/* 59 */     return this.ruleConfigurer;
/*    */   }
/*    */   
/*    */   private List<Condition<H>> itemTolist(ConditionItem conditionItem) throws RuleValueException
/*    */   {
/* 64 */     List<Condition<H>> conditions = new ArrayList();
/* 65 */     while (conditionItem.hasNext()) {
/* 66 */       Object[] objs = conditionItem.next();
/* 67 */       AbstractCondition<H> condition = new AbstractCondition();
/* 68 */       condition.opt(ConditionOpt.getOpt((String)objs[0]));
/* 69 */       if (((objs[1] instanceof Long)) || ((objs[1] instanceof Integer)) || ((objs[1] instanceof Float))) {
/* 70 */         objs[1] = Double.valueOf(objs[1].toString());
/*    */       }
/* 72 */       if (objs[1].getClass() != this.oClazz) {
/* 73 */         throw new RuleValueException("item value :" + objs[1] + ",is not match to the type of " + this.oClazz.getName());
/*    */       }
/* 75 */       condition.value((H) objs[1]);
/* 76 */       conditions.add(condition);
/*    */     }
/* 78 */     return conditions;
/*    */   }
/*    */ }
