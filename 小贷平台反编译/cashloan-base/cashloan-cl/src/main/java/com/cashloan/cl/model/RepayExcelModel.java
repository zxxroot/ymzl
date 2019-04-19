/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
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
/*     */ public class RepayExcelModel
/*     */ {
/*  29 */   private static final Logger logger = Logger.getLogger(RepayExcelModel.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Workbook createWorkBook(List<List<String>> list, String title)
/*     */   {
/*  39 */     Workbook wb = new HSSFWorkbook();
/*     */     
/*  41 */     Sheet sheet = wb.createSheet(title);
/*     */     
/*  43 */     for (int i = 0; i < 100; i++) {
/*  44 */       sheet.setColumnWidth((short)i, 5355);
/*     */     }
/*     */     
/*  47 */     sheet.createRow(0);
/*     */     
/*  49 */     CellStyle cs = wb.createCellStyle();
/*  50 */     CellStyle cs2 = wb.createCellStyle();
/*     */     
/*     */ 
/*  53 */     Font f = wb.createFont();
/*  54 */     Font f2 = wb.createFont();
/*     */     
/*     */ 
/*  57 */     f.setFontHeightInPoints((short)10);
/*  58 */     f.setColor(IndexedColors.BLACK.getIndex());
/*  59 */     f.setBoldweight((short)700);
/*     */     
/*     */ 
/*  62 */     f2.setFontHeightInPoints((short)10);
/*  63 */     f2.setColor(IndexedColors.BLACK.getIndex());
/*     */     
/*     */ 
/*  66 */     cs.setFont(f);
/*  67 */     cs.setBorderLeft((short)1);
/*  68 */     cs.setBorderRight((short)1);
/*  69 */     cs.setBorderTop((short)1);
/*  70 */     cs.setBorderBottom((short)1);
/*  71 */     cs.setAlignment((short)2);
/*     */     
/*     */ 
/*  74 */     cs2.setFont(f2);
/*  75 */     cs2.setBorderLeft((short)1);
/*  76 */     cs2.setBorderRight((short)1);
/*  77 */     cs2.setBorderTop((short)1);
/*  78 */     cs2.setBorderBottom((short)1);
/*  79 */     cs2.setAlignment((short)2);
/*     */     
/*  81 */     for (short i = 1; i < list.size(); i = (short)(i + 1))
/*     */     {
/*     */ 
/*  84 */       Row row = sheet.createRow(i);
/*  85 */       List<String> keys = (List)list.get(i);
/*     */       
/*  87 */       for (short j = 0; j < keys.size(); j = (short)(j + 1)) {
/*  88 */         Cell cell = row.createCell(j);
/*  89 */         cell.setCellValue((String)keys.get(j));
/*  90 */         cell.setCellStyle(cs2);
/*     */       }
/*     */     }
/*  93 */     return wb;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public String saveExcelByList(List<List<String>> list, String title, String fileName, HttpServletRequest request)
{return null;}
/*     */   
/*     */   public void exportExcel(List<List<String>> list, String title, String sFileName, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*     */     try
/*     */     {
/* 147 */       OutputStream out = response.getOutputStream();
/*     */       
/* 149 */       String agent = request.getHeader("User-Agent");
/*     */       
/* 151 */       boolean isFirefox = (agent != null) && (agent.contains("Firefox"));
/* 153 */       String sFileName_; if (isFirefox) {
/* 154 */         sFileName_ = new String(sFileName.getBytes("UTF-8"), "ISO-8859-1");
/*     */       } else {
/* 156 */         sFileName_ = URLEncoder.encode(sFileName, "UTF8");
/*     */       }
/* 158 */       response.setHeader("Content-Disposition", "attachment; filename=".concat(sFileName_));
/* 159 */       response.setHeader("Content-Type", "application/vnd.ms-excel");
/* 160 */       response.setCharacterEncoding("utf-8");
/* 161 */       response.setContentType("application/vnd.ms-excel");
/* 162 */       createWorkBook(list, title).write(out);
/* 163 */       out.flush();
/* 164 */       out.close();
/*     */     } catch (IOException e) {
/* 166 */       logger.error(e);
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void exportFile(String path, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore 4
/*     */     //   3: aconst_null
/*     */     //   4: astore 5
/*     */     //   6: aload_1
/*     */     //   7: aload_1
/*     */     //   8: ldc -81
/*     */     //   10: invokevirtual 215	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
/*     */     //   13: invokevirtual 337	java/lang/String:substring	(I)Ljava/lang/String;
/*     */     //   16: astore 6
/*     */     //   18: new 161	java/lang/StringBuilder
/*     */     //   21: dup
/*     */     //   22: aload_2
/*     */     //   23: invokeinterface 163 1 0
/*     */     //   28: invokeinterface 169 1 0
/*     */     //   33: ldc -81
/*     */     //   35: invokeinterface 177 2 0
/*     */     //   40: invokestatic 183	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   43: invokespecial 187	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   46: aload_1
/*     */     //   47: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   50: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   53: astore 7
/*     */     //   55: aload_3
/*     */     //   56: invokeinterface 265 1 0
/*     */     //   61: astore 4
/*     */     //   63: aload_2
/*     */     //   64: ldc_w 271
/*     */     //   67: invokeinterface 273 2 0
/*     */     //   72: astore 8
/*     */     //   74: aload 8
/*     */     //   76: ifnull +18 -> 94
/*     */     //   79: aload 8
/*     */     //   81: ldc_w 276
/*     */     //   84: invokevirtual 278	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
/*     */     //   87: ifeq +7 -> 94
/*     */     //   90: iconst_1
/*     */     //   91: goto +4 -> 95
/*     */     //   94: iconst_0
/*     */     //   95: istore 9
/*     */     //   97: iload 9
/*     */     //   99: ifeq +26 -> 125
/*     */     //   102: new 111	java/lang/String
/*     */     //   105: dup
/*     */     //   106: aload 6
/*     */     //   108: ldc_w 282
/*     */     //   111: invokevirtual 284	java/lang/String:getBytes	(Ljava/lang/String;)[B
/*     */     //   114: ldc_w 288
/*     */     //   117: invokespecial 290	java/lang/String:<init>	([BLjava/lang/String;)V
/*     */     //   120: astore 6
/*     */     //   122: goto +13 -> 135
/*     */     //   125: aload 6
/*     */     //   127: ldc_w 293
/*     */     //   130: invokestatic 295	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   133: astore 6
/*     */     //   135: new 340	java/io/BufferedInputStream
/*     */     //   138: dup
/*     */     //   139: new 342	java/io/FileInputStream
/*     */     //   142: dup
/*     */     //   143: aload 7
/*     */     //   145: invokespecial 344	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
/*     */     //   148: invokespecial 345	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
/*     */     //   151: astore 5
/*     */     //   153: aload 5
/*     */     //   155: invokevirtual 348	java/io/InputStream:available	()I
/*     */     //   158: newarray <illegal type>
/*     */     //   160: astore 10
/*     */     //   162: aload 5
/*     */     //   164: aload 10
/*     */     //   166: invokevirtual 353	java/io/InputStream:read	([B)I
/*     */     //   169: pop
/*     */     //   170: aload_3
/*     */     //   171: invokeinterface 357 1 0
/*     */     //   176: aload_3
/*     */     //   177: ldc_w 301
/*     */     //   180: ldc_w 303
/*     */     //   183: aload 6
/*     */     //   185: invokevirtual 305	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   188: invokeinterface 308 3 0
/*     */     //   193: aload_3
/*     */     //   194: ldc_w 312
/*     */     //   197: ldc_w 314
/*     */     //   200: invokeinterface 308 3 0
/*     */     //   205: aload_3
/*     */     //   206: ldc_w 316
/*     */     //   209: invokeinterface 318 2 0
/*     */     //   214: aload_3
/*     */     //   215: ldc_w 314
/*     */     //   218: invokeinterface 321 2 0
/*     */     //   223: aload 4
/*     */     //   225: aload 10
/*     */     //   227: invokevirtual 360	java/io/OutputStream:write	([B)V
/*     */     //   230: aload 4
/*     */     //   232: invokevirtual 324	java/io/OutputStream:flush	()V
/*     */     //   235: goto +87 -> 322
/*     */     //   238: astore 6
/*     */     //   240: getstatic 16	com/rongdu/cashloan/cl/model/RepayExcelModel:logger	Lorg/apache/log4j/Logger;
/*     */     //   243: aload 6
/*     */     //   245: invokevirtual 239	org/apache/log4j/Logger:error	(Ljava/lang/Object;)V
/*     */     //   248: aload 5
/*     */     //   250: ifnull +8 -> 258
/*     */     //   253: aload 5
/*     */     //   255: invokevirtual 363	java/io/InputStream:close	()V
/*     */     //   258: aload 4
/*     */     //   260: ifnull +95 -> 355
/*     */     //   263: aload 4
/*     */     //   265: invokevirtual 242	java/io/OutputStream:close	()V
/*     */     //   268: goto +87 -> 355
/*     */     //   271: astore 12
/*     */     //   273: getstatic 16	com/rongdu/cashloan/cl/model/RepayExcelModel:logger	Lorg/apache/log4j/Logger;
/*     */     //   276: aload 12
/*     */     //   278: invokevirtual 239	org/apache/log4j/Logger:error	(Ljava/lang/Object;)V
/*     */     //   281: goto +74 -> 355
/*     */     //   284: astore 11
/*     */     //   286: aload 5
/*     */     //   288: ifnull +8 -> 296
/*     */     //   291: aload 5
/*     */     //   293: invokevirtual 363	java/io/InputStream:close	()V
/*     */     //   296: aload 4
/*     */     //   298: ifnull +21 -> 319
/*     */     //   301: aload 4
/*     */     //   303: invokevirtual 242	java/io/OutputStream:close	()V
/*     */     //   306: goto +13 -> 319
/*     */     //   309: astore 12
/*     */     //   311: getstatic 16	com/rongdu/cashloan/cl/model/RepayExcelModel:logger	Lorg/apache/log4j/Logger;
/*     */     //   314: aload 12
/*     */     //   316: invokevirtual 239	org/apache/log4j/Logger:error	(Ljava/lang/Object;)V
/*     */     //   319: aload 11
/*     */     //   321: athrow
/*     */     //   322: aload 5
/*     */     //   324: ifnull +8 -> 332
/*     */     //   327: aload 5
/*     */     //   329: invokevirtual 363	java/io/InputStream:close	()V
/*     */     //   332: aload 4
/*     */     //   334: ifnull +21 -> 355
/*     */     //   337: aload 4
/*     */     //   339: invokevirtual 242	java/io/OutputStream:close	()V
/*     */     //   342: goto +13 -> 355
/*     */     //   345: astore 12
/*     */     //   347: getstatic 16	com/rongdu/cashloan/cl/model/RepayExcelModel:logger	Lorg/apache/log4j/Logger;
/*     */     //   350: aload 12
/*     */     //   352: invokevirtual 239	org/apache/log4j/Logger:error	(Ljava/lang/Object;)V
/*     */     //   355: return
/*     */     // Line number table:
/*     */     //   Java source line #170	-> byte code offset #0
/*     */     //   Java source line #171	-> byte code offset #3
/*     */     //   Java source line #173	-> byte code offset #6
/*     */     //   Java source line #174	-> byte code offset #18
/*     */     //   Java source line #176	-> byte code offset #55
/*     */     //   Java source line #178	-> byte code offset #63
/*     */     //   Java source line #180	-> byte code offset #74
/*     */     //   Java source line #181	-> byte code offset #97
/*     */     //   Java source line #182	-> byte code offset #102
/*     */     //   Java source line #183	-> byte code offset #122
/*     */     //   Java source line #184	-> byte code offset #125
/*     */     //   Java source line #187	-> byte code offset #135
/*     */     //   Java source line #188	-> byte code offset #153
/*     */     //   Java source line #189	-> byte code offset #162
/*     */     //   Java source line #191	-> byte code offset #170
/*     */     //   Java source line #192	-> byte code offset #176
/*     */     //   Java source line #193	-> byte code offset #193
/*     */     //   Java source line #194	-> byte code offset #205
/*     */     //   Java source line #195	-> byte code offset #214
/*     */     //   Java source line #196	-> byte code offset #223
/*     */     //   Java source line #197	-> byte code offset #230
/*     */     //   Java source line #198	-> byte code offset #235
/*     */     //   Java source line #199	-> byte code offset #240
/*     */     //   Java source line #202	-> byte code offset #248
/*     */     //   Java source line #203	-> byte code offset #253
/*     */     //   Java source line #205	-> byte code offset #258
/*     */     //   Java source line #206	-> byte code offset #263
/*     */     //   Java source line #208	-> byte code offset #268
/*     */     //   Java source line #209	-> byte code offset #273
/*     */     //   Java source line #200	-> byte code offset #284
/*     */     //   Java source line #202	-> byte code offset #286
/*     */     //   Java source line #203	-> byte code offset #291
/*     */     //   Java source line #205	-> byte code offset #296
/*     */     //   Java source line #206	-> byte code offset #301
/*     */     //   Java source line #208	-> byte code offset #306
/*     */     //   Java source line #209	-> byte code offset #311
/*     */     //   Java source line #211	-> byte code offset #319
/*     */     //   Java source line #202	-> byte code offset #322
/*     */     //   Java source line #203	-> byte code offset #327
/*     */     //   Java source line #205	-> byte code offset #332
/*     */     //   Java source line #206	-> byte code offset #337
/*     */     //   Java source line #208	-> byte code offset #342
/*     */     //   Java source line #209	-> byte code offset #347
/*     */     //   Java source line #212	-> byte code offset #355
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	356	0	this	RepayExcelModel
/*     */     //   0	356	1	path	String
/*     */     //   0	356	2	request	HttpServletRequest
/*     */     //   0	356	3	response	HttpServletResponse
/*     */     //   1	337	4	out	OutputStream
/*     */     //   4	324	5	fis	java.io.InputStream
/*     */     //   16	168	6	fileName	String
/*     */     //   238	6	6	e	IOException
/*     */     //   53	91	7	path_	String
/*     */     //   72	8	8	agent	String
/*     */     //   95	3	9	isFirefox	boolean
/*     */     //   160	66	10	buffer	byte[]
/*     */     //   284	36	11	localObject	Object
/*     */     //   271	6	12	e	IOException
/*     */     //   309	6	12	e	IOException
/*     */     //   345	6	12	e	IOException
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	235	238	java/io/IOException
/*     */     //   248	268	271	java/io/IOException
/*     */     //   6	248	284	finally
/*     */     //   286	306	309	java/io/IOException
/*     */     //   322	342	345	java/io/IOException
/*     */   }
/*     */ }
