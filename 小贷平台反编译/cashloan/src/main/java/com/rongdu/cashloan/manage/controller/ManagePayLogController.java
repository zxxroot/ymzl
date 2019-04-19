/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.BorrowProgress;
/*     */ import com.rongdu.cashloan.cl.domain.PayLog;
/*     */ import com.rongdu.cashloan.cl.model.ManagePayLogModel;
/*     */ import com.rongdu.cashloan.cl.service.BorrowProgressService;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.ClSmsService;
/*     */ import com.rongdu.cashloan.cl.service.PayLogService;
/*     */ import com.rongdu.cashloan.cl.service.ProfitAmountService;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.core.model.BorrowModel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.util.StringUtils;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ManagePayLogController
/*     */   extends ManageBaseController
/*     */ {
/*  54 */   private static final Logger logger = LoggerFactory.getLogger(ManagePayLogController.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private PayLogService payLogService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private ClBorrowService clBorrowService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private BorrowProgressService borrowProgressService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private BorrowRepayService borrowRepayService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private ProfitAmountService profitAmountService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private ClSmsService clSmsService;
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/pay/log/page.htm"})
/*     */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  85 */     Map<String, Object> searchMap = new HashMap();
/*  86 */     if (!StringUtils.isEmpty(search)) {
/*  87 */       searchMap = (Map)JsonUtil.parse(search, Map.class);
/*     */     }
/*     */     
/*  90 */     String type = StringUtil.isNull(searchMap.get("type"));
/*  91 */     String[] typeArray = type.split(",");
/*     */     
/*  93 */     List<String> typeList = new ArrayList();
/*  94 */     String[] arrayOfString1; int j = (arrayOfString1 = typeArray).length; for (int i = 0; i < j; i++) { String typeStr = arrayOfString1[i];
/*  95 */       if (StringUtil.isNotBlank(typeStr)) {
/*  96 */         typeList.add(typeStr);
/*     */       }
/*     */     }
/*  99 */     searchMap.put("type", typeList);
/*     */     
/* 101 */     Page<ManagePayLogModel> page = this.payLogService.page(current, pageSize, searchMap);
/*     */     
/* 103 */     Object result = new HashMap();
/* 104 */     ((Map)result).put("data", page);
/* 105 */     ((Map)result).put("page", new RdPage(page));
/* 106 */     ((Map)result).put("code", Integer.valueOf(200));
/* 107 */     ((Map)result).put("msg", "查询成功");
/* 108 */     ServletUtils.writeToResponse(this.response, (Map)result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/pay/log/findDetail.htm"})
/*     */   public void findDetail(@RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/* 121 */     ManagePayLogModel model = this.payLogService.findDetail(id);
/*     */     
/* 123 */     Map<String, Object> result = new HashMap();
/* 124 */     result.put("data", model);
/* 125 */     result.put("code", Integer.valueOf(200));
/* 126 */     result.put("msg", "查询成功");
/* 127 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/pay/log/auditPay.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void audit(@RequestParam("id") Long id, @RequestParam("state") String state)
/*     */   {
/* 138 */     boolean flag = true;
/* 139 */     String msg = "操作失败";
/*     */     
/* 141 */     Map<String, Object> checkMap = this.payLogService.checkPayLogState(id, state);
/*     */     
/* 143 */     if (checkMap.isEmpty()) {
/* 144 */       flag = this.payLogService.auditPay(id, state);
/*     */     }
/*     */     
/* 147 */     Map<String, Object> result = new HashMap();
/* 148 */     if (flag) {
/* 149 */       result.put("code", Integer.valueOf(200));
/* 150 */       result.put("msg", "操作成功");
/*     */     } else {
/* 152 */       result.put("code", Integer.valueOf(400));
/* 153 */       result.put("msg", msg);
/*     */     }
/* 155 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/pay/testPayNotify.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void testPaymentNotify(@RequestParam("orderNo") String orderNo)
/*     */     throws Exception
/*     */   {
/* 168 */     PayLog payLog = this.payLogService.findByOrderNo(orderNo);
/* 169 */     String codeMsg = null;
/* 170 */     if (payLog == null) {
/* 171 */       logger.warn("未查询到对应的支付订单");
/* 172 */       codeMsg = "未查询到对应的支付订单";
/* 173 */       return;
/*     */     }
/* 175 */     if (("10".equals(payLog.getState())) || 
/* 176 */       ("20".equals(payLog.getState())) || 
/* 177 */       ("50".equals(payLog.getState()))) {
/* 178 */       if ("10".equals(payLog.getScenes()))
/*     */       {
/* 180 */         Map<String, Object> map = new HashMap();
/* 181 */         map.put("id", payLog.getBorrowId());
/* 182 */         map.put("state", "30");
/* 183 */         this.clBorrowService.updatePayState(map);
/*     */         
/*     */ 
/* 186 */         BorrowProgress bp = new BorrowProgress();
/* 187 */         bp.setUserId(payLog.getUserId());
/* 188 */         bp.setBorrowId(payLog.getBorrowId());
/* 189 */         bp.setState("30");
/* 190 */         bp.setRemark(BorrowModel.convertBorrowRemark(bp.getState()));
/* 191 */         bp.setCreateTime(DateUtil.getNow());
/* 192 */         this.borrowProgressService.save(bp);
/*     */         
/* 194 */         Borrow borrow = (Borrow)this.clBorrowService.getById(payLog.getBorrowId());
/*     */         
/*     */ 
/* 197 */         this.borrowRepayService.genRepayPlan(borrow);
/*     */         
/* 199 */         Map<String, Object> paramMap = new HashMap();
/* 200 */         paramMap.put("state", "40");
/* 201 */         paramMap.put("updateTime", DateUtil.getNow());
/* 202 */         paramMap.put("id", payLog.getId());
/* 203 */         this.payLogService.updateSelective(paramMap);
/*     */         
/*     */ 
/* 206 */         this.clSmsService.loanInform(borrow.getUserId().longValue(), borrow.getId().longValue());
/*     */       }
/* 208 */       else if ("11".equals(payLog.getScenes()))
/*     */       {
/* 210 */         this.profitAmountService.cash(payLog.getUserId().longValue(), payLog.getAmount().doubleValue());
/*     */         
/*     */ 
/* 213 */         Map<String, Object> paramMap = new HashMap();
/* 214 */         paramMap.put("state", "40");
/* 215 */         paramMap.put("updateTime", DateUtil.getNow());
/* 216 */         paramMap.put("id", payLog.getId());
/* 217 */         this.payLogService.updateSelective(paramMap);
/*     */       }
/*     */     }
/*     */     else {
/* 221 */       codeMsg = "订单状态错误";
/*     */     }
/*     */     
/* 224 */     Map<String, Object> result = new HashMap();
/* 225 */     if (StringUtil.isBlank(codeMsg)) {
/* 226 */       result.put("code", Integer.valueOf(200));
/* 227 */       result.put("msg", "操作成功");
/*     */     } else {
/* 229 */       result.put("code", Integer.valueOf(400));
/* 230 */       result.put("msg", codeMsg);
/*     */     }
/* 232 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/pay/borrowLoan.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void borrowLoan(@RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/* 243 */     PayLog payLog = (PayLog)this.payLogService.getById(id);
/*     */     
/* 245 */     Map<String, Object> result = new HashMap();
/*     */     
/*     */ 
/* 248 */     if ((payLog != null) && 
/* 249 */       ("50".equals(payLog.getState())) && 
/* 250 */       ("10".equals(payLog.getScenes())))
/*     */     {
/* 252 */       Borrow borrow = this.clBorrowService.findByPrimary(payLog.getBorrowId());
/* 253 */       this.clBorrowService.borrowLoan(borrow, DateUtil.getNow());
/* 254 */       result.put("code", Integer.valueOf(200));
/* 255 */       result.put("msg", "操作成功");
/*     */     } else {
/* 257 */       result.put("code", Integer.valueOf(400));
/* 258 */       result.put("msg", "当前状态不允许放款");
/*     */     }
/* 260 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManagePayLogController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */