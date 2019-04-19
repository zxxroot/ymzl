/*     */ package com.rongdu.creditrank.cr.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.exception.CreditException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.creditrank.cr.domain.Card;
/*     */ import com.rongdu.creditrank.cr.domain.Factor;
/*     */ import com.rongdu.creditrank.cr.domain.FactorParam;
/*     */ import com.rongdu.creditrank.cr.domain.Item;
/*     */ import com.rongdu.creditrank.cr.mapper.CardMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.FactorMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.FactorParamMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.ItemMapper;
/*     */ import com.rongdu.creditrank.cr.model.FactorParamModel;
/*     */ import com.rongdu.creditrank.cr.service.FactorParamService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ @Service("factorParamService")
/*     */ public class FactorParamServiceImpl
/*     */   extends BaseServiceImpl<FactorParam, Long>
/*     */   implements FactorParamService
/*     */ {
/*     */   @Resource
/*     */   private FactorParamMapper factorParamMapper;
/*     */   @Resource
/*     */   private FactorMapper factorMapper;
/*     */   @Resource
/*     */   private ItemMapper itemMapper;
/*     */   @Resource
/*     */   private CardMapper cardMapper;
/*     */   
/*     */   public BaseMapper<FactorParam, Long> getMapper()
/*     */   {
/*  56 */     return this.factorParamMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<FactorParam> page(Map<String, Object> secreditrankhMap, int current, int pageSize)
/*     */   {
/*  62 */     PageHelper.startPage(current, pageSize);
/*  63 */     List<FactorParam> list = this.factorParamMapper.listSelective(secreditrankhMap);
/*  64 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public Map<String, Object> deleteSelective(long id) throws CreditException
/*     */   {
/*  69 */     int msg = 0;
/*  70 */     Map<String, Object> result = new HashMap();
/*  71 */     FactorParam fp = (FactorParam)this.factorParamMapper.findByPrimary(Long.valueOf(id));
/*  72 */     Factor ft = (Factor)this.factorMapper.findByPrimary(fp.getFactorId());
/*  73 */     Item item = (Item)this.itemMapper.findByPrimary(ft.getItemId());
/*  74 */     Card card = (Card)this.cardMapper.findByPrimary(item.getCardId());
/*     */     
/*  76 */     if ("10".equals(card.getType())) {
/*  77 */       msg = this.factorParamMapper.deleteSelective(id);
/*     */     }
/*  79 */     if (msg > 0) {
/*  80 */       result.put("code", Integer.valueOf(200));
/*  81 */       result.put("msg", "删除成功");
/*     */       
/*  83 */       long factorId = ft.getId().longValue();
/*  84 */       Map<String, Object> factorMap = new HashMap();
/*  85 */       factorMap.put("id", ft.getId());
/*  86 */       factorMap.put("factorScore", Integer.valueOf(this.factorParamMapper.findMaxScore(factorId)));
/*  87 */       this.factorMapper.updateSelective(factorMap);
/*     */       
/*  89 */       long itemId = item.getId().longValue();
/*  90 */       Map<String, Object> itemMap = new HashMap();
/*  91 */       itemMap.put("id", item.getId());
/*  92 */       itemMap.put("score", Integer.valueOf(this.factorMapper.findSumScore(itemId)));
/*  93 */       this.itemMapper.updateSelective(itemMap);
/*     */       
/*  95 */       long cardId = card.getId().longValue();
/*  96 */       Map<String, Object> cardMap = new HashMap();
/*  97 */       cardMap.put("id", card.getId());
/*  98 */       cardMap.put("score", Integer.valueOf(this.itemMapper.findSumScore(cardId)));
/*  99 */       this.cardMapper.updateSelective(cardMap);
/*     */     }
/*     */     else {
/* 102 */       result.put("code", Integer.valueOf(400));
/* 103 */       result.put("msg", "删除失败,请查看评分卡是否被使用");
/*     */     }
/* 105 */     return result;
/*     */   }
/*     */   
/*     */   public int updateSelective(Map<String, Object> updateMap)
/*     */   {
/* 110 */     return this.factorParamMapper.updateSelective(updateMap);
/*     */   }
/*     */   
/*     */   public List<FactorParamModel> listSelect(Map<String, Object> param)
/*     */   {
/* 115 */     return this.factorParamMapper.listSelect(param);
/*     */   }
/*     */   
/*     */   public int save(FactorParam fp)
/*     */   {
/* 120 */     return this.factorParamMapper.save(fp);
/*     */   }
/*     */   
/*     */   public FactorParam findByPrimary(long id)
/*     */   {
/* 125 */     return (FactorParam)this.factorParamMapper.findByPrimary(Long.valueOf(id));
/*     */   }
/*     */   
/*     */   public int deleteSelective(Long id)
/*     */   {
/* 130 */     return this.factorParamMapper.deleteSelective(id.longValue());
/*     */   }
/*     */   
/*     */   public int findMaxScore(long factorId)
/*     */   {
/* 135 */     return this.factorParamMapper.findMaxScore(factorId);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\FactorParamServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */