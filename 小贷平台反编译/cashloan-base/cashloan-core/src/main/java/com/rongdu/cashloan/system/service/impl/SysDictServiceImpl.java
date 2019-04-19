/*     */ package com.rongdu.cashloan.system.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.system.domain.SysDict;
/*     */ import com.rongdu.cashloan.system.mapper.SysDictDetailMapper;
/*     */ import com.rongdu.cashloan.system.mapper.SysDictMapper;
/*     */ import com.rongdu.cashloan.system.service.SysDictService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.cache.annotation.Cacheable;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("sysDictService")
/*     */ public class SysDictServiceImpl
/*     */   implements SysDictService
/*     */ {
/*     */   @Resource
/*     */   private SysDictMapper sysDictMapper;
/*     */   @Resource
/*     */   private SysDictDetailMapper sysDictDetailMapper;
/*     */   
/*     */   public List<SysDict> getDictByTypeArr(String... typeArr)
/*     */   {
/*  30 */     Map<String, Object> map = new HashMap();
/*  31 */     map.put("typeArr", typeArr);
/*  32 */     return this.sysDictMapper.getDictByTypeArr(map);
/*     */   }
/*     */   
/*     */   public Page<SysDict> getDictPageList(int currentPage, int pageSize, Map<String, Object> searchMap) throws ServiceException
/*     */   {
/*  37 */     PageHelper.startPage(currentPage, pageSize);
/*  38 */     Page<SysDict> pages = (Page)this.sysDictMapper.listSelective(searchMap);
/*  39 */     return pages;
/*     */   }
/*     */   
/*     */   public Long getDictCount(Map<String, Object> arg) throws ServiceException
/*     */   {
/*  44 */     Long count = null;
/*  45 */     count = this.sysDictMapper.getCount(arg);
/*  46 */     return count;
/*     */   }
/*     */   
/*     */   public long getDictDetailCount(Map<String, Object> data)
/*     */     throws ServiceException
/*     */   {
/*  52 */     Long count = null;
/*  53 */     count = this.sysDictDetailMapper.getCount(data);
/*  54 */     return count.longValue();
/*     */   }
/*     */   
/*     */   public boolean addOrModify(SysDict sysDict, String status)
/*     */     throws ServiceException
/*     */   {
/*  60 */     long num = 0L;
/*     */     
/*  62 */     if ((status != null) && ("create".equals(status))) {
/*  63 */       num = this.sysDictMapper.save(sysDict);
/*  64 */     } else if ((status != null) && ("update".equals(status))) {
/*  65 */       num = this.sysDictMapper.update(sysDict);
/*     */     }
/*  67 */     boolean isTrue = num > 0L;
/*  68 */     return isTrue;
/*     */   }
/*     */   
/*     */   public boolean deleteDict(Long id) throws ServiceException
/*     */   {
/*  73 */     boolean flag = false;
/*  74 */     long num = this.sysDictMapper.deleteById(id);
/*  75 */     if (num > 0L) {
/*  76 */       flag = true;
/*     */     }
/*  78 */     return flag;
/*     */   }
/*     */   
/*     */   @Cacheable(value={"dictionaryCache"}, key="#p0")
/*     */   public List<Map<String, Object>> getDictsCache(String typeDict)
/*     */     throws ServiceException
/*     */   {
/*  85 */     return this.sysDictMapper.getDictsCache(typeDict);
/*     */   }
/*     */   
/*     */   public List<String> getItemVlueByParentId(String id)
/*     */     throws ServiceException
/*     */   {
/*  91 */     return this.sysDictDetailMapper.getItemVlueByParentId(id);
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<Map<String, Object>> getDictDetailList(Map<String, Object> data)
/*     */     throws ServiceException
/*     */   {
/*  98 */     return null;
/*     */   }
/*     */   
/*     */   public SysDict findByTypeCode(String typeCode)
/*     */   {
/* 103 */     return this.sysDictMapper.findByTypeCode(typeCode);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysDictServiceImpl.class

 */