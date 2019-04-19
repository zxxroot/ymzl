/*    */ package com.rongdu.cashloan.manage.model;
/*    */ 
/*    */ import com.rongdu.cashloan.manage.domain.QuartzLog;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QuartzLogModel
/*    */   extends QuartzLog
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String RESULT_SUCCESS = "10";
/*    */   public static final String RESULT_FAIL = "20";
/*    */   private String name;
/*    */   private String resultStr;
/*    */   
/*    */   public String getName()
/*    */   {
/* 41 */     return this.name;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 50 */     this.name = name;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getResultStr()
/*    */   {
/* 59 */     this.resultStr = convertResult(getResult());
/* 60 */     return this.resultStr;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setResultStr(String resultStr)
/*    */   {
/* 69 */     this.resultStr = resultStr;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String convertResult(String result)
/*    */   {
/* 78 */     String resultStr = " - ";
/* 79 */     if ("10".equals(result)) {
/* 80 */       resultStr = "执行成功";
/* 81 */     } else if ("20".equals(result)) {
/* 82 */       resultStr = "执行失败";
/*    */     }
/* 84 */     return resultStr;
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\model\QuartzLogModel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */