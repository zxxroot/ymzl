package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.QianChengBlacklistLog;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface QianChengBlacklistLogMapper
  extends BaseMapper<QianChengBlacklistLog, Long>
{
  public abstract void deleteByUserId(@Param("userId") Long paramLong);
}
