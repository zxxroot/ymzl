/*    */ package com.rongdu.creditrank.cr.controller;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*    */ import com.rongdu.cashloan.core.common.util.RdPage;
/*    */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*    */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*    */ import com.rongdu.creditrank.cr.domain.RankDetail;
/*    */ import com.rongdu.creditrank.cr.service.RankDetailService;
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
/*    */ @Scope("prototype")
/*    */ @Controller
/*    */ public class RankDetailController
/*    */   extends BaseController
/*    */ {
/*    */   @Resource
/*    */   private RankDetailService rankDetailService;
/*    */   
/*    */   @RequestMapping(value={"/modules/manage/cr/rankDetail/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*    */     throws Exception
/*    */   {
/* 48 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(search, Map.class);
/* 49 */     Page<RankDetail> page = this.rankDetailService.page(searchMap, current, pageSize);
/* 50 */     Map<String, Object> result = new HashMap();
/* 51 */     result.put("data", page);
/* 52 */     result.put("page", new RdPage(page));
/* 53 */     result.put("code", Integer.valueOf(200));
/* 54 */     result.put("msg", "查询成功");
/* 55 */     ServletUtils.writeToResponse(this.response, result);
/*    */   }
/*    */ }
