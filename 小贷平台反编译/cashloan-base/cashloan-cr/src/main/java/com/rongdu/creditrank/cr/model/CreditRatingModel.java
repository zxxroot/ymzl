/*     */ package com.rongdu.creditrank.cr.model;
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
/*     */ 
/*     */ 
/*     */ public class CreditRatingModel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String borrowTypeId;
/*     */   private String borrowTypeName;
/*     */   private Long creditTypeId;
/*     */   private String creditTypeName;
/*     */   private Long cardId;
/*     */   private Integer cardScore;
/*     */   private Long itemId;
/*     */   private Integer itemScore;
/*     */   private Long factorId;
/*     */   private Integer factorScore;
/*     */   private Long paramId;
/*     */   private Integer paramScore;
/*     */   private String tabName;
/*     */   private String colName;
/*     */   private String formula;
/*     */   private String range;
/*     */   private String type;
/*     */   private Integer score;
/*     */   
/*     */   public Long getCardId()
/*     */   {
/* 114 */     return this.cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardId(Long cardId)
/*     */   {
/* 122 */     this.cardId = cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCardScore()
/*     */   {
/* 130 */     return this.cardScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardScore(Integer cardScore)
/*     */   {
/* 138 */     this.cardScore = cardScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getItemId()
/*     */   {
/* 146 */     return this.itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setItemId(Long itemId)
/*     */   {
/* 154 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getItemScore()
/*     */   {
/* 162 */     return this.itemScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setItemScore(Integer itemScore)
/*     */   {
/* 170 */     this.itemScore = itemScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getFactorId()
/*     */   {
/* 178 */     return this.factorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFactorId(Long factorId)
/*     */   {
/* 186 */     this.factorId = factorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getFactorScore()
/*     */   {
/* 194 */     return this.factorScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFactorScore(Integer factorScore)
/*     */   {
/* 202 */     this.factorScore = factorScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getParamId()
/*     */   {
/* 210 */     return this.paramId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamId(Long paramId)
/*     */   {
/* 218 */     this.paramId = paramId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getParamScore()
/*     */   {
/* 226 */     return this.paramScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamScore(Integer paramScore)
/*     */   {
/* 234 */     this.paramScore = paramScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTabName()
/*     */   {
/* 242 */     return this.tabName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTabName(String tabName)
/*     */   {
/* 250 */     this.tabName = tabName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getColName()
/*     */   {
/* 258 */     return this.colName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setColName(String colName)
/*     */   {
/* 266 */     this.colName = colName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFormula()
/*     */   {
/* 274 */     return this.formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFormula(String formula)
/*     */   {
/* 282 */     this.formula = formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRange()
/*     */   {
/* 290 */     return this.range;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRange(String range)
/*     */   {
/* 298 */     this.range = range;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/* 306 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 314 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getScore()
/*     */   {
/* 322 */     return this.score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScore(Integer score)
/*     */   {
/* 330 */     this.score = score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCreditTypeId()
/*     */   {
/* 338 */     return this.creditTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditTypeId(Long creditTypeId)
/*     */   {
/* 346 */     this.creditTypeId = creditTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditTypeName()
/*     */   {
/* 354 */     return this.creditTypeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditTypeName(String creditTypeName)
/*     */   {
/* 362 */     this.creditTypeName = creditTypeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBorrowTypeId()
/*     */   {
/* 370 */     return this.borrowTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowTypeId(String borrowTypeId)
/*     */   {
/* 378 */     this.borrowTypeId = borrowTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBorrowTypeName()
/*     */   {
/* 386 */     return this.borrowTypeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorrowTypeName(String borrowTypeName)
/*     */   {
/* 394 */     this.borrowTypeName = borrowTypeName;
/*     */   }
/*     */ }
