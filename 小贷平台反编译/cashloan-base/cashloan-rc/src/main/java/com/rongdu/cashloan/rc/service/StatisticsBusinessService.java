package com.rongdu.cashloan.rc.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.StatisticsBusiness;
import java.util.List;
import java.util.Map;

public abstract interface StatisticsBusinessService
  extends BaseService<StatisticsBusiness, Long>
{
  public abstract Page<StatisticsBusiness> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<StatisticsBusiness> listSelective(Map<String, Object> paramMap);
}
