/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.domain.BorrowRepay;
import com.cashloan.cl.domain.UrgeRepayOrder;
import com.cashloan.cl.mapper.BorrowRepayMapper;
import com.cashloan.cl.mapper.ClBorrowMapper;
import com.cashloan.cl.mapper.UrgeRepayOrderLogMapper;
import com.cashloan.cl.mapper.UrgeRepayOrderMapper;
import com.cashloan.cl.model.*;
import com.cashloan.cl.service.UrgeRepayOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.DateUtil;
import com.rongdu.cashloan.core.common.util.DateUtils;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.system.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.BigDecimalUtil;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.*;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("urgeRepayOrderService")
/*     */ public class UrgeRepayOrderServiceImpl
/*     */   extends BaseServiceImpl<UrgeRepayOrder, Long>
/*     */   implements UrgeRepayOrderService
/*     */ {
/*  60 */   private static final Logger logger = LoggerFactory.getLogger(UrgeRepayOrderServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UrgeRepayOrderMapper urgeRepayOrderMapper;
/*     */   
/*     */   @Resource
/*     */   private UrgeRepayOrderLogMapper urgeRepayOrderLogMapper;
/*     */   @Resource
/*     */   private ClBorrowMapper clBorrowMapper;
/*     */   @Resource
/*     */   private BorrowRepayMapper borrowRepayMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseinfoMapper;
/*     */   @Resource
/*     */   private SysUserMapper sysUserMapper;
/*     */   
/*     */   public BaseMapper<UrgeRepayOrder, Long> getMapper()
/*     */   {
/*  78 */     return this.urgeRepayOrderMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Page<UrgeRepayOrder> list(Map<String, Object> params, int current, int pageSize)
/*     */   {
/*  85 */     PageHelper.startPage(current, pageSize);
/*  86 */     List<UrgeRepayOrder> list = this.urgeRepayOrderMapper.listSelective(params);
/*  87 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<UrgeRepayOrderModel> listAll(Map<String, Object> params, int current, int pageSize)
/*     */   {
/*  93 */     PageHelper.startPage(current, pageSize);
/*  94 */     List<UrgeRepayOrderModel> list = this.urgeRepayOrderMapper.allSelective(params);
/*  95 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public Page<UrgeRepayOrderModel> listModel(Map<String, Object> params, int current, int pageSize)
/*     */   {
/* 100 */     PageHelper.startPage(current, pageSize);
/* 101 */     List<UrgeRepayOrderModel> list = this.urgeRepayOrderMapper
/* 102 */       .listModel(params);
/* 103 */     if ((list != null) && (!list.isEmpty())) {
/* 104 */       for (UrgeRepayOrderModel uro : list) {
/* 105 */         uro.setStateStr(UrgeRepayOrderModel.change(uro.getState()));
/*     */       }
/*     */     }
/* 108 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public List<UrgeRepayOrderModel> listModel(Map<String, Object> params) {
/* 112 */     return this.urgeRepayOrderMapper.listModel(params);
/*     */   }
/*     */   
/*     */ 
/*     */   public int orderAllotUser(Map<String, Object> params)
/*     */   {
/* 118 */     int r = this.urgeRepayOrderMapper.updateSelective(params);
/* 119 */     return r;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<String, Object> saveOrder(Long id)
/*     */   {
/* 125 */     Map<String, Object> result = new HashMap();
/* 126 */     Borrow b = (Borrow)this.clBorrowMapper.findByPrimary(id);
/* 127 */     if (b != null)
/*     */     {
/* 129 */       if (b.getState().equals("50")) {
/* 130 */         Map<String, Object> params = new HashMap();
/* 131 */         params.put("borrowId", b.getId());
/* 132 */         List<UrgeRepayOrder> list = this.urgeRepayOrderMapper.listSelective(params);
/* 133 */         if (list.size() <= 0) {
/* 134 */           UrgeRepayOrder order = new UrgeRepayOrder();
/* 135 */           order.setBorrowId(b.getId());
/* 136 */           order.setOrderNo(b.getOrderNo());
/* 137 */           order.setBorrowTime(b.getCreateTime());
/* 138 */           order.setTimeLimit(b.getTimeLimit());
/*     */           
/* 140 */           params = new HashMap();
/* 141 */           params.put("userId", b.getUserId());
/* 142 */           UserBaseInfo user = (UserBaseInfo)this.userBaseinfoMapper.findSelective(params);
/* 143 */           if (user != null) {
/* 144 */             order.setPhone(user.getPhone());
/* 145 */             order.setBorrowName(user.getRealName());
/*     */           }
/* 147 */           params = new HashMap();
/* 148 */           params.put("borrowId", b.getId());
/* 149 */           BorrowRepay br = (BorrowRepay)this.borrowRepayMapper.findSelective(params);
/* 150 */           if (br != null) {
/* 151 */             order.setAmount(br.getAmount());
/* 152 */             order.setRepayTime(br.getRepayTime());
/* 153 */             order.setPenaltyDay(Long.valueOf(br.getPenaltyDay()));
/* 154 */             order.setPenaltyAmout(br.getPenaltyAmout());
/*     */           }
/*     */           
/* 157 */           order.setState("10");
/* 158 */           order.setCreateTime(new Date());
/* 159 */           order.setCount(Long.valueOf(0L));
/*     */           
/* 161 */           this.urgeRepayOrderMapper.save(order);
/*     */           
/* 163 */           result.put("code", Integer.valueOf(200));
/* 164 */           result.put("msg", "提交成功");
/* 165 */           return result;
/*     */         }
/* 167 */         result.put("code", Integer.valueOf(400));
/* 168 */         result.put("msg", "已存在催收订单中，请勿重复添加");
/*     */       }
/*     */       else {
/* 171 */         result.put("code", Integer.valueOf(400));
/* 172 */         result.put("msg", "借款信息未逾期");
/*     */       }
/*     */     } else {
/* 175 */       result.put("code", Integer.valueOf(400));
/* 176 */       result.put("msg", "借款信息不存在");
/*     */     }
/* 178 */     return result;
/*     */   }
/*     */   
/*     */   public List<UrgeRepayOrder> listAll(HashMap<String, Object> hashMap)
/*     */   {
/* 183 */     List<UrgeRepayOrder> list = this.urgeRepayOrderMapper.listSelective(hashMap);
/* 184 */     return list;
/*     */   }
/*     */   
/*     */   public Page<UrgeRepayCountModel> memberCount(Map<String, Object> params, int current, int pageSize)
/*     */   {
/* 189 */     params = params == null ? new HashMap() : params;
/* 190 */     params.put("roleNid", "collectionSpecialist");
/*     */     
/* 192 */     PageHelper.startPage(current, pageSize);
/* 193 */     List<UrgeRepayCountModel> modelList = this.urgeRepayOrderMapper.listSysUserByRole(params);
/* 194 */     for (UrgeRepayCountModel model : modelList) {
/* 195 */       long userId = model.getUserId().longValue();
/*     */       
/* 197 */       params.clear();
/* 198 */       params.put("userId", Long.valueOf(userId));
/* 199 */       model.setCount(this.urgeRepayOrderMapper.countOrder(params));
/*     */       
/* 201 */       params.put("state", "11");
/* 202 */       model.setWaitCount(this.urgeRepayOrderMapper.countOrder(params));
/*     */       
/* 204 */       params.put("state", "40");
/* 205 */       model.setWaitCount(this.urgeRepayOrderMapper.countOrder(params));
/*     */       
/* 207 */       Date yester = DateUtil.rollDay(DateUtil.getNow(), -1);
/* 208 */       params.put("startTime", DateUtil.getDayStartTime(yester));
/* 209 */       params.put("endTime", DateUtil.getDayEndTime(yester));
/* 210 */       model.setYesterdayCount(this.urgeRepayOrderLogMapper.countLog(params));
/*     */     }
/*     */     
/*     */ 
/* 214 */     return (Page)modelList;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<UrgeRepayCountModel> orderCount(Map<String, Object> params)
/*     */   {
/* 220 */     List<UrgeRepayCountModel> list = null;
/*     */     try {
/* 222 */       list = new ArrayList();
/* 223 */       Date startTime = new Date();
/* 224 */       Date endTime = new Date();
/* 225 */       List<Date> dateList = null;
/* 226 */       if (params == null) {
/* 227 */         startTime = DateUtil.getDateBefore(-10, endTime);
/* 228 */         dateList = dateList(startTime, endTime);
/*     */       } else {
/* 230 */         endTime = DateUtil.valueOf(params.get("afterTime").toString());
/* 231 */         startTime = DateUtil.valueOf(params.get("beforeTime").toString());
/* 232 */         dateList = dateList(startTime, endTime);
/*     */       }
/* 234 */       for (Date date : dateList) {
/* 235 */         Map<String, Object> map = new HashMap();
/* 236 */         map.put("date", date);
/* 237 */         UrgeRepayCountModel urcModel = new UrgeRepayCountModel();
/* 238 */         urcModel.setCreateTime(date);
/*     */         
/* 240 */         String allOrder = this.urgeRepayOrderMapper.allOrderSum(map);
/* 241 */         urcModel.setAllOrderCount(allOrder != null ? Integer.parseInt(allOrder) : 0);
/*     */         
/* 243 */         String allSuccess = this.urgeRepayOrderMapper.allSuccessSum(map);
/* 244 */         urcModel.setAllSuccessCount(allSuccess != null ? Integer.parseInt(allSuccess) : 0);
/*     */         
/* 246 */         String allFail = this.urgeRepayOrderMapper.allFailSum(map);
/* 247 */         urcModel.setAllFailCount(allFail != null ? Integer.parseInt(allFail) : 0);
/*     */         
/* 249 */         if (urcModel.getAllSuccessCount() > urcModel.getAllOrderCount()) {
/* 250 */           urcModel.setAllBackRate(100.0D);
/* 251 */         } else if (urcModel.getAllOrderCount() > 0) {
/* 252 */           double allBackRate = urcModel.getAllSuccessCount() / urcModel.getAllOrderCount();
/* 253 */           if (allBackRate * 100.0D > 100.0D) {
/* 254 */             urcModel.setAllBackRate(100.0D);
/*     */           } else {
/* 256 */             urcModel.setAllBackRate(BigDecimalUtil.decimal(allBackRate * 100.0D, 2));
/*     */           }
/*     */         }
/*     */         
/* 260 */         String newOrder = this.urgeRepayOrderMapper.newOrderByUser(map);
/* 261 */         urcModel.setOrderCount(newOrder != null ? Integer.parseInt(newOrder) : 0);
/* 262 */         String repayOrder = this.urgeRepayOrderMapper.repayOrderByUser(map);
/* 263 */         urcModel.setPromisCount(repayOrder != null ? Integer.parseInt(repayOrder) : 0);
/* 264 */         String successOrder = this.urgeRepayOrderMapper.successOrderByUser(map);
/* 265 */         urcModel.setSuccessCount(successOrder != null ? Integer.parseInt(successOrder) : 0);
/* 266 */         String failOrder = this.urgeRepayOrderMapper.failOrderByUser(map);
/* 267 */         urcModel.setFailCount(failOrder != null ? Integer.parseInt(failOrder) : 0);
/* 268 */         String count = this.urgeRepayOrderMapper.countByUser(map);
/* 269 */         urcModel.setCount(count != null ? Integer.parseInt(count) : 0);
/* 270 */         urcModel.setBackRate(0.0D);
/* 271 */         if (urcModel.getSuccessCount() > urcModel.getOrderCount()) {
/* 272 */           urcModel.setBackRate(100.0D);
/* 273 */         } else if (urcModel.getOrderCount() > 0) {
/* 274 */           double backRate = urcModel.getSuccessCount() / urcModel.getOrderCount();
/* 275 */           if (backRate > 100.0D) {
/* 276 */             urcModel.setBackRate(100.0D);
/*     */           } else {
/* 278 */             urcModel.setBackRate(BigDecimalUtil.decimal(backRate * 100.0D, 2));
/*     */           }
/*     */         }
/*     */         
/* 282 */         list.add(urcModel);
/*     */       }
/*     */     } catch (Exception e) {
/* 285 */       logger.error(e.getMessage(), e);
/*     */     }
/* 287 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<UrgeRepayCountModel> urgeCount(Map<String, Object> params)
/*     */   {
/* 293 */     List<UrgeRepayCountModel> list = null;
/*     */     try {
/* 295 */       list = new ArrayList();
/* 296 */       Date startTime = new Date();
/* 297 */       Date endTime = new Date();
/* 298 */       List<Date> dateList = null;
/* 299 */       if (params == null) {
/* 300 */         startTime = DateUtil.getDateBefore(-10, endTime);
/* 301 */         dateList = dateList(startTime, endTime);
/*     */       } else {
/* 303 */         endTime = DateUtil.valueOf(params.get("afterTime").toString());
/* 304 */         startTime = DateUtil.valueOf(params.get("beforeTime").toString());
/* 305 */         dateList = dateList(startTime, endTime);
/*     */       }
/* 307 */       for (int i = 0; i < dateList.size(); i++) {
/* 308 */         Map<String, Object> map = new HashMap();
/* 309 */         map.put("date", dateList.get(i));
/* 310 */         UrgeRepayCountModel urcModel = new UrgeRepayCountModel();
/* 311 */         urcModel.setCreateTime((Date)dateList.get(i));
/* 312 */         String allOrderCount = this.urgeRepayOrderMapper.allOrderCount(map);
/* 313 */         urcModel.setOrderCount(Integer.valueOf(allOrderCount == null ? "0" : allOrderCount).intValue());
/* 314 */         String successCount = this.urgeRepayOrderMapper.successCount(map);
/* 315 */         urcModel.setSuccessCount(Integer.valueOf(successCount == null ? "0" : successCount).intValue());
/* 316 */         String Count = this.urgeRepayOrderMapper.count(map);
/* 317 */         urcModel.setCount(Integer.valueOf(Count == null ? "0" : Count).intValue());
/* 318 */         if (urcModel.getOrderCount() == 0) {
/* 319 */           urcModel.setBackRate(0.0D);
/*     */         } else {
/* 321 */           urcModel.setBackRate(BigDecimalUtil.decimal(
/* 322 */             Double.valueOf(urcModel.getSuccessCount()).doubleValue() / Double.valueOf(urcModel.getOrderCount()).doubleValue() * 100.0D, 2));
/*     */         }
/*     */         
/* 325 */         list.add(urcModel);
/*     */       }
/*     */     } catch (Exception e) {
/* 328 */       logger.error(e.getMessage(), e);
/*     */     }
/* 330 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<UrgeRepayCountModel> memberDayCount(Map<String, Object> params)
/*     */   {
/* 336 */     List<UrgeRepayCountModel> list = null;
/*     */     try {
/* 338 */       list = new ArrayList();
/* 339 */       Date startTime = new Date();
/* 340 */       Date endTime = new Date();
/* 341 */       List<Date> dateList = null;
/* 342 */       if (params == null) {
/* 343 */         startTime = DateUtil.getDateBefore(-10, endTime);
/* 344 */         dateList = dateList(startTime, endTime);
/*     */       } else {
/* 346 */         endTime = DateUtil.valueOf(params.get("afterTime").toString());
/* 347 */         startTime = DateUtil.valueOf(params.get("beforeTime").toString());
/* 348 */         dateList = dateList(startTime, endTime); }
/*     */       Iterator localIterator2;
/* 350 */       for (Iterator localIterator1 = dateList.iterator(); localIterator1.hasNext(); 
/*     */           
/*     */ 
/* 353 */           localIterator2.hasNext())
/*     */       {
/* 350 */         Date date = (Date)localIterator1.next();
/* 351 */         Map<String, Object> map = new HashMap();
/* 352 */         List<UrgeRepayOrder> uroList = this.urgeRepayOrderMapper.listOrder(map);
/* 353 */         localIterator2 = uroList.iterator();
                    UrgeRepayOrder urgeRepayOrder = (UrgeRepayOrder)localIterator2.next();
/* 354 */         if (StringUtil.isNull(urgeRepayOrder.getUserName()) != null) {
/* 355 */           UrgeRepayCountModel urcModel = new UrgeRepayCountModel();
/* 356 */           map.put("date", date);
/* 357 */           map.put("userId", urgeRepayOrder.getUserId());
/* 358 */           urcModel.setName(urgeRepayOrder.getUserName());
/* 359 */           String newOrder = this.urgeRepayOrderMapper.newOrderByUser(map);
/* 360 */           urcModel.setOrderCount(newOrder != null ? Integer.parseInt(newOrder) : 0);
/* 361 */           String repayOrder = this.urgeRepayOrderMapper.repayOrderByUser(map);
/* 362 */           urcModel.setPromisCount(repayOrder != null ? Integer.parseInt(repayOrder) : 0);
/* 363 */           String successOrder = this.urgeRepayOrderMapper.successOrderByUser(map);
/* 364 */           urcModel.setSuccessCount(successOrder != null ? Integer.parseInt(successOrder) : 0);
/* 365 */           String failOrder = this.urgeRepayOrderMapper.failOrderByUser(map);
/* 366 */           urcModel.setFailCount(failOrder != null ? Integer.parseInt(failOrder) : 0);
/* 367 */           String count = this.urgeRepayOrderMapper.countByUser(map);
/* 368 */           urcModel.setCount(count != null ? Integer.parseInt(count) : 0);
/* 369 */           urcModel.setBackRate(0.0D);
/* 370 */           if (urcModel.getSuccessCount() > urcModel.getOrderCount()) {
/* 371 */             urcModel.setBackRate(100.0D);
/* 372 */           } else if (urcModel.getOrderCount() > 0) {
/* 373 */             double backRate = urcModel.getSuccessCount() / urcModel.getOrderCount();
/* 374 */             if (backRate > 100.0D) {
/* 375 */               urcModel.setBackRate(100.0D);
/*     */             } else {
/* 377 */               urcModel.setBackRate(BigDecimalUtil.decimal(backRate * 100.0D, 2));
/*     */             }
/*     */           }
/* 380 */           urcModel.setCreateTime(date);
/* 381 */           list.add(urcModel);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 386 */       logger.error(e.getMessage(), e);
/*     */     }
/* 388 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public UrgeRepayOrder findByBorrowId(long borrowId)
/*     */   {
/* 394 */     Map<String, Object> map = new HashMap();
/* 395 */     map.put("borrowId", Long.valueOf(borrowId));
/* 396 */     return (UrgeRepayOrder)this.urgeRepayOrderMapper.findSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */   public int updateLate(Map<String, Object> uroMap)
/*     */   {
/* 402 */     return this.urgeRepayOrderMapper.updateSelective(uroMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UrgeRepayOrder findOrderByMap(Map<String, Object> orderMap)
/*     */   {
/* 409 */     return (UrgeRepayOrder)this.urgeRepayOrderMapper.findSelective(orderMap);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<?> listUrgeRepayOrder(Map<String, Object> params)
/*     */   {
/* 415 */     List<UrgeRepayOrder> list = this.urgeRepayOrderMapper.listSelective(params);
/* 416 */     if ((list != null) && (!list.isEmpty())) {
/* 417 */       for (UrgeRepayOrder uro : list) {
/* 418 */         uro.setState(UrgeRepayOrderModel.change(uro.getState()));
/*     */       }
/*     */     }
/* 421 */     return list;
/*     */   }
/*     */   
/*     */   public List<Long> listUrge(Map<String, Object> params)
/*     */   {
/* 426 */     return this.urgeRepayOrderMapper.listUrge(params);
/*     */   }
/*     */   
/*     */   public List<?> listUrgeLog(Map<String, Object> params)
/*     */   {
/* 431 */     List<UrgeRepayOrderModel> list = this.urgeRepayOrderMapper
/* 432 */       .listModel(params);
/* 433 */     for (UrgeRepayOrderModel uroModel : list) {
/* 434 */       uroModel.setState(UrgeRepayOrderModel.change(uroModel.getState()));
/* 435 */       String str; switch ((str = uroModel.getWay()).hashCode()) {case 1567:  if (str.equals("10")) break; break; case 1598:  if (str.equals("20")) {} break; case 1629:  if (str.equals("30")) {} break; case 1660:  if (str.equals("40")) {} break; case 1691:  if (!str.equals("50"))
/*     */         {
/* 437 */         uroModel.setWay("电话");
/*     */
/* 440 */           uroModel.setWay("邮件");
/*     */
/* 443 */           uroModel.setWay("短信");
/*     */
/* 446 */           uroModel.setWay("现场沟通");
/*     */         }
/*     */         else {
/* 449 */           uroModel.setWay("其他");
/*     */         }
/*     */         break; }
/*     */     }
/* 453 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Date> dateList(Date startTime, Date endTime)
/*     */     throws Exception
/*     */   {
/* 462 */     startTime = DateUtil.getDateBefore(0, startTime);
/* 463 */     List<Date> lists = DateUtil.dateSplit(startTime, endTime);
/* 464 */     if (!lists.isEmpty()) {
/* 465 */       return lists;
/*     */     }
/* 467 */     return null;
/*     */   }
/*     */   
/*     */   public ManageUrgeRepayTotalModel totalUrgeRepay(Map<String, Object> params)
/*     */   {
/* 472 */     String penaltyAmount = "0.00";
/* 473 */     String repayDay = "0";
/* 474 */     String penaltyDay = "0";
/* 475 */     ManageUrgeRepayTotalModel bean = new ManageUrgeRepayTotalModel();
/* 476 */     List<String> stateList = Arrays.asList(new String[] { "30", "40", 
/* 477 */       "50", "41", "90" });
/* 478 */     params.put("stateList", stateList);
/*     */     
/* 480 */     Map<String, String> map = this.clBorrowMapper.countSuccessBorrow(params);
/* 481 */     bean.setBorrowCount(String.valueOf(map.get("count")));
/* 482 */     params.put("penaltyAmout", "0");
/*     */     
/* 484 */     Map<String, String> repayMap = this.borrowRepayMapper.totalBorrow(params);
/* 485 */     bean.setPenaltyCount(String.valueOf(repayMap.get("count")));
/*     */     
/* 487 */     List<RepayModel> list = this.clBorrowMapper.findRepay(params);
/* 488 */     if ((list != null) && (!list.isEmpty())) {
/* 489 */       penaltyAmount = String.valueOf(((RepayModel)list.get(0)).getPenaltyAmout());
/* 490 */       penaltyDay = ((RepayModel)list.get(0)).getPenaltyDay();
/*     */     }
/*     */     
/* 493 */     List<RepayModel> listHistory = this.clBorrowMapper.findRepaySuccess(params);
/* 494 */     if ((listHistory != null) && (!listHistory.isEmpty())) {
/* 495 */       repayDay = ((RepayModel)listHistory.get(0)).getPenaltyDay();
/*     */     }
/* 497 */     bean.setPenaltyDay(penaltyDay);
/* 498 */     bean.setRepayDay(repayDay);
/* 499 */     bean.setPenaltyAmount(penaltyAmount);
/* 500 */     bean.setPenaltyTag("");
/* 501 */     return bean;
/*     */   }
/*     */   
/*     */   public int updateState(Map<String, Object> param)
/*     */   {
/* 506 */     return this.urgeRepayOrderMapper.updateState(param);
/*     */   }
/*     */   
/*     */ 
/*     */   public String updateOrderState(Long id, String state)
/*     */   {
/* 512 */     Map<String, Object> param = new HashMap();
/* 513 */     param.put("id", id);
/* 514 */     param.put("state", state);
/* 515 */     UrgeRepayOrder order = this.urgeRepayOrderMapper.findByPrimary(param);
/* 516 */     String msg = "操作异常,订单状态不可修改";
/*     */     
/* 518 */     if ((!order.equals(null)) && (order.getState().equals("10")) && 
/* 519 */       (!state.equals("11"))) {
/* 520 */       return msg;
/*     */     }
/*     */     
/*     */ 
/* 524 */     if ((!order.equals(null)) && (order.getState().equals("11")) && 
/* 525 */       (!state.equals("20"))) {
/* 526 */       return msg;
/*     */     }
/*     */     
/*     */ 
/* 530 */     if ((!order.equals(null)) && (order.getState().equals("20")) && (
/* 531 */       (state.equals("10")) || (state.equals("11")))) {
/* 532 */       return msg;
/*     */     }
/*     */     
/*     */ 
/* 536 */     if ((!order.equals(null)) && (order.getState().equals("30")) && (
/* 537 */       (state.equals("10")) || (state.equals("11")))) {
/* 538 */       return msg;
/*     */     }
/*     */     
/*     */ 
/* 542 */     if ((!order.equals(null)) && (order.getState().equals("40")) && (order.getState().equals("50"))) {
/* 543 */       return msg;
/*     */     }
/*     */     
/* 546 */     if ((!order.equals(null)) && (order.getState().equals("60")) && 
/* 547 */       (state.equals("10"))) {
/* 548 */       return msg;
/*     */     }
/*     */     
/* 551 */     this.urgeRepayOrderMapper.updateOrderState(param);
/* 552 */     return "成功";
/*     */   }
/*     */   
/*     */   public ManageRepayOrderTotalModel totalUrgeRepayOrder(Map<String, Object> params)
/*     */   {
/* 557 */     ManageRepayOrderTotalModel bean = new ManageRepayOrderTotalModel();
/* 558 */     bean.setUrgeCount(String.valueOf(this.urgeRepayOrderMapper.countOrder(params)));
/* 559 */     params.put("state", "11");
/* 560 */     bean.setNoUrgeCount(String.valueOf(this.urgeRepayOrderMapper.countOrder(params)));
/* 561 */     params.put("state", "20");
/* 562 */     bean.setUrgingCount(String.valueOf(this.urgeRepayOrderMapper.countOrder(params)));
/* 563 */     params.put("state", "30");
/* 564 */     bean.setCommitUrgeCount(String.valueOf(this.urgeRepayOrderMapper.countOrder(params)));
/* 565 */     params.put("state", "20");
/* 566 */     params.put("successTime", DateUtils.formatDate(new Date(), new Object[] { "yyyy-MM-dd" }));
/* 567 */     params.put("day", Integer.valueOf(3));
/* 568 */     bean.setNoUrgeThreeCount(String.valueOf(this.urgeRepayOrderMapper.countOrder(params)));
/* 569 */     params.put("day", Integer.valueOf(7));
/* 570 */     bean.setNoUrgeSevenCount(String.valueOf(this.urgeRepayOrderMapper.countOrder(params)));
/* 571 */     params.remove("successTime");
/* 572 */     params.put("state", "40");
/* 573 */     bean.setUrgeSuccessCount(String.valueOf(this.urgeRepayOrderMapper.countOrder(params)));
/* 574 */     params.put("state", "60");
/* 575 */     bean.setUrgeStopCount(String.valueOf(this.urgeRepayOrderMapper.countOrder(params)));
/* 576 */     return bean;
/*     */   }
/*     */ }


/*impl\UrgeRepayOrderServiceImpl.class

 */