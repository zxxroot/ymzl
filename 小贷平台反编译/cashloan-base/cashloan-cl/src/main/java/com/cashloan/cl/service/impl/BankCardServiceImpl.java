/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.model.pay.lianlian.CancelAuthSignModel;
import com.cashloan.cl.model.pay.lianlian.util.LianLianHelper;
import com.cashloan.cl.domain.BankCard;
import com.cashloan.cl.mapper.BankCardMapper;
import com.cashloan.cl.mapper.UserAuthMapper;
import com.cashloan.cl.model.pay.fuiou.newprotocol.UnbindModel;
import com.cashloan.cl.service.BankCardService;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import com.rongdu.cashloan.core.domain.User;
import com.rongdu.cashloan.core.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
/*     */ @Service("bankCardService")
/*     */ public class BankCardServiceImpl
/*     */   extends BaseServiceImpl<BankCard, Long>
/*     */   implements BankCardService
/*     */ {
/*  45 */   private static final Logger logger = LoggerFactory.getLogger(BankCardServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private BankCardMapper bankCardMapper;
/*     */   
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   
/*     */   @Resource
/*     */   private UserAuthMapper authMapper;
/*     */   
/*     */   public BaseMapper<BankCard, Long> getMapper()
/*     */   {
/*  58 */     return this.bankCardMapper;
/*     */   }
/*     */   
/*     */   public boolean save(BankCard bankCard)
/*     */   {
/*  63 */     int result = this.bankCardMapper.save(bankCard);
/*  64 */     if (result > 0) {
/*  65 */       return true;
/*     */     }
/*  67 */     return false;
/*     */   }
/*     */   
/*     */   public BankCard getBankCardByUserId(Long userId)
/*     */   {
/*     */     try {
/*  73 */       Map<String, Object> paramMap = new HashMap();
/*  74 */       paramMap.put("userId", userId);
/*  75 */       return (BankCard)this.bankCardMapper.findSelective2(paramMap);
/*     */     } catch (Exception e) {
/*  77 */       logger.error(e.getMessage(), e);
/*     */     }
/*  79 */     return null;
/*     */   }
/*     */   
/*     */   public BankCard findSelective(Map<String, Object> paramMap)
/*     */   {
/*  84 */     return (BankCard)this.bankCardMapper.findSelective(paramMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int cancelAuthSign(BankCard card)
/*     */   {
/*  91 */     User user = (User)this.userMapper.findByPrimary(card.getUserId());
/*  92 */     String orderNo = OrderNoUtil.getSerialNumber();
/*  93 */     CancelAuthSignModel model = new CancelAuthSignModel(orderNo);
/*     */     
/*  95 */     if ((user != null) && (StringUtil.isNotBlank(card.getAgreeNo()))) {
/*  96 */       model.setUser_id(user.getUuid());
/*  97 */       model.setNo_agree(card.getAgreeNo());
/*  98 */       LianLianHelper helper = new LianLianHelper();
/*  99 */       model = (CancelAuthSignModel)helper.cancelAuthSign(model); }
/*     */     int result;
/* 102 */     if ((model != null) && (model.checkReturn())) {
/* 103 */       result = this.bankCardMapper.update(card);
/*     */     } else {
/* 105 */       result = this.bankCardMapper.update(card);
/*     */     }
/* 107 */     return result;
/*     */   }
/*     */   
/*     */   public boolean updateSelective(Map<String, Object> paramMap)
/*     */   {
/* 112 */     int result = this.bankCardMapper.updateSelective(paramMap);
/* 113 */     if (result > 0L) {
/* 114 */       return true;
/*     */     }
/* 116 */     return false;
/*     */   }
/*     */   
/*     */   public Map<String, Object> unBind(BankCard card)
/*     */   {
/* 121 */     Map<String, Object> result = new HashMap();
/* 122 */     UnbindModel model = new UnbindModel();
/* 123 */     model.setUserId(card.getUserId().toString());
/* 124 */     model.setProtocolNo(card.getAgreeNo());
/* 125 */     Map map = model.submit();
/* 126 */     if ("0000".equals(map.get("RESPONSECODE"))) {
/* 127 */       Map<String, Object> paramMap = new HashMap();
/* 128 */       paramMap.put("userId", card.getUserId());
/* 129 */       paramMap.put("bankCardState", Integer.valueOf(10));
/* 130 */       int a = this.authMapper.updateByUserId(paramMap);
/* 131 */       paramMap.remove("bankCardState");
/* 132 */       paramMap.put("agree_no", "");
/* 133 */       int b = this.bankCardMapper.update(card);
/* 134 */       result.put("code", Integer.valueOf(200));
/*     */     } else {
/* 136 */       result.put("code", Integer.valueOf(400));
/*     */     }
/* 138 */     result.put("msg", map.get("RESPONSEMSG"));
/* 139 */     return result;
/*     */   }
/*     */ }
