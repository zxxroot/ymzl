/*    */ package com.rongdu.cashloan.manage.job;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.service.UserContactsService;
/*    */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*    */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
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
/*    */ public class QuartzContacts
/*    */   implements Job
/*    */ {
/* 40 */   private static final Logger logger = Logger.getLogger(QuartzContacts.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String profit()
/*    */   {
/* 48 */     logger.info("进入通讯录总数任务...");
/* 49 */     UserBaseInfoService userBaseInfoService = (UserBaseInfoService)BeanUtil.getBean("userBaseInfoService");
/* 50 */     UserContactsService userContactsService = (UserContactsService)BeanUtil.getBean("clUserContactsService");
/* 51 */     String quartzRemark = null;
/* 52 */     int succeed = 0;
/* 53 */     int fail = 0;
/* 54 */     int total = 0;
/*    */     
/* 56 */     List<UserBaseInfo> list = userBaseInfoService.listSelective(new HashMap());
/* 57 */     if ((list != null) && (!list.isEmpty())) {
/* 58 */       for (UserBaseInfo bean : list) {
/*    */         try {
/* 60 */           if (bean.getContactsCount().longValue() == 0L) {
/* 61 */             Map<String, Object> map = new HashMap();
/* 62 */             map.put("id", bean.getId());
/* 63 */             map.put("contactsCount", userContactsService.listContacts(bean.getUserId().longValue()) == null ? Long.valueOf(0L) : Long.valueOf(userContactsService.listContacts(bean.getUserId().longValue()).size()));
/* 64 */             userBaseInfoService.updateSelective(map);
/*    */           }
/* 66 */           succeed++;
/* 67 */           total++;
/*    */         } catch (Exception e) {
/* 69 */           fail++;
/* 70 */           total++;
/* 71 */           logger.error(e.getMessage(), e);
/*    */         }
/*    */       }
/*    */     }
/* 75 */     quartzRemark = "处理总数" + total + "个，成功" + succeed + "个，失败" + fail + "个";
/* 76 */     logger.info("修改通讯录总数任务，执行完毕，" + quartzRemark);
/* 77 */     return quartzRemark;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void execute(org.quartz.JobExecutionContext context)
/*    */     throws org.quartz.JobExecutionException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: ldc -75
/*    */     //   2: invokestatic 37	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   5: checkcast 183	com/rongdu/cashloan/manage/service/QuartzInfoService
/*    */     //   8: astore_2
/*    */     //   9: ldc -71
/*    */     //   11: invokestatic 37	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*    */     //   14: checkcast 187	com/rongdu/cashloan/manage/service/QuartzLogService
/*    */     //   17: astore_3
/*    */     //   18: aload_2
/*    */     //   19: ldc -67
/*    */     //   21: invokeinterface 191 2 0
/*    */     //   26: astore 4
/*    */     //   28: new 195	com/rongdu/cashloan/manage/domain/QuartzLog
/*    */     //   31: dup
/*    */     //   32: invokespecial 197	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*    */     //   35: astore 5
/*    */     //   37: new 49	java/util/HashMap
/*    */     //   40: dup
/*    */     //   41: invokespecial 51	java/util/HashMap:<init>	()V
/*    */     //   44: astore 6
/*    */     //   46: aload 6
/*    */     //   48: ldc 84
/*    */     //   50: aload 4
/*    */     //   52: invokevirtual 198	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   55: invokeinterface 89 3 0
/*    */     //   60: pop
/*    */     //   61: aload 5
/*    */     //   63: aload 4
/*    */     //   65: invokevirtual 198	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*    */     //   68: invokevirtual 201	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*    */     //   71: aload 5
/*    */     //   73: invokestatic 205	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   76: invokevirtual 211	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*    */     //   79: aload_0
/*    */     //   80: invokevirtual 215	com/rongdu/cashloan/manage/job/QuartzContacts:profit	()Ljava/lang/String;
/*    */     //   83: astore 7
/*    */     //   85: aload 5
/*    */     //   87: aload 7
/*    */     //   89: invokevirtual 217	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*    */     //   92: aload 5
/*    */     //   94: invokestatic 205	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*    */     //   97: invokevirtual 220	java/util/Date:getTime	()J
/*    */     //   100: aload 5
/*    */     //   102: invokevirtual 225	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*    */     //   105: invokevirtual 220	java/util/Date:getTime	()J
/*    */     //   108: lsub
/*    */     //   109: invokevirtual 228	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*    */     //   112: aload 5
/*    */     //   114: ldc -24
/*    */     //   116: invokevirtual 234	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   119: aload 6
/*    */     //   121: ldc -19
/*    */     //   123: aload 4
/*    */     //   125: invokevirtual 238	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*    */     //   128: invokevirtual 242	java/lang/Integer:intValue	()I
/*    */     //   131: iconst_1
/*    */     //   132: iadd
/*    */     //   133: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   136: invokeinterface 89 3 0
/*    */     //   141: pop
/*    */     //   142: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContacts:logger	Lorg/apache/log4j/Logger;
/*    */     //   145: ldc -6
/*    */     //   147: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   150: goto +110 -> 260
/*    */     //   153: astore 7
/*    */     //   155: aload 5
/*    */     //   157: ldc -4
/*    */     //   159: invokevirtual 234	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*    */     //   162: aload 6
/*    */     //   164: ldc -2
/*    */     //   166: aload 4
/*    */     //   168: invokevirtual 255	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*    */     //   171: invokevirtual 242	java/lang/Integer:intValue	()I
/*    */     //   174: iconst_1
/*    */     //   175: iadd
/*    */     //   176: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   179: invokeinterface 89 3 0
/*    */     //   184: pop
/*    */     //   185: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContacts:logger	Lorg/apache/log4j/Logger;
/*    */     //   188: aload 7
/*    */     //   190: invokevirtual 116	java/lang/Exception:getMessage	()Ljava/lang/String;
/*    */     //   193: aload 7
/*    */     //   195: invokevirtual 121	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*    */     //   198: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContacts:logger	Lorg/apache/log4j/Logger;
/*    */     //   201: ldc_w 258
/*    */     //   204: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   207: aload_3
/*    */     //   208: aload 5
/*    */     //   210: invokeinterface 260 2 0
/*    */     //   215: pop
/*    */     //   216: aload_2
/*    */     //   217: aload 6
/*    */     //   219: invokeinterface 264 2 0
/*    */     //   224: pop
/*    */     //   225: goto +62 -> 287
/*    */     //   228: astore 8
/*    */     //   230: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContacts:logger	Lorg/apache/log4j/Logger;
/*    */     //   233: ldc_w 258
/*    */     //   236: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   239: aload_3
/*    */     //   240: aload 5
/*    */     //   242: invokeinterface 260 2 0
/*    */     //   247: pop
/*    */     //   248: aload_2
/*    */     //   249: aload 6
/*    */     //   251: invokeinterface 264 2 0
/*    */     //   256: pop
/*    */     //   257: aload 8
/*    */     //   259: athrow
/*    */     //   260: getstatic 18	com/rongdu/cashloan/manage/job/QuartzContacts:logger	Lorg/apache/log4j/Logger;
/*    */     //   263: ldc_w 258
/*    */     //   266: invokevirtual 31	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*    */     //   269: aload_3
/*    */     //   270: aload 5
/*    */     //   272: invokeinterface 260 2 0
/*    */     //   277: pop
/*    */     //   278: aload_2
/*    */     //   279: aload 6
/*    */     //   281: invokeinterface 264 2 0
/*    */     //   286: pop
/*    */     //   287: return
/*    */     // Line number table:
/*    */     //   Java source line #84	-> byte code offset #0
/*    */     //   Java source line #85	-> byte code offset #9
/*    */     //   Java source line #87	-> byte code offset #18
/*    */     //   Java source line #88	-> byte code offset #28
/*    */     //   Java source line #89	-> byte code offset #37
/*    */     //   Java source line #90	-> byte code offset #46
/*    */     //   Java source line #91	-> byte code offset #61
/*    */     //   Java source line #92	-> byte code offset #71
/*    */     //   Java source line #95	-> byte code offset #79
/*    */     //   Java source line #96	-> byte code offset #85
/*    */     //   Java source line #97	-> byte code offset #92
/*    */     //   Java source line #98	-> byte code offset #112
/*    */     //   Java source line #99	-> byte code offset #119
/*    */     //   Java source line #100	-> byte code offset #142
/*    */     //   Java source line #101	-> byte code offset #150
/*    */     //   Java source line #102	-> byte code offset #155
/*    */     //   Java source line #103	-> byte code offset #162
/*    */     //   Java source line #104	-> byte code offset #185
/*    */     //   Java source line #106	-> byte code offset #198
/*    */     //   Java source line #107	-> byte code offset #207
/*    */     //   Java source line #108	-> byte code offset #216
/*    */     //   Java source line #105	-> byte code offset #228
/*    */     //   Java source line #106	-> byte code offset #230
/*    */     //   Java source line #107	-> byte code offset #239
/*    */     //   Java source line #108	-> byte code offset #248
/*    */     //   Java source line #109	-> byte code offset #257
/*    */     //   Java source line #106	-> byte code offset #260
/*    */     //   Java source line #107	-> byte code offset #269
/*    */     //   Java source line #108	-> byte code offset #278
/*    */     //   Java source line #111	-> byte code offset #287
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	288	0	this	QuartzContacts
/*    */     //   0	288	1	context	org.quartz.JobExecutionContext
/*    */     //   8	271	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*    */     //   17	253	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*    */     //   26	141	4	quartzInfo	com.rongdu.cashloan.manage.domain.QuartzInfo
/*    */     //   35	236	5	quartzLog	com.rongdu.cashloan.manage.domain.QuartzLog
/*    */     //   44	236	6	qiData	Map<String, Object>
/*    */     //   83	5	7	remark	String
/*    */     //   153	41	7	e	Exception
/*    */     //   228	30	8	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   79	150	153	java/lang/Exception
/*    */     //   79	198	228	finally
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzContacts.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */