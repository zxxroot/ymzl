/*    */ package com.rongdu.creditrank.cr.model.srule.config.condition;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConditionItem
/*    */   implements Iterator<Object[]>
/*    */ {
/*    */   private List<String> opts;
/*    */   private List<Object> values;
/* 19 */   private int point = 0;
/*    */   
/* 21 */   private int length = 0;
/*    */   
/*    */   public ConditionItem()
/*    */   {
/* 25 */     this.opts = new ArrayList();
/* 26 */     this.values = new ArrayList();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void add(String opt, Object value)
/*    */   {
/* 37 */     this.opts.add(opt);
/* 38 */     this.values.add(value);
/* 39 */     this.length += 1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean hasNext()
/*    */   {
/* 46 */     if (this.point >= this.length) {
/* 47 */       reset();
/* 48 */       return false;
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public Object[] next()
/*    */   {
/* 55 */     Object[] objs = new Object[2];
/* 56 */     objs[0] = this.opts.get(this.point);
/* 57 */     objs[1] = this.values.get(this.point);
/* 58 */     this.point += 1;
/* 59 */     return objs;
/*    */   }
/*    */   
/*    */ 
/*    */   public void remove()
/*    */   {
/* 65 */     this.opts.clear();
/* 66 */     this.values.clear();
/* 67 */     reset();
/* 68 */     this.length = 0;
/*    */   }
/*    */   
/*    */   private void reset() {
/* 72 */     this.point = 0;
/*    */   }
/*    */ }
