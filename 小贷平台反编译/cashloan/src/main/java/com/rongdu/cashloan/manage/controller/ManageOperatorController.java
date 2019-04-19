/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.rongdu.cashloan.cl.domain.OperatorCellBehavior;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorRepApplicationCheck;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorRepBehaviorCheck;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorRepContactRegion;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorRepPerson;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorRepTripInfo;
/*     */ import com.rongdu.cashloan.cl.domain.OperatorVoicesContact;
/*     */ import com.rongdu.cashloan.cl.service.OperatorCellBehaviorService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorRepApplicationCheckService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorRepBehaviorCheckService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorRepContactRegionService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorRepMainService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorRepPersonService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorRepTripInfoService;
/*     */ import com.rongdu.cashloan.cl.service.OperatorVoicesContactService;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.core.model.ManagerUserModel;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ManageOperatorController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private UserBaseInfoService userBaseInfoService;
/*     */   @Resource
/*     */   private OperatorRepApplicationCheckService operatorRepApplicationCheckService;
/*     */   @Resource
/*     */   private OperatorRepBehaviorCheckService operatorRepBehaviorCheckService;
/*     */   @Resource
/*     */   private OperatorRepContactRegionService operatorRepContactRegionService;
/*     */   @Resource
/*     */   private OperatorRepMainService operatorRepMainService;
/*     */   @Resource
/*     */   private OperatorRepPersonService operatorRepPersonService;
/*     */   @Resource
/*     */   private OperatorRepTripInfoService operatorRepTripInfoService;
/*     */   @Resource
/*     */   private OperatorCellBehaviorService operatorCellBehaviorService;
/*     */   @Resource
/*     */   private OperatorVoicesContactService operatorVoicesContactService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cl/hulu/operator/detail.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void detail(@RequestParam("userId") Long userId)
/*     */   {
/*  81 */     ManagerUserModel user = this.userBaseInfoService.getBaseModelByUserId(userId);
/*  82 */     Map<String, Object> map = new HashMap();
/*  83 */     Map<String, Object> paramsMap = new HashMap();
/*  84 */     paramsMap.put("userId", userId);
/*  85 */     if (user != null)
/*     */     {
/*     */ 
/*  88 */       OperatorRepPerson operatorRepPerson = this.operatorRepPersonService.findSelective(paramsMap);
/*  89 */       map.put("person", operatorRepPerson);
/*     */       
/*     */ 
/*  92 */       List<OperatorRepApplicationCheck> applicationCheck = this.operatorRepApplicationCheckService.listSelective(paramsMap);
/*  93 */       map.put("applicationCheck", applicationCheck);
/*     */       
/*     */ 
/*  96 */       List<OperatorRepBehaviorCheck> operatorRepBehaviorCheck = this.operatorRepBehaviorCheckService.listSelective(paramsMap);
/*  97 */       map.put("behaviorCheck", operatorRepBehaviorCheck);
/*     */       
/*     */ 
/* 100 */       List<OperatorVoicesContact> operatorVoicesContact = this.operatorVoicesContactService.listSelective(paramsMap);
/* 101 */       map.put("voicesContact", operatorVoicesContact);
/*     */       
/*     */ 
/* 104 */       List<OperatorRepContactRegion> operatorRepContactRegion = this.operatorRepContactRegionService.listSelective(paramsMap);
/* 105 */       map.put("contactRegion", operatorRepContactRegion);
/*     */       
/*     */ 
/* 108 */       List<OperatorCellBehavior> operatorCellBehavior = this.operatorCellBehaviorService.listSelective(paramsMap);
/* 109 */       map.put("cellBehavior", operatorCellBehavior);
/*     */       
/*     */ 
/* 112 */       List<OperatorRepTripInfo> operatorRepTripInfo = this.operatorRepTripInfoService.listSelective(paramsMap);
/* 113 */       map.put("tripInfo", operatorRepTripInfo);
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 150 */     Map<String, Object> result = new HashMap();
/* 151 */     result.put("data", map);
/* 152 */     result.put("code", Integer.valueOf(200));
/* 153 */     result.put("msg", "获取成功");
/* 154 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageOperatorController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */