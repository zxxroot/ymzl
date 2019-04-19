/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.rc.service.ContactCountService;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
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
/*    */ @Controller
/*    */ @Scope("prototype")
/*    */ public class ContactCountController
/*    */   extends ManageBaseController
/*    */ {
/*    */   @Resource
/*    */   private ContactCountService contactCountService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/Contact/save.htm"})
/*    */   public void save()
/*    */     throws Exception
/*    */   {
/* 36 */     int msg = this.contactCountService.save();
/* 37 */     Map<String, Object> result = new HashMap();
/* 38 */     result.put("data", Integer.valueOf(msg));
/* 39 */     result.put("code", Integer.valueOf(200));
/* 40 */     result.put("msg", "查询成功");
/* 41 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ContactCountController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */