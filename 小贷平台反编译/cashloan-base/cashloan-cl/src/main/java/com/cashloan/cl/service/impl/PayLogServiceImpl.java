/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.domain.BankCard;
import com.cashloan.cl.domain.PayLog;
import com.cashloan.cl.mapper.BankCardMapper;
import com.cashloan.cl.mapper.ClBorrowMapper;
import com.cashloan.cl.mapper.PayLogMapper;
import com.cashloan.cl.model.ManagePayLogModel;
import com.cashloan.cl.model.pay.lianlian.ConfirmPaymentModel;
import com.cashloan.cl.model.pay.lianlian.util.LianLianHelper;
import com.cashloan.cl.service.PayLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.cl.model.pay.fuiou.IncomeforreqModel;
import com.rongdu.cashloan.cl.model.pay.fuiou.utils.FuiouHelper;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.JsonUtil;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import org.springframework.stereotype.Service;
import tool.util.DateUtil;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*     */ @Service("payLogService")
/*     */ public class PayLogServiceImpl
/*     */   extends BaseServiceImpl<PayLog, Long>
/*     */   implements PayLogService
/*     */ {
/*     */   @Resource
/*     */   private PayLogMapper payLogMapper;
/*     */   @Resource
/*     */   private ClBorrowMapper clBorrowMapper;
/*     */   @Resource
/*     */   private BankCardMapper bankCardMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   
/*     */   public BaseMapper<PayLog, Long> getMapper()
/*     */   {
/*  66 */     return this.payLogMapper;
/*     */   }
/*     */   
/*     */   public boolean save(PayLog payLog)
/*     */   {
/*  71 */     payLog.setCreateTime(DateUtil.getNow());
/*  72 */     int result = this.payLogMapper.save(payLog);
/*  73 */     if (result > 0L) {
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManagePayLogModel> page(int current, int pageSize, Map<String, Object> searchMap)
/*     */   {
/*  82 */     PageHelper.startPage(current, pageSize);
/*  83 */     Page<ManagePayLogModel> page = (Page)this.payLogMapper
/*  84 */       .page(searchMap);
/*  85 */     return page;
/*     */   }
/*     */   
/*     */   public ManagePayLogModel findDetail(Long id)
/*     */   {
/*  90 */     return this.payLogMapper.findDetail(id);
/*     */   }
/*     */   
/*     */   public boolean auditPay(Long id, String state)
/*     */   {
/*  95 */     Map<String, Object> paramMap = new HashMap();
/*  96 */     paramMap.put("id", id);
/*  97 */     paramMap.put("state", state);
/*  98 */     int result = this.payLogMapper.updateSelective(paramMap);
/*     */     
/* 100 */     if ("20".equals(state)) {
/* 101 */       PayLog payLog = (PayLog)this.payLogMapper.findByPrimary(id);
/* 102 */       confirmPayment(payLog);
/*     */     }
/*     */     
/* 105 */     if (result > 0L) {
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void confirmPayment(PayLog payLog)
/*     */   {
/* 117 */     String value = Global.getValue("fuiou_switch");
/* 118 */     if ((org.apache.commons.lang.StringUtils.isNotBlank(value)) && 
/* 119 */       (org.apache.commons.lang.StringUtils.equals(value, "1"))) {
/* 120 */       Map<String, Object> bankCardMap = new HashMap();
/* 121 */       bankCardMap.put("userId", payLog.getUserId());
/* 122 */       BankCard bankCard = (BankCard)this.bankCardMapper.findSelective(bankCardMap);
/* 123 */       UserBaseInfo baseInfo = this.userBaseInfoMapper.findByUserId(payLog.getUserId());
/* 124 */       IncomeforreqModel ifm = new IncomeforreqModel();
/* 125 */       ifm.setBankno(bankCard.getBank());
/* 126 */       if ("dev".equals(Global.getValue("app_environment"))) {
/* 127 */         ifm.setAmt(Long.valueOf(1L));
/*     */       } else {
/* 129 */         ifm.setAmt(Long.valueOf(new Double(payLog.getAmount().doubleValue() * 100.0D).longValue()));
/*     */       }
/* 131 */       ifm.setAccntno(payLog.getCardNo());
/* 132 */       ifm.setAccntnm(baseInfo.getRealName());
/* 133 */       ifm.setCertno(bankCard.getCardNo());
/* 134 */       ifm.setMobile(bankCard.getPhone());
/* 135 */       ifm.setBankno(bankCard.getBank());
/* 136 */       ifm.setCertno(baseInfo.getIdNo());
/* 137 */       FuiouHelper fh = new FuiouHelper();
/* 138 */       fh.incomeforreq(ifm);
/* 139 */       return;
/*     */     }
/* 141 */     String orderNo = OrderNoUtil.getSerialNumber();
/* 142 */     ConfirmPaymentModel confirmPayment = new ConfirmPaymentModel(orderNo);
/* 143 */     confirmPayment.setNo_order(payLog.getOrderNo());
/* 144 */     confirmPayment.setConfirm_code(payLog.getConfirmCode());
/* 145 */     confirmPayment.setNotify_url(Global.getValue("server_host") + "/pay/lianlian/paymentNotify.htm");
/* 146 */     LianLianHelper helper = new LianLianHelper();
/* 147 */     helper.confirmPayment(confirmPayment);
/*     */   }
/*     */   
/*     */   public Map<String, Object> checkPayLogState(Long id, String state)
/*     */   {
/* 152 */     PayLog log = (PayLog)this.payLogMapper.findByPrimary(id);
/*     */     
/* 154 */     Map<String, Object> check = new HashMap();
/* 155 */     if (!"15".equals(log.getState())) {
/* 156 */       check.put("msg", "当前交易记录状态不允许审核！");
/*     */     }
/*     */     
/*     */ 
/* 160 */     if (("20".equals(state)) && 
/* 161 */       (StringUtil.isNotBlank(log.getBorrowId())))
/*     */     {
/* 163 */       Borrow borrow = (Borrow)this.clBorrowMapper.findByPrimary(log.getBorrowId());
/* 164 */       if ((!"20".equals(borrow.getState())) && 
/* 165 */         (!"26".equals(borrow.getState())) && 
/* 166 */         (!"31".equals(borrow.getState())) && (
/* 167 */         (!"12".equals(log.getScenes())) || (!"40".equals(borrow.getState()))))
/*     */       {
/*     */ 
/* 170 */         check.put("msg", "当前借款状态不允许审核通过！");
/*     */       }
/*     */     }
/* 173 */     return check;
/*     */   }
/*     */   
/*     */   public PayLog findByOrderNo(String orderNo)
/*     */   {
/* 178 */     Map<String, Object> paramMap = new HashMap();
/* 179 */     paramMap.put("orderNo", orderNo);
/* 180 */     return (PayLog)this.payLogMapper.findSelective(paramMap);
/*     */   }
/*     */   
/*     */   public boolean updateSelective(Map<String, Object> paramMap)
/*     */   {
/* 185 */     int result = this.payLogMapper.updateSelective(paramMap);
/* 186 */     if (result > 0L) {
/* 187 */       return true;
/*     */     }
/* 189 */     return false;
/*     */   }
/*     */   
/*     */   public PayLog findSelective(Map<String, Object> paramMap)
/*     */   {
/* 194 */     return (PayLog)this.payLogMapper.findSelective(paramMap);
/*     */   }
/*     */   
/*     */   public PayLog findLatestOne(Map<String, Object> paramMap)
/*     */   {
/* 199 */     return this.payLogMapper.findLatestOne(paramMap);
/*     */   }
/*     */   
/*     */   public List<PayLog> findCheckList(Map<String, Object> paramMap)
/*     */   {
/* 204 */     return this.payLogMapper.findCheckList(paramMap);
/*     */   }
/*     */   
/*     */   public boolean judge(long borrowId)
/*     */   {
/* 209 */     Map<String, Object> map = new HashMap();
/* 210 */     map.put("borrowId", Long.valueOf(borrowId));
/* 211 */     List<PayLog> plist = this.payLogMapper.listSelective(map);
/* 212 */     boolean flag = true;
/* 213 */     for (PayLog payLog : plist) {
/* 214 */       if (("10".equals(payLog.getScenes())) && ("15".equals(payLog.getState()))) {
/* 215 */         flag = false;
/* 216 */         break;
/*     */       }
/*     */     }
/* 219 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   public List listPayLog(String params)
/*     */   {
/* 225 */     Map<String, Object> searchMap = new HashMap();
/* 226 */     if (!org.springframework.util.StringUtils.isEmpty(params)) {
/* 227 */       searchMap = (Map)JsonUtil.parse(params, Map.class);
/*     */     }
/* 229 */     String type = StringUtil.isNull(searchMap.get("type"));
/* 230 */     String[] typeArray = type.split(",");
/*     */     
/* 232 */     List<String> typeList = new ArrayList();
/* 233 */     String[] arrayOfString1; int j = (arrayOfString1 = typeArray).length; for (int i = 0; i < j; i++) { String typeStr = arrayOfString1[i];
/* 234 */       if (StringUtil.isNotBlank(typeStr)) {
/* 235 */         typeList.add(typeStr);
/*     */       }
/*     */     }
/* 238 */     searchMap.put("type", typeList);
/* 239 */     List<ManagePayLogModel> list = this.payLogMapper.page(searchMap);
/* 240 */     return list;
/*     */   }
/*     */   
/*     */   public int doRepaymentNum(long borrowId)
/*     */   {
/* 245 */     return this.payLogMapper.doRepaymentCount(borrowId);
/*     */   }
/*     */ }
