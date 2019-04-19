package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysUserRole;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SysUserRoleMapper
  extends BaseMapper<SysUserRole, Long>
{
  public abstract void deleteByUserId(long paramLong);
  
  public abstract List<SysUserRole> getItemListByMap(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysUserRoleMapper.class

 */