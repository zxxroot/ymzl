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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DhbHistorySearch
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private Long userId;
/*     */   private Integer searchCnt;
/*     */   private Integer searchCntRecent7Days;
/*     */   private Integer searchCntRecent14Days;
/*     */   private Integer searchCntRecent30Days;
/*     */   private Integer searchCntRecent60Days;
/*     */   private Integer searchCntRecent90Days;
/*     */   private Integer searchCntRecent180Days;
/*     */   private Integer orgCnt;
/*     */   private Integer orgCntRecent7Days;
/*     */   private Integer orgCntRecent14Days;
/*     */   private Integer orgCntRecent30Days;
/*     */   private Integer orgCntRecent60Days;
/*     */   private Integer orgCntRecent90Days;
/*     */   private Integer orgCntRecent180Days;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 111 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 120 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 129 */     return this.orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 138 */     this.orderNo = orderNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 147 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 156 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSearchCnt()
/*     */   {
/* 165 */     return this.searchCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSearchCnt(Integer searchCnt)
/*     */   {
/* 174 */     this.searchCnt = searchCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSearchCntRecent7Days()
/*     */   {
/* 183 */     return this.searchCntRecent7Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSearchCntRecent7Days(Integer searchCntRecent7Days)
/*     */   {
/* 192 */     this.searchCntRecent7Days = searchCntRecent7Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSearchCntRecent14Days()
/*     */   {
/* 201 */     return this.searchCntRecent14Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSearchCntRecent14Days(Integer searchCntRecent14Days)
/*     */   {
/* 210 */     this.searchCntRecent14Days = searchCntRecent14Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSearchCntRecent30Days()
/*     */   {
/* 219 */     return this.searchCntRecent30Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSearchCntRecent30Days(Integer searchCntRecent30Days)
/*     */   {
/* 228 */     this.searchCntRecent30Days = searchCntRecent30Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSearchCntRecent60Days()
/*     */   {
/* 237 */     return this.searchCntRecent60Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSearchCntRecent60Days(Integer searchCntRecent60Days)
/*     */   {
/* 246 */     this.searchCntRecent60Days = searchCntRecent60Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSearchCntRecent90Days()
/*     */   {
/* 255 */     return this.searchCntRecent90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSearchCntRecent90Days(Integer searchCntRecent90Days)
/*     */   {
/* 264 */     this.searchCntRecent90Days = searchCntRecent90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getSearchCntRecent180Days()
/*     */   {
/* 273 */     return this.searchCntRecent180Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSearchCntRecent180Days(Integer searchCntRecent180Days)
/*     */   {
/* 282 */     this.searchCntRecent180Days = searchCntRecent180Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrgCnt()
/*     */   {
/* 291 */     return this.orgCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgCnt(Integer orgCnt)
/*     */   {
/* 300 */     this.orgCnt = orgCnt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrgCntRecent7Days()
/*     */   {
/* 309 */     return this.orgCntRecent7Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgCntRecent7Days(Integer orgCntRecent7Days)
/*     */   {
/* 318 */     this.orgCntRecent7Days = orgCntRecent7Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrgCntRecent14Days()
/*     */   {
/* 327 */     return this.orgCntRecent14Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgCntRecent14Days(Integer orgCntRecent14Days)
/*     */   {
/* 336 */     this.orgCntRecent14Days = orgCntRecent14Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrgCntRecent30Days()
/*     */   {
/* 345 */     return this.orgCntRecent30Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgCntRecent30Days(Integer orgCntRecent30Days)
/*     */   {
/* 354 */     this.orgCntRecent30Days = orgCntRecent30Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrgCntRecent60Days()
/*     */   {
/* 363 */     return this.orgCntRecent60Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgCntRecent60Days(Integer orgCntRecent60Days)
/*     */   {
/* 372 */     this.orgCntRecent60Days = orgCntRecent60Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrgCntRecent90Days()
/*     */   {
/* 381 */     return this.orgCntRecent90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgCntRecent90Days(Integer orgCntRecent90Days)
/*     */   {
/* 390 */     this.orgCntRecent90Days = orgCntRecent90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrgCntRecent180Days()
/*     */   {
/* 399 */     return this.orgCntRecent180Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgCntRecent180Days(Integer orgCntRecent180Days)
/*     */   {
/* 408 */     this.orgCntRecent180Days = orgCntRecent180Days;
/*     */   }
/*     */ }
