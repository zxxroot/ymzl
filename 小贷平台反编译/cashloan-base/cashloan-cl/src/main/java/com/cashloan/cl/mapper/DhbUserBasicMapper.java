package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.DhbUserBasic;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface DhbUserBasicMapper
  extends BaseMapper<DhbUserBasic, Long>
{
  public abstract void deleteByUserId(Long paramLong);
}
