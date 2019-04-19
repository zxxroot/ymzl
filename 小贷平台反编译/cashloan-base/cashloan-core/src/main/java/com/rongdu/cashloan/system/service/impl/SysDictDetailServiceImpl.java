/*    */ package com.rongdu.cashloan.system.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.system.domain.SysDictDetail;
/*    */ import com.rongdu.cashloan.system.mapper.SysDictDetailMapper;
/*    */ import com.rongdu.cashloan.system.service.SysDictDetailService;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
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
/*    */ @Service("sysDictDetailService")
/*    */ public class SysDictDetailServiceImpl
/*    */   extends BaseServiceImpl<SysDictDetail, Long>
/*    */   implements SysDictDetailService
/*    */ {
/*    */   @Resource
/*    */   private SysDictDetailMapper sysDictDetailMapper;
/*    */   
/*    */   public Boolean deleteSysDictDetail(Long id)
/*    */     throws ServiceException
/*    */   {
/* 36 */     Boolean isTrue = Boolean.valueOf(false);
/* 37 */     int num = this.sysDictDetailMapper.deleteByPrimary(id);
/* 38 */     if (num > 0) {
/* 39 */       isTrue = Boolean.valueOf(true);
/*    */     }
/* 41 */     return isTrue;
/*    */   }
/*    */   
/*    */   public Long getItemCountMap(Map<String, Object> arg)
/*    */     throws ServiceException
/*    */   {
/* 47 */     long num = this.sysDictDetailMapper.getCount(arg).longValue();
/* 48 */     return Long.valueOf(num);
/*    */   }
/*    */   
/*    */   public void addOrModify(SysDictDetail agr, String stauts)
/*    */     throws ServiceException
/*    */   {
/* 54 */     if ((stauts != null) && ("create".equals(stauts))) {
/* 55 */       this.sysDictDetailMapper.save(agr);
/* 56 */     } else if ((stauts != null) && ("update".equals(stauts))) {
/* 57 */       this.sysDictDetailMapper.update(agr);
/*    */     }
/*    */   }
/*    */   
/*    */   public Page<SysDictDetail> getDictDetailList(int currentPage, int pageSize, Map<String, Object> data) throws ServiceException
/*    */   {
/* 63 */     PageHelper.startPage(currentPage, pageSize);
/* 64 */     return (Page)this.sysDictDetailMapper.listSelective(data);
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Map<String, Object>> queryAllDic()
/*    */     throws ServiceException
/*    */   {
/* 71 */     return this.sysDictDetailMapper.queryAllDic();
/*    */   }
/*    */   
/*    */   public BaseMapper<SysDictDetail, Long> getMapper()
/*    */   {
/* 76 */     return this.sysDictDetailMapper;
/*    */   }
/*    */   
/*    */   public SysDictDetail findDetail(String code, String parentName) throws ServiceException
/*    */   {
/* 81 */     return this.sysDictDetailMapper.findDetail(code, parentName);
/*    */   }
/*    */   
/*    */   public List<Map<String, Object>> queryAllDicByParentName(String parentName)
/*    */   {
/* 86 */     return this.sysDictDetailMapper.queryAllDicByParentName(parentName);
/*    */   }
/*    */   
/*    */   public List<SysDictDetail> listByTypeCode(Map<String, Object> data)
/*    */   {
/* 91 */     return this.sysDictDetailMapper.listByTypeCode(data);
/*    */   }
/*    */   
/*    */   public List<SysDictDetail> listUpdateCode(Map<String, Object> data)
/*    */   {
/* 96 */     return this.sysDictDetailMapper.listUpdateCode(data);
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysDictDetailServiceImpl.class

 */