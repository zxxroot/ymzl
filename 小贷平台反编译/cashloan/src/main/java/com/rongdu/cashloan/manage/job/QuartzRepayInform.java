/*    */ package com.rongdu.cashloan.manage.job;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.domain.BorrowRepay;
/*    */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*    */ import com.rongdu.cashloan.cl.service.ClSmsService;
/*    */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.quartz.Job;
/*    */ import org.springframework.context.annotation.Lazy;
/*    */ import org.springframework.stereotype.Component;
/*    */ import tool.util.BeanUtil;
/*    */ import tool.util.DateUtil;
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
/*    */ public class QuartzRepayInform
/*    */   implements Job
/*    */ {
/* 33 */   private static final Logger logger = Logger.getLogger(QuartzRepayInform.class);
/*    */   
/*    */ 
/*    */ 
/*    */   public String repayInform()
/*    */     throws ServiceException
/*    */   {
/* 40 */     BorrowRepayService borrowRepayService = (BorrowRepayService)BeanUtil.getBean("borrowRepayService");
/* 41 */     ClSmsService clSmsService = (ClSmsService)BeanUtil.getBean("clSmsService");
/*    */     
/* 43 */     logger.info("进入还款日前0~2天计算...");
/* 44 */     String quartzRemark = null;
/* 45 */     int succeed = 0;
/* 46 */     int fail = 0;
/* 47 */     int total = 0;
/* 48 */     Map<String, Object> paramMap = new HashMap();
/* 49 */     paramMap.put("state", "20");
/* 50 */     List<BorrowRepay> list = borrowRepayService.listSelective(paramMap);
/* 51 */     if (!list.isEmpty()) {
/* 52 */       for (int i = 0; i < list.size(); i++) {
/*    */         try {
/* 54 */           long day = DateUtil.daysBetween(new Date(), ((BorrowRepay)list.get(i)).getRepayTime());
/*    */           
/* 56 */           if (day == 0L) {
/* 57 */             clSmsService.repayBefore(((BorrowRepay)list.get(i)).getUserId().longValue(), ((BorrowRepay)list.get(i)).getBorrowId());
/*    */           }
/*    */           
/* 60 */           succeed++;
/* 61 */           total++;
/*    */         } catch (Exception e) {
/* 63 */           fail++;
/* 64 */           total++;
/* 65 */           logger.error(e.getMessage(), e);
/*    */         }
/*    */       }
/*    */     }
/* 69 */     logger.info("还款日前0~2天计算结束");
/* 70 */     quartzRemark = "执行总次数" + total + ",成功" + succeed + "次,失败" + fail + "次";
/* 71 */     return quartzRemark;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void execute(org.quartz.JobExecutionContext arg0)
/*    */     throws org.quartz.JobExecutionException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: ldc -80
/*    */     //   2: invokestatic 34	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   5: checkcast 178	com/rongdu/cashloan/manage/service/QuartzInfoService
/*    */     //   8: astore_2
/*    */     //   9: ldc -76
/*    */     //   11: invokestatic 34	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   14: checkcast 182	com/rongdu/cashloan/manage/service/QuartzLogService
/*    */     //   17: astore_3
/*    */     //   18: new 184	com/rongdu/cashloan/manage/domain/QuartzLog
/*    */     //   21: dup
/*    */     //   22: invokespecial 186	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*    */     //   25: astore 4
/*    */     //   27: new 52	java/util/HashMap
/*    */     //   30: dup
/*    */     //   31: invokespecial 54	java/util/HashMap:<init>	()V
/*    */     //   34: astore 5
/*    */     //   36: aload_2
/*    */     //   37: ldc -69
/*    */     //   39: invokeinterface 189 2 0
/*    */     //   44: astore 6
/*    */     //   46: aload 5
/*    */     //   48: ldc -63
/*    */     //   50: aload 6
/*    */     //   52: invokevirtual 195	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   55: invokeinterface 59 3 0
/*    */     //   60: pop
/*    */     //   61: aload 4
/*    */     //   63: aload 6
/*    */     //   65: invokevirtual 195	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   68: invokevirtual 200	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*    */     //   71: aload 4
/*    */     //   73: invokestatic 204	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   76: invokevirtual 207	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*    */     //   79: aload_0
/*    */     //   80: invokevirtual 211	com/rongdu/cashloan/manage/job/QuartzRepayInform:repayInform	()Ljava/lang/String;
/*    */     //   83: astore 7
/*    */     //   85: aload 4
/*    */     //   87: invokestatic 204	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   90: invokevirtual 213	java/util/Date:getTime	()J
/*    */     //   93: aload 4
/*    */     //   95: invokevirtual 216	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*    */     //   98: invokevirtual 213	java/util/Date:getTime	()J
/*    */     //   101: lsub
/*    */     //   102: invokevirtual 219	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*    */     //   105: aload 4
/*    */     //   107: ldc -33
/*    */     //   109: invokevirtual 225	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   112: aload 4
/*    */     //   114: aload 7
/*    */     //   116: invokevirtual 228	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*    */     //   119: aload 5
/*    */     //   121: ldc -25
/*    */     //   123: aload 6
/*    */     //   125: invokevirtual 232	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*    */     //   128: invokevirtual 236	java/lang/Integer:intValue	()I
/*    */     //   131: iconst_1
/*    */     //   132: iadd
/*    */     //   133: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   136: invokeinterface 59 3 0
/*    */     //   141: pop
/*    */     //   142: goto +108 -> 250
/*    */     //   145: astore 7
/*    */     //   147: aload 4
/*    */     //   149: ldc 57
/*    */     //   151: invokevirtual 225	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   154: aload 5
/*    */     //   156: ldc -11
/*    */     //   158: aload 6
/*    */     //   160: invokevirtual 246	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*    */     //   163: invokevirtual 236	java/lang/Integer:intValue	()I
/*    */     //   166: iconst_1
/*    */     //   167: iadd
/*    */     //   168: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   171: invokeinterface 59 3 0
/*    */     //   176: pop
/*    */     //   177: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayInform:logger	Lorg/apache/log4j/Logger;
/*    */     //   180: aload 7
/*    */     //   182: invokevirtual 111	java/lang/Exception:getMessage	()Ljava/lang/String;
/*    */     //   185: aload 7
/*    */     //   187: invokevirtual 116	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*    */     //   190: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayInform:logger	Lorg/apache/log4j/Logger;
/*    */     //   193: ldc -7
/*    */     //   195: invokevirtual 48	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   198: aload_3
/*    */     //   199: aload 4
/*    */     //   201: invokeinterface 251 2 0
/*    */     //   206: pop
/*    */     //   207: aload_2
/*    */     //   208: aload 5
/*    */     //   210: invokeinterface 255 2 0
/*    */     //   215: pop
/*    */     //   216: goto +60 -> 276
/*    */     //   219: astore 8
/*    */     //   221: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayInform:logger	Lorg/apache/log4j/Logger;
/*    */     //   224: ldc -7
/*    */     //   226: invokevirtual 48	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   229: aload_3
/*    */     //   230: aload 4
/*    */     //   232: invokeinterface 251 2 0
/*    */     //   237: pop
/*    */     //   238: aload_2
/*    */     //   239: aload 5
/*    */     //   241: invokeinterface 255 2 0
/*    */     //   246: pop
/*    */     //   247: aload 8
/*    */     //   249: athrow
/*    */     //   250: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayInform:logger	Lorg/apache/log4j/Logger;
/*    */     //   253: ldc -7
/*    */     //   255: invokevirtual 48	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   258: aload_3
/*    */     //   259: aload 4
/*    */     //   261: invokeinterface 251 2 0
/*    */     //   266: pop
/*    */     //   267: aload_2
/*    */     //   268: aload 5
/*    */     //   270: invokeinterface 255 2 0
/*    */     //   275: pop
/*    */     //   276: return
/*    */     // Line number table:
/*    */     //   Java source line #76	-> byte code offset #0
/*    */     //   Java source line #77	-> byte code offset #9
/*    */     //   Java source line #78	-> byte code offset #18
/*    */     //   Java source line #79	-> byte code offset #27
/*    */     //   Java source line #80	-> byte code offset #36
/*    */     //   Java source line #82	-> byte code offset #46
/*    */     //   Java source line #83	-> byte code offset #61
/*    */     //   Java source line #84	-> byte code offset #71
/*    */     //   Java source line #86	-> byte code offset #79
/*    */     //   Java source line #88	-> byte code offset #85
/*    */     //   Java source line #89	-> byte code offset #105
/*    */     //   Java source line #90	-> byte code offset #112
/*    */     //   Java source line #91	-> byte code offset #119
/*    */     //   Java source line #93	-> byte code offset #142
/*    */     //   Java source line #94	-> byte code offset #147
/*    */     //   Java source line #95	-> byte code offset #154
/*    */     //   Java source line #96	-> byte code offset #177
/*    */     //   Java source line #98	-> byte code offset #190
/*    */     //   Java source line #99	-> byte code offset #198
/*    */     //   Java source line #100	-> byte code offset #207
/*    */     //   Java source line #97	-> byte code offset #219
/*    */     //   Java source line #98	-> byte code offset #221
/*    */     //   Java source line #99	-> byte code offset #229
/*    */     //   Java source line #100	-> byte code offset #238
/*    */     //   Java source line #101	-> byte code offset #247
/*    */     //   Java source line #98	-> byte code offset #250
/*    */     //   Java source line #99	-> byte code offset #258
/*    */     //   Java source line #100	-> byte code offset #267
/*    */     //   Java source line #102	-> byte code offset #276
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	277	0	this	QuartzRepayInform
/*    */     //   0	277	1	arg0	org.quartz.JobExecutionContext
/*    */     //   8	260	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*    */     //   17	242	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*    */     //   25	235	4	ql	com.rongdu.cashloan.manage.domain.QuartzLog
/*    */     //   34	235	5	qiData	Map<String, Object>
/*    */     //   44	115	6	qi	com.rongdu.cashloan.manage.domain.QuartzInfo
/*    */     //   83	32	7	remark	String
/*    */     //   145	41	7	e	Exception
/*    */     //   219	29	8	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   46	142	145	java/lang/Exception
/*    */     //   46	190	219	finally
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzRepayInform.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */