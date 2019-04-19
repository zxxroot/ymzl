package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.YoudunModelLog;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface YoudunModelLogMapper
  extends BaseMapper<YoudunModelLog, Long>
{
  public abstract void deleteByUserId(Long paramLong);
}
