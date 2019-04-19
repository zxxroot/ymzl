package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.RcHuadaoBlacklistLog;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface RcHuadaoBlacklistLogMapper
  extends BaseMapper<RcHuadaoBlacklistLog, Long>
{
  public abstract void deleteByUserId(@Param("userId") Long paramLong);
  
  public abstract void deleteByPhone(String paramString);
}
