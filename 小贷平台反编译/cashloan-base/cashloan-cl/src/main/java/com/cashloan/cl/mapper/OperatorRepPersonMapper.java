package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorRepPerson;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface OperatorRepPersonMapper
  extends BaseMapper<OperatorRepPerson, Long>
{
  public abstract void deleteShardByUserId(Long paramLong);
}
