/*     */ package com.rongdu.creditrank.cr.controller;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.creditrank.cr.domain.CreditType;
/*     */ import com.rongdu.creditrank.cr.model.CreditRatingModel;
/*     */ import com.rongdu.creditrank.cr.model.CreditTypeModel;
/*     */ import com.rongdu.creditrank.cr.service.CreditTypeService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.StringUtil;
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
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class CreditTypeController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private CreditTypeService creditTypeService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/cr/creditType/creditTypeList.htm"})
/*     */   public void creditTypeList()
/*     */     throws Exception
/*     */   {
/*  50 */     Map<String, Object> result = new HashMap();
/*  51 */     List<CreditTypeModel> list = this.creditTypeService.findAllCreditType();
/*  52 */     result.put("data", list);
/*  53 */     result.put("code", Integer.valueOf(200));
/*  54 */     result.put("msg", "查询成功");
/*  55 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/cr/creditType/saveCreditType.htm"})
/*     */   public void saveCreditType(@RequestParam("cardId") String cardId, @RequestParam("rankId") String rankId, @RequestParam("borrowTypeId") String borrowTypeId, @RequestParam("creditTypeId") Long creditTypeId, @RequestParam("name") String name)
/*     */     throws Exception
/*     */   {
/*  71 */     Map<String, Object> result = new HashMap();
/*  72 */     int rtValue = 0;
/*     */     
/*  74 */     if ((StringUtil.isNotBlank(cardId)) && 
/*  75 */       (StringUtil.isNotBlank(rankId)) && 
/*  76 */       (StringUtil.isNotBlank(borrowTypeId)) && 
/*  77 */       (StringUtil.isNotBlank(creditTypeId)) && 
/*  78 */       (StringUtil.isNotBlank(name)))
/*     */     {
/*  80 */       Map<String, Object> params = new HashMap();
/*  81 */       params.put("creditTypeId", creditTypeId);
/*  82 */       List<CreditType> typeList = this.creditTypeService.findCreditType(params);
/*  83 */       if ((typeList != null) && (!typeList.isEmpty())) {
/*  84 */         result.put("code", Integer.valueOf(400));
/*  85 */         result.put("msg", "保存失败,额度类型已经存在");
/*  86 */         ServletUtils.writeToResponse(this.response, result);
/*  87 */         return;
/*     */       }
/*  89 */       CreditType type = new CreditType();
/*  90 */       type.setCreditTypeId(creditTypeId);
/*  91 */       type.setCardId(cardId);
/*  92 */       type.setRankId(rankId);
/*  93 */       type.setBorrowTypeId(borrowTypeId);
/*  94 */       type.setAddTime(new Date());
/*  95 */       type.setName(name);
/*  96 */       rtValue = this.creditTypeService.insert(type);
/*     */     }
/*  98 */     if (rtValue > 0) {
/*  99 */       result.put("code", Integer.valueOf(200));
/* 100 */       result.put("msg", "保存成功");
/*     */     } else {
/* 102 */       result.put("code", Integer.valueOf(200));
/* 103 */       result.put("msg", "保存失败");
/*     */     }
/* 105 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/cr/creditType/updateCreditType.htm"})
/*     */   public void updateCreditType(@RequestParam("id") Long id, @RequestParam("cardId") String cardId, @RequestParam("rankId") String rankId, @RequestParam("borrowTypeId") String borrowTypeId, @RequestParam("creditTypeId") Long creditTypeId, @RequestParam("name") String name)
/*     */     throws Exception
/*     */   {
/* 123 */     int rtValue = 0;
/* 124 */     if ((id != null) && (StringUtil.isNotBlank(cardId)) && 
/* 125 */       (StringUtil.isNotBlank(rankId)) && 
/* 126 */       (StringUtil.isNotBlank(borrowTypeId)) && 
/* 127 */       (StringUtil.isNotBlank(creditTypeId)) && 
/* 128 */       (StringUtil.isNotBlank(name))) {
/* 129 */       CreditType type = new CreditType();
/* 130 */       type.setId(id);
/* 131 */       type.setCreditTypeId(creditTypeId);
/* 132 */       type.setCardId(cardId);
/* 133 */       type.setRankId(rankId);
/* 134 */       type.setBorrowTypeId(borrowTypeId);
/* 135 */       type.setName(name);
/* 136 */       rtValue = this.creditTypeService.updateById(type);
/*     */     }
/* 138 */     Map<String, Object> result = new HashMap();
/* 139 */     if (rtValue > 0) {
/* 140 */       result.put("code", Integer.valueOf(200));
/* 141 */       result.put("msg", "更新成功");
/*     */     } else {
/* 143 */       result.put("code", Integer.valueOf(200));
/* 144 */       result.put("msg", "更新失败");
/*     */     }
/* 146 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/modules/manage/cr/creditType/findDetail.htm"})
/*     */   public void findDetail(@RequestParam("id") Long id) throws Exception {
/* 151 */     CreditType creditType = (CreditType)this.creditTypeService.getById(id);
/* 152 */     CreditTypeModel info = this.creditTypeService.findCreditTypeInfo(creditType);
/* 153 */     Map<String, Object> result = new HashMap();
/* 154 */     result.put("data", info);
/* 155 */     result.put("code", Integer.valueOf(200));
/* 156 */     result.put("msg", "查询成功");
/* 157 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/cr/creditType/editBorrowType.htm"})
/*     */   public void editBorrowType(@RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/* 167 */     List<CreditRatingModel> list = this.creditTypeService.findEditBorrowType(id);
/* 168 */     Map<String, Object> result = new HashMap();
/* 169 */     result.put("data", list);
/* 170 */     result.put("code", Integer.valueOf(200));
/* 171 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/cr/creditType/findUnUsedBorrowType.htm"})
/*     */   public void findUnUsedBorrowType()
/*     */     throws Exception
/*     */   {
/* 180 */     List<Map<Long, String>> borrowTypes = this.creditTypeService.findUnUsedBorrowType();
/* 181 */     Map<String, Object> result = new HashMap();
/* 182 */     result.put("data", borrowTypes);
/* 183 */     result.put("code", Integer.valueOf(200));
/* 184 */     result.put("msg", "查询成功");
/* 185 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }