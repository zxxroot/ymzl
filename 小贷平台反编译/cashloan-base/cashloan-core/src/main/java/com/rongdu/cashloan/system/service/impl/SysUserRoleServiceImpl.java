/*    */ package com.rongdu.cashloan.system.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.system.domain.SysUserRole;
/*    */ import com.rongdu.cashloan.system.mapper.SysUserRoleMapper;
/*    */ import com.rongdu.cashloan.system.service.SysUserRoleService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("sysUserRoleServiceImpl")
/*    */ public class SysUserRoleServiceImpl
/*    */   extends BaseServiceImpl<SysUserRole, Long>
/*    */   implements SysUserRoleService
/*    */ {
/*    */   @Resource
/*    */   private SysUserRoleMapper sysUserRoleDao;
/*    */   
/*    */   public List<SysUserRole> getSysUserRoleList(Long userId)
/*    */     throws ServiceException
/*    */   {
/* 26 */     Map<String, Object> map = new HashMap();
/* 27 */     map.put("userId", userId);
/* 28 */     return this.sysUserRoleDao.getItemListByMap(map);
/*    */   }
/*    */   
/*    */ 
/*    */   public BaseMapper<SysUserRole, Long> getMapper()
/*    */   {
/* 34 */     return this.sysUserRoleDao;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysUserRoleServiceImpl.class

 */