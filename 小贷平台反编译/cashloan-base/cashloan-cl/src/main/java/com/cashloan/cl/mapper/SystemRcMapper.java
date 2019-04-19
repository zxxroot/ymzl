package com.cashloan.cl.mapper;

import com.cashloan.cl.model.DayPassApr;
import com.cashloan.cl.model.SystemDayData;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SystemRcMapper
{
  public abstract List<SystemDayData> dayData(Map<String, Object> paramMap);
  
  public abstract List<DayPassApr> dayApr(Map<String, Object> paramMap);
}
