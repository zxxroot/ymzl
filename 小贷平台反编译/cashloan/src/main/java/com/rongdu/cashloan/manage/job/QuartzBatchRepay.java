/*     */ package com.rongdu.cashloan.manage.job;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.alipay.api.AlipayClient;
/*     */ import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
/*     */ import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
/*     */ import com.rongdu.cashloan.cl.model.AlipayDownLoanFile;
/*     */ import com.rongdu.cashloan.cl.model.AlipayDownloadUrlQueryModel;
/*     */ import com.rongdu.cashloan.cl.model.AlipayModel;
/*     */ import com.rongdu.cashloan.cl.model.BaseAliPayModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageBRepayModel;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.quartz.Job;
/*     */ import org.quartz.JobExecutionContext;
/*     */ import org.quartz.JobExecutionException;
/*     */ import org.springframework.context.annotation.Lazy;
/*     */ import org.springframework.stereotype.Component;
/*     */ import tool.util.BeanUtil;
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
/*     */ @Component
/*     */ @Lazy(false)
/*     */ public class QuartzBatchRepay
/*     */   implements Job
/*     */ {
/*  43 */   private static final Logger logger = Logger.getLogger(QuartzBatchRepay.class);
/*     */   
/*     */   /* Error */
/*     */   public void queryUserZmScore()
/*     */     throws ServiceException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_1
/*     */     //   2: ldc 31
/*     */     //   4: invokestatic 33	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   7: checkcast 39	com/rongdu/cashloan/manage/service/QuartzInfoService
/*     */     //   10: astore_2
/*     */     //   11: ldc 41
/*     */     //   13: invokestatic 33	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   16: checkcast 43	com/rongdu/cashloan/manage/service/QuartzLogService
/*     */     //   19: astore_3
/*     */     //   20: new 45	com/rongdu/cashloan/manage/domain/QuartzLog
/*     */     //   23: dup
/*     */     //   24: invokespecial 47	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*     */     //   27: astore 4
/*     */     //   29: aload_2
/*     */     //   30: ldc 48
/*     */     //   32: invokeinterface 50 2 0
/*     */     //   37: astore 5
/*     */     //   39: new 54	java/util/HashMap
/*     */     //   42: dup
/*     */     //   43: invokespecial 56	java/util/HashMap:<init>	()V
/*     */     //   46: astore 6
/*     */     //   48: aload 6
/*     */     //   50: ldc 57
/*     */     //   52: aload 5
/*     */     //   54: invokevirtual 59	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   57: invokeinterface 65 3 0
/*     */     //   62: pop
/*     */     //   63: aload 4
/*     */     //   65: aload 5
/*     */     //   67: invokevirtual 59	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   70: invokevirtual 71	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*     */     //   73: aload 4
/*     */     //   75: invokestatic 75	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   78: invokevirtual 81	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*     */     //   81: getstatic 18	com/rongdu/cashloan/manage/job/QuartzBatchRepay:logger	Lorg/apache/log4j/Logger;
/*     */     //   84: ldc 85
/*     */     //   86: invokevirtual 87	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   89: new 91	com/rongdu/cashloan/cl/model/AlipayDownloadUrlQueryModel
/*     */     //   92: dup
/*     */     //   93: invokespecial 93	com/rongdu/cashloan/cl/model/AlipayDownloadUrlQueryModel:<init>	()V
/*     */     //   96: astore 7
/*     */     //   98: new 94	java/util/Date
/*     */     //   101: dup
/*     */     //   102: invokespecial 96	java/util/Date:<init>	()V
/*     */     //   105: astore 8
/*     */     //   107: invokestatic 97	java/util/Calendar:getInstance	()Ljava/util/Calendar;
/*     */     //   110: astore 9
/*     */     //   112: aload 9
/*     */     //   114: aload 8
/*     */     //   116: invokevirtual 103	java/util/Calendar:setTime	(Ljava/util/Date;)V
/*     */     //   119: aload 9
/*     */     //   121: iconst_5
/*     */     //   122: aload 9
/*     */     //   124: iconst_5
/*     */     //   125: invokevirtual 106	java/util/Calendar:get	(I)I
/*     */     //   128: iconst_1
/*     */     //   129: isub
/*     */     //   130: invokevirtual 110	java/util/Calendar:set	(II)V
/*     */     //   133: new 114	java/text/SimpleDateFormat
/*     */     //   136: dup
/*     */     //   137: ldc 116
/*     */     //   139: invokespecial 118	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
/*     */     //   142: astore 10
/*     */     //   144: aload 10
/*     */     //   146: aload 10
/*     */     //   148: aload 9
/*     */     //   150: invokevirtual 121	java/util/Calendar:getTime	()Ljava/util/Date;
/*     */     //   153: invokevirtual 124	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
/*     */     //   156: invokevirtual 128	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
/*     */     //   159: astore 11
/*     */     //   161: aload 10
/*     */     //   163: aload 11
/*     */     //   165: invokevirtual 124	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
/*     */     //   168: astore 12
/*     */     //   170: aload 7
/*     */     //   172: aload 12
/*     */     //   174: invokevirtual 132	com/rongdu/cashloan/cl/model/AlipayDownloadUrlQueryModel:setBill_date	(Ljava/lang/String;)V
/*     */     //   177: aload_0
/*     */     //   178: aload 7
/*     */     //   180: invokevirtual 135	com/rongdu/cashloan/manage/job/QuartzBatchRepay:alipayQuery	(Lcom/rongdu/cashloan/cl/model/AlipayDownloadUrlQueryModel;)I
/*     */     //   183: istore_1
/*     */     //   184: iload_1
/*     */     //   185: iconst_1
/*     */     //   186: if_icmpge +64 -> 250
/*     */     //   189: aload 4
/*     */     //   191: invokestatic 75	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   194: invokevirtual 139	java/util/Date:getTime	()J
/*     */     //   197: aload 4
/*     */     //   199: invokevirtual 142	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*     */     //   202: invokevirtual 139	java/util/Date:getTime	()J
/*     */     //   205: lsub
/*     */     //   206: invokevirtual 145	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*     */     //   209: aload 4
/*     */     //   211: ldc -108
/*     */     //   213: invokevirtual 150	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   216: aload 6
/*     */     //   218: ldc -103
/*     */     //   220: aload 5
/*     */     //   222: invokevirtual 155	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*     */     //   225: invokevirtual 159	java/lang/Integer:intValue	()I
/*     */     //   228: iconst_1
/*     */     //   229: iadd
/*     */     //   230: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   233: invokeinterface 65 3 0
/*     */     //   238: pop
/*     */     //   239: getstatic 18	com/rongdu/cashloan/manage/job/QuartzBatchRepay:logger	Lorg/apache/log4j/Logger;
/*     */     //   242: ldc -87
/*     */     //   244: invokevirtual 171	org/apache/log4j/Logger:error	(Ljava/lang/Object;)V
/*     */     //   247: goto +60 -> 307
/*     */     //   250: aload 4
/*     */     //   252: invokestatic 75	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   255: invokevirtual 139	java/util/Date:getTime	()J
/*     */     //   258: aload 4
/*     */     //   260: invokevirtual 142	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*     */     //   263: invokevirtual 139	java/util/Date:getTime	()J
/*     */     //   266: lsub
/*     */     //   267: invokevirtual 145	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*     */     //   270: aload 4
/*     */     //   272: ldc -82
/*     */     //   274: invokevirtual 150	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   277: aload 4
/*     */     //   279: ldc -80
/*     */     //   281: invokevirtual 178	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*     */     //   284: aload 6
/*     */     //   286: ldc -103
/*     */     //   288: aload 5
/*     */     //   290: invokevirtual 181	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*     */     //   293: invokevirtual 159	java/lang/Integer:intValue	()I
/*     */     //   296: iconst_1
/*     */     //   297: iadd
/*     */     //   298: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   301: invokeinterface 65 3 0
/*     */     //   306: pop
/*     */     //   307: getstatic 18	com/rongdu/cashloan/manage/job/QuartzBatchRepay:logger	Lorg/apache/log4j/Logger;
/*     */     //   310: ldc -72
/*     */     //   312: invokevirtual 87	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   315: goto +119 -> 434
/*     */     //   318: astore 7
/*     */     //   320: aload 4
/*     */     //   322: invokestatic 75	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   325: invokevirtual 139	java/util/Date:getTime	()J
/*     */     //   328: aload 4
/*     */     //   330: invokevirtual 142	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*     */     //   333: invokevirtual 139	java/util/Date:getTime	()J
/*     */     //   336: lsub
/*     */     //   337: invokevirtual 145	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*     */     //   340: aload 4
/*     */     //   342: ldc -108
/*     */     //   344: invokevirtual 150	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   347: aload 4
/*     */     //   349: ldc -70
/*     */     //   351: invokevirtual 178	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*     */     //   354: aload 6
/*     */     //   356: ldc -103
/*     */     //   358: aload 5
/*     */     //   360: invokevirtual 155	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*     */     //   363: invokevirtual 159	java/lang/Integer:intValue	()I
/*     */     //   366: iconst_1
/*     */     //   367: iadd
/*     */     //   368: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   371: invokeinterface 65 3 0
/*     */     //   376: pop
/*     */     //   377: getstatic 18	com/rongdu/cashloan/manage/job/QuartzBatchRepay:logger	Lorg/apache/log4j/Logger;
/*     */     //   380: aload 7
/*     */     //   382: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
/*     */     //   385: aload 7
/*     */     //   387: invokevirtual 194	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   390: aload_3
/*     */     //   391: aload 4
/*     */     //   393: invokeinterface 197 2 0
/*     */     //   398: pop
/*     */     //   399: aload_2
/*     */     //   400: aload 6
/*     */     //   402: invokeinterface 201 2 0
/*     */     //   407: pop
/*     */     //   408: goto +44 -> 452
/*     */     //   411: astore 13
/*     */     //   413: aload_3
/*     */     //   414: aload 4
/*     */     //   416: invokeinterface 197 2 0
/*     */     //   421: pop
/*     */     //   422: aload_2
/*     */     //   423: aload 6
/*     */     //   425: invokeinterface 201 2 0
/*     */     //   430: pop
/*     */     //   431: aload 13
/*     */     //   433: athrow
/*     */     //   434: aload_3
/*     */     //   435: aload 4
/*     */     //   437: invokeinterface 197 2 0
/*     */     //   442: pop
/*     */     //   443: aload_2
/*     */     //   444: aload 6
/*     */     //   446: invokeinterface 201 2 0
/*     */     //   451: pop
/*     */     //   452: return
/*     */     // Line number table:
/*     */     //   Java source line #51	-> byte code offset #0
/*     */     //   Java source line #52	-> byte code offset #2
/*     */     //   Java source line #53	-> byte code offset #11
/*     */     //   Java source line #55	-> byte code offset #20
/*     */     //   Java source line #56	-> byte code offset #29
/*     */     //   Java source line #57	-> byte code offset #39
/*     */     //   Java source line #58	-> byte code offset #48
/*     */     //   Java source line #60	-> byte code offset #63
/*     */     //   Java source line #61	-> byte code offset #73
/*     */     //   Java source line #63	-> byte code offset #81
/*     */     //   Java source line #64	-> byte code offset #89
/*     */     //   Java source line #65	-> byte code offset #98
/*     */     //   Java source line #66	-> byte code offset #107
/*     */     //   Java source line #67	-> byte code offset #112
/*     */     //   Java source line #68	-> byte code offset #119
/*     */     //   Java source line #69	-> byte code offset #133
/*     */     //   Java source line #70	-> byte code offset #144
/*     */     //   Java source line #71	-> byte code offset #161
/*     */     //   Java source line #72	-> byte code offset #170
/*     */     //   Java source line #73	-> byte code offset #177
/*     */     //   Java source line #74	-> byte code offset #184
/*     */     //   Java source line #75	-> byte code offset #189
/*     */     //   Java source line #76	-> byte code offset #209
/*     */     //   Java source line #77	-> byte code offset #216
/*     */     //   Java source line #78	-> byte code offset #239
/*     */     //   Java source line #79	-> byte code offset #247
/*     */     //   Java source line #80	-> byte code offset #250
/*     */     //   Java source line #81	-> byte code offset #270
/*     */     //   Java source line #82	-> byte code offset #277
/*     */     //   Java source line #83	-> byte code offset #284
/*     */     //   Java source line #86	-> byte code offset #307
/*     */     //   Java source line #87	-> byte code offset #315
/*     */     //   Java source line #88	-> byte code offset #320
/*     */     //   Java source line #89	-> byte code offset #340
/*     */     //   Java source line #90	-> byte code offset #347
/*     */     //   Java source line #91	-> byte code offset #354
/*     */     //   Java source line #92	-> byte code offset #377
/*     */     //   Java source line #94	-> byte code offset #390
/*     */     //   Java source line #95	-> byte code offset #399
/*     */     //   Java source line #93	-> byte code offset #411
/*     */     //   Java source line #94	-> byte code offset #413
/*     */     //   Java source line #95	-> byte code offset #422
/*     */     //   Java source line #96	-> byte code offset #431
/*     */     //   Java source line #94	-> byte code offset #434
/*     */     //   Java source line #95	-> byte code offset #443
/*     */     //   Java source line #97	-> byte code offset #452
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	453	0	this	QuartzBatchRepay
/*     */     //   1	184	1	msg	int
/*     */     //   10	434	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*     */     //   19	416	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*     */     //   27	409	4	ql	com.rongdu.cashloan.manage.domain.QuartzLog
/*     */     //   37	322	5	qi	com.rongdu.cashloan.manage.domain.QuartzInfo
/*     */     //   46	399	6	qiData	Map<String, Object>
/*     */     //   96	83	7	model	AlipayDownloadUrlQueryModel
/*     */     //   318	68	7	e	Exception
/*     */     //   105	10	8	beginDate	java.util.Date
/*     */     //   110	39	9	date	java.util.Calendar
/*     */     //   142	20	10	dft	java.text.SimpleDateFormat
/*     */     //   159	5	11	endDate	java.util.Date
/*     */     //   168	5	12	bill_date	String
/*     */     //   411	21	13	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   81	315	318	java/lang/Exception
/*     */     //   81	390	411	finally
/*     */   }
/*     */   
/*     */   public int alipayQuery(AlipayDownloadUrlQueryModel model)
/*     */     throws Exception
/*     */   {
/* 103 */     int reuslt = 0;
/* 104 */     logger.info("查询支付宝账单信息。。。。。");
/* 105 */     model.setBill_type("trade");
/* 106 */     BaseAliPayModel alipay = new BaseAliPayModel();
/* 107 */     AlipayClient alipayClient = alipay.defaultAlipayClient(alipay);
/* 108 */     AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
/* 109 */     request.setBizContent(JSONObject.toJSONString(model));
/* 110 */     AlipayDataDataserviceBillDownloadurlQueryResponse response = (AlipayDataDataserviceBillDownloadurlQueryResponse)alipayClient.execute(request);
/* 111 */     if (response.isSuccess()) {
/* 112 */       reuslt = 1;
/* 113 */       logger.info("调用成功" + response.getBillDownloadUrl());
/* 114 */       BorrowRepayService borrowRepayService = (BorrowRepayService)BeanUtil.getBean("borrowRepayService");
/* 115 */       List<AlipayModel> apliPayList = AlipayDownLoanFile.parseAlipayByUrl(response.getBillDownloadUrl());
/* 116 */       if ((apliPayList != null) && (!apliPayList.isEmpty())) {
/* 117 */         Map<String, Object> params = new HashMap();
/* 118 */         params.put("state", Integer.valueOf(20));
/* 119 */         List<ManageBRepayModel> list = borrowRepayService.listAllModel(params);
/* 120 */         Iterator localIterator2; for (Iterator localIterator1 = apliPayList.iterator(); localIterator1.hasNext(); 
/* 121 */             localIterator2.hasNext())
/*     */         {
/* 120 */           AlipayModel pay = (AlipayModel)localIterator1.next();
/* 121 */           localIterator2 = list.iterator(); continue;ManageBRepayModel repay = (ManageBRepayModel)localIterator2.next();
/*     */           
/* 123 */           if ((pay.getRemark().contains(repay.getPhone())) || (pay.getRemark().contains(repay.getRealName()))) {
/* 124 */             Map<String, Object> param = new HashMap();
/* 125 */             param.put("id", repay.getId());
/* 126 */             param.put("repayTime", pay.getRepayTime());
/* 127 */             param.put("repayWay", "30");
/* 128 */             param.put("repayAccount", pay.getAccount());
/* 129 */             param.put("penaltyAmout", Integer.valueOf(0));
/* 130 */             if (Double.valueOf(pay.getAmount()).doubleValue() < repay.getRepayAmount().doubleValue()) {
/* 131 */               param.put("state", "20");
/*     */             } else {
/* 133 */               param.put("state", "10");
/*     */             }
/* 135 */             param.put("amount", pay.getAmount());
/*     */             
/* 137 */             borrowRepayService.confirmRepay(param);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 143 */       logger.info("调用失败" + response.getMsg() + "====" + response.getSubMsg());
/*     */     }
/* 145 */     return reuslt;
/*     */   }
/*     */   
/*     */   public void execute(JobExecutionContext context)
/*     */     throws JobExecutionException
/*     */   {
/*     */     try
/*     */     {
/* 153 */       queryUserZmScore();
/*     */     } catch (ServiceException e) {
/* 155 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzBatchRepay.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */