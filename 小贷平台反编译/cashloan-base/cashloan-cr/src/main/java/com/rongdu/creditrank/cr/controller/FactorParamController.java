/*    */ package com.rongdu.creditrank.cr.controller;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*    */ import com.rongdu.creditrank.cr.domain.FactorParam;
/*    */ import com.rongdu.creditrank.cr.service.FactorParamService;
/*    */ import com.rongdu.creditrank.cr.service.FactorService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class FactorParamController
/*    */   extends BaseController
/*    */ {
/*    */   @Resource
/*    */   private FactorParamService factorParamService;
/*    */   @Resource
/*    */   private FactorService factorService;
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/cr/factorParam/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void page(@RequestParam(value="search", required=false) String secreditrankh, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*    */     throws Exception
/*    */   {
/* 58 */     Map<String, Object> secreditrankhMap = (Map)JsonUtil.parse(secreditrankh, Map.class);
/* 59 */     Page<FactorParam> page = this.factorParamService.page(secreditrankhMap, current, pageSize);
/* 60 */     Map<String, Object> result = new HashMap();
/* 61 */     result.put("data", page);
/* 62 */     result.put("page", new RdPage(page));
/* 63 */     result.put("code", Integer.valueOf(200));
/* 64 */     result.put("msg", "查询成功");
/* 65 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping(value={"/modules/manage/cr/factorParam/delete.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void delete(@RequestParam("id") long id)
/*    */     throws Exception
/*    */   {
/* 77 */     Map<String, Object> result = this.factorParamService.deleteSelective(id);
/* 78 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }
