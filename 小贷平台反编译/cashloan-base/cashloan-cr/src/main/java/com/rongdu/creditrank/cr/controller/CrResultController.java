/*    */ package com.rongdu.creditrank.cr.controller;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*    */ import com.rongdu.creditrank.cr.domain.CrResult;
/*    */ import com.rongdu.creditrank.cr.service.CrResultService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class CrResultController
/*    */   extends BaseController
/*    */ {
/*    */   @Resource
/*    */   private CrResultService crResultService;
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/cr/result/findUserResult.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void findUserResult(@RequestParam("userId") Long userId)
/*    */   {
/* 44 */     this.crResultService.findUserResult(userId);
/* 45 */     Map<String, Object> result = new HashMap();
/* 46 */     result.put("code", Integer.valueOf(200));
/* 47 */     result.put("msg", "获取成功");
/* 48 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/cr/result/findAllBorrowTypeResult.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void findAllBorrowTypeResult(@RequestParam("userId") Long userId) {
/* 53 */     List<CrResult> resultList = this.crResultService.findAllBorrowTypeResult(userId);
/* 54 */     Map<String, Object> result = new HashMap();
/* 55 */     result.put("data", resultList);
/* 56 */     result.put("code", Integer.valueOf(200));
/* 57 */     result.put("msg", "获取成功");
/* 58 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/cr/result/findBorrowTypeResult.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void findBorrowTypeResult(@RequestParam("userId") Long userId, @RequestParam("borrowTypeId") Long borrowTypeId)
/*    */   {
/* 64 */     List<CrResult> resultList = this.crResultService.findAllBorrowTypeResult(userId);
/* 65 */     Map<String, Object> result = new HashMap();
/* 66 */     result.put("data", resultList);
/* 67 */     result.put("code", Integer.valueOf(200));
/* 68 */     result.put("msg", "获取成功");
/* 69 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }
