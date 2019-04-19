/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperatorTdSmsRecord
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long infoId;
/*     */   private String msgStartTime;
/*     */   private String msgType;
/*     */   private String msgOtherNum;
/*     */   private String msgChannel;
/*     */   private String msgBizName;
/*     */   private String msgAddress;
/*     */   private String msgFee;
/*     */   private String msgDiscount;
/*     */   private String msgCost;
/*     */   private String msgRemark;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  86 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  95 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getInfoId()
/*     */   {
/* 104 */     return this.infoId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInfoId(Long infoId)
/*     */   {
/* 113 */     this.infoId = infoId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgStartTime()
/*     */   {
/* 122 */     return this.msgStartTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgStartTime(String msgStartTime)
/*     */   {
/* 131 */     this.msgStartTime = msgStartTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgType()
/*     */   {
/* 140 */     return this.msgType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgType(String msgType)
/*     */   {
/* 149 */     this.msgType = msgType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgOtherNum()
/*     */   {
/* 158 */     return this.msgOtherNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgOtherNum(String msgOtherNum)
/*     */   {
/* 167 */     this.msgOtherNum = msgOtherNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgChannel()
/*     */   {
/* 176 */     return this.msgChannel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgChannel(String msgChannel)
/*     */   {
/* 185 */     this.msgChannel = msgChannel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgBizName()
/*     */   {
/* 194 */     return this.msgBizName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgBizName(String msgBizName)
/*     */   {
/* 203 */     this.msgBizName = msgBizName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgAddress()
/*     */   {
/* 212 */     return this.msgAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgAddress(String msgAddress)
/*     */   {
/* 221 */     this.msgAddress = msgAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgFee()
/*     */   {
/* 230 */     return this.msgFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgFee(String msgFee)
/*     */   {
/* 239 */     this.msgFee = msgFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgDiscount()
/*     */   {
/* 248 */     return this.msgDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgDiscount(String msgDiscount)
/*     */   {
/* 257 */     this.msgDiscount = msgDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgCost()
/*     */   {
/* 266 */     return this.msgCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgCost(String msgCost)
/*     */   {
/* 275 */     this.msgCost = msgCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsgRemark()
/*     */   {
/* 284 */     return this.msgRemark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsgRemark(String msgRemark)
/*     */   {
/* 293 */     this.msgRemark = msgRemark;
/*     */   }
/*     */ }
