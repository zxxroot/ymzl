/*    */ package com.rongdu.cashloan.manage.job;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.quartz.Job;
/*    */ import org.quartz.JobExecutionContext;
/*    */ import org.quartz.JobExecutionException;
/*    */ import org.springframework.context.annotation.Lazy;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ @Lazy(false)
/*    */ public class QuartzContactCount
/*    */   implements Job
/*    */ {
/* 29 */   private static final Logger logger = Logger.getLogger(QuartzContactCount.class);
/*    */   
/*    */   /* Error */
/*    */   public void count()
/*    */     throws ServiceException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: iconst_0
/*    */     //   1: istore_1
/*    */     //   2: ldc 31
/*    */     //   4: invokestatic 33	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   7: checkcast 39	com/rongdu/cashloan/rc/service/ContactCountService
/*    */     //   10: astore_2
/*    */     //   11: ldc 41
/*    */     //   13: invokestatic 33	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   16: checkcast 43	com/rongdu/cashloan/manage/service/QuartzInfoService
/*    */     //   19: astore_3
/*    */     //   20: ldc 45
/*    */     //   22: invokestatic 33	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   25: checkcast 47	com/rongdu/cashloan/manage/service/QuartzLogService
/*    */     //   28: astore 4
/*    */     //   30: new 49	com/rongdu/cashloan/manage/domain/QuartzLog
/*    */     //   33: dup
/*    */     //   34: invokespecial 51	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*    */     //   37: astore 5
/*    */     //   39: aload_3
/*    */     //   40: ldc 52
/*    */     //   42: invokeinterface 54 2 0
/*    */     //   47: astore 6
/*    */     //   49: new 58	java/util/HashMap
/*    */     //   52: dup
/*    */     //   53: invokespecial 60	java/util/HashMap:<init>	()V
/*    */     //   56: astore 7
/*    */     //   58: aload 7
/*    */     //   60: ldc 61
/*    */     //   62: aload 6
/*    */     //   64: invokevirtual 63	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   67: invokeinterface 69 3 0
/*    */     //   72: pop
/*    */     //   73: aload 5
/*    */     //   75: aload 6
/*    */     //   77: invokevirtual 63	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   80: invokevirtual 75	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*    */     //   83: aload 5
/*    */     //   85: invokestatic 79	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   88: invokevirtual 85	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*    */     //   91: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContactCount:logger	Lorg/apache/log4j/Logger;
/*    */     //   94: ldc 89
/*    */     //   96: invokevirtual 91	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   99: aload_2
/*    */     //   100: invokeinterface 95 1 0
/*    */     //   105: istore_1
/*    */     //   106: iload_1
/*    */     //   107: iconst_1
/*    */     //   108: if_icmpge +71 -> 179
/*    */     //   111: aload 5
/*    */     //   113: invokestatic 79	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   116: invokevirtual 99	java/util/Date:getTime	()J
/*    */     //   119: aload 5
/*    */     //   121: invokevirtual 105	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*    */     //   124: invokevirtual 99	java/util/Date:getTime	()J
/*    */     //   127: lsub
/*    */     //   128: invokevirtual 108	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*    */     //   131: aload 5
/*    */     //   133: ldc 112
/*    */     //   135: invokevirtual 114	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   138: aload 5
/*    */     //   140: ldc 118
/*    */     //   142: invokevirtual 120	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*    */     //   145: aload 7
/*    */     //   147: ldc 123
/*    */     //   149: aload 6
/*    */     //   151: invokevirtual 125	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*    */     //   154: invokevirtual 129	java/lang/Integer:intValue	()I
/*    */     //   157: iconst_1
/*    */     //   158: iadd
/*    */     //   159: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   162: invokeinterface 69 3 0
/*    */     //   167: pop
/*    */     //   168: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContactCount:logger	Lorg/apache/log4j/Logger;
/*    */     //   171: ldc -118
/*    */     //   173: invokevirtual 140	org/apache/log4j/Logger:error	(Ljava/lang/Object;)V
/*    */     //   176: goto +60 -> 236
/*    */     //   179: aload 5
/*    */     //   181: invokestatic 79	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   184: invokevirtual 99	java/util/Date:getTime	()J
/*    */     //   187: aload 5
/*    */     //   189: invokevirtual 105	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*    */     //   192: invokevirtual 99	java/util/Date:getTime	()J
/*    */     //   195: lsub
/*    */     //   196: invokevirtual 108	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*    */     //   199: aload 5
/*    */     //   201: ldc -113
/*    */     //   203: invokevirtual 114	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   206: aload 5
/*    */     //   208: ldc -111
/*    */     //   210: invokevirtual 120	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*    */     //   213: aload 7
/*    */     //   215: ldc 123
/*    */     //   217: aload 6
/*    */     //   219: invokevirtual 147	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*    */     //   222: invokevirtual 129	java/lang/Integer:intValue	()I
/*    */     //   225: iconst_1
/*    */     //   226: iadd
/*    */     //   227: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   230: invokeinterface 69 3 0
/*    */     //   235: pop
/*    */     //   236: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContactCount:logger	Lorg/apache/log4j/Logger;
/*    */     //   239: ldc -106
/*    */     //   241: invokevirtual 91	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   244: goto +129 -> 373
/*    */     //   247: astore 8
/*    */     //   249: aload 5
/*    */     //   251: invokestatic 79	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   254: invokevirtual 99	java/util/Date:getTime	()J
/*    */     //   257: aload 5
/*    */     //   259: invokevirtual 105	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*    */     //   262: invokevirtual 99	java/util/Date:getTime	()J
/*    */     //   265: lsub
/*    */     //   266: invokevirtual 108	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*    */     //   269: aload 5
/*    */     //   271: ldc 112
/*    */     //   273: invokevirtual 114	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   276: aload 5
/*    */     //   278: ldc 118
/*    */     //   280: invokevirtual 120	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*    */     //   283: aload 7
/*    */     //   285: ldc 123
/*    */     //   287: aload 6
/*    */     //   289: invokevirtual 125	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*    */     //   292: invokevirtual 129	java/lang/Integer:intValue	()I
/*    */     //   295: iconst_1
/*    */     //   296: iadd
/*    */     //   297: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   300: invokeinterface 69 3 0
/*    */     //   305: pop
/*    */     //   306: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContactCount:logger	Lorg/apache/log4j/Logger;
/*    */     //   309: ldc -118
/*    */     //   311: invokevirtual 140	org/apache/log4j/Logger:error	(Ljava/lang/Object;)V
/*    */     //   314: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContactCount:logger	Lorg/apache/log4j/Logger;
/*    */     //   317: aload 8
/*    */     //   319: invokevirtual 152	java/lang/Exception:getMessage	()Ljava/lang/String;
/*    */     //   322: aload 8
/*    */     //   324: invokevirtual 158	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*    */     //   327: aload 4
/*    */     //   329: aload 5
/*    */     //   331: invokeinterface 161 2 0
/*    */     //   336: pop
/*    */     //   337: aload_3
/*    */     //   338: aload 7
/*    */     //   340: invokeinterface 164 2 0
/*    */     //   345: pop
/*    */     //   346: goto +46 -> 392
/*    */     //   349: astore 9
/*    */     //   351: aload 4
/*    */     //   353: aload 5
/*    */     //   355: invokeinterface 161 2 0
/*    */     //   360: pop
/*    */     //   361: aload_3
/*    */     //   362: aload 7
/*    */     //   364: invokeinterface 164 2 0
/*    */     //   369: pop
/*    */     //   370: aload 9
/*    */     //   372: athrow
/*    */     //   373: aload 4
/*    */     //   375: aload 5
/*    */     //   377: invokeinterface 161 2 0
/*    */     //   382: pop
/*    */     //   383: aload_3
/*    */     //   384: aload 7
/*    */     //   386: invokeinterface 164 2 0
/*    */     //   391: pop
/*    */     //   392: return
/*    */     // Line number table:
/*    */     //   Java source line #36	-> byte code offset #0
/*    */     //   Java source line #37	-> byte code offset #2
/*    */     //   Java source line #38	-> byte code offset #11
/*    */     //   Java source line #39	-> byte code offset #20
/*    */     //   Java source line #41	-> byte code offset #30
/*    */     //   Java source line #42	-> byte code offset #39
/*    */     //   Java source line #43	-> byte code offset #49
/*    */     //   Java source line #44	-> byte code offset #58
/*    */     //   Java source line #46	-> byte code offset #73
/*    */     //   Java source line #47	-> byte code offset #83
/*    */     //   Java source line #50	-> byte code offset #91
/*    */     //   Java source line #51	-> byte code offset #99
/*    */     //   Java source line #52	-> byte code offset #106
/*    */     //   Java source line #53	-> byte code offset #111
/*    */     //   Java source line #54	-> byte code offset #131
/*    */     //   Java source line #55	-> byte code offset #138
/*    */     //   Java source line #56	-> byte code offset #145
/*    */     //   Java source line #57	-> byte code offset #168
/*    */     //   Java source line #58	-> byte code offset #176
/*    */     //   Java source line #59	-> byte code offset #179
/*    */     //   Java source line #60	-> byte code offset #199
/*    */     //   Java source line #61	-> byte code offset #206
/*    */     //   Java source line #62	-> byte code offset #213
/*    */     //   Java source line #65	-> byte code offset #236
/*    */     //   Java source line #66	-> byte code offset #244
/*    */     //   Java source line #67	-> byte code offset #249
/*    */     //   Java source line #68	-> byte code offset #269
/*    */     //   Java source line #69	-> byte code offset #276
/*    */     //   Java source line #70	-> byte code offset #283
/*    */     //   Java source line #71	-> byte code offset #306
/*    */     //   Java source line #72	-> byte code offset #314
/*    */     //   Java source line #74	-> byte code offset #327
/*    */     //   Java source line #75	-> byte code offset #337
/*    */     //   Java source line #73	-> byte code offset #349
/*    */     //   Java source line #74	-> byte code offset #351
/*    */     //   Java source line #75	-> byte code offset #361
/*    */     //   Java source line #76	-> byte code offset #370
/*    */     //   Java source line #74	-> byte code offset #373
/*    */     //   Java source line #75	-> byte code offset #383
/*    */     //   Java source line #77	-> byte code offset #392
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	393	0	this	QuartzContactCount
/*    */     //   1	106	1	msg	int
/*    */     //   10	90	2	contactCountService	com.rongdu.cashloan.rc.service.ContactCountService
/*    */     //   19	365	3	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*    */     //   28	346	4	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*    */     //   37	339	5	ql	com.rongdu.cashloan.manage.domain.QuartzLog
/*    */     //   47	241	6	qi	com.rongdu.cashloan.manage.domain.QuartzInfo
/*    */     //   56	329	7	qiData	java.util.Map<String, Object>
/*    */     //   247	76	8	e	Exception
/*    */     //   349	22	9	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   91	244	247	java/lang/Exception
/*    */     //   91	327	349	finally
/*    */   }
/*    */   
/*    */   public void execute(JobExecutionContext context)
/*    */     throws JobExecutionException
/*    */   {
/*    */     try
/*    */     {
/* 83 */       count();
/*    */     } catch (ServiceException e) {
/* 85 */       logger.error(e.getMessage(), e);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzContactCount.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */