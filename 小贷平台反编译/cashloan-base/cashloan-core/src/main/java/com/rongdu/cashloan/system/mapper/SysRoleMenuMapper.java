package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.exception.PersistentDataException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysRoleMenu;
import java.util.List;

@RDBatisDao
public abstract interface SysRoleMenuMapper
  extends BaseMapper<SysRoleMenu, Long>
{
  public abstract void deleteByRoleId(long paramLong);
  
  public abstract List<SysRoleMenu> getRoleMenuList(long paramLong)
    throws PersistentDataException;
  
  public abstract void addRoleMenu(long paramLong, Long paramLong1);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysRoleMenuMapper.class

 */