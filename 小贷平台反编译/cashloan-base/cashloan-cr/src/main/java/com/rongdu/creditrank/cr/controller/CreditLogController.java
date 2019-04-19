/*    */ package com.rongdu.creditrank.cr.controller;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*    */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*    */ import com.rongdu.cashloan.system.service.SysDictDetailService;
/*    */ import com.rongdu.creditrank.cr.model.CreditLogModel;
/*    */ import com.rongdu.creditrank.cr.service.CreditLogService;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class CreditLogController
/*    */   extends BaseController
/*    */ {
/*    */   @Resource
/*    */   private CreditLogService creditLogService;
/*    */   @Resource
/*    */   private SysDictDetailService sysDictDetailService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/user/creditLog/page.htm"})
/*    */   @RequiresPermission(code="modules:manage:user:creditLog:page", name="查询用户额度变动记录列表")
/*    */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*    */     throws Exception
/*    */   {
/* 58 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(search, Map.class);
/* 59 */     Page<CreditLogModel> page = this.creditLogService.page(searchMap, current, pageSize);
/* 60 */     Map<String, Object> result = new HashMap();
/* 61 */     result.put("data", page);
/* 62 */     result.put("page", new RdPage(page));
/* 63 */     result.put("code", Integer.valueOf(200));
/* 64 */     result.put("msg", "查询成功");
/* 65 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }
