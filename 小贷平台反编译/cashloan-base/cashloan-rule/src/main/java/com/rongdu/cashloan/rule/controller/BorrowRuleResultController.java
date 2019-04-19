/*    */ package com.rongdu.cashloan.rule.controller;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*    */ import com.rongdu.cashloan.rule.domain.BorrowRuleResult;
/*    */ import com.rongdu.cashloan.rule.service.BorrowRuleResultService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @Scope("prototype")
/*    */ public class BorrowRuleResultController
/*    */   extends BaseController
/*    */ {
/*    */   @Resource
/*    */   private BorrowRuleResultService borrowRuleResultService;
/*    */   
/*    */   @RequestMapping({"/modules/manage/borrow/borrowRuleResult.htm"})
/*    */   public void borrowRuleResult(@RequestParam(value="borrowId", required=false) String borrowId, @RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize)
/*    */   {
/* 50 */     Map<String, Object> params = new HashMap();
/* 51 */     params.put("borrowId", borrowId);
/* 52 */     Page<BorrowRuleResult> page = this.borrowRuleResultService.borrowRuleResult(params, currentPage, pageSize);
/*    */     
/* 54 */     Map<String, Object> result = new HashMap();
/* 55 */     result.put("data", page);
/* 56 */     result.put("page", new RdPage(page));
/* 57 */     result.put("code", Integer.valueOf(200));
/* 58 */     result.put("msg", "获取成功");
/* 59 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\controller\BorrowRuleResultController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */