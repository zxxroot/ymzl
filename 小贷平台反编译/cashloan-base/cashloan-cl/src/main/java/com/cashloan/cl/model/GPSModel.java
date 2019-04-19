/*    */ package com.cashloan.cl.model;
/*    */ 
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
/*    */ public class GPSModel
/*    */ {
/*    */   private String coordinate;
/*    */   private Date createTime;
/*    */   private String affair;
/*    */   
/*    */   public String getCoordinate()
/*    */   {
/* 29 */     return this.coordinate;
/*    */   }
/*    */   
/*    */   public void setCoordinate(String coordinate) {
/* 33 */     this.coordinate = coordinate;
/*    */   }
/*    */   
/*    */   public Date getCreateTime() {
/* 37 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Date createTime) {
/* 41 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public String getAffair() {
/* 45 */     return this.affair;
/*    */   }
/*    */   
/*    */   public void setAffair(String affair) {
/* 49 */     this.affair = affair;
/*    */   }
/*    */ }
