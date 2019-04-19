/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.BorrowRepay;
/*     */ import com.rongdu.cashloan.cl.domain.UrgeRepayOrder;
/*     */ import com.rongdu.cashloan.cl.domain.UrgeRepayOrderLog;
/*     */ import com.rongdu.cashloan.cl.model.ManageBorrowModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageUrgeRepayTotalModel;
/*     */ import com.rongdu.cashloan.cl.model.UrgeRepayOrderModel;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.cl.service.UrgeRepayOrderLogService;
/*     */ import com.rongdu.cashloan.cl.service.UrgeRepayOrderService;
/*     */ import com.rongdu.cashloan.core.common.util.DestributeUtil;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysDictService;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.DateUtil;
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
/*     */ public class ManageUrgeRepayOrderController
/*     */   extends ManageBaseController
/*     */ {
/*  56 */   private static final Logger logger = Logger.getLogger(ManageUrgeRepayOrderController.class);
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private UrgeRepayOrderService urgeRepayOrderService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private UrgeRepayOrderLogService urgeRepayOrderLogService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private BorrowRepayService borrowRepayService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private SysDictService sysDictService;
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:list", name="催款计划信息列表")
/*     */   public void list(HttpServletRequest request, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  82 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  83 */     SysUser sysUser = getLoginUser(request);
/*  84 */     if ((sysUser != null) && 
/*  85 */       (params == null)) {
/*  86 */       params = new HashMap();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  92 */     Page<UrgeRepayOrder> page = this.urgeRepayOrderService.list(params, current, pageSize);
/*  93 */     Map<String, Object> result = new HashMap();
/*  94 */     result.put("data", page);
/*  95 */     result.put("page", new RdPage(page));
/*  96 */     result.put("code", Integer.valueOf(200));
/*  97 */     result.put("msg", "获取成功");
/*  98 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/borrow/repay/urge/listLog.htm"})
/*     */   public void listLog(@RequestParam("userId") long userId, @RequestParam(value="phone", required=false) String phone, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 113 */     Map<String, Object> params = new HashMap();
/* 114 */     params.put("phone", phone);
/* 115 */     Page<UrgeRepayOrderModel> page = this.urgeRepayOrderService.listModel(params, current, pageSize);
/* 116 */     params.put("userId", Long.valueOf(userId));
/*     */     
/* 118 */     ManageUrgeRepayTotalModel borrow = this.urgeRepayOrderService.totalUrgeRepay(params);
/* 119 */     Map<String, Object> data = new HashMap();
/* 120 */     data.put("list", page.getResult());
/* 121 */     data.put("total", borrow);
/* 122 */     Map<String, Object> result = new HashMap();
/* 123 */     result.put("data", data);
/* 124 */     result.put("page", new RdPage(page));
/* 125 */     result.put("code", Integer.valueOf(200));
/* 126 */     result.put("msg", "获取成功");
/* 127 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/loglist.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:loglist", name="催款记录信息列表")
/*     */   public void loglist(HttpServletRequest request, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 142 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 143 */     SysUser sysUser = getLoginUser(request);
/* 144 */     if (sysUser != null) {
/* 145 */       if (params == null) {
/* 146 */         params = new HashMap();
/*     */       }
/* 148 */       if (sysUser.getId().longValue() != 1L) {
/* 149 */         params.put("userId", sysUser.getId());
/*     */       }
/*     */     }
/* 152 */     Page<UrgeRepayOrderModel> page = this.urgeRepayOrderService.listModel(params, current, pageSize);
/* 153 */     Map<String, Object> result = new HashMap();
/* 154 */     result.put("data", page);
/* 155 */     result.put("page", new RdPage(page));
/* 156 */     result.put("code", Integer.valueOf(200));
/* 157 */     result.put("msg", "获取成功");
/* 158 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/sysUserlist.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:sysUserlist", name="催款专员信息列表")
/*     */   public void sysUserlist(@RequestParam(value="roleName", required=false) String roleName)
/*     */     throws Exception
/*     */   {
/* 170 */     Map<String, Object> responseMap = new HashMap();
/* 171 */     Map<String, Object> params = new HashMap();
/* 172 */     if (roleName == null) {
/* 173 */       params.put("roleName", "CollectionSpecialist");
/*     */     } else {
/* 175 */       params.put("roleName", roleName);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 181 */     params.put("status", Integer.valueOf(0));
/* 182 */     params.put("memberState", Integer.valueOf(2));
/* 183 */     List<Map<String, Object>> users = this.sysUserService.getUserInfo(params);
/* 184 */     responseMap.put("data", users);
/* 185 */     responseMap.put("code", Integer.valueOf(200));
/* 186 */     responseMap.put("msg", "操作成功");
/* 187 */     ServletUtils.writeToResponse(this.response, responseMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/allotUser.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:allotUser", name="催款订单分配人员")
/*     */   public void allotUser(@RequestParam("id") String id, @RequestParam("userId") Long userId, @RequestParam("userName") String userName)
/*     */     throws Exception
/*     */   {
/* 202 */     Map<String, Object> responseMap = new HashMap();
/* 203 */     long[] ids = StringUtil.toLongs(id.split(","));
/* 204 */     int msg = 0;
/* 205 */     for (int i = 0; i < ids.length; i++) {
/* 206 */       Map<String, Object> params = new HashMap();
/* 207 */       params.put("id", Long.valueOf(ids[i]));
/* 208 */       params.put("userId", userId);
/* 209 */       params.put("userName", userName);
/* 210 */       params.put("state", "11");
/* 211 */       msg = this.urgeRepayOrderService.orderAllotUser(params);
/*     */     }
/* 213 */     if (msg > 0) {
/* 214 */       responseMap.put("code", Integer.valueOf(200));
/* 215 */       responseMap.put("msg", "操作成功");
/*     */     } else {
/* 217 */       responseMap.put("code", Integer.valueOf(400));
/* 218 */       responseMap.put("msg", "操作失败");
/*     */     }
/* 220 */     ServletUtils.writeToResponse(this.response, responseMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/randomAllotUser.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void randomAllotUser()
/*     */     throws Exception
/*     */   {
/* 232 */     Map<String, Object> params = new HashMap();
/* 233 */     params.put("states", "(10,11)");
/*     */     
/* 235 */     List<Long> list = this.urgeRepayOrderService.listUrge(params);
/*     */     
/* 237 */     params.put("roleName", "CollectionSpecialist");
/* 238 */     params.put("status", Integer.valueOf(0));
/* 239 */     params.put("memberState", Integer.valueOf(2));
/* 240 */     List<Map<String, Object>> users = this.sysUserService.getUserInfo(params);
/* 241 */     if ((list != null) && (!list.isEmpty()) && (users != null) && (!users.isEmpty()))
/*     */     {
/* 243 */       Map<Integer, List<Long>> map = new DestributeUtil().getCollection(list, users.size());
/* 244 */       if ((map != null) && (!map.isEmpty()))
/*     */       {
/* 246 */         for (int i = 0; i < users.size(); i++)
/*     */         {
/* 248 */           List<Long> listOrder = (List)map.get(Integer.valueOf(i + 1));
/* 249 */           if ((listOrder != null) && (!listOrder.isEmpty())) {
/* 250 */             for (Long order : listOrder) {
/* 251 */               params.put("id", order);
/* 252 */               params.put("userId", ((Map)users.get(i)).get("id"));
/* 253 */               params.put("userName", ((Map)users.get(i)).get("userName"));
/* 254 */               params.put("state", "11");
/* 255 */               this.urgeRepayOrderService.orderAllotUser(params);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 261 */     Map<String, Object> responseMap = new HashMap();
/* 262 */     responseMap.put("code", Integer.valueOf(200));
/* 263 */     responseMap.put("msg", "操作成功");
/* 264 */     ServletUtils.writeToResponse(this.response, responseMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/listDetail.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:listDetail", name="催款订单详细记录")
/*     */   public void listDetail(@RequestParam("id") Long id)
/*     */   {
/* 276 */     Map<String, Object> data = new HashMap();
/* 277 */     UrgeRepayOrder order = (UrgeRepayOrder)this.urgeRepayOrderService.getById(id);
/* 278 */     Map<String, Object> params = new HashMap();
/* 279 */     params.put("dueId", id);
/* 280 */     List<UrgeRepayOrderLog> logs = this.urgeRepayOrderLogService.getLogByParam(params);
/* 281 */     data.put("order", order);
/* 282 */     data.put("logs", logs);
/* 283 */     Map<String, Object> result = new HashMap();
/* 284 */     result.put("data", data);
/* 285 */     result.put("code", Integer.valueOf(200));
/*     */     
/* 287 */     result.put("msg", "获取成功");
/* 288 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/borrowlist.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:borrowlist", name="催款专员信息列表")
/*     */   public void borrowlist(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 303 */     Map<String, Object> responseMap = new HashMap();
/* 304 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 305 */     if (params == null) {
/* 306 */       params = new HashMap();
/*     */     }
/* 308 */     params.put("state", "50");
/* 309 */     List<UrgeRepayOrder> list = this.urgeRepayOrderService.listAll(new HashMap());
/* 310 */     List<Long> idList = new ArrayList();
/* 311 */     if ((list != null) && (list.size() > 0)) {
/* 312 */       params.put("type", "urge");
/* 313 */       for (UrgeRepayOrder or : list) {
/* 314 */         idList.add(or.getBorrowId());
/*     */       }
/* 316 */       params.put("idList", idList);
/*     */     } else {
/* 318 */       params.put("type", "");
/*     */     }
/*     */     
/* 321 */     Page<ManageBorrowModel> page = this.borrowRepayService.listModelNotUrge(params, currentPage, pageSize);
/* 322 */     responseMap.put("data", page);
/* 323 */     responseMap.put("page", new RdPage(page));
/* 324 */     responseMap.put("code", Integer.valueOf(200));
/* 325 */     responseMap.put("msg", "操作成功");
/* 326 */     ServletUtils.writeToResponse(this.response, responseMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/addOrder.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:addOrder", name="新增催收订单信息")
/*     */   public void addOrder(@RequestParam("id") Long id)
/*     */   {
/* 338 */     Map<String, Object> result = new HashMap();
/* 339 */     Map<String, Object> resultmap = this.urgeRepayOrderService.saveOrder(id);
/* 340 */     result.put("code", resultmap.get("code"));
/* 341 */     result.put("msg", resultmap.get("msg"));
/* 342 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/updateOrderState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:updateOrderState", name="修改催收订单信息状态")
/*     */   public void addOrder(@RequestParam("id") String id, @RequestParam("state") String state)
/*     */   {
/* 353 */     Map<String, Object> result = new HashMap();
/* 354 */     Map<String, Object> param = new HashMap();
/* 355 */     long[] ids = StringUtil.toLongs(id.split(","));
/* 356 */     for (int i = 0; i < ids.length; i++) {
/* 357 */       param.put("id", Long.valueOf(ids[i]));
/* 358 */       param.put("state", state);
/* 359 */       this.urgeRepayOrderService.updateLate(param);
/*     */     }
/* 361 */     result.put("code", Integer.valueOf(200));
/* 362 */     result.put("msg", "提交成功");
/* 363 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/saveOrderInfo.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:urge:saveOrderInfo", name="添加催款反馈信息")
/*     */   public void saveOrderInfo(@RequestParam("dueId") Long dueId, @RequestParam("createTime") String createTime, @RequestParam("state") String state, @RequestParam("remark") String remark, @RequestParam(value="promiseTime", required=false) String promiseTime, @RequestParam("way") String way, @RequestParam(value="flag", required=false) String flag)
/*     */   {
/* 380 */     Map<String, Object> result = new HashMap();
/* 381 */     UrgeRepayOrder order = (UrgeRepayOrder)this.urgeRepayOrderService.getById(dueId);
/* 382 */     UrgeRepayOrderLog orderLog = new UrgeRepayOrderLog();
/* 383 */     if (order != null) {
/*     */       try {
/* 385 */         orderLog.setCreateTime(DateUtil.valueOf(createTime, "yyyy-MM-dd HH:mm:ss"));
/* 386 */         if ((promiseTime != null) && (promiseTime != "")) {
/* 387 */           orderLog.setPromiseTime(DateUtil.valueOf(promiseTime, "yyyy-MM-dd HH:mm:ss"));
/*     */         }
/* 389 */         orderLog.setRemark(remark);
/* 390 */         orderLog.setWay(way);
/* 391 */         orderLog.setFlag(flag);
/* 392 */         if ((state == null) || (state == "")) {
/* 393 */           orderLog.setState("20");
/*     */         } else {
/* 395 */           orderLog.setState(state);
/*     */         }
/* 397 */         this.urgeRepayOrderLogService.saveOrderInfo(orderLog, order);
/*     */         
/* 399 */         result.put("code", Integer.valueOf(200));
/* 400 */         result.put("msg", "提交成功");
/*     */       } catch (Exception e) {
/* 402 */         logger.error(e);
/* 403 */         result.put("code", Integer.valueOf(400));
/* 404 */         result.put("msg", "提交失败");
/*     */       }
/*     */     }
/*     */     else {
/* 408 */       result.put("code", Integer.valueOf(400));
/* 409 */       result.put("msg", "提交信息有误");
/*     */     }
/* 411 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/urge/success.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void urgeSuccess(@RequestParam("dueId") Long dueId)
/*     */     throws Exception
/*     */   {
/* 421 */     Map<String, Object> result = new HashMap();
/* 422 */     UrgeRepayOrder order = (UrgeRepayOrder)this.urgeRepayOrderService.getById(dueId);
/*     */     
/* 424 */     if (order != null)
/*     */     {
/* 426 */       Map<String, Object> map = new HashMap();
/* 427 */       map.put("borrowId", order.getBorrowId());
/* 428 */       BorrowRepay repay = this.borrowRepayService.findSelective(map);
/* 429 */       if (("10".equals(repay.getState())) && ("40".equals(order.getState()))) {
/* 430 */         result.put("code", Integer.valueOf(400));
/* 431 */         result.put("msg", "该订单已经还款并且催收成功！");
/* 432 */         ServletUtils.writeToResponse(this.response, result);
/* 433 */         return;
/*     */       }
/*     */     }
/* 436 */     result.put("code", Integer.valueOf(200));
/* 437 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageUrgeRepayOrderController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */