/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayLogService;
/*     */ import com.rongdu.cashloan.cl.service.ChannelService;
/*     */ import com.rongdu.cashloan.cl.service.ChannelSettlementService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorReqLogService;
/*     */ import com.rongdu.cashloan.cl.service.PayCheckService;
/*     */ import com.rongdu.cashloan.cl.service.PayLogService;
/*     */ import com.rongdu.cashloan.cl.service.UrgeRepayOrderService;
/*     */ import com.rongdu.cashloan.core.common.context.ExportConstant;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.excel.JsGridReportBase;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ManageListExport
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private ClBorrowService clBorrowService;
/*     */   @Resource
/*     */   private CloanUserService userService;
/*     */   @Resource
/*     */   private OperatorReqLogService operatorReqLogService;
/*     */   @Resource
/*     */   private BorrowRepayLogService borrowRepayLogService;
/*     */   @Resource
/*     */   private PayLogService payLogService;
/*     */   @Resource
/*     */   private PayCheckService payCheckService;
/*     */   @Resource
/*     */   private UrgeRepayOrderService urgeRepayOrderService;
/*     */   @Resource
/*     */   private ChannelService channelService;
/*     */   @Resource
/*     */   private ChannelSettlementService channelSettlementService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/borrowRepayLog/export.htm"})
/*     */   public void repayLogExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/*  63 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  64 */     List list = this.borrowRepayLogService.listExport(params);
/*  65 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/*  66 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/*  68 */     String title = "还款记录Excel表";
/*  69 */     String[] hearders = ExportConstant.EXPORT_REPAYLOG_LIST_HEARDERS;
/*  70 */     String[] fields = ExportConstant.EXPORT_REPAYLOG_LIST_FIELDS;
/*  71 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/*  72 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/export.htm"})
/*     */   public void borrowExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/*  83 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  84 */     List list = this.clBorrowService.listBorrow(params);
/*  85 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/*  86 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/*  88 */     String title = "借款订单Excel表";
/*  89 */     String[] hearders = ExportConstant.EXPORT_BORROW_LIST_HEARDERS;
/*  90 */     String[] fields = ExportConstant.EXPORT_BORROW_LIST_FIELDS;
/*  91 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/*  92 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/payLog/export.htm"})
/*     */   public void payLogExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 103 */     List list = this.payLogService.listPayLog(searchParams);
/* 104 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 105 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 107 */     String title = "支付记录Excel表";
/* 108 */     String[] hearders = ExportConstant.EXPORT_PAYLOG_LIST_HEARDERS;
/* 109 */     String[] fields = ExportConstant.EXPORT_PAYLOG_LIST_FIELDS;
/* 110 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 111 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/payCheck/export.htm"})
/*     */   public void payCheckExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 122 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 123 */     List list = this.payCheckService.listPayCheck(params);
/* 124 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 125 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 127 */     String title = "支付对账记录Excel表";
/* 128 */     String[] hearders = ExportConstant.EXPORT_PAYCHECK_LIST_HEARDERS;
/* 129 */     String[] fields = ExportConstant.EXPORT_PAYCHECK_LIST_FIELDS;
/* 130 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 131 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/overdue/export.htm"})
/*     */   public void overdueExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/*     */     Map<String, Object> params;
/*     */     
/*     */     Map<String, Object> params;
/*     */     
/* 143 */     if (StringUtil.isBlank(searchParams)) {
/* 144 */       params = new HashMap();
/*     */     } else {
/* 146 */       params = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/* 148 */     params.put("state", "50");
/* 149 */     List list = this.clBorrowService.listBorrow(params);
/* 150 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 151 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 153 */     String title = "已逾期订单Excel表";
/* 154 */     String[] hearders = ExportConstant.EXPORT_OVERDUE_LIST_HEARDERS;
/* 155 */     String[] fields = ExportConstant.EXPORT_OVERDUE_LIST_FIELDS;
/* 156 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 157 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/badDebt/export.htm"})
/*     */   public void badDebtExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/*     */     Map<String, Object> params;
/*     */     
/*     */     Map<String, Object> params;
/*     */     
/* 169 */     if (StringUtil.isBlank(searchParams)) {
/* 170 */       params = new HashMap();
/*     */     } else {
/* 172 */       params = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/* 174 */     params.put("state", "90");
/* 175 */     List list = this.clBorrowService.listBorrow(params);
/* 176 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 177 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 179 */     String title = "已坏账订单Excel表";
/* 180 */     String[] hearders = ExportConstant.EXPORT_BADDEBT_LIST_HEARDERS;
/* 181 */     String[] fields = ExportConstant.EXPORT_BADDEBT_LIST_FIELDS;
/* 182 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 183 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/urgeRepayOrder/export.htm"})
/*     */   public void urgeRepayOrderExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 194 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 195 */     List list = this.urgeRepayOrderService.listUrgeRepayOrder(params);
/* 196 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 197 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 199 */     String title = "催收订单Excel表";
/* 200 */     String[] hearders = ExportConstant.EXPORT_REPAYORDER_LIST_HEARDERS;
/* 201 */     String[] fields = ExportConstant.EXPORT_REPAYORDER_LIST_FIELDS;
/* 202 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 203 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/urgeLog/export.htm"})
/*     */   public void urgeLogExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 214 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 215 */     List list = this.urgeRepayOrderService.listUrgeLog(params);
/* 216 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 217 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 219 */     String title = "催收反馈Excel表";
/* 220 */     String[] hearders = ExportConstant.EXPORT_URGELOG_LIST_HEARDERS;
/* 221 */     String[] fields = ExportConstant.EXPORT_URGELOG_LIST_FIELDS;
/* 222 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 223 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/channel/export.htm"})
/*     */   public void channelExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 232 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/* 233 */     List list = this.channelService.listChannel(searchMap);
/* 234 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 235 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 237 */     String title = "渠道统计Excel表";
/* 238 */     String[] hearders = ExportConstant.EXPORT_CHANNEL_LIST_HEARDERS;
/* 239 */     String[] fields = ExportConstant.EXPORT_CHANNEL_LIST_FIELDS;
/* 240 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 241 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/channelSettlement/export.htm"})
/*     */   public void channelSettlementExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 250 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/* 251 */     List list = this.channelSettlementService.listChannelStaff(searchMap);
/* 252 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 253 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 255 */     String title = "渠道费用统计Excel表";
/* 256 */     String[] hearders = ExportConstant.EXPORT_CHANNELSETTLEMENT_LIST_HEARDERS;
/* 257 */     String[] fields = ExportConstant.EXPORT_CHANNELSETTLEMENT_LIST_FIELDS;
/* 258 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 259 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageListExport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */