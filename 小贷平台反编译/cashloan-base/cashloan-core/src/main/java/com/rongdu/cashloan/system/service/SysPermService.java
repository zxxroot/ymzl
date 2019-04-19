package com.rongdu.cashloan.system.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.system.domain.SysPerm;
import java.util.List;
import java.util.Map;

public abstract interface SysPermService
  extends BaseService<SysPerm, Long>
{
  public abstract int updateByPrimaryKeySelective(SysPerm paramSysPerm);
  
  public abstract List<SysPerm> listByUserName(String paramString);
  
  public abstract List<SysPerm> listByRoleId(Long paramLong);
  
  public abstract List<Map<String, Object>> fetchAll();
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\SysPermService.class

 */