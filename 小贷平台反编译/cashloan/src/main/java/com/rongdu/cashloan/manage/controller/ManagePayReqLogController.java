/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.cl.model.ManagePayReqLogModel;
/*    */ import com.rongdu.cashloan.cl.service.PayReqLogService;
/*    */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
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
/*    */ public class ManagePayReqLogController
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private PayReqLogService payReqLogService;
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/pay/reqLog/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*    */     throws Exception
/*    */   {
/* 56 */     Map<String, Object> searchMap = new HashMap();
/* 57 */     if (!StringUtils.isEmpty(search)) {
/* 58 */       searchMap = (Map)JsonUtil.parse(search, Map.class);
/*    */     }
/*    */     
/* 61 */     Page<ManagePayReqLogModel> page = this.payReqLogService.page(current, pageSize, 
/* 62 */       searchMap);
/*    */     
/* 64 */     Map<String, Object> result = new HashMap();
/* 65 */     result.put("data", page);
/* 66 */     result.put("page", new RdPage(page));
/* 67 */     result.put("code", Integer.valueOf(200));
/* 68 */     result.put("msg", "查询成功");
/* 69 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManagePayReqLogController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */