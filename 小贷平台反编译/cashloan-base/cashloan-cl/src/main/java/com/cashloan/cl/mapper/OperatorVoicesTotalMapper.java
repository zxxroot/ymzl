package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorVoicesTotal;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface OperatorVoicesTotalMapper
  extends BaseMapper<OperatorVoicesTotal, Long>
{
  public abstract void deleteByUserId(Long paramLong);
}
