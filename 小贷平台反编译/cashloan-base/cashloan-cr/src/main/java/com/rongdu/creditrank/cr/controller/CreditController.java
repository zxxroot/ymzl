/*     */ package com.rongdu.creditrank.cr.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.creditrank.cr.domain.Credit;
/*     */ import com.rongdu.creditrank.cr.model.CreditModel;
/*     */ import com.rongdu.creditrank.cr.service.CreditLogService;
/*     */ import com.rongdu.creditrank.cr.service.CreditService;
/*     */ import java.util.HashMap;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class CreditController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private CreditService creditService;
/*     */   @Resource
/*     */   private CreditLogService creditLogService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/user/credit/page.htm"})
/*     */   @RequiresPermission(code="modules:manage:user:credit:page", name="查询用户额度列表")
/*     */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  60 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(search, Map.class);
/*  61 */     Page<CreditModel> page = this.creditService.page(searchMap, current, pageSize);
/*  62 */     Map<String, Object> result = new HashMap();
/*  63 */     result.put("data", page);
/*  64 */     result.put("page", new RdPage(page));
/*  65 */     result.put("code", Integer.valueOf(200));
/*  66 */     result.put("msg", "查询成功");
/*  67 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/user/credit/findByConsumerNo.htm"})
/*     */   @RequiresPermission(code="modules:manage:user:credit:findByConsumerNo", name="查询用户额度详情")
/*     */   public void findByConsumerNo(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  82 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(search, Map.class);
/*  83 */     Page<CreditModel> page = this.creditService.listAll(searchMap, current, pageSize);
/*  84 */     Map<String, Object> result = new HashMap();
/*  85 */     result.put("data", page);
/*  86 */     result.put("page", new RdPage(page));
/*  87 */     result.put("code", Integer.valueOf(200));
/*  88 */     result.put("msg", "查询成功");
/*  89 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/user/credit/updateTotal.htm"})
/*     */   @RequiresPermission(code="modules:manage:user:credit:updateTotal", name="调整用户授信额度")
/*     */   public void updateTotal(@RequestParam("id") long id, @RequestParam("unuse") Double unuse, @RequestParam("remark") String remark)
/*     */     throws Exception
/*     */   {
/* 105 */     SysUser sysUser = getLoginUser(this.request);
/* 106 */     int msg = this.creditService.updateSelective(id, unuse.doubleValue(), sysUser, remark);
/* 107 */     Map<String, Object> result = new HashMap();
/* 108 */     if (msg > 0) {
/* 109 */       result.put("code", Integer.valueOf(200));
/* 110 */       result.put("msg", "操作成功");
/*     */     } else {
/* 112 */       result.put("code", Integer.valueOf(400));
/* 113 */       result.put("msg", "操作失败");
/*     */     }
/*     */     
/* 116 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/user/credit/updateState.htm"})
/*     */   @RequiresPermission(code="modules:manage:user:credit:updateState", name="冻结解冻账户")
/*     */   public void updateState(@RequestParam("id") long id, @RequestParam("state") String state)
/*     */     throws Exception
/*     */   {
/* 130 */     Credit credit = this.creditService.findByPrimary(id);
/* 131 */     Map<String, Object> result = new HashMap();
/* 132 */     if (credit.getState().equals(state)) {
/* 133 */       result.put("code", Integer.valueOf(400));
/* 134 */       result.put("msg", "操作失败,已经是此状态!");
/*     */     } else {
/* 136 */       SysUser sysUser = getLoginUser(this.request);
/* 137 */       int msg = this.creditService.updateState(id, state, sysUser);
/* 138 */       if (msg > 0) {
/* 139 */         result.put("code", Integer.valueOf(200));
/* 140 */         result.put("msg", "操作成功");
/*     */       } else {
/* 142 */         result.put("code", Integer.valueOf(400));
/* 143 */         result.put("msg", "操作失败");
/*     */       }
/*     */     }
/* 146 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
