/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.Opinion;
/*     */ import com.rongdu.cashloan.cl.model.OpinionModel;
/*     */ import com.rongdu.cashloan.cl.service.OpinionService;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.util.StringUtils;
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
/*     */ public class ManageOpinionController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private OpinionService opinionService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/mine/opinion/page.htm"})
/*     */   public void page(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  50 */     Map<String, Object> searchMap = new HashMap();
/*  51 */     if (!StringUtils.isEmpty(searchParams)) {
/*  52 */       searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/*  54 */     Page<OpinionModel> page = this.opinionService.page(searchMap, current, pageSize);
/*  55 */     Map<String, Object> resultMap = new HashMap();
/*  56 */     Map<String, Object> data = new HashMap();
/*  57 */     data.put("list", page);
/*  58 */     resultMap.put("data", data);
/*  59 */     resultMap.put("page", new RdPage(page));
/*  60 */     resultMap.put("code", Integer.valueOf(200));
/*  61 */     resultMap.put("msg", "查询成功");
/*  62 */     ServletUtils.writeToResponse(this.response, resultMap);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/modules/manage/mine/opinion/view.htm"})
/*     */   public void view(@RequestParam(value="id", required=false) Long id) throws Exception {
/*  67 */     Map<String, Object> resultMap = new HashMap();
/*  68 */     Opinion opinion = (Opinion)this.opinionService.getById(id);
/*  69 */     if (opinion != null) {
/*  70 */       resultMap.put("data", opinion);
/*  71 */       resultMap.put("code", Integer.valueOf(200));
/*  72 */       resultMap.put("msg", "查询成功");
/*     */     } else {
/*  74 */       resultMap.put("code", Integer.valueOf(400));
/*  75 */       resultMap.put("msg", "获取意见反馈失败");
/*     */     }
/*  77 */     ServletUtils.writeToResponse(this.response, resultMap);
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/mine/opinion/confirm.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void opinionConfirm(@RequestParam(value="id", required=true) Long id, @RequestParam(value="feedback", required=true) String feedback)
/*     */     throws Exception
/*     */   {
/*  85 */     Map<String, Object> paramMap = new HashMap();
/*  86 */     Map<String, Object> resultMap = new HashMap();
/*  87 */     SysUser user = getLoginUser(this.request);
/*  88 */     if (user != null) {
/*  89 */       paramMap.put("id", id);
/*  90 */       paramMap.put("sysUserId", getLoginUser(this.request).getId());
/*  91 */       paramMap.put("feedback", feedback);
/*  92 */       paramMap.put("confirmTime", DateUtil.dateStr3(DateUtil.getNow()));
/*  93 */       paramMap.put("state", "20");
/*  94 */       int result = this.opinionService.updateSelective(paramMap);
/*  95 */       if (result == 1) {
/*  96 */         resultMap.put("code", Integer.valueOf(200));
/*  97 */         resultMap.put("msg", "处理成功");
/*     */       } else {
/*  99 */         resultMap.put("code", Integer.valueOf(400));
/* 100 */         resultMap.put("msg", "处理失败");
/*     */       }
/*     */     } else {
/* 103 */       resultMap.put("code", Integer.valueOf(400));
/* 104 */       resultMap.put("msg", "处理失败,登陆已失效");
/*     */     }
/* 106 */     ServletUtils.writeToResponse(this.response, resultMap);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageOpinionController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */