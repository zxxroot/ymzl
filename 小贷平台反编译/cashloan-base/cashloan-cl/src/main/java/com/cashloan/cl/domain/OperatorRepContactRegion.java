/*     */ package com.cashloan.cl.domain;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperatorRepContactRegion
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String regionLoc;
/*     */   private Integer regionCallInCnt;
/*     */   private Integer regionCallOutCnt;
/*     */   private Integer regionUniqNumCnt;
/*     */   private Double regionCallInTime;
/*     */   private Double regionCallOutTime;
/*     */   private Double regionAvgCallInTime;
/*     */   private Double regionAvgCallOutTime;
/*     */   private Double regionCallInCntPct;
/*     */   private Double regionCallOutCntPct;
/*     */   private Double regionCallInTimePct;
/*     */   private Double regionCallOutTimePct;
/*     */   private Date createTime;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 103 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 112 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 121 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 130 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRegionLoc()
/*     */   {
/* 139 */     return this.regionLoc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionLoc(String regionLoc)
/*     */   {
/* 148 */     this.regionLoc = regionLoc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getRegionCallInCnt()
/*     */   {
/* 157 */     return this.regionCallInCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionCallInCnt(Integer regionCallInCnt)
/*     */   {
/* 166 */     this.regionCallInCnt = regionCallInCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getRegionCallOutCnt()
/*     */   {
/* 175 */     return this.regionCallOutCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionCallOutCnt(Integer regionCallOutCnt)
/*     */   {
/* 184 */     this.regionCallOutCnt = regionCallOutCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getRegionUniqNumCnt()
/*     */   {
/* 193 */     return this.regionUniqNumCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionUniqNumCnt(Integer regionUniqNumCnt)
/*     */   {
/* 202 */     this.regionUniqNumCnt = regionUniqNumCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRegionCallInTime()
/*     */   {
/* 211 */     return this.regionCallInTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionCallInTime(Double regionCallInTime)
/*     */   {
/* 220 */     this.regionCallInTime = regionCallInTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRegionCallOutTime()
/*     */   {
/* 229 */     return this.regionCallOutTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionCallOutTime(Double regionCallOutTime)
/*     */   {
/* 238 */     this.regionCallOutTime = regionCallOutTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRegionAvgCallInTime()
/*     */   {
/* 247 */     return this.regionAvgCallInTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionAvgCallInTime(Double regionAvgCallInTime)
/*     */   {
/* 256 */     this.regionAvgCallInTime = regionAvgCallInTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRegionAvgCallOutTime()
/*     */   {
/* 265 */     return this.regionAvgCallOutTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionAvgCallOutTime(Double regionAvgCallOutTime)
/*     */   {
/* 274 */     this.regionAvgCallOutTime = regionAvgCallOutTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRegionCallInCntPct()
/*     */   {
/* 283 */     return this.regionCallInCntPct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionCallInCntPct(Double regionCallInCntPct)
/*     */   {
/* 292 */     this.regionCallInCntPct = regionCallInCntPct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRegionCallOutCntPct()
/*     */   {
/* 301 */     return this.regionCallOutCntPct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionCallOutCntPct(Double regionCallOutCntPct)
/*     */   {
/* 310 */     this.regionCallOutCntPct = regionCallOutCntPct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRegionCallInTimePct()
/*     */   {
/* 319 */     return this.regionCallInTimePct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionCallInTimePct(Double regionCallInTimePct)
/*     */   {
/* 328 */     this.regionCallInTimePct = regionCallInTimePct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRegionCallOutTimePct()
/*     */   {
/* 337 */     return this.regionCallOutTimePct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegionCallOutTimePct(Double regionCallOutTimePct)
/*     */   {
/* 346 */     this.regionCallOutTimePct = regionCallOutTimePct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 355 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 364 */     this.createTime = createTime;
/*     */   }
/*     */ }
