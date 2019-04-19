/*    */ package com.cashloan.cl.model.pay.fuiou.newprotocol;
/*    */ 
/*    */

import com.rongdu.cashloan.cl.model.pay.fuiou.newprotocol.FuiouProtocolPayModel;
import com.rongdu.cashloan.core.common.context.Global;

import java.util.Map;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueryRePayResultModel
/*    */   extends FuiouProtocolPayModel
/*    */ {
/*    */   private String mchntOrderId;
/*    */   private String rem1;
/*    */   private String rem2;
/*    */   private String rem3;
/*    */   
/*    */   public String getRem1()
/*    */   {
/* 21 */     return this.rem1;
/*    */   }
/*    */   
/*    */   public void setRem1(String rem1) {
/* 25 */     this.rem1 = rem1;
/*    */   }
/*    */   
/*    */   public String getRem2() {
/* 29 */     return this.rem2;
/*    */   }
/*    */   
/*    */   public void setRem2(String rem2) {
/* 33 */     this.rem2 = rem2;
/*    */   }
/*    */   
/*    */   public String getRem3() {
/* 37 */     return this.rem3;
/*    */   }
/*    */   
/*    */   public void setRem3(String rem3) {
/* 41 */     this.rem3 = rem3;
/*    */   }
/*    */   
/*    */   public String getMchntOrderId() {
/* 45 */     return this.mchntOrderId;
/*    */   }
/*    */   
/*    */   public void setMchntOrderId(String mchntOrderId) {
/* 49 */     this.mchntOrderId = mchntOrderId;
/*    */   }
/*    */   
/*    */   public String getUrl()
/*    */   {
/* 54 */     return Global.getValue("fuiou_newpropay_result");
/*    */   }
/*    */   
/*    */   public void fillParams(Map<String, Object> map)
/*    */   {
/* 59 */     map.put("VERSION", "3.0");
/* 60 */     map.put("MCHNTCD", getMchntCd());
/* 61 */     map.put("MCHNTORDERID", getMchntOrderId());
/* 62 */     map.put("REM1", getRem1());
/* 63 */     map.put("REM2", getRem2());
/* 64 */     map.put("REM3", getRem3());
/* 65 */     map.put("SIGN", getSign());
/* 66 */     map.put("ORDER", "ORDER");
/*    */   }
/*    */   
/*    */   public String getSign()
/*    */   {
/* 71 */     String[] signItems = { "3.0", getMchntCd(), getMchntOrderId(), getMchntKey() };
/* 72 */     setSignItems(signItems);
/* 73 */     return super.getSign();
/*    */   }
/*    */ }
