/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.ChannelSettlement;
/*     */ import com.cashloan.cl.mapper.ChannelMapper;
/*     */ import com.cashloan.cl.mapper.ChannelSettlementMapper;
/*     */ import com.cashloan.cl.model.ChannelSettlementModel;
/*     */ import com.cashloan.cl.service.ChannelSettlementService;
/*     */ import com.rongdu.cashloan.core.common.exception.BussinessException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.excel.ReadExcelUtils;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.web.multipart.MultipartFile;
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
/*     */ @Service("channelSettlementService")
/*     */ public class ChannelSettlementServiceImpl
/*     */   extends BaseServiceImpl<ChannelSettlement, Long>
/*     */   implements ChannelSettlementService
/*     */ {
/*     */   @Resource
/*     */   private ChannelSettlementMapper channelSettlementMapper;
/*     */   @Resource
/*     */   private ChannelMapper channelMapper;
/*     */   
/*     */   public BaseMapper<ChannelSettlement, Long> getMapper()
/*     */   {
/*  51 */     return this.channelSettlementMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ChannelSettlementModel> channelStaffDetails(int current, int pageSize, Map<String, Object> params)
/*     */   {
/*  57 */     PageHelper.startPage(current, pageSize);
/*  58 */     Page<ChannelSettlementModel> page = this.channelSettlementMapper
/*  59 */       .page(params);
/*  60 */     return page;
/*     */   }
/*     */   
/*     */   public int fileBatchRepay(MultipartFile repayFile, String type, String loginUserName) throws Exception
/*     */   {
/*  65 */     String ext = repayFile.getOriginalFilename().substring(repayFile.getOriginalFilename().lastIndexOf("."));
/*  66 */     if ((".xlsx".equals(ext)) || (".xls".equals(ext))) {
/*  67 */       List<ChannelSettlement> channelSettlementList = new ArrayList();
/*  68 */       if (type.equals("alpay")) {
/*  69 */         channelSettlementList = parserByFile(repayFile, null);
/*  70 */       } else if ("bank".equals(type)) {
/*  71 */         channelSettlementList = toPaseBank(repayFile, null);
/*     */       } else {
/*  73 */         throw new BussinessException("请上传格式正确的文档。");
/*     */       }
/*     */       
/*  76 */       for (ChannelSettlement settlement : channelSettlementList) {
/*  77 */         settlement.setState(Integer.valueOf(20));
/*  78 */         settlement.setUpdateUser(loginUserName);
/*  79 */         int updateChannel = this.channelSettlementMapper.updateList(settlement);
/*  80 */         if (updateChannel == 0) {
/*  81 */           throw new BussinessException("批量结算失败，请核查数据。");
/*     */         }
/*     */       }
/*     */     } else {
/*  85 */       throw new BussinessException("支持.xls和.xlsx格式文档，请上传格式正确的文档。");
/*     */     }
/*  87 */     return 0;
/*     */   }
/*     */   
/*     */   private List<ChannelSettlement> toPaseBank(MultipartFile repayFile, List<ChannelSettlement> list) throws Exception
/*     */   {
/*  92 */     ReadExcelUtils excelReader = new ReadExcelUtils(repayFile);
/*  93 */     List<List<String>> arr = excelReader.readExcelContent();
/*  94 */     int j = 0;
/*  95 */     List<ChannelSettlement> channelSettlementList = new ArrayList();
/*  96 */     ChannelSettlement model = null;
/*  97 */     for (int i = 0; i < arr.size(); i++) {
/*  98 */       model = new ChannelSettlement();
/*  99 */       List<String> ls = (List)arr.get(i);
/* 100 */       for (int k = 0; k < ls.size(); k++) {
/* 101 */         String item = (String)ls.get(k);
/* 102 */         if (!"".equals(item))
/*     */         {
/*     */ 
/* 105 */           if (item.contains("渠道编号"))
/* 106 */             j = i;
/*     */         }
/*     */       }
/* 109 */       if ((j != 0) && (j + 1 < ls.size()) && (j + 1 <= i))
/*     */       {
/* 111 */         Long channelId = this.channelMapper.selectChannelCode(((String)ls.get(0)).toString());
/* 112 */         Date date = ls.get(1) != null ? DateUtil.valueOf((String)ls.get(1), "yyyy/MM") : null;
/* 113 */         SimpleDateFormat time = new SimpleDateFormat("yyyy-MM");
/* 114 */         model.setChannelId(channelId);
/* 115 */         model.setUpdateTime(time.format(date) + "-00 00:00:00");
/* 116 */         model.setCreateTime(time.format(date) + "-00 00:00:00");
/* 117 */         model.setPaymentTransaction((String)ls.get(4));
/* 118 */         model.setSettlement(Integer.valueOf(20));
/* 119 */         if (model != null) {
/* 120 */           channelSettlementList.add(model);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 125 */     if (channelSettlementList.size() <= 0) {
/* 126 */       throw new BussinessException("没有解析到匹配的数据，请上传正确的文档");
/*     */     }
/* 128 */     return channelSettlementList;
/*     */   }
/*     */   
/*     */   private List<ChannelSettlement> parserByFile(MultipartFile repayFile, List<ChannelSettlement> list) throws Exception
/*     */   {
/* 133 */     ReadExcelUtils excelReader = new ReadExcelUtils(repayFile);
/* 134 */     List<List<String>> arr = excelReader.readExcelContent();
/* 135 */     int j = 0;
/* 136 */     List<ChannelSettlement> channelSettlementList = new ArrayList();
/* 137 */     ChannelSettlement model = null;
/* 138 */     for (int i = 0; i < arr.size(); i++) {
/* 139 */       model = new ChannelSettlement();
/* 140 */       List<String> ls = (List)arr.get(i);
/* 141 */       for (int k = 0; k < ls.size(); k++) {
/* 142 */         String item = (String)ls.get(k);
/* 143 */         if (!"".equals(item))
/*     */         {
/*     */ 
/* 146 */           if (item.contains("渠道编号"))
/* 147 */             j = i;
/*     */         }
/*     */       }
/* 150 */       if ((j != 0) && (j + 1 < ls.size()) && (j + 1 <= i))
/*     */       {
/* 152 */         Long channelId = this.channelMapper.selectChannelCode(((String)ls.get(0)).toString());
/* 153 */         Date date = ls.get(1) != null ? DateUtil.valueOf((String)ls.get(1), "yyyy/MM") : null;
/* 154 */         SimpleDateFormat time = new SimpleDateFormat("yyyy-MM");
/* 155 */         model.setChannelId(channelId);
/* 156 */         model.setUpdateTime(time.format(date) + "-00 00:00:00");
/* 157 */         model.setCreateTime(time.format(date) + "-00 00:00:00");
/* 158 */         model.setPaymentTransaction((String)ls.get(3));
/* 159 */         model.setSettlement(Integer.valueOf(10));
/* 160 */         if (model != null) {
/* 161 */           channelSettlementList.add(model);
/*     */         }
/*     */       }
/*     */     }
/* 165 */     if (channelSettlementList.size() <= 0) {
/* 166 */       throw new BussinessException("没有解析到匹配的数据，请上传正确的文档");
/*     */     }
/* 168 */     return channelSettlementList;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean channelSettlementGenerate()
/*     */   {
/* 174 */     SimpleDateFormat time = new SimpleDateFormat("yyyy-MM");
/* 175 */     Date date = new Date();
/* 176 */     Map<String, Object> param = new HashMap();
/* 177 */     param.put("beginDate", DateUtil.valueOf(time.format(date) + "-01 00:00:00"));
/* 178 */     param.put("endDate", DateUtil.valueOf(time.format(date) + "-31 23:59:59"));
/*     */     
/* 180 */     List<Long> channalIdList = this.channelSettlementMapper.listChannel(param);
/* 181 */     List<ChannelSettlement> list = new ArrayList();
/* 182 */     if (channalIdList.size() > 0) {
/* 183 */       for (Long channelId : channalIdList) {
/* 184 */         if (channelId.longValue() != 0L) {
/* 185 */           ChannelSettlement settlement = new ChannelSettlement();
/* 186 */           settlement.setChannelId(channelId);
/* 187 */           settlement.setState(Integer.valueOf(10));
/* 188 */           settlement.setCreateTime(time.format(date) + "-00 00:00:00");
/* 189 */           list.add(settlement);
/*     */         }
/*     */       }
/* 192 */       if (list.size() > 0)
/*     */       {
/* 194 */         int count = this.channelSettlementMapper.listSaveChannel(list);
/* 195 */         if (count > 0) {
/* 196 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 200 */     return false;
/*     */   }
/*     */   
/*     */   public List<?> listChannelStaff(Map<String, Object> searchMap)
/*     */   {
/* 205 */     List<ChannelSettlementModel> list = this.channelSettlementMapper
/* 206 */       .page(searchMap);
/* 207 */     return list;
/*     */   }
/*     */ }


/*impl\ChannelSettlementServiceImpl.class

 */