package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.DhbHistoryOrg;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface DhbHistoryOrgMapper
  extends BaseMapper<DhbHistoryOrg, Long>
{
  public abstract void deleteByUserId(long paramLong);
}
