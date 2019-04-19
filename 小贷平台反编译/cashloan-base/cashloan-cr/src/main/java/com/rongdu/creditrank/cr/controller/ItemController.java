/*     */ package com.rongdu.creditrank.cr.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.creditrank.cr.model.FactorModel;
/*     */ import com.rongdu.creditrank.cr.model.FactorParamModel;
/*     */ import com.rongdu.creditrank.cr.model.ItemModel;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ItemController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private ItemService itemService;
/*     */   @Resource
/*     */   private CardService cardService;
/*     */   @Resource
/*     */   private FactorParamService factorParamService;
/*     */   @Resource
/*     */   private FactorService factorService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cr/item/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void page(@RequestParam(value="search", required=false) String secreditrankh, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  66 */     Map<String, Object> secreditrankhMap = (Map)JsonUtil.parse(secreditrankh, Map.class);
/*  67 */     Page<ItemModel> page = this.itemService.page(secreditrankhMap, current, pageSize);
/*  68 */     for (ItemModel itemModel : page) {
/*  69 */       Map<String, Object> factor = new HashMap();
/*  70 */       factor.put("itemId", itemModel.getId());
/*  71 */       List<FactorModel> FactorList = this.factorService.listFactorModel(factor);
/*     */       
/*  73 */       for (FactorModel factorModel : FactorList) {
/*  74 */         Map<String, Object> param = new HashMap();
/*  75 */         param.put("factorId", factorModel.getId());
/*  76 */         List<FactorParamModel> paramList = this.factorParamService.listSelect(param);
/*  77 */         factorModel.setChildren(paramList);
/*     */       }
/*  79 */       itemModel.setArticle("items");
/*  80 */       itemModel.setChildren(FactorList);
/*     */     }
/*  82 */     Map<String, Object> result = new HashMap();
/*  83 */     result.put("data", page);
/*  84 */     result.put("page", new RdPage(page));
/*  85 */     result.put("code", Integer.valueOf(200));
/*  86 */     result.put("msg", "查询成功");
/*  87 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/item/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(@RequestParam("itemName") String itemName, @RequestParam("cardId") long cardId)
/*     */     throws Exception
/*     */   {
/* 101 */     Map<String, Object> result = this.itemService.save(itemName, Long.valueOf(cardId));
/* 102 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/item/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void list(@RequestParam("cardId") long cardId)
/*     */     throws Exception
/*     */   {
/* 112 */     Map<String, Object> result = this.itemService.list(cardId);
/* 113 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/item/delete.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void delete(@RequestParam("id") long id)
/*     */     throws Exception
/*     */   {
/* 123 */     Map<String, Object> result = this.itemService.deleteSelective(id);
/* 124 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
