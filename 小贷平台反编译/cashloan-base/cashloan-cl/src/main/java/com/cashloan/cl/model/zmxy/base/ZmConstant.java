/*    */ package com.cashloan.cl.model.zmxy.base;
/*    */ 
/*    */ import java.util.Properties;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZmConstant
/*    */ {
/* 17 */   public static final Logger logger = LoggerFactory.getLogger(ZmConstant.class);
/*    */   
/*    */   public static final String CHARSET = "UTF-8";
/*    */   
/*    */   public static final String ZmScoreProductCode = "w1010100100000000001";
/*    */   
/*    */   public static final String ZmPlatform = "zmop";
/*    */   
/*    */   public static final String ZmChannel = "apppc";
/*    */   
/*    */   public static final String ZmWatchListProductCode = "w1010100100000000022";
/*    */   
/*    */   public static final String ZmAnitFraudProductCode = "w1010100000000000103";
/*    */   
/* 31 */   private static final Properties ZmWatchListRiskTable = new Properties();
/*    */   
/*    */   /* Error */
/*    */   static
/*    */   {
/*    */     // Byte code:
/*    */     //   0: ldc 1
/*    */     //   2: invokestatic 32	org/slf4j/LoggerFactory:getLogger	(Ljava/lang/Class;)Lorg/slf4j/Logger;
/*    */     //   5: putstatic 38	com/rongdu/cashloan/cl/model/zmxy/base/ZmConstant:logger	Lorg/slf4j/Logger;
/*    */     //   8: new 40	java/util/Properties
/*    */     //   11: dup
/*    */     //   12: invokespecial 42	java/util/Properties:<init>	()V
/*    */     //   15: putstatic 45	com/rongdu/cashloan/cl/model/zmxy/base/ZmConstant:ZmWatchListRiskTable	Ljava/util/Properties;
/*    */     //   18: aconst_null
/*    */     //   19: astore_0
/*    */     //   20: aconst_null
/*    */     //   21: astore_1
/*    */     //   22: ldc 1
/*    */     //   24: ldc 47
/*    */     //   26: invokevirtual 49	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
/*    */     //   29: astore_0
/*    */     //   30: new 55	java/io/BufferedReader
/*    */     //   33: dup
/*    */     //   34: new 57	java/io/InputStreamReader
/*    */     //   37: dup
/*    */     //   38: aload_0
/*    */     //   39: invokespecial 59	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
/*    */     //   42: invokespecial 62	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*    */     //   45: astore_1
/*    */     //   46: getstatic 45	com/rongdu/cashloan/cl/model/zmxy/base/ZmConstant:ZmWatchListRiskTable	Ljava/util/Properties;
/*    */     //   49: aload_1
/*    */     //   50: invokevirtual 65	java/util/Properties:load	(Ljava/io/Reader;)V
/*    */     //   53: goto +93 -> 146
/*    */     //   56: astore_2
/*    */     //   57: getstatic 38	com/rongdu/cashloan/cl/model/zmxy/base/ZmConstant:logger	Lorg/slf4j/Logger;
/*    */     //   60: ldc 68
/*    */     //   62: aload_2
/*    */     //   63: invokeinterface 70 3 0
/*    */     //   68: aload_1
/*    */     //   69: ifnull +7 -> 76
/*    */     //   72: aload_1
/*    */     //   73: invokevirtual 76	java/io/BufferedReader:close	()V
/*    */     //   76: aload_0
/*    */     //   77: ifnull +105 -> 182
/*    */     //   80: aload_0
/*    */     //   81: invokevirtual 79	java/io/InputStream:close	()V
/*    */     //   84: goto +98 -> 182
/*    */     //   87: astore 4
/*    */     //   89: getstatic 38	com/rongdu/cashloan/cl/model/zmxy/base/ZmConstant:logger	Lorg/slf4j/Logger;
/*    */     //   92: aload 4
/*    */     //   94: invokevirtual 82	java/io/IOException:getMessage	()Ljava/lang/String;
/*    */     //   97: aload 4
/*    */     //   99: invokeinterface 70 3 0
/*    */     //   104: goto +78 -> 182
/*    */     //   107: astore_3
/*    */     //   108: aload_1
/*    */     //   109: ifnull +7 -> 116
/*    */     //   112: aload_1
/*    */     //   113: invokevirtual 76	java/io/BufferedReader:close	()V
/*    */     //   116: aload_0
/*    */     //   117: ifnull +27 -> 144
/*    */     //   120: aload_0
/*    */     //   121: invokevirtual 79	java/io/InputStream:close	()V
/*    */     //   124: goto +20 -> 144
/*    */     //   127: astore 4
/*    */     //   129: getstatic 38	com/rongdu/cashloan/cl/model/zmxy/base/ZmConstant:logger	Lorg/slf4j/Logger;
/*    */     //   132: aload 4
/*    */     //   134: invokevirtual 82	java/io/IOException:getMessage	()Ljava/lang/String;
/*    */     //   137: aload 4
/*    */     //   139: invokeinterface 70 3 0
/*    */     //   144: aload_3
/*    */     //   145: athrow
/*    */     //   146: aload_1
/*    */     //   147: ifnull +7 -> 154
/*    */     //   150: aload_1
/*    */     //   151: invokevirtual 76	java/io/BufferedReader:close	()V
/*    */     //   154: aload_0
/*    */     //   155: ifnull +27 -> 182
/*    */     //   158: aload_0
/*    */     //   159: invokevirtual 79	java/io/InputStream:close	()V
/*    */     //   162: goto +20 -> 182
/*    */     //   165: astore 4
/*    */     //   167: getstatic 38	com/rongdu/cashloan/cl/model/zmxy/base/ZmConstant:logger	Lorg/slf4j/Logger;
/*    */     //   170: aload 4
/*    */     //   172: invokevirtual 82	java/io/IOException:getMessage	()Ljava/lang/String;
/*    */     //   175: aload 4
/*    */     //   177: invokeinterface 70 3 0
/*    */     //   182: return
/*    */     // Line number table:
/*    */     //   Java source line #17	-> byte code offset #0
/*    */     //   Java source line #31	-> byte code offset #8
/*    */     //   Java source line #34	-> byte code offset #18
/*    */     //   Java source line #35	-> byte code offset #20
/*    */     //   Java source line #37	-> byte code offset #22
/*    */     //   Java source line #38	-> byte code offset #30
/*    */     //   Java source line #39	-> byte code offset #46
/*    */     //   Java source line #40	-> byte code offset #53
/*    */     //   Java source line #41	-> byte code offset #57
/*    */     //   Java source line #44	-> byte code offset #68
/*    */     //   Java source line #45	-> byte code offset #72
/*    */     //   Java source line #47	-> byte code offset #76
/*    */     //   Java source line #48	-> byte code offset #80
/*    */     //   Java source line #50	-> byte code offset #84
/*    */     //   Java source line #51	-> byte code offset #89
/*    */     //   Java source line #42	-> byte code offset #107
/*    */     //   Java source line #44	-> byte code offset #108
/*    */     //   Java source line #45	-> byte code offset #112
/*    */     //   Java source line #47	-> byte code offset #116
/*    */     //   Java source line #48	-> byte code offset #120
/*    */     //   Java source line #50	-> byte code offset #124
/*    */     //   Java source line #51	-> byte code offset #129
/*    */     //   Java source line #53	-> byte code offset #144
/*    */     //   Java source line #44	-> byte code offset #146
/*    */     //   Java source line #45	-> byte code offset #150
/*    */     //   Java source line #47	-> byte code offset #154
/*    */     //   Java source line #48	-> byte code offset #158
/*    */     //   Java source line #50	-> byte code offset #162
/*    */     //   Java source line #51	-> byte code offset #167
/*    */     //   Java source line #54	-> byte code offset #182
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   19	140	0	inputStream	java.io.InputStream
/*    */     //   21	130	1	bf	java.io.BufferedReader
/*    */     //   56	7	2	e	java.io.IOException
/*    */     //   107	38	3	localObject	Object
/*    */     //   87	11	4	e	java.io.IOException
/*    */     //   127	11	4	e	java.io.IOException
/*    */     //   165	11	4	e	java.io.IOException
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   22	53	56	java/io/IOException
/*    */     //   68	84	87	java/io/IOException
/*    */     //   22	68	107	finally
/*    */     //   108	124	127	java/io/IOException
/*    */     //   146	162	165	java/io/IOException
/*    */   }
/*    */   
/*    */   public static String getRiskMessage(String riskCode)
/*    */   {
/* 58 */     return ZmWatchListRiskTable.getProperty(riskCode);
/*    */   }
/*    */ }
