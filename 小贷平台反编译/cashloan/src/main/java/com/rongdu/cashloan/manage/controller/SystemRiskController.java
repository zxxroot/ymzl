/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.cl.model.DayPassApr;
/*    */ import com.rongdu.cashloan.cl.model.SystemDayData;
/*    */ import com.rongdu.cashloan.cl.service.SystemRcService;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import javax.servlet.http.HttpServletResponse;
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
/*    */ @Controller
/*    */ @Scope("prototype")
/*    */ public class SystemRiskController
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private SystemRcService systemRcService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/rc/dayData.htm"})
/*    */   public void dayData(HttpServletResponse response, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize, @RequestParam("search") String search)
/*    */     throws Exception
/*    */   {
/* 54 */     Map<String, Object> params = JSONObject.parseObject(search);
/* 55 */     Page<SystemDayData> page = this.systemRcService.findDayData(params, current, pageSize);
/* 56 */     Map<String, Object> result = new HashMap();
/* 57 */     result.put("data", page);
/* 58 */     result.put("page", new RdPage(page));
/* 59 */     result.put("code", Integer.valueOf(200));
/* 60 */     result.put("msg", "查询成功");
/* 61 */     ServletUtils.writeToResponse(response, result);
/*    */   }
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
/*    */   @RequestMapping({"/modules/manage/rc/dayApr.htm"})
/*    */   public void dayApr(HttpServletResponse response, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize, @RequestParam("search") String search)
/*    */     throws Exception
/*    */   {
/* 77 */     Map<String, Object> params = JSONObject.parseObject(search);
/* 78 */     Page<DayPassApr> page = this.systemRcService.findDayApr(params, current, pageSize);
/* 79 */     Map<String, Object> result = new HashMap();
/* 80 */     result.put("data", page);
/* 81 */     result.put("page", new RdPage(page));
/* 82 */     result.put("code", Integer.valueOf(200));
/* 83 */     result.put("msg", "查询成功");
/* 84 */     ServletUtils.writeToResponse(response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SystemRiskController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */