/*    */ package com.cashloan.cl.domain;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.DateUtil;
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
/*    */ public class OperatorHLCallRecord
/*    */   extends OperatorVoices
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String startTime;
/*    */   private String place;
/*    */   private String otherCellPhone;
/*    */   private String subtotal;
/*    */   private String callType;
/*    */   private Long useTime;
/*    */   private String initType;
/*    */   
/*    */   public String getCallType()
/*    */   {
/* 39 */     return this.callType;
/*    */   }
/*    */   
/*    */   public String getInitType() {
/* 43 */     return this.initType;
/*    */   }
/*    */   
/*    */   public String getOtherCellPhone() {
/* 47 */     return this.otherCellPhone;
/*    */   }
/*    */   
/*    */   public String getPlace() {
/* 51 */     return this.place;
/*    */   }
/*    */   
/*    */   public String getStartTime() {
/* 55 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public String getSubtotal() {
/* 59 */     return this.subtotal;
/*    */   }
/*    */   
/*    */   public Long getUseTime() {
/* 63 */     return this.useTime;
/*    */   }
/*    */   
/*    */   public void setCallType(String callType) {
/* 67 */     super.setVoiceType(callType);
/* 68 */     this.callType = callType;
/*    */   }
/*    */   
/*    */   public void setInitType(String initType) {
/* 72 */     super.setVoiceStatus(initType);
/* 73 */     this.initType = initType;
/*    */   }
/*    */   
/*    */   public void setOtherCellPhone(String otherCellPhone) {
/* 77 */     super.setVoiceToNumber(otherCellPhone);
/* 78 */     this.otherCellPhone = otherCellPhone;
/*    */   }
/*    */   
/*    */   public void setPlace(String place) {
/* 82 */     super.setVoicePlace(place);
/* 83 */     this.place = place;
/*    */   }
/*    */   
/*    */   public void setStartTime(String startTime) {
/* 87 */     super.setVoiceDate(DateUtil.parse(startTime, "yyyy-MM-dd HH:mm:ss"));
/* 88 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   public void setSubtotal(String subtotal) {
/* 92 */     this.subtotal = subtotal;
/*    */   }
/*    */   
/*    */   public void setUseTime(Long useTime) {
/* 96 */     super.setVoiceDuration(useTime);
/* 97 */     this.useTime = useTime;
/*    */   }
/*    */ }
