package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysRolePerm;

@RDBatisDao
public abstract interface SysRolePermMapper
  extends BaseMapper<SysRolePerm, Long>
{
  public abstract SysRolePerm selectByPrimaryKey(Long paramLong);
  
  public abstract int updateByPrimaryKeySelective(SysRolePerm paramSysRolePerm);
  
  public abstract int deleteByRoleId(Integer paramInteger);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysRolePermMapper.class

 */