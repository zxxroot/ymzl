/*    */ package com.cashloan.cl.domain;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OperatorHLBasic
/*    */   extends OperatorTdBasic
/*    */ {
/*    */   private static final long serialVersionUID = -4301344159417211053L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String cellPhone;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String datasource;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String regTime;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String realName;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getCellPhone()
/*    */   {
/* 42 */     return this.cellPhone;
/*    */   }
/*    */   
/*    */   public void setCellPhone(String cellPhone) {
/* 46 */     super.setUserMobile(cellPhone);
/* 47 */     this.cellPhone = cellPhone;
/*    */   }
/*    */   
/*    */   public String getDatasource() {
/* 51 */     return this.datasource;
/*    */   }
/*    */   
/*    */   public void setDatasource(String datasource) {
/* 55 */     super.setChannelSrc(datasource);
/* 56 */     this.datasource = datasource;
/*    */   }
/*    */   
/*    */   public String getRegTime() {
/* 60 */     return this.regTime;
/*    */   }
/*    */   
/*    */   public void setRegTime(String regTime) {
/* 64 */     super.setNetTime(regTime);
/* 65 */     this.regTime = regTime;
/*    */   }
/*    */   
/*    */   public String getRealName() {
/* 69 */     return this.realName;
/*    */   }
/*    */   
/*    */   public void setRealName(String realName) {
/* 73 */     super.setRealInfo(realName);
/* 74 */     this.realName = realName;
/*    */   }
/*    */ }
