/*    */ package com.rongdu.cashloan.core.common.util.excel;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ 
/*    */ public class FormulaProcessor
/*    */ {
/*  7 */   private static FormulaProcessor self = null;
/*    */   
/*  9 */   private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\$(\\d+)");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static FormulaProcessor getInstance()
/*    */   {
/* 16 */     if (self == null)
/* 17 */       self = new FormulaProcessor();
/* 18 */     return self;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void fillValue(TableDataRow row) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String convertFormula(String formula)
/*    */   {
/* 36 */     Matcher m = this.pattern.matcher(formula);
/* 37 */     StringBuffer sb = new StringBuffer();
/* 38 */     while (m.find()) {
/* 39 */       m.appendReplacement(sb, "getValue(row, " + m.group(1) + ")");
/*    */     }
/* 41 */     m.appendTail(sb);
/*    */     
/* 43 */     return sb.toString();
/*    */   }
/*    */ }


/* excel\FormulaProcessor.class

 */