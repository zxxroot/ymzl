/*     */ package com.rongdu.creditrank.cr.service.impl;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.exception.CreditException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.creditrank.cr.domain.CrResult;
/*     */ import com.rongdu.creditrank.cr.domain.CrResultDetail;
/*     */ import com.rongdu.creditrank.cr.domain.Rank;
/*     */ import com.rongdu.creditrank.cr.domain.RankDetail;
/*     */ import com.rongdu.creditrank.cr.mapper.CardMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.CrResultDetailMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.CrResultMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.CreditTypeMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.RankDetailMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.RankMapper;
/*     */ import com.rongdu.creditrank.cr.model.CreditRatingModel;
/*     */ import com.rongdu.creditrank.cr.model.CreditTypeModel;
/*     */ import com.rongdu.creditrank.cr.model.FactorModel;
/*     */ import com.rongdu.creditrank.cr.model.srule.client.RulesExecutorUtil;
/*     */ import com.rongdu.creditrank.cr.model.srule.model.SimpleRule;
/*     */ import com.rongdu.creditrank.cr.service.CreditRatingService;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Propagation;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import tool.util.DateUtil;
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
/*     */ @Service("creditRatingService")
/*     */ public class CreditRatingServiceImpl
/*     */   extends BaseServiceImpl<CrResult, Long>
/*     */   implements CreditRatingService
/*     */ {
/*     */   @Resource
/*     */   private CrResultMapper crResultMapper;
/*     */   @Resource
/*     */   private RankMapper rankMapper;
/*     */   @Resource
/*     */   private RankDetailMapper rankDetailMapper;
/*     */   @Resource
/*     */   private CrResultDetailMapper crResultDetailMapper;
/*     */   @Resource
/*     */   private CreditTypeMapper creditTypeMapper;
/*     */   @Resource
/*     */   private CardMapper cardMapper;
/*     */   
/*     */   @Transactional(propagation=Propagation.NOT_SUPPORTED)
/*     */   public CrResult saveCreditRating(String consumerNo, Long borrowTypeId)
/*     */     throws CreditException
/*     */   {
/*  72 */     CreditTypeModel creditType = null;
/*  73 */     if (borrowTypeId != null) {
/*  74 */       creditType = this.creditTypeMapper.findByBorrowTypeId(borrowTypeId);
/*     */     }
/*     */     
/*  77 */     CrResult result = null;
/*  78 */     if ((creditType != null) && (consumerNo != null)) {
/*  79 */       result = this.crResultMapper.findCreditTypeResult(consumerNo, creditType.getId());
/*     */     } else {
/*  81 */       throw new CreditException("评分失败，请联系管理员配置借款类型对应的额度类型");
/*     */     }
/*     */     
/*     */ 
/*  85 */     if ((result == null) && (creditType != null)) {
/*  86 */       this.cardMapper.updateType(Long.valueOf(creditType.getCardId()));
/*  87 */       Integer totalScore = Integer.valueOf(0);
/*  88 */       BigDecimal totalAmount = BigDecimal.valueOf(0.0D);
/*     */       
/*  90 */       result = new CrResult();
/*  91 */       result.setConsumerNo(consumerNo);
/*  92 */       result.setCreditTypeId(creditType.getId());
/*  93 */       result.setTotalScore(totalScore);
/*  94 */       result.setTotalAmount(totalAmount);
/*  95 */       result.setAddTime(new Date());
/*     */       
/*  97 */       this.crResultMapper.saveRecord(result);
/*     */       
/*     */ 
/*     */ 
/* 101 */       List<CreditRatingModel> crList = this.crResultMapper.queryCreditRating(borrowTypeId, FactorModel.FACTOR_TYPE_SYSTEM);
/* 102 */       if ((crList != null) && (!crList.isEmpty())) {
/* 103 */         for (int i = 0; i < crList.size(); i++) {
/* 104 */           CreditRatingModel crModel = (CreditRatingModel)crList.get(i);
/* 105 */           CrResultDetail detail = new CrResultDetail(result.getId(), crModel.getCardId(), crModel.getItemId(), crModel.getFactorId(), crModel.getParamId(), crModel.getColName(), crModel.getParamScore(), crModel.getFormula(), crModel.getRange());
/* 106 */           String statement = "select " + crModel.getColName() + " from " + crModel.getTabName() + " where consumer_no = " + consumerNo;
/*     */           
/* 108 */           String value = this.crResultMapper.findValidValue(statement);
/* 109 */           detail.setValue(value);
/*     */           
/* 111 */           SimpleRule simpleRule = RulesExecutorUtil.singleRuleResult(crModel.getParamId(), crModel.getColName(), crModel.getFormula(), crModel.getRange(), value, crModel.getType(), "");
/*     */           
/* 113 */           if ("Y".equals(simpleRule.getComparResult())) {
/* 114 */             detail.setScore(crModel.getParamScore());
/* 115 */             totalScore = Integer.valueOf(totalScore.intValue() + crModel.getParamScore().intValue());
/*     */           }
/*     */           else {
/* 118 */             detail.setScore(Integer.valueOf(0));
/*     */           }
/*     */           
/*     */ 
/* 122 */           detail.setLevel("40");
/* 123 */           detail.setAddTime(DateUtil.getNow());
/* 124 */           this.crResultDetailMapper.save(detail);
/*     */         }
/*     */         
/*     */       } else {
/* 128 */         throw new CreditException("评分失败，没有找到对应的系统配置");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 133 */       List<CrResultDetail> scoreList = new ArrayList();
/*     */       
/*     */ 
/* 136 */       List<CrResultDetail> tempList = this.crResultDetailMapper.countFactorScore(result.getId());
/* 137 */       scoreList.addAll(tempList);
/*     */       
/*     */ 
/* 140 */       tempList = this.crResultDetailMapper.countItemScore(result.getId());
/* 141 */       scoreList.addAll(tempList);
/*     */       
/*     */ 
/* 144 */       tempList = this.crResultDetailMapper.countCardScore(result.getId());
/* 145 */       Rank rank = (Rank)this.rankMapper.findByPrimary(Long.valueOf(creditType.getRankId()));
/*     */       
/* 147 */       for (int i = 0; i < tempList.size(); i++) {
/* 148 */         if (rank != null) {
/* 149 */           CrResultDetail temp = (CrResultDetail)tempList.get(i);
/* 150 */           RankDetail detail = this.rankDetailMapper.findByParentIdAndScore(Long.valueOf(creditType.getRankId()), temp.getScore());
/* 151 */           totalAmount = totalAmount.add(detail.getAmountMin());
/* 152 */           temp.setAmount(detail.getAmountMin());
/* 153 */           tempList.set(i, temp);
/*     */         }
/*     */       }
/* 156 */       scoreList.addAll(tempList);
/*     */       
/*     */ 
/*     */ 
/* 160 */       this.crResultDetailMapper.saveCountScore(scoreList);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 165 */       result.setTotalScore(totalScore);
/*     */       
/* 167 */       result.setTotalAmount(totalAmount);
/*     */       
/* 169 */       this.crResultMapper.update(result);
/*     */     }
/*     */     
/* 172 */     return result;
/*     */   }
/*     */   
/*     */   public BaseMapper<CrResult, Long> getMapper()
/*     */   {
/* 177 */     return this.crResultMapper;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\CreditRatingServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */