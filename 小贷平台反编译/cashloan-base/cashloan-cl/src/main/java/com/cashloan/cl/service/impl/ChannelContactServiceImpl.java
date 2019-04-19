/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.domain.ChannelContact;
import com.cashloan.cl.domain.ChannelContactProvider;
import com.cashloan.cl.mapper.ChannelContactMapper;
import com.cashloan.cl.model.ChannelContactModel;
import com.cashloan.cl.model.KeyValue;
import com.cashloan.cl.service.ChannelContactService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.cashloan.system.domain.SysUserRole;
import com.rongdu.cashloan.system.mapper.SysUserMapper;
import com.rongdu.cashloan.system.mapper.SysUserRoleMapper;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("channelContactService")
/*     */ public class ChannelContactServiceImpl
/*     */   extends BaseServiceImpl<ChannelContact, Long>
/*     */   implements ChannelContactService
/*     */ {
/*     */   @Resource
/*     */   private ChannelContactMapper channelContactMapper;
/*     */   @Resource
/*     */   private SysUserMapper sysUserMapper;
/*     */   @Resource
/*     */   private SysUserRoleMapper sysUserRoleMapper;
/*     */   
/*     */   public BaseMapper<ChannelContact, Long> getMapper()
/*     */   {
/*  54 */     return null;
/*     */   }
/*     */   
/*     */   public Page<ChannelContactModel> listChannelContact(int current, int pageSize, Map<String, Object> searchParams)
/*     */   {
/*  59 */     PageHelper.startPage(current, pageSize);
/*  60 */     Page<ChannelContactModel> page = this.channelContactMapper.page(searchParams);
/*  61 */     return page;
/*     */   }
/*     */   
/*     */   public List<KeyValue> listChannelContactId()
/*     */   {
/*  66 */     List<KeyValue> keyValue = this.channelContactMapper.listChannelContactId();
/*  67 */     return keyValue;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean save(Map<String, Object> param, SysUser users, String id, String contactName, Long role)
/*     */   {
/*  73 */     String providerIds = null;
/*     */     
/*  75 */     Date curDate = new Date();
/*  76 */     ChannelContact channelContact = new ChannelContact();
/*  77 */     channelContact.setContactId(id);
/*  78 */     channelContact.setName(contactName);
/*  79 */     channelContact.setUserId(users.getId());
/*  80 */     channelContact.setUserName(users.getUserName());
/*  81 */     channelContact.setRole(role);
/*  82 */     channelContact.setUpdateUser(users.getAddUser());
/*  83 */     channelContact.setCreateTime(curDate);
/*  84 */     channelContact.setUpdateTime(curDate);
/*  85 */     if ((param != null) && (!param.equals("")))
/*     */     {
/*     */ 
/*  88 */       if (param.get("providerIds") != null) {
/*  89 */         providerIds = param.get("providerIds").toString();
/*     */       }
/*  91 */       if (param.get("grade") != null) {
/*  92 */         channelContact.setGrade(Long.valueOf(param.get("grade").toString()));
/*     */       }
/*  94 */       if (param.get("settlement") != null) {
/*  95 */         long settlement = Long.valueOf(param.get("settlement").toString()).longValue();
/*  96 */         channelContact.setSettlement(Long.valueOf(settlement));
/*  97 */         if (param.get("cardNumber") != null) {
/*  98 */           channelContact.setCardNumber(param.get("cardNumber").toString());
/*     */         }
/* 100 */         if (settlement == 20L) {
/* 101 */           if (param.get("bankAddress") != null) {
/* 102 */             channelContact.setBankAddress(param.get("bankAddress").toString());
/*     */           }
/* 104 */           if (param.get("bankOfAccounts") != null) {
/* 105 */             channelContact.setBankOfAccounts(param.get("bankOfAccounts").toString());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 112 */     int contactId = this.channelContactMapper.selectContactId(channelContact.getContactId());
/* 113 */     if (contactId > 0) {
/* 114 */       return false;
/*     */     }
/* 116 */     channelContact.setState(10);
/* 117 */     this.channelContactMapper.save(channelContact);
/*     */     
/* 119 */     if (providerIds != null)
/*     */     {
/* 121 */       this.channelContactMapper.delContactProvider(channelContact.getId());
/* 122 */       String[] ids = providerIds.split(",");
/* 123 */       List<ChannelContactProvider> ChannelContactProvider = new ArrayList();
/* 124 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/* 126 */         ChannelContactProvider provider = new ChannelContactProvider();
/* 127 */         provider.setChannelContactId(channelContact.getId());
/* 128 */         provider.setChannelProviderId(Long.valueOf(Long.parseLong(ids[i])));
/* 129 */         ChannelContactProvider.add(provider);
/*     */       }
/* 131 */       int i = this.channelContactMapper.addContactProvider(ChannelContactProvider);
/* 132 */       if (i < 1) {
/* 133 */         return false;
/*     */       }
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public ChannelContact channelContactDetails(Long id)
/*     */   {
/* 142 */     ChannelContact contact = (ChannelContact)this.channelContactMapper.findByPrimary(id);
/* 143 */     return contact;
/*     */   }
/*     */   
/*     */   public boolean update(Map<String, Object> param, Long id, String name)
/*     */   {
/* 148 */     ChannelContact channelContact = new ChannelContact();
/* 149 */     channelContact.setId(id);
/* 150 */     channelContact.setUpdateTime(new Date());
/* 151 */     channelContact.setUpdateUser(name);
/*     */     
/* 153 */     String providerIds = null;
/* 154 */     if (param.get("grade") != null) {
/* 155 */       channelContact.setGrade(Long.valueOf(param.get("grade").toString()));
/*     */     }
/*     */     
/* 158 */     if (param.get("providerIds") != null) {
/* 159 */       providerIds = param.get("providerIds").toString();
/*     */     }
/*     */     
/* 162 */     if (param.get("contactName") != null) {
/* 163 */       channelContact.setName(param.get("contactName").toString());
/*     */     }
/* 165 */     if (param.get("settlement") != null) {
/* 166 */       long settlement = Long.valueOf(param.get("settlement").toString()).longValue();
/* 167 */       channelContact.setSettlement(Long.valueOf(settlement));
/* 168 */       if (param.get("cardNumber") != null) {
/* 169 */         channelContact.setCardNumber(param.get("cardNumber").toString());
/*     */       }
/* 171 */       if (settlement == 20L) {
/* 172 */         if (param.get("bankAddress") != null) {
/* 173 */           channelContact.setBankAddress(param.get("bankAddress").toString());
/*     */         }
/* 175 */         if (param.get("bankOfAccounts") != null) {
/* 176 */           channelContact.setBankOfAccounts(param.get("bankOfAccounts").toString());
/*     */         }
/*     */       }
/*     */     }
/* 180 */     channelContact.setUpdateTime(new Date());
/* 181 */     int result = this.channelContactMapper.update(channelContact);
/* 182 */     if (result > 0)
/*     */     {
/* 184 */       if (providerIds != null)
/*     */       {
/* 186 */         this.channelContactMapper.delContactProvider(channelContact.getId());
/* 187 */         String[] ids = providerIds.split(",");
/* 188 */         List<ChannelContactProvider> ChannelContactProvider = new ArrayList();
/* 189 */         for (int i = 0; i < ids.length; i++)
/*     */         {
/* 191 */           ChannelContactProvider provider = new ChannelContactProvider();
/* 192 */           provider.setChannelContactId(channelContact.getId());
/* 193 */           provider.setChannelProviderId(Long.valueOf(Long.parseLong(ids[i])));
/* 194 */           ChannelContactProvider.add(provider);
/*     */         }
/* 196 */         int i = this.channelContactMapper.addContactProvider(ChannelContactProvider);
/* 197 */         if (i < 1) {
/* 198 */           return false;
/*     */         }
/*     */       }
/* 201 */       return true;
/*     */     }
/* 203 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int updateState(Map<String, Object> param)
/*     */   {
/* 209 */     ChannelContact contact = (ChannelContact)this.channelContactMapper.findByPrimary(Long.valueOf(Long.parseLong(param.get("id").toString())));
/* 210 */     if (contact != null) {
/* 211 */       int result = this.channelContactMapper.updateState(param);
/* 212 */       return result;
/*     */     }
/* 214 */     return 0;
/*     */   }
/*     */   
/*     */   public List<KeyValue> channelContactList(Long contactId)
/*     */   {
/* 219 */     List<KeyValue> list = this.channelContactMapper.channelContactList(contactId);
/* 220 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public SysUser saveUsers(String contactName, String userName, Long role, String id, String name)
/*     */   {
/* 226 */     int contactId = this.channelContactMapper.selectContactId(id);
/* 227 */     if (contactId > 0) {
/* 228 */       return null;
/*     */     }
/*     */     
/* 231 */     Date curDate = new Date();
/* 232 */     SysUser sysUser = new SysUser();
/* 233 */     sysUser.setName(contactName);
/* 234 */     sysUser.setUserName(userName);
/* 235 */     sysUser.setAddTime(curDate);
/* 236 */     sysUser.setAddUser(name);
/* 237 */     sysUser.setUpdateTime(curDate);
/* 238 */     sysUser.setUpdateUser(name);
/* 239 */     this.sysUserMapper.save(sysUser);
/*     */     
/* 241 */     SysUserRole sysUserRole = new SysUserRole();
/* 242 */     sysUserRole.setRoleId(role);
/* 243 */     sysUserRole.setUserId(sysUser.getId());
/* 244 */     this.sysUserRoleMapper.save(sysUserRole);
/* 245 */     return sysUser;
/*     */   }
/*     */ }
