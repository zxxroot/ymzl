/*     */ package com.rongdu.cashloan.manage.job;
/*     */ 
/*     */ import com.rongdu.cashloan.cl.domain.BankCard;
/*     */ import com.rongdu.cashloan.cl.domain.PayLog;
/*     */ import com.rongdu.cashloan.cl.domain.ProfitAmount;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.IncomeforreqModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.utils.FuiouHelper;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.utils.XmlMapUtils;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.PaymentModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.util.LianLianHelper;
/*     */ import com.rongdu.cashloan.cl.service.BankCardService;
/*     */ import com.rongdu.cashloan.cl.service.PayLogService;
/*     */ import com.rongdu.cashloan.cl.service.ProfitAmountService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.OrderNoUtil;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.StringUtils;
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
/*     */ public class QuartzProfit
/*     */   implements Job
/*     */ {
/*  57 */   private static final Logger logger = Logger.getLogger(QuartzProfit.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String profit()
/*     */   {
/*  65 */     ProfitAmountService profitAmountService = (ProfitAmountService)BeanUtil.getBean("profitAmountService");
/*  66 */     BankCardService bankCardService = (BankCardService)BeanUtil.getBean("bankCardService");
/*  67 */     UserBaseInfoService userBaseInfoService = (UserBaseInfoService)BeanUtil.getBean("userBaseInfoService");
/*  68 */     PayLogService payLogService = (PayLogService)BeanUtil.getBean("payLogService");
/*     */     
/*  70 */     List<ProfitAmount> profitAmountList = profitAmountService.listNoCash();
/*     */     
/*  72 */     String quartzRemark = null;
/*  73 */     int succeed = 0;
/*  74 */     int fail = 0;
/*  75 */     int total = 0;
/*  76 */     for (ProfitAmount profitAmount : profitAmountList) {
/*     */       try {
/*  78 */         double amountGrantMin = Global.getDouble("amount_grant_min");
/*     */         
/*  80 */         if (profitAmount.getNoCashed().doubleValue() >= amountGrantMin) {
/*  81 */           BankCard bankCard = bankCardService.getBankCardByUserId(profitAmount.getUserId());
/*  82 */           UserBaseInfo baseInfo = userBaseInfoService.findByUserId(profitAmount.getUserId());
/*  83 */           if ((baseInfo != null) && ("10".equals(baseInfo.getState()))) {
/*     */             continue;
/*     */           }
/*  86 */           String orderNo = OrderNoUtil.getSerialNumber();
/*  87 */           Date date = DateUtil.getNow();
/*     */           
/*  89 */           String value = Global.getValue("fuiou_switch");
/*  90 */           if ((StringUtils.isNotBlank(value)) && (StringUtils.equals(value, "1"))) {
/*  91 */             IncomeforreqModel ifm = new IncomeforreqModel();
/*  92 */             ifm.setBankno(bankCard.getCardNo());
/*  93 */             if ("dev".equals(Global.getValue("app_environment"))) {
/*  94 */               ifm.setAmt(Long.valueOf(1L));
/*     */             } else {
/*  96 */               ifm.setAmt(Long.valueOf(new Double(profitAmount.getNoCashed().doubleValue() * 100.0D).longValue()));
/*     */             }
/*  98 */             ifm.setAccntno(bankCard.getCardNo());
/*  99 */             ifm.setAccntnm(baseInfo.getRealName());
/* 100 */             ifm.setCertno(bankCard.getCardNo());
/* 101 */             ifm.setMobile(bankCard.getPhone());
/* 102 */             ifm.setBankno(bankCard.getBank());
/* 103 */             ifm.setCertno(baseInfo.getIdNo());
/* 104 */             FuiouHelper fh = new FuiouHelper();
/* 105 */             String ret = fh.incomeforreq(ifm);
/* 106 */             Map data = XmlMapUtils.xml2map(ret, false);
/* 107 */             PayLog payLog = new PayLog();
/* 108 */             payLog.setOrderNo(ifm.getOrderNo());
/* 109 */             payLog.setUserId(profitAmount.getUserId());
/* 110 */             payLog.setAmount(profitAmount.getNoCashed());
/* 111 */             payLog.setCardNo(bankCard.getCardNo());
/* 112 */             payLog.setBank(bankCard.getBank());
/* 113 */             payLog.setSource("10");
/* 114 */             payLog.setType("10");
/* 115 */             payLog.setScenes("11");
/* 116 */             if ("000000".equals(data.get("ret"))) {
/* 117 */               payLog.setState("40");
/*     */             } else {
/* 119 */               payLog.setState("50");
/* 120 */               payLog.setUpdateTime(DateUtil.getNow());
/*     */             }
/* 122 */             payLog.setRemark((String)data.get("memo"));
/* 123 */             payLog.setPayReqTime(date);
/* 124 */             payLog.setCreateTime(DateUtil.getNow());
/* 125 */             payLogService.save(payLog);
/*     */           }
/*     */           else {
/* 128 */             PaymentModel payment = new PaymentModel(orderNo);
/* 129 */             payment.setDt_order(DateUtil.dateStr3(date));
/* 130 */             if ("dev".equals(Global.getValue("app_environment"))) {
/* 131 */               payment.setMoney_order("0.01");
/*     */             } else {
/* 133 */               payment.setMoney_order(StringUtil.isNull(profitAmount.getNoCashed()));
/*     */             }
/* 135 */             payment.setAmount(profitAmount.getNoCashed().doubleValue());
/* 136 */             payment.setCard_no(bankCard.getCardNo());
/* 137 */             payment.setAcct_name(baseInfo.getRealName());
/* 138 */             payment.setInfo_order(profitAmount.getId() + "付款");
/* 139 */             payment.setMemo(profitAmount.getId() + "付款");
/* 140 */             payment.setNotify_url(Global.getValue("server_host") + "/pay/lianlian/profitNotify.htm");
/*     */             
/* 142 */             LianLianHelper helper = new LianLianHelper();
/* 143 */             payment = (PaymentModel)helper.payment(payment);
/*     */             
/* 145 */             PayLog payLog = new PayLog();
/* 146 */             payLog.setOrderNo(payment.getNo_order());
/* 147 */             payLog.setUserId(profitAmount.getUserId());
/* 148 */             payLog.setAmount(Double.valueOf(payment.getAmount()));
/* 149 */             payLog.setCardNo(bankCard.getCardNo());
/* 150 */             payLog.setBank(bankCard.getBank());
/* 151 */             payLog.setSource("10");
/* 152 */             payLog.setType("10");
/* 153 */             payLog.setScenes("11");
/* 154 */             if (payment.checkReturn()) {
/* 155 */               payLog.setState("10");
/* 156 */             } else if (("4002".equals(payment.getRet_code())) || ("4003".equals(payment.getRet_code())) || 
/* 157 */               ("4004".equals(payment.getRet_code()))) {
/* 158 */               payLog.setState("15");
/* 159 */               payLog.setConfirmCode(payment.getConfirm_code());
/* 160 */               payLog.setUpdateTime(DateUtil.getNow());
/* 161 */             } else if (("4006".equals(payment.getRet_code())) || 
/* 162 */               ("4007".equals(payment.getRet_code())) || 
/* 163 */               ("4009".equals(payment.getRet_code()))) {
/* 164 */               payLog.setState("10");
/*     */             } else {
/* 166 */               payLog.setState("50");
/* 167 */               payLog.setUpdateTime(DateUtil.getNow());
/*     */             }
/* 169 */             payLog.setRemark(payment.getRet_msg());
/* 170 */             payLog.setPayReqTime(date);
/* 171 */             payLog.setCreateTime(DateUtil.getNow());
/* 172 */             payLogService.save(payLog);
/*     */           }
/*     */         }
/*     */         
/* 176 */         succeed++;
/* 177 */         total++;
/*     */       } catch (Exception e) {
/* 179 */         logger.error(e.getMessage(), e);
/* 180 */         fail++;
/* 181 */         total++;
/*     */       }
/*     */     }
/* 184 */     quartzRemark = "执行总次数" + total + ",成功" + succeed + "次,失败" + fail + "次";
/* 185 */     return quartzRemark;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void execute(org.quartz.JobExecutionContext context)
/*     */     throws org.quartz.JobExecutionException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: ldc_w 461
/*     */     //   3: invokestatic 31	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   6: checkcast 463	com/rongdu/cashloan/manage/service/QuartzInfoService
/*     */     //   9: astore_2
/*     */     //   10: ldc_w 465
/*     */     //   13: invokestatic 31	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   16: checkcast 467	com/rongdu/cashloan/manage/service/QuartzLogService
/*     */     //   19: astore_3
/*     */     //   20: aload_2
/*     */     //   21: ldc_w 469
/*     */     //   24: invokeinterface 471 2 0
/*     */     //   29: astore 4
/*     */     //   31: new 475	com/rongdu/cashloan/manage/domain/QuartzLog
/*     */     //   34: dup
/*     */     //   35: invokespecial 477	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*     */     //   38: astore 5
/*     */     //   40: new 478	java/util/HashMap
/*     */     //   43: dup
/*     */     //   44: invokespecial 480	java/util/HashMap:<init>	()V
/*     */     //   47: astore 6
/*     */     //   49: aload 6
/*     */     //   51: ldc_w 481
/*     */     //   54: aload 4
/*     */     //   56: invokevirtual 483	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   59: invokeinterface 486 3 0
/*     */     //   64: pop
/*     */     //   65: aload 5
/*     */     //   67: aload 4
/*     */     //   69: invokevirtual 483	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   72: invokevirtual 490	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*     */     //   75: aload 5
/*     */     //   77: invokestatic 117	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   80: invokevirtual 493	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*     */     //   83: aload_0
/*     */     //   84: invokevirtual 496	com/rongdu/cashloan/manage/job/QuartzProfit:profit	()Ljava/lang/String;
/*     */     //   87: astore 7
/*     */     //   89: aload 5
/*     */     //   91: invokestatic 117	tool/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   94: invokevirtual 498	java/util/Date:getTime	()J
/*     */     //   97: aload 5
/*     */     //   99: invokevirtual 501	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*     */     //   102: invokevirtual 498	java/util/Date:getTime	()J
/*     */     //   105: lsub
/*     */     //   106: invokevirtual 504	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*     */     //   109: aload 5
/*     */     //   111: ldc 99
/*     */     //   113: invokevirtual 508	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   116: aload 5
/*     */     //   118: aload 7
/*     */     //   120: invokevirtual 511	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*     */     //   123: aload 6
/*     */     //   125: ldc_w 512
/*     */     //   128: aload 4
/*     */     //   130: invokevirtual 513	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*     */     //   133: invokevirtual 517	java/lang/Integer:intValue	()I
/*     */     //   136: iconst_1
/*     */     //   137: iadd
/*     */     //   138: invokestatic 523	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   141: invokeinterface 486 3 0
/*     */     //   146: pop
/*     */     //   147: getstatic 18	com/rongdu/cashloan/manage/job/QuartzProfit:logger	Lorg/apache/log4j/Logger;
/*     */     //   150: ldc_w 526
/*     */     //   153: invokevirtual 528	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   156: goto +112 -> 268
/*     */     //   159: astore 7
/*     */     //   161: aload 5
/*     */     //   163: ldc_w 532
/*     */     //   166: invokevirtual 508	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   169: aload 6
/*     */     //   171: ldc_w 534
/*     */     //   174: aload 4
/*     */     //   176: invokevirtual 535	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*     */     //   179: invokevirtual 517	java/lang/Integer:intValue	()I
/*     */     //   182: iconst_1
/*     */     //   183: iadd
/*     */     //   184: invokestatic 523	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   187: invokeinterface 486 3 0
/*     */     //   192: pop
/*     */     //   193: getstatic 18	com/rongdu/cashloan/manage/job/QuartzProfit:logger	Lorg/apache/log4j/Logger;
/*     */     //   196: aload 7
/*     */     //   198: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
/*     */     //   201: aload 7
/*     */     //   203: invokevirtual 396	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   206: getstatic 18	com/rongdu/cashloan/manage/job/QuartzProfit:logger	Lorg/apache/log4j/Logger;
/*     */     //   209: ldc_w 538
/*     */     //   212: invokevirtual 528	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   215: aload_3
/*     */     //   216: aload 5
/*     */     //   218: invokeinterface 540 2 0
/*     */     //   223: pop
/*     */     //   224: aload_2
/*     */     //   225: aload 6
/*     */     //   227: invokeinterface 543 2 0
/*     */     //   232: pop
/*     */     //   233: goto +62 -> 295
/*     */     //   236: astore 8
/*     */     //   238: getstatic 18	com/rongdu/cashloan/manage/job/QuartzProfit:logger	Lorg/apache/log4j/Logger;
/*     */     //   241: ldc_w 538
/*     */     //   244: invokevirtual 528	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   247: aload_3
/*     */     //   248: aload 5
/*     */     //   250: invokeinterface 540 2 0
/*     */     //   255: pop
/*     */     //   256: aload_2
/*     */     //   257: aload 6
/*     */     //   259: invokeinterface 543 2 0
/*     */     //   264: pop
/*     */     //   265: aload 8
/*     */     //   267: athrow
/*     */     //   268: getstatic 18	com/rongdu/cashloan/manage/job/QuartzProfit:logger	Lorg/apache/log4j/Logger;
/*     */     //   271: ldc_w 538
/*     */     //   274: invokevirtual 528	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   277: aload_3
/*     */     //   278: aload 5
/*     */     //   280: invokeinterface 540 2 0
/*     */     //   285: pop
/*     */     //   286: aload_2
/*     */     //   287: aload 6
/*     */     //   289: invokeinterface 543 2 0
/*     */     //   294: pop
/*     */     //   295: return
/*     */     // Line number table:
/*     */     //   Java source line #191	-> byte code offset #0
/*     */     //   Java source line #192	-> byte code offset #10
/*     */     //   Java source line #194	-> byte code offset #20
/*     */     //   Java source line #195	-> byte code offset #31
/*     */     //   Java source line #196	-> byte code offset #40
/*     */     //   Java source line #197	-> byte code offset #49
/*     */     //   Java source line #198	-> byte code offset #65
/*     */     //   Java source line #199	-> byte code offset #75
/*     */     //   Java source line #203	-> byte code offset #83
/*     */     //   Java source line #205	-> byte code offset #89
/*     */     //   Java source line #206	-> byte code offset #109
/*     */     //   Java source line #207	-> byte code offset #116
/*     */     //   Java source line #208	-> byte code offset #123
/*     */     //   Java source line #209	-> byte code offset #147
/*     */     //   Java source line #210	-> byte code offset #156
/*     */     //   Java source line #211	-> byte code offset #161
/*     */     //   Java source line #212	-> byte code offset #169
/*     */     //   Java source line #213	-> byte code offset #193
/*     */     //   Java source line #215	-> byte code offset #206
/*     */     //   Java source line #216	-> byte code offset #215
/*     */     //   Java source line #217	-> byte code offset #224
/*     */     //   Java source line #214	-> byte code offset #236
/*     */     //   Java source line #215	-> byte code offset #238
/*     */     //   Java source line #216	-> byte code offset #247
/*     */     //   Java source line #217	-> byte code offset #256
/*     */     //   Java source line #218	-> byte code offset #265
/*     */     //   Java source line #215	-> byte code offset #268
/*     */     //   Java source line #216	-> byte code offset #277
/*     */     //   Java source line #217	-> byte code offset #286
/*     */     //   Java source line #220	-> byte code offset #295
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	296	0	this	QuartzProfit
/*     */     //   0	296	1	context	org.quartz.JobExecutionContext
/*     */     //   9	278	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*     */     //   19	259	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*     */     //   29	146	4	quartzInfo	com.rongdu.cashloan.manage.domain.QuartzInfo
/*     */     //   38	241	5	quartzLog	com.rongdu.cashloan.manage.domain.QuartzLog
/*     */     //   47	241	6	qiData	Map<String, Object>
/*     */     //   87	32	7	remark	String
/*     */     //   159	43	7	e	Exception
/*     */     //   236	30	8	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   83	156	159	java/lang/Exception
/*     */     //   83	206	236	finally
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzProfit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */