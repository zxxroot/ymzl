/*     */ package com.rongdu.creditrank.cr.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.creditrank.cr.domain.Card;
/*     */ import com.rongdu.creditrank.cr.service.CardService;
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
/*     */ public class CardController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private CardService cardService;
/*     */   @Resource
/*     */   private ItemService itemService;
/*     */   @Resource
/*     */   private FactorService factorService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cr/card/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void page(@RequestParam(value="search", required=false) String secreditrankh, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  61 */     Map<String, Object> secreditrankhMap = (Map)JsonUtil.parse(secreditrankh, Map.class);
/*  62 */     Page<Card> page = this.cardService.page(secreditrankhMap, current, pageSize);
/*  63 */     Map<String, Object> result = new HashMap();
/*  64 */     result.put("data", page);
/*  65 */     result.put("page", new RdPage(page));
/*  66 */     result.put("code", Integer.valueOf(200));
/*  67 */     result.put("msg", "查询成功");
/*  68 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/card/findAll.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void findAll()
/*     */     throws Exception
/*     */   {
/*  77 */     List<Card> list = this.cardService.findAll();
/*  78 */     Map<String, Object> result = new HashMap();
/*  79 */     result.put("data", list);
/*  80 */     result.put("code", Integer.valueOf(200));
/*  81 */     result.put("msg", "查询成功");
/*  82 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/card/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(@RequestParam("cardName") String cardName)
/*     */     throws Exception
/*     */   {
/*  94 */     Map<String, Object> result = this.cardService.save(cardName);
/*  95 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/card/update.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void update(@RequestParam("id") long id, @RequestParam("cardName") String cardName)
/*     */     throws Exception
/*     */   {
/* 108 */     Map<String, Object> result = this.cardService.update(id, cardName);
/* 109 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/card/updateState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateState(@RequestParam("id") long id, @RequestParam("state") String state)
/*     */     throws Exception
/*     */   {
/* 122 */     Map<String, Object> result = this.cardService.updateState(id, state);
/* 123 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
