package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.model.DayPassApr;
import com.cashloan.cl.model.SystemDayData;
import java.util.Map;

public abstract interface SystemRcService
{
  public abstract Page<SystemDayData> findDayData(Map<String, Object> paramMap, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Page<DayPassApr> findDayApr(Map<String, Object> paramMap, Integer paramInteger1, Integer paramInteger2);
}
