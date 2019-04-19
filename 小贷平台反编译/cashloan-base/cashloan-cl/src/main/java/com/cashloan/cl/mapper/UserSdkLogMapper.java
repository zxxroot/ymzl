package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UserSdkLog;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.Map;

@RDBatisDao
public abstract interface UserSdkLogMapper
  extends BaseMapper<UserSdkLog, Long>
{
  public abstract int countDayTime(Map<String, Object> paramMap);
}
