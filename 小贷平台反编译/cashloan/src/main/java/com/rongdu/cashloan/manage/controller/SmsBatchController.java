/*    */ package com.rongdu.cashloan.manage.controller;
/*    */ 
/*    */ import com.rongdu.cashloan.cl.service.ClSmsService;
/*    */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
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
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class SmsBatchController
/*    */ {
/* 27 */   private static final Logger logger = Logger.getLogger(SmsBatchController.class);
/*    */   
/*    */   private UserBaseInfoService userBaseInfoService;
/*    */   private ClSmsService clSmsService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/smsBatch.htm"})
/*    */   public void activity()
/*    */   {
/* 35 */     int succeed = 0;
/* 36 */     int fail = 0;
/* 37 */     int total = 0;
/* 38 */     String tpl = "【袋鼠现金】恭喜您！在本平台连续主动还款未逾期，已获得提额5000元，限时7日.请在近期一次还款后，申请借款. https://fir.im/ge165领取";
/*    */     
/*    */ 
/*    */ 
/* 42 */     List<String> phones = this.userBaseInfoService.getUnRepayPhone();
/* 43 */     Map<String, Integer> result = this.clSmsService.sendBatchSms(phones, tpl);
/* 44 */     logger.info("共需要发" + result.get("total") + "条，成功" + result.get("success条"));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/modules/manage/smstest.htm"})
/*    */   public void test()
/*    */   {
/* 50 */     int succeed = 0;
/* 51 */     int fail = 0;
/* 52 */     int total = 0;
/* 53 */     String tpl = "尊敬的用户,您{$platform}借款{$loan}元,现已未还款{$overdueDay}天,违约金额为{$amercement}元,请尽快还款!";
/*    */     
/*    */ 
/*    */ 
/* 57 */     List<String> phones = new ArrayList();
/* 58 */     phones.add("");
/* 59 */     Map<String, Integer> result = this.clSmsService.sendBatchSms(phones, tpl);
/* 60 */     logger.info("共需要发" + result.get("total") + "条，成功" + result.get("success") + "条");
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SmsBatchController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */