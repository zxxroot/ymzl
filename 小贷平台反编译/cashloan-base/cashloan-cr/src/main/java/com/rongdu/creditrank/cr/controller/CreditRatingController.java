/*    */ package com.rongdu.creditrank.cr.controller;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*    */ import com.rongdu.creditrank.cr.service.CreditRatingService;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
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
/*    */ public class CreditRatingController
/*    */   extends BaseController
/*    */ {
/*    */   @Resource
/*    */   private CreditRatingService creditRatingService;
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/cr/result/testCreditRating.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void testCreditRating()
/*    */     throws Exception
/*    */   {
/* 35 */     this.creditRatingService.saveCreditRating("1", Long.valueOf(7L));
/* 36 */     Map<String, Object> result = new HashMap();
/* 37 */     result.put("code", Integer.valueOf(200));
/* 38 */     result.put("msg", "获取成功");
/* 39 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }
