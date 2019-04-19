package com.rongdu.cashloan.system.service;

import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.system.domain.SysUserRole;
import java.util.List;

public abstract interface SysUserRoleService
{
  public abstract List<SysUserRole> getSysUserRoleList(Long paramLong)
    throws ServiceException;
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysUserRoleService.class

 */