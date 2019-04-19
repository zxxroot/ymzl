/*     */ package com.rongdu.cashloan.rc.domain;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SceneBusinessLog
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public Long id;
/*     */   public Long sceneId;
/*     */   public Long borrowId;
/*     */   public Long userId;
/*     */   public Long tppId;
/*     */   public Long businessId;
/*     */   public String nid;
/*     */   public Date createTime;
/*     */   public Date updateTime;
/*     */   public String rsState;
/*     */   public String rsDesc;
/*     */   public String type;
/*     */   private String scene;
/*     */   private String phone;
/*     */   
/*     */   public SceneBusinessLog() {}
/*     */   
/*     */   public SceneBusinessLog(Long sceneId, Long borrowId, Long userId, Long tppId, Long businessId, String nid, Date createTime, String type, String phone)
/*     */   {
/*  96 */     this.sceneId = sceneId;
/*  97 */     this.borrowId = borrowId;
/*  98 */     this.userId = userId;
/*  99 */     this.tppId = tppId;
/* 100 */     this.businessId = businessId;
/* 101 */     this.nid = nid;
/* 102 */     this.createTime = createTime;
/* 103 */     this.type = type;
/* 104 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 113 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 122 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getSceneId()
/*     */   {
/* 131 */     return this.sceneId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSceneId(Long sceneId)
/*     */   {
/* 140 */     this.sceneId = sceneId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getBorrowId()
/*     */   {
/* 149 */     return this.borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowId(Long borrowId)
/*     */   {
/* 158 */     this.borrowId = borrowId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getTppId()
/*     */   {
/* 167 */     return this.tppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTppId(Long tppId)
/*     */   {
/* 176 */     this.tppId = tppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNid()
/*     */   {
/* 185 */     return this.nid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNid(String nid)
/*     */   {
/* 194 */     this.nid = nid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getBusinessId()
/*     */   {
/* 203 */     return this.businessId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBusinessId(Long businessId)
/*     */   {
/* 212 */     this.businessId = businessId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 221 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 230 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRsState()
/*     */   {
/* 239 */     return this.rsState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRsState(String rsState)
/*     */   {
/* 248 */     this.rsState = rsState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRsDesc()
/*     */   {
/* 257 */     return this.rsDesc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRsDesc(String rsDesc)
/*     */   {
/* 266 */     this.rsDesc = rsDesc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 275 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 284 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/* 293 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 302 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 311 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 320 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getScene() {
/* 324 */     return this.scene;
/*     */   }
/*     */   
/*     */   public void setScene(String scene) {
/* 328 */     this.scene = scene;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 332 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 336 */     this.phone = phone;
/*     */   }
/*     */ }

