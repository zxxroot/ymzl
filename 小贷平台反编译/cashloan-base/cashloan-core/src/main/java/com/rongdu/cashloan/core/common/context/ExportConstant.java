/*     */ package com.rongdu.cashloan.core.common.context;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ExportConstant
/*     */ {
/*     */   public static final int STRAT_LIMIT = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int END_LIMIT = 5000;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  19 */   public static final String[] EXPORT_USERINFO_LIST_HEARDERS = { "手机号", "真实姓名", "身份证号码", "地址", "学历", "注册时间", "注册客户端", "注册渠道", "借款次数", "状态" };
/*     */   
/*  21 */   public static final String[] EXPORT_USERINFO_LIST_FIELDS = { "loginName", "realName", "idNo", "idAddr", "education", "registTime", "registerClient", "channelName", "brTimes", "state" };
/*     */   
/*     */ 
/*  24 */   public static final String[] EXPORT_REPAYLOG_LIST_HEARDERS = { "真实姓名", "手机号码", "订单号", "借款金额(元)", "综合费用(元)", "应还金额(元)", "逾期天数", "应还逾期罚金(元)", "应还总额(元)", "实还金额(元)", "实还逾期罚金(元)", "实还总金额(元)'", 
/*  25 */     "还款账号", "流水号", "还款方式", "应还款日期", "实际还款日期" };
/*     */   
/*  27 */   public static final String[] EXPORT_REPAYLOG_LIST_FIELDS = { "realName", "phone", "orderNo", "borrowAmount", "fee", "repayAmount", "penaltyDay", "repayPenalty", "repayTotal", "repayLogAmount", "penaltyAmout", "repayYesTotal", 
/*  28 */     "repayAccount", "serialNumber", "repayWay", "repayPlanTime", "repayTime" };
/*     */   
/*     */ 
/*  31 */   public static final String[] EXPORT_BORROW_LIST_HEARDERS = { "真实姓名", "手机号", "订单号", "借款金额(元)", "借款期限", "订单生成时间", "综合费用", "居间服务费", "信息认证费", "利息", 
/*  32 */     "实际到账金额", "订单状态", "借款地址", "放款时间", "实际还款时间", "实际还款金额(元)", "逾期天数", "逾期罚金(元)" };
/*     */   
/*  34 */   public static final String[] EXPORT_BORROW_LIST_FIELDS = { "realName", "phone", "orderNo", "amount", "timeLimit", "createTime", "fee", 
/*  35 */     "serviceFee", "infoAuthFee", "interest", "realAmount", "state", "address", "loanTime", "repayTime", "repayAmount", "penaltyDay", "penaltyAmout" };
/*     */   
/*     */ 
/*  38 */   public static final String[] EXPORT_PAYLOG_LIST_HEARDERS = { "收款人姓名", "手机号码", "金额", "收款银行卡", "支付订单号", "借款时间", "打款时间", "业务", "状态", "反馈" };
/*     */   
/*  40 */   public static final String[] EXPORT_PAYLOG_LIST_FIELDS = { "realName", "loginName", "amount", "cardNo", "orderNo", "loanTime", "updateTime", "scenesStr", "stateStr", "remark" };
/*     */   
/*     */ 
/*  43 */   public static final String[] EXPORT_PAYCHECK_LIST_HEARDERS = { "订单号", "支付方式", "订单金额", "支付方订单金额", "错误类型", "对账记录添加时间", "支付业务", "处理方式", "处理结果" };
/*     */   
/*  45 */   public static final String[] EXPORT_PAYCHECK_LIST_FIELDS = { "orderNo", "payTypeStr", "orderAmount", "realPayAmount", "typeStr", "processTime", 
/*  46 */     "scenesStr", "processWayStr", "processResultStr" };
/*     */   
/*     */ 
/*  49 */   public static final String[] EXPORT_OVERDUE_LIST_HEARDERS = { "真实姓名", "手机号", "订单号", "借款金额(元)", "借款期限(天)", "订单生成时间", "综合费用(元)", "居间服务费(元)", "信息认证费(元)", "利息(元)", 
/*  50 */     "实际到账金额", "订单状态", "借款地址", "放款时间", "逾期天数", "逾期罚金(元)", "逾期等级" };
/*     */   
/*  52 */   public static final String[] EXPORT_OVERDUE_LIST_FIELDS = { "realName", "phone", "orderNo", "amount", "timeLimit", "createTime", "fee", 
/*  53 */     "serviceFee", "infoAuthFee", "interest", "realAmount", "state", "address", "loanTime", "penaltyDay", "penaltyAmout", "level" };
/*     */   
/*     */ 
/*  56 */   public static final String[] EXPORT_BADDEBT_LIST_HEARDERS = { "真实姓名", "手机号", "订单号", "借款金额(元)", "借款期限", "订单生成时间", "综合费用", "居间服务费", "信息认证费", "利息", 
/*  57 */     "实际到账金额", "订单状态", "借款地址", "放款时间", "实际还款时间", "实际还款金额(元)", "逾期天数", "逾期罚金(元)" };
/*     */   
/*  59 */   public static final String[] EXPORT_BADDEBT_LIST_FIELDS = { "realName", "phone", "orderNo", "amount", "timeLimit", "createTime", "fee", 
/*  60 */     "serviceFee", "infoAuthFee", "interest", "realAmount", "state", "address", "loanTime", "repayTime", "repayAmount", "penaltyDay", "penaltyAmout" };
/*     */   
/*     */ 
/*  63 */   public static final String[] EXPORT_REPAYORDER_LIST_HEARDERS = { "真实姓名", "手机号码", "金额", "借款时间", "预计还款时间", "逾期天数", "逾期等级", "罚息", "催收人", "订单状态" };
/*     */   
/*  65 */   public static final String[] EXPORT_REPAYORDER_LIST_FIELDS = { "borrowName", "phone", "amount", "borrowTime", "repayTime", "penaltyDay", "level", 
/*  66 */     "penaltyAmout", "userName", "state" };
/*     */   
/*     */ 
/*  69 */   public static final String[] EXPORT_URGELOG_LIST_HEARDERS = { "借款人姓名", "手机号码", "金额", "借款时间", "预计还款时间", "逾期天数", "逾期等级", "罚息", "催收人", "订单状态", 
/*  70 */     "催收方式", "承诺还款时间", "催收反馈", "催收时间" };
/*     */   
/*  72 */   public static final String[] EXPORT_URGELOG_LIST_FIELDS = { "borrowName", "phone", "amount", "borrowTime", "repayTime", "penaltyDay", "level", 
/*  73 */     "penaltyAmout", "userName", "state", "way", "promiseTime", "remark", "createTime" };
/*     */   
/*     */ 
/*  76 */   public static final String[] EXPORT_TONGDUNLOG_LIST_HEARDERS = { "真实姓名", "手机号码", "借款订单号", "借款金额", "风险报告编码", "申请状态", 
/*  77 */     "提交审核报告结果编码", "提交审核返回信息", "提交审核报告时间", "查询审核报告结果编码", "查询审核报告信息", "风险结果", "风险分数", "查询审核报告时间" };
/*     */   
/*  79 */   public static final String[] EXPORT_TONGDUNLOG_LIST_FIELDS = { "realName", "phone", "borrowNo", "amount", "reportId", "stateStr", 
/*  80 */     "submitCode", "submitParams", "createTime", "queryCode", "queryParams", "rsState", "rsScore", "updateTime" };
/*     */   
/*     */ 
/*  83 */   public static final String[] EXPORT_CHANNEL_LIST_HEARDERS = { "渠道编号", "渠道名称", "渠道商编号", "渠道商名称", "渠道商结算方式", "渠道联系人id", "渠道联系人姓名", "渠道联系人结算方式", "一级责任人", "二级责任人", "渠道阶段", "结算方式", 
/*  84 */     "结算标记", "创建时间", "更新时间", "操作人", "状态" };
/*     */   
/*  86 */   public static final String[] EXPORT_CHANNEL_LIST_FIELDS = { "code", "name", "providerId", "providerName", "providerSettlementStr", "contactId", "contactName", "contactSettlementStr", "firstName", "twoName", "channelStageStr", "providerSettlement", 
/*  87 */     "settlementSignStr", "createTime", "updateTime", "updateUser", "stateStr" };
/*     */   
/*     */ 
/*  90 */   public static final String[] EXPORT_CHANNELSETTLEMENT_LIST_HEARDERS = { "渠道编号", "渠道名称", "渠道商编号", "渠道商名称", "渠道商结算方式", "渠道联系人id", "渠道联系人姓名", "渠道联系人结算方式", "一级责任人名称", "二级责任人名称", "结算标记", 
/*  91 */     "创建时间", "更新时间", "操作人", "结算状态", "结算时间", "状态" };
/*     */   
/*  93 */   public static final String[] EXPORT_CHANNELSETTLEMENT_LIST_FIELDS = { "code", "name", "providerId", "providerName", "providerSettlementStr", "contactId", "contactName", "contactSettlementStr", "firstName", "twoName", 
/*  94 */     "settlementSignStr", "createTime", "updateTime", "updateUser", "settlementStateStr", "settlementUpdateTime", "stateStr" };
/*     */   
/*     */ 
/*  97 */   public static final String[] EXPORT_CREDIT_LIST_HEARDERS = { "真实姓名", "用户名", "工号", "待信审订单数", "信审订单数", "通过订单数", "拒绝订单数", "通过率" };
/*     */   
/*  99 */   public static final String[] EXPORT_CREDIT_LIST_FIELDS = { "name", "userName", "jobNumber", "waitCreditCount", "creditCount", "creditSucCount", "creditRefCount", 
/* 100 */     "rate" };
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\context\ExportConstant.class

 */