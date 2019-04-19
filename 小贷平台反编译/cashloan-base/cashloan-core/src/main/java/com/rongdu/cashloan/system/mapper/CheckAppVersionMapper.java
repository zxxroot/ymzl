package com.rongdu.cashloan.system.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.system.domain.CheckAppVersion;

@RDBatisDao
public abstract interface CheckAppVersionMapper
  extends BaseMapper<CheckAppVersion, Long>
{
  public abstract CheckAppVersion getCheckAppVersion(String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\mapper\CheckAppVersionMapper.class

 */