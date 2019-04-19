package com.rongdu.cashloan.system.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.system.domain.SysRole;
import com.rongdu.cashloan.system.domain.SysUser;
import java.util.List;
import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;

public abstract interface SysUserService
{
  public abstract Boolean editUserLoginInfo(SysUser paramSysUser)
    throws ServiceException;
  
  @PreAuthorize("hasRole('ROLE_USER')")
  public abstract Boolean editUserPassWord(SysUser paramSysUser)
    throws ServiceException;
  
  public abstract void addUser(SysUser paramSysUser, String paramString)
    throws ServiceException;
  
  public abstract SysUser getUserById(long paramLong)
    throws ServiceException;
  
  public abstract int userUpdate(SysUser paramSysUser)
    throws ServiceException;
  
  public abstract SysUser getUserByUserName(String paramString)
    throws ServiceException;
  
  public abstract Page<Map<String, Object>> getUserPageList(int paramInt1, int paramInt2, Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract int getUserSum(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract Boolean updateSysUserById(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract int queryRoleUserIsUse(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract SysRole getRoleById(long paramLong)
    throws ServiceException;
  
  public abstract List<Map<String, Object>> getUserInfo(Map<String, Object> paramMap)
    throws ServiceException;
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysUserService.class

 */