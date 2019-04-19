/*      */ package com.cashloan.cl.service.impl;
/*      */ 
/*      */

import com.alibaba.fastjson.JSONObject;
import com.cashloan.cl.domain.*;
import com.cashloan.cl.mapper.*;
import com.cashloan.cl.model.*;
import com.cashloan.cl.model.pay.fuiou.utils.XmlMapUtils;
import com.cashloan.cl.model.pay.lianlian.PaymentModel;
import com.cashloan.cl.model.pay.lianlian.util.LianLianHelper;
import com.cashloan.cl.monitor.BusinessExceptionMonitor;
import com.cashloan.cl.service.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.cl.model.pay.fuiou.PayforreqModel;
import com.rongdu.cashloan.cl.model.pay.fuiou.utils.FuiouHelper;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.exception.SimpleMessageException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.*;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.User;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.core.mapper.UserMapper;
import com.rongdu.cashloan.core.model.BorrowModel;
import com.rongdu.cashloan.core.service.UserBaseInfoService;
import com.rongdu.cashloan.rc.domain.SceneBusinessLog;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import com.rongdu.cashloan.rc.mapper.SceneBusinessLogMapper;
import com.rongdu.cashloan.rc.mapper.SceneBusinessMapper;
import com.rongdu.cashloan.rc.model.TppServiceInfoModel;
import com.rongdu.cashloan.rc.service.*;
import com.rongdu.cashloan.rule.domain.BorrowRuleResult;
import com.rongdu.cashloan.rule.domain.RuleEngineConfig;
import com.rongdu.cashloan.rule.mapper.BorrowRuleEngineMapper;
import com.rongdu.cashloan.rule.mapper.BorrowRuleResultMapper;
import com.rongdu.cashloan.rule.mapper.RuleEngineConfigMapper;
import com.rongdu.cashloan.rule.mapper.RuleEngineMapper;
import com.rongdu.cashloan.rule.model.ManageReviewModel;
import com.rongdu.cashloan.rule.model.ManageRuleResultModel;
import com.rongdu.cashloan.rule.model.srule.client.RulesExecutorUtil;
import com.rongdu.cashloan.rule.model.srule.model.SimpleRule;
import com.rongdu.cashloan.rule.model.srule.utils.GenerateRule;
import com.rongdu.cashloan.system.domain.SysDictDetail;
import com.rongdu.cashloan.system.service.SysConfigService;
import com.rongdu.cashloan.system.service.SysDictDetailService;
import com.rongdu.creditrank.cr.domain.Credit;
import com.rongdu.creditrank.cr.mapper.CreditMapper;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.util.BigDecimalUtil;
import tool.util.RandomUtil;

