/*    */ package com.rongdu.cashloan.manage.job;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.domain.BorrowRepay;
/*    */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.quartz.Job;
/*    */ import org.springframework.context.annotation.Lazy;
/*    */ import org.springframework.stereotype.Component;
/*    */ import tool.util.BeanUtil;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ @Lazy(false)
/*    */ public class QuartzRepayRist
/*    */   implements Job
/*    */ {
/* 39 */   private static final Logger logger = Logger.getLogger(QuartzRepayRist.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String profit()
/*    */   {
/* 47 */     logger.info("进入初始化续贷风控任务...");
/* 48 */     BorrowRepayService borrowRepayService = (BorrowRepayService)BeanUtil.getBean("borrowRepayService");
/* 49 */     String quartzRemark = null;
/* 50 */     int succeed = 0;
/* 51 */     int fail = 0;
/* 52 */     int total = 0;
/*    */     
/* 54 */     Map<String, Object> params = new HashMap();
/* 55 */     params.put("group", "group");
/* 56 */     List<BorrowRepay> borrowRepayList = borrowRepayService.listSelective(params);
/* 57 */     if ((borrowRepayList != null) && (!borrowRepayList.isEmpty())) {
/* 58 */       for (BorrowRepay borrowRepay : borrowRepayList) {
/*    */         try
/*    */         {
/* 61 */           borrowRepayService.insertRepayData(borrowRepay.getUserId());
/* 62 */           succeed++;
/* 63 */           total++;
/*    */         } catch (Exception e) {
/* 65 */           fail++;
/* 66 */           total++;
/* 67 */           logger.error(e.getMessage(), e);
/*    */         }
/*    */       }
/*    */     }
/* 71 */     quartzRemark = "处理总数" + total + "个，成功" + succeed + "个，失败" + fail + "个";
/* 72 */     logger.info("代扣还款任务，执行完毕，" + quartzRemark);
/* 73 */     return quartzRemark;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void execute(org.quartz.JobExecutionContext context)
/*    */     throws org.quartz.JobExecutionException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: ldc -107
/*    */     //   2: invokestatic 37	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   5: checkcast 151	com/rongdu/cashloan/manage/service/QuartzInfoService
/*    */     //   8: astore_2
/*    */     //   9: ldc -103
/*    */     //   11: invokestatic 37	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   14: checkcast 155	com/rongdu/cashloan/manage/service/QuartzLogService
/*    */     //   17: astore_3
/*    */     //   18: aload_2
/*    */     //   19: ldc -99
/*    */     //   21: invokeinterface 159 2 0
/*    */     //   26: astore 4
/*    */     //   28: new 163	com/rongdu/cashloan/manage/domain/QuartzLog
/*    */     //   31: dup
/*    */     //   32: invokespecial 165	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*    */     //   35: astore 5
/*    */     //   37: new 45	java/util/HashMap
/*    */     //   40: dup
/*    */     //   41: invokespecial 47	java/util/HashMap:<init>	()V
/*    */     //   44: astore 6
/*    */     //   46: aload 6
/*    */     //   48: ldc -90
/*    */     //   50: aload 4
/*    */     //   52: invokevirtual 168	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   55: invokeinterface 50 3 0
/*    */     //   60: pop
/*    */     //   61: aload 5
/*    */     //   63: aload 4
/*    */     //   65: invokevirtual 168	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   68: invokevirtual 173	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*    */     //   71: aload 5
/*    */     //   73: invokestatic 176	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   76: invokevirtual 182	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*    */     //   79: aload_0
/*    */     //   80: invokevirtual 186	com/rongdu/cashloan/manage/job/QuartzRepayRist:profit	()Ljava/lang/String;
/*    */     //   83: astore 7
/*    */     //   85: aload 5
/*    */     //   87: aload 7
/*    */     //   89: invokevirtual 188	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*    */     //   92: aload 5
/*    */     //   94: invokestatic 176	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   97: invokevirtual 191	java/util/Date:getTime	()J
/*    */     //   100: aload 5
/*    */     //   102: invokevirtual 197	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*    */     //   105: invokevirtual 191	java/util/Date:getTime	()J
/*    */     //   108: lsub
/*    */     //   109: invokevirtual 200	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*    */     //   112: aload 5
/*    */     //   114: ldc -52
/*    */     //   116: invokevirtual 206	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   119: aload 6
/*    */     //   121: ldc -47
/*    */     //   123: aload 4
/*    */     //   125: invokevirtual 210	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*    */     //   128: invokevirtual 214	java/lang/Integer:intValue	()I
/*    */     //   131: iconst_1
/*    */     //   132: iadd
/*    */     //   133: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   136: invokeinterface 50 3 0
/*    */     //   141: pop
/*    */     //   142: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRist:logger	Lorg/apache/log4j/Logger;
/*    */     //   145: ldc -32
/*    */     //   147: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   150: goto +108 -> 258
/*    */     //   153: astore 7
/*    */     //   155: aload 5
/*    */     //   157: ldc -30
/*    */     //   159: invokevirtual 206	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   162: aload 6
/*    */     //   164: ldc -28
/*    */     //   166: aload 4
/*    */     //   168: invokevirtual 229	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*    */     //   171: invokevirtual 214	java/lang/Integer:intValue	()I
/*    */     //   174: iconst_1
/*    */     //   175: iadd
/*    */     //   176: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   179: invokeinterface 50 3 0
/*    */     //   184: pop
/*    */     //   185: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRist:logger	Lorg/apache/log4j/Logger;
/*    */     //   188: aload 7
/*    */     //   190: invokevirtual 86	java/lang/Exception:getMessage	()Ljava/lang/String;
/*    */     //   193: aload 7
/*    */     //   195: invokevirtual 91	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*    */     //   198: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRist:logger	Lorg/apache/log4j/Logger;
/*    */     //   201: ldc -24
/*    */     //   203: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   206: aload_3
/*    */     //   207: aload 5
/*    */     //   209: invokeinterface 234 2 0
/*    */     //   214: pop
/*    */     //   215: aload_2
/*    */     //   216: aload 6
/*    */     //   218: invokeinterface 238 2 0
/*    */     //   223: pop
/*    */     //   224: goto +60 -> 284
/*    */     //   227: astore 8
/*    */     //   229: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRist:logger	Lorg/apache/log4j/Logger;
/*    */     //   232: ldc -24
/*    */     //   234: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   237: aload_3
/*    */     //   238: aload 5
/*    */     //   240: invokeinterface 234 2 0
/*    */     //   245: pop
/*    */     //   246: aload_2
/*    */     //   247: aload 6
/*    */     //   249: invokeinterface 238 2 0
/*    */     //   254: pop
/*    */     //   255: aload 8
/*    */     //   257: athrow
/*    */     //   258: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRist:logger	Lorg/apache/log4j/Logger;
/*    */     //   261: ldc -24
/*    */     //   263: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   266: aload_3
/*    */     //   267: aload 5
/*    */     //   269: invokeinterface 234 2 0
/*    */     //   274: pop
/*    */     //   275: aload_2
/*    */     //   276: aload 6
/*    */     //   278: invokeinterface 238 2 0
/*    */     //   283: pop
/*    */     //   284: return
/*    */     // Line number table:
/*    */     //   Java source line #80	-> byte code offset #0
/*    */     //   Java source line #81	-> byte code offset #9
/*    */     //   Java source line #83	-> byte code offset #18
/*    */     //   Java source line #84	-> byte code offset #28
/*    */     //   Java source line #85	-> byte code offset #37
/*    */     //   Java source line #86	-> byte code offset #46
/*    */     //   Java source line #87	-> byte code offset #61
/*    */     //   Java source line #88	-> byte code offset #71
/*    */     //   Java source line #91	-> byte code offset #79
/*    */     //   Java source line #92	-> byte code offset #85
/*    */     //   Java source line #93	-> byte code offset #92
/*    */     //   Java source line #94	-> byte code offset #112
/*    */     //   Java source line #95	-> byte code offset #119
/*    */     //   Java source line #96	-> byte code offset #142
/*    */     //   Java source line #97	-> byte code offset #150
/*    */     //   Java source line #98	-> byte code offset #155
/*    */     //   Java source line #99	-> byte code offset #162
/*    */     //   Java source line #100	-> byte code offset #185
/*    */     //   Java source line #102	-> byte code offset #198
/*    */     //   Java source line #103	-> byte code offset #206
/*    */     //   Java source line #104	-> byte code offset #215
/*    */     //   Java source line #101	-> byte code offset #227
/*    */     //   Java source line #102	-> byte code offset #229
/*    */     //   Java source line #103	-> byte code offset #237
/*    */     //   Java source line #104	-> byte code offset #246
/*    */     //   Java source line #105	-> byte code offset #255
/*    */     //   Java source line #102	-> byte code offset #258
/*    */     //   Java source line #103	-> byte code offset #266
/*    */     //   Java source line #104	-> byte code offset #275
/*    */     //   Java source line #107	-> byte code offset #284
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	285	0	this	QuartzRepayRist
/*    */     //   0	285	1	context	org.quartz.JobExecutionContext
/*    */     //   8	268	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*    */     //   17	250	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*    */     //   26	141	4	quartzInfo	com.rongdu.cashloan.manage.domain.QuartzInfo
/*    */     //   35	233	5	quartzLog	com.rongdu.cashloan.manage.domain.QuartzLog
/*    */     //   44	233	6	qiData	Map<String, Object>
/*    */     //   83	5	7	remark	String
/*    */     //   153	41	7	e	Exception
/*    */     //   227	29	8	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   79	150	153	java/lang/Exception
/*    */     //   79	198	227	finally
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzRepayRist.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */