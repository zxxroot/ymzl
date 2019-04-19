/*    */ package com.rongdu.creditrank.cr.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.creditrank.cr.domain.CrResultDetail;
/*    */ import com.rongdu.creditrank.cr.mapper.CrResultDetailMapper;
/*    */ import com.rongdu.creditrank.cr.mapper.CrResultMapper;
/*    */ import com.rongdu.creditrank.cr.model.CrResultDetailModel;
/*    */ import com.rongdu.creditrank.cr.model.CrResultFactorDetail;
/*    */ import com.rongdu.creditrank.cr.model.CrResultItemDetail;
/*    */ import com.rongdu.creditrank.cr.service.CrResultDetailService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
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
/*    */ @Service("crResultDetailService")
/*    */ public class CrResultDetailServiceImpl
/*    */   extends BaseServiceImpl<CrResultDetail, Long>
/*    */   implements CrResultDetailService
/*    */ {
/*    */   @Resource
/*    */   private CrResultDetailMapper crResultDetailMapper;
/*    */   @Resource
/*    */   private CrResultMapper crResultMapper;
/*    */   
/*    */   public BaseMapper<CrResultDetail, Long> getMapper()
/*    */   {
/* 46 */     return this.crResultDetailMapper;
/*    */   }
/*    */   
/*    */   public Page<CrResultDetail> page(Map<String, Object> secreditrankhMap, int current, int pageSize)
/*    */   {
/* 51 */     PageHelper.startPage(current, pageSize);
/* 52 */     List<CrResultDetail> list = this.crResultDetailMapper.listResultDetail(secreditrankhMap);
/* 53 */     return (Page)list;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<CrResultDetailModel> listDetailTree(Long resultId)
/*    */   {
/* 59 */     List<CrResultDetailModel> cardList = this.crResultDetailMapper.findDetail(resultId, "10");
/* 60 */     for (int i = 0; i < cardList.size(); i++) {
/* 61 */       List<CrResultItemDetail> itemList = this.crResultDetailMapper.findItemDetail(resultId, "20");
/* 62 */       CrResultDetailModel cardDetail = (CrResultDetailModel)cardList.get(i);
/* 63 */       cardList.set(i, cardDetail);
/* 64 */       for (int m = 0; m < itemList.size(); m++) {
/* 65 */         List<CrResultFactorDetail> factorList = this.crResultDetailMapper.findFactorDetail(resultId, "30");
/* 66 */         CrResultItemDetail itemDetail = (CrResultItemDetail)itemList.get(m);
/* 67 */         itemDetail.setFactorList(factorList);
/* 68 */         itemList.set(m, itemDetail);
/*    */       }
/* 70 */       cardDetail.setItemList(itemList);
/*    */     }
/* 72 */     return cardList;
/*    */   }
/*    */   
/*    */   public List<CrResultDetail> listInfo(Long cardId)
/*    */   {
/* 77 */     Map<String, Object> paramMap = new HashMap();
/* 78 */     paramMap.put("cardId", cardId);
/* 79 */     return this.crResultDetailMapper.listSelective(paramMap);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\CrResultDetailServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */