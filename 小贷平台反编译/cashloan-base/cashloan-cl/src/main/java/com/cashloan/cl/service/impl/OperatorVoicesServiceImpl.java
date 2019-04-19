/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.google.common.base.Optional;
/*     */ import com.cashloan.cl.domain.OperatorVoices;
/*     */ import com.cashloan.cl.mapper.OperatorVoicesMapper;
/*     */ import com.cashloan.cl.mapper.UserContactsMapper;
/*     */ import com.cashloan.cl.service.OperatorVoicesService;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.ShardTableUtil;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.stereotype.Service;
/*     */ @Service("operatorVoicesService")
/*     */ public class OperatorVoicesServiceImpl
/*     */   extends BaseServiceImpl<OperatorVoices, Long>
/*     */   implements OperatorVoicesService
/*     */ {
/*     */   @Resource
/*     */   private OperatorVoicesMapper operatorVoicesMapper;
/*     */   @Resource
/*     */   private UserContactsMapper userContactsMapper;
/*     */   
/*     */   public BaseMapper<OperatorVoices, Long> getMapper()
/*     */   {
/*  50 */     return this.operatorVoicesMapper;
/*     */   }
/*     */   
/*     */   public Page<OperatorVoices> findShardPage(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  55 */     long userId = ((Long)params.get("userId")).longValue();
/*     */     
/*  57 */     String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId, 30000L);
/*  58 */     int countTable = this.operatorVoicesMapper.countTable(tableName);
/*  59 */     if (countTable == 0) {
/*  60 */       this.operatorVoicesMapper.createTable(tableName);
/*     */     }
/*  62 */     params.put("orderBy", "voice_date DESC");
/*  63 */     PageHelper.startPage(currentPage, pageSize);
/*  64 */     List<OperatorVoices> list = this.operatorVoicesMapper.listShardSelective(tableName, params);
/*  65 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateVoiceMessage(String tableName, String tableContactsName, HashMap<String, Object> paramMap)
/*     */   {
/*  71 */     List<Map<String, String>> list = this.operatorVoicesMapper.listServiceContact(tableName, tableContactsName, paramMap);
/*  72 */     if ((list != null) && (!list.isEmpty())) {
/*  73 */       for (Map<String, String> map : list) {
/*  74 */         paramMap.put("phone", map.get("voice_to_number"));
/*  75 */         paramMap.put("contactsName", map.get("name"));
/*     */         
/*  77 */         Map<String, Object> reMap = this.operatorVoicesMapper.operatorVoicesCount(tableName, paramMap);
/*  78 */         if (Optional.fromNullable(reMap).isPresent())
/*     */         {
/*  80 */           paramMap.put("voicesCount", Long.valueOf(String.valueOf(Optional.fromNullable(reMap.get("voices_count")).isPresent() ? reMap.get("voices_count") : Integer.valueOf(0))));
/*     */           
/*  82 */           this.userContactsMapper.updateVoicesCount(tableContactsName, paramMap);
/*     */         }
/*     */         
/*  85 */         this.operatorVoicesMapper.updateSelective(tableName, paramMap);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Page<OperatorVoices> recordsDetail(Map<String, Object> params, int current, int pageSize, long userId, long voiceToNumber)
/*     */     throws ParseException
/*     */   {
/*  93 */     String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId, 30000L);
/*  94 */     int countTable = this.operatorVoicesMapper.countTable(tableName);
/*  95 */     if (countTable == 0) {
/*  96 */       this.operatorVoicesMapper.createTable(tableName);
/*     */     }
/*  98 */     PageHelper.startPage(current, pageSize);
/*  99 */     if (params == null) {
/* 100 */       params = new HashMap();
/*     */     }
/* 102 */     params.put("userId", Long.valueOf(userId));
/* 103 */     params.put("voiceToNumber", Long.valueOf(voiceToNumber));
/* 104 */     if (params.get("voiceDate") != null)
/*     */     {
/* 106 */       String voiceDate = (String)params.get("voiceDate");
/* 107 */       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
/* 108 */       Calendar c = Calendar.getInstance();
/* 109 */       Date endDate = new Date();
/* 110 */       if (voiceDate.equals("1")) {
/* 111 */         c.add(5, -6);
/* 112 */         String start = format.format(c.getTime()) + " 00:00:00";
/* 113 */         params.put("beginDate", format.parse(start));
/* 114 */         params.put("endDate", endDate);
/*     */       }
/* 116 */       if (voiceDate.equals("2")) {
/* 117 */         c.add(2, -1);
/* 118 */         String start = format.format(c.getTime()) + " 00:00:00";
/* 119 */         params.put("beginDate", format.parse(start));
/* 120 */         params.put("endDate", endDate);
/*     */       }
/* 122 */       if (voiceDate.equals("3")) {
/* 123 */         c.add(2, -3);
/* 124 */         String start = format.format(c.getTime()) + " 00:00:00";
/* 125 */         params.put("beginDate", format.parse(start));
/* 126 */         params.put("endDate", endDate);
/*     */       }
/* 128 */       if (voiceDate.equals("4")) {
/* 129 */         c.add(2, -3);
/* 130 */         String start = format.format(c.getTime()) + " 00:00:00";
/* 131 */         params.put("endDate", format.parse(start));
/*     */       }
/*     */     }
/* 134 */     List<OperatorVoices> list = this.operatorVoicesMapper.ShardDetailSelective(tableName, params);
/* 135 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public Map<String, Object> recordsCount(long userId, long voiceToNumber) throws ParseException
/*     */   {
/* 140 */     Map<String, Object> map = new HashMap();
/*     */     
/* 142 */     String tableName = ShardTableUtil.generateTableNameById("cl_operator_voices", userId, 30000L);
/* 143 */     int countTable = this.operatorVoicesMapper.countTable(tableName);
/* 144 */     if (countTable == 0) {
/* 145 */       this.operatorVoicesMapper.createTable(tableName);
/*     */     }
/* 147 */     Map<String, Object> params = new HashMap();
/* 148 */     params.put("userId", Long.valueOf(userId));
/* 149 */     params.put("voiceToNumber", Long.valueOf(voiceToNumber));
/* 150 */     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
/* 151 */     Date endDate = new Date();
/* 152 */     Calendar c = Calendar.getInstance();
/* 153 */     c.add(5, -6);
/* 154 */     String all = format.format(c.getTime()) + " 00:00:00";
/*     */     
/* 156 */     int allTime = this.operatorVoicesMapper.recordsCount(tableName, params);
/* 157 */     map.put("allTime", Integer.valueOf(allTime));
/*     */     
/* 159 */     params.put("beginDate", format.parse(all));
/* 160 */     params.put("endDate", endDate);
/* 161 */     int weekTime = this.operatorVoicesMapper.recordsCount(tableName, params);
/* 162 */     map.put("weekTime", Integer.valueOf(weekTime));
/*     */     
/* 164 */     Calendar m = Calendar.getInstance();
/* 165 */     m.add(2, -1);
/* 166 */     String month = format.format(m.getTime()) + " 00:00:00";
/* 167 */     params.put("beginDate", format.parse(month));
/* 168 */     params.put("endDate", endDate);
/* 169 */     int oneMonth = this.operatorVoicesMapper.recordsCount(tableName, params);
/* 170 */     map.put("oneMonth", Integer.valueOf(oneMonth));
/*     */     
/* 172 */     Calendar tm = Calendar.getInstance();
/* 173 */     tm.add(2, -3);
/* 174 */     String threeMonth = format.format(tm.getTime()) + " 00:00:00";
/* 175 */     params.put("beginDate", format.parse(threeMonth));
/* 176 */     params.put("endDate", endDate);
/* 177 */     int tMonth = this.operatorVoicesMapper.recordsCount(tableName, params);
/* 178 */     map.put("threeMonth", Integer.valueOf(tMonth));
/*     */     
/* 180 */     params.put("beginDate", null);
/* 181 */     params.put("endDate", format.parse(threeMonth));
/* 182 */     int overThreeMonths = this.operatorVoicesMapper.recordsCount(tableName, params);
/* 183 */     map.put("overThreeMonths", Integer.valueOf(overThreeMonths));
/*     */     
/* 185 */     params.put("beginDate", null);
/* 186 */     params.put("endDate", null);
/* 187 */     params.put("voiceStatus", null);
/* 188 */     int allVoiceType = this.operatorVoicesMapper.recordsCount(tableName, params);
/* 189 */     map.put("allVoiceType", Integer.valueOf(allVoiceType));
/*     */     
/* 191 */     params.put("beginDate", null);
/* 192 */     params.put("endDate", null);
/* 193 */     params.put("voiceStatus", "主叫");
/* 194 */     int caller = this.operatorVoicesMapper.recordsCount(tableName, params);
/* 195 */     map.put("caller", Integer.valueOf(caller));
/*     */     
/* 197 */     params.put("beginDate", null);
/* 198 */     params.put("endDate", null);
/* 199 */     params.put("voiceStatus", "被叫");
/* 200 */     int beCalled = this.operatorVoicesMapper.recordsCount(tableName, params);
/* 201 */     map.put("beCalled", Integer.valueOf(beCalled));
/* 202 */     return map;
/*     */   }
/*     */ }
