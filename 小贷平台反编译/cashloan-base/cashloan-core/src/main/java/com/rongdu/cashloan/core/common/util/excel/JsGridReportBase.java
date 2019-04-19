/*     */ package com.rongdu.cashloan.core.common.util.excel;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JsGridReportBase
/*     */ {
/*  35 */   private static final Logger logger = LoggerFactory.getLogger(JsGridReportBase.class);
/*  36 */   public SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */   
/*     */ 
/*     */   private HttpServletResponse response;
/*     */   
/*     */ 
/*     */   private HttpSession session;
/*     */   
/*     */   private ServletOutputStream out;
/*     */   
/*  46 */   public static int EXCEL_MAX_CNT = 5000;
/*  47 */   public static int SHEET_MAX_CNT = 100;
/*     */   
/*     */   public JsGridReportBase() {}
/*     */   
/*     */   public JsGridReportBase(HttpServletRequest request, HttpServletResponse response) throws Exception
/*     */   {
/*  53 */     this.response = response;
/*  54 */     this.session = request.getSession();
/*  55 */     init(this.session);
/*     */   }
/*     */   
/*     */   private void init(HttpSession session) throws IOException {
/*  59 */     this.out = this.response.getOutputStream();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void exportExcel(List<Object> list, String title, String[] hearders, String[] fields, String operatorName)
/*     */     throws Exception
/*     */   {
/*  68 */     List<List<Object>> listResult = new ArrayList();
/*  69 */     String excelTitle = title + "_" + DateUtil.dateStr3(DateUtil.getNow());
/*  70 */     if (list.size() > 5000) {
/*  71 */       int excelSize = 5000;
/*  72 */       int totalCount = list.size();
/*  73 */       int pageCount = 0;
/*  74 */       int numPage = totalCount % excelSize;
/*  75 */       if (numPage > 0) {
/*  76 */         pageCount = totalCount / excelSize + 1;
/*     */       } else {
/*  78 */         pageCount = totalCount / excelSize;
/*     */       }
/*  80 */       for (int i = 1; i <= pageCount; i++) {
/*  81 */         if (numPage == 0) {
/*  82 */           listResult.add(list.subList((i - 1) * excelSize, excelSize * i));
/*     */ 
/*     */         }
/*  85 */         else if (i == pageCount) {
/*  86 */           listResult.add(list.subList((i - 1) * excelSize, totalCount));
/*     */         }
/*     */         else {
/*  89 */           listResult.add(list.subList((i - 1) * excelSize, excelSize * i));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  94 */     TableData td = null;
/*  95 */     if (listResult.size() > 0) {
/*  96 */       List<TableData> tableDataLst = new ArrayList();
/*  97 */       for (int i = 0; i < listResult.size(); i++) {
/*  98 */         td = ExcelUtil.createTableData((List)listResult.get(i), ExcelUtil.createTableHeader(hearders), fields);
/*  99 */         td.setSheetTitle(title + "_(" + (i + 1) + ")");
/* 100 */         tableDataLst.add(td);
/*     */       }
/* 102 */       exportToExcel(excelTitle, operatorName, tableDataLst);
/*     */     } else {
/* 104 */       td = ExcelUtil.createTableData(list, ExcelUtil.createTableHeader(hearders), fields);
/* 105 */       exportToExcel(excelTitle, operatorName, td);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void outDataToBrowser(TableData tableData)
/*     */   {
/* 116 */     StringBuilder outData = new StringBuilder();
/*     */     
/*     */ 
/* 119 */     outData.append("{pageInfo: {totalRowNum: " + tableData.getTotalRows() + "},");
/* 120 */     outData.append("data: [");
/* 121 */     boolean isFirst = true;
/*     */     
/* 123 */     TableHeaderMetaData headerMetaData = tableData.getTableHeader();
/* 124 */     List<TableDataRow> dataRows = tableData.getRows();
/*     */     try {
/* 126 */       for (TableDataRow dataRow : dataRows) {
/* 127 */         List<TableDataCell> dataCells = dataRow.getCells();
/* 128 */         int size = dataCells.size();
/* 129 */         if (!isFirst) {
/* 130 */           outData.append(",{");
/* 131 */           for (int i = 0; i < size; i++) {
/* 132 */             outData.append(headerMetaData.getColumnAt(i).getId() + ": '" + ((TableDataCell)dataCells.get(i)).getValue() + 
/* 133 */               "',");
/*     */           }
/* 135 */           int index = outData.lastIndexOf(",");
/* 136 */           outData.deleteCharAt(index);
/* 137 */           outData.append("}");
/*     */         } else {
/* 139 */           outData.append("{");
/* 140 */           for (int i = 0; i < size; i++) {
/* 141 */             outData.append(headerMetaData.getColumnAt(i).getId() + ": '" + ((TableDataCell)dataCells.get(i)).getValue() + 
/* 142 */               "',");
/*     */           }
/* 144 */           int index = outData.lastIndexOf(",");
/* 145 */           outData.deleteCharAt(index);
/* 146 */           outData.append("}");
/* 147 */           isFirst = false;
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 151 */       logger.error("异常", e);
/*     */     }
/* 153 */     outData.append("]");
/* 154 */     outData.append("}");
/*     */     try
/*     */     {
/* 157 */       this.out.print(outData.toString());
/* 158 */       this.out.flush();
/* 159 */       this.out.close();
/*     */     } catch (IOException e) {
/* 161 */       logger.error("读写异常", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void stopGrouping(HSSFSheet sheet, HashMap<Integer, String> word, HashMap<Integer, Integer> counter, int i, int size, int rownum, HSSFCellStyle style)
/*     */   {
/* 171 */     String w = (String)word.get(Integer.valueOf(i));
/* 172 */     if (w != null) {
/* 173 */       int len = ((Integer)counter.get(Integer.valueOf(i))).intValue();
/* 174 */       CellRangeAddress address = new CellRangeAddress(rownum - len, rownum - 1, i, i);
/* 175 */       sheet.addMergedRegion(address);
/* 176 */       fillMergedRegion(sheet, address, style);
/* 177 */       word.remove(Integer.valueOf(i));
/* 178 */       counter.remove(Integer.valueOf(i));
/*     */     }
/* 180 */     if (i + 1 < size) {
/* 181 */       stopGrouping(sheet, word, counter, i + 1, size, rownum, style);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void generateColumn(HSSFSheet sheet, TableColumn tc, int maxlevel, int rownum, int colnum, HSSFCellStyle headerstyle)
/*     */   {
/* 191 */     HSSFRow row = sheet.getRow(rownum);
/* 192 */     if (row == null) {
/* 193 */       row = sheet.createRow(rownum);
/*     */     }
/* 195 */     HSSFCell cell = row.createCell(colnum);
/* 196 */     cell.setCellValue(tc.getDisplay());
/*     */     
/* 198 */     if (headerstyle != null)
/* 199 */       cell.setCellStyle(headerstyle);
/* 200 */     if (tc.isComplex()) {
/* 201 */       CellRangeAddress address = new CellRangeAddress(rownum, rownum, colnum, colnum + tc.getLength() - 1);
/* 202 */       sheet.addMergedRegion(address);
/* 203 */       fillMergedRegion(sheet, address, headerstyle);
/*     */       
/* 205 */       int cn = colnum;
/* 206 */       for (int i = 0; i < tc.getChildren().size(); i++) {
/* 207 */         if (i != 0) {
/* 208 */           cn += ((TableColumn)tc.getChildren().get(i - 1)).getLength();
/*     */         }
/* 210 */         generateColumn(sheet, (TableColumn)tc.getChildren().get(i), maxlevel, rownum + 1, cn, headerstyle);
/*     */       }
/*     */     } else {
/* 213 */       CellRangeAddress address = new CellRangeAddress(rownum, rownum + maxlevel - tc.level, colnum, colnum);
/* 214 */       sheet.addMergedRegion(address);
/* 215 */       fillMergedRegion(sheet, address, headerstyle);
/*     */     }
/* 217 */     sheet.autoSizeColumn(colnum, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillMergedRegion(HSSFSheet sheet, CellRangeAddress address, HSSFCellStyle style)
/*     */   {
/* 225 */     for (int i = address.getFirstRow(); i <= address.getLastRow(); i++) {
/* 226 */       HSSFRow row = sheet.getRow(i);
/* 227 */       if (row == null)
/* 228 */         row = sheet.createRow(i);
/* 229 */       for (int j = address.getFirstColumn(); j <= address.getLastColumn(); j++) {
/* 230 */         HSSFCell cell = row.getCell(j);
/* 231 */         if (cell == null) {
/* 232 */           cell = row.createCell(j);
/* 233 */           if (style != null) {
/* 234 */             cell.setCellStyle(style);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
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
/*     */   public HSSFWorkbook writeSheet(HSSFWorkbook wb, String title, HashMap<String, HSSFCellStyle> styles, String creator, TableData tableData)
/*     */   {
/* 253 */     TableHeaderMetaData headerMetaData = tableData.getTableHeader();
/*     */     
/* 255 */     SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
/* 256 */     String create_time = formater.format(DateUtil.getNow());
/*     */     
/* 258 */     HSSFSheet sheet = wb.createSheet(title);
/* 259 */     sheet.setDisplayGridlines(false);
/*     */     
/*     */ 
/* 262 */     HSSFRow row = sheet.createRow(0);
/* 263 */     HSSFCell cell = row.createCell(0);
/* 264 */     int rownum = 0;
/* 265 */     cell.setCellValue(new HSSFRichTextString(title));
/* 266 */     HSSFCellStyle style = (HSSFCellStyle)styles.get("TITLE");
/* 267 */     if (style != null)
/* 268 */       cell.setCellStyle(style);
/* 269 */     sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headerMetaData.getColumnCount() - 1));
/*     */     
/*     */ 
/*     */ 
/* 273 */     row = sheet.createRow(1);
/* 274 */     cell = row.createCell(0);
/* 275 */     cell.setCellValue(new HSSFRichTextString("创建人:"));
/* 276 */     style = (HSSFCellStyle)styles.get("SUB_TITLE");
/* 277 */     if (style != null) {
/* 278 */       cell.setCellStyle(style);
/*     */     }
/* 280 */     cell = row.createCell(1);
/* 281 */     cell.setCellValue(new HSSFRichTextString(creator));
/* 282 */     style = (HSSFCellStyle)styles.get("SUB_TITLE2");
/* 283 */     if (style != null) {
/* 284 */       cell.setCellStyle(style);
/*     */     }
/* 286 */     cell = row.createCell(2);
/* 287 */     cell.setCellValue(new HSSFRichTextString("创建时间:"));
/* 288 */     style = (HSSFCellStyle)styles.get("SUB_TITLE");
/* 289 */     if (style != null) {
/* 290 */       cell.setCellStyle(style);
/*     */     }
/* 292 */     cell = row.createCell(3);
/* 293 */     style = (HSSFCellStyle)styles.get("SUB_TITLE2");
/* 294 */     cell.setCellValue(new HSSFRichTextString(create_time));
/* 295 */     if (style != null) {
/* 296 */       cell.setCellStyle(style);
/*     */     }
/* 298 */     rownum = 3;
/*     */     
/* 300 */     HSSFCellStyle headerstyle = (HSSFCellStyle)styles.get("TABLE_HEADER");
/*     */     
/* 302 */     int colnum = 0;
/* 303 */     for (int i = 0; i < headerMetaData.getOriginColumns().size(); i++) {
/* 304 */       TableColumn tc = (TableColumn)headerMetaData.getOriginColumns().get(i);
/* 305 */       if (i != 0) {
/* 306 */         colnum += ((TableColumn)headerMetaData.getOriginColumns().get(i - 1)).getLength();
/*     */       }
/* 308 */       generateColumn(sheet, tc, headerMetaData.maxlevel, rownum, colnum, headerstyle);
/*     */     }
/* 310 */     rownum += headerMetaData.maxlevel;
/*     */     
/* 312 */     List<TableDataRow> dataRows = tableData.getRows();
/*     */     
/* 314 */     HashMap<Integer, Integer> counter = new HashMap();
/* 315 */     HashMap<Integer, String> word = new HashMap();
/* 316 */     int index = 0;
/* 317 */     for (TableDataRow dataRow : dataRows) {
/* 318 */       row = sheet.createRow(rownum);
/*     */       
/* 320 */       List<TableDataCell> dataCells = dataRow.getCells();
/* 321 */       int size = headerMetaData.getColumns().size();
/* 322 */       index = -1;
/* 323 */       for (int i = 0; i < size; i++) {
/* 324 */         TableColumn tc = (TableColumn)headerMetaData.getColumns().get(i);
/* 325 */         if (tc.isVisible())
/*     */         {
/* 327 */           index++;
/*     */           
/* 329 */           String value = ((TableDataCell)dataCells.get(i)).getValue();
/* 330 */           if (tc.isGrouped()) {
/* 331 */             String w = (String)word.get(Integer.valueOf(index));
/* 332 */             if (w == null) {
/* 333 */               word.put(Integer.valueOf(index), value);
/* 334 */               counter.put(Integer.valueOf(index), Integer.valueOf(1));
/* 335 */               createCell(row, tc, dataCells, i, index, styles);
/*     */             }
/* 337 */             else if (w.equals(value)) {
/* 338 */               counter.put(Integer.valueOf(index), Integer.valueOf(((Integer)counter.get(Integer.valueOf(index))).intValue() + 1));
/*     */             } else {
/* 340 */               stopGrouping(sheet, word, counter, index, size, rownum, (HSSFCellStyle)styles.get("STRING"));
/*     */               
/* 342 */               word.put(Integer.valueOf(index), value);
/* 343 */               counter.put(Integer.valueOf(index), Integer.valueOf(1));
/* 344 */               createCell(row, tc, dataCells, i, index, styles);
/*     */             }
/*     */           }
/*     */           else {
/* 348 */             createCell(row, tc, dataCells, i, index, styles);
/*     */           }
/*     */         } }
/* 351 */       rownum++;
/*     */     }
/*     */     
/* 354 */     stopGrouping(sheet, word, counter, 0, index, rownum, (HSSFCellStyle)styles.get("STRING"));
/*     */     
/* 356 */     for (int c = 0; c < headerMetaData.getColumns().size(); c++) {
/* 357 */       sheet.autoSizeColumn((short)c);
/* 358 */       String t = ((TableColumn)headerMetaData.getColumns().get(c)).getDisplay();
/* 359 */       if (sheet.getColumnWidth(c) < t.length() * 256 * 3)
/* 360 */         sheet.setColumnWidth(c, t.length() * 256 * 3);
/*     */     }
/* 362 */     sheet.setGridsPrinted(true);
/*     */     
/* 364 */     return wb;
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
/*     */   public HSSFWorkbook writeSheet(HSSFWorkbook wb, HashMap<String, HSSFCellStyle> styles, String creator, List<TableData> tableDataLst)
/*     */   {
/* 380 */     SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
/* 381 */     String create_time = formater.format(DateUtil.getNow());
/*     */     
/* 383 */     int cnt = 1;
/* 384 */     for (TableData tableData : tableDataLst) {
/* 385 */       String sheetTitle = tableData.getSheetTitle();
/* 386 */       sheetTitle = (sheetTitle == null) || ("".equals(sheetTitle)) ? "sheet" + cnt : sheetTitle;
/* 387 */       cnt++;
/*     */       
/* 389 */       TableHeaderMetaData headerMetaData = tableData.getTableHeader();
/* 390 */       HSSFSheet sheet = wb.createSheet(sheetTitle);
/* 391 */       sheet.setDisplayGridlines(false);
/* 392 */       wb.cloneSheet(0);
/*     */       
/*     */ 
/* 395 */       HSSFRow row = sheet.createRow(0);
/* 396 */       HSSFCell cell = row.createCell(0);
/* 397 */       int rownum = 0;
/* 398 */       cell.setCellValue(new HSSFRichTextString(sheetTitle));
/* 399 */       HSSFCellStyle style = (HSSFCellStyle)styles.get("TITLE");
/* 400 */       if (style != null)
/* 401 */         cell.setCellStyle(style);
/* 402 */       sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headerMetaData.getColumnCount() - 1));
/*     */       
/*     */ 
/*     */ 
/* 406 */       row = sheet.createRow(1);
/* 407 */       cell = row.createCell(0);
/* 408 */       cell.setCellValue(new HSSFRichTextString("创建人:"));
/* 409 */       style = (HSSFCellStyle)styles.get("SUB_TITLE");
/* 410 */       if (style != null) {
/* 411 */         cell.setCellStyle(style);
/*     */       }
/* 413 */       cell = row.createCell(1);
/* 414 */       cell.setCellValue(new HSSFRichTextString(creator));
/* 415 */       style = (HSSFCellStyle)styles.get("SUB_TITLE2");
/* 416 */       if (style != null) {
/* 417 */         cell.setCellStyle(style);
/*     */       }
/* 419 */       cell = row.createCell(2);
/* 420 */       cell.setCellValue(new HSSFRichTextString("创建时间:"));
/* 421 */       style = (HSSFCellStyle)styles.get("SUB_TITLE");
/* 422 */       if (style != null) {
/* 423 */         cell.setCellStyle(style);
/*     */       }
/* 425 */       cell = row.createCell(3);
/* 426 */       style = (HSSFCellStyle)styles.get("SUB_TITLE2");
/* 427 */       cell.setCellValue(new HSSFRichTextString(create_time));
/* 428 */       if (style != null) {
/* 429 */         cell.setCellStyle(style);
/*     */       }
/* 431 */       rownum = 3;
/*     */       
/* 433 */       HSSFCellStyle headerstyle = (HSSFCellStyle)styles.get("TABLE_HEADER");
/*     */       
/* 435 */       int colnum = 0;
/* 436 */       for (int i = 0; i < headerMetaData.getOriginColumns().size(); i++) {
/* 437 */         TableColumn tc = (TableColumn)headerMetaData.getOriginColumns().get(i);
/* 438 */         if (i != 0) {
/* 439 */           colnum += ((TableColumn)headerMetaData.getOriginColumns().get(i - 1)).getLength();
/*     */         }
/* 441 */         generateColumn(sheet, tc, headerMetaData.maxlevel, rownum, colnum, headerstyle);
/*     */       }
/* 443 */       rownum += headerMetaData.maxlevel;
/*     */       
/* 445 */       List<TableDataRow> dataRows = tableData.getRows();
/*     */       
/* 447 */       int index = 0;
/* 448 */       for (TableDataRow dataRow : dataRows) {
/* 449 */         row = sheet.createRow(rownum);
/*     */         
/* 451 */         List<TableDataCell> dataCells = dataRow.getCells();
/* 452 */         int size = headerMetaData.getColumns().size();
/* 453 */         index = -1;
/* 454 */         for (int i = 0; i < size; i++) {
/* 455 */           TableColumn tc = (TableColumn)headerMetaData.getColumns().get(i);
/* 456 */           if (tc.isVisible())
/*     */           {
/* 458 */             index++;
/*     */             
/* 460 */             createCell(row, tc, dataCells, i, index, styles);
/*     */           } }
/* 462 */         rownum++;
/*     */       }
/*     */       
/* 465 */       for (int c = 0; c < headerMetaData.getColumns().size(); c++) {
/* 466 */         sheet.autoSizeColumn((short)c);
/* 467 */         String t = ((TableColumn)headerMetaData.getColumns().get(c)).getDisplay();
/* 468 */         if (sheet.getColumnWidth(c) < t.length() * 256 * 3)
/* 469 */           sheet.setColumnWidth(c, t.length() * 256 * 3);
/*     */       }
/* 471 */       sheet.setGridsPrinted(true);
/*     */     }
/*     */     
/* 474 */     return wb;
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
/*     */   public void exportToExcel(String title, String creator, TableData tableData)
/*     */     throws Exception
/*     */   {
/* 488 */     HSSFWorkbook wb = new HSSFWorkbook();
/*     */     
/* 490 */     HashMap<String, HSSFCellStyle> styles = initStyles(wb);
/*     */     
/* 492 */     wb = writeSheet(wb, title, styles, creator, tableData);
/*     */     
/* 494 */     String sFileName = title + ".xls";
/*     */     
/*     */ 
/*     */ 
/* 498 */     HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
/* 499 */     String agent = request.getHeader("User-Agent");
/*     */     
/* 501 */     boolean isFirefox = (agent != null) && (agent.contains("Firefox"));
/* 502 */     if (isFirefox) {
/* 503 */       sFileName = new String(sFileName.getBytes("UTF-8"), "ISO-8859-1");
/*     */     } else {
/* 505 */       sFileName = URLEncoder.encode(sFileName, "UTF8");
/*     */     }
/* 507 */     this.response.setHeader("Content-Disposition", "attachment; filename=".concat(sFileName));
/* 508 */     this.response.setHeader("Connection", "close");
/* 509 */     this.response.setHeader("Content-Type", "application/vnd.ms-excel");
/* 510 */     wb.write(this.response.getOutputStream());
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
/*     */   public void exportToExcel(String title, String creator, List<TableData> tableDataLst)
/*     */     throws IOException
/*     */   {
/* 525 */     HSSFWorkbook wb = new HSSFWorkbook();
/* 526 */     HashMap<String, HSSFCellStyle> styles = initStyles(wb);
/*     */     
/* 528 */     int i = 1;
/* 529 */     for (TableData tableData : tableDataLst) {
/* 530 */       String sheetTitle = tableData.getSheetTitle();
/* 531 */       sheetTitle = (sheetTitle == null) || ("".equals(sheetTitle)) ? "sheet" + i : sheetTitle;
/* 532 */       wb = writeSheet(wb, tableData.getSheetTitle(), styles, creator, tableData);
/* 533 */       i++;
/*     */     }
/*     */     
/* 536 */     String sFileName = title + ".xls";
/* 537 */     this.response.setHeader("Content-Disposition", 
/* 538 */       "attachment;filename=".concat(String.valueOf(URLEncoder.encode(sFileName, "UTF-8"))));
/* 539 */     this.response.setHeader("Connection", "close");
/* 540 */     this.response.setHeader("Content-Type", "application/vnd.ms-excel");
/*     */     
/* 542 */     wb.write(this.response.getOutputStream());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void createCell(HSSFRow row, TableColumn tc, List<TableDataCell> data, int i, int index, HashMap<String, HSSFCellStyle> styles)
/*     */   {
/* 553 */     TableDataCell dc = (TableDataCell)data.get(i);
/* 554 */     HSSFCell cell = row.createCell(index);
/* 555 */     switch (tc.getColumnType()) {
/*     */     case 3: 
/* 557 */       cell.setCellValue(dc.getIntValue());
/* 558 */       HSSFCellStyle style = (HSSFCellStyle)styles.get("INT");
/* 559 */       if (row.getRowNum() % 2 != 0)
/* 560 */         style = (HSSFCellStyle)styles.get("INT_C");
/* 561 */       if (style != null)
/* 562 */         cell.setCellStyle(style);
/* 563 */       break;
/*     */     case 1: 
/* 565 */       cell.setCellValue(dc.getDoubleValue());
/* 566 */       style = (HSSFCellStyle)styles.get("D2");
/* 567 */       if (row.getRowNum() % 2 != 0)
/* 568 */         style = (HSSFCellStyle)styles.get("D2_C");
/* 569 */       if (style != null)
/* 570 */         cell.setCellStyle(style);
/* 571 */       break;
/*     */     case 2: 
/* 573 */       cell.setCellValue(dc.getDoubleValue());
/* 574 */       style = (HSSFCellStyle)styles.get("D3");
/* 575 */       if (row.getRowNum() % 2 != 0)
/* 576 */         style = (HSSFCellStyle)styles.get("D3_C");
/* 577 */       if (style != null)
/* 578 */         cell.setCellStyle(style);
/* 579 */       break;
/*     */     case 10: 
/* 581 */       cell.setCellValue(dc.getValue());
/* 582 */       style = (HSSFCellStyle)styles.get("RED_BG");
/* 583 */       if (style != null)
/* 584 */         cell.setCellStyle(style);
/* 585 */       break;
/*     */     case 11: 
/* 587 */       cell.setCellValue(dc.getValue());
/* 588 */       style = (HSSFCellStyle)styles.get("YELLOW_BG");
/* 589 */       if (style != null)
/* 590 */         cell.setCellStyle(style);
/* 591 */       break;
/*     */     case 12: 
/* 593 */       cell.setCellValue(dc.getValue());
/* 594 */       style = (HSSFCellStyle)styles.get("GREEN_BG");
/* 595 */       if (style != null)
/* 596 */         cell.setCellStyle(style);
/* 597 */       break;
/*     */     case 4: case 5: case 6: case 7: case 8: case 9: default: 
/* 599 */       if ("&nbsp;".equalsIgnoreCase(dc.getValue())) {
/* 600 */         cell.setCellValue("");
/*     */       } else
/* 602 */         cell.setCellValue(dc.getValue());
/* 603 */       style = (HSSFCellStyle)styles.get("STRING");
/* 604 */       if (row.getRowNum() % 2 != 0)
/* 605 */         style = (HSSFCellStyle)styles.get("STRING_C");
/* 606 */       if (style != null) {
/* 607 */         cell.setCellStyle(style);
/*     */       }
/*     */       
/*     */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */   private HashMap<String, HSSFCellStyle> initStyles(HSSFWorkbook wb)
/*     */   {
/* 618 */     HashMap<String, HSSFCellStyle> ret = new HashMap();
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 624 */       String filePath = this.session.getServletContext().getRealPath("/") + "/excel/module.xls";
/*     */       
/* 626 */       InputStream is = new FileInputStream(filePath);
/* 627 */       POIFSFileSystem fs = new POIFSFileSystem(is);
/*     */       
/* 629 */       HSSFWorkbook src = new HSSFWorkbook(fs);
/* 630 */       HSSFSheet sheet = src.getSheetAt(0);
/*     */       
/* 632 */       buildStyle(wb, src, sheet, 0, ret, "TITLE");
/* 633 */       buildStyle(wb, src, sheet, 1, ret, "SUB_TITLE");
/* 634 */       buildStyle(wb, src, sheet, 2, ret, "SUB_TITLE2");
/*     */       
/* 636 */       buildStyle(wb, src, sheet, 4, ret, "TABLE_HEADER");
/* 637 */       buildStyle(wb, src, sheet, 5, ret, "STRING");
/* 638 */       buildStyle(wb, src, sheet, 6, ret, "INT");
/* 639 */       buildStyle(wb, src, sheet, 7, ret, "D2");
/* 640 */       buildStyle(wb, src, sheet, 8, ret, "D3");
/*     */       
/* 642 */       buildStyle(wb, src, sheet, 10, ret, "STRING_C");
/* 643 */       buildStyle(wb, src, sheet, 11, ret, "INT_C");
/* 644 */       buildStyle(wb, src, sheet, 12, ret, "D2_C");
/* 645 */       buildStyle(wb, src, sheet, 13, ret, "D3_C");
/*     */       
/* 647 */       buildStyle(wb, src, sheet, 15, ret, "RED_BG");
/* 648 */       buildStyle(wb, src, sheet, 16, ret, "YELLOW_BG");
/* 649 */       buildStyle(wb, src, sheet, 17, ret, "GREEN_BG");
/*     */     } catch (Exception e) {
/* 651 */       logger.error(e.getMessage(), e);
/*     */     }
/* 653 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void buildStyle(HSSFWorkbook wb, HSSFWorkbook src, HSSFSheet sheet, int index, HashMap<String, HSSFCellStyle> ret, String key)
/*     */   {
/* 662 */     HSSFRow row = sheet.getRow(index);
/* 663 */     HSSFCell cell = row.getCell(1);
/* 664 */     HSSFCellStyle nstyle = wb.createCellStyle();
/* 665 */     ExcelUtil.copyCellStyle(wb, nstyle, src, cell.getCellStyle());
/* 666 */     ret.put(key, nstyle);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String getUTF8String(String string)
/*     */   {
/* 676 */     if (string == null) {
/* 677 */       return null;
/*     */     }
/*     */     try {
/* 680 */       return new String(string.getBytes("ISO8859-1"), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/* 683 */       logger.error("异常", e); }
/* 684 */     return string;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String getGBKString(String string)
/*     */   {
/* 696 */     if (string == null) {
/* 697 */       return null;
/*     */     }
/*     */     try {
/* 700 */       return new String(string.getBytes("ISO8859-1"), "GBK");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/* 703 */       logger.error("异常", e); }
/* 704 */     return string;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String fieldRender(String value)
/*     */   {
/* 716 */     if (value == null) {
/* 717 */       return "&nbsp;";
/*     */     }
/* 719 */     return value;
/*     */   }
/*     */ }


/* excel\JsGridReportBase.class

 */