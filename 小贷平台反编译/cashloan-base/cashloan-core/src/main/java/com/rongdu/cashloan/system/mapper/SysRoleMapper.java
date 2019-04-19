package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysRole;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SysRoleMapper
  extends BaseMapper<SysRole, Long>
{
  public abstract List<? extends SysRole> getRolePageList(Map<String, Object> paramMap);
  
  public abstract List<SysRole> getRoleListByUserId(Long paramLong);
  
  public abstract List<SysRole> getListByMap(Map<String, Object> paramMap);
  
  public abstract int deleteById(long paramLong);
  
  public abstract int updateByMap(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> getByUserPassRolesList(Map<String, Object> paramMap);
  
  public abstract int getRolecount(Map<String, Object> paramMap);
  
  public abstract long insertByMap(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysRoleMapper.class

 */