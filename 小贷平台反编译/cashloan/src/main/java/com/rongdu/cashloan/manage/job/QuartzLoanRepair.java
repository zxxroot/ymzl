/*    */ package com.rongdu.cashloan.manage.job;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*    */ import com.rongdu.cashloan.core.domain.Borrow;
/*    */ import java.util.Date;
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
/*    */ 
/*    */ @Component
/*    */ @Lazy(false)
/*    */ public class QuartzLoanRepair
/*    */   implements Job
/*    */ {
/* 41 */   private static final Logger logger = Logger.getLogger(QuartzLoanRepair.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String profit()
/*    */   {
/* 49 */     logger.info("进入初始化人工复审任务...");
/* 50 */     ClBorrowService clBorrowService = (ClBorrowService)BeanUtil.getBean("clBorrowService");
/* 51 */     Map<String, Object> map = new HashMap();
/* 52 */     map.put("state", "26");
/* 53 */     List<Borrow> list = clBorrowService.findBorrowByMap(map);
/* 54 */     String quartzRemark = null;
/* 55 */     int succeed = 0;
/* 56 */     int fail = 0;
/* 57 */     int total = 0;
/*    */     
/* 59 */     if ((list != null) && (!list.isEmpty())) {
/* 60 */       for (Borrow bean : list) {
/*    */         try {
/* 62 */           if (bean.getId().longValue() == 16865L)
/*    */           {
/* 64 */             clBorrowService.modifyCredit(bean.getUserId(), bean.getAmount().doubleValue(), "unuse");
/*    */           }
/*    */           else
/*    */           {
/* 68 */             if ("26".equals(bean.getState())) {
/* 69 */               clBorrowService.borrowLoan(bean, new Date());
/*    */             }
/* 71 */             succeed++;
/* 72 */             total++;
/*    */           }
/* 74 */         } catch (Exception e) { fail++;
/* 75 */           total++;
/* 76 */           logger.error(e.getMessage(), e);
/*    */         }
/*    */       }
/*    */     }
/* 80 */     quartzRemark = "处理总数" + total + "个，成功" + succeed + "个，失败" + fail + "个";
/* 81 */     logger.info("修改人工复审任务，执行完毕，" + quartzRemark);
/* 82 */     return quartzRemark;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void execute(org.quartz.JobExecutionContext context)
/*    */     throws org.quartz.JobExecutionException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: ldc -68
/*    */     //   2: invokestatic 37	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   5: checkcast 190	com/rongdu/cashloan/manage/service/QuartzInfoService
/*    */     //   8: astore_2
/*    */     //   9: ldc -64
/*    */     //   11: invokestatic 37	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   14: checkcast 194	com/rongdu/cashloan/manage/service/QuartzLogService
/*    */     //   17: astore_3
/*    */     //   18: aload_2
/*    */     //   19: ldc -60
/*    */     //   21: invokeinterface 198 2 0
/*    */     //   26: astore 4
/*    */     //   28: new 202	com/rongdu/cashloan/manage/domain/QuartzLog
/*    */     //   31: dup
/*    */     //   32: invokespecial 204	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*    */     //   35: astore 5
/*    */     //   37: new 45	java/util/HashMap
/*    */     //   40: dup
/*    */     //   41: invokespecial 47	java/util/HashMap:<init>	()V
/*    */     //   44: astore 6
/*    */     //   46: aload 6
/*    */     //   48: ldc -51
/*    */     //   50: aload 4
/*    */     //   52: invokevirtual 207	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   55: invokeinterface 52 3 0
/*    */     //   60: pop
/*    */     //   61: aload 5
/*    */     //   63: aload 4
/*    */     //   65: invokevirtual 207	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   68: invokevirtual 210	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*    */     //   71: aload 5
/*    */     //   73: invokestatic 214	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   76: invokevirtual 220	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*    */     //   79: aload_0
/*    */     //   80: invokevirtual 224	com/rongdu/cashloan/manage/job/QuartzLoanRepair:profit	()Ljava/lang/String;
/*    */     //   83: astore 7
/*    */     //   85: aload 5
/*    */     //   87: aload 7
/*    */     //   89: invokevirtual 226	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*    */     //   92: aload 5
/*    */     //   94: invokestatic 214	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   97: invokevirtual 229	java/util/Date:getTime	()J
/*    */     //   100: aload 5
/*    */     //   102: invokevirtual 232	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*    */     //   105: invokevirtual 229	java/util/Date:getTime	()J
/*    */     //   108: lsub
/*    */     //   109: invokevirtual 235	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*    */     //   112: aload 5
/*    */     //   114: ldc -17
/*    */     //   116: invokevirtual 241	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   119: aload 6
/*    */     //   121: ldc -12
/*    */     //   123: aload 4
/*    */     //   125: invokevirtual 245	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*    */     //   128: invokevirtual 249	java/lang/Integer:intValue	()I
/*    */     //   131: iconst_1
/*    */     //   132: iadd
/*    */     //   133: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   136: invokeinterface 52 3 0
/*    */     //   141: pop
/*    */     //   142: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLoanRepair:logger	Lorg/apache/log4j/Logger;
/*    */     //   145: ldc_w 259
/*    */     //   148: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   151: goto +112 -> 263
/*    */     //   154: astore 7
/*    */     //   156: aload 5
/*    */     //   158: ldc_w 261
/*    */     //   161: invokevirtual 241	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   164: aload 6
/*    */     //   166: ldc_w 263
/*    */     //   169: aload 4
/*    */     //   171: invokevirtual 264	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*    */     //   174: invokevirtual 249	java/lang/Integer:intValue	()I
/*    */     //   177: iconst_1
/*    */     //   178: iadd
/*    */     //   179: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   182: invokeinterface 52 3 0
/*    */     //   187: pop
/*    */     //   188: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLoanRepair:logger	Lorg/apache/log4j/Logger;
/*    */     //   191: aload 7
/*    */     //   193: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
/*    */     //   196: aload 7
/*    */     //   198: invokevirtual 132	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*    */     //   201: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLoanRepair:logger	Lorg/apache/log4j/Logger;
/*    */     //   204: ldc_w 267
/*    */     //   207: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   210: aload_3
/*    */     //   211: aload 5
/*    */     //   213: invokeinterface 269 2 0
/*    */     //   218: pop
/*    */     //   219: aload_2
/*    */     //   220: aload 6
/*    */     //   222: invokeinterface 273 2 0
/*    */     //   227: pop
/*    */     //   228: goto +62 -> 290
/*    */     //   231: astore 8
/*    */     //   233: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLoanRepair:logger	Lorg/apache/log4j/Logger;
/*    */     //   236: ldc_w 267
/*    */     //   239: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   242: aload_3
/*    */     //   243: aload 5
/*    */     //   245: invokeinterface 269 2 0
/*    */     //   250: pop
/*    */     //   251: aload_2
/*    */     //   252: aload 6
/*    */     //   254: invokeinterface 273 2 0
/*    */     //   259: pop
/*    */     //   260: aload 8
/*    */     //   262: athrow
/*    */     //   263: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLoanRepair:logger	Lorg/apache/log4j/Logger;
/*    */     //   266: ldc_w 267
/*    */     //   269: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   272: aload_3
/*    */     //   273: aload 5
/*    */     //   275: invokeinterface 269 2 0
/*    */     //   280: pop
/*    */     //   281: aload_2
/*    */     //   282: aload 6
/*    */     //   284: invokeinterface 273 2 0
/*    */     //   289: pop
/*    */     //   290: return
/*    */     // Line number table:
/*    */     //   Java source line #89	-> byte code offset #0
/*    */     //   Java source line #90	-> byte code offset #9
/*    */     //   Java source line #92	-> byte code offset #18
/*    */     //   Java source line #93	-> byte code offset #28
/*    */     //   Java source line #94	-> byte code offset #37
/*    */     //   Java source line #95	-> byte code offset #46
/*    */     //   Java source line #96	-> byte code offset #61
/*    */     //   Java source line #97	-> byte code offset #71
/*    */     //   Java source line #100	-> byte code offset #79
/*    */     //   Java source line #101	-> byte code offset #85
/*    */     //   Java source line #102	-> byte code offset #92
/*    */     //   Java source line #103	-> byte code offset #112
/*    */     //   Java source line #104	-> byte code offset #119
/*    */     //   Java source line #105	-> byte code offset #142
/*    */     //   Java source line #106	-> byte code offset #151
/*    */     //   Java source line #107	-> byte code offset #156
/*    */     //   Java source line #108	-> byte code offset #164
/*    */     //   Java source line #109	-> byte code offset #188
/*    */     //   Java source line #111	-> byte code offset #201
/*    */     //   Java source line #112	-> byte code offset #210
/*    */     //   Java source line #113	-> byte code offset #219
/*    */     //   Java source line #110	-> byte code offset #231
/*    */     //   Java source line #111	-> byte code offset #233
/*    */     //   Java source line #112	-> byte code offset #242
/*    */     //   Java source line #113	-> byte code offset #251
/*    */     //   Java source line #114	-> byte code offset #260
/*    */     //   Java source line #111	-> byte code offset #263
/*    */     //   Java source line #112	-> byte code offset #272
/*    */     //   Java source line #113	-> byte code offset #281
/*    */     //   Java source line #116	-> byte code offset #290
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	291	0	this	QuartzLoanRepair
/*    */     //   0	291	1	context	org.quartz.JobExecutionContext
/*    */     //   8	274	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*    */     //   17	256	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*    */     //   26	144	4	quartzInfo	com.rongdu.cashloan.manage.domain.QuartzInfo
/*    */     //   35	239	5	quartzLog	com.rongdu.cashloan.manage.domain.QuartzLog
/*    */     //   44	239	6	qiData	Map<String, Object>
/*    */     //   83	5	7	remark	String
/*    */     //   154	43	7	e	Exception
/*    */     //   231	30	8	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   79	151	154	java/lang/Exception
/*    */     //   79	201	231	finally
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzLoanRepair.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */