/*     */ package com.rongdu.cashloan.system.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.system.domain.SysConfig;
/*     */ import com.rongdu.cashloan.system.mapper.SysConfigMapper;
/*     */ import com.rongdu.cashloan.system.service.SysConfigService;
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
/*     */ @Service("sysConfigService")
/*     */ public class SysConfigServiceImpl
/*     */   extends BaseServiceImpl<SysConfig, Long>
/*     */   implements SysConfigService
/*     */ {
/*  33 */   private static final Logger log = LoggerFactory.getLogger(SysConfigServiceImpl.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private SysConfigMapper sysConfigMapper;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BaseMapper<SysConfig, Long> getMapper()
/*     */   {
/*  46 */     return this.sysConfigMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long insertSysConfig(SysConfig sysConfig)
/*     */     throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/*  57 */       return this.sysConfigMapper.save(sysConfig);
/*     */     }
/*     */     catch (Exception e) {
/*  60 */       log.error(e.getMessage(), e);
/*  61 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long updateSysConfig(SysConfig sysConfig)
/*     */     throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/*  73 */       return this.sysConfigMapper.update(sysConfig);
/*     */     }
/*     */     catch (Exception e) {
/*  76 */       log.error(e.getMessage(), e);
/*  77 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Page<SysConfig> getSysConfigPageList(int currentPage, int pageSize, Map<String, Object> paramMap)
/*     */     throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/*  89 */       PageHelper.startPage(currentPage, pageSize);
/*  90 */       return (Page)this.sysConfigMapper.listSelective(paramMap);
/*     */     }
/*     */     catch (Exception e) {
/*  93 */       log.error(e.getMessage(), e);
/*  94 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTotalCount(Map<String, Object> map)
/*     */     throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/* 109 */       return this.sysConfigMapper.total(map).intValue();
/*     */     }
/*     */     catch (Exception e) {
/* 112 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public List<SysConfig> findAll()
/*     */   {
/* 118 */     return this.sysConfigMapper.findAll();
/*     */   }
/*     */   
/*     */   public String selectByCode(String code)
/*     */   {
/* 123 */     return this.sysConfigMapper.selectByCode(code).getValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<SysConfig> listByCode(String code)
/*     */   {
/* 132 */     return this.sysConfigMapper.listByCode(code);
/*     */   }
/*     */   
/*     */   public List<SysConfig> getList(Map<String, Object> map)
/*     */   {
/* 137 */     return this.sysConfigMapper.getList(map);
/*     */   }
/*     */   
/*     */   public SysConfig findByCode(String code)
/*     */   {
/* 142 */     return this.sysConfigMapper.selectByCode(code);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysConfigServiceImpl.class

 */