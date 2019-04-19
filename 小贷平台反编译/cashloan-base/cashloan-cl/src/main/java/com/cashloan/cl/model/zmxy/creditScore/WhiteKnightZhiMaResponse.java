/*    */ package com.cashloan.cl.model.zmxy.creditScore;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class WhiteKnightZhiMaResponse
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String msgCode;
/*    */   private String msgDesc;
/*    */   private String dataType;
/*    */   private String name;
/*    */   private String mobile;
/*    */   private String certNo;
/*    */   private String resultCode;
/*    */   private String resultDesc;
/*    */   
/*    */   public String getMsgCode()
/*    */   {
/* 33 */     return this.msgCode;
/*    */   }
/*    */   
/*    */   public void setMsgCode(String msgCode) {
/* 37 */     this.msgCode = msgCode;
/*    */   }
/*    */   
/*    */   public String getMsgDesc() {
/* 41 */     return this.msgDesc;
/*    */   }
/*    */   
/*    */   public void setMsgDesc(String msgDesc) {
/* 45 */     this.msgDesc = msgDesc;
/*    */   }
/*    */   
/*    */   public String getDataType() {
/* 49 */     return this.dataType;
/*    */   }
/*    */   
/*    */   public void setDataType(String dataType) {
/* 53 */     this.dataType = dataType;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 57 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 61 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getMobile() {
/* 65 */     return this.mobile;
/*    */   }
/*    */   
/*    */   public void setMobile(String mobile) {
/* 69 */     this.mobile = mobile;
/*    */   }
/*    */   
/*    */   public String getCertNo() {
/* 73 */     return this.certNo;
/*    */   }
/*    */   
/*    */   public void setCertNo(String certNo) {
/* 77 */     this.certNo = certNo;
/*    */   }
/*    */   
/*    */   public String getResultCode() {
/* 81 */     return this.resultCode;
/*    */   }
/*    */   
/*    */   public void setResultCode(String resultCode) {
/* 85 */     this.resultCode = resultCode;
/*    */   }
/*    */   
/*    */   public String getResultDesc() {
/* 89 */     return this.resultDesc;
/*    */   }
/*    */   
/*    */   public void setResultDesc(String resultDesc) {
/* 93 */     this.resultDesc = resultDesc;
/*    */   }
/*    */ }
