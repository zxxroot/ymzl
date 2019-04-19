/*     */ package com.rongdu.creditrank.cr.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrResultDetail
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String LEVEL_FACTOR_PARAM = "40";
/*     */   public static final String LEVEL_FACTOR = "30";
/*     */   public static final String LEVEL_ITEM = "20";
/*     */   public static final String LEVEL_CARD = "10";
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
/*     */   private BigDecimal amount;
/*     */   private String cardLevel;
/*     */   private Date addTime;
/*     */   
/*     */   public CrResultDetail(Long resultId, Long cardId, Long itemId, Long factorId, Long paramId, String paramName, Integer paramScore, String formula, String cvalue)
/*     */   {
/* 116 */     this.resultId = resultId;
/* 117 */     this.cardId = cardId;
/* 118 */     this.itemId = itemId;
/* 119 */     this.factorId = factorId;
/* 120 */     this.paramId = paramId;
/* 121 */     this.paramName = paramName;
/* 122 */     this.paramScore = paramScore;
/* 123 */     this.formula = formula;
/* 124 */     this.cvalue = cvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CrResultDetail() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 136 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 144 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getResultId()
/*     */   {
/* 152 */     return this.resultId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResultId(Long resultId)
/*     */   {
/* 160 */     this.resultId = resultId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getCardId()
/*     */   {
/* 168 */     return this.cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardId(Long cardId)
/*     */   {
/* 176 */     this.cardId = cardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getItemId()
/*     */   {
/* 184 */     return this.itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setItemId(Long itemId)
/*     */   {
/* 192 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getFactorId()
/*     */   {
/* 200 */     return this.factorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFactorId(Long factorId)
/*     */   {
/* 208 */     this.factorId = factorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getParamId()
/*     */   {
/* 216 */     return this.paramId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamId(Long paramId)
/*     */   {
/* 224 */     this.paramId = paramId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getParamName()
/*     */   {
/* 232 */     return this.paramName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamName(String paramName)
/*     */   {
/* 240 */     this.paramName = paramName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getParamScore()
/*     */   {
/* 248 */     return this.paramScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParamScore(Integer paramScore)
/*     */   {
/* 256 */     this.paramScore = paramScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFormula()
/*     */   {
/* 264 */     return this.formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFormula(String formula)
/*     */   {
/* 272 */     this.formula = formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCvalue()
/*     */   {
/* 280 */     return this.cvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCvalue(String cvalue)
/*     */   {
/* 288 */     this.cvalue = cvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getValue()
/*     */   {
/* 296 */     return this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setValue(String value)
/*     */   {
/* 304 */     this.value = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLevel()
/*     */   {
/* 312 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLevel(String level)
/*     */   {
/* 320 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getScore()
/*     */   {
/* 328 */     return this.score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScore(Integer score)
/*     */   {
/* 336 */     this.score = score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 344 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 352 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BigDecimal getAmount()
/*     */   {
/* 360 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmount(BigDecimal amount)
/*     */   {
/* 368 */     this.amount = amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCardLevel()
/*     */   {
/* 376 */     return this.cardLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardLevel(String cardLevel)
/*     */   {
/* 384 */     this.cardLevel = cardLevel;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\domain\CrResultDetail.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */