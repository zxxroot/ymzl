/*    */ package com.rongdu.creditrank.cr.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.creditrank.cr.domain.BorrowTypeCard;
/*    */ import com.rongdu.creditrank.cr.mapper.BorrowTypeCardMapper;
/*    */ import com.rongdu.creditrank.cr.service.BorrowTypeCardService;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
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
/*    */ 
/*    */ @Service("borrowTypeCardService")
/*    */ public class BorrowTypeCardServiceImpl
/*    */   extends BaseServiceImpl<BorrowTypeCard, Long>
/*    */   implements BorrowTypeCardService
/*    */ {
/* 39 */   private static final Logger logger = LoggerFactory.getLogger(BorrowTypeCardServiceImpl.class);
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private BorrowTypeCardMapper borrowTypeCardMapper;
/*    */   
/*    */ 
/*    */ 
/*    */   public BaseMapper<BorrowTypeCard, Long> getMapper()
/*    */   {
/* 49 */     return this.borrowTypeCardMapper;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Page<BorrowTypeCard> page(Map<String, Object> secreditrankhMap, int current, int pageSize)
/*    */   {
/* 58 */     PageHelper.startPage(current, pageSize);
/* 59 */     List<BorrowTypeCard> list = this.borrowTypeCardMapper.listSelective(secreditrankhMap);
/* 60 */     return (Page)list;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int save(long borrowTypeId, String borrowTypeName, long cardId, String cardName)
/*    */   {
/* 69 */     BorrowTypeCard btc = new BorrowTypeCard();
/* 70 */     btc.setBorrowTypeId(Long.valueOf(borrowTypeId));
/* 71 */     btc.setBorrowTypeName(borrowTypeName);
/* 72 */     btc.setCardId(Long.valueOf(cardId));
/* 73 */     btc.setCardName(cardName);
/* 74 */     btc.setAddTime(new Date());
/* 75 */     return this.borrowTypeCardMapper.save(btc);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int update(long id, long borrowTypeId, String borrowTypeName, long cardId, String cardName)
/*    */   {
/* 84 */     Map<String, Object> updateMap = new HashMap();
/* 85 */     updateMap.put("id", Long.valueOf(id));
/* 86 */     updateMap.put("borrowTypeId", Long.valueOf(borrowTypeId));
/* 87 */     updateMap.put("borrowTypeName", borrowTypeName);
/* 88 */     updateMap.put("cardId", Long.valueOf(cardId));
/* 89 */     updateMap.put("cardName", cardName);
/* 90 */     return this.borrowTypeCardMapper.updateSelective(updateMap);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\service\impl\BorrowTypeCardServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */