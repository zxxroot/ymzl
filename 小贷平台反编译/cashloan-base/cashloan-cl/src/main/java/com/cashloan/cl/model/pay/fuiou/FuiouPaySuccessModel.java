/*     */ package com.cashloan.cl.model.pay.fuiou;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.codec.digest.DigestUtils;
/*     */ import org.apache.commons.lang.StringUtils;
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
/*     */ public class FuiouPaySuccessModel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7407229147995447245L;
/*     */   private String orderno;
/*     */   private String merdt;
/*     */   private String fuorderno;
/*     */   private String accntno;
/*     */   private String accntnm;
/*     */   private String bankno;
/*     */   private Long amt;
/*     */   private String state;
/*     */   private String result;
/*     */   private String reason;
/*     */   private String mac;
/*     */   
/*     */   public String getOrderno()
/*     */   {
/*  69 */     return this.orderno;
/*     */   }
/*     */   
/*     */   public void setOrderno(String orderno) {
/*  73 */     this.orderno = orderno;
/*     */   }
/*     */   
/*     */   public String getMerdt() {
/*  77 */     return this.merdt;
/*     */   }
/*     */   
/*     */   public void setMerdt(String merdt) {
/*  81 */     this.merdt = merdt;
/*     */   }
/*     */   
/*     */   public String getFuorderno() {
/*  85 */     return this.fuorderno;
/*     */   }
/*     */   
/*     */   public void setFuorderno(String fuorderno) {
/*  89 */     this.fuorderno = fuorderno;
/*     */   }
/*     */   
/*     */   public String getAccntno() {
/*  93 */     return this.accntno;
/*     */   }
/*     */   
/*     */   public void setAccntno(String accntno) {
/*  97 */     this.accntno = accntno;
/*     */   }
/*     */   
/*     */   public String getAccntnm() {
/* 101 */     return this.accntnm;
/*     */   }
/*     */   
/*     */   public void setAccntnm(String accntnm) {
/* 105 */     this.accntnm = accntnm;
/*     */   }
/*     */   
/*     */   public String getBankno() {
/* 109 */     return this.bankno;
/*     */   }
/*     */   
/*     */   public void setBankno(String bankno) {
/* 113 */     this.bankno = bankno;
/*     */   }
/*     */   
/*     */   public Long getAmt() {
/* 117 */     return this.amt;
/*     */   }
/*     */   
/*     */   public void setAmt(Long amt) {
/* 121 */     this.amt = amt;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 125 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 129 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getResult() {
/* 133 */     return this.result;
/*     */   }
/*     */   
/*     */   public void setResult(String result) {
/* 137 */     this.result = result;
/*     */   }
/*     */   
/*     */   public String getReason() {
/* 141 */     return this.reason;
/*     */   }
/*     */   
/*     */   public void setReason(String reason) {
/* 145 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   public String getMac() {
/* 149 */     return this.mac;
/*     */   }
/*     */   
/*     */   public void setMac(String mac) {
/* 153 */     this.mac = mac;
/*     */   }
/*     */   
/*     */   public Boolean isValidSign() {
/* 157 */     String mchntCd = Global.getValue("fuiou_mchnt");
/* 158 */     String signSource = mchntCd + "|" + Global.getValue("fuiou_passwd") + "|" + this.orderno + "|" + this.merdt + "|" + 
/* 159 */       this.accntno + "|" + this.amt + Global.getValue("fuiou_passwd");
/* 160 */     String sign = DigestUtils.shaHex(signSource);
/* 161 */     boolean isEq = StringUtils.equalsIgnoreCase(this.mac, sign);
/* 162 */     if (isEq) {
/* 163 */       return Boolean.TRUE;
/*     */     }
/* 165 */     return Boolean.FALSE;
/*     */   }
/*     */ }
