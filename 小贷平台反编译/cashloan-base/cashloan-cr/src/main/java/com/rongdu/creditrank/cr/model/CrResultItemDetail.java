/*     */ package com.rongdu.creditrank.cr.model;
/*     */ 
/*     */ import java.util.Date;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrResultItemDetail
/*     */ {
/*     */   private Long id;
/*     */   private Long resultId;
/*     */   private Long cardId;
/*     */   private Long itemId;
/*     */   private Long factorId;
/*     */   private Long paramId;
/*     */   private String paramName;
/*     */   private Integer paramScore;
/*     */   private String formula;
/*     */   private String cvalue;
/*     */   private String value;
/*     */   private String level;
/*     */   private Integer score;
/*     */   private Date addTime;
/*     */   public List<CrResultFactorDetail> factorList;
/*     */   
/*     */   public Long getResultId()
/*     */   {
/*  84 */     return this.resultId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResultId(Long resultId)
/*     */   {
/*  93 */     this.resultId = resultId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCardId()
/*     */   {
/* 102 */     return this.cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardId(Long cardId)
/*     */   {
/* 111 */     this.cardId = cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getItemId()
/*     */   {
/* 120 */     return this.itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setItemId(Long itemId)
/*     */   {
/* 129 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getFactorId()
/*     */   {
/* 138 */     return this.factorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFactorId(Long factorId)
/*     */   {
/* 147 */     this.factorId = factorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getParamId()
/*     */   {
/* 156 */     return this.paramId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamId(Long paramId)
/*     */   {
/* 165 */     this.paramId = paramId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getParamName()
/*     */   {
/* 174 */     return this.paramName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamName(String paramName)
/*     */   {
/* 183 */     this.paramName = paramName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getParamScore()
/*     */   {
/* 192 */     return this.paramScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamScore(Integer paramScore)
/*     */   {
/* 201 */     this.paramScore = paramScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFormula()
/*     */   {
/* 210 */     return this.formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFormula(String formula)
/*     */   {
/* 219 */     this.formula = formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCvalue()
/*     */   {
/* 228 */     return this.cvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCvalue(String cvalue)
/*     */   {
/* 237 */     this.cvalue = cvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getValue()
/*     */   {
/* 246 */     return this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setValue(String value)
/*     */   {
/* 255 */     this.value = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLevel()
/*     */   {
/* 264 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLevel(String level)
/*     */   {
/* 273 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getScore()
/*     */   {
/* 282 */     return this.score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScore(Integer score)
/*     */   {
/* 291 */     this.score = score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 300 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 309 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<CrResultFactorDetail> getFactorList()
/*     */   {
/* 318 */     return this.factorList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFactorList(List<CrResultFactorDetail> factorList)
/*     */   {
/* 327 */     this.factorList = factorList;
/*     */   }
/*     */   
/*     */   public Long getId() {
/* 331 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 335 */     this.id = id;
/*     */   }
/*     */ }
