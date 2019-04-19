/*     */ package com.rongdu.cashloan.core.common.util.excel;
/*     */ 
/*     */ import java.util.LinkedList;
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
/*     */ public class TableColumn
/*     */ {
/*     */   public static final int COLUMN_TYPE_STRING = 0;
/*     */   public static final int COLUMN_TYPE_FLOAT_2 = 1;
/*     */   public static final int COLUMN_TYPE_FLOAT_3 = 2;
/*     */   public static final int COLUMN_TYPE_INTEGER = 3;
/*     */   public static final int COLUMN_TYPE_FORMULA = 4;
/*     */   public static final int COLUMN_TYPE_RED_BG = 10;
/*     */   public static final int COLUMN_TYPE_YELLOW_BG = 11;
/*     */   public static final int COLUMN_TYPE_GREEN_BG = 12;
/*     */   private String id;
/*     */   private String display;
/*     */   private String dbField;
/*  63 */   private int columnType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  68 */   private boolean grouped = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  73 */   private boolean displaySummary = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String aggregateRule;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  83 */   private boolean isVisible = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  88 */   private boolean isComplex = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String common;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  98 */   private int width = 100;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int percentWidth;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 108 */   private String widthType = "P";
/*     */   
/*     */   protected int level;
/*     */   
/* 112 */   protected TableColumn parent = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 117 */   protected List<TableColumn> children = new LinkedList();
/*     */   
/*     */   public void addChild(TableColumn column) {
/* 120 */     this.children.add(column);
/* 121 */     column.parent = this;
/* 122 */     if (column.isVisible())
/* 123 */       this.isComplex = true;
/*     */   }
/*     */   
/*     */   public List<TableColumn> getChildren() {
/* 127 */     LinkedList<TableColumn> ret = new LinkedList();
/* 128 */     for (TableColumn c : this.children) {
/* 129 */       if (c.isVisible())
/* 130 */         ret.add(c);
/*     */     }
/* 132 */     return ret;
/*     */   }
/*     */   
/*     */   public boolean isComplex() {
/* 136 */     return this.isComplex;
/*     */   }
/*     */   
/*     */   public int getLength() {
/* 140 */     int len = 0;
/* 141 */     if (isComplex()) {
/* 142 */       for (TableColumn col : getChildren()) {
/* 143 */         len += col.getLength();
/*     */       }
/*     */     } else {
/* 146 */       len = 1;
/*     */     }
/* 148 */     return len;
/*     */   }
/*     */   
/*     */   public String getDisplay() {
/* 152 */     return this.display;
/*     */   }
/*     */   
/*     */   public void setDisplay(String display) {
/* 156 */     this.display = display;
/*     */   }
/*     */   
/*     */   public String getDbField() {
/* 160 */     return this.dbField;
/*     */   }
/*     */   
/*     */   public void setDbField(String dbField) {
/* 164 */     this.dbField = dbField;
/*     */   }
/*     */   
/*     */   public int getColumnType() {
/* 168 */     return this.columnType;
/*     */   }
/*     */   
/*     */   public String getColumnStringType(int columnType) {
/* 172 */     String stringType = "string";
/* 173 */     if (columnType == 3) {
/* 174 */       stringType = "int";
/* 175 */     } else if (columnType == 1) {
/* 176 */       stringType = "float";
/* 177 */     } else if (columnType == 2) {
/* 178 */       stringType = "float";
/*     */     }
/* 180 */     return stringType;
/*     */   }
/*     */   
/*     */   public void setColumnType(int columnType) {
/* 184 */     this.columnType = columnType;
/*     */   }
/*     */   
/*     */   public boolean isGrouped() {
/* 188 */     return this.grouped;
/*     */   }
/*     */   
/*     */   public void setGrouped(boolean grouped) {
/* 192 */     this.grouped = grouped;
/*     */   }
/*     */   
/*     */   public boolean isDisplaySummary() {
/* 196 */     return this.displaySummary;
/*     */   }
/*     */   
/*     */   public void setDisplaySummary(boolean displaySummary) {
/* 200 */     this.displaySummary = displaySummary;
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 204 */     return this.isVisible;
/*     */   }
/*     */   
/*     */   public void setVisible(boolean isVisible) {
/* 208 */     this.isVisible = isVisible;
/*     */   }
/*     */   
/*     */   public String getAggregateRule() {
/* 212 */     return this.aggregateRule;
/*     */   }
/*     */   
/*     */   public void setAggregateRule(String aggregateRule) {
/* 216 */     this.aggregateRule = aggregateRule;
/*     */   }
/*     */   
/*     */   public String getId() {
/* 220 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(String id) {
/* 224 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getCommon() {
/* 228 */     return this.common;
/*     */   }
/*     */   
/*     */   public void setCommon(String common) {
/* 232 */     this.common = common;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 236 */     return this.width;
/*     */   }
/*     */   
/*     */   public void setWidth(int width) {
/* 240 */     this.width = width;
/*     */   }
/*     */   
/*     */   public int getPercentWidth() {
/* 244 */     return this.percentWidth;
/*     */   }
/*     */   
/*     */   public void setPercentWidth(int percentWidth) {
/* 248 */     this.percentWidth = percentWidth;
/*     */   }
/*     */   
/*     */   public String getWidthType() {
/* 252 */     return this.widthType;
/*     */   }
/*     */   
/*     */   public void setWidthType(String widthType) {
/* 256 */     this.widthType = widthType;
/*     */   }
/*     */ }


/* excel\TableColumn.class

 */