/*    */ package com.rongdu.creditrank.cr.model.srule.config.condition;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.model.srule.utils.ConditionOpt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AbstractCondition<T>
/*    */   implements Condition<T>
/*    */ {
/*    */   protected ConditionOpt conditionOpt;
/*    */   protected T value;
/*    */   
/*    */   public Condition<T> opt(ConditionOpt opt)
/*    */   {
/* 19 */     this.conditionOpt = opt;
/* 20 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public Condition<T> value(T t)
/*    */   {
/* 26 */     this.value = t;
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public ConditionOpt getOpt()
/*    */   {
/* 32 */     return this.conditionOpt;
/*    */   }
/*    */   
/*    */ 
/*    */   public T getValue()
/*    */   {
/* 38 */     return (T)this.value;
/*    */   }
/*    */ }
