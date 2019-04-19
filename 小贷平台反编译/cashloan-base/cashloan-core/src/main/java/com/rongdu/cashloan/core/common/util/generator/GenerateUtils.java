/*     */ package com.rongdu.cashloan.core.common.util.generator;
/*     */ 
/*     */ import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tool.util.StringUtil;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

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
/*     */ public class GenerateUtils
/*     */ {
/*  24 */   public static final Logger logger = LoggerFactory.getLogger(GenerateUtils.class);
/*     */   
/*     */   /* Error */
/*     */   public static java.util.List<Table> getList(String dbClass, String table_name, String url, String MysqlUser, String mysqlPassword, String database, String sql)
/*     */   {
    return null;
/*     */   }
/*     */   
/*     */   public static Connection getDblink(String dbClass, String url, String MysqlUser, String mysqlPassword)
/*     */   {
/*  88 */     Connection conn = null;
/*     */     try {
/*  90 */       Class.forName(dbClass);
/*  91 */       conn = DriverManager.getConnection(url, MysqlUser, mysqlPassword);
/*     */     } catch (Exception e) {
/*  93 */       logger.error(e.getMessage(), e);
/*     */     }
/*  95 */     return conn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String toUpper(String str)
/*     */   {
/* 105 */     String name = null;
/* 106 */     String[] split = StringUtil.split(str, "_");
/* 107 */     String[] arrayOfString1; int j = (arrayOfString1 = split).length; for (int i = 0; i < j; i++) { String string = arrayOfString1[i];
/* 108 */       if (name == null) {
/* 109 */         name = StringUtil.capitalize(string);
/*     */       } else
/* 111 */         name = name + StringUtil.capitalize(string);
/*     */     }
/* 113 */     return name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String sqlTypeToJavaType(String sqlType)
/*     */   {
/* 124 */     if ("bit".equalsIgnoreCase(sqlType))
/* 125 */       return "Boolean";
/* 126 */     if ("tinyint".equalsIgnoreCase(sqlType))
/* 127 */       return "Integer";
/* 128 */     if ("smallint".equalsIgnoreCase(sqlType))
/* 129 */       return "short";
/* 130 */     if ("int".equalsIgnoreCase(sqlType))
/* 131 */       return "Integer";
/* 132 */     if ("bigint".equalsIgnoreCase(sqlType))
/* 133 */       return "Long";
/* 134 */     if ("float".equalsIgnoreCase(sqlType))
/* 135 */       return "float";
/* 136 */     if (("decimal".equalsIgnoreCase(sqlType)) || ("numeric".equalsIgnoreCase(sqlType)) || 
/* 137 */       ("real".equalsIgnoreCase(sqlType)) || ("money".equalsIgnoreCase(sqlType)) || 
/* 138 */       ("smallmoney".equalsIgnoreCase(sqlType)) || ("double".equalsIgnoreCase(sqlType)))
/* 139 */       return "Double";
/* 140 */     if (("varchar".equalsIgnoreCase(sqlType)) || ("char".equalsIgnoreCase(sqlType)) || 
/* 141 */       ("nvarchar".equalsIgnoreCase(sqlType)) || ("nchar".equalsIgnoreCase(sqlType)) || 
/* 142 */       ("text".equalsIgnoreCase(sqlType)))
/* 143 */       return "String";
/* 144 */     if (("datetime".equalsIgnoreCase(sqlType)) || ("date".equalsIgnoreCase(sqlType)))
/* 145 */       return "Date";
/* 146 */     if ("image".equalsIgnoreCase(sqlType)) {
/* 147 */       return "Blod";
/*     */     }
/* 149 */     return "String";
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
/*     */   private static String sqlTypeToJdbcType(String sqlType)
/*     */   {
/* 162 */     if (sqlType.equalsIgnoreCase("bit"))
/* 163 */       return "BIT";
/* 164 */     if (sqlType.equalsIgnoreCase("tinyint"))
/* 165 */       return "INTEGER";
/* 166 */     if (sqlType.equalsIgnoreCase("smallint"))
/* 167 */       return "INTEGER";
/* 168 */     if (sqlType.equalsIgnoreCase("int"))
/* 169 */       return "INTEGER";
/* 170 */     if (sqlType.equalsIgnoreCase("bigint"))
/* 171 */       return "BIGINT";
/* 172 */     if (sqlType.equalsIgnoreCase("float"))
/* 173 */       return "DECIMAL";
/* 174 */     if ((sqlType.equalsIgnoreCase("decimal")) || (sqlType.equalsIgnoreCase("numeric")) || 
/* 175 */       (sqlType.equalsIgnoreCase("real")) || (sqlType.equalsIgnoreCase("money")) || 
/* 176 */       (sqlType.equalsIgnoreCase("smallmoney")) || (sqlType.equalsIgnoreCase("double")))
/* 177 */       return "DECIMAL";
/* 178 */     if ((sqlType.equalsIgnoreCase("varchar")) || (sqlType.equalsIgnoreCase("char")) || 
/* 179 */       (sqlType.equalsIgnoreCase("nvarchar")) || (sqlType.equalsIgnoreCase("nchar")) || 
/* 180 */       (sqlType.equalsIgnoreCase("text")))
/* 181 */       return "VARCHAR";
/* 182 */     if ((sqlType.equalsIgnoreCase("datetime")) || (sqlType.equalsIgnoreCase("date")) || (sqlType.equalsIgnoreCase("timestamp"))) {
/* 183 */       return "TIMESTAMP";
/*     */     }
/*     */     
/* 186 */     return "VARCHAR";
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static void writeFile(String content, String filePath)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore_2
/*     */     //   2: aload_1
/*     */     //   3: invokestatic 278	com/rongdu/cashloan/core/common/util/generator/GenerateUtils:createFile	(Ljava/lang/String;)Z
/*     */     //   6: ifeq +38 -> 44
/*     */     //   9: new 281	java/io/FileWriter
/*     */     //   12: dup
/*     */     //   13: aload_1
/*     */     //   14: iconst_1
/*     */     //   15: invokespecial 283	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
/*     */     //   18: astore_2
/*     */     //   19: new 286	java/io/BufferedWriter
/*     */     //   22: dup
/*     */     //   23: aload_2
/*     */     //   24: invokespecial 288	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
/*     */     //   27: astore_3
/*     */     //   28: aload_3
/*     */     //   29: aload_0
/*     */     //   30: invokevirtual 291	java/io/BufferedWriter:write	(Ljava/lang/String;)V
/*     */     //   33: aload_3
/*     */     //   34: invokevirtual 294	java/io/BufferedWriter:close	()V
/*     */     //   37: aload_2
/*     */     //   38: invokevirtual 295	java/io/FileWriter:close	()V
/*     */     //   41: goto +93 -> 134
/*     */     //   44: getstatic 296	java/lang/System:err	Ljava/io/PrintStream;
/*     */     //   47: ldc_w 302
/*     */     //   50: invokevirtual 304	java/io/PrintStream:println	(Ljava/lang/String;)V
/*     */     //   53: goto +81 -> 134
/*     */     //   56: astore_3
/*     */     //   57: getstatic 16	com/rongdu/cashloan/core/common/util/generator/GenerateUtils:logger	Lorg/slf4j/Logger;
/*     */     //   60: aload_3
/*     */     //   61: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
/*     */     //   64: aload_3
/*     */     //   65: invokeinterface 121 3 0
/*     */     //   70: aload_2
/*     */     //   71: ifnull +91 -> 162
/*     */     //   74: aload_2
/*     */     //   75: invokevirtual 295	java/io/FileWriter:close	()V
/*     */     //   78: goto +84 -> 162
/*     */     //   81: astore 5
/*     */     //   83: getstatic 16	com/rongdu/cashloan/core/common/util/generator/GenerateUtils:logger	Lorg/slf4j/Logger;
/*     */     //   86: aload 5
/*     */     //   88: invokevirtual 309	java/io/IOException:getMessage	()Ljava/lang/String;
/*     */     //   91: aload 5
/*     */     //   93: invokeinterface 121 3 0
/*     */     //   98: goto +64 -> 162
/*     */     //   101: astore 4
/*     */     //   103: aload_2
/*     */     //   104: ifnull +27 -> 131
/*     */     //   107: aload_2
/*     */     //   108: invokevirtual 295	java/io/FileWriter:close	()V
/*     */     //   111: goto +20 -> 131
/*     */     //   114: astore 5
/*     */     //   116: getstatic 16	com/rongdu/cashloan/core/common/util/generator/GenerateUtils:logger	Lorg/slf4j/Logger;
/*     */     //   119: aload 5
/*     */     //   121: invokevirtual 309	java/io/IOException:getMessage	()Ljava/lang/String;
/*     */     //   124: aload 5
/*     */     //   126: invokeinterface 121 3 0
/*     */     //   131: aload 4
/*     */     //   133: athrow
/*     */     //   134: aload_2
/*     */     //   135: ifnull +27 -> 162
/*     */     //   138: aload_2
/*     */     //   139: invokevirtual 295	java/io/FileWriter:close	()V
/*     */     //   142: goto +20 -> 162
/*     */     //   145: astore 5
/*     */     //   147: getstatic 16	com/rongdu/cashloan/core/common/util/generator/GenerateUtils:logger	Lorg/slf4j/Logger;
/*     */     //   150: aload 5
/*     */     //   152: invokevirtual 309	java/io/IOException:getMessage	()Ljava/lang/String;
/*     */     //   155: aload 5
/*     */     //   157: invokeinterface 121 3 0
/*     */     //   162: return
/*     */     // Line number table:
/*     */     //   Java source line #195	-> byte code offset #0
/*     */     //   Java source line #197	-> byte code offset #2
/*     */     //   Java source line #198	-> byte code offset #9
/*     */     //   Java source line #199	-> byte code offset #19
/*     */     //   Java source line #200	-> byte code offset #28
/*     */     //   Java source line #201	-> byte code offset #33
/*     */     //   Java source line #202	-> byte code offset #37
/*     */     //   Java source line #203	-> byte code offset #41
/*     */     //   Java source line #204	-> byte code offset #44
/*     */     //   Java source line #206	-> byte code offset #53
/*     */     //   Java source line #207	-> byte code offset #57
/*     */     //   Java source line #209	-> byte code offset #70
/*     */     //   Java source line #211	-> byte code offset #74
/*     */     //   Java source line #212	-> byte code offset #78
/*     */     //   Java source line #213	-> byte code offset #83
/*     */     //   Java source line #208	-> byte code offset #101
/*     */     //   Java source line #209	-> byte code offset #103
/*     */     //   Java source line #211	-> byte code offset #107
/*     */     //   Java source line #212	-> byte code offset #111
/*     */     //   Java source line #213	-> byte code offset #116
/*     */     //   Java source line #216	-> byte code offset #131
/*     */     //   Java source line #209	-> byte code offset #134
/*     */     //   Java source line #211	-> byte code offset #138
/*     */     //   Java source line #212	-> byte code offset #142
/*     */     //   Java source line #213	-> byte code offset #147
/*     */     //   Java source line #217	-> byte code offset #162
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	163	0	content	String
/*     */     //   0	163	1	filePath	String
/*     */     //   1	138	2	fileWriter	java.io.FileWriter
/*     */     //   27	7	3	bufferedWriter	java.io.BufferedWriter
/*     */     //   56	9	3	e	Exception
/*     */     //   101	31	4	localObject	Object
/*     */     //   81	11	5	e	java.io.IOException
/*     */     //   114	11	5	e	java.io.IOException
/*     */     //   145	11	5	e	java.io.IOException
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	53	56	java/lang/Exception
/*     */     //   74	78	81	java/io/IOException
/*     */     //   2	70	101	finally
/*     */     //   107	111	114	java/io/IOException
/*     */     //   138	142	145	java/io/IOException
/*     */   }
/*     */   
/*     */   public static boolean createFile(String descFileName)
/*     */   {
/* 227 */     File file = new File(descFileName);
/* 228 */     if (file.exists()) {
/* 229 */       System.err.println("文件 " + descFileName + " 已存在!");
/* 230 */       return false;
/*     */     }
/* 232 */     if (descFileName.endsWith(File.separator)) {
/* 233 */       System.err.println(descFileName + " 为目录，不能创建目录!");
/* 234 */       return false;
/*     */     }
/* 236 */     if (!file.getParentFile().exists())
/*     */     {
/* 238 */       if (!file.getParentFile().mkdirs()) {
/* 239 */         logger.error("创建文件所在的目录失败!");
/* 240 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 246 */       if (file.createNewFile()) {
/* 247 */         System.err.println(descFileName + " 文件创建成功!");
/* 248 */         return true;
/*     */       }
/* 250 */       System.err.println(descFileName + " 文件创建失败!");
/* 251 */       return false;
/*     */     }
/*     */     catch (Exception e) {
/* 254 */       logger.error(descFileName + " 文件创建失败!", e); }
/* 255 */     return false;
/*     */   }
/*     */   
/*     */   public static String getDate()
/*     */   {
/* 260 */     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 261 */     return format.format(new Date());
/*     */   }
/*     */ }


/* generator\GenerateUtils.class

 */