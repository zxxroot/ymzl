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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FuiouRefundModel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7407229147995447245L;
/*     */   private String orderno;
/*     */   private String merdt;
/*     */   private String fuorderno;
/*     */   private String tpmerdt;
/*     */   private String futporderno;
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
/*  76 */     return this.orderno;
/*     */   }
/*     */   
/*     */   public void setOrderno(String orderno) {
/*  80 */     this.orderno = orderno;
/*     */   }
/*     */   
/*     */   public String getMerdt() {
/*  84 */     return this.merdt;
/*     */   }
/*     */   
/*     */   public void setMerdt(String merdt) {
/*  88 */     this.merdt = merdt;
/*     */   }
/*     */   
/*     */   public String getFuorderno() {
/*  92 */     return this.fuorderno;
/*     */   }
/*     */   
/*     */   public void setFuorderno(String fuorderno) {
/*  96 */     this.fuorderno = fuorderno;
/*     */   }
/*     */   
/*     */   public String getTpmerdt() {
/* 100 */     return this.tpmerdt;
/*     */   }
/*     */   
/*     */   public void setTpmerdt(String tpmerdt) {
/* 104 */     this.tpmerdt = tpmerdt;
/*     */   }
/*     */   
/*     */   public String getFutporderno() {
/* 108 */     return this.futporderno;
/*     */   }
/*     */   
/*     */   public void setFutporderno(String futporderno) {
/* 112 */     this.futporderno = futporderno;
/*     */   }
/*     */   
/*     */   public String getAccntno() {
/* 116 */     return this.accntno;
/*     */   }
/*     */   
/*     */   public void setAccntno(String accntno) {
/* 120 */     this.accntno = accntno;
/*     */   }
/*     */   
/*     */   public String getAccntnm() {
/* 124 */     return this.accntnm;
/*     */   }
/*     */   
/*     */   public void setAccntnm(String accntnm) {
/* 128 */     this.accntnm = accntnm;
/*     */   }
/*     */   
/*     */   public String getBankno() {
/* 132 */     return this.bankno;
/*     */   }
/*     */   
/*     */   public void setBankno(String bankno) {
/* 136 */     this.bankno = bankno;
/*     */   }
/*     */   
/*     */   public Long getAmt() {
/* 140 */     return this.amt;
/*     */   }
/*     */   
/*     */   public void setAmt(Long amt) {
/* 144 */     this.amt = amt;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 148 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 152 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getResult() {
/* 156 */     return this.result;
/*     */   }
/*     */   
/*     */   public void setResult(String result) {
/* 160 */     this.result = result;
/*     */   }
/*     */   
/*     */   public String getReason() {
/* 164 */     return this.reason;
/*     */   }
/*     */   
/*     */   public void setReason(String reason) {
/* 168 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   public String getMac() {
/* 172 */     return this.mac;
/*     */   }
/*     */   
/*     */   public void setMac(String mac) {
/* 176 */     this.mac = mac;
/*     */   }
/*     */   
/*     */   public Boolean isValidSign() {
/* 180 */     String mchntCd = Global.getValue("fuiou_mchnt");
/* 181 */     String signSource = mchntCd + "|" + Global.getValue("fuiou_passwd") + "|" + this.orderno + "|" + this.merdt + "|" + 
/* 182 */       this.accntno + "|" + this.amt + Global.getValue("fuiou_passwd");
/* 183 */     String sign = DigestUtils.shaHex(signSource);
/* 184 */     boolean isEq = StringUtils.equalsIgnoreCase(this.mac, sign);
/* 185 */     if (isEq) {
/* 186 */       return Boolean.TRUE;
/*     */     }
/* 188 */     return Boolean.FALSE;
/*     */   }
/*     */ }
