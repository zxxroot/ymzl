package com.rongdu.cashloan.manage.job;

import com.rongdu.cashloan.cl.service.ChannelSettlementService;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import tool.util.BeanUtil;

@Component
@Lazy(false)
public class QuartzChannelSettlement
        implements Job {
    private static final Logger logger = Logger.getLogger(QuartzChannelSettlement.class);


    public String channelSettlement()
            throws ServiceException {
        ChannelSettlementService channelSettlementService = (ChannelSettlementService) BeanUtil.getBean("channelSettlementService");
        logger.info("统计每月渠道注册...");
        String quartzRemark = "失败";
        boolean settlement = channelSettlementService.channelSettlementGenerate();
        if (settlement) {
            logger.info("每月渠道注册插入成功");
            quartzRemark = "成功";
        }
        return quartzRemark;
    }

    /* Error */
    public void execute(org.quartz.JobExecutionContext arg0)
            throws org.quartz.JobExecutionException {
        // Byte code:
        //   0: ldc 70
        //   2: invokestatic 34	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
        //   5: checkcast 72	com/rongdu/cashloan/manage/service/QuartzInfoService
        //   8: astore_2
        //   9: ldc 74
        //   11: invokestatic 34	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
        //   14: checkcast 76	com/rongdu/cashloan/manage/service/QuartzLogService
        //   17: astore_3
        //   18: new 78	com/rongdu/cashloan/manage/domain/QuartzLog
        //   21: dup
        //   22: invokespecial 80	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
        //   25: astore 4
        //   27: new 81	java/util/HashMap
        //   30: dup
        //   31: invokespecial 83	java/util/HashMap:<init>	()V
        //   34: astore 5
        //   36: aload_2
        //   37: ldc 84
        //   39: invokeinterface 86 2 0
        //   44: astore 6
        //   46: aload 5
        //   48: ldc 90
        //   50: aload 6
        //   52: invokevirtual 92	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
        //   55: invokeinterface 98 3 0
        //   60: pop
        //   61: aload 4
        //   63: aload 6
        //   65: invokevirtual 92	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
        //   68: invokevirtual 104	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
        //   71: aload 4
        //   73: invokestatic 108	tool/util/DateUtil:getNow	()Ljava/util/Date;
        //   76: invokevirtual 114	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
        //   79: aload_0
        //   80: invokevirtual 118	com/rongdu/cashloan/manage/job/QuartzChannelSettlement:channelSettlement	()Ljava/lang/String;
        //   83: astore 7
        //   85: aload 4
        //   87: invokestatic 108	tool/util/DateUtil:getNow	()Ljava/util/Date;
        //   90: invokevirtual 120	java/util/Date:getTime	()J
        //   93: aload 4
        //   95: invokevirtual 126	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
        //   98: invokevirtual 120	java/util/Date:getTime	()J
        //   101: lsub
        //   102: invokevirtual 129	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
        //   105: aload 4
        //   107: ldc -123
        //   109: invokevirtual 135	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
        //   112: aload 4
        //   114: aload 7
        //   116: invokevirtual 139	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
        //   119: aload 5
        //   121: ldc -114
        //   123: aload 6
        //   125: invokevirtual 144	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
        //   128: invokevirtual 148	java/lang/Integer:intValue	()I
        //   131: iconst_1
        //   132: iadd
        //   133: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   136: invokeinterface 98 3 0
        //   141: pop
        //   142: goto +108 -> 250
        //   145: astore 7
        //   147: aload 4
        //   149: ldc -98
        //   151: invokevirtual 135	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
        //   154: aload 5
        //   156: ldc -96
        //   158: aload 6
        //   160: invokevirtual 162	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
        //   163: invokevirtual 148	java/lang/Integer:intValue	()I
        //   166: iconst_1
        //   167: iadd
        //   168: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   171: invokeinterface 98 3 0
        //   176: pop
        //   177: getstatic 18	com/rongdu/cashloan/manage/job/QuartzChannelSettlement:logger	Lorg/apache/log4j/Logger;
        //   180: aload 7
        //   182: invokevirtual 165	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   185: aload 7
        //   187: invokevirtual 170	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
        //   190: getstatic 18	com/rongdu/cashloan/manage/job/QuartzChannelSettlement:logger	Lorg/apache/log4j/Logger;
        //   193: ldc -82
        //   195: invokevirtual 44	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
        //   198: aload_3
        //   199: aload 4
        //   201: invokeinterface 176 2 0
        //   206: pop
        //   207: aload_2
        //   208: aload 5
        //   210: invokeinterface 180 2 0
        //   215: pop
        //   216: goto +60 -> 276
        //   219: astore 8
        //   221: getstatic 18	com/rongdu/cashloan/manage/job/QuartzChannelSettlement:logger	Lorg/apache/log4j/Logger;
        //   224: ldc -82
        //   226: invokevirtual 44	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
        //   229: aload_3
        //   230: aload 4
        //   232: invokeinterface 176 2 0
        //   237: pop
        //   238: aload_2
        //   239: aload 5
        //   241: invokeinterface 180 2 0
        //   246: pop
        //   247: aload 8
        //   249: athrow
        //   250: getstatic 18	com/rongdu/cashloan/manage/job/QuartzChannelSettlement:logger	Lorg/apache/log4j/Logger;
        //   253: ldc -82
        //   255: invokevirtual 44	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
        //   258: aload_3
        //   259: aload 4
        //   261: invokeinterface 176 2 0
        //   266: pop
        //   267: aload_2
        //   268: aload 5
        //   270: invokeinterface 180 2 0
        //   275: pop
        //   276: return
        // Line number table:
        //   Java source line #48	-> byte code offset #0
        //   Java source line #49	-> byte code offset #9
        //   Java source line #50	-> byte code offset #18
        //   Java source line #51	-> byte code offset #27
        //   Java source line #52	-> byte code offset #36
        //   Java source line #54	-> byte code offset #46
        //   Java source line #55	-> byte code offset #61
        //   Java source line #56	-> byte code offset #71
        //   Java source line #58	-> byte code offset #79
        //   Java source line #60	-> byte code offset #85
        //   Java source line #61	-> byte code offset #105
        //   Java source line #62	-> byte code offset #112
        //   Java source line #63	-> byte code offset #119
        //   Java source line #65	-> byte code offset #142
        //   Java source line #66	-> byte code offset #147
        //   Java source line #67	-> byte code offset #154
        //   Java source line #68	-> byte code offset #177
        //   Java source line #70	-> byte code offset #190
        //   Java source line #71	-> byte code offset #198
        //   Java source line #72	-> byte code offset #207
        //   Java source line #69	-> byte code offset #219
        //   Java source line #70	-> byte code offset #221
        //   Java source line #71	-> byte code offset #229
        //   Java source line #72	-> byte code offset #238
        //   Java source line #73	-> byte code offset #247
        //   Java source line #70	-> byte code offset #250
        //   Java source line #71	-> byte code offset #258
        //   Java source line #72	-> byte code offset #267
        //   Java source line #74	-> byte code offset #276
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	277	0	this	QuartzChannelSettlement
        //   0	277	1	arg0	org.quartz.JobExecutionContext
        //   8	260	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
        //   17	242	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
        //   25	235	4	ql	com.rongdu.cashloan.manage.domain.QuartzLog
        //   34	235	5	qiData	java.util.Map<String, Object>
        //   44	115	6	qi	com.rongdu.cashloan.manage.domain.QuartzInfo
        //   83	32	7	remark	String
        //   145	41	7	e	Exception
        //   219	29	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   46	142	145	java/lang/Exception
        //   46	190	219	finally
    }
}
