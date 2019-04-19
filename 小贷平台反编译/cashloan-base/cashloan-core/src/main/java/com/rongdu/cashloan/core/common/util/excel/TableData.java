/*     */ package com.rongdu.cashloan.core.common.util.excel;
/*     */ 
/*     */ import java.text.DecimalFormat;
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
/*     */ public class TableData
/*     */ {
/*  19 */   private static DecimalFormat format = new DecimalFormat("0.##");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STYLE_TYPE_STRING = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STYLE_TYPE_FLOAT_2 = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STYLE_TYPE_FLOAT_3 = 2;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STYLE_TYPE_INTEGER = 3;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int STYLE_TYPE_RED_BG = 10;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int STYLE_TYPE_YELLOW_BG = 11;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int STYLE_TYPE_GREEN_BG = 12;
/*     */   
/*     */ 
/*     */ 
/*     */   private String sheetTitle;
/*     */   
/*     */ 
/*     */ 
/*     */   private TableHeaderMetaData header;
/*     */   
/*     */ 
/*     */ 
/*     */   private LinkedList<TableDataRow> rows;
/*     */   
/*     */ 
/*     */ 
/*     */   private int totalRows;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TableData() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TableData(TableHeaderMetaData header)
/*     */   {
/*  80 */     this.header = header;
/*  81 */     this.rows = new LinkedList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void compute()
/*     */   {
/*  88 */     for (int i = 0; i < this.header.getColumnCount(); i++) {
/*  89 */       TableColumn tc = this.header.getColumnAt(i);
/*  90 */       if ((tc.isVisible()) && (tc.isGrouped()) && (tc.isDisplaySummary()))
/*  91 */         buildSummary(i);
/*     */     }
/*     */   }
/*     */   
/*     */   class SummaryData {
/*     */     String key;
/*     */     int index;
/*     */     int count;
/*     */     TableDataRow row;
/*     */     
/*     */     SummaryData() {}
/*     */     
/*     */     public String toString() {
/* 104 */       StringBuilder sb = new StringBuilder();
/* 105 */       sb.append(this.key).append("\t").append(this.index).append("\t").append(this.count).append("\t");
/* 106 */       for (TableDataCell cell : this.row.getCells()) {
/* 107 */         sb.append(cell.getValue()).append("\t");
/*     */       }
/* 109 */       return sb.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private TableDataRow buildNewRow(String key, int index)
/*     */   {
/* 121 */     TableDataRow nrow = new TableDataRow(this);
/* 122 */     for (int i = 0; i < index; i++) {
/* 123 */       nrow.addCell("");
/*     */     }
/* 125 */     nrow.addCell("(" + key + ")小计");
/* 126 */     for (int i = index + 1; i < this.header.getColumnCount(); i++) {
/* 127 */       TableColumn thc = this.header.getColumnAt(i);
/* 128 */       if (thc.getAggregateRule() != null) {
/* 129 */         nrow.addCell(Integer.valueOf(0));
/*     */       } else {
/* 131 */         nrow.addCell("");
/*     */       }
/*     */     }
/* 134 */     return nrow;
/*     */   }
/*     */   
/*     */   private void buildSummary(int index) {
/* 138 */     LinkedList<SummaryData> lst = new LinkedList();
/* 139 */     String okey = null;
/* 140 */     SummaryData sd = null;
/* 141 */     for (int j = 0; j < this.rows.size(); j++) {
/* 142 */       TableDataRow row = (TableDataRow)this.rows.get(j);
/* 143 */       String key = row.getCellAt(index).getValue();
/*     */       
/* 145 */       if (okey == null) {
/* 146 */         okey = key;
/* 147 */         sd = new SummaryData();
/* 148 */         sd.key = key;
/* 149 */         sd.count = 0;
/* 150 */         sd.row = buildNewRow(key, index);
/*     */       }
/*     */       
/* 153 */       if ((okey != null) && (!okey.equals(key))) {
/* 154 */         for (int i = index; i < this.header.getColumnCount(); i++) {
/* 155 */           TableColumn thc = this.header.getColumnAt(i);
/* 156 */           if (thc.getAggregateRule() != null) {
/* 157 */             String value = sd.row.getCellAt(i).getValue();
/* 158 */             if ("avg".equalsIgnoreCase(thc.getAggregateRule())) {
/* 159 */               if (sd.count > 0) {
/* 160 */                 sd.row.getCellAt(i).setValue(
/* 161 */                   "平均：" + format.format(Double.parseDouble(value) / sd.count));
/*     */               } else {
/* 163 */                 sd.row.getCellAt(i).setValue("平均：0");
/*     */               }
/* 165 */             } else if ("max".equalsIgnoreCase(thc.getAggregateRule())) {
/* 166 */               sd.row.getCellAt(i).setValue("最大值：" + value);
/* 167 */             } else if (thc.getAggregateRule().equalsIgnoreCase("min")) {
/* 168 */               sd.row.getCellAt(i).setValue("最小值：" + value);
/* 169 */             } else if (thc.getAggregateRule().equalsIgnoreCase("sum")) {
/* 170 */               sd.row.getCellAt(i).setValue("求和：" + value);
/* 171 */             } else if (thc.getAggregateRule().equalsIgnoreCase("count")) {
/* 172 */               sd.row.getCellAt(i).setValue("共" + value + "行");
/*     */             }
/*     */           }
/*     */         }
/* 176 */         sd.index = j;
/*     */         
/* 178 */         FormulaProcessor.getInstance().fillValue(sd.row);
/* 179 */         lst.add(sd);
/*     */         
/* 181 */         okey = key;
/* 182 */         sd = new SummaryData();
/* 183 */         sd.key = key;
/* 184 */         sd.count = 0;
/* 185 */         sd.row = buildNewRow(key, index);
/*     */       }
/* 187 */       sd.count += 1;
/* 188 */       for (int i = index + 1; i < this.header.getColumnCount(); i++) {
/* 189 */         TableColumn thc = this.header.getColumnAt(i);
/* 190 */         if ((thc.getColumnType() != 4) && (thc.getAggregateRule() != null)) {
/* 191 */           Double value = Double.valueOf(Double.parseDouble(sd.row.getCellAt(i).getValue()));
/* 192 */           Double cellValue = null;
/*     */           try {
/* 194 */             cellValue = Double.valueOf(row.getCellAt(i).getValue());
/*     */           } catch (NumberFormatException e) {
/* 196 */             cellValue = null;
/*     */           }
/* 198 */           if (cellValue != null)
/*     */           {
/* 200 */             if ("max".equalsIgnoreCase(thc.getAggregateRule())) {
/* 201 */               if (value.doubleValue() < cellValue.doubleValue()) {
/* 202 */                 value = cellValue;
/*     */               }
/* 204 */             } else if ("min".equalsIgnoreCase(thc.getAggregateRule())) {
/* 205 */               if (value.doubleValue() > cellValue.doubleValue()) {
/* 206 */                 value = cellValue;
/*     */               }
/* 208 */             } else if ("count".equalsIgnoreCase(thc.getAggregateRule())) {
/* 209 */               value = Double.valueOf(value.doubleValue() + 1.0D);
/* 210 */             } else if ("sum".equalsIgnoreCase(thc.getAggregateRule())) {
/* 211 */               value = Double.valueOf(value.doubleValue() + cellValue.doubleValue());
/* 212 */             } else if ("avg".equalsIgnoreCase(thc.getAggregateRule())) {
/* 213 */               value = Double.valueOf(value.doubleValue() + cellValue.doubleValue());
/*     */             }
/* 215 */             sd.row.getCellAt(i).setValue(format.format(value));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 220 */     if (sd != null) {
/* 221 */       for (int i = index; i < this.header.getColumnCount(); i++) {
/* 222 */         TableColumn thc = this.header.getColumnAt(i);
/* 223 */         if (thc.getAggregateRule() != null) {
/* 224 */           String value = sd.row.getCellAt(i).getValue();
/* 225 */           if ("avg".equalsIgnoreCase(thc.getAggregateRule())) {
/* 226 */             if (sd.count > 0) {
/* 227 */               sd.row.getCellAt(i).setValue("平均：" + format.format(Double.parseDouble(value) / sd.count));
/*     */             } else {
/* 229 */               sd.row.getCellAt(i).setValue("平均：0");
/*     */             }
/* 231 */           } else if ("max".equalsIgnoreCase(thc.getAggregateRule())) {
/* 232 */             sd.row.getCellAt(i).setValue("最大值：" + value);
/* 233 */           } else if ("min".equalsIgnoreCase(thc.getAggregateRule())) {
/* 234 */             sd.row.getCellAt(i).setValue("最小值：" + value);
/* 235 */           } else if ("sum".equalsIgnoreCase(thc.getAggregateRule())) {
/* 236 */             sd.row.getCellAt(i).setValue("求和：" + value);
/* 237 */           } else if ("count".equalsIgnoreCase(thc.getAggregateRule())) {
/* 238 */             sd.row.getCellAt(i).setValue("共" + value + "行");
/*     */           }
/*     */         }
/*     */       }
/* 242 */       FormulaProcessor.getInstance().fillValue(sd.row);
/* 243 */       lst.add(sd);
/* 244 */       sd.index = this.rows.size();
/*     */     }
/* 246 */     for (int i = 0; i < lst.size(); i++) {
/* 247 */       SummaryData sda = (SummaryData)lst.get(i);
/* 248 */       this.rows.add(sda.index + i, sda.row);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TableHeaderMetaData getTableHeader()
/*     */   {
/* 259 */     return this.header;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addRow(TableDataRow row)
/*     */   {
/* 268 */     this.rows.add(row);
/*     */   }
/*     */   
/*     */   public List<TableDataRow> getRows() {
/* 272 */     return this.rows;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TableDataRow getRowAt(int index)
/*     */   {
/* 282 */     return (TableDataRow)this.rows.get(index);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRowCount()
/*     */   {
/* 291 */     return this.rows.size();
/*     */   }
/*     */   
/*     */   public int getTotalRows() {
/* 295 */     return this.totalRows;
/*     */   }
/*     */   
/*     */   public void setTotalRows(int totalRows) {
/* 299 */     this.totalRows = totalRows;
/*     */   }
/*     */   
/*     */   public void setHeader(TableHeaderMetaData header) {
/* 303 */     this.header = header;
/*     */   }
/*     */   
/*     */   public void setRows(LinkedList<TableDataRow> rows) {
/* 307 */     this.rows = rows;
/*     */   }
/*     */   
/*     */   public String getSheetTitle() {
/* 311 */     return this.sheetTitle;
/*     */   }
/*     */   
/*     */   public void setSheetTitle(String sheetTitle) {
/* 315 */     this.sheetTitle = sheetTitle;
/*     */   }
/*     */ }
