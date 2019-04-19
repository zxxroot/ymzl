package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.exception.PersistentDataException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysUser;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SysUserMapper
  extends BaseMapper<SysUser, Long>
{
  public abstract Boolean editUserLoginInfo(SysUser paramSysUser);
  
  public abstract Boolean editUserPassWord(SysUser paramSysUser);
  
  public abstract int updateSysUserById(Map<String, Object> paramMap);
  
  public abstract int queryRoleUserIsUse(Map<String, Object> paramMap)
    throws PersistentDataException;
  
  public abstract SysUser getUserByUserName(String paramString)
    throws PersistentDataException;
  
  public abstract int getPageCountOracle(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> getUserInfoOracle(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> queryTheLeastBusyUserByMap(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> queryTheUserWhoDidThisTask(Map<String, Object> paramMap);
  
  public abstract SysUser getUserByMap(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> getUserInfo(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> listUserInfo(Map<String, Object> paramMap);
  
  public abstract List<SysUser> listByRole(Map<String, Object> paramMap);
  
  public abstract void updateState(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysUserMapper.class

 */