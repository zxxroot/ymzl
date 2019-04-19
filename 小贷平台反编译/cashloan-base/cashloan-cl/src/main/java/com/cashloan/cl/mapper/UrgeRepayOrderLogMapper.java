package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UrgeRepayOrderLog;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.Map;

@RDBatisDao
public abstract interface UrgeRepayOrderLogMapper
  extends BaseMapper<UrgeRepayOrderLog, Long>
{
  public abstract int countLog(Map<String, Object> paramMap);
}
