/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*    */ import com.rongdu.cashloan.manage.model.QuartzLogModel;
/*    */ import com.rongdu.cashloan.manage.service.QuartzLogService;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import tool.util.BeanUtil;
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
/*    */ 
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class QuartzLogController
/*    */   extends BaseController
/*    */ {
/*    */   @Resource
/*    */   private QuartzLogService quartzLogService;
/*    */   
/*    */   @RequestMapping({"/modules/quartzLog/page.htm"})
/*    */   public void quartzLog(@RequestParam("search") String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*    */     throws Exception
/*    */   {
/* 55 */     QuartzLogService quartzLogService = (QuartzLogService)BeanUtil.getBean("quartzLogService");
/* 56 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(search, Map.class);
/* 57 */     Page<QuartzLogModel> page = quartzLogService.page(searchMap, current, pageSize);
/* 58 */     Map<String, Object> result = new HashMap();
/* 59 */     result.put("data", page);
/* 60 */     result.put("page", new RdPage(page));
/* 61 */     result.put("code", Integer.valueOf(200));
/* 62 */     result.put("msg", "查询成功");
/* 63 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\QuartzLogController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */