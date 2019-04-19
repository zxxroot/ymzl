/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.domain.ChannelContactProvider;
import com.cashloan.cl.domain.ChannelProvider;
import com.cashloan.cl.mapper.ChannelProviderMapper;
import com.cashloan.cl.model.ChannelContactModel;
import com.cashloan.cl.model.KeyValue;
import com.cashloan.cl.service.ChannelProviderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
/*     */ @Service("channelProviderService")
/*     */ public class ChannelProviderServiceImpl
/*     */   extends BaseServiceImpl<ChannelProvider, Long>
/*     */   implements ChannelProviderService
/*     */ {
/*     */   @Resource
/*     */   private ChannelProviderMapper channelProviderMapper;
/*     */   
/*     */   public BaseMapper<ChannelProvider, Long> getMapper()
/*     */   {
/*  44 */     return this.channelProviderMapper;
/*     */   }
/*     */   
/*     */   public Page<ChannelContactModel> listChannelProvider(int current, int pageSize, Map<String, Object> searchMap)
/*     */   {
/*  49 */     PageHelper.startPage(current, pageSize);
/*  50 */     Page<ChannelContactModel> page = this.channelProviderMapper.page(searchMap);
/*  51 */     return page;
/*     */   }
/*     */   
/*     */   public List<KeyValue> listChannelProviderId()
/*     */   {
/*  56 */     List<KeyValue> keyValue = this.channelProviderMapper.listChannelProviderId();
/*  57 */     return keyValue;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean save(Map<String, Object> param, String userName, String id, String name)
/*     */   {
/*  63 */     int providerId = this.channelProviderMapper.selectProviderId(id);
/*  64 */     if (providerId > 0) {
/*  65 */       return false;
/*     */     }
/*  67 */     Date curDate = new Date();
/*  68 */     ChannelProvider provider = new ChannelProvider();
/*  69 */     provider.setProviderId(id);
/*  70 */     provider.setName(name);
/*  71 */     provider.setUpdateUser(userName);
/*  72 */     provider.setCreateTime(curDate);
/*  73 */     provider.setUpdateTime(curDate);
/*  74 */     String contactIds = null;
/*  75 */     if ((param != null) && (!param.equals("")))
/*     */     {
/*  77 */       if (param.get("contactIds") != null) {
/*  78 */         contactIds = param.get("contactIds").toString();
/*     */       }
/*  80 */       if (param.get("grade") != null) {
/*  81 */         provider.setGrade(Long.valueOf(param.get("grade").toString()));
/*     */       }
/*  83 */       if (param.get("settlement") != null) {
/*  84 */         long settlement = Long.valueOf(param.get("settlement").toString()).longValue();
/*  85 */         provider.setSettlement(Long.valueOf(settlement));
/*  86 */         if (param.get("cardNumber") != null) {
/*  87 */           provider.setCardNumber(param.get("cardNumber").toString());
/*     */         }
/*  89 */         if (settlement == 20L) {
/*  90 */           if (param.get("bankAddress") != null) {
/*  91 */             provider.setBankAddress(param.get("bankAddress").toString());
/*     */           }
/*  93 */           if (param.get("bankOfAccounts") != null) {
/*  94 */             provider.setBankOfAccounts(param.get("bankOfAccounts").toString());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  99 */     provider.setState(10);
/* 100 */     this.channelProviderMapper.save(provider);
/*     */     
/* 102 */     if (contactIds != null)
/*     */     {
/* 104 */       this.channelProviderMapper.delContactProvider(provider.getId());
/*     */       
/* 106 */       String[] ids = contactIds.split(",");
/* 107 */       List<ChannelContactProvider> ChannelContactProvider = new ArrayList();
/* 108 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/* 110 */         ChannelContactProvider cprovider = new ChannelContactProvider();
/* 111 */         cprovider.setChannelContactId(Long.valueOf(Long.parseLong(ids[i].toString())));
/* 112 */         cprovider.setChannelProviderId(provider.getId());
/* 113 */         ChannelContactProvider.add(cprovider);
/*     */       }
/* 115 */       int i = this.channelProviderMapper.addContactProvider(ChannelContactProvider);
/* 116 */       if (i < 1) {
/* 117 */         return false;
/*     */       }
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   public ChannelProvider channelProviderDetails(Long id)
/*     */   {
/* 125 */     ChannelProvider provider = (ChannelProvider)this.channelProviderMapper.findByPrimary(id);
/* 126 */     return provider;
/*     */   }
/*     */   
/*     */   public List<KeyValue> channelContactList(Long id)
/*     */   {
/* 131 */     List<KeyValue> list = this.channelProviderMapper.channelContactList(id);
/* 132 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update(Map<String, Object> param, Long id, String name)
/*     */   {
/* 138 */     ChannelProvider provider = new ChannelProvider();
/* 139 */     provider.setId(id);
/* 140 */     provider.setUpdateUser(name);
/* 141 */     provider.setUpdateTime(new Date());
/*     */     
/* 143 */     String contactIds = null;
/* 144 */     if ((param != null) && (!param.equals("")))
/*     */     {
/* 146 */       if (param.get("contactIds") != null) {
/* 147 */         contactIds = param.get("contactIds").toString();
/*     */       }
/*     */       
/* 150 */       if (param.get("providerName") != null) {
/* 151 */         provider.setName(param.get("providerName").toString());
/*     */       }
/* 153 */       if (param.get("grade") != null) {
/* 154 */         provider.setGrade(Long.valueOf(param.get("grade").toString()));
/*     */       }
/* 156 */       if (param.get("settlement") != null) {
/* 157 */         long settlement = Long.valueOf(param.get("settlement").toString()).longValue();
/* 158 */         provider.setSettlement(Long.valueOf(settlement));
/* 159 */         if (param.get("cardNumber") != null) {
/* 160 */           provider.setCardNumber(param.get("cardNumber").toString());
/*     */         }
/* 162 */         if (settlement == 20L) {
/* 163 */           if (param.get("bankAddress") != null) {
/* 164 */             provider.setBankAddress(param.get("bankAddress").toString());
/*     */           }
/* 166 */           if (param.get("bankOfAccounts") != null) {
/* 167 */             provider.setBankOfAccounts(param.get("bankOfAccounts").toString());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 172 */     int result = this.channelProviderMapper.update(provider);
/* 173 */     if (result > 0)
/*     */     {
/* 175 */       if (contactIds != null)
/*     */       {
/* 177 */         this.channelProviderMapper.delContactProvider(provider.getId());
/*     */         
/* 179 */         String[] ids = contactIds.split(",");
/* 180 */         List<ChannelContactProvider> ChannelContactProvider = new ArrayList();
/* 181 */         for (int i = 0; i < ids.length; i++)
/*     */         {
/* 183 */           ChannelContactProvider cprovider = new ChannelContactProvider();
/* 184 */           cprovider.setChannelContactId(Long.valueOf(Long.parseLong(ids[i])));
/* 185 */           cprovider.setChannelProviderId(provider.getId());
/* 186 */           ChannelContactProvider.add(cprovider);
/*     */         }
/* 188 */         int i = this.channelProviderMapper.addContactProvider(ChannelContactProvider);
/* 189 */         if (i < 1) {
/* 190 */           return false;
/*     */         }
/*     */       }
/* 193 */       return true;
/*     */     }
/* 195 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int updateState(Map<String, Object> param)
/*     */   {
/* 201 */     ChannelProvider provider = (ChannelProvider)this.channelProviderMapper.findByPrimary(Long.valueOf(Long.parseLong(param.get("id").toString())));
/* 202 */     if (provider != null) {
/* 203 */       int result = this.channelProviderMapper.updateState(param);
/* 204 */       return result;
/*     */     }
/* 206 */     return 0;
/*     */   }
/*     */ }
