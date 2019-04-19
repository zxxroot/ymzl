package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.DhbRiskBlacklist;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface DhbRiskBlacklistMapper
  extends BaseMapper<DhbRiskBlacklist, Long>
{
  public abstract void deleteByUserId(long paramLong);
}
