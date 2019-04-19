/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.domain.BankCard;
import com.cashloan.cl.domain.BorrowProgress;
import com.cashloan.cl.domain.BorrowRepayLog;
import com.cashloan.cl.mapper.*;
import com.cashloan.cl.model.BorrowRepayModel;
import com.cashloan.cl.model.ClBorrowModel;
import com.cashloan.cl.model.ManageBorrowModel;
import com.cashloan.cl.model.ManageBorrowProgressModel;
import com.cashloan.cl.service.BorrowProgressService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.system.domain.SysDictDetail;
import com.rongdu.cashloan.system.service.SysDictDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tool.util.DateUtil;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("borrowProgressService")
/*     */ public class BorrowProgressServiceImpl
/*     */   extends BaseServiceImpl<BorrowProgress, Long>
/*     */   implements BorrowProgressService
/*     */ {
/*  59 */   private static final Logger logger = LoggerFactory.getLogger(BorrowProgressServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private BorrowProgressMapper borrowProgressMapper;
/*     */   
/*     */   @Resource
/*     */   private ClBorrowMapper clBorrowMapper;
/*     */   @Resource
/*     */   private BorrowRepayMapper borrowRepayMapper;
/*     */   @Resource
/*     */   private BorrowRepayLogMapper borrowRepayLogMapper;
/*     */   @Resource
/*     */   private BankCardMapper bankCardMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private SysDictDetailService sysDictDetailService;
/*     */   
/*     */   public BaseMapper<BorrowProgress, Long> getMapper()
/*     */   {
/*  79 */     return this.borrowProgressMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<String, Object> result(Borrow borrow)
/*     */   {
/*  85 */     Map<String, Object> searchMap = new HashMap();
/*  86 */     searchMap.put("borrowId", borrow.getId());
/*  87 */     BorrowRepayLog log = (BorrowRepayLog)this.borrowRepayLogMapper.findSelective(searchMap);
/*     */     
/*  89 */     List<BorrowRepayModel> repay = this.borrowRepayMapper.listSelModel(searchMap);
/*  90 */     Map<String, Object> result = new HashMap();
/*  91 */     ClBorrowModel clBorrowModel = new ClBorrowModel();
/*  92 */     BeanUtils.copyProperties(borrow, clBorrowModel);
/*  93 */     clBorrowModel.setCreditTimeStr(DateUtil.dateStr(clBorrowModel.getCreateTime(), "yyyy-M-d"));
/*  94 */     clBorrowModel.setPenalty("20");
/*  95 */     if (!repay.isEmpty()) {
/*  96 */       clBorrowModel.setPenaltyAmount(((BorrowRepayModel)repay.get(0)).getPenaltyAmout().doubleValue());
/*  97 */       if (((BorrowRepayModel)repay.get(0)).getPenaltyAmout().doubleValue() > 0.0D) {
/*  98 */         clBorrowModel.setPenalty("10");
/*  99 */         clBorrowModel.setOverdueAmount(String.valueOf(clBorrowModel.getAmount().doubleValue() + clBorrowModel.getPenaltyAmount()));
/*     */       }
/*     */     } else {
/* 102 */       clBorrowModel.setOverdueAmount(String.valueOf(clBorrowModel.getAmount()));
/*     */     }
/* 104 */     searchMap.clear();
/* 105 */     searchMap.put("userId", borrow.getUserId());
/* 106 */     BankCard card = (BankCard)this.bankCardMapper.findSelective(searchMap);
/*     */     try {
/* 108 */       if (StringUtil.isNotBlank(searchMap)) {
/* 109 */         SysDictDetail findDetail = this.sysDictDetailService.findDetail(card.getBank(), "BANK_TYPE");
/* 110 */         clBorrowModel.setCardNo(card.getCardNo());
/* 111 */         clBorrowModel.setBank(findDetail.getItemValue());
/*     */       }
/*     */     } catch (ServiceException e) {
/* 114 */       e.printStackTrace();
/*     */     }
/*     */     
/* 117 */     List<ClBorrowModel> brList = new ArrayList();
/* 118 */     brList.add(clBorrowModel);
/* 119 */     result.put("borrow", brList);
/* 120 */     for (BorrowRepayModel borrowRepayModel : repay) {
/* 121 */       borrowRepayModel.setRepayTimeStr(DateUtil.dateStr(borrowRepayModel.getRepayTime(), "yyyy-M-d"));
/* 122 */       borrowRepayModel.setAmount(Double.valueOf(borrowRepayModel.getAmount().doubleValue() + borrowRepayModel.getPenaltyAmout().doubleValue()));
/*     */     }
/* 124 */     if (StringUtil.isNotBlank(log)) {
/* 125 */       for (BorrowRepayModel repayModel : repay) {
/* 126 */         repayModel.setRealRepayTime(DateUtil.dateStr(log.getRepayTime(), "yyyy-M-d"));
/* 127 */         repayModel.setRealRepayAmount(String.valueOf(log.getAmount().doubleValue() + log.getPenaltyAmout().doubleValue()));
/*     */       }
/*     */     }
/* 130 */     result.put("repay", repay);
/* 131 */     return result;
/*     */   }
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
/*     */   public Page<ManageBorrowProgressModel> listModel(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/* 192 */     Map<String, Object> bparams = new HashMap();
/* 193 */     if (StringUtil.isNotBlank(params)) {
/* 194 */       if (params.containsKey("realName")) {
/* 195 */         bparams.put("realName", params.get("realName"));
/*     */       }
/* 197 */       if (params.containsKey("phone")) {
/* 198 */         bparams.put("phone", params.get("phone"));
/*     */       }
/* 200 */       if (params.containsKey("orderNo")) {
/* 201 */         bparams.put("orderNo", params.get("orderNo"));
/*     */       }
/* 203 */       List<ManageBorrowModel> borrowList = this.clBorrowMapper.listModel(bparams);
/*     */       
/* 205 */       if ((StringUtil.isNotBlank(params)) && (StringUtil.isNotBlank(bparams)) && (StringUtil.isNotBlank(borrowList))) {
/* 206 */         bparams = new HashMap();
/* 207 */         List borrowIds = new ArrayList();
/* 208 */         if (borrowList.size() > 0) {
/* 209 */           for (ManageBorrowModel b : borrowList) {
/* 210 */             borrowIds.add(b.getId());
/*     */           }
/*     */         } else {
/* 213 */           borrowIds.add("0");
/*     */         }
/* 215 */         if (StringUtil.isNotBlank(borrowIds)) {
/* 216 */           params.put("borrowIds", borrowIds);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 221 */     PageHelper.startPage(currentPage, pageSize);
/* 222 */     List<ManageBorrowProgressModel> list = this.borrowProgressMapper.listModel(params);
/* 223 */     if (StringUtil.isNotBlank(list)) {
/* 224 */       for (int i = 0; i < list.size(); i++) {
/* 225 */         ManageBorrowProgressModel model = (ManageBorrowProgressModel)list.get(i);
/* 226 */         Borrow b = (Borrow)this.clBorrowMapper.findByPrimary(model.getBorrowId());
/* 227 */         ((ManageBorrowProgressModel)list.get(i)).setAmount(b.getAmount());
/* 228 */         ((ManageBorrowProgressModel)list.get(i)).setOrderNo(b.getOrderNo());
/* 229 */         UserBaseInfo info = this.userBaseInfoMapper.findByUserId(model.getUserId());
/* 230 */         if (StringUtil.isNotBlank(info)) {
/* 231 */           ((ManageBorrowProgressModel)list.get(i)).setPhone(info.getPhone());
/* 232 */           ((ManageBorrowProgressModel)list.get(i)).setRealName(info.getRealName());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 237 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public boolean save(BorrowProgress borrowProgress)
/*     */   {
/* 242 */     int result = this.borrowProgressMapper.save(borrowProgress);
/* 243 */     if (result > 0) {
/* 244 */       return true;
/*     */     }
/* 246 */     return false;
/*     */   }
/*     */   
/*     */   public List<BorrowProgress> listSeletetiv(Map<String, Object> map)
/*     */   {
/* 251 */     return this.borrowProgressMapper.listSelective(map);
/*     */   }
/*     */ }


/*impl\BorrowProgressServiceImpl.class

 */