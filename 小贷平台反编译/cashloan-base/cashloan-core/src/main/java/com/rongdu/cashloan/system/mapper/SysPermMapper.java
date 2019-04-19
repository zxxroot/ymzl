package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysPerm;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SysPermMapper
  extends BaseMapper<SysPerm, Long>
{
  public abstract SysPerm selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SysPerm paramSysPerm);
  
  public abstract List<SysPerm> listByUserName(String paramString);
  
  public abstract List<SysPerm> selectAll();
  
  public abstract List<SysPerm> listByRoleId(Long paramLong);
  
  public abstract List<Map<String, Object>> fetchAll();
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysPermMapper.class

 */