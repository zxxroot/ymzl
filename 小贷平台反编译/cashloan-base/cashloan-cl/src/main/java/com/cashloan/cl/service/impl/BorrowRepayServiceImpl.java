/*      */ package com.cashloan.cl.service.impl;
/*      */ 
/*      */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.domain.*;
import com.cashloan.cl.mapper.*;
import com.cashloan.cl.model.*;
import com.cashloan.cl.model.pay.fuiou.newprotocol.QueryRePayResultModel;
import com.cashloan.cl.model.pay.fuiou.utils.XmlMapUtils;
import com.cashloan.cl.model.pay.lianlian.*;
import com.cashloan.cl.model.pay.lianlian.util.LianLianHelper;
import com.cashloan.cl.service.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.cl.model.pay.fuiou.IncomeforreqModel;
import com.rongdu.cashloan.cl.model.pay.fuiou.QrytransModel;
import com.rongdu.cashloan.cl.model.pay.fuiou.newprotocol.RePayModel;
import com.rongdu.cashloan.cl.model.pay.fuiou.utils.FuiouHelper;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.DateUtil;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import com.rongdu.cashloan.core.common.util.excel.ReadExcelUtils;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.User;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.core.mapper.UserMapper;
import com.rongdu.cashloan.core.model.BorrowModel;
import com.rongdu.creditrank.cr.domain.Credit;
import com.rongdu.creditrank.cr.mapper.CreditMapper;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tool.util.BigDecimalUtil;
import tool.util.NumberUtil;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Service("borrowRepayService")
/*      */ public class BorrowRepayServiceImpl
/*      */   extends BaseServiceImpl<BorrowRepay, Long>
/*      */   implements BorrowRepayService
/*      */ {
/*  115 */   private static final Logger logger = LoggerFactory.getLogger(BorrowRepayServiceImpl.class);
/*      */   
/*      */   @Resource
/*      */   private BorrowRepayMapper borrowRepayMapper;
/*      */   @Resource
/*      */   private BorrowRepayLogMapper borrowRepayLogMapper;
/*      */   @Resource
/*      */   private ClBorrowMapper clBorrowMapper;
/*      */   @Resource
/*      */   private BorrowProgressMapper borrowProgressMapper;
/*      */   @Resource
/*      */   private CreditMapper creditMapper;
/*      */   @Resource
/*      */   private UrgeRepayOrderService urgeRepayOrderService;
/*      */   @Resource
/*      */   private UrgeRepayOrderLogService urgeRepayOrderLogService;
/*      */   @Resource
/*      */   private ProfitLogService profitLogService;
/*      */   @Resource
/*      */   private UserInviteMapper userInviteMapper;
/*      */   @Resource
/*      */   private ProfitLogMapper profitLogMapper;
/*      */   @Resource
/*      */   private BankCardMapper bankCardMapper;
/*      */   @Resource
/*      */   private UserMapper userMapper;
/*      */   @Resource
/*      */   private BorrowRiskDataMapper borrowRiskDataMapper;
/*      */   @Resource
/*      */   private UserBaseInfoMapper userBaseInfoMapper;
/*      */   @Resource
/*      */   private PayLogMapper payLogMapper;
/*      */   @Resource
/*      */   private ClSmsService clSmsService;
/*      */   
/*      */   public BaseMapper<BorrowRepay, Long> getMapper()
/*      */   {
/*  152 */     return this.borrowRepayMapper;
/*      */   }
/*      */   
/*      */   public int save(BorrowRepay borrowRepay)
/*      */   {
/*  157 */     return this.borrowRepayMapper.save(borrowRepay);
/*      */   }
/*      */   
/*      */   public boolean genRepayPlan(Borrow borrow)
/*      */   {
/*  162 */     String beheadFee = Global.getValue("behead_fee");
/*      */     
/*  164 */     BorrowRepay br = new BorrowRepay();
/*  165 */     if ("10".equals(beheadFee)) {
/*  166 */       br.setAmount(borrow.getAmount());
/*      */     } else {
/*  168 */       br.setAmount(Double.valueOf(borrow.getAmount().doubleValue() + borrow.getFee().doubleValue()));
/*      */     }
/*  170 */     br.setBorrowId(borrow.getId().longValue());
/*  171 */     br.setUserId(borrow.getUserId());
/*  172 */     String repay = 
/*  173 */       DateUtil.dateStr2(DateUtil.rollDay(DateUtil.getNow(), Integer.parseInt(borrow.getTimeLimit()) - 1));
/*  174 */     repay = repay + " 23:59:59";
/*  175 */     br.setRepayTime(DateUtil.valueOf(repay, "yyyy-MM-dd HH:mm:ss"));
/*  176 */     br.setState("20");
/*  177 */     br.setPenaltyAmout(Double.valueOf(0.0D));
/*  178 */     br.setPenaltyDay("0");
/*  179 */     br.setCreateTime(DateUtil.getNow());
/*  180 */     int result = this.borrowRepayMapper.save(br);
/*      */     
/*  182 */     if (result > 0) {
/*  183 */       String value = Global.getValue("lianlian_switch");
/*  184 */       if ((StringUtils.isNotBlank(value)) && (StringUtils.equals(value, "1")))
/*      */       {
/*  186 */         authApply(br);
/*      */       }
/*  188 */       return true;
/*      */     }
/*  190 */     return false;
/*      */   }
/*      */   
/*      */   public void authSignApply(Long userId)
/*      */   {
/*  195 */     Map<String, Object> paramMap = new HashMap();
/*  196 */     paramMap.put("userId", userId);
/*  197 */     paramMap.put("state", "20");
/*  198 */     List<BorrowRepay> borrowRepayList = this.borrowRepayMapper.findUnRepay(paramMap);
/*      */     
/*      */ 
/*  201 */     if ((borrowRepayList != null) && (!borrowRepayList.isEmpty())) {
/*  202 */       for (BorrowRepay borrowRepay : borrowRepayList) {
/*  203 */         authApply(borrowRepay);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void authApply(final BorrowRepay borrowRepay)
/*      */   {
/*  251 */     new Thread()
/*      */     {
/*      */       public void run()
/*      */       {
/*  219 */         Map<String, Object> paramMap = new HashMap();
/*  220 */         paramMap.put("userId", borrowRepay.getUserId());
/*  221 */         BankCard bankCard = (BankCard)BorrowRepayServiceImpl.this.bankCardMapper.findSelective(paramMap);
/*      */         
/*  223 */         User user = (User)BorrowRepayServiceImpl.this.userMapper.findByPrimary(borrowRepay.getUserId());
/*  224 */         Borrow borrow = (Borrow)BorrowRepayServiceImpl.this.clBorrowMapper.findByPrimary(Long.valueOf(borrowRepay.getBorrowId()));
/*      */         
/*  226 */         String orderNo = OrderNoUtil.getSerialNumber();
/*  227 */         AuthApplyModel authApply = new AuthApplyModel(orderNo);
/*  228 */         authApply.setUser_id(user.getUuid());
/*  229 */         Map<String, Object> repaymentPlanMap = new HashMap();
/*  230 */         List<RepaymentPlan> list = new ArrayList();
/*  231 */         RepaymentPlan plan = new RepaymentPlan();
/*  232 */         plan.setDate(DateUtil.dateStr2(borrowRepay.getRepayTime()));
/*  233 */         plan.setAmount(StringUtil.isNull(borrowRepay.getAmount()));
/*  234 */         list.add(plan);
/*  235 */         repaymentPlanMap.put("repaymentPlan", list);
/*  236 */         authApply.setRepayment_plan(JSONObject.toJSONString(repaymentPlanMap));
/*  237 */         authApply.setRepayment_no(borrow.getOrderNo());
/*  238 */         SmsParams smsParams = new SmsParams();
/*  239 */         smsParams.setContract_type(Global.getValue("title"));
/*  240 */         smsParams.setContact_way(Global.getValue("phone"));
/*  241 */         authApply.setSms_param(JSONObject.toJSONString(smsParams));
/*  242 */         authApply.setNo_agree(bankCard.getAgreeNo());
/*  243 */         LianLianHelper helper = new LianLianHelper();
/*  244 */         authApply = (AuthApplyModel)helper.authApply(authApply);
/*  245 */         if (authApply.checkReturn()) {
/*  246 */           BorrowRepayServiceImpl.logger.info("Borrow", borrow.getOrderNo(), "授权成功");
/*      */         } else {
/*  248 */           BorrowRepayServiceImpl.logger.info("Borrow" + borrow.getOrderNo() + "授权失败,原因：" + authApply.getRet_msg());
/*      */         }
/*      */       }
/*      */     }.start();
/*      */   }
/*      */   
/*      */   private void autoAuthApply(BorrowRepay borrowRepay)
/*      */   {
/*  256 */     Map<String, Object> paramMap = new HashMap();
/*  257 */     paramMap.put("userId", borrowRepay.getUserId());
/*  258 */     BankCard bankCard = (BankCard)this.bankCardMapper.findSelective(paramMap);
/*      */     
/*  260 */     User user = (User)this.userMapper.findByPrimary(borrowRepay.getUserId());
/*  261 */     Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowRepay.getBorrowId()));
/*      */     
/*      */ 
/*      */ 
/*  265 */     String orderNo = OrderNoUtil.getSerialNumber();
/*  266 */     AuthApplyModel authApply = new AuthApplyModel(orderNo);
/*  267 */     authApply.setUser_id(user.getUuid());
/*  268 */     Map<String, Object> repaymentPlanMap = new HashMap();
/*  269 */     List<RepaymentPlan> list = new ArrayList();
/*  270 */     RepaymentPlan plan = new RepaymentPlan();
/*  271 */     plan.setDate(DateUtil.dateStr2(borrowRepay.getRepayTime()));
/*  272 */     plan.setAmount(StringUtil.isNull(borrowRepay.getAmount()));
/*  273 */     list.add(plan);
/*  274 */     repaymentPlanMap.put("repaymentPlan", list);
/*  275 */     authApply.setRepayment_plan(JSONObject.toJSONString(repaymentPlanMap));
/*  276 */     authApply.setRepayment_no(borrow.getOrderNo());
/*  277 */     SmsParams smsParams = new SmsParams();
/*  278 */     smsParams.setContract_type(Global.getValue("title"));
/*  279 */     smsParams.setContact_way(Global.getValue("phone"));
/*  280 */     authApply.setSms_param(JSONObject.toJSONString(smsParams));
/*  281 */     authApply.setNo_agree(bankCard.getAgreeNo());
/*  282 */     LianLianHelper helper = new LianLianHelper();
/*  283 */     authApply = (AuthApplyModel)helper.authApply(authApply);
/*  284 */     if (authApply.checkReturn()) {
/*  285 */       logger.info("Borrow", borrow.getOrderNo(), "授权成功");
/*      */     } else {
/*  287 */       logger.info("Borrow" + borrow.getOrderNo() + "授权失败,原因：" + authApply.getRet_msg());
/*      */     }
/*      */   }
/*      */   
/*      */   public Page<ManageBRepayModel> listModel(Map<String, Object> params, int currentPage, int pageSize)
/*      */   {
/*  293 */     PageHelper.startPage(currentPage, pageSize);
/*  294 */     List<ManageBRepayModel> list = this.borrowRepayMapper.listModel(params);
/*  295 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public Map<String, Object> confirmRepay(Map<String, Object> param)
/*      */   {
/*  300 */     Date repayTime = (Date)param.get("repayTime");
/*  301 */     Map<String, Object> result = new HashMap();
/*  302 */     Long id = (Long)param.get("id");
/*  303 */     logger.debug("进入确认还款...借款id=" + id);
/*  304 */     BorrowRepay br = (BorrowRepay)this.borrowRepayMapper.findByPrimary(id);
/*  305 */     String state = (String)param.get("state");
/*  306 */     SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
/*  307 */     if ("10".equals(state)) {
/*  308 */       state = "40";
/*  309 */       if ((StringUtil.isNotBlank(br.getPenaltyDay())) && (br.getPenaltyAmout().doubleValue() > 0.0D))
/*      */       {
/*  311 */         int day = DateUtil.daysBetween(DateUtil.valueOf(time.format(repayTime)), new Date());
/*  312 */         if (day > 0) {
/*  313 */           double penaltyAmout = BigDecimal.valueOf(NumberUtil.getDouble((String)param.get("amount")))
/*  314 */             .subtract(BigDecimal.valueOf(br.getAmount().doubleValue())).doubleValue();
/*  315 */           param.put("penaltyAmout", Double.valueOf(penaltyAmout));
/*  316 */           param.put("penaltyDay", Integer.valueOf(br.getPenaltyDay()).intValue() - day < 0 ? br.getPenaltyDay() : 
/*  317 */             Integer.valueOf(Integer.valueOf(br.getPenaltyDay()).intValue() - day));
/*  318 */           br.setPenaltyDay(String.valueOf(Integer.valueOf(br.getPenaltyDay()).intValue() - day));
/*      */         } else {
/*  320 */           param.put("penaltyAmout", StringUtil.isNull(br.getPenaltyAmout()));
/*      */         }
/*  322 */         param.put("amount", StringUtil.isNull(br.getAmount()));
/*      */       }
/*  324 */     } else if ("20".equals(state)) {
/*  325 */       state = "41";
/*  326 */       double repayAmount = NumberUtil.getDouble(param.get("amount") != null ? (String)param.get("amount") : "0");
/*  327 */       if (br.getAmount().doubleValue() < repayAmount) {
/*  328 */         result.put("Code", Integer.valueOf(400));
/*  329 */         result.put("Msg", "还款金额不能大于应还金额");
/*  330 */         return result;
/*      */       }
/*  332 */       double penaltyAmount = 
/*  333 */         NumberUtil.getDouble(param.get("penaltyAmout") != null ? (String)param.get("penaltyAmout") : "0");
/*  334 */       if (br.getPenaltyAmout().doubleValue() < penaltyAmount) {
/*  335 */         result.put("Code", Integer.valueOf(400));
/*  336 */         result.put("Msg", "逾期罚金不能大于原逾期罚金");
/*  337 */         return result;
/*      */       }
/*      */     }
/*      */     
/*  341 */     int msg = updateBorrowReplay(br, repayTime, param);
/*  342 */     if (msg <= 0) {
/*  343 */       throw new BussinessException("更新还款信息出错" + br.getBorrowId());
/*      */     }
/*      */     
/*  346 */     msg = updateBorrow(br.getBorrowId(), br.getUserId().longValue(), state);
/*  347 */     if (msg <= 0) {
/*  348 */       throw new BussinessException("更新借款表和借款进度状态出错" + br.getBorrowId());
/*      */     }
/*  350 */     Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(br.getBorrowId()));
/*      */     
/*  352 */     Map<String, Object> creditMap = new HashMap();
/*  353 */     creditMap.put("consumerNo", br.getUserId());
/*  354 */     Credit credit = (Credit)this.creditMapper.findSelective(creditMap);
/*  355 */     if (credit != null) {
/*  356 */       credit.setUnuse(Double.valueOf(credit.getUnuse().doubleValue() + borrow.getAmount().doubleValue()));
/*  357 */       credit.setUsed(Double.valueOf(credit.getUsed().doubleValue() > borrow.getAmount().doubleValue() ? credit.getUsed().doubleValue() - borrow.getAmount().doubleValue() : 0.0D));
/*  358 */       this.creditMapper.update(credit);
/*      */     } else {
/*  360 */       throw new BussinessException("用户信用额度信息不存在" + br.getUserId());
/*      */     }
/*      */     
/*  363 */     Map<String, Object> orderMap = new HashMap();
/*  364 */     orderMap.put("borrowId", Long.valueOf(br.getBorrowId()));
/*  365 */     UrgeRepayOrder order = this.urgeRepayOrderService.findOrderByMap(orderMap);
/*  366 */     if (order != null) {
/*  367 */       logger.debug("更新存在的催收订单中的状态");
/*  368 */       UrgeRepayOrderLog orderLog = new UrgeRepayOrderLog();
/*  369 */       orderLog.setRemark("用户还款成功");
/*  370 */       orderLog.setWay("50");
/*  371 */       orderLog.setCreateTime(DateUtil.getNow());
/*  372 */       orderLog.setState("40");
/*  373 */       this.urgeRepayOrderLogService.saveOrderInfo(orderLog, order);
/*      */     }
/*      */     
/*  376 */     insertRepayData(br.getUserId());
/*      */     
/*  378 */     Map<String, Object> inviteMap = new HashMap();
/*  379 */     inviteMap.put("inviteId", br.getUserId());
/*  380 */     UserInvite invite = (UserInvite)this.userInviteMapper.findSelective(inviteMap);
/*  381 */     if (StringUtil.isNotBlank(invite))
/*      */     {
/*  383 */       Map<String, Object> profitMap = new HashMap();
/*  384 */       profitMap.put("borrowId", Long.valueOf(br.getBorrowId()));
/*  385 */       int count = this.profitLogMapper.count(profitMap);
/*  386 */       if (count == 0) {
/*  387 */         this.profitLogService.save(br.getBorrowId(), DateUtil.getNow());
/*      */       }
/*      */     }
/*  390 */     result.put("Code", Integer.valueOf(200));
/*  391 */     result.put("Msg", "还款成功");
/*      */     
/*  393 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int updateBorrow(long borrowId, long userId, String state)
/*      */   {
/*  405 */     int i = 0;
/*      */     
/*  407 */     Map<String, Object> stateMap = new HashMap();
/*  408 */     stateMap.put("id", Long.valueOf(borrowId));
/*  409 */     stateMap.put("state", state);
/*  410 */     i = this.clBorrowMapper.updateSelective(stateMap);
/*  411 */     if (i > 0)
/*      */     {
/*  413 */       BorrowProgress bp = new BorrowProgress();
/*  414 */       bp.setBorrowId(Long.valueOf(borrowId));
/*  415 */       bp.setUserId(Long.valueOf(userId));
/*  416 */       bp.setRemark(BorrowModel.convertBorrowRemark(state));
/*  417 */       bp.setState(state);
/*  418 */       bp.setCreateTime(DateUtil.getNow());
/*  419 */       return this.borrowProgressMapper.save(bp);
/*      */     }
/*  421 */     return i;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int updateBorrowReplay(BorrowRepay br, Date repayTime, Map<String, Object> param)
/*      */   {
/*  434 */     int i = 0;
/*  435 */     Map<String, Object> paramMap = new HashMap();
/*  436 */     paramMap.put("id", br.getId());
/*  437 */     paramMap.put("state", "10");
/*      */     
/*  439 */     SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
/*  440 */     Date repayPlanTime = DateUtil.valueOf(time.format(br.getRepayTime()));
/*  441 */     Date repay_time = DateUtil.valueOf(time.format(repayTime));
/*      */     
/*  443 */     if ((StringUtil.isNotBlank(br.getPenaltyDay())) && (br.getPenaltyAmout().doubleValue() > 0.0D))
/*      */     {
/*  445 */       if (!repay_time.after(repayPlanTime)) {
/*  446 */         br.setPenaltyDay(String.valueOf(0));
/*  447 */         br.setPenaltyAmout(Double.valueOf(0.0D));
/*  448 */         paramMap.put("penaltyDay", "0");
/*  449 */         paramMap.put("penaltyAmout", Double.valueOf(0.0D));
/*      */       }
/*  451 */       else if ("10".equals((String)param.get("state"))) {
/*  452 */         paramMap.put("penaltyDay", param.get("penaltyDay"));
/*  453 */         paramMap.put("penaltyAmout", param.get("penaltyAmout"));
/*      */       }
/*      */     }
/*      */     
/*  457 */     i = this.borrowRepayMapper.updateParam(paramMap);
/*  458 */     if (i > 0)
/*      */     {
/*  460 */       BorrowRepayLog log = new BorrowRepayLog();
/*  461 */       log.setBorrowId(Long.valueOf(br.getBorrowId()));
/*  462 */       log.setRepayId(br.getId());
/*  463 */       log.setUserId(br.getUserId());
/*  464 */       log.setAmount(Double.valueOf((String)param.get("amount")));
/*  465 */       log.setRepayTime(repayTime);
/*  466 */       log.setPenaltyDay(br.getPenaltyDay());
/*      */       
/*  468 */       if (!repay_time.after(repayPlanTime)) {
/*  469 */         log.setPenaltyAmout(Double.valueOf(0.0D));
/*  470 */         log.setPenaltyDay("0");
/*      */       }
/*      */       else {
/*  473 */         String penaltyAmout = StringUtil.isNull(param.get("penaltyAmout"));
/*  474 */         if (StringUtil.isNotBlank(penaltyAmout)) {
/*  475 */           log.setPenaltyAmout(Double.valueOf(NumberUtil.getDouble(penaltyAmout)));
/*      */         } else {
/*  477 */           log.setPenaltyAmout(br.getPenaltyAmout());
/*      */         }
/*      */       }
/*      */       
/*  481 */       log.setSerialNumber((String)param.get("serialNumber"));
/*  482 */       log.setRepayAccount((String)param.get("repayAccount"));
/*  483 */       log.setRepayWay((String)param.get("repayWay"));
/*  484 */       log.setCreateTime(DateUtil.getNow());
/*  485 */       return this.borrowRepayLogMapper.save(log);
/*      */     }
/*  487 */     return i;
/*      */   }
/*      */   
/*      */   public List<BorrowRepay> listSelective(Map<String, Object> paramMap)
/*      */   {
/*  492 */     return this.borrowRepayMapper.listSelective(paramMap);
/*      */   }
/*      */   
/*      */   public int updateLate(BorrowRepay data)
/*      */   {
/*  497 */     return this.borrowRepayMapper.updateLate(data);
/*      */   }
/*      */   
/*      */   public int updateSelective(Map<String, Object> paramMap)
/*      */   {
/*  502 */     return this.borrowRepayMapper.updateSelective(paramMap);
/*      */   }
/*      */   
/*      */   public Page<ManageBorrowModel> listRepayModel(Map<String, Object> params, int currentPage, int pageSize)
/*      */   {
/*  507 */     PageHelper.startPage(currentPage, pageSize);
/*  508 */     List<ManageBorrowModel> list = this.borrowRepayMapper.listRepayModel(params);
/*  509 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public Page<ManageBorrowModel> listModelNotUrge(Map<String, Object> params, int currentPage, int pageSize)
/*      */   {
/*  514 */     PageHelper.startPage(currentPage, pageSize);
/*  515 */     List<ManageBorrowModel> list = this.borrowRepayMapper.listModelNotUrge(params);
/*  516 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public List<BorrowRepay> findUnRepay(Map<String, Object> paramMap)
/*      */   {
/*  521 */     return this.borrowRepayMapper.findUnRepay(paramMap);
/*      */   }
/*      */   
/*      */   public BorrowRepay findSelective(Map<String, Object> paramMap)
/*      */   {
/*  526 */     return (BorrowRepay)this.borrowRepayMapper.findSelective(paramMap);
/*      */   }
/*      */   
/*      */   public List<ManageBRepayModel> listAllModel(Map<String, Object> params)
/*      */   {
/*  531 */     List<ManageBRepayModel> list = this.borrowRepayMapper.listModel(params);
/*  532 */     return list;
/*      */   }
/*      */   
/*      */   public List<List<String>> fileBatchRepay(MultipartFile repayFile, String type)
/*      */     throws Exception
/*      */   {
/*  538 */     Map<String, Object> params = new HashMap();
/*  539 */     params.put("state", Integer.valueOf(20));
/*  540 */     List<ManageBRepayModel> list = this.borrowRepayMapper.listModel(params);
/*  541 */     List<List<String>> result = new ArrayList();
/*  542 */     String ext = repayFile.getOriginalFilename().substring(repayFile.getOriginalFilename().lastIndexOf("."));
/*  543 */     if ((".xlsx".equals(ext)) || (".xls".equals(ext))) {
/*  544 */       String title = "批量还款匹配结果";
/*  545 */       if (type.equals("alpay")) {
/*  546 */         result = parserByFile(repayFile, list);
/*  547 */       } else if ("bank".equals(type)) {
/*  548 */         result = toPaseBank(repayFile, list);
/*  549 */         RepayExcelModel.createWorkBook(result, title);
/*      */       } else {
/*  551 */         throw new BussinessException("请上传格式正确的文档。");
/*      */       }
/*      */     } else {
/*  554 */       throw new BussinessException("支持.xls和.xlsx格式文档，请上传格式正确的文档。");
/*      */     }
/*  556 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<List<String>> parserByFile(MultipartFile repayFile, List<ManageBRepayModel> list)
/*      */     throws Exception
/*      */   {
/*  572 */     ReadExcelUtils excelReader = new ReadExcelUtils(repayFile);
/*  573 */     List<List<String>> arr = excelReader.readExcelContent();
/*      */     
/*  575 */     int j = 0;
/*  576 */     List<AlipayModel> alipayList = new ArrayList();
/*  577 */     AlipayModel model = null;
/*  578 */     for (int i = 0; i < arr.size(); i++) {
/*  579 */       model = new AlipayModel();
/*  580 */       List<String> ls = (List)arr.get(i);
/*  581 */       for (int k = 0; k < ls.size(); k++) {
/*  582 */         String item = (String)ls.get(k);
/*  583 */         if (!"".equals(item))
/*      */         {
/*      */ 
/*  586 */           if (item.contains("账务流水号")) {
/*  587 */             j = i;
/*  588 */             ((List)arr.get(i)).add(ls.size(), "是否有备注信息与还款计划匹配");
/*      */           } }
/*      */       }
/*  591 */       if ((j != 0) && (j + 1 < ls.size()) && (j + 1 <= i)) {
/*  592 */         model.setSerialNumber((String)ls.get(1));
/*  593 */         model.setAccount((String)ls.get(5));
/*  594 */         model.setAmount((String)ls.get(6));
/*  595 */         model.setRemark((String)ls.get(11));
/*  596 */         model.setRepayTime(ls.get(4) != null ? DateUtil.valueOf((String)ls.get(4), "yyyy/MM/dd HH:mm") : null);
/*  597 */         if ((model != null) && (model.getAccount() != null)) {
/*  598 */           alipayList.add(model);
/*      */         }
/*  600 */         boolean flag = false;
/*  601 */         flag = remarkPay(flag, model, list);
/*  602 */         ((List)arr.get(i)).add(ls.size(), flag ? "有" : "无");
/*      */       }
/*      */     }
/*  605 */     if (alipayList.size() <= 0) {
/*  606 */       throw new BussinessException("没有解析到匹配的数据，请上传正确的文档");
/*      */     }
/*      */     
/*  609 */     return arr;
/*      */   }
/*      */   
/*      */   public List<List<String>> toPaseBank(MultipartFile file, List<ManageBRepayModel> list) throws Exception {
/*  613 */     ReadExcelUtils excelReader = new ReadExcelUtils(file);
/*  614 */     List<List<String>> arr = excelReader.readExcelContent();
/*      */     
/*  616 */     List<AlipayModel> alipayList = new ArrayList();
/*  617 */     AlipayModel model = null;
/*  618 */     int j = 0;
/*  619 */     for (int i = 0; i < arr.size(); i++) {
/*  620 */       model = new AlipayModel();
/*  621 */       List<String> ls = (List)arr.get(i);
/*  622 */       for (int k = 0; k < ls.size(); k++) {
/*  623 */         String item = (String)ls.get(k);
/*  624 */         if (!"".equals(item))
/*      */         {
/*      */ 
/*  627 */           if (item.contains("交易日")) {
/*  628 */             j = i;
/*  629 */             ((List)arr.get(i)).add(ls.size(), "是否有备注信息与还款计划匹配");
/*      */           } }
/*      */       }
/*  632 */       if ((j != 0) && (j + 1 < ls.size()) && (j + 1 <= i)) {
/*  633 */         String repayTime = (String)ls.get(0) + (String)ls.get(1);
/*  634 */         model.setRepayTime(repayTime != "" ? DateUtil.valueOf(repayTime, "yyyyMMddHHmmss") : null);
/*  635 */         model.setSerialNumber((String)ls.get(8));
/*  636 */         model.setAccount((String)ls.get(17));
/*  637 */         model.setAmount((String)ls.get(6));
/*  638 */         model.setRemark((String)ls.get(7));
/*  639 */         if ((model != null) && (model.getAccount() != null)) {
/*  640 */           alipayList.add(model);
/*      */         }
/*  642 */         boolean flag = false;
/*  643 */         flag = remarkPay(flag, model, list);
/*  644 */         ((List)arr.get(i)).add(ls.size(), flag ? "有" : "无");
/*      */       }
/*      */     }
/*  647 */     if (alipayList.size() <= 0) {
/*  648 */       throw new BussinessException("没有解析到匹配的数据，请上传正确的文档");
/*      */     }
/*      */     
/*  651 */     return arr;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean remarkPay(boolean flag, AlipayModel model, List<ManageBRepayModel> list)
/*      */   {
/*  663 */     for (ManageBRepayModel repay : list)
/*      */     {
/*  665 */       if (model.getRemark().contains(repay.getPhone())) {
/*  666 */         flag = true;
/*  667 */         logger.info("批量还款匹配到的还款数据==" + repay.getId() + "=" + model.getRemark() + "=" + repay.getPhone() + "=" + 
/*  668 */           repay.getRealName());
/*  669 */         Map<String, Object> param = new HashMap();
/*  670 */         param.put("id", repay.getId());
/*  671 */         param.put("repayTime", model.getRepayTime());
/*  672 */         param.put("repayWay", "30");
/*  673 */         param.put("repayAccount", model.getAccount());
/*  674 */         param.put("penaltyAmout", Integer.valueOf(0));
/*  675 */         if (Double.valueOf(model.getAmount()).doubleValue() < repay.getRepayAmount().doubleValue()) {
/*  676 */           param.put("state", "20");
/*      */         } else {
/*  678 */           param.put("state", "10");
/*      */         }
/*  680 */         param.put("serialNumber", model.getSerialNumber());
/*  681 */         param.put("amount", model.getAmount());
/*  682 */         confirmRepay(param);
/*  683 */         break;
/*      */       }
/*      */     }
/*  686 */     return flag;
/*      */   }
/*      */   
/*      */   public void insertRepayData(Long userId)
/*      */   {
/*  691 */     Map<String, Object> params = new HashMap();
/*  692 */     params.put("state", "10");
/*  693 */     params.put("userId", userId);
/*  694 */     ManageBRepayModel repay = this.borrowRepayMapper.findRecordByUser(params);
/*  695 */     if (repay != null)
/*      */     {
/*  697 */       Map<String, Object> map = new HashMap();
/*  698 */       map.put("userId", repay.getUserId());
/*  699 */       BorrowRiskData borrowRiskData = (BorrowRiskData)this.borrowRiskDataMapper.findSelective(map);
/*  700 */       if (borrowRiskData == null)
/*      */       {
/*  702 */         BorrowRiskData bean = new BorrowRiskData();
/*  703 */         bean.setUserId(userId);
/*  704 */         bean.setRepayId(repay.getId());
/*      */         
/*  706 */         bean.setExpireDay(Long.valueOf(repay.getPenaltyDay()));
/*  707 */         params.clear();
/*  708 */         params.put("userId", userId);
/*  709 */         params.put("states", "states");
/*  710 */         List<UrgeRepayOrderModel> listModel = this.urgeRepayOrderService.listModel(params);
/*  711 */         if ((listModel == null) || (listModel.isEmpty())) {
/*  712 */           bean.setUrgeCount(Long.valueOf(0L));
/*      */         } else {
/*  714 */           bean.setUrgeCount(Long.valueOf(listModel.size()));
/*      */         }
/*  716 */         bean.setCreateTime(new Date());
/*  717 */         bean.setUpdateTime(new Date());
/*  718 */         bean.setLoanCount(new Long(1L));
/*  719 */         bean.setLoanSuCount(new Long(1L));
/*  720 */         bean.setLoanFailCount(new Long(0L));
/*  721 */         this.borrowRiskDataMapper.save(bean);
/*      */       }
/*      */       else {
/*  724 */         borrowRiskData.setUserId(userId);
/*  725 */         borrowRiskData.setRepayId(repay.getId());
/*  726 */         borrowRiskData.setExpireDay(Long.valueOf(repay.getPenaltyDay()));
/*  727 */         params.clear();
/*  728 */         params.put("userId", userId);
/*  729 */         params.put("states", "states");
/*  730 */         List<UrgeRepayOrderModel> listModel = this.urgeRepayOrderService.listModel(params);
/*  731 */         if ((listModel == null) || (listModel.isEmpty())) {
/*  732 */           borrowRiskData.setUrgeCount(Long.valueOf(0L));
/*      */         } else {
/*  734 */           borrowRiskData.setUrgeCount(Long.valueOf(listModel.size()));
/*      */         }
/*      */         
/*  737 */         Map<String, Long> countMap = this.clBorrowMapper.countRiskBorrow(userId.longValue());
/*  738 */         if (countMap != null) {
/*  739 */           borrowRiskData.setLoanCount((Long)countMap.get("count"));
/*  740 */           borrowRiskData.setLoanSuCount((Long)countMap.get("suc_count"));
/*  741 */           borrowRiskData.setLoanFailCount((Long)countMap.get("ref_count"));
/*      */         }
/*  743 */         borrowRiskData.setUpdateTime(new Date());
/*  744 */         this.borrowRiskDataMapper.update(borrowRiskData);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<String, Object> autoRepay(String userId, Long id)
/*      */   {
/*  755 */     Map<String, Object> returnMsg = new HashMap();
/*  756 */     Long userid = Long.valueOf(userId);
/*  757 */     Map<String, Object> param = new HashMap();
/*  758 */     param.put("id", id);
/*  759 */     param.put("state", "20");
/*  760 */     List<BorrowRepay> borrowRepayList = findUnRepay(param);
/*  761 */     if (borrowRepayList != null)
/*      */     {
/*  763 */       BorrowRepay borrowRepay = (BorrowRepay)borrowRepayList.get(0);
/*      */       
/*  765 */       User user = (User)this.userMapper.findByPrimary(userid);
/*  766 */       UserBaseInfo baseInfo = this.userBaseInfoMapper.findByUserId(userid);
/*  767 */       Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowRepay.getBorrowId()));
/*  768 */       param.clear();
/*  769 */       param.put("userId", userid);
/*  770 */       BankCard bankCard = (BankCard)this.bankCardMapper.findSelective(param);
/*      */       
/*      */ 
/*  773 */       Map<String, Object> countParam = new HashMap();
/*  774 */       Date date = new Date();
/*  775 */       DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
/*  776 */       String time = format.format(date);
/*  777 */       countParam.put("userId", userid);
/*  778 */       countParam.put("createTime", time);
/*  779 */       int count = this.payLogMapper.findPayLogCount(countParam);
/*  780 */       if (count >= 2) {
/*  781 */         returnMsg.put("Code", Integer.valueOf(400));
/*  782 */         returnMsg.put("Msg", "您当天还款次数超过2次，请通过银行卡/支付宝转账还款");
/*  783 */         return returnMsg;
/*      */       }
/*      */       
/*  786 */       Map<String, Object> payLogMap = new HashMap();
/*  787 */       payLogMap.put("userId", borrowRepay.getUserId());
/*  788 */       payLogMap.put("borrowId", Long.valueOf(borrowRepay.getBorrowId()));
/*  789 */       payLogMap.put("type", "20");
/*  790 */       payLogMap.put("scenes", "20");
/*  791 */       PayLog repaymentLog = this.payLogMapper.findLatestOne(payLogMap);
/*  792 */       autoAuthApply(borrowRepay);
/*      */       
/*  794 */       if (repaymentLog == null) {
/*  795 */         autoInsertPayMentLog(user, borrow, borrowRepay, baseInfo, bankCard);
/*      */       }
/*      */       
/*  798 */       PayLog repaymentData = this.payLogMapper.findLatestOne(payLogMap);
/*      */       
/*  800 */       if ((repaymentData != null) && (!"50".equals(repaymentData.getState()))) {
/*  801 */         if ("40".equals(repaymentData.getState())) {
/*  802 */           returnMsg.put("Code", Integer.valueOf(400));
/*  803 */           returnMsg.put("Msg", "还款已经成功，如有问题，请联系客服！");
/*  804 */           return returnMsg;
/*      */         }
/*      */         
/*  807 */         String orderNo = OrderNoUtil.getSerialNumber();
/*  808 */         QueryRepaymentModel queryRepayment = new QueryRepaymentModel(orderNo);
/*  809 */         queryRepayment.setNo_order(repaymentData.getOrderNo());
/*  810 */         queryRepayment.setDt_order(DateUtil.dateStr3(repaymentData.getPayReqTime()));
/*  811 */         LianLianHelper helper = new LianLianHelper();
/*  812 */         queryRepayment = (QueryRepaymentModel)helper.queryRepayment(queryRepayment);
/*      */         
/*  814 */         if ((queryRepayment.checkReturn()) && 
/*  815 */           ("SUCCESS".equals(queryRepayment.getResult_pay()))) {
/*  816 */           logger.info("------------------------还款计划处理成功------------------" + queryRepayment.getResult_pay());
/*      */           
/*  818 */           Map<String, Object> paramMap = new HashMap();
/*  819 */           paramMap.put("id", borrowRepay.getId());
/*  820 */           paramMap.put("repayTime", DateUtil.getNow());
/*  821 */           paramMap.put("repayWay", "40");
/*  822 */           paramMap.put("repayAccount", bankCard.getCardNo());
/*  823 */           paramMap.put("amount", String.valueOf(borrowRepay.getAmount()));
/*  824 */           paramMap.put("serialNumber", repaymentData.getOrderNo());
/*  825 */           paramMap.put("penaltyAmout", borrowRepay.getPenaltyAmout());
/*  826 */           paramMap.put("state", "10");
/*  827 */           if (!borrowRepay.getState().equals("10")) {
/*  828 */             confirmRepay(paramMap);
/*      */           }
/*      */           
/*      */ 
/*  832 */           Map<String, Object> payLogParamMap = new HashMap();
/*  833 */           payLogParamMap.put("state", "40");
/*  834 */           payLogParamMap.put("updateTime", DateUtil.getNow());
/*  835 */           payLogParamMap.put("id", repaymentData.getId());
/*  836 */           this.payLogMapper.updateSelective(payLogParamMap);
/*      */           
/*      */ 
/*  839 */           this.clSmsService.repayInform(borrowRepay.getUserId().longValue(), borrowRepay.getBorrowId());
/*      */           
/*      */ 
/*  842 */           returnMsg.put("Code", Integer.valueOf(200));
/*  843 */           returnMsg.put("Msg", "系统扣款成功，还款成功！");
/*  844 */           return returnMsg; }
/*  845 */         if ((queryRepayment.checkReturn()) && 
/*  846 */           ("PROCESSING ".equals(queryRepayment.getResult_pay()))) {
/*  847 */           logger.info("------------------------还款计划处理中------------------" + queryRepayment.getResult_pay());
/*  848 */           returnMsg.put("Code", Integer.valueOf(400));
/*  849 */           returnMsg.put("Msg", "系统扣款失败，请查看您的银行卡账户余额并联系客服！");
/*  850 */           return returnMsg;
/*      */         }
/*  852 */         logger.info("------------------------还款失败------------------" + queryRepayment.getResult_pay());
/*      */         
/*  854 */         Map<String, Object> payLogParamMap = new HashMap();
/*  855 */         payLogParamMap.put("state", "50");
/*  856 */         payLogParamMap.put("updateTime", DateUtil.getNow());
/*  857 */         payLogParamMap.put("id", repaymentData.getId());
/*  858 */         this.payLogMapper.updateSelective(payLogParamMap);
/*      */       }
/*      */       
/*  861 */       autoInsertPayMentLog(user, borrow, borrowRepay, baseInfo, bankCard);
/*  862 */       returnMsg.put("Code", Integer.valueOf(400));
/*  863 */       returnMsg.put("Msg", "系统扣款失败，请查看您的银行卡账户余额并联系客服！");
/*      */     }
/*  865 */     return returnMsg;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<String, Object> autoFuiouRepay(String userId, Long id)
/*      */   {
/*  873 */     Map<String, Object> returnMsg = new HashMap();
/*  874 */     Long userid = Long.valueOf(userId);
/*  875 */     Map<String, Object> param = new HashMap();
/*  876 */     param.put("id", id);
/*  877 */     param.put("state", "20");
/*  878 */     List<BorrowRepay> borrowRepayList = findUnRepay(param);
/*  879 */     if (borrowRepayList != null)
/*      */     {
/*  881 */       BorrowRepay borrowRepay = (BorrowRepay)borrowRepayList.get(0);
/*      */       
/*  883 */       User user = (User)this.userMapper.findByPrimary(userid);
/*  884 */       UserBaseInfo baseInfo = this.userBaseInfoMapper.findByUserId(userid);
/*  885 */       Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowRepay.getBorrowId()));
/*  886 */       param.clear();
/*  887 */       param.put("userId", userid);
/*  888 */       BankCard bankCard = (BankCard)this.bankCardMapper.findSelective(param);
/*      */       
/*      */ 
/*  891 */       Map<String, Object> countParam = new HashMap();
/*  892 */       Date date = new Date();
/*  893 */       DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
/*  894 */       String time = format.format(date);
/*  895 */       countParam.put("userId", userid);
/*  896 */       countParam.put("createTime", time);
/*  897 */       int repay_count = Global.getInt("repay_count");
/*  898 */       int count = this.payLogMapper.findPayLogCount(countParam);
/*  899 */       if (count >= repay_count) {
/*  900 */         returnMsg.put("Code", Integer.valueOf(400));
/*  901 */         returnMsg.put("Msg", "您当天还款次数超过" + repay_count + "次，请通过银行卡/支付宝转账还款");
/*  902 */         return returnMsg;
/*      */       }
/*      */       
/*  905 */       Map<String, Object> payLogMap = new HashMap();
/*  906 */       payLogMap.put("userId", borrowRepay.getUserId());
/*  907 */       payLogMap.put("borrowId", Long.valueOf(borrowRepay.getBorrowId()));
/*  908 */       payLogMap.put("type", "20");
/*  909 */       payLogMap.put("scenes", "20");
/*  910 */       PayLog repaymentLog = this.payLogMapper.findLatestOne(payLogMap);
/*      */       
/*  912 */       if (repaymentLog != null) {
/*  913 */         autoFuiouInsertPayMentLog(user, borrow, borrowRepay, baseInfo, bankCard);
/*      */       }
/*      */       
/*  916 */       PayLog repaymentData = this.payLogMapper.findLatestOne(payLogMap);
/*      */       try
/*      */       {
/*  919 */         if ((repaymentData != null) && (!"50".equals(repaymentData.getState()))) {
/*  920 */           if ("40".equals(repaymentData.getState())) {
/*  921 */             returnMsg.put("Code", Integer.valueOf(400));
/*  922 */             returnMsg.put("Msg", "还款已经成功，如有问题，请联系客服！");
/*  923 */             return returnMsg;
/*      */           }
/*  925 */           autoFuiouInsertPayMentLog(user, borrow, borrowRepay, baseInfo, bankCard);
/*      */           
/*  927 */           QrytransModel qm = new QrytransModel();
/*  928 */           qm.setType("AC01");
/*  929 */           qm.setSerialNumber(repaymentData.getOrderNo());
/*  930 */           FuiouHelper fh = new FuiouHelper();
/*  931 */           String qrytrans = fh.qrytrans(qm);
/*  932 */           Map data = XmlMapUtils.xml2map(qrytrans, false);
/*  933 */           String ret = (String)data.get("ret");
/*  934 */           logger.info("------------------------富友还款查询返回结果------------------" + JSON.toJSONString(qm));
/*  935 */           if ("000000".equals(ret))
/*      */           {
/*  937 */             Map<String, Object> paramMap = new HashMap();
/*  938 */             paramMap.put("id", borrowRepay.getId());
/*  939 */             paramMap.put("repayTime", DateUtil.getNow());
/*  940 */             paramMap.put("repayWay", "40");
/*  941 */             paramMap.put("repayAccount", bankCard.getCardNo());
/*  942 */             paramMap.put("amount", String.valueOf(borrowRepay.getAmount()));
/*  943 */             paramMap.put("serialNumber", repaymentData.getOrderNo());
/*  944 */             paramMap.put("penaltyAmout", borrowRepay.getPenaltyAmout());
/*  945 */             paramMap.put("state", "10");
/*  946 */             if (!borrowRepay.getState().equals("10")) {
/*  947 */               confirmRepay(paramMap);
/*      */             }
/*      */             
/*      */ 
/*  951 */             Map<String, Object> payLogParamMap = new HashMap();
/*  952 */             payLogParamMap.put("state", "40");
/*  953 */             payLogParamMap.put("updateTime", DateUtil.getNow());
/*  954 */             payLogParamMap.put("id", repaymentData.getId());
/*  955 */             this.payLogMapper.updateSelective(payLogParamMap);
/*      */             
/*      */ 
/*  958 */             this.clSmsService.repayInform(borrowRepay.getUserId().longValue(), borrowRepay.getBorrowId());
/*      */             
/*  960 */             returnMsg.put("Code", Integer.valueOf(200));
/*  961 */             returnMsg.put("Msg", "系统扣款成功，还款成功！");
/*  962 */             return returnMsg;
/*      */           }
/*  964 */           logger.info("------------------------还款失败------------------" + ret);
/*      */           
/*  966 */           Map<String, Object> payLogParamMap = new HashMap();
/*  967 */           payLogParamMap.put("state", "50");
/*  968 */           payLogParamMap.put("updateTime", DateUtil.getNow());
/*  969 */           payLogParamMap.put("id", repaymentData.getId());
/*  970 */           this.payLogMapper.updateSelective(payLogParamMap);
/*      */         }
/*      */       }
/*      */       catch (DocumentException e) {
/*  974 */         logger.error("解析XML发生异常");
/*      */       }
/*      */       
/*  977 */       returnMsg.put("Code", Integer.valueOf(400));
/*  978 */       returnMsg.put("Msg", "系统扣款失败，请查看您的银行卡账户余额并联系客服！");
/*      */     }
/*  980 */     return returnMsg;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<String, Object> autoFuiouProtocolRepay(String userId, Long id, String userIp, boolean... isTask)
/*      */   {
/*  988 */     boolean isSence = isTask.length > 0;
/*  989 */     Map<String, Object> returnMsg = new HashMap();
/*  990 */     Long userid = Long.valueOf(userId);
/*  991 */     Map<String, Object> param = new HashMap();
/*  992 */     param.put("id", id);
/*  993 */     param.put("state", "20");
/*  994 */     List<BorrowRepay> borrowRepayList = findUnRepay(param);
/*  995 */     if (borrowRepayList != null)
/*      */     {
/*  997 */       BorrowRepay borrowRepay = (BorrowRepay)borrowRepayList.get(0);
/*      */       
/*  999 */       User user = (User)this.userMapper.findByPrimary(userid);
/* 1000 */       UserBaseInfo baseInfo = this.userBaseInfoMapper.findByUserId(userid);
/* 1001 */       Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowRepay.getBorrowId()));
/* 1002 */       param.clear();
/* 1003 */       param.put("userId", userid);
/* 1004 */       BankCard bankCard = (BankCard)this.bankCardMapper.findSelective(param);
/*      */       
/*      */ 
/* 1007 */       Map<String, Object> countParam = new HashMap();
/* 1008 */       Date date = new Date();
/* 1009 */       DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
/* 1010 */       String time = format.format(date);
/* 1011 */       countParam.put("userId", userid);
/* 1012 */       countParam.put("createTime", time);
/* 1013 */       int repay_count = Global.getInt("repay_count");
/* 1014 */       int count = this.payLogMapper.findPayLogCount(countParam);
/* 1015 */       if (count >= repay_count) {
/* 1016 */         returnMsg.put("Code", Integer.valueOf(400));
/* 1017 */         returnMsg.put("Msg", "您当天还款次数超过" + repay_count + "次，请通过银行卡/支付宝转账还款");
/* 1018 */         return returnMsg;
/*      */       }
/*      */       
/* 1021 */       Map<String, Object> payLogMap = new HashMap();
/* 1022 */       payLogMap.put("userId", borrowRepay.getUserId());
/* 1023 */       payLogMap.put("borrowId", Long.valueOf(borrowRepay.getBorrowId()));
/* 1024 */       payLogMap.put("type", "20");
/* 1025 */       if (isSence) {
/* 1026 */         payLogMap.put("scenes", "50");
/*      */       } else {
/* 1028 */         payLogMap.put("scenes", "20");
/*      */       }
/*      */       
/* 1031 */       PayLog repaymentLog = this.payLogMapper.findLatestOne(payLogMap);
/*      */       
/* 1033 */       if (repaymentLog == null) {
/* 1034 */         autoFuiouInsertPayMentLog(user, borrow, borrowRepay, baseInfo, bankCard, userIp, new boolean[] { isSence });
/*      */       }
/*      */       
/* 1037 */       PayLog repaymentData = this.payLogMapper.findLatestOne(payLogMap);
/*      */       
/*      */       try
/*      */       {
/* 1041 */         if (repaymentData != null) {
/* 1042 */           if ("40".equals(repaymentData.getState())) {
/* 1043 */             returnMsg.put("Code", Integer.valueOf(400));
/* 1044 */             returnMsg.put("Msg", "还款已经成功，如有问题，请联系客服！");
/* 1045 */             return returnMsg; }
/* 1046 */           if (!"10".equals(repaymentData.getState())) {
/* 1047 */             autoFuiouInsertPayMentLog(user, borrow, borrowRepay, baseInfo, bankCard, userIp, new boolean[] { isSence });
/* 1048 */             repaymentData = this.payLogMapper.findLatestOne(payLogMap);
/*      */           }
/*      */           
/* 1051 */           QueryRePayResultModel beanReq = new QueryRePayResultModel();
/* 1052 */           beanReq.setMchntOrderId(repaymentData.getOrderNo());
/* 1053 */           Map<String, Object> data = beanReq.submit();
/* 1054 */           String ret = (String)data.get("RESPONSECODE");
/* 1055 */           logger.info("------------------------富友还款查询返回结果------------------" + JSON.toJSONString(ret));
/* 1056 */           if ("0000".equals(ret))
/*      */           {
/* 1058 */             Map<String, Object> paramMap = new HashMap();
/* 1059 */             paramMap.put("id", borrowRepay.getId());
/* 1060 */             paramMap.put("repayTime", DateUtil.getNow());
/* 1061 */             paramMap.put("repayWay", "40");
/* 1062 */             paramMap.put("repayAccount", bankCard.getCardNo());
/* 1063 */             paramMap.put("amount", String.valueOf(borrowRepay.getAmount()));
/* 1064 */             paramMap.put("serialNumber", repaymentData.getOrderNo());
/* 1065 */             paramMap.put("penaltyAmout", borrowRepay.getPenaltyAmout());
/* 1066 */             paramMap.put("state", "10");
/* 1067 */             if (!borrowRepay.getState().equals("10")) {
/* 1068 */               confirmRepay(paramMap);
/*      */             }
/*      */             
/*      */ 
/* 1072 */             Map<String, Object> payLogParamMap = new HashMap();
/* 1073 */             payLogParamMap.put("state", "40");
/* 1074 */             payLogParamMap.put("updateTime", DateUtil.getNow());
/* 1075 */             payLogParamMap.put("id", repaymentData.getId());
/* 1076 */             this.payLogMapper.updateSelective(payLogParamMap);
/*      */             
/*      */ 
/* 1079 */             this.clSmsService.repayInform(borrowRepay.getUserId().longValue(), borrowRepay.getBorrowId());
/*      */             
/* 1081 */             returnMsg.put("Code", Integer.valueOf(200));
/* 1082 */             returnMsg.put("Msg", "系统扣款成功，还款成功！");
/* 1083 */             return returnMsg;
/*      */           }
/* 1085 */           logger.info("------------------------还款失败------------------" + ret);
/*      */           
/* 1087 */           Map<String, Object> payLogParamMap = new HashMap();
/* 1088 */           payLogParamMap.put("state", "50");
/* 1089 */           payLogParamMap.put("updateTime", DateUtil.getNow());
/* 1090 */           payLogParamMap.put("id", repaymentData.getId());
/* 1091 */           this.payLogMapper.updateSelective(payLogParamMap);
/*      */         }
/*      */       }
/*      */       catch (Exception e)
/*      */       {
/* 1096 */         e.printStackTrace();
/*      */       }
/*      */       
/* 1099 */       returnMsg.put("Code", Integer.valueOf(400));
/* 1100 */       returnMsg.put("Msg", "系统扣款失败，请查看您的银行卡账户余额并联系客服！");
/*      */     }
/* 1102 */     return returnMsg;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void autoInsertPayMentLog(User user, Borrow borrow, BorrowRepay borrowRepay, UserBaseInfo baseInfo, BankCard bankCard)
/*      */   {
/* 1109 */     Date payReqTime = DateUtil.getNow();
/* 1110 */     String orderNo = OrderNoUtil.getSerialNumber();
/* 1111 */     RepaymentModel repayment = new RepaymentModel(orderNo);
/* 1112 */     repayment.setUser_id(user.getUuid());
/* 1113 */     repayment.setBusi_partner("101001");
/* 1114 */     repayment.setDt_order(DateUtil.dateStr3(payReqTime));
/* 1115 */     repayment.setName_goods("还款" + borrow.getOrderNo());
/* 1116 */     repayment.setInfo_order("repayment_" + borrow.getOrderNo());
/*      */     
/* 1118 */     double amount = BigDecimalUtil.add(new double[] { borrowRepay.getAmount().doubleValue(), borrowRepay.getPenaltyAmout().doubleValue() });
/* 1119 */     if ("dev".equals(Global.getValue("app_environment"))) {
/* 1120 */       repayment.setMoney_order("0.01");
/*      */     } else {
/* 1122 */       repayment.setMoney_order(StringUtil.isNull(Double.valueOf(amount)));
/*      */     }
/*      */     
/* 1125 */     repayment.setAmount(amount);
/* 1126 */     RiskItems riskItems = new RiskItems();
/* 1127 */     riskItems.setFrms_ware_category("2010");
/* 1128 */     riskItems.setUser_info_mercht_userno(user.getUuid());
/* 1129 */     riskItems.setUser_info_bind_phone(baseInfo.getPhone());
/* 1130 */     riskItems.setUser_info_dt_register(DateUtil.dateStr3(user.getRegistTime()));
/* 1131 */     riskItems.setUser_info_full_name(baseInfo.getRealName());
/* 1132 */     riskItems.setUser_info_id_no(baseInfo.getIdNo());
/* 1133 */     riskItems.setUser_info_identify_type("1");
/* 1134 */     riskItems.setUser_info_identify_state("1");
/* 1135 */     repayment.setRisk_item(JSONObject.toJSONString(riskItems));
/* 1136 */     repayment.setSchedule_repayment_date(DateUtil.dateStr2(borrowRepay.getRepayTime()));
/* 1137 */     repayment.setRepayment_no(borrow.getOrderNo());
/* 1138 */     repayment.setNo_agree(bankCard.getAgreeNo());
/* 1139 */     repayment.setNotify_url(Global.getValue("server_host") + "/pay/lianlian/repaymentNotify.htm");
/*      */     
/* 1141 */     LianLianHelper helper = new LianLianHelper();
/* 1142 */     repayment = (RepaymentModel)helper.repayment(repayment);
/*      */     
/* 1144 */     logger.info("------------------------还款计划请求对象------------------" + JSONArray.toJSONString(repayment));
/*      */     
/* 1146 */     PayLog payLog = new PayLog();
/* 1147 */     payLog.setOrderNo(repayment.getOrderNo());
/* 1148 */     payLog.setUserId(borrowRepay.getUserId());
/* 1149 */     payLog.setBorrowId(Long.valueOf(borrowRepay.getBorrowId()));
/* 1150 */     payLog.setAmount(Double.valueOf(repayment.getAmount()));
/* 1151 */     payLog.setCardNo(bankCard.getCardNo());
/* 1152 */     payLog.setBank(bankCard.getBank());
/* 1153 */     payLog.setSource("10");
/* 1154 */     payLog.setType("20");
/* 1155 */     payLog.setScenes("20");
/* 1156 */     payLog.setState("10");
/* 1157 */     payLog.setRemark(repayment.getRet_msg());
/* 1158 */     payLog.setPayReqTime(payReqTime);
/* 1159 */     payLog.setCreateTime(DateUtil.getNow());
/* 1160 */     this.payLogMapper.save(payLog);
/*      */   }
/*      */   
/*      */ 
/*      */   private void autoFuiouInsertPayMentLog(User user, Borrow borrow, BorrowRepay borrowRepay, UserBaseInfo baseInfo, BankCard bankCard)
/*      */   {
/* 1166 */     Date payReqTime = DateUtil.getNow();
/* 1167 */     double amount = BigDecimalUtil.add(new double[] { borrowRepay.getAmount().doubleValue(), borrowRepay.getPenaltyAmout().doubleValue() });
/* 1168 */     IncomeforreqModel model = new IncomeforreqModel();
/* 1169 */     if ("dev".equals(Global.getValue("app_environment"))) {
/* 1170 */       model.setAmt(Long.valueOf(1L));
/*      */     } else {
/* 1172 */       model.setAmt(Long.valueOf(new Double(amount * 100.0D).longValue()));
/*      */     }
/* 1174 */     model.setBankno(bankCard.getBank());
/* 1175 */     model.setAccntno(bankCard.getCardNo());
/* 1176 */     model.setAccntnm(baseInfo.getRealName());
/* 1177 */     model.setMobile(bankCard.getPhone());
/* 1178 */     model.setCertno(baseInfo.getIdNo());
/*      */     
/*      */ 
/* 1181 */     RiskItems riskItems = new RiskItems();
/* 1182 */     riskItems.setFrms_ware_category("2010");
/* 1183 */     riskItems.setUser_info_mercht_userno(user.getUuid());
/* 1184 */     riskItems.setUser_info_bind_phone(baseInfo.getPhone());
/* 1185 */     riskItems.setUser_info_dt_register(DateUtil.dateStr3(user.getRegistTime()));
/* 1186 */     riskItems.setUser_info_full_name(baseInfo.getRealName());
/* 1187 */     riskItems.setUser_info_id_no(baseInfo.getIdNo());
/* 1188 */     riskItems.setUser_info_identify_type("1");
/* 1189 */     riskItems.setUser_info_identify_state("1");
/* 1190 */     FuiouHelper fh = new FuiouHelper();
/* 1191 */     String res = fh.incomeforreq(model);
/* 1192 */     logger.info("------------------------富友还款计返回结果------------------" + res);
/*      */     try {
/* 1194 */       Map data = XmlMapUtils.xml2map(res, false);
/* 1195 */       PayLog payLog = new PayLog();
/* 1196 */       payLog.setOrderNo(model.getOrderNo());
/* 1197 */       payLog.setUserId(borrowRepay.getUserId());
/* 1198 */       payLog.setBorrowId(Long.valueOf(borrowRepay.getBorrowId()));
/* 1199 */       payLog.setAmount(Double.valueOf(amount));
/* 1200 */       payLog.setCardNo(bankCard.getCardNo());
/* 1201 */       payLog.setBank(bankCard.getBank());
/* 1202 */       payLog.setSource("10");
/* 1203 */       payLog.setType("20");
/* 1204 */       payLog.setScenes("20");
/* 1205 */       payLog.setState("10");
/* 1206 */       payLog.setPayReqTime(payReqTime);
/* 1207 */       payLog.setCreateTime(DateUtil.getNow());
/* 1208 */       payLog.setRemark((String)data.get("memo"));
/* 1209 */       this.payLogMapper.save(payLog);
/*      */     } catch (DocumentException e) {
/* 1211 */       logger.error("解析XML发生异常");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void autoFuiouInsertPayMentLog(User user, Borrow borrow, BorrowRepay borrowRepay, UserBaseInfo baseInfo, BankCard bankCard, String userIp, boolean... isTask)
/*      */   {
/* 1218 */     Date payReqTime = DateUtil.getNow();
/* 1219 */     double amount = BigDecimalUtil.add(new double[] { borrowRepay.getAmount().doubleValue(), borrowRepay.getPenaltyAmout().doubleValue() });
/* 1220 */     RePayModel beanReq = new RePayModel();
/* 1221 */     if ("dev".equals(Global.getValue("app_environment"))) {
/* 1222 */       beanReq.setAmt(Long.valueOf(1L));
/*      */     } else {
/* 1224 */       beanReq.setAmt(Long.valueOf(new Double(amount * 100.0D).longValue()));
/*      */     }
/* 1226 */     beanReq.setProtocolNo(bankCard.getAgreeNo());
/* 1227 */     beanReq.setUserId(baseInfo.getUserId().toString());
/* 1228 */     beanReq.setUserIp(userIp);
/*      */     try
/*      */     {
/* 1231 */       RiskItems riskItems = new RiskItems();
/* 1232 */       riskItems.setFrms_ware_category("2010");
/* 1233 */       riskItems.setUser_info_mercht_userno(user.getUuid());
/* 1234 */       riskItems.setUser_info_bind_phone(baseInfo.getPhone());
/* 1235 */       riskItems.setUser_info_dt_register(DateUtil.dateStr3(user.getRegistTime()));
/* 1236 */       riskItems.setUser_info_full_name(baseInfo.getRealName());
/* 1237 */       riskItems.setUser_info_id_no(baseInfo.getIdNo());
/* 1238 */       riskItems.setUser_info_identify_type("1");
/* 1239 */       riskItems.setUser_info_identify_state("1");
/*      */       
/* 1241 */       Map respData = beanReq.submit();
/*      */       
/* 1243 */       PayLog payLog = new PayLog();
/* 1244 */       payLog.setOrderNo(beanReq.getMchntOrderId());
/* 1245 */       payLog.setUserId(borrowRepay.getUserId());
/* 1246 */       payLog.setBorrowId(Long.valueOf(borrowRepay.getBorrowId()));
/* 1247 */       payLog.setAmount(Double.valueOf(amount));
/* 1248 */       payLog.setCardNo(bankCard.getCardNo());
/* 1249 */       payLog.setBank(bankCard.getBank());
/* 1250 */       payLog.setSource("10");
/* 1251 */       payLog.setType("20");
/* 1252 */       if (isTask[0]) {
/* 1253 */         payLog.setScenes("50");
/*      */       }
/*      */       else {
/* 1256 */         payLog.setScenes("20");
/*      */       }
/* 1258 */       payLog.setState("10");
/* 1259 */       payLog.setPayReqTime(payReqTime);
/* 1260 */       payLog.setCreateTime(DateUtil.getNow());
/* 1261 */       payLog.setRemark((String)respData.get("RESPONSEMSG"));
/* 1262 */       this.payLogMapper.save(payLog);
/*      */     } catch (Exception e) {
/* 1264 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ }
