/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.model.TongdunReqLogModel;
/*     */ import com.rongdu.cashloan.cl.service.TongdunReqLogService;
/*     */ import com.rongdu.cashloan.core.common.context.ExportConstant;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.excel.JsGridReportBase;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ManageTongdunController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private TongdunReqLogService tongdunReqLogService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/borrow/tongdun/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:tongdun:list", name="同盾机审请求记录列表")
/*     */   public void list(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  56 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  57 */     Page<TongdunReqLogModel> page = this.tongdunReqLogService.pageListModel(params, current, pageSize);
/*  58 */     Map<String, Object> result = new HashMap();
/*  59 */     result.put("data", page);
/*  60 */     result.put("page", new RdPage(page));
/*  61 */     result.put("code", Integer.valueOf(200));
/*  62 */     result.put("msg", "获取成功");
/*  63 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/tongdun/export.htm"})
/*     */   public void export(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/*  75 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  76 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/*  77 */     if (user != null) {
/*  78 */       List list = this.tongdunReqLogService.listByMap(params);
/*  79 */       this.response.setContentType("application/msexcel;charset=UTF-8");
/*  80 */       String title = "同盾机审请求记录";
/*  81 */       String[] hearders = ExportConstant.EXPORT_TONGDUNLOG_LIST_HEARDERS;
/*  82 */       String[] fields = ExportConstant.EXPORT_TONGDUNLOG_LIST_FIELDS;
/*  83 */       JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/*  84 */       report.exportExcel(list, title, hearders, fields, user.getName());
/*     */     } else {
/*  86 */       Map<String, Object> result = new HashMap();
/*  87 */       result.put("code", Integer.valueOf(400));
/*  88 */       result.put("msg", "登录超时,请重新登录");
/*  89 */       ServletUtils.writeToResponse(this.response, result);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/tongdun/detail.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:tongdun:detail", name="同盾机审详细内容")
/*     */   public void detail(@RequestParam("id") long id)
/*     */   {
/* 100 */     TongdunReqLogModel model = this.tongdunReqLogService.getModelById(id);
/* 101 */     Map<String, Object> result = new HashMap();
/* 102 */     result.put("data", model);
/* 103 */     result.put("code", Integer.valueOf(200));
/* 104 */     result.put("msg", "获取成功");
/* 105 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageTongdunController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */