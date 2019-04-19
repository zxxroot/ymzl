package com.rongdu.cashloan.system.service;

import com.rongdu.cashloan.core.common.exception.PersistentDataException;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.system.domain.SysRoleMenu;
import java.util.List;

public abstract interface SysRoleMenuService
{
  public abstract List<SysRoleMenu> getRoleMenuList(Long paramLong)
    throws ServiceException, PersistentDataException;
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysRoleMenuService.class

 */