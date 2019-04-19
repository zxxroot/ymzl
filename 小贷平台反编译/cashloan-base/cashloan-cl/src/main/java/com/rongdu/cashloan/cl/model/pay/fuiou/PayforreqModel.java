/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou;

import com.cashloan.cl.model.pay.fuiou.FuiouPaymentModel;
import com.cashloan.cl.utils.MD5Utils;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.util.StringUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PayforreqModel
/*     */   extends FuiouPaymentModel
/*     */ {
/*     */   private String ver;
/*     */   private String bankno;
/*     */   private String accntno;
/*     */   private String accntnm;
/*     */   private Long amt;
/*     */   private String cityno;
/*     */   
/*     */   public String getVer()
/*     */   {
/*  52 */     return this.ver;
/*     */   }
/*     */   
/*     */   public void setVer(String ver) {
/*  56 */     this.ver = ver;
/*     */   }
/*     */   
/*     */   public String getBankno() {
/*  60 */     return this.bankno;
/*     */   }
/*     */   
/*     */   public void setBankno(String bankno) {
/*  64 */     this.bankno = bankno;
/*     */   }
/*     */   
/*     */   public String getAccntno() {
/*  68 */     return this.accntno;
/*     */   }
/*     */   
/*     */   public void setAccntno(String accntno) {
/*  72 */     this.accntno = accntno;
/*     */   }
/*     */   
/*     */   public String getAccntnm() {
/*  76 */     return this.accntnm;
/*     */   }
/*     */   
/*     */   public void setAccntnm(String accntnm) {
/*  80 */     this.accntnm = accntnm;
/*     */   }
/*     */   
/*     */   public Long getAmt() {
/*  84 */     return this.amt;
/*     */   }
/*     */   
/*     */   public void setAmt(Long amt) {
/*  88 */     this.amt = amt;
/*     */   }
/*     */   
/*     */   public String getCityno() {
/*  92 */     return this.cityno;
/*     */   }
/*     */   
/*     */   public void setCityno(String cityno) {
/*  96 */     this.cityno = cityno;
/*     */   }
/*     */   
/*     */   public void signature() {
/* 100 */     String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><payforreq><ver>1.0</ver><merdt>" + 
/* 101 */       StringUtil.getDate() + "</merdt>" + "<orderno>" + super.getOrderNo() + "</orderno>" + 
/* 102 */       "<bankno>" + this.bankno + "</bankno>" + "<cityno>0086</cityno>" + "<accntno>" + this.accntno + 
/* 103 */       "</accntno>" + "<accntnm>" + this.accntnm + "</accntnm>" + "<amt>" + this.amt + "</amt>" + "</payforreq>";
/* 104 */     String mchntCd = super.getMchntCd();
/* 105 */     String passwd = Global.getValue("fuiou_passwd");
/* 106 */     String macSource = mchntCd + "|" + passwd + "|" + "payforreq" + "|" + xml;
/* 107 */     String mac = MD5Utils.MD5Encrpytion(macSource).toUpperCase();
/* 108 */     List<NameValuePair> params = new ArrayList();
/* 109 */     params.add(new BasicNameValuePair("merid", mchntCd));
/* 110 */     params.add(new BasicNameValuePair("reqtype", "payforreq"));
/* 111 */     params.add(new BasicNameValuePair("xml", xml));
/* 112 */     params.add(new BasicNameValuePair("mac", mac));
/* 113 */     super.setParams(params);
/* 114 */     super.setUrl(Global.getValue("fuiou_pay_addr"));
/*     */   }
/*     */ }
