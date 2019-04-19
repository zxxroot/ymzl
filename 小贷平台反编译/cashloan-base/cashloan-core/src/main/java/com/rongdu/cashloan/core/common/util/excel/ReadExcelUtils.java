/*     */ package com.rongdu.cashloan.core.common.util.excel;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.exception.BaseException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReadExcelUtils
/*     */ {
/*  30 */   private Logger logger = LoggerFactory.getLogger(ReadExcelUtils.class);
/*     */   private Workbook wb;
/*     */   private Sheet sheet;
/*     */   private Row row;
/*     */   
/*     */   /* Error */
/*     */   public ReadExcelUtils(String filepath)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial 16	java/lang/Object:<init>	()V
/*     */     //   4: aload_0
/*     */     //   5: ldc 1
/*     */     //   7: invokestatic 19	org/slf4j/LoggerFactory:getLogger	(Ljava/lang/Class;)Lorg/slf4j/Logger;
/*     */     //   10: putfield 25	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:logger	Lorg/slf4j/Logger;
/*     */     //   13: aload_1
/*     */     //   14: ifnonnull +4 -> 18
/*     */     //   17: return
/*     */     //   18: aload_1
/*     */     //   19: aload_1
/*     */     //   20: ldc 27
/*     */     //   22: invokevirtual 29	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
/*     */     //   25: invokevirtual 35	java/lang/String:substring	(I)Ljava/lang/String;
/*     */     //   28: astore_2
/*     */     //   29: aconst_null
/*     */     //   30: astore_3
/*     */     //   31: new 39	java/io/FileInputStream
/*     */     //   34: dup
/*     */     //   35: aload_1
/*     */     //   36: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
/*     */     //   39: astore_3
/*     */     //   40: ldc 43
/*     */     //   42: aload_2
/*     */     //   43: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   46: ifeq +18 -> 64
/*     */     //   49: aload_0
/*     */     //   50: new 49	org/apache/poi/hssf/usermodel/HSSFWorkbook
/*     */     //   53: dup
/*     */     //   54: aload_3
/*     */     //   55: invokespecial 51	org/apache/poi/hssf/usermodel/HSSFWorkbook:<init>	(Ljava/io/InputStream;)V
/*     */     //   58: putfield 54	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:wb	Lorg/apache/poi/ss/usermodel/Workbook;
/*     */     //   61: goto +142 -> 203
/*     */     //   64: ldc 56
/*     */     //   66: aload_2
/*     */     //   67: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   70: ifeq +18 -> 88
/*     */     //   73: aload_0
/*     */     //   74: new 58	org/apache/poi/xssf/usermodel/XSSFWorkbook
/*     */     //   77: dup
/*     */     //   78: aload_3
/*     */     //   79: invokespecial 60	org/apache/poi/xssf/usermodel/XSSFWorkbook:<init>	(Ljava/io/InputStream;)V
/*     */     //   82: putfield 54	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:wb	Lorg/apache/poi/ss/usermodel/Workbook;
/*     */     //   85: goto +118 -> 203
/*     */     //   88: aload_0
/*     */     //   89: aconst_null
/*     */     //   90: putfield 54	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:wb	Lorg/apache/poi/ss/usermodel/Workbook;
/*     */     //   93: goto +110 -> 203
/*     */     //   96: astore 4
/*     */     //   98: aload_0
/*     */     //   99: getfield 25	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:logger	Lorg/slf4j/Logger;
/*     */     //   102: ldc 61
/*     */     //   104: aload 4
/*     */     //   106: invokeinterface 63 3 0
/*     */     //   111: aload_3
/*     */     //   112: invokevirtual 69	java/io/InputStream:close	()V
/*     */     //   115: goto +110 -> 225
/*     */     //   118: astore 6
/*     */     //   120: aload_0
/*     */     //   121: getfield 25	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:logger	Lorg/slf4j/Logger;
/*     */     //   124: ldc 74
/*     */     //   126: aload 6
/*     */     //   128: invokeinterface 63 3 0
/*     */     //   133: goto +92 -> 225
/*     */     //   136: astore 4
/*     */     //   138: aload_0
/*     */     //   139: getfield 25	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:logger	Lorg/slf4j/Logger;
/*     */     //   142: ldc 76
/*     */     //   144: aload 4
/*     */     //   146: invokeinterface 63 3 0
/*     */     //   151: aload_3
/*     */     //   152: invokevirtual 69	java/io/InputStream:close	()V
/*     */     //   155: goto +70 -> 225
/*     */     //   158: astore 6
/*     */     //   160: aload_0
/*     */     //   161: getfield 25	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:logger	Lorg/slf4j/Logger;
/*     */     //   164: ldc 74
/*     */     //   166: aload 6
/*     */     //   168: invokeinterface 63 3 0
/*     */     //   173: goto +52 -> 225
/*     */     //   176: astore 5
/*     */     //   178: aload_3
/*     */     //   179: invokevirtual 69	java/io/InputStream:close	()V
/*     */     //   182: goto +18 -> 200
/*     */     //   185: astore 6
/*     */     //   187: aload_0
/*     */     //   188: getfield 25	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:logger	Lorg/slf4j/Logger;
/*     */     //   191: ldc 74
/*     */     //   193: aload 6
/*     */     //   195: invokeinterface 63 3 0
/*     */     //   200: aload 5
/*     */     //   202: athrow
/*     */     //   203: aload_3
/*     */     //   204: invokevirtual 69	java/io/InputStream:close	()V
/*     */     //   207: goto +18 -> 225
/*     */     //   210: astore 6
/*     */     //   212: aload_0
/*     */     //   213: getfield 25	com/rongdu/cashloan/core/common/util/excel/ReadExcelUtils:logger	Lorg/slf4j/Logger;
/*     */     //   216: ldc 74
/*     */     //   218: aload 6
/*     */     //   220: invokeinterface 63 3 0
/*     */     //   225: return
/*     */     // Line number table:
/*     */     //   Java source line #35	-> byte code offset #0
/*     */     //   Java source line #30	-> byte code offset #4
/*     */     //   Java source line #36	-> byte code offset #13
/*     */     //   Java source line #37	-> byte code offset #17
/*     */     //   Java source line #39	-> byte code offset #18
/*     */     //   Java source line #40	-> byte code offset #29
/*     */     //   Java source line #42	-> byte code offset #31
/*     */     //   Java source line #43	-> byte code offset #40
/*     */     //   Java source line #44	-> byte code offset #49
/*     */     //   Java source line #45	-> byte code offset #61
/*     */     //   Java source line #46	-> byte code offset #73
/*     */     //   Java source line #47	-> byte code offset #85
/*     */     //   Java source line #48	-> byte code offset #88
/*     */     //   Java source line #50	-> byte code offset #93
/*     */     //   Java source line #51	-> byte code offset #98
/*     */     //   Java source line #56	-> byte code offset #111
/*     */     //   Java source line #57	-> byte code offset #115
/*     */     //   Java source line #58	-> byte code offset #120
/*     */     //   Java source line #52	-> byte code offset #136
/*     */     //   Java source line #53	-> byte code offset #138
/*     */     //   Java source line #56	-> byte code offset #151
/*     */     //   Java source line #57	-> byte code offset #155
/*     */     //   Java source line #58	-> byte code offset #160
/*     */     //   Java source line #54	-> byte code offset #176
/*     */     //   Java source line #56	-> byte code offset #178
/*     */     //   Java source line #57	-> byte code offset #182
/*     */     //   Java source line #58	-> byte code offset #187
/*     */     //   Java source line #60	-> byte code offset #200
/*     */     //   Java source line #56	-> byte code offset #203
/*     */     //   Java source line #57	-> byte code offset #207
/*     */     //   Java source line #58	-> byte code offset #212
/*     */     //   Java source line #61	-> byte code offset #225
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	226	0	this	ReadExcelUtils
/*     */     //   0	226	1	filepath	String
/*     */     //   28	39	2	ext	String
/*     */     //   30	174	3	is	InputStream
/*     */     //   96	9	4	e	java.io.FileNotFoundException
/*     */     //   136	9	4	e	IOException
/*     */     //   176	25	5	localObject	Object
/*     */     //   118	9	6	e	IOException
/*     */     //   158	9	6	e	IOException
/*     */     //   185	9	6	e	IOException
/*     */     //   210	9	6	e	IOException
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   31	93	96	java/io/FileNotFoundException
/*     */     //   111	115	118	java/io/IOException
/*     */     //   31	93	136	java/io/IOException
/*     */     //   151	155	158	java/io/IOException
/*     */     //   31	111	176	finally
/*     */     //   136	151	176	finally
/*     */     //   178	182	185	java/io/IOException
/*     */     //   203	207	210	java/io/IOException
/*     */   }
/*     */   
/*     */   public ReadExcelUtils(MultipartFile file)
/*     */     throws IOException
/*     */   {
/*  63 */     InputStream is = file.getInputStream();
/*     */     try {
/*  65 */       this.wb = new XSSFWorkbook(is);
/*     */     } catch (Exception e) {
/*  67 */       this.wb = new HSSFWorkbook(is);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String[] readExcelTitle()
/*     */   {
/*  79 */     if (this.wb == null) {
/*  80 */       throw new BaseException("Workbook对象为空！");
/*     */     }
/*  82 */     this.sheet = this.wb.getSheetAt(0);
/*  83 */     this.row = this.sheet.getRow(0);
/*     */     
/*  85 */     int colNum = this.row.getPhysicalNumberOfCells();
/*  86 */     String[] title = new String[colNum];
/*  87 */     for (int i = 0; i < colNum; i++)
/*     */     {
/*  89 */       title[i] = this.row.getCell(i).getCellFormula();
/*     */     }
/*  91 */     return title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<List<String>> readExcelContent()
/*     */   {
/* 102 */     if (this.wb == null) {
/* 103 */       throw new BaseException("Workbook对象为空！");
/*     */     }
/* 105 */     List<List<String>> content = new ArrayList();
/* 106 */     this.sheet = this.wb.getSheetAt(0);
/*     */     
/* 108 */     int rowNum = this.sheet.getLastRowNum();
/* 109 */     for (int i = 1; i <= rowNum; i++) {
/* 110 */       this.row = this.sheet.getRow(i);
/* 111 */       if (this.row != null) {
/* 112 */         int colNum = this.row.getPhysicalNumberOfCells();
/* 113 */         int j = 0;
/* 114 */         List<String> cellValue = new ArrayList();
/* 115 */         while (j < colNum) {
/* 116 */           Cell cell = this.row.getCell(j);
/* 117 */           if (cell != null) {
/* 118 */             Object obj = getCellFormatValue(cell);
/* 119 */             String value = obj != null ? obj.toString().replace("/t", "").trim() : "";
/* 120 */             cellValue.add(value);
/*     */           }
/* 122 */           j++;
/*     */         }
/* 124 */         content.add(cellValue);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 129 */     return content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Object getCellFormatValue(Cell cell)
/*     */   {
/* 141 */     Object cellvalue = "";
/* 142 */     if (cell != null)
/*     */     {
/* 144 */       switch (cell.getCellType())
/*     */       {
/*     */       case 0: 
/*     */       case 2: 
/* 148 */         if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
/* 149 */           Date date = cell.getDateCellValue();
/* 150 */           cellvalue = tool.util.DateUtil.dateStr(date, "yyyy/MM/dd HH:mm:ss");
/*     */         }
/*     */         else
/*     */         {
/* 154 */           cellvalue = String.valueOf(cell.getNumericCellValue());
/*     */         }
/* 156 */         break;
/*     */       
/*     */ 
/*     */       case 1: 
/* 160 */         cellvalue = cell.getRichStringCellValue().getString();
/* 161 */         break;
/*     */       default: 
/* 163 */         cellvalue = "";
/*     */         
/* 165 */         break; } } else {
/* 166 */       cellvalue = "";
/*     */     }
/* 168 */     return cellvalue;
/*     */   }
/*     */ }
