package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorTdSmsInfo;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface OperatorTdSmsInfoMapper
  extends BaseMapper<OperatorTdSmsInfo, Long>
{
  public abstract void deleteByUserId(Long paramLong);
}
