/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.BorrowProgress;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BorrowProgressModel
/*     */   extends BorrowProgress
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String PROGRESS_APPLY = "10";
/*     */   public static final String PROGRESS_AUTO_PASS = "20";
/*     */   public static final String PROGRESS_AUTO_REFUSED = "21";
/*     */   public static final String PROGRESS_NEED_REVIEW = "22";
/*     */   public static final String PROGRESS_PERSON_PASS = "26";
/*     */   public static final String PROGRESS_PERSON_RESUSED = "27";
/*     */   public static final String PROGRESS_LOAN_SUCCESS = "30";
/*     */   public static final String PROGRESS_LOAN_FAIL = "31";
/*     */   public static final String PROGRESS_REPAY_SUCCESS = "40";
/*     */   public static final String PROGRESS_REPAY_REMISSION_SUCCESS = "41";
/*     */   public static final String PROGRESS_REPAY_OVERDUE = "50";
/*     */   public static final String PROGRESS_BILL_BAD = "90";
/*     */   private String msg;
/*     */   private String type;
/*     */   private String createTimeStr;
/*     */   private String str;
/*     */   
/*     */   private String alter(String state)
/*     */   {
/*  46 */     String stateStr = "";
/*  47 */     if ("10".equals(state)) {
/*  48 */       stateStr = "申请提交成功";
/*  49 */     } else if ("22".equals(state)) {
/*  50 */       stateStr = "审核中";
/*  51 */     } else if (("20".equals(state)) || 
/*  52 */       ("26".equals(state))) {
/*  53 */       stateStr = "审核通过";
/*  54 */     } else if (("21".equals(state)) || 
/*  55 */       ("27".equals(state))) {
/*  56 */       stateStr = "审核未通过";
/*  57 */     } else if (("30".equals(state)) || 
/*  58 */       ("31".equals(state))) {
/*  59 */       stateStr = "已打款";
/*  60 */     } else if (("40".equals(state)) || 
/*  61 */       ("41".equals(state))) {
/*  62 */       stateStr = "已还款";
/*  63 */     } else if ("50".equals(state)) {
/*  64 */       stateStr = "已逾期";
/*  65 */     } else if ("90".equals(state)) {
/*  66 */       stateStr = "坏账";
/*     */     } else {
/*  68 */       stateStr = state;
/*     */     }
/*  70 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsg()
/*     */   {
/*  78 */     return this.msg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMsg(String msg)
/*     */   {
/*  85 */     this.msg = msg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/*  92 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/*  99 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreateTimeStr()
/*     */   {
/* 107 */     return this.createTimeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateTimeStr(String createTimeStr)
/*     */   {
/* 114 */     this.createTimeStr = createTimeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getStr()
/*     */   {
/* 123 */     return this.str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStr(String str)
/*     */   {
/* 131 */     this.str = alter(str);
/*     */   }
/*     */ }
