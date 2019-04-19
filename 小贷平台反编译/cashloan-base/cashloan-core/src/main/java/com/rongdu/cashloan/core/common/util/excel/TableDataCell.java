/*    */ package com.rongdu.cashloan.core.common.util.excel;
/*    */ 
/*    */ import java.text.DecimalFormat;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TableDataCell
/*    */ {
/*    */   private String value;
/*    */   private int intValue;
/*    */   private double doubleValue;
/*    */   private TableDataRow row;
/*    */   private int columnIndex;
/* 16 */   private static DecimalFormat format2 = new DecimalFormat("0.##");
/*    */   
/* 18 */   private static DecimalFormat format3 = new DecimalFormat("0.###");
/*    */   
/* 20 */   private int cellStyle = 0;
/*    */   
/*    */   public TableDataCell(TableDataRow row) {
/* 23 */     this(-1, row);
/*    */   }
/*    */   
/*    */   public TableDataCell(int index, TableDataRow row) {
/* 27 */     this.row = row;
/* 28 */     if (index == -1) {
/* 29 */       index = row.getCells().size();
/*    */     } else {
/* 31 */       this.columnIndex = index;
/*    */     }
/* 33 */     this.value = "";
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 37 */     this.value = value;
/*    */   }
/*    */   
/*    */   public void setValue(int value) {
/* 41 */     this.value = String.valueOf(value);
/* 42 */     this.intValue = value;
/*    */   }
/*    */   
/*    */   public void setValue(double value) {
/* 46 */     int type = this.row.getTable().getTableHeader().getColumnAt(this.columnIndex).getColumnType();
/* 47 */     if (type == 1) {
/* 48 */       this.value = format2.format(value);
/* 49 */     } else if (type == 2) {
/* 50 */       this.value = format3.format(value);
/*    */     }
/* 52 */     this.doubleValue = value;
/* 53 */     this.value = String.format("%.2f", new Object[] { Double.valueOf(value) });
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 57 */     return this.value;
/*    */   }
/*    */   
/*    */   public TableDataRow getRow() {
/* 61 */     return this.row;
/*    */   }
/*    */   
/*    */   public int getColumnIndex() {
/* 65 */     return this.columnIndex;
/*    */   }
/*    */   
/*    */   public int getIntValue() {
/* 69 */     return this.intValue;
/*    */   }
/*    */   
/*    */   public double getDoubleValue() {
/* 73 */     return this.doubleValue;
/*    */   }
/*    */   
/*    */   public void setCellStyle(int cellStyle) {
/* 77 */     this.cellStyle = cellStyle;
/*    */   }
/*    */   
/*    */   public int getCellStyle() {
/* 81 */     return this.cellStyle;
/*    */   }
/*    */ }
