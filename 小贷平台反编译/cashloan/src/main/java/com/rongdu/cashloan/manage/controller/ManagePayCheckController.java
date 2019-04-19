/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.cl.model.ManagePayCheckModel;
/*    */ import com.rongdu.cashloan.cl.service.PayCheckService;
/*    */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.util.StringUtils;
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
/*    */ @Controller
/*    */ @Scope("prototype")
/*    */ public class ManagePayCheckController
/*    */   extends ManageBaseController
/*    */ {
/* 40 */   private static final Logger logger = LoggerFactory.getLogger(ManagePayCheckController.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @Resource
/*    */   private PayCheckService payCheckService;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping({"/modules/manage/pay/check/page.htm"})
/*    */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*    */     throws Exception
/*    */   {
/* 60 */     Map<String, Object> searchMap = new HashMap();
/* 61 */     if (!StringUtils.isEmpty(search)) {
/* 62 */       searchMap = (Map)JsonUtil.parse(search, Map.class);
/*    */     }
/*    */     
/* 65 */     Page<ManagePayCheckModel> page = this.payCheckService.page(current, pageSize, searchMap);
/*    */     
/* 67 */     Map<String, Object> result = new HashMap();
/* 68 */     result.put("data", page);
/* 69 */     result.put("page", new RdPage(page));
/* 70 */     result.put("code", Integer.valueOf(200));
/* 71 */     result.put("msg", "查询成功");
/* 72 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManagePayCheckController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */