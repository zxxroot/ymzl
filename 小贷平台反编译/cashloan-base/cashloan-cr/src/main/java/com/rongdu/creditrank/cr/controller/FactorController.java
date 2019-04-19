/*     */ package com.rongdu.creditrank.cr.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.creditrank.cr.model.FactorModel;
/*     */ import com.rongdu.creditrank.cr.model.FactorParamModel;
/*     */ import com.rongdu.creditrank.cr.service.CardService;
/*     */ import com.rongdu.creditrank.cr.service.FactorParamService;
/*     */ import com.rongdu.creditrank.cr.service.FactorService;
/*     */ import com.rongdu.creditrank.cr.service.ItemService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class FactorController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private FactorService factorService;
/*     */   @Resource
/*     */   private FactorParamService factorParamService;
/*     */   @Resource
/*     */   private ItemService itemService;
/*     */   @Resource
/*     */   private CardService cardService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cr/factor/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void page(@RequestParam(value="secreditrankh", required=false) String secreditrankh, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  69 */     Map<String, Object> secreditrankhMap = (Map)JsonUtil.parse(secreditrankh, Map.class);
/*  70 */     Page<FactorModel> page = this.factorService.page(secreditrankhMap, current, pageSize);
/*  71 */     for (FactorModel factorModel : page) {
/*  72 */       factorModel.setTab(factorModel.getCtable() + "," + factorModel.getCcolumn());
/*  73 */       Map<String, Object> param = new HashMap();
/*  74 */       param.put("factorId", factorModel.getId());
/*  75 */       List<FactorParamModel> paramList = this.factorParamService.listSelect(param);
/*  76 */       factorModel.setChildren(paramList);
/*     */     }
/*  78 */     Map<String, Object> result = new HashMap();
/*  79 */     result.put("data", page);
/*  80 */     result.put("page", new RdPage(page));
/*  81 */     result.put("code", Integer.valueOf(200));
/*  82 */     result.put("msg", "查询成功");
/*  83 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/factor/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(@RequestParam("factorModel") String factorModel, @RequestParam("secreditrankh") String secreditrankh)
/*     */     throws Exception
/*     */   {
/*  96 */     List<Map<String, Object>> list = (List)JsonUtil.parse(secreditrankh, List.class);
/*  97 */     Map<String, Object> factorMap = (Map)JsonUtil.parse(factorModel, Map.class);
/*     */     
/*  99 */     Map<String, Object> result = this.factorService.save(factorMap, list);
/* 100 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/factor/update.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void update(@RequestParam("factorModel") String factorModel, @RequestParam(value="secreditrankh", required=false) String secreditrankh)
/*     */     throws Exception
/*     */   {
/* 113 */     List<Map<String, Object>> list = (List)JsonUtil.parse(secreditrankh, List.class);
/* 114 */     Map<String, Object> factorMap = (Map)JsonUtil.parse(factorModel, Map.class);
/* 115 */     Map<String, Object> result = this.factorService.updateSelective(factorMap, list);
/* 116 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/factor/delete.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void delete(@RequestParam("id") long id)
/*     */     throws Exception
/*     */   {
/* 127 */     Map<String, Object> result = this.factorService.deleteSelective(id);
/* 128 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
