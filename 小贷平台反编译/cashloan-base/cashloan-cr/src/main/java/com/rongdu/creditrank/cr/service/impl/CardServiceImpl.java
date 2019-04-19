/*     */ package com.rongdu.creditrank.cr.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.exception.CreditException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.NidGenerator;
/*     */ import com.rongdu.creditrank.cr.domain.Card;
/*     */ import com.rongdu.creditrank.cr.mapper.CardMapper;
/*     */ import com.rongdu.creditrank.cr.service.CardService;
/*     */ import com.rongdu.creditrank.cr.service.FactorService;
/*     */ import com.rongdu.creditrank.cr.service.ItemService;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("cardService")
/*     */ public class CardServiceImpl
/*     */   extends BaseServiceImpl<Card, Long>
/*     */   implements CardService
/*     */ {
/*     */   @Resource
/*     */   private CardMapper cardMapper;
/*     */   @Resource
/*     */   private ItemService itemSercice;
/*     */   @Resource
/*     */   private FactorService factorService;
/*     */   @Resource
/*     */   private CardService cardService;
/*     */   
/*     */   public BaseMapper<Card, Long> getMapper()
/*     */   {
/*  57 */     return this.cardMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Page<Card> page(Map<String, Object> params, int current, int pageSize)
/*     */   {
/*  67 */     PageHelper.startPage(current, pageSize);
/*  68 */     List<Card> list = this.cardMapper.listSelective(params);
/*  69 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<String, Object> save(String cardName)
/*     */     throws CreditException
/*     */   {
/*  78 */     Card card = new Card();
/*  79 */     card.setCardName(cardName);
/*  80 */     card.setAddTime(new Date());
/*  81 */     card.setScore(Integer.valueOf(0));
/*  82 */     card.setType("20");
/*  83 */     card.setState("20");
/*  84 */     card.setNid(NidGenerator.getCardNid());
/*  85 */     int msg = this.cardMapper.save(card);
/*  86 */     Map<String, Object> result = new HashMap();
/*  87 */     if (msg > 0) {
/*  88 */       result.put("code", Integer.valueOf(200));
/*  89 */       result.put("msg", "新增成功");
/*     */     } else {
/*  91 */       result.put("code", Integer.valueOf(400));
/*  92 */       result.put("msg", "新增失败");
/*     */     }
/*  94 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Card findByPrimary(long cardId)
/*     */   {
/* 102 */     return (Card)this.cardMapper.findByPrimary(Long.valueOf(cardId));
/*     */   }
/*     */   
/*     */   public Map<String, Object> updateState(long id, String state)
/*     */     throws CreditException
/*     */   {
/* 108 */     int msg = 0;
/* 109 */     Map<String, Object> map = new HashMap();
/* 110 */     map.put("id", Long.valueOf(id));
/* 111 */     map.put("state", state);
/* 112 */     msg = this.cardMapper.updateState(map);
/* 113 */     Map<String, Object> result = new HashMap();
/* 114 */     if (msg > 0) {
/* 115 */       result.put("code", Integer.valueOf(200));
/* 116 */       result.put("msg", "操作成功");
/*     */     } else {
/* 118 */       result.put("code", Integer.valueOf(400));
/* 119 */       result.put("msg", "操作失败");
/*     */     }
/* 121 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void updateSelective(Map<String, Object> cardMap)
/*     */   {
/* 128 */     this.cardMapper.updateSelective(cardMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Card> findAll()
/*     */   {
/* 135 */     return this.cardMapper.findAll();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<String, Object> update(long id, String cardName)
/*     */   {
/* 142 */     int msg = 0;
/* 143 */     Card card = (Card)this.cardMapper.findByPrimary(Long.valueOf(id));
/* 144 */     if ("20".equals(card.getType())) {
/* 145 */       Map<String, Object> cardMap = new HashMap();
/* 146 */       cardMap.put("id", Long.valueOf(id));
/* 147 */       cardMap.put("cardName", cardName);
/* 148 */       msg = this.cardMapper.updateSelective(cardMap);
/*     */     } else {
/* 150 */       msg = -1;
/*     */     }
/* 152 */     Map<String, Object> result = new HashMap();
/* 153 */     if (msg > 0) {
/* 154 */       result.put("code", Integer.valueOf(200));
/* 155 */       result.put("msg", "修改成功");
/*     */     } else {
/* 157 */       result.put("code", Integer.valueOf(400));
/* 158 */       result.put("msg", "修改失败");
/* 159 */       if (msg == -1) {
/* 160 */         result.put("code", Integer.valueOf(400));
/* 161 */         result.put("msg", "评分卡已被使用!");
/*     */       }
/*     */     }
/* 164 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\CardServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */