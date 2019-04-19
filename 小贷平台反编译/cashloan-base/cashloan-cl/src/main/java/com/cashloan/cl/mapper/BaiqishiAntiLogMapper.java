package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.BaiqishiAntiLog;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface BaiqishiAntiLogMapper
  extends BaseMapper<BaiqishiAntiLog, Long>
{
  public abstract void deleteByUserId(Long paramLong);
}
