package com.rongdu.cashloan.system.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.system.domain.SysRolePerm;
import java.util.List;

public abstract interface SysRolePermService
  extends BaseService<SysRolePerm, Long>
{
  public abstract int deleteByRoleId(Integer paramInteger);
  
  public abstract void updatePerms(Integer paramInteger, List<Integer> paramList, String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysRolePermService.class

 */