import javax.annotation.Resource;
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
/*      */ @Service("clBorrowService")
/*      */ @Transactional(rollbackFor={Exception.class})
/*      */ public class ClBorrowServiceImpl
/*      */   extends BaseServiceImpl<Borrow, Long>
/*      */   implements ClBorrowService
/*      */ {
/*  150 */   private static final Logger logger = LoggerFactory.getLogger(ClBorrowServiceImpl.class);
/*      */   @Resource
/*      */   SysDictDetailService sysDictDetailService;
/*      */   @Resource
/*      */   private ClBorrowMapper clBorrowMapper;
/*      */   @Resource
/*      */   private PayRespLogService payRespLogService;
/*      */   @Resource
/*      */   private BorrowProgressMapper borrowProgressMapper;
/*      */   @Resource
/*      */   private BorrowRepayMapper borrowRepayMapper;
/*      */   @Resource
/*      */   private CreditMapper creditMapper;
/*      */   @Resource
/*      */   private BorrowRepayLogMapper borrowRepayLogMapper;
/*      */   @Resource
/*      */   private BankCardMapper bankCardMapper;
/*      */   @Resource
/*      */   private UserInviteMapper userInviteMapper;
/*      */   @Resource
/*      */   private PayReqLogService payReqLogService;
/*      */   @Resource
/*      */   private ProfitAgentMapper profitAgentMapper;
/*      */   @Resource
/*      */   private UserMapper userMapper;
/*      */   @Resource
/*      */   private UserAuthService userAuthService;
/*      */   @Resource
/*      */   private BorrowRuleEngineMapper borrowRuleEngineMapper;
/*      */   @Resource
/*      */   private RuleEngineConfigMapper ruleEngineConfigMapper;
/*      */   @Resource
/*      */   private BorrowRuleResultMapper borrowRuleResultMapper;
/*      */   @Resource
/*      */   private RcQianchenService rcQianchenService;
/*      */   @Resource
/*      */   private QianchengReqlogMapper qianchengReqlogMapper;
/*      */   @Resource
/*      */   private UserBaseInfoMapper userBaseInfoMapper;
/*      */   @Resource
/*      */   private PayLogMapper payLogMapper;
/*      */   @Resource
/*      */   private OperatorReqLogMapper operatorReqLogMapper;
/*      */   @Resource
/*      */   private UrgeRepayOrderMapper urgeRepayOrderMapper;
/*      */   @Resource
/*      */   private RuleEngineMapper ruleEngineMapper;
/*      */   @Resource
/*      */   private ClSmsService clSmsService;
/*      */   @Resource
/*      */   private TongdunReqLogService tongdunReqLogService;
/*      */   @Resource
/*      */   private SceneBusinessLogMapper sceneBusinessLogMapper;
/*      */   @Resource
/*      */   private SceneBusinessLogService sceneBusinessLogService;
/*      */   @Resource
/*      */   private SceneBusinessMapper sceneBusinessMapper;
/*      */   @Resource
/*      */   private ZhimaService zhimaService;
/*      */   @Resource
/*      */   private OperatorCountService operatorCountService;
/*      */   @Resource
/*      */   private ContactCountService contactCountService;
/*      */   @Resource
/*      */   private BorrowCountService borrowCountService;
/*      */   @Resource
/*      */   private SimpleBorrowCountService simpleBorrowCountService;
/*      */   @Resource
/*      */   private SimpleVoicesCountService simpleVoicesCountService;
/*      */   @Resource
/*      */   private SimpleContactCountService simpleContactCountService;
/*      */   @Resource
/*      */   private UserBaseInfoService userBaseInfoService;
/*      */   @Resource
/*      */   private TppBusinessService tppBusinessService;
/*      */   @Resource
/*      */   private RcHuadaoBlacklistLogService rcHuadaoBlacklistLogService;
/*      */   @Resource
/*      */   private DhbReqLogService dhbReqLogService;
/*      */   @Resource
/*      */   private BorrowRepayService borrowRepayService;
/*      */   @Resource
/*      */   private SysConfigService sysConfigService;
/*      */   @Resource
/*      */   private FireeyesBlackLogService fireeyesBlackLogService;
/*      */   @Resource
/*      */   private QianChengBlacklistLogService qianChengBlacklistLogService;
/*      */   @Resource
/*      */   private WhiteKnightService whiteKnightService;
/*      */   @Resource
/*      */   private YoudunModelService youdunModelService;
/*      */   
/*      */   public BaseMapper<Borrow, Long> getMapper() {
/*  243 */     return this.clBorrowMapper;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isCanBorrow(Borrow borrow, String tradePwd)
/*      */   {
/*  249 */     Long userId = borrow.getUserId();
/*  250 */     User user = (User)this.userMapper.findByPrimary(userId);
/*      */     
/*      */ 
/*  253 */     if ((user == null) || (user.getId().longValue() < 1L)) {
/*  254 */       throw new SimpleMessageException("找不到对应的用户信息");
/*      */     }
/*      */     
/*  257 */     if (StringUtil.isBlank(user.getTradePwd())) {
/*  258 */       throw new SimpleMessageException("请先设置交易密码!");
/*      */     }
/*  260 */     if (!user.getTradePwd().equals(tradePwd)) {
/*  261 */       throw new SimpleMessageException(String.valueOf(401), "交易密码不正确!");
/*      */     }
/*      */     
/*  264 */     UserBaseInfo userBaseInfo = this.userBaseInfoMapper.findByUserId(userId);
/*  265 */     if ((userBaseInfo != null) && ("10".equals(userBaseInfo.getState()))) {
/*  266 */       throw new SimpleMessageException("该账号无法借款,请联系客服人员。");
/*      */     }
/*      */     
/*      */ 
/*  270 */     String time = DateUtil.dateStr2(new Date());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  278 */     Map<String, Object> authMap = new HashMap();
/*  279 */     authMap.put("userId", userId);
/*  280 */     Map<String, Object> auth = this.userAuthService.getAuthState(authMap);
/*  281 */     if ((StringUtil.isBlank(auth)) || (Integer.parseInt(auth.get("qualified").toString()) == 0)) {
/*  282 */       throw new SimpleMessageException("资料未完善，无法借款");
/*      */     }
/*      */     
/*      */ 
/*  286 */     List<Borrow> list = this.clBorrowMapper.findUserUnFinishedBorrow(userId);
/*  287 */     if (list.size() > 0) {
/*  288 */       throw new SimpleMessageException("有未完成借款，无法借款");
/*      */     }
/*      */     
/*      */ 
/*  292 */     int day = 0;
/*  293 */     String againBorrow = Global.getValue("again_borrow");
/*  294 */     Map<String, Object> searchMap = new HashMap();
/*  295 */     searchMap.put("userId", userId);
/*  296 */     Borrow borrowTemp = findLast(searchMap);
/*  297 */     if (StringUtil.isNotBlank(borrowTemp)) {
/*  298 */       day = DateUtil.daysBetween(borrowTemp.getCreateTime(), new Date());
/*  299 */       day = Integer.parseInt(againBorrow) - day;
/*  300 */       if (day > 0) {
/*  301 */         throw new SimpleMessageException("申请失败,您在" + day + "天后才能再次借款");
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  306 */     String orderNo = this.operatorReqLogMapper.findOrderByUserId(userId);
/*  307 */     if (StringUtil.isBlank(orderNo)) {
/*  308 */       throw new SimpleMessageException("运营商认证数据不正确");
/*      */     }
/*      */     
/*      */ 
/*  312 */     String borrowDay = Global.getValue("borrow_day");
/*  313 */     String[] days = borrowDay.split(",");
/*  314 */     int maxDays = Integer.parseInt(days[(days.length - 1)]);
/*  315 */     int minDays = Integer.parseInt(days[0]);
/*  316 */     String borrowCredit = Global.getValue("borrow_credit");
/*  317 */     String[] credits = borrowCredit.split(",");
/*  318 */     double maxCredit = Double.parseDouble(credits[(credits.length - 1)]);
/*  319 */     double minCredit = Double.parseDouble(credits[0]);
/*  320 */     Double amount = borrow.getAmount();
/*      */     
/*  322 */     if ((Math.abs(borrow.getAmount().doubleValue()) % 10.0D != 0.0D) || (amount.doubleValue() < minCredit) || (amount.doubleValue() > maxCredit)) {
/*  323 */       throw new SimpleMessageException("借款金额格式不正确");
/*      */     }
/*      */     
/*      */ 
/*  327 */     Map<String, Object> creditMap = new HashMap();
/*  328 */     creditMap.put("consumerNo", borrow.getUserId());
/*  329 */     Credit credit = (Credit)this.creditMapper.findSelective(creditMap);
/*  330 */     if ((StringUtil.isBlank(credit)) || (credit.getUnuse().doubleValue() < borrow.getAmount().doubleValue())) {
/*  331 */       throw new SimpleMessageException("额度不足，无法借款");
/*      */     }
/*      */     
/*      */ 
/*  335 */     double borrowTotal = this.clBorrowMapper.borrowAmountSum();
/*      */     
/*  337 */     double loanCeiling = Global.getDouble("loan_ceiling");
/*  338 */     if ((borrowTotal > 0.0D) && (loanCeiling > 0.0D) && (borrowTotal >= loanCeiling)) {
/*  339 */       throw new SimpleMessageException("今日借款已达上限，请明天再来！");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  346 */     return true;
/*      */   }
/*      */   
/*      */   public List<RepayModel> findRepay(Map<String, Object> searchMap)
/*      */   {
/*  351 */     List<RepayModel> modelList = this.clBorrowMapper.findRepay(searchMap);
/*  352 */     for (RepayModel repayModel : modelList) {
/*  353 */       if (StringUtil.isNotBlank(repayModel)) {
/*  354 */         int day = DateUtil.daysBetween(new Date(), 
/*  355 */           repayModel.getRepayTime());
/*  356 */         if (day > 0) {
/*  357 */           repayModel.setIsPunish("false");
/*  358 */           repayModel.setMsg(day + "天后还款");
/*  359 */         } else if (day == 0) {
/*  360 */           repayModel.setIsPunish("false");
/*  361 */           repayModel.setMsg("今日还款");
/*      */         } else {
/*  363 */           repayModel.setIsPunish("true");
/*  364 */           repayModel.setMsg("已逾期" + Math.abs(day) + "天");
/*      */         }
/*  366 */         repayModel.setRepayTimeStr(DateUtil.dateStr8(repayModel
/*  367 */           .getRepayTime()));
/*      */       }
/*      */     }
/*  370 */     return modelList;
/*      */   }
/*      */   
/*      */ 
/*      */   public Page<ClBorrowModel> page(Map<String, Object> searchMap, int current, int pageSize)
/*      */   {
/*  376 */     PageHelper.startPage(current, pageSize);
/*  377 */     List<ClBorrowModel> list = this.clBorrowMapper.listAll(searchMap);
/*  378 */     for (ClBorrowModel clBorrowModel : list) {
/*  379 */       clBorrowModel.setCreditTimeStr(DateUtil.dateStr(
/*  380 */         clBorrowModel.getCreateTime(), "yyyy-MM-dd HH:mm"));
/*  381 */       clBorrowModel.setStateStr(clBorrowModel.getState());
/*  382 */       if (("审核通过".equals(clBorrowModel.getStateStr())) || ("放款失败".equals(clBorrowModel.getStateStr()))) {
/*  383 */         clBorrowModel.setState("打款中");
/*  384 */         clBorrowModel.setStateStr("打款中");
/*      */       }
/*  386 */       if ("还款中".equals(clBorrowModel.getStateStr())) {
/*  387 */         clBorrowModel.setState("待还款");
/*  388 */         clBorrowModel.setStateStr("待还款");
/*      */       }
/*      */     }
/*  391 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public List<IndexModel> listIndex()
/*      */   {
/*  396 */     List<IndexModel> list = this.clBorrowMapper.listIndex();
/*  397 */     List indexList = new ArrayList();
/*  398 */     for (int i = 0; i < list.size(); i++) {
/*  399 */       String cardNo = ((IndexModel)list.get(i)).getCardNo();
/*  400 */       if (!StringUtil.isBlank(cardNo))
/*      */       {
/*      */ 
/*  403 */         cardNo = StringUtil.substring(cardNo, cardNo.length() - 4);
/*  404 */         double money = ((IndexModel)list.get(i)).getAmount().doubleValue();
/*  405 */         int time = 0;
/*  406 */         if ((list.get(i) != null) && (((IndexModel)list.get(i)).getCreateTime() != null) && 
/*  407 */           (((IndexModel)list.get(i)).getLoanTime() != null)) {
/*  408 */           time = DateUtil.minuteBetween(((IndexModel)list.get(i)).getCreateTime(), 
/*  409 */             ((IndexModel)list.get(i)).getLoanTime());
/*      */         }
/*      */         
/*  412 */         String value = "尾号" + cardNo + " " + "成功借款" + (int)money + 
/*  413 */           "元 用时" + time + "分钟";
/*  414 */         Map<String, Object> map = new HashMap();
/*  415 */         map.put("id", Integer.valueOf(i));
/*  416 */         map.put("value", value);
/*  417 */         indexList.add(map);
/*      */       } }
/*  419 */     return indexList;
/*      */   }
/*      */   
/*      */   public Map<String, Object> findIndex(String userId)
/*      */   {
/*  424 */     String fee = Global.getValue("fee");
/*  425 */     double loanCeiling = Global.getDouble("loan_ceiling");
/*      */     
/*  427 */     double repayTotal = this.clBorrowMapper.borrowAmountSum();
/*      */     
/*  429 */     if ((loanCeiling <= 0.0D) || (loanCeiling <= repayTotal)) {
/*  430 */       loanCeiling = 0.0D;
/*      */     } else {
/*  432 */       loanCeiling -= repayTotal;
/*      */     }
/*  434 */     String[] fees = fee.split(",");
/*  435 */     String borrowDay = Global.getValue("borrow_day");
/*  436 */     String[] days = borrowDay.split(",");
/*  437 */     int maxDays = Integer.parseInt(days[(days.length - 1)]);
/*  438 */     int minDays = Integer.parseInt(days[0]);
/*  439 */     String borrowCredit = Global.getValue("borrow_credit");
/*  440 */     String[] credits = borrowCredit.split(",");
/*  441 */     double maxCredit = Double.parseDouble(credits[(credits.length - 1)]);
/*  442 */     double minCredit = Double.parseDouble(credits[0]);
/*  443 */     String title = Global.getValue("title");
/*  444 */     int authTotal = Global.getInt("auth_total");
/*      */     
/*      */ 
/*      */ 
/*  448 */     Boolean isBorrow = Boolean.valueOf(false);
/*      */     
/*  450 */     Map<String, Object> result = new HashMap();
/*  451 */     Map<String, Object> auth = new HashMap();
/*  452 */     if ((StringUtil.isNotBlank(userId)) && (!StringUtil.equals(userId, "0"))) {
/*  453 */       result.put("total", Global.getValue("init_credit"));
/*      */     } else {
/*  455 */       String unregistered_credit = Global.getValue("unregistered_credit");
/*  456 */       if ((unregistered_credit == null) || (unregistered_credit.equals(""))) {
/*  457 */         unregistered_credit = Global.getValue("init_credit");
/*      */       }
/*  459 */       result.put("total", unregistered_credit);
/*      */     }
/*  461 */     auth.put("total", Integer.valueOf(authTotal));
/*  462 */     auth.put("result", Integer.valueOf(0));
/*  463 */     auth.put("qualified", Integer.valueOf(0));
/*  464 */     result.put("cardNo", "");
/*  465 */     if ((StringUtil.isNotBlank(userId)) && (!StringUtil.equals(userId, "0"))) {
/*  466 */       User user = (User)this.userMapper.findByPrimary(Long.valueOf(Long.parseLong(userId)));
/*  467 */       boolean isPwd = false;
/*  468 */       if ((StringUtil.isNotBlank(user)) && (StringUtil.isNotBlank(user.getTradePwd()))) {
/*  469 */         isPwd = true;
/*      */       }
/*  471 */       result.put("isPwd", Boolean.valueOf(isPwd));
/*  472 */       Map<String, Object> paramMap = new HashMap();
/*  473 */       paramMap.put("userId", Long.valueOf(Long.parseLong(userId)));
/*      */       try {
/*  475 */         BankCard bc = (BankCard)this.bankCardMapper.findSelective(paramMap);
/*  476 */         if (StringUtil.isNotBlank(bc)) {
/*  477 */           result.put("cardId", bc.getId());
/*  478 */           result.put("cardNo", bc.getCardNo());
/*  479 */           SysDictDetail findDetail = this.sysDictDetailService.findDetail(bc.getBank(), "BANK_TYPE");
/*  480 */           result.put("cardName", findDetail.getItemValue());
/*  481 */           result.put("cardNoShort", bc.getCardNo().substring(bc.getCardNo().length() - 4, bc.getCardNo().length()));
/*      */         }
/*      */       } catch (ServiceException e) {
/*  484 */         e.printStackTrace();
/*      */       }
/*  486 */       long count = this.clBorrowMapper.countBorrow(Long.parseLong(userId));
/*  487 */       Map<String, Object> borrowMap = new HashMap();
/*  488 */       borrowMap.put("userId", Long.valueOf(Long.parseLong(userId)));
/*  489 */       Borrow borrow = this.clBorrowMapper.findRepayBorrow(borrowMap);
/*  490 */       List<BorrowProgressModel> list = new ArrayList();
/*  491 */       if (borrow != null) {
/*  492 */         if ((borrow.getState().equals("30")) || 
/*  493 */           (borrow.getState().equals("50")) || 
/*  494 */           (borrow.getState().equals("90"))) {
/*  495 */           result.put("isRepay", Boolean.valueOf(true));
/*      */         } else {
/*  497 */           result.put("isRepay", Boolean.valueOf(false));
/*      */         }
/*      */       }
/*  500 */       if (borrow != null) {
/*  501 */         list = borrowProgress(borrow, "index");
/*  502 */         result.put("list", list);
/*  503 */         result.put("borrowId", borrow.getId());
/*      */       }
/*      */       
/*  506 */       if ((borrow != null) && (getBorrowDays(borrow.getUserId()) > 0)) {
/*  507 */         isBorrow = Boolean.valueOf(true);
/*      */       }
/*      */       
/*  510 */       if ((list != null) && (!list.isEmpty())) {
/*  511 */         isBorrow = Boolean.valueOf(true);
/*  512 */         Map<String, Object> unRepayMap = new HashMap();
/*  513 */         List<String> stateList = Arrays.asList(new String[] { "10", 
/*  514 */           "20", 
/*  515 */           "22", "26", 
/*  516 */           "30" });
/*  517 */         unRepayMap.put("userId", userId);
/*  518 */         unRepayMap.put("stateList", stateList);
/*  519 */         Borrow unRepayBorrow = this.clBorrowMapper.findByUserIdAndState(unRepayMap);
/*  520 */         if (unRepayBorrow != null) {
/*  521 */           borrow = unRepayBorrow;
/*      */         }
/*      */       }
/*      */       
/*  525 */       result.put("borrow", borrow);
/*      */       
/*  527 */       Map<String, Object> authMap = new HashMap();
/*  528 */       authMap.put("userId", userId);
/*  529 */       auth = this.userAuthService.getAuthState(authMap);
/*      */       
/*  531 */       if ((auth != null) && (auth.get("qualified") != null) && 
/*  532 */         (Integer.parseInt(auth.get("qualified").toString()) == 1))
/*      */       {
/*  534 */         Map<String, Object> creditMap = new HashMap();
/*  535 */         creditMap.put("consumerNo", userId);
/*  536 */         Credit credit = (Credit)this.creditMapper.findSelective(creditMap);
/*  537 */         result.put("total", credit.getUnuse());
/*  538 */         if ((StringUtil.isNotBlank(credit)) && 
/*  539 */           ("10".equals(credit.getState()))) {
/*  540 */           result.put("total", credit.getUnuse());
/*  541 */           if (credit.getTotal().doubleValue() - credit.getUsed().doubleValue() < 100.0D) {
/*  542 */             minCredit = credit.getTotal().doubleValue() - credit.getUsed().doubleValue();
/*      */           }
/*  544 */           maxCredit = credit.getUnuse().doubleValue();
/*      */         }
/*      */       }
/*  547 */       result.put("count", Long.valueOf(count));
/*      */     }
/*      */     
/*  550 */     result.put("auth", auth);
/*  551 */     result.put("maxCredit", Double.valueOf(maxCredit));
/*  552 */     result.put("minCredit", Double.valueOf(minCredit));
/*  553 */     List creditList = new ArrayList();
/*  554 */     List dayList = new ArrayList();
/*  555 */     List interests = new ArrayList();
/*  556 */     for (int i = 0; i < credits.length; i++) {
/*  557 */       creditList.add(credits[i]);
/*      */     }
/*  559 */     for (int i = 0; i < days.length; i++) {
/*  560 */       dayList.add(days[i]);
/*      */     }
/*  562 */     for (int i = 0; i < fees.length; i++) {
/*  563 */       interests.add(fees[i]);
/*      */     }
/*  565 */     result.put("creditList", creditList);
/*  566 */     result.put("dayList", dayList);
/*  567 */     result.put("interests", interests);
/*  568 */     result.put("maxDays", Integer.valueOf(maxDays));
/*  569 */     result.put("minDays", Integer.valueOf(minDays));
/*  570 */     result.put("isBorrow", isBorrow);
/*  571 */     result.put("title", title);
/*  572 */     result.put("loanCeiling", Double.valueOf(loanCeiling));
/*  573 */     return result;
/*      */   }
/*      */   
/*      */   public int getBorrowDays(Long userId)
/*      */   {
/*  578 */     int day = 0;
/*  579 */     String againBorrow = Global.getValue("again_borrow");
/*  580 */     Map<String, Object> searchMap = new HashMap();
/*  581 */     searchMap.put("userId", userId);
/*  582 */     Borrow borrowTemp = findLast(searchMap);
/*  583 */     if (StringUtil.isNotBlank(borrowTemp)) {
/*  584 */       day = DateUtil.daysBetween(borrowTemp.getCreateTime(), new Date());
/*  585 */       day = Integer.parseInt(againBorrow) - day;
/*      */     }
/*  587 */     return day;
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
/*      */   public List<BorrowProgressModel> borrowProgress(Borrow borrow, String pageFlag)
/*      */   {
/*  600 */     List<BorrowProgressModel> list = new ArrayList();
/*  601 */     Map<String, Object> bpMap = new HashMap();
/*  602 */     bpMap.put("borrowId", borrow.getId());
/*      */     
/*  604 */     int day = getBorrowDays(borrow.getUserId());
/*      */     
/*      */ 
/*  607 */     if (("10".equals(borrow.getState())) || 
/*  608 */       ("22".equals(borrow.getState()))) {
/*  609 */       bpMap.put("state", borrow.getState());
/*  610 */       List<BorrowProgressModel> pgList = this.borrowProgressMapper.listProgress(bpMap);
/*  611 */       Calendar cal = Calendar.getInstance();
/*  612 */       cal.setTime(((BorrowProgressModel)pgList.get(0)).getCreateTime());
/*  613 */       cal.add(13, 1);
/*  614 */       BorrowProgressModel progress = new BorrowProgressModel();
/*  615 */       progress.setUserId(borrow.getUserId());
/*  616 */       progress.setBorrowId(borrow.getId());
/*  617 */       progress.setRemark("已进入风控审核状态，请耐心等待。");
/*  618 */       progress.setStr("审核中");
/*  619 */       progress.setState(progress.getStr());
/*  620 */       progress.setType("10");
/*  621 */       progress.setCreateTime(cal.getTime());
/*  622 */       list.add(progress);
/*      */       
/*  624 */       progress = (BorrowProgressModel)pgList.get(0);
/*  625 */       progress.setStr(progress.getState());
/*  626 */       progress.setState(progress.getStr());
/*  627 */       progress.setType("10");
/*  628 */       list.add(progress);
/*      */     }
/*      */     
/*      */ 
/*  632 */     if (("detail".equals(pageFlag)) && (
/*  633 */       ("21".equals(borrow.getState())) || 
/*  634 */       ("27".equals(borrow.getState())))) {
/*  635 */       bpMap.put("state", borrow.getState());
/*  636 */       List<BorrowProgressModel> pgList = this.borrowProgressMapper.listProgress(bpMap);
/*      */       
/*  638 */       int size = pgList.size();
/*  639 */       BorrowProgressModel progress = (BorrowProgressModel)pgList.get(size - 1);
/*  640 */       progress.setStr(progress.getState());
/*  641 */       progress.setState(progress.getStr());
/*  642 */       progress.setType("20");
/*  643 */       if (day > 0) {
/*  644 */         progress.setRemark(progress.getRemark() + ",请等待" + day + "天后可再次申请借款");
/*      */       }
/*  646 */       list.add(progress);
/*      */       
/*  648 */       progress = (BorrowProgressModel)pgList.get(0);
/*  649 */       progress.setStr(progress.getState());
/*  650 */       progress.setState(progress.getStr());
/*  651 */       progress.setType("10");
/*      */       
/*      */ 
/*  654 */       list.add(progress);
/*      */     }
/*      */     
/*      */ 
/*  658 */     if (("index".equals(pageFlag)) && (day > 0) && (
/*  659 */       ("21".equals(borrow.getState())) || 
/*  660 */       ("27".equals(borrow.getState())))) {
/*  661 */       bpMap.put("state", borrow.getState());
/*  662 */       List<BorrowProgressModel> pgList = this.borrowProgressMapper.listProgress(bpMap);
/*      */       
/*  664 */       int size = pgList.size();
/*  665 */       BorrowProgressModel progress = (BorrowProgressModel)pgList.get(size - 1);
/*  666 */       progress.setStr(progress.getState());
/*  667 */       progress.setState(progress.getStr());
/*  668 */       progress.setType("20");
/*  669 */       progress.setRemark(progress.getRemark() + ",请等待" + day + "天后可再次申请借款");
/*  670 */       list.add(progress);
/*      */       
/*  672 */       progress = (BorrowProgressModel)pgList.get(0);
/*  673 */       progress.setStr(progress.getState());
/*  674 */       progress.setState(progress.getStr());
/*  675 */       progress.setType("10");
/*      */       
/*      */ 
/*  678 */       list.add(progress);
/*      */     }
/*      */     
/*      */ 
/*  682 */     if (("31".equals(borrow.getState())) || 
/*  683 */       ("20".equals(borrow.getState())) || 
/*  684 */       ("26".equals(borrow.getState()))) {
/*  685 */       bpMap.put("state", borrow.getState());
/*  686 */       List<BorrowProgressModel> pgList = this.borrowProgressMapper.listProgress(bpMap);
/*  687 */       boolean passFlag = true;
/*  688 */       for (int i = pgList.size() - 1; i >= 0; i--) {
/*  689 */         BorrowProgressModel progress = (BorrowProgressModel)pgList.get(i);
/*  690 */         progress.setType("10");
/*  691 */         if (i == 0) {
/*  692 */           progress.setStr(progress.getState());
/*  693 */           progress.setState(progress.getStr());
/*  694 */           list.add(progress);
/*      */         }
/*      */         
/*  697 */         if ((passFlag) && (
/*  698 */           ("20".equals(progress.getState())) || 
/*  699 */           ("26".equals(progress.getState()))))
/*      */         {
/*      */ 
/*  702 */           Calendar cal = Calendar.getInstance();
/*  703 */           cal.setTime(progress.getCreateTime());
/*  704 */           cal.add(13, 1);
/*  705 */           BorrowProgressModel progress2 = new BorrowProgressModel();
/*  706 */           progress2.setUserId(Long.valueOf(borrow.getUserId().longValue()));
/*  707 */           progress2.setBorrowId(borrow.getId());
/*  708 */           progress2.setStr("打款中");
/*  709 */           progress2.setState("打款中");
/*  710 */           progress2.setMsg("打款中，请查看您的提现银行卡");
/*  711 */           progress2.setRemark("打款中，请查看您的提现银行卡");
/*  712 */           progress2.setType("10");
/*  713 */           progress2.setCreateTime(cal.getTime());
/*  714 */           list.add(progress2);
/*      */           
/*  716 */           progress.setStr(progress.getState());
/*  717 */           progress.setState(progress.getStr());
/*  718 */           list.add(progress);
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  723 */         if ("31".equals(progress.getState())) {
/*  724 */           progress.setMsg("打款中，请查看您的提现银行卡。");
/*  725 */           progress.setStr(progress.getState());
/*  726 */           progress.setState(progress.getStr());
/*  727 */           list.add(progress);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  733 */     if ("30".equals(borrow.getState())) {
/*  734 */       bpMap.put("state", borrow.getState());
/*  735 */       List<BorrowProgressModel> pgList = this.borrowProgressMapper.listProgress(bpMap);
/*  736 */       boolean passFlag = true;
/*  737 */       for (int i = pgList.size() - 1; i >= 0; i--) {
/*  738 */         BorrowProgressModel progress = (BorrowProgressModel)pgList.get(i);
/*  739 */         progress.setType("10");
/*  740 */         if (i == 0) {
/*  741 */           progress.setStr(progress.getState());
/*  742 */           progress.setState(progress.getStr());
/*  743 */           list.add(progress);
/*      */         }
/*      */         
/*  746 */         if ((passFlag) && (
/*  747 */           ("20".equals(progress.getState())) || 
/*  748 */           ("26".equals(progress.getState())))) {
/*  749 */           progress.setStr(progress.getState());
/*  750 */           progress.setState(progress.getStr());
/*  751 */           list.add(progress);
/*  752 */           passFlag = false;
/*      */         }
/*      */         
/*  755 */         if ("30".equals(progress.getState())) {
/*  756 */           double repayAmount = borrow.getRealAmount().doubleValue() + borrow.getFee().doubleValue();
/*      */           
/*  758 */           Calendar cal = Calendar.getInstance();
/*  759 */           cal.setTime(progress.getCreateTime());
/*  760 */           cal.add(13, 1);
/*  761 */           progress = new BorrowProgressModel();
/*  762 */           progress.setUserId(Long.valueOf(borrow.getUserId().longValue()));
/*  763 */           progress.setBorrowId(borrow.getId());
/*  764 */           progress.setStr("待还款");
/*  765 */           progress.setRemark("您需要在" + borrow.getTimeLimit() + "天后还款" + repayAmount + "元");
/*  766 */           Map<String, Object> paramMap = new HashMap();
/*  767 */           paramMap.put("borrowId", borrow.getId());
/*  768 */           BorrowRepay repay = (BorrowRepay)this.borrowRepayMapper.findSelective(paramMap);
/*  769 */           if (repay != null) {
/*  770 */             day = DateUtil.daysBetween(new Date(), 
/*  771 */               repay.getRepayTime());
/*  772 */             if (day > 0) {
/*  773 */               progress.setRemark("您需要在" + day + "天后还款" + repayAmount + "元");
/*  774 */             } else if (day == 0) {
/*  775 */               progress.setRemark("您需要在今天还款" + repayAmount + "元");
/*      */             }
/*      */           }
/*      */           
/*  779 */           if ("1".equals(borrow.getTimeLimit())) {
/*  780 */             progress.setRemark("您需要在今天还款" + repayAmount + "元");
/*      */           }
/*  782 */           progress.setState("待还款");
/*  783 */           progress.setType("10");
/*  784 */           progress.setCreateTime(cal.getTime());
/*  785 */           list.add(progress);
/*      */           
/*  787 */           progress = (BorrowProgressModel)pgList.get(i);
/*  788 */           progress.setStr("已打款");
/*  789 */           progress.setState(progress.getStr());
/*  790 */           list.add(progress);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  796 */     if (("detail".equals(pageFlag)) && (
/*  797 */       ("40".equals(borrow.getState())) || 
/*  798 */       ("41".equals(borrow.getState())))) {
/*  799 */       bpMap.put("state", borrow.getState());
/*  800 */       List<BorrowProgressModel> pgList = this.borrowProgressMapper.listProgress(bpMap);
/*  801 */       boolean passFlag = true;
/*  802 */       for (int i = pgList.size() - 1; i >= 0; i--) {
/*  803 */         BorrowProgressModel progress = (BorrowProgressModel)pgList.get(i);
/*  804 */         progress.setType("10");
/*  805 */         if (i == 0) {
/*  806 */           progress.setStr(progress.getState());
/*  807 */           progress.setState(progress.getStr());
/*  808 */           list.add(progress);
/*      */         }
/*      */         
/*  811 */         if (passFlag)
/*      */         {
/*  813 */           if (("20".equals(progress.getState())) || 
/*  814 */             ("26".equals(progress.getState()))) {
/*  815 */             progress.setStr(progress.getState());
/*  816 */             progress.setState(progress.getStr());
/*  817 */             list.add(progress);
/*  818 */             passFlag = false;
/*      */           }
/*      */         }
/*      */         
/*  822 */         if (("30".equals(progress.getState())) || 
/*      */         
/*  824 */           ("40".equals(progress.getState())) || 
/*      */           
/*  826 */           ("41".equals(progress.getState()))) {
/*  827 */           progress.setStr(progress.getState());
/*  828 */           progress.setState(progress.getStr());
/*  829 */           list.add(progress);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  835 */     int brState = Integer.parseInt(borrow.getState());
/*  836 */     int signState = Integer.parseInt("40");
/*  837 */     if (brState > signState)
/*      */     {
/*  839 */       if (!"41".equals(borrow.getState())) {
/*  840 */         bpMap.put("state", "90");
/*  841 */         List<BorrowProgressModel> pgList = this.borrowProgressMapper.listProgress(bpMap);
/*  842 */         boolean passFlag = true;
/*  843 */         boolean overdueFlag = true;
/*      */         
/*  845 */         for (int i = pgList.size() - 1; i >= 0; i--) {
/*  846 */           BorrowProgressModel progress = (BorrowProgressModel)pgList.get(i);
/*  847 */           progress.setType("10");
/*  848 */           int prState = Integer.parseInt(progress.getState());
/*  849 */           if (i == 0) {
/*  850 */             progress.setStr(progress.getState());
/*  851 */             progress.setState(progress.getStr());
/*  852 */             list.add(progress);
/*      */           }
/*      */           
/*  855 */           if (passFlag)
/*      */           {
/*  857 */             if (("20".equals(progress.getState())) || 
/*  858 */               ("26".equals(progress.getState()))) {
/*  859 */               progress.setStr(progress.getState());
/*  860 */               progress.setState(progress.getStr());
/*  861 */               list.add(progress);
/*  862 */               passFlag = false;
/*      */             }
/*      */           }
/*      */           
/*  866 */           if ("30".equals(progress.getState())) {
/*  867 */             progress.setStr(progress.getState());
/*  868 */             progress.setState(progress.getStr());
/*  869 */             list.add(progress);
/*      */           }
/*      */           
/*  872 */           if ((overdueFlag) && (prState > signState)) {
/*  873 */             progress = (BorrowProgressModel)pgList.get(pgList.size() - 1);
/*  874 */             progress.setStr(progress.getState());
/*  875 */             progress.setState(progress.getStr());
/*      */             
/*  877 */             Calendar cal = Calendar.getInstance();
/*  878 */             cal.setTime(progress.getCreateTime());
/*  879 */             cal.add(13, 1);
/*  880 */             progress.setRemark("您已逾期,请尽快还款");
/*  881 */             progress.setState("已逾期");
/*  882 */             progress.setType("10");
/*  883 */             progress.setCreateTime(cal.getTime());
/*  884 */             list.add(progress);
/*  885 */             overdueFlag = false;
/*      */           }
/*      */         }
/*      */       } }
/*  889 */     return list;
/*      */   }
/*      */   
/*      */   public Map<String, Object> choice(double amount, String timeLimit)
/*      */   {
/*  894 */     String fee_ = Global.getValue("fee");
/*  895 */     String[] fees = fee_.split(",");
/*  896 */     String borrowDay = Global.getValue("borrow_day");
/*  897 */     String[] days = borrowDay.split(",");
/*  898 */     double infoAuthFee = Double.valueOf(Global.getValue("info_auth_fee")).doubleValue();
/*  899 */     double serviceFee = Double.valueOf(Global.getValue("service_fee")).doubleValue();
/*  900 */     double interest = Double.valueOf(Global.getValue("interest")).doubleValue();
/*  901 */     double channelFee = Double.valueOf(Global.getValue("channel_fee")).doubleValue();
/*  902 */     double accountFee = Double.valueOf(Global.getValue("account_fee")).doubleValue();
/*      */     
/*  904 */     Map<String, Object> map = new HashMap();
/*  905 */     map.put("amount", Double.valueOf(amount));
/*  906 */     map.put("timeLimit", timeLimit);
/*      */     
/*  908 */     double fee = 0.0D;
/*  909 */     for (int i = 0; i < days.length; i++) {
/*  910 */       if (timeLimit.equals(days[i])) {
/*  911 */         fee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { amount, Double.parseDouble(fees[i]) }));
/*  912 */         map.put("fee", Double.valueOf(BigDecimalUtil.decimal(fee, 2)));
/*      */         
/*  914 */         String beheadFee = Global.getValue("behead_fee");
/*  915 */         if (beheadFee.equals("10")) {
/*  916 */           map.put("realAmount", Double.valueOf(amount - fee));
/*      */         } else {
/*  918 */           map.put("realAmount", Double.valueOf(amount));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  923 */     Map<String, Object> feeDetail = new HashMap();
/*  924 */     infoAuthFee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { fee, infoAuthFee }));
/*  925 */     serviceFee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { fee, serviceFee }));
/*  926 */     channelFee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { fee, channelFee }));
/*  927 */     accountFee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { fee, accountFee }));
/*  928 */     interest = BigDecimalUtil.sub(new double[] { fee, infoAuthFee, serviceFee, channelFee, accountFee });
/*      */     
/*  930 */     feeDetail.put("infoAuthFee", Double.valueOf(infoAuthFee));
/*  931 */     feeDetail.put("serviceFee", Double.valueOf(serviceFee));
/*  932 */     feeDetail.put("channelFee", Double.valueOf(channelFee));
/*  933 */     feeDetail.put("accountFee", Double.valueOf(accountFee));
/*  934 */     feeDetail.put("interest", Double.valueOf(interest));
/*      */     
/*  936 */     map.put("feeDetail", feeDetail);
/*      */     
/*  938 */     return map;
/*      */   }
/*      */   
/*      */   public List<Map<String, Object>> choices()
/*      */   {
/*  943 */     String fee_ = Global.getValue("fee");
/*  944 */     String feeName = this.sysConfigService.findByCode("fee").getName();
/*  945 */     String[] fees = fee_.split(",");
/*  946 */     String borrowDay = Global.getValue("borrow_day");
/*  947 */     String[] days = borrowDay.split(",");
/*  948 */     String borrowCredit = Global.getValue("borrow_credit");
/*  949 */     String[] borrowCredits = borrowCredit.split(",");
/*  950 */     String penaltyFees = Global.getValue("penalty_fee");
/*  951 */     String[] penaltyFee = penaltyFees.split(",");
/*  952 */     double infoAuthFee = Double.valueOf(Global.getValue("info_auth_fee")).doubleValue();
/*  953 */     double serviceFee = Double.valueOf(Global.getValue("service_fee")).doubleValue();
/*  954 */     double channelFee = Double.valueOf(Global.getValue("channel_fee")).doubleValue();
/*  955 */     double accountFee = Double.valueOf(Global.getValue("account_fee")).doubleValue();
/*  956 */     double interest = Double.valueOf(Global.getValue("interest")).doubleValue();
/*  957 */     String infoAuthFeeName = this.sysConfigService.findByCode("info_auth_fee").getName();
/*  958 */     String serviceFeeName = this.sysConfigService.findByCode("service_fee").getName();
/*  959 */     String interestName = this.sysConfigService.findByCode("interest").getName();
/*  960 */     String channelName = this.sysConfigService.findByCode("channel_fee").getName();
/*  961 */     String accountName = this.sysConfigService.findByCode("account_fee").getName();
/*  962 */     String penaltyFeeName = this.sysConfigService.findByCode("penalty_fee").getName();
/*      */     
/*  964 */     List<Map<String, Object>> list = new ArrayList();
/*  965 */     for (int i = 0; i < days.length; i++) {
/*  966 */       for (int j = 0; j < borrowCredits.length; j++) {
/*  967 */         Map<String, Object> map = new HashMap();
/*  968 */         double fee = Double.parseDouble(borrowCredits[j]) * Double.parseDouble(fees[i]);
/*  969 */         map.put("fee", Double.valueOf(BigDecimalUtil.decimal(fee, 2)));
/*  970 */         map.put("feeName", feeName);
/*      */         
/*  972 */         double amount = Double.parseDouble(borrowCredits[j]);
/*  973 */         double penFee = Double.parseDouble(penaltyFee[i].split("-")[1]);
/*  974 */         String beheadFee = Global.getValue("behead_fee");
/*  975 */         if (beheadFee.equals("10")) {
/*  976 */           map.put("realAmount", Double.valueOf(amount - fee));
/*      */         } else {
/*  978 */           map.put("realAmount", Double.valueOf(amount));
/*      */         }
/*  980 */         Map<String, Object> feeDetail = new HashMap();
/*      */         
/*  982 */         double[] totalFees = { fee * infoAuthFee, fee * serviceFee, fee * channelFee, fee * accountFee };
/*  983 */         double totalFee = BigDecimalUtil.add(totalFees);
/*      */         
/*  985 */         feeDetail.put("infoAuthFeeName", infoAuthFeeName);
/*  986 */         feeDetail.put("infoAuthFee", Double.valueOf(BigDecimalUtil.decimal(fee * infoAuthFee, 2)));
/*  987 */         feeDetail.put("serviceFeeName", serviceFeeName);
/*  988 */         feeDetail.put("serviceFee", Double.valueOf(BigDecimalUtil.decimal(fee * serviceFee, 2)));
/*  989 */         feeDetail.put("interestName", interestName);
/*  990 */         feeDetail.put("interest", Double.valueOf(BigDecimalUtil.decimal(fee * interest, 2)));
/*  991 */         feeDetail.put("channelName", channelName);
/*  992 */         feeDetail.put("channelFee", Double.valueOf(BigDecimalUtil.decimal(fee * channelFee, 2)));
/*  993 */         feeDetail.put("accountName", accountName);
/*  994 */         feeDetail.put("accountFee", Double.valueOf(BigDecimalUtil.decimal(fee * accountFee, 2)));
/*  995 */         feeDetail.put("penaltyFeeName", penaltyFeeName);
/*  996 */         feeDetail.put("penaltyFee", Double.valueOf(BigDecimalUtil.decimal(penFee * amount, 2)));
/*  997 */         String repay = DateUtil.dateStr2(DateUtil.rollDay(DateUtil.getNow(), Integer.parseInt(days[i]) - 1));
/*  998 */         feeDetail.put("repayTime", DateUtil.valueOf(repay, "yyyy-MM-dd"));
/*  999 */         map.put("feeDetail", feeDetail);
/* 1000 */         map.put("totalFee", Double.valueOf(BigDecimalUtil.decimal(totalFee, 2)));
/*      */         
/* 1002 */         map.put("timeLimit", days[i]);
/* 1003 */         map.put("amount", Double.valueOf(amount));
/* 1004 */         list.add(map);
/*      */       }
/*      */     }
/*      */     
/* 1008 */     return list;
/*      */   }
/*      */   
/*      */   public Borrow saveBorrow(Borrow borrow)
/*      */   {
/* 1013 */     String fee_ = Global.getValue("fee");
/* 1014 */     String[] fees = fee_.split(",");
/* 1015 */     String borrowDay = Global.getValue("borrow_day");
/* 1016 */     String[] days = borrowDay.split(",");
/* 1017 */     double serviceFee = Double.valueOf(Global.getValue("service_fee")).doubleValue();
/* 1018 */     double infoAuthFee = Double.valueOf(Global.getValue("info_auth_fee")).doubleValue();
/* 1019 */     double channelFee = Double.valueOf(Global.getValue("channel_fee")).doubleValue();
/* 1020 */     double accountFee = Double.valueOf(Global.getValue("account_fee")).doubleValue();
/* 1021 */     double interest = Double.valueOf(Global.getValue("interest")).doubleValue();
/* 1022 */     String beheadFee = Global.getValue("behead_fee");
/*      */     
/* 1024 */     double fee = 0.0D;
/* 1025 */     for (int i = 0; i < days.length; i++) {
/* 1026 */       if (borrow.getTimeLimit().equals(days[i])) {
/* 1027 */         fee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { borrow.getAmount().doubleValue(), Double.parseDouble(fees[i]) }));
/* 1028 */         borrow.setFee(Double.valueOf(fee));
/* 1029 */         if ("10".equals(beheadFee)) {
/* 1030 */           borrow.setRealAmount(Double.valueOf(borrow.getAmount().doubleValue() - fee));
/*      */         } else {
/* 1032 */           borrow.setRealAmount(borrow.getAmount());
/*      */         }
/*      */       }
/*      */     }
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
/* 1048 */     infoAuthFee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { fee, infoAuthFee }));
/* 1049 */     serviceFee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { fee, serviceFee }));
/* 1050 */     channelFee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { fee, channelFee }));
/* 1051 */     accountFee = BigDecimalUtil.round(BigDecimalUtil.mul(new double[] { fee, accountFee }));
/* 1052 */     interest = BigDecimalUtil.sub(new double[] { fee, infoAuthFee, serviceFee, channelFee, accountFee });
/*      */     
/* 1054 */     borrow.setInfoAuthFee(Double.valueOf(infoAuthFee));
/* 1055 */     borrow.setServiceFee(Double.valueOf(serviceFee));
/* 1056 */     borrow.setInterest(Double.valueOf(interest));
/* 1057 */     borrow.setChannelFee(Double.valueOf(channelFee));
/* 1058 */     borrow.setAccountFee(Double.valueOf(accountFee));
/*      */     
/* 1060 */     borrow.setOrderNo(NidGenerator.getOrderNo());
/* 1061 */     borrow.setState("10");
/* 1062 */     borrow.setCreateTime(DateUtil.getNow());
/*      */     
/* 1064 */     this.clBorrowMapper.save(borrow);
/*      */     
/* 1066 */     return borrow;
/*      */   }
/*      */   
/*      */   public List<Borrow> findBorrowByMap(Map<String, Object> searchMap)
/*      */   {
/* 1071 */     List<Borrow> list = this.clBorrowMapper.listSelective(searchMap);
/* 1072 */     return list;
/*      */   }
/*      */   
/*      */   private void addList(BorrowProgressModel bpModel) {
/* 1076 */     if ((bpModel.getState().equals("10")) || 
/* 1077 */       (bpModel.getState().equals("22"))) {
/* 1078 */       bpModel.setMsg("系统审核中,请耐心等待");
/* 1079 */       bpModel.setType("10");
/*      */     }
/* 1081 */     if ((bpModel.getState().equals("20")) || 
/* 1082 */       (bpModel.getState().equals("26"))) {
/* 1083 */       bpModel.setMsg("恭喜通过风控审核");
/* 1084 */       bpModel.setType("10");
/*      */     }
/* 1086 */     if ((bpModel.getState().equals("21")) || 
/* 1087 */       (bpModel.getState().equals("27"))) {
/* 1088 */       bpModel.setMsg("很遗憾,您未通过审核");
/* 1089 */       bpModel.setType("20");
/*      */     }
/* 1091 */     if ((bpModel.getState().equals("30")) || 
/* 1092 */       (bpModel.getState().equals("31"))) {
/* 1093 */       bpModel.setMsg("打款中,请注意查收短信");
/* 1094 */       bpModel.setType("10");
/*      */     }
/* 1096 */     if ((bpModel.getState().equals("40")) || 
/*      */     
/* 1098 */       (bpModel.getState().equals("41"))) {
/* 1099 */       bpModel.setMsg("已还款");
/* 1100 */       bpModel.setType("30");
/*      */     }
/* 1102 */     if (bpModel.getState().equals("50")) {
/* 1103 */       bpModel.setMsg("已逾期,请尽快还款");
/* 1104 */       bpModel.setType("20");
/*      */     }
/* 1106 */     if (bpModel.getState().equals("90")) {
/* 1107 */       bpModel.setMsg("已坏账");
/* 1108 */       bpModel.setType("20");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public Page<ManageBorrowModel> listModel(Map<String, Object> params, int currentPage, int pageSize)
/*      */   {
/* 1115 */     PageHelper.startPage(currentPage, pageSize);
/* 1116 */     List<ManageBorrowModel> list = this.clBorrowMapper.listModel(params);
/* 1117 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public int updateSelective(Map<String, Object> data)
/*      */   {
/* 1122 */     return this.clBorrowMapper.updateSelective(data);
/*      */   }
/*      */   
/*      */   public void saveQcResult(String qcRsMsg, Borrow borrow)
/*      */   {
/* 1127 */     if (StringUtil.isNotBlank(qcRsMsg)) {
/* 1128 */       JSONObject resultJson = null;
/* 1129 */       if (!qcRsMsg.toUpperCase().startsWith("<HTML>")) {
/* 1130 */         resultJson = JSONObject.parseObject(qcRsMsg);
/*      */       }
/* 1132 */       String code = resultJson == null ? "" : resultJson.getString("code");
/* 1133 */       String message = resultJson == null ? qcRsMsg : String.valueOf(resultJson.get("message"));
/*      */       
/* 1135 */       QianchengReqlog reqLog = this.qianchengReqlogMapper.findByBorrowId(borrow.getId());
/* 1136 */       reqLog.setRespCode(code);
/* 1137 */       reqLog.setRespParams(qcRsMsg);
/* 1138 */       reqLog.setRespTime(DateUtil.getNow());
/*      */       
/* 1140 */       if (("200".equals(code)) && (resultJson != null)) {
/* 1141 */         reqLog.setRespOrderNo(resultJson.getString("orderNo"));
/* 1142 */         this.qianchengReqlogMapper.update(reqLog);
/*      */       } else {
/* 1144 */         BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_4, reqLog.getOrderNo(), message);
/* 1145 */         reqLog.setRsState("1");
/* 1146 */         reqLog.setRsDesc(message);
/* 1147 */         this.qianchengReqlogMapper.update(reqLog);
/* 1148 */         syncSceneBusinessLog("1", "成功", borrow.getId(), "QcRisk");
/*      */       }
/*      */     } else {
/* 1151 */       syncSceneBusinessLog("0", "浅橙返回为空字符串", borrow.getId(), "QcRisk");
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
/*      */   public int modifyState(long id, String state)
/*      */   {
/* 1164 */     Map<String, Object> paramMap = new HashMap();
/* 1165 */     paramMap.put("state", state);
/* 1166 */     paramMap.put("id", Long.valueOf(id));
/* 1167 */     return this.clBorrowMapper.updateSelective(paramMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void savePressState(Borrow borrow, String state)
/*      */   {
/* 1178 */     BorrowProgress borrowProgress = new BorrowProgress();
/* 1179 */     borrowProgress.setBorrowId(borrow.getId());
/* 1180 */     borrowProgress.setUserId(borrow.getUserId());
/* 1181 */     if (state.equals("10")) {
/* 1182 */       borrowProgress.setRemark("借款" + 
/* 1183 */         StringUtil.isNull(borrow.getAmount()) + 
/* 1184 */         "元，期限" + 
/* 1185 */         borrow.getTimeLimit() + 
/* 1186 */         "天，综合费用" + 
/* 1187 */         StringUtil.isNull(borrow.getFee()) + "元，" + 
/* 1188 */         BorrowModel.convertBorrowRemark(state));
/*      */     } else {
/* 1190 */       borrowProgress.setRemark(BorrowModel.convertBorrowRemark(state));
/*      */     }
/* 1192 */     borrowProgress.setState(state);
/* 1193 */     borrowProgress.setCreateTime(DateUtil.getNow());
/* 1194 */     this.borrowProgressMapper.save(borrowProgress);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int modifyCredit(Long userId, double amount, String type)
/*      */   {
/* 1205 */     Map<String, Object> params = new HashMap();
/* 1206 */     Map<String, Object> creditMap = new HashMap();
/* 1207 */     creditMap.put("consumerNo", userId);
/* 1208 */     Credit credit = (Credit)this.creditMapper.findSelective(creditMap);
/* 1209 */     if (credit != null) {
/* 1210 */       params.put("id", credit.getId());
/* 1211 */       if ("used".equals(type)) {
/* 1212 */         params.put("used", Double.valueOf(amount));
/* 1213 */         params.put("unuse", Double.valueOf(-amount));
/*      */       } else {
/* 1215 */         params.put("used", Double.valueOf(-amount));
/* 1216 */         params.put("unuse", Double.valueOf(amount));
/*      */       }
/* 1218 */       int result = this.creditMapper.updateAmount(params);
/*      */       
/* 1220 */       if (result != 1) {
/* 1221 */         logger.error("更新额度失败，不能出现负值，type：" + type + ",userId:" + userId);
/* 1222 */         throw new BussinessException("更新额度失败");
/*      */       }
/* 1224 */       return result;
/*      */     }
/* 1226 */     logger.error("更新额度失败，不能出现负值，type：" + type + ",userId:" + userId);
/* 1227 */     throw new BussinessException("更新额度失败");
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
/*      */   public String verifyBorrow(Borrow borrow, String adaptedId)
/*      */   {
/* 1240 */     List<RuleEngineConfig> configCollection = this.ruleEngineConfigMapper.findRuleEnginConfigForBorrow(adaptedId);
/* 1241 */     if ((configCollection != null) && (!configCollection.isEmpty()))
/*      */     {
/* 1243 */       int pass = 0;
/* 1244 */       int reveiw = 0;
/* 1245 */       for (int i = 0; i < configCollection.size(); i++) {
/* 1246 */         RuleEngineConfig config = (RuleEngineConfig)configCollection.get(i);
/* 1247 */         BorrowRuleResult result = new BorrowRuleResult();
/* 1248 */         result.setBorrowId(borrow.getId());
/* 1249 */         result.setRuleId(config.getRuleEnginId());
/* 1250 */         result.setTbNid(config.getCtable());
/* 1251 */         result.setTbName(config.getTableComment());
/* 1252 */         result.setColNid(config.getCcolumn());
/* 1253 */         result.setColName(config.getColumnComment());
/* 1254 */         result.setRule(config.getFormula());
/* 1255 */         result.setAddTime(new Date());
/* 1256 */         result.setUserId(borrow.getUserId());
/* 1257 */         result.setAdaptedId(adaptedId);
/*      */         
/* 1259 */         String tabelName = config.getCtable();
/* 1260 */         if ((!"".equals(config.getCtable())) && (config.getCtable() != null)) {
/* 1261 */           tabelName = ShardTableUtil.generateTableNameById(config.getCtable(), borrow.getUserId().longValue(), 30000L);
/*      */         }
/* 1263 */         String statement = "select " + config.getCcolumn() + " from " + tabelName + " where user_id = " + borrow.getUserId();
/* 1264 */         if (config.getCtable().equals("cl_user")) {
/* 1265 */           statement = "select " + config.getCcolumn() + " from " + tabelName + " where id = " + borrow.getUserId();
/*      */         }
/* 1267 */         String value = this.ruleEngineMapper.findValidValue(statement);
/* 1268 */         boolean flag = false;
/* 1269 */         result.setValue(config.getCvalue());
/* 1270 */         if (StringUtil.isNotBlank(value)) {
/* 1271 */           String rs = "N";
/* 1272 */           if ("int".equals(config.getType()))
/*      */           {
/* 1274 */             SimpleRule simpleRule = RulesExecutorUtil.singleRuleResult(config.getId(), config.getCcolumn(), config.getFormula(), config.getCvalue(), value, config.getType(), "");
/*      */             
/* 1276 */             rs = simpleRule.getComparResult();
/* 1277 */             if ("Y".equals(simpleRule.getComparResult())) {
/* 1278 */               flag = true;
/*      */             }
/* 1280 */           } else if ("string".equals(config.getType())) {
/* 1281 */             flag = GenerateRule.comparText(config.getFormula(), config.getCvalue(), value);
/* 1282 */             if (flag) {
/* 1283 */               rs = "Y";
/*      */             }
/*      */           }
/* 1286 */           result.setResult(rs);
/* 1287 */           result.setMatching(value != null ? value : "");
/* 1288 */           result.setResultType(config.getResult());
/*      */         }
/*      */         else {
/* 1291 */           result.setMatching("未知 ");
/* 1292 */           result.setResult("N");
/* 1293 */           result.setResultType("20");
/* 1294 */           this.borrowRuleResultMapper.save(result);
/* 1295 */           reveiw++;
/*      */         }
/* 1297 */         this.borrowRuleResultMapper.save(result);
/* 1298 */         if ((flag) && ("30".equals(config.getResult()))) {
/* 1299 */           pass++;
/* 1300 */         } else if ((flag) && ("20".equals(config.getResult()))) {
/* 1301 */           reveiw++;
/* 1302 */         } else if ((flag) && ("10".equals(config.getResult()))) {
/* 1303 */           return config.getResult();
/*      */         }
/*      */       }
/* 1306 */       if (reveiw > 0)
/* 1307 */         return "20";
/* 1308 */       if (pass > 0) {
/* 1309 */         return "30";
/*      */       }
/* 1311 */       return "20";
/*      */     }
/*      */     
/* 1314 */     return "10";
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
/*      */   public void borrowLoan(final Borrow borrow, final Date date)
/*      */   {
/* 1329 */     String value = Global.getValue("fuiou_switch");
/* 1330 */     if ((StringUtils.isNotBlank(value)) && (StringUtils.equals(value, "1")))
/*      */     {
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
/* 1423 */       new Thread()
/*      */       {
/*      */         public void run()
/*      */         {
/* 1334 */           Map<String, Object> bankCardMap = new HashMap();
/* 1335 */           bankCardMap.put("userId", borrow.getUserId());
/* 1336 */           BankCard bankCard = (BankCard)ClBorrowServiceImpl.this.bankCardMapper.findSelective(bankCardMap);
/*      */           
/* 1338 */           UserBaseInfo baseInfo = ClBorrowServiceImpl.this.userBaseInfoMapper.findByUserId(borrow.getUserId());
/* 1339 */           PayforreqModel pfm = new PayforreqModel();
/* 1340 */           pfm.setBankno(bankCard.getBank());
/* 1341 */           if ("dev".equals(Global.getValue("app_environment"))) {
/* 1342 */             pfm.setAmt(Long.valueOf(1L));
/*      */           } else {
/* 1344 */             pfm.setAmt(Long.valueOf(new Double(borrow.getRealAmount().doubleValue() * 100.0D).longValue()));
/*      */           }
/* 1346 */           pfm.setAccntno(bankCard.getCardNo());
/* 1347 */           pfm.setAccntnm(baseInfo.getRealName());
/* 1348 */           FuiouHelper fh = new FuiouHelper();
/* 1349 */           String ret = fh.payforreq(pfm);
/*      */           
/* 1351 */           PayLog payLog = new PayLog();
/* 1352 */           payLog.setOrderNo(pfm.getOrderNo());
/* 1353 */           payLog.setUserId(borrow.getUserId());
/* 1354 */           payLog.setBorrowId(borrow.getId());
/* 1355 */           payLog.setAmount(borrow.getRealAmount());
/* 1356 */           payLog.setCardNo(bankCard.getCardNo());
/* 1357 */           payLog.setBank(bankCard.getBank());
/* 1358 */           payLog.setSource("10");
/* 1359 */           payLog.setType("10");
/* 1360 */           payLog.setScenes("10");
/*      */           try
/*      */           {
/* 1363 */             ClBorrowServiceImpl.logger.info("进入订单" + pfm.getOrderNo() + "处理中.....");
/* 1364 */             PayReqLog payReqLog = ClBorrowServiceImpl.this.payReqLogService.findByOrderNo(pfm.getOrderNo());
/* 1365 */             if (payReqLog != null)
/*      */             {
/* 1367 */               PayRespLog payRespLog = new PayRespLog(pfm.getOrderNo(), 
/* 1368 */                 Integer.valueOf(1), ret);
/* 1369 */               ClBorrowServiceImpl.this.payRespLogService.save(payRespLog);
/*      */               
/* 1371 */               ClBorrowServiceImpl.this.modifyPayReqLog(payReqLog, ret);
/*      */             }
/* 1373 */             Map data = XmlMapUtils.xml2map(ret, false);
/* 1374 */             if ("000000".equals(data.get("ret"))) {
/* 1375 */               payLog.setState("40");
/*      */               
/* 1377 */               if ("10".equals(payLog.getScenes())) {
/* 1378 */                 ClBorrowServiceImpl.logger.info("生成借款计划。。");
/*      */                 
/* 1380 */                 Map<String, Object> map = new HashMap();
/* 1381 */                 map.put("id", payLog.getBorrowId());
/* 1382 */                 map.put("state", "30");
/* 1383 */                 ClBorrowServiceImpl.this.clBorrowMapper.updatePayState(map);
/*      */                 
/*      */ 
/* 1386 */                 BorrowProgress bp = new BorrowProgress();
/* 1387 */                 bp.setUserId(payLog.getUserId());
/* 1388 */                 bp.setBorrowId(payLog.getBorrowId());
/* 1389 */                 bp.setState("30");
/* 1390 */                 bp.setRemark(BorrowModel.convertBorrowRemark(bp.getState()));
/* 1391 */                 bp.setCreateTime(DateUtil.getNow());
/* 1392 */                 ClBorrowServiceImpl.this.borrowProgressMapper.save(bp);
/*      */                 
/* 1394 */                 Borrow borrow = (Borrow)ClBorrowServiceImpl.this.clBorrowMapper.findByPrimary(payLog.getBorrowId());
/*      */                 
/*      */ 
/* 1397 */                 ClBorrowServiceImpl.this.borrowRepayService.genRepayPlan(borrow);
/*      */                 
/* 1399 */                 Map<String, Object> paramMap = new HashMap();
/* 1400 */                 paramMap.put("state", "40");
/* 1401 */                 paramMap.put("updateTime", DateUtil.getNow());
/* 1402 */                 paramMap.put("id", payLog.getId());
/* 1403 */                 ClBorrowServiceImpl.this.payLogMapper.updateSelective(paramMap);
/*      */                 
/*      */ 
/* 1406 */                 ClBorrowServiceImpl.this.clSmsService.loanInform(borrow.getUserId().longValue(), borrow.getId().longValue());
/*      */               }
/*      */             } else {
/* 1409 */               BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_9, payLog.getOrderNo(), ret);
/* 1410 */               payLog.setState("50");
/* 1411 */               payLog.setUpdateTime(DateUtil.getNow());
/* 1412 */               ClBorrowServiceImpl.this.clBorrowMapper.updateState("31", borrow.getId());
/*      */             }
/* 1414 */             payLog.setRemark((String)data.get("memo"));
/* 1415 */             payLog.setPayReqTime(date);
/* 1416 */             payLog.setCreateTime(DateUtil.getNow());
/* 1417 */             ClBorrowServiceImpl.this.payLogMapper.save(payLog);
/*      */           } catch (DocumentException e) {
/* 1419 */             ClBorrowServiceImpl.logger.info("放款时XML解析发生错误");
/*      */           }
/*      */           
/*      */         }
/* 1423 */       }.start();
/* 1424 */       return;
/*      */     }
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
/* 1528 */     new Thread()
/*      */     {
/*      */       public void run()
/*      */       {
/* 1430 */         Map<String, Object> bankCardMap = new HashMap();
/* 1431 */         bankCardMap.put("userId", borrow.getUserId());
/* 1432 */         BankCard bankCard = (BankCard)ClBorrowServiceImpl.this.bankCardMapper.findSelective(bankCardMap);
/*      */         
/* 1434 */         UserBaseInfo baseInfo = ClBorrowServiceImpl.this.userBaseInfoMapper.findByUserId(borrow.getUserId());
/* 1435 */         String orderNo = OrderNoUtil.getSerialNumber();
/* 1436 */         PaymentModel payment = new PaymentModel(orderNo);
/* 1437 */         payment.setDt_order(DateUtil.dateStr3(date));
/* 1438 */         if ("dev".equals(Global.getValue("app_environment"))) {
/* 1439 */           payment.setMoney_order("0.01");
/*      */         } else {
/* 1441 */           payment.setMoney_order(StringUtil.isNull(borrow.getRealAmount()));
/*      */         }
/* 1443 */         payment.setAmount(borrow.getRealAmount().doubleValue());
/* 1444 */         payment.setCard_no(bankCard.getCardNo());
/* 1445 */         payment.setAcct_name(baseInfo.getRealName());
/* 1446 */         payment.setInfo_order(borrow.getOrderNo() + "付款");
/* 1447 */         payment.setMemo(borrow.getOrderNo() + "付款");
/* 1448 */         payment.setNotify_url(Global.getValue("server_host") + "/pay/lianlian/paymentNotify.htm");
/* 1449 */         LianLianHelper helper = new LianLianHelper();
/* 1450 */         payment = (PaymentModel)helper.payment(payment);
/*      */         
/* 1452 */         PayLog payLog = new PayLog();
/* 1453 */         payLog.setOrderNo(payment.getNo_order());
/* 1454 */         payLog.setUserId(borrow.getUserId());
/* 1455 */         payLog.setBorrowId(borrow.getId());
/* 1456 */         payLog.setAmount(Double.valueOf(payment.getAmount()));
/* 1457 */         payLog.setCardNo(bankCard.getCardNo());
/* 1458 */         payLog.setBank(bankCard.getBank());
/* 1459 */         payLog.setSource("10");
/* 1460 */         payLog.setType("10");
/* 1461 */         payLog.setScenes("10");
/*      */         
/* 1463 */         if (payment.checkReturn()) {
/* 1464 */           payLog.setState("10");
/* 1465 */         } else if (("4002".equals(payment.getRet_code())) || 
/* 1466 */           ("4003".equals(payment.getRet_code())) || 
/* 1467 */           ("4004".equals(payment.getRet_code()))) {
/* 1468 */           payLog.setState("15");
/* 1469 */           payLog.setConfirmCode(payment.getConfirm_code());
/* 1470 */           payLog.setUpdateTime(DateUtil.getNow());
/* 1471 */         } else if (("4006".equals(payment.getRet_code())) || 
/* 1472 */           ("4007".equals(payment.getRet_code())) || 
/* 1473 */           ("4009".equals(payment.getRet_code()))) {
/* 1474 */           payLog.setState("10");
/*      */         } else {
/* 1476 */           BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_9, payLog.getOrderNo(), payment.getRet_msg());
/* 1477 */           payLog.setState("50");
/* 1478 */           payLog.setUpdateTime(DateUtil.getNow());
/*      */           
/* 1480 */           ClBorrowServiceImpl.this.clBorrowMapper.updateState("31", borrow.getId());
/*      */         }
/*      */         
/* 1483 */         payLog.setRemark(payment.getRet_msg());
/* 1484 */         payLog.setPayReqTime(date);
/* 1485 */         payLog.setCreateTime(DateUtil.getNow());
/* 1486 */         ClBorrowServiceImpl.this.payLogMapper.save(payLog);
/*      */         
/*      */ 
/* 1489 */         String lianlianSwitch = Global.getValue("lianlian_switch");
/* 1490 */         if (("dev".equals(Global.getValue("app_environment"))) && (StringUtil.isNotBlank(lianlianSwitch)) && ("2".equals(lianlianSwitch)) && 
/* 1491 */           ("10".equals(payLog.getScenes()))) {
/* 1492 */           ClBorrowServiceImpl.logger.info("模拟连连放款回调成功，生成借款计划。。");
/*      */           
/* 1494 */           Map<String, Object> map = new HashMap();
/* 1495 */           map.put("id", payLog.getBorrowId());
/* 1496 */           map.put("state", "30");
/* 1497 */           ClBorrowServiceImpl.this.clBorrowMapper.updatePayState(map);
/*      */           
/*      */ 
/* 1500 */           BorrowProgress bp = new BorrowProgress();
/* 1501 */           bp.setUserId(payLog.getUserId());
/* 1502 */           bp.setBorrowId(payLog.getBorrowId());
/* 1503 */           bp.setState("30");
/* 1504 */           bp.setRemark(BorrowModel.convertBorrowRemark(bp.getState()));
/* 1505 */           bp.setCreateTime(DateUtil.getNow());
/* 1506 */           ClBorrowServiceImpl.this.borrowProgressMapper.save(bp);
/*      */           
/* 1508 */           Borrow borrow = (Borrow)ClBorrowServiceImpl.this.clBorrowMapper.findByPrimary(payLog.getBorrowId());
/*      */           
/*      */ 
/* 1511 */           ClBorrowServiceImpl.this.borrowRepayService.genRepayPlan(borrow);
/*      */           
/* 1513 */           Map<String, Object> paramMap = new HashMap();
/* 1514 */           paramMap.put("state", "40");
/* 1515 */           paramMap.put("updateTime", DateUtil.getNow());
/* 1516 */           paramMap.put("id", payLog.getId());
/* 1517 */           ClBorrowServiceImpl.this.payLogMapper.updateSelective(paramMap);
/*      */           
/*      */ 
/* 1520 */           ClBorrowServiceImpl.this.clSmsService.loanInform(borrow.getUserId().longValue(), borrow.getId().longValue());
/*      */         }
/*      */       }
/*      */     }.start();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<String, Object> findResult(long borrowId)
/*      */   {
/* 1533 */     Map<String, Object> data = new HashMap();
/* 1534 */     List<ManageReviewModel> ruleList = this.borrowRuleResultMapper
/* 1535 */       .findRuleResult(borrowId);
/* 1536 */     data.put("ruleList", ruleList);
/* 1537 */     List resultList = new ArrayList();
/* 1538 */     List<ManageRuleResultModel> result = this.borrowRuleResultMapper
/* 1539 */       .findResult(borrowId);
/* 1540 */     for (ManageRuleResultModel model : result) {
/* 1541 */       Map<String, Object> search = new HashMap();
/* 1542 */       search.put("ruleId", model.getRuleId());
/* 1543 */       search.put("borrowId", Long.valueOf(borrowId));
/* 1544 */       List<BorrowRuleResult> infoList = this.borrowRuleResultMapper
/* 1545 */         .findRule(search);
/* 1546 */       for (BorrowRuleResult borrowRuleResult : infoList) {
/* 1547 */         borrowRuleResult.setResultType(borrowRuleResult
/* 1548 */           .alterType(borrowRuleResult.getResultType()));
/*      */       }
/* 1550 */       model.setInfoList(infoList);
/*      */     }
/* 1552 */     resultList.add(result);
/* 1553 */     data.put("resultList", resultList);
/* 1554 */     return data;
/*      */   }
/*      */   
/*      */   public List<ManageBorrowTestModel> seleteUser()
/*      */   {
/* 1559 */     List<ManageBorrowTestModel> list = this.clBorrowMapper.seleteUser();
/* 1560 */     List<ManageBorrowTestModel> userList = new ArrayList();
/* 1561 */     for (ManageBorrowTestModel user : list) {
/* 1562 */       boolean type = true;
/* 1563 */       Map<String, Object> searchMap = new HashMap();
/* 1564 */       searchMap.put("userId", Long.valueOf(user.getUserId()));
/* 1565 */       List<Borrow> borrowList = this.clBorrowMapper.listSelective(searchMap);
/* 1566 */       for (Borrow borrow : borrowList)
/*      */       {
/*      */ 
/*      */ 
/* 1570 */         if (((borrow.getState().equals("21") ? 0 : 1) & (borrow.getState().equals("27") ? 0 : 1) & (borrow.getState().equals("40") ? 0 : 1) & 
/* 1571 */           (borrow.getState().equals("41") ? 0 : 1)) != 0) {
/* 1572 */           type = false;
/*      */         }
/*      */       }
/* 1575 */       if (type) {
/* 1576 */         userList.add(user);
/*      */       }
/* 1578 */       if (userList.size() >= 20) {
/*      */         break;
/*      */       }
/*      */     }
/* 1582 */     return userList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int manualVerifyBorrow(Long borrowId, String state, String remark, Long sysUserId)
/*      */   {
/* 1590 */     int code = 0;
/* 1591 */     Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(borrowId);
/* 1592 */     if (borrow != null) {
/* 1593 */       if (!borrow.getState().equals("22")) {
/* 1594 */         logger.error("人工复审失败,当前状态不是待人工复审");
/* 1595 */         throw new BussinessException("复审失败,当前状态不是待人工复审");
/*      */       }
/* 1597 */       Map<String, Object> map = new HashMap();
/* 1598 */       map.put("id", borrowId);
/* 1599 */       map.put("state", state);
/* 1600 */       map.put("remark", remark);
/* 1601 */       map.put("sysUserId", sysUserId);
/* 1602 */       map.put("auditTime", new Date());
/* 1603 */       code = this.clBorrowMapper.reviewState(map);
/* 1604 */       if (code != 1) {
/* 1605 */         throw new BussinessException("复审失败,当前状态不是待人工复审");
/*      */       }
/* 1607 */       savePressState(borrow, state);
/* 1608 */       if (("27".equals(state)) || ("21".equals(state)))
/*      */       {
/* 1610 */         modifyCredit(borrow.getUserId(), borrow.getAmount().doubleValue(), "unuse");
/*      */       }
/*      */       
/* 1613 */       if ("26".equals(state)) {
/* 1614 */         borrowLoan(borrow, new Date());
/*      */       }
/*      */     } else {
/* 1617 */       logger.error("复审失败，当前标不存在");
/* 1618 */       throw new BussinessException("复审失败，当前标不存在");
/*      */     }
/* 1620 */     return code;
/*      */   }
/*      */   
/*      */   private String findBorrowDay(long userId) {
/* 1624 */     String remark = null;
/* 1625 */     Map<String, Object> searchMap = new HashMap();
/* 1626 */     searchMap.put("userId", Long.valueOf(userId));
/* 1627 */     List<RepayModel> modelList = this.clBorrowMapper.findRepay(searchMap);
/* 1628 */     for (RepayModel repayModel : modelList) {
/* 1629 */       if (StringUtil.isNotBlank(repayModel)) {
/* 1630 */         int day = DateUtil.daysBetween(new Date(), 
/* 1631 */           repayModel.getRepayTime());
/* 1632 */         if (day > 0) {
/* 1633 */           remark = 
/* 1634 */             "您需要" + day + "天后还款" + repayModel.getAmount() + "元";
/* 1635 */         } else if (day == 0) {
/* 1636 */           remark = "您需要在今天还款" + repayModel.getAmount() + "元";
/*      */         }
/*      */       }
/*      */     }
/* 1640 */     return remark;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ManageBorrowModel getModelByBorrowId(long borrowId)
/*      */   {
/* 1649 */     ManageBorrowModel model = new ManageBorrowModel();
/* 1650 */     Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowId));
/* 1651 */     if (borrow == null) {
/* 1652 */       logger.error("查询的借款标不存在");
/*      */     } else {
/* 1654 */       model = ManageBorrowModel.instance(borrow);
/*      */       
/* 1656 */       model.setBorrowId(borrow.getId().longValue());
/* 1657 */       UserBaseInfo userBaseInfo = this.userBaseInfoMapper.findByUserId(borrow
/* 1658 */         .getUserId());
/* 1659 */       if (userBaseInfo != null) {
/* 1660 */         model.setPhone(userBaseInfo.getPhone());
/* 1661 */         model.setRealName(userBaseInfo.getRealName());
/*      */       }
/*      */       
/* 1664 */       Map<String, Object> paramMap = new HashMap();
/* 1665 */       paramMap.put("borrowId", Long.valueOf(borrowId));
/* 1666 */       paramMap.put("state", "30");
/* 1667 */       BorrowProgress bp = (BorrowProgress)this.borrowProgressMapper.findSelective(paramMap);
/* 1668 */       if (bp != null) {
/* 1669 */         model.setLoanTime(bp.getCreateTime());
/*      */       }
/* 1671 */       paramMap = new HashMap();
/* 1672 */       paramMap.put("borrowId", Long.valueOf(borrowId));
/* 1673 */       BorrowRepay borrowRepay = (BorrowRepay)this.borrowRepayMapper.findSelective(paramMap);
/* 1674 */       if (borrowRepay != null) {
/* 1675 */         model.setPenaltyAmout(borrowRepay.getPenaltyAmout());
/* 1676 */         model.setPenaltyDay(borrowRepay.getPenaltyDay());
/* 1677 */         if (StringUtil.isNotBlank(borrowRepay.getAmount())) {
/* 1678 */           model.setRepayTotal(Double.valueOf(BigDecimalUtil.add(new double[] { borrowRepay.getAmount().doubleValue(), borrowRepay.getPenaltyAmout().doubleValue() })));
/*      */         } else {
/* 1680 */           model.setRepayTotal(Double.valueOf(0.0D));
/*      */         }
/*      */       }
/* 1683 */       paramMap = new HashMap();
/* 1684 */       paramMap.put("borrowId", Long.valueOf(borrowId));
/* 1685 */       BorrowRepayLog borrowRepaylog = 
/* 1686 */         (BorrowRepayLog)this.borrowRepayLogMapper.findSelective(paramMap);
/* 1687 */       if (borrowRepaylog != null) {
/* 1688 */         model.setRepayTime(DateUtil.dateStr(borrowRepaylog.getRepayTime(), "yyyy-MM-dd HH:mm:ss"));
/* 1689 */         model.setRepayAmount(borrowRepaylog.getAmount());
/* 1690 */         if (StringUtil.isNotBlank(borrowRepay.getAmount())) {
/* 1691 */           model.setRepayYesTotal(Double.valueOf(BigDecimalUtil.add(new double[] { borrowRepaylog.getAmount().doubleValue(), borrowRepaylog.getPenaltyAmout().doubleValue() })));
/*      */         } else {
/* 1693 */           model.setRepayYesTotal(Double.valueOf(0.0D));
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 1698 */       paramMap = new HashMap();
/* 1699 */       paramMap.put("borrowId", Long.valueOf(borrowId));
/* 1700 */       UrgeRepayOrder order = (UrgeRepayOrder)this.urgeRepayOrderMapper.findSelective(paramMap);
/* 1701 */       if (order != null) {
/* 1702 */         model.setLevel(order.getLevel());
/*      */       }
/*      */     }
/*      */     
/* 1706 */     return model;
/*      */   }
/*      */   
/*      */   public Page<ManageBorrowModel> listBorrowModel(Map<String, Object> params, int currentPage, int pageSize)
/*      */   {
/* 1711 */     PageHelper.startPage(currentPage, pageSize);
/* 1712 */     List<ManageBorrowModel> list = this.clBorrowMapper.listBorrowModel(params);
/* 1713 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public Page<ManageBorrowModel> listBorrow(Map<String, Object> params, int currentPage, int pageSize)
/*      */   {
/* 1718 */     PageHelper.startPage(currentPage, pageSize);
/* 1719 */     List<ManageBorrowModel> list = this.clBorrowMapper.listBorrow(params);
/* 1720 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public Borrow findLast(Map<String, Object> searchMap)
/*      */   {
/* 1725 */     return this.clBorrowMapper.findLast(searchMap);
/*      */   }
/*      */   
/*      */   public void updatePayState(Map<String, Object> paramMap)
/*      */   {
/* 1730 */     int result = this.clBorrowMapper.updatePayState(paramMap);
/* 1731 */     if (result < 1) {
/* 1732 */       throw new BussinessException("当前借款状态不允许修改");
/*      */     }
/*      */   }
/*      */   
/*      */   public Borrow findByPrimary(Long borrowId)
/*      */   {
/* 1738 */     return (Borrow)this.clBorrowMapper.findByPrimary(borrowId);
/*      */   }
/*      */   
/*      */   public Borrow rcBorrowApply(Borrow borrow, String tradePwd, String mobileType) throws Exception
/*      */   {
/* 1743 */     Borrow realBorrow = null;
/*      */     
/* 1745 */     boolean isCanBorrow = isCanBorrow(borrow, tradePwd);
/* 1746 */     if (isCanBorrow) {
/* 1747 */       realBorrow = saveBorrow(borrow);
/*      */     }
/* 1749 */     if ((realBorrow != null) && (realBorrow.getId().longValue() > 0L)) {
/* 1750 */       long borrowId = realBorrow.getId().longValue();
/* 1751 */       savePressState(realBorrow, "10");
/* 1752 */       modifyCredit(realBorrow.getUserId(), realBorrow.getAmount().doubleValue(), "used");
/*      */       
/* 1754 */       List<TppServiceInfoModel> infoList = this.sceneBusinessMapper.findTppServiceInfo(isRiskBorrow(borrow.getUserId()));
/*      */       
/*      */ 
/* 1757 */       logger.debug("审核需要执行的接口信息" + JSONObject.toJSONString(infoList));
/*      */       
/* 1759 */       if ((infoList != null) && (infoList.size() > 0)) {
/* 1760 */         SceneBusinessLog sceneLog = null;
/* 1761 */         for (TppServiceInfoModel info : infoList) {
/* 1762 */           boolean needExcute = this.sceneBusinessLogService.needExcute(realBorrow.getUserId(), info.getBusId(), info.getGetWay(), info.getPeriod());
/* 1763 */           if (needExcute) {
/* 1764 */             sceneLog = new SceneBusinessLog(info.getSceneId(), realBorrow.getId(), realBorrow.getUserId(), info.getTppId(), info.getBusId(), info.getBusNid(), realBorrow.getCreateTime(), info.getType(), null);
/* 1765 */             this.sceneBusinessLogMapper.save(sceneLog);
/*      */           }
/*      */         }
/*      */       }
/*      */     } else {
/* 1770 */       throw new BussinessException("借款失败");
/*      */     }
/* 1772 */     return realBorrow;
/*      */   }
/*      */   
/*      */   public void getThirdServiceData(final Borrow borrow, final String nid, final Long tppId, final String mobileType, final String adaptedId)
/*      */   {
/* 1777 */     if ("CreditScoreQuery".equals(nid)) {
/* 1778 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 1780 */           int count = ClBorrowServiceImpl.this.zhimaService.updateZhimaScore(borrow.getUserId());
/* 1781 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 1783 */       });
/* 1784 */       t.start();
/*      */ 
/*      */     }
/* 1787 */     else if ("QcRisk".equals(nid))
/*      */     {
/* 1789 */       String reborrow_qiancheng_switch = Global.getValue("reborrow_qiancheng_switch");
/* 1790 */       if ((reborrow_qiancheng_switch == null) || (reborrow_qiancheng_switch.equals(""))) {
/* 1791 */         reborrow_qiancheng_switch = "2";
/*      */       }
/* 1793 */       int borrowCount = 0;
/* 1794 */       if (reborrow_qiancheng_switch.equals("1")) {
/* 1795 */         borrowCount = this.clBorrowMapper.userBorrowCount(borrow.getUserId().longValue());
/*      */       }
/* 1797 */       if (borrowCount == 0)
/*      */       {
/* 1799 */         Thread t = new Thread(new Runnable() {
/*      */           public void run() {
/* 1801 */             TppBusiness bussiness = ClBorrowServiceImpl.this.tppBusinessService.findByNid(nid, tppId);
/* 1802 */             String reqOrderNo = RandomUtil.getRandomNumString(9);
/* 1803 */             String operatorNo = ClBorrowServiceImpl.this.operatorReqLogMapper.findOrderByUserId(borrow.getUserId());
/* 1804 */             String qcRsMsg = ClBorrowServiceImpl.this.rcQianchenService.qianchenRiskRequest(borrow.getUserId(), borrow, operatorNo, reqOrderNo, bussiness);
/* 1805 */             ClBorrowServiceImpl.logger.info("qianchen返回结果" + qcRsMsg);
/* 1806 */             ClBorrowServiceImpl.this.saveQcResult(qcRsMsg, borrow);
/*      */           }
/* 1808 */         });
/* 1809 */         t.start();
/*      */       }
/*      */       else {
/* 1812 */         syncSceneBusinessLog("1", "成功", borrow.getId(), "QcRisk");
/*      */       }
/*      */     }
/* 1815 */     else if ("TongdunApply".equals(nid)) {
/* 1816 */       logger.info("进入同盾贷前审核数据查询");
/* 1817 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 1819 */           TppBusiness bussiness = ClBorrowServiceImpl.this.tppBusinessService.findByNid(nid, tppId);
/* 1820 */           int count = ClBorrowServiceImpl.this.tongdunReqLogService.preloanApplyRequest(borrow.getUserId(), borrow, bussiness, mobileType);
/* 1821 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 1823 */       });
/* 1824 */       t.start();
/*      */     }
/* 1826 */     else if ("FireeyesBlack".equals(nid)) {
/* 1827 */       logger.info("进入火眼黑名单查询");
/* 1828 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 1830 */           TppBusiness business = ClBorrowServiceImpl.this.tppBusinessService.findByNid(nid, tppId);
/* 1831 */           int count = ClBorrowServiceImpl.this.fireeyesBlackLogService.queryFireeyesBlack(borrow, business);
/* 1832 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 1834 */       });
/* 1835 */       t.start();
/*      */     }
/* 1837 */     else if ("DhbSauron".equals(nid)) {
/* 1838 */       logger.info("进入贷后邦_反欺诈信息查询");
/* 1839 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 1841 */           TppBusiness business = ClBorrowServiceImpl.this.tppBusinessService.findByNid(nid, tppId);
/* 1842 */           int count = ClBorrowServiceImpl.this.dhbReqLogService.queryDhbSauron(borrow, business);
/* 1843 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 1845 */       });
/* 1846 */       t.start();
/* 1847 */     } else if ("WhiteKnight".equals(nid)) {
/* 1848 */       logger.info("进入白骑士_反欺诈信息查询");
/* 1849 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 1851 */           TppBusiness business = ClBorrowServiceImpl.this.tppBusinessService.findByNid(nid, tppId);
/* 1852 */           int count = ClBorrowServiceImpl.this.whiteKnightService.queryWhiteKnight(borrow, business);
/* 1853 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 1855 */       });
/* 1856 */       t.start();
/* 1857 */     } else if ("YdModel".equals(nid)) {
/* 1858 */       logger.info("进入有盾_联合建模查询");
/* 1859 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 1861 */           TppBusiness business = ClBorrowServiceImpl.this.tppBusinessService.findByNid(nid, tppId);
/* 1862 */           int count = ClBorrowServiceImpl.this.youdunModelService.queryYouDModel(borrow, business);
/* 1863 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 1865 */       });
/* 1866 */       t.start();
/*      */     } else {
/* 1868 */       logger.error("没有找到" + nid + "对应的第三方接口信息");
/*      */     }
/*      */   }
/*      */   
/*      */   public void rcBorrowRuleVerify(Long borrowId, String adaptedId)
/*      */   {
/* 1874 */     Borrow borrow = (Borrow)getById(borrowId);
/* 1875 */     String resultType = "30";
/*      */     
/* 1877 */     List<RuleEngineConfig> configCollection = this.ruleEngineConfigMapper.findRuleEnginConfigForBorrow(adaptedId);
/*      */     
/* 1879 */     if ((configCollection != null) && (!configCollection.isEmpty()))
/*      */     {
/*      */ 
/* 1882 */       boolean review = false;
/*      */       
/*      */ 
/* 1885 */       for (int i = 0; i < configCollection.size(); i++) {
/* 1886 */         RuleEngineConfig config = (RuleEngineConfig)configCollection.get(i);
/* 1887 */         BorrowRuleResult result = new BorrowRuleResult();
/* 1888 */         result.setBorrowId(borrowId);
/* 1889 */         result.setRuleId(config.getRuleEnginId());
/* 1890 */         result.setTbNid(config.getCtable());
/* 1891 */         result.setTbName(config.getTableComment());
/* 1892 */         result.setColNid(config.getCcolumn());
/* 1893 */         result.setColName(config.getColumnComment());
/* 1894 */         result.setRule(config.getFormula());
/* 1895 */         result.setAddTime(new Date());
/* 1896 */         result.setUserId(borrow.getUserId());
/* 1897 */         result.setAdaptedId(adaptedId);
/*      */         
/*      */ 
/* 1900 */         String tabelName = config.getCtable();
/* 1901 */         if ((!"".equals(config.getCtable())) && (config.getCtable() != null)) {
/* 1902 */           tabelName = ShardTableUtil.generateTableNameById(config.getCtable(), borrow.getUserId().longValue(), 30000L);
/*      */         }
/* 1904 */         String statement = "select " + config.getCcolumn() + " from " + tabelName + " where user_id = " + borrow.getUserId() + " order by id desc limit 1";
/* 1905 */         if (config.getCtable().equals("cl_user")) {
/* 1906 */           statement = "select " + config.getCcolumn() + " from " + tabelName + " where id = " + borrow.getUserId() + " order by id desc limit 1";
/*      */         }
/*      */         
/* 1909 */         String value = this.ruleEngineMapper.findValidValue(statement);
/* 1910 */         boolean flag = false;
/* 1911 */         result.setValue(config.getCvalue());
/*      */         
/* 1913 */         if (StringUtil.isNotBlank(value))
/*      */         {
/* 1915 */           if ("int".equals(config.getType()))
/*      */           {
/* 1917 */             SimpleRule simpleRule = RulesExecutorUtil.singleRuleResult(config.getId(), config.getCcolumn(), config.getFormula(), config.getCvalue(), value, config.getType(), "");
/*      */             
/* 1919 */             if ("Y".equals(simpleRule.getComparResult())) {
/* 1920 */               result.setResult("Y");
/* 1921 */               flag = true;
/*      */             } else {
/* 1923 */               result.setResult("N");
/*      */             }
/* 1925 */           } else if ("string".equals(config.getType())) {
/* 1926 */             flag = GenerateRule.comparText(config.getFormula(), value, config.getCvalue());
/* 1927 */             result.setResult(flag ? "Y" : "N");
/*      */           }
/*      */           
/* 1930 */           result.setMatching(value != null ? value : "");
/* 1931 */           result.setResultType(config.getResult());
/*      */         }
/*      */         else {
/* 1934 */           flag = GenerateRule.comparText(config.getFormula(), "未知", config.getCvalue());
/* 1935 */           result.setResult(flag ? "Y" : "N");
/*      */           
/* 1937 */           result.setMatching("未知 ");
/* 1938 */           result.setResultType(config.getResult());
/*      */         }
/*      */         
/* 1941 */         this.borrowRuleResultMapper.save(result);
/* 1942 */         if (flag) {
/* 1943 */           resultType = config.getResult();
/* 1944 */           if ("20".equals(config.getResult())) {
/* 1945 */             review = true;
/*      */           }
/* 1947 */           if ("10".equals(config.getResult())) {
/*      */             break;
/*      */           }
/*      */         }
/*      */         
/* 1952 */         if (i == configCollection.size() - 1)
/*      */         {
/* 1954 */           if (review) {
/* 1955 */             resultType = "20";
/* 1956 */             break; }
/* 1957 */           resultType = "30";
/*      */           
/* 1959 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1965 */     if (StringUtil.isNotBlank(resultType))
/*      */     {
/* 1967 */       if ("10".equals(resultType)) {
/* 1968 */         modifyState(borrow.getId().longValue(), "21");
/* 1969 */         savePressState(borrow, "21");
/* 1970 */         modifyCredit(borrow.getUserId(), borrow.getAmount().doubleValue(), "unuse");
/*      */ 
/*      */       }
/* 1973 */       else if ("20".equals(resultType)) {
/* 1974 */         modifyState(borrow.getId().longValue(), "22");
/* 1975 */         savePressState(borrow, "22");
/*      */       }
/*      */       else
/*      */       {
/* 1979 */         modifyState(borrow.getId().longValue(), "20");
/* 1980 */         savePressState(borrow, "20");
/*      */         
/* 1982 */         borrowLoan(borrow, new Date());
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1987 */       modifyState(borrow.getId().longValue(), "21");
/* 1988 */       savePressState(borrow, "21");
/* 1989 */       modifyCredit(borrow.getUserId(), borrow.getAmount().doubleValue(), "unuse");
/*      */     }
/*      */   }
/*      */   
/*      */   public void getStatisticsServiceData(final Borrow borrow, final String nid, final String adaptedId) {
/* 1994 */     if ("borrow".equals(nid)) {
/* 1995 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 1997 */           int count = ClBorrowServiceImpl.this.borrowCountService.countBorrowRefusedTimes(borrow.getUserId());
/* 1998 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 2000 */       });
/* 2001 */       t.start();
/* 2002 */     } else if ("simple_borrow_count".equals(nid)) {
/* 2003 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 2005 */           int count = ClBorrowServiceImpl.this.simpleBorrowCountService.countOne(borrow.getUserId().longValue());
/* 2006 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 2008 */       });
/* 2009 */       t.start();
/* 2010 */     } else if ("simple_contact_count".equals(nid)) {
/* 2011 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 2013 */           int count = ClBorrowServiceImpl.this.simpleContactCountService.countOne(borrow.getUserId().longValue());
/* 2014 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 2016 */       });
/* 2017 */       t.start();
/* 2018 */     } else if ("simple_voices_count".equals(nid)) {
/* 2019 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 2021 */           int count = ClBorrowServiceImpl.this.simpleVoicesCountService.countOne(borrow.getUserId().longValue());
/* 2022 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 2024 */       });
/* 2025 */       t.start();
/* 2026 */     } else if ("concats".equals(nid)) {
/* 2027 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 2029 */           int count = ClBorrowServiceImpl.this.contactCountService.countContacts(borrow.getUserId());
/* 2030 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 2032 */       });
/* 2033 */       t.start();
/* 2034 */     } else if ("operator_voice".equals(nid)) {
/* 2035 */       Thread t = new Thread(new Runnable() {
/*      */         public void run() {
/* 2037 */           int count = ClBorrowServiceImpl.this.operatorCountService.operatorCountVoice(borrow.getUserId());
/* 2038 */           ClBorrowServiceImpl.this.syncSceneBusinessLog(borrow.getId(), nid, count, adaptedId);
/*      */         }
/* 2040 */       });
/* 2041 */       t.start();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2054 */       logger.error("没有找到" + nid + "对应的统计处理");
/*      */     }
/*      */   }
/*      */   
/*      */   public void syncSceneBusinessLog(Long borrowId, String nid, int count, String adaptedId)
/*      */   {
/* 2060 */     Map<String, Object> params = new HashMap();
/* 2061 */     params.put("borrowId", borrowId);
/* 2062 */     params.put("nid", nid);
/* 2063 */     SceneBusinessLog log = (SceneBusinessLog)this.sceneBusinessLogMapper.findSelective(params);
/*      */     
/* 2065 */     if (log != null) {
/* 2066 */       String state = "0";
/* 2067 */       String desc = "失败";
/* 2068 */       if (count > 0) {
/* 2069 */         state = "1";
/* 2070 */         desc = "成功";
/*      */       }
/* 2072 */       log.setUpdateTime(new Date());
/* 2073 */       log.setRsState(state);
/* 2074 */       log.setRsDesc(desc);
/* 2075 */       int result = this.sceneBusinessLogMapper.update(log);
/* 2076 */       logger.info("syncSceneBusinessLog，borrowId：" + borrowId + "，nid：" + nid + "，syncSceneBusinessLog更新结果：" + result);
/* 2077 */       SceneBusinessLog bean = new SceneBusinessLog();
/* 2078 */       bean.setBorrowId(borrowId);
/* 2079 */       bean.setRsState("0");
/* 2080 */       bean.setScene(adaptedId);
/* 2081 */       boolean haveNeed = this.sceneBusinessLogService.haveNeedExcuteService(bean);
/* 2082 */       if (!haveNeed) {
/* 2083 */         rcBorrowRuleVerify(borrowId, adaptedId);
/*      */       }
/*      */     } else {
/* 2086 */       logger.error("syncSceneBusinessLog，borrowId：" + borrowId + "，nid：" + nid + "，未找到对应的sceneBusinessLog");
/*      */     }
/*      */   }
/*      */   
/*      */   public Map<String, Object> syncSceneBusinessLog(String adaptedId, Long userId, String nid, int count)
/*      */   {
/* 2092 */     Map<String, Object> map = new HashMap();
/* 2093 */     Map<String, Object> params = new HashMap();
/* 2094 */     params.put("userId", userId);
/* 2095 */     params.put("nid", nid);
/* 2096 */     params.put("adaptedId", adaptedId);
/* 2097 */     SceneBusinessLog log = (SceneBusinessLog)this.sceneBusinessLogMapper.findSelective(params);
/*      */     
/* 2099 */     if (log != null) {
/* 2100 */       String state = "0";
/* 2101 */       String desc = "失败";
/* 2102 */       if (count > 0) {
/* 2103 */         state = "1";
/* 2104 */         desc = "成功";
/*      */       }
/* 2106 */       log.setUpdateTime(new Date());
/* 2107 */       log.setRsState(state);
/* 2108 */       log.setRsDesc(desc);
/* 2109 */       int result = this.sceneBusinessLogMapper.update(log);
/* 2110 */       logger.info("syncSceneBusinessLog，userId：" + userId + "，nid：" + nid + "，syncSceneBusinessLog更新结果：" + result);
/* 2111 */       SceneBusinessLog bean = new SceneBusinessLog();
/* 2112 */       bean.setNid(nid);
/* 2113 */       bean.setUserId(userId);
/* 2114 */       bean.setScene(adaptedId);
/* 2115 */       bean.setRsState("0");
/* 2116 */       boolean haveNeed = this.sceneBusinessLogService.haveNeedExcuteService(bean);
/* 2117 */       if (!haveNeed) {
/* 2118 */         map = rcBorrowRuleRealAuthVerify(userId);
/*      */       }
/*      */     } else {
/* 2121 */       logger.error("syncSceneBusinessLog，userId：" + userId + "，nid：" + nid + "，未找到对应的sceneBusinessLog");
/*      */     }
/* 2123 */     return map;
/*      */   }
/*      */   
/*      */   public Map<String, Object> syncSceneBusinessLog(String adaptedId, String phone, String nid, int count)
/*      */   {
/* 2128 */     Map<String, Object> map = new HashMap();
/* 2129 */     Map<String, Object> params = new HashMap();
/* 2130 */     params.put("phone", phone);
/* 2131 */     params.put("nid", nid);
/* 2132 */     params.put("adaptedId", adaptedId);
/* 2133 */     SceneBusinessLog log = (SceneBusinessLog)this.sceneBusinessLogMapper.findSelective(params);
/*      */     
/* 2135 */     if (log != null) {
/* 2136 */       String state = "0";
/* 2137 */       String desc = "失败";
/* 2138 */       if (count > 0) {
/* 2139 */         state = "1";
/* 2140 */         desc = "成功";
/*      */       }
/* 2142 */       log.setUpdateTime(new Date());
/* 2143 */       log.setRsState(state);
/* 2144 */       log.setRsDesc(desc);
/* 2145 */       int result = this.sceneBusinessLogMapper.update(log);
/* 2146 */       logger.info("syncSceneBusinessLog，phone：" + phone + "，nid：" + nid + "，syncSceneBusinessLog更新结果：" + result);
/*      */     } else {
/* 2148 */       logger.error("syncSceneBusinessLog，phone：" + phone + "，nid：" + nid + "，未找到对应的sceneBusinessLog");
/*      */     }
/* 2150 */     return map;
/*      */   }
/*      */   
/*      */   public Map<String, Object> rcBorrowRuleRealAuthVerify(Long userId) {
/* 2154 */     Map<String, Object> map = new HashMap();
/* 2155 */     UserBaseInfo userBaseInfo = this.userBaseInfoMapper.findByUserId(userId);
/* 2156 */     String resultType = "10";
/*      */     
/* 2158 */     List<RuleEngineConfig> configCollection = this.ruleEngineConfigMapper.findRuleEnginConfigForBorrow("30");
/* 2159 */     if ((configCollection != null) && (!configCollection.isEmpty()))
/*      */     {
/* 2161 */       boolean review = false;
/* 2162 */       BorrowRuleResult bean = new BorrowRuleResult();
/* 2163 */       bean.setUserId(userId);
/* 2164 */       bean.setAdaptedId("30");
/*      */       
/* 2166 */       this.borrowRuleResultMapper.delete(bean);
/*      */       
/* 2168 */       for (int i = 0; i < configCollection.size(); i++) {
/* 2169 */         RuleEngineConfig config = (RuleEngineConfig)configCollection.get(i);
/* 2170 */         BorrowRuleResult result = new BorrowRuleResult();
/* 2171 */         result.setBorrowId(null);
/* 2172 */         result.setRuleId(config.getRuleEnginId());
/* 2173 */         result.setTbNid(config.getCtable());
/* 2174 */         result.setTbName(config.getTableComment());
/* 2175 */         result.setColNid(config.getCcolumn());
/* 2176 */         result.setColName(config.getColumnComment());
/* 2177 */         result.setRule(config.getFormula());
/* 2178 */         result.setAddTime(new Date());
/* 2179 */         result.setUserId(userId);
/* 2180 */         result.setAdaptedId("30");
/*      */         
/* 2182 */         String tabelName = config.getCtable();
/* 2183 */         if ((!"".equals(config.getCtable())) && (config.getCtable() != null)) {
/* 2184 */           tabelName = ShardTableUtil.generateTableNameById(config.getCtable(), userBaseInfo.getUserId().longValue(), 30000L);
/*      */         }
/* 2186 */         String statement = "select " + config.getCcolumn() + " from " + tabelName + " where user_id = " + userBaseInfo.getUserId() + " order by id desc limit 1";
/* 2187 */         if (config.getCtable().equals("cl_user")) {
/* 2188 */           statement = "select " + config.getCcolumn() + " from " + tabelName + " where id = " + userBaseInfo.getUserId() + " order by id desc limit 1";
/*      */         }
/*      */         
/* 2191 */         String value = this.ruleEngineMapper.findValidValue(statement);
/* 2192 */         boolean flag = false;
/* 2193 */         result.setValue(config.getCvalue());
/*      */         
/* 2195 */         if (StringUtil.isNotBlank(value))
/*      */         {
/* 2197 */           if ("int".equals(config.getType()))
/*      */           {
/* 2199 */             SimpleRule simpleRule = RulesExecutorUtil.singleRuleResult(config.getId(), config.getCcolumn(), config.getFormula(), config.getCvalue(), value, config.getType(), "");
/*      */             
/* 2201 */             if ("Y".equals(simpleRule.getComparResult())) {
/* 2202 */               result.setResult("Y");
/* 2203 */               flag = true;
/*      */             } else {
/* 2205 */               result.setResult("N");
/*      */             }
/* 2207 */           } else if ("string".equals(config.getType())) {
/* 2208 */             flag = GenerateRule.comparText(config.getFormula(), value, config.getCvalue());
/* 2209 */             result.setResult(flag ? "Y" : "N");
/*      */           }
/*      */           
/* 2212 */           result.setMatching(value != null ? value : "");
/* 2213 */           result.setResultType(config.getResult());
/*      */         }
/*      */         else
/*      */         {
/* 2217 */           result.setMatching("未知 ");
/* 2218 */           result.setResult("N");
/* 2219 */           result.setResultType("20");
/* 2220 */           resultType = "20";
/*      */         }
/*      */         
/* 2223 */         this.borrowRuleResultMapper.save(result);
/* 2224 */         if (flag) {
/* 2225 */           resultType = config.getResult();
/* 2226 */           if ("20".equals(config.getResult())) {
/* 2227 */             review = true;
/*      */           }
/* 2229 */           if ("10".equals(config.getResult())) {
/*      */             break;
/*      */           }
/*      */         }
/*      */         
/* 2234 */         if (i == configCollection.size() - 1)
/*      */         {
/* 2236 */           if (review) {
/* 2237 */             resultType = "20";
/* 2238 */             break; }
/* 2239 */           resultType = "30";
/*      */           
/* 2241 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 2247 */     if (StringUtil.isNotBlank(resultType))
/*      */     {
/* 2249 */       if ("10".equals(resultType)) {
/* 2250 */         map.put("code", Integer.valueOf(400));
/* 2251 */         map.put("msg", "非常抱歉您的实名认证不通过，根据系统检测，您目前信用不良，无可用借款额度，请5天后再来申请");
/*      */       }
/* 2253 */       else if ("20".equals(resultType)) {
/* 2254 */         map.put("code", Integer.valueOf(400));
/* 2255 */         map.put("msg", "系统维护中，请稍后再试");
/*      */       }
/*      */       else
/*      */       {
/* 2259 */         map.put("code", Integer.valueOf(200));
/* 2260 */         map.put("msg", "恭喜您实名认证通过");
/*      */       }
/*      */     } else {
/* 2263 */       map.put("code", Integer.valueOf(400));
/* 2264 */       map.put("msg", "非常抱歉您的实名认证不通过，根据系统检测，您目前信用不良，无可用借款额度，请5天后再来申请");
/*      */     }
/* 2266 */     return map;
/*      */   }
/*      */   
/*      */   public void syncSceneBusinessLog(String state, String desc, Long borrowId, String nid)
/*      */   {
/* 2271 */     Map<String, Object> params = new HashMap();
/* 2272 */     params.put("borrowId", borrowId);
/* 2273 */     params.put("nid", nid);
/* 2274 */     SceneBusinessLog log = (SceneBusinessLog)this.sceneBusinessLogMapper.findSelective(params);
/*      */     
/* 2276 */     Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(borrowId);
/*      */     
/* 2278 */     String adaptedId = isRiskBorrow(borrow.getUserId());
/* 2279 */     if (log != null) {
/* 2280 */       log.setUpdateTime(new Date());
/* 2281 */       log.setRsState(state);
/* 2282 */       log.setRsDesc(desc);
/* 2283 */       this.sceneBusinessLogMapper.update(log);
/* 2284 */       SceneBusinessLog bean = new SceneBusinessLog();
/* 2285 */       bean.setBorrowId(borrowId);
/* 2286 */       bean.setRsState("0");
/* 2287 */       boolean haveNeed = this.sceneBusinessLogService.haveNeedExcuteService(bean);
/* 2288 */       if (!haveNeed) {
/* 2289 */         rcBorrowRuleVerify(borrowId, adaptedId);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public String isRiskBorrow(Long userId) {
/* 2295 */     String adaptedId = "10";
/*      */     
/* 2297 */     Map<String, Object> res = new HashMap();
/* 2298 */     res.put("userId", userId);
/* 2299 */     res.put("state", Integer.valueOf(10));
/*      */     
/* 2301 */     List<BorrowRepayModel> listRepay = this.borrowRepayMapper.listSelModel(res);
/* 2302 */     if ((listRepay != null) && (listRepay.size() > 0)) {
/* 2303 */       adaptedId = "40";
/*      */     }
/* 2305 */     return adaptedId;
/*      */   }
/*      */   
/*      */   public void verifyBorrowData(long borrowId, long userId)
/*      */   {
/* 2310 */     Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(Long.valueOf(borrowId));
/* 2311 */     SceneBusinessLog bean = new SceneBusinessLog();
/* 2312 */     bean.setBorrowId(Long.valueOf(borrowId));
/*      */     
/* 2314 */     bean.setRsState("0");
/* 2315 */     bean.setScene("10");
/* 2316 */     List<SceneBusinessLog> sceneLogList = this.sceneBusinessLogMapper.findSceneLogUnFinish(bean);
/*      */     
/* 2318 */     String adaptedId = isRiskBorrow(borrow.getUserId());
/* 2319 */     if (borrow != null) {
/* 2320 */       if ((sceneLogList != null) && (!sceneLogList.isEmpty())) {
/* 2321 */         for (SceneBusinessLog log : sceneLogList) {
/* 2322 */           if ("20".equals(log.getType())) {
/* 2323 */             getStatisticsServiceData(borrow, log.getNid(), adaptedId);
/* 2324 */           } else if ("10".equals(log.getType())) {
/* 2325 */             getThirdServiceData(borrow, log.getNid(), log.getTppId(), "0", adaptedId);
/*      */           }
/*      */         }
/*      */       } else {
/* 2329 */         rcBorrowRuleVerify(Long.valueOf(borrowId), adaptedId);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void reVerifyBorrowData(Long borrowId)
/*      */   {
/* 2336 */     Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(borrowId);
/*      */     
/* 2338 */     String adaptedId = isRiskBorrow(borrow.getUserId());
/* 2339 */     SceneBusinessLog bean = new SceneBusinessLog();
/* 2340 */     bean.setBorrowId(borrowId);
/*      */     
/* 2342 */     bean.setRsState("0");
/* 2343 */     bean.setScene(adaptedId);
/* 2344 */     bean.setUserId(borrow.getUserId());
/* 2345 */     List<SceneBusinessLog> sceneLogList = this.sceneBusinessLogMapper.findSceneLogUnFinish(bean);
/* 2346 */     if ((borrow != null) && (sceneLogList != null) && (!sceneLogList.isEmpty())) {
/* 2347 */       logger.info("风控审核重触发，borrowId：" + borrow.getId() + "进入征信数据重获取流程");
/*      */       
/* 2349 */       for (SceneBusinessLog log : sceneLogList)
/*      */       {
/* 2351 */         if ("20".equals(log.getType())) {
/* 2352 */           getStatisticsServiceData(borrow, log.getNid(), adaptedId);
/*      */         }
/* 2354 */         else if ("10".equals(log.getType())) {
/* 2355 */           getThirdServiceData(borrow, log.getNid(), log.getTppId(), "0", adaptedId);
/*      */         }
/*      */       }
/* 2358 */     } else if ((sceneLogList == null) || (sceneLogList.isEmpty())) {
/* 2359 */       Map<String, Object> ruleResultMap = new HashMap();
/* 2360 */       ruleResultMap.put("borrowId", borrowId);
/* 2361 */       ruleResultMap.put("adaptedId", adaptedId);
/* 2362 */       Object resultList = this.borrowRuleResultMapper.listSelective(ruleResultMap);
/* 2363 */       if ((resultList == null) || (((List)resultList).isEmpty())) {
/* 2364 */         logger.info("风控审核重触发，borrowId：" + borrow.getId() + "进入规则审核流程");
/* 2365 */         rcBorrowRuleVerify(borrowId, adaptedId);
/* 2366 */       } else if (("20".equals(borrow.getState())) || 
/* 2367 */         ("26".equals(borrow.getState()))) {
/* 2368 */         logger.info("风控审核重触发，borrowId：" + borrow.getId() + "进入放款流程");
/* 2369 */         borrowLoan(borrow, DateUtil.getNow());
/*      */       }
/*      */     } else {
/* 2372 */       logger.info("风控审核重触发，borrowId：" + borrow.getId() + "，不满足执行条件，执行失败");
/*      */     }
/*      */   }
/*      */   
/*      */   public List listBorrow(Map<String, Object> params) {
/* 2377 */     List<ManageBorrowExportModel> list = this.clBorrowMapper.listExportModel(params);
/* 2378 */     for (ManageBorrowExportModel model : list) {
/* 2379 */       model.setState(BorrowModel.apiConvertBorrowState(model.getState()));
/* 2380 */       UserBaseInfo ubi = this.userBaseInfoMapper.findByUserId(model.getUserId());
/* 2381 */       if (ubi != null) {
/* 2382 */         model.setRealName(ubi.getRealName());
/* 2383 */         model.setPhone(ubi.getPhone());
/*      */       }
/* 2385 */       Map<String, Object> params2 = new HashMap();
/* 2386 */       params2.put("borrowId", model.getId());
/* 2387 */       params2.put("state", "30");
/* 2388 */       BorrowProgress bp = (BorrowProgress)this.borrowProgressMapper.findSelective(params2);
/* 2389 */       if (bp != null) {
/* 2390 */         model.setLoanTime(bp.getCreateTime());
/*      */       }
/* 2392 */       Map<String, Object> params3 = new HashMap();
/* 2393 */       params3.put("borrowId", model.getId());
/* 2394 */       BorrowRepay br = (BorrowRepay)this.borrowRepayMapper.findSelective(params3);
/* 2395 */       if (br != null) {
/* 2396 */         model.setPenaltyDay(br.getPenaltyDay());
/* 2397 */         model.setPenaltyAmout(br.getPenaltyAmout().doubleValue());
/*      */       }
/* 2399 */       BorrowRepayLog brl = (BorrowRepayLog)this.borrowRepayLogMapper.findSelective(params3);
/* 2400 */       if (brl != null) {
/* 2401 */         model.setRepayAmount(brl.getAmount().doubleValue());
/* 2402 */         model.setRepayTime(brl.getRepayTime());
/*      */       }
/* 2404 */       UrgeRepayOrder uro = (UrgeRepayOrder)this.urgeRepayOrderMapper.findSelective(params3);
/* 2405 */       if (uro != null) {
/* 2406 */         model.setLevel(uro.getLevel());
/*      */       }
/*      */     }
/*      */     
/* 2410 */     return list;
/*      */   }
/*      */   
/*      */   public Page<ManageBorrowModel> listReview(Map<String, Object> params, int currentPage, int pageSize)
/*      */   {
/* 2415 */     PageHelper.startPage(currentPage, pageSize);
/* 2416 */     List<ManageBorrowModel> list = this.clBorrowMapper.listReview(params);
/* 2417 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public List<Borrow> findUserUnFinishedBorrow(long userId)
/*      */   {
/* 2422 */     return this.clBorrowMapper.findUserUnFinishedBorrow(Long.valueOf(userId));
/*      */   }
/*      */   
/*      */ 
/*      */   public Borrow findLastBorrow(long userId)
/*      */   {
/* 2428 */     return this.clBorrowMapper.findLastBorrow(userId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void rcRealAuthApply(String userId, String type)
/*      */   {
/* 2437 */     this.sceneBusinessLogMapper.deleteByUserId(Long.valueOf(userId));
/* 2438 */     List<TppServiceInfoModel> infoList = this.sceneBusinessMapper.findTppServiceInfo(type);
/*      */     
/* 2440 */     logger.debug("审核需要执行的接口信息" + JSONObject.toJSONString(infoList));
/*      */     
/* 2442 */     if ((infoList != null) && (infoList.size() > 0)) {
/* 2443 */       SceneBusinessLog sceneLog = null;
/* 2444 */       for (TppServiceInfoModel info : infoList) {
/* 2445 */         boolean needExcute = this.sceneBusinessLogService.needExcute(Long.valueOf(userId), info.getBusId(), info.getGetWay(), info.getPeriod());
/* 2446 */         if (needExcute) {
/* 2447 */           sceneLog = new SceneBusinessLog(info.getSceneId(), null, Long.valueOf(userId), info.getTppId(), info.getBusId(), info.getBusNid(), new Date(), info.getType(), null);
/* 2448 */           this.sceneBusinessLogMapper.save(sceneLog);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public Map<String, Object> verifyRealAuthData(String userId, String type)
/*      */   {
/* 2456 */     Map<String, Object> map = new HashMap();
/* 2457 */     UserBaseInfo bean = this.userBaseInfoMapper.findByUserId(Long.valueOf(userId));
/* 2458 */     SceneBusinessLog sceneBusinessLog = new SceneBusinessLog();
/*      */     
/* 2460 */     sceneBusinessLog.setUserId(Long.valueOf(userId));
/* 2461 */     sceneBusinessLog.setRsState("0");
/* 2462 */     sceneBusinessLog.setScene(type);
/* 2463 */     List<SceneBusinessLog> sceneLogList = this.sceneBusinessLogMapper.findSceneLogUnFinish(sceneBusinessLog);
/*      */     
/* 2465 */     if ((sceneLogList != null) && (!sceneLogList.isEmpty())) {
/* 2466 */       for (SceneBusinessLog log : sceneLogList) {
/* 2467 */         if ("10".equals(log.getType())) {
/* 2468 */           map = getThirdServiceData(bean, log.getNid(), log.getTppId(), "0", type);
/*      */         }
/*      */         
/*      */       }
/* 2472 */     } else if ("30".equals(type)) {
/* 2473 */       map = rcBorrowRuleRealAuthVerify(Long.valueOf(userId));
/*      */     }
/*      */     
/* 2476 */     return map;
/*      */   }
/*      */   
/*      */   public Map<String, Object> getThirdServiceData(UserBaseInfo bean, String nid, Long tppId, String mobileType, String category) {
/* 2480 */     Map<String, Object> map = new HashMap();
/*      */     
/* 2482 */     if ("QcBlack".equals(nid)) {
/* 2483 */       this.qianChengBlacklistLogService.deleteByUserId(bean.getUserId());
/* 2484 */       logger.info("进入浅橙黑名单查询");
/* 2485 */       TppBusiness business = this.tppBusinessService.findByNid(nid, tppId);
/* 2486 */       int count = this.qianChengBlacklistLogService.qianchengBlackRequest(bean.getUserId(), business);
/* 2487 */       map = syncSceneBusinessLog(category, bean.getUserId(), nid, count);
/*      */     }
/*      */     else {
/* 2490 */       logger.error("没有找到" + nid + "对应的第三方接口信息");
/*      */     }
/* 2492 */     return map;
/*      */   }
/*      */   
/*      */ 
/*      */   public List<RuleEngineConfig> findRuleEnginConfigForBorrow(String adaptedId)
/*      */   {
/* 2498 */     return this.ruleEngineConfigMapper.findRuleEnginConfigForBorrow(adaptedId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public ManageBorrowTotalModel totalBorrow(Map<String, Object> params)
/*      */   {
/* 2506 */     String borrowAmount = "0.00";
/* 2507 */     String penaltyAmount = "0.00";
/* 2508 */     ManageBorrowTotalModel bean = new ManageBorrowTotalModel();
/*      */     
/* 2510 */     Integer borrowCount = Integer.valueOf(this.clBorrowMapper.countService(params));
/* 2511 */     List<String> stateList = Arrays.asList(new String[] { "30", "40", 
/* 2512 */       "50", "41", "90" });
/* 2513 */     params.put("stateList", stateList);
/*      */     
/* 2515 */     Map<String, String> map = this.clBorrowMapper.countSuccessBorrow(params);
/* 2516 */     bean.setBorrowCount(String.valueOf(borrowCount));
/* 2517 */     bean.setBorrowSuccessCount(String.valueOf(map.get("count")));
/* 2518 */     params.put("penaltyAmout", "0");
/*      */     
/* 2520 */     Map<String, String> repayMap = this.borrowRepayMapper.totalBorrow(params);
/* 2521 */     bean.setPenaltyCount(bean.getBorrowSuccessCount() + "/" + String.valueOf(repayMap.get("count")));
/*      */     
/* 2523 */     List<RepayModel> list = this.clBorrowMapper.findRepay(params);
/* 2524 */     if ((list != null) && (!list.isEmpty())) {
/* 2525 */       borrowAmount = String.valueOf(((RepayModel)list.get(0)).getAmount());
/* 2526 */       penaltyAmount = String.valueOf(((RepayModel)list.get(0)).getPenaltyAmout());
/*      */     }
/* 2528 */     bean.setBorrowAmount(borrowAmount);
/* 2529 */     bean.setPenaltyAmount(penaltyAmount);
/* 2530 */     bean.setPenaltyTotalAmount(String.valueOf(repayMap.get("total")));
/* 2531 */     bean.setBorrowTotalAmount(String.valueOf(map.get("amount")));
/* 2532 */     bean.setTotalBorrowCount(bean.getBorrowCount() + "/" + bean.getBorrowSuccessCount());
/* 2533 */     return bean;
/*      */   }
/*      */   
/*      */   public List<GPSModel> listUserGPS(long userId)
/*      */   {
/* 2538 */     return this.clBorrowMapper.listUserGPS(userId);
/*      */   }
/*      */   
/*      */   public List<GPSModel> listBorrowGPS(long userId)
/*      */   {
/* 2543 */     return this.clBorrowMapper.listBorrowGPS(userId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void rcRegisterApply(String phone, String type)
/*      */   {
/* 2552 */     this.sceneBusinessLogMapper.deleteByPhone(phone);
/* 2553 */     List<TppServiceInfoModel> infoList = this.sceneBusinessMapper.findTppServiceInfo(type);
/*      */     
/* 2555 */     logger.debug("审核需要执行的接口信息" + JSONObject.toJSONString(infoList));
/*      */     
/* 2557 */     if ((infoList != null) && (infoList.size() > 0)) {
/* 2558 */       SceneBusinessLog sceneLog = null;
/* 2559 */       for (TppServiceInfoModel info : infoList) {
/* 2560 */         boolean needExcute = this.sceneBusinessLogService.needExcute(phone, info.getBusId(), info.getGetWay(), info.getPeriod());
/* 2561 */         if (needExcute) {
/* 2562 */           sceneLog = new SceneBusinessLog(info.getSceneId(), null, null, info.getTppId(), info.getBusId(), info.getBusNid(), new Date(), info.getType(), phone);
/* 2563 */           this.sceneBusinessLogMapper.save(sceneLog);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean verifyRegisterData(String phone, String type)
/*      */   {
/* 2574 */     SceneBusinessLog sceneBusinessLog = new SceneBusinessLog();
/*      */     
/* 2576 */     sceneBusinessLog.setPhone(phone);
/* 2577 */     sceneBusinessLog.setRsState("0");
/* 2578 */     sceneBusinessLog.setScene(type);
/* 2579 */     List<SceneBusinessLog> sceneLogList = this.sceneBusinessLogMapper.findSceneLogUnFinish(sceneBusinessLog);
/*      */     
/* 2581 */     if ((sceneLogList != null) && (!sceneLogList.isEmpty())) {
/* 2582 */       for (SceneBusinessLog log : sceneLogList) {
/* 2583 */         if ("10".equals(log.getType())) {
/* 2584 */           getThirdServiceData(phone, log.getNid(), log.getTppId(), "0", type);
/*      */         }
/*      */       }
/*      */     }
/* 2588 */     Map<String, Object> params = new HashMap();
/* 2589 */     params.put("phone", phone);
/* 2590 */     params.put("isBlack", Integer.valueOf(1));
/*      */     
/* 2592 */     if (this.rcHuadaoBlacklistLogService.listService(params).size() > 0) {
/* 2593 */       return true;
/*      */     }
/* 2595 */     return false;
/*      */   }
/*      */   
/*      */   private void getThirdServiceData(String phone, String nid, Long tppId, String mobileType, String category) {
/* 2599 */     if ("HuadaoBlacklist".equals(nid)) {
/* 2600 */       this.rcHuadaoBlacklistLogService.deleteByPhone(phone);
/* 2601 */       logger.info("进入华道黑名单查询");
/* 2602 */       TppBusiness business = this.tppBusinessService.findByNid(nid, tppId);
/* 2603 */       int count = this.rcHuadaoBlacklistLogService.queryHuadaoBlackList(phone, business);
/* 2604 */       syncSceneBusinessLog(category, phone, nid, count);
/*      */     } else {
/* 2606 */       logger.error("没有找到" + nid + "对应的第三方接口信息");
/*      */     }
/*      */   }
/*      */   
/*      */   public Map<String, Object> borrowOrLogin(String userId)
/*      */   {
/* 2612 */     boolean isBorrow = false;
/* 2613 */     boolean isPerfect = false;
/* 2614 */     Map<String, Object> borrowMap = new HashMap();
/* 2615 */     borrowMap.put("userId", Long.valueOf(Long.parseLong(userId)));
/* 2616 */     Borrow borrow = this.clBorrowMapper.findRepayBorrow(borrowMap);
/* 2617 */     if ((borrow != null) && (getBorrowDays(borrow.getUserId()) > 0)) {
/* 2618 */       isBorrow = true;
/*      */     }
/* 2620 */     List<BorrowProgressModel> list = new ArrayList();
/* 2621 */     if (borrow != null) {
/* 2622 */       list = borrowProgress(borrow, "index");
/*      */     }
/* 2624 */     if ((list != null) && (!list.isEmpty())) {
/* 2625 */       isBorrow = true;
/*      */     }
/* 2627 */     Map<String, Object> auth = this.userAuthService.getAuthState(borrowMap);
/* 2628 */     if ((auth != null) && (auth.get("qualified") != null) && 
/* 2629 */       (Integer.parseInt(auth.get("qualified").toString()) == 1)) {
/* 2630 */       isPerfect = true;
/*      */     }
/* 2632 */     Map<String, Object> map = new HashMap();
/* 2633 */     map.put("isBorrow", Boolean.valueOf(isBorrow));
/* 2634 */     map.put("isPerfect", Boolean.valueOf(isPerfect));
/* 2635 */     return map;
/*      */   }
/*      */   
/*      */   public Map<String, Long> countRiskBorrow(Long userId)
/*      */   {
/* 2640 */     return this.clBorrowMapper.countRiskBorrow(userId.longValue());
/*      */   }
/*      */   
/*      */   public Page<ManageCreditReviewModel> listReviewModel(Map<String, Object> params, int currentPage, int pageSize)
/*      */   {
/* 2645 */     PageHelper.startPage(currentPage, pageSize);
/* 2646 */     List<ManageCreditReviewModel> list = this.clBorrowMapper.listReviewModel(params);
/* 2647 */     return (Page)list;
/*      */   }
/*      */   
/*      */   public List<Long> listOrder(Map<String, Object> params)
/*      */   {
/* 2652 */     return this.clBorrowMapper.listOrder(params);
/*      */   }
/*      */   
/*      */   public List<?> listReview(Map<String, Object> params)
/*      */   {
/* 2657 */     params = params == null ? new HashMap() : params;
/* 2658 */     params.put("roleNid", "riskControlPersonnel");
/* 2659 */     List<CreditReviewTotalModel> modelList = this.clBorrowMapper.listSysUserByRole(params);
/* 2660 */     return modelList;
/*      */   }
/*      */   
/*      */   public void giveOrder(List<Long> list, List<Map<String, Object>> users)
/*      */   {
/* 2665 */     Map<String, Object> params = new HashMap();
/* 2666 */     if ((list != null) && (!list.isEmpty()) && (users != null) && (!users.isEmpty()))
/*      */     {
/* 2668 */       Map<Integer, List<Long>> map = new DestributeUtil().getCollection(
/* 2669 */         list, users.size());
/* 2670 */       if ((map != null) && (!map.isEmpty()))
/*      */       {
/* 2672 */         for (int i = 0; i < users.size(); i++)
/*      */         {
/* 2674 */           List<Long> listOrder = (List)map.get(Integer.valueOf(i + 1));
/* 2675 */           if ((listOrder != null) && (!listOrder.isEmpty())) {
/* 2676 */             for (Long order : listOrder) {
/* 2677 */               params.put("id", order);
/* 2678 */               params.put("sysUserId", ((Map)users.get(i)).get("id"));
/* 2679 */               updateSelective(params);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void modifyPayReqLog(PayReqLog payReqLog, String params) {
/* 2688 */     payReqLog.setNotifyParams(params);
/* 2689 */     payReqLog.setNotifyTime(DateUtil.getNow());
/* 2690 */     this.payReqLogService.updateById(payReqLog);
/*      */   }
/*      */ }
