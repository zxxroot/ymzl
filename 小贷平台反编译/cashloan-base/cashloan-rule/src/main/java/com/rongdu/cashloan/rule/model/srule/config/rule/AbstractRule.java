/*    */ package com.rongdu.cashloan.rule.model.srule.config.rule;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.model.srule.config.condition.Condition;
/*    */ import com.rongdu.cashloan.rule.model.srule.exception.RuleValueException;
/*    */ import com.rongdu.cashloan.rule.model.srule.utils.RulePolicy;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractRule<T>
/*    */   implements Rule, RuleBasic<T>
/*    */ {
/*    */   protected List<Condition<T>> conditions;
/* 18 */   protected RulePolicy policy = RulePolicy.MATCHALL;
/*    */   
/*    */ 
/*    */   protected Map<T, Integer> preLoad;
/*    */   
/*    */   protected Class<T> valueClass;
/*    */   
/*    */   protected long id;
/*    */   
/*    */   protected String column;
/*    */   
/*    */   protected String name;
/*    */   
/*    */   protected T matchTo;
/*    */   
/*    */ 
/*    */   public void setId(long id)
/*    */   {
/* 36 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setColumn(String column)
/*    */   {
/* 41 */     this.column = column;
/*    */   }
/*    */   
/*    */   public void setName(String name)
/*    */   {
/* 46 */     this.name = name;
/*    */   }
/*    */   
/*    */   public void setValueType(Class<T> clazz)
/*    */   {
/* 51 */     this.valueClass = clazz;
/*    */   }
/*    */   
/*    */   public void matchTo(Object o)
/*    */     throws RuleValueException
/*    */   {
/* 57 */     if (((o instanceof Integer)) || ((o instanceof Long)) || ((o instanceof Float))) {
/* 58 */       o = Double.valueOf(o.toString());
/*    */     }
/* 60 */     if (o.getClass() != this.valueClass) {
/* 61 */       throw new RuleValueException("the matchTo Object: " + o + " which type is " + o.getClass().getName() + ",is not fit for the " + this.valueClass.getName());
/*    */     }
/* 63 */     this.matchTo = (T) o;
/*    */   }
/*    */   
/*    */ 
/*    */   public long getId()
/*    */   {
/* 69 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getColumn()
/*    */   {
/* 74 */     return this.column;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 79 */     return this.name;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setConditions(List<Condition<T>> conditions)
/*    */   {
/* 85 */     this.conditions = conditions;
/*    */   }
/*    */   
/*    */   public void setRulePolicy(RulePolicy rulePolicy)
/*    */   {
/* 90 */     this.policy = rulePolicy;
/*    */   }
/*    */   
/*    */   public void setPreLoad(Map<T, Integer> preLoad)
/*    */   {
/* 95 */     this.preLoad = preLoad;
/*    */   }
/*    */ }
