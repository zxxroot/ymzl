package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorTdCallInfo;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface OperatorTdCallInfoMapper
  extends BaseMapper<OperatorTdCallInfo, Long>
{
  public abstract void deleteByUserId(Long paramLong);
}
