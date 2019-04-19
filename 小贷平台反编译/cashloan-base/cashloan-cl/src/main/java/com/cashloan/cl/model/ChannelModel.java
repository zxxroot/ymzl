/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.Channel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChannelModel
/*     */   extends Channel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String STATE_ENABLE = "10";
/*     */   public static final String STATE_DISABLE = "20";
/*     */   public static final String SETTLEMENT_ALIPAY = "10";
/*     */   public static final String SETTLEMENT_BANK_CARD = "20";
/*     */   public static final String SETTLEMENTSIGN_COMMON = "10";
/*     */   public static final String SETTLEMENTSIGN_PRIVATE = "20";
/*     */   public static final String SETTLEMENTSTATE_UNSETTLED = "10";
/*     */   public static final String SETTLEMENTSTATE_SETTLEMENT = "20";
/*     */   public static final String CHANNEL_STAGE_EXPERIMENTAL_PERIOD = "10";
/*     */   public static final String CHANNEL_STAGE_PERIOD_UNDER_OBSERVATION = "20";
/*     */   public static final String CHANNEL_STAGE_DEEP_COOPERATION = "20";
/*     */   private String typeStr;
/*     */   private String stateStr;
/*     */   
/*     */   public static String stateConvert(String state)
/*     */   {
/*     */     String stateStr;
/*  80 */     if ("20".equals(state)) {
/*  81 */       stateStr = "禁用";
/*     */     } else {
/*  83 */       stateStr = "启用";
/*     */     }
/*  85 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTypeStr()
/*     */   {
/*  93 */     return this.typeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTypeStr(String typeStr)
/*     */   {
/* 101 */     this.typeStr = typeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getStateStr()
/*     */   {
/* 109 */     this.stateStr = stateConvert(getState());
/* 110 */     return this.stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStateStr(String stateStr)
/*     */   {
/* 118 */     this.stateStr = stateStr;
/*     */   }
/*     */ }
