/*     */ package com.rongdu.cashloan.core.model;
/*     */ 
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BorrowModel
/*     */   extends Borrow
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String STATE_PRE = "10";
/*     */   public static final String STATE_AUTO_PASS = "20";
/*     */   public static final String STATE_AUTO_REFUSED = "21";
/*     */   public static final String STATE_NEED_REVIEW = "22";
/*     */   public static final String STATE_PASS = "26";
/*     */   public static final String STATE_REFUSED = "27";
/*     */   public static final String STATE_REPAY = "30";
/*     */   public static final String STATE_REPAY_FAIL = "31";
/*     */   public static final String STATE_FINISH = "40";
/*     */   public static final String STATE_REMISSION_FINISH = "41";
/*     */   public static final String STATE_DELAY = "50";
/*     */   public static final String STATE_BAD = "90";
/*     */   private String stateStr;
/*     */   private String remark;
/*     */   
/*     */   public String getStateStr()
/*     */   {
/*  64 */     this.stateStr = apiConvertBorrowState(getState());
/*  65 */     return this.stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStateStr(String stateStr)
/*     */   {
/*  73 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRemark()
/*     */   {
/*  81 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/*  89 */     this.remark = remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String manageConvertBorrowState(String state)
/*     */   {
/*  97 */     String stateStr = " - ";
/*  98 */     if ("10".equals(state)) {
/*  99 */       stateStr = "申请成功待审核";
/* 100 */     } else if ("20".equals(state)) {
/* 101 */       stateStr = "自动审核通过";
/* 102 */     } else if ("21".equals(state)) {
/* 103 */       stateStr = "自动审核不通过 ";
/* 104 */     } else if ("22".equals(state)) {
/* 105 */       stateStr = "待人工复审";
/* 106 */     } else if ("26".equals(state)) {
/* 107 */       stateStr = "人工复审通过";
/* 108 */     } else if ("27".equals(state)) {
/* 109 */       stateStr = "人工复审不通过";
/* 110 */     } else if ("30".equals(state)) {
/* 111 */       stateStr = "放款成功";
/* 112 */     } else if ("31".equals(state)) {
/* 113 */       stateStr = "放款失败";
/* 114 */     } else if ("40".equals(state)) {
/* 115 */       stateStr = "还款成功";
/* 116 */     } else if ("41".equals(state)) {
/* 117 */       stateStr = "还款成功-金额减免";
/* 118 */     } else if ("50".equals(state)) {
/* 119 */       stateStr = "已逾期";
/* 120 */     } else if ("90".equals(state)) {
/* 121 */       stateStr = "已坏账";
/*     */     }
/*     */     
/* 124 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String apiConvertBorrowState(String state)
/*     */   {
/* 133 */     String stateStr = state;
/* 134 */     if ("10".equals(state)) {
/* 135 */       stateStr = "待审核";
/* 136 */     } else if ("20".equals(state)) {
/* 137 */       stateStr = "审核通过";
/* 138 */     } else if ("21".equals(state)) {
/* 139 */       stateStr = "审核不通过";
/* 140 */     } else if ("22".equals(state)) {
/* 141 */       stateStr = "待审核";
/* 142 */     } else if ("26".equals(state)) {
/* 143 */       stateStr = "审核通过";
/* 144 */     } else if ("27".equals(state)) {
/* 145 */       stateStr = "审核不通过";
/* 146 */     } else if ("30".equals(state)) {
/* 147 */       stateStr = "还款中";
/* 148 */     } else if ("31".equals(state)) {
/* 149 */       stateStr = "放款失败";
/* 150 */     } else if ("40".equals(state)) {
/* 151 */       stateStr = "已还款";
/* 152 */     } else if ("41".equals(state)) {
/* 153 */       stateStr = "已还款";
/* 154 */     } else if ("50".equals(state)) {
/* 155 */       stateStr = "已逾期";
/* 156 */     } else if ("90".equals(state)) {
/* 157 */       stateStr = "已逾期";
/*     */     }
/* 159 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String convertBorrowRemark(String state)
/*     */   {
/* 169 */     String remarkStr = " - ";
/* 170 */     if ("10".equals(state)) {
/* 171 */       remarkStr = "系统审核中,请耐心等待";
/* 172 */     } else if ("20".equals(state)) {
/* 173 */       remarkStr = "恭喜通过风控审核";
/* 174 */     } else if ("21".equals(state)) {
/* 175 */       remarkStr = "很遗憾,您未通过审核";
/* 176 */     } else if ("22".equals(state)) {
/* 177 */       remarkStr = "系统复审中,请耐心等待";
/* 178 */     } else if ("26".equals(state)) {
/* 179 */       remarkStr = "恭喜通过风控复审";
/* 180 */     } else if ("27".equals(state)) {
/* 181 */       remarkStr = "很遗憾,您未通过复审";
/* 182 */     } else if ("30".equals(state)) {
/* 183 */       remarkStr = "已打款,请查看您的提现银行卡";
/* 184 */     } else if ("31".equals(state)) {
/* 185 */       remarkStr = "放款失败";
/* 186 */     } else if ("40".equals(state)) {
/* 187 */       remarkStr = "还款成功";
/* 188 */     } else if ("41".equals(state)) {
/* 189 */       remarkStr = "借款人无法支付全部借款金额,减免还款成功";
/* 190 */     } else if ("50".equals(state)) {
/* 191 */       remarkStr = "您的借款已逾期";
/* 192 */     } else if ("90".equals(state)) {
/* 193 */       remarkStr = "经长时间催收,没有结果";
/*     */     }
/* 195 */     return remarkStr;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\model\BorrowModel.class

 */