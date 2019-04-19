/*    */ package com.rongdu.cashloan.system.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.exception.PersistentDataException;
/*    */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*    */ import com.rongdu.cashloan.system.domain.SysRoleMenu;
/*    */ import com.rongdu.cashloan.system.mapper.SysRoleMenuMapper;
/*    */ import com.rongdu.cashloan.system.service.SysRoleMenuService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("sysRoleMenuServiceImpl")
/*    */ public class SysRoleMenuServiceImpl
/*    */   implements SysRoleMenuService
/*    */ {
/*    */   @Resource
/*    */   private SysRoleMenuMapper sysRoleMenuDao;
/*    */   
/*    */   public List<SysRoleMenu> getRoleMenuList(Long roleId)
/*    */     throws ServiceException, PersistentDataException
/*    */   {
/* 22 */     return this.sysRoleMenuDao.getRoleMenuList(roleId.longValue());
/*    */   }
/*    */   
/*    */   public SysRoleMenuMapper getSysRoleMenuDao() {
/* 26 */     return this.sysRoleMenuDao;
/*    */   }
/*    */   
/*    */   public void setSysRoleMenuDao(SysRoleMenuMapper sysRoleMenuDao) {
/* 30 */     this.sysRoleMenuDao = sysRoleMenuDao;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysRoleMenuServiceImpl.class

 */