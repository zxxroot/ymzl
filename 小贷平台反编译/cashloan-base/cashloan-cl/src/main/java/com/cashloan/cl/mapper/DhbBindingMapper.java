package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.DhbBinding;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface DhbBindingMapper
  extends BaseMapper<DhbBinding, Long>
{
  public abstract void deleteByUserId(long paramLong);
}
