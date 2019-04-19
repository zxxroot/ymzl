/*     */ package com.rongdu.cashloan.rule.service.impl;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.rule.domain.BorrowRuleConfig;
/*     */ import com.rongdu.cashloan.rule.mapper.BorrowRuleConfigMapper;
/*     */ import com.rongdu.cashloan.rule.model.BorrowRuleConfigModel;
/*     */ import com.rongdu.cashloan.rule.service.BorrowRuleConfigService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
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
/*     */ @Service("borrowRuleConfigService")
/*     */ public class BorrowRuleConfigServiceImpl
/*     */   extends BaseServiceImpl<BorrowRuleConfig, Long>
/*     */   implements BorrowRuleConfigService
/*     */ {
/*  36 */   private static final Logger logger = LoggerFactory.getLogger(BorrowRuleConfigServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private BorrowRuleConfigMapper borrowRuleConfigMapper;
/*     */   
/*     */ 
/*     */   public BaseMapper<BorrowRuleConfig, Long> getMapper()
/*     */   {
/*  44 */     return this.borrowRuleConfigMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<BorrowRuleConfigModel> findConfig(Map<String, Object> params)
/*     */   {
/*  53 */     List<BorrowRuleConfig> list = this.borrowRuleConfigMapper.listSelective(params);
/*  54 */     List<BorrowRuleConfigModel> result = new ArrayList();
/*  55 */     String ruleIds = ";";
/*  56 */     BorrowRuleConfig rule; for (BorrowRuleConfig config : list) {
/*  57 */       BorrowRuleConfigModel model = new BorrowRuleConfigModel();
/*  58 */       rule = new BorrowRuleConfig();
/*  59 */       rule.setRuleId(config.getRuleId());
/*  60 */       rule.setRuleSort(config.getRuleSort());
/*  61 */       model.setRule(rule);
/*  62 */       if (!ruleIds.contains(";" + String.valueOf(model.getRule().getRuleId()) + ";")) {
/*  63 */         result.add(model);
/*  64 */         ruleIds = ruleIds + config.getRuleId() + ";";
/*     */       }
/*     */     }
/*  67 */     if (result.size() > 0) {
/*  68 */       for (int i = 0; i < result.size(); i++) {
/*  69 */         Object configList = new ArrayList();
/*  70 */         for (BorrowRuleConfig config : list) {
/*  71 */           if (((BorrowRuleConfigModel)result.get(i)).getRule().getRuleId().equals(config.getRuleId()))
/*     */           {
/*  73 */             BorrowRuleConfig c = new BorrowRuleConfig();
/*  74 */             c.setConfigId(config.getConfigId());
/*  75 */             c.setConfigSort(config.getConfigSort());
/*  76 */             c.setId(config.getId());
/*  77 */             if (!((List)configList).contains(c)) {
/*  78 */               ((List)configList).add(c);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*  83 */         ((BorrowRuleConfigModel)result.get(i)).setConfigList((List)configList);
/*     */       }
/*     */     }
/*  86 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void deleteByMap(Map<String, Object> map)
/*     */   {
/*  95 */     this.borrowRuleConfigMapper.deleteByMap(map);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<BorrowRuleConfig> findBorrowRuleId(Map<String, Object> paramMap)
/*     */   {
/* 101 */     return this.borrowRuleConfigMapper.findBorrowRuleId(paramMap);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-rule\src\main\java\!\com\rongdu\cashloan\rule\service\impl\BorrowRuleConfigServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */