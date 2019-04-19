/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DestributeUtil
/*    */ {
/* 16 */   List<Long> debitList = new ArrayList();
/*    */   
/* 18 */   Set<Integer> set = new HashSet();
/*    */   
/*    */ 
/* 21 */   static Map<Integer, List<Long>> map = new HashMap();
/*    */   
/*    */   public Map<Integer, List<Long>> getCollection(List<Long> a, int num) {
/* 24 */     this.debitList.addAll(a);
/*    */     
/* 26 */     List<Long> list = null;
/* 27 */     for (Integer count = Integer.valueOf(num); 
/* 28 */         count.intValue() > 0; count = Integer.valueOf(count.intValue() - 1)) {
/* 29 */       list = new ArrayList();
/* 30 */       map.put(count, list);
/*    */     }
/*    */     
/* 33 */     divideDebit(this.debitList, Integer.valueOf(num), true);
/*    */     
/* 35 */     ArrayList<Integer> arrays = Lists.newArrayList(map.keySet());
/* 36 */     Collections.shuffle(arrays);
/* 37 */     return map;
/*    */   }
/*    */   
/*    */ 
/*    */   private void divideDebit(List<Long> dList, Integer num, boolean direction)
/*    */   {
/* 43 */     Collections.shuffle(this.debitList);
/* 44 */     if (dList.size() >= num.intValue()) {
/* 45 */       for (int i = 0; i < num.intValue(); i++) { Integer index;
/* 47 */         if (direction) {
/* 48 */           index = Integer.valueOf(i + 1);
/*    */         } else {
/* 50 */           index = Integer.valueOf(num.intValue() - i);
/*    */         }
/* 52 */         List<Long> list = (List)map.get(index);
/* 53 */         list.add((Long)dList.get(i));
/* 54 */         map.put(index, list);
/*    */       }
/*    */       
/* 57 */       List<Long> newDebitList = new ArrayList();
/* 58 */       for (int i = 0; i < dList.size(); i++) {
/* 59 */         if (i > num.intValue() - 1) {
/* 60 */           newDebitList.add((Long)dList.get(i));
/*    */         }
/*    */       }
/* 63 */       if (newDebitList.size() > 0)
/*    */       {
/* 65 */         divideDebit(newDebitList, num, !direction);
/*    */       }
/* 67 */     } else if (dList.size() < num.intValue()) {
/* 68 */       for (int i = 0; i < dList.size(); i++) {
/* 69 */         List<Long> list = (List)map.get(Integer.valueOf(i + 1));
/* 70 */         list.add((Long)dList.get(i));
/* 71 */         map.put(Integer.valueOf(i + 1), list);
/*    */       }
/*    */     }
/*    */   }
/*    */ }
