/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArrayUtil
/*    */ {
/*    */   public static <T> T[] concat(T[] first, T[] second)
/*    */   {
/* 15 */     Object[] result = Arrays.copyOf(first, first.length + second.length);
/* 16 */     System.arraycopy(second, 0, result, first.length, second.length);
/* 17 */     return (T[]) result;
/*    */   }
/*    */ }
