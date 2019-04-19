/*     */ package com.rongdu.cashloan.core.common.util.excel;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
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
/*     */ public class TableDataRow
/*     */ {
/*     */   private LinkedList<TableDataCell> cells;
/*     */   private TableData table;
/*  35 */   private int rowStyle = 0;
/*     */   
/*     */   public void addCell(TableDataCell cell) {
/*  38 */     this.cells.add(cell);
/*     */   }
/*     */   
/*     */   public void addCell(String value) {
/*  42 */     TableDataCell cell = new TableDataCell(this);
/*  43 */     cell.setValue(value);
/*  44 */     cell.setCellStyle(this.rowStyle);
/*  45 */     addCell(cell);
/*     */   }
/*     */   
/*     */   public void addCell(Integer value) {
/*  49 */     TableDataCell cell = new TableDataCell(this);
/*  50 */     cell.setValue(value.intValue());
/*  51 */     cell.setCellStyle(this.rowStyle);
/*  52 */     addCell(cell);
/*     */   }
/*     */   
/*     */   public void addCell(Double value) {
/*  56 */     TableDataCell cell = new TableDataCell(this);
/*  57 */     cell.setValue(value.doubleValue());
/*  58 */     cell.setCellStyle(this.rowStyle);
/*  59 */     addCell(cell);
/*     */   }
/*     */   
/*     */   public void addCell(Object value) {
/*  63 */     if ((value instanceof String)) {
/*  64 */       addCell((String)value);
/*  65 */     } else if ((value instanceof Integer)) {
/*  66 */       addCell((Integer)value);
/*  67 */     } else if ((value instanceof Double)) {
/*  68 */       addCell((Double)value);
/*  69 */     } else if ((value instanceof BigDecimal)) {
/*  70 */       addCell(value.toString());
/*  71 */     } else if ((value instanceof Long)) {
/*  72 */       addCell(value.toString());
/*  73 */     } else if ((value instanceof Date)) {
/*  74 */       addCell(DateUtil.dateStr4((Date)value));
/*     */     }
/*  76 */     else if ((value instanceof Timestamp)) {
/*  77 */       addCell(DateUtil.dateStr4((Timestamp)value));
/*     */     }
/*  79 */     else if (value == null) {
/*  80 */       addCell("");
/*     */     } else {
/*  82 */       addCell(value);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TableDataCell getCellAt(int index)
/*     */   {
/*  92 */     return (TableDataCell)this.cells.get(index);
/*     */   }
/*     */   
/*     */   public List<TableDataCell> getCells() {
/*  96 */     return this.cells;
/*     */   }
/*     */   
/*     */   public TableData getTable() {
/* 100 */     return this.table;
/*     */   }
/*     */   
/*     */   public TableDataRow(TableData table) {
/* 104 */     this.cells = new LinkedList();
/* 105 */     this.table = table;
/*     */   }
/*     */   
/*     */   public void setRowStyle(int rowStyle) {
/* 109 */     this.rowStyle = rowStyle;
/*     */   }
/*     */   
/*     */   public int getRowStyle() {
/* 113 */     return this.rowStyle;
/*     */   }
/*     */ }
