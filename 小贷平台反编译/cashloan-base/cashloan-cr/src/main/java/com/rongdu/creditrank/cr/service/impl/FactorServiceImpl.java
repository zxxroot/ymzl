/*     */ package com.rongdu.creditrank.cr.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.exception.CreditException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.NidGenerator;
/*     */ import com.rongdu.creditrank.cr.domain.Card;
/*     */ import com.rongdu.creditrank.cr.domain.Factor;
/*     */ import com.rongdu.creditrank.cr.domain.FactorParam;
/*     */ import com.rongdu.creditrank.cr.domain.Item;
/*     */ import com.rongdu.creditrank.cr.mapper.CardMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.FactorMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.FactorParamMapper;
/*     */ import com.rongdu.creditrank.cr.mapper.ItemMapper;
/*     */ import com.rongdu.creditrank.cr.model.FactorModel;
/*     */ import com.rongdu.creditrank.cr.model.FactorParamModel;
/*     */ import com.rongdu.creditrank.cr.service.FactorService;
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
/*     */ @Service("factorService")
/*     */ public class FactorServiceImpl
/*     */   extends BaseServiceImpl<Factor, Long>
/*     */   implements FactorService
/*     */ {
/*     */   Map<String, Object> data;
/*     */   @Resource
/*     */   private FactorMapper factorMapper;
/*     */   @Resource
/*     */   private ItemMapper itemMapper;
/*     */   @Resource
/*     */   private FactorParamMapper factorParamMapper;
/*     */   @Resource
/*     */   private CardMapper cardMapper;
/*     */   
/*     */   public BaseMapper<Factor, Long> getMapper()
/*     */   {
/*  59 */     return this.factorMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Factor findByFactorName(String factorName)
/*     */   {
/*  65 */     return this.factorMapper.findByFactorName(factorName);
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<FactorModel> page(Map<String, Object> secreditrankhMap, int current, int pageSize)
/*     */   {
/*  71 */     PageHelper.startPage(current, pageSize);
/*  72 */     List<FactorModel> list = this.factorMapper.listSelect(secreditrankhMap);
/*  73 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public int updateSelective(Map<String, Object> updateMap)
/*     */   {
/*  79 */     return this.factorMapper.updateSelective(updateMap);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<FactorModel> listSelect(Map<String, Object> factor)
/*     */   {
/*  85 */     return this.factorMapper.listSelect(factor);
/*     */   }
/*     */   
/*     */ 
/*     */   public Factor findByPrimary(long id)
/*     */   {
/*  91 */     return (Factor)this.factorMapper.findByPrimary(Long.valueOf(id));
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Factor> findByItemId(long id)
/*     */   {
/*  97 */     return this.factorMapper.findByItemId(id);
/*     */   }
/*     */   
/*     */   public Map<String, Object> save(Map<String, Object> factorMap, List<Map<String, Object>> list)
/*     */     throws CreditException
/*     */   {
/* 103 */     int msg = 0;
/* 104 */     Map<String, Object> result = new HashMap();
/*     */     
/* 106 */     Item item = (Item)this.itemMapper.findByPrimary(Long.valueOf(Long.parseLong(factorMap.get("itemId").toString())));
/* 107 */     Card card = (Card)this.cardMapper.findByPrimary(item.getCardId());
/* 108 */     if ("20".equals(card.getType())) {
/* 109 */       Factor factor = new Factor();
/* 110 */       factor.setItemId(item.getId());
/* 111 */       factor.setFactorName(factorMap.get("factorName").toString());
/* 112 */       factor.setFactorScore(Integer.valueOf(getScore(list)));
/* 113 */       factor.setType(factorMap.get("type").toString());
/* 114 */       factor.setNnid(factorMap.get("nnid").toString());
/* 115 */       factor.setCtable(factorMap.get("ctable").toString());
/* 116 */       factor.setCtableName(factorMap.get("ctableName").toString());
/* 117 */       factor.setCcolumn(factorMap.get("ccolumn").toString());
/* 118 */       factor.setCcolumnName(factorMap.get("ccolumnName").toString());
/* 119 */       factor.setCtype(factorMap.get("ctype").toString());
/* 120 */       factor.setCardId(Long.parseLong(factorMap.get("cardId").toString()));
/* 121 */       factor.setNid(NidGenerator.getFactorNid());
/* 122 */       factor.setState("10");
/* 123 */       factor.setAddTime(new Date());
/* 124 */       long id = this.factorMapper.save(factor);
/*     */       
/* 126 */       if (id > 0L) {
/* 127 */         if ((list != null) && (!list.isEmpty())) {
/* 128 */           int paramMsg = saveOrUpdate(list, factor);
/* 129 */           msg = paramMsg;
/*     */         }
/* 131 */         Map<String, Object> cardMap = new HashMap();
/* 132 */         cardMap.put("id", card.getId());
/* 133 */         cardMap.put("score", Integer.valueOf(card.getScore().intValue() + getScore(list)));
/* 134 */         this.cardMapper.updateSelective(cardMap);
/*     */         
/* 136 */         Map<String, Object> itemMap = new HashMap();
/* 137 */         itemMap.put("id", item.getId());
/* 138 */         itemMap.put("score", Integer.valueOf(item.getScore().intValue() + getScore(list)));
/* 139 */         this.itemMapper.updateSelective(itemMap);
/*     */       }
/* 141 */       if (msg > 0) {
/* 142 */         result.put("code", Integer.valueOf(200));
/* 143 */         result.put("msg", "新增成功");
/*     */       } else {
/* 145 */         result.put("code", Integer.valueOf(400));
/* 146 */         result.put("msg", "新增异常");
/*     */       }
/*     */     } else {
/* 149 */       result.put("code", Integer.valueOf(400));
/* 150 */       result.put("msg", "评分卡已被使用无法编辑!");
/*     */     }
/* 152 */     return result;
/*     */   }
/*     */   
/*     */   public Map<String, Object> updateSelective(Map<String, Object> factorMap, List<Map<String, Object>> list)
/*     */     throws CreditException
/*     */   {
/* 158 */     int msg = 0;
/* 159 */     Map<String, Object> result = new HashMap();
/*     */     
/* 161 */     Factor factor = (Factor)this.factorMapper.findByPrimary(Long.valueOf(Long.parseLong(factorMap.get("id").toString())));
/* 162 */     Item item = (Item)this.itemMapper.findByPrimary(factor.getItemId());
/* 163 */     Card card = (Card)this.cardMapper.findByPrimary(item.getCardId());
/*     */     
/* 165 */     if ("20".equals(card.getType())) {
/* 166 */       factorMap.put("factorScore", Integer.valueOf(getScore(list)));
/* 167 */       msg = this.factorMapper.updateSelective(factorMap);
/* 168 */       Map<String, Object> secreditrankh = new HashMap();
/* 169 */       secreditrankh.put("factorId", factorMap.get("id"));
/* 170 */       if (msg > 0) {
/* 171 */         int code = 0;
/* 172 */         code = getScore(list) - factor.getFactorScore().intValue();
/*     */         
/* 174 */         Map<String, Object> itemMap = new HashMap();
/* 175 */         itemMap.put("id", factorMap.get("itemId"));
/* 176 */         itemMap.put("score", Integer.valueOf(item.getScore().intValue() + code));
/* 177 */         this.itemMapper.updateSelective(itemMap);
/*     */         
/* 179 */         Map<String, Object> cardMap = new HashMap();
/* 180 */         cardMap.put("id", item.getCardId());
/* 181 */         cardMap.put("score", Integer.valueOf(card.getScore().intValue() + code));
/* 182 */         this.cardMapper.updateSelective(cardMap);
/*     */         
/* 184 */         if ((list != null) && (!list.isEmpty())) {
/* 185 */           msg = saveOrUpdate(list, factor);
/*     */         }
/*     */       }
/* 188 */       if (msg > 0) {
/* 189 */         result.put("code", Integer.valueOf(200));
/* 190 */         result.put("msg", "修改成功");
/*     */       } else {
/* 192 */         result.put("code", Integer.valueOf(400));
/* 193 */         result.put("msg", "修改失败");
/*     */       }
/*     */     } else {
/* 196 */       result.put("code", Integer.valueOf(400));
/* 197 */       result.put("msg", "评分卡已被使用无法编辑!");
/*     */     }
/* 199 */     return result;
/*     */   }
/*     */   
/*     */   public int saveOrUpdate(List<Map<String, Object>> list, Factor factor) {
/* 203 */     FactorParam fp = new FactorParam();
/* 204 */     int msg = 0;
/* 205 */     for (int i = 0; i < list.size(); i++) {
/* 206 */       Map<String, Object> fpm = (Map)list.get(i);
/* 207 */       Factor ft = (Factor)this.factorMapper.findByPrimary(factor.getId());
/* 208 */       if (Integer.parseInt(fpm.get("paramScore").toString()) <= ft.getFactorScore().intValue()) {
/* 209 */         long id = Long.parseLong(fpm.get("id").toString());
/* 210 */         fp.setId(Long.valueOf(id));
/* 211 */         fp.setParamScore(Integer.valueOf(Integer.parseInt(fpm.get("paramScore").toString())));
/* 212 */         fp.setFormula(fpm.get("formula").toString());
/* 213 */         fp.setCvalue(fpm.get("cvalue").toString());
/* 214 */         fp.setFactorId(factor.getId());
/* 215 */         fp.setAddTime(new Date());
/* 216 */         if (id == 0L) {
/* 217 */           fp.setState("10");
/* 218 */           msg = this.factorParamMapper.save(fp);
/*     */         } else {
/* 220 */           msg = this.factorParamMapper.updateSelective(fpm);
/*     */         }
/*     */       }
/*     */     }
/* 224 */     return msg;
/*     */   }
/*     */   
/*     */   public int getScore(List<Map<String, Object>> list) {
/* 228 */     int score = 0;
/* 229 */     for (int i = 0; i < list.size(); i++) {
/* 230 */       Map<String, Object> map = (Map)list.get(i);
/* 231 */       int factorScore = Integer.parseInt(map.get("paramScore").toString());
/* 232 */       if (factorScore > score) {
/* 233 */         score = factorScore;
/*     */       }
/*     */     }
/* 236 */     return score;
/*     */   }
/*     */   
/*     */   public Map<String, Object> deleteSelective(long id) throws CreditException
/*     */   {
/* 241 */     int msg = 0;
/* 242 */     Factor ft = (Factor)this.factorMapper.findByPrimary(Long.valueOf(id));
/* 243 */     Item item = (Item)this.itemMapper.findByPrimary(ft.getItemId());
/* 244 */     Card card = (Card)this.cardMapper.findByPrimary(item.getCardId());
/* 245 */     Map<String, Object> result = new HashMap();
/* 246 */     if ("20".equals(card.getType())) {
/* 247 */       msg = this.factorMapper.deleteSelective(id);
/* 248 */       if (msg > 0)
/*     */       {
/* 250 */         Map<String, Object> cardMap = new HashMap();
/* 251 */         cardMap.put("id", card.getId());
/* 252 */         cardMap.put("score", Integer.valueOf(card.getScore().intValue() - ft.getFactorScore().intValue()));
/* 253 */         this.cardMapper.updateSelective(cardMap);
/*     */         
/* 255 */         Map<String, Object> itemMap = new HashMap();
/* 256 */         itemMap.put("id", item.getId());
/* 257 */         itemMap.put("score", Integer.valueOf(item.getScore().intValue() - ft.getFactorScore().intValue()));
/* 258 */         this.itemMapper.updateSelective(itemMap);
/*     */         
/* 260 */         Map<String, Object> param = new HashMap();
/* 261 */         param.put("factorId", ft.getId());
/* 262 */         List<FactorParamModel> fpList = this.factorParamMapper.listSelect(param);
/* 263 */         for (FactorParamModel factorParamModel : fpList) {
/* 264 */           msg = this.factorParamMapper.deleteSelective(factorParamModel.getId().longValue());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 269 */     if (msg > 0) {
/* 270 */       result.put("code", Integer.valueOf(200));
/* 271 */       result.put("msg", "删除成功");
/*     */     } else {
/* 273 */       result.put("code", Integer.valueOf(400));
/* 274 */       result.put("msg", "删除失败,请查看评分卡是否被使用");
/*     */     }
/* 276 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public int deleteSelective(Long id)
/*     */   {
/* 282 */     return this.factorMapper.deleteSelective(id.longValue());
/*     */   }
/*     */   
/*     */ 
/*     */   public int findSumScore(long itemId)
/*     */   {
/* 288 */     return this.factorMapper.findSumScore(itemId);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<FactorModel> listFactorModel(Map<String, Object> factor)
/*     */   {
/* 294 */     return this.factorMapper.listFactorModel(factor);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\FactorServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */