/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.service.SystemCountService;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
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
/*    */ public class SystemCountController
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private SystemCountService systemCountService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/count/homeInfo.htm"})
/*    */   public void homeInfo(HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 41 */     Map<String, Object> data = this.systemCountService.systemCount();
/* 42 */     Map<String, Object> result = new HashMap();
/* 43 */     result.put("data", data);
/* 44 */     result.put("code", Integer.valueOf(200));
/* 45 */     result.put("msg", "查询成功");
/* 46 */     ServletUtils.writeToResponse(response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SystemCountController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */