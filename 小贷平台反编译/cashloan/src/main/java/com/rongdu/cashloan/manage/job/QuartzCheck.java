/*     */ package com.rongdu.cashloan.manage.job;
/*     */ 
/*     */ import com.rongdu.cashloan.cl.domain.PayCheck;
/*     */ import com.rongdu.cashloan.cl.domain.PayLog;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.PaymentCheckModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.TransactionCheckModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.util.ReadFileUtil;
/*     */ import com.rongdu.cashloan.cl.service.PayCheckService;
/*     */ import com.rongdu.cashloan.cl.service.PayLogService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.quartz.Job;
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
/*     */ public class QuartzCheck
/*     */   implements Job
/*     */ {
/*  48 */   private static final Logger logger = Logger.getLogger(QuartzCheck.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void paymentCheck()
/*     */   {
/*  55 */     logger.info("进入实时付款交易对账...");
/*  56 */     PayCheckService payCheckService = (PayCheckService)BeanUtil.getBean("payCheckService");
/*  57 */     PayLogService payLogService = (PayLogService)BeanUtil.getBean("payLogService");
/*     */     
/*  59 */     String merchartNo = Global.getValue("lianlian_business_no");
/*  60 */     Date date = DateUtil.rollDay(DateUtil.getNow(), -5);
/*  61 */     String dateStr = DateUtil.dateStr7(date);
/*  62 */     List<String> list = ReadFileUtil.getFile("FKMX_" + merchartNo + "_" + dateStr + ".txt");
/*     */     
/*     */ 
/*  65 */     Date startTime = DateUtil.getDayStartTime(date);
/*  66 */     Date endTime = DateUtil.getDayEndTime(date);
/*     */     
/*  68 */     Map<String, Object> paramMap = new HashMap();
/*  69 */     paramMap.put("startTime", startTime);
/*  70 */     paramMap.put("endTime", endTime);
/*  71 */     paramMap.put("type", "10");
/*  72 */     List<PayLog> payLogList = payLogService.findCheckList(paramMap);
/*     */     
/*     */ 
/*  75 */     String merchantNo = Global.getValue("lianlian_business_no");
/*  76 */     for (String string : list) {
/*  77 */       PaymentCheckModel model = new PaymentCheckModel();
/*  78 */       model = model.anlsStr(string);
/*  79 */       if (!merchantNo.equals(model.getOid_partner())) {
/*  80 */         logger.info("商户号不匹配,对账商户号：" + model.getOid_partner());
/*     */       }
/*     */       else {
/*  83 */         boolean mismatch = true;
/*  84 */         for (PayLog payLog : payLogList) {
/*  85 */           if (model.getOrderNo().equals(payLog.getOrderNo())) {
/*  86 */             mismatch = false;
/*  87 */             if (("0".equals(model.getState())) && (payLog.getState().equals("40"))) {
/*  88 */               if (model.getAmount() != payLog.getAmount().doubleValue()) {
/*  89 */                 PayCheck check = new PayCheck(
/*  90 */                   model.getOrderNo(), 
/*  91 */                   payLog.getAmount().doubleValue(), 
/*  92 */                   model.getAmount(), 
/*  93 */                   "10", 
/*  94 */                   "10");
/*  95 */                 check.setState(model.getState());
/*  96 */                 payCheckService.save(check);
/*     */               }
/*     */             } else {
/*  99 */               PayCheck check = new PayCheck(model.getOrderNo(), 
/* 100 */                 payLog.getAmount().doubleValue(), model.getAmount(), 
/* 101 */                 "10", 
/* 102 */                 "10");
/* 103 */               check.setState(model.getState());
/* 104 */               payCheckService.save(check);
/*     */             }
/*     */           }
/*     */         }
/* 108 */         if (mismatch) {
/* 109 */           PayCheck check = new PayCheck(model.getOrderNo(), 0.0D, 
/* 110 */             model.getAmount(), 
/* 111 */             "30", 
/* 112 */             "10");
/* 113 */           check.setState(model.getState());
/* 114 */           payCheckService.save(check);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 119 */     for (PayLog payLog : payLogList) {
/* 120 */       boolean mismatch = true;
/* 121 */       PaymentCheckModel model = new PaymentCheckModel();
/* 122 */       for (String string : list) {
/* 123 */         model = model.anlsStr(string);
/* 124 */         if (payLog.getOrderNo().equals(model.getOrderNo())) {
/* 125 */           mismatch = false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 130 */       if (mismatch) {
/* 131 */         PayCheck check = new PayCheck(payLog.getOrderNo(), 
/* 132 */           payLog.getAmount().doubleValue(), 0.0D, 
/* 133 */           "20", 
/* 134 */           "10");
/* 135 */         check.setState(model.getState());
/* 136 */         payCheckService.save(check);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void transactionCheck()
/*     */   {
/* 146 */     logger.info("进入分期付交易对账...");
/* 147 */     PayCheckService payCheckService = (PayCheckService)BeanUtil.getBean("payCheckService");
/* 148 */     PayLogService payLogService = (PayLogService)BeanUtil.getBean("payLogService");
/*     */     
/* 150 */     String merchartNo = Global.getValue("lianlian_business_no");
/* 151 */     Date date = DateUtil.rollDay(DateUtil.getNow(), -5);
/* 152 */     String dateStr = DateUtil.dateStr7(date);
/* 153 */     List<String> list = ReadFileUtil.getFile("JYMX_" + merchartNo + "_" + dateStr + ".txt");
/*     */     
/*     */ 
/* 156 */     Date startTime = DateUtil.getDayStartTime(date);
/* 157 */     Date endTime = DateUtil.getDayEndTime(date);
/*     */     
/* 159 */     Map<String, Object> paramMap = new HashMap();
/* 160 */     paramMap.put("startTime", startTime);
/* 161 */     paramMap.put("endTime", endTime);
/* 162 */     paramMap.put("type", "20");
/* 163 */     List<PayLog> payLogList = payLogService.findCheckList(paramMap);
/*     */     
/*     */ 
/*     */ 
/* 167 */     String merchantNo = Global.getValue("lianlian_business_no");
/* 168 */     for (String string : list) {
/* 169 */       TransactionCheckModel model = new TransactionCheckModel();
/* 170 */       model = model.anlsStr(string);
/* 171 */       if (!merchantNo.equals(model.getOid_partner())) {
/* 172 */         logger.info("商户号不匹配,对账商户号：" + model.getOid_partner());
/*     */       }
/*     */       else {
/* 175 */         boolean mismatch = true;
/* 176 */         for (PayLog payLog : payLogList) {
/* 177 */           if (model.getOrderNo().equals(payLog.getOrderNo())) {
/* 178 */             mismatch = false;
/* 179 */             if ("0".equals(model.getState()))
/*     */             {
/* 181 */               if (payLog.getState().equals("40")) {
/* 182 */                 if (model.getAmount() == payLog.getAmount().doubleValue()) continue;
/* 183 */                 PayCheck check = new PayCheck(model.getOrderNo(), 
/* 184 */                   payLog.getAmount().doubleValue(), 
/* 185 */                   model.getAmount(), 
/* 186 */                   "10", 
/* 187 */                   "10");
/* 188 */                 check.setState(model.getState());
/* 189 */                 payCheckService.save(check);
/*     */                 
/* 191 */                 continue; } }
/* 192 */             PayCheck check = new PayCheck(model.getOrderNo(), 
/* 193 */               payLog.getAmount().doubleValue(), model.getAmount(), 
/* 194 */               "10", 
/* 195 */               "10");
/* 196 */             check.setState(model.getState());
/* 197 */             payCheckService.save(check);
/*     */           }
/*     */         }
/*     */         
/* 201 */         if (mismatch) {
/* 202 */           PayCheck check = new PayCheck(model.getOrderNo(), 0.0D, 
/* 203 */             model.getAmount(), 
/* 204 */             "30", 
/* 205 */             "10");
/* 206 */           check.setState(model.getState());
/* 207 */           payCheckService.save(check);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 212 */     for (PayLog payLog : payLogList) {
/* 213 */       boolean mismatch = true;
/* 214 */       TransactionCheckModel model = new TransactionCheckModel();
/* 215 */       for (String string : list) {
/* 216 */         model = model.anlsStr(string);
/* 217 */         if (payLog.getOrderNo().equals(model.getOrderNo())) {
/* 218 */           mismatch = false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 223 */       if (mismatch) {
/* 224 */         PayCheck check = new PayCheck(payLog.getOrderNo(), payLog.getAmount().doubleValue(), 0.0D, "20", 
/* 225 */           "10");
/* 226 */         check.setState(model.getState());
/* 227 */         payCheckService.save(check);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void execute(org.quartz.JobExecutionContext context)
/*     */     throws org.quartz.JobExecutionException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: ldc -7
/*     */     //   2: invokestatic 36	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   5: checkcast 251	com/rongdu/cashloan/manage/service/QuartzInfoService
/*     */     //   8: astore_2
/*     */     //   9: ldc -3
/*     */     //   11: invokestatic 36	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   14: checkcast 255	com/rongdu/cashloan/manage/service/QuartzLogService
/*     */     //   17: astore_3
/*     */     //   18: aload_2
/*     */     //   19: ldc_w 257
/*     */     //   22: invokeinterface 259 2 0
/*     */     //   27: astore 4
/*     */     //   29: new 102	java/util/HashMap
/*     */     //   32: dup
/*     */     //   33: invokespecial 104	java/util/HashMap:<init>	()V
/*     */     //   36: astore 5
/*     */     //   38: aload 5
/*     */     //   40: ldc_w 263
/*     */     //   43: aload 4
/*     */     //   45: invokevirtual 265	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   48: invokeinterface 107 3 0
/*     */     //   53: pop
/*     */     //   54: new 271	com/rongdu/cashloan/manage/domain/QuartzLog
/*     */     //   57: dup
/*     */     //   58: invokespecial 273	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*     */     //   61: astore 6
/*     */     //   63: aload 6
/*     */     //   65: aload 4
/*     */     //   67: invokevirtual 265	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   70: invokevirtual 274	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*     */     //   73: aload 6
/*     */     //   75: invokestatic 56	com/rongdu/cashloan/core/common/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   78: invokevirtual 278	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*     */     //   81: aload_0
/*     */     //   82: invokevirtual 282	com/rongdu/cashloan/manage/job/QuartzCheck:paymentCheck	()V
/*     */     //   85: aload_0
/*     */     //   86: invokevirtual 284	com/rongdu/cashloan/manage/job/QuartzCheck:transactionCheck	()V
/*     */     //   89: aload 6
/*     */     //   91: invokestatic 56	com/rongdu/cashloan/core/common/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   94: invokevirtual 286	java/util/Date:getTime	()J
/*     */     //   97: aload 6
/*     */     //   99: invokevirtual 290	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*     */     //   102: invokevirtual 286	java/util/Date:getTime	()J
/*     */     //   105: lsub
/*     */     //   106: invokevirtual 293	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*     */     //   109: aload 6
/*     */     //   111: ldc 117
/*     */     //   113: invokevirtual 297	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   116: aload 6
/*     */     //   118: ldc_w 300
/*     */     //   121: invokevirtual 302	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*     */     //   124: aload 5
/*     */     //   126: ldc_w 305
/*     */     //   129: aload 4
/*     */     //   131: invokevirtual 307	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*     */     //   134: invokevirtual 311	java/lang/Integer:intValue	()I
/*     */     //   137: iconst_1
/*     */     //   138: iadd
/*     */     //   139: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   142: invokeinterface 107 3 0
/*     */     //   147: pop
/*     */     //   148: goto +119 -> 267
/*     */     //   151: astore 7
/*     */     //   153: aload 6
/*     */     //   155: ldc -59
/*     */     //   157: invokevirtual 297	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   160: aload 6
/*     */     //   162: ldc_w 321
/*     */     //   165: invokevirtual 302	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*     */     //   168: aload 5
/*     */     //   170: ldc_w 323
/*     */     //   173: aload 4
/*     */     //   175: invokevirtual 325	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*     */     //   178: invokevirtual 311	java/lang/Integer:intValue	()I
/*     */     //   181: iconst_1
/*     */     //   182: iadd
/*     */     //   183: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   186: invokeinterface 107 3 0
/*     */     //   191: pop
/*     */     //   192: getstatic 18	com/rongdu/cashloan/manage/job/QuartzCheck:logger	Lorg/apache/log4j/Logger;
/*     */     //   195: aload 7
/*     */     //   197: invokevirtual 328	java/lang/Exception:getMessage	()Ljava/lang/String;
/*     */     //   200: aload 7
/*     */     //   202: invokevirtual 333	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   205: getstatic 18	com/rongdu/cashloan/manage/job/QuartzCheck:logger	Lorg/apache/log4j/Logger;
/*     */     //   208: ldc_w 337
/*     */     //   211: invokevirtual 30	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   214: aload_3
/*     */     //   215: aload 6
/*     */     //   217: invokeinterface 339 2 0
/*     */     //   222: pop
/*     */     //   223: aload_2
/*     */     //   224: aload 5
/*     */     //   226: invokeinterface 342 2 0
/*     */     //   231: pop
/*     */     //   232: goto +62 -> 294
/*     */     //   235: astore 8
/*     */     //   237: getstatic 18	com/rongdu/cashloan/manage/job/QuartzCheck:logger	Lorg/apache/log4j/Logger;
/*     */     //   240: ldc_w 337
/*     */     //   243: invokevirtual 30	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   246: aload_3
/*     */     //   247: aload 6
/*     */     //   249: invokeinterface 339 2 0
/*     */     //   254: pop
/*     */     //   255: aload_2
/*     */     //   256: aload 5
/*     */     //   258: invokeinterface 342 2 0
/*     */     //   263: pop
/*     */     //   264: aload 8
/*     */     //   266: athrow
/*     */     //   267: getstatic 18	com/rongdu/cashloan/manage/job/QuartzCheck:logger	Lorg/apache/log4j/Logger;
/*     */     //   270: ldc_w 337
/*     */     //   273: invokevirtual 30	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   276: aload_3
/*     */     //   277: aload 6
/*     */     //   279: invokeinterface 339 2 0
/*     */     //   284: pop
/*     */     //   285: aload_2
/*     */     //   286: aload 5
/*     */     //   288: invokeinterface 342 2 0
/*     */     //   293: pop
/*     */     //   294: return
/*     */     // Line number table:
/*     */     //   Java source line #237	-> byte code offset #0
/*     */     //   Java source line #238	-> byte code offset #9
/*     */     //   Java source line #240	-> byte code offset #18
/*     */     //   Java source line #241	-> byte code offset #29
/*     */     //   Java source line #242	-> byte code offset #38
/*     */     //   Java source line #244	-> byte code offset #54
/*     */     //   Java source line #245	-> byte code offset #63
/*     */     //   Java source line #246	-> byte code offset #73
/*     */     //   Java source line #250	-> byte code offset #81
/*     */     //   Java source line #253	-> byte code offset #85
/*     */     //   Java source line #255	-> byte code offset #89
/*     */     //   Java source line #256	-> byte code offset #109
/*     */     //   Java source line #257	-> byte code offset #116
/*     */     //   Java source line #258	-> byte code offset #124
/*     */     //   Java source line #259	-> byte code offset #148
/*     */     //   Java source line #260	-> byte code offset #153
/*     */     //   Java source line #261	-> byte code offset #160
/*     */     //   Java source line #262	-> byte code offset #168
/*     */     //   Java source line #263	-> byte code offset #192
/*     */     //   Java source line #265	-> byte code offset #205
/*     */     //   Java source line #266	-> byte code offset #214
/*     */     //   Java source line #267	-> byte code offset #223
/*     */     //   Java source line #264	-> byte code offset #235
/*     */     //   Java source line #265	-> byte code offset #237
/*     */     //   Java source line #266	-> byte code offset #246
/*     */     //   Java source line #267	-> byte code offset #255
/*     */     //   Java source line #268	-> byte code offset #264
/*     */     //   Java source line #265	-> byte code offset #267
/*     */     //   Java source line #266	-> byte code offset #276
/*     */     //   Java source line #267	-> byte code offset #285
/*     */     //   Java source line #270	-> byte code offset #294
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	295	0	this	QuartzCheck
/*     */     //   0	295	1	context	org.quartz.JobExecutionContext
/*     */     //   8	278	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*     */     //   17	260	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*     */     //   27	147	4	quartzInfo	com.rongdu.cashloan.manage.domain.QuartzInfo
/*     */     //   36	251	5	qiData	Map<String, Object>
/*     */     //   61	217	6	quartzLog	com.rongdu.cashloan.manage.domain.QuartzLog
/*     */     //   151	50	7	e	Exception
/*     */     //   235	30	8	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   81	148	151	java/lang/Exception
/*     */     //   81	205	235	finally
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzCheck.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */