/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou;
/*     */ 
/*     */

import com.cashloan.cl.model.pay.fuiou.FuiouPaymentModel;
import com.cashloan.cl.utils.MD5Utils;
import com.rongdu.cashloan.core.common.context.Global;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
/*     */ public class FuiouProtocolAutoPayModel
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
/*     */   private String userIp;
/*     */   private String userId;
/*     */   private String protocolNo;
/*     */   
/*     */   public String getVer()
/*     */   {
/*  76 */     return this.ver;
/*     */   }
/*     */   
/*     */   public void setVer(String ver) {
/*  80 */     this.ver = ver;
/*     */   }
/*     */   
/*     */   public String getBankno() {
/*  84 */     return this.bankno;
/*     */   }
/*     */   
/*     */   public void setBankno(String bankno) {
/*  88 */     this.bankno = bankno;
/*     */   }
/*     */   
/*     */   public String getAccntno() {
/*  92 */     return this.accntno;
/*     */   }
/*     */   
/*     */   public void setAccntno(String accntno) {
/*  96 */     this.accntno = accntno;
/*     */   }
/*     */   
/*     */   public String getAccntnm() {
/* 100 */     return this.accntnm;
/*     */   }
/*     */   
/*     */   public void setAccntnm(String accntnm) {
/* 104 */     this.accntnm = accntnm;
/*     */   }
/*     */   
/*     */   public Long getAmt() {
/* 108 */     return this.amt;
/*     */   }
/*     */   
/*     */   public void setAmt(Long amt) {
/* 112 */     this.amt = amt;
/*     */   }
/*     */   
/*     */   public String getEntseq() {
/* 116 */     return this.entseq;
/*     */   }
/*     */   
/*     */   public void setEntseq(String entseq) {
/* 120 */     this.entseq = entseq;
/*     */   }
/*     */   
/*     */   public String getMemo() {
/* 124 */     return this.memo;
/*     */   }
/*     */   
/*     */   public void setMemo(String memo) {
/* 128 */     this.memo = memo;
/*     */   }
/*     */   
/*     */   public String getMobile() {
/* 132 */     return this.mobile;
/*     */   }
/*     */   
/*     */   public void setMobile(String mobile) {
/* 136 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */   public String getCertno() {
/* 140 */     return this.certno;
/*     */   }
/*     */   
/*     */   public void setCertno(String certno) {
/* 144 */     this.certno = certno;
/*     */   }
/*     */   
/*     */   public String getUserIp()
/*     */   {
/* 149 */     return this.userIp;
/*     */   }
/*     */   
/*     */   public void setUserIp(String userIp) {
/* 153 */     this.userIp = userIp;
/*     */   }
/*     */   
/*     */   public String getUserId() {
/* 157 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(String userId) {
/* 161 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getProtocolNo() {
/* 165 */     return this.protocolNo;
/*     */   }
/*     */   
/*     */   public void setProtocolNo(String protocolNo) {
/* 169 */     this.protocolNo = protocolNo;
/*     */   }
/*     */   
/*     */   public void signature() {
/* 173 */     String mchntCd = super.getMchntCd();
/*     */     
/* 175 */     String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><request><version> 1.0</version><userip>" + 
/*     */     
/* 177 */       this.userIp + "</userip>" + 
/* 178 */       "<mchntcd>" + mchntCd + "</mchntcd>" + 
/* 179 */       "<type>" + 3 + "</type>" + 
/* 180 */       "<mchntorderid>" + super.getOrderNo() + "</mchntorderid>" + 
/* 181 */       "<userid>" + this.userId + "</userid>" + 
/* 182 */       "<amt>" + this.amt + "</amt>" + 
/* 183 */       "<protocolno>" + this.protocolNo + "</protocolno>" + 
/* 184 */       "<needsendmsg>0</needsendmsg>" + 
/* 185 */       "<backurl>http://www.baidu.com</backurl>" + 
/* 186 */       "</request>";
/*     */     
/* 188 */     String passwd = Global.getValue("fuiou_passwd");
/* 189 */     String macSource = xml;
/* 190 */     String mac = MD5Utils.MD5Encrpytion(macSource).toUpperCase();
/* 191 */     List<NameValuePair> params = new ArrayList();
/* 192 */     params.add(new BasicNameValuePair("merid", mchntCd));
/*     */     
/*     */ 
/* 195 */     params.add(new BasicNameValuePair("mac", mac));
/* 196 */     super.setParams(params);
/* 197 */     super.setUrl(Global.getValue("fuiou_xieyizhifu_autopay"));
/*     */   }
/*     */ }
