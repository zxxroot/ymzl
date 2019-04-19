/*    */ package com.cashloan.cl.model.pay.fuiou.utils;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlRootElement(name="RESPONSE")
/*    */ public class NewProtocolBindXmlBeanResp
/*    */ {
/* 14 */   private String version = "1.0";
/*    */   
/*    */   private String responseCode;
/*    */   
/*    */   private String responseMSG;
/*    */   
/*    */   private String mchntcd;
/*    */   
/*    */   private String mchntssn;
/*    */   private String protocolno;
/*    */   
/*    */   public String getVersion()
/*    */   {
/* 27 */     return this.version;
/*    */   }
/*    */   
/*    */   @XmlElement(name="VERSION")
/*    */   public void setVersion(String version) {
/* 32 */     this.version = version;
/*    */   }
/*    */   
/*    */   public String getResponseCode() {
/* 36 */     return this.responseCode;
/*    */   }
/*    */   
/*    */   @XmlElement(name="RESPONSECODE")
/*    */   public void setResponseCode(String responseCode) {
/* 41 */     this.responseCode = responseCode;
/*    */   }
/*    */   
/*    */   public String getResponseMSG() {
/* 45 */     return this.responseMSG;
/*    */   }
/*    */   
/*    */   @XmlElement(name="RESPONSEMSG")
/* 49 */   public void setResponseMSG(String responseMSG) { this.responseMSG = responseMSG; }
/*    */   
/*    */   public String getMchntcd()
/*    */   {
/* 53 */     return this.mchntcd;
/*    */   }
/*    */   
/*    */   @XmlElement(name="MCHNTCD")
/* 57 */   public void setMchntcd(String mchntcd) { this.mchntcd = mchntcd; }
/*    */   
/*    */   public String getMchntssn()
/*    */   {
/* 61 */     return this.mchntssn;
/*    */   }
/*    */   
/*    */   @XmlElement(name="MCHNTSSN")
/*    */   public void setMchntssn(String mchntssn) {
/* 66 */     this.mchntssn = mchntssn;
/*    */   }
/*    */   
/*    */   public String getProtocolno() {
/* 70 */     return this.protocolno;
/*    */   }
/*    */   
/*    */   @XmlElement(name="PROTOCOLNO")
/* 74 */   public void setProtocolno(String protocolno) { this.protocolno = protocolno; }
/*    */ }
