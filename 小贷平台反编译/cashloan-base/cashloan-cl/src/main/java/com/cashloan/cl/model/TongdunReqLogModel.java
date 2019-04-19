/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.TongdunReqLog;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TongdunReqLogModel
/*     */   extends TongdunReqLog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Double amount;
/*     */   private String realName;
/*     */   private String phone;
/*     */   private String borrowNo;
/*     */   private String queryParams;
/*     */   private String stateStr;
/*     */   public static final String STATE_SUBMIT = "10";
/*     */   public static final String STATE_PASS = "20";
/*     */   public static final String STATE_REFUSED = "30";
/*     */   
/*     */   public String getStateStr()
/*     */   {
/*  48 */     if ("10".equals(getState())) {
/*  49 */       setStateStr("已提交审核");
/*  50 */     } else if ("20".equals(getState())) {
/*  51 */       setStateStr("查询成功");
/*  52 */     } else if ("30".equals(getState())) {
/*  53 */       setStateStr("查询失败  ");
/*     */     } else {
/*  55 */       setStateStr("--");
/*     */     }
/*  57 */     return this.stateStr;
/*     */   }
/*     */   
/*     */   public void setStateStr(String stateStr) {
/*  61 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */   public Double getAmount()
/*     */   {
/*  67 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Double amount) {
/*  71 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/*  75 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/*  79 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/*  83 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  87 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getBorrowNo() {
/*  91 */     return this.borrowNo;
/*     */   }
/*     */   
/*     */   public void setBorrowNo(String borrowNo) {
/*  95 */     this.borrowNo = borrowNo;
/*     */   }
/*     */   
/*     */   public String getQueryParams() {
/*  99 */     return this.queryParams;
/*     */   }
/*     */   
/*     */   public void setQueryParams(String queryParams) {
/* 103 */     this.queryParams = queryParams;
/*     */   }
/*     */ }
