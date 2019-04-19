/*     */ package com.rongdu.cashloan.core.common.util.excel;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
import com.rongdu.cashloan.core.common.util.ReflectUtil;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.Region;
import tool.util.BigDecimalUtil;
import tool.util.StringUtil;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExcelUtil
/*     */ {
/*     */   public static final String UID = "serialVersionUID";
/*  46 */   private static final Logger LOGGER = Logger.getLogger(ExcelUtil.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<String, Object> beanToMap(Object obj)
/*     */   {
/*  55 */     Map<String, Object> params = new HashMap(0);
/*     */     try {
/*  57 */       PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
/*  58 */       PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
/*  59 */       for (int i = 0; i < descriptors.length; i++) {
/*  60 */         String name = descriptors[i].getName();
/*  61 */         if (!StringUtils.equals(name, "class")) {
/*  62 */           params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  66 */       LOGGER.error(e);
/*     */     }
/*  68 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TableHeaderMetaData createTableHeader(List<String> list)
/*     */   {
/*  78 */     TableHeaderMetaData headMeta = new TableHeaderMetaData();
/*  79 */     for (String title : list) {
/*  80 */       TableColumn tc = new TableColumn();
/*  81 */       tc.setDisplay(title);
/*  82 */       headMeta.addColumn(tc);
/*     */     }
/*  84 */     return headMeta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TableHeaderMetaData createTableHeader(String[] titls)
/*     */   {
/*  94 */     TableHeaderMetaData headMeta = new TableHeaderMetaData();
/*  95 */     String[] arrayOfString = titls;int j = titls.length; for (int i = 0; i < j; i++) { String title = arrayOfString[i];
/*  96 */       TableColumn tc = new TableColumn();
/*  97 */       tc.setDisplay(title);
/*  98 */       tc.setGrouped(true);
/*  99 */       headMeta.addColumn(tc);
/*     */     }
/* 101 */     return headMeta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TableHeaderMetaData createTableHeader(String[] titls, int spanCount)
/*     */   {
/* 112 */     if (spanCount > titls.length)
/* 113 */       spanCount = titls.length;
/* 114 */     TableHeaderMetaData headMeta = new TableHeaderMetaData();
/* 115 */     for (int i = 0; i < titls.length; i++) {
/* 116 */       TableColumn tc = new TableColumn();
/* 117 */       tc.setDisplay(titls[i]);
/* 118 */       if (i < spanCount)
/* 119 */         tc.setGrouped(true);
/* 120 */       headMeta.addColumn(tc);
/*     */     }
/* 122 */     return headMeta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TableHeaderMetaData createTableHeader(String[] parents, String[][] children)
/*     */   {
/* 133 */     TableHeaderMetaData headMeta = new TableHeaderMetaData();
/* 134 */     TableColumn parentColumn = null;
/* 135 */     TableColumn sonColumn = null;
/* 136 */     for (int i = 0; i < parents.length; i++) {
/* 137 */       parentColumn = new TableColumn();
/* 138 */       parentColumn.setDisplay(parents[i]);
/* 139 */       if ((children != null) && (children[i] != null)) {
/* 140 */         for (int j = 0; j < children[i].length; j++) {
/* 141 */           sonColumn = new TableColumn();
/* 142 */           sonColumn.setDisplay(children[i][j]);
/* 143 */           parentColumn.addChild(sonColumn);
/*     */         }
/*     */       }
/* 146 */       headMeta.addColumn(parentColumn);
/*     */     }
/* 148 */     return headMeta;
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
/*     */   public static TableData createTableData(List list, TableHeaderMetaData headMeta, String[] fields)
/*     */   {
/* 162 */     TableData td = new TableData(headMeta);
/* 163 */     TableDataRow row = null;
/* 164 */     if ((list != null) && (list.size() > 0)) { int j;
/* 165 */       if (list.get(0).getClass().isArray()) {
/* 166 */         for (Object obj : list) {
/* 167 */           row = new TableDataRow(td);
/* 168 */           Object[] arrayOfObject; j = (arrayOfObject = (Object[])obj).length; for (int i = 0; i < j; i++) { Object o = arrayOfObject[i];
/* 169 */             row.addCell(o);
/*     */           }
/* 171 */           td.addRow(row);
/*     */         }
/*     */       } else {
/* 174 */         for (Object obj : list) {
/* 175 */           row = new TableDataRow(td);
/* 176 */           Map<String, Object> map = (obj instanceof Map) ? (Map)obj : beanToMap(obj);
/* 177 */           String[] arrayOfString; int k = (arrayOfString = fields).length; for (j = 0; j < k; j++) { String key = arrayOfString[j];
/* 178 */             row.addCell(map.get(key));
/*     */           }
/* 180 */           td.addRow(row);
/*     */         }
/*     */       }
/*     */     }
/* 184 */     return td;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ZipOutputStream createZipStream(HttpServletResponse response, String zipName)
/*     */   {
/* 195 */     response.reset();
/* 196 */     response.setContentType("application/vnd.ms-excel");
/*     */     try {
/* 198 */       response.setHeader("Content-Disposition", 
/* 199 */         "attachment;filename=".concat(String.valueOf(URLEncoder.encode(zipName + ".zip", "UTF-8"))));
/*     */     } catch (UnsupportedEncodingException e) {
/* 201 */       LOGGER.error(e);
/*     */     }
/* 203 */     OutputStream os = null;
/*     */     try {
/* 205 */       os = response.getOutputStream();
/*     */     } catch (IOException e) {
/* 207 */       LOGGER.error(e);
/*     */     }
/* 209 */     return new ZipOutputStream(os);
/*     */   }
/*     */   
/*     */   public static void copySheetStyle(HSSFWorkbook destwb, HSSFSheet dest, HSSFWorkbook srcwb, HSSFSheet src) {
/* 213 */     if ((src == null) || (dest == null)) {
/* 214 */       return;
/*     */     }
/* 216 */     dest.setAlternativeExpression(src.getAlternateExpression());
/* 217 */     dest.setAlternativeFormula(src.getAlternateFormula());
/* 218 */     dest.setAutobreaks(src.getAutobreaks());
/* 219 */     dest.setDialog(src.getDialog());
/* 220 */     int[] arrayOfInt; int localRegion3; if (src.getColumnBreaks() != null) {
/* 221 */       localRegion3 = (arrayOfInt=src.getColumnBreaks()).length;
for (int localRegion1 = 0; localRegion1 < localRegion3; localRegion1++) { int col = arrayOfInt[localRegion1];
/* 222 */         dest.setColumnBreak((short)col);
/*     */       }
/*     */     }
/* 225 */     dest.setDefaultColumnWidth(src.getDefaultColumnWidth());
/* 226 */     dest.setDefaultRowHeight(src.getDefaultRowHeight());
/* 227 */     dest.setDefaultRowHeightInPoints(src.getDefaultRowHeightInPoints());
/* 228 */     dest.setDisplayGuts(src.getDisplayGuts());
/* 229 */     dest.setFitToPage(src.getFitToPage());
/* 230 */     dest.setHorizontallyCenter(src.getHorizontallyCenter());
/* 231 */     dest.setDisplayFormulas(src.isDisplayFormulas());
/* 232 */     dest.setDisplayGridlines(src.isDisplayGridlines());
/* 233 */     dest.setDisplayRowColHeadings(src.isDisplayRowColHeadings());
/* 234 */     dest.setGridsPrinted(src.isGridsPrinted());
/* 235 */     dest.setPrintGridlines(src.isPrintGridlines());
/*     */     Object r;
/* 237 */     for (int i = 0; i < src.getNumMergedRegions(); i++) {
/* 238 */       r = src.getMergedRegionAt(i);
/* 239 */       dest.addMergedRegion((Region)r);
/*     */     }
/*     */     
/* 242 */     if (src.getRowBreaks() != null) {
/* 243 */       localRegion3 = (arrayOfInt = src.getRowBreaks()).length; for (int localRegion2 = 0; localRegion2 < localRegion3; localRegion2++) { int row = arrayOfInt[localRegion2];
/* 244 */         dest.setRowBreak(row);
/*     */       }
/*     */     }
/* 247 */     dest.setRowSumsBelow(src.getRowSumsBelow());
/* 248 */     dest.setRowSumsRight(src.getRowSumsRight());
/*     */     
/* 250 */     short maxcol = 0;
/* 251 */     for (int i = 0; i <= src.getLastRowNum(); i++) {
/* 252 */       HSSFRow row = src.getRow(i);
/* 253 */       if ((row != null) && 
/* 254 */         (maxcol < row.getLastCellNum())) {
/* 255 */         maxcol = row.getLastCellNum();
/*     */       }
/*     */     }
/* 258 */     for (short col = 0; col <= maxcol; col = (short)(col + 1)) {
/* 259 */       if (src.getColumnWidth(col) != src.getDefaultColumnWidth())
/* 260 */         dest.setColumnWidth(col, src.getColumnWidth(col));
/* 261 */       dest.setColumnHidden(col, src.isColumnHidden(col));
/*     */     }
/*     */   }
/*     */   
/*     */   public static String dumpCellStyle(HSSFCellStyle style) {
/* 266 */     StringBuilder sb = new StringBuilder();
/* 267 */     sb.append(style.getHidden()).append(",");
/* 268 */     sb.append(style.getLocked()).append(",");
/* 269 */     sb.append(style.getWrapText()).append(",");
/* 270 */     sb.append(style.getAlignment()).append(",");
/* 271 */     sb.append(style.getBorderBottom()).append(",");
/* 272 */     sb.append(style.getBorderLeft()).append(",");
/* 273 */     sb.append(style.getBorderRight()).append(",");
/* 274 */     sb.append(style.getBorderTop()).append(",");
/* 275 */     sb.append(style.getBottomBorderColor()).append(",");
/* 276 */     sb.append(style.getDataFormat()).append(",");
/* 277 */     sb.append(style.getFillBackgroundColor()).append(",");
/* 278 */     sb.append(style.getFillForegroundColor()).append(",");
/* 279 */     sb.append(style.getFillPattern()).append(",");
/* 280 */     sb.append(style.getIndention()).append(",");
/* 281 */     sb.append(style.getLeftBorderColor()).append(",");
/* 282 */     sb.append(style.getRightBorderColor()).append(",");
/* 283 */     sb.append(style.getRotation()).append(",");
/* 284 */     sb.append(style.getTopBorderColor()).append(",");
/* 285 */     sb.append(style.getVerticalAlignment());
/*     */     
/* 287 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String dumpFont(HSSFFont font) {
/* 291 */     StringBuilder sb = new StringBuilder();
/* 292 */     sb.append(font.getItalic()).append(",").append(font.getStrikeout()).append(",").append(font.getBoldweight())
/* 293 */       .append(",").append(font.getCharSet()).append(",").append(font.getColor()).append(",")
/* 294 */       .append(font.getFontHeight()).append(",").append(font.getFontName()).append(",")
/* 295 */       .append(font.getTypeOffset()).append(",").append(font.getUnderline());
/* 296 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static void copyCellStyle(HSSFWorkbook destwb, HSSFCell dest, HSSFWorkbook srcwb, HSSFCell src) {
/* 300 */     if ((src == null) || (dest == null)) {
/* 301 */       return;
/*     */     }
/* 303 */     HSSFCellStyle nstyle = findStyle(src.getCellStyle(), srcwb, destwb);
/* 304 */     if (nstyle == null) {
/* 305 */       nstyle = destwb.createCellStyle();
/* 306 */       copyCellStyle(destwb, nstyle, srcwb, src.getCellStyle());
/*     */     }
/* 308 */     dest.setCellStyle(nstyle);
/*     */   }
/*     */   
/*     */   private static boolean isSameColor(short a, short b, HSSFPalette apalette, HSSFPalette bpalette) {
/* 312 */     if (a == b)
/* 313 */       return true;
/* 314 */     HSSFColor acolor = apalette.getColor(a);
/* 315 */     HSSFColor bcolor = bpalette.getColor(b);
/* 316 */     if (acolor == null)
/* 317 */       return true;
/* 318 */     if (bcolor == null)
/* 319 */       return false;
/* 320 */     return acolor.getHexString().equals(bcolor.getHexString());
/*     */   }
/*     */   
/*     */   private static short findColor(short index, HSSFWorkbook srcwb, HSSFWorkbook destwb) {
/* 324 */     Integer id = new Integer(index);
/* 325 */     if (HSSFColor.getIndexHash().containsKey(id))
/* 326 */       return index;
/* 327 */     if (index == 64)
/* 328 */       return index;
/* 329 */     HSSFColor color = srcwb.getCustomPalette().getColor(index);
/* 330 */     if (color == null) {
/* 331 */       return index;
/*     */     }
/*     */     
/* 334 */     HSSFColor ncolor = destwb.getCustomPalette().findColor((byte)color.getTriplet()[0], 
/* 335 */       (byte)color.getTriplet()[1], (byte)color.getTriplet()[2]);
/* 336 */     if (ncolor != null)
/* 337 */       return ncolor.getIndex();
/* 338 */     destwb.getCustomPalette().setColorAtIndex(index, (byte)color.getTriplet()[0], (byte)color.getTriplet()[1], 
/* 339 */       (byte)color.getTriplet()[2]);
/* 340 */     return index;
/*     */   }
/*     */   
/*     */   public static HSSFCellStyle findStyle(HSSFCellStyle style, HSSFWorkbook srcwb, HSSFWorkbook destwb) {
/* 344 */     HSSFPalette srcpalette = srcwb.getCustomPalette();
/* 345 */     HSSFPalette destpalette = destwb.getCustomPalette();
/*     */     
/* 347 */     for (short i = 0; i < destwb.getNumCellStyles(); i = (short)(i + 1)) {
/* 348 */       HSSFCellStyle old = destwb.getCellStyleAt(i);
/* 349 */       if (old != null)
/*     */       {
/*     */ 
/* 352 */         if ((style.getAlignment() == old.getAlignment()) && 
/* 353 */           (style.getBorderBottom() == old.getBorderBottom()) && 
/* 354 */           (style.getBorderLeft() == old.getBorderLeft()) && 
/* 355 */           (style.getBorderRight() == old.getBorderRight()) && 
/* 356 */           (style.getBorderTop() == old.getBorderTop()) && 
/* 357 */           (isSameColor(style.getBottomBorderColor(), old.getBottomBorderColor(), srcpalette, destpalette)) && 
/* 358 */           (style.getDataFormat() == old.getDataFormat()))
/*     */         {
/* 360 */           if (isSameColor(style.getFillBackgroundColor(), old.getFillBackgroundColor(), srcpalette, destpalette))
/*     */           {
/* 362 */             if ((isSameColor(style.getFillForegroundColor(), old.getFillForegroundColor(), srcpalette, destpalette)) && (style.getFillPattern() == old.getFillPattern()) && 
/* 363 */               (style.getHidden() == old.getHidden()) && (style.getIndention() == old.getIndention()) && 
/* 364 */               (isSameColor(style.getLeftBorderColor(), old.getLeftBorderColor(), srcpalette, destpalette)) && 
/* 365 */               (style.getLocked() == old.getLocked()) && 
/* 366 */               (isSameColor(style.getRightBorderColor(), old.getRightBorderColor(), srcpalette, destpalette)) && 
/* 367 */               (style.getRotation() == old.getRotation()) && 
/* 368 */               (isSameColor(style.getTopBorderColor(), old.getTopBorderColor(), srcpalette, destpalette)) && 
/* 369 */               (style.getVerticalAlignment() == old.getVerticalAlignment()) && 
/* 370 */               (style.getWrapText() == old.getWrapText()))
/*     */             {
/* 372 */               HSSFFont oldfont = destwb.getFontAt(old.getFontIndex());
/* 373 */               HSSFFont font = srcwb.getFontAt(style.getFontIndex());
/* 374 */               if ((oldfont.getBoldweight() == font.getBoldweight()) && (oldfont.getItalic() == font.getItalic()) && 
/* 375 */                 (oldfont.getStrikeout() == font.getStrikeout()) && (oldfont.getCharSet() == font.getCharSet()) && 
/* 376 */                 (isSameColor(oldfont.getColor(), font.getColor(), srcpalette, destpalette)) && 
/* 377 */                 (oldfont.getFontHeight() == font.getFontHeight()) && 
/* 378 */                 (oldfont.getFontName().equals(font.getFontName())) && 
/* 379 */                 (oldfont.getTypeOffset() == font.getTypeOffset()) && 
/* 380 */                 (oldfont.getUnderline() == font.getUnderline()))
/* 381 */                 return old;
/*     */             } } }
/*     */       }
/*     */     }
/* 385 */     return null;
/*     */   }
/*     */   
/*     */   public static void copyCellStyle(HSSFWorkbook destwb, HSSFCellStyle dest, HSSFWorkbook srcwb, HSSFCellStyle src) {
/* 389 */     if ((src == null) || (dest == null))
/* 390 */       return;
/* 391 */     dest.setAlignment(src.getAlignment());
/* 392 */     dest.setBorderBottom(src.getBorderBottom());
/* 393 */     dest.setBorderLeft(src.getBorderLeft());
/* 394 */     dest.setBorderRight(src.getBorderRight());
/* 395 */     dest.setBorderTop(src.getBorderTop());
/* 396 */     dest.setBottomBorderColor(findColor(src.getBottomBorderColor(), srcwb, destwb));
/* 397 */     dest.setDataFormat(destwb.createDataFormat().getFormat(srcwb.createDataFormat().getFormat(src.getDataFormat())));
/* 398 */     dest.setFillPattern(src.getFillPattern());
/* 399 */     dest.setFillForegroundColor(findColor(src.getFillForegroundColor(), srcwb, destwb));
/* 400 */     dest.setFillBackgroundColor(findColor(src.getFillBackgroundColor(), srcwb, destwb));
/* 401 */     dest.setHidden(src.getHidden());
/* 402 */     dest.setIndention(src.getIndention());
/* 403 */     dest.setLeftBorderColor(findColor(src.getLeftBorderColor(), srcwb, destwb));
/* 404 */     dest.setLocked(src.getLocked());
/* 405 */     dest.setRightBorderColor(findColor(src.getRightBorderColor(), srcwb, destwb));
/* 406 */     dest.setRotation(src.getRotation());
/* 407 */     dest.setTopBorderColor(findColor(src.getTopBorderColor(), srcwb, destwb));
/* 408 */     dest.setVerticalAlignment(src.getVerticalAlignment());
/* 409 */     dest.setWrapText(src.getWrapText());
/*     */     
/* 411 */     HSSFFont f = srcwb.getFontAt(src.getFontIndex());
/* 412 */     HSSFFont nf = findFont(f, srcwb, destwb);
/* 413 */     if (nf == null) {
/* 414 */       nf = destwb.createFont();
/* 415 */       nf.setBoldweight(f.getBoldweight());
/* 416 */       nf.setCharSet(f.getCharSet());
/* 417 */       nf.setColor(findColor(f.getColor(), srcwb, destwb));
/* 418 */       nf.setFontHeight(f.getFontHeight());
/* 419 */       nf.setFontHeightInPoints(f.getFontHeightInPoints());
/* 420 */       nf.setFontName(f.getFontName());
/* 421 */       nf.setItalic(f.getItalic());
/* 422 */       nf.setStrikeout(f.getStrikeout());
/* 423 */       nf.setTypeOffset(f.getTypeOffset());
/* 424 */       nf.setUnderline(f.getUnderline());
/*     */     }
/* 426 */     dest.setFont(nf);
/*     */   }
/*     */   
/*     */   private static HSSFFont findFont(HSSFFont font, HSSFWorkbook src, HSSFWorkbook dest) {
/* 430 */     for (short i = 0; i < dest.getNumberOfFonts(); i = (short)(i + 1)) {
/* 431 */       HSSFFont oldfont = dest.getFontAt(i);
/* 432 */       if ((font.getBoldweight() == oldfont.getBoldweight()) && (font.getItalic() == oldfont.getItalic()) && 
/* 433 */         (font.getStrikeout() == oldfont.getStrikeout()) && (font.getCharSet() == oldfont.getCharSet()) && 
/* 434 */         (font.getColor() == oldfont.getColor()) && (font.getFontHeight() == oldfont.getFontHeight()) && 
/* 435 */         (font.getFontName().equals(oldfont.getFontName())) && 
/* 436 */         (font.getTypeOffset() == oldfont.getTypeOffset()) && (font.getUnderline() == oldfont.getUnderline())) {
/* 437 */         return oldfont;
/*     */       }
/*     */     }
/* 440 */     return null;
/*     */   }
/*     */   
/*     */   public static void copySheet(HSSFWorkbook destwb, HSSFSheet dest, HSSFWorkbook srcwb, HSSFSheet src) {
/* 444 */     if ((src == null) || (dest == null)) {
/* 445 */       return;
/*     */     }
/* 447 */     copySheetStyle(destwb, dest, srcwb, src);
/*     */     
/* 449 */     for (int i = 0; i <= src.getLastRowNum(); i++) {
/* 450 */       HSSFRow row = src.getRow(i);
/* 451 */       copyRow(destwb, dest.createRow(i), srcwb, row);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void copyRow(HSSFWorkbook destwb, HSSFRow dest, HSSFWorkbook srcwb, HSSFRow src) {
/* 456 */     if ((src == null) || (dest == null))
/* 457 */       return;
/* 458 */     for (short i = 0; i <= src.getLastCellNum(); i = (short)(i + 1)) {
/* 459 */       if (src.getCell(i) != null) {
/* 460 */         HSSFCell cell = dest.createCell(i);
/* 461 */         copyCell(destwb, cell, srcwb, src.getCell(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void copyCell(HSSFWorkbook destwb, HSSFCell dest, HSSFWorkbook srcwb, HSSFCell src)
/*     */   {
/* 468 */     if (src == null) {
/* 469 */       dest.setCellType(3);
/* 470 */       return;
/*     */     }
/*     */     
/* 473 */     if (src.getCellComment() != null)
/* 474 */       dest.setCellComment(src.getCellComment());
/* 475 */     if (src.getCellStyle() != null) {
/* 476 */       HSSFCellStyle nstyle = findStyle(src.getCellStyle(), srcwb, destwb);
/* 477 */       if (nstyle == null) {
/* 478 */         nstyle = destwb.createCellStyle();
/* 479 */         copyCellStyle(destwb, nstyle, srcwb, src.getCellStyle());
/*     */       }
/* 481 */       dest.setCellStyle(nstyle);
/*     */     }
/* 483 */     dest.setCellType(src.getCellType());
/*     */     
/* 485 */     switch (src.getCellType())
/*     */     {
/*     */     case 3: 
/*     */       break;
/*     */     case 4: 
/* 490 */       dest.setCellValue(src.getBooleanCellValue());
/* 491 */       break;
/*     */     case 2: 
/* 493 */       dest.setCellFormula(src.getCellFormula());
/* 494 */       break;
/*     */     case 5: 
/* 496 */       dest.setCellErrorValue(src.getErrorCellValue());
/* 497 */       break;
/*     */     case 0: 
/* 499 */       dest.setCellValue(src.getNumericCellValue());
/* 500 */       break;
/*     */     case 1: default: 
/* 502 */       dest.setCellValue(new HSSFRichTextString(src.getRichStringCellValue().getString()));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void writeExcel(String file, List list, Class clazz)
/*     */     throws Exception
/*     */   {
/* 509 */     Field[] fields = clazz.getDeclaredFields();
/* 510 */     List<String> flist = new ArrayList();
/* 511 */     for (int i = 0; i < fields.length; i++) {
/* 512 */       if (!fields[i].getName().equals("serialVersionUID"))
/*     */       {
/*     */ 
/* 515 */         flist.add(fields[i].getName()); }
/*     */     }
/* 517 */     writeExcel(file, list, clazz, flist, null);
/*     */   }
/*     */   
/*     */   public static void writeExcel(String file, List list, Class clazz, List<String> fields, List<String> titles)
/*     */     throws Exception
/*     */   {
/* 523 */     OutputStream os = getOutputStream(file);
/* 524 */     WritableWorkbook wwb = Workbook.createWorkbook(os);
/* 525 */     WritableSheet ws = wwb.createSheet("Sheet1", 0);
/* 526 */     Label label = null;
/* 527 */     int start = 0;
/* 528 */     if ((titles != null) && (titles.size() > 0)) {
/* 529 */       for (int j = 0; j < titles.size(); j++) {
/* 530 */         label = new Label(j, 0, (String)titles.get(j));
/* 531 */         ws.addCell(label);
/*     */       }
/* 533 */       start++;
/*     */     }
/* 535 */     for (int i = start; i < list.size() + start; i++) {
/* 536 */       Object o = list.get(i - start);
/* 537 */       if (o != null)
/*     */       {
/*     */ 
/* 540 */         for (int j = 0; j < fields.size(); j++) {
/* 541 */           String value = "";
/* 542 */           String field = (String)fields.get(j);
/* 543 */           if ((field != null) && (!"serialVersionUID".equals(field)))
/*     */           {
/*     */             try
/*     */             {
/* 547 */               value = ReflectUtil.invokeGetMethod(clazz, o, field).toString();
/*     */             } catch (Exception e) {
/* 549 */               LOGGER.error(e);
/*     */             }
/* 551 */             if ((field != null) && (isTime(field))) {
/* 552 */               if (value.isEmpty()) {
/* 553 */                 value = "";
/*     */               } else {
/* 555 */                 value = DateUtil.dateStr4(value);
/*     */               }
/*     */             }
/*     */             
/* 559 */             if ((field != null) && (isMoney(field))) {
/* 560 */               if (value.isEmpty()) {
/* 561 */                 value = "";
/*     */               } else {
/* 563 */                 value = StringUtil.isNull(Double.valueOf(BigDecimalUtil.round(value)));
/*     */               }
/*     */             }
/* 566 */             label = new Label(j, i, value);
/* 567 */             ws.addCell(label);
/*     */           }
/*     */         } } }
/* 570 */     wwb.write();
/* 571 */     wwb.close();
/*     */   }
/*     */   
/*     */   public static List[] read(String xls) throws Exception
/*     */   {
/* 576 */     List[] data = null;
/* 577 */     File file = new File(xls);
/* 578 */     if (file.exists()) {
/* 579 */       data = read(file);
/*     */     }
/* 581 */     return data;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static List[] read(File file)
/*     */   {
                return null;
/*     */   }
/*     */   
/*     */   private static boolean isTime(String field)
/*     */   {
/* 624 */     String[] times = { "addtime", "addTime", "repay_time", "verify_time", "repay_yestime", 
/* 625 */       "repayment_time", "repayment_yestime", "registertime", "vip_verify_time", "full_verifytime", 
/* 626 */       "last_tender_time", "kefu_addtime", "realname_verify_time", "video_verify_time", "scene_verify_time", 
/* 627 */       "phone_verify_time", "pwd_modify_time", "vip_end_time", "add_time", "update_time", 
/* 628 */       "interest_start_time", "interest_end_time" };
/* 629 */     boolean isTime = false;
/* 630 */     String[] arrayOfString1; int j = (arrayOfString1 = times).length; for (int i = 0; i < j; i++) { String s = arrayOfString1[i];
/* 631 */       if (s.equals(field)) {
/* 632 */         isTime = true;
/* 633 */         break;
/*     */       }
/*     */     }
/* 636 */     return isTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isMoney(String field)
/*     */   {
/* 646 */     String[] money = { "sum", "use_money", "collection", "total", "no_use_money", "money" };
/* 647 */     boolean isMoney = false;
/* 648 */     String[] arrayOfString1; int j = (arrayOfString1 = money).length; for (int i = 0; i < j; i++) { String s = arrayOfString1[i];
/* 649 */       if (s.equals(field)) {
/* 650 */         isMoney = true;
/* 651 */         break;
/*     */       }
/*     */     }
/* 654 */     return isMoney;
/*     */   }
/*     */   
/*     */   public static OutputStream getOutputStream(String file) throws IOException {
/* 658 */     File f = new File(file);
/* 659 */     f.createNewFile();
/* 660 */     OutputStream os = new FileOutputStream(f);
/* 661 */     return os;
/*     */   }
/*     */ }
