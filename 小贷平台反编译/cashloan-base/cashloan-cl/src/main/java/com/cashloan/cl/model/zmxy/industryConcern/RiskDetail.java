/*     */ package com.cashloan.cl.model.zmxy.industryConcern;
/*     */ 
/*     */ import com.antgroup.zmxy.openplatform.api.domain.ZmWatchListExtendInfo;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RiskDetail
/*     */ {
/*     */   private String bizCode;
/*     */   private String code;
/*     */   private boolean settlement;
/*     */   private String status;
/*     */   private String type;
/*     */   private String bizMsg;
/*     */   private String codeMsg;
/*     */   private String typeMsg;
/*     */   private List<ZmWatchListExtendInfo> extendInfos;
/*     */   
/*     */   public String getBizCode()
/*     */   {
/*  58 */     return this.bizCode;
/*     */   }
/*     */   
/*     */   public void setBizCode(String bizCode) {
/*  62 */     this.bizCode = bizCode;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  66 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  70 */     this.code = code;
/*     */   }
/*     */   
/*     */   public boolean getSettlement() {
/*  74 */     return this.settlement;
/*     */   }
/*     */   
/*     */   public void setSettlement(boolean settlement) {
/*  78 */     this.settlement = settlement;
/*     */   }
/*     */   
/*     */   public String getStatus() {
/*  82 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/*  86 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  90 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  94 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getBizMsg() {
/*  98 */     return this.bizMsg;
/*     */   }
/*     */   
/*     */   public void setBizMsg(String bizMsg) {
/* 102 */     this.bizMsg = bizMsg;
/*     */   }
/*     */   
/*     */   public String getCodeMsg() {
/* 106 */     return this.codeMsg;
/*     */   }
/*     */   
/*     */   public void setCodeMsg(String codeMsg) {
/* 110 */     this.codeMsg = codeMsg;
/*     */   }
/*     */   
/*     */   public String getTypeMsg() {
/* 114 */     return this.typeMsg;
/*     */   }
/*     */   
/*     */   public void setTypeMsg(String typeMsg) {
/* 118 */     this.typeMsg = typeMsg;
/*     */   }
/*     */   
/*     */   public List<ZmWatchListExtendInfo> getExtendInfos() {
/* 122 */     return this.extendInfos;
/*     */   }
/*     */   
/*     */   public void setExtendInfos(List<ZmWatchListExtendInfo> extendInfos) {
/* 126 */     this.extendInfos = extendInfos;
/*     */   }
/*     */ }
