/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.cl.domain.QianchengReqlog;
/*    */ import com.rongdu.cashloan.cl.mapper.QianchengReqlogMapper;
/*    */ import com.rongdu.cashloan.cl.model.QianchengReqlogModel;
/*    */ import com.rongdu.cashloan.cl.service.QianchengReqlogService;
/*    */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
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
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class ManageQianchengReqlogController
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private QianchengReqlogService qianchengReqlogService;
/*    */   @Resource
/*    */   private QianchengReqlogMapper qianchengReqlogMapper;
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/borrow/qianchengReqLog/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @RequiresPermission(code="modules:manage:borrow:list", name="机审请求记录列表")
/*    */   public void list(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*    */   {
/* 56 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 57 */     Page<QianchengReqlogModel> page = this.qianchengReqlogService.listQianchengReqlog(params, current, pageSize);
/* 58 */     Map<String, Object> result = new HashMap();
/* 59 */     result.put("data", page);
/* 60 */     result.put("page", new RdPage(page));
/* 61 */     result.put("code", Integer.valueOf(200));
/* 62 */     result.put("msg", "获取成功");
/* 63 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping(value={"/modules/manage/borrow/qianchengReqLog/listByBorrow.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @RequiresPermission(code="modules:manage:borrow:qianchengReqLog:listByBorrow", name="机审请求记录列表")
/*    */   public void listByBorrow(@RequestParam("borrowId") Long borrowId)
/*    */   {
/* 75 */     QianchengReqlog log = this.qianchengReqlogService.findByBorrowId(borrowId);
/* 76 */     Map<String, Object> result = new HashMap();
/* 77 */     if (log != null)
/*    */     {
/* 79 */       result.put("data", log);
/* 80 */       result.put("code", Integer.valueOf(200));
/* 81 */       result.put("msg", "获取成功");
/* 82 */       ServletUtils.writeToResponse(this.response, result);
/*    */     } else {
/* 84 */       result.put("code", Integer.valueOf(400));
/* 85 */       result.put("msg", "获取失败");
/* 86 */       ServletUtils.writeToResponse(this.response, result);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageQianchengReqlogController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */