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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrResultDetailTree
/*     */ {
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
/*     */   public List<CrResultDetailModel> cardList;
/*     */   
/*     */   public Long getResultId()
/*     */   {
/*  93 */     return this.resultId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResultId(Long resultId)
/*     */   {
/* 102 */     this.resultId = resultId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCardId()
/*     */   {
/* 111 */     return this.cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardId(Long cardId)
/*     */   {
/* 120 */     this.cardId = cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getItemId()
/*     */   {
/* 129 */     return this.itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setItemId(Long itemId)
/*     */   {
/* 138 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getFactorId()
/*     */   {
/* 147 */     return this.factorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFactorId(Long factorId)
/*     */   {
/* 156 */     this.factorId = factorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getParamId()
/*     */   {
/* 165 */     return this.paramId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamId(Long paramId)
/*     */   {
/* 174 */     this.paramId = paramId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getParamName()
/*     */   {
/* 183 */     return this.paramName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamName(String paramName)
/*     */   {
/* 192 */     this.paramName = paramName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getParamScore()
/*     */   {
/* 201 */     return this.paramScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamScore(Integer paramScore)
/*     */   {
/* 210 */     this.paramScore = paramScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFormula()
/*     */   {
/* 219 */     return this.formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFormula(String formula)
/*     */   {
/* 228 */     this.formula = formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCvalue()
/*     */   {
/* 237 */     return this.cvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCvalue(String cvalue)
/*     */   {
/* 246 */     this.cvalue = cvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getValue()
/*     */   {
/* 255 */     return this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setValue(String value)
/*     */   {
/* 264 */     this.value = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLevel()
/*     */   {
/* 273 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLevel(String level)
/*     */   {
/* 282 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getScore()
/*     */   {
/* 291 */     return this.score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScore(Integer score)
/*     */   {
/* 300 */     this.score = score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 309 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 318 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<CrResultDetailModel> getCardList()
/*     */   {
/* 327 */     return this.cardList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardList(List<CrResultDetailModel> cardList)
/*     */   {
/* 336 */     this.cardList = cardList;
/*     */   }
/*     */ }
