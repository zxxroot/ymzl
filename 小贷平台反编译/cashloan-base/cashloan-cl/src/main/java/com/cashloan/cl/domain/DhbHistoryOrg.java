/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DhbHistoryOrg
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private Long userId;
/*     */   private Integer onlineInstallmentCnt;
/*     */   private Integer offlineInstallmentCnt;
/*     */   private Integer creditCardRepaymentCnt;
/*     */   private Integer paydayLoanCnt;
/*     */   private Integer onlineCashLoanCnt;
/*     */   private Integer offlineCashLoanCnt;
/*     */   private Integer othersCnt;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  76 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  85 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/*  94 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 103 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 112 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 121 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOnlineInstallmentCnt()
/*     */   {
/* 130 */     return this.onlineInstallmentCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOnlineInstallmentCnt(Integer onlineInstallmentCnt)
/*     */   {
/* 139 */     this.onlineInstallmentCnt = onlineInstallmentCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOfflineInstallmentCnt()
/*     */   {
/* 148 */     return this.offlineInstallmentCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOfflineInstallmentCnt(Integer offlineInstallmentCnt)
/*     */   {
/* 157 */     this.offlineInstallmentCnt = offlineInstallmentCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCreditCardRepaymentCnt()
/*     */   {
/* 166 */     return this.creditCardRepaymentCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditCardRepaymentCnt(Integer creditCardRepaymentCnt)
/*     */   {
/* 175 */     this.creditCardRepaymentCnt = creditCardRepaymentCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPaydayLoanCnt()
/*     */   {
/* 184 */     return this.paydayLoanCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPaydayLoanCnt(Integer paydayLoanCnt)
/*     */   {
/* 193 */     this.paydayLoanCnt = paydayLoanCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOnlineCashLoanCnt()
/*     */   {
/* 202 */     return this.onlineCashLoanCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOnlineCashLoanCnt(Integer onlineCashLoanCnt)
/*     */   {
/* 211 */     this.onlineCashLoanCnt = onlineCashLoanCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOfflineCashLoanCnt()
/*     */   {
/* 220 */     return this.offlineCashLoanCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOfflineCashLoanCnt(Integer offlineCashLoanCnt)
/*     */   {
/* 229 */     this.offlineCashLoanCnt = offlineCashLoanCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOthersCnt()
/*     */   {
/* 238 */     return this.othersCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOthersCnt(Integer othersCnt)
/*     */   {
/* 247 */     this.othersCnt = othersCnt;
/*     */   }
/*     */ }
