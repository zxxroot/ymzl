/*     */ package com.rongdu.cashloan.cl.model.pay.fuiou;
/*     */ 
/*     */

import com.cashloan.cl.model.pay.fuiou.FuiouPaymentModel;
import com.cashloan.cl.model.pay.fuiou.utils.SignatureUtil;
import com.rongdu.cashloan.core.common.context.Global;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*     */ public class FuiouSignModel
/*     */   extends FuiouPaymentModel
/*     */ {
/*     */   private String acntNo;
/*     */   private String bankCd;
/*  29 */   private String pageFrontUrl = Global.getValue("fuiou_page_url");
/*     */   
/*     */ 
/*     */   private String userNm;
/*     */   
/*     */ 
/*     */   private String credtNo;
/*     */   
/*     */ 
/*     */   private String mobileNo;
/*     */   
/*     */ 
/*     */   private String signature;
/*     */   
/*     */ 
/*     */   public Map<String, String> signature()
/*     */   {
/*  46 */     super.setSrcChnl("APP");
/*  47 */     String isCallback = getIsCallback();
/*  48 */     String busiCd = getBusiCd();
/*  49 */     String credtTp = getCredtTp();
/*  50 */     String srcChnl = getSrcChnl();
/*  51 */     String acntTp = getAcntTp();
/*  52 */     String mchntCd = getMchntCd();
/*  53 */     String reserved1 = getReserved1();
/*  54 */     ArrayList<String> list = new ArrayList();
/*  55 */     list.add(isCallback);
/*  56 */     list.add(busiCd);
/*  57 */     list.add(credtTp);
/*  58 */     list.add(this.acntNo);
/*  59 */     list.add(this.bankCd);
/*  60 */     list.add(this.userNm);
/*  61 */     list.add(this.credtNo);
/*  62 */     list.add(srcChnl);
/*  63 */     list.add(acntTp);
/*  64 */     list.add(this.mobileNo);
/*  65 */     list.add(mchntCd);
/*  66 */     list.add(reserved1);
/*  67 */     list.add(this.pageFrontUrl);
/*  68 */     String passwd = Global.getValue("fuiou_passwd");
/*  69 */     setSignature(SignatureUtil.hex(list, passwd));
/*  70 */     List<NameValuePair> params = new ArrayList();
/*  71 */     params.add(new BasicNameValuePair("acntNo", this.acntNo));
/*  72 */     params.add(new BasicNameValuePair("acntTp", acntTp));
/*  73 */     params.add(new BasicNameValuePair("bankCd", this.bankCd));
/*  74 */     params.add(new BasicNameValuePair("busiCd", busiCd));
/*  75 */     params.add(new BasicNameValuePair("credtNo", this.credtNo));
/*  76 */     params.add(new BasicNameValuePair("credtTp", credtTp));
/*  77 */     params.add(new BasicNameValuePair("isCallback", isCallback));
/*  78 */     params.add(new BasicNameValuePair("mchntCd", mchntCd));
/*  79 */     params.add(new BasicNameValuePair("mobileNo", this.mobileNo));
/*  80 */     params.add(new BasicNameValuePair("pageFrontUrl", this.pageFrontUrl));
/*  81 */     params.add(new BasicNameValuePair("signature", this.signature));
/*  82 */     params.add(new BasicNameValuePair("reserved1", reserved1));
/*  83 */     params.add(new BasicNameValuePair("srcChnl", srcChnl));
/*  84 */     params.add(new BasicNameValuePair("userNm", this.userNm));
/*  85 */     params.add(new BasicNameValuePair("url", Global.getValue("fuiou_sign_addr")));
/*  86 */     super.setParams(params);
/*  87 */     super.setUrl(Global.getValue("fuiou_sign_addr"));
/*     */     
/*  89 */     Map<String, String> data = new HashMap();
/*  90 */     data.put("acntNo", this.acntNo);
/*  91 */     data.put("acntTp", acntTp);
/*  92 */     data.put("bankCd", this.bankCd);
/*  93 */     data.put("busiCd", busiCd);
/*  94 */     data.put("credtNo", this.credtNo);
/*  95 */     data.put("credtTp", credtTp);
/*  96 */     data.put("isCallback", isCallback);
/*  97 */     data.put("mchntCd", mchntCd);
/*  98 */     data.put("mobileNo", this.mobileNo);
/*  99 */     data.put("pageFrontUrl", this.pageFrontUrl);
/* 100 */     data.put("signature", this.signature);
/* 101 */     data.put("reserved1", reserved1);
/* 102 */     data.put("srcChnl", srcChnl);
/* 103 */     data.put("userNm", this.userNm);
/* 104 */     data.put("url", Global.getValue("fuiou_sign_addr"));
/* 105 */     return data;
/*     */   }
/*     */   
/*     */   public String getSignature() {
/* 109 */     return this.signature;
/*     */   }
/*     */   
/*     */   public void setSignature(String signature) {
/* 113 */     this.signature = signature;
/*     */   }
/*     */   
/*     */   public String getAcntNo() {
/* 117 */     return this.acntNo;
/*     */   }
/*     */   
/*     */   public void setAcntNo(String acntNo) {
/* 121 */     this.acntNo = acntNo;
/*     */   }
/*     */   
/*     */   public String getBankCd() {
/* 125 */     return this.bankCd;
/*     */   }
/*     */   
/*     */   public void setBankCd(String bankCd) {
/* 129 */     this.bankCd = bankCd;
/*     */   }
/*     */   
/*     */   public String getUserNm() {
/* 133 */     return this.userNm;
/*     */   }
/*     */   
/*     */   public void setUserNm(String userNm) {
/* 137 */     this.userNm = userNm;
/*     */   }
/*     */   
/*     */   public String getCredtNo() {
/* 141 */     return this.credtNo;
/*     */   }
/*     */   
/*     */   public void setCredtNo(String credtNo) {
/* 145 */     this.credtNo = credtNo;
/*     */   }
/*     */   
/*     */   public String getPageFrontUrl() {
/* 149 */     return this.pageFrontUrl;
/*     */   }
/*     */   
/*     */   public void setPageFrontUrl(String pageFrontUrl) {
/* 153 */     this.pageFrontUrl = pageFrontUrl;
/*     */   }
/*     */   
/*     */   public String getMobileNo() {
/* 157 */     return this.mobileNo;
/*     */   }
/*     */   
/*     */   public void setMobileNo(String mobileNo) {
/* 161 */     this.mobileNo = mobileNo;
/*     */   }
/*     */ }
