/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.cashloan.cl.mapper.SystemCountMapper;
/*     */ import com.cashloan.cl.service.SystemCountService;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.web.context.ContextLoader;
/*     */ import org.springframework.web.context.WebApplicationContext;
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
/*     */ @Service("systemCountService")
/*     */ public class SystemCountServiceImpl
/*     */   implements SystemCountService
/*     */ {
/*     */   @Resource
/*     */   private SystemCountMapper systemCountMapper;
/*     */   
/*     */   public Map<String, Object> systemCount()
/*     */     throws Exception
/*     */   {
/*  45 */     Map<String, Object> rtMap = new HashMap();
/*     */     
/*  47 */     Map<String, Object> param = new HashMap();
/*  48 */     param.put("todayTime", DateUtil.getNow());
/*     */     
/*  50 */     Integer register = this.systemCountMapper.countRegister(param);
/*  51 */     rtMap.put("register", register);
/*     */     
/*  53 */     Integer login = this.systemCountMapper.countLogin(param);
/*  54 */     rtMap.put("login", login);
/*     */     
/*  56 */     double borrow = this.systemCountMapper.countBorrow(param);
/*  57 */     rtMap.put("borrow", Double.valueOf(borrow));
/*     */     
/*  59 */     double borrowPass = this.systemCountMapper.countBorrowPass(param);
/*  60 */     rtMap.put("borrowPass", Double.valueOf(borrowPass));
/*     */     
/*     */ 
/*     */ 
/*  64 */     if (borrow > 0.0D) {
/*  65 */       rtMap.put("passApr", Double.valueOf(BigDecimalUtil.decimal(borrowPass / borrow * 100.0D, 2)));
/*     */     } else {
/*  67 */       rtMap.put("passApr", Integer.valueOf(0));
/*     */     }
/*     */     
/*     */ 
/*  71 */     double borrow2 = this.systemCountMapper.countBorrow2(param);
/*  72 */     rtMap.put("borrow2", Double.valueOf(borrow2));
/*     */     
/*  74 */     double borrowPass2 = this.systemCountMapper.countBorrowPass2(param);
/*  75 */     rtMap.put("borrowPass2", Double.valueOf(borrowPass2));
/*     */     
/*  77 */     int unReviewLoanOrderNum = this.systemCountMapper.countUnReviewLoanOrderNum();
/*     */     
/*  79 */     int cuishou = this.systemCountMapper.countCuishou();
/*     */     
/*  81 */     int reviewPay = this.systemCountMapper.countReviewPay();
/*     */     
/*  83 */     int callback = this.systemCountMapper.countCallback();
/*  84 */     rtMap.put("unReviewLoanOrderNum", Integer.valueOf(unReviewLoanOrderNum));
/*  85 */     rtMap.put("cuishou", Integer.valueOf(cuishou));
/*  86 */     rtMap.put("reviewPay", Integer.valueOf(reviewPay));
/*  87 */     rtMap.put("callback", Integer.valueOf(callback));
/*     */     
/*  89 */     Integer borrowLoan = this.systemCountMapper.countBorrowLoan(param);
/*  90 */     rtMap.put("borrowLoan", borrowLoan);
/*     */     
/*  92 */     Integer borrowRepay = this.systemCountMapper.countBorrowRepay(param);
/*  93 */     rtMap.put("borrowRepay", borrowRepay);
/*     */     
/*  95 */     Integer borrowLoanHistory = this.systemCountMapper.countBorrowLoanHistory();
/*  96 */     rtMap.put("borrowLoanHistory", borrowLoanHistory);
/*     */     
/*  98 */     Integer borrowRepayHistory = this.systemCountMapper.countBorrowRepayHistory();
/*  99 */     rtMap.put("borrowRepayHistory", borrowRepayHistory);
/*     */     
/* 101 */     Double needRepay = this.systemCountMapper.sumBorrowNeedRepay();
/* 102 */     rtMap.put("needRepay", Double.valueOf(needRepay == null ? 0.0D : needRepay.doubleValue()));
/*     */     
/* 104 */     Double overdueRepay = this.systemCountMapper.sumBorrowOverdueRepay();
/* 105 */     rtMap.put("overdueRepay", Double.valueOf(overdueRepay == null ? 0.0D : overdueRepay.doubleValue()));
/*     */     
/* 107 */     Map<String, Object> result = null;
/* 108 */     List<Map<String, Object>> rtValue = null;
/*     */     
/* 110 */     monthCountDispose(result, rtValue, rtMap);
/*     */     
/* 112 */     rtValue = this.systemCountMapper.countRepaySource();
/* 113 */     result = reBuildMap(rtValue);
/* 114 */     String[] source = { "自动代扣", "银行卡转账", "支付宝转账", "其它" };
/* 115 */     List<Map<String, Object>> sourceList = new ArrayList();
/*     */     
/* 117 */     for (int i = 0; i < source.length; i++) {
/* 118 */       if (!result.containsKey(source[i])) {
/* 119 */         result.put(source[i], Integer.valueOf(0));
/*     */       }
/* 121 */       Map<String, Object> sm = new HashMap();
/* 122 */       sm.put(source[i], result.get(source[i]));
/* 123 */       sourceList.add(sm);
/*     */     }
/* 125 */     rtMap.put("repaySource", sourceList);
/*     */     
/* 127 */     List<String> days = new ArrayList();
/* 128 */     Date nowDate = DateUtil.getNow();
/* 129 */     days.add(DateUtil.dateStr(nowDate, "yyyy-MM-dd"));
/* 130 */     Calendar date = Calendar.getInstance();
/* 131 */     for (int i = 0; i < 15; i++) {
/* 132 */       date.setTime(nowDate);
/* 133 */       date.set(5, date.get(5) - 1);
/* 134 */       nowDate = date.getTime();
/* 135 */       String day = DateUtil.dateStr(nowDate, "yyyy-MM-dd");
/* 136 */       days.add(day);
/*     */     }
/*     */     
/* 139 */     this.systemCountMapper.countFifteenDaysNeedRepay();
/* 140 */     List<Map<String, Object>> rtValue1 = this.systemCountMapper.countFifteenDaysNeedRepay();
/* 141 */     List<Map<String, Object>> rtValue2 = this.systemCountMapper.countFifteenDaysRealRepay();
/* 142 */     List<Map<String, Object>> rtValue4 = this.systemCountMapper.countFifteenDaysLoan();
/* 143 */     Map<String, Object> result1 = reBuildMap(rtValue1);
/* 144 */     Map<String, Object> result2 = reBuildMap(rtValue2);
/* 145 */     Map<String, Object> result4 = reBuildMap(rtValue4);
/* 146 */     Map<String, Object> result3 = new HashMap();
/* 147 */     for (int i = 0; i < days.size(); i++) {
/* 148 */       String day = (String)days.get(i);
/* 149 */       if (!result1.containsKey(day)) {
/* 150 */         result1.put(day, Double.valueOf(0.0D));
/*     */       }
/* 152 */       if (!result2.containsKey(day)) {
/* 153 */         result2.put(day, Double.valueOf(0.0D));
/*     */       }
/*     */       
/* 156 */       String needStr = String.valueOf(result1.get(day));
/* 157 */       needStr = (StringUtil.isNotBlank(needStr)) && (!"null".equals(needStr)) ? needStr : "0.00";
/* 158 */       String realStr = String.valueOf(result2.get(day));
/* 159 */       realStr = (StringUtil.isNotBlank(realStr)) && (!"null".equals(realStr)) ? realStr : "0.00";
/* 160 */       Double need = Double.valueOf(needStr);
/* 161 */       Double real = Double.valueOf(realStr);
/* 162 */       if (real.doubleValue() >= need.doubleValue()) {
/* 163 */         result3.put(day, Double.valueOf(0.0D));
/* 164 */       } else if (real.doubleValue() < need.doubleValue()) {
/* 165 */         Double diff = Double.valueOf(need.doubleValue() - real.doubleValue());
/* 166 */         result3.put(day, Double.valueOf(diff.doubleValue() / need.doubleValue()));
/*     */       } else {
/* 168 */         result3.put(day, Double.valueOf(1.0D));
/*     */       }
/*     */       
/* 171 */       if (!result4.containsKey(day)) {
/* 172 */         result4.put(day, Integer.valueOf(0));
/*     */       }
/*     */     }
/* 175 */     rtMap.put("fifteenDaysNeedRepay", result1);
/* 176 */     rtMap.put("fifteenDaysRealRepay", result2);
/* 177 */     rtMap.put("fifteenDaysOverdueApr", result3);
/* 178 */     rtMap.put("fifteenDaysLoan", result4);
/*     */     
/* 180 */     return rtMap;
/*     */   }
/*     */   
/*     */   public Map<String, Object> reBuildMap(List<Map<String, Object>> maps) {
/* 184 */     if (maps != null) {
/* 185 */       Map<String, Object> result = new HashMap();
/* 186 */       for (int i = 0; i < maps.size(); i++) {
/* 187 */         String key = String.valueOf(((Map)maps.get(i)).get("key"));
/* 188 */         if (StringUtil.isNotBlank(key)) {
/* 189 */           key = key == null ? "" : key;
/*     */         }
/*     */         else {
/* 192 */           key = "未知地区";
/*     */         }
/* 194 */         Object value = ((Map)maps.get(i)).get("value");
/* 195 */         result.put(key, value);
/*     */       }
/* 197 */       result.remove("null");
/* 198 */       return result;
/*     */     }
/* 200 */     return new HashMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void monthCountDispose(Map<String, Object> result, List<Map<String, Object>> rtValue, Map<String, Object> rtMap)
/*     */     throws ParseException
/*     */   {
/* 212 */     WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
/* 213 */     ServletContext context = webApplicationContext.getServletContext();
/*     */     
/* 215 */     if (StringUtil.isNotBlank(context)) {
/* 216 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 217 */       Object t = context.getAttribute("monthCountSelectTime");
/* 218 */       int now = DateUtil.getDay(DateUtil.getNow());
/* 219 */       if ((t == null) || (DateUtil.getDay(sdf.parse(t.toString())) != now))
/*     */       {
/* 221 */         rtValue = MonthCount(1);
/* 222 */         result = reBuildMap(rtValue);
/* 223 */         rtMap.put("monthBorrowAmt", result);
/* 224 */         context.setAttribute("monthBorrowAmt", rtValue);
/*     */         
/* 226 */         rtValue = MonthCount(2);
/* 227 */         result = reBuildMap(rtValue);
/* 228 */         rtMap.put("monthBorrowRepay", result);
/* 229 */         context.setAttribute("monthBorrowRepay", rtValue);
/*     */         
/* 231 */         rtValue = MonthCount(3);
/* 232 */         result = reBuildMap(rtValue);
/* 233 */         rtMap.put("monthRegister", result);
/* 234 */         context.setAttribute("monthRegister", rtValue);
/*     */         
/* 236 */         context.setAttribute("monthCountSelectTime", sdf.format(Integer.valueOf(now)));
/*     */       }
/*     */       else
/*     */       {
/* 240 */         rtValue = (List)context.getAttribute("monthBorrowAmt");
/* 241 */         result = reBuildMap(rtValue);
/* 242 */         rtMap.put("monthBorrowAmt", result);
/*     */         
/* 244 */         rtValue = (List)context.getAttribute("monthBorrowRepay");
/* 245 */         result = reBuildMap(rtValue);
/* 246 */         rtMap.put("monthBorrowRepay", result);
/*     */         
/* 248 */         rtValue = (List)context.getAttribute("monthRegister");
/* 249 */         result = reBuildMap(rtValue);
/* 250 */         rtMap.put("monthRegister", result);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/* 256 */   private static String[] address = { "北京市", "上海市", "天津市", "重庆市", "内蒙古自治区", "宁夏回族自治区", "新疆维吾尔自治区", "西藏自治区", "广西壮族自治区", 
/* 257 */     "香港特别行政区", "澳门特别行政区", "黑龙江省", "辽宁省", "吉林省", "河北省", "河南省", "湖北省", "湖南省", "山东省", "山西省", "陕西省", "安徽省", "浙江省", "江苏省", "福建省", 
/* 258 */     "广东省", "海南省", "四川省", "云南省", "贵州省", "青海省", "甘肃省", "江西省", "台湾省" };
/*     */   
/*     */   private String changeAdd(String address) {
/* 261 */     address = 
/* 262 */       address.replace("省", "").replace("市", "").replace("自治区", "").replace("回族", "").replace("维吾尔", "").replace("壮族", "").replace("特别行政区", "");
/* 263 */     return address;
/*     */   }
/*     */   
/*     */   private List<Map<String, Object>> MonthCount(int type) {
/* 267 */     List<Map<String, Object>> list = new ArrayList();
/* 268 */     switch (type) {
/*     */     case 1: 
/* 270 */       for (int i = 0; i < address.length; i++) {
/* 271 */         Map<String, Object> map = new HashMap();
/* 272 */         map.put("key", changeAdd(address[i]));
/* 273 */         map.put("value", this.systemCountMapper.sumBorrowAmtByProvince(address[i] + "%"));
/* 274 */         list.add(map);
/*     */       }
/* 276 */       break;
/*     */     case 2: 
/* 278 */       for (int i = 0; i < address.length; i++) {
/* 279 */         Map<String, Object> map = new HashMap();
/* 280 */         map.put("key", changeAdd(address[i]));
/* 281 */         map.put("value", this.systemCountMapper.sumBorrowRepayByProvince(address[i] + "%"));
/* 282 */         list.add(map);
/*     */       }
/* 284 */       break;
/*     */     default: 
/* 286 */       for (int i = 0; i < address.length; i++) {
/* 287 */         Map<String, Object> map = new HashMap();
/* 288 */         String userCount = this.systemCountMapper.countRegisterByProvince(address[i] + "%");
/* 289 */         if (Integer.valueOf(userCount).intValue() > 0) {
/* 290 */           map.put("key", changeAdd(address[i]));
/* 291 */           map.put("value", userCount);
/*     */         }
/* 293 */         list.add(map);
/*     */       }
/*     */     }
/*     */     
/* 297 */     return list;
/*     */   }
/*     */ }
