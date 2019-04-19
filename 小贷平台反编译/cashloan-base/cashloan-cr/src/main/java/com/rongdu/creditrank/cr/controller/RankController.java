/*     */ package com.rongdu.creditrank.cr.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.creditrank.cr.domain.Rank;
/*     */ import com.rongdu.creditrank.cr.model.RankModel;
/*     */ import com.rongdu.creditrank.cr.service.RankService;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class RankController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private RankService rankService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cr/rank/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void page(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  49 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(search, Map.class);
/*  50 */     Page<Rank> page = this.rankService.page(searchMap, current, pageSize);
/*  51 */     Map<String, Object> result = new HashMap();
/*  52 */     result.put("data", page);
/*  53 */     result.put("page", new RdPage(page));
/*  54 */     result.put("code", Integer.valueOf(200));
/*  55 */     result.put("msg", "查询成功");
/*  56 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/rank/findAll.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void findAll()
/*     */     throws Exception
/*     */   {
/*  65 */     List<Rank> page = this.rankService.findAll();
/*  66 */     Map<String, Object> result = new HashMap();
/*  67 */     result.put("data", page);
/*  68 */     result.put("code", Integer.valueOf(200));
/*  69 */     result.put("msg", "查询成功");
/*  70 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/rank/getRankList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void getRankList(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  83 */     Map<String, Object> result = new HashMap();
/*  84 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(search, Map.class);
/*  85 */     Page<RankModel> page = this.rankService.countList(searchMap, current, pageSize);
/*  86 */     result.put("data", page);
/*  87 */     result.put("page", new RdPage(page));
/*  88 */     result.put("code", Integer.valueOf(200));
/*  89 */     result.put("msg", "查询成功");
/*  90 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/rank/delete.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void delete(@RequestParam("id") long id)
/*     */     throws Exception
/*     */   {
/* 100 */     Map<String, Object> result = this.rankService.deleteSelective(id);
/* 101 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cr/rank/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(@RequestParam("id") long id, @RequestParam("rankName") String rankName, @RequestParam("search") String search)
/*     */     throws Exception
/*     */   {
/* 114 */     List<Map<String, Object>> list = (List)JsonUtil.parse(search, List.class);
/* 115 */     Map<String, Object> result = this.rankService.save(list, rankName, id);
/* 116 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }
