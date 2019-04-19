/*     */ package com.rongdu.cashloan.manage.job;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.rongdu.cashloan.cl.domain.BankCard;
/*     */ import com.rongdu.cashloan.cl.domain.BorrowRepay;
/*     */ import com.rongdu.cashloan.cl.domain.PayLog;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.IncomeforreqModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.QrytransModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.utils.FuiouHelper;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.utils.XmlMapUtils;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.QueryRepaymentModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.RepaymentModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.RiskItems;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.util.LianLianHelper;
/*     */ import com.rongdu.cashloan.cl.service.BankCardService;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.ClSmsService;
/*     */ import com.rongdu.cashloan.cl.service.PayLogService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.OrderNoUtil;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.quartz.Job;
/*     */ import org.springframework.context.annotation.Lazy;
/*     */ import org.springframework.stereotype.Component;
/*     */ import tool.util.BeanUtil;
/*     */ import tool.util.BigDecimalUtil;
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
/*     */ 
/*     */ 
/*     */ @Component
/*     */ @Lazy(false)
/*     */ public class QuartzRepayment
/*     */   implements Job
/*     */ {
/*  71 */   private static final Logger logger = Logger.getLogger(QuartzRepayment.class);
/*     */   
/*     */   private String repayment() throws ServiceException {
/*  74 */     logger.info("进入代扣还款任务...");
/*  75 */     CloanUserService cloanUserService = (CloanUserService)BeanUtil.getBean("cloanUserService");
/*  76 */     UserBaseInfoService userBaseInfoService = (UserBaseInfoService)BeanUtil.getBean("userBaseInfoService");
/*  77 */     BankCardService bankCardService = (BankCardService)BeanUtil.getBean("bankCardService");
/*  78 */     ClBorrowService clBorrowService = (ClBorrowService)BeanUtil.getBean("clBorrowService");
/*  79 */     BorrowRepayService borrowRepayService = (BorrowRepayService)BeanUtil.getBean("borrowRepayService");
/*  80 */     PayLogService payLogService = (PayLogService)BeanUtil.getBean("payLogService");
/*  81 */     ClSmsService clSmsService = (ClSmsService)BeanUtil.getBean("clSmsService");
/*  82 */     int doRepaymentMax = Global.getInt("do_repayment_max");
/*     */     
/*     */ 
/*  85 */     Map<String, Object> paramMap = new HashMap();
/*  86 */     String doRepaymentToday = Global.getValue("do_repayment_today");
/*  87 */     if ("10".equals(doRepaymentToday)) {
/*  88 */       paramMap.put("repayTime", DateUtil.rollDay(DateUtil.getDayStartTime(DateUtil.getNow()), 1));
/*     */     } else {
/*  90 */       paramMap.put("repayTime", DateUtil.getNow());
/*     */     }
/*  92 */     paramMap.put("state", "20");
/*  93 */     List<BorrowRepay> borrowRepayList = borrowRepayService.findUnRepay(paramMap);
/*  94 */     logger.info("代扣还款任务，待处理的还款计划总数为：" + borrowRepayList.size());
/*     */     
/*  96 */     String quartzRemark = null;
/*  97 */     int succeed = 0;
/*  98 */     int fail = 0;
/*  99 */     int total = 0;
/* 100 */     for (BorrowRepay borrowRepay : borrowRepayList) {
/* 101 */       logger.info("代扣还款任务，还款计划borrowReapyId：" + borrowRepay.getId() + "开始处理");
/*     */       try
/*     */       {
/* 104 */         User user = (User)cloanUserService.getById(borrowRepay.getUserId());
/* 105 */         UserBaseInfo baseInfo = userBaseInfoService.findByUserId(borrowRepay.getUserId());
/* 106 */         Borrow borrow = (Borrow)clBorrowService.getById(Long.valueOf(borrowRepay.getBorrowId()));
/* 107 */         BankCard bankCard = bankCardService.getBankCardByUserId(borrowRepay.getUserId());
/*     */         
/*     */ 
/* 110 */         int doRepaymentCount = payLogService.doRepaymentNum(borrow.getId().longValue());
/* 111 */         if ((doRepaymentMax <= 0) || (doRepaymentCount < doRepaymentMax))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 116 */           if (!"90".equals(borrow.getState()))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 121 */             Map<String, Object> map = borrowRepayService.autoFuiouProtocolRepay(borrowRepay.getUserId(), borrowRepay.getId(), "192.168.1.111", new boolean[] { true });
/* 122 */             if (map.get("Code").equals(Integer.valueOf(200))) {
/* 123 */               succeed++;
/* 124 */               total++;
/*     */             } else {
/* 126 */               fail++;
/* 127 */               total++;
/*     */             }
/*     */           } }
/*     */       } catch (Exception e) {
/* 131 */         fail++;
/* 132 */         total++;
/* 133 */         logger.error(e.getMessage(), e);
/*     */       }
/*     */     }
/*     */     
/* 137 */     quartzRemark = "处理总数" + total + "个，成功" + succeed + "个，失败" + fail + "个";
/* 138 */     logger.info("代扣还款任务，执行完毕，" + quartzRemark);
/* 139 */     return quartzRemark;
/*     */   }
/*     */   
/*     */   private String repayment2() throws ServiceException
/*     */   {
/* 144 */     logger.info("进入代扣还款任务...");
/* 145 */     CloanUserService cloanUserService = (CloanUserService)BeanUtil.getBean("cloanUserService");
/* 146 */     UserBaseInfoService userBaseInfoService = (UserBaseInfoService)BeanUtil.getBean("userBaseInfoService");
/* 147 */     BankCardService bankCardService = (BankCardService)BeanUtil.getBean("bankCardService");
/* 148 */     ClBorrowService clBorrowService = (ClBorrowService)BeanUtil.getBean("clBorrowService");
/* 149 */     BorrowRepayService borrowRepayService = (BorrowRepayService)BeanUtil.getBean("borrowRepayService");
/* 150 */     PayLogService payLogService = (PayLogService)BeanUtil.getBean("payLogService");
/* 151 */     ClSmsService clSmsService = (ClSmsService)BeanUtil.getBean("clSmsService");
/* 152 */     int doRepaymentMax = Global.getInt("do_repayment_max");
/*     */     
/*     */ 
/* 155 */     Map<String, Object> paramMap = new HashMap();
/* 156 */     String doRepaymentToday = Global.getValue("do_repayment_today");
/* 157 */     if ("10".equals(doRepaymentToday)) {
/* 158 */       paramMap.put("repayTime", DateUtil.rollDay(DateUtil.getDayStartTime(DateUtil.getNow()), 1));
/*     */     } else {
/* 160 */       paramMap.put("repayTime", DateUtil.getNow());
/*     */     }
/* 162 */     paramMap.put("state", "20");
/* 163 */     List<BorrowRepay> borrowRepayList = borrowRepayService.findUnRepay(paramMap);
/* 164 */     logger.info("代扣还款任务，待处理的还款计划总数为：" + borrowRepayList.size());
/*     */     
/* 166 */     String quartzRemark = null;
/* 167 */     int succeed = 0;
/* 168 */     int fail = 0;
/* 169 */     int total = 0;
/* 170 */     for (BorrowRepay borrowRepay : borrowRepayList) {
/* 171 */       logger.info("代扣还款任务，还款计划borrowReapyId：" + borrowRepay.getId() + "开始处理");
/*     */       try
/*     */       {
/* 174 */         User user = (User)cloanUserService.getById(borrowRepay.getUserId());
/* 175 */         UserBaseInfo baseInfo = userBaseInfoService.findByUserId(borrowRepay.getUserId());
/* 176 */         Borrow borrow = (Borrow)clBorrowService.getById(Long.valueOf(borrowRepay.getBorrowId()));
/* 177 */         BankCard bankCard = bankCardService.getBankCardByUserId(borrowRepay.getUserId());
/*     */         
/*     */ 
/* 180 */         int doRepaymentCount = payLogService.doRepaymentNum(borrow.getId().longValue());
/* 181 */         if ((doRepaymentMax <= 0) || (doRepaymentCount < doRepaymentMax))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 186 */           if (!"90".equals(borrow.getState()))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 191 */             Map<String, Object> payLogMap = new HashMap();
/* 192 */             payLogMap.put("userId", borrowRepay.getUserId());
/* 193 */             payLogMap.put("borrowId", Long.valueOf(borrowRepay.getBorrowId()));
/* 194 */             payLogMap.put("type", "20");
/* 195 */             payLogMap.put("scenes", "20");
/* 196 */             PayLog repaymentLog = payLogService.findLatestOne(payLogMap);
/* 197 */             String value = Global.getValue("fuiou_switch");
/* 198 */             if ((StringUtils.isNotBlank(value)) && (StringUtils.equals(value, "1"))) {
/* 199 */               QrytransModel qm = new QrytransModel();
/* 200 */               qm.setType("AC01");
/* 201 */               qm.setSerialNumber(repaymentLog.getOrderNo());
/* 202 */               FuiouHelper fh = new FuiouHelper();
/* 203 */               String qrytrans = fh.qrytrans(qm);
/* 204 */               Map data = XmlMapUtils.xml2map(qrytrans, false);
/* 205 */               String ret = (String)data.get("ret");
/* 206 */               if ("000000".equals(ret))
/*     */               {
/* 208 */                 if ((repaymentLog != null) && (!"50".equals(repaymentLog.getState()))) {
/* 209 */                   if ("40".equals(repaymentLog.getState())) {
/*     */                     continue;
/*     */                   }
/*     */                   
/* 213 */                   Map<String, Object> param = new HashMap();
/* 214 */                   param.put("id", borrowRepay.getId());
/* 215 */                   param.put("repayTime", DateUtil.getNow());
/* 216 */                   param.put("repayWay", "10");
/* 217 */                   param.put("repayAccount", bankCard.getCardNo());
/* 218 */                   param.put("amount", String.valueOf(borrowRepay.getAmount()));
/* 219 */                   param.put("serialNumber", repaymentLog.getOrderNo());
/* 220 */                   param.put("penaltyAmout", borrowRepay.getPenaltyAmout());
/* 221 */                   param.put("state", "10");
/* 222 */                   if (!borrowRepay.getState().equals("10")) {
/* 223 */                     borrowRepayService.confirmRepay(param);
/*     */                   }
/*     */                   
/*     */ 
/* 227 */                   Map<String, Object> payLogParamMap = new HashMap();
/* 228 */                   payLogParamMap.put("state", "40");
/* 229 */                   payLogParamMap.put("updateTime", DateUtil.getNow());
/* 230 */                   payLogParamMap.put("id", repaymentLog.getId());
/* 231 */                   payLogService.updateSelective(payLogParamMap);
/*     */                   
/*     */ 
/* 234 */                   clSmsService.repayInform(borrowRepay.getUserId().longValue(), borrowRepay.getBorrowId());
/*     */                   
/* 236 */                   borrowRepayService.insertRepayData(borrowRepay.getUserId());
/* 237 */                   continue;
/*     */                 }
/*     */                 
/* 240 */                 Map<String, Object> payLogParamMap = new HashMap();
/* 241 */                 payLogParamMap.put("state", "50");
/* 242 */                 payLogParamMap.put("updateTime", DateUtil.getNow());
/* 243 */                 payLogParamMap.put("id", repaymentLog.getId());
/* 244 */                 payLogService.updateSelective(payLogParamMap);
/*     */                 
/* 246 */                 double amount = BigDecimalUtil.add(new double[] { borrowRepay.getAmount().doubleValue(), borrowRepay.getPenaltyAmout().doubleValue() });
/* 247 */                 IncomeforreqModel model = new IncomeforreqModel();
/* 248 */                 if ("dev".equals(Global.getValue("app_environment"))) {
/* 249 */                   model.setAmt(Long.valueOf(1L));
/*     */                 } else {
/* 251 */                   model.setAmt(Long.valueOf(new Double(amount * 100.0D).longValue()));
/*     */                 }
/* 253 */                 model.setBankno(bankCard.getBank());
/* 254 */                 model.setAccntno(bankCard.getCardNo());
/* 255 */                 model.setAccntnm(baseInfo.getRealName());
/* 256 */                 model.setMobile(bankCard.getPhone());
/* 257 */                 model.setCertno(baseInfo.getIdNo());
/*     */                 
/*     */ 
/* 260 */                 RiskItems riskItems = new RiskItems();
/* 261 */                 riskItems.setFrms_ware_category("2010");
/* 262 */                 riskItems.setUser_info_mercht_userno(user.getUuid());
/* 263 */                 riskItems.setUser_info_bind_phone(baseInfo.getPhone());
/* 264 */                 riskItems.setUser_info_dt_register(DateUtil.dateStr3(user.getRegistTime()));
/* 265 */                 riskItems.setUser_info_full_name(baseInfo.getRealName());
/* 266 */                 riskItems.setUser_info_id_no(baseInfo.getIdNo());
/* 267 */                 riskItems.setUser_info_identify_type("1");
/* 268 */                 riskItems.setUser_info_identify_state("1");
/*     */                 
/* 270 */                 FuiouHelper fh2 = new FuiouHelper();
/* 271 */                 String res = fh2.incomeforreq(model);
/* 272 */                 Map data2 = XmlMapUtils.xml2map(res, false);
/* 273 */                 PayLog payLog = new PayLog();
/* 274 */                 payLog.setOrderNo(model.getOrderNo());
/* 275 */                 payLog.setUserId(borrowRepay.getUserId());
/* 276 */                 payLog.setBorrowId(Long.valueOf(borrowRepay.getBorrowId()));
/* 277 */                 payLog.setAmount(Double.valueOf(amount));
/* 278 */                 payLog.setCardNo(bankCard.getCardNo());
/* 279 */                 payLog.setBank(bankCard.getBank());
/* 280 */                 payLog.setSource("10");
/* 281 */                 payLog.setType("20");
/* 282 */                 payLog.setScenes("20");
/* 283 */                 if ("000000".equals(data2.get("ret"))) {
/* 284 */                   payLog.setState("40");
/*     */                 } else {
/* 286 */                   payLog.setState("10");
/*     */                 }
/* 288 */                 payLog.setPayReqTime(DateUtil.getNow());
/* 289 */                 payLog.setCreateTime(DateUtil.getNow());
/* 290 */                 payLogService.save(payLog);
/*     */               }
/*     */             }
/*     */             else {
/* 294 */               if ((repaymentLog != null) && (!"50".equals(repaymentLog.getState()))) {
/* 295 */                 if ("40".equals(repaymentLog.getState())) {
/*     */                   continue;
/*     */                 }
/*     */                 
/* 299 */                 String orderNo = OrderNoUtil.getSerialNumber();
/* 300 */                 QueryRepaymentModel queryRepayment = new QueryRepaymentModel(orderNo);
/* 301 */                 queryRepayment.setNo_order(repaymentLog.getOrderNo());
/* 302 */                 queryRepayment.setDt_order(DateUtil.dateStr3(repaymentLog.getPayReqTime()));
/* 303 */                 LianLianHelper helper = new LianLianHelper();
/* 304 */                 queryRepayment = (QueryRepaymentModel)helper.queryRepayment(queryRepayment);
/*     */                 
/* 306 */                 if ((queryRepayment.checkReturn()) && 
/* 307 */                   ("SUCCESS".equals(queryRepayment.getResult_pay())))
/*     */                 {
/* 309 */                   Map<String, Object> param = new HashMap();
/* 310 */                   param.put("id", borrowRepay.getId());
/* 311 */                   param.put("repayTime", DateUtil.getNow());
/* 312 */                   param.put("repayWay", "10");
/* 313 */                   param.put("repayAccount", bankCard.getCardNo());
/* 314 */                   param.put("amount", String.valueOf(borrowRepay.getAmount()));
/* 315 */                   param.put("serialNumber", repaymentLog.getOrderNo());
/* 316 */                   param.put("penaltyAmout", borrowRepay.getPenaltyAmout());
/* 317 */                   param.put("state", "10");
/* 318 */                   if (!borrowRepay.getState().equals("10")) {
/* 319 */                     borrowRepayService.confirmRepay(param);
/*     */                   }
/*     */                   
/*     */ 
/* 323 */                   Map<String, Object> payLogParamMap = new HashMap();
/* 324 */                   payLogParamMap.put("state", "40");
/* 325 */                   payLogParamMap.put("updateTime", DateUtil.getNow());
/* 326 */                   payLogParamMap.put("id", repaymentLog.getId());
/* 327 */                   payLogService.updateSelective(payLogParamMap);
/*     */                   
/*     */ 
/* 330 */                   clSmsService.repayInform(borrowRepay.getUserId().longValue(), borrowRepay.getBorrowId());
/*     */                   
/* 332 */                   borrowRepayService.insertRepayData(borrowRepay.getUserId());
/* 333 */                   continue; }
/* 334 */                 if ((queryRepayment.checkReturn()) && 
/* 335 */                   ("PROCESSING ".equals(queryRepayment.getResult_pay()))) {
/*     */                   continue;
/*     */                 }
/*     */                 
/* 339 */                 Map<String, Object> payLogParamMap = new HashMap();
/* 340 */                 payLogParamMap.put("state", "50");
/* 341 */                 payLogParamMap.put("updateTime", DateUtil.getNow());
/* 342 */                 payLogParamMap.put("id", repaymentLog.getId());
/* 343 */                 payLogService.updateSelective(payLogParamMap);
/*     */               }
/*     */               
/*     */ 
/* 347 */               Date payReqTime = DateUtil.getNow();
/* 348 */               String orderNo = OrderNoUtil.getSerialNumber();
/* 349 */               RepaymentModel repayment = new RepaymentModel(orderNo);
/* 350 */               repayment.setUser_id(user.getUuid());
/* 351 */               repayment.setBusi_partner("101001");
/* 352 */               repayment.setDt_order(DateUtil.dateStr3(payReqTime));
/* 353 */               repayment.setName_goods("还款" + borrow.getOrderNo());
/* 354 */               repayment.setInfo_order("repayment_" + borrow.getOrderNo());
/*     */               
/* 356 */               double amount = BigDecimalUtil.add(new double[] { borrowRepay.getAmount().doubleValue(), borrowRepay.getPenaltyAmout().doubleValue() });
/* 357 */               if ("dev".equals(Global.getValue("app_environment"))) {
/* 358 */                 repayment.setMoney_order("0.01");
/*     */               } else {
/* 360 */                 repayment.setMoney_order(StringUtil.isNull(Double.valueOf(amount)));
/*     */               }
/*     */               
/* 363 */               repayment.setAmount(amount);
/* 364 */               RiskItems riskItems = new RiskItems();
/* 365 */               riskItems.setFrms_ware_category("2010");
/* 366 */               riskItems.setUser_info_mercht_userno(user.getUuid());
/* 367 */               riskItems.setUser_info_bind_phone(baseInfo.getPhone());
/* 368 */               riskItems.setUser_info_dt_register(DateUtil.dateStr3(user.getRegistTime()));
/* 369 */               riskItems.setUser_info_full_name(baseInfo.getRealName());
/* 370 */               riskItems.setUser_info_id_no(baseInfo.getIdNo());
/* 371 */               riskItems.setUser_info_identify_type("1");
/* 372 */               riskItems.setUser_info_identify_state("1");
/* 373 */               repayment.setRisk_item(JSONObject.toJSONString(riskItems));
/* 374 */               repayment.setSchedule_repayment_date(DateUtil.dateStr2(borrowRepay.getRepayTime()));
/* 375 */               repayment.setRepayment_no(borrow.getOrderNo());
/* 376 */               repayment.setNo_agree(bankCard.getAgreeNo());
/* 377 */               repayment.setNotify_url(Global.getValue("server_host") + "/pay/lianlian/repaymentNotify.htm");
/*     */               
/*     */ 
/* 380 */               LianLianHelper helper = new LianLianHelper();
/* 381 */               repayment = (RepaymentModel)helper.repayment(repayment);
/*     */               
/* 383 */               PayLog payLog = new PayLog();
/* 384 */               payLog.setOrderNo(repayment.getOrderNo());
/* 385 */               payLog.setUserId(borrowRepay.getUserId());
/* 386 */               payLog.setBorrowId(Long.valueOf(borrowRepay.getBorrowId()));
/* 387 */               payLog.setAmount(Double.valueOf(repayment.getAmount()));
/* 388 */               payLog.setCardNo(bankCard.getCardNo());
/* 389 */               payLog.setBank(bankCard.getBank());
/* 390 */               payLog.setSource("10");
/* 391 */               payLog.setType("20");
/* 392 */               payLog.setScenes("20");
/* 393 */               payLog.setState("10");
/* 394 */               payLog.setRemark(repayment.getRet_msg());
/* 395 */               payLog.setPayReqTime(payReqTime);
/* 396 */               payLog.setCreateTime(DateUtil.getNow());
/* 397 */               payLogService.save(payLog);
/*     */             }
/* 399 */             succeed++;
/* 400 */             total++;
/*     */           } }
/* 402 */       } catch (Exception e) { fail++;
/* 403 */         total++;
/* 404 */         logger.error(e.getMessage(), e);
/*     */       }
/*     */     }
/*     */     
/* 408 */     quartzRemark = "处理总数" + total + "个，成功" + succeed + "个，失败" + fail + "个";
/* 409 */     logger.info("代扣还款任务，执行完毕，" + quartzRemark);
/* 410 */     return quartzRemark;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void execute(org.quartz.JobExecutionContext context)
/*     */     throws org.quartz.JobExecutionException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: ldc_w 698
/*     */     //   3: invokestatic 40	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   6: checkcast 700	com/rongdu/cashloan/manage/service/QuartzInfoService
/*     */     //   9: astore_2
/*     */     //   10: ldc_w 702
/*     */     //   13: invokestatic 40	tool/util/BeanUtil:getBean	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   16: checkcast 704	com/rongdu/cashloan/manage/service/QuartzLogService
/*     */     //   19: astore_3
/*     */     //   20: aload_2
/*     */     //   21: ldc_w 706
/*     */     //   24: invokeinterface 708 2 0
/*     */     //   29: astore 4
/*     */     //   31: new 80	java/util/HashMap
/*     */     //   34: dup
/*     */     //   35: invokespecial 82	java/util/HashMap:<init>	()V
/*     */     //   38: astore 5
/*     */     //   40: aload 5
/*     */     //   42: ldc_w 362
/*     */     //   45: aload 4
/*     */     //   47: invokevirtual 712	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   50: invokeinterface 113 3 0
/*     */     //   55: pop
/*     */     //   56: new 715	com/rongdu/cashloan/manage/domain/QuartzLog
/*     */     //   59: dup
/*     */     //   60: invokespecial 717	com/rongdu/cashloan/manage/domain/QuartzLog:<init>	()V
/*     */     //   63: astore 6
/*     */     //   65: aload 6
/*     */     //   67: aload 4
/*     */     //   69: invokevirtual 712	com/rongdu/cashloan/manage/domain/QuartzInfo:getId	()Ljava/lang/Long;
/*     */     //   72: invokevirtual 718	com/rongdu/cashloan/manage/domain/QuartzLog:setQuartzId	(Ljava/lang/Long;)V
/*     */     //   75: aload 6
/*     */     //   77: invokestatic 99	com/rongdu/cashloan/core/common/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   80: invokevirtual 721	com/rongdu/cashloan/manage/domain/QuartzLog:setStartTime	(Ljava/util/Date;)V
/*     */     //   83: aload_0
/*     */     //   84: invokespecial 724	com/rongdu/cashloan/manage/job/QuartzRepayment:repayment	()Ljava/lang/String;
/*     */     //   87: astore 7
/*     */     //   89: aload 6
/*     */     //   91: invokestatic 99	com/rongdu/cashloan/core/common/util/DateUtil:getNow	()Ljava/util/Date;
/*     */     //   94: invokevirtual 726	java/util/Date:getTime	()J
/*     */     //   97: aload 6
/*     */     //   99: invokevirtual 729	com/rongdu/cashloan/manage/domain/QuartzLog:getStartTime	()Ljava/util/Date;
/*     */     //   102: invokevirtual 726	java/util/Date:getTime	()J
/*     */     //   105: lsub
/*     */     //   106: invokevirtual 732	com/rongdu/cashloan/manage/domain/QuartzLog:setTime	(J)V
/*     */     //   109: aload 6
/*     */     //   111: ldc 89
/*     */     //   113: invokevirtual 736	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   116: aload 6
/*     */     //   118: aload 7
/*     */     //   120: invokevirtual 739	com/rongdu/cashloan/manage/domain/QuartzLog:setRemark	(Ljava/lang/String;)V
/*     */     //   123: aload 5
/*     */     //   125: ldc_w 740
/*     */     //   128: aload 4
/*     */     //   130: invokevirtual 741	com/rongdu/cashloan/manage/domain/QuartzInfo:getSucceed	()Ljava/lang/Integer;
/*     */     //   133: invokevirtual 745	java/lang/Integer:intValue	()I
/*     */     //   136: iconst_1
/*     */     //   137: iadd
/*     */     //   138: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   141: invokeinterface 113 3 0
/*     */     //   146: pop
/*     */     //   147: goto +111 -> 258
/*     */     //   150: astore 7
/*     */     //   152: aload 6
/*     */     //   154: ldc 121
/*     */     //   156: invokevirtual 736	com/rongdu/cashloan/manage/domain/QuartzLog:setResult	(Ljava/lang/String;)V
/*     */     //   159: aload 5
/*     */     //   161: ldc_w 748
/*     */     //   164: aload 4
/*     */     //   166: invokevirtual 749	com/rongdu/cashloan/manage/domain/QuartzInfo:getFail	()Ljava/lang/Integer;
/*     */     //   169: invokevirtual 745	java/lang/Integer:intValue	()I
/*     */     //   172: iconst_1
/*     */     //   173: iadd
/*     */     //   174: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   177: invokeinterface 113 3 0
/*     */     //   182: pop
/*     */     //   183: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayment:logger	Lorg/apache/log4j/Logger;
/*     */     //   186: aload 7
/*     */     //   188: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
/*     */     //   191: aload 7
/*     */     //   193: invokevirtual 239	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   196: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayment:logger	Lorg/apache/log4j/Logger;
/*     */     //   199: ldc_w 752
/*     */     //   202: invokevirtual 34	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   205: aload_3
/*     */     //   206: aload 6
/*     */     //   208: invokeinterface 754 2 0
/*     */     //   213: pop
/*     */     //   214: aload_2
/*     */     //   215: aload 5
/*     */     //   217: invokeinterface 757 2 0
/*     */     //   222: pop
/*     */     //   223: goto +62 -> 285
/*     */     //   226: astore 8
/*     */     //   228: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayment:logger	Lorg/apache/log4j/Logger;
/*     */     //   231: ldc_w 752
/*     */     //   234: invokevirtual 34	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   237: aload_3
/*     */     //   238: aload 6
/*     */     //   240: invokeinterface 754 2 0
/*     */     //   245: pop
/*     */     //   246: aload_2
/*     */     //   247: aload 5
/*     */     //   249: invokeinterface 757 2 0
/*     */     //   254: pop
/*     */     //   255: aload 8
/*     */     //   257: athrow
/*     */     //   258: getstatic 18	com/rongdu/cashloan/manage/job/QuartzRepayment:logger	Lorg/apache/log4j/Logger;
/*     */     //   261: ldc_w 752
/*     */     //   264: invokevirtual 34	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   267: aload_3
/*     */     //   268: aload 6
/*     */     //   270: invokeinterface 754 2 0
/*     */     //   275: pop
/*     */     //   276: aload_2
/*     */     //   277: aload 5
/*     */     //   279: invokeinterface 757 2 0
/*     */     //   284: pop
/*     */     //   285: return
/*     */     // Line number table:
/*     */     //   Java source line #416	-> byte code offset #0
/*     */     //   Java source line #417	-> byte code offset #10
/*     */     //   Java source line #419	-> byte code offset #20
/*     */     //   Java source line #420	-> byte code offset #31
/*     */     //   Java source line #421	-> byte code offset #40
/*     */     //   Java source line #423	-> byte code offset #56
/*     */     //   Java source line #424	-> byte code offset #65
/*     */     //   Java source line #425	-> byte code offset #75
/*     */     //   Java source line #427	-> byte code offset #83
/*     */     //   Java source line #428	-> byte code offset #89
/*     */     //   Java source line #429	-> byte code offset #109
/*     */     //   Java source line #430	-> byte code offset #116
/*     */     //   Java source line #431	-> byte code offset #123
/*     */     //   Java source line #432	-> byte code offset #147
/*     */     //   Java source line #433	-> byte code offset #152
/*     */     //   Java source line #434	-> byte code offset #159
/*     */     //   Java source line #435	-> byte code offset #183
/*     */     //   Java source line #437	-> byte code offset #196
/*     */     //   Java source line #438	-> byte code offset #205
/*     */     //   Java source line #439	-> byte code offset #214
/*     */     //   Java source line #436	-> byte code offset #226
/*     */     //   Java source line #437	-> byte code offset #228
/*     */     //   Java source line #438	-> byte code offset #237
/*     */     //   Java source line #439	-> byte code offset #246
/*     */     //   Java source line #440	-> byte code offset #255
/*     */     //   Java source line #437	-> byte code offset #258
/*     */     //   Java source line #438	-> byte code offset #267
/*     */     //   Java source line #439	-> byte code offset #276
/*     */     //   Java source line #442	-> byte code offset #285
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	286	0	this	QuartzRepayment
/*     */     //   0	286	1	context	org.quartz.JobExecutionContext
/*     */     //   9	268	2	quartzInfoService	com.rongdu.cashloan.manage.service.QuartzInfoService
/*     */     //   19	249	3	quartzLogService	com.rongdu.cashloan.manage.service.QuartzLogService
/*     */     //   29	136	4	quartzInfo	com.rongdu.cashloan.manage.domain.QuartzInfo
/*     */     //   38	240	5	qiData	Map<String, Object>
/*     */     //   63	206	6	quartzLog	com.rongdu.cashloan.manage.domain.QuartzLog
/*     */     //   87	32	7	remark	String
/*     */     //   150	42	7	e	Exception
/*     */     //   226	30	8	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   83	147	150	java/lang/Exception
/*     */     //   83	196	226	finally
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\job\QuartzRepayment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */