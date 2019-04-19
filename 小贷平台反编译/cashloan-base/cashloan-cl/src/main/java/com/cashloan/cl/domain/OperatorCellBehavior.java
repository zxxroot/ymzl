/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperatorCellBehavior
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String cellPhoneNum;
/*     */   private String cellLoc;
/*     */   private String cellOperator;
/*     */   private String cellOperatorZh;
/*     */   private String cellMth;
/*     */   private Long callCnt;
/*     */   private Long callOutCnt;
/*     */   private Double callOutTime;
/*     */   private Long callInCnt;
/*     */   private Double callInTime;
/*     */   private Double netFlow;
/*     */   private Long smsCnt;
/*     */   private Double totalAmount;
/*     */   private Date createTime;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 108 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 117 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 126 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 135 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCellPhoneNum()
/*     */   {
/* 144 */     return this.cellPhoneNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCellPhoneNum(String cellPhoneNum)
/*     */   {
/* 153 */     this.cellPhoneNum = cellPhoneNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCellLoc()
/*     */   {
/* 162 */     return this.cellLoc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCellLoc(String cellLoc)
/*     */   {
/* 171 */     this.cellLoc = cellLoc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCellOperator()
/*     */   {
/* 180 */     return this.cellOperator;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCellOperator(String cellOperator)
/*     */   {
/* 189 */     this.cellOperator = cellOperator;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCellOperatorZh()
/*     */   {
/* 198 */     return this.cellOperatorZh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCellOperatorZh(String cellOperatorZh)
/*     */   {
/* 207 */     this.cellOperatorZh = cellOperatorZh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCellMth()
/*     */   {
/* 216 */     return this.cellMth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCellMth(String cellMth)
/*     */   {
/* 225 */     this.cellMth = cellMth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCallCnt()
/*     */   {
/* 234 */     return this.callCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallCnt(Long callCnt)
/*     */   {
/* 243 */     this.callCnt = callCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCallOutCnt()
/*     */   {
/* 252 */     return this.callOutCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallOutCnt(Long callOutCnt)
/*     */   {
/* 261 */     this.callOutCnt = callOutCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getCallOutTime()
/*     */   {
/* 270 */     return this.callOutTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallOutTime(Double callOutTime)
/*     */   {
/* 279 */     this.callOutTime = callOutTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCallInCnt()
/*     */   {
/* 288 */     return this.callInCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallInCnt(Long callInCnt)
/*     */   {
/* 297 */     this.callInCnt = callInCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getCallInTime()
/*     */   {
/* 306 */     return this.callInTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCallInTime(Double callInTime)
/*     */   {
/* 315 */     this.callInTime = callInTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getNetFlow()
/*     */   {
/* 324 */     return this.netFlow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNetFlow(Double netFlow)
/*     */   {
/* 333 */     this.netFlow = netFlow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getSmsCnt()
/*     */   {
/* 342 */     return this.smsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSmsCnt(Long smsCnt)
/*     */   {
/* 351 */     this.smsCnt = smsCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getTotalAmount()
/*     */   {
/* 360 */     return this.totalAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalAmount(Double totalAmount)
/*     */   {
/* 369 */     this.totalAmount = totalAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 378 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 387 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Double getTotalCallTime()
/*     */   {
/* 394 */     BigDecimal b1 = new BigDecimal(getCallInTime() == null ? 0.0D : getCallInTime().doubleValue());
/* 395 */     BigDecimal b2 = new BigDecimal(getCallOutTime() == null ? 0.0D : getCallOutTime().doubleValue());
/* 396 */     return new Double(b1.add(b2).doubleValue());
/*     */   }
/*     */ }
