/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.ProfitLog;
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
/*     */ public class ManageProfitLogModel
/*     */   extends ProfitLog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String agentName;
/*     */   private String userName;
/*     */   private String money;
/*     */   private String fee;
/*     */   private Date repayTime;
/*     */   private Double amount;
/*     */   
/*     */   public String getUserName()
/*     */   {
/*  27 */     return this.userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUserName(String userName)
/*     */   {
/*  34 */     this.userName = userName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMoney()
/*     */   {
/*  41 */     return this.money;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMoney(String money)
/*     */   {
/*  48 */     this.money = money;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getFee()
/*     */   {
/*  55 */     return this.fee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFee(String fee)
/*     */   {
/*  62 */     this.fee = fee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getRepayTime()
/*     */   {
/*  72 */     return this.repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepayTime(Date repayTime)
/*     */   {
/*  80 */     this.repayTime = repayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Double getAmount()
/*     */   {
/*  87 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAmount(Double amount)
/*     */   {
/*  94 */     this.amount = amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAgentName()
/*     */   {
/* 101 */     return this.agentName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAgentName(String agentName)
/*     */   {
/* 108 */     this.agentName = agentName;
/*     */   }
/*     */ }
