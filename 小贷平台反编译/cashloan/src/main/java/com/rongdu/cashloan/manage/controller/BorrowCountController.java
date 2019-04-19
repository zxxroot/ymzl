/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class BorrowCountController
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private BorrowCountService borrowCountService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/borrow/save.htm"})
/*    */   public void save()
/*    */     throws Exception
/*    */   {
/* 36 */     int msg = this.borrowCountService.save();
/* 37 */     Map<String, Object> result = new HashMap();
/* 38 */     result.put("data", Integer.valueOf(msg));
/* 39 */     result.put("code", Integer.valueOf(200));
/* 40 */     result.put("msg", "查询成功");
/* 41 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\BorrowCountController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */