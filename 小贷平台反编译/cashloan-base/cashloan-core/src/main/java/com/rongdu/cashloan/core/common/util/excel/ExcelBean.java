/*     */ package com.rongdu.cashloan.core.common.util.excel;
/*     */ 
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
/*     */ public class ExcelBean
/*     */ {
/*     */   private String title;
/*     */   private String creator;
/*     */   private List list;
/*     */   private String[] hearders;
/*     */   private String[][] children;
/*     */   private String[] fields;
/*     */   
/*     */   public ExcelBean() {}
/*     */   
/*     */   public ExcelBean(String title, String creator, List list, String[] hearders)
/*     */   {
/*  47 */     this.title = title;
/*  48 */     this.creator = creator;
/*  49 */     this.list = list;
/*  50 */     this.hearders = hearders;
/*     */   }
/*     */   
/*     */   public ExcelBean(String title, String creator, List list, String[] hearders, String[] fields)
/*     */   {
/*  55 */     this.title = title;
/*  56 */     this.creator = creator;
/*  57 */     this.list = list;
/*  58 */     this.hearders = hearders;
/*  59 */     this.fields = fields;
/*     */   }
/*     */   
/*     */   public ExcelBean(String title, String creator, List list, String[] hearders, String[][] children, String[] fields)
/*     */   {
/*  64 */     this.title = title;
/*  65 */     this.creator = creator;
/*  66 */     this.list = list;
/*  67 */     this.hearders = hearders;
/*  68 */     this.children = children;
/*  69 */     this.fields = fields;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  73 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  77 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getCreator() {
/*  81 */     return this.creator;
/*     */   }
/*     */   
/*     */   public void setCreator(String creator) {
/*  85 */     this.creator = creator;
/*     */   }
/*     */   
/*     */   public List getList()
/*     */   {
/*  90 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List list)
/*     */   {
/*  95 */     this.list = list;
/*     */   }
/*     */   
/*     */   public String[] getHearders() {
/*  99 */     return this.hearders;
/*     */   }
/*     */   
/*     */   public void setHearders(String[] hearders) {
/* 103 */     this.hearders = hearders;
/*     */   }
/*     */   
/*     */   public String[][] getChildren() {
/* 107 */     return this.children;
/*     */   }
/*     */   
/*     */   public void setChildren(String[][] children) {
/* 111 */     this.children = children;
/*     */   }
/*     */   
/*     */   public String[] getFields() {
/* 115 */     return this.fields;
/*     */   }
/*     */   
/*     */   public void setFields(String[] fields) {
/* 119 */     this.fields = fields;
/*     */   }
/*     */ }


/* excel\ExcelBean.class

 */