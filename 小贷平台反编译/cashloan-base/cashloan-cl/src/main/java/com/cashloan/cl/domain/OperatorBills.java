/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperatorBills
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Date gmtModified;
/*     */   private String phoneNum;
/*     */   private Date gmtCreate;
/*     */   private Date month;
/*     */   private Date billMonthDateStart;
/*     */   private Date billMonthDateEnd;
/*     */   private Double billMonthAmt;
/*     */   private String bizNo;
/*     */   private Date createTime;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  77 */     return this.id;
/*     */   }
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
/*     */   public Date getGmtModified()
/*     */   {
/*  93 */     return this.gmtModified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGmtModified(Date gmtModified)
/*     */   {
/* 101 */     this.gmtModified = gmtModified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhoneNum()
/*     */   {
/* 110 */     return this.phoneNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneNum(String phoneNum)
/*     */   {
/* 118 */     this.phoneNum = phoneNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 126 */     return this.gmtCreate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 134 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getMonth()
/*     */   {
/* 142 */     return this.month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMonth(Date month)
/*     */   {
/* 150 */     this.month = month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getBillMonthDateStart()
/*     */   {
/* 158 */     return this.billMonthDateStart;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBillMonthDateStart(Date billMonthDateStart)
/*     */   {
/* 166 */     this.billMonthDateStart = billMonthDateStart;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getBillMonthDateEnd()
/*     */   {
/* 174 */     return this.billMonthDateEnd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBillMonthDateEnd(Date billMonthDateEnd)
/*     */   {
/* 182 */     this.billMonthDateEnd = billMonthDateEnd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getBillMonthAmt()
/*     */   {
/* 190 */     return this.billMonthAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBillMonthAmt(Double billMonthAmt)
/*     */   {
/* 198 */     this.billMonthAmt = billMonthAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBizNo()
/*     */   {
/* 206 */     return this.bizNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBizNo(String bizNo)
/*     */   {
/* 214 */     this.bizNo = bizNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 222 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 230 */     this.createTime = createTime;
/*     */   }
/*     */ }
