/*     */ package com.rongdu.creditrank.cr.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.creditrank.cr.domain.Rank;
/*     */ import com.rongdu.creditrank.cr.domain.RankDetail;
/*     */ import com.rongdu.creditrank.cr.mapper.RankMapper;
/*     */ import com.rongdu.creditrank.cr.model.RankModel;
/*     */ import com.rongdu.creditrank.cr.service.RankDetailService;
/*     */ import com.rongdu.creditrank.cr.service.RankService;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
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
/*     */ @Service("rankService")
/*     */ public class RankServiceImpl
/*     */   extends BaseServiceImpl<Rank, Long>
/*     */   implements RankService
/*     */ {
/*     */   @Resource
/*     */   private RankMapper rankMapper;
/*     */   @Resource
/*     */   private RankService rankService;
/*     */   @Resource
/*     */   private RankDetailService rankDetailService;
/*     */   
/*     */   public BaseMapper<Rank, Long> getMapper()
/*     */   {
/*  51 */     return this.rankMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Page<Rank> page(Map<String, Object> searchMap, int current, int pageSize)
/*     */   {
/*  58 */     PageHelper.startPage(current, pageSize);
/*  59 */     List<Rank> list = this.rankMapper.listSelective(searchMap);
/*  60 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public int updateSelective(Map<String, Object> updateMap)
/*     */   {
/*  65 */     return this.rankMapper.updateSelective(updateMap);
/*     */   }
/*     */   
/*     */   public List<Rank> listSelective(Map<String, Object> search)
/*     */   {
/*  70 */     return this.rankMapper.listSelective(search);
/*     */   }
/*     */   
/*     */   public Map<String, Object> save(List<Map<String, Object>> list, String rankName, long id)
/*     */   {
/*  75 */     int msg = 0;
/*  76 */     Rank rank = new Rank();
/*  77 */     if (id > 0L) {
/*  78 */       Map<String, Object> rankMap = new HashMap();
/*  79 */       rankMap.put("id", Long.valueOf(id));
/*  80 */       rankMap.put("rankName", rankName);
/*  81 */       msg = this.rankMapper.updateSelective(rankMap);
/*     */     } else {
/*  83 */       rank.setRankName(rankName);
/*  84 */       msg = this.rankMapper.save(rank);
/*     */     }
/*  86 */     if (msg > 0) {
/*  87 */       for (int i = 0; i < list.size(); i++) {
/*  88 */         Map<String, Object> rankDetailMap = (Map)list.get(i);
/*  89 */         RankDetail rankDetail = new RankDetail();
/*  90 */         rankDetail.setRankId(rank.getId());
/*  91 */         rankDetail.setRank(rankDetailMap.get("rank").toString());
/*  92 */         rankDetail.setRtype(rankDetailMap.get("rtype").toString());
/*  93 */         BigDecimal amountMax = BigDecimal.valueOf(Double.valueOf(rankDetailMap.get("amountMax").toString()).doubleValue());
/*  94 */         BigDecimal amountMin = BigDecimal.valueOf(Double.valueOf(rankDetailMap.get("amountMin").toString()).doubleValue());
/*  95 */         rankDetail.setAmountMax(amountMax);
/*  96 */         rankDetail.setAmountMin(amountMin);
/*  97 */         rankDetail.setScoreMax(Integer.valueOf(Integer.parseInt(rankDetailMap.get("scoreMax").toString())));
/*  98 */         rankDetail.setScoreMin(Integer.valueOf(Integer.parseInt(rankDetailMap.get("scoreMin").toString())));
/*  99 */         if (Long.parseLong(rankDetailMap.get("id").toString()) == 0L) {
/* 100 */           rankDetail.setState("10");
/* 101 */           rankDetail.setAddTime(new Date());
/* 102 */           msg = this.rankDetailService.save(rankDetail);
/*     */         } else {
/* 104 */           rankDetail.setId(Long.valueOf(Long.parseLong(rankDetailMap.get("id").toString())));
/* 105 */           rankDetail.setState(rankDetailMap.get("state").toString());
/* 106 */           msg = this.rankDetailService.updateSelective(rankDetailMap);
/*     */         }
/*     */       }
/*     */     }
/* 110 */     Map<String, Object> result = new HashMap();
/* 111 */     if (msg < 0) {
/* 112 */       result.put("code", Integer.valueOf(400));
/* 113 */       result.put("msg", "操作失败");
/*     */     } else {
/* 115 */       result.put("code", Integer.valueOf(200));
/* 116 */       result.put("msg", "操作成功");
/*     */     }
/* 118 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public Rank findSelective(Map<String, Object> search)
/*     */   {
/* 124 */     return (Rank)this.rankMapper.findSelective(search);
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<String, Object> deleteSelective(long id)
/*     */   {
/* 130 */     int msg = this.rankMapper.deleteSelective(id);
/* 131 */     Map<String, Object> result = new HashMap();
/* 132 */     if (msg > 0) {
/* 133 */       result.put("code", Integer.valueOf(200));
/* 134 */       result.put("msg", "删除成功");
/*     */     } else {
/* 136 */       result.put("code", Integer.valueOf(400));
/* 137 */       result.put("msg", "删除失败");
/*     */     }
/* 139 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Page<RankModel> countList(Map<String, Object> searchMap, int current, int pageSize)
/*     */   {
/* 146 */     PageHelper.startPage(current, pageSize);
/* 147 */     List<RankModel> list = this.rankMapper.countList(searchMap);
/* 148 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Rank> findAll()
/*     */   {
/* 154 */     return this.rankMapper.findAll();
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\RankServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */