/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.rongdu.cashloan.cl.domain.BankCard;
/*     */ import com.rongdu.cashloan.cl.domain.BorrowRepay;
/*     */ import com.rongdu.cashloan.cl.domain.PayLog;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.RepaymentModel;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.RiskItems;
/*     */ import com.rongdu.cashloan.cl.model.pay.lianlian.util.LianLianHelper;
/*     */ import com.rongdu.cashloan.cl.service.BankCardService;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.PayLogService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.OrderNoUtil;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import java.util.Date;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.BigDecimalUtil;
/*     */ import tool.util.DateUtil;
/*     */ import tool.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class TestChargeController
/*     */   extends ManageBaseController
/*     */ {
/*  44 */   private static Logger logger = LoggerFactory.getLogger(TestChargeController.class);
/*     */   
/*     */   @Resource
/*     */   private CloanUserService cloanUserService;
/*     */   @Resource
/*     */   private UserBaseInfoService userBaseInfoService;
/*     */   @Resource
/*     */   private BankCardService bankCardService;
/*     */   @Resource
/*     */   private ClBorrowService clBorrowService;
/*     */   @Resource
/*     */   private BorrowRepayService borrowRepayService;
/*     */   @Resource
/*     */   private PayLogService payLogService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/borrowRepay/testCharge.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void testCharge(@RequestParam("repayId") long repayId)
/*     */   {
/*  62 */     BorrowRepay borrowRepay = (BorrowRepay)this.borrowRepayService.getById(Long.valueOf(repayId));
/*  63 */     User user = (User)this.cloanUserService.getById(borrowRepay.getUserId());
/*  64 */     UserBaseInfo baseInfo = this.userBaseInfoService.findByUserId(borrowRepay.getUserId());
/*  65 */     Borrow borrow = (Borrow)this.clBorrowService.getById(Long.valueOf(borrowRepay.getBorrowId()));
/*  66 */     BankCard bankCard = this.bankCardService.getBankCardByUserId(borrowRepay.getUserId());
/*     */     
/*  68 */     Date payReqTime = DateUtil.getNow();
/*  69 */     String orderNo = OrderNoUtil.getSerialNumber();
/*  70 */     RepaymentModel repayment = new RepaymentModel(orderNo);
/*  71 */     repayment.setUser_id(user.getUuid());
/*  72 */     repayment.setBusi_partner("101001");
/*  73 */     repayment.setDt_order(DateUtil.dateStr3(payReqTime));
/*  74 */     repayment.setName_goods("还款" + borrow.getOrderNo());
/*  75 */     repayment.setInfo_order("repayment_" + borrow.getOrderNo());
/*     */     
/*  77 */     double amount = BigDecimalUtil.add(new double[] { borrowRepay.getAmount().doubleValue(), borrowRepay.getPenaltyAmout().doubleValue() });
/*  78 */     if ("dev".equals(Global.getValue("app_environment"))) {
/*  79 */       repayment.setMoney_order("0.01");
/*     */     } else {
/*  81 */       repayment.setMoney_order(StringUtil.isNull(Double.valueOf(amount)));
/*     */     }
/*     */     
/*  84 */     repayment.setAmount(amount);
/*  85 */     RiskItems riskItems = new RiskItems();
/*  86 */     riskItems.setFrms_ware_category("2010");
/*  87 */     riskItems.setUser_info_mercht_userno(user.getUuid());
/*  88 */     riskItems.setUser_info_bind_phone(baseInfo.getPhone());
/*  89 */     riskItems.setUser_info_dt_register(DateUtil.dateStr3(user.getRegistTime()));
/*  90 */     riskItems.setUser_info_full_name(baseInfo.getRealName());
/*  91 */     riskItems.setUser_info_id_no(baseInfo.getIdNo());
/*  92 */     riskItems.setUser_info_identify_type("1");
/*  93 */     riskItems.setUser_info_identify_state("1");
/*  94 */     repayment.setRisk_item(JSONObject.toJSONString(riskItems));
/*  95 */     repayment.setSchedule_repayment_date(DateUtil.dateStr2(borrowRepay.getRepayTime()));
/*  96 */     repayment.setRepayment_no(borrow.getOrderNo());
/*  97 */     repayment.setNo_agree(bankCard.getAgreeNo());
/*  98 */     repayment.setNotify_url(Global.getValue("server_host") + "/pay/lianlian/repaymentNotify.htm");
/*     */     
/* 100 */     logger.info("Borrow" + borrow.getOrderNo() + "进行还款,还款金额" + repayment.getMoney_order());
/*     */     
/* 102 */     LianLianHelper helper = new LianLianHelper();
/* 103 */     repayment = (RepaymentModel)helper.repayment(repayment);
/*     */     
/* 105 */     PayLog payLog = new PayLog();
/* 106 */     payLog.setOrderNo(repayment.getOrderNo());
/* 107 */     payLog.setUserId(borrowRepay.getUserId());
/* 108 */     payLog.setBorrowId(Long.valueOf(borrowRepay.getBorrowId()));
/* 109 */     payLog.setAmount(Double.valueOf(repayment.getAmount()));
/* 110 */     payLog.setCardNo(bankCard.getCardNo());
/* 111 */     payLog.setBank(bankCard.getBank());
/* 112 */     payLog.setSource("10");
/* 113 */     payLog.setType("20");
/* 114 */     payLog.setScenes("20");
/* 115 */     payLog.setState("10");
/* 116 */     payLog.setRemark(repayment.getRet_msg());
/* 117 */     payLog.setPayReqTime(payReqTime);
/* 118 */     payLog.setCreateTime(DateUtil.getNow());
/* 119 */     this.payLogService.save(payLog);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\TestChargeController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */