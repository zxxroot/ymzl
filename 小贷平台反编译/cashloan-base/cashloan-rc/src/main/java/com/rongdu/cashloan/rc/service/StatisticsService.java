package com.rongdu.cashloan.rc.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.Statistics;
import java.util.List;
import java.util.Map;

public abstract interface StatisticsService
  extends BaseService<Statistics, Long>
{
  public abstract Page<Statistics> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<Statistics> listAll();
}
