/*     */ package com.rongdu.cashloan.rule.domain;
/*     */ 
/*     */ import com.alibaba.fastjson.annotation.JSONField;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RuleEngineConfig
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String RESULT_FAIL = "10";
/*     */   public static final String RESULT_REVIEW = "20";
/*     */   public static final String RESULT_PASS = "30";
/*     */   private Long id;
/*     */   private Long ruleEnginId;
/*     */   private String ctable;
/*     */   private String ccolumn;
/*     */   private String formula;
/*     */   private String cvalue;
/*     */   private String state;
/*     */   private String reqExt;
/*     */   private String addIp;
/*     */   private String tableComment;
/*     */   private String columnComment;
/*     */   @JSONField(format="yyyy-MM-dd HH:mm:ss")
/*     */   private Date addTime;
/*     */   private String type;
/*     */   private Integer integral;
/*     */   private String result;
/*     */   private String resultType;
/*     */   private Integer sort;
/*     */   
/*     */   public Integer getSort()
/*     */   {
/* 114 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Integer sort) {
/* 118 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   public String getResult() {
/* 122 */     return this.result;
/*     */   }
/*     */   
/*     */   public void setResult(String result) {
/* 126 */     this.result = result;
/*     */   }
/*     */   
/*     */   public String getResultType() {
/* 130 */     return this.resultType;
/*     */   }
/*     */   
/*     */   public void setResultType(String resultType) {
/* 134 */     this.resultType = resultType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 143 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 152 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getRuleEnginId()
/*     */   {
/* 161 */     return this.ruleEnginId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRuleEnginId(Long ruleEnginId)
/*     */   {
/* 170 */     this.ruleEnginId = ruleEnginId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCtable()
/*     */   {
/* 179 */     return this.ctable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCtable(String ctable)
/*     */   {
/* 189 */     this.ctable = ctable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCcolumn()
/*     */   {
/* 198 */     return this.ccolumn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCcolumn(String ccolumn)
/*     */   {
/* 208 */     this.ccolumn = ccolumn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFormula()
/*     */   {
/* 217 */     return this.formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFormula(String formula)
/*     */   {
/* 227 */     this.formula = formula;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCvalue()
/*     */   {
/* 236 */     return this.cvalue;
/*     */   }
/*     */   
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
/*     */   public String getState()
/*     */   {
/* 255 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 265 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReqExt()
/*     */   {
/* 274 */     return this.reqExt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReqExt(String reqExt)
/*     */   {
/* 284 */     this.reqExt = reqExt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAddIp()
/*     */   {
/* 293 */     return this.addIp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddIp(String addIp)
/*     */   {
/* 303 */     this.addIp = addIp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 312 */     return this.addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 322 */     this.addTime = addTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/* 331 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 340 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Integer getIntegral() {
/* 344 */     return this.integral;
/*     */   }
/*     */   
/*     */   public void setIntegral(Integer integral) {
/* 348 */     this.integral = integral;
/*     */   }
/*     */   
/*     */   public String getTableComment() {
/* 352 */     return this.tableComment;
/*     */   }
/*     */   
/*     */   public void setTableComment(String tableComment) {
/* 356 */     this.tableComment = tableComment;
/*     */   }
/*     */   
/*     */   public String getColumnComment() {
/* 360 */     return this.columnComment;
/*     */   }
/*     */   
/*     */   public void setColumnComment(String columnComment) {
/* 364 */     this.columnComment = columnComment;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\domain\RuleEngineConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */