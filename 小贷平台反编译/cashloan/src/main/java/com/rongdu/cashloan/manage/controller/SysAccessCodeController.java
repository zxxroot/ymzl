/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.system.domain.SysAccessCode;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.model.SysAccessCodeModel;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysAccessCodeService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
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
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class SysAccessCodeController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private SysAccessCodeService sysAccessCodeService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/user/accessCode/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:accessCode:list", name="访问码信息列表")
/*     */   public void list(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  58 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  59 */     Page<SysAccessCodeModel> page = this.sysAccessCodeService.listAccessCodeModel(params, current, pageSize);
/*  60 */     Map<String, Object> result = new HashMap();
/*  61 */     result.put("data", page);
/*  62 */     result.put("page", new RdPage(page));
/*  63 */     result.put("code", Integer.valueOf(200));
/*  64 */     result.put("msg", "获取成功");
/*  65 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/user/accessCode/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:accessCode:add", name="新增访问码")
/*     */   public void add(@RequestParam("sysUserId") long sysUserId, @RequestParam("code") String code, @RequestParam("time") String time)
/*     */   {
/*  78 */     Map<String, Object> result = new HashMap();
/*  79 */     int codeCount = this.sysAccessCodeService.countCode(sysUserId, code);
/*  80 */     if (codeCount > 0) {
/*  81 */       result.put("code", Integer.valueOf(400));
/*  82 */       result.put("msg", "添加失败，该用户已存在此访问码，请重新输入访问码");
/*     */     } else {
/*  84 */       SysAccessCode accessCode = new SysAccessCode();
/*  85 */       accessCode.setSysUserId(Long.valueOf(sysUserId));
/*  86 */       accessCode.setCode(code);
/*  87 */       int msg = this.sysAccessCodeService.save(accessCode, time);
/*     */       
/*  89 */       if (msg > 0) {
/*  90 */         result.put("code", Integer.valueOf(200));
/*  91 */         result.put("msg", "添加成功");
/*     */       } else {
/*  93 */         result.put("code", Integer.valueOf(400));
/*  94 */         result.put("msg", "添加失败");
/*     */       }
/*     */     }
/*     */     
/*  98 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/user/accessCode/enable.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:accessCode:enable", name="访问码启用")
/*     */   public void enable(@RequestParam("id") Long id)
/*     */   {
/* 108 */     Map<String, Object> result = new HashMap();
/* 109 */     SysAccessCode accessCode = (SysAccessCode)this.sysAccessCodeService.getById(id);
/* 110 */     accessCode.setState("10");
/* 111 */     int msg = this.sysAccessCodeService.updateState(accessCode);
/* 112 */     if (msg > 0) {
/* 113 */       result.put("code", Integer.valueOf(200));
/* 114 */       result.put("msg", "启用成功");
/*     */     } else {
/* 116 */       result.put("code", Integer.valueOf(400));
/* 117 */       result.put("msg", "启用失败");
/*     */     }
/* 119 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/user/accessCode/disable.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:accessCode:disable", name="访问码禁用")
/*     */   public void disable(@RequestParam("id") Long id)
/*     */   {
/* 130 */     Map<String, Object> result = new HashMap();
/* 131 */     SysAccessCode accessCode = (SysAccessCode)this.sysAccessCodeService.getById(id);
/* 132 */     accessCode.setState("20");
/* 133 */     int msg = this.sysAccessCodeService.updateState(accessCode);
/* 134 */     if (msg > 0) {
/* 135 */       result.put("code", Integer.valueOf(200));
/* 136 */       result.put("msg", "禁用成功");
/*     */     } else {
/* 138 */       result.put("code", Integer.valueOf(400));
/* 139 */       result.put("msg", "禁用失败");
/*     */     }
/* 141 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/user/accessCode/modify.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:accessCode:modify", name="修改访问码")
/*     */   public void modify(@RequestParam("id") long id, @RequestParam("time") String time)
/*     */   {
/* 154 */     SysAccessCode accessCode = (SysAccessCode)this.sysAccessCodeService.getById(Long.valueOf(id));
/* 155 */     int msg = this.sysAccessCodeService.update(accessCode, time);
/* 156 */     Map<String, Object> result = new HashMap();
/* 157 */     if (msg > 0) {
/* 158 */       result.put("code", Integer.valueOf(200));
/* 159 */       result.put("msg", "操作成功");
/*     */     } else {
/* 161 */       result.put("code", Integer.valueOf(400));
/* 162 */       result.put("msg", "操作失败");
/*     */     }
/* 164 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/user/accessCode/listName.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:accessCode:listName", name="用户名列表")
/*     */   public void listUserName()
/*     */   {
/* 173 */     List<SysUser> list = this.sysAccessCodeService.listUserName();
/* 174 */     Map<String, Object> result = new HashMap();
/* 175 */     result.put("data", list);
/* 176 */     result.put("code", Integer.valueOf(200));
/* 177 */     result.put("msg", "获取成功");
/* 178 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SysAccessCodeController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */