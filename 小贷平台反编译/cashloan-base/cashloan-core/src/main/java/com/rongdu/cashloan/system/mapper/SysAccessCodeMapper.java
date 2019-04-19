package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.SysAccessCode;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.cashloan.system.model.SysAccessCodeModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SysAccessCodeMapper
  extends BaseMapper<SysAccessCode, Long>
{
  public abstract List<SysAccessCodeModel> listAccessCodeModel(Map<String, Object> paramMap);
  
  public abstract int save(SysAccessCode paramSysAccessCode);
  
  public abstract int update(SysAccessCode paramSysAccessCode);
  
  public abstract int countCode(Map<String, Object> paramMap);
  
  public abstract List<SysAccessCode> listSysAccessCode(Long paramLong);
  
  public abstract SysAccessCode findSysAccessCode(Map<String, Object> paramMap);
  
  public abstract List<SysUser> listUserName();
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\SysAccessCodeMapper.class

 */