/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.service.ClBorrowService;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
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
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class ManageReviewController
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private ClBorrowService clBorrowService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/review/findResult.htm"})
/*    */   public void findResult(@RequestParam("borrowId") long borrowId)
/*    */     throws Exception
/*    */   {
/* 44 */     Map<String, Object> data = this.clBorrowService.findResult(borrowId);
/* 45 */     Map<String, Object> result = new HashMap();
/* 46 */     result.put("data", data);
/* 47 */     result.put("code", Integer.valueOf(200));
/* 48 */     result.put("msg", "查询成功");
/* 49 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageReviewController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */