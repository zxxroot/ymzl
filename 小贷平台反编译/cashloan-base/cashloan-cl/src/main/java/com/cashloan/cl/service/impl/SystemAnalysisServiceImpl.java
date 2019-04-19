/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.mapper.SystemAnalysisMapper;
/*     */ import com.cashloan.cl.model.OverdueAnalisisModel;
/*     */ import com.cashloan.cl.model.RepayAnalisisModel;
/*     */ import com.cashloan.cl.service.SystemAnalysisService;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.StringUtil;
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
/*     */ @Service("systemAnalysisService")
/*     */ public class SystemAnalysisServiceImpl
/*     */   implements SystemAnalysisService
/*     */ {
/*  39 */   private static final Logger logger = LoggerFactory.getLogger(SystemAnalysisServiceImpl.class);
/*     */   @Resource
/*     */   private SystemAnalysisMapper systemAnalysisMapper;
/*     */   
/*     */   public List<RepayAnalisisModel> monthRepayAnalisis(Map<String, Object> params)
/*     */   {
/*  45 */     List<RepayAnalisisModel> list = null;
/*  46 */     List<String> mouthList = null;
/*  47 */     list = new ArrayList();
/*     */     try {
/*  49 */       if (params == null) {
/*  50 */         mouthList = this.systemAnalysisMapper.mouthList();
/*     */       } else {
/*  52 */         String minMouth = StringUtil.isNull(params.get("startDate"));
/*  53 */         String maxMouth = StringUtil.isNull(params.get("endDate"));
/*  54 */         mouthList = DateUtil.getMonthBetween(minMouth, maxMouth);
/*     */       }
/*  56 */       for (int i = mouthList.size() - 1; i > 0; i--) {
/*  57 */         Map<String, Object> map = new HashMap();
/*  58 */         map.put("date", (String)mouthList.get(i) + "-01");
/*  59 */         map.put("dateType", "%Y-%m");
/*     */         
/*  61 */         RepayAnalisisModel repayModel = new RepayAnalisisModel();
/*  62 */         repayModel.setDate((String)mouthList.get(i));
/*  63 */         String repayCount = this.systemAnalysisMapper.repayCount(map);
/*  64 */         repayModel.setRepayCount(repayCount == null ? "0" : repayCount);
/*     */         
/*  66 */         String overdueCount = this.systemAnalysisMapper.overdueCount(map);
/*  67 */         repayModel.setOverdueCount(overdueCount == null ? "0" : overdueCount);
/*     */         
/*  69 */         String repayAmt = this.systemAnalysisMapper.repayAmt(map);
/*  70 */         repayModel.setRepayAmt(repayAmt == null ? "0" : repayAmt);
/*     */         
/*  72 */         String penaltyRepayAmt = this.systemAnalysisMapper.penaltyRepayAmt(map);
/*  73 */         repayModel.setPenaltyRepayAmt(penaltyRepayAmt == null ? "0" : penaltyRepayAmt);
/*     */         
/*  75 */         repayModel.setApr(repayModel.getApr());
/*  76 */         repayModel.setAmountApr(repayModel.getAmountApr());
/*  77 */         list.add(repayModel);
/*     */       }
/*     */     } catch (ParseException e) {
/*  80 */       logger.error(e.getMessage(), e);
/*     */     }
/*  82 */     return list;
/*     */   }
/*     */   
/*     */   public List<RepayAnalisisModel> dayRepayAnalisis(Map<String, Object> params)
/*     */   {
/*  87 */     List<RepayAnalisisModel> list = null;
/*     */     try {
/*  89 */       list = new ArrayList();
/*  90 */       Date startTime = new Date();
/*  91 */       Date endTime = new Date();
/*  92 */       List<Date> dateList = null;
/*  93 */       if (params == null) {
/*  94 */         startTime = DateUtil.getDateBefore(-10, endTime);
/*  95 */         dateList = dateList(startTime, endTime);
/*     */       } else {
/*  97 */         endTime = DateUtil.valueOf(params.get("afterTime").toString());
/*  98 */         startTime = DateUtil.valueOf(params.get("beforeTime").toString());
/*  99 */         dateList = dateList(startTime, endTime);
/*     */       }
/* 101 */       for (int i = 0; i < dateList.size(); i++) {
/* 102 */         Map<String, Object> map = new HashMap();
/* 103 */         map.put("date", dateList.get(i));
/* 104 */         map.put("dateType", "%y-%m-%d");
/*     */         
/* 106 */         RepayAnalisisModel repayModel = new RepayAnalisisModel();
/* 107 */         repayModel.setDate(DateUtil.dateStr2((Date)dateList.get(i)));
/* 108 */         String repayCount = this.systemAnalysisMapper.repayCount(map);
/* 109 */         repayModel.setRepayCount(repayCount == null ? "0" : repayCount);
/*     */         
/* 111 */         String overdueCount = this.systemAnalysisMapper.overdueCount(map);
/* 112 */         repayModel.setOverdueCount(overdueCount == null ? "0" : overdueCount);
/*     */         
/* 114 */         String repayAmt = this.systemAnalysisMapper.repayAmt(map);
/* 115 */         repayModel.setRepayAmt(repayAmt == null ? "0" : repayAmt);
/*     */         
/* 117 */         String penaltyRepayAmt = this.systemAnalysisMapper.penaltyRepayAmt(map);
/* 118 */         repayModel.setPenaltyRepayAmt(penaltyRepayAmt == null ? "0" : penaltyRepayAmt);
/*     */         
/* 120 */         repayModel.setApr(repayModel.getApr());
/* 121 */         repayModel.setAmountApr(repayModel.getAmountApr());
/* 122 */         list.add(repayModel);
/*     */       }
/*     */     } catch (Exception e) {
/* 125 */       logger.error(e.getMessage(), e);
/*     */     }
/* 127 */     return list;
/*     */   }
/*     */   
/*     */   public Page<OverdueAnalisisModel> overdueAnalisis(Map<String, Object> params, Integer current, Integer pageSize)
/*     */   {
/* 132 */     PageHelper.startPage(current.intValue(), pageSize.intValue());
/* 133 */     params.put("dateType", "%Y-%m");
/* 134 */     Page<OverdueAnalisisModel> page = (Page)this.systemAnalysisMapper.overdueAnalisis(params);
/* 135 */     return page;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Date> dateList(Date startTime, Date endTime)
/*     */     throws Exception
/*     */   {
/* 144 */     startTime = DateUtil.getDateBefore(-1, startTime);
/* 145 */     List<Date> lists = DateUtil.dateSplit(startTime, endTime);
/* 146 */     if (!lists.isEmpty()) {
/* 147 */       return lists;
/*     */     }
/* 149 */     return null;
/*     */   }
/*     */ }


/*impl\SystemAnalysisServiceImpl.class

 */