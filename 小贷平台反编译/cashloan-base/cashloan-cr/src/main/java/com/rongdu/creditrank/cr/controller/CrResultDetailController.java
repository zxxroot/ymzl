/*    */ package com.rongdu.creditrank.cr.controller;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*    */ import com.rongdu.creditrank.cr.domain.CrResultDetail;
/*    */ import com.rongdu.creditrank.cr.model.CrResultDetailModel;
/*    */ import com.rongdu.creditrank.cr.service.CrResultDetailService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class CrResultDetailController
/*    */   extends BaseController
/*    */ {
/*    */   @Resource
/*    */   private CrResultDetailService crResultDetailService;
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/cr/resultDetail/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void page(@RequestParam(value="search", required=false) String secreditrankh, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*    */     throws Exception
/*    */   {
/* 57 */     Map<String, Object> secreditrankhMap = (Map)JsonUtil.parse(secreditrankh, Map.class);
/* 58 */     Page<CrResultDetail> page = this.crResultDetailService.page(secreditrankhMap, current, pageSize);
/* 59 */     Map<String, Object> result = new HashMap();
/* 60 */     result.put("data", page);
/* 61 */     result.put("page", new RdPage(page));
/* 62 */     result.put("code", Integer.valueOf(200));
/* 63 */     result.put("msg", "查询成功");
/* 64 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping(value={"/modules/manage/cr/resultDetail/detailTree.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void detailTree(@RequestParam("resultId") Long resultId)
/*    */   {
/* 73 */     List<CrResultDetailModel> detail = this.crResultDetailService.listDetailTree(resultId);
/* 74 */     Map<String, Object> result = new HashMap();
/* 75 */     result.put("data", JSONObject.toJSON(detail));
/* 76 */     result.put("code", Integer.valueOf(200));
/* 77 */     result.put("msg", "查询成功");
/* 78 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }
