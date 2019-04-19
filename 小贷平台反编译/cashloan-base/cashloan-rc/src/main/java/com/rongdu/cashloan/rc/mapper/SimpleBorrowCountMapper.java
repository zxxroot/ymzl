package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.SimpleBorrowCount;

@RDBatisDao
public abstract interface SimpleBorrowCountMapper
  extends BaseMapper<SimpleBorrowCount, Long>
{
  public abstract int countOne(long paramLong);
}
