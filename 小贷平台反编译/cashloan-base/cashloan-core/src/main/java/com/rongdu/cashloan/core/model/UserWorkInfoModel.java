/*    */ package com.rongdu.cashloan.core.model;
/*    */ 
/*    */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
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
/*    */ public class UserWorkInfoModel
/*    */   extends UserBaseInfo
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String WORK_IMG_ADDED = "10";
/*    */   public static final String WORK_IMG_NO_ADD = "20";
/*    */   private String workImgState;
/*    */   private String itemCode;
/*    */   
/*    */   public String getWorkImgState()
/*    */   {
/* 35 */     return this.workImgState;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setWorkImgState(String workImgState)
/*    */   {
/* 44 */     this.workImgState = workImgState;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getItemCode()
/*    */   {
/* 52 */     return this.itemCode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setItemCode(String itemCode)
/*    */   {
/* 60 */     this.itemCode = itemCode;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\model\UserWorkInfoModel.class

 */