/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.Channel;
/*     */ import com.rongdu.cashloan.cl.model.CreditReviewTotalModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageCreditReviewModel;
/*     */ import com.rongdu.cashloan.cl.service.ChannelService;
/*     */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*     */ import com.rongdu.cashloan.cl.service.CreditReviewService;
/*     */ import com.rongdu.cashloan.core.common.context.ExportConstant;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.excel.JsGridReportBase;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
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
/*     */ 
/*     */ @Controller
/*     */ public class CreditReviewManage
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private CreditReviewService creditReviewService;
/*     */   @Resource
/*     */   private ClBorrowService clBorrowService;
/*     */   @Resource
/*     */   private SysUserService sysUserService;
/*     */   @Resource
/*     */   private ChannelService channelService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/credit/review/collection/member.htm"})
/*     */   @RequiresPermission(code="modules:manage:credit:review:member", name="信审人员统计列表")
/*     */   public void member(HttpServletResponse res, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  64 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  65 */     Page<CreditReviewTotalModel> page = this.creditReviewService.memberCount(params, current, pageSize);
/*  66 */     Map<String, Object> result = new HashMap();
/*  67 */     result.put("data", page);
/*  68 */     result.put("page", new RdPage(page));
/*  69 */     result.put("code", Integer.valueOf(200));
/*  70 */     result.put("msg", "获取成功");
/*     */     
/*  72 */     ServletUtils.writeToResponse(res, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/credit/review/channelUserList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:credit:review:channel:user:list", name="渠道人员、信审人员")
/*     */   public void reviewList(HttpServletResponse resp)
/*     */     throws Exception
/*     */   {
/*  85 */     Map<String, Object> param = new HashMap();
/*  86 */     param.put("roleName", "riskControl");
/*  87 */     List<Map<String, Object>> sys = this.sysUserService.getUserInfo(param);
/*  88 */     boolean flag = false;
/*     */     
/*  90 */     SysUser sysUser = getLoginUser(this.request);
/*  91 */     if ((sysUser != null) && 
/*  92 */       (sysUser.getId().longValue() == ((Long)((Map)sys.get(0)).get("id")).longValue())) {
/*  93 */       flag = true;
/*     */     }
/*     */     
/*     */ 
/*  97 */     Map<String, Object> params = new HashMap();
/*  98 */     params.put("roleName", "riskControlPersonnel");
/*  99 */     List<Map<String, Object>> sysList = this.sysUserService.getUserInfo(params);
/*     */     
/* 101 */     List<Channel> channelList = this.channelService.listChannel();
/* 102 */     Map<String, Object> res = new HashMap();
/* 103 */     res.put("sysList", sysList);
/* 104 */     res.put("channelList", channelList);
/* 105 */     res.put("flag", Boolean.valueOf(flag));
/* 106 */     Map<String, Object> result = new HashMap();
/* 107 */     result.put("data", res);
/* 108 */     result.put("code", Integer.valueOf(200));
/* 109 */     result.put("msg", "获取成功");
/* 110 */     ServletUtils.writeToResponse(resp, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/review/list.htm"})
/*     */   public void reviewList(HttpServletResponse res, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*     */     try
/*     */     {
/* 124 */       Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 125 */       if (params == null) {
/* 126 */         params = new HashMap();
/*     */       }
/* 128 */       params.put("roleName", "riskControl");
/* 129 */       List<Map<String, Object>> sysList = this.sysUserService.getUserInfo(params);
/*     */       
/* 131 */       SysUser sysUser = getLoginUser(this.request);
/* 132 */       if ((sysUser != null) && 
/* 133 */         (sysUser.getId().longValue() != 1L) && (sysUser.getId().longValue() != ((Long)((Map)sysList.get(0)).get("id")).longValue())) {
/* 134 */         params.put("sysUserId", sysUser.getId());
/*     */       }
/*     */       
/* 137 */       if (params.get("stateList") == null) {
/* 138 */         params.put("stateList", Arrays.asList(new String[] { "22", "27", "26", "90", 
/* 139 */           "30", "31", "40", "41", "50" }));
/*     */       } else {
/* 141 */         params.put("stateList", params.get("stateList").toString().split(","));
/*     */       }
/* 143 */       Page<ManageCreditReviewModel> page = this.clBorrowService.listReviewModel(params, currentPage, pageSize);
/* 144 */       Map<String, Object> result = new HashMap();
/* 145 */       result.put("data", page);
/* 146 */       result.put("page", new RdPage(page));
/* 147 */       result.put("code", Integer.valueOf(200));
/* 148 */       result.put("msg", "获取成功");
/* 149 */       ServletUtils.writeToResponse(res, result);
/*     */     } catch (ServiceException e) {
/* 151 */       e.printStackTrace();
/*     */     }
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
/*     */   @RequestMapping(value={"/modules/manage/credit/review/listLog.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:credit:review:listLog", name="人工复审记录列表")
/*     */   public void reviewListLog(HttpServletResponse res, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 168 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 169 */     if (params == null) {
/* 170 */       params = new HashMap();
/*     */     }
/* 172 */     params.put("roleName", "riskControl");
/* 173 */     List<Map<String, Object>> sysList = this.sysUserService.getUserInfo(params);
/*     */     
/* 175 */     SysUser sysUser = getLoginUser(this.request);
/* 176 */     if ((sysUser != null) && 
/* 177 */       (sysUser.getId().longValue() != 1L) && (sysUser.getId().longValue() != ((Long)((Map)sysList.get(0)).get("id")).longValue())) {
/* 178 */       params.put("sysUserId", sysUser.getId());
/*     */     }
/*     */     
/* 181 */     if (params.get("stateList") == null) {
/* 182 */       params.put("stateList", Arrays.asList(new String[] { "27", "26", "90", 
/* 183 */         "30", "31", "40", "41", "50" }));
/*     */     } else {
/* 185 */       params.put("stateList", params.get("stateList").toString().split(","));
/*     */     }
/* 187 */     Page<ManageCreditReviewModel> page = this.clBorrowService.listReviewModel(params, currentPage, pageSize);
/* 188 */     Map<String, Object> result = new HashMap();
/* 189 */     result.put("data", page);
/* 190 */     result.put("page", new RdPage(page));
/* 191 */     result.put("code", Integer.valueOf(200));
/* 192 */     result.put("msg", "获取成功");
/* 193 */     ServletUtils.writeToResponse(res, result);
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
/*     */   @RequestMapping(value={"/modules/manage/credit/review/giveList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:credit:review:giveList", name="信审订单派发列表")
/*     */   public void giveList(HttpServletResponse res, @RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 208 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 209 */     if (params == null) {
/* 210 */       params = new HashMap();
/*     */     }
/* 212 */     params.put("state", "22");
/* 213 */     Page<ManageCreditReviewModel> page = this.clBorrowService.listReviewModel(params, currentPage, pageSize);
/* 214 */     Map<String, Object> result = new HashMap();
/* 215 */     result.put("data", page);
/* 216 */     result.put("page", new RdPage(page));
/* 217 */     result.put("code", Integer.valueOf(200));
/* 218 */     result.put("msg", "获取成功");
/* 219 */     ServletUtils.writeToResponse(res, result);
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
/*     */   @RequestMapping(value={"/modules/manage/credit/review/allotUser.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:credit:review:allotUser", name="信审批量分配人员")
/*     */   public void allotUser(HttpServletResponse res, @RequestParam(value="id", required=false) String id, @RequestParam("sysUserId") String sysUserId)
/*     */     throws Exception
/*     */   {
/* 235 */     Map<String, Object> par = new HashMap();
/* 236 */     par.put("state", "22");
/*     */     
/* 238 */     par.put("giveStatus", "giveStatus");
/*     */     
/* 240 */     List<Long> list = this.clBorrowService.listOrder(par);
/* 241 */     if ((id == null) || ("".equals(id)))
/*     */     {
/* 243 */       if ((list == null) || (list.isEmpty())) {
/* 244 */         Map<String, Object> responseMap = new HashMap();
/* 245 */         responseMap.put("code", Integer.valueOf(400));
/* 246 */         responseMap.put("msg", "没有未分配的订单!");
/* 247 */         ServletUtils.writeToResponse(res, responseMap);
/* 248 */         return;
/*     */       }
/*     */       
/* 251 */       Map<String, Object> params = new HashMap();
/* 252 */       params.put("ids", "(" + sysUserId + ")");
/* 253 */       params.put("roleName", "riskControlPersonnel");
/* 254 */       List<Map<String, Object>> users = this.sysUserService.getUserInfo(params);
/*     */       
/* 256 */       this.clBorrowService.giveOrder(list, users);
/*     */     } else {
/* 258 */       Map<String, Object> params = new HashMap();
/* 259 */       params.put("id", id.split(",")[0]);
/* 260 */       params.put("sysUserId", sysUserId);
/* 261 */       this.clBorrowService.updateSelective(params);
/*     */     }
/*     */     
/* 264 */     Map<String, Object> responseMap = new HashMap();
/* 265 */     responseMap.put("code", Integer.valueOf(200));
/* 266 */     responseMap.put("msg", "操作成功");
/* 267 */     ServletUtils.writeToResponse(res, responseMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/credit/review/randomAllotUser.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void randomAllotUser(HttpServletResponse res)
/*     */     throws Exception
/*     */   {
/* 279 */     Map<String, Object> params = new HashMap();
/* 280 */     params.put("state", "22");
/*     */     
/* 282 */     params.put("giveStatus", "giveStatus");
/*     */     
/* 284 */     List<Long> list = this.clBorrowService.listOrder(params);
/* 285 */     if ((list == null) || (list.isEmpty())) {
/* 286 */       Map<String, Object> responseMap = new HashMap();
/* 287 */       responseMap.put("code", Integer.valueOf(400));
/* 288 */       responseMap.put("msg", "没有未分配的订单!");
/* 289 */       ServletUtils.writeToResponse(res, responseMap);
/* 290 */       return;
/*     */     }
/*     */     
/* 293 */     params.put("roleName", "riskControlPersonnel");
/* 294 */     params.put("status", "0");
/* 295 */     params.put("memberState", "2");
/* 296 */     List<Map<String, Object>> users = this.sysUserService.getUserInfo(params);
/* 297 */     if ((users == null) || (users.isEmpty())) {
/* 298 */       Map<String, Object> responseMap = new HashMap();
/* 299 */       responseMap.put("code", Integer.valueOf(400));
/* 300 */       responseMap.put("msg", "没有可分配的信审员!");
/* 301 */       ServletUtils.writeToResponse(res, responseMap);
/* 302 */       return;
/*     */     }
/*     */     
/* 305 */     this.clBorrowService.giveOrder(list, users);
/* 306 */     Map<String, Object> responseMap = new HashMap();
/* 307 */     responseMap.put("code", Integer.valueOf(200));
/* 308 */     responseMap.put("msg", "操作成功");
/* 309 */     ServletUtils.writeToResponse(res, responseMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/credit/review/export.htm"})
/*     */   public void urgeRepayOrderExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 320 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 321 */     List list = this.clBorrowService.listReview(params);
/* 322 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 323 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 325 */     String title = "信审人员Excel表";
/* 326 */     String[] hearders = ExportConstant.EXPORT_CREDIT_LIST_HEARDERS;
/* 327 */     String[] fields = ExportConstant.EXPORT_CREDIT_LIST_FIELDS;
/* 328 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 329 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\CreditReviewManage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */