/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.rongdu.cashloan.cl.domain.DhbBinding;
/*     */ import com.rongdu.cashloan.cl.domain.DhbHistoryOrg;
/*     */ import com.rongdu.cashloan.cl.domain.DhbHistorySearch;
/*     */ import com.rongdu.cashloan.cl.domain.DhbRiskBlacklist;
/*     */ import com.rongdu.cashloan.cl.domain.DhbRiskSocialNetwork;
/*     */ import com.rongdu.cashloan.cl.domain.DhbUserBasic;
/*     */ import com.rongdu.cashloan.cl.service.DhbBindingService;
/*     */ import com.rongdu.cashloan.cl.service.DhbHistoryOrgService;
/*     */ import com.rongdu.cashloan.cl.service.DhbHistorySearchService;
/*     */ import com.rongdu.cashloan.cl.service.DhbRiskBlacklistService;
/*     */ import com.rongdu.cashloan.cl.service.DhbRiskSocialNetworkService;
/*     */ import com.rongdu.cashloan.cl.service.DhbUserBasicService;
/*     */ import com.rongdu.cashloan.cl.service.YoudunUserFeaturesService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.core.model.ManagerUserModel;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class ManageDhbController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private UserBaseInfoService userBaseInfoService;
/*     */   @Resource
/*     */   private DhbBindingService dhbBindingService;
/*     */   @Resource
/*     */   private DhbHistoryOrgService dhbHistoryOrgService;
/*     */   @Resource
/*     */   private DhbHistorySearchService dhbHistorySearchService;
/*     */   @Resource
/*     */   private DhbRiskBlacklistService dhbRiskBlacklistService;
/*     */   @Resource
/*     */   private DhbRiskSocialNetworkService dhbRiskSocialNetworkService;
/*     */   @Resource
/*     */   private DhbUserBasicService dhbUserBasicService;
/*     */   @Resource
/*     */   private YoudunUserFeaturesService youdunUserFeaturesService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cl/dhb/detail.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void detail(@RequestParam("userId") Long userId)
/*     */   {
/*  70 */     ManagerUserModel user = this.userBaseInfoService.getBaseModelByUserId(userId);
/*  71 */     Map<String, Object> map = new HashMap();
/*  72 */     Map<String, Object> paramsMap = new HashMap();
/*  73 */     paramsMap.put("userId", userId);
/*  74 */     if (user != null)
/*     */     {
/*  76 */       map.put("user", user);
/*     */       
/*     */ 
/*  79 */       DhbUserBasic dhbUserBasic = this.dhbUserBasicService.findSelective(paramsMap);
/*  80 */       map.put("dhbUserBasic", dhbUserBasic);
/*     */       
/*     */ 
/*  83 */       DhbRiskSocialNetwork dhbRiskSocialNetwork = this.dhbRiskSocialNetworkService.findSelective(paramsMap);
/*  84 */       map.put("dhbRiskSocialNetwork", dhbRiskSocialNetwork);
/*     */       
/*     */ 
/*  87 */       DhbRiskBlacklist dhbRiskBlacklist = this.dhbRiskBlacklistService.findSelective(paramsMap);
/*  88 */       map.put("dhbRiskBlacklist", dhbRiskBlacklist);
/*     */       
/*     */ 
/*  91 */       DhbHistoryOrg dhbHistoryOrg = this.dhbHistoryOrgService.findSelective(paramsMap);
/*  92 */       map.put("dhbHistoryOrg", dhbHistoryOrg);
/*     */       
/*     */ 
/*  95 */       DhbHistorySearch dhbHistorySearch = this.dhbHistorySearchService.findSelective(paramsMap);
/*  96 */       map.put("dhbHistorySearch", dhbHistorySearch);
/*     */       
/*     */ 
/*  99 */       DhbBinding dhbBinding = this.dhbBindingService.findSelective(paramsMap);
/* 100 */       map.put("dhbBindingIdcards", JSONArray.parse(dhbBinding.getBindingIdcardsDetail()));
/* 101 */       map.put("dhbBindingPhone", JSONArray.parse(dhbBinding.getBindingPhonesDetail()));
/*     */     }
/* 103 */     Map<String, Object> result = new HashMap();
/* 104 */     result.put("data", map);
/* 105 */     result.put("code", Integer.valueOf(200));
/* 106 */     result.put("msg", "获取成功");
/* 107 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cl/youdun/youdunDetail.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void youdunDetail(@RequestParam(value="userId", required=true) Long userId)
/*     */     throws Exception
/*     */   {
/* 117 */     Map<String, Object> result = new HashMap();
/* 118 */     String type = Global.getValue("verify_type");
/* 119 */     Map<String, Object> map = new HashMap();
/* 120 */     if (!StringUtils.equalsIgnoreCase(type, "40")) {
/* 121 */       result.put("code", Integer.valueOf(400));
/* 122 */       result.put("msg", "系统配置出错，请联系管理员。");
/*     */     } else {
/* 124 */       map = this.youdunUserFeaturesService.udcredit(userId);
/*     */     }
/* 126 */     result.put("data", map);
/* 127 */     result.put("code", Integer.valueOf(200));
/* 128 */     result.put("msg", "获取成功");
/* 129 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageDhbController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */