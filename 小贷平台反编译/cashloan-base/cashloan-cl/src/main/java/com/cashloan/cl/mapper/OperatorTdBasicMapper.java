package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorTdBasic;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface OperatorTdBasicMapper
  extends BaseMapper<OperatorTdBasic, Long>
{
  public abstract void deleteByUserId(Long paramLong);
}
