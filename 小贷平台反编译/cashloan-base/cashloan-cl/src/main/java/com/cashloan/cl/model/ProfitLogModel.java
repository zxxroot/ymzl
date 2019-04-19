/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProfitLogModel
/*    */ {
/*    */   private double amount;
/*    */   private double money;
/*    */   private double fee;
/*    */   private String loginName;
/*    */   private Date addTime;
/*    */   private String msg;
/*    */   
/*    */   public double getAmount()
/*    */   {
/* 23 */     return this.amount;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setAmount(double amount)
/*    */   {
/* 29 */     this.amount = amount;
/*    */   }
/*    */   
/*    */ 
/*    */   public double getMoney()
/*    */   {
/* 35 */     return this.money;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setMoney(double money)
/*    */   {
/* 41 */     this.money = money;
/*    */   }
/*    */   
/*    */ 
/*    */   public double getFee()
/*    */   {
/* 47 */     return this.fee;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setFee(double fee)
/*    */   {
/* 53 */     this.fee = fee;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getLoginName()
/*    */   {
/* 59 */     return this.loginName;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setLoginName(String loginName)
/*    */   {
/* 65 */     this.loginName = loginName;
/*    */   }
/*    */   
/*    */ 
/*    */   public Date getAddTime()
/*    */   {
/* 71 */     return this.addTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setAddTime(Date addTime)
/*    */   {
/* 77 */     this.addTime = addTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getMsg()
/*    */   {
/* 83 */     return this.msg;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setMsg(String msg)
/*    */   {
/* 89 */     this.msg = msg;
/*    */   }
/*    */ }
