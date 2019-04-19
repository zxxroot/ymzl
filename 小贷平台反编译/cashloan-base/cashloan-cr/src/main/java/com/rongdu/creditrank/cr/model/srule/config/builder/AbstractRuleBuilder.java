/*    */ package com.rongdu.creditrank.cr.model.srule.config.builder;
/*    */ 
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.Rule;
/*    */ import com.rongdu.creditrank.cr.model.srule.config.rule.RuleBasic;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractRuleBuilder<H, O extends Rule>
/*    */   implements RuleBuilder<H>, Builder
/*    */ {
/* 15 */   private AtomicBoolean building = new AtomicBoolean();
/*    */   
/*    */ 
/*    */ 
/*    */   private O object;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public O build()
/*    */     throws Exception
/*    */   {
/* 27 */     this.object = doBuild();
/* 28 */     return this.object;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected abstract O doBuild()
/*    */     throws Exception;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final O getObject()
/*    */   {
/* 47 */     if (!this.building.get()) {
/* 48 */       throw new IllegalStateException("This object has not been built");
/*    */     }
/* 50 */     return this.object;
/*    */   }
/*    */   
/*    */   protected abstract RuleBasic<H> concrete();
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\model\srule\config\builder\AbstractRuleBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */