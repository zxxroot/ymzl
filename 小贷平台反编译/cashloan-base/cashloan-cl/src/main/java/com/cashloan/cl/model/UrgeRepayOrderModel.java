/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.UrgeRepayOrder;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UrgeRepayOrderModel
/*     */   extends UrgeRepayOrder
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String STATE_ORDER_PRE = "10";
/*     */   public static final String STATE_ORDER_WAIT = "11";
/*     */   public static final String STATE_ORDER_URGE = "20";
/*     */   public static final String STATE_ORDER_PROMISE = "30";
/*     */   public static final String STATE_ORDER_SUCCESS = "40";
/*     */   public static final String STATE_ORDER_BAD = "50";
/*     */   public static final String STATE_ORDER_FAIL = "60";
/*     */   private Date createTime;
/*     */   private String remark;
/*     */   private Date promiseTime;
/*     */   private String way;
/*     */   public String idNo;
/*     */   public String idAddr;
/*     */   private Long userInfoId;
/*     */   private String flag;
/*     */   private String stateStr;
/*     */   
/*     */   public static String change(String state)
/*     */   {
/*  39 */     String stateStr = "";
/*  40 */     if (state == null) {
/*  41 */       state = "";
/*     */     }
/*  43 */     String str1 = state; switch (state.hashCode()) {case 1567:  if (str1.equals("10")) break; break; case 1568:
    if (str1.equals("11")) {} break; case 1598:  if (str1.equals("20")) {} break; case 1629:  if (str1.equals("30")) {} break; case 1660:
        if (str1.equals("40")) {} break; case 1691:  if (str1.equals("50")) {} break; case 1722:  if (!str1.equals("60"))
/*     */       {
/*  45 */        stateStr = "未分配催收人员";
/*  46 */         return stateStr;
/*     */         
///*  48 */         stateStr = "待催收";
///*  49 */         return stateStr;
///*     */
///*  51 */         stateStr = "催收中";
///*  52 */         return stateStr;
///*     */
///*  54 */         stateStr = "承诺还款";
///*  55 */         return stateStr;
///*     */
///*  57 */         stateStr = "催收成功";
///*  58 */         return stateStr;
///*     */
///*  60 */         stateStr = "坏账";
/*     */       }
/*     */       else {
/*  63 */         stateStr = "暂停催收";
/*     */       }
/*     */       break; }
/*  66 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getPromiseTime()
/*     */   {
/* 115 */     return this.promiseTime;
/*     */   }
/*     */   
/*     */   public void setPromiseTime(Date promiseTime) {
/* 119 */     this.promiseTime = promiseTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 128 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 138 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 147 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 157 */     this.remark = remark;
/*     */   }
/*     */   
/*     */   public String getWay() {
/* 161 */     return this.way;
/*     */   }
/*     */   
/*     */   public void setWay(String way) {
/* 165 */     this.way = way;
/*     */   }
/*     */   
/*     */   public String getIdNo() {
/* 169 */     return this.idNo;
/*     */   }
/*     */   
/*     */   public void setIdNo(String idNo) {
/* 173 */     this.idNo = idNo;
/*     */   }
/*     */   
/*     */   public Long getUserInfoId() {
/* 177 */     return this.userInfoId;
/*     */   }
/*     */   
/*     */   public void setUserInfoId(Long userInfoId) {
/* 181 */     this.userInfoId = userInfoId;
/*     */   }
/*     */   
/*     */   public String getFlag() {
/* 185 */     return this.flag;
/*     */   }
/*     */   
/*     */   public void setFlag(String flag) {
/* 189 */     this.flag = flag;
/*     */   }
/*     */   
/*     */   public String getIdAddr() {
/* 193 */     return this.idAddr;
/*     */   }
/*     */   
/*     */   public void setIdAddr(String idAddr) {
/* 197 */     this.idAddr = idAddr;
/*     */   }
/*     */   
/*     */   public String getStateStr() {
/* 201 */     return this.stateStr;
/*     */   }
/*     */   
/*     */   public void setStateStr(String stateStr) {
/* 205 */     this.stateStr = stateStr;
/*     */   }
/*     */ }
