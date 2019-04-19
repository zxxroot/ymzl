/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.PhoneCollectionLog;
/*     */ import com.rongdu.cashloan.cl.domain.UrgeRepayOrder;
/*     */ import com.rongdu.cashloan.cl.domain.UrgeRepayOrderLog;
/*     */ import com.rongdu.cashloan.cl.model.ManageRepayOrderTotalModel;
/*     */ import com.rongdu.cashloan.cl.model.PhoneCollectionLogModel;
/*     */ import com.rongdu.cashloan.cl.model.UrgeRepayCountModel;
/*     */ import com.rongdu.cashloan.cl.model.UrgeRepayOrderModel;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.PhoneCollectionLogService;
/*     */ import com.rongdu.cashloan.cl.service.UrgeRepayOrderLogService;
/*     */ import com.rongdu.cashloan.cl.service.UrgeRepayOrderService;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
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
/*     */ public class ManageUrgeCollectionRepayController
/*     */   extends ManageBaseController
/*     */ {
/*  58 */   private static final Logger logger = LoggerFactory.getLogger(ManageUrgeCollectionRepayController.class);
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private UrgeRepayOrderService urgeRepayOrderService;
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private UrgeRepayOrderLogService urgeRepayOrderLogService;
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private BorrowRepayService borrowRepayService;
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private PhoneCollectionLogService phoneCollectionLogService;
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private ClBorrowService clBorrowService;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/repay/urge/collection/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:collection:list", name="我的催款计划信息列表")
/*     */   public void list(HttpServletResponse response, HttpServletRequest request, HttpSession session, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  92 */     Map<String, Object> result = new HashMap();
/*  93 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  94 */     SysUser sysUser = getLoginUser(request);
/*  95 */     Page<UrgeRepayOrderModel> page = new Page();
/*  96 */     Map<String, Object> data = new HashMap();
/*  97 */     if (sysUser != null) {
/*  98 */       if (params == null) {
/*  99 */         params = new HashMap();
/* 100 */         params.put("userId", sysUser.getId());
/*     */         
/* 102 */         ManageRepayOrderTotalModel bean = this.urgeRepayOrderService.totalUrgeRepayOrder(params);
/* 103 */         result.put("bean", bean);
/* 104 */         params.remove("successTime");
/* 105 */         params.remove("state");
/*     */       }
/* 107 */       params.put("userId", sysUser.getId());
/* 108 */       page = this.urgeRepayOrderService.listAll(params, current, pageSize);
/* 109 */       data.put("page", page);
/*     */       
/* 111 */       String state = String.valueOf(params.get("state") == null ? "" : params.get("state"));
/* 112 */       if (("".equals(state)) || ("11".equals(state))) {
/* 113 */         Map<String, Object> map = new HashMap();
/* 114 */         map.put("userId", sysUser.getId());
/* 115 */         map.put("state", "11");
/* 116 */         result.put("total", Integer.valueOf(this.urgeRepayOrderService.listUrge(map).size()));
/* 117 */         map.put("currentTime", new Date());
/* 118 */         result.put("insert", Integer.valueOf(this.urgeRepayOrderService.listUrge(map).size()));
/*     */       }
/*     */       
/* 121 */       result.put("data", page);
/* 122 */       result.put("page", new RdPage(page));
/* 123 */       result.put("code", Integer.valueOf(200));
/* 124 */       result.put("msg", "获取成功");
/*     */     } else {
/* 126 */       result.put("data", page);
/* 127 */       result.put("page", new RdPage(page));
/* 128 */       result.put("code", Integer.valueOf(200));
/* 129 */       result.put("msg", "登陆过期请重新登录");
/*     */     }
/* 131 */     ServletUtils.writeToResponse(response, result);
/*     */   }
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
/*     */   @RequestMapping({"/modules/manage/borrow/repay/urge/collection/loglist.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:collection:loglist", name="我的催款记录信息列表")
/*     */   public void loglist(HttpServletResponse response, HttpServletRequest request, HttpSession session, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 150 */     Map<String, Object> result = new HashMap();
/* 151 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 152 */     Page<UrgeRepayOrderModel> page = new Page();
/* 153 */     SysUser sysUser = getLoginUser(request);
/* 154 */     if (sysUser != null) {
/* 155 */       if (params == null) {
/* 156 */         params = new HashMap();
/*     */       }
/* 158 */       params.put("userId", sysUser.getId());
/* 159 */       page = this.urgeRepayOrderService.listModel(params, current, pageSize);
/* 160 */       result.put("data", page);
/* 161 */       result.put("page", new RdPage(page));
/* 162 */       result.put("code", Integer.valueOf(200));
/* 163 */       result.put("msg", "获取成功");
/*     */     } else {
/* 165 */       result.put("data", page);
/* 166 */       result.put("page", new RdPage(page));
/* 167 */       result.put("code", Integer.valueOf(200));
/* 168 */       result.put("msg", "登陆过期请重新登录");
/*     */     }
/* 170 */     ServletUtils.writeToResponse(response, result);
/*     */   }
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
/*     */   @RequestMapping({"/modules/manage/borrow/repay/urge/collection/member.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:collection:member", name="催收人员统计列表")
/*     */   public void member(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 186 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 187 */     Page<UrgeRepayCountModel> page = this.urgeRepayOrderService.memberCount(params, current, pageSize);
/* 188 */     Map<String, Object> result = new HashMap();
/* 189 */     result.put("data", page);
/* 190 */     result.put("page", new RdPage(page));
/* 191 */     result.put("code", Integer.valueOf(200));
/* 192 */     result.put("msg", "获取成功");
/*     */     
/* 194 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/repay/urge/collection/urgeCount.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:collection:urge", name="催回率统计")
/*     */   public void urgeCount(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */   {
/* 208 */     Map<String, Object> result = new HashMap();
/* 209 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 210 */     List<UrgeRepayCountModel> list = this.urgeRepayOrderService.urgeCount(params);
/* 211 */     result.put("data", list);
/* 212 */     result.put("code", Integer.valueOf(200));
/* 213 */     result.put("msg", "获取成功");
/* 214 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/repay/urge/collection/orderCountt.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:collection:orderCount", name="催收订单统计")
/*     */   public void orderCount(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */   {
/* 228 */     Map<String, Object> result = new HashMap();
/* 229 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 230 */     List<UrgeRepayCountModel> list = this.urgeRepayOrderService.orderCount(params);
/* 231 */     result.put("data", list);
/* 232 */     result.put("code", Integer.valueOf(200));
/* 233 */     result.put("msg", "获取成功");
/*     */     
/* 235 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/repay/urge/collection/memberDayCount.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:collection:memberDayCount", name="催收员每日统计")
/*     */   public void memberDayCount(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */   {
/* 250 */     Map<String, Object> result = new HashMap();
/* 251 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 252 */     List<UrgeRepayCountModel> list = this.urgeRepayOrderService.memberDayCount(params);
/* 253 */     result.put("data", list);
/* 254 */     result.put("code", Integer.valueOf(200));
/* 255 */     result.put("msg", "获取成功");
/*     */     
/* 257 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/collection/updateState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:collection:updateState", name="修改催收员状态")
/*     */   public void updateState(@RequestParam("id") Long id, @RequestParam(value="status", required=false) String status, @RequestParam(value="memberState", required=false) String memberState)
/*     */     throws ServiceException
/*     */   {
/* 271 */     Map<String, Object> result = new HashMap();
/* 272 */     Map<String, Object> param = new HashMap();
/* 273 */     result.put("code", Integer.valueOf(400));
/* 274 */     result.put("msg", "参数不合法");
/* 275 */     if ((memberState != null) || (status != null)) {
/* 276 */       param.put("id", id);
/* 277 */       param.put("status", status);
/* 278 */       param.put("memberState", memberState);
/* 279 */       this.urgeRepayOrderService.updateState(param);
/*     */       
/* 281 */       if (("1".equals(memberState)) || ("1".equals(status)))
/*     */       {
/* 283 */         Map<String, Object> params = new HashMap();
/* 284 */         params.put("state", "22");
/*     */         
/* 286 */         params.put("sysUserId", id);
/*     */         
/* 288 */         List<Long> list = this.clBorrowService.listOrder(params);
/* 289 */         if ((list != null) && (!list.isEmpty()))
/*     */         {
/* 291 */           params.put("roleName", "riskControlPersonnel");
/* 292 */           params.put("status", "0");
/* 293 */           params.put("memberState", "2");
/* 294 */           List<Map<String, Object>> users = this.sysUserService.getUserInfo(params);
/*     */           
/* 296 */           this.clBorrowService.giveOrder(list, users);
/*     */         }
/*     */       }
/*     */       
/* 300 */       result.put("code", Integer.valueOf(200));
/* 301 */       result.put("msg", "提交成功");
/*     */     }
/*     */     
/* 304 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/collection/updateOrderState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:collection:updateOrderState", name="修改催收员状态")
/*     */   public void updateOrderState(@RequestParam("id") Long id, @RequestParam("state") String state)
/*     */   {
/* 316 */     Map<String, Object> result = new HashMap();
/* 317 */     String msg = this.urgeRepayOrderService.updateOrderState(id, state);
/* 318 */     result.put("code", Integer.valueOf(200));
/* 319 */     result.put("msg", msg);
/* 320 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/urge/collection/phoneList.htm"})
/*     */   public void phoneListLog(@RequestParam("urgeRepayId") long urgeRepayId, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 335 */     Map<String, Object> result = new HashMap();
/* 336 */     Map<String, Object> params = new HashMap();
/* 337 */     SysUser sysUser = getLoginUser(this.request);
/* 338 */     if (sysUser == null) {
/* 339 */       result.put("code", Integer.valueOf(200));
/* 340 */       result.put("msg", "登陆过期请重新登录");
/* 341 */       ServletUtils.writeToResponse(this.response, result);
/*     */     }
/* 343 */     params.put("urgeRepayId", Long.valueOf(urgeRepayId));
/* 344 */     params.put("sysUserId", sysUser.getId());
/* 345 */     Page<PhoneCollectionLogModel> page = this.phoneCollectionLogService.list(params, current, pageSize);
/* 346 */     Map<String, Object> data = new HashMap();
/* 347 */     data.put("list", page.getResult());
/* 348 */     result.put("data", data);
/* 349 */     result.put("page", new RdPage(page));
/* 350 */     result.put("code", Integer.valueOf(200));
/* 351 */     result.put("msg", "查询成功");
/* 352 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
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
/*     */   @RequestMapping(value={"/modules/manage/borrow/urge/collection/phone/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void saveOrderInfo(@RequestParam("urgeRepayId") Long urgeRepayId, @RequestParam("relation") String relation, @RequestParam(value="contactsName", required=false) String contactsName, @RequestParam("remark") String remark, @RequestParam("phone") String phone)
/*     */   {
/* 367 */     Map<String, Object> result = new HashMap();
/*     */     
/* 369 */     SysUser sysUser = getLoginUser(this.request);
/* 370 */     if (sysUser == null) {
/* 371 */       result.put("code", Integer.valueOf(200));
/* 372 */       result.put("msg", "登陆过期请重新登录");
/* 373 */       ServletUtils.writeToResponse(this.response, result);
/*     */     }
/* 375 */     UrgeRepayOrder order = (UrgeRepayOrder)this.urgeRepayOrderService.getById(urgeRepayId);
/* 376 */     PhoneCollectionLog phoneCollectionLog = new PhoneCollectionLog();
/* 377 */     if (order != null) {
/*     */       try {
/* 379 */         phoneCollectionLog.setUrgeRepayId(urgeRepayId);
/* 380 */         phoneCollectionLog.setSysUserId(sysUser.getId());
/* 381 */         phoneCollectionLog.setContactsName(contactsName);
/* 382 */         phoneCollectionLog.setRelation(relation);
/* 383 */         phoneCollectionLog.setRemark(remark);
/* 384 */         phoneCollectionLog.setCreateTime(new Date());
/* 385 */         phoneCollectionLog.setPhone(phone);
/*     */         
/* 387 */         this.phoneCollectionLogService.insert(phoneCollectionLog);
/*     */         
/* 389 */         result.put("code", Integer.valueOf(200));
/* 390 */         result.put("msg", "提交成功");
/*     */       } catch (Exception e) {
/* 392 */         logger.error(e.toString());
/* 393 */         result.put("code", Integer.valueOf(400));
/* 394 */         result.put("msg", "提交失败");
/*     */       }
/*     */     }
/*     */     else {
/* 398 */       result.put("code", Integer.valueOf(400));
/* 399 */       result.put("msg", "提交信息有误");
/*     */     }
/* 401 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/repay/urge/collection/result.htm"})
/*     */   public void loglist(@RequestParam("dueId") Long dueId)
/*     */   {
/* 414 */     Map<String, Object> result = new HashMap();
/* 415 */     Map<String, Object> params = new HashMap();
/* 416 */     SysUser sysUser = getLoginUser(this.request);
/* 417 */     if (sysUser != null) {
/* 418 */       params.put("userId", sysUser.getId());
/* 419 */       params.put("dueId", dueId);
/* 420 */       params.put("orderBy", "create_time desc,promise_time desc");
/* 421 */       UrgeRepayOrderLog bean = new UrgeRepayOrderLog();
/* 422 */       List<UrgeRepayOrderLog> list = this.urgeRepayOrderLogService.getLogByParam(params);
/* 423 */       if ((list != null) && (!list.isEmpty())) {
/* 424 */         bean = (UrgeRepayOrderLog)list.get(0);
/*     */       }
/* 426 */       result.put("data", bean);
/* 427 */       result.put("code", Integer.valueOf(200));
/* 428 */       result.put("msg", "获取成功");
/*     */     } else {
/* 430 */       result.put("data", null);
/* 431 */       result.put("code", Integer.valueOf(200));
/* 432 */       result.put("msg", "登陆过期请重新登录");
/*     */     }
/* 434 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageUrgeCollectionRepayController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */