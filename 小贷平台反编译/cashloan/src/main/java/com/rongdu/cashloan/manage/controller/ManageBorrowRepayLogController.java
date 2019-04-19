/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.BankCard;
/*     */ import com.rongdu.cashloan.cl.domain.BorrowRepay;
/*     */ import com.rongdu.cashloan.cl.domain.BorrowRepayLog;
/*     */ import com.rongdu.cashloan.cl.domain.PayLog;
/*     */ import com.rongdu.cashloan.cl.model.ManageBRepayLogModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.IncomeforreqModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.QrytransModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.utils.FuiouHelper;
/*     */ import com.rongdu.cashloan.cl.model.pay.fuiou.utils.XmlMapUtils;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.PaymentModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.QueryRepaymentModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.RepaymentModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.RiskItems;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.util.LianLianHelper;
/*     */ import com.rongdu.cashloan.cl.service.BankCardService;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayLogService;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.PayLogService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.OrderNoUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.dom4j.DocumentException;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.NumberUtil;
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
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class ManageBorrowRepayLogController
/*     */   extends ManageBaseController
/*     */ {
/*  77 */   private static final Logger logger = LoggerFactory.getLogger(ManageBorrowRepayLogController.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private CloanUserService cloanUserService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private UserBaseInfoService userBaseInfoService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private BankCardService bankCardService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private ClBorrowService clBorrowService;
/*     */   
/*     */   @Resource
/*     */   private BorrowRepayService borrowRepayService;
/*     */   
/*     */   @Resource
/*     */   private BorrowRepayLogService borrowRepayLogService;
/*     */   
/*     */   @Resource
/*     */   private PayLogService payLogService;
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/repay/log/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:log:list", name="还款记录列表")
/*     */   public void page(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 109 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 110 */     if (params != null) {
/* 111 */       Object obj = params.get("create_time");
/* 112 */       if (obj != null) {
/* 113 */         ArrayList<String> create_time = (ArrayList)obj;
/* 114 */         if (create_time != null) {
/* 115 */           params.put("begin", create_time.get(0));
/* 116 */           params.put("end", create_time.get(1));
/*     */         }
/*     */       }
/*     */     }
/* 120 */     Page<ManageBRepayLogModel> page = this.borrowRepayLogService.listModel(params, currentPage, pageSize);
/* 121 */     Map<String, Object> result = new HashMap();
/* 122 */     result.put("data", page);
/* 123 */     result.put("page", new RdPage(page));
/* 124 */     result.put("code", Integer.valueOf(200));
/* 125 */     result.put("msg", "获取成功");
/* 126 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repayLog/refund.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void refund(@RequestParam("id") Long id, @RequestParam("amount") String amount)
/*     */     throws Exception
/*     */   {
/* 139 */     String value = Global.getValue("fuiou_switch");
/* 140 */     if ((StringUtils.isNotBlank(value)) && (StringUtils.equalsIgnoreCase(value, "1"))) {
/* 141 */       Map<String, Object> result = new HashMap();
/* 142 */       result.put("code", Integer.valueOf(400));
/* 143 */       result.put("msg", "富友商户不支持主动退还接口!");
/* 144 */       ServletUtils.writeToResponse(this.response, result);
/*     */     }
/* 146 */     BorrowRepayLog borrowRepayLog = (BorrowRepayLog)this.borrowRepayLogService.getById(id);
/* 147 */     BankCard bankCard = this.bankCardService.getBankCardByUserId(borrowRepayLog.getUserId());
/* 148 */     UserBaseInfo baseInfo = this.userBaseInfoService.findByUserId(borrowRepayLog.getUserId());
/* 149 */     Borrow borrow = (Borrow)this.clBorrowService.getById(borrowRepayLog.getBorrowId());
/*     */     
/* 151 */     Date date = DateUtil.getNow();
/* 152 */     String orderNo = OrderNoUtil.getSerialNumber();
/*     */     
/* 154 */     PaymentModel payment = new PaymentModel(orderNo);
/* 155 */     payment.setDt_order(DateUtil.dateStr3(date));
/* 156 */     if ("dev".equals(Global.getValue("app_environment"))) {
/* 157 */       payment.setMoney_order("0.01");
/*     */     } else {
/* 159 */       payment.setMoney_order(amount);
/*     */     }
/* 161 */     payment.setAmount(NumberUtil.getDouble(amount));
/*     */     
/* 163 */     payment.setCard_no(bankCard.getCardNo());
/* 164 */     payment.setAcct_name(baseInfo.getRealName());
/* 165 */     payment.setInfo_order(borrow.getOrderNo() + "付款");
/* 166 */     payment.setMemo(borrow.getOrderNo() + "付款");
/* 167 */     payment.setNotify_url(Global.getValue("server_host") + "/pay/lianlian/refundNotify.htm");
/* 168 */     LianLianHelper helper = new LianLianHelper();
/* 169 */     payment = (PaymentModel)helper.payment(payment);
/*     */     
/* 171 */     PayLog payLog = new PayLog();
/* 172 */     payLog.setOrderNo(payment.getNo_order());
/* 173 */     payLog.setUserId(borrow.getUserId());
/* 174 */     payLog.setBorrowId(borrow.getId());
/* 175 */     payLog.setAmount(Double.valueOf(payment.getAmount()));
/* 176 */     payLog.setCardNo(bankCard.getCardNo());
/* 177 */     payLog.setBank(bankCard.getBank());
/* 178 */     payLog.setSource("10");
/* 179 */     payLog.setType("10");
/* 180 */     payLog.setScenes("12");
/*     */     
/* 182 */     if (payment.checkReturn()) {
/* 183 */       payLog.setState("10");
/* 184 */     } else if (("4002".equals(payment.getRet_code())) || 
/* 185 */       ("4003".equals(payment.getRet_code())) || 
/* 186 */       ("4004".equals(payment.getRet_code()))) {
/* 187 */       payLog.setConfirmCode(payment.getConfirm_code());
/* 188 */       payLog.setState("15");
/* 189 */       payLog.setUpdateTime(DateUtil.getNow());
/* 190 */     } else if (("4006".equals(payment.getRet_code())) || 
/* 191 */       ("4007".equals(payment.getRet_code())) || 
/* 192 */       ("4009".equals(payment.getRet_code()))) {
/* 193 */       payLog.setState("10");
/*     */     } else {
/* 195 */       payLog.setState("50");
/* 196 */       payLog.setUpdateTime(DateUtil.getNow());
/*     */     }
/* 198 */     payLog.setRemark(payment.getRet_msg());
/* 199 */     payLog.setPayReqTime(date);
/* 200 */     payLog.setCreateTime(DateUtil.getNow());
/* 201 */     this.payLogService.save(payLog);
/*     */     
/* 203 */     Map<String, Object> result = new HashMap();
/* 204 */     result.put("code", Integer.valueOf(200));
/* 205 */     result.put("msg", "操作成功");
/* 206 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repayLog/deduction.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deduction(@RequestParam("id") Long id, @RequestParam("amount") String amount)
/*     */     throws Exception
/*     */   {
/* 220 */     BorrowRepayLog borrowRepayLog = (BorrowRepayLog)this.borrowRepayLogService.getById(id);
/* 221 */     BorrowRepay borrowRepay = (BorrowRepay)this.borrowRepayService.getById(borrowRepayLog.getRepayId());
/* 222 */     User user = (User)this.cloanUserService.getById(borrowRepayLog.getUserId());
/* 223 */     UserBaseInfo baseInfo = this.userBaseInfoService.findByUserId(borrowRepayLog.getUserId());
/* 224 */     Borrow borrow = (Borrow)this.clBorrowService.getById(borrowRepayLog.getBorrowId());
/* 225 */     BankCard bankCard = this.bankCardService.getBankCardByUserId(borrowRepayLog.getUserId());
/*     */     
/*     */ 
/* 228 */     Map<String, Object> payLogMap = new HashMap();
/* 229 */     payLogMap.put("userId", borrowRepayLog.getUserId());
/* 230 */     payLogMap.put("borrowId", borrowRepayLog.getBorrowId());
/* 231 */     payLogMap.put("type", "20");
/* 232 */     payLogMap.put("scenes", "21");
/* 233 */     PayLog deductionLog = this.payLogService.findLatestOne(payLogMap);
/* 234 */     String value = Global.getValue("fuiou_switch");
/* 235 */     if ((StringUtils.isNotBlank(value)) && (StringUtils.equals(value, "1"))) {
/* 236 */       updateFuiouOrder(amount, borrowRepay, user, baseInfo, borrow, bankCard, deductionLog);
/*     */     } else {
/* 238 */       updateLianlianOrder(amount, borrowRepay, user, baseInfo, borrow, bankCard, deductionLog);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void updateLianlianOrder(String amount, BorrowRepay borrowRepay, User user, UserBaseInfo baseInfo, Borrow borrow, BankCard bankCard, PayLog deductionLog)
/*     */   {
/* 245 */     if ((deductionLog != null) && (!"50".equals(deductionLog.getState())))
/*     */     {
/* 247 */       String orderNo = OrderNoUtil.getSerialNumber();
/* 248 */       QueryRepaymentModel queryRepayment = new QueryRepaymentModel(orderNo);
/* 249 */       queryRepayment.setNo_order(deductionLog.getOrderNo());
/* 250 */       queryRepayment.setDt_order(DateUtil.dateStr3(deductionLog.getPayReqTime()));
/* 251 */       LianLianHelper helper = new LianLianHelper();
/* 252 */       queryRepayment = (QueryRepaymentModel)helper.queryRepayment(queryRepayment);
/*     */       
/*     */ 
/* 255 */       if ((queryRepayment.checkReturn()) && ("SUCCESS".equals(queryRepayment.getResult_pay())))
/*     */       {
/* 257 */         deductionLog.setState("40");
/* 258 */         deductionLog.setUpdateTime(DateUtil.getNow());
/* 259 */         this.payLogService.updateById(deductionLog);
/*     */       }
/*     */     }
/*     */     
/* 263 */     Date payReqTime = DateUtil.getNow();
/* 264 */     String orderNo = OrderNoUtil.getSerialNumber();
/* 265 */     RepaymentModel repayment = new RepaymentModel(orderNo);
/* 266 */     repayment.setUser_id(user.getUuid());
/* 267 */     repayment.setBusi_partner("101001");
/* 268 */     repayment.setDt_order(DateUtil.dateStr3(payReqTime));
/* 269 */     repayment.setName_goods("还款" + borrow.getOrderNo());
/* 270 */     repayment.setInfo_order("repayment_" + borrow.getOrderNo());
/* 271 */     if ("dev".equals(Global.getValue("app_environment"))) {
/* 272 */       repayment.setMoney_order("0.01");
/*     */     } else {
/* 274 */       repayment.setMoney_order(StringUtil.isNull(amount));
/*     */     }
/* 276 */     repayment.setAmount(NumberUtil.getDouble(amount));
/* 277 */     RiskItems riskItems = new RiskItems();
/* 278 */     riskItems.setFrms_ware_category("2010");
/* 279 */     riskItems.setUser_info_mercht_userno(user.getUuid());
/* 280 */     riskItems.setUser_info_bind_phone(baseInfo.getPhone());
/* 281 */     riskItems.setUser_info_dt_register(DateUtil.dateStr3(user.getRegistTime()));
/* 282 */     riskItems.setUser_info_full_name(baseInfo.getRealName());
/* 283 */     riskItems.setUser_info_id_no(baseInfo.getIdNo());
/* 284 */     riskItems.setUser_info_identify_type("1");
/* 285 */     riskItems.setUser_info_identify_state("1");
/* 286 */     repayment.setRisk_item(JSONObject.toJSONString(riskItems));
/* 287 */     repayment.setSchedule_repayment_date(DateUtil.dateStr2(borrowRepay.getRepayTime()));
/* 288 */     repayment.setRepayment_no(borrow.getOrderNo());
/* 289 */     repayment.setNo_agree(bankCard.getAgreeNo());
/* 290 */     repayment.setNotify_url(Global.getValue("server_host") + "/pay/lianlian/deductionNotify.htm");
/*     */     
/* 292 */     logger.info("进行补扣代扣" + amount);
/*     */     
/* 294 */     LianLianHelper helper = new LianLianHelper();
/* 295 */     repayment = (RepaymentModel)helper.repayment(repayment);
/*     */     
/* 297 */     PayLog payLog = new PayLog();
/* 298 */     payLog.setOrderNo(repayment.getOrderNo());
/* 299 */     payLog.setUserId(borrowRepay.getUserId());
/* 300 */     payLog.setBorrowId(Long.valueOf(borrowRepay.getBorrowId()));
/* 301 */     payLog.setAmount(Double.valueOf(repayment.getAmount()));
/* 302 */     payLog.setCardNo(bankCard.getCardNo());
/* 303 */     payLog.setBank(bankCard.getBank());
/* 304 */     payLog.setSource("10");
/* 305 */     payLog.setType("20");
/* 306 */     payLog.setScenes("21");
/* 307 */     payLog.setState("10");
/* 308 */     payLog.setRemark(repayment.getRet_msg());
/* 309 */     payLog.setPayReqTime(payReqTime);
/* 310 */     payLog.setCreateTime(DateUtil.getNow());
/* 311 */     this.payLogService.save(payLog);
/*     */     
/* 313 */     Map<String, Object> result = new HashMap();
/* 314 */     result.put("code", Integer.valueOf(200));
/* 315 */     result.put("msg", "操作成功");
/* 316 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */   private void updateFuiouOrder(String amount, BorrowRepay borrowRepay, User user, UserBaseInfo baseInfo, Borrow borrow, BankCard bankCard, PayLog deductionLog)
/*     */     throws DocumentException
/*     */   {
/* 322 */     if ((deductionLog != null) && (!"50".equals(deductionLog.getState()))) {
/* 323 */       QrytransModel qm = new QrytransModel();
/* 324 */       qm.setType("AC01");
/* 325 */       qm.setSerialNumber(deductionLog.getOrderNo());
/* 326 */       FuiouHelper fh = new FuiouHelper();
/* 327 */       String qrytrans = fh.qrytrans(qm);
/* 328 */       Map data = XmlMapUtils.xml2map(qrytrans, false);
/* 329 */       String ret = (String)data.get("ret");
/* 330 */       if ("000000".equals(ret))
/*     */       {
/* 332 */         deductionLog.setState("40");
/* 333 */         deductionLog.setUpdateTime(DateUtil.getNow());
/* 334 */         this.payLogService.updateById(deductionLog);
/*     */       }
/*     */     }
/*     */     
/* 338 */     Date payReqTime = DateUtil.getNow();
/*     */     
/* 340 */     IncomeforreqModel model = new IncomeforreqModel();
/* 341 */     if ("dev".equals(Global.getValue("app_environment"))) {
/* 342 */       model.setAmt(Long.valueOf(1L));
/*     */     } else {
/* 344 */       model.setAmt(Long.valueOf(new BigDecimal(amount).multiply(new BigDecimal(100)).longValue()));
/*     */     }
/* 346 */     model.setBankno(bankCard.getBank());
/* 347 */     model.setAccntno(bankCard.getCardNo());
/* 348 */     model.setAccntnm(baseInfo.getRealName());
/* 349 */     model.setMobile(bankCard.getPhone());
/* 350 */     model.setCertno(baseInfo.getIdNo());
/*     */     
/* 352 */     RiskItems riskItems = new RiskItems();
/* 353 */     riskItems.setFrms_ware_category("2010");
/* 354 */     riskItems.setUser_info_mercht_userno(user.getUuid());
/* 355 */     riskItems.setUser_info_bind_phone(baseInfo.getPhone());
/* 356 */     riskItems.setUser_info_dt_register(DateUtil.dateStr3(user.getRegistTime()));
/* 357 */     riskItems.setUser_info_full_name(baseInfo.getRealName());
/* 358 */     riskItems.setUser_info_id_no(baseInfo.getIdNo());
/* 359 */     riskItems.setUser_info_identify_type("1");
/* 360 */     riskItems.setUser_info_identify_state("1");
/*     */     
/* 362 */     logger.info("进行补扣代扣" + amount);
/* 363 */     FuiouHelper fh = new FuiouHelper();
/* 364 */     fh.incomeforreq(model);
/*     */     
/*     */ 
/* 367 */     PayLog payLog = new PayLog();
/* 368 */     payLog.setOrderNo(model.getOrderNo());
/* 369 */     payLog.setUserId(borrowRepay.getUserId());
/* 370 */     payLog.setBorrowId(Long.valueOf(borrowRepay.getBorrowId()));
/* 371 */     payLog.setAmount(new Double(amount));
/* 372 */     payLog.setCardNo(bankCard.getCardNo());
/* 373 */     payLog.setBank(bankCard.getBank());
/* 374 */     payLog.setSource("10");
/* 375 */     payLog.setType("20");
/* 376 */     payLog.setScenes("21");
/* 377 */     payLog.setState("10");
/* 378 */     payLog.setPayReqTime(payReqTime);
/* 379 */     payLog.setCreateTime(DateUtil.getNow());
/* 380 */     this.payLogService.save(payLog);
/*     */     
/* 382 */     Map<String, Object> result = new HashMap();
/* 383 */     result.put("code", Integer.valueOf(200));
/* 384 */     result.put("msg", "操作成功");
/* 385 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageBorrowRepayLogController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */