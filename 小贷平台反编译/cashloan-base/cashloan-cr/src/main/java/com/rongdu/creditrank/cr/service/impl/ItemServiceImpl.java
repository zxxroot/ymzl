/*     */ package com.rongdu.creditrank.cr.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.core.common.exception.CreditException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.NidGenerator;
import com.rongdu.creditrank.cr.domain.Card;
import com.rongdu.creditrank.cr.domain.Factor;
import com.rongdu.creditrank.cr.domain.Item;
import com.rongdu.creditrank.cr.mapper.CardMapper;
import com.rongdu.creditrank.cr.mapper.FactorMapper;
import com.rongdu.creditrank.cr.mapper.FactorParamMapper;
import com.rongdu.creditrank.cr.mapper.ItemMapper;
import com.rongdu.creditrank.cr.model.FactorParamModel;
import com.rongdu.creditrank.cr.model.ItemModel;
import com.rongdu.creditrank.cr.service.ItemService;
import org.springframework.stereotype.Service;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.*;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("itemService")
/*     */ public class ItemServiceImpl
/*     */   extends BaseServiceImpl<Item, Long>
/*     */   implements ItemService
/*     */ {
/*     */   @Resource
/*     */   private ItemMapper itemMapper;
/*     */   @Resource
/*     */   private CardMapper cardMapper;
/*     */   @Resource
/*     */   private FactorMapper factorMapper;
/*     */   @Resource
/*     */   private FactorParamMapper factorParamMapper;
/*     */   
/*     */   public BaseMapper<Item, Long> getMapper()
/*     */   {
/*  64 */     return this.itemMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<String, Object> save(String itemName, Long cardId)
/*     */     throws CreditException
/*     */   {
/*  72 */     int msg = 0;
/*  73 */     Map<String, Object> result = new HashMap();
/*  74 */     Card card = (Card)this.cardMapper.findByPrimary(cardId);
/*  75 */     if ("20".equals(card.getType())) {
/*  76 */       Item item = new Item();
/*  77 */       item.setCardId(cardId);
/*  78 */       item.setItemName(itemName);
/*  79 */       item.setScore(Integer.valueOf(0));
/*  80 */       item.setState("10");
/*  81 */       item.setNid(NidGenerator.getItemNid());
/*  82 */       item.setAddTime(new Date());
/*  83 */       msg = this.itemMapper.save(item);
/*  84 */       if (msg > 0) {
/*  85 */         result.put("code", Integer.valueOf(200));
/*  86 */         result.put("msg", "新增成功");
/*     */       } else {
/*  88 */         result.put("code", Integer.valueOf(400));
/*  89 */         result.put("msg", "新增失败");
/*     */       }
/*     */     }
/*     */     else {
/*  93 */       result.put("code", Integer.valueOf(400));
/*  94 */       result.put("msg", "评分卡已被使用无法编辑!");
/*     */     }
/*  96 */     return result;
/*     */   }
/*     */   
/*     */   public int updateSelective(Map<String, Object> map)
/*     */   {
/* 101 */     return this.itemMapper.updateSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Page<ItemModel> page(Map<String, Object> secreditrankhMap, int current, int pageSize)
/*     */   {
/* 108 */     PageHelper.startPage(current, pageSize);
/* 109 */     List<ItemModel> list = this.itemMapper.listSelect(secreditrankhMap);
/* 110 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public Item findByPrimary(long id)
/*     */   {
/* 115 */     return (Item)this.itemMapper.findByPrimary(Long.valueOf(id));
/*     */   }
/*     */   
/*     */   public List<ItemModel> listSelect(Map<String, Object> secreditrankhMap)
/*     */   {
/* 120 */     return this.itemMapper.listSelect(secreditrankhMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<String, Object> deleteSelective(long id)
/*     */     throws CreditException
/*     */   {
/* 128 */     int msg = 0;
/* 129 */     Map<String, Object> result = new HashMap();
/* 130 */     Item item = (Item)this.itemMapper.findByPrimary(Long.valueOf(id));
/* 131 */     Card card = (Card)this.cardMapper.findByPrimary(item.getCardId());
/* 132 */     if ("20".equals(card.getType())) {
/* 133 */       if ((StringUtil.isNotBlank(item)) && 
/* 134 */         ("20".equals(card.getState()))) {
/* 135 */         msg = this.itemMapper.deleteSelective(id);
/* 136 */         if (msg > 0) {
/* 137 */           List<Factor> fac = this.factorMapper.findByItemId(id);
/* 138 */           Map<String, Object> param = new HashMap();
/* 139 */           Iterator localIterator2; for (Iterator localIterator1 = fac.iterator(); localIterator1.hasNext(); 
/*     */               
/*     */ 
/*     */ 
/* 143 */               localIterator2.hasNext())
/*     */           {
/* 139 */             Factor factor = (Factor)localIterator1.next();
/* 140 */             param.put("factorId", factor.getId());
/* 141 */             msg = this.factorMapper.deleteSelective(factor.getId().longValue());
/* 142 */             List<FactorParamModel> fpList = this.factorParamMapper.listSelect(param);
/* 143 */             localIterator2 = fpList.iterator(); FactorParamModel factorParamModel = (FactorParamModel)localIterator2.next();
/* 144 */             msg = this.factorParamMapper.deleteSelective(factorParamModel.getId().longValue());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 150 */       if (msg > 0) {
/* 151 */         result.put("code", Integer.valueOf(200));
/* 152 */         result.put("msg", "删除成功");
/*     */       } else {
/* 154 */         result.put("code", Integer.valueOf(400));
/* 155 */         result.put("msg", "删除异常,请查看评分卡是否禁用");
/*     */       }
/*     */     } else {
/* 158 */       result.put("code", Integer.valueOf(400));
/* 159 */       result.put("msg", "评分卡已被使用无法编辑!");
/*     */     }
/* 161 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<String, Object> list(long cardId)
/*     */   {
/* 169 */     Map<String, Object> result = new HashMap();
/* 170 */     Map<String, Object> secreditrankh = new HashMap();
/* 171 */     secreditrankh.put("cardId", Long.valueOf(cardId));
/* 172 */     List<Map<String, Object>> item = new ArrayList();
/* 173 */     List<ItemModel> itemList = this.itemMapper.listSelect(secreditrankh);
/* 174 */     for (ItemModel itemModel : itemList) {
/* 175 */       Map<String, Object> itemName = new HashMap();
/* 176 */       itemName.put("id", itemModel.getId());
/* 177 */       itemName.put("itemName", itemModel.getItemName());
/* 178 */       item.add(itemName);
/*     */     }
/* 180 */     result.put("data", item);
/* 181 */     result.put("code", Integer.valueOf(200));
/* 182 */     result.put("msg", "查询成功");
/* 183 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int findSumScore(long cardId)
/*     */   {
/* 191 */     return this.itemMapper.findSumScore(cardId);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\ItemServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */