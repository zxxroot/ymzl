/*    */ package com.rongdu.cashloan.manage.model;
/*    */ 
/*    */ import com.rongdu.cashloan.manage.domain.QuartzInfo;
/*    */ import java.util.Date;
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
/*    */ public class QuartzInfoModel
/*    */   extends QuartzInfo
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String STATE_ENABLE = "10";
/*    */   public static final String STATE_DISABLE = "20";
/*    */   private String stateStr;
/*    */   private Date lastStartTime;
/*    */   
/*    */   public static String stateConvert(String state)
/*    */   {
/*    */     String stateStr;
/*    */     String stateStr;
/* 36 */     if ("20".equals(state)) {
/* 37 */       stateStr = "禁用";
/*    */     } else {
/* 39 */       stateStr = "启用";
/*    */     }
/* 41 */     return stateStr;
/*    */   }
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
/*    */   public String getStateStr()
/*    */   {
/* 60 */     this.stateStr = stateConvert(getState());
/* 61 */     return this.stateStr;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setStateStr(String stateStr)
/*    */   {
/* 69 */     this.stateStr = stateStr;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Date getLastStartTime()
/*    */   {
/* 78 */     return this.lastStartTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setLastStartTime(Date lastStartTime)
/*    */   {
/* 87 */     this.lastStartTime = lastStartTime;
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\model\QuartzInfoModel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */