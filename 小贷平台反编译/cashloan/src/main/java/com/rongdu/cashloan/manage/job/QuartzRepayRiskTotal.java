/*    */ package com.rongdu.cashloan.manage.job;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.domain.BorrowRiskData;
/*    */ import com.rongdu.cashloan.cl.service.BorrowRiskDataService;
/*    */ import com.rongdu.cashloan.cl.service.ClBorrowService;
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
/*    */ public class QuartzRepayRiskTotal
/*    */   implements Job
/*    */ {
/* 40 */   private static final Logger logger = Logger.getLogger(QuartzRepayRiskTotal.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String profit()
/*    */   {
/* 48 */     logger.info("进入修改续贷表中的借款总数、借款成功次数、借款失败次数任务...");
/* 49 */     BorrowRiskDataService borrowRiskDataService = (BorrowRiskDataService)BeanUtil.getBean("borrowRiskDataService");
/* 50 */     ClBorrowService clBorrowService = (ClBorrowService)BeanUtil.getBean("clBorrowService");
/* 51 */     String quartzRemark = null;
/* 52 */     int succeed = 0;
/* 53 */     int fail = 0;
/* 54 */     int total = 0;
/*    */     
/* 56 */     List<BorrowRiskData> list = borrowRiskDataService.listSelective(new HashMap());
/* 57 */     if ((list != null) && (!list.isEmpty())) {
/* 58 */       for (BorrowRiskData borrowRiskData : list) {
/*    */         try
/*    */         {
/* 61 */           Map<String, Long> countMap = clBorrowService.countRiskBorrow(borrowRiskData.getUserId());
/* 62 */           if (countMap != null) {
/* 63 */             borrowRiskData.setLoanCount((Long)countMap.get("count"));
/* 64 */             borrowRiskData.setLoanSuCount((Long)countMap.get("suc_count"));
/* 65 */             borrowRiskData.setLoanFailCount((Long)countMap.get("ref_count"));
/* 66 */             borrowRiskDataService.updateById(borrowRiskData);
/*    */           }
/* 68 */           succeed++;
/* 69 */           total++;
/*    */         } catch (Exception e) {
/* 71 */           fail++;
/* 72 */           total++;
/* 73 */           logger.error(e.getMessage(), e);
/*    */         }
/*    */       }
/*    */     }
/* 77 */     quartzRemark = "处理总数" + total + "个，成功" + succeed + "个，失败" + fail + "个";
/* 78 */     logger.info("修改续贷表中的借款总数、借款成功次数、借款失败次数任务，执行完毕，" + quartzRemark);
/* 79 */     return quartzRemark;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void execute(org.quartz.JobExecutionContext context)
/*    */     throws org.quartz.JobExecutionException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: ldc -82
/*    */     //   2: invokestatic 37	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   5: checkcast 176	com/rongdu/cashloan/manage/service/QuartzInfoService
/*    */     //   8: astore_2
/*    */     //   9: ldc -78
/*    */     //   11: invokestatic 37	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   14: checkcast 180	com/rongdu/cashloan/manage/service/QuartzLogService
/*    */     //   17: astore_3
/*    */     //   18: aload_2
/*    */     //   19: ldc -74
/*    */     //   21: invokeinterface 184 2 0
/*    */     //   26: astore 4
/*    */     //   28: new 188	com/rongdu/cashloan/manage/domain/QuartzLog
/*    */     //   31: dup
/*    */     //   32: invokespecial 190	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*    */     //   35: astore 5
/*    */     //   37: new 49	java/util/HashMap
/*    */     //   40: dup
/*    */     //   41: invokespecial 51	java/util/HashMap:<init>	()V
/*    */     //   44: astore 6
/*    */     //   46: aload 6
/*    */     //   48: ldc -65
/*    */     //   50: aload 4
/*    */     //   52: invokevirtual 193	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   55: invokeinterface 198 3 0
/*    */     //   60: pop
/*    */     //   61: aload 5
/*    */     //   63: aload 4
/*    */     //   65: invokevirtual 193	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   68: invokevirtual 202	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*    */     //   71: aload 5
/*    */     //   73: invokestatic 205	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   76: invokevirtual 211	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*    */     //   79: aload_0
/*    */     //   80: invokevirtual 215	com/rongdu/cashloan/manage/job/QuartzRepayRiskTotal:profit	()Ljava/lang/String;
/*    */     //   83: astore 7
/*    */     //   85: aload 5
/*    */     //   87: aload 7
/*    */     //   89: invokevirtual 217	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*    */     //   92: aload 5
/*    */     //   94: invokestatic 205	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   97: invokevirtual 220	java/util/Date:getTime	()J
/*    */     //   100: aload 5
/*    */     //   102: invokevirtual 226	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*    */     //   105: invokevirtual 220	java/util/Date:getTime	()J
/*    */     //   108: lsub
/*    */     //   109: invokevirtual 229	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*    */     //   112: aload 5
/*    */     //   114: ldc -23
/*    */     //   116: invokevirtual 235	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   119: aload 6
/*    */     //   121: ldc -18
/*    */     //   123: aload 4
/*    */     //   125: invokevirtual 239	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*    */     //   128: invokevirtual 243	java/lang/Integer:intValue	()I
/*    */     //   131: iconst_1
/*    */     //   132: iadd
/*    */     //   133: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   136: invokeinterface 198 3 0
/*    */     //   141: pop
/*    */     //   142: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRiskTotal:logger	Lorg/apache/log4j/Logger;
/*    */     //   145: ldc -3
/*    */     //   147: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   150: goto +111 -> 261
/*    */     //   153: astore 7
/*    */     //   155: aload 5
/*    */     //   157: ldc -1
/*    */     //   159: invokevirtual 235	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   162: aload 6
/*    */     //   164: ldc_w 257
/*    */     //   167: aload 4
/*    */     //   169: invokevirtual 258	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*    */     //   172: invokevirtual 243	java/lang/Integer:intValue	()I
/*    */     //   175: iconst_1
/*    */     //   176: iadd
/*    */     //   177: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   180: invokeinterface 198 3 0
/*    */     //   185: pop
/*    */     //   186: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRiskTotal:logger	Lorg/apache/log4j/Logger;
/*    */     //   189: aload 7
/*    */     //   191: invokevirtual 110	java/lang/Exception:getMessage	()Ljava/lang/String;
/*    */     //   194: aload 7
/*    */     //   196: invokevirtual 115	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*    */     //   199: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRiskTotal:logger	Lorg/apache/log4j/Logger;
/*    */     //   202: ldc_w 261
/*    */     //   205: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   208: aload_3
/*    */     //   209: aload 5
/*    */     //   211: invokeinterface 263 2 0
/*    */     //   216: pop
/*    */     //   217: aload_2
/*    */     //   218: aload 6
/*    */     //   220: invokeinterface 267 2 0
/*    */     //   225: pop
/*    */     //   226: goto +62 -> 288
/*    */     //   229: astore 8
/*    */     //   231: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRiskTotal:logger	Lorg/apache/log4j/Logger;
/*    */     //   234: ldc_w 261
/*    */     //   237: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   240: aload_3
/*    */     //   241: aload 5
/*    */     //   243: invokeinterface 263 2 0
/*    */     //   248: pop
/*    */     //   249: aload_2
/*    */     //   250: aload 6
/*    */     //   252: invokeinterface 267 2 0
/*    */     //   257: pop
/*    */     //   258: aload 8
/*    */     //   260: athrow
/*    */     //   261: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayRiskTotal:logger	Lorg/apache/log4j/Logger;
/*    */     //   264: ldc_w 261
/*    */     //   267: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   270: aload_3
/*    */     //   271: aload 5
/*    */     //   273: invokeinterface 263 2 0
/*    */     //   278: pop
/*    */     //   279: aload_2
/*    */     //   280: aload 6
/*    */     //   282: invokeinterface 267 2 0
/*    */     //   287: pop
/*    */     //   288: return
/*    */     // Line number table:
/*    */     //   Java source line #86	-> byte code offset #0
/*    */     //   Java source line #87	-> byte code offset #9
/*    */     //   Java source line #89	-> byte code offset #18
/*    */     //   Java source line #90	-> byte code offset #28
/*    */     //   Java source line #91	-> byte code offset #37
/*    */     //   Java source line #92	-> byte code offset #46
/*    */     //   Java source line #93	-> byte code offset #61
/*    */     //   Java source line #94	-> byte code offset #71
/*    */     //   Java source line #97	-> byte code offset #79
/*    */     //   Java source line #98	-> byte code offset #85
/*    */     //   Java source line #99	-> byte code offset #92
/*    */     //   Java source line #100	-> byte code offset #112
/*    */     //   Java source line #101	-> byte code offset #119
/*    */     //   Java source line #102	-> byte code offset #142
/*    */     //   Java source line #103	-> byte code offset #150
/*    */     //   Java source line #104	-> byte code offset #155
/*    */     //   Java source line #105	-> byte code offset #162
/*    */     //   Java source line #106	-> byte code offset #186
/*    */     //   Java source line #108	-> byte code offset #199
/*    */     //   Java source line #109	-> byte code offset #208
/*    */     //   Java source line #110	-> byte code offset #217
/*    */     //   Java source line #107	-> byte code offset #229
/*    */     //   Java source line #108	-> byte code offset #231
/*    */     //   Java source line #109	-> byte code offset #240
/*    */     //   Java source line #110	-> byte code offset #249
/*    */     //   Java source line #111	-> byte code offset #258
/*    */     //   Java source line #108	-> byte code offset #261
/*    */     //   Java source line #109	-> byte code offset #270
/*    */     //   Java source line #110	-> byte code offset #279
/*    */     //   Java source line #113	-> byte code offset #288
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	289	0	this	QuartzRepayRiskTotal
/*    */     //   0	289	1	context	org.quartz.JobExecutionContext
/*    */     //   8	272	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*    */     //   17	254	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*    */     //   26	142	4	quartzInfo	com.rongdu.cashloan.manage.domain.QuartzInfo
/*    */     //   35	237	5	quartzLog	com.rongdu.cashloan.manage.domain.QuartzLog
/*    */     //   44	237	6	qiData	Map<String, Object>
/*    */     //   83	5	7	remark	String
/*    */     //   153	42	7	e	Exception
/*    */     //   229	30	8	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   79	150	153	java/lang/Exception
/*    */     //   79	199	229	finally
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzRepayRiskTotal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */