/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ import tool.util.DateUtil;
import tool.util.NumberUtil;

import java.util.Date;

/*     */
/*     */

/*     */ public class PaymentCheckModel
/*     */   extends BasePaymentModel
/*     */ {
/*     */   private Date orderTime;
/*     */   private String businessNo;
/*     */   private String ytOrderNo;
/*     */   private String ytAccountDate;
/*     */   private String payMark;
/*     */   private String state;
/*     */   private Date updatetime;
/*     */   private String fee;
/*     */   private String payProduct;
/*     */   private String payWay;
/*     */   private String orderInfo;
/*     */   private String receiverBank;
/*     */   private String receiverAccount;
/*     */   private String ReceiverName;
/*     */   
/*     */   public PaymentCheckModel anlsStr(String str)
/*     */   {
/*  95 */     PaymentCheckModel checkModel = new PaymentCheckModel();
/*  96 */     String[] checkArray = str.split(",");
/*  97 */     checkModel.setOrderNo(checkArray[0]);
/*  98 */     checkModel.setOid_partner(checkArray[1]);
/*  99 */     checkModel.setOrderTime(DateUtil.valueOf(checkArray[2]));
/* 100 */     checkModel.setBusinessNo(checkArray[3]);
/* 101 */     checkModel.setYtOrderNo(checkArray[4]);
/* 102 */     checkModel.setYtAccountDate(checkArray[5]);
/* 103 */     checkModel.setAmount(NumberUtil.getDouble(checkArray[6]));
/* 104 */     checkModel.setPayMark(checkArray[7]);
/* 105 */     checkModel.setState(checkArray[8]);
/* 106 */     checkModel.setUpdatetime(DateUtil.valueOf(checkArray[9]));
/* 107 */     checkModel.setFee(checkArray[10]);
/* 108 */     checkModel.setPayProduct(checkArray[11]);
/* 109 */     checkModel.setPayWay(checkArray[12]);
/* 110 */     checkModel.setOrderInfo(checkArray[13]);
/* 111 */     checkModel.setReceiverBank(checkArray[14]);
/* 112 */     checkModel.setReceiverAccount(checkArray[15]);
/* 113 */     checkModel.setReceiverName(checkArray[16]);
/* 114 */     return checkModel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getOrderTime()
/*     */   {
/* 123 */     return this.orderTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderTime(Date orderTime)
/*     */   {
/* 132 */     this.orderTime = orderTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBusinessNo()
/*     */   {
/* 141 */     return this.businessNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBusinessNo(String businessNo)
/*     */   {
/* 150 */     this.businessNo = businessNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getYtOrderNo()
/*     */   {
/* 159 */     return this.ytOrderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYtOrderNo(String ytOrderNo)
/*     */   {
/* 168 */     this.ytOrderNo = ytOrderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getYtAccountDate()
/*     */   {
/* 177 */     return this.ytAccountDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYtAccountDate(String ytAccountDate)
/*     */   {
/* 186 */     this.ytAccountDate = ytAccountDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPayMark()
/*     */   {
/* 195 */     return this.payMark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayMark(String payMark)
/*     */   {
/* 204 */     this.payMark = payMark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 213 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 222 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdatetime()
/*     */   {
/* 231 */     return this.updatetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdatetime(Date updatetime)
/*     */   {
/* 240 */     this.updatetime = updatetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFee()
/*     */   {
/* 249 */     return this.fee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFee(String fee)
/*     */   {
/* 258 */     this.fee = fee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPayProduct()
/*     */   {
/* 267 */     return this.payProduct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayProduct(String payProduct)
/*     */   {
/* 276 */     this.payProduct = payProduct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPayWay()
/*     */   {
/* 285 */     return this.payWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayWay(String payWay)
/*     */   {
/* 294 */     this.payWay = payWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderInfo()
/*     */   {
/* 303 */     return this.orderInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderInfo(String orderInfo)
/*     */   {
/* 312 */     this.orderInfo = orderInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReceiverBank()
/*     */   {
/* 321 */     return this.receiverBank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReceiverBank(String receiverBank)
/*     */   {
/* 330 */     this.receiverBank = receiverBank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReceiverAccount()
/*     */   {
/* 339 */     return this.receiverAccount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReceiverAccount(String receiverAccount)
/*     */   {
/* 348 */     this.receiverAccount = receiverAccount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReceiverName()
/*     */   {
/* 357 */     return this.ReceiverName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReceiverName(String receiverName)
/*     */   {
/* 366 */     this.ReceiverName = receiverName;
/*     */   }
/*     */ }
