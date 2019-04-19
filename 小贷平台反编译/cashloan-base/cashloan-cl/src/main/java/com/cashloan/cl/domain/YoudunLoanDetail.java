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
/*     */ public class YoudunLoanDetail
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String orderNo;
/*     */   private String actualLoanPlatformCount;
/*     */   private String actualLoanPlatformCount3m;
/*     */   private String actualLoanPlatformCount1m;
/*     */   private String actualLoanPlatformCount6m;
/*     */   private String loanPlatformCount;
/*     */   private String loanPlatformCount3m;
/*     */   private String loanPlatformCount1m;
/*     */   private String loanPlatformCount6m;
/*     */   private String repaymentTimesCount;
/*     */   private String repaymentPlatformCount;
/*     */   private String repaymentPlatformCount3m;
/*     */   private String repaymentPlatformCount1m;
/*     */   private String repaymentPlatformCount6m;
/*     */   private String loanIndustry;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 111 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 120 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 129 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 138 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 147 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 156 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getActualLoanPlatformCount()
/*     */   {
/* 165 */     return this.actualLoanPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setActualLoanPlatformCount(String actualLoanPlatformCount)
/*     */   {
/* 174 */     this.actualLoanPlatformCount = actualLoanPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getActualLoanPlatformCount3m()
/*     */   {
/* 183 */     return this.actualLoanPlatformCount3m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setActualLoanPlatformCount3m(String actualLoanPlatformCount3m)
/*     */   {
/* 192 */     this.actualLoanPlatformCount3m = actualLoanPlatformCount3m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getActualLoanPlatformCount1m()
/*     */   {
/* 201 */     return this.actualLoanPlatformCount1m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setActualLoanPlatformCount1m(String actualLoanPlatformCount1m)
/*     */   {
/* 210 */     this.actualLoanPlatformCount1m = actualLoanPlatformCount1m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getActualLoanPlatformCount6m()
/*     */   {
/* 219 */     return this.actualLoanPlatformCount6m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setActualLoanPlatformCount6m(String actualLoanPlatformCount6m)
/*     */   {
/* 228 */     this.actualLoanPlatformCount6m = actualLoanPlatformCount6m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanPlatformCount()
/*     */   {
/* 237 */     return this.loanPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanPlatformCount(String loanPlatformCount)
/*     */   {
/* 246 */     this.loanPlatformCount = loanPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanPlatformCount3m()
/*     */   {
/* 255 */     return this.loanPlatformCount3m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanPlatformCount3m(String loanPlatformCount3m)
/*     */   {
/* 264 */     this.loanPlatformCount3m = loanPlatformCount3m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanPlatformCount1m()
/*     */   {
/* 273 */     return this.loanPlatformCount1m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanPlatformCount1m(String loanPlatformCount1m)
/*     */   {
/* 282 */     this.loanPlatformCount1m = loanPlatformCount1m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanPlatformCount6m()
/*     */   {
/* 291 */     return this.loanPlatformCount6m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanPlatformCount6m(String loanPlatformCount6m)
/*     */   {
/* 300 */     this.loanPlatformCount6m = loanPlatformCount6m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepaymentTimesCount()
/*     */   {
/* 309 */     return this.repaymentTimesCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepaymentTimesCount(String repaymentTimesCount)
/*     */   {
/* 318 */     this.repaymentTimesCount = repaymentTimesCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepaymentPlatformCount()
/*     */   {
/* 327 */     return this.repaymentPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepaymentPlatformCount(String repaymentPlatformCount)
/*     */   {
/* 336 */     this.repaymentPlatformCount = repaymentPlatformCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepaymentPlatformCount3m()
/*     */   {
/* 345 */     return this.repaymentPlatformCount3m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepaymentPlatformCount3m(String repaymentPlatformCount3m)
/*     */   {
/* 354 */     this.repaymentPlatformCount3m = repaymentPlatformCount3m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepaymentPlatformCount1m()
/*     */   {
/* 363 */     return this.repaymentPlatformCount1m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepaymentPlatformCount1m(String repaymentPlatformCount1m)
/*     */   {
/* 372 */     this.repaymentPlatformCount1m = repaymentPlatformCount1m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRepaymentPlatformCount6m()
/*     */   {
/* 381 */     return this.repaymentPlatformCount6m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepaymentPlatformCount6m(String repaymentPlatformCount6m)
/*     */   {
/* 390 */     this.repaymentPlatformCount6m = repaymentPlatformCount6m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanIndustry()
/*     */   {
/* 399 */     return this.loanIndustry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanIndustry(String loanIndustry)
/*     */   {
/* 408 */     this.loanIndustry = loanIndustry;
/*     */   }
/*     */ }
