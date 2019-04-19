/*    */ package com.rongdu.cashloan.system.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.system.domain.CheckAppVersion;
/*    */ import com.rongdu.cashloan.system.mapper.CheckAppVersionMapper;
/*    */ import com.rongdu.cashloan.system.service.CheckAppVersionService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("checkAppVersionService")
/*    */ public class CheckAppVersionServiceImpl
/*    */   extends BaseServiceImpl<CheckAppVersion, Long>
/*    */   implements CheckAppVersionService
/*    */ {
/*    */   @Resource
/*    */   private CheckAppVersionMapper checkAppVersionMapper;
/*    */   
/*    */   public CheckAppVersion checkAppVersion(String osType)
/*    */   {
/* 37 */     CheckAppVersion checkAppVersion = this.checkAppVersionMapper.getCheckAppVersion(osType);
/* 38 */     return checkAppVersion;
/*    */   }
/*    */   
/*    */   public BaseMapper<CheckAppVersion, Long> getMapper()
/*    */   {
/* 43 */     return this.checkAppVersionMapper;
/*    */   }
/*    */   
/*    */   public Page<CheckAppVersion> getPageList(int current, int pageSize, Map<String, Object> searchMap)
/*    */   {
/* 48 */     PageHelper.startPage(current, pageSize);
/* 49 */     Page<CheckAppVersion> pages = (Page)this.checkAppVersionMapper.listSelective(searchMap);
/* 50 */     return pages;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\CheckAppVersionServiceImpl.class

 */