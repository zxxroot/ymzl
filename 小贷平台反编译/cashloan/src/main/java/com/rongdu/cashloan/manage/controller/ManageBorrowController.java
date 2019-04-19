/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.model.GPSModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageBorrowModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageBorrowProgressModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageBorrowTotalModel;
/*     */ import com.rongdu.cashloan.cl.service.BorrowProgressService;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayLogService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.ClSmsService;
/*     */ import com.rongdu.cashloan.cl.service.PayLogService;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.domain.Borrow;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
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
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class ManageBorrowController
/*     */   extends ManageBaseController
/*     */ {
/*  56 */   private static final Logger logger = Logger.getLogger(ManageBorrowController.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private ClBorrowService clBorrowService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private BorrowProgressService borrowProgressService;
/*     */   
/*     */   @Resource
/*     */   private BorrowRepayLogService borrowRepayLogService;
/*     */   
/*     */   @Resource
/*     */   private PayLogService payLogService;
/*     */   
/*     */   @Resource
/*     */   private ClSmsService clSmsService;
/*     */   
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:list", name="借款信息列表")
/*     */   public void list(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  80 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  81 */     Page<ManageBorrowModel> page = this.clBorrowService.listModel(params, current, pageSize);
/*  82 */     Map<String, Object> result = new HashMap();
/*  83 */     result.put("data", page);
/*  84 */     result.put("page", new RdPage(page));
/*  85 */     result.put("code", Integer.valueOf(200));
/*  86 */     result.put("msg", "获取成功");
/*  87 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/progress/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:progress:list", name="借款进度列表")
/*     */   public void progresslist(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 101 */     if (searchParams == null) {
/* 102 */       searchParams = "";
/*     */     }
/* 104 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 105 */     if (params != null) {
/* 106 */       Object obj = params.get("create_time");
/* 107 */       if (obj != null) {
/* 108 */         ArrayList<String> create_time = (ArrayList)obj;
/* 109 */         if (create_time != null) {
/* 110 */           params.put("begin", create_time.get(0));
/* 111 */           params.put("end", create_time.get(1));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 117 */     Page<ManageBorrowProgressModel> page = this.borrowProgressService.listModel(params, currentPage, pageSize);
/* 118 */     Map<String, Object> result = new HashMap();
/* 119 */     result.put("data", page);
/* 120 */     result.put("page", new RdPage(page));
/* 121 */     result.put("code", Integer.valueOf(200));
/* 122 */     result.put("msg", "获取成功");
/* 123 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/reviewList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:reviewList", name="人工复审通过列表")
/*     */   public void reviewList(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 137 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     
/* 139 */     Page<ManageBorrowModel> page = null;
/* 140 */     if (params != null) {
/* 141 */       Object obj = params.get("create_time");
/* 142 */       if (obj != null) {
/* 143 */         ArrayList<String> create_time = (ArrayList)obj;
/* 144 */         if (create_time != null) {
/* 145 */           params.put("begin", create_time.get(0));
/* 146 */           params.put("end", create_time.get(1));
/*     */         }
/*     */       }
/* 149 */       String state = StringUtil.isNull(params.get("state"));
/* 150 */       if ((state != null) && (!StringUtil.isBlank(state))) {
/* 151 */         if (StringUtil.equals(state, "26")) {
/* 152 */           page = this.clBorrowService.listReview(params, currentPage, pageSize);
/*     */         } else {
/* 154 */           List stateList = Arrays.asList(new String[] { state });
/* 155 */           params.put("stateList", stateList);
/* 156 */           params.put("state", "");
/* 157 */           page = this.clBorrowService.listModel(params, currentPage, pageSize);
/*     */         }
/*     */       } else {
/* 160 */         List stateList = Arrays.asList(new String[] { "22", 
/* 161 */           "27", "26" });
/* 162 */         params.put("stateList", stateList);
/* 163 */         params.put("state", "");
/* 164 */         page = this.clBorrowService.listModel(params, currentPage, pageSize);
/*     */       }
/*     */     }
/*     */     
/* 168 */     Map<String, Object> result = new HashMap();
/* 169 */     result.put("data", page);
/* 170 */     result.put("page", new RdPage(page));
/* 171 */     result.put("code", Integer.valueOf(200));
/* 172 */     result.put("msg", "获取成功");
/* 173 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/borrowList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowList", name="借款审核状态列表")
/*     */   public void borrowList(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 187 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     
/* 189 */     if (params != null) {
/* 190 */       String state = StringUtil.isNull(params.get("state"));
/* 191 */       if ((state != null) && (!StringUtil.isBlank(state)))
/*     */       {
/* 193 */         if (state.equals("10")) {
/* 194 */           List stateList = Arrays.asList(new String[] { "10" });
/* 195 */           params.put("stateList", stateList);
/* 196 */           params.put("state", "");
/*     */         }
/*     */         
/* 199 */         if (state.equals("21")) {
/* 200 */           List stateList = Arrays.asList(new String[] { "21" });
/* 201 */           params.put("stateList", stateList);
/* 202 */           params.put("state", "");
/*     */         }
/*     */         
/* 205 */         if (state.equals("22")) {
/* 206 */           List stateList = Arrays.asList(new String[] { "22", 
/* 207 */             "27", "26" });
/* 208 */           params.put("stateList", stateList);
/* 209 */           params.put("state", "");
/*     */         }
/*     */         
/* 212 */         if (state.equals("20")) {
/* 213 */           List stateList = Arrays.asList(new String[] { "20" });
/* 214 */           params.put("stateList", stateList);
/* 215 */           params.put("state", "");
/*     */         }
/* 217 */         Object obj = params.get("create_time");
/* 218 */         if (obj != null) {
/* 219 */           ArrayList<String> create_time = (ArrayList)obj;
/* 220 */           if (create_time != null) {
/* 221 */             params.put("begin", create_time.get(0));
/* 222 */             params.put("end", create_time.get(1));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 227 */     Page<ManageBorrowModel> page = this.clBorrowService.listModel(params, currentPage, pageSize);
/* 228 */     Map<String, Object> result = new HashMap();
/* 229 */     result.put("data", page);
/* 230 */     result.put("page", new RdPage(page));
/* 231 */     result.put("code", Integer.valueOf(200));
/* 232 */     result.put("msg", "获取成功");
/* 233 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/borrowRepayList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRepayList", name="借款还款信息列表 ")
/*     */   public void borrowRepayList(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 247 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     
/* 249 */     if (params != null)
/*     */     {
/* 251 */       String type = StringUtil.isNull(params.get("type"));
/* 252 */       if ("repay".equals(type)) {
/* 253 */         List stateList = Arrays.asList(new String[] { "90", "50", "30", "41", "31", "40" });
/* 254 */         params.put("stateList", stateList);
/* 255 */         String state = StringUtil.isNull(params.get("state"));
/* 256 */         if ((state != null) && (!StringUtil.isBlank(state))) {
/* 257 */           params.put("state", state);
/*     */         }
/*     */       }
/* 260 */       String state = StringUtil.isNull(params.get("state"));
/* 261 */       if ((state != null) && (!StringUtil.isBlank(state)))
/*     */       {
/* 263 */         if (state.equals("40")) {
/* 264 */           List stateList = Arrays.asList(new String[] { "40", 
/* 265 */             "41" });
/* 266 */           params.put("stateList", stateList);
/* 267 */           params.put("state", "");
/*     */         }
/*     */         
/* 270 */         if (state.equals("50")) {
/* 271 */           List stateList = Arrays.asList(new String[] { "50" });
/* 272 */           params.put("stateList", stateList);
/* 273 */           params.put("state", "");
/*     */         }
/*     */         
/* 276 */         if (state.equals("90")) {
/* 277 */           List stateList = Arrays.asList(new String[] { "90" });
/* 278 */           params.put("stateList", stateList);
/* 279 */           params.put("state", "");
/*     */         }
/*     */       }
/*     */       
/* 283 */       Object obj = params.get("create_time");
/* 284 */       if (obj != null) {
/* 285 */         ArrayList<String> create_time = (ArrayList)obj;
/* 286 */         if (create_time != null) {
/* 287 */           params.put("begin", create_time.get(0));
/* 288 */           params.put("end", create_time.get(1));
/*     */         }
/*     */       }
/*     */     }
/* 292 */     Page<ManageBorrowModel> page = this.clBorrowService.listBorrowModel(params, current, pageSize);
/* 293 */     Map<String, Object> result = new HashMap();
/* 294 */     result.put("data", page);
/* 295 */     result.put("page", new RdPage(page));
/* 296 */     result.put("code", Integer.valueOf(200));
/* 297 */     result.put("msg", "获取成功");
/* 298 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/payAgain.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:payAgain", name="借款还款信息详细页面    ")
/*     */   public void payAgain(@RequestParam("borrowId") long borrowId)
/*     */   {
/* 308 */     Borrow borrow = (Borrow)this.clBorrowService.getById(Long.valueOf(borrowId));
/* 309 */     boolean flag = this.payLogService.judge(borrowId);
/* 310 */     Map<String, Object> result = new HashMap();
/*     */     
/* 312 */     if ((borrow != null) && (flag) && (
/* 313 */       ("20".equals(borrow.getState())) || 
/* 314 */       ("26".equals(borrow.getState())) || 
/* 315 */       ("31".equals(borrow.getState())))) {
/* 316 */       this.clBorrowService.borrowLoan(borrow, DateUtil.getNow());
/* 317 */       result.put("code", Integer.valueOf(200));
/* 318 */       result.put("msg", "操作成功");
/*     */     }
/*     */     else {
/* 321 */       result.put("code", Integer.valueOf(400));
/* 322 */       result.put("msg", "此借款状态不允许再次支付");
/*     */     }
/*     */     
/* 325 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/borrowRepayContent.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRepayContent", name="借款还款信息详细页面    ")
/*     */   public void borrowRepayContent(@RequestParam("borrowId") long borrowId)
/*     */   {
/* 337 */     ManageBorrowModel model = this.clBorrowService.getModelByBorrowId(borrowId);
/* 338 */     Map<String, Object> result = new HashMap();
/* 339 */     result.put("data", model);
/* 340 */     result.put("code", Integer.valueOf(200));
/* 341 */     result.put("msg", "获取成功");
/* 342 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/borrow/listBorrowLog.htm"})
/*     */   public void listBorrowLog(@RequestParam("userId") long userId, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 383 */     Map<String, Object> params = new HashMap();
/* 384 */     params.put("userId", Long.valueOf(userId));
/* 385 */     Page<ManageBorrowModel> page = this.clBorrowService.listBorrow(params, current, pageSize);
/*     */     
/* 387 */     ManageBorrowTotalModel borrow = this.clBorrowService.totalBorrow(params);
/* 388 */     Map<String, Object> data = new HashMap();
/* 389 */     data.put("list", page.getResult());
/* 390 */     data.put("total", borrow);
/* 391 */     Map<String, Object> result = new HashMap();
/* 392 */     result.put("data", data);
/* 393 */     result.put("page", new RdPage(page));
/* 394 */     result.put("code", Integer.valueOf(200));
/* 395 */     result.put("msg", "查询成功");
/* 396 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/verifyBorrow.htm"})
/*     */   public void verifyBorrow(@RequestParam("borrowId") Long borrowId, @RequestParam("state") String state, @RequestParam("remark") String remark)
/*     */     throws Exception
/*     */   {
/* 410 */     List<Map<String, Object>> sysList = null;
/* 411 */     Map<String, Object> result = new HashMap();
/*     */     try {
/* 413 */       Map<String, Object> params = new HashMap();
/* 414 */       params.put("roleName", "riskControl");
/* 415 */       sysList = this.sysUserService.getUserInfo(params);
/*     */       
/* 417 */       SysUser sysUser = getLoginUser(this.request);
/* 418 */       if ((sysUser != null) && 
/* 419 */         (sysUser.getId().longValue() == ((Long)((Map)sysList.get(0)).get("id")).longValue())) {
/* 420 */         result.put("code", Integer.valueOf(400));
/* 421 */         result.put("msg", "信审主管不能进行人工复审操作");
/* 422 */         ServletUtils.writeToResponse(this.response, result);
/* 423 */         return;
/*     */       }
/*     */       
/* 426 */       int msg = this.clBorrowService.manualVerifyBorrow(borrowId, state, remark, sysUser.getId());
/* 427 */       if (msg == 1) {
/* 428 */         result.put("code", Integer.valueOf(200));
/* 429 */         result.put("msg", "复审成功");
/*     */       } else {
/* 431 */         result.put("code", Integer.valueOf(400));
/* 432 */         result.put("msg", "复审失败");
/*     */       }
/*     */     } catch (Exception e) {
/* 435 */       logger.error(e);
/* 436 */       result.put("code", Integer.valueOf(400));
/* 437 */       result.put("msg", (sysList == null) || (sysList.isEmpty()) ? "当前用户无操作权限" : e.getMessage());
/*     */     }
/* 439 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/reVerifyBorrowData.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void reVerifyBorrowData(@RequestParam("borrowId") String borrowId)
/*     */   {
/* 450 */     long[] ids = StringUtil.toLongs(borrowId.split(","));
/* 451 */     Map<String, Object> result = new HashMap();
/* 452 */     for (int i = 0; i < ids.length; i++) {
/* 453 */       this.clBorrowService.reVerifyBorrowData(Long.valueOf(ids[i]));
/*     */     }
/* 455 */     result.put("code", Integer.valueOf(200));
/* 456 */     result.put("msg", "提交成功，请等待处理结果");
/*     */     
/* 458 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/api/smsBatch.htm"})
/*     */   public void smsBatch()
/*     */   {
/* 466 */     String id = this.request.getParameter("ids");
/* 467 */     Map<String, Object> result = new HashMap();
/* 468 */     int r = this.clSmsService.smsBatch(id);
/* 469 */     if (r == 1) {
/* 470 */       result.put("code", Integer.valueOf(200));
/* 471 */       result.put("msg", "处理结束");
/*     */     }
/* 473 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/listUserGPS.htm"})
/*     */   public void listUserGPS(@RequestParam("userId") long userId)
/*     */     throws Exception
/*     */   {
/* 483 */     List<GPSModel> borrowList = this.clBorrowService.listBorrowGPS(userId);
/*     */     
/* 485 */     List<GPSModel> userList = this.clBorrowService.listUserGPS(userId);
/* 486 */     borrowList.addAll(userList);
/* 487 */     Map<String, Object> data = new HashMap();
/* 488 */     data.put("list", borrowList);
/* 489 */     Map<String, Object> result = new HashMap();
/* 490 */     result.put("data", data);
/* 491 */     result.put("code", Integer.valueOf(200));
/* 492 */     result.put("msg", "查询成功");
/* 493 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/borrowRepayListChannel.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:borrowRepayList", name="借款还款信息列表 ")
/*     */   public void borrowRepayListChannel(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 507 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     
/* 509 */     if (params != null)
/*     */     {
/* 511 */       String type = StringUtil.isNull(params.get("type"));
/* 512 */       if ("repay".equals(type)) {
/* 513 */         List stateList = Arrays.asList(new String[] { "90", "50", "30", "41", "31", "40" });
/* 514 */         params.put("stateList", stateList);
/* 515 */         String state = StringUtil.isNull(params.get("state"));
/* 516 */         if ((state != null) && (!StringUtil.isBlank(state))) {
/* 517 */           params.put("state", state);
/*     */         }
/*     */       }
/* 520 */       String state = StringUtil.isNull(params.get("state"));
/* 521 */       if ((state != null) && (!StringUtil.isBlank(state)))
/*     */       {
/* 523 */         if (state.equals("40")) {
/* 524 */           List stateList = Arrays.asList(new String[] { "40", 
/* 525 */             "41" });
/* 526 */           params.put("stateList", stateList);
/* 527 */           params.put("state", "");
/*     */         }
/*     */         
/* 530 */         if (state.equals("50")) {
/* 531 */           List stateList = Arrays.asList(new String[] { "50" });
/* 532 */           params.put("stateList", stateList);
/* 533 */           params.put("state", "");
/*     */         }
/*     */         
/* 536 */         if (state.equals("90")) {
/* 537 */           List stateList = Arrays.asList(new String[] { "90" });
/* 538 */           params.put("stateList", stateList);
/* 539 */           params.put("state", "");
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 544 */     Page<ManageBorrowModel> page = this.clBorrowService.listBorrowModel(params, current, pageSize);
/* 545 */     Map<String, Object> result = new HashMap();
/* 546 */     result.put("data", page);
/* 547 */     result.put("page", new RdPage(page));
/* 548 */     result.put("code", Integer.valueOf(200));
/* 549 */     result.put("msg", "获取成功");
/* 550 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageBorrowController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */