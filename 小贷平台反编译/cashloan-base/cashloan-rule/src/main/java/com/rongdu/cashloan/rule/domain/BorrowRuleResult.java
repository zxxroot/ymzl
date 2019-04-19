/*     */ package com.rongdu.cashloan.rule.domain;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class BorrowRuleResult implements java.io.Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String RESULT_TYPE_PASS = "30";
/*     */   public static final String RESULT_TYPE_REVIEW = "20";
/*     */   public static final String RESULT_TYPE_REFUSED = "10";
/*     */   private Long id;
/*     */   private Long borrowId;
/*     */   private Long userId;
/*     */   private Long ruleId;
/*     */   private String tbNid;
/*     */   private String tbName;
/*     */   private String colNid;
/*     */   private String colName;
/*     */   private String value;
/*     */   private String matching;
/*     */   private String rule;
/*     */   private String result;
/*     */   private String resultType;
/*     */   private String reqExt;
/*     */   private Date addTime;
/*     */   private String adaptedId;
/*     */   
/*     */   public String alterType(String str) {
/*  28 */     switch ((str = str).hashCode()) {case 1567:
    if (str.equals("10")) break; break;
case 1598:  if (str.equals("20")) {} break; case 1629:  if (!str.equals("30"))
/*     */       {
/*  30 */         str = "不通过";
///*  31 */         return str;
/*     */         
/*  33 */         str = "人工复审";
/*     */       }
/*     */       else {
/*  36 */         str = "通过"; }
/*  37 */       break;
/*     */     }
/*     */     
/*     */     
/*  41 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 130 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 139 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getBorrowId()
/*     */   {
/* 148 */     return this.borrowId;
/*     */   }
/*     */   
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
/*     */   public Long getUserId()
/*     */   {
/* 167 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 177 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getRuleId()
/*     */   {
/* 186 */     return this.ruleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRuleId(Long ruleId)
/*     */   {
/* 196 */     this.ruleId = ruleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTbNid()
/*     */   {
/* 205 */     return this.tbNid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTbNid(String tbNid)
/*     */   {
/* 215 */     this.tbNid = tbNid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTbName()
/*     */   {
/* 224 */     return this.tbName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTbName(String tbName)
/*     */   {
/* 234 */     this.tbName = tbName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getColNid()
/*     */   {
/* 243 */     return this.colNid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setColNid(String colNid)
/*     */   {
/* 253 */     this.colNid = colNid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getColName()
/*     */   {
/* 262 */     return this.colName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setColName(String colName)
/*     */   {
/* 272 */     this.colName = colName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getValue()
/*     */   {
/* 281 */     return this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setValue(String value)
/*     */   {
/* 291 */     this.value = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRule()
/*     */   {
/* 300 */     return this.rule;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRule(String rule)
/*     */   {
/* 310 */     this.rule = rule;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResult()
/*     */   {
/* 319 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResult(String result)
/*     */   {
/* 329 */     this.result = result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReqExt()
/*     */   {
/* 338 */     return this.reqExt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReqExt(String reqExt)
/*     */   {
/* 348 */     this.reqExt = reqExt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 357 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 367 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getResultType()
/*     */   {
/* 376 */     return this.resultType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResultType(String resultType)
/*     */   {
/* 385 */     this.resultType = resultType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMatching()
/*     */   {
/* 392 */     return this.matching;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMatching(String matching)
/*     */   {
/* 400 */     this.matching = matching;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAdaptedId()
/*     */   {
/* 409 */     return this.adaptedId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAdaptedId(String adaptedId)
/*     */   {
/* 419 */     this.adaptedId = adaptedId;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\domain\BorrowRuleResult.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */