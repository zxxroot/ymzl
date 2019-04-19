/*    */ package com.rongdu.cashloan.cl.model.pay.fuiou;

import com.cashloan.cl.model.pay.fuiou.FuiouPaymentModel;
import com.cashloan.cl.utils.MD5Utils;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.util.StringUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

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
/*    */ public class QrytransModel
/*    */   extends FuiouPaymentModel
/*    */ {
/*    */   private String type;
/*    */   private String serialNumber;
/*    */   
/*    */   public String getSerialNumber()
/*    */   {
/* 29 */     return this.serialNumber;
/*    */   }
/*    */   
/*    */   public void setSerialNumber(String serialNumber) {
/* 33 */     this.serialNumber = serialNumber;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 37 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 41 */     this.type = type;
/*    */   }
/*    */   
/*    */   public void signature() {
/* 45 */     String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><qrytransreq><ver>1.0</ver><busicd>" + 
/*    */     
/*    */ 
/* 48 */       this.type + "</busicd>" + 
/* 49 */       "<orderno>" + this.serialNumber + "</orderno>" + 
/* 50 */       "<startdt>" + StringUtil.getDate(2) + "</startdt>" + 
/* 51 */       "<enddt>" + StringUtil.getDate(1) + "</enddt>" + 
/* 52 */       "<transst>1</transst>" + 
/* 53 */       "</qrytransreq>";
/* 54 */     String mchntCd = super.getMchntCd();
/* 55 */     String passwd = Global.getValue("fuiou_passwd");
/* 56 */     String macSource = mchntCd + "|" + passwd + "|" + "qrytransreq" + "|" + xml;
/* 57 */     String mac = MD5Utils.MD5Encrpytion(macSource).toUpperCase();
/* 58 */     List<NameValuePair> params = new ArrayList();
/* 59 */     params.add(new BasicNameValuePair("merid", mchntCd));
/* 60 */     params.add(new BasicNameValuePair("reqtype", "qrytransreq"));
/* 61 */     params.add(new BasicNameValuePair("xml", xml));
/* 62 */     params.add(new BasicNameValuePair("mac", mac));
/* 63 */     super.setParams(params);
/* 64 */     super.setUrl(Global.getValue("fuiou_pay_addr"));
/*    */   }
/*    */ }
