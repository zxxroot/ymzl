package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.DhbHistorySearch;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface DhbHistorySearchMapper
  extends BaseMapper<DhbHistorySearch, Long>
{
  public abstract void deleteByUserId(long paramLong);
}
