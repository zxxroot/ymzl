/*     */ package com.cashloan.cl.model.pay.lianlian;
/*     */ 
/*     */ import java.util.Date;
/*     */ import tool.util.DateUtil;
/*     */ import tool.util.NumberUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransactionCheckModel
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
/*     */   
/*     */   public TransactionCheckModel anlsStr(String str)
/*     */   {
/*  82 */     TransactionCheckModel checkModel = new TransactionCheckModel();
/*  83 */     String[] checkArray = str.split(",");
/*  84 */     checkModel.setOrderNo(checkArray[0]);
/*  85 */     checkModel.setOid_partner(checkArray[1]);
/*  86 */     checkModel.setOrderTime(DateUtil.valueOf(checkArray[2]));
/*  87 */     checkModel.setBusinessNo(checkArray[3]);
/*  88 */     checkModel.setYtOrderNo(checkArray[4]);
/*  89 */     checkModel.setYtAccountDate(checkArray[5]);
/*  90 */     checkModel.setAmount(NumberUtil.getDouble(checkArray[6]));
/*  91 */     checkModel.setPayMark(checkArray[7]);
/*  92 */     checkModel.setState(checkArray[8]);
/*  93 */     checkModel.setUpdatetime(DateUtil.valueOf(checkArray[9]));
/*  94 */     checkModel.setFee(checkArray[10]);
/*  95 */     checkModel.setPayProduct(checkArray[11]);
/*  96 */     checkModel.setPayWay(checkArray[12]);
/*  97 */     checkModel.setOrderInfo(checkArray[13]);
/*  98 */     return checkModel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getOrderTime()
/*     */   {
/* 107 */     return this.orderTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderTime(Date orderTime)
/*     */   {
/* 116 */     this.orderTime = orderTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBusinessNo()
/*     */   {
/* 125 */     return this.businessNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBusinessNo(String businessNo)
/*     */   {
/* 134 */     this.businessNo = businessNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getYtOrderNo()
/*     */   {
/* 143 */     return this.ytOrderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYtOrderNo(String ytOrderNo)
/*     */   {
/* 152 */     this.ytOrderNo = ytOrderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getYtAccountDate()
/*     */   {
/* 161 */     return this.ytAccountDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYtAccountDate(String ytAccountDate)
/*     */   {
/* 170 */     this.ytAccountDate = ytAccountDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPayMark()
/*     */   {
/* 179 */     return this.payMark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayMark(String payMark)
/*     */   {
/* 188 */     this.payMark = payMark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 197 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 206 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdatetime()
/*     */   {
/* 215 */     return this.updatetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdatetime(Date updatetime)
/*     */   {
/* 224 */     this.updatetime = updatetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFee()
/*     */   {
/* 233 */     return this.fee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFee(String fee)
/*     */   {
/* 242 */     this.fee = fee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPayProduct()
/*     */   {
/* 251 */     return this.payProduct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayProduct(String payProduct)
/*     */   {
/* 260 */     this.payProduct = payProduct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPayWay()
/*     */   {
/* 269 */     return this.payWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayWay(String payWay)
/*     */   {
/* 278 */     this.payWay = payWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderInfo()
/*     */   {
/* 287 */     return this.orderInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderInfo(String orderInfo)
/*     */   {
/* 296 */     this.orderInfo = orderInfo;
/*     */   }
/*     */ }
