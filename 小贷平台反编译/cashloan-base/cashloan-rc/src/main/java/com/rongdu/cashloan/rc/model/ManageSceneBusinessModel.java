/*     */ package com.rongdu.cashloan.rc.model;
/*     */ 
/*     */ import com.rongdu.cashloan.rc.domain.SceneBusiness;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManageSceneBusinessModel
/*     */   extends SceneBusiness
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long tppId;
/*     */   private String tppName;
/*     */   private String businessName;
/*     */   private String sceneName;
/*     */   private String getWayStr;
/*     */   private String stateStr;
/*     */   
/*     */   public String getTppName()
/*     */   {
/*  55 */     return this.tppName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTppName(String tppName)
/*     */   {
/*  64 */     this.tppName = tppName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBusinessName()
/*     */   {
/*  73 */     return this.businessName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBusinessName(String businessName)
/*     */   {
/*  82 */     this.businessName = businessName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSceneName()
/*     */   {
/*  91 */     return this.sceneName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSceneName(String sceneName)
/*     */   {
/* 100 */     this.sceneName = sceneName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getGetWayStr()
/*     */   {
/* 109 */     if ("00".equals(getGetWay())) {
/* 110 */       this.getWayStr = "获取一次";
/* 111 */     } else if ("10".equals(getGetWay())) {
/* 112 */       this.getWayStr = "每次获取";
/* 113 */     } else if ("20".equals(getGetWay())) {
/* 114 */       this.getWayStr = "固定周期获取";
/*     */     }
/* 116 */     return this.getWayStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGetWayStr(String getWayStr)
/*     */   {
/* 125 */     this.getWayStr = getWayStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getStateStr()
/*     */   {
/* 134 */     return this.stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStateStr(String stateStr)
/*     */   {
/* 143 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getTppId()
/*     */   {
/* 151 */     return this.tppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTppId(Long tppId)
/*     */   {
/* 159 */     this.tppId = tppId;
/*     */   }
/*     */ }


