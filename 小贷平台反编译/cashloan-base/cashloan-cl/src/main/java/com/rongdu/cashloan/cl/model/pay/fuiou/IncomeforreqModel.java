/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou;
/*     */

import com.cashloan.cl.model.pay.fuiou.FuiouPaymentModel;
import com.cashloan.cl.utils.MD5Utils;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
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
/*     */ public class IncomeforreqModel
/*     */   extends FuiouPaymentModel
/*     */ {
/*     */   private String ver;
/*     */   private String bankno;
/*     */   private String accntno;
/*     */   private String accntnm;
/*     */   private Long amt;
/*     */   private String entseq;
/*     */   private String memo;
/*     */   private String mobile;
/*     */   private String certno;
/*     */   
/*     */   public String getVer()
/*     */   {
/*  68 */     return this.ver;
/*     */   }
/*     */   
/*     */   public void setVer(String ver) {
/*  72 */     this.ver = ver;
/*     */   }
/*     */   
/*     */   public String getBankno() {
/*  76 */     return this.bankno;
/*     */   }
/*     */   
/*     */   public void setBankno(String bankno) {
/*  80 */     this.bankno = bankno;
/*     */   }
/*     */   
/*     */   public String getAccntno() {
/*  84 */     return this.accntno;
/*     */   }
/*     */   
/*     */   public void setAccntno(String accntno) {
/*  88 */     this.accntno = accntno;
/*     */   }
/*     */   
/*     */   public String getAccntnm() {
/*  92 */     return this.accntnm;
/*     */   }
/*     */   
/*     */   public void setAccntnm(String accntnm) {
/*  96 */     this.accntnm = accntnm;
/*     */   }
/*     */   
/*     */   public Long getAmt() {
/* 100 */     return this.amt;
/*     */   }
/*     */   
/*     */   public void setAmt(Long amt) {
/* 104 */     this.amt = amt;
/*     */   }
/*     */   
/*     */   public String getEntseq() {
/* 108 */     return this.entseq;
/*     */   }
/*     */   
/*     */   public void setEntseq(String entseq) {
/* 112 */     this.entseq = entseq;
/*     */   }
/*     */   
/*     */   public String getMemo() {
/* 116 */     return this.memo;
/*     */   }
/*     */   
/*     */   public void setMemo(String memo) {
/* 120 */     this.memo = memo;
/*     */   }
/*     */   
/*     */   public String getMobile() {
/* 124 */     return this.mobile;
/*     */   }
/*     */   
/*     */   public void setMobile(String mobile) {
/* 128 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */   public String getCertno() {
/* 132 */     return this.certno;
/*     */   }
/*     */   
/*     */   public void setCertno(String certno) {
/* 136 */     this.certno = certno;
/*     */   }
/*     */   
/*     */   public void signature()
/*     */   {
/* 141 */     String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><incomeforreq><ver> 2.00</ver><merdt>" + 
/*     */     
/* 143 */       StringUtil.getDate() + "</merdt>" + 
/* 144 */       "<orderno>" + super.getOrderNo() + "</orderno>" + 
/* 145 */       "<bankno>" + this.bankno + "</bankno>" + 
/* 146 */       "<accntno>" + this.accntno + "</accntno>" + 
/* 147 */       "<accntnm>" + this.accntnm + "</accntnm>" + 
/* 148 */       "<amt>" + this.amt + "</amt>" + 
/* 149 */       "<entseq>" + OrderNoUtil.getSerialNumber() + "</entseq>" + 
/* 150 */       "<memo>无</memo>" + "<mobile>" + this.mobile + "</mobile>" + 
/* 151 */       "<certtp>0</certtp>" + 
/* 152 */       "<certno>" + this.certno + "</certno>" + 
/* 153 */       "</incomeforreq>";
/* 154 */     String mchntCd = super.getMchntCd();
/* 155 */     String passwd = Global.getValue("fuiou_passwd");
/* 156 */     String macSource = mchntCd + "|" + passwd + "|" + "sincomeforreq" + "|" + xml;
/* 157 */     String mac = MD5Utils.MD5Encrpytion(macSource).toUpperCase();
/* 158 */     List<NameValuePair> params = new ArrayList();
/* 159 */     params.add(new BasicNameValuePair("merid", mchntCd));
/* 160 */     params.add(new BasicNameValuePair("reqtype", "sincomeforreq"));
/* 161 */     params.add(new BasicNameValuePair("xml", xml));
/* 162 */     params.add(new BasicNameValuePair("mac", mac));
/* 163 */     super.setParams(params);
/* 164 */     super.setUrl(Global.getValue("fuiou_pay_addr"));
/*     */   }
/*     */ }
