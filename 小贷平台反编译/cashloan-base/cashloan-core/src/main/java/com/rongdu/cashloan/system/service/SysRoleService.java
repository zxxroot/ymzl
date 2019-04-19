package com.rongdu.cashloan.system.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.system.domain.SysRole;
import java.util.List;
import java.util.Map;

public abstract interface SysRoleService
{
  public abstract List<SysRole> getRoleListByUserId(long paramLong)
    throws ServiceException;
  
  public abstract SysRole getRoleById(long paramLong)
    throws ServiceException;
  
  public abstract List<SysRole> getList(Map<String, Object> paramMap);
  
  public abstract int deleteRole(long paramLong)
    throws ServiceException;
  
  public abstract int getRolecount(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract Page<SysRole> getRolePageList(int paramInt1, int paramInt2, Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract long addRole(SysRole paramSysRole)
    throws BussinessException;
  
  public abstract long insertByMap(Map<String, Object> paramMap)
    throws ServiceException;
  
  public abstract int updateRole(Map<String, Object> paramMap)
    throws BussinessException;
  
  public abstract List<Map<String, Object>> getByUserPassRolesList(String paramString1, String paramString2)
    throws ServiceException;
  
  public abstract SysRole findByNid(String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysRoleService.class

 */