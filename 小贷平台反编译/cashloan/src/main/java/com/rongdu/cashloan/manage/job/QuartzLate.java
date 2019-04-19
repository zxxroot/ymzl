/*     */ package com.rongdu.cashloan.manage.job;
/*     */ 
/*     */ import com.rongdu.cashloan.cl.domain.BorrowProgress;
/*     */ import com.rongdu.cashloan.cl.domain.BorrowRepay;
/*     */ import com.rongdu.cashloan.cl.domain.UrgeRepayOrder;
/*     */ import com.rongdu.cashloan.cl.service.BorrowProgressService;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.ClSmsService;
/*     */ import com.rongdu.cashloan.cl.service.UrgeRepayOrderService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.quartz.Job;
/*     */ import org.springframework.context.annotation.Lazy;
/*     */ import org.springframework.stereotype.Component;
/*     */ import tool.util.BeanUtil;
/*     */ import tool.util.DateUtil;
/*     */ import tool.util.StringUtil;
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
/*     */ public class QuartzLate
/*     */   implements Job
/*     */ {
/*  44 */   private static final Logger logger = Logger.getLogger(QuartzLate.class);
/*     */   
/*     */ 
/*     */ 
/*     */   public String late()
/*     */     throws ServiceException
/*     */   {
/*  51 */     BorrowRepayService borrowRepayService = (BorrowRepayService)BeanUtil.getBean("borrowRepayService");
/*  52 */     BorrowProgressService borrowProgressService = (BorrowProgressService)BeanUtil.getBean("borrowProgressService");
/*  53 */     ClBorrowService clBorrowService = (ClBorrowService)BeanUtil.getBean("clBorrowService");
/*  54 */     UrgeRepayOrderService urgeRepayOrderService = (UrgeRepayOrderService)BeanUtil.getBean("urgeRepayOrderService");
/*  55 */     ClSmsService clSmsService = (ClSmsService)BeanUtil.getBean("clSmsService");
/*     */     
/*  57 */     logger.info("huhuhu进入逾期计算...");
/*  58 */     String quartzRemark = null;
/*  59 */     int succeed = 0;
/*  60 */     int fail = 0;
/*  61 */     int total = 0;
/*  62 */     Map<String, Object> paramMap = new HashMap();
/*  63 */     paramMap.put("state", "20");
/*  64 */     List<BorrowRepay> list = borrowRepayService.listSelective(paramMap);
/*  65 */     String penaltyFee = Global.getValue("penalty_fee");
/*  66 */     String[] penaltyFees = penaltyFee.split(",");
/*  67 */     if (!list.isEmpty()) {
/*  68 */       for (int i = 0; i < list.size(); i++) {
/*     */         try {
/*  70 */           long day = DateUtil.daysBetween(new Date(), ((BorrowRepay)list.get(i)).getRepayTime());
/*  71 */           logger.info("逾期天数" + day + "PenaltyDay" + ((BorrowRepay)list.get(i)).getPenaltyDay());
/*  72 */           if ((Math.abs(day) > Integer.parseInt(((BorrowRepay)list.get(i)).getPenaltyDay())) && 
/*  73 */             (day < 0L)) {
/*  74 */             Borrow borrow = clBorrowService.findByPrimary(Long.valueOf(((BorrowRepay)list.get(i)).getBorrowId()));
/*     */             
/*  76 */             double amout = 0.0D;
/*  77 */             double penaltyAmoutMax = Double.parseDouble(Global.getValue("penalty_amout_max"));
/*  78 */             double penaltyAmout = ((BorrowRepay)list.get(i)).getPenaltyAmout().doubleValue();
/*     */             
/*     */ 
/*  81 */             if (penaltyAmout / borrow.getAmount().doubleValue() < penaltyAmoutMax)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */               amout = Math.abs(day) * 50L;
/*     */             } else {
/*  94 */               amout = 1000.0D;
/*     */             }
/*  96 */             Map<String, Object> data = new HashMap();
/*  97 */             BorrowRepay br = new BorrowRepay();
/*  98 */             br.setId(((BorrowRepay)list.get(i)).getId());
/*     */             
/* 100 */             br.setPenaltyAmout(Double.valueOf(amout));
/* 101 */             br.setPenaltyDay(Long.toString(Math.abs(day)));
/* 102 */             logger.info("id--" + ((BorrowRepay)list.get(i)).getId() + " ==> 已经逾期 " + Math.abs(day) + " 天,逾期费用 " + amout + "元");
/* 103 */             int msg = borrowRepayService.updateLate(br);
/* 104 */             if (msg > 0)
/*     */             {
/* 106 */               Map<String, Object> map = new HashMap();
/* 107 */               map.put("borrowId", Long.valueOf(((BorrowRepay)list.get(i)).getBorrowId()));
/* 108 */               List<BorrowProgress> bpList = borrowProgressService.listSeletetiv(map);
/* 109 */               boolean is = true;
/* 110 */               for (BorrowProgress borrowProgress : bpList) {
/* 111 */                 if ((borrowProgress.getState().equals("90")) || 
/* 112 */                   (borrowProgress.getState().equals("50"))) {
/* 113 */                   is = false;
/* 114 */                   break;
/*     */                 }
/*     */               }
/* 117 */               if (is) {
/* 118 */                 logger.info("---------添加逾期进度---------");
/* 119 */                 BorrowProgress bp = new BorrowProgress();
/* 120 */                 bp.setBorrowId(Long.valueOf(((BorrowRepay)list.get(i)).getBorrowId()));
/* 121 */                 bp.setCreateTime(new Date());
/* 122 */                 bp.setRemark("您已逾期,请尽快还款");
/* 123 */                 bp.setState("50");
/* 124 */                 bp.setUserId(((BorrowRepay)list.get(i)).getUserId());
/* 125 */                 borrowProgressService.save(bp);
/*     */                 
/* 127 */                 data = new HashMap();
/* 128 */                 data.put("id", Long.valueOf(((BorrowRepay)list.get(i)).getBorrowId()));
/* 129 */                 data.put("state", "50");
/* 130 */                 msg = clBorrowService.updateSelective(data);
/* 131 */                 logger.info("---------添加逾期结束---------");
/*     */               }
/*     */               
/* 134 */               logger.info("---------修改催收计划start-------");
/* 135 */               UrgeRepayOrder uro = urgeRepayOrderService.findByBorrowId(((BorrowRepay)list.get(i)).getBorrowId());
/* 136 */               if (StringUtil.isBlank(uro)) {
/* 137 */                 urgeRepayOrderService.saveOrder(Long.valueOf(((BorrowRepay)list.get(i)).getBorrowId()));
/* 138 */                 clSmsService.overdue(((BorrowRepay)list.get(i)).getBorrowId());
/*     */               } else {
/* 140 */                 Object uroMap = new HashMap();
/* 141 */                 ((Map)uroMap).put("penaltyAmout", br.getPenaltyAmout());
/* 142 */                 ((Map)uroMap).put("penaltyDay", br.getPenaltyDay());
/* 143 */                 ((Map)uroMap).put("id", uro.getId());
/* 144 */                 msg = urgeRepayOrderService.updateLate((Map)uroMap);
/*     */               }
/* 146 */               logger.info("---------修改催收计划end-------");
/*     */             } else {
/* 148 */               logger.error("定时计算逾期任务修改数据失败");
/*     */             }
/*     */           }
/*     */           
/* 152 */           succeed++;
/* 153 */           total++;
/*     */         } catch (Exception e) {
/* 155 */           fail++;
/* 156 */           total++;
/* 157 */           logger.error(e.getMessage(), e);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 162 */     logger.info("逾期计算结束...");
/* 163 */     quartzRemark = "执行总次数" + total + ",成功" + succeed + "次,失败" + fail + "次";
/* 164 */     return quartzRemark;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void execute(org.quartz.JobExecutionContext arg0)
/*     */     throws org.quartz.JobExecutionException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: ldc_w 414
/*     */     //   3: invokestatic 34	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   6: checkcast 416	com/rongdu/cashloan/manage/service/QuartzInfoService
/*     */     //   9: astore_2
/*     */     //   10: ldc_w 418
/*     */     //   13: invokestatic 34	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   16: checkcast 420	com/rongdu/cashloan/manage/service/QuartzLogService
/*     */     //   19: astore_3
/*     */     //   20: new 422	com/rongdu/cashloan/manage/domain/QuartzLog
/*     */     //   23: dup
/*     */     //   24: invokespecial 424	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*     */     //   27: astore 4
/*     */     //   29: new 64	java/util/HashMap
/*     */     //   32: dup
/*     */     //   33: invokespecial 66	java/util/HashMap:<init>	()V
/*     */     //   36: astore 5
/*     */     //   38: aload_2
/*     */     //   39: ldc_w 425
/*     */     //   42: invokeinterface 427 2 0
/*     */     //   47: astore 6
/*     */     //   49: aload 5
/*     */     //   51: ldc_w 294
/*     */     //   54: aload 6
/*     */     //   56: invokevirtual 431	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   59: invokeinterface 71 3 0
/*     */     //   64: pop
/*     */     //   65: aload 4
/*     */     //   67: aload 6
/*     */     //   69: invokevirtual 431	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   72: invokevirtual 434	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*     */     //   75: aload 4
/*     */     //   77: invokestatic 437	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   80: invokevirtual 440	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*     */     //   83: aload_0
/*     */     //   84: invokevirtual 443	com/rongdu/cashloan/manage/job/QuartzLate:late	()Ljava/lang/String;
/*     */     //   87: astore 7
/*     */     //   89: aload 4
/*     */     //   91: invokestatic 437	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   94: invokevirtual 445	java/util/Date:getTime	()J
/*     */     //   97: aload 4
/*     */     //   99: invokevirtual 448	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*     */     //   102: invokevirtual 445	java/util/Date:getTime	()J
/*     */     //   105: lsub
/*     */     //   106: invokevirtual 451	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*     */     //   109: aload 4
/*     */     //   111: ldc_w 455
/*     */     //   114: invokevirtual 457	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   117: aload 4
/*     */     //   119: aload 7
/*     */     //   121: invokevirtual 460	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*     */     //   124: aload 5
/*     */     //   126: ldc_w 461
/*     */     //   129: aload 6
/*     */     //   131: invokevirtual 462	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*     */     //   134: invokevirtual 466	java/lang/Integer:intValue	()I
/*     */     //   137: iconst_1
/*     */     //   138: iadd
/*     */     //   139: invokestatic 469	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   142: invokeinterface 71 3 0
/*     */     //   147: pop
/*     */     //   148: goto +111 -> 259
/*     */     //   151: astore 7
/*     */     //   153: aload 4
/*     */     //   155: ldc 69
/*     */     //   157: invokevirtual 457	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   160: aload 5
/*     */     //   162: ldc_w 472
/*     */     //   165: aload 6
/*     */     //   167: invokevirtual 473	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*     */     //   170: invokevirtual 466	java/lang/Integer:intValue	()I
/*     */     //   173: iconst_1
/*     */     //   174: iadd
/*     */     //   175: invokestatic 469	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   178: invokeinterface 71 3 0
/*     */     //   183: pop
/*     */     //   184: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLate:logger	Lorg/apache/log4j/Logger;
/*     */     //   187: aload 7
/*     */     //   189: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
/*     */     //   192: aload 7
/*     */     //   194: invokevirtual 342	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   197: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLate:logger	Lorg/apache/log4j/Logger;
/*     */     //   200: ldc_w 476
/*     */     //   203: invokevirtual 60	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   206: aload_3
/*     */     //   207: aload 4
/*     */     //   209: invokeinterface 478 2 0
/*     */     //   214: pop
/*     */     //   215: aload_2
/*     */     //   216: aload 5
/*     */     //   218: invokeinterface 481 2 0
/*     */     //   223: pop
/*     */     //   224: goto +62 -> 286
/*     */     //   227: astore 8
/*     */     //   229: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLate:logger	Lorg/apache/log4j/Logger;
/*     */     //   232: ldc_w 476
/*     */     //   235: invokevirtual 60	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   238: aload_3
/*     */     //   239: aload 4
/*     */     //   241: invokeinterface 478 2 0
/*     */     //   246: pop
/*     */     //   247: aload_2
/*     */     //   248: aload 5
/*     */     //   250: invokeinterface 481 2 0
/*     */     //   255: pop
/*     */     //   256: aload 8
/*     */     //   258: athrow
/*     */     //   259: getstatic 18	com/rongdu/cashloan/manage/job/QuartzLate:logger	Lorg/apache/log4j/Logger;
/*     */     //   262: ldc_w 476
/*     */     //   265: invokevirtual 60	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   268: aload_3
/*     */     //   269: aload 4
/*     */     //   271: invokeinterface 478 2 0
/*     */     //   276: pop
/*     */     //   277: aload_2
/*     */     //   278: aload 5
/*     */     //   280: invokeinterface 481 2 0
/*     */     //   285: pop
/*     */     //   286: return
/*     */     // Line number table:
/*     */     //   Java source line #169	-> byte code offset #0
/*     */     //   Java source line #170	-> byte code offset #10
/*     */     //   Java source line #171	-> byte code offset #20
/*     */     //   Java source line #172	-> byte code offset #29
/*     */     //   Java source line #173	-> byte code offset #38
/*     */     //   Java source line #175	-> byte code offset #49
/*     */     //   Java source line #176	-> byte code offset #65
/*     */     //   Java source line #177	-> byte code offset #75
/*     */     //   Java source line #179	-> byte code offset #83
/*     */     //   Java source line #181	-> byte code offset #89
/*     */     //   Java source line #182	-> byte code offset #109
/*     */     //   Java source line #183	-> byte code offset #117
/*     */     //   Java source line #184	-> byte code offset #124
/*     */     //   Java source line #186	-> byte code offset #148
/*     */     //   Java source line #187	-> byte code offset #153
/*     */     //   Java source line #188	-> byte code offset #160
/*     */     //   Java source line #189	-> byte code offset #184
/*     */     //   Java source line #191	-> byte code offset #197
/*     */     //   Java source line #192	-> byte code offset #206
/*     */     //   Java source line #193	-> byte code offset #215
/*     */     //   Java source line #190	-> byte code offset #227
/*     */     //   Java source line #191	-> byte code offset #229
/*     */     //   Java source line #192	-> byte code offset #238
/*     */     //   Java source line #193	-> byte code offset #247
/*     */     //   Java source line #194	-> byte code offset #256
/*     */     //   Java source line #191	-> byte code offset #259
/*     */     //   Java source line #192	-> byte code offset #268
/*     */     //   Java source line #193	-> byte code offset #277
/*     */     //   Java source line #195	-> byte code offset #286
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	287	0	this	QuartzLate
/*     */     //   0	287	1	arg0	org.quartz.JobExecutionContext
/*     */     //   9	269	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*     */     //   19	250	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*     */     //   27	243	4	ql	com.rongdu.cashloan.manage.domain.QuartzLog
/*     */     //   36	243	5	qiData	Map<String, Object>
/*     */     //   47	119	6	qi	com.rongdu.cashloan.manage.domain.QuartzInfo
/*     */     //   87	33	7	remark	String
/*     */     //   151	42	7	e	Exception
/*     */     //   227	30	8	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   49	148	151	java/lang/Exception
/*     */     //   49	197	227	finally
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzLate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */