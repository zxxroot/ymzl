/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.google.common.base.Optional;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.system.domain.CheckAppVersion;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.CheckAppVersionService;
/*     */ import com.rongdu.cashloan.system.service.SysDictDetailService;
/*     */ import com.rongdu.cashloan.system.service.SysDictService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class SysCheckVersionController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private SysDictService sysDictService;
/*     */   @Resource
/*     */   private SysDictDetailService sysDictDetailService;
/*     */   @Autowired
/*     */   private CheckAppVersionService checkAppVersionService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/system/checkversion/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:checkversion:page", name=" 获取app版本控制列表")
/*     */   public void listDicts(HttpServletResponse response, HttpServletRequest request, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize, @RequestParam(value="search", required=false) String search)
/*     */     throws Exception
/*     */   {
/*  69 */     Map<String, Object> searchMap = new HashMap();
/*  70 */     if (search != null) {
/*  71 */       searchMap = (Map)JsonUtil.parse(search, Map.class);
/*     */     }
/*  73 */     Page<CheckAppVersion> page = this.checkAppVersionService.getPageList(current, pageSize, searchMap);
/*  74 */     Map<String, Object> result = new HashMap();
/*  75 */     result.put("data", page);
/*  76 */     result.put("page", new RdPage(page));
/*  77 */     result.put("code", Integer.valueOf(200));
/*  78 */     result.put("msg", "获取成功");
/*  79 */     ServletUtils.writeToResponse(response, result);
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
/*     */   @RequestMapping({"/modules/manage/system/checkversion/save.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:checkversion:detail:save", name="新增修改app版本控制详情")
/*     */   public void saveOrUpdateDictDetail(HttpServletResponse response, @RequestParam(value="data", required=false) String data, @RequestParam(value="status", required=false) String status)
/*     */     throws Exception
/*     */   {
/*  95 */     Map<String, Object> res = new HashMap();
/*  96 */     CheckAppVersion bean = (CheckAppVersion)JsonUtil.parse(data, CheckAppVersion.class);
/*  97 */     if ((Optional.fromNullable(bean).isPresent()) && (Optional.fromNullable(bean.getId()).isPresent()) && (StringUtils.equalsIgnoreCase(status, "update"))) {
/*  98 */       bean.setUpdateTime(new Date());
/*  99 */       this.checkAppVersionService.updateById(bean);
/* 100 */       res.put("code", Integer.valueOf(200));
/* 101 */       res.put("msg", "更新成功");
/*     */     } else {
/* 103 */       res.put("msg", "更新失败！");
/*     */     }
/* 105 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SysCheckVersionController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */