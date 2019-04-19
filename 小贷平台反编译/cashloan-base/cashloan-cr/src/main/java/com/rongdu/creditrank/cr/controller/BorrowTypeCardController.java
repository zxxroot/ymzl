/*     */ package com.rongdu.creditrank.cr.controller;
/*     */ 
/*     */

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.util.JsonUtil;
import com.rongdu.cashloan.core.common.util.RdPage;
import com.rongdu.cashloan.core.common.util.ServletUtils;
import com.rongdu.cashloan.core.common.web.controller.BaseController;
import com.rongdu.creditrank.cr.domain.BorrowTypeCard;
import com.rongdu.creditrank.cr.service.BorrowTypeCardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
/*     */ @Controller
/*     */ public class BorrowTypeCardController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private BorrowTypeCardService borrowTypeCardService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cr/borrowTypeCard/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void page(@RequestParam(value="search", required=false) String secreditrankh, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  52 */     Map<String, Object> secreditrankhMap = (Map)JsonUtil.parse(secreditrankh, Map.class);
/*  53 */     Page<BorrowTypeCard> page = this.borrowTypeCardService.page(secreditrankhMap, current, pageSize);
/*  54 */     Map<String, Object> result = new HashMap();
/*  55 */     result.put("data", page);
/*  56 */     result.put("page", new RdPage(page));
/*  57 */     result.put("code", Integer.valueOf(200));
/*  58 */     result.put("msg", "查询成功");
/*  59 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
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
/*     */   @RequestMapping(value={"/modules/manage/cr/borrowTypeCard/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(@RequestParam("borrowTypeId") long borrowTypeId, @RequestParam("borrowTypeName") String borrowTypeName, @RequestParam("cardId") long cardId, @RequestParam("cardName") String cardName)
/*     */     throws Exception
/*     */   {
/*  77 */     int msg = this.borrowTypeCardService.save(borrowTypeId, borrowTypeName, cardId, cardName);
/*  78 */     Map<String, Object> result = new HashMap();
/*  79 */     if (msg > 0) {
/*  80 */       result.put("code", Integer.valueOf(200));
/*  81 */       result.put("msg", "成功");
/*     */     } else {
/*  83 */       result.put("code", Integer.valueOf(400));
/*  84 */       result.put("msg", "成功");
/*     */     }
/*  86 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
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
/*     */   @RequestMapping(value={"/modules/manage/cr/borrowTypeCard/update.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void update(@RequestParam("id") long id, @RequestParam("borrowTypeId") long borrowTypeId, @RequestParam("borrowTypeName") String borrowTypeName, @RequestParam("cardId") long cardId, @RequestParam("cardName") String cardName)
/*     */     throws Exception
/*     */   {
/* 106 */     int msg = this.borrowTypeCardService.update(id, borrowTypeId, borrowTypeName, cardId, cardName);
/* 107 */     Map<String, Object> result = new HashMap();
/* 108 */     if (msg > 0) {
/* 109 */       result.put("code", Integer.valueOf(200));
/* 110 */       result.put("msg", "成功");
/*     */     } else {
/* 112 */       result.put("code", Integer.valueOf(400));
/* 113 */       result.put("msg", "成功");
/*     */     }
/* 115 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
